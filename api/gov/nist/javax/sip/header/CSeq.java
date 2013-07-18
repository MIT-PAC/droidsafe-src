package gov.nist.javax.sip.header;

// Droidsafe Imports
import gov.nist.javax.sip.message.SIPRequest;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.header.CSeqHeader;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class CSeq extends SIPHeader implements javax.sip.header.CSeqHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.081 -0400", hash_original_field = "D8D8C9E3082C9D3CC78D718B0D250891", hash_generated_field = "5A572E9FB5FD389BBCF9DBD877C25097")

    protected Long seqno;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.081 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.081 -0400", hash_original_method = "CAC1D7DD6777B55F66B86A8C606BDF3F", hash_generated_method = "BFE754B09B264D46E6FE8D5188A03DEF")
    public  CSeq() {
        super(CSEQ);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.082 -0400", hash_original_method = "0763337F5CD1490E001F70DA32337AFB", hash_generated_method = "F9B3D16C7E67EEEABA12EC35D440EC3F")
    public  CSeq(long seqno, String method) {
        this();
        this.seqno = Long.valueOf(seqno);
        this.method = SIPRequest.getCannonicalName(method);
        // ---------- Original Method ----------
        //this.seqno = Long.valueOf(seqno);
        //this.method = SIPRequest.getCannonicalName(method);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.083 -0400", hash_original_method = "4EDEC57C2297C20220D48BA90CD455C6", hash_generated_method = "893953E36A14661C3D26788511DA88C3")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(other instanceof CSeqHeader)        
        {
            final CSeqHeader o = (CSeqHeader) other;
            boolean var9FD0C0FB4E4F5D21757EC4B3CD591368_1526255615 = (this.getSeqNumber() == o.getSeqNumber()
                && this.getMethod().equals( o.getMethod() ));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_110346386 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_110346386;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1522078000 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1624711378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1624711378;
        // ---------- Original Method ----------
        //if (other instanceof CSeqHeader) {
            //final CSeqHeader o = (CSeqHeader) other;
            //return this.getSeqNumber() == o.getSeqNumber()
                //&& this.getMethod().equals( o.getMethod() );
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.083 -0400", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "C95FFFC37E456B25B20A76C2D4021678")
    public String encode() {
String var4D54AC96FDD6E716CB6C2C0211520077_1036989770 =         headerName + COLON + SP + encodeBody() + NEWLINE;
        var4D54AC96FDD6E716CB6C2C0211520077_1036989770.addTaint(taint);
        return var4D54AC96FDD6E716CB6C2C0211520077_1036989770;
        // ---------- Original Method ----------
        //return headerName + COLON + SP + encodeBody() + NEWLINE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.083 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "5EC20CECDB66EFBBDB304D42D020CD8D")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_1061677676 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_1061677676.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_1061677676;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.083 -0400", hash_original_method = "406CBE421082AA424BCBC4FB260BE3F4", hash_generated_method = "A2180EA551ED7ABB359894303148E286")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
StringBuffer varA1E43DCB3174BD2194B740F873FB644F_1887815825 =         buffer.append(seqno).append(SP).append(method.toUpperCase());
        varA1E43DCB3174BD2194B740F873FB644F_1887815825.addTaint(taint);
        return varA1E43DCB3174BD2194B740F873FB644F_1887815825;
        // ---------- Original Method ----------
        //return buffer.append(seqno).append(SP).append(method.toUpperCase());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.084 -0400", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "C0503AEAC488390D02E368D247128C6A")
    public String getMethod() {
String var27E3C5B2D4A798771E5F53D6527EECD0_1207793864 =         method;
        var27E3C5B2D4A798771E5F53D6527EECD0_1207793864.addTaint(taint);
        return var27E3C5B2D4A798771E5F53D6527EECD0_1207793864;
        // ---------- Original Method ----------
        //return method;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.084 -0400", hash_original_method = "0BFD480B5A908D011772234303C89701", hash_generated_method = "D6F37E846425A4C382363A62E53A0CA2")
    public void setSeqNumber(long sequenceNumber) throws InvalidArgumentException {
        if(sequenceNumber < 0)        
        {
        InvalidArgumentException var535F4965268159C133A1508185E38B2E_211704133 = new InvalidArgumentException(
                "JAIN-SIP Exception, CSeq, setSequenceNumber(), "
                    + "the sequence number parameter is < 0 : " + sequenceNumber);
        var535F4965268159C133A1508185E38B2E_211704133.addTaint(taint);
        throw var535F4965268159C133A1508185E38B2E_211704133;
        }
        else
        if(sequenceNumber >  ((long)1)<<32 - 1)        
        {
        InvalidArgumentException var10286898EE50EE90C3FFCA11303C1E0F_1637395320 = new InvalidArgumentException(
                    "JAIN-SIP Exception, CSeq, setSequenceNumber(), "
                        + "the sequence number parameter is too large : " + sequenceNumber);
        var10286898EE50EE90C3FFCA11303C1E0F_1637395320.addTaint(taint);
        throw var10286898EE50EE90C3FFCA11303C1E0F_1637395320;
        }
        seqno = Long.valueOf(sequenceNumber);
        // ---------- Original Method ----------
        //if (sequenceNumber < 0 )
            //throw new InvalidArgumentException(
                //"JAIN-SIP Exception, CSeq, setSequenceNumber(), "
                    //+ "the sequence number parameter is < 0 : " + sequenceNumber);
        //else if ( sequenceNumber >  ((long)1)<<32 - 1)
            //throw new InvalidArgumentException(
                    //"JAIN-SIP Exception, CSeq, setSequenceNumber(), "
                        //+ "the sequence number parameter is too large : " + sequenceNumber);
        //seqno = Long.valueOf(sequenceNumber);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.085 -0400", hash_original_method = "AC14810648D4561552145A0674E118CB", hash_generated_method = "CFB014E73D2787B90A121FAE2CBF9569")
    public void setSequenceNumber(int sequenceNumber) throws InvalidArgumentException {
        addTaint(sequenceNumber);
        this.setSeqNumber( (long) sequenceNumber );
        // ---------- Original Method ----------
        //this.setSeqNumber( (long) sequenceNumber );
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.085 -0400", hash_original_method = "5BC8CE15D24F53FCB65EDFE00EEC2F3C", hash_generated_method = "95DB9763DE2E9CAD748859C8500A356E")
    public void setMethod(String meth) throws ParseException {
        if(meth == null)        
        {
        NullPointerException var5EF9346A7A063AE03B0B3A8C458E9F37_1780542535 = new NullPointerException(
                "JAIN-SIP Exception, CSeq"
                    + ", setMethod(), the meth parameter is null");
        var5EF9346A7A063AE03B0B3A8C458E9F37_1780542535.addTaint(taint);
        throw var5EF9346A7A063AE03B0B3A8C458E9F37_1780542535;
        }
        this.method = SIPRequest.getCannonicalName(meth);
        // ---------- Original Method ----------
        //if (meth == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, CSeq"
                    //+ ", setMethod(), the meth parameter is null");
        //this.method = SIPRequest.getCannonicalName(meth);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.085 -0400", hash_original_method = "C444FE335840CD646F9A52EE546690DB", hash_generated_method = "47CECA7BD05AF6D2726C6F2B3F3B126A")
    public int getSequenceNumber() {
        if(this.seqno == null)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_336481987 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1140358423 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1140358423;
        }
        else
        {
        int var89FDA5779696A46A7A6D486674F3D97E_69488507 = (this.seqno.intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1365918906 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1365918906;
        }
        // ---------- Original Method ----------
        //if (this.seqno == null)
            //return 0;
        //else
            //return this.seqno.intValue();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.086 -0400", hash_original_method = "6A4C94B16343774E5C3F1252C6DA6DFA", hash_generated_method = "B2EB58A152838C79AC74C2A985A818DF")
    public long getSeqNumber() {
        long varE69C616A1F2EAB093AFAF63BC63AB707_555263536 = (this.seqno.longValue());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_645908803 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_645908803;
        // ---------- Original Method ----------
        //return this.seqno.longValue();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.086 -0400", hash_original_field = "653973139075CE657DA71F6B7D0C7B06", hash_generated_field = "666558DE3DB38737E2687424E9321784")

    private static final long serialVersionUID = -5405798080040422910L;
}

