package web.controller;

import web.utits.UserService;
import web.utits.UserServiceImpl;
import web.models.User;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @GetMapping (value="/main")
    public String mainPage (Model model) {
        System.out.println("start main");
        List<User> messages = userService.getAllUsers();
        model.addAttribute("users", messages);
        return "main";
    }

    @GetMapping (value="/delete")
    public String removeUser (@RequestParam(required = true) Long id, Model model) {
        userService.removeUser(id);
        return "redirect:/main";
    }

    @GetMapping (value="/create")
    public String createUser (@RequestParam(required = true) String name, String lastname, Byte age, Model model) {
        User user = new User(name, lastname, age);
        userService.addUser(user);
        return "redirect:/main";
    }

    @GetMapping (value="/update")
    public String updateUser (@RequestParam(required = true) Long id, String name, String lastname, Byte age, Model model) {
        User user = new User(name, lastname, age);
        userService.updateUser(user, id);
        return "redirect:/main";
    }
}