package concert;

import org.aspectj.lang.annotation.*;

/**
 * <p>Title: Audience</p>
 *
 * @description: 观众
 * @author: xiongzy
 * @date: 2018-10-18
 **/
@Aspect // 标记为切面
public class Audience {
    // 切点表达式
    @Pointcut("execution(* concert.Performance.perform(..))")
    public void performance() {
    }

    @Before("performance()") // 括号内为切点表达式
    public void silenceCellPhones() {
        System.out.println("Silence cell phones");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}