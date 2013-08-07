package android.text;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface GetChars
extends CharSequence
{
    
    public void getChars(int start, int end, char[] dest, int destoff);
}
