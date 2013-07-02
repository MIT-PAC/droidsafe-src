package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
