package com.alejandroct.taskerdone.service.impl;

import com.alejandroct.taskerdone.repository.MemberRepository;
import com.alejandroct.taskerdone.service.IMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements IMemberService {
    private final MemberRepository memberRepository;
}
