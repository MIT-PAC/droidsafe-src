package com.google.android.gms.ads.mediation;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public abstract interface MediationInterstitialListener
{

   public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdLoaded(MediationInterstitialAdapter  r0);

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdFailedToLoad(MediationInterstitialAdapter  r0, int  i1);

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdOpened(MediationInterstitialAdapter  r0);

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdClosed(MediationInterstitialAdapter  r0);

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdLeftApplication(MediationInterstitialAdapter  r0);

    public abstract void onAdClicked(MediationInterstitialAdapter  r0);
}
