package Comparable과Comparator;

import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
	// TODO Auto-generated constructor stub
		Person p1 = new Person(185, 75);
		Person p2 = new Person(163, 100);
//		// p3가 쓸모없이 메모리르 차지한다...? 필요가 없다..
//		Person p3 = new Person();
		
		// 익명객체 선언
		Comparator<Person> comp = new Comparator<Person>(){
			@Override
			public int compare(Person p1, Person p2) {
				return p1.weight - p2.weight;
			}
		};
		
//		// comparable사용
//		// 누가 더쎌까..?
//		if(p1.compareTo(p2)>0) {
//			System.out.println("p1이 더쎄다");
//		}
//		else if(p1.compareTo(p2)==0) {
//			System.out.println("둘이 똑같다.");
//		}
//		else {
//			System.out.println("p2가 더 쎄다.");
//		}
		
//		// comparator 사용
//		// 누가 더쎌까..?
//		if(p3.compare(p1, p2)>0) {
//			System.out.println("p1이 더쎄다");
//		}
//		else if(p3.compare(p1, p2)==0) {
//			System.out.println("둘이 똑같다.");
//		}
//		else {
//			System.out.println("p2가 더 쎄다.");
//		}
		
		// comparator 사용 + 익명객체
		// 누가 더쎌까..?
		if(comp.compare(p1, p2)>0) {
			System.out.println("p1이 더쎄다");
		}
		else if(comp.compare(p1, p2)==0) {
			System.out.println("둘이 똑같다.");
		}
		else {
			System.out.println("p2가 더 쎄다.");
		}
		
	}
}
