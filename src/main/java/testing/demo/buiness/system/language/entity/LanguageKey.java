package testing.demo.buiness.system.language.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import testing.demo.buiness.jpa.EitherBooleanOrYnConverter;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "language_key")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LanguageKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_key_id")
    private Long id;

    @Column(name = "language_key", unique = true, length = 50)
    private String key;

    @Column(name = "can_use", nullable = false, length = 1)
    @EitherBooleanOrYnConverter
    private String canUse;

    @OneToMany(mappedBy = "languageKey")
    private List<LanguageValue> values = new ArrayList<>();
}
