package com.projeto.skillhub.repository;

import com.projeto.skillhub.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
}
