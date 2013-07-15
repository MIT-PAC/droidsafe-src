package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

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
