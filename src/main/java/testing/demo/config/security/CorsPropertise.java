package testing.demo.config.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import lombok.Data;

@Component
@ConfigurationProperties("cors")
@Data
public class CorsPropertise {
    private List<String> allowedOrigins;
    private List<String> allowedMethods;
    private List<String> allowedHeaders;
    private Boolean allowedCredentials;
    private Long maxAge;
}
