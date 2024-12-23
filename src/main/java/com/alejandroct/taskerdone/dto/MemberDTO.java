package com.alejandroct.taskerdone.dto;

import com.alejandroct.taskerdone.enums.MemberRole;

public record ProjectMemberDTO(
        long id,
        MemberRole role,
        UserDTO user
) {}
