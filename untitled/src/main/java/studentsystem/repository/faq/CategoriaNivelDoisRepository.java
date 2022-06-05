package studentsystem.repository.faq;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentsystem.model.faq.CategoriaNivelDois;

import java.util.List;

@Repository
public interface CategoriaNivelDoisRepository extends JpaRepository<CategoriaNivelDois, Long> {
    List<CategoriaNivelDois> findByIdOrderByRelevancePointDois(Long id);
}
