public class Stack {

    private static int stack[];
    private static int TOP;

    Stack(int capacity) {
        stack = new int[capacity];
        TOP = 0;
    }

    public void push(int data) {
        // [ ... ] data ->
        if (TOP > stack.length - 1) {
            System.out.println("PROBLEM! Needs resizing");
            return;
        } else {
            stack[TOP] = data;
            TOP++;
        }
    }

    public int pop() {
        if (TOP == 0) {
            return -1;
        }
        int data = stack[--TOP];
        return data;
    }

    public int peek() {
        if (TOP == 0) {
            return -1;
        }
        return stack[TOP - 1];
    }

    public boolean empty() {
        return TOP == 0;
    }

    public void printStack() {
        if (empty()) {
            System.out.println("Stack is empty!");
        } else {
            for (int i = 0; i < TOP; i++) {
                System.out.print(stack[i] + "" + (i == TOP - 1 ? "" : " | "));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        stack.printStack();
        for(int i = 1; i <= 4; i++) {
            stack.pop();
            stack.printStack();
        }

        System.out.println("PEEK returned: " + stack.peek());

        for(int i = 1; i <= 6; i++) {
            stack.pop();
            stack.printStack();
        }
        
        stack.push(15);
        stack.push(25);
        stack.printStack();
        stack.pop();
        stack.printStack();
    }
}
