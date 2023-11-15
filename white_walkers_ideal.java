public static boolean white_walkers_ideal(String village) {
        int dig = 0;
        int wnum = 0;
        boolean has10 = false;

        for (char ch : village.toCharArray()) {
            if(Character.isDigit(ch)){
                if(Character.getNumericValue(ch) + dig == 10) {
                    if(wnum != 3){
                        return false;
                    } else {
                        has10 = true;
                    }
                }
                dig = Character.getNumericValue(ch);
                wnum = 0;
            } else if (ch == '='){
                wnum += 1;
            }
        }

        return has10;

    }
