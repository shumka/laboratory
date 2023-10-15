import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Level1 {
    private StringBuilder text;
    private Deque<String> undoStack;
    private Stack<String> redoStack;
    public Level1() {
        text = new StringBuilder();
        undoStack = new ArrayDeque<>();
        redoStack = new Stack<>();
    }


    public String executeCommand(String command) {

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

    private void add(String string) {
        if(undoStack.size() == 2){
            undoStack.pollFirst();
            undoStack.addLast(text.toString());
        } else {
            undoStack.addLast(text.toString());
        }
        text.append(string);
        redoStack.clear();

    }

    private void remove(String count) {
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

    private String getCharacter(String index) {
        int idx = Integer.parseInt(index);
        if (idx < text.length()) {
            return String.valueOf(text.charAt(idx));
        }
        return "";
    }

    private void undo() {
        if (undoStack.size() == 1){
            redoStack.push(text.toString());
            text = new StringBuilder(undoStack.peek());
        }
        else{
            redoStack.push(text.toString());
            text = new StringBuilder(undoStack.pollLast());
        }
    }

    private void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.addLast(text.toString());
            text = new StringBuilder(redoStack.pop());
        }
    }
}
