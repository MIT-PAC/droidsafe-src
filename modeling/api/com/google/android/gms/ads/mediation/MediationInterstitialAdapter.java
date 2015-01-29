package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import droidsafe.annotations.*;
import droidsafe.helpers.DSUtils;

/*
 * NN: We made a few changes.  Make this object concrete rather than abstract as in API
 * This class is meant to be subclassed by external ad provider
 * And will be added to the runtime via: com.google.android.gms.ads.AdRequest$Builder
 */
public abstract class MediationInterstitialAdapter implements MediationAdapter {


	protected MediationInterstitialAdapter() {
		onPause();
		onResume();
		onDestroy();
	}
	
	//NN: Not sure what we can do with it.  It is originally abstract and "user" will need to
	//provide this meaning that this method is won't be called at all.
	public void requestInterstitialAd(Context context, MediationInterstitialListener listener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle mediationExtras) {

		addTaint(context.getTaint());
		addTaint(serverParameters.getBoolean(DSUtils.FAKE_STRING));
		addTaint(mediationAdRequest.hashCode());
		addTaint(mediationExtras.getBoolean(DSUtils.FAKE_STRING));

		if (listener != null) {
			listener.onAdClicked(this);
			listener.onAdLoaded(this);
			listener.onAdClosed(this);
			listener.onAdOpened(this);
			listener.onAdFailedToLoad(this, getTaintInt());
			listener.onAdLeftApplication(this);
		}
	}

	public abstract void showInterstitial();

	@DSSafe(DSCat.ANDROID_CALLBACK)
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		
	}

	@DSSafe(DSCat.ANDROID_CALLBACK)
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		
	}

	@DSSafe(DSCat.ANDROID_CALLBACK)
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		
	}
}
