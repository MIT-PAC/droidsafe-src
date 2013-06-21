package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    protected StatusLine statusLine;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.196 -0400", hash_original_method = "65DF8DACE365B596A00FB19E5D885842", hash_generated_method = "AE416E6D4DED1C87AFAE2A281AEC29CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPResponse() {
        super();
        // ---------- Original Method ----------
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.196 -0400", hash_original_method = "13FB64FAC5CAB193CAEE311D629E27B6", hash_generated_method = "DDB15898815F19C7D7AB14A9578DC94B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStatusCode(int statusCode) throws ParseException {
        dsTaint.addTaint(statusCode);
        if (DroidSafeAndroidRuntime.control) throw new ParseException("bad status code", 0);
        this.statusLine = new StatusLine();
        this.statusLine.setStatusCode(statusCode);
        // ---------- Original Method ----------
        //if (statusCode < 100 || statusCode > 699)
            //throw new ParseException("bad status code", 0);
        //if (this.statusLine == null)
            //this.statusLine = new StatusLine();
        //this.statusLine.setStatusCode(statusCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.197 -0400", hash_original_method = "A01A6E14359F44471B36FBE20B7B7D3C", hash_generated_method = "DD356D54EBD02E5DF14F2D4B7A75CA26")
    @DSModeled(DSC.SAFE)
    public StatusLine getStatusLine() {
        return (StatusLine)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return statusLine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.197 -0400", hash_original_method = "83A312D9FCEFB6DCEE53922D19363429", hash_generated_method = "B16E9F3EE28772C9B1D14BD486F17B6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStatusCode() {
        int varD859CC97397DB96E8F5EB83FBBCBB1EC_380873368 = (statusLine.getStatusCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return statusLine.getStatusCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.197 -0400", hash_original_method = "1E99C1E53099DAE9563D2AD677513193", hash_generated_method = "D5F44DEEA067D9566B3BA1F17B8FBEE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReasonPhrase(String reasonPhrase) {
        dsTaint.addTaint(reasonPhrase);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad reason phrase");
        this.statusLine = new StatusLine();
        this.statusLine.setReasonPhrase(reasonPhrase);
        // ---------- Original Method ----------
        //if (reasonPhrase == null)
            //throw new IllegalArgumentException("Bad reason phrase");
        //if (this.statusLine == null)
            //this.statusLine = new StatusLine();
        //this.statusLine.setReasonPhrase(reasonPhrase);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.197 -0400", hash_original_method = "116CF5266E081CFEF1340E67E2A6CB5B", hash_generated_method = "207613096F2727EDD761A6D4D30B55F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getReasonPhrase() {
        {
            boolean varD79B996C15B8224204D233914DDF1C6A_1852881483 = (statusLine == null || statusLine.getReasonPhrase() == null);
            String var132CC29BA48FAB1C1B52241FB46026C1_1465364014 = (statusLine.getReasonPhrase());
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (statusLine == null || statusLine.getReasonPhrase() == null)
            //return "";
        //else
            //return statusLine.getReasonPhrase();
    }

    
        public static boolean isFinalResponse(int rc) {
        return rc >= 200 && rc < 700;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.197 -0400", hash_original_method = "298BCAB11064A058FB155FBEF5B04212", hash_generated_method = "BEF3CFE2A7F1C57C26830DF5D44D3B8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isFinalResponse() {
        boolean var3591EB911E6267E97669918E320A7B29_1919872458 = (isFinalResponse(statusLine.getStatusCode()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isFinalResponse(statusLine.getStatusCode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.198 -0400", hash_original_method = "7D2F1602DEBC36BCE0009AF9416F7471", hash_generated_method = "0FD478FECCC63748F8121E54956FE23F")
    @DSModeled(DSC.SAFE)
    public void setStatusLine(StatusLine sl) {
        dsTaint.addTaint(sl.dsTaint);
        // ---------- Original Method ----------
        //statusLine = sl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.198 -0400", hash_original_method = "55B8B2C74AE8EFAFCF07CA3753E23BB0", hash_generated_method = "AE492BD7AA7C320D2B19254647961BDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String debugDump() {
        String superstring;
        superstring = super.debugDump();
        stringRepresentation = "";
        sprint(SIPResponse.class.getCanonicalName());
        sprint("{");
        {
            sprint(statusLine.debugDump());
        } //End block
        sprint(superstring);
        sprint("}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String superstring = super.debugDump();
        //stringRepresentation = "";
        //sprint(SIPResponse.class.getCanonicalName());
        //sprint("{");
        //if (statusLine != null) {
            //sprint(statusLine.debugDump());
        //}
        //sprint(superstring);
        //sprint("}");
        //return stringRepresentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.198 -0400", hash_original_method = "C990BF11F3A1B0CB0383B4A73773ED5B", hash_generated_method = "ECBBD5EA4118DAFFC92865C4E1A9EAC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void checkHeaders() throws ParseException {
        {
            boolean var6342A96FD7DE6C1AD71DF5E6F041816B_1570891237 = (getCSeq() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(CSeq.NAME+ " Is missing ", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var028720CEB12D4FCC08D30523F58E270F_1804036112 = (getTo() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(To.NAME+ " Is missing ", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var59B1519B8C7900F9210D51C7E88064B0_1576427264 = (getFrom() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(From.NAME+ " Is missing ", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCE8B10FB91FF6C0A5E135CD4C2A83BAD_225246311 = (getViaHeaders() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(Via.NAME+ " Is missing ", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBA60822AA10D06D1B72B8431F8364BB6_685096261 = (getCallId() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(CallID.NAME + " Is missing ", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF2E7FF4AFF0DD92AB829FDA3E8D58905_1539989526 = (getStatusCode() > 699);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Unknown error code!" + getStatusCode(), 0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getCSeq() == null) {
            //throw new ParseException(CSeq.NAME+ " Is missing ", 0);
        //}
        //if (getTo() == null) {
            //throw new ParseException(To.NAME+ " Is missing ", 0);
        //}
        //if (getFrom() == null) {
            //throw new ParseException(From.NAME+ " Is missing ", 0);
        //}
        //if (getViaHeaders() == null) {
            //throw new ParseException(Via.NAME+ " Is missing ", 0);
        //}
        //if (getCallId() == null) {
            //throw new ParseException(CallID.NAME + " Is missing ", 0);
        //}
        //if (getStatusCode() > 699) {
            //throw new ParseException("Unknown error code!" + getStatusCode(), 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.198 -0400", hash_original_method = "B07DBFC1814EC442DAADA17506313119", hash_generated_method = "F23890966F256619FF7583077D504BFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String retval;
        retval = statusLine.encode() + super.encode();
        retval = super.encode();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String retval;
        //if (statusLine != null)
            //retval = statusLine.encode() + super.encode();
        //else
            //retval = super.encode();
        //return retval ;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.199 -0400", hash_original_method = "BE972BED58D414983B801FA7B0B8948D", hash_generated_method = "8891B043622E775176EA4294CBAB5CD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeMessage() {
        String retval;
        retval = statusLine.encode() + super.encodeSIPHeaders();
        retval = super.encodeSIPHeaders();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String retval;
        //if (statusLine != null)
            //retval = statusLine.encode() + super.encodeSIPHeaders();
        //else
            //retval = super.encodeSIPHeaders();
        //return retval ;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.199 -0400", hash_original_method = "6F0C3DD571A294E8DFD4F72BBB3CCE7B", hash_generated_method = "0FDEB79B5F90D5250C2DFCA6164705D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedList getMessageAsEncodedStrings() {
        LinkedList retval;
        retval = super.getMessageAsEncodedStrings();
        retval.addFirst(statusLine.encode());
        return (LinkedList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LinkedList retval = super.getMessageAsEncodedStrings();
        //if (statusLine != null)
            //retval.addFirst(statusLine.encode());
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.199 -0400", hash_original_method = "DB86120AE2172E8F10EBF4BE032C0B65", hash_generated_method = "CB28CE30F0C8978E6BC1D78CA9B59D1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        SIPResponse retval;
        retval = (SIPResponse) super.clone();
        retval.statusLine = (StatusLine) this.statusLine.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SIPResponse retval = (SIPResponse) super.clone();
        //if (this.statusLine != null)
            //retval.statusLine = (StatusLine) this.statusLine.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.199 -0400", hash_original_method = "8179D62366D10A1706B482955DEA9790", hash_generated_method = "0704A5259BA922BE8EFA48463C050361")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_670373478 = (!this.getClass().equals(other.getClass()));
        } //End collapsed parenthetic
        SIPResponse that;
        that = (SIPResponse) other;
        boolean var2E4D82D5A00FDE713CBA592D511F580B_1927292249 = (statusLine.equals(that.statusLine) && super.equals(other));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!this.getClass().equals(other.getClass()))
            //return false;
        //SIPResponse that = (SIPResponse) other;
        //return statusLine.equals(that.statusLine) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.200 -0400", hash_original_method = "E3EF862BAAD83B9956A8AA3297016E01", hash_generated_method = "3B90E7BFACE1563585999B464C003541")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean match(Object matchObj) {
        dsTaint.addTaint(matchObj.dsTaint);
        {
            boolean varE5ABD91269B098FDB02552058FE738E0_682275726 = (!matchObj.getClass().equals(this.getClass()));
            {
                boolean var3D06C934D988FBFEA9FF217EEB1CEB0C_1852034368 = (matchObj == this);
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        SIPResponse that;
        that = (SIPResponse) matchObj;
        StatusLine rline;
        rline = that.statusLine;
        boolean var6F0A9113B429A383C35EED8AD8F98AAE_1757065327 = (super.match(matchObj));
        {
            boolean varA212D68AC1E4A9C32D9D4D8952220840_1519534827 = (statusLine.match(that.statusLine) && super.match(matchObj));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (matchObj == null)
            //return true;
        //else if (!matchObj.getClass().equals(this.getClass())) {
            //return false;
        //} else if (matchObj == this)
            //return true;
        //SIPResponse that = (SIPResponse) matchObj;
        //StatusLine rline = that.statusLine;
        //if (this.statusLine == null && rline != null)
            //return false;
        //else if (this.statusLine == rline)
            //return super.match(matchObj);
        //else {
            //return statusLine.match(that.statusLine) && super.match(matchObj);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.200 -0400", hash_original_method = "8A95B6782662E6180E39BCA19FEC79A2", hash_generated_method = "6AA05E19247ED15E6628D21B0D0B12DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] encodeAsBytes( String transport ) {
        dsTaint.addTaint(transport);
        byte[] slbytes;
        slbytes = null;
        {
            try 
            {
                slbytes = statusLine.encode().getBytes("UTF-8");
            } //End block
            catch (UnsupportedEncodingException ex)
            {
                InternalErrorHandler.handleException(ex);
            } //End block
        } //End block
        byte[] superbytes;
        superbytes = super.encodeAsBytes( transport );
        byte[] retval;
        retval = new byte[slbytes.length + superbytes.length];
        System.arraycopy(slbytes, 0, retval, 0, slbytes.length);
        System.arraycopy(superbytes, 0, retval, slbytes.length,
                superbytes.length);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] slbytes = null;
        //if (statusLine != null) {
            //try {
                //slbytes = statusLine.encode().getBytes("UTF-8");
            //} catch (UnsupportedEncodingException ex) {
                //InternalErrorHandler.handleException(ex);
            //}
        //}
        //byte[] superbytes = super.encodeAsBytes( transport );
        //byte[] retval = new byte[slbytes.length + superbytes.length];
        //System.arraycopy(slbytes, 0, retval, 0, slbytes.length);
        //System.arraycopy(superbytes, 0, retval, slbytes.length,
                //superbytes.length);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.200 -0400", hash_original_method = "9D2127AEC1E1548A62DA89BBBF00D215", hash_generated_method = "200514EF7A6DE2291D8C97D41940488E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDialogId(boolean isServer) {
        dsTaint.addTaint(isServer);
        CallID cid;
        cid = (CallID) this.getCallId();
        From from;
        from = (From) this.getFrom();
        To to;
        to = (To) this.getTo();
        StringBuffer retval;
        retval = new StringBuffer(cid.getCallId());
        {
            {
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_1599819461 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var1BE29C19B15B07BF37F624C6B7042CDF_52600277 = (to.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(to.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var1BE29C19B15B07BF37F624C6B7042CDF_2068164309 = (to.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(to.getTag());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_1944500948 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        String var83C56777869B6188025C813E0B2FBE18_957841445 = (retval.toString().toLowerCase());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.201 -0400", hash_original_method = "6DAE45694664AE2CF5B3EB0BCA54E49B", hash_generated_method = "DAD27606AB9C11A8A9B0FB4ED1A67AAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDialogId(boolean isServer, String toTag) {
        dsTaint.addTaint(toTag);
        dsTaint.addTaint(isServer);
        CallID cid;
        cid = (CallID) this.getCallId();
        From from;
        from = (From) this.getFrom();
        StringBuffer retval;
        retval = new StringBuffer(cid.getCallId());
        {
            {
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_1173799979 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
            {
                retval.append(COLON);
                retval.append(toTag);
            } //End block
        } //End block
        {
            {
                retval.append(COLON);
                retval.append(toTag);
            } //End block
            {
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_1561574033 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        String var83C56777869B6188025C813E0B2FBE18_1724327592 = (retval.toString().toLowerCase());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.201 -0400", hash_original_method = "20A80D2C7777E602FB41086859FCE7A8", hash_generated_method = "4DA6D42AA09632A646ED312BFBC55464")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void setBranch( Via via, String method ) {
        dsTaint.addTaint(via.dsTaint);
        dsTaint.addTaint(method);
        String branch;
        {
            boolean var4D1E14298D0940533345FEB745E202E5_509541082 = (method.equals( Request.ACK ));
            {
                {
                    boolean var5D4C73C769DA05A2485ED8FEE0F4734C_6421152 = (statusLine.getStatusCode() >= 300);
                    {
                        branch = getTopmostVia().getBranch();
                    } //End block
                    {
                        branch = Utils.getInstance().generateBranchId();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var92A9CE588B1D28BBEAFD2D6E5E8923F5_340303010 = (method.equals( Request.CANCEL ));
                {
                    branch = getTopmostVia().getBranch();
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        try 
        {
            via.setBranch( branch );
        } //End block
        catch (ParseException e)
        {
            e.printStackTrace();
        } //End block
        // ---------- Original Method ----------
        //String branch;
        //if (method.equals( Request.ACK ) ) {
            //if (statusLine.getStatusCode() >= 300 ) {
                //branch = getTopmostVia().getBranch();   
            //} else {
                //branch = Utils.getInstance().generateBranchId();    
            //}
        //} else if (method.equals( Request.CANCEL )) {
            //branch = getTopmostVia().getBranch();   
        //} else return;
        //try {
            //via.setBranch( branch );
        //} catch (ParseException e) {
            //e.printStackTrace();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.201 -0400", hash_original_method = "EE95455CDB90A9B95BEE72161BE1B5B8", hash_generated_method = "30515C0172A9AAF583115ADEC5A0476F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getFirstLine() {
        String var62CFE35277E6271EDCFF2554C9BD6712_232340149 = (this.statusLine.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (this.statusLine == null)
            //return null;
        //else
            //return this.statusLine.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.202 -0400", hash_original_method = "7AF9DBED68BFE70E00218B8B8B8BF082", hash_generated_method = "0A02B517ED64D95540F101587ACDBE2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSIPVersion(String sipVersion) {
        dsTaint.addTaint(sipVersion);
        this.statusLine.setSipVersion(sipVersion);
        // ---------- Original Method ----------
        //this.statusLine.setSipVersion(sipVersion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.202 -0400", hash_original_method = "81E4A3A86ED8E9389A222C77FFC4E212", hash_generated_method = "DDA15446C826D7DF89F8771F12D5ACBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSIPVersion() {
        String varF5DA0A61A0084418A82575404F72ECDC_1795130686 = (this.statusLine.getSipVersion());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.statusLine.getSipVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.202 -0400", hash_original_method = "11E3A7EA0BB166C76EF5663B1C05C1DB", hash_generated_method = "16AF774CC812AC3C75B8A6BC0F76ACBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var60F08036BC83CEBF63C83769E8441993_236659162 = (statusLine.encode() + super.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (statusLine == null) return  "";
        //else return statusLine.encode() + super.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.202 -0400", hash_original_method = "B6A6DA92002B5EA057CE082C91930B65", hash_generated_method = "40C11349F13F1F512AA60C9231D0479F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPRequest createRequest(SipUri requestURI, Via via, CSeq cseq, From from, To to) {
        dsTaint.addTaint(to.dsTaint);
        dsTaint.addTaint(via.dsTaint);
        dsTaint.addTaint(cseq.dsTaint);
        dsTaint.addTaint(requestURI.dsTaint);
        dsTaint.addTaint(from.dsTaint);
        SIPRequest newRequest;
        newRequest = new SIPRequest();
        String method;
        method = cseq.getMethod();
        newRequest.setMethod(method);
        newRequest.setRequestURI(requestURI);
        this.setBranch( via, method );
        newRequest.setHeader(via);
        newRequest.setHeader(cseq);
        Iterator headerIterator;
        headerIterator = getHeaders();
        {
            boolean var1440086C7F6E137687239D414F8ECC74_382450739 = (headerIterator.hasNext());
            {
                SIPHeader nextHeader;
                nextHeader = (SIPHeader) headerIterator.next();
                {
                    boolean var75C54062C1C143943A1062913C71A6AD_1277447668 = (SIPMessage.isResponseHeader(nextHeader)
                || nextHeader instanceof ViaList
                || nextHeader instanceof CSeq
                || nextHeader instanceof ContentType
                || nextHeader instanceof ContentLength
                || nextHeader instanceof RecordRouteList
                || nextHeader instanceof RequireList
                || nextHeader instanceof ContactList    
                || nextHeader instanceof ContentLength
                || nextHeader instanceof ServerHeader
                || nextHeader instanceof ReasonHeader
                || nextHeader instanceof SessionExpires
                || nextHeader instanceof ReasonList);
                } //End collapsed parenthetic
                nextHeader = (SIPHeader) to;
                nextHeader = (SIPHeader) from;
                try 
                {
                    newRequest.attachHeader(nextHeader, false);
                } //End block
                catch (SIPDuplicateHeaderException e)
                {
                    e.printStackTrace();
                } //End block
            } //End block
        } //End collapsed parenthetic
        try 
        {
            newRequest.attachHeader( new MaxForwards(70), false);
        } //End block
        catch (Exception d)
        { }
        {
            boolean var896FD3C9C4EED86170D10D69961A19CE_1912615799 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        return (SIPRequest)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

