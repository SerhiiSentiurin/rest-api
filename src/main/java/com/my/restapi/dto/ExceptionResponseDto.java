package com.my.restapi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionResponseDto {
    private final Integer code;
    private final String message;
    private final LocalDateTime localTime;
}
