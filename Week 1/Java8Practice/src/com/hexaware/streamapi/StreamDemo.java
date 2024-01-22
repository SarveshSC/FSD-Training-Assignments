package com.hexaware.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 11, 41, 42, 12);
//		long count = stream.count();

//		System.out.println(count);

		Comparator<Integer> comparator = (a, b) -> {
			return a.compareTo(b);
		};
		Optional<Integer> optional = stream.max(comparator);
		if (optional.isPresent()) {
			System.out.println(optional.get());
		}

		String[] names = { "Max", "Lewis", "George", "Daniel", "Oscar" };
		Stream<String> stream1 = Arrays.stream(names);

		stream1.map((str) -> {
			System.out.print(str);
			return str.length();
		}).forEach((len) -> {
			System.out.println(len);
		});

		List<String> list = Arrays.asList(names);

		Stream<String> stream2 = list.stream();

		List<Integer> list1 = stream2.map((str) -> {
			return str.length();
		}).filter((len) -> {
			return len > 4;
		})
//		       .forEach( (len) -> {System.out.println(len);}); 
				.toList();

		System.out.println(list1);
	}
}
