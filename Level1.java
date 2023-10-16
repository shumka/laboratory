public class Level1 {
    
    public static String BiggerGreater(String input) {
        char[] magicWord = input.toCharArray();
        int N = magicWord.length;
        int i = N - 2;
        while(i >= 0 && magicWord[i] >= magicWord[i+1]){
            i--;
        }

        if (i == -1){
            return "";
        }
        
        int j = N - 1;

        while (magicWord[j] <= magicWord[i]) {
            j--;
        }

        char temp = magicWord[i];
        magicWord[i] = magicWord[j];
        magicWord[j] = temp;

        
        int left = i + 1;
        int right = N - 1;

        while (left < right) {
            temp = magicWord[left];
            magicWord[left] = magicWord[right];
            magicWord[right] = temp;
            left++;
            right--;
        }
        return new String(magicWord);
    }
}
