package directory;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ImplB {

    //自定义一个方法当作 pointcut
    @Pointcut("execution(void directory.ImplA.show())")
    public void pt1(){}


//    @Before()
//    @After()
    @Around("pt1()")
    public void bb(ProceedingJoinPoint p) throws Throwable {

        System.out.println("此IB类实现类自带的方法bbbbbbccc（） before");
        p.proceed();
        System.out.println("此IB类实现类自带的方法bbbbbbccc（）after");
    }
}
