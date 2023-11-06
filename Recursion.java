import java.util.ArrayList;
import java.util.List;

public class Recursion {

    public static void main(String[] args) {

        System.out.println(firstRecursion(2,4));
        System.out.println(secondRecursion(253));

        List<String> list = new ArrayList<>();
        list.add("Духовной жаждою томим,");
        list.add("В пустыне мрачной я влачился,");
        list.add("И шестикрылый серафим");
        list.add("На перепутье мне явился.");

        System.out.println(thirdRecursion((ArrayList<String>) list));
        System.out.println(fourthRecursion("DOVOD"));

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
