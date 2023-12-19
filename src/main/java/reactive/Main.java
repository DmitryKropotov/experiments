package reactive;

import reactor.core.publisher.Flux;
import rx.Observable;
import rx.Scheduler;
import rx.observables.ConnectableObservable;
import rx.schedulers.Schedulers;

import javax.security.auth.callback.Callback;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        observablesWithSubscribeOn();
        Flux<Integer> fluxes = Flux.range(0, 2000).delayElements(Duration.ofMillis(1000));
        fluxes.subscribe(x->{
            System.out.println("Flux observer Thread is " + Thread.currentThread());
            System.out.println(x);
        });
        for(int i=0; i<3000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static void observablesWithSubscribeOn() {
        System.out.println("This is thread " + Thread.currentThread());
        Observable<Integer> observable1 = Observable.from(Arrays.asList(1, 2, 3, 4, 5));
        Observable<Integer> observable2 = observable1.filter(x -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("x is " + x + " Thread is " + Thread.currentThread());
            return x % 2 == 0;
        });
        observable2.subscribeOn(Schedulers.newThread()).subscribe(x-> {
            System.out.println("second observer Thread is " + Thread.currentThread());
            System.out.println(x);
        });

    }
}
