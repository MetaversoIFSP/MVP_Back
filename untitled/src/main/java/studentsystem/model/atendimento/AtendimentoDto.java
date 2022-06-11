package studentsystem.model.atendimento;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import java.io.Serializable;

@Data
@Builder
public class AtendimentoDto implements Serializable {
    private final Boolean passouFaq;
    private final Boolean passouNivel;
    private final PessoaAtendimentoDto cliente;
    private final TecnicoAtendimentoDto tecnico;
    private final Boolean resolvido;

    @Builder
    @Data
    public static class PessoaAtendimentoDto implements Serializable {
        private final Long id;
        @Email
        private final String userName;
    }

    @Builder
    @Data
    public static class TecnicoAtendimentoDto implements Serializable {
        private final Long id;
        @Email
        private final String userName;
    }
}
