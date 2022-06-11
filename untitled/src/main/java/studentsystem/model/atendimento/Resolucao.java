package studentsystem.model.atendimento;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "RESOLUCAO")
@Getter @Setter @ToString
public class Resolucao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_atendimento")
    private Atendimento atendimento;

    private String observacao;
}