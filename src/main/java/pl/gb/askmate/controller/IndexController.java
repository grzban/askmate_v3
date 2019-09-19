package pl.gb.askmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.gb.askmate.model.User;
import pl.gb.askmate.service.AnswerService;
import pl.gb.askmate.service.QuestionService;
import pl.gb.askmate.service.UserService;

@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model) {

        return "index";
    }

}
