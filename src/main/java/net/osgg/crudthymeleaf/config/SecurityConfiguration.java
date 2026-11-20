package net.osgg.crudthymeleaf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Value("${APP_ADMIN_USER:}")
    private String adminUser;
    @Value("${APP_ADMIN_PASSWORD:}")
    private String adminPassword;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/", "/registration**", "/js/**", "/css/**", "/img/**", "/webjars/**").permitAll()
            .anyRequest().authenticated()
            .and().headers().frameOptions().sameOrigin()
            .and().formLogin().loginPage("/recetas/login").permitAll()
            .defaultSuccessUrl("/recetas", true)
            .and().logout().logoutUrl("/recetas/logout").permitAll().logoutSuccessUrl("/recetas");
        // CSRF permanece activado; no se permite acceso público a la consola H2.
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        CredencialesEntorno.validar(adminUser, adminPassword);
        auth.inMemoryAuthentication()
            .withUser(adminUser).password(passwordEncoder().encode(adminPassword)).roles("ADMIN");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
}
