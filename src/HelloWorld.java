import java.util.Scanner;

public class HelloWorld {

	static String A = "ashish malviya";

	public static void main(String[] args) {
		mycalculation();
	}

	public static void mycalculation() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your age: ");
		long age = scan.nextLong();
		//
		// if(age>18) {
		// System.out.println("Eligible for voting");
		// }
		// else if(age==18){
		// System.out.println("18 year old");
		// }
		// else
		// System.out.println("Not Eligible");
		// }
		for (int i = 3; i <= A.length(); i++) {
			System.out.println(i + " " + A);
		}
	}
}
// if the percentage is above 90, assign grade A
// if the percentage is above 75, assign grade B
// if the percentage is above 65, assign grade C
