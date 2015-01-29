package com.google.android.gms.ads.mediation;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Date;
import java.util.Set;
import droidsafe.annotations.*;

public abstract interface MediationAdRequest
{
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;

    public abstract @DSSource({DSSourceKind.AD})
    @DSSafe(DSCat.SAFE_OTHERS)
    java.util.Date getBirthday();

    public abstract @DSSource({DSSourceKind.AD})
    @DSSafe(DSCat.SAFE_OTHERS)
    int getGender();

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    java.util.Set getKeywords();

    public abstract int taggedForChildDirectedTreatment();

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    boolean isTesting();
}
