package testing.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import testing.demo.business.system.config.LanguageCode;
import testing.demo.business.system.language.entity.LanguageValue;

@SpringBootTest
@ActiveProfiles("test")
class DemoApplicationTests {

	@Test
	void contextLoads() {
		final String languageKey = "testLangKey1";
		LanguageValue languageValueKorean = LanguageValue.createInsertInstance(LanguageCode.KOREAN, "테스트1");
		LanguageValue languageValueEnglish = LanguageValue.createInsertInstance(LanguageCode.KOREAN, "test2");
	}

}
