package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class EriInfo {
    public int mRoamingIndicator;
    public int mIconIndex;
    public int mIconMode;
    public String mEriText;
    public int mCallPromptId;
    public int mAlertId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.774 -0400", hash_original_method = "523A7CAAB1F3203BD5E6C41D254336C4", hash_generated_method = "E42E3A988753D5D00C3416D0EC4E64E2")
    @DSModeled(DSC.SAFE)
    public EriInfo(int roamingIndicator, int iconIndex, int iconMode, String eriText,
            int callPromptId, int alertId) {
        dsTaint.addTaint(alertId);
        dsTaint.addTaint(iconMode);
        dsTaint.addTaint(eriText);
        dsTaint.addTaint(iconIndex);
        dsTaint.addTaint(callPromptId);
        dsTaint.addTaint(roamingIndicator);
        // ---------- Original Method ----------
        //this.mRoamingIndicator = roamingIndicator;
        //this.mIconIndex = iconIndex;
        //this.mIconMode = iconMode;
        //this.mEriText = eriText;
        //this.mCallPromptId = callPromptId;
        //this.mAlertId = alertId;
    }

    
    public static final int ROAMING_INDICATOR_ON    = 0;
    public static final int ROAMING_INDICATOR_OFF   = 1;
    public static final int ROAMING_INDICATOR_FLASH = 2;
    public static final int ROAMING_ICON_MODE_NORMAL    = 0;
    public static final int ROAMING_ICON_MODE_FLASH     = 1;
}

