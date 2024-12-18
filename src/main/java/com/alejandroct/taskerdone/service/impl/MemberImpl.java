package com.alejandroct.taskerdone.service.impl;

import com.alejandroct.taskerdone.repository.ProjectMemberRepository;
import com.alejandroct.taskerdone.service.IMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberImpl implements IMemberService {
    private final ProjectMemberRepository projectMemberRepository;
}
