package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface PhoneNotifier {

    public void notifyPhoneState(Phone sender);

    public void notifyServiceState(Phone sender);

    public void notifyCellLocation(Phone sender);

    public void notifySignalStrength(Phone sender);

    public void notifyMessageWaitingChanged(Phone sender);

    public void notifyCallForwardingChanged(Phone sender);

    
    public void notifyDataConnection(Phone sender, String reason, String apnType,
            Phone.DataState state);

    public void notifyDataConnectionFailed(Phone sender, String reason, String apnType);

    public void notifyDataActivity(Phone sender);

    public void notifyOtaspChanged(Phone sender, int otaspMode);
}
