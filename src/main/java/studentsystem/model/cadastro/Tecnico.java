package studentsystem.model.cadastro;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
@ToString
@Entity(name = "TECNICO")
@SuperBuilder
@NoArgsConstructor
public class Tecnico extends Pessoa {
    private Integer pontuacaoAtendimento;
    private Integer pontuacaoContribuicoes;

    @ToString.Exclude
    @OneToMany(mappedBy = "tecnico")
    private List<Portifolio> portifolio;

    @ToString.Exclude
    @OneToMany(mappedBy = "tecnico")
    private List<Qualificacao> qualificacoes = new ArrayList<>();

}
