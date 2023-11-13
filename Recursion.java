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

    public static int sevenRecursion(int[] arr) {
        return sevenRecursion(arr, arr.length, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private static int sevenRecursion(int[] arr, int n, int max, int secondMax) {
        if (n == 0) {
            return secondMax;
        }

        if (arr[n-1] > max) {
            secondMax = max;
            max = arr[n-1];
        } else if (arr[n-1] > secondMax && arr[n-1] < max) {
            secondMax = arr[n-1];
        }

        return sevenRecursion(arr, n-1, max, secondMax);
    }

    public static List<String> eightRecursion(String directoryPath) {
        List<String> fileList = new ArrayList<>();
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileList.add(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    fileList.addAll(eightRecursion(file.getAbsolutePath()));
                }
            }
        }
        return fileList;
    }


    public static List<String> hardRecursion(int n) {
        List<String> result = new ArrayList<>();
        generateHard(result, "", n, n);
        return result;
    }

    public static void generateHard(List<String> result, String s, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }

        if (left > 0) {
            generateHard(result, s + "(", left - 1, right);
        }

        if (right > left) {
            generateHard(result, s + ")", left, right - 1);
        }
    }
    
    
}
