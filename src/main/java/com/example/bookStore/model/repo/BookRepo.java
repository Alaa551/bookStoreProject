package com.example.bookStore.model.repo;

import com.example.bookStore.model.entities.Account;
import com.example.bookStore.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer>{

//    @Query("select categories.name " +
//            "from categories " +
//            "right join books " +
//            "on books.category_id = categories.id " +
//            "where books.id=:bookId")
@Query("SELECT b.category.name " +
        "FROM Book b " +
        "WHERE b.id = :id")
 public String findCategoryNameByBookId(@Param("id") int id);

}


