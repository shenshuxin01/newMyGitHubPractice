import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashSet;

public class Test_40 extends TestCase {

    public void testFun() {
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        System.out.println(l == l2);
        System.out.println(l.equals(l2));
        assert l.equals(l2);
        //可知：List重写了equals方法
        //实现Compareable接口或者compareter

        HashSet<ArrayList<Integer>> set = new HashSet<>();
        boolean add = set.add(l);
        boolean add1 = set.add(l2);
        System.out.println(add);
        System.out.println(add1);
        assert add != add1;
    }
}
