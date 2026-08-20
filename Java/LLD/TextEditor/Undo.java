package LLD.TextEditor;

import java.util.Stack;

public class Undo
{

    Stack<String> undo;
    private static Undo instance;
    Undo
    {
        undo = new Stack<>();
    }
    public Undo getInstance()
    {
        if(instance == null)
        {
            instance = new Undo();
        }
        return instance;
    }

    public String getUndo(String text)
    {
        return undo.pop();

    }
    public void setUndo(String text)
    {
        undo.push(text);
    }
    public void clearUndo()
    {
        undo.clear();
    }
}