package com.alejandroct.taskerdone.dto;

import java.util.List;

public record ProjectDetailsDTO(
        long id,
        String name,
        List<MemberDTO> members

) {
}
