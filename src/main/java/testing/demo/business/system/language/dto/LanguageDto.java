package testing.demo.business.system.language.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageDto {
    private String key;
    private String value;
    private String countryCode;
}
