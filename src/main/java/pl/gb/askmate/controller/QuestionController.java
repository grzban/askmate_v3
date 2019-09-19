package pl.gb.askmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gb.askmate.model.Question;
import pl.gb.askmate.service.QuestionService;
import pl.gb.askmate.service.UserService;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;

    @GetMapping("/questions")
    public String getQuestions(Model model) {
        model.addAttribute("questions", questionService.getQuestions());
        return "questions";
    }

    @PostMapping("/question/{id}/delete")
    public String deleteQuestions(@PathVariable int id) {
        questionService.deleteQuestion(id);
        return "redirect:/questions";
    }

    @PostMapping("/question/{id}/edit")
    public String editQuestions(@PathVariable int id, Model model) {
        model.addAttribute("question", questionService.getQuestionById(id).get());
        return "questionEditForm";
    }

    @GetMapping("/question/add")
    public String addQuestionForm(Model model) {
        Question question = new Question();
        model.addAttribute("question", question);
        return "questionAddForm";
    }

    @PostMapping("/question/{id}/save")
    public String saveEditedQuestion(@PathVariable int id, @ModelAttribute Question question) {
        Question question1 = questionService.getQuestionById(id).get();
        question1.setTitle(question.getTitle());
        question1.setDescription(question.getDescription());
        questionService.saveEditedQuestion(question1);
        return "redirect:/questions";
    }

    @PostMapping("/question/add")
    public String addQuestion(@ModelAttribute("question") Question question) {
        question.setUser(userService.getUserById(1).get());
        questionService.addQuestion(question);
        return "redirect:/questions";
    }

    @GetMapping("/question/{id}")
    public String showQuestionWithAnswers(@PathVariable int id, Model model) {
        Question question = questionService.getQuestionById(id).get();
        model.addAttribute("question", question);
        return "question";
    }
}
