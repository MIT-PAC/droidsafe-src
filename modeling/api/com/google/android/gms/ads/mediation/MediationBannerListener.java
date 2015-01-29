package com.google.android.gms.ads.mediation;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public abstract interface MediationBannerListener
{

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdLoaded(MediationBannerAdapter  r0);

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdFailedToLoad(MediationBannerAdapter  r0, int  i1);

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdOpened(MediationBannerAdapter  r0);

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdClosed(MediationBannerAdapter  r0);

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdLeftApplication(MediationBannerAdapter  r0);

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdClicked(MediationBannerAdapter  r0);
}
