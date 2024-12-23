package com.alejandroct.taskerdone.repository;

import com.alejandroct.taskerdone.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
}
