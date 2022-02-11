package Comparable과Comparator;

import java.util.Comparator;
// comparable 사용할때
//public class Person implements Comparable<Person>{
//	int height;
//	int weight;
//	Person(){}
//	Person(int height, int weight){
//		this.height = height;
//		this.weight = weight;
//	}
//	
//	@Override
//	public int compareTo(Person p) {
//		// TODO Auto-generated method stub
//		// 몸무게를 기준으로!!
////		if(this.weight > p.weight) {
////			return 1;
////		}
////		else if(this.weight == p.weight) {
////			return 0;
////		}
////		else {
////			return -1;
////		}
//		// 이렇게 해도된다.(하지만 overflow, underflow조심해야함)
//		return (this.weight - p.weight);
//	}
//	
//}

// comparator 사용할때
//public class Person implements Comparator<Person>{
//	int height;
//	int weight;
//	Person(){}
//	Person(int height, int weight){
//		this.height = height;
//		this.weight = weight;
//	}
//	@Override
//	public int compare(Person p1, Person p2) {
//		// TODO Auto-generated method stub
//		// 몸무게를 기준으로!!
////		if(p1.weight > p2.weight) {
////			return 1;
////		}
////		else if(p1.weight == p2.weight) {
////			return 0;
////		}
////		else {
////			return -1;
////		}
//		// 이렇게 해도된다.(하지만 overflow, underflow조심해야함)
//		return (p1.weight - p2.weight);
//	}
//}

// comparator + 익명객체 사용할때
public class Person{
	int height;
	int weight;
	Person(){}
	Person(int height, int weight){
		this.height = height;
		this.weight = weight;
	}
}
