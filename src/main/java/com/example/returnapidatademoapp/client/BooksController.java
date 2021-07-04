package com.example.returnapidatademoapp.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class BooksController {

    public BooksController() {

        listOfTitles();
    }

    public BookList[] listOfTitles() {

        RestTemplate restTemplate = new RestTemplate();

        BookList[] bookList = restTemplate.getForObject("https://wolnelektury.pl/api/books", BookList[].class);

        for (BookList bookList1 : bookList) {
            System.out.println(bookList1.getTitle());

        }

        return bookList;

    }

    @GetMapping("/titles")
    public String getListOfTitles(Model model) {

        model.addAttribute("listOfTitles", listOfTitles());
        return "bookslist";


    }


}
