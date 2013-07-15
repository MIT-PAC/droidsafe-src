package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class CallIdentifier extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.113 -0400", hash_original_field = "DCE9A98B36C0C310FAD7389D09ECC427", hash_generated_field = "E0739543348EE12559B498D426D0BA5B")

    protected String localId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.113 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "B7178EBD81D0CF23E79BD79FD4385F5A")

    protected String host;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.113 -0400", hash_original_method = "725C6736E3C17143B15C26E546AA8C2D", hash_generated_method = "9B9DCA6066999CD4A4D71B400C05A796")
    public  CallIdentifier() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.114 -0400", hash_original_method = "FA95D86B0844593C9B40E5A0309137C0", hash_generated_method = "C0DB7A582E1DE893DDD4C612D25EF1A4")
    public  CallIdentifier(String localId, String host) {
        this.localId = localId;
        this.host = host;
        // ---------- Original Method ----------
        //this.localId = localId;
        //this.host = host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.114 -0400", hash_original_method = "DC194AEEEBC974AB700C1882192F385A", hash_generated_method = "2DE98CAEF4040EA53C45B07F85056575")
    public  CallIdentifier(String cid) throws IllegalArgumentException {
        addTaint(cid.getTaint());
        setCallID(cid);
        // ---------- Original Method ----------
        //setCallID(cid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.114 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "6817CDB1F0E689476DAC9FEF28CA88EF")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_381539049 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_381539049.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_381539049;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.115 -0400", hash_original_method = "BA99BEB4A81573E88FDC5269E1629A0E", hash_generated_method = "4FCFAE572C262696C460550F60E15AE1")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        buffer.append(localId);
    if(host != null)        
        {
            buffer.append(AT).append(host);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1373406188 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1373406188.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1373406188;
        // ---------- Original Method ----------
        //buffer.append(localId);
        //if (host != null) {
            //buffer.append(AT).append(host);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.115 -0400", hash_original_method = "89691ECA244C4E1A9E04F5B4F61288E7", hash_generated_method = "F8D826FF7FFDD27E430E72F6185BE81C")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(other == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_767268724 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_497913242 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_497913242;
        }
    if(!other.getClass().equals(this.getClass()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_764611933 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2102577989 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2102577989;
        } //End block
        CallIdentifier that = (CallIdentifier) other;
    if(this.localId.compareTo(that.localId) != 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1068736617 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_481006071 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_481006071;
        } //End block
    if(this.host == that.host)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1853193399 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_256432948 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_256432948;
        }
    if((this.host == null && that.host != null)
            || (this.host != null && that.host == null))        
        {
        boolean var68934A3E9455FA72420237EB05902327_2121404273 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1303865846 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1303865846;
        }
    if(host.compareToIgnoreCase(that.host) != 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_587613325 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2092385784 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2092385784;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_808305440 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1381003170 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1381003170;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.116 -0400", hash_original_method = "CE30DABED6DD49816A955450A93F0F59", hash_generated_method = "336577F3798F348926A339D5A06137F1")
    @Override
    public int hashCode() {
    if(this.localId  == null)        
        {
            UnsupportedOperationException var1DF8693A1D5EF1D02144F02810D80405_587320594 = new UnsupportedOperationException("Hash code called before id is set");
            var1DF8693A1D5EF1D02144F02810D80405_587320594.addTaint(taint);
            throw var1DF8693A1D5EF1D02144F02810D80405_587320594;
        } //End block
        int varE319146F867F5CD7F7BC8A7C55C70EDE_907201926 = (this.localId.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608651415 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608651415;
        // ---------- Original Method ----------
        //if (this.localId  == null ) {
             //throw new UnsupportedOperationException("Hash code called before id is set");
        //}
        //return this.localId.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.116 -0400", hash_original_method = "842945DA69DE126BDF81117018A1E298", hash_generated_method = "2E1F419DB20A32B2EF98E0C4A97BE081")
    public String getLocalId() {
String var90D04EB3A2BC9A2B47743CBF5887EE35_2048861058 =         localId;
        var90D04EB3A2BC9A2B47743CBF5887EE35_2048861058.addTaint(taint);
        return var90D04EB3A2BC9A2B47743CBF5887EE35_2048861058;
        // ---------- Original Method ----------
        //return localId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.116 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "C356CB4C665405DD683BF4B7C8D10195")
    public String getHost() {
String var872E07117C05F1A34EC24B57B694B8E3_1507218619 =         host;
        var872E07117C05F1A34EC24B57B694B8E3_1507218619.addTaint(taint);
        return var872E07117C05F1A34EC24B57B694B8E3_1507218619;
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.117 -0400", hash_original_method = "0AB9BF9EEACCCDCF81C792E2B80A49BD", hash_generated_method = "B25AB12FE689784887B4988DF74D0163")
    public void setLocalId(String localId) {
        this.localId = localId;
        // ---------- Original Method ----------
        //this.localId = localId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.118 -0400", hash_original_method = "634BBA0AF80BB0AB1D1819140BE7D2A5", hash_generated_method = "C3310103FC0263AE264F2E692592C9F1")
    public void setCallID(String cid) throws IllegalArgumentException {
    if(cid == null)        
        {
        IllegalArgumentException var76B09EB5BAD2860D3A417FCF2330768C_1649412643 = new IllegalArgumentException("NULL!");
        var76B09EB5BAD2860D3A417FCF2330768C_1649412643.addTaint(taint);
        throw var76B09EB5BAD2860D3A417FCF2330768C_1649412643;
        }
        int index = cid.indexOf('@');
    if(index == -1)        
        {
            localId = cid;
            host = null;
        } //End block
        else
        {
            localId = cid.substring(0, index);
            host = cid.substring(index + 1, cid.length());
    if(localId == null || host == null)            
            {
                IllegalArgumentException varD78AB02BD8CE632147582DFE0FE08846_543408526 = new IllegalArgumentException("CallID  must be token@token or token");
                varD78AB02BD8CE632147582DFE0FE08846_543408526.addTaint(taint);
                throw varD78AB02BD8CE632147582DFE0FE08846_543408526;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.119 -0400", hash_original_method = "50061DDE3121AF364F9B69CF73D75DB1", hash_generated_method = "8B7526142A00FCD16001137F323106D3")
    public void setHost(String host) {
        this.host = host;
        // ---------- Original Method ----------
        //this.host = host;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.119 -0400", hash_original_field = "A7CDAEE5AAB46814E7BE1EC0E776EA02", hash_generated_field = "A04AE76734793B24A3254EFC13B52182")

    private static final long serialVersionUID = 7314773655675451377L;
}

