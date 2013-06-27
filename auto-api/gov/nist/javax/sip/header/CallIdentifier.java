package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class CallIdentifier extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.482 -0400", hash_original_field = "DCE9A98B36C0C310FAD7389D09ECC427", hash_generated_field = "E0739543348EE12559B498D426D0BA5B")

    protected String localId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.483 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "B7178EBD81D0CF23E79BD79FD4385F5A")

    protected String host;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.483 -0400", hash_original_method = "725C6736E3C17143B15C26E546AA8C2D", hash_generated_method = "9B9DCA6066999CD4A4D71B400C05A796")
    public  CallIdentifier() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.483 -0400", hash_original_method = "FA95D86B0844593C9B40E5A0309137C0", hash_generated_method = "C0DB7A582E1DE893DDD4C612D25EF1A4")
    public  CallIdentifier(String localId, String host) {
        this.localId = localId;
        this.host = host;
        // ---------- Original Method ----------
        //this.localId = localId;
        //this.host = host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.484 -0400", hash_original_method = "DC194AEEEBC974AB700C1882192F385A", hash_generated_method = "499BF38FAD895C8C9E760BA6F69C10BA")
    public  CallIdentifier(String cid) throws IllegalArgumentException {
        setCallID(cid);
        addTaint(cid.getTaint());
        // ---------- Original Method ----------
        //setCallID(cid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.484 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "1105C7F7D968B32812CFC011C943E3A2")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1345112464 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1345112464 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1345112464.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1345112464;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.488 -0400", hash_original_method = "BA99BEB4A81573E88FDC5269E1629A0E", hash_generated_method = "4C5E3C9749EECFEEE2ACE505D95E1EAB")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1516530321 = null; //Variable for return #1
        buffer.append(localId);
        {
            buffer.append(AT).append(host);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1516530321 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1516530321.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1516530321;
        // ---------- Original Method ----------
        //buffer.append(localId);
        //if (host != null) {
            //buffer.append(AT).append(host);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.496 -0400", hash_original_method = "89691ECA244C4E1A9E04F5B4F61288E7", hash_generated_method = "0E418F2FB58F182A67CC2328D5EB7188")
    public boolean equals(Object other) {
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_2049932697 = (!other.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        CallIdentifier that;
        that = (CallIdentifier) other;
        {
            boolean varBF9570C9524265024F1E557A4B8202FF_90837627 = (this.localId.compareTo(that.localId) != 0);
        } //End collapsed parenthetic
        {
            boolean var14EF96FC58D2EC327CE1927E8BA3D7A9_1134503178 = (host.compareToIgnoreCase(that.host) != 0);
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_209453541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_209453541;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.501 -0400", hash_original_method = "CE30DABED6DD49816A955450A93F0F59", hash_generated_method = "A40D131F8F944D393D3A5C44EF2DD935")
    @Override
    public int hashCode() {
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Hash code called before id is set");
        } //End block
        int var72752CD5F1D9A5C1A22D8F84D012EE23_1901348213 = (this.localId.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1932521625 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1932521625;
        // ---------- Original Method ----------
        //if (this.localId  == null ) {
             //throw new UnsupportedOperationException("Hash code called before id is set");
        //}
        //return this.localId.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.501 -0400", hash_original_method = "842945DA69DE126BDF81117018A1E298", hash_generated_method = "BA78D80AC8564A9CF687477BCCA29B98")
    public String getLocalId() {
        String varB4EAC82CA7396A68D541C85D26508E83_275879496 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_275879496 = localId;
        varB4EAC82CA7396A68D541C85D26508E83_275879496.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_275879496;
        // ---------- Original Method ----------
        //return localId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.501 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "57DA9BD29B4D2E6B547DA0AE4BC2B2B7")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1716215514 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1716215514 = host;
        varB4EAC82CA7396A68D541C85D26508E83_1716215514.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1716215514;
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.502 -0400", hash_original_method = "0AB9BF9EEACCCDCF81C792E2B80A49BD", hash_generated_method = "B25AB12FE689784887B4988DF74D0163")
    public void setLocalId(String localId) {
        this.localId = localId;
        // ---------- Original Method ----------
        //this.localId = localId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.502 -0400", hash_original_method = "634BBA0AF80BB0AB1D1819140BE7D2A5", hash_generated_method = "B01FBD3641C0D417C056193A7B0F200F")
    public void setCallID(String cid) throws IllegalArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("NULL!");
        int index;
        index = cid.indexOf('@');
        {
            localId = cid;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.512 -0400", hash_original_method = "50061DDE3121AF364F9B69CF73D75DB1", hash_generated_method = "8B7526142A00FCD16001137F323106D3")
    public void setHost(String host) {
        this.host = host;
        // ---------- Original Method ----------
        //this.host = host;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.513 -0400", hash_original_field = "A7CDAEE5AAB46814E7BE1EC0E776EA02", hash_generated_field = "B5DECA272C914646646D5059DB41FA63")

    private static long serialVersionUID = 7314773655675451377L;
}

