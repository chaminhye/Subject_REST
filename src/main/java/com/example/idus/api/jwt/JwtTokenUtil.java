package com.example.idus.api.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;
/**
 *    JwtTokenUtil의 역할
 *      -> JWT를 생성하고 검증하는 역할 수행
 * */
@Component
@RequiredArgsConstructor
public class JwtTokenUtil {
    @Value("${jwt.secret}")
    private String secretKey;

    private final long serialVersionUID = -2550185165626007488L;
    private final long TOKEN_VALIDATION_SECOND = 1000L * 60 *60 ;     // 토큰 유효시간 1시간
    private final UserDetailsService userDetailsService;

    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    /**
     *  generateToken : token 생성
     *      @claim : Token에 담을 정보
     *      @issuer : Token 발급자
     *      @subject : Token 제목
     *      @issuedate : Token 발급시간
     *      @expiration : Token 만료시간 ( miliseconds 기준, JWT_TOKEN_VALIDITY =5 60 60 = 5시간
     *      @signWith : 비밀키(알고리즘)
     * */
    public String generateToken(String username, String roles) {
        Claims claims = Jwts.claims();
        claims.put("roles", roles);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))      // 토큰 발행일자
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDATION_SECOND))      // 토근 만료일자
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    // Jwt 토큰으로 인증 정보를 조회
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // Jwt 토큰에서 회원 구별 정보 추출
    public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    // Request의 Header에서 token 파싱 : "AUTH-TOKEN: jwt토큰"
    public String resolveToken(HttpServletRequest req) {
        return req.getHeader("AUTH-TOKEN");
    }

    // Jwt 토큰의 유효성 + 만료일자 확인
    public boolean validateToken(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}

