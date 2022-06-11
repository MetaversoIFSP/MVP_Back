package studentsystem.repository.atendimento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentsystem.model.atendimento.Atendimento;

import java.util.List;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
    List<Atendimento> findByCliente_UserName(String userName);
    List<Atendimento> findByCliente_UserNameAndResolvido(String userName, Boolean aberto);
}
