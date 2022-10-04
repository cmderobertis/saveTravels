package net.cmderobertis.mvc.repositories;
import net.cmderobertis.mvc.models.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    // this method retrieves all the books from the database
    List<Expense> findAll();
    // this method finds books with descriptions containing the search string
    List<Expense> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByNameContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByNameStartingWith(String search);
}
