package com.projeto.skillhub.service;

import com.projeto.skillhub.entity.LoginHistory;
import com.projeto.skillhub.repository.LoginHistoryRepository;
import com.projeto.skillhub.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;


    public void save(CustomUserDetails user, String token) {
        LoginHistory history = new LoginHistory();
        history.setUserId(user.getId());
        history.setEmail(user.getEmail());
        history.setAccessToken(token);
        loginHistoryRepository.save(history);
    }
}