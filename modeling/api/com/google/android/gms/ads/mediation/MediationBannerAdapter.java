package com.google.android.gms.ads.mediation;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;
import android.view.View;

public abstract interface MediationBannerAdapter extends MediationAdapter
{

    public abstract void requestBannerAd(android.content.Context  r0, com.google.android.gms.ads.mediation.MediationBannerListener  r1, android.os.Bundle  r2, com.google.android.gms.ads.AdSize  r3, com.google.android.gms.ads.mediation.MediationAdRequest  r4, android.os.Bundle  r5);

    public abstract android.view.View getBannerView();
}
