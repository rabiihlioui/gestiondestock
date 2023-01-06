package com.rabii.gestiondestock.handlers;

import com.rabii.gestiondestock.exception.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ErrorDto {
    private Integer httpCode;
    private ErrorCodes code;
    private String message;
    private List<String> errors = new ArrayList<>();
}
