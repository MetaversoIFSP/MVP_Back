package studentsystem.controller.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentsystem.model.cadastro.Tecnico;
import studentsystem.model.cadastro.TecnicoDto;
import studentsystem.service.interfaces.ITecnicoService;

@RestController
@RequestMapping("tecnico")
@CrossOrigin
public class TecnicoController {
    @Autowired
    private ITecnicoService tecnicoService;

    @PostMapping
    public ResponseEntity<Tecnico> newTecnico(@RequestBody TecnicoDto tecnico){
        Tecnico newTecnico = tecnicoService.save(tecnico);
        return newTecnico != null
                ? ResponseEntity.ok(newTecnico)
                : ResponseEntity.badRequest().build();
    }
}
