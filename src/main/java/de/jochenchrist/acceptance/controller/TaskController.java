package de.jochenchrist.acceptance.controller;

import de.jochenchrist.acceptance.domain.Task;
import de.jochenchrist.acceptance.domain.TaskRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @ModelAttribute("task")
    public Task newTask() {
        return new Task();
    }

    @GetMapping("/")
    public String index(@AuthenticationPrincipal User user, Model model) {

        model.addAttribute("tasks", tasks(user));

        return "tasks";
    }

    @PostMapping("tasks")
    public String addTask(@Valid Task task, BindingResult bindingResult, @AuthenticationPrincipal User user, Model model) {

        if(bindingResult.hasErrors()) {
            return "tasks";
        }

        task.setOwner(user.getUsername());
        taskRepository.save(task);

        model.addAttribute("tasks", tasks(user));

        return "tasks";
    }

    List<Task> tasks(@AuthenticationPrincipal User user) {
        return taskRepository.findAllByOwnerAndCompleted(user.getUsername(), false);
    }


}
