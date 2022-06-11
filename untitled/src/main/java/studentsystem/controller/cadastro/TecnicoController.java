package studentsystem.controller.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentsystem.model.cadastro.Tecnico;
import studentsystem.model.cadastro.TecnicoDto;
import studentsystem.service.interfaces.TecnicoService;

@RestController
@RequestMapping("tecnico")
public class TecnicoController {
    @Autowired
    private TecnicoService tecnicoService;

    @PostMapping
    public ResponseEntity<Tecnico> newTecnico(@RequestBody TecnicoDto tecnico){
        Tecnico newTecnico = tecnicoService.save(tecnico);
        return newTecnico != null
                ? ResponseEntity.ok(newTecnico)
                : ResponseEntity.badRequest().build();
    }
}
