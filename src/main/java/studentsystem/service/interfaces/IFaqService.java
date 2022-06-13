package studentsystem.service.interfaces;

import org.springframework.stereotype.Service;
import studentsystem.model.faq.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

@Service
public interface IFaqService {
    Optional<List<CategoriaNivelUm>> getAllCategoriasNivelUm();

    Optional<List<CategoriaNivelDois>> getAllCategoriasDoisByIdOrderByRelevancePoint(Long id);

    Optional<List<Solution>> getAllSolucoesByIdCategoriaDoisOrderByRelevancePoint(Long idCategoriaDois);

    void addRelevancePointToCategoriaUm(Long id);

    void addRelevancePointToCategoriaDois(Long idCategoriaDois);

    Optional<Solution> save(SolutionDto solution);
}
