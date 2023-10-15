import java.util.*;

public class Level1 {
    public static StringBuilder text;
    public static Deque<String> undoStack;
    public static Stack<String> redoStack;
    public Level1() {
        text = new StringBuilder();
        undoStack = new ArrayDeque<>();
        redoStack = new Stack<>();
    }


    public static String BastShoe(String command) {

        if (command.charAt(0) == '1') {
            String addParameter = command.substring(1).trim();
            add(addParameter);
        }

        if (command.charAt(0) == '2') {
            String[] parts = command.split(" ");
            String parameter = parts[1];
            remove(parameter);
        }

        if (command.charAt(0) == '3') {
            String[] parts = command.split(" ");
            String parameter = parts[1];
            return getCharacter(parameter);
        }

        if (command.charAt(0) == '4') {
            undo();
        }

        if (command.charAt(0) == '5') {
            redo();
        }

        return text.toString();
    }

    public static void add(String string) {
        if(undoStack.size() == 2){
            undoStack.pollFirst();
            undoStack.addLast(text.toString());
        } else {
            undoStack.addLast(text.toString());
        }
        text.append(string);
        redoStack.clear();

    }

    public static void remove(String count) {
        int numToRemove = Integer.parseInt(count);
        if (numToRemove >= text.length()) {
            if(undoStack.size() == 2){
                undoStack.pollFirst();
                undoStack.addLast(text.toString());
            } else {
                undoStack.addLast(text.toString());
            }
            text.setLength(0);
            redoStack.clear();
        } else {
            if(undoStack.size() == 2){
                undoStack.pollFirst();
                undoStack.addLast(text.toString());
            } else {
                undoStack.addLast(text.toString());
            }
            text.setLength(text.length() - numToRemove);
            redoStack.clear();
        }
    }

    public static String getCharacter(String index) {
        int idx = Integer.parseInt(index);
        if (idx < text.length()) {
            return String.valueOf(text.charAt(idx));
        }
        return "";
    }

    public static void undo() {
        if (undoStack.size() == 1){
            redoStack.push(text.toString());
            text = new StringBuilder(undoStack.peek());
        }
        else{
            redoStack.push(text.toString());
            text = new StringBuilder(undoStack.pollLast());
        }
    }

    public static void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.addLast(text.toString());
            text = new StringBuilder(redoStack.pop());
        }
    }
}
