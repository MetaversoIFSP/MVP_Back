package studentsystem.service.interfaces;

import org.springframework.stereotype.Service;
import studentsystem.model.cadastro.FisicaCliente;

import java.util.List;
import java.util.Optional;

@Service
public interface IFisicaClienteService {
    Optional<List<FisicaCliente>> getAll();

    Optional<FisicaCliente> findById(Long id);

    Optional<FisicaCliente> findAllByUserName(String userName);

    FisicaCliente save(FisicaCliente build);
}
