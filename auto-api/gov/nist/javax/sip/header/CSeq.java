package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.message.SIPRequest;
import javax.sip.InvalidArgumentException;
import javax.sip.header.CSeqHeader;
import java.text.ParseException;

public class CSeq extends SIPHeader implements javax.sip.header.CSeqHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.227 -0400", hash_original_field = "D8D8C9E3082C9D3CC78D718B0D250891", hash_generated_field = "5A572E9FB5FD389BBCF9DBD877C25097")

    protected Long seqno;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.227 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.228 -0400", hash_original_method = "CAC1D7DD6777B55F66B86A8C606BDF3F", hash_generated_method = "BFE754B09B264D46E6FE8D5188A03DEF")
    public  CSeq() {
        super(CSEQ);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.228 -0400", hash_original_method = "0763337F5CD1490E001F70DA32337AFB", hash_generated_method = "F9B3D16C7E67EEEABA12EC35D440EC3F")
    public  CSeq(long seqno, String method) {
        this();
        this.seqno = Long.valueOf(seqno);
        this.method = SIPRequest.getCannonicalName(method);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.228 -0400", hash_original_method = "4EDEC57C2297C20220D48BA90CD455C6", hash_generated_method = "FA6591683D1EAE6FF50ED192CF09C85F")
    public boolean equals(Object other) {
        {
            final CSeqHeader o = (CSeqHeader) other;
            boolean var21506D0060368AAB7BB0E8117ABB1EE5_892209334 = (this.getSeqNumber() == o.getSeqNumber()
                && this.getMethod().equals( o.getMethod() ));
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_439545924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_439545924;
        
        
            
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.229 -0400", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "7737F35C570E4ADB7904F44B28A3C53C")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_2049129711 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2049129711 = headerName + COLON + SP + encodeBody() + NEWLINE;
        varB4EAC82CA7396A68D541C85D26508E83_2049129711.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2049129711;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.229 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "A1C56E1175EA3F7B015597AE566D45A1")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1166926123 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1166926123 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1166926123.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1166926123;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.230 -0400", hash_original_method = "406CBE421082AA424BCBC4FB260BE3F4", hash_generated_method = "73B2DB13781274AB191B10E3DFCDBE4F")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1489860484 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1489860484 = buffer.append(seqno).append(SP).append(method.toUpperCase());
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1489860484.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1489860484;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.230 -0400", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "3210B6BD6941EBCD6566B534309AF665")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_566061136 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_566061136 = method;
        varB4EAC82CA7396A68D541C85D26508E83_566061136.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_566061136;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.231 -0400", hash_original_method = "0BFD480B5A908D011772234303C89701", hash_generated_method = "A82EF90DDA9E43264213C9C62773DA00")
    public void setSeqNumber(long sequenceNumber) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP Exception, CSeq, setSequenceNumber(), "
                    + "the sequence number parameter is < 0 : " + sequenceNumber);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                    "JAIN-SIP Exception, CSeq, setSequenceNumber(), "
                        + "the sequence number parameter is too large : " + sequenceNumber);
        seqno = Long.valueOf(sequenceNumber);
        
        
            
                
                    
        
            
                    
                        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.231 -0400", hash_original_method = "AC14810648D4561552145A0674E118CB", hash_generated_method = "232B26F0ADDD983481AC31A586466EB1")
    public void setSequenceNumber(int sequenceNumber) throws InvalidArgumentException {
        this.setSeqNumber( (long) sequenceNumber );
        addTaint(sequenceNumber);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.232 -0400", hash_original_method = "5BC8CE15D24F53FCB65EDFE00EEC2F3C", hash_generated_method = "8E9172D7E88C32D74CE6784722A22AAB")
    public void setMethod(String meth) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, CSeq"
                    + ", setMethod(), the meth parameter is null");
        this.method = SIPRequest.getCannonicalName(meth);
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.233 -0400", hash_original_method = "C444FE335840CD646F9A52EE546690DB", hash_generated_method = "79C91427EEE078852137C76990A2E707")
    public int getSequenceNumber() {
        int var3120FA4D89A7CDA8F56876C4ED8FAD51_319086315 = (this.seqno.intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622458091 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622458091;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.233 -0400", hash_original_method = "6A4C94B16343774E5C3F1252C6DA6DFA", hash_generated_method = "19BE132A38ADB11D0F543F992B2BB1BB")
    public long getSeqNumber() {
        long var4F2893A67EBC9218CC613B1103F5E046_991589105 = (this.seqno.longValue());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1930779720 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1930779720;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.233 -0400", hash_original_field = "653973139075CE657DA71F6B7D0C7B06", hash_generated_field = "666558DE3DB38737E2687424E9321784")

    private static final long serialVersionUID = -5405798080040422910L;
}

