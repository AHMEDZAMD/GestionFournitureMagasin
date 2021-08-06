package com.aulsh.GestionFournitureMagasin.handlers;


import com.aulsh.GestionFournitureMagasin.exception.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {




    private Integer httpcode;
    private ErrorCodes code;
    private String message;
    @Builder.Default
    private List<String> errors = new ArrayList<>();


}
