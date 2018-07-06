package Exercises2_Interface;

import java.util.Scanner;

public class DaySo {
	Scanner sc = new Scanner(System.in);
	int arr[];

	public DaySo(int n) {
		arr = new int[n];
		Nhap(n);
		printf();
	}

	public void Nhap(int n) {
		System.out.println("Moi nhap Day so:  ");
		int temp = 0;
		int value;
		while (temp < n) {
			System.out.println("Nhap phan tu thu " + (temp + 1) + ": ");
			value = sc.nextInt();
			System.out.println("Value: "+ value);
			arr[temp] = value;
			temp++;
		}
	}

	public void printf() {
		System.out.print("Danh sach cac phan tu trong mang: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print("  " + arr[i]);
		}
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

}
