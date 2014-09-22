package com.google.android.gms.ads;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.view.ViewGroup;
import android.content.Context;
import com.google.android.gms.internal.au;
import android.util.AttributeSet;
import android.view.View;

public final class AdView extends ViewGroup
{
	private AdListener adListener;
	private AdSize adSize;
	private String adId;
	
//@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.773 -0400", hash_original_field = "9BA8B29B56BBB080E0A380CBBB59B964", hash_generated_field = "C129D5DE1B19BFAD9FC01BA2ABA4B50C")

    //private  au kx;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.785 -0400", hash_original_method = "E386C48C970741838B45620D33A35906", hash_generated_method = "6ED1957F6BBF51C9308F6F6E4554DB59")
    
public AdView(Context  r1)
    {
        super(r1);

        //kx = new au(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.797 -0400", hash_original_method = "EFE8AAC202F463CB12FF8FAC054360E4", hash_generated_method = "FEFF8988BFFDC779A67121DA721A08C4")
    
public AdView(Context  r1, AttributeSet  r2)
    {
        super(r1, r2);

        //kx = new au(this, r2, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.809 -0400", hash_original_method = "B70713324E98293CFB7FDD0E0044BEB3", hash_generated_method = "D6D3FD2990426DA1A8CF2343D6FADF9E")
    
public AdView(Context  r1, AttributeSet  r2, int  i0)
    {
        super(r1, r2, i0);

        //kx = new au(this, r2, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.815 -0400", hash_original_method = "8515908A075CB738827CDE99AF1DFBCC", hash_generated_method = "CC7CEA69F42A96A63184D04C0DA9A491")
    
public void destroy()
    {


        //kx.destroy();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.821 -0400", hash_original_method = "8664C601E24E9FAC5DF6F47AC4056FAB", hash_generated_method = "8E50F3D70F616797601B8331AEE59EE1")
    
public AdListener getAdListener()
    {
    	return adListener;


        //return kx.getAdListener();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.826 -0400", hash_original_method = "0AC48EF7204D63D5D5FE68A78C6E912B", hash_generated_method = "9DA083A06F857A392E9FC01D291CBFD2")
    
public AdSize getAdSize()
    {
    	if (adSize == null)
    		return AdSize.FULL_BANNER;
    	
    	return adSize;

        //return kx.getAdSize();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.834 -0400", hash_original_method = "0E59C81AA27618D2420AA114BB51A65F", hash_generated_method = "C4C5D91108BF70CE57DB479BE4345293")
    
public String getAdUnitId()
    {
    	if (adId == null)
    		adId = "<default-adId>";
    	return adId;
        //return kx.getAdUnitId();
    }
/*
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.840 -0400", hash_original_method = "7DB9720ED86120D06E214ECCDE11BD53", hash_generated_method = "D2C94D1145D1D4763DDA32959D146DFE")
    
public InAppPurchaseListener getInAppPurchaseListener()
    {


        //return kx.getInAppPurchaseListener();
    }*/

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.847 -0400", hash_original_method = "14A834E47475EB6C71688AB8AE14F494", hash_generated_method = "971B79A373C8FB8F477DADAACD42838F")
    
public void loadAd(AdRequest  r1)
    {


        //kx.a(r1.T());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.853 -0400", hash_original_method = "16B8EBEF08F6A0DD1AB1FF78593FC92F", hash_generated_method = "21D77C1D935D513F25DD5EE5BBFA968E")
    
public void pause()
    {


        //kx.pause();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.859 -0400", hash_original_method = "A2ABFA756BC51342FC1EE11A4C6C81AD", hash_generated_method = "4E418D477787BD275C05AA8FCCBD705F")
    
public void resume()
    {


        //kx.resume();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.865 -0400", hash_original_method = "304525B11ACBB719ECEFA31F894D6DE4", hash_generated_method = "F93D7C0BC3BB8EDB39FBBABBDC7AB8A8")
   @DSSafe(DSCat.ANDROID_CALLBACK) 
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


        //kx.setAdListener(r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.872 -0400", hash_original_method = "4F2C2DA30E6C97AA0575917A5FF72310", hash_generated_method = "3EC09901CB86248DD39514561A6E2972")
    
public void setAdSize(AdSize  r1)
    {
    	adSize = r1;
        //AdSize[] $r3 = {r1};
        //kx.setAdSizes($r3);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.879 -0400", hash_original_method = "E86533FDA8CE9B764C42BE8B3FE7C919", hash_generated_method = "3A4689349F9A08AA662375A39ACFEF7A")
    
public void setAdUnitId(String  r1)
    {
    	adId = r1;

        //kx.setAdUnitId(r1);
    }

   /* @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.885 -0400", hash_original_method = "FD1BF409053736EA2F383481ACEF74D8", hash_generated_method = "E4D3E3691782F496CE7BA9AD14E77584")
    
public void setInAppPurchaseListener(InAppPurchaseListener  r1)
    {


        //kx.setInAppPurchaseListener(r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.891 -0400", hash_original_method = "26988F35BD52993E2159AB0CED2B34A8", hash_generated_method = "80374A87E64F8D53A3304FCBBD016A37")
    
public void setPlayStorePurchaseParams(PlayStorePurchaseListener  r1, String  r2)
    {


        kx.setPlayStorePurchaseParams(r1, r2);
    }*/

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.902 -0400", hash_original_method = "74A075E8FA1ACED683AA56119FFEA04B", hash_generated_method = "871B3BAC9877DADE3EC3746456822B20")
    
protected void onLayout(boolean  z0, int  i0, int  i1, int  i2, int  i3)
    {

        View r1;
        int i4, i5, i6, i7;
        r1 = this.getChildAt(0);

        if (r1 != null && r1.getVisibility() != 8)
        {
            i4 = r1.getMeasuredWidth();
            i5 = r1.getMeasuredHeight();
            i6 = (i2 - i0 - i4) / 2;
            i7 = (i3 - i1 - i5) / 2;
            r1.layout(i6, i7, i6 + i4, i7 + i5);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:44.913 -0400", hash_original_method = "04A8D271449338CCC0CD8FD772AD00A0", hash_generated_method = "5B363BC20EF4761F90EBBBEA1621BE7D")
    
protected void onMeasure(int  i0, int  i1)
    {

        int i2, i3, i6, i8;
        View r1;
        AdSize r2;
        Context r3;
        i2 = 0;
        i3 = 0;
        r1 = this.getChildAt(0);
        r2 = this.getAdSize();

        label_0:
        {
            if (r1 != null && r1.getVisibility() != 8)
            {
                this.measureChild(r1, i0, i1);
                i2 = r1.getMeasuredWidth();
                i3 = r1.getMeasuredHeight();
                break label_0;
            }

            if (r2 != null)
            {
                r3 = this.getContext();
                i2 = r2.getWidthInPixels(r3);
                i3 = r2.getHeightInPixels(r3);
            }
        } //end label_0:


        i6 = Math.max(i2, this.getSuggestedMinimumWidth());
        i8 = Math.max(i3, this.getSuggestedMinimumHeight());
        this.setMeasuredDimension(View.resolveSize(i6, i0), View.resolveSize(i8, i1));
    }
}
