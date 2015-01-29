package com.google.android.gms.ads;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;

public final class InterstitialAd
{
	AdListener adListener;
	String adUnitId;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.138 -0400", hash_original_method = "6D519A44E0533E4F94247FEF0CAA8F6F", hash_generated_method = "072A7307B44600C81BB6893FD1A025FB")
    
public InterstitialAd(Context  r1)
    {

        //ky = new av(r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.143 -0400", hash_original_method = "FD37459560A816182EA66EC4FD4D0C0A", hash_generated_method = "C9CC651A5727FC8AFFBFAD85E87F1161")
    
public AdListener getAdListener()
    {

    	return adListener;

        //return ky.getAdListener();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.148 -0400", hash_original_method = "06AE35DA91F214DEC81B48017A83CE75", hash_generated_method = "8B93C86FE40BEE7D426BF2EEC0875A2C")
    
public String getAdUnitId()
    {
    	return adUnitId;
    }

   /* @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.153 -0400", hash_original_method = "943F68A27D1383EB5638D379439DF7CA", hash_generated_method = "5A6782AAA71CE7F5B31B3D415A209CAC")
    
public InAppPurchaseListener getInAppPurchaseListener()
    {

        return ky.getInAppPurchaseListener();
    }
*/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.158 -0400", hash_original_method = "530BDFE7FFB78CC0B9BA91E44ED95386", hash_generated_method = "7CDD871A0F8A57890F3525F9992964A1")
    
public boolean isLoaded()
    {
    	return getTaintBoolean();
        //return ky.isLoaded();
    }

    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.165 -0400", hash_original_method = "A024AF37F16114A4D59341F9EE6389EF", hash_generated_method = "9E65B26237AB451A4D0B0983A9F9FF4C")
    
public void loadAd(AdRequest  r1)
    {
        //ky.a(r1.T());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.171 -0400", hash_original_method = "03FE424D1432AA991654B0DE1742660D", hash_generated_method = "CC406837AB22081E9D94A1EFDB729C3C")
    
public void setAdListener(AdListener  r1)
    {
    	adListener = r1;
    	adListener.onAdOpened();

    	if (DroidSafeAndroidRuntime.control)
    		adListener.onAdFailedToLoad(getTaintInt());
    	else
    		adListener.onAdLoaded();

    	adListener.onAdLeftApplication();
    	adListener.onAdClosed();

        //ky.setAdListener(r1);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.176 -0400", hash_original_method = "8A7CBCAEFE11E4EFE7C4A06388BFDBD8", hash_generated_method = "AE6A9619C950E914A9E579166DB8DC23")
    
public void setAdUnitId(String  r1)
    {
    	adUnitId = r1;
    }
    
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.193 -0400", hash_original_method = "1D9FD0BE3AAFCF88DF6EF667307F97DD", hash_generated_method = "AD125C47164700A5A8F4AE95B58FEDE2")
    
public void show()
    {
        //ky.show();
    }
}
