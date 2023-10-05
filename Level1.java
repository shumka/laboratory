import java.util.Arrays;

import static java.lang.Math.sqrt;

public static class Level1 {
    public static String TheRabbitsFoot(String s, Boolean encode) {
        String[] decodeParts = new String[0];
        if (!encode) {
            decodeParts = s.split(" ");
        }
        System.out.println(Arrays.toString(decodeParts));
        String text = s.replaceAll(" ", "");
        int N = text.length();
        int y = (int) Math.ceil(sqrt(N));
        int x = N / y;
        while (x * y < N) {
            x++;
        }
        char[][] cryptoArray = new char[x][y];

        int indexSymbol = 0;
        if (encode) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (indexSymbol < N) {
                        cryptoArray[i][j] = text.charAt(indexSymbol);
                        indexSymbol++;
                    } else {
                        cryptoArray[i][j] = ' ';
                    }
                }
            }
        } else {
            for (int i = 0; i < decodeParts.length; i++) {
                for (int j = 0; j < decodeParts[i].length(); j++){
                    cryptoArray[j][i] = decodeParts[i].charAt(j);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        if (encode) {
            // Crypt
            for (int j = 0; j < y; j++) {
                for (int i = 0; i < x; i++) {
                    if (cryptoArray[i][j] != ' ') {
                        result.append(cryptoArray[i][j]);
                    } else {
                        continue;
                    }
                }
                result.append(" ");
            }
        } else {
            // Decrypt
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (cryptoArray[i][j] != ' ') {
                        result.append(cryptoArray[i][j]);
                    }
                }
            }
        }

        return result.toString().trim();
    }

}
