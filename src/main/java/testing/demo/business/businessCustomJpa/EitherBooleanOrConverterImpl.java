package testing.demo.business.businessCustomJpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

/**
 * Databse에서 사용하는 Y/N과 Java Boolean을 서로 전환해준다.
 * 사용할 곳에서 @Convert(converter = EitherBooleanOrConverterImpl.class)를 사용하면 된다.
 */
@Convert
public class EitherBooleanOrConverterImpl implements AttributeConverter<Boolean, String>{
    /**
     * Entity to Database
     * Boolean to Y/N
     */
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return attribute != null && attribute ? "Y" : "N";
    }

    /**
     * Database to Entity
     * Y/N to Boolean
     */
    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "Y".equals(dbData);
    }
    
}
