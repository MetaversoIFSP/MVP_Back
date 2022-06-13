package studentsystem.model.cadastro;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "REGRA")
public class Regra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ITEM")
    private String item;

    @Column(name = "DESCRICAO", length = 2048)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "ID_ASSINATURA")
    private Assinatura assinatura;

}
