package testing.demo.buiness.language.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import testing.demo.buiness.system.language.dto.LanguageDto;
import testing.demo.buiness.system.language.entity.LanguageKey;

import java.util.List;

@SpringBootTest
@ActiveProfiles("profile")
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LanguageRepositoryTest {
    private final EntityManager em;

    @Test
    @Transactional
    public void insertLanguage(){
        List<LanguageDto> languageDtos = List.of(
            LanguageDto.builder().key("languageKey1").value("한국어").build()
        );
    }
}
