package pl.gb.askmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gb.askmate.model.Answer;
import pl.gb.askmate.service.AnswerService;
import pl.gb.askmate.service.QuestionService;
import pl.gb.askmate.service.UserService;

@Controller
public class AnswerController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private UserService userService;

    @GetMapping("/question/{id}/answer/add")
    public String addAnswerForm(@PathVariable int id, Model model) {
        Answer answer = new Answer();
        model.addAttribute("answer", answer);
        return "answerAddForm";
    }

    @PostMapping("/question/{id}/answer/{answer_id}/edit")
    public String editAnswerForm(@PathVariable int id, @PathVariable int answer_id, Model model ) {
        Answer answer = answerService.getAnswerById(answer_id);
        model.addAttribute("answer", answer);
        return "answerEditForm";
    }

    @PostMapping("/question/{id}/answer/{answer_id}/save")
    public String saveEditedAnswer(@PathVariable int id, @PathVariable int answer_id, @ModelAttribute Answer answer ) {
        Answer answer1 = answerService.getAnswerById(answer_id);
        answer1.setAnswerString(answer.getAnswerString());
        answerService.saveEditedAnswer(answer1);
        return "redirect:/question/" +id+"/";
    }

    @PostMapping("/question/{id}/answer/{answer_id}/delete")
    public String deleteEditedAnswer(@PathVariable int id, @PathVariable int answer_id) {
        answerService.deleteAnswerById(answer_id);
        return "redirect:/question/" +id+"/";
    }

    @PostMapping("/question/{id}/answer/add")
    public String addAnswer(@PathVariable int id, @ModelAttribute Answer answer) {
        Answer answer1 = new Answer();
        answer1.setQuestion(answer.getQuestion());
        answer1.setAnswerString(answer.getAnswerString());
        answer1.setQuestion(questionService.getQuestionById(id).get());
        answer1.setUser(userService.getUserById(1).get());
        answerService.addAnswer(answer1);
        return "redirect:/question/{id}/";
    }
}
