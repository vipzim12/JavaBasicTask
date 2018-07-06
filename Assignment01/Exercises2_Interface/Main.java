package Exercises2_Interface;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhap so phan tu cua mang: ");
		int n=sc.nextInt();
		QuickSort quickSort= new QuickSort(n);
		quickSort.Sort();

	}

}
