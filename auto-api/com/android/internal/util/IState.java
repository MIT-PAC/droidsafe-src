package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
