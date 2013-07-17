package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class CallIdentifier extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.121 -0400", hash_original_field = "DCE9A98B36C0C310FAD7389D09ECC427", hash_generated_field = "E0739543348EE12559B498D426D0BA5B")

    protected String localId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.121 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "B7178EBD81D0CF23E79BD79FD4385F5A")

    protected String host;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.121 -0400", hash_original_method = "725C6736E3C17143B15C26E546AA8C2D", hash_generated_method = "9B9DCA6066999CD4A4D71B400C05A796")
    public  CallIdentifier() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.122 -0400", hash_original_method = "FA95D86B0844593C9B40E5A0309137C0", hash_generated_method = "C0DB7A582E1DE893DDD4C612D25EF1A4")
    public  CallIdentifier(String localId, String host) {
        this.localId = localId;
        this.host = host;
        // ---------- Original Method ----------
        //this.localId = localId;
        //this.host = host;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.123 -0400", hash_original_method = "DC194AEEEBC974AB700C1882192F385A", hash_generated_method = "2DE98CAEF4040EA53C45B07F85056575")
    public  CallIdentifier(String cid) throws IllegalArgumentException {
        addTaint(cid.getTaint());
        setCallID(cid);
        // ---------- Original Method ----------
        //setCallID(cid);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.123 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "609C92839CAF03F026450A7158709617")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_549512220 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_549512220.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_549512220;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.123 -0400", hash_original_method = "BA99BEB4A81573E88FDC5269E1629A0E", hash_generated_method = "174828A9423ED77F6A3A94EE948B47F1")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        buffer.append(localId);
        if(host != null)        
        {
            buffer.append(AT).append(host);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_129447561 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_129447561.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_129447561;
        // ---------- Original Method ----------
        //buffer.append(localId);
        //if (host != null) {
            //buffer.append(AT).append(host);
        //}
        //return buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.124 -0400", hash_original_method = "89691ECA244C4E1A9E04F5B4F61288E7", hash_generated_method = "D4D14F5C2626535B7F654C89156139EB")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(other == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1770905609 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1510244515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1510244515;
        }
        if(!other.getClass().equals(this.getClass()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1038900685 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_996425484 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_996425484;
        } //End block
        CallIdentifier that = (CallIdentifier) other;
        if(this.localId.compareTo(that.localId) != 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_2082736259 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_567081835 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_567081835;
        } //End block
        if(this.host == that.host)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1882115464 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_923331020 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_923331020;
        }
        if((this.host == null && that.host != null)
            || (this.host != null && that.host == null))        
        {
        boolean var68934A3E9455FA72420237EB05902327_126444555 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_638203388 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_638203388;
        }
        if(host.compareToIgnoreCase(that.host) != 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1880817150 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1336256030 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1336256030;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1784071131 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_254616802 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_254616802;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.124 -0400", hash_original_method = "CE30DABED6DD49816A955450A93F0F59", hash_generated_method = "EBFBF7702021D4F470B2F573DD885A92")
    @Override
    public int hashCode() {
        if(this.localId  == null)        
        {
            UnsupportedOperationException var1DF8693A1D5EF1D02144F02810D80405_52057702 = new UnsupportedOperationException("Hash code called before id is set");
            var1DF8693A1D5EF1D02144F02810D80405_52057702.addTaint(taint);
            throw var1DF8693A1D5EF1D02144F02810D80405_52057702;
        } //End block
        int varE319146F867F5CD7F7BC8A7C55C70EDE_1173574757 = (this.localId.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1933724142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1933724142;
        // ---------- Original Method ----------
        //if (this.localId  == null ) {
             //throw new UnsupportedOperationException("Hash code called before id is set");
        //}
        //return this.localId.hashCode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.125 -0400", hash_original_method = "842945DA69DE126BDF81117018A1E298", hash_generated_method = "9CDA12BF158FB4753BAE5A2F81EA1BCF")
    public String getLocalId() {
String var90D04EB3A2BC9A2B47743CBF5887EE35_1497303846 =         localId;
        var90D04EB3A2BC9A2B47743CBF5887EE35_1497303846.addTaint(taint);
        return var90D04EB3A2BC9A2B47743CBF5887EE35_1497303846;
        // ---------- Original Method ----------
        //return localId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.125 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "2B80171EC20AB90E70D482BC1AEE93F9")
    public String getHost() {
String var872E07117C05F1A34EC24B57B694B8E3_536134061 =         host;
        var872E07117C05F1A34EC24B57B694B8E3_536134061.addTaint(taint);
        return var872E07117C05F1A34EC24B57B694B8E3_536134061;
        // ---------- Original Method ----------
        //return host;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.125 -0400", hash_original_method = "0AB9BF9EEACCCDCF81C792E2B80A49BD", hash_generated_method = "B25AB12FE689784887B4988DF74D0163")
    public void setLocalId(String localId) {
        this.localId = localId;
        // ---------- Original Method ----------
        //this.localId = localId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.127 -0400", hash_original_method = "634BBA0AF80BB0AB1D1819140BE7D2A5", hash_generated_method = "3AE25D94BF8EAB8A401A492DFBC8364F")
    public void setCallID(String cid) throws IllegalArgumentException {
        if(cid == null)        
        {
        IllegalArgumentException var76B09EB5BAD2860D3A417FCF2330768C_165587112 = new IllegalArgumentException("NULL!");
        var76B09EB5BAD2860D3A417FCF2330768C_165587112.addTaint(taint);
        throw var76B09EB5BAD2860D3A417FCF2330768C_165587112;
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
                IllegalArgumentException varD78AB02BD8CE632147582DFE0FE08846_1875705207 = new IllegalArgumentException("CallID  must be token@token or token");
                varD78AB02BD8CE632147582DFE0FE08846_1875705207.addTaint(taint);
                throw varD78AB02BD8CE632147582DFE0FE08846_1875705207;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.128 -0400", hash_original_method = "50061DDE3121AF364F9B69CF73D75DB1", hash_generated_method = "8B7526142A00FCD16001137F323106D3")
    public void setHost(String host) {
        this.host = host;
        // ---------- Original Method ----------
        //this.host = host;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.128 -0400", hash_original_field = "A7CDAEE5AAB46814E7BE1EC0E776EA02", hash_generated_field = "A04AE76734793B24A3254EFC13B52182")

    private static final long serialVersionUID = 7314773655675451377L;
}

