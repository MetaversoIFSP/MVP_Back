package studentsystem.model.cadastro;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "DISPOSITIVO")
@Getter
@Setter
@ToString
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @ToString.Exclude
    private Pessoa dono;

    @NotBlank
    private String descricao;
}
