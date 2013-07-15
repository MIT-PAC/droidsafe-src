package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.InvalidArgumentException;

public class RSeq extends SIPHeader implements javax.sip.header.RSeqHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.788 -0400", hash_original_field = "1C021ADF174562C07D271E889F46BABF", hash_generated_field = "C1658771442CAEB41DDFE88E4F8049F6")

    protected long sequenceNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.788 -0400", hash_original_method = "1AAF86792C53F220850630A2C399A377", hash_generated_method = "6A0A39043D78AB195C93E6EDE279F663")
    public  RSeq() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.789 -0400", hash_original_method = "39133A5DFA90BF891F6ADEE458981A87", hash_generated_method = "FE8EE08CC115A00D40116D73DFC9C8B7")
    public int getSequenceNumber() {
        int var195C5E3592D5616B6E9F1073F1C4D062_654986576 = ((int)this.sequenceNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1632389829 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1632389829;
        // ---------- Original Method ----------
        //return (int)this.sequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.789 -0400", hash_original_method = "5D7C81BCBFD28CA691320147DF9DB2DE", hash_generated_method = "DF2229BAA11C6C4A701D758EB2A8F8C0")
    protected String encodeBody() {
String var972D3DD8F35FA0BF57E7827D8C0C5E85_2047426500 =         Long.toString(this.sequenceNumber);
        var972D3DD8F35FA0BF57E7827D8C0C5E85_2047426500.addTaint(taint);
        return var972D3DD8F35FA0BF57E7827D8C0C5E85_2047426500;
        // ---------- Original Method ----------
        //return Long.toString(this.sequenceNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.790 -0400", hash_original_method = "5EE204E642716446A9A561BAE9DA4271", hash_generated_method = "D554003BE89F422B4ED1736F0EA5434A")
    public long getSeqNumber() {
        long var55681EAF3A729CFE03DE3E3B3BFAB18A_911205065 = (this.sequenceNumber);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1629958602 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1629958602;
        // ---------- Original Method ----------
        //return this.sequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.791 -0400", hash_original_method = "479EDE29655FEADB0A6AC8DE2CF03B87", hash_generated_method = "5E51757E937C1819485C044AB807FD48")
    public void setSeqNumber(long sequenceNumber) throws InvalidArgumentException {
    if(sequenceNumber <= 0 ||sequenceNumber > ((long)1)<<32 - 1)        
        {
        InvalidArgumentException var21C7B068D162F7CB8BEDE493763898CB_340585673 = new InvalidArgumentException(
                    "Bad seq number " + sequenceNumber);
        var21C7B068D162F7CB8BEDE493763898CB_340585673.addTaint(taint);
        throw var21C7B068D162F7CB8BEDE493763898CB_340585673;
        }
        this.sequenceNumber = sequenceNumber;
        // ---------- Original Method ----------
        //if (sequenceNumber <= 0 ||sequenceNumber > ((long)1)<<32 - 1)
                //throw new InvalidArgumentException(
                    //"Bad seq number " + sequenceNumber);
        //this.sequenceNumber = sequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.791 -0400", hash_original_method = "34CCD2A626C0B5A84694D440C0C4B269", hash_generated_method = "260914DAB800A4E7B48D4E7538D30522")
    public void setSequenceNumber(int sequenceNumber) throws InvalidArgumentException {
        addTaint(sequenceNumber);
        this.setSeqNumber(sequenceNumber);
        // ---------- Original Method ----------
        //this.setSeqNumber(sequenceNumber);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.791 -0400", hash_original_field = "4C2D12D7F2E32667A2D1C242B442F590", hash_generated_field = "0CC6639306B4D0AC114368BCCC7354B6")

    private static final long serialVersionUID = 8765762413224043394L;
}

