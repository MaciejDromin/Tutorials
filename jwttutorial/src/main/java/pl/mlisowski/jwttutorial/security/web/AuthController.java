package pl.mlisowski.jwttutorial.security.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mlisowski.jwttutorial.security.application.RefreshTokenService;
import pl.mlisowski.jwttutorial.security.domain.JwtRefreshRequestDto;
import pl.mlisowski.jwttutorial.security.domain.JwtResponseDto;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final RefreshTokenService refreshTokenService;

    @PostMapping("/refresh")
    public JwtResponseDto refreshJwt(@RequestBody JwtRefreshRequestDto refreshRequestDto) {
        return refreshTokenService.refreshToken(refreshRequestDto);
    }

}
