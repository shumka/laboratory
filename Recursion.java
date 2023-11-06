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
        if(palindrome.length() <= 1)
            return true;
        if(palindrome.charAt(0) != palindrome.charAt(palindrome.length()-1))
            return false;
        return fourthRecursion(palindrome.substring(1,palindrome.length()-1));
    }

}
