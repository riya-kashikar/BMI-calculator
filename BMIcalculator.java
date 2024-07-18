import java.util.Scanner;

public class BMIcalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your weight in kg: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your height (feet part): ");
        int feet = scanner.nextInt();

        System.out.print("Enter your height (inches part): ");
        int inches = scanner.nextInt();

        double heightInMeters = convertMeters(feet, inches);

        double bmi = calculateBMI(weight, heightInMeters);

        System.out.printf("Your BMI is: %.2f%n", bmi);
        displayBMI(bmi);

        double idealWeightMin = calculateIdealWeightMin(heightInMeters);
        double idealWeightMax = calculateIdealWeightMax(heightInMeters);

        System.out.printf("Your ideal weight range is: %.2f kg - %.2f kg%n", idealWeightMin, idealWeightMax);

        scanner.close();
    }

    public static double convertMeters(int feet, int inches) {
        int totalInches = (feet * 12) + inches;
        return totalInches * 0.0254;
    }

    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    public static void displayBMI(double bmi) {
        if (bmi < 18.5) {
            System.out.println("You are underweight.");
        } else if (bmi < 24.9) {
            System.out.println("You have a normal weight.");
        } else if (bmi < 29.9) {
            System.out.println("You are overweight.");
        } else {
            System.out.println("You are obese.");
        }
    }

    public static double calculateIdealWeightMin(double height) {
        return 18.5 * height * height;
    }

    public static double calculateIdealWeightMax(double height) {
        return 24.9 * height * height;
    }
}
