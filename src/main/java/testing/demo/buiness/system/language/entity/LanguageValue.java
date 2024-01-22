package testing.demo.buiness.system.language.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import testing.demo.buiness.jpa.EitherBooleanOrYnConverter;
import testing.demo.buiness.system.commonCode.entity.CommonCode;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;

@Entity
@Table(name = "language_value")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LanguageValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_value_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_key_id", foreignKey = @ForeignKey(name = "none"), nullable = false)
    private LanguageKey key;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_code_id", foreignKey = @ForeignKey(name = "none"), nullable = false)
    private CommonCode countryCode;

    @JoinColumn(name = "language_value", nullable = false)
    private String value;

    @Column(name = "can_use", nullable = false, length = 1)
    @EitherBooleanOrYnConverter
    private String canUse;
}
