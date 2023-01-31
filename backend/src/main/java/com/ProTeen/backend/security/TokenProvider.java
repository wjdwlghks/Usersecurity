package com.ProTeen.backend.security;


import com.ProTeen.backend.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@Service
public class TokenProvider {

    // private static final String SECRET_KEY = "NMA8JPctFuna59f5";
    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String create(User user) {
        // 기한은 지금부터 1일로 설정
        Date expiryDate = Date.from(
                Instant.now().plus(1, ChronoUnit.DAYS)
        );

        log.info(user.getUserId() + " 의 토큰 생성");

        // jwt token 생성
        return Jwts.builder()
                // header에 들어갈 내용 및 서명을 하기 위한 시크릿 키
                .signWith(key)
                // payload에 들어갈 내용
                .setSubject(user.getId()) //sub
                .setIssuer("demo app")
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .compact();
    }

    public Claims validateAndGetUserPayload(String token) {
        // parseClaimJws 메서드가 Base64로 디코딩 및 파싱
        // 헤더와 페이로드를 setSigningKey로 넘어온 시크릿을 이용해 서명한 후 token의 서명과 비교
        // 위조되지 않았다면 페이로드(Claims) 리턴, 위조라면 예외를 날림
        // 그중 우리는 userId가 필요하므로 getBody를 부른다.
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        log.info(claims.getExpiration().toString());

        return claims;
    }
}
