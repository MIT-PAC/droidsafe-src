package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.InvalidArgumentException;

public class RSeq extends SIPHeader implements javax.sip.header.RSeqHeader {
    protected long sequenceNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.098 -0400", hash_original_method = "1AAF86792C53F220850630A2C399A377", hash_generated_method = "6A0A39043D78AB195C93E6EDE279F663")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RSeq() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.098 -0400", hash_original_method = "39133A5DFA90BF891F6ADEE458981A87", hash_generated_method = "672F92F82E9D9D4CAAAE41C15A6578AE")
    @DSModeled(DSC.SAFE)
    public int getSequenceNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int)this.sequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.099 -0400", hash_original_method = "5D7C81BCBFD28CA691320147DF9DB2DE", hash_generated_method = "7D8B2D68C82272F0CE4BF2F993D39920")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        String var33CAB5A0185386B2A61F074ADE54D323_705114753 = (Long.toString(this.sequenceNumber));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Long.toString(this.sequenceNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.099 -0400", hash_original_method = "5EE204E642716446A9A561BAE9DA4271", hash_generated_method = "A87CDACC27C3E6364CFF7554193E0536")
    @DSModeled(DSC.SAFE)
    public long getSeqNumber() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return this.sequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.099 -0400", hash_original_method = "479EDE29655FEADB0A6AC8DE2CF03B87", hash_generated_method = "8368FB4DB0872BB96F4027EFC235BCCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSeqNumber(long sequenceNumber) throws InvalidArgumentException {
        dsTaint.addTaint(sequenceNumber);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                    "Bad seq number " + sequenceNumber);
        // ---------- Original Method ----------
        //if (sequenceNumber <= 0 ||sequenceNumber > ((long)1)<<32 - 1)
                //throw new InvalidArgumentException(
                    //"Bad seq number " + sequenceNumber);
        //this.sequenceNumber = sequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.099 -0400", hash_original_method = "34CCD2A626C0B5A84694D440C0C4B269", hash_generated_method = "FE73F33C09A3D96AA4787C6E59243BFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSequenceNumber(int sequenceNumber) throws InvalidArgumentException {
        dsTaint.addTaint(sequenceNumber);
        this.setSeqNumber(sequenceNumber);
        // ---------- Original Method ----------
        //this.setSeqNumber(sequenceNumber);
    }

    
    private static final long serialVersionUID = 8765762413224043394L;
}

