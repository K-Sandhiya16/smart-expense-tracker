package com.example.demo;

import com.example.demo.model.Expense;
import com.example.demo.service.ExpenseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExpenseTrackerApplicationTests {

    private ExpenseService expenseService;

    @BeforeEach
    void setUp() {
        expenseService = new ExpenseService();
    }

    @Test
    void testAddAndGetExpense() {
        Expense expense = new Expense(null, "Groceries", new BigDecimal("150.50"), "Food", LocalDate.now());
        Expense created = expenseService.addExpense(expense);

        assertThat(created.getId()).isNotNull();
        assertThat(created.getTitle()).isEqualTo("Groceries");

        List<Expense> allExpenses = expenseService.getAllExpenses(null);
        assertThat(allExpenses).hasSize(1);
    }

    @Test
    void testFilterByCategoryAndTotal() {
        expenseService.addExpense(new Expense(null, "Groceries", new BigDecimal("100.00"), "Food", LocalDate.now()));
        expenseService.addExpense(new Expense(null, "Bus Ticket", new BigDecimal("50.00"), "Travel", LocalDate.now()));

        List<Expense> foodExpenses = expenseService.getAllExpenses("Food");
        assertThat(foodExpenses).hasSize(1);
        assertThat(foodExpenses.get(0).getCategory()).isEqualTo("Food");

        BigDecimal totalFood = expenseService.getTotalExpenses("Food");
        assertThat(totalFood).isEqualTo(new BigDecimal("100.00"));
    }

    @Test
    void testDeleteExpense() {
        Expense created = expenseService.addExpense(new Expense(null, "Dinner", new BigDecimal("45.00"), "Food", LocalDate.now()));

        boolean deleted = expenseService.deleteExpense(created.getId());
        assertThat(deleted).isTrue();

        List<Expense> allExpenses = expenseService.getAllExpenses(null);
        assertThat(allExpenses).isEmpty();
    }
}