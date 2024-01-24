package testing.demo.business.system.language.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import testing.demo.business.system.config.LanguageCode;
import testing.demo.business.system.language.entity.LanguageKey;
import testing.demo.business.system.language.entity.LanguageValue;
import java.util.List;


@SpringBootTest
@Transactional(readOnly = true)
@ActiveProfiles("test")
public class LanguageRepositoryTest {
    @Autowired
    LanguageKeyRepository languageKeyRepository;

    @Autowired
    LanguageValueRepository languageValueRepository;

    @Test
    @Transactional
    @Commit
    public void saveLanguage(){
        LanguageValue languageValue1 = LanguageValue.getInstance(
            null,
            null,
            LanguageCode.ENGLISH,
            "testValue"
        );
        LanguageValue languageValue2 = LanguageValue.getInstance(
            null,
            null,
            LanguageCode.KOREAN,
            "테스트값"
        );

        LanguageKey languageKey = LanguageKey.getInstance(
            null,
            "testKey",
            List.of(languageValue1, languageValue2)
        );

        languageKeyRepository.save(languageKey);
        languageValueRepository.save(languageValue1);
        languageValueRepository.save(languageValue2);
        
    }
}
