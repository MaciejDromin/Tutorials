package pl.mlisowski.jwttutorial.security.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JwtResponseDto {

    private String token;
    private String refreshToken;

    public static JwtResponseDto of(String token, String refreshToken) {
        return new JwtResponseDto(token, refreshToken);
    }

}
