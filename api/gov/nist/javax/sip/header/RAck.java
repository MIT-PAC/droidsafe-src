package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.InvalidArgumentException;
import java.text.ParseException;

public class RAck extends SIPHeader implements javax.sip.header.RAckHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.785 -0400", hash_original_field = "E9A77CB6D532BAD6B3C1F9AFF8D3456A", hash_generated_field = "90A1DBDECBC94B16131E7EAFCA83250F")

    protected long cSeqNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.785 -0400", hash_original_field = "9165AF4FCD38054297A85E5DFD02DC76", hash_generated_field = "0BFA342B8453938DE41E6CA4A7186CA9")

    protected long rSeqNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.785 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.785 -0400", hash_original_method = "7C5933C28B73D77B67311599A1BD6348", hash_generated_method = "B9F10F92D666D06433633A2E45A818B7")
    public  RAck() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.786 -0400", hash_original_method = "31F6FBF38938A8E830748EA5A3D758B3", hash_generated_method = "08E7DB6F65E9976C961BEA385C8A6429")
    protected String encodeBody() {
String varC978D6217C568332ACACC40C43306966_138633978 =         new StringBuffer().append(rSeqNumber).append(SP).append(
                cSeqNumber).append(SP).append(method).toString();
        varC978D6217C568332ACACC40C43306966_138633978.addTaint(taint);
        return varC978D6217C568332ACACC40C43306966_138633978;
        // ---------- Original Method ----------
        //return new StringBuffer().append(rSeqNumber).append(SP).append(
                //cSeqNumber).append(SP).append(method).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.786 -0400", hash_original_method = "717B64217AB1BDBD09BA8111F0B019A1", hash_generated_method = "E64CE7E6CE63E4A9A828847DC19DA781")
    public int getCSeqNumber() {
        int varB14D0F2A81E62BA4D649F660B1FC34D4_2102879174 = ((int) cSeqNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_571400049 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_571400049;
        // ---------- Original Method ----------
        //return (int) cSeqNumber;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.786 -0400", hash_original_method = "718B34DE34C00921F3D0FF08E153D08E", hash_generated_method = "C04FEB19137E8BC09D0FA3DF4B8709D9")
    public long getCSeqNumberLong() {
        long varE9A77CB6D532BAD6B3C1F9AFF8D3456A_897579296 = (cSeqNumber);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_157314372 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_157314372;
        // ---------- Original Method ----------
        //return cSeqNumber;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.787 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "C147B12A822F75C205654866579DC5B6")
    public String getMethod() {
String varB88046C53AB584448F89DD952FF416E1_1369126673 =         this.method;
        varB88046C53AB584448F89DD952FF416E1_1369126673.addTaint(taint);
        return varB88046C53AB584448F89DD952FF416E1_1369126673;
        // ---------- Original Method ----------
        //return this.method;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.787 -0400", hash_original_method = "F18C054E96BBFC72C2FB4D9E194B171A", hash_generated_method = "DB6B853AD5B7AFB213B615F614C5327F")
    public int getRSeqNumber() {
        int varFCAEE8E77F7DC510E4E9F77ADC66603E_256941202 = ((int) rSeqNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_748134609 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_748134609;
        // ---------- Original Method ----------
        //return (int) rSeqNumber;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.787 -0400", hash_original_method = "C47555692F5984E7397D2D721232A447", hash_generated_method = "7F4E30DD7BEF01A19576F95BC45604C9")
    public void setCSeqNumber(int cSeqNumber) throws InvalidArgumentException {
        addTaint(cSeqNumber);
        this.setCSequenceNumber(cSeqNumber);
        // ---------- Original Method ----------
        //this.setCSequenceNumber(cSeqNumber);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.788 -0400", hash_original_method = "417A86B1B77116D6C3275A494BFCD4D5", hash_generated_method = "E85DCEE65E2288E3D9797383EC01CCC2")
    public void setMethod(String method) throws ParseException {
        this.method = method;
        // ---------- Original Method ----------
        //this.method = method;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.788 -0400", hash_original_method = "BF53D6931E1144BDB37994BD814B2F3D", hash_generated_method = "C9B955BA0AA140700FB6E009D043D7D2")
    public long getCSequenceNumber() {
        long varE516DBD268B2684D4A918F5F3E547EFB_429398775 = (this.cSeqNumber);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_610993258 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_610993258;
        // ---------- Original Method ----------
        //return this.cSeqNumber;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.788 -0400", hash_original_method = "5B686B97AD60967CB1F8F2531F7AE87D", hash_generated_method = "655B51FC2687B7736DEDE14A62B71D75")
    public long getRSequenceNumber() {
        long varA42CE60384320A53D767299FB99CE752_1232008826 = (this.rSeqNumber);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1731090753 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1731090753;
        // ---------- Original Method ----------
        //return this.rSeqNumber;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.789 -0400", hash_original_method = "61A1EA2F1C73324A7B71E464128A3BB2", hash_generated_method = "7B5F1610F13183FCA3C5FF1179EAB1A9")
    public void setCSequenceNumber(long cSeqNumber) throws InvalidArgumentException {
        if(cSeqNumber <= 0 || cSeqNumber > ((long) 1) << 32 - 1)        
        {
        InvalidArgumentException var0176257641E7B5982458D40099B78D3F_1350955079 = new InvalidArgumentException("Bad CSeq # " + cSeqNumber);
        var0176257641E7B5982458D40099B78D3F_1350955079.addTaint(taint);
        throw var0176257641E7B5982458D40099B78D3F_1350955079;
        }
        this.cSeqNumber = cSeqNumber;
        // ---------- Original Method ----------
        //if (cSeqNumber <= 0 || cSeqNumber > ((long) 1) << 32 - 1)
            //throw new InvalidArgumentException("Bad CSeq # " + cSeqNumber);
        //this.cSeqNumber = cSeqNumber;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.789 -0400", hash_original_method = "CBE5EB0602C16E16F46451A7279E3ED5", hash_generated_method = "888B4C5A623E4EBD3999ECF80436EF6E")
    public void setRSeqNumber(int rSeqNumber) throws InvalidArgumentException {
        addTaint(rSeqNumber);
        this.setRSequenceNumber(rSeqNumber);
        // ---------- Original Method ----------
        //this.setRSequenceNumber(rSeqNumber);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.789 -0400", hash_original_method = "31F5BB280EB4BE3CAFCEE8170222695A", hash_generated_method = "51609A0284747471FB680D8B4BF67C11")
    public void setRSequenceNumber(long rSeqNumber) throws InvalidArgumentException {
        if(rSeqNumber <= 0 || cSeqNumber > ((long) 1) << 32 - 1)        
        {
        InvalidArgumentException varFE1CF409D0ED647618C511042A9660CE_1711500663 = new InvalidArgumentException("Bad rSeq # " + rSeqNumber);
        varFE1CF409D0ED647618C511042A9660CE_1711500663.addTaint(taint);
        throw varFE1CF409D0ED647618C511042A9660CE_1711500663;
        }
        this.rSeqNumber = rSeqNumber;
        // ---------- Original Method ----------
        //if (rSeqNumber <= 0 || cSeqNumber > ((long) 1) << 32 - 1)
            //throw new InvalidArgumentException("Bad rSeq # " + rSeqNumber);
        //this.rSeqNumber = rSeqNumber;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.789 -0400", hash_original_field = "708D86A2FAF0568BD7A5DF39F0E29E9A", hash_generated_field = "7D32B1C47FED303719E2DC0EBD9FC96B")

    private static final long serialVersionUID = 743999286077404118L;
}

