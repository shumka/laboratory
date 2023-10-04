import java.util.ArrayList;

public class Level1 {
    public static int [] WordSearch(int len, String s, String subs){
        s = s.toLowerCase();
        subs = subs.toLowerCase();
        String[] subStrDirty;
        ArrayList<String> subStrClean = new ArrayList<String>();
        subStrDirty = s.split(" ");
        for(int i = 0; i < subStrDirty.length-1; i++){
            if( (subStrDirty[i].length() + subStrDirty[i+1].length()) <= len ){
                subStrClean.add(subStrDirty[i] + " " + subStrDirty[i+1]);
                if(i == subStrDirty.length - 3){
                    subStrClean.add(subStrDirty[i+2]);
                } else {
                    i++;
                }
            } else {
                subStrClean.add(subStrDirty[i]);
            }
        }
        int[] result = new int[subStrClean.size()-1];
        for(int i = 0; i < subStrClean.size()-1; i++){
            if(subStrClean.get(i).matches(".*\\b" + subs + "\\b.*")){
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

}
