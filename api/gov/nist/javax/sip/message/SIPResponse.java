package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.Utils;
import gov.nist.javax.sip.address.SipUri;
import gov.nist.javax.sip.header.CSeq;
import gov.nist.javax.sip.header.CallID;
import gov.nist.javax.sip.header.ContactList;
import gov.nist.javax.sip.header.ContentLength;
import gov.nist.javax.sip.header.ContentType;
import gov.nist.javax.sip.header.From;
import gov.nist.javax.sip.header.MaxForwards;
import gov.nist.javax.sip.header.ReasonList;
import gov.nist.javax.sip.header.RecordRouteList;
import gov.nist.javax.sip.header.RequireList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.StatusLine;
import gov.nist.javax.sip.header.To;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.header.ViaList;
import gov.nist.javax.sip.header.extensions.SessionExpires;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.sip.header.ReasonHeader;
import javax.sip.header.ServerHeader;
import javax.sip.message.Request;

public final class SIPResponse extends SIPMessage implements javax.sip.message.Response, ResponseExt {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.541 -0500", hash_original_method = "AB9A03C3951275E5A2E90FE8CAAD0800", hash_generated_method = "99B6F14DC1A55F1EE64DD39F2BDF3CAE")
    
public static String getReasonPhrase(int rc) {
        String retval = null;
        switch (rc) {

            case TRYING :
                retval = "Trying";
                break;

            case RINGING :
                retval = "Ringing";
                break;

            case CALL_IS_BEING_FORWARDED :
                retval = "Call is being forwarded";
                break;

            case QUEUED :
                retval = "Queued";
                break;

            case SESSION_PROGRESS :
                retval = "Session progress";
                break;

            case OK :
                retval = "OK";
                break;

            case ACCEPTED :
                retval = "Accepted";
                break;

            case MULTIPLE_CHOICES :
                retval = "Multiple choices";
                break;

            case MOVED_PERMANENTLY :
                retval = "Moved permanently";
                break;

            case MOVED_TEMPORARILY :
                retval = "Moved Temporarily";
                break;

            case USE_PROXY :
                retval = "Use proxy";
                break;

            case ALTERNATIVE_SERVICE :
                retval = "Alternative service";
                break;

            case BAD_REQUEST :
                retval = "Bad request";
                break;

            case UNAUTHORIZED :
                retval = "Unauthorized";
                break;

            case PAYMENT_REQUIRED :
                retval = "Payment required";
                break;

            case FORBIDDEN :
                retval = "Forbidden";
                break;

            case NOT_FOUND :
                retval = "Not found";
                break;

            case METHOD_NOT_ALLOWED :
                retval = "Method not allowed";
                break;

            case NOT_ACCEPTABLE :
                retval = "Not acceptable";
                break;

            case PROXY_AUTHENTICATION_REQUIRED :
                retval = "Proxy Authentication required";
                break;

            case REQUEST_TIMEOUT :
                retval = "Request timeout";
                break;

            case GONE :
                retval = "Gone";
                break;

            case TEMPORARILY_UNAVAILABLE :
                retval = "Temporarily Unavailable";
                break;

            case REQUEST_ENTITY_TOO_LARGE :
                retval = "Request entity too large";
                break;

            case REQUEST_URI_TOO_LONG :
                retval = "Request-URI too large";
                break;

            case UNSUPPORTED_MEDIA_TYPE :
                retval = "Unsupported media type";
                break;

            case UNSUPPORTED_URI_SCHEME :
                retval = "Unsupported URI Scheme";
                break;

            case BAD_EXTENSION :
                retval = "Bad extension";
                break;

            case EXTENSION_REQUIRED :
                retval = "Etension Required";
                break;

            case INTERVAL_TOO_BRIEF :
                retval = "Interval too brief";
                break;

            case CALL_OR_TRANSACTION_DOES_NOT_EXIST :
                retval = "Call leg/Transaction does not exist";
                break;

            case LOOP_DETECTED :
                retval = "Loop detected";
                break;

            case TOO_MANY_HOPS :
                retval = "Too many hops";
                break;

            case ADDRESS_INCOMPLETE :
                retval = "Address incomplete";
                break;

            case AMBIGUOUS :
                retval = "Ambiguous";
                break;

            case BUSY_HERE :
                retval = "Busy here";
                break;

            case REQUEST_TERMINATED :
                retval = "Request Terminated";
                break;

            //Issue 168, Typo fix reported by fre on the retval
            case NOT_ACCEPTABLE_HERE :
                retval = "Not Acceptable here";
                break;

            case BAD_EVENT :
                retval = "Bad Event";
                break;

            case REQUEST_PENDING :
                retval = "Request Pending";
                break;

            case SERVER_INTERNAL_ERROR :
                retval = "Server Internal Error";
                break;

            case UNDECIPHERABLE :
                retval = "Undecipherable";
                break;

            case NOT_IMPLEMENTED :
                retval = "Not implemented";
                break;

            case BAD_GATEWAY :
                retval = "Bad gateway";
                break;

            case SERVICE_UNAVAILABLE :
                retval = "Service unavailable";
                break;

            case SERVER_TIMEOUT :
                retval = "Gateway timeout";
                break;

            case VERSION_NOT_SUPPORTED :
                retval = "SIP version not supported";
                break;

            case MESSAGE_TOO_LARGE :
                retval = "Message Too Large";
                break;

            case BUSY_EVERYWHERE :
                retval = "Busy everywhere";
                break;

            case DECLINE :
                retval = "Decline";
                break;

            case DOES_NOT_EXIST_ANYWHERE :
                retval = "Does not exist anywhere";
                break;

            case SESSION_NOT_ACCEPTABLE :
                retval = "Session Not acceptable";
                break;

            case CONDITIONAL_REQUEST_FAILED:
                retval = "Conditional request failed";
                break;

            default :
                retval = "Unknown Status";

        }
        return retval;

    }

