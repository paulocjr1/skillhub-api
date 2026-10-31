package com.projeto.skillhub.service;

import com.projeto.skillhub.dto.JwtResponse;
import com.projeto.skillhub.dto.LoginRequest;
import com.projeto.skillhub.dto.RefreshTokenRequest;
import com.projeto.skillhub.dto.RegisterRequest;
import com.projeto.skillhub.entity.RefreshToken;
import com.projeto.skillhub.entity.Usuario;
import com.projeto.skillhub.repository.UsuarioRepository;
import com.projeto.skillhub.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final LoginHistoryService loginHistoryService;
    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public JwtResponse login(LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.email(), request.password()));

        CustomUserDetails user =
                (CustomUserDetails) authentication.getPrincipal();

        String accessToken = jwtService.generateToken(user);
        RefreshToken refreshToken =
                refreshTokenService.create(user.getId());

        loginHistoryService.save(user, accessToken);

        return new JwtResponse(accessToken, refreshToken.getToken());
    }

    public void register(RegisterRequest request) {

        if (userRepository.findByEmail(request.email()) != null) {
            throw new RuntimeException("Email já cadastrado");
        }

        Usuario user = new Usuario();
        user.setNome(request.nome());
        user.setEmail(request.email());
        user.setSenha(passwordEncoder.encode(request.senha()));
        user.setAtivo(Boolean.TRUE);
        userRepository.save(user);
    }

    public JwtResponse refreshToken(RefreshTokenRequest request) {

        RefreshToken refreshToken =
                refreshTokenService.validate(request.refreshToken());

        Usuario user = userRepository.findById(refreshToken.getUserId()).orElse(null);

        CustomUserDetails userDetails = new CustomUserDetails(user);

        String newAccessToken = jwtService.generateToken(userDetails);

        return new JwtResponse(
                newAccessToken,
                refreshToken.getToken()
        );
    }
}
