package studentsystem.model.cadastro;

import lombok.*;
import lombok.experimental.SuperBuilder;
import studentsystem.model.atendimento.Atendimento;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "CLIENTE_PF")
@SuperBuilder
public class FisicaCliente extends Pessoa {

    @Column(name = "nivel_experiencia")
    private Integer nivelExperiencia;

    @Column(name = "dt_nascimento")
    private Date nascimento;

//    @Builder
//    public FisicaCliente(
//            Long id,
//            String nome,
//            String documento,
//            String userName,
//            List<Endereco> enderecos,
//            List<Telefone> telefones,
//            List<EmailCadastro> emails,
//            List<Atendimento> atendimentos,
//            List<Dispositivo> dispositivos,
//            Assinatura assinatura,
//            Integer nivelExperiencia,
//            Date nascimento
//    ){
//        super(
//                id,
//                nome,
//                documento,
//                userName,
//                enderecos,
//                telefones,
//                emails,
//                atendimentos,
//                dispositivos,
//                assinatura);
//        this.nivelExperiencia = nivelExperiencia;
//        this.nascimento = nascimento;
//    }

}
