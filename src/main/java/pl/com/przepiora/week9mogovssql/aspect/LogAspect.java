package pl.com.przepiora.week9mogovssql.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class LogAspect {

  private static final Logger LOG = LoggerFactory.getLogger(LogAspect.class);

  @Around("execution(public * pl.com.przepiora.week9mogovssql.service.PersonService.*(..))")
  public void logAdvice(ProceedingJoinPoint jp) throws Throwable {
    Instant startTime = Instant.now();
    jp.proceed();
    Instant endTime = Instant.now();
    LOG.info("-----> Method: {}, time:{} miliseconds", jp.getSignature().getName(),
        Duration.between(startTime, endTime).getNano() / 1000000);

  }
}
