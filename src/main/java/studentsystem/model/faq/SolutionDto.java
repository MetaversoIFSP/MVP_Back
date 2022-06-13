package studentsystem.model.faq;

import lombok.Data;

import java.io.Serializable;

@Data
public class SolutionDto implements Serializable {
    private final CategoriaNivelDoisWriterDto categoriaNivelDois;
    private final String pergunta;
    private final String resposta;

    @Data
    public static class CategoriaNivelDoisWriterDto implements Serializable {
        private final CategoriaNivelUmWriterDto categoriaNivelUm;
        private final String nameDois;
        private final String urlImageDois;

        @Data
        public static class CategoriaNivelUmWriterDto implements Serializable {
            private final String name;
            private final String urlImage;
        }
    }
}
