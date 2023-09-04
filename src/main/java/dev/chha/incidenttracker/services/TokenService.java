package dev.chha.incidenttracker.services;

import dev.chha.incidenttracker.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class TokenService {
    @Autowired
    private JwtEncoder jwtEncoder;

    @Autowired
    private JwtDecoder jwtDecoder;

    public String generateJwt(Authentication auth) {

        Instant now = Instant.now();

        String scope = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        if(auth.getPrincipal() instanceof User) {
            Long userId = (((User) auth.getPrincipal()).getUserId());

            JwtClaimsSet claims = JwtClaimsSet.builder()
                    .issuer("self")
                    .issuedAt(now)
                    .subject(auth.getName())
                    .claim("roles", scope)
                    .claim("userId", userId)
                    .build();

            return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        }
        return null;
    }

    public Long extractUserIdFromToken(String token) {
        Jwt jwt = jwtDecoder.decode(token);
        System.out.println(jwt.getClaim("userId").toString());
        return jwt.getClaim("userId");

    }




}
