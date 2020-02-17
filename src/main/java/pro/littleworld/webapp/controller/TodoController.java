
package pro.littleworld.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pro.littleworld.webapp.model.Todo;
import pro.littleworld.webapp.service.TodoService;



@Controller
public class TodoController {

    @Autowired  private TodoService todoService;

    @GetMapping ("/todo")
    public String todoForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "todoForm";
    }

    @PostMapping("/todo/create")
    public String todoInert(Todo todo) {
        todoService.save(todo);
        return "redirect:/todo/list";
    }


    @GetMapping("/todo/delete")
    public String todoDelete(@RequestParam("id") int id) {
        todoService.deleteById(id);
        return "redirect:/todo/list";
    }

    @GetMapping("/todo/list")
    public String todoFindAll(Model model) {
        Iterable<Todo> todos = todoService.findAll();
        model.addAttribute("todos", todos);
        return "todoList";
    }
}

