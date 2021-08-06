package com.aulsh.GestionFournitureMagasin.handlers;


import com.aulsh.GestionFournitureMagasin.exception.EntityNotFoundException;
import com.aulsh.GestionFournitureMagasin.exception.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice   // listner global sur les exceptions pour la gestion des exceptions au lieu de  l'application
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(EntityNotFoundException.class) // Lorsque on a une excption sur lapplication  de type EntityNotFoundException @RestControllerAdvice va traiter automatiqument la fonction handelexception

    public ResponseEntity<ErrorDto> handelexception(EntityNotFoundException exception, WebRequest webRequest){


        final HttpStatus notFound = HttpStatus.NOT_FOUND; // code not found : 404
        final ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCodes())
                .httpcode(notFound.value())
                .message(exception.getMessage())
                .build();


        return new ResponseEntity<>(errorDto,notFound); // renvoi la reponce avec le code

    }

    @ExceptionHandler(InvalidEntityException.class)


    public ResponseEntity<ErrorDto> handelexception(InvalidEntityException exception, WebRequest webRequest){

        final HttpStatus badRequest = HttpStatus.BAD_REQUEST; // code not found : 400

        final ErrorDto errorDto = ErrorDto.builder() // creation d un objet errorDto

                .code(exception.getErrorCode())
                .httpcode(badRequest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();

        return new ResponseEntity<>(errorDto,badRequest); // renvoi la reponce avec le code

    }


}
