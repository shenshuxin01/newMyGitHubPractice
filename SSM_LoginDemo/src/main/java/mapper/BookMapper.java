package mapper;

import entity.BooKPOJO;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface BookMapper {

//    @Insert("insert into ssm_book_demo_tab(book_name,book_price) " +
//            "        values (#{bookName},#{bookPrice})")
    void addBook(BooKPOJO booKPOJO);

    List<BooKPOJO> queryAllBooks();

    void removeAll();

    boolean submitFun();
}
