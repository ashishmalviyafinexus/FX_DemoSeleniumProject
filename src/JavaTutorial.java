
import java.util.Scanner;

public class JavaTutorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the percentage: ");
        double percentage = scanner.nextDouble();

        char grade;

        if (percentage > 90) {
            grade = 'A';
        } else if (percentage > 75) {
            grade = 'B';
        } else if (percentage > 65) {
            grade = 'C';
        } else {
            grade = 'D'; 
        }
        System.out.println("The grade is: " + grade);
        scanner.close();
    }
}

