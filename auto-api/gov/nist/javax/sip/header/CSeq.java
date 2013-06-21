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
    protected Long seqno;
    protected String method;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.832 -0400", hash_original_method = "CAC1D7DD6777B55F66B86A8C606BDF3F", hash_generated_method = "BFE754B09B264D46E6FE8D5188A03DEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CSeq() {
        super(CSEQ);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.833 -0400", hash_original_method = "0763337F5CD1490E001F70DA32337AFB", hash_generated_method = "D90E10F204E3884528081F1B9DC86049")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CSeq(long seqno, String method) {
        this();
        dsTaint.addTaint(seqno);
        dsTaint.addTaint(method);
        this.seqno = Long.valueOf(seqno);
        this.method = SIPRequest.getCannonicalName(method);
        // ---------- Original Method ----------
        //this.seqno = Long.valueOf(seqno);
        //this.method = SIPRequest.getCannonicalName(method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.833 -0400", hash_original_method = "4EDEC57C2297C20220D48BA90CD455C6", hash_generated_method = "9AEA512A74A0DEF29386002F8EE686BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            CSeqHeader o;
            o = (CSeqHeader) other;
            boolean var21506D0060368AAB7BB0E8117ABB1EE5_217491298 = (this.getSeqNumber() == o.getSeqNumber()
                && this.getMethod().equals( o.getMethod() ));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (other instanceof CSeqHeader) {
            //final CSeqHeader o = (CSeqHeader) other;
            //return this.getSeqNumber() == o.getSeqNumber()
                //&& this.getMethod().equals( o.getMethod() );
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.833 -0400", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "C2CD6BF5A481639C3A936C3C98310016")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String var803E280AC6E161553ACD6EAB6E4869F5_646648384 = (headerName + COLON + SP + encodeBody() + NEWLINE);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return headerName + COLON + SP + encodeBody() + NEWLINE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.833 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "D6836AB66F9839D0B12BF28C3D77531E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_15296813 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.833 -0400", hash_original_method = "406CBE421082AA424BCBC4FB260BE3F4", hash_generated_method = "11686381A64B79C542B19678D595DAD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        StringBuffer var1B08E035BC9FF6C37E9FD4349403668C_2130775645 = (buffer.append(seqno).append(SP).append(method.toUpperCase()));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return buffer.append(seqno).append(SP).append(method.toUpperCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.834 -0400", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "66F4EA2E5AA841011071F21690E6549B")
    @DSModeled(DSC.SAFE)
    public String getMethod() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.834 -0400", hash_original_method = "0BFD480B5A908D011772234303C89701", hash_generated_method = "62C4BCFD1F3F52C9A4CD4077B1A39F48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSeqNumber(long sequenceNumber) throws InvalidArgumentException {
        dsTaint.addTaint(sequenceNumber);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.834 -0400", hash_original_method = "AC14810648D4561552145A0674E118CB", hash_generated_method = "9DDFE2BFCF58B944DC3FA39C466CE925")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSequenceNumber(int sequenceNumber) throws InvalidArgumentException {
        dsTaint.addTaint(sequenceNumber);
        this.setSeqNumber( (long) sequenceNumber );
        // ---------- Original Method ----------
        //this.setSeqNumber( (long) sequenceNumber );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.834 -0400", hash_original_method = "5BC8CE15D24F53FCB65EDFE00EEC2F3C", hash_generated_method = "BE669037B1E2FE1319011A292CC9D7A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMethod(String meth) throws ParseException {
        dsTaint.addTaint(meth);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.834 -0400", hash_original_method = "C444FE335840CD646F9A52EE546690DB", hash_generated_method = "526990094FC55D417FF349E5175B37A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSequenceNumber() {
        int var3120FA4D89A7CDA8F56876C4ED8FAD51_502258259 = (this.seqno.intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (this.seqno == null)
            //return 0;
        //else
            //return this.seqno.intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.834 -0400", hash_original_method = "6A4C94B16343774E5C3F1252C6DA6DFA", hash_generated_method = "8EF381F86D16B68927815ABCA7627308")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getSeqNumber() {
        long var4F2893A67EBC9218CC613B1103F5E046_38024768 = (this.seqno.longValue());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return this.seqno.longValue();
    }

    
    private static final long serialVersionUID = -5405798080040422910L;
}

