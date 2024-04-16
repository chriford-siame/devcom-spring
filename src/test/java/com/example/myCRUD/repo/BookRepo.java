package com.example.myCRUD.repo;

import org.springframework.stereotype.Repository;

import com.example.myCRUD.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
}
