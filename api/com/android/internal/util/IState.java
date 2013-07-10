package com.android.internal.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Message;

public interface IState {

    
    static final boolean HANDLED = true;

    
    static final boolean NOT_HANDLED = false;

    
    void enter();

    
    void exit();

    
    boolean processMessage(Message msg);

    
    String getName();
}
