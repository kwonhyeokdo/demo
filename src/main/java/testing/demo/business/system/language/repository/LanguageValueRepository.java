package testing.demo.business.system.language.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import testing.demo.business.system.language.entity.LanguageValue;

public interface LanguageValueRepository extends JpaRepository<LanguageValue, Long>{
    
}
