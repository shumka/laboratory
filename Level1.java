import java.util.*;

public class Level1 {
    public static StringBuilder text;
    public static Stack<String> undoStack;
    public static Stack<String> redoStack;
    public static int lastCommand;

    static{
        text = new StringBuilder();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        lastCommand = 0;
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
            undoStack.clear();
            undoStack.push(text.toString());
            text.append(string);
            redoStack.clear();
        }

        if(!cleanChain) {
            undoStack.push(text.toString());
            text.append(string);
            redoStack.clear();
        }
    }

    private static void remove(String count, Boolean cleanChain) {
        int numToRemove = Integer.parseInt(count);
        lastCommand = 2;
        if(cleanChain){
            if (numToRemove >= text.length()) {
                undoStack.clear();
                undoStack.push(text.toString());
                text.setLength(0);
                redoStack.clear();
            } else {
                undoStack.clear();
                undoStack.push(text.toString());
                text.setLength(text.length() - numToRemove);
                redoStack.clear();
            }
        }
        if(!cleanChain){
            if (numToRemove >= text.length()) {
                undoStack.push(text.toString());
                text.setLength(0);
                redoStack.clear();
            } else {
                undoStack.push(text.toString());
                text.setLength(text.length() - numToRemove);
                redoStack.clear();
            }
        }
    }
    public static String getCharacter(String index) {
        lastCommand = 3;
        int idx = Integer.parseInt(index);
        if (idx < text.length()) {
            undoStack.push(String.valueOf(text.charAt(idx)));
            return String.valueOf(text.charAt(idx));
        }
        return "";
    }

    public static void undo() {
        lastCommand = 4;
        if (undoStack.size() == 1){
            redoStack.push(text.toString());
            text = new StringBuilder(undoStack.peek());
        } else {
            redoStack.push(text.toString());
            text = new StringBuilder(undoStack.pop());
        }
    }

    public static void redo() {
        lastCommand = 5;
        if (redoStack.size() == 1){
            undoStack.push(text.toString());
            text = new StringBuilder(redoStack.peek());
            if(Objects.equals(redoStack.peek(), undoStack.peek())){
                undoStack.pop();
            }
        } else {
            undoStack.push(text.toString());
            text = new StringBuilder(redoStack.pop());
            if(Objects.equals(redoStack.peek(), undoStack.peek())){
                undoStack.pop();
            }
        }
    }

}
