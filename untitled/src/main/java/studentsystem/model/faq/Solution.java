package studentsystem.model.faq;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor @ToString
@Builder @AllArgsConstructor
@Entity
@Table(name = "FaqSolution")
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_CategoriaDois")
    @ToString.Exclude
    @Getter @Setter
    private CategoriaNivelDois categoriaNivelDois;

    @Getter @Setter
    private String pergunta;
    @Getter @Setter
    private String resposta;
    @Getter @Setter
    private Integer relevancePoints;

}