import java.util.Stack;

public class TextOperation {
    public enum Type {
        ADD,
        DELETE
    }

    private Type type;
    private char character;

    public TextOperation(Type type, char character) {
        this.type = type;
        this.character = character;
    }

    // Getters
    public Type getType() {
        return type;
    }

    public char getCharacter() {
        return character;
    }

    // Required methods for application

    // addText to push text to top of stack
    public static TextOperation addText(char inputText, Stack<Character> textStack) {
        textStack.push(inputText);
        return new TextOperation(Type.ADD, inputText);
    }

    // deleteText to pop most recently added text, returning the value and discarding
    public static TextOperation deleteText(Stack<Character> textStack) {
        if (textStack.isEmpty()) {
            System.out.println("Nothing in the stack to perform DELETION upon.");
            return null;
        }
        char deletedChar = textStack.pop();
        return new TextOperation(Type.DELETE, deletedChar);
    }

    // undo
    public static Stack<TextOperation> undo(Stack<TextOperation> operationStack, Stack<Character> textStack) {
        // Empty stack catch
        if (operationStack.isEmpty()) {
            System.out.println("Nothing in the stack to perform UNDO upon.");
            return operationStack;
        }

        /* This portion of the code will evaluate whether the last operation was an add or delete,
            and will undo the result of which type it was, reverting back to before the action */
        TextOperation recentOp = operationStack.pop();
        if (recentOp.getType() == Type.ADD) {
            if (!textStack.isEmpty()) {
                textStack.pop();
            }
        } else if (recentOp.getType() == Type.DELETE) {
            textStack.push(recentOp.getCharacter());
        }
        return operationStack;
    }

    // display shows the state of where the text stack is as a whole
    public static void display(Stack<Character> textStack) {
        for (char charIndex : textStack) {      // for-each to iterate through the stack
            System.out.print(charIndex);
        }
        System.out.println();
    }
}