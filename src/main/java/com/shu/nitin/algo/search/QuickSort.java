package com.shu.nitin.algo.search;

public class QuickSort {

	public static void main(String[] args) {
		int[] elements = new int[] { 6, 5, 3, 2, 8 };
		sort(elements, -1, elements.length);
		for (int e : elements) {
			System.out.println(e);
		}

	}

	static void sort(int[] elements, int l, int h) {
		if (elements.length > 1) {
			int pivot = pivot(elements, l, h);
			sort(elements, l, pivot - 1);
			sort(elements, pivot + 1, h);
		}
	}

	static int pivot(int[] elements, int l, int h) {
		int pivot = (l + h) / 2;
		int i = l;
		int j = h;
		while (i < j) {
			do {
				i++;
			} while (elements[i] >= elements[pivot]);

			do {
				j--;
			} while (elements[j] < elements[pivot]);

			if (i < j) {
				swap(elements, elements[i], elements[j]);
			}
		}
		swap(elements, elements[pivot], elements[j]);
		return j;
	}

	private static void swap(int[] elements, int i, int j) {
		int tmp = elements[i];
		elements[i] = elements[j];
		elements[j] = tmp;
	}

}
