package com.codingdojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.models.Expense;
import com.codingdojo.services.ExpenseService;

@Controller 
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@GetMapping("/expenses")
	public String index(Model model)
	{
		model.addAttribute("all", expenseService.FindAll());
		model.addAttribute("expense", new Expense());
		return "expenses";
	}
	@PostMapping("/create_expense")
	public String expense_create(@Valid @ModelAttribute("expense") Expense expense, BindingResult res)
	{
		if(res.hasErrors()) {
			return "expenses";
		}
		expenseService.Create(expense);
		return "redirect:/expenses";	
	}
	@GetMapping("/expenses/{id}/edit")
	public String expense_edit(
			@PathVariable("id") Long id,
			Model model
			) 
	{
		model.addAttribute("one",expenseService.FindOne(id));
		return "expenses_edit";
	}
	@PostMapping("/expenses/{id}/edit")
	public String expense_edit_fr(@Valid @ModelAttribute("one") Expense expense, BindingResult res)
	{
		if(res.hasErrors()) {
			return "/expenses/{id}/edit";
		}
		expenseService.Update(expense);
		return "redirect:/expenses";
	}
	@GetMapping("/expenses/{id}/details")
	public String show_one(@PathVariable("id") Long id,Model model)
	{
		model.addAttribute("one", expenseService.FindOne(id));
		return "expenses_show";
	}
	@GetMapping("/expenses/{id}/delete")
	public String delete(@PathVariable("id") Long id)
	{
		expenseService.Delete(id);
		return "redirect:/expenses";
	}
};
