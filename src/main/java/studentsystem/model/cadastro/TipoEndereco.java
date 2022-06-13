package studentsystem.model.cadastro;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class TipoEndereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String tipo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipo")
    @ToString.Exclude
    private List<Endereco> endereco;
}
