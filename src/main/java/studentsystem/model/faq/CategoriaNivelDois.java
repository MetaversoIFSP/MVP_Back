package studentsystem.model.faq;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder @AllArgsConstructor
@ToString @Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "FaqCategoriaDois")
public class CategoriaNivelDois {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Categoria_Um")
    private CategoriaNivelUm categoriaNivelUm;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoriaNivelDois")
    @ToString.Exclude
    private List<Solution> solutions;

    @Column(name = "NOME")
    private String nameDois;

    @Column(name = "PONTOS_RELEVANCIA")
    private Integer relevancePointDois;

    @Column(name = "URL_IMAGEM")
    private String urlImageDois;

}