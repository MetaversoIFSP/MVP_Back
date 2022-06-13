package studentsystem.model.atendimento;

import lombok.*;
import studentsystem.model.cadastro.Pessoa;
import studentsystem.model.cadastro.Tecnico;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Boolean passouFaq;
    private Boolean passouNivel;
    private Boolean resolvido;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Pessoa cliente;

    @ManyToOne
    @JoinColumn(name = "ID_TECNICO")
    private Tecnico tecnico;

    @OneToOne
    @JoinColumn(name = "id_resolucao")
    private Resolucao resolucao;

}
