import java.util.ArrayList;
import java.util.List;

public class Recursion {

    public static void main(String[] args) {
        }
    
    public static int firstRecursion(int N, int M) {
        if(M == 1 || M == 0)
            return N;
        return N * firstRecursion(N, M-1);
    }

    public static int secondRecursion(int N) {
        if(N == 0)
            return N;
        return N % 10 + secondRecursion(N / 10);
    }

    public static int thirdRecursion(ArrayList<String> list) {
        if(list.isEmpty())
            return 0;
        list.remove(0);
        return 1 + thirdRecursion(list);
    }

    public static boolean fourthRecursion(String palindrome) {
        return fourthRecursion(palindrome, 0, palindrome.length() - 1);
    }
    
    private static boolean fourthRecursion(String palindrome, int start, int end) {
        if (start >= end)
            return true;
        if (palindrome.charAt(start) != palindrome.charAt(end))
            return false;
        return fourthRecursion(palindrome, start + 1, end - 1);
    }

    public static void fiveRecursion(List<Integer> list){
        fiveRecursion(list, 0);
    }
    private static void fiveRecursion(List<Integer> list, int index) {
        if (index == list.size()) {
            return;
        }
        if (list.get(index) % 2 == 0) {
            System.out.println(list.get(index));
        }
        fiveRecursion(list, index + 1);
    }
    
    public static void sixRecursion(List<Integer> list){
        sixRecursion(list, 0);
    }
    private static void sixRecursion(List<Integer> list, int index) {
        if (index >= list.size()) {
            return;
        }
        System.out.println(list.get(index));
        sixRecursion(list, index + 2);
    }

}
