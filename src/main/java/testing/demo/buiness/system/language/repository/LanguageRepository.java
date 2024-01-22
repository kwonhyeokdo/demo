package testing.demo.buiness.system.language.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import testing.demo.buiness.system.language.entity.LanguageKey;

public interface LanguageRepository extends JpaRepository<LanguageKey, Long>{
    
}
