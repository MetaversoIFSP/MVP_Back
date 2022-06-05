package studentsystem.repository.faq;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentsystem.model.faq.CategoriaNivelUm;

import java.util.List;

@Repository
public interface CategoriaNivelUmRepository extends JpaRepository<CategoriaNivelUm, Long> {
    List<CategoriaNivelUm> findAllByOrderByRelevancePointsDesc();
}
