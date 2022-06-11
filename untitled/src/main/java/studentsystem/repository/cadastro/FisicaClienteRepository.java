package studentsystem.repository.cadastro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentsystem.model.cadastro.FisicaCliente;

@Repository
public interface FisicaClienteRepository extends JpaRepository<FisicaCliente, Long> {
    FisicaCliente findByUserName(String userName);
}
