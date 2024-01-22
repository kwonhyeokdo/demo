package testing.demo.business.businessCustomJpa;

import jakarta.persistence.Convert;

/**
 * @Convert(converter = BothBooleanYnConverterImpl.class) 대신 @BothBooleanAndYnConverter를 사용하기 위한 어노테이션 정의.
 * Databse에서 사용하는 Y/N과 Java Boolean을 서로 전환해준다.
 */
@Convert(converter = EitherBooleanOrConverterImpl.class)
public @interface EitherBooleanOrYnConverter {
}
