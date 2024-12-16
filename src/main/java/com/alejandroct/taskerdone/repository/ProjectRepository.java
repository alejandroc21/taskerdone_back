package com.alejandroct.taskerdone.repository;

import com.alejandroct.taskerdone.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
