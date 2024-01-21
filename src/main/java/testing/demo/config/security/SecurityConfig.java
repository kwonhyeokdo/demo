package testing.demo.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{
    private final CorsPropertise corsPropertise;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                    .cors(cors -> cors.configurationSource(
                                request ->{
                                    final CorsConfiguration cofing = new CorsConfiguration();
                                    cofing.setAllowedOriginPatterns(corsPropertise.getAllowedOrigins());
                                    cofing.setAllowedMethods(corsPropertise.getAllowedMethods());
                                    cofing.setAllowedHeaders(corsPropertise.getAllowedHeaders());
                                    cofing.setAllowCredentials(corsPropertise.getAllowedCredentials());
                                    cofing.setMaxAge(corsPropertise.getMaxAge());
                                    return cofing;
                                }
                            )
                        )
                    .csrf(csrf -> csrf.disable())
                    .exceptionHandling(Customizer.withDefaults())
                    .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests(
                            auth -> auth
                                .requestMatchers("/").permitAll()
                                //    .requestMatchers("/admin").hasRole("ADMIN")
                                .anyRequest().authenticated()
                        )
                    .build();
    }
}
