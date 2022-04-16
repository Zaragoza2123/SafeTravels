package com.codingdojo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Expense;
import com.codingdojo.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	private ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository=expenseRepository;
	}
	
	public void Create(Expense expense) {
		expenseRepository.save(expense);
	}
	
	public ArrayList<Expense> FindAll() {
		return (ArrayList<Expense>)expenseRepository.findAll();
	}
	public Expense FindOne(long id)
	{
		Optional<Expense> expense=expenseRepository.findById(id);
		return expense.isPresent()?expense.get():null;
	}
	public void Update(Expense expense)
	{
		Create(expense);
	}
	public void Delete(Long id)
	{
		expenseRepository.deleteById(id);
	}
};