    /** Return true if the response is a final response.
     *@param rc is the return code.
     *@return true if the parameter is between the range 200 and 700.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.556 -0500", hash_original_method = "9BDD4A9455BD1C7063AC3292F21A5391", hash_generated_method = "E984B1AF0D90746A0523DDD96252ED83")
    
public static boolean isFinalResponse(int rc) {
        return rc >= 200 && rc < 700;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.536 -0500", hash_original_field = "4C50529F9664A6B13E43C09FC604FE0C", hash_generated_field = "4214B75EEFCC2F5FE0C8E2F4EEF5B95F")

    protected StatusLine statusLine;

    /** Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.564 -0500", hash_original_method = "65DF8DACE365B596A00FB19E5D885842", hash_generated_method = "7FEC7FFFD9A82C910E99BC4EE8678350")
    
public SIPResponse() {
        super();
    }

    /** set the status code.
     *@param statusCode is the status code to set.
     *@throws IlegalArgumentException if invalid status code.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.544 -0500", hash_original_method = "13FB64FAC5CAB193CAEE311D629E27B6", hash_generated_method = "C71EF0C8945C9FB319B5902C7D75D3A3")
    
public void setStatusCode(int statusCode) throws ParseException {

      // RFC3261 defines statuscode as 3DIGIT, 606 is the highest officially
      // defined code but extensions may add others (in theory up to 999,
      // but in practice up to 699 since the 6xx range is defined as 'final error')
        if (statusCode < 100 || statusCode > 699)
            throw new ParseException("bad status code", 0);
        if (this.statusLine == null)
            this.statusLine = new StatusLine();
        this.statusLine.setStatusCode(statusCode);
    }

    /**
     * Get the status line of the response.
     *@return StatusLine
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.546 -0500", hash_original_method = "A01A6E14359F44471B36FBE20B7B7D3C", hash_generated_method = "8D01BFD6FB20FFC92D2B0CFDA8D009AD")
    
public StatusLine getStatusLine() {
        return statusLine;
    }

    /** Get the staus code (conveniance function).
     *@return the status code of the status line.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.548 -0500", hash_original_method = "83A312D9FCEFB6DCEE53922D19363429", hash_generated_method = "0F50982A111B92FF491D67F5F040FCB0")
    
public int getStatusCode() {
        return statusLine.getStatusCode();
    }

    /** Set the reason phrase.
     *@param reasonPhrase the reason phrase.
     *@throws IllegalArgumentException if null string
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.551 -0500", hash_original_method = "1E99C1E53099DAE9563D2AD677513193", hash_generated_method = "AFADAB15DF93F0FDD8E7665A24397D5F")
    
public void setReasonPhrase(String reasonPhrase) {
        if (reasonPhrase == null)
            throw new IllegalArgumentException("Bad reason phrase");
        if (this.statusLine == null)
            this.statusLine = new StatusLine();
        this.statusLine.setReasonPhrase(reasonPhrase);
    }

    /** Get the reason phrase.
     *@return the reason phrase.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.553 -0500", hash_original_method = "116CF5266E081CFEF1340E67E2A6CB5B", hash_generated_method = "5CBEEDBC580502FB2FE58E3A7234B866")
    
public String getReasonPhrase() {
        if (statusLine == null || statusLine.getReasonPhrase() == null)
            return "";
        else
            return statusLine.getReasonPhrase();
    }

    /** Is this a final response?
     *@return true if this is a final response.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.559 -0500", hash_original_method = "298BCAB11064A058FB155FBEF5B04212", hash_generated_method = "85399CA52B5D349444155F5AF171013D")
    
public boolean isFinalResponse() {
        return isFinalResponse(statusLine.getStatusCode());
    }

    /**
     * Set the status line field.
     *@param sl Status line to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.562 -0500", hash_original_method = "7D2F1602DEBC36BCE0009AF9416F7471", hash_generated_method = "C37B2F5D9289BDEC8A500B9A00F77463")
    
public void setStatusLine(StatusLine sl) {
        statusLine = sl;
    }
    /**
     * Print formatting function.
     *Indent and parenthesize for pretty printing.
     * Note -- use the encode method for formatting the message.
     * Hack here to XMLize.
     *
     *@return a string for pretty printing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.567 -0500", hash_original_method = "55B8B2C74AE8EFAFCF07CA3753E23BB0", hash_generated_method = "A30D64FD09E2B0376DF0127CD24EFA6B")
    
public String debugDump() {
        String superstring = super.debugDump();
        stringRepresentation = "";
        sprint(SIPResponse.class.getCanonicalName());
        sprint("{");
        if (statusLine != null) {
            sprint(statusLine.debugDump());
        }
        sprint(superstring);
        sprint("}");
        return stringRepresentation;
    }

    /**
     * Check the response structure. Must have from, to CSEQ and VIA
     * headers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.569 -0500", hash_original_method = "C990BF11F3A1B0CB0383B4A73773ED5B", hash_generated_method = "1DC6F74BDCD474B5CA7CC5413E32C922")
    
public void checkHeaders() throws ParseException {
        if (getCSeq() == null) {
            throw new ParseException(CSeq.NAME+ " Is missing ", 0);
        }
        if (getTo() == null) {
            throw new ParseException(To.NAME+ " Is missing ", 0);
        }
        if (getFrom() == null) {
            throw new ParseException(From.NAME+ " Is missing ", 0);
        }
        if (getViaHeaders() == null) {
            throw new ParseException(Via.NAME+ " Is missing ", 0);
        }
        if (getCallId() == null) {
            throw new ParseException(CallID.NAME + " Is missing ", 0);
        }

        if (getStatusCode() > 699) {
            throw new ParseException("Unknown error code!" + getStatusCode(), 0);
        }

    }

    /**
     *  Encode the SIP Request as a string.
     *@return The string encoded canonical form of the message.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.571 -0500", hash_original_method = "B07DBFC1814EC442DAADA17506313119", hash_generated_method = "9E1C9BE76DFF7E78A3DC9474715D9513")
    
public String encode() {
        String retval;
        if (statusLine != null)
            retval = statusLine.encode() + super.encode();
        else
            retval = super.encode();
        return retval ;
    }

    /** Encode the message except for the body.
    *
    *@return The string except for the body.
    */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.574 -0500", hash_original_method = "BE972BED58D414983B801FA7B0B8948D", hash_generated_method = "E13A9001291767B2DB837CA14886ABC3")
    
public String encodeMessage() {
        String retval;
        if (statusLine != null)
            retval = statusLine.encode() + super.encodeSIPHeaders();
        else
            retval = super.encodeSIPHeaders();
        return retval ;
    }

