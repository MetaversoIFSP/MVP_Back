package studentsystem.service.interfaces;

import org.springframework.stereotype.Service;
import studentsystem.model.atendimento.Atendimento;
import studentsystem.model.atendimento.AtendimentoDto;

import java.util.List;
import java.util.Optional;

@Service
public interface IAtendimentoService {
    Atendimento save(AtendimentoDto atendimentoDto);
    Atendimento save(Atendimento atendimento);
    Optional<Atendimento> findById(Long id);
    Optional<List<Atendimento>> findByUserName(String userName);

    Optional<List<Atendimento>> findByUserNameAndResolvidoTrue(String userName);
    Optional<List<Atendimento>> findByUserNameAndResolvidoFalse(String userName);

}
