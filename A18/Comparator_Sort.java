package Comparable과Comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Comparator_Sort {
	public static void main(String[] args) {
		Soldier2[] arr = new Soldier2[3];
		
		Soldier2 s3 = new Soldier2();
		
		
		arr[0] = new Soldier2(2017, 26);
		arr[1] = new Soldier2(2018, 28);
		arr[2] = new Soldier2(2016, 24);
		
		System.out.println("정렬 전 : ");
		for(int i=0; i<3; i++) {
			System.out.print(arr[i].입대년 + " " + arr[i].나이 + "\n");
		}
		
		Arrays.sort(arr, s3);
		
		System.out.println("정렬 후 : ");
		for(int i=0; i<3; i++) {
			System.out.print(arr[i].입대년 + " " + arr[i].나이 + "\n");
		}
	}
}

class Soldier2 implements Comparator<Soldier2>{
	int 입대년;
	int 나이;
	Soldier2(){};
	Soldier2(int 입대년, int 나이){
		this.입대년 = 입대년;
		this.나이 = 나이;
	}
	@Override
	public int compare(Soldier2 o1, Soldier2 o2) {
		// TODO Auto-generated method stub
		return o1.나이 - o2.나이;
	}
}
