package studentsystem.model.cadastro;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TIPO_QUALIFICACAO")
@Getter
@Setter
@ToString
public class TipoQualificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String descricao;
}