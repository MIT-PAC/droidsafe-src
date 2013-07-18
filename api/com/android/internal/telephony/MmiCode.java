package com.android.internal.telephony;

// Droidsafe Imports

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
