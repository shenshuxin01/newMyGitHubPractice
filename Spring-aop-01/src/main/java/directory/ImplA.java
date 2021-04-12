package directory;

import org.springframework.stereotype.Component;

@Component
public class ImplA  {
    public void show() {
        System.out.println("此IA类实现类自带的方法show（）");
    }

    public void bb() {
        System.out.println("此IA类实现类自带的方法bb（）");
    }
}
