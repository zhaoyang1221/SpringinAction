package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author zhaoyang
 * @date: 2018/10/18/0018 15:47
 * @description:
 */
@Aspect
public class AudienceForAround {
    // 切点表达式
    @Pointcut("execution(* concert.Performance.perform(..))")
    public void performance() {
    }

    @Around("performance()")
    public Object watchPerformance(ProceedingJoinPoint joinPoint) {
        Object proceed = null;
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
             proceed = joinPoint.proceed();
            System.out.println("ClAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
        return proceed;
    }
}
