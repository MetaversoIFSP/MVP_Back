package studentsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentsystem.model.faq.CategoriaNivelDoisDto;
import studentsystem.model.faq.CategoriaNivelUmDto;
import studentsystem.service.interfaces.IFaqService;


import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RestController
@RequestMapping("faq")
@Slf4j
public class FaqController {

    @Autowired
    private IFaqService faqService;

    @GetMapping
    public ResponseEntity<List<CategoriaNivelUmDto>> getAllNivelUm(){
        AtomicReference<Integer> i = new AtomicReference<>(1);
        var o = faqService.getAllCategoriasNivelUm()
                .map(catList -> catList.stream()
                        .sorted((str1, str2) -> str1.getRelevancePoints().compareTo(str2.getRelevancePoints()))
                        .map(cat -> CategoriaNivelUmDto.builder()
                                .id(cat.getId())
                                .nome(cat.getName())
                                .posicao(i.getAndSet(i.get() + 1))
                                .urlImage(cat.getUrlImage())
                                .build()
                        ).collect(Collectors.toList())
                );
        if(o.isPresent() && !o.get().isEmpty()) {
            return o
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> notFound("Lista de CategoriaUm vazia"));
        } else return notFound("Nenhuma CategoriaUm identificada");
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CategoriaNivelDoisDto>> getNivelDois(@PathVariable("id") Long id){
        var categorias = faqService.getAllCategoriasDoisByIdOrderByRelevancePoint(id)
                .map(catList -> catList.stream()
                        .map(cat -> CategoriaNivelDoisDto.builder()
                                .categoriaNivelUm(new CategoriaNivelDoisDto.CategoriaNivelUmDto1(cat.getCategoriaNivelUm()))
                                .nome(cat.getNameDois())
                                .posicao(cat.getRelevancePointDois())
//                                .solutions(cat.getSolutions().stream()
//                                        .map(solution -> CategoriaNivelDoisDto.SolutionDto.builder()
//                                                .relevancePoints(solution.getRelevancePoints())
//                                                .pergunta(solution.getPergunta())
//                                                .resposta(solution.getResposta())
//                                                .id(solution.getId())
//                                                .build())
//                                        .collect(Collectors.toList()))
                                .urlImage(cat.getUrlImageDois())
                                .build())
                        .collect(Collectors.toList()));
        if(categorias.isPresent() && !categorias.get().isEmpty()) {
            faqService.addRelevancePointToCategoriaUm(id);
            return categorias
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> notFound("Lista de CategoriaDois com erro"));
        } else return notFound("Não existem CategoriasDois");
    }

    @GetMapping("/{idCategoriaUm}/{idCategoriaDois}")
    public ResponseEntity<List<CategoriaNivelDoisDto.SolutionDto>> getSolutionsForCategoriaDois(
            @PathVariable("idCategoriaUm") Long idCategoriaUm,
            @PathVariable("idCategoriaDois") Long idCategoriaDois
    ){
        var solutions = faqService.getAllSolucoesByIdCategoriaDoisOrderByRelevancePoint(idCategoriaDois)
                .map(catList -> catList.stream()
                        .map(solution -> CategoriaNivelDoisDto.SolutionDto.builder()
                                .relevancePoints(solution.getRelevancePoints())
                                .pergunta(solution.getPergunta())
                                .resposta(solution.getResposta())
                                .id(solution.getId())
                                .build())
                        .collect(Collectors.toList()));
        if(solutions.isPresent() && !solutions.get().isEmpty()){
            faqService.addRelevancePointToCategoriaDois(idCategoriaDois);
            return solutions
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.noContent().build());
        } else return notFound("Nenhuma Solution encontrada");
    }

    private <T> ResponseEntity<T> notFound(String str){
        log.error(str);
        return ResponseEntity.notFound().header("message", str).build();
    }
}
