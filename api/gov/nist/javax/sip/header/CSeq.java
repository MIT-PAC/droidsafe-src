package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.message.SIPRequest;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.header.CSeqHeader;

public class CSeq extends SIPHeader implements javax.sip.header.CSeqHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.108 -0500", hash_original_field = "A542DD63EDA49DE553CE1CB41D57F431", hash_generated_field = "666558DE3DB38737E2687424E9321784")

    private static final long serialVersionUID = -5405798080040422910L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.112 -0500", hash_original_field = "3D46FA92D817D1070E73440BE4FB7186", hash_generated_field = "5A572E9FB5FD389BBCF9DBD877C25097")

    protected Long seqno;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.115 -0500", hash_original_field = "842C170402669AC7A74293BBBFD3BC5D", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;

    /**
     * Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.119 -0500", hash_original_method = "CAC1D7DD6777B55F66B86A8C606BDF3F", hash_generated_method = "91BA67FAB03ECA27672B1981059D780E")
    
public CSeq() {
        super(CSEQ);
    }

    /**
     * Constructor given the sequence number and method.
     *
     * @param seqno is the sequence number to assign.
     * @param method is the method string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.122 -0500", hash_original_method = "0763337F5CD1490E001F70DA32337AFB", hash_generated_method = "E9125E5FB414D00579F1177FA5EC4F4E")
    
public CSeq(long seqno, String method) {
        this();
        this.seqno = Long.valueOf(seqno);
        this.method = SIPRequest.getCannonicalName(method);
    }

    /**
     * Compare two cseq headers for equality.
     * @param other Object to compare against.
     * @return true if the two cseq headers are equals, false
     * otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.125 -0500", hash_original_method = "4EDEC57C2297C20220D48BA90CD455C6", hash_generated_method = "2DDEA071AADB70B9000C80626B498058")
    
public boolean equals(Object other) {

        if (other instanceof CSeqHeader) {
            final CSeqHeader o = (CSeqHeader) other;
            return this.getSeqNumber() == o.getSeqNumber()
                && this.getMethod().equals( o.getMethod() );
        }
        return false;
    }

    /**
     * Return canonical encoded header.
     * @return String with canonical encoded header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.127 -0500", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "EB7FE71751A7FA292A28A3D6E4687565")
    
public String encode() {
        return headerName + COLON + SP + encodeBody() + NEWLINE;
    }

    /**
     * Return canonical header content. (encoded header except headerName:)
     *
     * @return encoded string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.130 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "74B066602ECC20A74FD97E770D65E8BD")
    
public String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.133 -0500", hash_original_method = "406CBE421082AA424BCBC4FB260BE3F4", hash_generated_method = "3D5C4B68E081785BE2F850EDDFA5C58C")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        return buffer.append(seqno).append(SP).append(method.toUpperCase());
    }

    /**
     * Get the method.
     * @return String the method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.136 -0500", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "BC38B478E0AED2517A3460750CABA307")
    
public String getMethod() {
        return method;
    }

    /*
     * (non-Javadoc)
     * @see javax.sip.header.CSeqHeader#setSequenceNumber(long)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.139 -0500", hash_original_method = "0BFD480B5A908D011772234303C89701", hash_generated_method = "7D257CF8E83E7143F46A893E14E3A70E")
    
public void setSeqNumber(long sequenceNumber)
        throws InvalidArgumentException {
        if (sequenceNumber < 0 )
            throw new InvalidArgumentException(
                "JAIN-SIP Exception, CSeq, setSequenceNumber(), "
                    + "the sequence number parameter is < 0 : " + sequenceNumber);
        else if ( sequenceNumber >  ((long)1)<<32 - 1)
            throw new InvalidArgumentException(
                    "JAIN-SIP Exception, CSeq, setSequenceNumber(), "
                        + "the sequence number parameter is too large : " + sequenceNumber);

        seqno = Long.valueOf(sequenceNumber);
    }

    /**
     * For backwards compatibility
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.142 -0500", hash_original_method = "AC14810648D4561552145A0674E118CB", hash_generated_method = "82BC4025E6FE027ADDEE5507FB824AC6")
    
public void setSequenceNumber(int sequenceNumber) throws InvalidArgumentException {
        this.setSeqNumber( (long) sequenceNumber );
    }

    /*
     * (non-Javadoc)
     * @see javax.sip.header.CSeqHeader#setMethod(java.lang.String)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.145 -0500", hash_original_method = "5BC8CE15D24F53FCB65EDFE00EEC2F3C", hash_generated_method = "162809E923160350903383D42A12AB5B")
    
public void setMethod(String meth) throws ParseException {
        if (meth == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, CSeq"
                    + ", setMethod(), the meth parameter is null");
        this.method = SIPRequest.getCannonicalName(meth);
    }

    /*
     * (non-Javadoc)
     * @see javax.sip.header.CSeqHeader#getSequenceNumber()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.147 -0500", hash_original_method = "C444FE335840CD646F9A52EE546690DB", hash_generated_method = "C2243BD144024DC88366725A24D8FF2E")
    
public int getSequenceNumber() {
        if (this.seqno == null)
            return 0;
        else
            return this.seqno.intValue();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.150 -0500", hash_original_method = "6A4C94B16343774E5C3F1252C6DA6DFA", hash_generated_method = "768B4BA1E0575D104C97AF9DDDA811B4")
    
public long getSeqNumber() {
        return this.seqno.longValue();
    }
}

