package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.InvalidArgumentException;






public class RSeq extends SIPHeader implements javax.sip.header.RSeqHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.446 -0500", hash_original_field = "F8EF62319DC7554669434938D4737539", hash_generated_field = "0CC6639306B4D0AC114368BCCC7354B6")

    private static final long serialVersionUID = 8765762413224043394L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.449 -0500", hash_original_field = "581F60A6D443ADFC2ED9EAB5D0FA287B", hash_generated_field = "C1658771442CAEB41DDFE88E4F8049F6")

    protected long sequenceNumber;

    /** Creates a new instance of RSeq */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.452 -0500", hash_original_method = "1AAF86792C53F220850630A2C399A377", hash_generated_method = "F23EB0EE2ABF189E0964015CD69CAB2F")
    
public RSeq() {
        super(NAME);
    }

    /** Gets the sequence number of this RSeqHeader.
     * @deprecated
     * @return the integer value of the Sequence number of the RSeqHeader
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.455 -0500", hash_original_method = "39133A5DFA90BF891F6ADEE458981A87", hash_generated_method = "6D320E3A7100F3252D23482EE5ACC465")
    
public int getSequenceNumber() {
        return (int)this.sequenceNumber;
    }


    /** Encode the body of this header (the stuff that follows headerName).
     * A.K.A headerValue.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.458 -0500", hash_original_method = "5D7C81BCBFD28CA691320147DF9DB2DE", hash_generated_method = "19013A4DCE29E261487A5DF1011BDA8C")
    
protected String encodeBody() {
        return Long.toString(this.sequenceNumber);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.460 -0500", hash_original_method = "5EE204E642716446A9A561BAE9DA4271", hash_generated_method = "66986177B84CDF6993C8F18A16AD5904")
    
public long getSeqNumber() {
        return this.sequenceNumber;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.463 -0500", hash_original_method = "479EDE29655FEADB0A6AC8DE2CF03B87", hash_generated_method = "00666C39E172A3D5D6A53F4B5FDB71D9")
    
public void setSeqNumber(long sequenceNumber) throws InvalidArgumentException {

            if (sequenceNumber <= 0 ||sequenceNumber > ((long)1)<<32 - 1)
                throw new InvalidArgumentException(
                    "Bad seq number " + sequenceNumber);
            this.sequenceNumber = sequenceNumber;

    }

    /**
     * @deprecated
     * @see javax.sip.header.RSeqHeader#setSequenceNumber(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.466 -0500", hash_original_method = "34CCD2A626C0B5A84694D440C0C4B269", hash_generated_method = "066CDF009BA94F3DCA7BF90AE5E40E39")
    
public void setSequenceNumber(int sequenceNumber) throws InvalidArgumentException {
        this.setSeqNumber(sequenceNumber);

    }
}

