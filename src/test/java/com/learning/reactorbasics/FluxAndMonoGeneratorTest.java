package com.learning.reactorbasics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Log4j2
class FluxAndMonoGeneratorTest {

    @Test
    void namesFlux() {
        StepVerifier.create(FluxAndMonoGenerator.namesFlux())
                .expectNext("Alex","Ben","Chloe")
                .verifyComplete();

    }

    @Test
    void nameMono() {
        StepVerifier.create(FluxAndMonoGenerator.nameMono())
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void namesFluxMap() {
        StepVerifier.create(FluxAndMonoGenerator.namesFluxMap())
                .expectNext("ALEX")
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void namesFluxFilter() {
        StepVerifier.create(FluxAndMonoGenerator.namesFluxFilter())
                .expectNext("4-ALEX","5-CHLOE")
                .verifyComplete();
    }
    @Test
    void namesFluxFlatMap() {
        StepVerifier.create(FluxAndMonoGenerator.namesFluxFlatMap())
                .expectNext("A","L","E","X","C","H","L","O","E")
                .verifyComplete();
    }

    @Test
    void nameMonoFlatMap() {
        StepVerifier.create(FluxAndMonoGenerator.nameMonoFlatMap())
                .expectNext((List.of("a","l","e","x")))
                .verifyComplete();
    }

    @Test
    void nameMonoFlatMapMany() {
        StepVerifier.create(FluxAndMonoGenerator.nameMonoFlatMapMany())
                .expectNextCount(4)
                .verifyComplete();
    }

    @Test
    void fluxConcat() {
        StepVerifier.create(FluxAndMonoGenerator.fluxConcat())
                .expectNextCount(8)
                .verifyComplete();
    }

    @Test
    void fluxConcatWith() {
        StepVerifier.create(FluxAndMonoGenerator.fluxConcatWith())
                .expectNextCount(6)
                .verifyComplete();
    }

    @Test
    void monoConcatWith() {
        StepVerifier.create(FluxAndMonoGenerator.monoConcatWith())
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void fluxMerge() {
        StepVerifier.create(FluxAndMonoGenerator.fluxMerge())
                .expectNextCount(8)
                .verifyComplete();
    }
    @Test
    void fluxMergeWith() {
        StepVerifier.create(FluxAndMonoGenerator.fluxMergeWith())
                .expectNextCount(8)
                .verifyComplete();
    }

    @Test
    void monoMergeWith() {
        StepVerifier.create(FluxAndMonoGenerator.monoMergeWith())
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void fluxMergeSequential() {
        StepVerifier.create(FluxAndMonoGenerator.fluxMergeSequential())
                .expectNextCount(8)
                .verifyComplete();
    }
}