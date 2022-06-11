package studentsystem.model.cadastro;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "EMAIL")
public class EmailCadastro {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoEmail tipo;

    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    @ToString.Exclude
    private Pessoa pessoa;

}
