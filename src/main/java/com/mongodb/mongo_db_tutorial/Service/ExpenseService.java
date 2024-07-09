package com.mongodb.mongo_db_tutorial.Service;

import com.mongodb.mongo_db_tutorial.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mongodb.mongo_db_tutorial.repository.ExpenseRepository;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name){
        return expenseRepository.findByName(name)
                .orElseThrow(()-> new RuntimeException(String.format("Cannot find expense by name %s",name)));
    }

    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(()->new RuntimeException(String.format("Cannot find expense by ID %s",expense.getId())));
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseName(expense.getExpenseName());

        expenseRepository.save(savedExpense);
    }

}
