package com.google.android.gms.ads.mediation;


import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public abstract interface MediationBannerListener
{

    public abstract void onAdLoaded(MediationBannerAdapter  r0);

    public abstract void onAdFailedToLoad(MediationBannerAdapter  r0, int  i1);

    public abstract void onAdOpened(MediationBannerAdapter  r0);

    public abstract void onAdClosed(MediationBannerAdapter  r0);

    public abstract void onAdLeftApplication(MediationBannerAdapter  r0);

    public abstract void onAdClicked(MediationBannerAdapter  r0);
}
