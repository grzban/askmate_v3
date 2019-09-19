package pl.gb.askmate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gb.askmate.model.Answer;
import pl.gb.askmate.repository.AnswerRepository;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public void addAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public void saveEditedAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public void deleteAnswerById(int id) {
        answerRepository.deleteById(id);
    }

    public Answer getAnswerById(int id) {
        return answerRepository.findById(id).get();
    }
}
