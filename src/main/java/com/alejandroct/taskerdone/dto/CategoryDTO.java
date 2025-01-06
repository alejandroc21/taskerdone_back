package com.alejandroct.taskerdone.dto;

import org.springframework.validation.annotation.Validated;

public record CategoryDTO(
        long id,
        String name
) {
}
