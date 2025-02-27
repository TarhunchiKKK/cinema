package com.example.api.shared.interfaces;

import org.springframework.data.domain.Example;

public interface IQueryBuilder<T> {
    Example<T> getExample();
}
