package com.android.internal.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.location.ILocationManager;
import android.location.LocationProvider;

public class DummyLocationProvider extends LocationProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.090 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

    String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.091 -0400", hash_original_field = "182459C6AF0846CF429E94DF2B5959BF", hash_generated_field = "DF2B3171B11A67F621676EF40A236159")

    boolean mRequiresNetwork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.091 -0400", hash_original_field = "EFC1F8EB20F439228277C82383DD8A28", hash_generated_field = "2FAE948EF0EDA44AE36030A345BCA7F9")

    boolean mRequiresSatellite;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.091 -0400", hash_original_field = "E39A10840F71D93205DC1F88A34956EC", hash_generated_field = "CD2451BEADF29CB4B04A5FBF2BECE7A5")

    boolean mRequiresCell;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.091 -0400", hash_original_field = "B83959B604F2556CE5CD8C482DC210E6", hash_generated_field = "9BB0C6F2515CD3D4097971FB7222AFC9")

    boolean mHasMonetaryCost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.091 -0400", hash_original_field = "FCDDD58BCD6E2BF64ED3B1463A2C99BB", hash_generated_field = "FE17A406A6FDB81F55F27A7ED9FDCF16")

    boolean mSupportsAltitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.091 -0400", hash_original_field = "B441555425878714F69CE88456EA4B51", hash_generated_field = "E9787058DB54707705A7DDFE4B3B4B19")

    boolean mSupportsSpeed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.091 -0400", hash_original_field = "421850CAFF8369DEEAE79E4BFA800D3E", hash_generated_field = "8D283BB3EB5888B0DE27DB1FD6DF7003")

    boolean mSupportsBearing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.091 -0400", hash_original_field = "8CE6AA00EE3C11F8598CD0D337F6CAE9", hash_generated_field = "16051051674F42DF07BACDCFF2C64789")

    int mPowerRequirement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.091 -0400", hash_original_field = "662D142255956BF41BF8EF5110A28B67", hash_generated_field = "A988C0B68D6A03FA302108721EA90905")

    int mAccuracy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.092 -0400", hash_original_method = "2D2A21251E5C69E5D6553C80AB5C5FAF", hash_generated_method = "1A857AE7D6A50084544002A4B8014781")
    public  DummyLocationProvider(String name, ILocationManager service) {
        super(name, service);
        addTaint(name.getTaint());
        addTaint(service.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.092 -0400", hash_original_method = "1F8DE8B3742DB968D48AC8E46FA2231B", hash_generated_method = "B491D2865225D184CA94E5FDA8C8C83A")
    public void setRequiresNetwork(boolean requiresNetwork) {
        mRequiresNetwork = requiresNetwork;
        // ---------- Original Method ----------
        //mRequiresNetwork = requiresNetwork;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.093 -0400", hash_original_method = "29EAF7BAC1D59C67F0068E19069EC95C", hash_generated_method = "6417F8E937DEF182FD4384B8EC43DEFA")
    public void setRequiresSatellite(boolean requiresSatellite) {
        mRequiresSatellite = requiresSatellite;
        // ---------- Original Method ----------
        //mRequiresSatellite = requiresSatellite;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.100 -0400", hash_original_method = "800DBE9AB92460271BA9850123B2E01B", hash_generated_method = "59AA1D4331D17CE5FE6E163324E4AAF8")
    public void setRequiresCell(boolean requiresCell) {
        mRequiresCell = requiresCell;
        // ---------- Original Method ----------
        //mRequiresCell = requiresCell;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.100 -0400", hash_original_method = "3E58BDCD583420258AF42AE15C5A1B66", hash_generated_method = "7A8F281C030D2AB2F4123F69F3ED81E7")
    public void setHasMonetaryCost(boolean hasMonetaryCost) {
        mHasMonetaryCost = hasMonetaryCost;
        // ---------- Original Method ----------
        //mHasMonetaryCost = hasMonetaryCost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.101 -0400", hash_original_method = "CCF8D193AEBD5AA7F01F4990E2AE806C", hash_generated_method = "038ABF6E048EB620C4682786FEA54672")
    public void setSupportsAltitude(boolean supportsAltitude) {
        mSupportsAltitude = supportsAltitude;
        // ---------- Original Method ----------
        //mSupportsAltitude = supportsAltitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.108 -0400", hash_original_method = "92E2AFB41DD112983B18606F5344DACF", hash_generated_method = "ADEA9A24C7E4EA76ACFC2A2BDA342523")
    public void setSupportsSpeed(boolean supportsSpeed) {
        mSupportsSpeed = supportsSpeed;
        // ---------- Original Method ----------
        //mSupportsSpeed = supportsSpeed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.108 -0400", hash_original_method = "F9CE2AAA32ACB1BAFD2F9DDDA0BB7D16", hash_generated_method = "8412DD7B3724FC89A37067DC4C863938")
    public void setSupportsBearing(boolean supportsBearing) {
        mSupportsBearing = supportsBearing;
        // ---------- Original Method ----------
        //mSupportsBearing = supportsBearing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.122 -0400", hash_original_method = "2C88F96CAFDD5DC38199E97F56E6E512", hash_generated_method = "AB54773A7A0BA7F8B4062B2F76D15C71")
    public void setPowerRequirement(int powerRequirement) {
        mPowerRequirement = powerRequirement;
        // ---------- Original Method ----------
        //mPowerRequirement = powerRequirement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.122 -0400", hash_original_method = "50C70CC35BE1C99F5177BBD5E6545CA6", hash_generated_method = "D288525613995EDA7816DABBB501D13A")
    public void setAccuracy(int accuracy) {
        mAccuracy = accuracy;
        // ---------- Original Method ----------
        //mAccuracy = accuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.123 -0400", hash_original_method = "12AE735753CC1F454105371651D9BBA1", hash_generated_method = "79E044DD506268CBB2AE1A50796E3F70")
    public boolean requiresNetwork() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_657254145 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_657254145;
        // ---------- Original Method ----------
        //return mRequiresNetwork;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.123 -0400", hash_original_method = "A3DAE9100E63CBDE8137FDA5BE5C7B6B", hash_generated_method = "745C68A949C76E4B3395A75870F7E192")
    public boolean requiresSatellite() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2134587187 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2134587187;
        // ---------- Original Method ----------
        //return mRequiresSatellite;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.124 -0400", hash_original_method = "BE22582F45632E0BED7FA33E3D9F0EE8", hash_generated_method = "04C2CC6F9AB83F4386A263FA201FC9C6")
    public boolean requiresCell() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1046885528 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1046885528;
        // ---------- Original Method ----------
        //return mRequiresCell;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.124 -0400", hash_original_method = "464B91F9461F0393A5548F6081396811", hash_generated_method = "7361323F047E427C433E87D1F397F8B4")
    public boolean hasMonetaryCost() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235716416 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_235716416;
        // ---------- Original Method ----------
        //return mHasMonetaryCost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.124 -0400", hash_original_method = "80EB2267564425834001A2243EC06FBE", hash_generated_method = "52D7D92B7B774991F0E489493E639DB7")
    public boolean supportsAltitude() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400049578 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_400049578;
        // ---------- Original Method ----------
        //return mSupportsAltitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.125 -0400", hash_original_method = "F5A7ECCEC7D24AC04E83E34652847C55", hash_generated_method = "3A529F1327E8C3A140D3B6780D9CB2FB")
    public boolean supportsSpeed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1863372055 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1863372055;
        // ---------- Original Method ----------
        //return mSupportsSpeed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.125 -0400", hash_original_method = "ADDCD70E458E7B4958723B2C0A9B7ABB", hash_generated_method = "B4764C889E732731505C0D51D13FD9D5")
    public boolean supportsBearing() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_620893121 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_620893121;
        // ---------- Original Method ----------
        //return mSupportsBearing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.126 -0400", hash_original_method = "50AB5D6061392E8FAC8A81CA41B14FB2", hash_generated_method = "58903B8F233617C7FC7060869A73E57C")
    public int getPowerRequirement() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1788727508 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1788727508;
        // ---------- Original Method ----------
        //return mPowerRequirement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.126 -0400", hash_original_method = "8D132D636D1C633E7B8C919AFBA33B78", hash_generated_method = "840658F345F72623DD303E4D11BDEC26")
    public int getAccuracy() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148235920 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148235920;
        // ---------- Original Method ----------
        //return mAccuracy;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.126 -0400", hash_original_field = "6DB4E50C9647E9E62752AF81FB6BC633", hash_generated_field = "73B86FFA199881D223289AC4315C2657")

    private static String TAG = "DummyLocationProvider";
}

