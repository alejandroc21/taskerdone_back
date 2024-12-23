package com.alejandroct.taskerdone.repository;

import com.alejandroct.taskerdone.enums.MemberRole;
import com.alejandroct.taskerdone.model.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    List<Project> findByUserEmail(String email);

    @Query("SELECT p FROM Project p JOIN p.members m WHERE m.user.id = :userId AND (:role IS NULL OR m.role = :role)")
    List<Project> findByUserId(long userId, MemberRole role);

    @Query("SELECT p FROM Project p JOIN p.members m WHERE m.user.id = :userId AND project.id = :projectId")
    Optional<Project> findByIdAndUserId(long projectId, long userId);
}
