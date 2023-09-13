package AlgorithmsPreparation;

import java.util.*;

public class core2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int [] first = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int [] second = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();



        int [] memory = new int[first.length + 1];

        memory[0] = 0;
        memory[1] = first[0];

        for (int i = 2; i <= first.length ; i++) {
            int firstNum = memory[i - 1] + first[i - 1];
            int secondNum = memory[i - 2] + second[i - 2];
            memory[i] = Math.min(firstNum,secondNum);
        }

        System.out.println("Optimal Time: " + memory[memory.length - 1]);
        int index = memory.length - 1;
        List<String> save = new ArrayList<>();

        while (index > 0){
            String line;
            if(memory[index - 1] + first[index - 1] == memory[index]){
                line = "Single " + index;
                index--;
            }else{
                line = "Pair of " + (index - 1) + " and " + index;
                index-=2;
            }
            save.add(line);
        }

        Collections.reverse(save);
        save.forEach(e -> System.out.println(e));

    }
}
