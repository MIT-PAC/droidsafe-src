package android.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.telephony.CellLocation;

public class CdmaCellLocation extends CellLocation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.718 -0400", hash_original_field = "2B9F88F31AD9FCE7ABFBB18752950285", hash_generated_field = "880CD477F89AEF4CABEE47659812611F")

    private int mBaseStationId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.718 -0400", hash_original_field = "A4905204300C202E8EC2868687891FB1", hash_generated_field = "F33E82AA4D4032A9950970FEC5999108")

    private int mBaseStationLatitude = INVALID_LAT_LONG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.718 -0400", hash_original_field = "541CA7BA4B615865A9786E9ED80E68C2", hash_generated_field = "72B050148DB085190086BCC6506DAE80")

    private int mBaseStationLongitude = INVALID_LAT_LONG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.718 -0400", hash_original_field = "A2C016429B67E11504F428C6C56EF165", hash_generated_field = "5B31DE8CC89DD13B11EA69E8D17F6B69")

    private int mSystemId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.719 -0400", hash_original_field = "D8D1D4C0DE12D0696DFA216CCA322C8C", hash_generated_field = "61B4BCE8DF023A8A81D64AB2D58B0D50")

    private int mNetworkId = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.719 -0400", hash_original_method = "5C896DC446B6DB5EAC37BD66E663CEA5", hash_generated_method = "A6B4E6684301834C9B993D832B63288A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.720 -0400", hash_original_method = "8EA08E2DEACD96E97EA367485FCE09D0", hash_generated_method = "8F9524D6F69E9AD19BD6E67135034EBD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.721 -0400", hash_original_method = "5BA2DB973405907BCB7576020C4BB767", hash_generated_method = "ED79183241E911A02CADDEB67E7995B1")
    public int getBaseStationId() {
        int var83DE69BDE54D9DD130453E5F2CB98A4F_59585234 = (this.mBaseStationId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181498993 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181498993;
        // ---------- Original Method ----------
        //return this.mBaseStationId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.721 -0400", hash_original_method = "8D32771FFADF2E37F4C4C4E7BB2945F8", hash_generated_method = "FDBBB60D6486707E8F8E62B504326D2C")
    public int getBaseStationLatitude() {
        int varD18636815E0D0DF6EA3F7C118258ED98_1135826708 = (this.mBaseStationLatitude);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_541391277 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_541391277;
        // ---------- Original Method ----------
        //return this.mBaseStationLatitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.721 -0400", hash_original_method = "B2E759A184D0C15083668122E08B0641", hash_generated_method = "A47F9B97D7616B259EF552A745EC3326")
    public int getBaseStationLongitude() {
        int var0C827E6E4C71764E5957681DD67AB006_1598289313 = (this.mBaseStationLongitude);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052010069 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052010069;
        // ---------- Original Method ----------
        //return this.mBaseStationLongitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.721 -0400", hash_original_method = "E5E4F22C1EB64E5BA2863333F6C891A3", hash_generated_method = "04EC874B8F75B1ECBFD7677D98579191")
    public int getSystemId() {
        int varDC9AC627E8999951F7D1333DA260C4E1_504554422 = (this.mSystemId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_771148511 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_771148511;
        // ---------- Original Method ----------
        //return this.mSystemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.722 -0400", hash_original_method = "909C93F66AD557988A123F548D8C31FC", hash_generated_method = "284F46BFEF2A56E12E4AA9C18DC301B9")
    public int getNetworkId() {
        int varC36C789BAAC39C6FF0348461365E3AA8_569870999 = (this.mNetworkId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1068341373 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1068341373;
        // ---------- Original Method ----------
        //return this.mNetworkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.723 -0400", hash_original_method = "0C9042B8D6AE69440E11B69CE7953639", hash_generated_method = "677DCE7DC5322BDEF3694C512B2DB3B9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.724 -0400", hash_original_method = "61B794D65EE283C3FD04A14E94D0946D", hash_generated_method = "95DF98EF65A56ED2B9C5F0DB04FA3610")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.725 -0400", hash_original_method = "4013196C0844C1883550E95EB904B1DA", hash_generated_method = "8A3DA43B0D301E0F9071C09FBAB3053B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.725 -0400", hash_original_method = "E85418559CBFBFDF0470CD6A904DEAD1", hash_generated_method = "BBC2EFAE3337287FD5918DC403AFB421")
    @Override
    public int hashCode() {
        int var7B5336FB7E61EDE4E56D546B92DF3A34_777817690 = (this.mBaseStationId ^ this.mBaseStationLatitude ^ this.mBaseStationLongitude
                ^ this.mSystemId ^ this.mNetworkId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1490286353 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1490286353;
        // ---------- Original Method ----------
        //return this.mBaseStationId ^ this.mBaseStationLatitude ^ this.mBaseStationLongitude
                //^ this.mSystemId ^ this.mNetworkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.725 -0400", hash_original_method = "38D738FF275D66A3A0FE767FC9AC4FB9", hash_generated_method = "C3E762617D431F7F0D44C0F886F9F87C")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        CdmaCellLocation s;
        try 
        {
            s = (CdmaCellLocation)o;
        } //End block
        catch (ClassCastException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_1614797215 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2084996222 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2084996222;
        } //End block
    if(o == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_167399238 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_648540434 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_648540434;
        } //End block
        boolean varA7F8E6B062F01F0CC05C597986949F61_1794460216 = ((equalsHandlesNulls(this.mBaseStationId, s.mBaseStationId) &&
                equalsHandlesNulls(this.mBaseStationLatitude, s.mBaseStationLatitude) &&
                equalsHandlesNulls(this.mBaseStationLongitude, s.mBaseStationLongitude) &&
                equalsHandlesNulls(this.mSystemId, s.mSystemId) &&
                equalsHandlesNulls(this.mNetworkId, s.mNetworkId)
        ));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1476076099 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1476076099;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.726 -0400", hash_original_method = "3AD4832D3A3F9EB2D9CB5CAE1051FD90", hash_generated_method = "074AA48844F6F8339715F7902EE702D8")
    @Override
    public String toString() {
String varD00AE8B4DB8250B02A118CD67CC66F17_955463290 =         "[" + this.mBaseStationId + ","
                   + this.mBaseStationLatitude + ","
                   + this.mBaseStationLongitude + ","
                   + this.mSystemId + ","
                   + this.mNetworkId + "]";
        varD00AE8B4DB8250B02A118CD67CC66F17_955463290.addTaint(taint);
        return varD00AE8B4DB8250B02A118CD67CC66F17_955463290;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.726 -0400", hash_original_method = "A94D1CCD0A9181704E5BCB2385E1DEF3", hash_generated_method = "CAE0A0B8424A69B718E7AD066B6471D8")
    public void fillInNotifierBundle(Bundle bundleToFill) {
        addTaint(bundleToFill.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.727 -0400", hash_original_method = "8DF1697B3E0EEA68CA131C0067500EBA", hash_generated_method = "1794D8401C4AD6551BA43E8E7C63CC7B")
    public boolean isEmpty() {
        boolean var27982435A14BB8D93E80836A7CB07524_1431264457 = ((this.mBaseStationId == -1 &&
                this.mBaseStationLatitude == INVALID_LAT_LONG &&
                this.mBaseStationLongitude == INVALID_LAT_LONG &&
                this.mSystemId == -1 &&
                this.mNetworkId == -1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1603313009 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1603313009;
        // ---------- Original Method ----------
        //return (this.mBaseStationId == -1 &&
                //this.mBaseStationLatitude == INVALID_LAT_LONG &&
                //this.mBaseStationLongitude == INVALID_LAT_LONG &&
                //this.mSystemId == -1 &&
                //this.mNetworkId == -1);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.727 -0400", hash_original_field = "3F7F839DCCF54CFE34E5B7E72480D008", hash_generated_field = "28DC8731CB240B39E76829C4149A3B3B")

    public final static int INVALID_LAT_LONG = Integer.MAX_VALUE;
}

