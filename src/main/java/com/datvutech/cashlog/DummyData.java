package com.datvutech.cashlog;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.datvutech.cashlog.data.entity.Bank;
import com.datvutech.cashlog.data.entity.Transaction;
import com.datvutech.cashlog.data.entity.User;
import com.datvutech.cashlog.data.entity.type.RoleType;
import com.datvutech.cashlog.data.entity.type.TransactionType;
import com.datvutech.cashlog.data.repository.BankRepository;
import com.datvutech.cashlog.data.repository.TransactionRepository;
import com.datvutech.cashlog.data.repository.UserRepository;

public class DummyData {
    public static void createUser(UserRepository userRepo) {
        User admin = new User();
        User accountant = new User();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        admin.setCode("ADMIN");
        admin.setEmail("admin@gmail.com");
        admin.setFullName("ADMIN");
        admin.setPassword("123456a@");
        admin.setPhone("0898993601");
        admin.setRole(RoleType.ROLE_ADMIN);
        admin.setUsername("admin");

        accountant.setCode("ACCOUNTANT");
        accountant.setEmail("accountant@gmail.com");
        accountant.setFullName("Accountant");
        accountant.setPassword("123456a@");
        accountant.setPhone("0898993601");
        accountant.setRole(RoleType.ROLE_ADMIN);
        accountant.setUsername("accountant");

        user1.setCode("CT06N0110");
        user1.setEmail("ct06n0110@actvn.edu.vn");
        user1.setFullName("Vu Tien Dat");
        user1.setPassword("123456a@");
        user1.setPhone("0898993601");
        user1.setRole(RoleType.ROLE_MEMBER);
        user1.setUsername("ct06n0110");

        user2.setCode("CT06N0107");
        user2.setEmail("ct06n0107@actvn.edu.vn");
        user2.setFullName("Diep Kim Chi");
        user2.setPassword("123456a@");
        user2.setPhone("0704757499");
        user2.setRole(RoleType.ROLE_MEMBER);
        user2.setUsername("ct06n0107");

        user3.setCode("CT06N0109");
        user3.setEmail("ct06n0109@actvn.edu.vn");
        user3.setFullName("Nguyen Tien Dat");
        user3.setPassword("123456a@");
        user3.setPhone("0706088073");
        user3.setRole(RoleType.ROLE_MEMBER);
        user3.setUsername("ct06n0109");

        userRepo.insert(admin);
        userRepo.insert(accountant);
        userRepo.insert(user1);
        userRepo.insert(user2);
        userRepo.insert(user3);
    }

    public static void createBank(BankRepository bankRepo) {
        Bank tcb = new Bank();
        tcb.setCode("TCB");
        tcb.setDescription("Ngan hang thuong mai co phan Ky thuong Viet Nam");
        tcb.setName("Techcombank");

        Bank acb = new Bank();
        acb.setCode("ACB");
        acb.setDescription("Ngan hang thuong mai co phan A Chau");
        acb.setName("A Chau");

        Bank momo = new Bank();
        momo.setCode("MOMO");
        momo.setDescription("Công ty Cổ phần Dịch vụ Di động Trực tuyến");
        momo.setName("Vi Dien tu MoMo");

        bankRepo.insert(tcb);
        bankRepo.insert(acb);
        bankRepo.insert(momo);
    }

