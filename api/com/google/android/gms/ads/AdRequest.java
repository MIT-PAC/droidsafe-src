package com.google.android.gms.ads;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;

import android.location.Location;
import android.os.Bundle;
import android.content.Context;

public final class AdRequest
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.421 -0400", hash_original_field = "6BC03DE5FEB16339EBA333BF6FB1B767", hash_generated_field = "26D177409BE600F4246DE8916FF6BCE1")

    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.430 -0400", hash_original_field = "0557E9ED9E652E9A345A9CDE5F9125AC", hash_generated_field = "BBB6F9108B3291E7E0022BCDC2CB7CD7")

    public static final int ERROR_CODE_INVALID_REQUEST = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.438 -0400", hash_original_field = "184C490BC28987D15240A2E586F2D947", hash_generated_field = "70EB3C3CB06B5325DD3C30EF5ADCB1EA")

    public static final int ERROR_CODE_NETWORK_ERROR = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.447 -0400", hash_original_field = "7AA535BF532B6D0C9E84E705A205D7C8", hash_generated_field = "1F06D246B3E6D8FC53DEE43984883C07")

    public static final int ERROR_CODE_NO_FILL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.455 -0400", hash_original_field = "07ADF0062107C8AABC85BBDDB7BF1D59", hash_generated_field = "E597FB18FF78CFEB4F0187BA63723976")

    public static final int GENDER_UNKNOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.463 -0400", hash_original_field = "AE9236E7D233EA61316C8B3C6C656A3B", hash_generated_field = "43008ED90EF67CB29545433690D07113")

    public static final int GENDER_MALE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.471 -0400", hash_original_field = "B43B080E76F0E9F1DF65B0470C052860", hash_generated_field = "DB524BFAC5F035899001BA85C53473F9")

    public static final int GENDER_FEMALE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.481 -0400", hash_original_field = "DD4C86259BB327AF45A4E54D8509677E", hash_generated_field = "7A2C96EE40223FD6C7EC56C5BDFEB136")

    public static final int MAX_CONTENT_URL_LENGTH = 512;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.490 -0400", hash_original_field = "3D3B1CB0F7CAE7DA71D57B5EA30A4AF0", hash_generated_field = "AAEDD6AE20C8097E055050C7833ED305")

    public static  String DEVICE_ID_EMULATOR;

	Builder builder;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.598 -0400", hash_original_method = "823C55570B3782363A72910317842B3F", hash_generated_method = "1212DB6407F0F230CBA837174AA079E0")
    
    AdRequest(AdRequest.Builder  r1)
    {
        // this(r1);

        //this.ks = null;
    	builder = r1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.514 -0400", hash_original_method = "50E8AE67967FFC1A883341F3B95A16B6", hash_generated_method = "8CD070C43E04BC318F90691DAD5A1E26")
    
public Date getBirthday()
    {
    	return builder.birthday;

        //return ks.getBirthday();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.523 -0400", hash_original_method = "8394A6FCC50C274358ECB525BDF64681", hash_generated_method = "2A872E5C4BF4B4F5881A17E48DCCD48B")
    
public String getContentUrl()
    {
    	return builder.contentUrl;

        //return ks.getContentUrl();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.532 -0400", hash_original_method = "46199B381856BEF6FAA8F79758B17074", hash_generated_method = "271972CBF1C17AF1E9268B23DCAB688D")
    
public int getGender()
    {
    	return builder.gender;

        //return ks.getGender();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.541 -0400", hash_original_method = "767F9D7B28BD8323F782AF9505D57536", hash_generated_method = "9556A4B8D062C968E01B89B7458B1D51")
    
public Set getKeywords()
    {
    	return builder.keywords;

        //return ks.getKeywords();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.549 -0400", hash_original_method = "A4279CD2E7AA4C4A191E7046A636631E", hash_generated_method = "E56E2D68569CC9B27226BCA825557F07")
    
public Location getLocation()
    {
    	return builder.location;
        //return ks.getLocation();
    }
/*
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.559 -0400", hash_original_method = "E730FC225BD334033BDE41B85FE1E05B", hash_generated_method = "7806BFBC79C71A4CDAFBA917189CCD92")
    
public NetworkExtras getNetworkExtras(Class  r1)
    {

        //return ks.getNetworkExtras(r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.568 -0400", hash_original_method = "51D2EC14A952C1CF7B981EB9BA5013EA", hash_generated_method = "80A6507B57D203A271773EDE9D34FC0C")
    
public Bundle getNetworkExtrasBundle(Class  r1)
    {

        //return ks.getNetworkExtrasBundle(r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.576 -0400", hash_original_method = "6AE74A63B9C4F5146A523B72DF81B83D", hash_generated_method = "4006040569B5D3789BBC469853C26536")
    
public Bundle getCustomEventExtrasBundle(Class  r1)
    {

        //return ks.getCustomEventExtrasBundle(r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:43.584 -0400", hash_original_method = "A30E9E24CF9F2D165F9069939E7143EF", hash_generated_method = "49512D707E255B3ECA40BF68A30DBE90")
    
public boolean isTestDevice(Context  r1)
    {

        //return ks.isTestDevice(r1);
    }
*/
    private static class Builder {
    	Set<String> keywords = new HashSet<String>();
    	Set<String> devices = new HashSet<String>();
    	Date birthday;
    	int gender;
    	boolean tag;
    	String contentUrl;
        Class<? extends MediationAdapter> adapterClass;
        Bundle networkExtras;
    	
    	@DSSafe(DSCat.SAFE_OTHERS)
        public Builder() {
    		
    	}

    	public Builder setContentUrl(String contentUrl) {
    		this.contentUrl = contentUrl;
    		return this;
    	}

    	@DSSink({DSSinkKind.AD})
        @DSSafe(DSCat.SAFE_OTHERS)
        public Builder addKeyword(String keyword) {
    		keywords.add(keyword);
    		return this;
    	}

    	@DSSafe(DSCat.SAFE_OTHERS)
        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass, Bundle networkExtras) {
    		this.adapterClass = adapterClass;
    		this.networkExtras = networkExtras;
    		return this;
    	}

    	@DSSafe(DSCat.SAFE_OTHERS)
        public Builder addTestDevice(String device){
    		devices.add(device);
    		return this;
    	}

    	@DSSafe(DSCat.SAFE_OTHERS)
        public AdRequest build() {
    		AdRequest request = new AdRequest(this);
    		if (adapterClass != null) {
    			try {
					MediationAdapter adapter = (MediationAdapter)adapterClass.newInstance();
					
					if (adapter instanceof MediationInterstitialAdapter) {
						MediationInterstitialAdapter mAdapter = (MediationInterstitialAdapter) adapter;
						// How do we provide the callback???
						//mAdapter.requestInterstitialAd(context, listener, serverParameters, this, networkExtras);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
				} 
    		}
    		return request;
    	}

    	@DSSink({DSSinkKind.AD})
        @DSSpec(DSCat.SPEC_OTHERS)
        public Builder setBirthday(Date birthday) {
    		this.birthday = birthday;
    		return this;
    	}
    	@DSSink({DSSinkKind.AD})
        @DSSpec(DSCat.SPEC_OTHERS)
        public Builder setGender(int gender){
    		this.gender = gender;
    		return this;
    	}
    	@DSSafe(DSCat.SAFE_OTHERS)
        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
    		this.tag = tagForChildDirectedTreatment;
    		return this;
    	}

    	Location location;
    	public Builder setLocation(Location loc){
    		this.location = loc;
    		return this;
    	}

    }
    
}
