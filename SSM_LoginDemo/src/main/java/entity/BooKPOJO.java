package entity;

import java.io.Serializable;

public class BooKPOJO implements Serializable {
    private String bookName;
    private int bookPrice;

    public BooKPOJO(String bookName, int bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public BooKPOJO() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookPrice() {
        return bookPrice;
    }


    @Override
    public String toString() {
        return "BooKPOJO{" +
                "bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                '}';
    }
}
