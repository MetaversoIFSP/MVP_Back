package studentsystem.repository.faq;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentsystem.model.faq.CategoriaNivelUm;

import java.util.List;

@Repository
public interface ICategoriaNivelUmRepository extends JpaRepository<CategoriaNivelUm, Long> {
    List<CategoriaNivelUm> findAllByOrderByRelevancePointsDesc();

    CategoriaNivelUm findByName(String name);
}
