
package pro.littleworld.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pro.littleworld.webapp.model.Todo;
import pro.littleworld.webapp.service.TodoService;

import java.util.Optional;


@Controller
public class TodoController {

    @Autowired  private TodoService todoService;

    @GetMapping ("/page")
    public String todoForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "todoForm";
    }

    @PostMapping("/create")
    public String todoSubmit(Todo todo) {
        todoService.save(todo);
        return "redirect:list";
    }


    @GetMapping("/delete")
    public String todoDelete(@RequestParam("id") int id) {
        todoService.deleteById(id);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String todoGetAll(Model model) {
        Iterable<Todo> todos = todoService.findAll();
        model.addAttribute("todos", todos);
        return "todoList";
    }

    @ResponseBody
    @GetMapping("/listTodo")
    public Iterable<Todo> findAllTodos() {
      return todoService.findAll();
    }
}

