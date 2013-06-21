package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class CallIdentifier extends SIPObject {
    protected String localId;
    protected String host;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.845 -0400", hash_original_method = "725C6736E3C17143B15C26E546AA8C2D", hash_generated_method = "9B9DCA6066999CD4A4D71B400C05A796")
    @DSModeled(DSC.SAFE)
    public CallIdentifier() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.845 -0400", hash_original_method = "FA95D86B0844593C9B40E5A0309137C0", hash_generated_method = "BF02555C5B71106589CD2DFD4BE1B3E6")
    @DSModeled(DSC.SAFE)
    public CallIdentifier(String localId, String host) {
        dsTaint.addTaint(host);
        dsTaint.addTaint(localId);
        // ---------- Original Method ----------
        //this.localId = localId;
        //this.host = host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.845 -0400", hash_original_method = "DC194AEEEBC974AB700C1882192F385A", hash_generated_method = "9BA30C42E48F34B858966B39A378EF64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CallIdentifier(String cid) throws IllegalArgumentException {
        dsTaint.addTaint(cid);
        setCallID(cid);
        // ---------- Original Method ----------
        //setCallID(cid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.845 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "4AD5F2FA09EBB5B74E1A675312508D1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_2015433516 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.846 -0400", hash_original_method = "BA99BEB4A81573E88FDC5269E1629A0E", hash_generated_method = "D82808E87B82A1E5C7956536711B78BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        buffer.append(localId);
        {
            buffer.append(AT).append(host);
        } //End block
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //buffer.append(localId);
        //if (host != null) {
            //buffer.append(AT).append(host);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.846 -0400", hash_original_method = "89691ECA244C4E1A9E04F5B4F61288E7", hash_generated_method = "31221B95D871B38837906737DBDEF922")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_598349119 = (!other.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        CallIdentifier that;
        that = (CallIdentifier) other;
        {
            boolean varBF9570C9524265024F1E557A4B8202FF_709197468 = (this.localId.compareTo(that.localId) != 0);
        } //End collapsed parenthetic
        {
            boolean var14EF96FC58D2EC327CE1927E8BA3D7A9_1797884776 = (host.compareToIgnoreCase(that.host) != 0);
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (other == null ) return false;
        //if (!other.getClass().equals(this.getClass())) {
            //return false;
        //}
        //CallIdentifier that = (CallIdentifier) other;
        //if (this.localId.compareTo(that.localId) != 0) {
            //return false;
        //}
        //if (this.host == that.host)
            //return true;
        //if ((this.host == null && that.host != null)
            //|| (this.host != null && that.host == null))
            //return false;
        //if (host.compareToIgnoreCase(that.host) != 0) {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.846 -0400", hash_original_method = "CE30DABED6DD49816A955450A93F0F59", hash_generated_method = "BAA5C184EFD808A8A0685C5369E03E1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Hash code called before id is set");
        } //End block
        int var72752CD5F1D9A5C1A22D8F84D012EE23_125294728 = (this.localId.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (this.localId  == null ) {
             //throw new UnsupportedOperationException("Hash code called before id is set");
        //}
        //return this.localId.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.846 -0400", hash_original_method = "842945DA69DE126BDF81117018A1E298", hash_generated_method = "09CBDFECEB244F70E1766A56AFD698D0")
    @DSModeled(DSC.SAFE)
    public String getLocalId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return localId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.847 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "5963FFD88478AF2B93ECD8C406035DCE")
    @DSModeled(DSC.SAFE)
    public String getHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.847 -0400", hash_original_method = "0AB9BF9EEACCCDCF81C792E2B80A49BD", hash_generated_method = "15A390C391BA65F43A1B02BF13305B41")
    @DSModeled(DSC.SAFE)
    public void setLocalId(String localId) {
        dsTaint.addTaint(localId);
        // ---------- Original Method ----------
        //this.localId = localId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.847 -0400", hash_original_method = "634BBA0AF80BB0AB1D1819140BE7D2A5", hash_generated_method = "F147A887A0C5DACB2FB95EEF9C5674D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCallID(String cid) throws IllegalArgumentException {
        dsTaint.addTaint(cid);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("NULL!");
        int index;
        index = cid.indexOf('@');
        {
            host = null;
        } //End block
        {
            localId = cid.substring(0, index);
            host = cid.substring(index + 1, cid.length());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("CallID  must be token@token or token");
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (cid == null)
            //throw new IllegalArgumentException("NULL!");
        //int index = cid.indexOf('@');
        //if (index == -1) {
            //localId = cid;
            //host = null;
        //} else {
            //localId = cid.substring(0, index);
            //host = cid.substring(index + 1, cid.length());
            //if (localId == null || host == null) {
                //throw new IllegalArgumentException("CallID  must be token@token or token");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.847 -0400", hash_original_method = "50061DDE3121AF364F9B69CF73D75DB1", hash_generated_method = "664FB474D4D6ADFFAADC5D5F7E2F12CA")
    @DSModeled(DSC.SAFE)
    public void setHost(String host) {
        dsTaint.addTaint(host);
        // ---------- Original Method ----------
        //this.host = host;
    }

    
    private static final long serialVersionUID = 7314773655675451377L;
}

