package mono;

import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) throws Exception {

        Mono<ComplexObj> mono = Mono.just(new ComplexObj(true, "test")).delayElement(Duration.ofMillis(2000));
        mono.doOnNext(result -> System.out.println("we got result in doOnNext1 " + result)).
                subscribe(result -> System.out.println("we got result in subscribe1 " + result));
        System.out.println("after subscribe1");
        mono.doOnNext(result -> System.out.println("we got result in doOnNext2 " + result)).
                subscribe(result -> System.out.println("we got result in subscribe2 " + result));

        System.out.println("before mono2");
        Mono<ComplexObj> mono2 = Mono.just(new ComplexObj(false, "test2")).delayElement(Duration.ofMillis(3000));
        System.out.println("mono2 is " + mono2.block());
        System.out.println("after mono2");

    }
}
