package testing.demo.business.system.language.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import testing.demo.business.businessCustomJpa.EitherBooleanOrYnConverter;

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

    @Column(name = "language_key", unique = true)
    @Size(max = 50)
    @NotNull
    private String key;

    @Column(name = "can_use")
    @Size(max = 1)
    @NotNull
    @EitherBooleanOrYnConverter
    private String canUse;

    @OneToMany(mappedBy = "languageKey")
    @NotNull
    private List<LanguageValue> values = new ArrayList<>();

    public static LanguageKey getInsertInstance(
        @Size(max = 50) @NotNull String key,
        @Size(max = 1) @NotNull String canUse,
        @NotNull List<LanguageValue> values
    ) {
        LanguageKey languageKey = new LanguageKey();
        languageKey.key = key;
        languageKey.canUse = canUse;
        languageKey.values = values;
        return languageKey;
    }
}
