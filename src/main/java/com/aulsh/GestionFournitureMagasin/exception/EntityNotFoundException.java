package com.aulsh.GestionFournitureMagasin.exception;


import lombok.Getter;
import lombok.Setter;

//exception Generique
public class EntityNotFoundException extends RuntimeException{


    @Getter
    @Setter
    protected ErrorCodes errorCodes;
    public EntityNotFoundException(String message){

        super(message);

    }

    public EntityNotFoundException(String message,Throwable cause,ErrorCodes errorCodes){

        super(message,cause);

        this.errorCodes = errorCodes;

    }


    public EntityNotFoundException(String message,ErrorCodes errorCodes){

        super(message);

        this.errorCodes = errorCodes;

    }

}
