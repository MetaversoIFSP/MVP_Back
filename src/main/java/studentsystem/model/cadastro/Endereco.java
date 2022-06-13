package studentsystem.model.cadastro;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Endereco {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    /*
      Registra o tipo de email que será armazenado para fins de contato:
      Residencial, Contato, Profissional, etc...
     */

    @ManyToOne
    @JoinColumn(name = "ID_TIPO", nullable = false)
    private TipoEndereco tipo;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    @ToString.Exclude
    private Pessoa pessoa;

    @NotNull
    private String logradouro;

    @Column(length = 6)
    private String numero;

    @Column(length = 45)
    private String complemento;

    @Column(nullable = false, length = 9)
    private String cep;

    @Column(length = 2)
    private String uf;

    private String pais;

}
