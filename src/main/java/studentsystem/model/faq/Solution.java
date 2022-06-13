package studentsystem.model.faq;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor @ToString
@Builder @AllArgsConstructor
@Entity
@Table(name = "FaqSolution")
@Getter @Setter
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_Categoria_Dois")
    @ToString.Exclude
    private CategoriaNivelDois categoriaNivelDois;

    private String pergunta;

    private String resposta;

    @Column(name = "PONTOS_RELEVANCIA")
    private Integer relevancePoints;

}