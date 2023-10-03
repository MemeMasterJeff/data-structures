import java.util.Stack;

/**
 * This program simulates an undo stack. Note that operations
 * must be undone in the opposite order in which they are first
 * issued.
*/
public class StackDemo
{
    public static void main(String[] args) {
        Stack<String> commands = new Stack<>();

        // push commands onto the top of the stack, simulates undo function in this case
        commands.push("insert: 'hello'");
        commands.push("insert ','");
        commands.push("insert ' '");
        commands.push("insert 'world'");
        commands.push("insert '?");
        commands.push("delete '?'");
        commands.push("insert: '!'");

        //print the stack; the top of the stack is on the far right
        System.out.println(commands);

        //simulate the user pressing the undo button 4 times;
        for(int i = 0; i<4;i++){
            String command = commands.pop();
            System.out.println(command);
        }

    }
}
