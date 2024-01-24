package testing.demo.business.system.language.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import java.util.ArrayList;

@Entity
@Table(name = "language_key")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter(AccessLevel.PROTECTED)
public class LanguageKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_key_id")
    private Long id;

    @Column(name = "language_key", unique = true, nullable = false)
    @Size(max = 50)
    private String key;

    @OneToMany(mappedBy = "key")
    private List<LanguageValue> values = new ArrayList<>();

    public static LanguageKey getInstance(
        Long id,
        String key,
        List<LanguageValue> values
    ){
        LanguageKey result = new LanguageKey();
        result.setId(id);
        result.setKey(key);
        result.setValues(values);

        if(values != null && !values.isEmpty()){
            result.changeValues(values);
        }
        
        return result;
    }

    public void changeValues(List<LanguageValue> values){
        this.values = values;
        values.forEach(value -> {
            value.changeKey(this);
        });
    }
}
