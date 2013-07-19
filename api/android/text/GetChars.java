package android.text;

// Droidsafe Imports

public interface GetChars
extends CharSequence
{
    
    public void getChars(int start, int end, char[] dest, int destoff);
}
