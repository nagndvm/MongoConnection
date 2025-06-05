package com.example.mongoconnection.repository;

import com.example.mongoconnection.model.UserSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoMySql extends JpaRepository<UserSql, Long> {
}
