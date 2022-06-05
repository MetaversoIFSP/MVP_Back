package studentsystem.repository.faq;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentsystem.model.faq.Solution;

import java.util.List;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Long> {
    List<Solution> findByCategoriaNivelDois_idOrderByRelevancePoints(Long idCategoriaDois);
}
