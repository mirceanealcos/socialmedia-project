package com.mirceanealcos.socialmedia.repository;

import com.mirceanealcos.socialmedia.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
