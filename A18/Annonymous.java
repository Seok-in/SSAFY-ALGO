package Comparable과Comparator;

public class Annonymous {
	public static void main(String[] args) {
	// TODO Auto-generated constructor stub
		Human h = new Human();
		Human anonymous = new Human() {
			@Override
			int getPower() {
				return age*2;
			}
		};
		
		System.out.println(h.getPower());
		System.out.println(anonymous.getPower());
	}
}

class Human{
	int age = 26;
	
	int getPower() {
		return age;
	}
}