package android.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Bundle;
import android.telephony.CellLocation;

public class CdmaCellLocation extends CellLocation {
    private int mBaseStationId = -1;
    public final static int INVALID_LAT_LONG = Integer.MAX_VALUE;
    private int mBaseStationLatitude = INVALID_LAT_LONG;
    private int mBaseStationLongitude = INVALID_LAT_LONG;
    private int mSystemId = -1;
    private int mNetworkId = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.440 -0400", hash_original_method = "5C896DC446B6DB5EAC37BD66E663CEA5", hash_generated_method = "38C6000CEE13723418227F0A0600B43F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.440 -0400", hash_original_method = "8EA08E2DEACD96E97EA367485FCE09D0", hash_generated_method = "66529180EF5669BEF0EB14AE987EEE46")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.440 -0400", hash_original_method = "5BA2DB973405907BCB7576020C4BB767", hash_generated_method = "95A553D3D7B1FF17BF6D16B3695007CB")
    @DSModeled(DSC.SAFE)
    public int getBaseStationId() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mBaseStationId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.440 -0400", hash_original_method = "8D32771FFADF2E37F4C4C4E7BB2945F8", hash_generated_method = "CB1DC42DC646530998DC507693C7B1DB")
    @DSModeled(DSC.SAFE)
    public int getBaseStationLatitude() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mBaseStationLatitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.440 -0400", hash_original_method = "B2E759A184D0C15083668122E08B0641", hash_generated_method = "6D8F83F2BEB8D3FC0B2ADA16160D8284")
    @DSModeled(DSC.SAFE)
    public int getBaseStationLongitude() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mBaseStationLongitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.441 -0400", hash_original_method = "E5E4F22C1EB64E5BA2863333F6C891A3", hash_generated_method = "5AD8FA1F1322B3F6075B5AF1C2C5BB12")
    @DSModeled(DSC.SAFE)
    public int getSystemId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mSystemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.441 -0400", hash_original_method = "909C93F66AD557988A123F548D8C31FC", hash_generated_method = "4FE5BA076D817461E8F44E1D5240DB90")
    @DSModeled(DSC.SAFE)
    public int getNetworkId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mNetworkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.441 -0400", hash_original_method = "0C9042B8D6AE69440E11B69CE7953639", hash_generated_method = "B6D15CD0122CE82CECE156DF3D30AFFC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.441 -0400", hash_original_method = "61B794D65EE283C3FD04A14E94D0946D", hash_generated_method = "269CEB42AD9EC2AC9F4F86DA1E5ED78B")
    @DSModeled(DSC.SAFE)
    public void setCellLocationData(int baseStationId, int baseStationLatitude,
         int baseStationLongitude) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(baseStationLongitude);
        dsTaint.addTaint(baseStationLatitude);
        dsTaint.addTaint(baseStationId);
        // ---------- Original Method ----------
        //this.mBaseStationId = baseStationId;
        //this.mBaseStationLatitude = baseStationLatitude;
        //this.mBaseStationLongitude = baseStationLongitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.441 -0400", hash_original_method = "4013196C0844C1883550E95EB904B1DA", hash_generated_method = "BB0F9A69566F90ABC5458213CDF021E8")
    @DSModeled(DSC.SAFE)
    public void setCellLocationData(int baseStationId, int baseStationLatitude,
         int baseStationLongitude, int systemId, int networkId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(baseStationLongitude);
        dsTaint.addTaint(baseStationLatitude);
        dsTaint.addTaint(networkId);
        dsTaint.addTaint(baseStationId);
        dsTaint.addTaint(systemId);
        // ---------- Original Method ----------
        //this.mBaseStationId = baseStationId;
        //this.mBaseStationLatitude = baseStationLatitude;
        //this.mBaseStationLongitude = baseStationLongitude;
        //this.mSystemId = systemId;
        //this.mNetworkId = networkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.441 -0400", hash_original_method = "E85418559CBFBFDF0470CD6A904DEAD1", hash_generated_method = "1BACA1CAD2EED2840E34DD976A54F1FB")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mBaseStationId ^ this.mBaseStationLatitude ^ this.mBaseStationLongitude
                //^ this.mSystemId ^ this.mNetworkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.442 -0400", hash_original_method = "38D738FF275D66A3A0FE767FC9AC4FB9", hash_generated_method = "2101EA692A97241694D99C3A310DB280")
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
        boolean varF7FAA7223520EA38037273760A9832FA_708524856 = ((equalsHandlesNulls(this.mBaseStationId, s.mBaseStationId) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.442 -0400", hash_original_method = "3AD4832D3A3F9EB2D9CB5CAE1051FD90", hash_generated_method = "D81620BEEF5E6D1D8213B293003BA4DB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.442 -0400", hash_original_method = "BC145A1DE2472995676ED9A315FB0956", hash_generated_method = "171409CD29A7B7D5AD18DD4C394534AC")
    private static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.442 -0400", hash_original_method = "A94D1CCD0A9181704E5BCB2385E1DEF3", hash_generated_method = "0DFA0759B9E3FDF8250217E646F6CAAC")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.442 -0400", hash_original_method = "8DF1697B3E0EEA68CA131C0067500EBA", hash_generated_method = "D9EE10D64862D7DAA9C79D11FE6776EB")
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

    
}


