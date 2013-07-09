package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.InvalidArgumentException;
import java.text.ParseException;

public class RAck extends SIPHeader implements javax.sip.header.RAckHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.961 -0400", hash_original_field = "E9A77CB6D532BAD6B3C1F9AFF8D3456A", hash_generated_field = "90A1DBDECBC94B16131E7EAFCA83250F")

    protected long cSeqNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.961 -0400", hash_original_field = "9165AF4FCD38054297A85E5DFD02DC76", hash_generated_field = "0BFA342B8453938DE41E6CA4A7186CA9")

    protected long rSeqNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.961 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.961 -0400", hash_original_method = "7C5933C28B73D77B67311599A1BD6348", hash_generated_method = "B9F10F92D666D06433633A2E45A818B7")
    public  RAck() {
        super(NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.962 -0400", hash_original_method = "31F6FBF38938A8E830748EA5A3D758B3", hash_generated_method = "85648D95B034230A3FCB77C7CFBEE114")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_93215108 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_93215108 = new StringBuffer().append(rSeqNumber).append(SP).append(
                cSeqNumber).append(SP).append(method).toString();
        varB4EAC82CA7396A68D541C85D26508E83_93215108.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_93215108;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.963 -0400", hash_original_method = "717B64217AB1BDBD09BA8111F0B019A1", hash_generated_method = "53FE4F2D27CB95DAA4B7DF52F824A195")
    public int getCSeqNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_487547808 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_487547808;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.963 -0400", hash_original_method = "718B34DE34C00921F3D0FF08E153D08E", hash_generated_method = "17493BF73D778F5F30E35329A3477553")
    public long getCSeqNumberLong() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1044394604 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1044394604;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.964 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "8C9B74321C2F57B50BD7767BB4E96388")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_343281912 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_343281912 = this.method;
        varB4EAC82CA7396A68D541C85D26508E83_343281912.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_343281912;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.964 -0400", hash_original_method = "F18C054E96BBFC72C2FB4D9E194B171A", hash_generated_method = "7C593E925FF47F9045AE92D83E17BA4E")
    public int getRSeqNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365031310 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365031310;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.964 -0400", hash_original_method = "C47555692F5984E7397D2D721232A447", hash_generated_method = "53177C635774DC77B478B0105EFC25A9")
    public void setCSeqNumber(int cSeqNumber) throws InvalidArgumentException {
        this.setCSequenceNumber(cSeqNumber);
        addTaint(cSeqNumber);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.965 -0400", hash_original_method = "417A86B1B77116D6C3275A494BFCD4D5", hash_generated_method = "E85DCEE65E2288E3D9797383EC01CCC2")
    public void setMethod(String method) throws ParseException {
        this.method = method;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.965 -0400", hash_original_method = "BF53D6931E1144BDB37994BD814B2F3D", hash_generated_method = "9D0C5E88E2DFEC697CD6E1B1AB6A745D")
    public long getCSequenceNumber() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1292498435 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1292498435;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.965 -0400", hash_original_method = "5B686B97AD60967CB1F8F2531F7AE87D", hash_generated_method = "2A836C6FB5C54D4722CFE673A324E9BB")
    public long getRSequenceNumber() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_297382354 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_297382354;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.965 -0400", hash_original_method = "61A1EA2F1C73324A7B71E464128A3BB2", hash_generated_method = "E90B1195C679AE24147FA20DAB07F4F0")
    public void setCSequenceNumber(long cSeqNumber) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Bad CSeq # " + cSeqNumber);
        this.cSeqNumber = cSeqNumber;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.966 -0400", hash_original_method = "CBE5EB0602C16E16F46451A7279E3ED5", hash_generated_method = "18E329379FFB53E1CDA712ADE9DBB9F2")
    public void setRSeqNumber(int rSeqNumber) throws InvalidArgumentException {
        this.setRSequenceNumber(rSeqNumber);
        addTaint(rSeqNumber);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.966 -0400", hash_original_method = "31F5BB280EB4BE3CAFCEE8170222695A", hash_generated_method = "580E610E2255CA085CEFD25F89BADB1B")
    public void setRSequenceNumber(long rSeqNumber) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Bad rSeq # " + rSeqNumber);
        this.rSeqNumber = rSeqNumber;
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.966 -0400", hash_original_field = "708D86A2FAF0568BD7A5DF39F0E29E9A", hash_generated_field = "7D32B1C47FED303719E2DC0EBD9FC96B")

    private static final long serialVersionUID = 743999286077404118L;
}

