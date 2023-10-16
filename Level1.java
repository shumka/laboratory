import java.util.*;

public class Level1 {
    public static StringBuilder text;
    public static ArrayList<String> textBuffer;
    public static int lastCommand;
    public static int currentIndex;
    private static boolean CanRedo;
    private static boolean CanUndo;

    static{
        text = new StringBuilder();
        textBuffer = new ArrayList<>();
        lastCommand = 0;
        currentIndex = -1;
    }
    public static String BastShoe(String command) {

        if (command.charAt(0) == '1') {
            String addParameter = command.substring(1).trim();
            add(addParameter, lastCommand == 4);
        }

        if (command.charAt(0) == '2') {
            String[] parts = command.split(" ");
            remove(parts[1], lastCommand == 4);
        }

        if (command.charAt(0) == '3') {
            String[] parts = command.split(" ");
            return getCharacter(parts[1]);
        }

        if (command.charAt(0) == '4') {
            if(textBuffer.size() != 0){
                undo();
            } else {
                return "";
            }
        }

        if (command.charAt(0) == '5') {
            if(textBuffer.size() != 0){
                redo();
            } else {
                return "";
            }
        }

        return text.toString();
    }

    private static void add(String string, Boolean cleanChain) {
        lastCommand = 1;
        if(cleanChain) {
            text.append(string);
            textBuffer.add(String.valueOf(text));

            String temp00 = textBuffer.get(currentIndex);
            String temp01 = textBuffer.get(textBuffer.size()-1);

            textBuffer.clear();
            currentIndex = 1;

            textBuffer.add(temp00);
            textBuffer.add(temp01);
        }

        if(!cleanChain) {
            currentIndex++;
            text.append(string);
            textBuffer.add(String.valueOf(text));
        }



    }

    private static void remove(String count, Boolean cleanChain) {
        int numToRemove = Integer.parseInt(count);
        lastCommand = 2;

        if(cleanChain) {

            if (numToRemove >= text.length()) {

                text.setLength(0);
                textBuffer.add(String.valueOf(text));

                String temp00 = textBuffer.get(currentIndex);
                String temp01 = textBuffer.get(textBuffer.size()-1);

                textBuffer.clear();
                currentIndex = 1;

                textBuffer.add(temp00);
                textBuffer.add(temp01);

              } else {
                text.setLength(text.length() - numToRemove);
                textBuffer.add(String.valueOf(text));

                String temp00 = textBuffer.get(currentIndex);
                String temp01 = textBuffer.get(textBuffer.size()-1);


                textBuffer.clear();
                currentIndex = 1;

                textBuffer.add(temp00);
                textBuffer.add(temp01);
            }
        }

        if(!cleanChain) {
            if (numToRemove >= text.length()) {
                text.setLength(0);
                currentIndex++;
            } else {
                text.setLength(text.length() - numToRemove);
                textBuffer.add(String.valueOf(text));
                currentIndex++;
            }
        }

    }

    public static String getCharacter(String index) {
        lastCommand = 3;
        int idx = Integer.parseInt(index);
        if (idx < text.length()) {
            return String.valueOf(text.charAt(idx));
        }
        return "";
    }

    public static void undo() {
        lastCommand = 4;

        if(currentIndex == 0) {
            text = new StringBuilder(textBuffer.get(currentIndex));
        }else{
            currentIndex--;
            text = new StringBuilder(textBuffer.get(currentIndex));
        }
    }

    public static void redo() {
        lastCommand = 5;

        if(currentIndex == textBuffer.size()-1) {
            text = new StringBuilder(textBuffer.get(currentIndex));
        }else{
            currentIndex++;
            text = new StringBuilder(textBuffer.get(currentIndex));
        }

    }

}
