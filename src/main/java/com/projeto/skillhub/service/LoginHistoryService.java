package com.projeto.skillhub.service;

import com.projeto.skillhub.repository.LoginHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginHistoryService {

    private LoginHistoryRepository loginHistoryRepository;

}
