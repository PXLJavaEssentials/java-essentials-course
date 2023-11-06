package be.pxl.h1.debug;

public class BugApp {

    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 10};

        for (int i = 0; i < numbers.length; i++) {
            if (isEven(i)) {
                System.out.println(numbers[i] + " is even.");
            } else {
                System.out.println(numbers[i] + " is odd.");  // Bug: This line incorrectly identifies even numbers as odd.
            }
        }
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

}
