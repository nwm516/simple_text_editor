import org.w3c.dom.Text;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Character> charStack = new Stack<>();
        Stack<TextOperation> operationStack = new Stack<>();

        // Adding text to the stack
        operationStack.push(TextOperation.addText('S', charStack));
        operationStack.push(TextOperation.addText('u', charStack));
        operationStack.push(TextOperation.addText('p', charStack));
        operationStack.push(TextOperation.addText('e', charStack));
        operationStack.push(TextOperation.addText('r', charStack));
        operationStack.push(TextOperation.addText('b', charStack));

        // Display after add
        TextOperation.display(charStack);

        // Delete
        TextOperation deleteOperation = TextOperation.deleteText(charStack);
        if (deleteOperation != null) {
            operationStack.push(deleteOperation);
        } else {
            throw new IllegalStateException("Unexpected error: deleteOperation is null");   // Additional error handling
        }

        // Display after deletion
        TextOperation.display(charStack);

        // Undo
        operationStack = TextOperation.undo(operationStack, charStack);

        // Display after undo
        TextOperation.display(charStack);
    }
}