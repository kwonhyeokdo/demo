package testing.demo.business.system.language.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import testing.demo.business.system.language.entity.LanguageKey;
import testing.demo.business.system.language.entity.LanguageValue;

@SpringBootTest
@Transactional(readOnly = true)
@ActiveProfiles("test")
@RequiredArgsConstructor
public class LanguageRepositoryTest {
    private final EntityManager em;

    @Test
    @Transactional
    @Commit
    public void saveLanguage(){
        
    }
}
