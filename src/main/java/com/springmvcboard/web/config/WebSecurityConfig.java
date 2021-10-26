package com.springmvcboard.web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.springmvcboard.service.member.MemberServiceImpl;
/*import com.springmvcboard.web.handler.CustomAuthFailureHandler;
import com.springmvcboard.web.handler.CustomAuthSuccessHandler;*/

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final MemberServiceImpl memberService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //antMatchers( /board/list 삭제할 것
        http
                .authorizeRequests()
                    .antMatchers("/","/signup","/login","/board/list").permitAll()
                    .anyRequest().authenticated()
                    .and()
              /*  .csrf()
                    .disable()*/
                .headers()
                    .frameOptions().disable()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login/auth")
                    .defaultSuccessUrl("/board/list")
                    .failureUrl("/login?error=true")
             /*       .successHandler(successHandler())
                    .failureHandler(failureHandler())*/
                    .usernameParameter("userId")
                    .passwordParameter("password")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .deleteCookies("JSESSIONID", "SPRING_SECURITY_REMEMBER_ME_COOKIE")
                    .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(new BCryptPasswordEncoder());
    }

    /*@Bean
    public AuthenticationSuccessHandler successHandler() {
        return new CustomAuthSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler failureHandler() {
        return new CustomAuthFailureHandler();
    }*/
}
