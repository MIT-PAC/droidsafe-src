package com.android.internal.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.KeyEvent;
import android.view.InputQueue;
import android.view.MotionEvent;
import android.view.InputHandler;
public abstract class BaseInputHandler implements InputHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.277 -0400", hash_original_method = "522A2E7328698FD3DE180C07E34FA985", hash_generated_method = "522A2E7328698FD3DE180C07E34FA985")
    public BaseInputHandler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.278 -0400", hash_original_method = "6AA5D575C860B25855F95BD4232B08A1", hash_generated_method = "C9A5A38DD61D951AD01AC7B418DC250C")
    public void handleKey(KeyEvent event, InputQueue.FinishedCallback finishedCallback) {
        addTaint(finishedCallback.getTaint());
        addTaint(event.getTaint());
finishedCallback.finished(false)
        // ---------- Original Method ----------
        //finishedCallback.finished(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.279 -0400", hash_original_method = "35439058E3C8BD19C89BD91A4DC0F7D4", hash_generated_method = "1A2B94AB09F3CA7B8B2BE1F84BE52653")
    public void handleMotion(MotionEvent event, InputQueue.FinishedCallback finishedCallback) {
        addTaint(finishedCallback.getTaint());
        addTaint(event.getTaint());
finishedCallback.finished(false)
        // ---------- Original Method ----------
        //finishedCallback.finished(false);
    }

    
}

