package pl.gb.askmate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gb.askmate.repository.QuestionRepository;
import pl.gb.askmate.model.Question;

import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Iterable<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public void deleteQuestion(Question question) {
        questionRepository.delete(question);
    }

    public void deleteQuestion(int id) {
        questionRepository.deleteById(id);
    }

    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    public void saveEditedQuestion(Question question) {
        questionRepository.save(question);
    }

    public Optional<Question> getQuestionById(int id) {
        return questionRepository.findById(id);
    }
}
