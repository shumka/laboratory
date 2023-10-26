import static java.lang.Character.getNumericValue;

public class Level1 {
    public static boolean white_walkers(String village) {
        int walkerCount = 0;
        boolean flag = false;

        for (int i = 0; i < village.length(); i++){
            if(Character.isDigit(village.charAt(i)) && i != village.length() ){
                for(int j = i+1; j < village.length(); j++){
                    if(Character.isDigit(village.charAt(j))  &&
                            ( getNumericValue(village.charAt(i)) + getNumericValue(village.charAt(j))  == 10)){
                        for(int x=i,y=j; x < y; x++ ){
                            if(village.charAt(x) == '=') {
                                walkerCount += 1;
                            }
                        }
                        if(walkerCount >= 3){
                            flag = true;
                        } else {
                            flag = false;
                        }
                        walkerCount = 0;
                    }
                }
            }
        }

        return flag;
    }
}
