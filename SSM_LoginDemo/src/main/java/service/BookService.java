package service;

import entity.BooKPOJO;

import java.util.List;

public interface BookService {
    void addBook(BooKPOJO booKPOJO);

    List<BooKPOJO> queryAllBooks();
}
