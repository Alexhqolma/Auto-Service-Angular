package com.example.autoservice.dto.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
