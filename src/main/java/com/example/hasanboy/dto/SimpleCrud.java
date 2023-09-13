package com.example.hasanboy.dto;

public interface SimpleCrud <K,V>{
    ResponseDto<V> create(V dto);
    ResponseDto<V> get(K entityId);

    ResponseDto<V> delete(K entityId);
    ResponseDto<V> update(K entityId,V dto);
}
