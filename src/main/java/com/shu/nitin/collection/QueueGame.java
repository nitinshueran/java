package com.shu.nitin.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class QueueGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int noOfElems = Integer.parseInt(input[0]);
		int noOfIterations = Integer.parseInt(input[1]);
		int inputElements[] = new int[noOfElems];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		while(st.hasMoreTokens()){
			inputElements[i++] = Integer.parseInt(st.nextToken());
		}
		
		Queue<Inner> elems = new LinkedList<>();
		
		for (int j = 1; j <= noOfElems; ++j) {
            int num = inputElements[j-1];
            Inner elem = new Inner();
            elem.setNumber(num);
            elem.setPower(j);
            elems.add(elem);
        }
		List<Inner> fetchedElems = new ArrayList<>();
		for(int iterations = 0; iterations < noOfIterations; ++iterations) {
			elems.forEach(ele -> System.out.println(ele.getNumber() +" "+ele.getPower()));
			for(int itr =0; itr < noOfIterations; ++itr) {
				fetchedElems.add(elems.remove());
			}
			int maxPower = 0;
			for(Inner inner : fetchedElems) {
				if(inner.getPower() > maxPower) {
					maxPower = inner.getPower();
				}
			}
			Iterator<Inner> itr = fetchedElems.iterator();
			while(itr.hasNext()) {
				Inner inner = itr.next();
				boolean elementRemoved = false;
				if(inner.getPower() == maxPower) {
					if(elementRemoved) {
						if(inner.getPower() > 0) {
							inner.setPower(inner.getPower()-1);
						}
					}else {
						System.out.println(inner.getPower());
						itr.remove();
						elementRemoved = true;
					}
					
				}
				inner.setNumber(inner.getNumber()-1);
			}
			for(Inner inner: fetchedElems) {
				elems.add(inner);
			}
		}
		
	}
	
}
class Inner{
		
		private int number;
		private int power;
		
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public int getPower() {
			return power;
		}
		public void setPower(int power) {
			this.power = power;
		}
		
}
