package com.datvutech.cashlog.presentation.controller.accountant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.datvutech.cashlog.data.entity.type.RoleType;
import com.datvutech.cashlog.data.pagination.PageResponse;
import com.datvutech.cashlog.logic.dto.BankDto;
import com.datvutech.cashlog.logic.dto.TransactionDto;
import com.datvutech.cashlog.logic.dto.UserDto;
import com.datvutech.cashlog.logic.service.BankService;
import com.datvutech.cashlog.logic.service.TransactionService;
import com.datvutech.cashlog.logic.service.UserService;

@Controller
@RequestMapping("/accountant")
public class AccountantTransactionController {

    @Autowired
    private TransactionService transService;

    @Autowired
    private UserService userService;

    @Autowired
    private BankService bankService;

    /* Begin: @GetMapping */
    @GetMapping("/transaction")
    public String loadTransacion(Model model,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int max) {
        // Transactions
        PageResponse<TransactionDto> pageDtoResponse = transService
                .getTransactionPage(page < 1 ? 1 : page,
                        max < 1 ? 10 : max, null);
        int currentPage = page;
        long numOfPage = pageDtoResponse.getCount();
        numOfPage = numOfPage % max == 0 ? numOfPage / max : numOfPage / max + 1;

        // Users
        List<UserDto> memberUserDtos = userService.getUsers(RoleType.ROLE_MEMBER);

        // Banks
        List<BankDto> bankDtos = bankService.getBanks();
        model.addAttribute("maxPerPage", max);
        model.addAttribute("transReq", new TransactionDto());
        model.addAttribute("members", memberUserDtos);
        model.addAttribute("banks", bankDtos);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("numOfPage", numOfPage);
        model.addAttribute("transactions", pageDtoResponse.getResult());
        return "accountant/transaction";
    }
    /* End: @GetMapping */

    /* Begin: @PostMapping */
    @PostMapping("/transaction")
    public String createTransaction(TransactionDto transDto) {
        transService.createTransaction(transDto);
        return "redirect:/accountant/transaction";
    }
    /* End: @PostMapping */
}
