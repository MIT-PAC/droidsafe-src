package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface GetChars
extends CharSequence
{
    
    public void getChars(int start, int end, char[] dest, int destoff);
}

