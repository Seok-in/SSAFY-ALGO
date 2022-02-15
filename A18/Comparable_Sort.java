package Comparable과Comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Comparable_Sort {
	public static void main(String[] args) {
		Soldier[] arr = new Soldier[3];
		
		arr[0] = new Soldier(2017, 26);
		arr[1] = new Soldier(2018, 28);
		arr[2] = new Soldier(2016, 24);
		
		System.out.println("정렬 전 : ");
		for(int i=0; i<3; i++) {
			System.out.print(arr[i].입대년 + " " + arr[i].나이 + "\n");
		}
		
		Arrays.sort(arr);
		System.out.println("정렬 후 : ");
		for(int i=0; i<3; i++) {
			System.out.print(arr[i].입대년 + " " + arr[i].나이 + "\n");
		}
	}
}

class Soldier implements Comparable<Soldier>{
	int 입대년;
	int 나이;
	Soldier(){};
	Soldier(int 입대년, int 나이){
		this.입대년 = 입대년;
		this.나이 = 나이;
	}
	@Override
	public int compareTo(Soldier s) {
		// TODO Auto-generated method stub
		return -(this.입대년-s.입대년);
	}
}
