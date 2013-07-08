package com.android.internal.location;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.location.ILocationManager;
import android.location.LocationProvider;

public class DummyLocationProvider extends LocationProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.182 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

    String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.182 -0400", hash_original_field = "182459C6AF0846CF429E94DF2B5959BF", hash_generated_field = "DF2B3171B11A67F621676EF40A236159")

    boolean mRequiresNetwork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.182 -0400", hash_original_field = "EFC1F8EB20F439228277C82383DD8A28", hash_generated_field = "2FAE948EF0EDA44AE36030A345BCA7F9")

    boolean mRequiresSatellite;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.182 -0400", hash_original_field = "E39A10840F71D93205DC1F88A34956EC", hash_generated_field = "CD2451BEADF29CB4B04A5FBF2BECE7A5")

    boolean mRequiresCell;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.182 -0400", hash_original_field = "B83959B604F2556CE5CD8C482DC210E6", hash_generated_field = "9BB0C6F2515CD3D4097971FB7222AFC9")

    boolean mHasMonetaryCost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.182 -0400", hash_original_field = "FCDDD58BCD6E2BF64ED3B1463A2C99BB", hash_generated_field = "FE17A406A6FDB81F55F27A7ED9FDCF16")

    boolean mSupportsAltitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.182 -0400", hash_original_field = "B441555425878714F69CE88456EA4B51", hash_generated_field = "E9787058DB54707705A7DDFE4B3B4B19")

    boolean mSupportsSpeed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.182 -0400", hash_original_field = "421850CAFF8369DEEAE79E4BFA800D3E", hash_generated_field = "8D283BB3EB5888B0DE27DB1FD6DF7003")

    boolean mSupportsBearing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.182 -0400", hash_original_field = "8CE6AA00EE3C11F8598CD0D337F6CAE9", hash_generated_field = "16051051674F42DF07BACDCFF2C64789")

    int mPowerRequirement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.182 -0400", hash_original_field = "662D142255956BF41BF8EF5110A28B67", hash_generated_field = "A988C0B68D6A03FA302108721EA90905")

    int mAccuracy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.183 -0400", hash_original_method = "2D2A21251E5C69E5D6553C80AB5C5FAF", hash_generated_method = "1A857AE7D6A50084544002A4B8014781")
    public  DummyLocationProvider(String name, ILocationManager service) {
        super(name, service);
        addTaint(name.getTaint());
        addTaint(service.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.183 -0400", hash_original_method = "1F8DE8B3742DB968D48AC8E46FA2231B", hash_generated_method = "B491D2865225D184CA94E5FDA8C8C83A")
    public void setRequiresNetwork(boolean requiresNetwork) {
        mRequiresNetwork = requiresNetwork;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.183 -0400", hash_original_method = "29EAF7BAC1D59C67F0068E19069EC95C", hash_generated_method = "6417F8E937DEF182FD4384B8EC43DEFA")
    public void setRequiresSatellite(boolean requiresSatellite) {
        mRequiresSatellite = requiresSatellite;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.184 -0400", hash_original_method = "800DBE9AB92460271BA9850123B2E01B", hash_generated_method = "59AA1D4331D17CE5FE6E163324E4AAF8")
    public void setRequiresCell(boolean requiresCell) {
        mRequiresCell = requiresCell;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.184 -0400", hash_original_method = "3E58BDCD583420258AF42AE15C5A1B66", hash_generated_method = "7A8F281C030D2AB2F4123F69F3ED81E7")
    public void setHasMonetaryCost(boolean hasMonetaryCost) {
        mHasMonetaryCost = hasMonetaryCost;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.184 -0400", hash_original_method = "CCF8D193AEBD5AA7F01F4990E2AE806C", hash_generated_method = "038ABF6E048EB620C4682786FEA54672")
    public void setSupportsAltitude(boolean supportsAltitude) {
        mSupportsAltitude = supportsAltitude;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.184 -0400", hash_original_method = "92E2AFB41DD112983B18606F5344DACF", hash_generated_method = "ADEA9A24C7E4EA76ACFC2A2BDA342523")
    public void setSupportsSpeed(boolean supportsSpeed) {
        mSupportsSpeed = supportsSpeed;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.185 -0400", hash_original_method = "F9CE2AAA32ACB1BAFD2F9DDDA0BB7D16", hash_generated_method = "8412DD7B3724FC89A37067DC4C863938")
    public void setSupportsBearing(boolean supportsBearing) {
        mSupportsBearing = supportsBearing;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.185 -0400", hash_original_method = "2C88F96CAFDD5DC38199E97F56E6E512", hash_generated_method = "AB54773A7A0BA7F8B4062B2F76D15C71")
    public void setPowerRequirement(int powerRequirement) {
        mPowerRequirement = powerRequirement;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.185 -0400", hash_original_method = "50C70CC35BE1C99F5177BBD5E6545CA6", hash_generated_method = "D288525613995EDA7816DABBB501D13A")
    public void setAccuracy(int accuracy) {
        mAccuracy = accuracy;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.185 -0400", hash_original_method = "12AE735753CC1F454105371651D9BBA1", hash_generated_method = "C5DED6B822C4139811E3EB34DE4F579F")
    public boolean requiresNetwork() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1858195503 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1858195503;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.185 -0400", hash_original_method = "A3DAE9100E63CBDE8137FDA5BE5C7B6B", hash_generated_method = "5B8E6597DDB89CE68AD9F07C81DD652E")
    public boolean requiresSatellite() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_128245372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_128245372;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.186 -0400", hash_original_method = "BE22582F45632E0BED7FA33E3D9F0EE8", hash_generated_method = "5F9B7E8A6EF65874347259D62181FD7A")
    public boolean requiresCell() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2078315843 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2078315843;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.186 -0400", hash_original_method = "464B91F9461F0393A5548F6081396811", hash_generated_method = "24D89A3CA2E3E35E61FB2F0469C51C07")
    public boolean hasMonetaryCost() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2022722905 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2022722905;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.186 -0400", hash_original_method = "80EB2267564425834001A2243EC06FBE", hash_generated_method = "0B725DEFE9D1EC73D0C4C11E0331F7B6")
    public boolean supportsAltitude() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1821001050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1821001050;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.186 -0400", hash_original_method = "F5A7ECCEC7D24AC04E83E34652847C55", hash_generated_method = "49858C8ABDE16D65829201E2984DE871")
    public boolean supportsSpeed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_372446893 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_372446893;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.186 -0400", hash_original_method = "ADDCD70E458E7B4958723B2C0A9B7ABB", hash_generated_method = "C440532AD8821D802887FA3D3FC30787")
    public boolean supportsBearing() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_202906664 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_202906664;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.187 -0400", hash_original_method = "50AB5D6061392E8FAC8A81CA41B14FB2", hash_generated_method = "2883911C9E47A378AF69E2EB1BEFD984")
    public int getPowerRequirement() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1796301197 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1796301197;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.187 -0400", hash_original_method = "8D132D636D1C633E7B8C919AFBA33B78", hash_generated_method = "41EEE9A8B9512B91417F7F3B92D3E564")
    public int getAccuracy() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693989397 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693989397;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.187 -0400", hash_original_field = "6DB4E50C9647E9E62752AF81FB6BC633", hash_generated_field = "901EFB6E43A09AC53DEA608D292AE5C5")

    private static final String TAG = "DummyLocationProvider";
}

