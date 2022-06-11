package studentsystem.model.cadastro;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ASSINATURA")
@Getter
@Setter
@ToString
public class Assinatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "ID_PRECO",
            foreignKey = @ForeignKey(
                    name = "FK_ASSINATURA_PRECO",
                    value = ConstraintMode.NO_CONSTRAINT
            )
    )
    private Preco preco;

    @ManyToOne
    @JoinColumn(
            name = "ID_CLIENTE",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_ASSINATURA_CLIENTE",
                    value = ConstraintMode.NO_CONSTRAINT
            )
    )
    private Pessoa cliente;

    @Column(name = "DATA_INICIO")
    private Date dataInicio;

    @Column(name = "DATA_FIM")
    private Date dataFim;

    @Column(name = "DESCONTO")
    private BigDecimal desconto;

    @OneToMany(mappedBy = "id")
    private List<Regra> regras;

    @Column(name = "VALIDADE")
    private Date validade;

}