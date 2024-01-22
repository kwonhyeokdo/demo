package testing.demo.business.system.commonCode.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "common_code_key")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonCodeKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "common_code_key_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "common_code_id", foreignKey = @ForeignKey(name = "none"), nullable = false)
    private CommonCode code;

    @Column(name = "common_code_key", unique = true, length = 50)
    @Size(max = 50)
    private String key;

    @OneToMany(mappedBy = "value")
    private List<CommonCodeValue> values = new ArrayList<>(); 
}
