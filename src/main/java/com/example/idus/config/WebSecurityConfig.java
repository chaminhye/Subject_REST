package com.example.idus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *    WebSecurityConfig의 역할
 *      -> 모든 접근에 대해 인가가 필요하다.
 *      -> WebSecurity와 HttpSecurity를 커스터마이징 (CORS등 해결)
 * */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private JwtRequestFilter jwtRequestFilter;

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // ignore file setting : swqgger-ui
//        web.ignoring().antMatchers("/v2/api-docs", "/swagger-resources/**",
//                "/swagger-ui.html", "/webjars/**", "/swagger/**");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/**").permitAll()        // 회원 가입 누구나 접근가능
                .antMatchers("/swagger*/**").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .anyRequest().hasRole("USER")
                .and();
//                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);     // token필터를 id/pwd 인증 전에 넣는다.
    }

//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
}