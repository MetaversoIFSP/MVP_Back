package studentsystem.model.faq;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FaqCategoriaDois")
@NoArgsConstructor @ToString
@Builder @AllArgsConstructor
public class CategoriaNivelDois {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @Getter @Setter
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CategoriaUm")
    @Getter @Setter
    private CategoriaNivelUm categoriaNivelUm;
//    @Column(name = "ID_CategoriaUm")
//    private Long idCategoriaUm;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoriaNivelDois")
    @ToString.Exclude
    @Getter @Setter
    private List<Solution> solutions;

    @Column(name = "NOME")
    @Getter @Setter
    private String nameDois;

    @Column(name = "PONTOS_RELEVANCIA")
    @Getter @Setter
    private Integer relevancePointDois;

    @Column(name = "URL_IMAGEM")
    @Getter @Setter
    private String urlImageDois;

}