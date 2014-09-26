package com.google.android.gms.ads.mediation;


import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public abstract interface MediationInterstitialListener
{

   public abstract void onAdLoaded(MediationInterstitialAdapter  r0);

    public abstract void onAdFailedToLoad(MediationInterstitialAdapter  r0, int  i1);

    public abstract void onAdOpened(MediationInterstitialAdapter  r0);

    public abstract void onAdClosed(MediationInterstitialAdapter  r0);

    public abstract void onAdLeftApplication(MediationInterstitialAdapter  r0);

    public abstract void onAdClicked(MediationInterstitialAdapter  r0);
}
