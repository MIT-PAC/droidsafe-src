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
    protected long cSeqNumber;
    protected long rSeqNumber;
    protected String method;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.091 -0400", hash_original_method = "7C5933C28B73D77B67311599A1BD6348", hash_generated_method = "B9F10F92D666D06433633A2E45A818B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RAck() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.091 -0400", hash_original_method = "31F6FBF38938A8E830748EA5A3D758B3", hash_generated_method = "7D302640ADA986CBA29755879C875A27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        String var79219C1BD42D1BF5744ACC65C9D85A84_2105838329 = (new StringBuffer().append(rSeqNumber).append(SP).append(
                cSeqNumber).append(SP).append(method).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return new StringBuffer().append(rSeqNumber).append(SP).append(
                //cSeqNumber).append(SP).append(method).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.091 -0400", hash_original_method = "717B64217AB1BDBD09BA8111F0B019A1", hash_generated_method = "4B4D276C0E63D93BC315824001F0ED27")
    @DSModeled(DSC.SAFE)
    public int getCSeqNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) cSeqNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.091 -0400", hash_original_method = "718B34DE34C00921F3D0FF08E153D08E", hash_generated_method = "E0A01BDF46E25817E30C5184111A70EF")
    @DSModeled(DSC.SAFE)
    public long getCSeqNumberLong() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return cSeqNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.092 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "E416FDFFB284E6CD1525F551DC901FBA")
    @DSModeled(DSC.SAFE)
    public String getMethod() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.092 -0400", hash_original_method = "F18C054E96BBFC72C2FB4D9E194B171A", hash_generated_method = "40EBE9ABB4CF9E19BA7F92D590EC0B08")
    @DSModeled(DSC.SAFE)
    public int getRSeqNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) rSeqNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.092 -0400", hash_original_method = "C47555692F5984E7397D2D721232A447", hash_generated_method = "C2FFED85E7BAC74006D17DD58AA84083")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCSeqNumber(int cSeqNumber) throws InvalidArgumentException {
        dsTaint.addTaint(cSeqNumber);
        this.setCSequenceNumber(cSeqNumber);
        // ---------- Original Method ----------
        //this.setCSequenceNumber(cSeqNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.093 -0400", hash_original_method = "417A86B1B77116D6C3275A494BFCD4D5", hash_generated_method = "4068B94A030093435A7A1ECE2F6E1B05")
    @DSModeled(DSC.SAFE)
    public void setMethod(String method) throws ParseException {
        dsTaint.addTaint(method);
        // ---------- Original Method ----------
        //this.method = method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.093 -0400", hash_original_method = "BF53D6931E1144BDB37994BD814B2F3D", hash_generated_method = "47CF571AE0C5B03EF59436DFF67893B2")
    @DSModeled(DSC.SAFE)
    public long getCSequenceNumber() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return this.cSeqNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.093 -0400", hash_original_method = "5B686B97AD60967CB1F8F2531F7AE87D", hash_generated_method = "DF21D828150DDCD4CAA08AF28A38AE2E")
    @DSModeled(DSC.SAFE)
    public long getRSequenceNumber() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return this.rSeqNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.093 -0400", hash_original_method = "61A1EA2F1C73324A7B71E464128A3BB2", hash_generated_method = "32B0B2696D1A9AB1A5338B37CBAD2E58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCSequenceNumber(long cSeqNumber) throws InvalidArgumentException {
        dsTaint.addTaint(cSeqNumber);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Bad CSeq # " + cSeqNumber);
        // ---------- Original Method ----------
        //if (cSeqNumber <= 0 || cSeqNumber > ((long) 1) << 32 - 1)
            //throw new InvalidArgumentException("Bad CSeq # " + cSeqNumber);
        //this.cSeqNumber = cSeqNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.093 -0400", hash_original_method = "CBE5EB0602C16E16F46451A7279E3ED5", hash_generated_method = "15350C1F9EEDA7C2B76A387F9FE8D7F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRSeqNumber(int rSeqNumber) throws InvalidArgumentException {
        dsTaint.addTaint(rSeqNumber);
        this.setRSequenceNumber(rSeqNumber);
        // ---------- Original Method ----------
        //this.setRSequenceNumber(rSeqNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.094 -0400", hash_original_method = "31F5BB280EB4BE3CAFCEE8170222695A", hash_generated_method = "1D8394E33FD624E6BCA2BE203D523021")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRSequenceNumber(long rSeqNumber) throws InvalidArgumentException {
        dsTaint.addTaint(rSeqNumber);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Bad rSeq # " + rSeqNumber);
        // ---------- Original Method ----------
        //if (rSeqNumber <= 0 || cSeqNumber > ((long) 1) << 32 - 1)
            //throw new InvalidArgumentException("Bad rSeq # " + rSeqNumber);
        //this.rSeqNumber = rSeqNumber;
    }

    
    private static final long serialVersionUID = 743999286077404118L;
}