    public static void createTransaction(TransactionRepository transRepo) {
        Transaction ct6n_00001 = new Transaction();
        Transaction ct6n_00002 = new Transaction();
        Transaction ct6n_00003 = new Transaction();
        Transaction ct6n_00004 = new Transaction();
        Transaction ct6n_00005 = new Transaction();
        Transaction ct6n_00006 = new Transaction();
        Transaction ct6n_00007 = new Transaction();
        Transaction ct6n_00008 = new Transaction();
        Transaction ct6n_00009 = new Transaction();
        Transaction ct6n_00010 = new Transaction();
        Transaction ct6n_00011 = new Transaction();
        Transaction ct6n_00012 = new Transaction();
        Transaction ct6n_00013 = new Transaction();
        Transaction ct6n_00014 = new Transaction();
        Transaction ct6n_00015 = new Transaction();

        ct6n_00001.setAmount(new BigDecimal(256000000));
        ct6n_00001.setDate(LocalDateTime.parse("2021-01-22 21:38:00",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ct6n_00001.setDetail("Quỹ - Quỹ Phụ huynh học sinh");
        ct6n_00001.setTransType(TransactionType.COLLECTED);
        ct6n_00001.setBank(new Bank(1L));
        ct6n_00001.setUser(new User(3L));

        ct6n_00002.setAmount(new BigDecimal(1300000));
        ct6n_00002.setDate(LocalDateTime.parse("2022-12-29 09:37:00",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ct6n_00002.setDetail("Sinh hoạt - Lương lao công, tu sửa trang thiết bị");
        ct6n_00002.setTransType(TransactionType.PAID);
        ct6n_00002.setBank(new Bank(1L));
        ct6n_00002.setUser(new User(5L));

        ct6n_00003.setAmount(new BigDecimal(200000));
        ct6n_00003.setDate(LocalDateTime.parse("2022-12-29 21:38:00",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ct6n_00003.setDetail("Vận hành - Thi thử");
        ct6n_00003.setTransType(TransactionType.PAID);
        ct6n_00003.setBank(new Bank(1L));
        ct6n_00003.setUser(new User(5L));

        ct6n_00004.setAmount(new BigDecimal(200000));
        ct6n_00004.setDate(LocalDateTime.parse("2022-12-30 21:37:59",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ct6n_00004.setDetail("Vận hành - Tư vấn nghề nghiệp");
        ct6n_00004.setTransType(TransactionType.PAID);
        ct6n_00004.setBank(new Bank(1L));
        ct6n_00004.setUser(new User(5L));

        ct6n_00005.setAmount(new BigDecimal(200000));
        ct6n_00005.setDate(LocalDateTime.parse("2022-12-31 21:37:59",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ct6n_00005.setDetail("Vận hành - Các khoản thi Tốt nghiệp");
        ct6n_00005.setTransType(TransactionType.PAID);
        ct6n_00005.setBank(new Bank(1L));
        ct6n_00005.setUser(new User(4L));

        ct6n_00006.setAmount(new BigDecimal(6000000));
        ct6n_00006.setDate(LocalDateTime.parse("2023-01-01 21:37:59",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ct6n_00006.setDetail("Sinh hoạt - Điện, nước");
        ct6n_00006.setTransType(TransactionType.PAID);
        ct6n_00006.setBank(new Bank(1L));
        ct6n_00006.setUser(new User(4L));

        ct6n_00007.setAmount(new BigDecimal(12000000));
        ct6n_00007.setDate(LocalDateTime.parse("2023-01-02 21:37:59",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ct6n_00007.setDetail("Xã hội - Bảo vệ an ninh trật tự");
        ct6n_00007.setTransType(TransactionType.PAID);
        ct6n_00007.setBank(new Bank(1L));
        ct6n_00007.setUser(new User(4L));

        ct6n_00008.setAmount(new BigDecimal(4000000));
        ct6n_00008.setDate(LocalDateTime.parse("2023-01-04 21:37:59",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ct6n_00008.setDetail("Đoàn - Hoạt động Đoàn Thanh niên");
        ct6n_00008.setTransType(TransactionType.PAID);
        ct6n_00008.setBank(new Bank(1L));
        ct6n_00008.setUser(new User(3L));

        ct6n_00009.setAmount(new BigDecimal(32000000));
        ct6n_00009.setDate(LocalDateTime.parse("2023-01-05 21:37:59",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ct6n_00009.setDetail("Trang thiết bị - Thay hệ thống máy chiếu");
        ct6n_00009.setTransType(TransactionType.PAID);
        ct6n_00009.setBank(new Bank(1L));
        ct6n_00009.setUser(new User(4L));

        ct6n_00010.setAmount(new BigDecimal(3000000));
        ct6n_00010.setDate(LocalDateTime.parse("2023-01-07 21:37:59",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ct6n_00010.setDetail("Trang thiết bị - Thay hệ thống quạt");
        ct6n_00010.setTransType(TransactionType.PAID);
        ct6n_00010.setBank(new Bank(1L));
        ct6n_00010.setUser(new User(5L));

        ct6n_00011.setAmount(new BigDecimal(10000000));
        ct6n_00011.setDate(LocalDateTime.parse("2023-01-09 21:37:59",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ct6n_00011.setDetail("Trang thiết bị - Tu sửa phòng học");
        ct6n_00011.setTransType(TransactionType.PAID);
        ct6n_00011.setBank(new Bank(1L));
        ct6n_00011.setUser(new User(5L));

        ct6n_00012.setAmount(new BigDecimal(14000000));
        ct6n_00012.setDate(LocalDateTime.parse("2023-01-11 21:37:59",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ct6n_00012.setDetail("Trang thiết bị - Lắp đặt hệ thống máy lạnh");
        ct6n_00012.setTransType(TransactionType.PAID);
        ct6n_00012.setBank(new Bank(1L));
        ct6n_00012.setUser(new User(3L));

        ct6n_00013.setAmount(new BigDecimal(16000000));
        ct6n_00013.setDate(LocalDateTime.parse("2023-01-19 21:37:59",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ct6n_00013.setDetail("Vận hành - Triển khai quà tết cho các học sinh có hoàn cảnh khó khăn");
        ct6n_00013.setTransType(TransactionType.PAID);
        ct6n_00013.setBank(new Bank(1L));
        ct6n_00013.setUser(new User(3L));

        ct6n_00014.setAmount(new BigDecimal(32000000));
        ct6n_00014.setDate(LocalDateTime.parse("2023-01-20 21:37:59",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ct6n_00014.setDetail("Vận hành - Trao thưởng cho học sinh có thành tích tốt");
        ct6n_00014.setTransType(TransactionType.PAID);
        ct6n_00014.setBank(new Bank(1L));
        ct6n_00014.setUser(new User(3L));

        ct6n_00015.setAmount(new BigDecimal(2000000));
        ct6n_00015.setDate(LocalDateTime.parse("2023-01-21 21:37:59",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ct6n_00015.setDetail("Trang thiết bị - Văn phòng phẩm");
        ct6n_00015.setTransType(TransactionType.PAID);
        ct6n_00015.setBank(new Bank(1L));
        ct6n_00015.setUser(new User(4L));

        transRepo.insert(ct6n_00001);
        transRepo.insert(ct6n_00002);
        transRepo.insert(ct6n_00003);
        transRepo.insert(ct6n_00004);
        transRepo.insert(ct6n_00005);
        transRepo.insert(ct6n_00006);
        transRepo.insert(ct6n_00007);
        transRepo.insert(ct6n_00008);
        transRepo.insert(ct6n_00009);
        transRepo.insert(ct6n_00010);
        transRepo.insert(ct6n_00011);
        transRepo.insert(ct6n_00012);
        transRepo.insert(ct6n_00013);
        transRepo.insert(ct6n_00014);
        transRepo.insert(ct6n_00015);
    }
}
