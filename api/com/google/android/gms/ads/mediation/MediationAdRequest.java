package com.google.android.gms.ads.mediation;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Date;
import java.util.Set;

public abstract interface MediationAdRequest
{
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;

    public abstract java.util.Date getBirthday();

    public abstract int getGender();

    public abstract java.util.Set getKeywords();

    public abstract int taggedForChildDirectedTreatment();

    public abstract boolean isTesting();
}
