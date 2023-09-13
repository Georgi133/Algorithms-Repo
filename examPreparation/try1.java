package AlgorithmsPreparation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class try1 {
    static Set<Integer> save = new HashSet<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] num = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();



        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num.length ; i++) {
            recursion2(0, num,sb,i + 1);
            save.clear();
        }

        System.out.print(sb);



    }

    private static void recursion2(int start, int[] num, StringBuilder sb, int constant) {
        if (save.size() == constant) {
            saveIt(sb);
            return;
        }

        for (int i = start; i < num.length; i++) {
            if (!save.contains(num[i])) {
                save.add(num[i]);
                recursion2(i + 1, num, sb,constant);
                save.remove(num[i]);
            }
        }

    }

    private static void saveIt(StringBuilder sb) {
        for (Integer integer : save) {
            sb.append(integer + " ");
        }
        sb.append(System.lineSeparator());
    }

}
