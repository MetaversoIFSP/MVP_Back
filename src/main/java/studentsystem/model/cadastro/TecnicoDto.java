package studentsystem.model.cadastro;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
public class TecnicoDto implements Serializable {
    private final String nome;
    private final String documento;
    @Email
    private final String userName;
    private final List<EnderecoDto> enderecos = List.of();
    private final List<TelefoneDto> telefones = List.of();
    private final List<EmailCadastroDto> emails = List.of();
    private final Integer pontuacaoAtendimento;
    private final Integer pontuacaoContribuicoes;
    private final List<PortifolioDto> portifolio = List.of();
    private final List<QualificacaoDto> qualificacoes = List.of();;

    @Data
    public static class EnderecoDto implements Serializable {
        @NotNull
        private final String logradouro;
        private final String numero;
        private final String complemento;
        private final String cep;
        private final String uf;
        private final String pais;
    }

    @Data
    public static class TelefoneDto implements Serializable {
        @NotBlank
        private String tipo;
        @NotBlank
        private final String telefone;
    }

    @Data
    public static class EmailCadastroDto implements Serializable {
        @Email
        private final String email;
        private final String tipo;
    }

    @Data
    public static class PortifolioDto implements Serializable {
        private final String url;
        private final String nome;
    }

    @Data
    public static class QualificacaoDto implements Serializable {
        private final String descricao;
        private final TipoQualificacao tipo;
    }
}
