package com.practice.response_service.web.mapper;

import java.util.List;

public interface Mappable<E, D>{

    E toEntity(D dto);

    D toDto(E entity);

    List<D> toDto(List<E> entityList);
}
