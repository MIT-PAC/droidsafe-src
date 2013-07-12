package android.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface GetChars
extends CharSequence
{
    
    public void getChars(int start, int end, char[] dest, int destoff);
}
