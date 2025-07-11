import java.util.*;

public class Main
{
    public static void main(String args[])
    {        
        Stack s1 = new Stack(5);

        Stack.push(s1, 3);
        Stack.push(s1, 5);
        Stack.push(s1, 7);
        Stack.push(s1, 9);
        Stack.push(s1, 11);
        
        Stack.pop(s1);
        Stack.pop(s1);

        Stack.display(s1);
    }
};