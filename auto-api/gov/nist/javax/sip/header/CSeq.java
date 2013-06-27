package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.message.SIPRequest;
import javax.sip.InvalidArgumentException;
import javax.sip.header.CSeqHeader;
import java.text.ParseException;

public class CSeq extends SIPHeader implements javax.sip.header.CSeqHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.579 -0400", hash_original_field = "D8D8C9E3082C9D3CC78D718B0D250891", hash_generated_field = "5A572E9FB5FD389BBCF9DBD877C25097")

    protected Long seqno;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.579 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.579 -0400", hash_original_method = "CAC1D7DD6777B55F66B86A8C606BDF3F", hash_generated_method = "BFE754B09B264D46E6FE8D5188A03DEF")
    public  CSeq() {
        super(CSEQ);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.579 -0400", hash_original_method = "0763337F5CD1490E001F70DA32337AFB", hash_generated_method = "F9B3D16C7E67EEEABA12EC35D440EC3F")
    public  CSeq(long seqno, String method) {
        this();
        this.seqno = Long.valueOf(seqno);
        this.method = SIPRequest.getCannonicalName(method);
        // ---------- Original Method ----------
        //this.seqno = Long.valueOf(seqno);
        //this.method = SIPRequest.getCannonicalName(method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.580 -0400", hash_original_method = "4EDEC57C2297C20220D48BA90CD455C6", hash_generated_method = "13C56454D5DAB548C0FEBFF2A171AE4F")
    public boolean equals(Object other) {
        {
            CSeqHeader o;
            o = (CSeqHeader) other;
            boolean var21506D0060368AAB7BB0E8117ABB1EE5_231727448 = (this.getSeqNumber() == o.getSeqNumber()
                && this.getMethod().equals( o.getMethod() ));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1379918629 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1379918629;
        // ---------- Original Method ----------
        //if (other instanceof CSeqHeader) {
            //final CSeqHeader o = (CSeqHeader) other;
            //return this.getSeqNumber() == o.getSeqNumber()
                //&& this.getMethod().equals( o.getMethod() );
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.581 -0400", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "70041D07C4AAAB8BC53B28B66655E087")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_653517439 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_653517439 = headerName + COLON + SP + encodeBody() + NEWLINE;
        varB4EAC82CA7396A68D541C85D26508E83_653517439.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_653517439;
        // ---------- Original Method ----------
        //return headerName + COLON + SP + encodeBody() + NEWLINE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.581 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "1C1E04463AA4F159E3E3283F204EF97C")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_675631133 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_675631133 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_675631133.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_675631133;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.581 -0400", hash_original_method = "406CBE421082AA424BCBC4FB260BE3F4", hash_generated_method = "2059EBEB30BFCC3D3FE7B15075A5F175")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_755348401 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_755348401 = buffer.append(seqno).append(SP).append(method.toUpperCase());
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_755348401.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_755348401;
        // ---------- Original Method ----------
        //return buffer.append(seqno).append(SP).append(method.toUpperCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.582 -0400", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "9C1B96FF8D06952ED109406B638D510D")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_2048532484 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2048532484 = method;
        varB4EAC82CA7396A68D541C85D26508E83_2048532484.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2048532484;
        // ---------- Original Method ----------
        //return method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.595 -0400", hash_original_method = "0BFD480B5A908D011772234303C89701", hash_generated_method = "A82EF90DDA9E43264213C9C62773DA00")
    public void setSeqNumber(long sequenceNumber) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP Exception, CSeq, setSequenceNumber(), "
                    + "the sequence number parameter is < 0 : " + sequenceNumber);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                    "JAIN-SIP Exception, CSeq, setSequenceNumber(), "
                        + "the sequence number parameter is too large : " + sequenceNumber);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.596 -0400", hash_original_method = "AC14810648D4561552145A0674E118CB", hash_generated_method = "232B26F0ADDD983481AC31A586466EB1")
    public void setSequenceNumber(int sequenceNumber) throws InvalidArgumentException {
        this.setSeqNumber( (long) sequenceNumber );
        addTaint(sequenceNumber);
        // ---------- Original Method ----------
        //this.setSeqNumber( (long) sequenceNumber );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.596 -0400", hash_original_method = "5BC8CE15D24F53FCB65EDFE00EEC2F3C", hash_generated_method = "8E9172D7E88C32D74CE6784722A22AAB")
    public void setMethod(String meth) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, CSeq"
                    + ", setMethod(), the meth parameter is null");
        this.method = SIPRequest.getCannonicalName(meth);
        // ---------- Original Method ----------
        //if (meth == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, CSeq"
                    //+ ", setMethod(), the meth parameter is null");
        //this.method = SIPRequest.getCannonicalName(meth);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.596 -0400", hash_original_method = "C444FE335840CD646F9A52EE546690DB", hash_generated_method = "034F9CCC762D01527E806CC15AB99C1D")
    public int getSequenceNumber() {
        int var3120FA4D89A7CDA8F56876C4ED8FAD51_2046922802 = (this.seqno.intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_492398976 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_492398976;
        // ---------- Original Method ----------
        //if (this.seqno == null)
            //return 0;
        //else
            //return this.seqno.intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.597 -0400", hash_original_method = "6A4C94B16343774E5C3F1252C6DA6DFA", hash_generated_method = "5FD7BEA017FE98A50AD6CA97E6E4B215")
    public long getSeqNumber() {
        long var4F2893A67EBC9218CC613B1103F5E046_1636663494 = (this.seqno.longValue());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_824644523 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_824644523;
        // ---------- Original Method ----------
        //return this.seqno.longValue();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.597 -0400", hash_original_field = "653973139075CE657DA71F6B7D0C7B06", hash_generated_field = "6125133E26F365FFE465409CA16FCB26")

    private static long serialVersionUID = -5405798080040422910L;
}

