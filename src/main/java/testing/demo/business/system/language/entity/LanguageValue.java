package testing.demo.business.system.language.entity;

import java.util.stream.IntStream;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import testing.demo.business.system.language.code.LanguageCode;
import jakarta.persistence.FetchType;

@Entity
@Table(name = "language_value")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter(AccessLevel.PRIVATE)
public class LanguageValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_value_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_key_id", nullable = false)
    private LanguageKey key;

    @Enumerated(EnumType.STRING)
    @Column(name = "language_code", nullable = false)
    private LanguageCode languageCode;

    @JoinColumn(name = "language_value", nullable = false)
    private String value;

    public LanguageValue(
        Long id,
        LanguageKey key,
        LanguageCode languageCode,
        String value
    ){
        this.setId(id);
        this.setKey(key);
        this.setLanguageCode(languageCode);
        this.setValue(value);

        this.changeKey(key);
    }

    public void changeKey(LanguageKey key){
        this.key = key;
        List<LanguageValue> values = key.getValues();
        int index = IntStream.range(0, values.size())
                   .filter(i -> values.get(i).getId() == key.getId())
                   .findFirst()
                   .orElse(-1);
        
        if(index == -1){
            values.add(this);
        }else{
            values.set(index, this);
        }
    }
}