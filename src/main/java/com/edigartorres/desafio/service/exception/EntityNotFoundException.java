package com.edigartorres.desafio.service.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException (String msg) {
        super(msg);
    }
}