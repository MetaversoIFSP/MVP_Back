package studentsystem.model.cadastro;

import lombok.*;
import lombok.experimental.SuperBuilder;
import studentsystem.model.atendimento.Atendimento;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME_RAZAOSOCIAL")
    private String nome;

    private String documento;

    @Email
    @NonNull
    @Column(name = "USER_NAME", nullable = false)
    private String userName; // Normalmente, email de cadastro

    @ToString.Exclude
    @OneToMany(mappedBy = "id")
    private List<Endereco> enderecos = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "id")
    private List<Telefone> telefones = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "id")
    private List<EmailCadastro> emails = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Atendimento> atendimentos = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "dono") // para não adicionar mais uma camada de ClienteController, adicionamos a listagem de dispositivos. assim, eventualmente, um tecnico tambem poderia adicionar um dispositivo.
    private List<Dispositivo> dispositivos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "ID_ASSINATURA")  // para não adicionar mais uma camada de ClienteController, adicionamos a listagem de dispositivos. assim, eventualmente, um tecnico tambem poderia adicionar um dispositivo.
    private Assinatura assinatura;

}
