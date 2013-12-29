package com.android.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Message;

public interface IState {

    
    static final boolean HANDLED = true;

    
    static final boolean NOT_HANDLED = false;

    
    void enter();

    
    void exit();

    
    boolean processMessage(Message msg);

    
    String getName();
}
