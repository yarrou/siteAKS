package site.alexkononsol.siteAKS.configs;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .requiresChannel()
                .anyRequest()
                .requiresSecure()
                .and()
                .authorizeRequests()
                .antMatchers("/**").permitAll();
    }
}