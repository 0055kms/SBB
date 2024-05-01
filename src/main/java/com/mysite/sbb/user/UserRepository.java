package com.mysite.sbb.user;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
}
