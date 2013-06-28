package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.InvalidArgumentException;

public class RSeq extends SIPHeader implements javax.sip.header.RSeqHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.972 -0400", hash_original_field = "1C021ADF174562C07D271E889F46BABF", hash_generated_field = "C1658771442CAEB41DDFE88E4F8049F6")

    protected long sequenceNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.972 -0400", hash_original_method = "1AAF86792C53F220850630A2C399A377", hash_generated_method = "6A0A39043D78AB195C93E6EDE279F663")
    public  RSeq() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.972 -0400", hash_original_method = "39133A5DFA90BF891F6ADEE458981A87", hash_generated_method = "3B4146A60E2D91B5B119A4537D8E768B")
    public int getSequenceNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238203743 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238203743;
        // ---------- Original Method ----------
        //return (int)this.sequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.973 -0400", hash_original_method = "5D7C81BCBFD28CA691320147DF9DB2DE", hash_generated_method = "12FBFC391C155BE7C80804F61013A8D4")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_502884025 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_502884025 = Long.toString(this.sequenceNumber);
        varB4EAC82CA7396A68D541C85D26508E83_502884025.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_502884025;
        // ---------- Original Method ----------
        //return Long.toString(this.sequenceNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.973 -0400", hash_original_method = "5EE204E642716446A9A561BAE9DA4271", hash_generated_method = "103A91A875380172E1BA39B406F4FD37")
    public long getSeqNumber() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_312397779 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_312397779;
        // ---------- Original Method ----------
        //return this.sequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.974 -0400", hash_original_method = "479EDE29655FEADB0A6AC8DE2CF03B87", hash_generated_method = "8A0AF97038E7237A3C5A3DCA9536FD51")
    public void setSeqNumber(long sequenceNumber) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                    "Bad seq number " + sequenceNumber);
        this.sequenceNumber = sequenceNumber;
        // ---------- Original Method ----------
        //if (sequenceNumber <= 0 ||sequenceNumber > ((long)1)<<32 - 1)
                //throw new InvalidArgumentException(
                    //"Bad seq number " + sequenceNumber);
        //this.sequenceNumber = sequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.975 -0400", hash_original_method = "34CCD2A626C0B5A84694D440C0C4B269", hash_generated_method = "6363357D5FF8625057D7270046E349CE")
    public void setSequenceNumber(int sequenceNumber) throws InvalidArgumentException {
        this.setSeqNumber(sequenceNumber);
        addTaint(sequenceNumber);
        // ---------- Original Method ----------
        //this.setSeqNumber(sequenceNumber);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.975 -0400", hash_original_field = "4C2D12D7F2E32667A2D1C242B442F590", hash_generated_field = "0CC6639306B4D0AC114368BCCC7354B6")

    private static final long serialVersionUID = 8765762413224043394L;
}

