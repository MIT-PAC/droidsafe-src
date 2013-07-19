package com.android.internal.util;

// Droidsafe Imports
import android.os.Message;

public interface IState {

    
    static final boolean HANDLED = true;

    
    static final boolean NOT_HANDLED = false;

    
    void enter();

    
    void exit();

    
    boolean processMessage(Message msg);

    
    String getName();
}
