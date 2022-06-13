package studentsystem.controller.cadastro;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentsystem.model.cadastro.FisicaCliente;
import studentsystem.service.interfaces.IFisicaClienteService;

@RestController
@RequestMapping("cliente")
@CrossOrigin
public class ClienteController {
    @Autowired
    private IFisicaClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<FisicaCliente>> getAllClientes(){
        var list = clienteService.getAll();
        return list.isPresent() && !list.get().isEmpty()
                ? ResponseEntity.ok(list.get())
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FisicaCliente> getById(@PathVariable Long id){
        Optional<FisicaCliente> cliente = clienteService.findById(id);
        return cliente
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FisicaCliente> newClient(@RequestBody @NonNull FisicaCliente cliente){
        Optional<FisicaCliente> pesquisa = clienteService.findAllByUserName(cliente.getUserName());
        var newCliente = clienteService.save(
                FisicaCliente.builder()
                        .assinatura(cliente.getAssinatura())
                        .atendimentos(cliente.getAtendimentos())
                        .nome(cliente.getNome())
                        .dispositivos(cliente.getDispositivos())
                        .documento(cliente.getDocumento())
                        .emails(cliente.getEmails())
                        .enderecos(cliente.getEnderecos())
                        .telefones(cliente.getTelefones())
                        .userName(cliente.getUserName())
                        .nivelExperiencia(cliente.getNivelExperiencia())
                        .nascimento(cliente.getNascimento())
                        .build()
        );
        return pesquisa.isEmpty()
                ? ResponseEntity.created(URI.create("/cliente/"+newCliente.getId())).body(newCliente)
                : ResponseEntity.badRequest().body(pesquisa.get());
    }

}
