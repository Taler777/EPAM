package hometask02.task7;

/*
Задание 7. Аннотации

Разработайте для класса АтомнаяЛодка из задания 6 (или любого другого класса) аннотацию,
которая могла бы обрабатываться утилитой Javadoc.
Аннотируйте класс.

 */

import java.lang.annotation.*;
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public  @interface   AtomicSubmarine {

}