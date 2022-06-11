package studentsystem.model.cadastro;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class TipoTelefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    /*
      Registra o tipo de telefone que será armazenado para fins de contato:
      Residencial, Contato, Profissional, etc...
     */
    private String tipo;
}
