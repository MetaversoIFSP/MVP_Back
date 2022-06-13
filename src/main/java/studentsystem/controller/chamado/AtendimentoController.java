package studentsystem.controller.chamado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentsystem.model.atendimento.Atendimento;
import studentsystem.model.atendimento.AtendimentoDto;
import studentsystem.model.atendimento.Resolucao;
import studentsystem.service.interfaces.IAtendimentoService;

import java.net.URI;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("atendimento")
public class AtendimentoController {

    @Autowired
    private IAtendimentoService atendimentoService;

    @PostMapping
    public ResponseEntity<Atendimento> newAtendimento(@RequestBody AtendimentoDto atendimento){
        Atendimento saved = atendimentoService.save(atendimento);
        return saved != null
                ? ResponseEntity.created(URI.create("/atendimento/" + saved.getId())).body(saved)
                : ResponseEntity.badRequest().build();
    }

    @PatchMapping("/ref/{id}")
    public ResponseEntity<Atendimento> updateAtendimento(@PathVariable Long id, @RequestBody Atendimento atendimento){
        Optional<Atendimento> updateable = atendimentoService.findById(id);
        Atendimento updated = null;
        if(updateable.isPresent()) {
            if (atendimento.getId() == null)
                atendimento.setId(id);
            updated = atendimentoService.save(atendimento);
        }
        return updated == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(updated);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<List<Atendimento>> getAllActiveByUser(@PathVariable String userName,
                                                                @RequestParam(value = "abertos", required = false) Boolean abertos,
                                                                @RequestParam(value = "resolvidos", required = false) Boolean resolvidos){
        if(!abertos && !resolvidos){
            Optional<List<Atendimento>> atendimentos = atendimentoService.findByUserName(userName);
            return atendimentos.isEmpty() || atendimentos.get().isEmpty()
                    ? ResponseEntity.notFound().build()
                    : ResponseEntity.ok(atendimentos.get());
        }
        if(abertos && !resolvidos) {
            Optional<List<Atendimento>> atendimentos = atendimentoService.findByUserNameAndResolvidoFalse(userName);
            return atendimentos.isEmpty() || atendimentos.get().isEmpty()
                    ? ResponseEntity.notFound().build()
                    : ResponseEntity.ok(atendimentos.get());
        }
        if(resolvidos && !abertos){
            Optional<List<Atendimento>> atendimentos = atendimentoService.findByUserNameAndResolvidoTrue(userName);
            return atendimentos.isEmpty() || atendimentos.get().isEmpty()
                    ? ResponseEntity.notFound().build()
                    : ResponseEntity.ok(atendimentos.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/ref/{id}")
    public ResponseEntity<Atendimento> getAllById(@PathVariable Long id){
        Optional<Atendimento> atendimento = atendimentoService.findById(id);
        return atendimento.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(atendimento.get());
    }

    @PostMapping("/ref/{id}/encerrar")
    public ResponseEntity<Atendimento> encerrar(@PathVariable Long id, @RequestBody Resolucao resolucao){
        Optional<Atendimento> atendimento = atendimentoService.findById(id);
        Atendimento updated = null;
        if(atendimento.isPresent()) {
            updated = atendimento.get();
            updated.setResolucao(resolucao);
            updated.setResolvido(true);

            updated = atendimentoService.save(updated);
        }
        return updated == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(updated);
    }
}
