package com.example.company.config;


import com.example.company.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor
public class  WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final SecurityService securityService;
    private final PasswordEncoder passwordEncoder;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
             auth.userDetailsService(securityService)
             .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http
                 .authorizeRequests()
                 .antMatchers(HttpMethod.GET, "/")
                 .permitAll()
                 .antMatchers(HttpMethod.GET, "/addemployee")
                 .hasAnyAuthority("ADMIN")
                 .antMatchers(HttpMethod.GET, "/employee")
                 .hasAnyAuthority("ADMIN","USER")
                 .antMatchers(HttpMethod.GET, "/company")
                 .hasAnyAuthority("ADMIN","USER")
                 .and()
                 .csrf()
                 .disable()
                 .logout()
                 .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                 .logoutSuccessUrl("/")
                 .deleteCookies("JSESSIONID")
                 .invalidateHttpSession(true)
                 .and()
                 .formLogin();
    }


}
