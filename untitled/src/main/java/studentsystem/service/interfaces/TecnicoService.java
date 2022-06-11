package studentsystem.service.interfaces;

import org.springframework.stereotype.Service;
import studentsystem.model.cadastro.Tecnico;
import studentsystem.model.cadastro.TecnicoDto;

@Service
public interface TecnicoService {
    Tecnico save(TecnicoDto tecnico);
}
