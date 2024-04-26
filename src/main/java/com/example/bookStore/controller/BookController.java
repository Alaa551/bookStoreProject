package com.example.bookStore.controller;

import com.example.bookStore.model.entities.Book;
import com.example.bookStore.model.entities.Category;
import com.example.bookStore.service.BookService;
import com.example.bookStore.service.CategoryService;
import jakarta.validation.Valid;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("bookStore")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/books")
    public String showBooksPage(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "Admin_view/all-Books";
    }

    @GetMapping("/deleteBook/{id}")
    private String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "redirect:/bookStore/books";
    }

    @GetMapping("/editBookPage/{id}")
    private String showUpdateBookPage(Model model, Model categories, @PathVariable int id) {
        Optional<Book> book = bookService.getBook(id);
        List<Category> names = categoryService.getAllCategoriesNames();

        String base64Image = Base64.getEncoder().encodeToString(book.get().getImage());

        model.addAttribute("book", book.get());
        model.addAttribute("image",base64Image);

        categories.addAttribute("categoriesNames", names);
        return "Admin_view/edit-book";
    }


    @PostMapping("/editBook")
    private String updateBook(@ModelAttribute("book") @Valid Book book,BindingResult bindingResult, @RequestParam("imageFile") MultipartFile imageFile) throws Exception{
        if (bindingResult.hasErrors()) {
            // There are validation errors, return to the form page
            return "/bookStore/showAddBookPage";
        }

        if (!imageFile.isEmpty()) {
            byte[] imageData = imageFile.getBytes();
            book.setImage(imageData);
        }
        bookService.saveBook(book);
        return "redirect:/bookStore/books";
    }


    @GetMapping("/showAddBookPage")
    private String showAddBookPage(Model model, Model categories) {

        model.addAttribute("book",new Book());
        List<Category> names = categoryService.getAllCategoriesNames();
        categories.addAttribute("categoriesNames", names);
        return "Admin_view/add-book";
    }

    @PostMapping("/addBook")
    private String addBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        if (bindingResult.hasErrors()) {
            // There are validation errors, return to the form page
            return "/bookStore/showAddBookPage";
        }

        if (!imageFile.isEmpty()) {
            byte[] imageData = imageFile.getBytes();
            book.setImage(imageData);
        }


        bookService.saveBook(book);

        return "redirect:/bookStore/books";
    }




}
