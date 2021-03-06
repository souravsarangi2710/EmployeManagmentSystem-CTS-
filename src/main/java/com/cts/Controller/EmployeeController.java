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

import com.cts.Entities.*;
import com.cts.Repository.*;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository eRepo;
	


	@GetMapping({ "/showEmployees", "/list" })
	public ModelAndView showEmployees() {

		ModelAndView mav = new ModelAndView("list-employees"); // list-employees is thymeleaf template

		List<Employee> list = eRepo.findAll();

		mav.addObject("employees", list);

		return mav;
	}

	@GetMapping("/addEmployeeForm")
	public ModelAndView addEmployeeForm() {

		ModelAndView mav = new ModelAndView("add-employee-form"); // add-employee-form is a thymeleaf template
		Employee newEmployee = new Employee();

		mav.addObject("employee", newEmployee);

		return mav;

	}

	 
	//for save employee
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee) {

		eRepo.save(employee);
		return "redirect:/list";
	}
	

	//for update details of employee
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long employeeId) {
		ModelAndView mav = new ModelAndView("add-employee-form");

		Employee employee = eRepo.findById(employeeId).get();
		mav.addObject("employee", employee);
		return mav;
	}

	/* List of Employee details */
	@GetMapping("/showEmployeeDetails")
	public String showEmployeeDetails(Model model) {
	    List<Employee> listUsers = eRepo.findAll();
	    model.addAttribute("listUsers", listUsers);
	     
	    return "show-employee-details";
	}

	/*	Employee Details by ID	*/
	
	
	
	
	
	//for Delete details of employee
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam Long employeeId) {
		eRepo.deleteById(employeeId);

		return "redirect:/list";
	}

}
