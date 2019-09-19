package pl.gb.askmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gb.askmate.model.User;
import pl.gb.askmate.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/user/add")
    public String addUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userAddForm";
    }

    @PostMapping("/user/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUserById(id).get());
        return "user";
    }

    @GetMapping("/user/{id}/edit")
    public String editFormUserById(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userEditForm";
    }

    @PutMapping("/user/{id}/edit")
    public String editSaveUserById(@PathVariable int id, @ModelAttribute("user") User user) {
        userService.saveEditedUser(user);
        return "redirect:/user/"+id;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
