import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    // Function to find the minimum number of stacks needed for a given container schedule
    public static int minimumStacks(String containerSchedule) {
        List<List<Character>> stacks = new ArrayList<>();

        for (char container : containerSchedule.toCharArray()) {
            boolean placed = false;
            for (List<Character> stack : stacks) {
                if (stack.get(stack.size() - 1) >= container) {
                    stack.add(container);
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                List<Character> newStack = new ArrayList<>();
                newStack.add(container);
                stacks.add(newStack);
            }
        }

        return stacks.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // Ignore the newline after the number

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            String containerSchedule = scanner.nextLine();
            results.add(minimumStacks(containerSchedule));
        }

        for (int result : results) {
            System.out.println(result);
        }

        scanner.close();
    }
}
