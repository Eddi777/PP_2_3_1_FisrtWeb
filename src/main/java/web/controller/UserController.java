package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import web.utits.UserService;
import web.models.User;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
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
        userService.removeById(id);
        return "redirect:/main";
    }

    @GetMapping (value="/create")
    public String createUser (@RequestParam(required = true) String name, String lastname, Byte age, Model model) {
        User user = new User(name, lastname, age);
        userService.add(user);
        return "redirect:/main";
    }

    @GetMapping (value="/update")
    public String updateUser (@RequestParam(required = true) Long id, String name, String lastname, Byte age, Model model) {
        User user = new User(name, lastname, age);
        user.setId(id);
        System.out.println("Update user " + user);
        userService.update(user);
        return "redirect:/main";
    }
}