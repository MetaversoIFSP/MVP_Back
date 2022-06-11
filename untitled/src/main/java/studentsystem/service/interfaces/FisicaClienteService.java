package studentsystem.service.interfaces;

import org.springframework.stereotype.Service;
import studentsystem.model.cadastro.FisicaCliente;
import studentsystem.model.cadastro.Pessoa;

import java.util.List;
import java.util.Optional;

@Service
public interface FisicaClienteService {
    Optional<List<FisicaCliente>> getAll();

    Optional<FisicaCliente> findById(Long id);

    Optional<FisicaCliente> findAllByUserName(String userName);

    FisicaCliente save(FisicaCliente build);
}
