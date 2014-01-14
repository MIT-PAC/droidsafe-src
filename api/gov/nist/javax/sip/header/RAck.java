package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.InvalidArgumentException;

public class RAck extends SIPHeader implements javax.sip.header.RAckHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.609 -0500", hash_original_field = "21224DB2CEFA4FDB2588A5AB9FA52719", hash_generated_field = "7D32B1C47FED303719E2DC0EBD9FC96B")

    private static final long serialVersionUID = 743999286077404118L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.613 -0500", hash_original_field = "8D723CA62ACF0900470804DB2E8B3A1B", hash_generated_field = "90A1DBDECBC94B16131E7EAFCA83250F")

    protected long cSeqNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.617 -0500", hash_original_field = "3501CEA861DDA8807A9A2CC4BD51D6A6", hash_generated_field = "0BFA342B8453938DE41E6CA4A7186CA9")

    protected long rSeqNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.620 -0500", hash_original_field = "842C170402669AC7A74293BBBFD3BC5D", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;

    /** Creates a new instance of RAck */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.623 -0500", hash_original_method = "7C5933C28B73D77B67311599A1BD6348", hash_generated_method = "CDB735DF58562B10FB6D23459A5ACA7C")
    
public RAck() {
        super(NAME);
    }

    /**
     * Encode the body of this header (the stuff that follows headerName). A.K.A
     * headerValue.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.626 -0500", hash_original_method = "31F6FBF38938A8E830748EA5A3D758B3", hash_generated_method = "54E3F8853B4F0637E7B3F1BC87878747")
    
protected String encodeBody() {
        // Bug reported by Bruno Konik - was encoded in
        // the wrong order.
        return new StringBuffer().append(rSeqNumber).append(SP).append(
                cSeqNumber).append(SP).append(method).toString();

    }

    /**
     * Gets the CSeq sequence number of this RAckHeader.
     *
     * @deprecated
     * @return the integer value of the cSeq number of the RAckHeader
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.631 -0500", hash_original_method = "717B64217AB1BDBD09BA8111F0B019A1", hash_generated_method = "CB776960DFF39BBEB9C58CD15DEDF34C")
    
public int getCSeqNumber() {
        return (int) cSeqNumber;
    }

    /**
     * Gets the CSeq sequence number of this RAckHeader.
     *
     * @return the integer value of the cSeq number of the RAckHeader
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.635 -0500", hash_original_method = "718B34DE34C00921F3D0FF08E153D08E", hash_generated_method = "913FDE8A56429D9E6964F9B28CE36D63")
    
public long getCSeqNumberLong() {
        return cSeqNumber;
    }

    /**
     * Gets the method of RAckHeader
     *
     * @return method of RAckHeader
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.638 -0500", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "7472B5026828D1D5EB47237766CBDA14")
    
public String getMethod() {
        return this.method;
    }

    /**
     * Gets the RSeq sequence number of this RAckHeader.
     *
     * @deprecated
     * @return the integer value of the RSeq number of the RAckHeader
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.641 -0500", hash_original_method = "F18C054E96BBFC72C2FB4D9E194B171A", hash_generated_method = "39322FB794AAC42317FD41F3205BFECD")
    
public int getRSeqNumber() {
        return (int) rSeqNumber;
    }

    /**
     * @deprecated
     * @see javax.sip.header.RAckHeader#setCSeqNumber(int)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.644 -0500", hash_original_method = "C47555692F5984E7397D2D721232A447", hash_generated_method = "27C70ABF257DD14AF80C3700BAD9D706")
    
public void setCSeqNumber(int cSeqNumber) throws InvalidArgumentException {
        this.setCSequenceNumber(cSeqNumber);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.647 -0500", hash_original_method = "417A86B1B77116D6C3275A494BFCD4D5", hash_generated_method = "E32A085D9A4E61586BE15FA8ED348AC2")
    
public void setMethod(String method) throws ParseException {
        this.method = method;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.650 -0500", hash_original_method = "BF53D6931E1144BDB37994BD814B2F3D", hash_generated_method = "937408AF82E736FDDC8219757C0C3EEE")
    
public long getCSequenceNumber() {
        return this.cSeqNumber;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.652 -0500", hash_original_method = "5B686B97AD60967CB1F8F2531F7AE87D", hash_generated_method = "D3CB01A69CDF260BF92C8A70EC14267D")
    
public long getRSequenceNumber() {
        return this.rSeqNumber;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.656 -0500", hash_original_method = "61A1EA2F1C73324A7B71E464128A3BB2", hash_generated_method = "3B11BB8868318D78DE35A8C099A48298")
    
public void setCSequenceNumber(long cSeqNumber)
            throws InvalidArgumentException {
        if (cSeqNumber <= 0 || cSeqNumber > ((long) 1) << 32 - 1)
            throw new InvalidArgumentException("Bad CSeq # " + cSeqNumber);
        this.cSeqNumber = cSeqNumber;

    }

    /**
     *@deprecated
     * @see javax.sip.header.RAckHeader#setRSeqNumber(int)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.659 -0500", hash_original_method = "CBE5EB0602C16E16F46451A7279E3ED5", hash_generated_method = "8154CF7C849DD1D5F768861BB73E3795")
    
public void setRSeqNumber(int rSeqNumber) throws InvalidArgumentException {
        this.setRSequenceNumber(rSeqNumber);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.662 -0500", hash_original_method = "31F5BB280EB4BE3CAFCEE8170222695A", hash_generated_method = "FB3601C864F6E96416230F46B1ADB83B")
    
public void setRSequenceNumber(long rSeqNumber)
            throws InvalidArgumentException {
        if (rSeqNumber <= 0 || cSeqNumber > ((long) 1) << 32 - 1)
            throw new InvalidArgumentException("Bad rSeq # " + rSeqNumber);
        this.rSeqNumber = rSeqNumber;
    }
}

