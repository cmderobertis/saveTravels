package net.cmderobertis.mvc.controllers;
import net.cmderobertis.mvc.models.Expense;
import net.cmderobertis.mvc.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    ExpenseService expenseService;

    @GetMapping("/")
    String index() {
        return "redirect:/expenses";
    }
    @GetMapping("/expenses")
    String expenses(Model model) {
        List<Expense> expenses = expenseService.getAll();
        System.out.println(expenses);
        if (expenses.size() > 0) {
            model.addAttribute("expenses", expenses);
            return "expenses.jsp";
        } else {
            return "redirect:/expenses/new";
        }
    }

    @GetMapping("/expenses/{id}")
    String show(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.getOne(id);
        model.addAttribute("expense", expense);
        return "show.jsp";
    }

    @GetMapping("/expenses/new")
    String createForm(@ModelAttribute("expense") Expense expense) {
        return "create.jsp";
    }

    @PostMapping("/expenses")
    String create(
        @Valid
        @ModelAttribute("expense") Expense expense,
        BindingResult result)
    {
        if (result.hasErrors()) {
            return "create.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/expenses";
        }
    }
    @RequestMapping("/expenses/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.getOne(id);
        model.addAttribute("expense", expense);
        return "update.jsp";
    }

    @RequestMapping(value="/expenses/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "update.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/expenses";
        }
    }
}
