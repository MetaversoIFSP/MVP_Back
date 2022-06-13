package studentsystem.model.cadastro;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PORTIFOLIO")
@Getter
@Setter
@ToString
public class Portifolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_TECNICO", nullable = false)
    private Tecnico tecnico;

    private String url;
    private String nome;

}