package com.alejandroct.taskerdone.dto;

import com.alejandroct.taskerdone.enums.MemberRole;

public record MemberDTO(
        long id,
        MemberRole role,
        UserDTO user
) {}
