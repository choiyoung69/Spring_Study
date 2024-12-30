package management.membermanagent.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
    @Around("execution(* management.membermanagent..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("STARTL " + joinPoint.toString());
        try{
            return joinPoint.proceed();
        }
        finally{
            long finish = System.currentTimeMillis();
            long timeMS = finish - start;
            System.out.println("End: " + joinPoint.toString() + " " + timeMS + "ms");
        }
    }
}
