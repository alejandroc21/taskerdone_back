package com.alejandroct.taskerdone.service.impl;

import com.alejandroct.taskerdone.repository.ProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectMemberImpl {
    private final ProjectMemberRepository projectMemberRepository;
}
