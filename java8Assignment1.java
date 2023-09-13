package assignments;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class java8Assignment1 {

	public static void main(String[] args) {
		
//		1.	Basic Lambda Expressions:
//			•	Write a lambda expression that takes two integers and returns their sum.
		
		BiFunction<Integer,Integer,Integer> sum = (x,y)->{return x+y;};
		System.out.println(sum.apply(2, 3));

		//•	Write a lambda expression that takes a string and returns its uppercase version.
		
		 Function<String,String> f1 = (s)->s.toUpperCase();
		 System.out.println(f1.apply("renuka"));

		/*
		 * 2. Comparator Using Lambda:
		 * • Given a list of strings, sort them based on
		 * their length using a lambda expression.
		 */
		 String[] sampleName = {"hi","helllo","neeew"};
		 List<String> newList = Arrays.asList(sampleName);
		 List<String> sortedList = newList.stream().sorted((str1, str2) -> str1.length()-str2.length()).collect(Collectors.toList());
		 System.out.println(sortedList);
		 
		 
		 //•	Create a new thread using the Runnable interface and lambda expressions. 
		 //The thread should print "Lambda Runnable in action!" when run.
		 
		 Runnable r1 = () -> System.out.println("Lambda Runnable in action!");
	      r1.run();
	      
			/*
			 * • Convert a list of integers into a stream, filter out the odd numbers, and
			 * collect the result into a new list.
			 */
	      
	      Integer arr[] = {1,2,7,32,21,879,0};
	     List<Integer> intList = Arrays.asList(arr);
	     List<Integer> filterList = intList.stream().filter(i->i%2==0).toList();
	     System.out.println(filterList);
	     
			/*
			 * • Using a list of strings, convert all strings to
			 * uppercase (map), filter out strings that are less than 4 characters long, and
			 * concatenate the remaining strings (reduce).
			 */
	     
	     String list2 = newList.stream().map(s->s.toUpperCase()).filter(s->s.length()>4).reduce("", String::concat);
	     System.out.println(list2);
	     
		/*
		 * 3. Function Composition: 
		 * • Create two Function<Integer, Integer> definitions:
		 * a. One that multiplies the given number by 2. 
		 * b. Another that adds 3 to the
		 * given number. 
		 * • Compose the two functions into a new function that multiplies
		 * a given number by 2 and then adds 3.
		 */
	     
	     Function<Integer,Integer> f3 = (a)->a*2;
	     System.out.println(f3.apply(23));
	     Function<Integer,Integer> f4 = (a)->a+3;
	     System.out.println(f4.apply(3));
	     Function<Integer,Integer> f5 = (a)->a*2+3;
	     System.out.println(f5.apply(3));
	     
			/*
			 * Part 3: Using Pre-defined Functional Interfaces 
			 * 1. Predicates: 
			 * • Write a predicate that checks if a number is even. 
			 * • Write a predicate that checks if a string's length is greater than 5. 
			 * • Combine the two predicates to check a list of strings and filter out those that are even in length and have a
			 * length greater than 5. 
			 */
	     
	     Predicate<Integer> p1 = s->s%2==0;
	     Predicate<String> p2 = s->s.length()>5;
	     Predicate<String> p3 = s->(s.length()%2==0)&&(s.length()>5);
	     System.out.println(p1.test(5));
	     System.out.println(p2.test("Renuka"));
	     
	     List<String> list3 = newList.stream().filter(p3).toList();
	     System.out.println(list3);
	     
	     /* 
		 * 2. Function Interface: 
		 * • Write a function that takes a string and returns its length. 
		 * • Write a function that takes a string and returns its lowercase version. 
		 */ 
	     Function<String, Integer> f6 = s->s.length();
	     Function<String, String> f7 = s->s.toLowerCase();
	     
	     System.out.println(f6.apply("Renuka"));
	     System.out.println(f7.apply("Home"));
		 
		 /* 3. Consumer and Supplier: 
		 * • Write a consumer that prints the string it receives.
		 * • Write a supplier that returns the current date-time as a formatted string.
		 */
	  
	     Consumer<String> c1= s->System.out.println(s);
	     c1.accept("This is me");
	     
	     Supplier<String> s1 = ()->LocalDateTime.now().toString();
	     System.out.println(s1.get());
	     
	}
}
