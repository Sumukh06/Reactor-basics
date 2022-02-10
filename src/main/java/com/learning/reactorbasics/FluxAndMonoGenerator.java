package com.learning.reactorbasics;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Log4j2
@Service
public class FluxAndMonoGenerator {
    static Flux<String>namesFlux(){
        return Flux.just("Alex","Ben","Chloe") ;
    }
    static Mono<String>nameMono(){
        return Mono.just("Raj");
    }
    static Flux<String>namesFluxMap(){
        return Flux.just("Alex","Ben","Chloe")
                .map(s -> s.toUpperCase(Locale.ROOT));
    }
    static Flux<String>namesFluxFilter(){
        return Flux.just("Alex","Ben","Chloe")
                .map(s -> s.toUpperCase())
                .filter(s -> s.length()>3)
                .map(s -> s.length()+"-"+s);
    }
    static Flux<String>namesFluxFlatMap(){
        return Flux.just("Alex","Ben","Chloe")
                .map(s -> s.toUpperCase())
                .filter(s -> s.length()>3)
                .flatMap(s -> {
                    String[] chars=s.split("");
                    return Flux.fromArray(chars);
                });
    }
    static Mono<List<String>>nameMonoFlatMap(){
        return Mono.just("alex")
                .flatMap(s -> {
                    String[] chars=s.split("");
                    List<String> sList= Arrays.asList(chars);
                    return Mono.just(sList);
    }).log();
    }

    static Mono<Integer>nameMonoMap(){
        return Mono.just("alex")
                .map(s -> s.length());
    }
    static Flux<String> nameMonoFlatMapMany(){
        return Mono.just("alex")
                .flatMapMany(s -> {
                    var a=s.split("");
                    return Flux.fromArray(a);
                }).log();
    }
    static Flux<String> fluxConcat(){
        var a=Flux.just("a","b","c","d");
        var b=Flux.just("e","f","g","h");
        return Flux.concat(a,b).log();
    }
    static Flux<String> fluxConcatWith(){
        var a1=Flux.just("a","b","c");
        var b1=Flux.just("d","e","f");
        return a1.concatWith(b1).log();
    }
    static Flux<String> monoConcatWith(){
        var a1=Mono.just("a");
        var b1=Mono.just("b");
        return a1.concatWith(b1).log();
    }
    static Flux<String> fluxMerge(){
        var a=Flux.just("a","b","c","d")
                .delayElements(Duration.ofMillis(100));
        var b=Flux.just("e","f","g","h")
                .delayElements(Duration.ofMillis(125));
        return Flux.merge(a,b).log();
    }
    static Flux<String> fluxMergeWith(){
        var a=Flux.just("a","b","c","d")
                .delayElements(Duration.ofMillis(100));
        var b=Flux.just("e","f","g","h")
                .delayElements(Duration.ofMillis(125));
        return a.mergeWith(b).log();
    }
    static Flux<String> monoMergeWith(){
        var a=Mono.just("a").delayElement(Duration.ofMillis(1));
        var b=Mono.just("b");
        return a.mergeWith(b).log();
    }
    static Flux<String> fluxMergeSequential(){
        var a=Flux.just("a","b","c","d")
                .delayElements(Duration.ofMillis(100));
        var b=Flux.just("e","f","g","h")
                .delayElements(Duration.ofMillis(125));
        return Flux.mergeSequential(a,b).log();
    }


    public static void main(String[] args) {

    }
}
