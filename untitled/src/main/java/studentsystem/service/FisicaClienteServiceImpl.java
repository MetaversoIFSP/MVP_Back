package studentsystem.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsystem.model.cadastro.FisicaCliente;
import studentsystem.model.cadastro.Pessoa;
import studentsystem.repository.cadastro.FisicaClienteRepository;
import studentsystem.service.interfaces.FisicaClienteService;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Service
public class FisicaClienteServiceImpl implements FisicaClienteService {
    @Autowired
    private FisicaClienteRepository clienteRepository;

    @Override
    public Optional<List<FisicaCliente>> getAll() {
        return Optional.of(clienteRepository.findAll());
    }

    @Override
    public Optional<FisicaCliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Optional<FisicaCliente> findAllByUserName(String userName) {
        return Optional.ofNullable(clienteRepository.findByUserName(userName));
    }

    @Override
    public FisicaCliente save(FisicaCliente cliente) {
        return clienteRepository.save(cliente);
    }
}
