package com.shu.nitin.collection.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HotstarProblem {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfSubjects = Integer.parseInt(br.readLine());
		List<Interval> intervals = new ArrayList<>();
		for(int i=0; i<noOfSubjects;++i) {
			
			String[] startAndEnd = br.readLine().split(" ");
			long start = Long.parseLong(startAndEnd[0]);
			long end = Long.parseLong(startAndEnd[1]);
			
			Interval interval =new Interval(start, end);
			intervals.add(interval);
		}
		Collections.sort(intervals, Interval.BY_START);
		//intervals.sort(Interval.BY_START);
		
		for(int i=0; i<intervals.size(); i++) {
			for (int j = i+1; j < intervals.size(); j++) {
				Interval i1 = intervals.get(i);
				Interval i2 = intervals.get(j);
				if(i2.getStart() < i1.getEnd()) {
					long agg = (i2.getStart() + i1.getEnd())/2;
					i1.setEnd(agg);
					i2.setStart(agg);
				}
			}
			System.out.println(intervals.get(i).getStart()+" "+intervals.get(i).getEnd());
		}
		
	}

}

class Interval {
	
	public static final Comparator<Interval> BY_START = Comparator.comparing(Interval::getStart);
	private Long start;
	private Long end;
	public Interval(Long start, Long end) {
		super();
		this.start = start;
		this.end = end;
	}
	public Long getStart() {
		return start;
	}
	public Long getEnd() {
		return end;
	}
	
	
	public void setStart(Long start) {
		this.start = start;
	}
	public void setEnd(Long end) {
		this.end = end;
	}
	
}
