package studentsystem.model.cadastro;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class TipoEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /*
      Registra o tipo de email que será armazenado para fins de contato:
      Residencial, Contato, Profissional, etc...
     */
    @NotBlank
    private String tipo;

}
