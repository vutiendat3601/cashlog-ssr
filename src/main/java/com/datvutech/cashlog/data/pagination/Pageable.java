package com.datvutech.cashlog.data.pagination;

import com.datvutech.cashlog.data.sort.Sorter;

public interface Pageable {

    int getPage();

    int getLimit();

    int getOffset();

    Sorter getSorter();
}
