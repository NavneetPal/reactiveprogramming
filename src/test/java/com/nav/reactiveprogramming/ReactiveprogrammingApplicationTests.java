package com.nav.reactiveprogramming;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.List;

@SpringBootTest
class ReactiveprogrammingApplicationTests {

	@Test
	void monoCreation() {
		Mono<String> m1 = Mono.just("Navneet Pal");
		m1.subscribe(System.out::println);
	}

	@Test
	void monoZip() {
		Mono<String> m1 = Mono.just("Navneet Pal");
		Mono<String> m2 = Mono.just("Nakul Pal");

		Mono<Tuple2<String,String>> combinedMono = Mono.zip(m1, m2);
		combinedMono.subscribe(t -> System.out.println("Zip: " + t.getT1() + ", " + t.getT2()));
	}

	/**
	 * Map method always return the same value that is passed to it.
	 * So it returns the Mono
	 */
	@Test
	void mapMethod(){
		Mono<String> m1 = Mono.just("Navneet Pal");
		Mono<String> updatedM1 = m1.map(String::toUpperCase);
		updatedM1.subscribe(System.out::println);
	}


	/**
	 * FlatMap method change value type possible
	 * So it returns the Mono
	 */
	@Test
	void flatMapMethod(){
		Mono<String> m1 = Mono.just("Navneet Pal");
		Mono<List<String>> updatedM1 = m1.flatMap(data -> {
			return Mono.just(List.of(data));
		});
		updatedM1.subscribe(System.out::println);
	}
}
