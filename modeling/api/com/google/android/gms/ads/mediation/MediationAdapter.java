package com.google.android.gms.ads.mediation;


import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public abstract interface MediationAdapter
{

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onResume();
}
