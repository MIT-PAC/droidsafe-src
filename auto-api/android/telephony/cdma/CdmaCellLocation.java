package android.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.telephony.CellLocation;

public class CdmaCellLocation extends CellLocation {
    private int mBaseStationId = -1;
    private int mBaseStationLatitude = INVALID_LAT_LONG;
    private int mBaseStationLongitude = INVALID_LAT_LONG;
    private int mSystemId = -1;
    private int mNetworkId = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.907 -0400", hash_original_method = "5C896DC446B6DB5EAC37BD66E663CEA5", hash_generated_method = "A6B4E6684301834C9B993D832B63288A")
    @DSModeled(DSC.SAFE)
    public CdmaCellLocation() {
        this.mBaseStationId = -1;
        this.mBaseStationLatitude = INVALID_LAT_LONG;
        this.mBaseStationLongitude = INVALID_LAT_LONG;
        this.mSystemId = -1;
        this.mNetworkId = -1;
        // ---------- Original Method ----------
        //this.mBaseStationId = -1;
        //this.mBaseStationLatitude = INVALID_LAT_LONG;
        //this.mBaseStationLongitude = INVALID_LAT_LONG;
        //this.mSystemId = -1;
        //this.mNetworkId = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.908 -0400", hash_original_method = "8EA08E2DEACD96E97EA367485FCE09D0", hash_generated_method = "F3D9292B9B8C10FE93F4B42023396915")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CdmaCellLocation(Bundle bundle) {
        dsTaint.addTaint(bundle.dsTaint);
        this.mBaseStationId = bundle.getInt("baseStationId", mBaseStationId);
        this.mBaseStationLatitude = bundle.getInt("baseStationLatitude", mBaseStationLatitude);
        this.mBaseStationLongitude = bundle.getInt("baseStationLongitude", mBaseStationLongitude);
        this.mSystemId = bundle.getInt("systemId", mSystemId);
        this.mNetworkId = bundle.getInt("networkId", mNetworkId);
        // ---------- Original Method ----------
        //this.mBaseStationId = bundle.getInt("baseStationId", mBaseStationId);
        //this.mBaseStationLatitude = bundle.getInt("baseStationLatitude", mBaseStationLatitude);
        //this.mBaseStationLongitude = bundle.getInt("baseStationLongitude", mBaseStationLongitude);
        //this.mSystemId = bundle.getInt("systemId", mSystemId);
        //this.mNetworkId = bundle.getInt("networkId", mNetworkId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.908 -0400", hash_original_method = "5BA2DB973405907BCB7576020C4BB767", hash_generated_method = "1BBE4D0983A179B37C423B03E0A5871B")
    @DSModeled(DSC.SAFE)
    public int getBaseStationId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mBaseStationId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.908 -0400", hash_original_method = "8D32771FFADF2E37F4C4C4E7BB2945F8", hash_generated_method = "64C8E3C8932FFB5BD5FFA63BA8233BBF")
    @DSModeled(DSC.SAFE)
    public int getBaseStationLatitude() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mBaseStationLatitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.908 -0400", hash_original_method = "B2E759A184D0C15083668122E08B0641", hash_generated_method = "A7C92FBFFBF7184EB6C357D46479AF42")
    @DSModeled(DSC.SAFE)
    public int getBaseStationLongitude() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mBaseStationLongitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.908 -0400", hash_original_method = "E5E4F22C1EB64E5BA2863333F6C891A3", hash_generated_method = "9AF58D756F49E3460180162C1F9F75FB")
    @DSModeled(DSC.SAFE)
    public int getSystemId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mSystemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.909 -0400", hash_original_method = "909C93F66AD557988A123F548D8C31FC", hash_generated_method = "5F062E331A0EEB3F90F4CE6D7A3F5621")
    @DSModeled(DSC.SAFE)
    public int getNetworkId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mNetworkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.909 -0400", hash_original_method = "0C9042B8D6AE69440E11B69CE7953639", hash_generated_method = "677DCE7DC5322BDEF3694C512B2DB3B9")
    @DSModeled(DSC.SAFE)
    public void setStateInvalid() {
        this.mBaseStationId = -1;
        this.mBaseStationLatitude = INVALID_LAT_LONG;
        this.mBaseStationLongitude = INVALID_LAT_LONG;
        this.mSystemId = -1;
        this.mNetworkId = -1;
        // ---------- Original Method ----------
        //this.mBaseStationId = -1;
        //this.mBaseStationLatitude = INVALID_LAT_LONG;
        //this.mBaseStationLongitude = INVALID_LAT_LONG;
        //this.mSystemId = -1;
        //this.mNetworkId = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.909 -0400", hash_original_method = "61B794D65EE283C3FD04A14E94D0946D", hash_generated_method = "600FECC25EFCE5DC3755C2F6458D2F01")
    @DSModeled(DSC.SAFE)
    public void setCellLocationData(int baseStationId, int baseStationLatitude,
         int baseStationLongitude) {
        dsTaint.addTaint(baseStationLongitude);
        dsTaint.addTaint(baseStationLatitude);
        dsTaint.addTaint(baseStationId);
        // ---------- Original Method ----------
        //this.mBaseStationId = baseStationId;
        //this.mBaseStationLatitude = baseStationLatitude;
        //this.mBaseStationLongitude = baseStationLongitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.909 -0400", hash_original_method = "4013196C0844C1883550E95EB904B1DA", hash_generated_method = "B97B997BF60C62F8F5E2829618A6BD26")
    @DSModeled(DSC.SAFE)
    public void setCellLocationData(int baseStationId, int baseStationLatitude,
         int baseStationLongitude, int systemId, int networkId) {
        dsTaint.addTaint(baseStationLongitude);
        dsTaint.addTaint(networkId);
        dsTaint.addTaint(baseStationLatitude);
        dsTaint.addTaint(baseStationId);
        dsTaint.addTaint(systemId);
        // ---------- Original Method ----------
        //this.mBaseStationId = baseStationId;
        //this.mBaseStationLatitude = baseStationLatitude;
        //this.mBaseStationLongitude = baseStationLongitude;
        //this.mSystemId = systemId;
        //this.mNetworkId = networkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.910 -0400", hash_original_method = "E85418559CBFBFDF0470CD6A904DEAD1", hash_generated_method = "BBCB1357CE771BB67F68291D54FFDE2F")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mBaseStationId ^ this.mBaseStationLatitude ^ this.mBaseStationLongitude
                //^ this.mSystemId ^ this.mNetworkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.910 -0400", hash_original_method = "38D738FF275D66A3A0FE767FC9AC4FB9", hash_generated_method = "648FE7669CC648D657065DC076BD8EB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        CdmaCellLocation s;
        try 
        {
            s = (CdmaCellLocation)o;
        } //End block
        catch (ClassCastException ex)
        { }
        boolean varF7FAA7223520EA38037273760A9832FA_315260053 = ((equalsHandlesNulls(this.mBaseStationId, s.mBaseStationId) &&
                equalsHandlesNulls(this.mBaseStationLatitude, s.mBaseStationLatitude) &&
                equalsHandlesNulls(this.mBaseStationLongitude, s.mBaseStationLongitude) &&
                equalsHandlesNulls(this.mSystemId, s.mSystemId) &&
                equalsHandlesNulls(this.mNetworkId, s.mNetworkId)
        ));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //CdmaCellLocation s;
        //try {
            //s = (CdmaCellLocation)o;
        //} catch (ClassCastException ex) {
            //return false;
        //}
        //if (o == null) {
            //return false;
        //}
        //return (equalsHandlesNulls(this.mBaseStationId, s.mBaseStationId) &&
                //equalsHandlesNulls(this.mBaseStationLatitude, s.mBaseStationLatitude) &&
                //equalsHandlesNulls(this.mBaseStationLongitude, s.mBaseStationLongitude) &&
                //equalsHandlesNulls(this.mSystemId, s.mSystemId) &&
                //equalsHandlesNulls(this.mNetworkId, s.mNetworkId)
        //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.910 -0400", hash_original_method = "3AD4832D3A3F9EB2D9CB5CAE1051FD90", hash_generated_method = "0DA8339A3D8C1466A444895725CEF920")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "[" + this.mBaseStationId + ","
                   //+ this.mBaseStationLatitude + ","
                   //+ this.mBaseStationLongitude + ","
                   //+ this.mSystemId + ","
                   //+ this.mNetworkId + "]";
    }

    
        private static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.911 -0400", hash_original_method = "A94D1CCD0A9181704E5BCB2385E1DEF3", hash_generated_method = "D6888E22FAAEC4FF2CEF0001848B0849")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fillInNotifierBundle(Bundle bundleToFill) {
        dsTaint.addTaint(bundleToFill.dsTaint);
        bundleToFill.putInt("baseStationId", this.mBaseStationId);
        bundleToFill.putInt("baseStationLatitude", this.mBaseStationLatitude);
        bundleToFill.putInt("baseStationLongitude", this.mBaseStationLongitude);
        bundleToFill.putInt("systemId", this.mSystemId);
        bundleToFill.putInt("networkId", this.mNetworkId);
        // ---------- Original Method ----------
        //bundleToFill.putInt("baseStationId", this.mBaseStationId);
        //bundleToFill.putInt("baseStationLatitude", this.mBaseStationLatitude);
        //bundleToFill.putInt("baseStationLongitude", this.mBaseStationLongitude);
        //bundleToFill.putInt("systemId", this.mSystemId);
        //bundleToFill.putInt("networkId", this.mNetworkId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.911 -0400", hash_original_method = "8DF1697B3E0EEA68CA131C0067500EBA", hash_generated_method = "88243D2742C075F60B626FE0DDC48A24")
    @DSModeled(DSC.SAFE)
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (this.mBaseStationId == -1 &&
                //this.mBaseStationLatitude == INVALID_LAT_LONG &&
                //this.mBaseStationLongitude == INVALID_LAT_LONG &&
                //this.mSystemId == -1 &&
                //this.mNetworkId == -1);
    }

    
    public final static int INVALID_LAT_LONG = Integer.MAX_VALUE;
}

