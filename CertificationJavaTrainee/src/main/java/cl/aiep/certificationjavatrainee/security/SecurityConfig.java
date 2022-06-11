package cl.aiep.certificationjavatrainee.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .antMatchers("/css/**","/js/**").permitAll()
                        .antMatchers("/","/postulante/registro","/cursos","/detalle-cursos/{id}").permitAll()
                        .antMatchers("/modificar-curso/{id}","/curso-crear","/eliminar-curso/{id}").hasAuthority("ADMINISTRADOR")
                        .antMatchers("/postularCurso/{id}","/postulante/perfil").hasAuthority("POSTULANTE")
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll())

                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET")).logoutSuccessUrl("/"));

        return http.build();

    }
}
