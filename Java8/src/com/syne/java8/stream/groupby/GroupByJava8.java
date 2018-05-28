package com.syne.java8.stream.groupby;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

//Group persons by gender 
public class GroupByJava8 {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Sharon", 21, "Female"));
		personList.add(new Person("Maria", 18, "Female"));
		personList.add(new Person("Ruby", 22, "Female"));
		personList.add(new Person("Jack", 25, "Male"));
		personList.add(new Person("James", 35, "Male"));
		
		System.out.println("List<Person>::::::");
		personList.stream().forEach(System.out::println);
		
		//Group person by gender - Return result in List
		Map<String, List<Person>> groupByGenderList = 
				personList.stream().collect(Collectors.groupingBy(Person::getGender));
		
		//System.out.println("1. result in List>> "+groupByGenderList.toString());
		
		//group person by gender - Return result in Set
		
		Map<String, Set<Person>> groupByGenderSet =
				personList.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.toSet()));
		
		//System.out.println("2. result in Set>> "+groupByGenderSet.toString());
		
		Map<String, Set<String>> groupByGenderNameSet = 
				personList.stream().collect(Collectors.groupingBy(Person::getGender, 
						TreeMap::new, Collectors.mapping(Person::getName, Collectors.toSet())));
		//System.out.println("3. result in groupByGenderNameSet>> "+groupByGenderNameSet.toString());
	
	
		Map<String, Long> countPersonByGender =
				personList.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
		
		System.out.println("4. Count Person By Gender>> "+countPersonByGender.toString());
		
		Map<String, Optional<Person>> personByMaxAge = personList.stream()
				.collect(Collectors.groupingBy(Person::getGender, 
						Collectors.maxBy(Comparator.comparing(Person::getAge))));
		System.out.println("5. Group person objects by gender and get person with max age: ");
		System.out.println(personByMaxAge.toString());
		
		
		Map<String, IntSummaryStatistics> groupPersonsByAge = personList.stream().
				collect(Collectors.groupingBy(Person::getGender
						,Collectors.summarizingInt(Person::getAge)));		
		System.out.println("6. Group person objects by gender and get age statistics: ");
		System.out.println(groupPersonsByAge.toString());
		IntSummaryStatistics malesAge = groupPersonsByAge.get("Female");
		System.out.println("Avgerage male age:"+ malesAge.getAverage());
		System.out.println("Max male age:"+ malesAge.getMax());
		System.out.println("Min male age:"+ malesAge.getMin());
	}
}