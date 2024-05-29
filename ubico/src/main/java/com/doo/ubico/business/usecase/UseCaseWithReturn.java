package com.doo.ubico.business.usecase;

public interface UseCaseWithReturn<T,R> {

    R execute(T data);
}
