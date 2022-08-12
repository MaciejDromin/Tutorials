package pl.mlisowski.jwttutorial.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JwtUserRepository extends JpaRepository<JwtUser, Long> {

    Optional<JwtUser> findJwtUserByUsername(String username);
    Optional<JwtUser> findJwtUserByEmail(String email);

}
