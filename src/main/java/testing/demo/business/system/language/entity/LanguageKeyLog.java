package testing.demo.business.system.language.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import testing.demo.business.system.language.code.LanguageKeyLogCode;

@Entity
@Table(name = "language_key_log")
public class LanguageKeyLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_key_log_id")
    private Long id;

    @Column(name = "language_key_log_code", nullable = false)
    private LanguageKeyLogCode logCode;
}
