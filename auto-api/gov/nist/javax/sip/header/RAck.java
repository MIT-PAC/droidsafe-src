package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.InvalidArgumentException;
import java.text.ParseException;

public class RAck extends SIPHeader implements javax.sip.header.RAckHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.307 -0400", hash_original_field = "E9A77CB6D532BAD6B3C1F9AFF8D3456A", hash_generated_field = "90A1DBDECBC94B16131E7EAFCA83250F")

    protected long cSeqNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.307 -0400", hash_original_field = "9165AF4FCD38054297A85E5DFD02DC76", hash_generated_field = "0BFA342B8453938DE41E6CA4A7186CA9")

    protected long rSeqNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.307 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.307 -0400", hash_original_method = "7C5933C28B73D77B67311599A1BD6348", hash_generated_method = "B9F10F92D666D06433633A2E45A818B7")
    public  RAck() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.317 -0400", hash_original_method = "31F6FBF38938A8E830748EA5A3D758B3", hash_generated_method = "8EFC733F74AC99E1BE7B19F58DC1F1CB")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1905699914 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1905699914 = new StringBuffer().append(rSeqNumber).append(SP).append(
                cSeqNumber).append(SP).append(method).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1905699914.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1905699914;
        // ---------- Original Method ----------
        //return new StringBuffer().append(rSeqNumber).append(SP).append(
                //cSeqNumber).append(SP).append(method).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.318 -0400", hash_original_method = "717B64217AB1BDBD09BA8111F0B019A1", hash_generated_method = "7BDAA6A210035FF473CB1DB932D40458")
    public int getCSeqNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059878179 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059878179;
        // ---------- Original Method ----------
        //return (int) cSeqNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.318 -0400", hash_original_method = "718B34DE34C00921F3D0FF08E153D08E", hash_generated_method = "7878DB4480E97DF9D573D386979107BC")
    public long getCSeqNumberLong() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_703727053 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_703727053;
        // ---------- Original Method ----------
        //return cSeqNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.318 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "37EB4CB289A057EC83BD49434C6B3858")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_1076511770 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1076511770 = this.method;
        varB4EAC82CA7396A68D541C85D26508E83_1076511770.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1076511770;
        // ---------- Original Method ----------
        //return this.method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.319 -0400", hash_original_method = "F18C054E96BBFC72C2FB4D9E194B171A", hash_generated_method = "BE355B88A841FCA15F1CD535FBAEBF22")
    public int getRSeqNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1868613094 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1868613094;
        // ---------- Original Method ----------
        //return (int) rSeqNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.319 -0400", hash_original_method = "C47555692F5984E7397D2D721232A447", hash_generated_method = "53177C635774DC77B478B0105EFC25A9")
    public void setCSeqNumber(int cSeqNumber) throws InvalidArgumentException {
        this.setCSequenceNumber(cSeqNumber);
        addTaint(cSeqNumber);
        // ---------- Original Method ----------
        //this.setCSequenceNumber(cSeqNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.319 -0400", hash_original_method = "417A86B1B77116D6C3275A494BFCD4D5", hash_generated_method = "E85DCEE65E2288E3D9797383EC01CCC2")
    public void setMethod(String method) throws ParseException {
        this.method = method;
        // ---------- Original Method ----------
        //this.method = method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.324 -0400", hash_original_method = "BF53D6931E1144BDB37994BD814B2F3D", hash_generated_method = "29C5FA40773D1B0AD37537430AB6DAE5")
    public long getCSequenceNumber() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1875909355 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1875909355;
        // ---------- Original Method ----------
        //return this.cSeqNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.324 -0400", hash_original_method = "5B686B97AD60967CB1F8F2531F7AE87D", hash_generated_method = "21CA5C3A13D0455E56B53B18F5251334")
    public long getRSequenceNumber() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_375782976 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_375782976;
        // ---------- Original Method ----------
        //return this.rSeqNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.334 -0400", hash_original_method = "61A1EA2F1C73324A7B71E464128A3BB2", hash_generated_method = "E90B1195C679AE24147FA20DAB07F4F0")
    public void setCSequenceNumber(long cSeqNumber) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Bad CSeq # " + cSeqNumber);
        this.cSeqNumber = cSeqNumber;
        // ---------- Original Method ----------
        //if (cSeqNumber <= 0 || cSeqNumber > ((long) 1) << 32 - 1)
            //throw new InvalidArgumentException("Bad CSeq # " + cSeqNumber);
        //this.cSeqNumber = cSeqNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.334 -0400", hash_original_method = "CBE5EB0602C16E16F46451A7279E3ED5", hash_generated_method = "18E329379FFB53E1CDA712ADE9DBB9F2")
    public void setRSeqNumber(int rSeqNumber) throws InvalidArgumentException {
        this.setRSequenceNumber(rSeqNumber);
        addTaint(rSeqNumber);
        // ---------- Original Method ----------
        //this.setRSequenceNumber(rSeqNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.335 -0400", hash_original_method = "31F5BB280EB4BE3CAFCEE8170222695A", hash_generated_method = "580E610E2255CA085CEFD25F89BADB1B")
    public void setRSequenceNumber(long rSeqNumber) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Bad rSeq # " + rSeqNumber);
        this.rSeqNumber = rSeqNumber;
        // ---------- Original Method ----------
        //if (rSeqNumber <= 0 || cSeqNumber > ((long) 1) << 32 - 1)
            //throw new InvalidArgumentException("Bad rSeq # " + rSeqNumber);
        //this.rSeqNumber = rSeqNumber;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.335 -0400", hash_original_field = "708D86A2FAF0568BD7A5DF39F0E29E9A", hash_generated_field = "82DF17AE19273AC52397CD83A161158C")

    private static long serialVersionUID = 743999286077404118L;
}

