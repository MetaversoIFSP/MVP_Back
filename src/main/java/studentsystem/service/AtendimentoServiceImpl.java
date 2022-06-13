package studentsystem.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsystem.model.atendimento.Atendimento;
import studentsystem.model.atendimento.AtendimentoDto;
import studentsystem.repository.atendimento.IAtendimentoRepository;
import studentsystem.repository.cadastro.IFisicaClienteRepository;
import studentsystem.repository.cadastro.ITecnicoRepository;
import studentsystem.service.interfaces.IAtendimentoService;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@Slf4j
@Service
public class AtendimentoServiceImpl implements IAtendimentoService {
    @Autowired
    private IAtendimentoRepository atendimentoRepository;
    @Autowired
    private ITecnicoRepository tecnicoRepository;

    @Autowired
    private IFisicaClienteRepository clienteRepository;
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
    public Optional<List<Atendimento>> findByUserNameAndResolvidoFalse(String userName) {
        return Optional.ofNullable(atendimentoRepository.findByCliente_UserNameAndResolvidoFalse(userName));
    }

    @Override
    public Optional<List<Atendimento>> findByUserNameAndResolvidoTrue(String userName) {
        var atendimentos = atendimentoRepository.findByCliente_UserNameAndResolvidoTrue(userName);
        return atendimentos.isEmpty()
                ? Optional.of(List.of())
                : Optional.of(
                        atendimentos.stream()
                                .filter(atendimento -> null != atendimento.getResolucao())
                                .collect(Collectors.toList())
        );
    }

}
