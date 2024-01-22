package testing.demo.buiness.system.commonCode.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "common_code")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "common_code_id")
    private Long id;

    @Column(name = "common_code", unique = true, length = 50)
    @Size(max = 50)
    private String code;

    @OneToMany(mappedBy = "code")
    private List<CommonCodeKey> keys = new ArrayList<>();
}
