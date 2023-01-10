package com.datvutech.cashlog.data.repository.generic;

import com.datvutech.cashlog.data.pagination.PageResponse;
import com.datvutech.cashlog.data.pagination.Pageable;

public interface PagebleRepository<T> extends GenericRepository<T> {
    PageResponse<T> findAll(Pageable page);
}
