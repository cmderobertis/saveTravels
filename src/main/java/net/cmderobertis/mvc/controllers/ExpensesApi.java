package net.cmderobertis.mvc.controllers;

import net.cmderobertis.mvc.models.Expense;
import net.cmderobertis.mvc.services.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpensesApi {
    private final ExpenseService expenseService;
    public ExpensesApi(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    @RequestMapping("/api/expenses")
    public List<Expense> index() {
        return expenseService.getAll();
    }

    @PostMapping("/api/expenses")
    public Expense create(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "vendor") String vendor,
            @RequestParam(value = "amount") Double amount,
            @RequestParam(value = "description") String desc) {
        Expense expense = new Expense(name, vendor, amount, desc);
        return expenseService.createExpense(expense);
    }

    @RequestMapping("/api/expenses/{id}")
    public Expense show(@PathVariable("id") Long id) {
        return expenseService.getOne(id);
    }

    @PutMapping("/api/expenses/{id}")
    public Expense update(
            @PathVariable("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("vendor") String vendor,
            @RequestParam("pages") Double amount,
            @RequestParam("description") String desc) {
        return expenseService.updateExpense(id, name, vendor, amount, desc);
    }

    @DeleteMapping("/api/expenses/{id}")
    public void delete(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
    }
}