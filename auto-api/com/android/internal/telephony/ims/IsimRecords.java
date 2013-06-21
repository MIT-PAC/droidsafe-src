package com.android.internal.telephony.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface IsimRecords {

    
    String getIsimImpi();

    
    String getIsimDomain();

    
    String[] getIsimImpu();
}
