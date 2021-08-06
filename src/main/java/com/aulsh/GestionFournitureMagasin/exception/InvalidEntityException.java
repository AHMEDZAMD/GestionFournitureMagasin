package com.aulsh.GestionFournitureMagasin.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class InvalidEntityException extends RuntimeException{

    @Getter
    @Setter
    private ErrorCodes errorCode;

    @Getter
    @Setter
    protected List<String> errors;



    public InvalidEntityException(String message){

        super(message);

    }

    public InvalidEntityException(String message,Throwable cause,ErrorCodes errorCode){

        super(message,cause);

        this.errorCode = errorCode;

    }


    public InvalidEntityException(String message,ErrorCodes errorCode){

        super(message);

        this.errorCode = errorCode;

    }


    public InvalidEntityException(String message,ErrorCodes errorCode,List<String>erros){

        super(message);

        this.errorCode = errorCode;

        this.errors = erros;


    }
}
