package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface MmiCode
{
	
    public enum State {
        PENDING,
        CANCELLED,
        COMPLETE,
        FAILED
    }


    
    public State getState();

    

    public CharSequence getMessage();

    
    public void cancel();

    
    public boolean isUssdRequest();

    
    public boolean isCancelable();
}