    /** Get this message as a list of encoded strings.
     *@return LinkedList containing encoded strings for each header in
     *   the message.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.577 -0500", hash_original_method = "6F0C3DD571A294E8DFD4F72BBB3CCE7B", hash_generated_method = "36DBBAB33213CA4ABBCFABAB2C048017")
    
public LinkedList getMessageAsEncodedStrings() {
        LinkedList retval = super.getMessageAsEncodedStrings();

        if (statusLine != null)
            retval.addFirst(statusLine.encode());
        return retval;

    }

    /**
     * Make a clone (deep copy) of this object.
     *@return a deep copy of this object.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.579 -0500", hash_original_method = "DB86120AE2172E8F10EBF4BE032C0B65", hash_generated_method = "EC6E53241FB95C4510E2107EBE0789CC")
    
public Object clone() {
        SIPResponse retval = (SIPResponse) super.clone();
        if (this.statusLine != null)
            retval.statusLine = (StatusLine) this.statusLine.clone();
        return retval;
    }

    /**
     * Compare for equality.
     *@param other other object to compare with.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.582 -0500", hash_original_method = "8179D62366D10A1706B482955DEA9790", hash_generated_method = "E6D56011159932796927CAADB5E5BE06")
    
public boolean equals(Object other) {
        if (!this.getClass().equals(other.getClass()))
            return false;
        SIPResponse that = (SIPResponse) other;
        return statusLine.equals(that.statusLine) && super.equals(other);
    }

    /**
     * Match with a template.
     *@param matchObj template object to match ourselves with (null
     * in any position in the template object matches wildcard)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.585 -0500", hash_original_method = "E3EF862BAAD83B9956A8AA3297016E01", hash_generated_method = "13E58C66E850EA7B48861D473E69E03D")
    
public boolean match(Object matchObj) {
        if (matchObj == null)
            return true;
        else if (!matchObj.getClass().equals(this.getClass())) {
            return false;
        } else if (matchObj == this)
            return true;
        SIPResponse that = (SIPResponse) matchObj;

        StatusLine rline = that.statusLine;
        if (this.statusLine == null && rline != null)
            return false;
        else if (this.statusLine == rline)
            return super.match(matchObj);
        else {

            return statusLine.match(that.statusLine) && super.match(matchObj);
        }

    }

    /** Encode this into a byte array.
     * This is used when the body has been set as a binary array
     * and you want to encode the body as a byte array for transmission.
     *
     *@return a byte array containing the SIPRequest encoded as a byte
     *  array.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.587 -0500", hash_original_method = "8A95B6782662E6180E39BCA19FEC79A2", hash_generated_method = "E705090A3E61239D7EFB0BC96276E719")
    
public byte[] encodeAsBytes( String transport ) {
        byte[] slbytes = null;
        if (statusLine != null) {
            try {
                slbytes = statusLine.encode().getBytes("UTF-8");
            } catch (UnsupportedEncodingException ex) {
                InternalErrorHandler.handleException(ex);
            }
        }
        byte[] superbytes = super.encodeAsBytes( transport );
        byte[] retval = new byte[slbytes.length + superbytes.length];
        System.arraycopy(slbytes, 0, retval, 0, slbytes.length);
        System.arraycopy(superbytes, 0, retval, slbytes.length,
                superbytes.length);
        return retval;
    }

    /** Get a dialog identifier.
     * Generates a string that can be used as a dialog identifier.
     *
     * @param isServer is set to true if this is the UAS
     * and set to false if this is the UAC
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.590 -0500", hash_original_method = "9D2127AEC1E1548A62DA89BBBF00D215", hash_generated_method = "51E5F20A832E54757FADCF8D0C90486D")
    
public String getDialogId(boolean isServer) {
        CallID cid = (CallID) this.getCallId();
        From from = (From) this.getFrom();
        To to = (To) this.getTo();
        StringBuffer retval = new StringBuffer(cid.getCallId());
        if (!isServer) {
            //retval.append(COLON).append(from.getUserAtHostPort());
            if (from.getTag() != null) {
                retval.append(COLON);
                retval.append(from.getTag());
            }
            //retval.append(COLON).append(to.getUserAtHostPort());
            if (to.getTag() != null) {
                retval.append(COLON);
                retval.append(to.getTag());
            }
        } else {
            //retval.append(COLON).append(to.getUserAtHostPort());
            if (to.getTag() != null) {
                retval.append(COLON);
                retval.append(to.getTag());
            }
            //retval.append(COLON).append(from.getUserAtHostPort());
            if (from.getTag() != null) {
                retval.append(COLON);
                retval.append(from.getTag());
            }
        }
        return retval.toString().toLowerCase();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.593 -0500", hash_original_method = "6DAE45694664AE2CF5B3EB0BCA54E49B", hash_generated_method = "9F2ADF6A1C0256C2AF3ACE84B6B62376")
    
public String getDialogId(boolean isServer, String toTag) {
        CallID cid = (CallID) this.getCallId();
        From from = (From) this.getFrom();
        StringBuffer retval = new StringBuffer(cid.getCallId());
        if (!isServer) {
            //retval.append(COLON).append(from.getUserAtHostPort());
            if (from.getTag() != null) {
                retval.append(COLON);
                retval.append(from.getTag());
            }
            //retval.append(COLON).append(to.getUserAtHostPort());
            if (toTag != null) {
                retval.append(COLON);
                retval.append(toTag);
            }
        } else {
            //retval.append(COLON).append(to.getUserAtHostPort());
            if (toTag != null) {
                retval.append(COLON);
                retval.append(toTag);
            }
            //retval.append(COLON).append(from.getUserAtHostPort());
            if (from.getTag() != null) {
                retval.append(COLON);
                retval.append(from.getTag());
            }
        }
        return retval.toString().toLowerCase();
    }

    /**
     * Sets the Via branch for CANCEL or ACK requests
     *
     * @param via
     * @param method
     * @throws ParseException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.596 -0500", hash_original_method = "20A80D2C7777E602FB41086859FCE7A8", hash_generated_method = "55F620A2972E397D0422621AF41A15E0")
    
private final void setBranch( Via via, String method ) {
        String branch;
        if (method.equals( Request.ACK ) ) {
            if (statusLine.getStatusCode() >= 300 ) {
                branch = getTopmostVia().getBranch();   // non-2xx ACK uses same branch
            } else {
                branch = Utils.getInstance().generateBranchId();    // 2xx ACK gets new branch
            }
        } else if (method.equals( Request.CANCEL )) {
            branch = getTopmostVia().getBranch();   // CANCEL uses same branch
        } else return;

        try {
            via.setBranch( branch );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the encoded first line.
     *
     *@return the status line encoded.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.599 -0500", hash_original_method = "EE95455CDB90A9B95BEE72161BE1B5B8", hash_generated_method = "139389A587B9ABCED5D44A5482056AB1")
    
public String getFirstLine() {
        if (this.statusLine == null)
            return null;
        else
            return this.statusLine.encode();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.601 -0500", hash_original_method = "7AF9DBED68BFE70E00218B8B8B8BF082", hash_generated_method = "B2D1D2CE38A3F32F163109DB8658AF4A")
    
public void setSIPVersion(String sipVersion) {
        this.statusLine.setSipVersion(sipVersion);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.604 -0500", hash_original_method = "81E4A3A86ED8E9389A222C77FFC4E212", hash_generated_method = "5291D37196CFDE6336F38A2E2209772D")
    
public String getSIPVersion() {
        return this.statusLine.getSipVersion();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.607 -0500", hash_original_method = "11E3A7EA0BB166C76EF5663B1C05C1DB", hash_generated_method = "FEDF0922A0CDE1027F0FCBB4054C4E54")
    
public String toString() {
        if (statusLine == null) return  "";
        else return statusLine.encode() + super.encode();
    }

    /**
     * Generate a request from a response.
     *
     * @param requestURI -- the request URI to assign to the request.
     * @param via -- the Via header to assign to the request
     * @param cseq -- the CSeq header to assign to the request
     * @param from -- the From header to assign to the request
     * @param to -- the To header to assign to the request
     * @return -- the newly generated sip request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.610 -0500", hash_original_method = "B6A6DA92002B5EA057CE082C91930B65", hash_generated_method = "A603441423DB3EB7274980FF307DAD07")
    
public SIPRequest createRequest(SipUri requestURI, Via via, CSeq cseq, From from, To to) {
        SIPRequest newRequest = new SIPRequest();
        String method = cseq.getMethod();

        newRequest.setMethod(method);
        newRequest.setRequestURI(requestURI);
        this.setBranch( via, method );
        newRequest.setHeader(via);
        newRequest.setHeader(cseq);
        Iterator headerIterator = getHeaders();
        while (headerIterator.hasNext()) {
            SIPHeader nextHeader = (SIPHeader) headerIterator.next();
            // Some headers do not belong in a Request ....
            if (SIPMessage.isResponseHeader(nextHeader)
                || nextHeader instanceof ViaList
                || nextHeader instanceof CSeq
                || nextHeader instanceof ContentType
                || nextHeader instanceof ContentLength
                || nextHeader instanceof RecordRouteList
                || nextHeader instanceof RequireList
                || nextHeader instanceof ContactList    // JvB: added
                || nextHeader instanceof ContentLength
                || nextHeader instanceof ServerHeader
                || nextHeader instanceof ReasonHeader
                || nextHeader instanceof SessionExpires
                || nextHeader instanceof ReasonList) {
                continue;
            }
            if (nextHeader instanceof To)
                nextHeader = (SIPHeader) to;
            else if (nextHeader instanceof From)
                nextHeader = (SIPHeader) from;
            try {
                newRequest.attachHeader(nextHeader, false);
            } catch (SIPDuplicateHeaderException e) {
                //Should not happen!
                e.printStackTrace();
            }
        }

        try {
          // JvB: all requests need a Max-Forwards
          newRequest.attachHeader( new MaxForwards(70), false);
        } catch (Exception d) {

        }

        if (MessageFactoryImpl.getDefaultUserAgentHeader() != null ) {
            newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
        }
        return newRequest;

    }
    
}

