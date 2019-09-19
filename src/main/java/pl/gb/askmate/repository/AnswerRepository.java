package pl.gb.askmate.repository;

import org.springframework.data.repository.CrudRepository;
import pl.gb.askmate.model.Answer;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {
    List<Answer> getAnswersByQuestionId(int id);
}
