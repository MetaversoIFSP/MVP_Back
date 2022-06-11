package studentsystem.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsystem.model.atendimento.Atendimento;
import studentsystem.model.atendimento.AtendimentoDto;
import studentsystem.model.cadastro.FisicaCliente;
import studentsystem.model.cadastro.Tecnico;
import studentsystem.repository.atendimento.AtendimentoRepository;
import studentsystem.repository.cadastro.FisicaClienteRepository;
import studentsystem.repository.cadastro.TecnicoRepository;
import studentsystem.service.interfaces.AtendimentoService;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@Slf4j
@Service
public class AtendimentoServiceImpl implements AtendimentoService {
    @Autowired
    private AtendimentoRepository atendimentoRepository;
    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private FisicaClienteRepository clienteRepository;
    @Override
    public Atendimento save(AtendimentoDto dto) {
        return atendimentoRepository.save(
                Atendimento.builder()
                        .cliente(clienteRepository.findByUserName(dto.getCliente().getUserName()))
                        .passouFaq(dto.getPassouFaq())
                        .passouNivel(dto.getPassouNivel())
                        .resolvido(dto.getResolvido())
                        .tecnico(tecnicoRepository.findByUserName(dto.getTecnico().getUserName()))
                        .build()
        );
    }

    @Override
    public Atendimento save(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    @Override
    public Optional<Atendimento> findById(Long id) {
        return atendimentoRepository.findById(id);
    }

    @Override
    public Optional<List<Atendimento>> findByUserName(String userName) {
        return Optional.ofNullable(atendimentoRepository.findByCliente_UserName(userName));
    }

    @Override
    public Optional<List<Atendimento>> findByUserNameAndAberto(String userName, Boolean aberto) {
        return Optional.ofNullable(atendimentoRepository.findByCliente_UserNameAndResolvido(userName, aberto));
    }

    @Override
    public Optional<List<Atendimento>> findByUserNameAndResolvido(String userName, Boolean resolvido) {
        var atendimentos = atendimentoRepository.findByCliente_UserNameAndResolvido(userName, false);
        return atendimentos.isEmpty()
                ? Optional.of(List.of())
                : Optional.of(
                        atendimentos.stream()
                                .filter(atendimento -> null != atendimento.getResolucao())
                                .collect(Collectors.toList())
        );
    }
}
