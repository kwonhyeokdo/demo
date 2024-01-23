package testing.demo.business.system.language.entity;

import org.hibernate.annotations.ColumnDefault;

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import testing.demo.business.businessCustomJpa.EitherBooleanOrYnConverter;
import testing.demo.business.system.config.LanguageCode;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;

@Entity
@Table(name = "language_value")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter(AccessLevel.PROTECTED)
public class LanguageValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_value_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_key_id", foreignKey = @ForeignKey(name = "none"))
    @NotNull
    private LanguageKey key;

    @Enumerated(EnumType.STRING)
    @Column(name = "language_code")
    @Size(max = 10)
    @NotNull
    private LanguageCode languageCode;

    @JoinColumn(name = "language_value")
    @NotNull
    private String value;

    @EitherBooleanOrYnConverter
    @Size(max = 1)
    @NotNull
    @Column(name = "can_use", columnDefinition = "DEFAULT 'Y'")
    String canUse;

    public static LanguageValue createInsertInstance(
        @Size(max = 10) @NotNull LanguageCode languageCode,
        @NotNull String value
    ){
        return LanguageValue.createInsertInstance(languageCode, value, "Y");
    }

    public static LanguageValue createInsertInstance(
        @Size(max = 10) @NotNull LanguageCode languageCode,
        @NotNull String value,
        @Size(max = 1) @NotNull String canUse
    ){
        LanguageValue result = new LanguageValue();
        result.setLanguageCode(languageCode);
        result.setValue(value);
        result.setCanUse(canUse);
        return result;
    }

    public void changeLanguageKey(LanguageKey languageKey){
        this.key = languageKey;
    }
}
