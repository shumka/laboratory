import java.sql.SQLOutput;
import java.util.*;

public class Level1 {
    public static StringBuilder text;
    public static ArrayList<String> undoStack;
    public static ArrayList<String> redoStack;
    public static int lastCommand;
    public static int currentIndexUndo;
    public static int currentIndexRedo;

    static{
        text = new StringBuilder();
        undoStack = new ArrayList<>();
        redoStack = new ArrayList<>();
        lastCommand = 0;
        currentIndexUndo = -1;
        currentIndexRedo = -1;
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
            undo();
        }

        if (command.charAt(0) == '5') {
            redo();
        }

        return text.toString();
    }

    private static void add(String string, Boolean cleanChain) {
        lastCommand = 1;

        if(cleanChain){
            String temp = undoStack.get(currentIndexUndo);
            undoStack.clear();
            currentIndexUndo = 0;
            redoStack.clear();
            currentIndexRedo = 0;
            undoStack.add(temp);
            text.append(string);
        }

        if(!cleanChain){
            currentIndexUndo++;
            text.append(string);
            undoStack.add(String.valueOf(text));
        }

    }

    private static void remove(String count, Boolean cleanChain) {
        int numToRemove = Integer.parseInt(count);
        lastCommand = 2;

        if(cleanChain) {

            if (numToRemove >= text.length()) {
                String temp = undoStack.get(currentIndexUndo);
                undoStack.clear();
                currentIndexUndo = 0;
                redoStack.clear();
                currentIndexRedo = -1;
                undoStack.add(temp);

                currentIndexUndo++;
                text.setLength(0);
                undoStack.add(text.toString());
            } else {
                String temp = undoStack.get(currentIndexUndo);
                undoStack.clear();
                currentIndexUndo = 0;
                redoStack.clear();
                currentIndexRedo = -1;
                undoStack.add(temp);

                currentIndexUndo++;
                text.setLength(text.length() - numToRemove);
                undoStack.add(text.toString());
            }
        }

        if(!cleanChain) {
            if (numToRemove >= text.length()) {
                currentIndexUndo++;
                text.setLength(0);
                undoStack.add(text.toString());
            }else{
                currentIndexUndo++;
                text.setLength(text.length() - numToRemove);
                undoStack.add(text.toString());
            }
        }

    }

    public static String getCharacter(String index) {
        lastCommand = 3;
        int idx = Integer.parseInt(index);
        if (idx < text.length()) {
            currentIndexUndo++;
            undoStack.add(String.valueOf(text.charAt(idx)));
            return String.valueOf(text.charAt(idx));
        }
        return "";
    }

    public static void undo() {
        lastCommand = 4;
        if (undoStack.size() == 1){
            text = new StringBuilder(undoStack.get(currentIndexUndo));
            currentIndexRedo++;
            redoStack.add(text.toString());
        } else {
            currentIndexUndo--;
            currentIndexRedo++;
            text = new StringBuilder(undoStack.get(currentIndexUndo));
            redoStack.add(text.toString());
            undoStack.remove(currentIndexUndo);
        }
    }

    public static void redo() {
        lastCommand = 5;

        if (redoStack.size() == 1){
            text = new StringBuilder(redoStack.get(currentIndexRedo));
            currentIndexUndo++;
            undoStack.add(text.toString());
        } else {
            currentIndexUndo++;
            currentIndexRedo--;
            text = new StringBuilder(redoStack.get(currentIndexRedo));
            undoStack.add(text.toString());
            redoStack.remove(currentIndexRedo);
        }
    }

/*
    public static void main(String[] args) {

        System.out.println(BastShoe("1 Привет"));

        System.out.println(BastShoe("3 4"));

        System.out.println(BastShoe("4"));

        }
*/

    public static void main(String[] args) {
        System.out.println(BastShoe("1 Привет"));
        System.out.println(BastShoe("1  , Мир!"));
        System.out.println(BastShoe("1 ++ "));
        //System.out.println(undoStack);
        //System.out.println("Отрез 2 2");
        System.out.println(BastShoe("2 2"));

       // System.out.println(undoStack);
        System.out.println(BastShoe("4"));
       // System.out.println(undoStack);
        System.out.println(BastShoe("4"));
       // System.out.println(undoStack);
        //System.out.println("Добавление звезды");
        System.out.println(BastShoe("1 *"));
        //System.out.println(undoStack);
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("4"));

        System.out.println(BastShoe("3 6"));
        System.out.println(BastShoe("2 100"));
       System.out.println(BastShoe("1 Привет"));
       System.out.println(BastShoe("1 , Мир!"));
       System.out.println(BastShoe("1 ++"));

        //System.out.println(undoStack);
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("4"));
        System.out.println(undoStack);
        System.out.println(redoStack);

        System.out.println(BastShoe("5"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("5"));
        System.out.println(BastShoe("5"));
        System.out.println(undoStack);
        System.out.println(redoStack);
        System.out.println(BastShoe("5"));
        System.out.println(BastShoe("5"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("2 2"));

        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("5"));
        System.out.println(BastShoe("5"));
        System.out.println(BastShoe("5"));




    }


}

