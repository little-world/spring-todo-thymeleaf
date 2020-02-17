package pro.littleworld.webapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.littleworld.webapp.model.Todo;
import pro.littleworld.webapp.model.User;

@Controller
public class UserController {

    // create UserService
    //@Autowired
    //UserService userService;

    @GetMapping("/user")
    public String userForm(Model model) {
       // add to database
        return "userForm.html";
    }

    @PostMapping("/user/create")
    public String userInsert(Todo todo) {
        // add to database
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete")
    public String userDelete(@RequestParam("id") int id) {
        // delete from database
        return "redirect:/user/list";
    }

    @GetMapping("/user/list")
    public String userFindAll(Model model) {
        Iterable<User> users = null;// get from database
        model.addAttribute("users", users);
        return "userList";
    }


}
