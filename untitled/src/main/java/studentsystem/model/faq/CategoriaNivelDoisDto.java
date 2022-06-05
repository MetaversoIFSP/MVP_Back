package studentsystem.model.faq;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data @Builder
public class CategoriaNivelDoisDto implements Serializable {
    private final Long id;
    private final CategoriaNivelUmDto1 categoriaNivelUm;
    private final List<SolutionDto> solutions;
    private final String nome;
    private final Integer posicao;
    private final String urlImage;

    @Data
    public static class CategoriaNivelUmDto1 implements Serializable {
        private final Long id;
        public CategoriaNivelUmDto1(CategoriaNivelUm categoria){
            this.id = categoria.getId();
        }
    }

    @Data @Builder
    public static class SolutionDto implements Serializable {
        private final Long id;
        private final String pergunta;
        private final String resposta;
        private final Integer relevancePoints;
    }
}
