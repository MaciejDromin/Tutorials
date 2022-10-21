package pl.mlisowski.jwttutorial.security.application;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.mlisowski.jwttutorial.security.JwtUtils;
import pl.mlisowski.jwttutorial.security.application.port.RefreshTokenRepository;
import pl.mlisowski.jwttutorial.security.domain.JwtRefreshRequestDto;
import pl.mlisowski.jwttutorial.security.domain.JwtResponseDto;
import pl.mlisowski.jwttutorial.security.domain.RefreshToken;
import pl.mlisowski.jwttutorial.user.JwtUser;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtUtils jwtUtils;

    @Value("${jwt.refreshToken.expiration}")
    private int expiration;

    public String createToken(JwtUser user) {
        var refreshToken = refreshTokenRepository.save(RefreshToken.builder()
                .token(UUID.randomUUID().toString())
                .user(user)
                .expiration(ZonedDateTime.now(ZoneId.systemDefault()).plusMinutes(expiration))
                .build());
        return refreshToken.getToken();
    }

    public JwtResponseDto refreshToken(JwtRefreshRequestDto refreshRequestDto) {
        var tokenOpt = refreshTokenRepository.findRefreshTokenByToken(refreshRequestDto.getRefreshToken());
        if (tokenOpt.isEmpty()) {
            throw new RuntimeException("Refresh Token %s not found!".formatted(refreshRequestDto.getRefreshToken()));
        }
        var token = tokenOpt.get();
        if (isTokenExpired(token.getExpiration())) {
            refreshTokenRepository.delete(token);
            throw new RuntimeException("Refresh Token %s was expired!".formatted(refreshRequestDto.getRefreshToken()));
        }
        String jwt = jwtUtils.createJwt(token.getUser().getEmail());
        updateToken(token);
        return JwtResponseDto.of(jwt, token.getToken());
    }

    private void updateToken(RefreshToken token) {
        token.setExpiration(ZonedDateTime.now(ZoneId.systemDefault()).plusMinutes(expiration));
        refreshTokenRepository.save(token);
    }

    private boolean isTokenExpired(ZonedDateTime expirationTime) {
        return expirationTime.isBefore(ZonedDateTime.now(ZoneId.systemDefault()));
    }

}
