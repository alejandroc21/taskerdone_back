package com.alejandroct.taskerdone.repository;

import com.alejandroct.taskerdone.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
