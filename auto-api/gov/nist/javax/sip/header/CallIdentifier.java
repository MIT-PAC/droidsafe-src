package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class CallIdentifier extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.636 -0400", hash_original_field = "DCE9A98B36C0C310FAD7389D09ECC427", hash_generated_field = "E0739543348EE12559B498D426D0BA5B")

    protected String localId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.636 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "B7178EBD81D0CF23E79BD79FD4385F5A")

    protected String host;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.642 -0400", hash_original_method = "725C6736E3C17143B15C26E546AA8C2D", hash_generated_method = "9B9DCA6066999CD4A4D71B400C05A796")
    public  CallIdentifier() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.653 -0400", hash_original_method = "FA95D86B0844593C9B40E5A0309137C0", hash_generated_method = "C0DB7A582E1DE893DDD4C612D25EF1A4")
    public  CallIdentifier(String localId, String host) {
        this.localId = localId;
        this.host = host;
        // ---------- Original Method ----------
        //this.localId = localId;
        //this.host = host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.653 -0400", hash_original_method = "DC194AEEEBC974AB700C1882192F385A", hash_generated_method = "499BF38FAD895C8C9E760BA6F69C10BA")
    public  CallIdentifier(String cid) throws IllegalArgumentException {
        setCallID(cid);
        addTaint(cid.getTaint());
        // ---------- Original Method ----------
        //setCallID(cid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.653 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "96D81F99B21A86FFA0A1078E49AA74DD")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_605174535 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_605174535 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_605174535.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_605174535;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.654 -0400", hash_original_method = "BA99BEB4A81573E88FDC5269E1629A0E", hash_generated_method = "8E032F947B2F07E62988FE1EE678EB3B")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_643732757 = null; //Variable for return #1
        buffer.append(localId);
        {
            buffer.append(AT).append(host);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_643732757 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_643732757.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_643732757;
        // ---------- Original Method ----------
        //buffer.append(localId);
        //if (host != null) {
            //buffer.append(AT).append(host);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.655 -0400", hash_original_method = "89691ECA244C4E1A9E04F5B4F61288E7", hash_generated_method = "F3CFCA8D7BF27BAE1046EA0974106C8B")
    public boolean equals(Object other) {
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_234625335 = (!other.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        CallIdentifier that;
        that = (CallIdentifier) other;
        {
            boolean varBF9570C9524265024F1E557A4B8202FF_1680082288 = (this.localId.compareTo(that.localId) != 0);
        } //End collapsed parenthetic
        {
            boolean var14EF96FC58D2EC327CE1927E8BA3D7A9_243670079 = (host.compareToIgnoreCase(that.host) != 0);
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_604583159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_604583159;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.655 -0400", hash_original_method = "CE30DABED6DD49816A955450A93F0F59", hash_generated_method = "42AD3AF149535A44BC016EEBF6785ED0")
    @Override
    public int hashCode() {
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Hash code called before id is set");
        } //End block
        int var72752CD5F1D9A5C1A22D8F84D012EE23_246540921 = (this.localId.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199612453 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199612453;
        // ---------- Original Method ----------
        //if (this.localId  == null ) {
             //throw new UnsupportedOperationException("Hash code called before id is set");
        //}
        //return this.localId.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.656 -0400", hash_original_method = "842945DA69DE126BDF81117018A1E298", hash_generated_method = "BCC7A9912F06D742F12A73DD32BA08F2")
    public String getLocalId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1456143128 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1456143128 = localId;
        varB4EAC82CA7396A68D541C85D26508E83_1456143128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1456143128;
        // ---------- Original Method ----------
        //return localId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.657 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "0AB5415CE94A341708DC20AAA4647CC3")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_754681484 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_754681484 = host;
        varB4EAC82CA7396A68D541C85D26508E83_754681484.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_754681484;
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.657 -0400", hash_original_method = "0AB9BF9EEACCCDCF81C792E2B80A49BD", hash_generated_method = "B25AB12FE689784887B4988DF74D0163")
    public void setLocalId(String localId) {
        this.localId = localId;
        // ---------- Original Method ----------
        //this.localId = localId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.666 -0400", hash_original_method = "634BBA0AF80BB0AB1D1819140BE7D2A5", hash_generated_method = "B01FBD3641C0D417C056193A7B0F200F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.666 -0400", hash_original_method = "50061DDE3121AF364F9B69CF73D75DB1", hash_generated_method = "8B7526142A00FCD16001137F323106D3")
    public void setHost(String host) {
        this.host = host;
        // ---------- Original Method ----------
        //this.host = host;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.666 -0400", hash_original_field = "A7CDAEE5AAB46814E7BE1EC0E776EA02", hash_generated_field = "B5DECA272C914646646D5059DB41FA63")

    private static long serialVersionUID = 7314773655675451377L;
}

