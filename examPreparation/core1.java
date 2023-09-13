package AlgorithmsPreparation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class core1 {

    static boolean [] visited;
    static int[] numbers;
    static int [] expression ;
    static int counter;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        numbers = IntStream.rangeClosed(1, n).toArray();

        visited = new boolean[n];
        expression = new int[n];



        variations(n,0);

        System.out.println(sb.toString().trim());
        System.out.println("Total solutions: " + counter);

    }

    private static void variations(int n, int index) {
        if(index >= n){
            printSolution();
            return;
        }

        expression[index] = numbers[index];

        variations(n, index + 1);

        expression[index] = -numbers[index];
        variations(n,index + 1);

    }

    private static void printSolution() {
        int sum = Arrays.stream(expression).sum();
       
        if(sum == 0){
            counter++;
            for (int number : expression) {
                String formattedNum = number > 0 ? "+" + number : String.valueOf(number);
                sb.append(formattedNum).append(" ");
            }
            sb.append(System.lineSeparator());
        }
    }


}
