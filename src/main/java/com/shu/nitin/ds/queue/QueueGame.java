package com.shu.nitin.ds.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringTokenizer;

public class QueueGame {

	public static void main(String[] args) throws IOException {

		// Taking input from console for no of elements and no of iterations.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] elemsAndIterations = br.readLine().split(" ");
		int noOfElements = Integer.parseInt(elemsAndIterations[0]);
		int iterations = Integer.parseInt(elemsAndIterations[1]);

		// Taking input from console for numbers to be inserted in queue
		StringTokenizer st = new StringTokenizer(br.readLine());

		Queue<Element> elementQueue = new LinkedList<>();
		int j = 1;
		while (st.hasMoreTokens() && j <= noOfElements) {
			Element elem = new Element();
			elem.setNumber(Integer.parseInt(st.nextToken()));
			elem.setPower(j);
			elementQueue.offer(elem);
			j++;
		}

		List<Element> poppedElementsList = new ArrayList<>();
		for (int iteration = 0; iteration < iterations; ++iteration) {
			// printing elements of queue
			elementQueue.forEach(System.out::print);
			for (int itr = 0; itr < iterations; ++itr) {
				poppedElementsList.add(elementQueue.poll());
			}

			// finding maximum power element out of popped elements
			int maxPower = poppedElementsList.stream().max(Comparator.comparing(Element::getPower))
					.orElseThrow(NoSuchElementException::new).getPower();

			// Applying business rules to popped elements from queue present in list
			Iterator<Element> itr = poppedElementsList.iterator();
			while (itr.hasNext()) {
				Element element = itr.next();
				boolean elementRemoved = false;
				if (element.getPower() == maxPower) {
					if (elementRemoved) {
						if (element.getPower() > 0) {
							element.setPower(element.getPower() - 1);
						}
					} else {
						System.out.println();
						System.out.println(element.getPower());
						itr.remove();
						elementRemoved = true;
					}

				}
				element.setNumber(element.getNumber() - 1);
			}

			// adding element back to queue
			for (Element element : poppedElementsList) {
				elementQueue.add(element);
			}
		}

	}

}

class Element {

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

	public String toString() {
		return Integer.toString(this.number) + "->" + Integer.toString(this.power) + "   ";
	}

}
