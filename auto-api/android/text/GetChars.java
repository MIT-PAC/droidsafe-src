package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface GetChars
extends CharSequence
{
    
    public void getChars(int start, int end, char[] dest, int destoff);
}
