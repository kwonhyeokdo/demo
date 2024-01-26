package testing.demo.business.system.language.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import testing.demo.business.system.language.code.LanguageCode;
import testing.demo.business.system.language.entity.LanguageKey;
import testing.demo.business.system.language.entity.LanguageValue;
import java.util.List;
import java.util.ArrayList;
import java.util.EnumSet;


@SpringBootTest
@Transactional(readOnly = true)
@ActiveProfiles("test")
public class LanguageRepositoryTest {
    @Autowired
    private LanguageKeyRepository languageKeyRepository;

    @Autowired
    private LanguageValueRepository languageValueRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private static int KEY_COUNT = 100;
    private static String PREFIX_KEY = "testKey";

    private void saveLanguageKeys(){
        final int count = KEY_COUNT;
        final String key = PREFIX_KEY;
        List<LanguageKey> languageKeys = new ArrayList<>();
        for(int i = 1; i <= count; i++){
            languageKeys.add(new LanguageKey(null, key + i, null));
        }

        languageKeyRepository.saveAll(languageKeys);
    }

    @Test
    @Transactional
    @Commit
    public void saveLanguageKey(){
        saveLanguageKeys();
        entityManager.flush();
        entityManager.clear();
        
        List<LanguageKey> languageKeys = languageKeyRepository.findAll();

        if(languageKeys != null){
            Assertions.assertThat(languageKeys.size()).isEqualTo(KEY_COUNT);
        }
    }

    private void createLanguageCode(List<LanguageKey> languageKeys){
        languageKeys.forEach(languageKey -> 
            EnumSet.allOf(LanguageCode.class).forEach(languageCode ->{
                LanguageValue languageValue = new LanguageValue(null, languageKey, languageCode, languageKey.getKey() + "-" + languageCode.toString());
                languageValueRepository.save(languageValue);
            })
        );
    }

    @Test
    @Transactional
    @Commit
    public void saveLanguageValue(){
        saveLanguageKeys();
        List<LanguageKey> languageKeys = languageKeyRepository.findAll();
        createLanguageCode(languageKeys);
    }
}
