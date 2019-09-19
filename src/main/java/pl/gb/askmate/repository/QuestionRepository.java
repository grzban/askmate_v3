package pl.gb.askmate.repository;

import org.springframework.data.repository.CrudRepository;
import pl.gb.askmate.model.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
