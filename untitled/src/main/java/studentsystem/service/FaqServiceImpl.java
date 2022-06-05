package studentsystem.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsystem.model.faq.CategoriaNivelDois;
import studentsystem.model.faq.CategoriaNivelUm;
import studentsystem.model.faq.Solution;
import studentsystem.repository.faq.CategoriaNivelDoisRepository;
import studentsystem.repository.faq.CategoriaNivelUmRepository;
import studentsystem.repository.faq.SolutionRepository;
import studentsystem.service.interfaces.IFaqService;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Service
public class FaqServiceImpl implements IFaqService {

    @Autowired
    private CategoriaNivelUmRepository categoriaNivelUmRepository;
    @Autowired
    private CategoriaNivelDoisRepository categoriaNivelDoisRepository;

    @Autowired
    private SolutionRepository solutionRepository;

    public FaqServiceImpl(CategoriaNivelDoisRepository categoriaNivelDoisRepository){
        log.debug("Injeção manual de dependência CategoriaNivelDoisRepository");
        this.categoriaNivelDoisRepository = categoriaNivelDoisRepository;
    }

    public FaqServiceImpl(CategoriaNivelUmRepository categoriaNivelUmRepository){
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
}
