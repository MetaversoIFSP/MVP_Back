package studentsystem.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsystem.model.faq.*;
import studentsystem.repository.faq.ICategoriaNivelDoisRepository;
import studentsystem.repository.faq.ICategoriaNivelUmRepository;
import studentsystem.repository.faq.ISolutionRepository;
import studentsystem.service.interfaces.IFaqService;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Service
public class FaqServiceImpl implements IFaqService {

    @Autowired
    private ICategoriaNivelUmRepository categoriaNivelUmRepository;
    @Autowired
    private ICategoriaNivelDoisRepository categoriaNivelDoisRepository;

    @Autowired
    private ISolutionRepository solutionRepository;

    public FaqServiceImpl(ICategoriaNivelDoisRepository categoriaNivelDoisRepository){
        log.debug("Injeção manual de dependência CategoriaNivelDoisRepository");
        this.categoriaNivelDoisRepository = categoriaNivelDoisRepository;
    }

    public FaqServiceImpl(ICategoriaNivelUmRepository categoriaNivelUmRepository){
        log.debug("Injeção manual de dependëncia CategoriaNivelUmRepository");
        this.categoriaNivelUmRepository = categoriaNivelUmRepository;
    }

    @Override
    public Optional<List<CategoriaNivelUm>> getAllCategoriasNivelUm() {
//        return categoriaNivelUmRepository.findAll(Sort.by(Sort.Direction.DESC, "position"));
        log.debug("Processando FaqServiceImpl::getAllCategoriasNivelUm");
        return Optional.ofNullable(categoriaNivelUmRepository.findAllByOrderByRelevancePointsDesc());
    }

    @Override
    public Optional<List<CategoriaNivelDois>> getAllCategoriasDoisByIdOrderByRelevancePoint(Long id) {
        log.debug("Processando FaqServiceImpl::getAllCategoriasDoisByIdOrderByRelevancePoint");
        return Optional.ofNullable(categoriaNivelDoisRepository.findByIdOrderByRelevancePointDois(id));
    }

    @Override
    public Optional<List<Solution>> getAllSolucoesByIdCategoriaDoisOrderByRelevancePoint(Long idCategoriaDois) {
        log.debug("Processando FaqServiceImpl::getAllSolucoesByIdCategoriaDoisOrderByRelevancePoint");
        return Optional.ofNullable(solutionRepository.findByCategoriaNivelDois_idOrderByRelevancePoints(idCategoriaDois));
    }

    @Override
    public void addRelevancePointToCategoriaUm(Long id) {
        var cat = categoriaNivelUmRepository.findById(id).stream().findFirst();
        if(cat.isPresent()){
            var categoria = cat.get();
            categoria.setRelevancePoints(categoria.getRelevancePoints() + 1);
            categoriaNivelUmRepository.save(categoria);
        } else {
            log.error("Erro ao gravar id: " + id + " de CategoriaUm. Causa provavel é que não exista id Cadastrado");
        }
    }

    @Override
    public void addRelevancePointToCategoriaDois(Long idCategoriaDois) {
        var cat = categoriaNivelDoisRepository.findById(idCategoriaDois).stream().findFirst();
        if(cat.isPresent()){
            var categoria = cat.get();
            categoria.setRelevancePointDois(categoria.getRelevancePointDois() + 1);
            categoriaNivelDoisRepository.save(categoria);
        } else {
            log.error("Erro ao gravar id: " + idCategoriaDois + " de CategoriaDois. Causa provavel é que não exista id Cadastrado");
        }

    }

    @Override
    public Optional<Solution> save(SolutionDto solution) {
        log.info("Checking FaqServiceImpl::save");
        Solution s = null;
        log.info("Not existing solution confirmed");

        s = solutionRepository.save(
                Solution.builder()
                        .resposta(solution.getResposta())
                        .pergunta(solution.getPergunta())
                        .relevancePoints(0)
                        .categoriaNivelDois(
                                getOrSaveCategoriaNivelDois(solution, getOrSaveCategoriaNivelUm(solution))
                        )
                        .build());
        return Optional.of(s);

    }

    private CategoriaNivelDois getOrSaveCategoriaNivelDois(SolutionDto solution, CategoriaNivelUm cat1) {
        log.info("Check de existência de CategoriaDois");
        CategoriaNivelDois cat2 = categoriaNivelDoisRepository.findByNameDois(solution.getCategoriaNivelDois()
            .getNameDois());

        if(cat2 == null) {
            cat2 = categoriaNivelDoisRepository.save(
                    CategoriaNivelDois.builder()
                            .urlImageDois(solution.getCategoriaNivelDois().getUrlImageDois())
                            .nameDois(solution.getCategoriaNivelDois().getNameDois())
                            .categoriaNivelUm(cat1)
                            .relevancePointDois(0)
                            .build()
            );
            log.info("Nova Categoria Dois cadastrada: " + cat2);
        }
        return cat2;
    }

    private CategoriaNivelUm getOrSaveCategoriaNivelUm(SolutionDto solution) {
        log.info("Check de CategoriaUm");
        CategoriaNivelUm cat1 = categoriaNivelUmRepository.findByName(solution.getCategoriaNivelDois()
                .getCategoriaNivelUm()
                .getName());
        if (cat1 == null) {
            cat1 = categoriaNivelUmRepository.save(
                    CategoriaNivelUm.builder()
                            .name(solution.getCategoriaNivelDois()
                                    .getCategoriaNivelUm()
                                    .getName())
                            .relevancePoints(0)
                            .build()
            );
            log.info("Nova Categoria Um cadastrada: " + cat1);
        }
        return cat1;
    }
}
