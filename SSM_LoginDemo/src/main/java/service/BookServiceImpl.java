package service;

import entity.BooKPOJO;
import mapper.BookMapper;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public void addBook(BooKPOJO booKPOJO) {
        bookMapper.addBook(booKPOJO);
    }

    public List<BooKPOJO> queryAllBooks() {
        return bookMapper.queryAllBooks();
    }
}
