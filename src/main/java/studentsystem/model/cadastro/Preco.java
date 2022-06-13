package studentsystem.model.cadastro;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Builder
@AllArgsConstructor
@Entity
@Table(name = "PRECO")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Preco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "PACOTE")
    private String pacote;

    @Column(name = "INICIO_VIGENCIA")
    private Date dataInicioVigencia;

    @Column(name = "FIM_VIGENCIA")
    private Date dataFimVigencia;

    @Column(name = "VALOR_PACOTE")
    private BigDecimal valor;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "preco")
    private List<Assinatura> assinaturas = new ArrayList<>();

}