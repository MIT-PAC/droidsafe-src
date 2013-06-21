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
    String mName;
    boolean mRequiresNetwork;
    boolean mRequiresSatellite;
    boolean mRequiresCell;
    boolean mHasMonetaryCost;
    boolean mSupportsAltitude;
    boolean mSupportsSpeed;
    boolean mSupportsBearing;
    int mPowerRequirement;
    int mAccuracy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.106 -0400", hash_original_method = "2D2A21251E5C69E5D6553C80AB5C5FAF", hash_generated_method = "A9D42A396B843101549ADC3678174818")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DummyLocationProvider(String name, ILocationManager service) {
        super(name, service);
        dsTaint.addTaint(name);
        dsTaint.addTaint(service.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.107 -0400", hash_original_method = "1F8DE8B3742DB968D48AC8E46FA2231B", hash_generated_method = "9923FBF9975531DD730F8D707FB24474")
    @DSModeled(DSC.SAFE)
    public void setRequiresNetwork(boolean requiresNetwork) {
        dsTaint.addTaint(requiresNetwork);
        // ---------- Original Method ----------
        //mRequiresNetwork = requiresNetwork;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.107 -0400", hash_original_method = "29EAF7BAC1D59C67F0068E19069EC95C", hash_generated_method = "A1B5F50184B94A3A115FE99884C9C853")
    @DSModeled(DSC.SAFE)
    public void setRequiresSatellite(boolean requiresSatellite) {
        dsTaint.addTaint(requiresSatellite);
        // ---------- Original Method ----------
        //mRequiresSatellite = requiresSatellite;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.107 -0400", hash_original_method = "800DBE9AB92460271BA9850123B2E01B", hash_generated_method = "ABBE0682DB907117C26917CCD534D71F")
    @DSModeled(DSC.SAFE)
    public void setRequiresCell(boolean requiresCell) {
        dsTaint.addTaint(requiresCell);
        // ---------- Original Method ----------
        //mRequiresCell = requiresCell;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.107 -0400", hash_original_method = "3E58BDCD583420258AF42AE15C5A1B66", hash_generated_method = "E0540825989EF08FC0AF6581CE498011")
    @DSModeled(DSC.SAFE)
    public void setHasMonetaryCost(boolean hasMonetaryCost) {
        dsTaint.addTaint(hasMonetaryCost);
        // ---------- Original Method ----------
        //mHasMonetaryCost = hasMonetaryCost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.107 -0400", hash_original_method = "CCF8D193AEBD5AA7F01F4990E2AE806C", hash_generated_method = "3F6B321380BD42F104AB3BF274774F90")
    @DSModeled(DSC.SAFE)
    public void setSupportsAltitude(boolean supportsAltitude) {
        dsTaint.addTaint(supportsAltitude);
        // ---------- Original Method ----------
        //mSupportsAltitude = supportsAltitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.108 -0400", hash_original_method = "92E2AFB41DD112983B18606F5344DACF", hash_generated_method = "DC7DC9FBD86BCC9337E71B87C870CD59")
    @DSModeled(DSC.SAFE)
    public void setSupportsSpeed(boolean supportsSpeed) {
        dsTaint.addTaint(supportsSpeed);
        // ---------- Original Method ----------
        //mSupportsSpeed = supportsSpeed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.108 -0400", hash_original_method = "F9CE2AAA32ACB1BAFD2F9DDDA0BB7D16", hash_generated_method = "0D60C071BF0AD7EDD16BF767FDB9D4F4")
    @DSModeled(DSC.SAFE)
    public void setSupportsBearing(boolean supportsBearing) {
        dsTaint.addTaint(supportsBearing);
        // ---------- Original Method ----------
        //mSupportsBearing = supportsBearing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.108 -0400", hash_original_method = "2C88F96CAFDD5DC38199E97F56E6E512", hash_generated_method = "C2A1683487F4FFE85BA93E8431E50568")
    @DSModeled(DSC.SAFE)
    public void setPowerRequirement(int powerRequirement) {
        dsTaint.addTaint(powerRequirement);
        // ---------- Original Method ----------
        //mPowerRequirement = powerRequirement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.108 -0400", hash_original_method = "50C70CC35BE1C99F5177BBD5E6545CA6", hash_generated_method = "A67889EC244F02A0D356DF8AA8312D75")
    @DSModeled(DSC.SAFE)
    public void setAccuracy(int accuracy) {
        dsTaint.addTaint(accuracy);
        // ---------- Original Method ----------
        //mAccuracy = accuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.108 -0400", hash_original_method = "12AE735753CC1F454105371651D9BBA1", hash_generated_method = "A4F1F375BEFA2DB42E32ECDCAAAA009A")
    @DSModeled(DSC.SAFE)
    public boolean requiresNetwork() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRequiresNetwork;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.108 -0400", hash_original_method = "A3DAE9100E63CBDE8137FDA5BE5C7B6B", hash_generated_method = "4B6931DD82500776B27B66EF09737C2E")
    @DSModeled(DSC.SAFE)
    public boolean requiresSatellite() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRequiresSatellite;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.108 -0400", hash_original_method = "BE22582F45632E0BED7FA33E3D9F0EE8", hash_generated_method = "4DECB6BDF5E12C6B2FF8A1DCF556877D")
    @DSModeled(DSC.SAFE)
    public boolean requiresCell() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRequiresCell;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.109 -0400", hash_original_method = "464B91F9461F0393A5548F6081396811", hash_generated_method = "4D8903A40F3FFAC144F042C627FFD675")
    @DSModeled(DSC.SAFE)
    public boolean hasMonetaryCost() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHasMonetaryCost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.109 -0400", hash_original_method = "80EB2267564425834001A2243EC06FBE", hash_generated_method = "23C4A396875F97F018FF870D1631F0ED")
    @DSModeled(DSC.SAFE)
    public boolean supportsAltitude() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSupportsAltitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.109 -0400", hash_original_method = "F5A7ECCEC7D24AC04E83E34652847C55", hash_generated_method = "8FA76EC5221BC9B660925747F4199D43")
    @DSModeled(DSC.SAFE)
    public boolean supportsSpeed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSupportsSpeed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.109 -0400", hash_original_method = "ADDCD70E458E7B4958723B2C0A9B7ABB", hash_generated_method = "7CC32A3C8A8330F7E23C3F3FF9B6C6EA")
    @DSModeled(DSC.SAFE)
    public boolean supportsBearing() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSupportsBearing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.109 -0400", hash_original_method = "50AB5D6061392E8FAC8A81CA41B14FB2", hash_generated_method = "EB9B54582F63466D038DF03D194EED66")
    @DSModeled(DSC.SAFE)
    public int getPowerRequirement() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPowerRequirement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.109 -0400", hash_original_method = "8D132D636D1C633E7B8C919AFBA33B78", hash_generated_method = "E5A4EE3D44F9CCA46916F54E2999950C")
    @DSModeled(DSC.SAFE)
    public int getAccuracy() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAccuracy;
    }

    
    private static final String TAG = "DummyLocationProvider";
}

