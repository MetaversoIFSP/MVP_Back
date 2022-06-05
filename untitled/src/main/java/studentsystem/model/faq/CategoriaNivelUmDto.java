package studentsystem.model.faq;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data @Builder
public class CategoriaNivelUmDto implements Serializable {
    private final Long id;
    private final String nome;
    private final String urlImage;
    private final Integer posicao;
}
