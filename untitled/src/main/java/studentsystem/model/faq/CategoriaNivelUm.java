package studentsystem.model.faq;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity @Getter @Setter @NoArgsConstructor @ToString
@Builder @AllArgsConstructor
@Table(name = "FaqCategoriaUm")
public class CategoriaNivelUm {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME")
    private String name;

    @Column(name = "URL_IMAGEM")
    private String urlImage;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoriaNivelUm")
    @ToString.Exclude
    private List<CategoriaNivelDois> categoriaNivelDoisList;

    @Column(name = "PONTOS_RELEVANCIA")
    private Integer relevancePoints;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CategoriaNivelUm that = (CategoriaNivelUm) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
