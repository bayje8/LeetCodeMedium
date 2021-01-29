package com.lc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DistinctArraySolutionExecutor {

	public static void main(String[] args) throws Exception {
		//DistinctArraySolution solution = new DistinctArraySolution();
		//System.out.println(solution.getWinner(new int[] {2,1,3,5,4,6,7}, 2));

		DistinctArraySolutionExecutor executor = new DistinctArraySolutionExecutor();
		//executor.testStreams();
		executor.test();
		
	}
	
	public void test() throws Exception {
		//System.out.println(filterRestaurants(new int[][] {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}}, 0, 100, 50));
		//System.out.println(filterrestaurents(new int[][] {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}}, 0, 100, 50));
	}
	
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] seats = new int[n];
        
IntStream.range(1, n+1).forEach(i->{
            seats[i-1]=Arrays.stream(bookings)
                .filter(x->i>=x[0]&&i<=x[1])
                .map(x->x[2])
                .reduce(0,(a,b)->a+b);
});
      
        return seats;
    }
	
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
    	return Arrays.stream(restaurants).filter(x->{return veganFriendly == 1?x[2]==1:true;}).filter(x->x[3]<=maxPrice).filter(x->x[4]<=maxDistance).sorted(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1]-o1[1];
			}}).map(x->x[0]).collect(Collectors.toList());        
    }
    
    public List<Integer> filterrestaurents(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
    	PriorityQueue<int[]> sortedRestaurants = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[1]==o1[1]?o2[0]-o1[0]:o2[1]-o1[1];
			}
		});
    	
    	for(int[]rt:restaurants ) {
    		if(rt[3]<=maxPrice && rt[4]<=maxDistance) {
    		if(veganFriendly==1) {
    			if(rt[2]==1) {
    				sortedRestaurants.add(rt);
    			}
    		}else {sortedRestaurants.add(rt);}
    		}
    	}
    	List<Integer> list= new ArrayList<>();
    	while(!sortedRestaurants.isEmpty()) {
    		list.add(sortedRestaurants.poll()[0]);
    	}
    	return list;
    }
	
	public void testStreams() throws Exception {
		String[] arr = new String[] {"1","2","3","4","5","6","7","8","9"};
		List<String> strList = Arrays.asList(arr);
		
		//Stream + terminal operation
		IntStream
			.range(1, 11)			
			.forEach(System.out::print);
		
		System.out.println();
		//Stream + intermediate (skip) + terminal (forEach)operation
		IntStream
			.range(1, 10)
			.skip(3)
			.forEach(x -> {System.out.print(x);x=x+2;System.out.print(x);});
		System.out.println();
		//Stream + intermediate(skip) + terminal (count)
		long count = IntStream
			.range(0,100)
			.skip(10)
			.count();
		System.out.println("count: "+count);
		
		System.out.println(Stream.of(2,1,3,4,76,8,0)
			.sorted()
			.findFirst()
			.get());
		
		Stream.of("D","B","A","Z")
			.sorted()
			.findFirst()
			.ifPresent(x -> {System.out.println(x + " presents");});
		
		int[] intArr = new int[] {2,1,3,5,4,6,7,10};
		
		System.out.println(Arrays.stream(intArr)
			.filter(x -> {return x%2==0;}).sorted().findFirst().getAsInt());
		
		Arrays.stream(intArr)
			.map(x -> x+2)
			.average()
			.ifPresent(x -> {System.out.println(x);});
		
		String[] names = new String[] {"Bala","Ammu","Chitra","Jeeva"};
		
		Arrays.stream(names)
			.map(String::toUpperCase)
			.filter(x->x.startsWith("J"))
			.findFirst()
			.ifPresent(x->{System.out.println(x.toLowerCase());});
		
		///read from a file
		
		try {
			Stream<String> states = Files.lines(Paths.get("C:\\Users\\bayje8\\Documents\\workspace-spring-tool-suite-4-4.4.0.RELEASE\\LeetCodeExcercise\\states.txt"));
			
			states
				.map(x->x=x.substring(0, 2).toUpperCase())
				.filter(x->x.startsWith("N"))
				.distinct()
				.forEach(System.out::println);
			
			states.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> strLst = Arrays.stream(names)
								.collect(Collectors.toList());
		System.out.println(strLst);
		
		char[] inds = new char[] {'Y','N','X'};
		
		List<String> strl = IntStream.range(0, inds.length)
			.mapToObj(x -> Character.toString(inds[x]))
			.collect(Collectors.toList());
		
		System.out.println(strl);
		
		Stream<String> csv = Files.lines(Paths.get("C:\\Users\\bayje8\\Documents\\workspace-spring-tool-suite-4-4.4.0.RELEASE\\LeetCodeExcercise\\Names.txt"));
		
		System.out.println("--------");
		csv
		.map(x->x.split(","))
		.filter(x->true)
		.filter(x->(Integer.parseInt(x[2]) > 1900))
		.forEach(x->{System.out.println(x[0]+" "+x[1]+" "+x[2]+" "+x[3]);});
		//);
		csv.close();		

		csv = Files.lines(Paths.get("C:\\Users\\bayje8\\Documents\\workspace-spring-tool-suite-4-4.4.0.RELEASE\\LeetCodeExcercise\\Names.txt"));
		
		Map<String, String> namesAge =  csv
		.map(x->x.split(","))
		.filter(x->x[3].equals("Adult"))
		.collect(Collectors.toMap(
							x->x[0], 
							x->x[1]));
		
		for (String string : namesAge.keySet()) {
			System.out.println("Key: "+string+" Value: "+namesAge.get(string));
		}
		
		csv.close();

		System.out.println(
				Stream.of(1.0, 2.0, 3.04, 4.56, 7.89)
						.reduce(0.0, (Double a, Double b) -> a + b));
		
		
		IntSummaryStatistics stats = IntStream.range(0, 1001)
			.summaryStatistics();
		
		System.out.println(stats.getCount());
		System.out.println(stats.getMax());
		System.out.println(stats.getMin());
		System.out.println(stats.getSum());
		System.out.println(stats.getAverage());
		System.out.println(stats.toString());
		
		String s = null;
		System.out.println("``````````"+Stream.of(s.split(","))
		.reduce((a,b)->b).orElse(""));
	}

}
