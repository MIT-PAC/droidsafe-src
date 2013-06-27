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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.053 -0400", hash_original_field = "2B9F88F31AD9FCE7ABFBB18752950285", hash_generated_field = "880CD477F89AEF4CABEE47659812611F")

    private int mBaseStationId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.053 -0400", hash_original_field = "A4905204300C202E8EC2868687891FB1", hash_generated_field = "F33E82AA4D4032A9950970FEC5999108")

    private int mBaseStationLatitude = INVALID_LAT_LONG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.053 -0400", hash_original_field = "541CA7BA4B615865A9786E9ED80E68C2", hash_generated_field = "72B050148DB085190086BCC6506DAE80")

    private int mBaseStationLongitude = INVALID_LAT_LONG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.053 -0400", hash_original_field = "A2C016429B67E11504F428C6C56EF165", hash_generated_field = "5B31DE8CC89DD13B11EA69E8D17F6B69")

    private int mSystemId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.053 -0400", hash_original_field = "D8D1D4C0DE12D0696DFA216CCA322C8C", hash_generated_field = "61B4BCE8DF023A8A81D64AB2D58B0D50")

    private int mNetworkId = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.054 -0400", hash_original_method = "5C896DC446B6DB5EAC37BD66E663CEA5", hash_generated_method = "A6B4E6684301834C9B993D832B63288A")
    public  CdmaCellLocation() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.055 -0400", hash_original_method = "8EA08E2DEACD96E97EA367485FCE09D0", hash_generated_method = "8F9524D6F69E9AD19BD6E67135034EBD")
    public  CdmaCellLocation(Bundle bundle) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.056 -0400", hash_original_method = "5BA2DB973405907BCB7576020C4BB767", hash_generated_method = "002C59EF0B27D60359AB7835E79B39F2")
    public int getBaseStationId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565812152 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565812152;
        // ---------- Original Method ----------
        //return this.mBaseStationId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.056 -0400", hash_original_method = "8D32771FFADF2E37F4C4C4E7BB2945F8", hash_generated_method = "5E7FAB9AE21ABE7D6A20EFE5E154A37F")
    public int getBaseStationLatitude() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349650886 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349650886;
        // ---------- Original Method ----------
        //return this.mBaseStationLatitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.060 -0400", hash_original_method = "B2E759A184D0C15083668122E08B0641", hash_generated_method = "8FD0D34BFE1A8DB25DA31C5E9774808D")
    public int getBaseStationLongitude() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479229822 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479229822;
        // ---------- Original Method ----------
        //return this.mBaseStationLongitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.061 -0400", hash_original_method = "E5E4F22C1EB64E5BA2863333F6C891A3", hash_generated_method = "55B980E6B69CB663CBC6F9C2B5E6F181")
    public int getSystemId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627803779 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627803779;
        // ---------- Original Method ----------
        //return this.mSystemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.062 -0400", hash_original_method = "909C93F66AD557988A123F548D8C31FC", hash_generated_method = "FCB837E90C2CEFFEF1B85145D774622C")
    public int getNetworkId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137231717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137231717;
        // ---------- Original Method ----------
        //return this.mNetworkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.080 -0400", hash_original_method = "0C9042B8D6AE69440E11B69CE7953639", hash_generated_method = "677DCE7DC5322BDEF3694C512B2DB3B9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.081 -0400", hash_original_method = "61B794D65EE283C3FD04A14E94D0946D", hash_generated_method = "95DF98EF65A56ED2B9C5F0DB04FA3610")
    public void setCellLocationData(int baseStationId, int baseStationLatitude,
         int baseStationLongitude) {
        this.mBaseStationId = baseStationId;
        this.mBaseStationLatitude = baseStationLatitude;
        this.mBaseStationLongitude = baseStationLongitude;
        // ---------- Original Method ----------
        //this.mBaseStationId = baseStationId;
        //this.mBaseStationLatitude = baseStationLatitude;
        //this.mBaseStationLongitude = baseStationLongitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.095 -0400", hash_original_method = "4013196C0844C1883550E95EB904B1DA", hash_generated_method = "8A3DA43B0D301E0F9071C09FBAB3053B")
    public void setCellLocationData(int baseStationId, int baseStationLatitude,
         int baseStationLongitude, int systemId, int networkId) {
        this.mBaseStationId = baseStationId;
        this.mBaseStationLatitude = baseStationLatitude;
        this.mBaseStationLongitude = baseStationLongitude;
        this.mSystemId = systemId;
        this.mNetworkId = networkId;
        // ---------- Original Method ----------
        //this.mBaseStationId = baseStationId;
        //this.mBaseStationLatitude = baseStationLatitude;
        //this.mBaseStationLongitude = baseStationLongitude;
        //this.mSystemId = systemId;
        //this.mNetworkId = networkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.095 -0400", hash_original_method = "E85418559CBFBFDF0470CD6A904DEAD1", hash_generated_method = "CCB5225ADAD9E43D454B1963412FE7D3")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_329866041 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_329866041;
        // ---------- Original Method ----------
        //return this.mBaseStationId ^ this.mBaseStationLatitude ^ this.mBaseStationLongitude
                //^ this.mSystemId ^ this.mNetworkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.096 -0400", hash_original_method = "38D738FF275D66A3A0FE767FC9AC4FB9", hash_generated_method = "32BA2D885BB9CA163B68F22661F8CBE6")
    @Override
    public boolean equals(Object o) {
        CdmaCellLocation s;
        try 
        {
            s = (CdmaCellLocation)o;
        } //End block
        catch (ClassCastException ex)
        { }
        boolean varF7FAA7223520EA38037273760A9832FA_248095172 = ((equalsHandlesNulls(this.mBaseStationId, s.mBaseStationId) &&
                equalsHandlesNulls(this.mBaseStationLatitude, s.mBaseStationLatitude) &&
                equalsHandlesNulls(this.mBaseStationLongitude, s.mBaseStationLongitude) &&
                equalsHandlesNulls(this.mSystemId, s.mSystemId) &&
                equalsHandlesNulls(this.mNetworkId, s.mNetworkId)
        ));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1194018776 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1194018776;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.097 -0400", hash_original_method = "3AD4832D3A3F9EB2D9CB5CAE1051FD90", hash_generated_method = "E7D68CBA759E883293AC6569C4095A4A")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1536417449 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1536417449 = "[" + this.mBaseStationId + ","
                   + this.mBaseStationLatitude + ","
                   + this.mBaseStationLongitude + ","
                   + this.mSystemId + ","
                   + this.mNetworkId + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1536417449.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1536417449;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.099 -0400", hash_original_method = "A94D1CCD0A9181704E5BCB2385E1DEF3", hash_generated_method = "D0474282778EBEC9FB86F8958E095702")
    public void fillInNotifierBundle(Bundle bundleToFill) {
        bundleToFill.putInt("baseStationId", this.mBaseStationId);
        bundleToFill.putInt("baseStationLatitude", this.mBaseStationLatitude);
        bundleToFill.putInt("baseStationLongitude", this.mBaseStationLongitude);
        bundleToFill.putInt("systemId", this.mSystemId);
        bundleToFill.putInt("networkId", this.mNetworkId);
        addTaint(bundleToFill.getTaint());
        // ---------- Original Method ----------
        //bundleToFill.putInt("baseStationId", this.mBaseStationId);
        //bundleToFill.putInt("baseStationLatitude", this.mBaseStationLatitude);
        //bundleToFill.putInt("baseStationLongitude", this.mBaseStationLongitude);
        //bundleToFill.putInt("systemId", this.mSystemId);
        //bundleToFill.putInt("networkId", this.mNetworkId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.099 -0400", hash_original_method = "8DF1697B3E0EEA68CA131C0067500EBA", hash_generated_method = "F175FF5E4FFBCAC5DE1B4DA670AED194")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672049841 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672049841;
        // ---------- Original Method ----------
        //return (this.mBaseStationId == -1 &&
                //this.mBaseStationLatitude == INVALID_LAT_LONG &&
                //this.mBaseStationLongitude == INVALID_LAT_LONG &&
                //this.mSystemId == -1 &&
                //this.mNetworkId == -1);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.099 -0400", hash_original_field = "3F7F839DCCF54CFE34E5B7E72480D008", hash_generated_field = "28DC8731CB240B39E76829C4149A3B3B")

    public final static int INVALID_LAT_LONG = Integer.MAX_VALUE;
}

