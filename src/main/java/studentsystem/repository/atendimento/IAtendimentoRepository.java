package studentsystem.repository.atendimento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentsystem.model.atendimento.Atendimento;

import java.util.List;

@Repository
public interface IAtendimentoRepository extends JpaRepository<Atendimento, Long> {
    List<Atendimento> findByCliente_UserName(String userName);
    List<Atendimento> findByCliente_UserNameAndResolvidoTrue(String userName);

    List<Atendimento> findByCliente_UserNameAndResolvidoFalse(String userName);
}
