package studentsystem.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsystem.model.cadastro.*;
import studentsystem.repository.cadastro.ITecnicoRepository;
import studentsystem.service.interfaces.ITecnicoService;

import java.util.stream.Collectors;

@NoArgsConstructor
@Slf4j
@Service
public class TecnicoServiceImpl implements ITecnicoService {

    @Autowired
    private ITecnicoRepository tecnicoRepository;

    @Override
    public Tecnico save(TecnicoDto tecnico) {
//        System.out.println(tecnico);
        var tec = Tecnico.builder()
                .userName(tecnico.getUserName())
                .pontuacaoAtendimento(tecnico.getPontuacaoAtendimento())
                .pontuacaoContribuicoes(tecnico.getPontuacaoContribuicoes())
                .documento(tecnico.getDocumento())
                .nome(tecnico.getNome())
                .emails(tecnico.getEmails().stream()
                        .map(email -> EmailCadastro.builder()
                                .email(email.getEmail())
                                .tipo(TipoEmail.builder()
                                        .tipo(email.getTipo())
                                        .build())
                                .build())
                        .collect(Collectors.toList()))
                .portifolio(tecnico.getPortifolio().stream()
                        .map(item -> Portifolio.builder()
                                .nome(item.getNome())
                                .url(item.getUrl())
                                .build())
                        .collect(Collectors.toList()))
                .qualificacoes(tecnico.getQualificacoes().stream()
                        .map(qualificacao -> Qualificacao.builder()
                                .descricao(qualificacao.getDescricao())
                                .tipo(qualificacao.getTipo())
                                .build())
                        .collect(Collectors.toList()))
                .build();
//        System.out.println(tec);
        return tecnicoRepository.save(tec);
    }
}
