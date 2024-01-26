package testing.demo.business.system.language.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import testing.demo.business.system.language.entity.LanguageKey;


public interface LanguageKeyRepository extends JpaRepository<LanguageKey, Long>{
    LanguageKey findByKey(String key);
}
