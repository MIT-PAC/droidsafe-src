package com.android.internal.telephony.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface IsimRecords {

    
    String getIsimImpi();

    
    String getIsimDomain();

    
    String[] getIsimImpu();
}

