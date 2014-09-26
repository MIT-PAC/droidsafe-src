package com.google.ads.mediation;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Activity;

public abstract interface MediationInterstitialAdapter extends com.google.ads.mediation.MediationAdapter
{

    public abstract void requestInterstitialAd(com.google.ads.mediation.MediationInterstitialListener  r0, android.app.Activity  r1, com.google.ads.mediation.MediationServerParameters  r2, com.google.ads.mediation.MediationAdRequest  r3, com.google.ads.mediation.NetworkExtras  r4);

    public abstract void showInterstitial();
}
