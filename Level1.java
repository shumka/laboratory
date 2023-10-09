public class Level1 {
    public static String BigMinus(String s1, String s2) {
        s1 = removeLeadingZeroes(s1);
        s2 = removeLeadingZeroes(s2);

        if (s1.isEmpty()) {
            return s2;
        } else if (s2.isEmpty()) {
            return s1;
        }

        if (s1.length() < s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        if (s1.length() == s2.length()){
            for (int i = 0; i < s1.length(); i++){
                if(Character.getNumericValue(s2.charAt(i)) > Character.getNumericValue(s1.charAt(i))){
                    String temp = s1;
                    s1 = s2;
                    s2 = temp;
                    break;
                }
            }
        }

        int maxLength = Math.max(s1.length(), s2.length());
        s1 = padZeros(s1, maxLength);
        s2 = padZeros(s2, maxLength);

        StringBuilder result = new StringBuilder();
        int carry = 0;

        for (int i = maxLength - 1; i >= 0; i--) {
            int digit1 = Character.getNumericValue(s1.charAt(i));
            int digit2 = Character.getNumericValue(s2.charAt(i));
            int diff;
            if (digit1 >= digit2) {
                diff = digit1 - digit2 - carry;
                carry = 0;
            } else {
                diff = 10 + digit1 - digit2 - carry;
                carry = 1;
            }

            result.insert(0, diff);

        }

        String result_final = removeLeadingZeroes(result.toString());
        return result.toString();
    }

    public static String removeLeadingZeroes(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static String padZeros(String number, int length) {
        StringBuilder paddedNumber = new StringBuilder(number);
        while (paddedNumber.length() < length) {
            paddedNumber.insert(0, '0');
        }
        return paddedNumber.toString();
    }


}
