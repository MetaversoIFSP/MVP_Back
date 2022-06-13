package studentsystem.model.cadastro;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@ToString
public class Telefone {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    @NotBlank
    private TipoTelefone tipo;

    @NotBlank
    private String telefone;
}
