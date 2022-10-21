package pl.mlisowski.jwttutorial.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
@RequiredArgsConstructor
public class JwtUtils {

    @Value("${jwt.expiration}")
    private int expTime;

    @Value("${jwt.secret}")
    private String secret;

    public String createJwt(String email) {
        return JWT.create()
                .withSubject(email)
                .withExpiresAt(Instant.ofEpochMilli(ZonedDateTime.now(ZoneId.systemDefault()).toInstant().toEpochMilli() + expTime))
                .sign(Algorithm.HMAC256(secret));
    }

}
