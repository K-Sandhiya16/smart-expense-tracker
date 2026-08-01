package com.example.demo.service;

import com.example.demo.model.Expense;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final Map<String, Expense> expenseStore = new ConcurrentHashMap<>();

    public Expense addExpense(Expense expense) {
        if (expense.getId() == null || expense.getId().isBlank()) {
            expense.setId(UUID.randomUUID().toString());
        }
        expenseStore.put(expense.getId(), expense);
        return expense;
    }

    public List<Expense> getAllExpenses(String category) {
        if (category != null && !category.isBlank()) {
            return expenseStore.values().stream()
                    .filter(e -> e.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>(expenseStore.values());
    }

    public BigDecimal getTotalExpenses(String category) {
        return getAllExpenses(category).stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public boolean deleteExpense(String id) {
        return expenseStore.remove(id) != null;
    }
}