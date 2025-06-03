package ExemploAnnotations.PrimeiraAnnotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface PrimeiraAnnotation {

    String value();

    String[] nome();

    long numeroCasa();

    double valores();
}
