package com.android.internal.telephony.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface SimulatedRadioControl
{
    public void triggerRing(String number);

    public void progressConnectingCallState();

    public void progressConnectingToActive();

    public void setAutoProgressConnectingCall(boolean b);

    public void setNextDialFailImmediately(boolean b);

    public void setNextCallFailCause(int gsmCause);

    public void triggerHangupForeground();

    public void triggerHangupBackground();

    public void triggerHangupAll();

    public void triggerIncomingSMS(String message);

    public void shutdown();

    
    public void pauseResponses();

    
    public void resumeResponses();

    public void triggerSsn(int type, int code);

    
    public void triggerIncomingUssd(String statusCode, String message);
}
