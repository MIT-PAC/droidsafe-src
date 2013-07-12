package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.message.SIPRequest;
import javax.sip.InvalidArgumentException;
import javax.sip.header.CSeqHeader;
import java.text.ParseException;

public class CSeq extends SIPHeader implements javax.sip.header.CSeqHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.075 -0400", hash_original_field = "D8D8C9E3082C9D3CC78D718B0D250891", hash_generated_field = "5A572E9FB5FD389BBCF9DBD877C25097")

    protected Long seqno;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.075 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.075 -0400", hash_original_method = "CAC1D7DD6777B55F66B86A8C606BDF3F", hash_generated_method = "BFE754B09B264D46E6FE8D5188A03DEF")
    public  CSeq() {
        super(CSEQ);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.076 -0400", hash_original_method = "0763337F5CD1490E001F70DA32337AFB", hash_generated_method = "F9B3D16C7E67EEEABA12EC35D440EC3F")
    public  CSeq(long seqno, String method) {
        this();
        this.seqno = Long.valueOf(seqno);
        this.method = SIPRequest.getCannonicalName(method);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.077 -0400", hash_original_method = "4EDEC57C2297C20220D48BA90CD455C6", hash_generated_method = "9EE330B119AAF76BDCE9E647B750123A")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(other instanceof CSeqHeader)        
        {
            final CSeqHeader o = (CSeqHeader) other;
            boolean var9FD0C0FB4E4F5D21757EC4B3CD591368_757229908 = (this.getSeqNumber() == o.getSeqNumber()
                && this.getMethod().equals( o.getMethod() ));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_803870048 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_803870048;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1915402067 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1412232445 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1412232445;
        
        
            
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.077 -0400", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "1D1083C43C4D32F6EFF97DA6931FF1A9")
    public String encode() {
String var4D54AC96FDD6E716CB6C2C0211520077_820677834 =         headerName + COLON + SP + encodeBody() + NEWLINE;
        var4D54AC96FDD6E716CB6C2C0211520077_820677834.addTaint(taint);
        return var4D54AC96FDD6E716CB6C2C0211520077_820677834;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.078 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "EC783A68E7F0199D2D581C0E39EDC5E9")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_2103785911 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_2103785911.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_2103785911;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.078 -0400", hash_original_method = "406CBE421082AA424BCBC4FB260BE3F4", hash_generated_method = "86E559E33ECE0A60D7DFE7020EE8E824")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
StringBuffer varA1E43DCB3174BD2194B740F873FB644F_1696407171 =         buffer.append(seqno).append(SP).append(method.toUpperCase());
        varA1E43DCB3174BD2194B740F873FB644F_1696407171.addTaint(taint);
        return varA1E43DCB3174BD2194B740F873FB644F_1696407171;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.078 -0400", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "7CB1A539847B68DF6A6AF784C9E89485")
    public String getMethod() {
String var27E3C5B2D4A798771E5F53D6527EECD0_179234729 =         method;
        var27E3C5B2D4A798771E5F53D6527EECD0_179234729.addTaint(taint);
        return var27E3C5B2D4A798771E5F53D6527EECD0_179234729;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.079 -0400", hash_original_method = "0BFD480B5A908D011772234303C89701", hash_generated_method = "34E0DCCC464669B4E53F5177B255CCE4")
    public void setSeqNumber(long sequenceNumber) throws InvalidArgumentException {
    if(sequenceNumber < 0)        
        {
        InvalidArgumentException var535F4965268159C133A1508185E38B2E_1197328664 = new InvalidArgumentException(
                "JAIN-SIP Exception, CSeq, setSequenceNumber(), "
                    + "the sequence number parameter is < 0 : " + sequenceNumber);
        var535F4965268159C133A1508185E38B2E_1197328664.addTaint(taint);
        throw var535F4965268159C133A1508185E38B2E_1197328664;
        }
        else
    if(sequenceNumber >  ((long)1)<<32 - 1)        
        {
        InvalidArgumentException var10286898EE50EE90C3FFCA11303C1E0F_1127374605 = new InvalidArgumentException(
                    "JAIN-SIP Exception, CSeq, setSequenceNumber(), "
                        + "the sequence number parameter is too large : " + sequenceNumber);
        var10286898EE50EE90C3FFCA11303C1E0F_1127374605.addTaint(taint);
        throw var10286898EE50EE90C3FFCA11303C1E0F_1127374605;
        }
        seqno = Long.valueOf(sequenceNumber);
        
        
            
                
                    
        
            
                    
                        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.079 -0400", hash_original_method = "AC14810648D4561552145A0674E118CB", hash_generated_method = "CFB014E73D2787B90A121FAE2CBF9569")
    public void setSequenceNumber(int sequenceNumber) throws InvalidArgumentException {
        addTaint(sequenceNumber);
        this.setSeqNumber( (long) sequenceNumber );
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.080 -0400", hash_original_method = "5BC8CE15D24F53FCB65EDFE00EEC2F3C", hash_generated_method = "97F46A731B7C3747C0FC1F35FF6FCB5E")
    public void setMethod(String meth) throws ParseException {
    if(meth == null)        
        {
        NullPointerException var5EF9346A7A063AE03B0B3A8C458E9F37_609147268 = new NullPointerException(
                "JAIN-SIP Exception, CSeq"
                    + ", setMethod(), the meth parameter is null");
        var5EF9346A7A063AE03B0B3A8C458E9F37_609147268.addTaint(taint);
        throw var5EF9346A7A063AE03B0B3A8C458E9F37_609147268;
        }
        this.method = SIPRequest.getCannonicalName(meth);
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.080 -0400", hash_original_method = "C444FE335840CD646F9A52EE546690DB", hash_generated_method = "97FF518A397E0595D262B3055DF1FDA2")
    public int getSequenceNumber() {
    if(this.seqno == null)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1285961587 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307823286 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307823286;
        }
        else
        {
        int var89FDA5779696A46A7A6D486674F3D97E_979925646 = (this.seqno.intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447100103 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447100103;
        }
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.080 -0400", hash_original_method = "6A4C94B16343774E5C3F1252C6DA6DFA", hash_generated_method = "06E41C49C3865FF07263046E4482E498")
    public long getSeqNumber() {
        long varE69C616A1F2EAB093AFAF63BC63AB707_1384200157 = (this.seqno.longValue());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1121513389 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1121513389;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.081 -0400", hash_original_field = "653973139075CE657DA71F6B7D0C7B06", hash_generated_field = "666558DE3DB38737E2687424E9321784")

    private static final long serialVersionUID = -5405798080040422910L;
}

