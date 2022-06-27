package com.cts.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.Entities.Employee;
import com.cts.Entities.Task;
import com.cts.Repository.TaskRepository;

@Controller
public class TaskController {

	@Autowired
	private TaskRepository tRepo;

	@GetMapping("/addTaskForm")
	public ModelAndView addTaskForm() {

		ModelAndView mav = new ModelAndView("add-task-form"); // add-task-form is a thymeleaf template
		Task newTask = new Task();

		mav.addObject("task", newTask);

		return mav;

	}

	// for save tasks
	@PostMapping("/saveTask")
	public String saveTask(@ModelAttribute Task task) {

		tRepo.save(task);
		return "redirect:/list";
	}

	/* List of Task details */
	@GetMapping("/showTaskDetails")
	public String showTaskDetails(Model model) {
		List<Task> listTask = tRepo.findAll();
		model.addAttribute("listTask", listTask);

		return "showTask";
	}

	@GetMapping("/deleteTask")
	public String deleteTask(@RequestParam Long taskId) {
		tRepo.deleteById(taskId);
		return "redirect:/list";
	}

}
