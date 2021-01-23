package com.pateo.fluxApi;

import reactor.core.publisher.Flux;

import java.util.Arrays;

/**
 * @创建人 juncao
 * @创建时间 2019/12/18 18:46
 * @描述
 **/
public class FluxDemo {
    public static void main(String[] args) {
        Flux.just("1","2","3").subscribe(System.out::println);
        Flux.fromArray(new Integer[]{1,2,3}).subscribe(System.out::println);
        Flux.fromArray(new String[]{"1","2","3"}).subscribe(System.out::println);
        Flux.fromStream(Arrays.asList("1","2","3").stream()).subscribe(System.out::println);
        Flux.fromIterable(Arrays.asList("1","2","3")).subscribe(System.out::println);

        Flux.empty().subscribe(System.out::println);

        Flux.range(1,10).subscribe(System.out::println);







    }

}