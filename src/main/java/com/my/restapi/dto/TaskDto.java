package com.my.restapi.dto;

import lombok.Data;

@Data
public class TaskDto {
    private String title;
    private Boolean completed;
}
