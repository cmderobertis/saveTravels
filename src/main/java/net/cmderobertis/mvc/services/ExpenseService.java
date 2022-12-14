package net.cmderobertis.mvc.services;

import org.springframework.stereotype.Service;
import net.cmderobertis.mvc.repositories.ExpenseRepository;
import net.cmderobertis.mvc.models.Expense;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    // adding the expense repository as a dependency
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // returns all the expenses
    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }

    // creates a expense
    public Expense createExpense(Expense e) {
        return expenseRepository.save(e);
    }

    // retrieves a expense
    public Expense getOne(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        return optionalExpense.orElse(null);
    }

    public Expense updateExpense(Expense expense) {
        Expense e = getOne(expense.getId());
        e.setName(expense.getName());
        e.setVendor(expense.getVendor());
        e.setAmount(expense.getAmount());
        e.setDescription(expense.getDescription());
        return expenseRepository.save(e);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
