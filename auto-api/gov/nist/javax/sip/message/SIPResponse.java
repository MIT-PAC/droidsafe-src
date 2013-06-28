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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.586 -0400", hash_original_field = "8462E9D9B0BB0450DAF299F1B5423B07", hash_generated_field = "4214B75EEFCC2F5FE0C8E2F4EEF5B95F")

    protected StatusLine statusLine;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.586 -0400", hash_original_method = "65DF8DACE365B596A00FB19E5D885842", hash_generated_method = "AE416E6D4DED1C87AFAE2A281AEC29CD")
    public  SIPResponse() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.587 -0400", hash_original_method = "13FB64FAC5CAB193CAEE311D629E27B6", hash_generated_method = "488E9D18B5912AC5509D20E8DF5928BC")
    public void setStatusCode(int statusCode) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException("bad status code", 0);
        this.statusLine = new StatusLine();
        this.statusLine.setStatusCode(statusCode);
        addTaint(statusCode);
        // ---------- Original Method ----------
        //if (statusCode < 100 || statusCode > 699)
            //throw new ParseException("bad status code", 0);
        //if (this.statusLine == null)
            //this.statusLine = new StatusLine();
        //this.statusLine.setStatusCode(statusCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.587 -0400", hash_original_method = "A01A6E14359F44471B36FBE20B7B7D3C", hash_generated_method = "BBDB869F1CF49438C74278BDD2C74899")
    public StatusLine getStatusLine() {
        StatusLine varB4EAC82CA7396A68D541C85D26508E83_2067069094 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2067069094 = statusLine;
        varB4EAC82CA7396A68D541C85D26508E83_2067069094.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2067069094;
        // ---------- Original Method ----------
        //return statusLine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.588 -0400", hash_original_method = "83A312D9FCEFB6DCEE53922D19363429", hash_generated_method = "802EFCDE8E6442FA6C4BFB1BB8023F12")
    public int getStatusCode() {
        int varD859CC97397DB96E8F5EB83FBBCBB1EC_1463291057 = (statusLine.getStatusCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1475133053 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1475133053;
        // ---------- Original Method ----------
        //return statusLine.getStatusCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.588 -0400", hash_original_method = "1E99C1E53099DAE9563D2AD677513193", hash_generated_method = "DD36F23BFABCF8B0A47C7AC0CEC7703C")
    public void setReasonPhrase(String reasonPhrase) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad reason phrase");
        this.statusLine = new StatusLine();
        this.statusLine.setReasonPhrase(reasonPhrase);
        addTaint(reasonPhrase.getTaint());
        // ---------- Original Method ----------
        //if (reasonPhrase == null)
            //throw new IllegalArgumentException("Bad reason phrase");
        //if (this.statusLine == null)
            //this.statusLine = new StatusLine();
        //this.statusLine.setReasonPhrase(reasonPhrase);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.588 -0400", hash_original_method = "116CF5266E081CFEF1340E67E2A6CB5B", hash_generated_method = "662E5A155053E6B3B050167E6CE1FDB0")
    public String getReasonPhrase() {
        String varB4EAC82CA7396A68D541C85D26508E83_786957021 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_421874019 = null; //Variable for return #2
        {
            boolean varD79B996C15B8224204D233914DDF1C6A_1491820700 = (statusLine == null || statusLine.getReasonPhrase() == null);
            varB4EAC82CA7396A68D541C85D26508E83_786957021 = "";
            varB4EAC82CA7396A68D541C85D26508E83_421874019 = statusLine.getReasonPhrase();
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_1407830405; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1407830405 = varB4EAC82CA7396A68D541C85D26508E83_786957021;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1407830405 = varB4EAC82CA7396A68D541C85D26508E83_421874019;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1407830405.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1407830405;
        // ---------- Original Method ----------
        //if (statusLine == null || statusLine.getReasonPhrase() == null)
            //return "";
        //else
            //return statusLine.getReasonPhrase();
    }

    
    public static boolean isFinalResponse(int rc) {
        return rc >= 200 && rc < 700;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.589 -0400", hash_original_method = "298BCAB11064A058FB155FBEF5B04212", hash_generated_method = "1C7DF4E509BAEE446ABECD7AB8E2D116")
    public boolean isFinalResponse() {
        boolean var3591EB911E6267E97669918E320A7B29_1633528079 = (isFinalResponse(statusLine.getStatusCode()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1520453150 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1520453150;
        // ---------- Original Method ----------
        //return isFinalResponse(statusLine.getStatusCode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.590 -0400", hash_original_method = "7D2F1602DEBC36BCE0009AF9416F7471", hash_generated_method = "78471822E05FC292C5738D1D96B9B746")
    public void setStatusLine(StatusLine sl) {
        statusLine = sl;
        // ---------- Original Method ----------
        //statusLine = sl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.591 -0400", hash_original_method = "55B8B2C74AE8EFAFCF07CA3753E23BB0", hash_generated_method = "CE6E976E339F972820FC039F3A1E8848")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_1375627739 = null; //Variable for return #1
        String superstring = super.debugDump();
        stringRepresentation = "";
        sprint(SIPResponse.class.getCanonicalName());
        sprint("{");
        {
            sprint(statusLine.debugDump());
        } //End block
        sprint(superstring);
        sprint("}");
        varB4EAC82CA7396A68D541C85D26508E83_1375627739 = stringRepresentation;
        varB4EAC82CA7396A68D541C85D26508E83_1375627739.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1375627739;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.591 -0400", hash_original_method = "C990BF11F3A1B0CB0383B4A73773ED5B", hash_generated_method = "0CA9782E478B6F3D714AD0DAB6927CF8")
    public void checkHeaders() throws ParseException {
        {
            boolean var6342A96FD7DE6C1AD71DF5E6F041816B_1194400902 = (getCSeq() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(CSeq.NAME+ " Is missing ", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var028720CEB12D4FCC08D30523F58E270F_436925316 = (getTo() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(To.NAME+ " Is missing ", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var59B1519B8C7900F9210D51C7E88064B0_1952291323 = (getFrom() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(From.NAME+ " Is missing ", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCE8B10FB91FF6C0A5E135CD4C2A83BAD_201488639 = (getViaHeaders() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(Via.NAME+ " Is missing ", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBA60822AA10D06D1B72B8431F8364BB6_722293467 = (getCallId() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(CallID.NAME + " Is missing ", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF2E7FF4AFF0DD92AB829FDA3E8D58905_1657866273 = (getStatusCode() > 699);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.592 -0400", hash_original_method = "B07DBFC1814EC442DAADA17506313119", hash_generated_method = "80F0B34769F278903D77719E5AEEC36B")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1822033036 = null; //Variable for return #1
        String retval;
        retval = statusLine.encode() + super.encode();
        retval = super.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1822033036 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1822033036.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1822033036;
        // ---------- Original Method ----------
        //String retval;
        //if (statusLine != null)
            //retval = statusLine.encode() + super.encode();
        //else
            //retval = super.encode();
        //return retval ;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.593 -0400", hash_original_method = "BE972BED58D414983B801FA7B0B8948D", hash_generated_method = "0567FF6AB1ACDFCE51836F8A59A25788")
    public String encodeMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_104213621 = null; //Variable for return #1
        String retval;
        retval = statusLine.encode() + super.encodeSIPHeaders();
        retval = super.encodeSIPHeaders();
        varB4EAC82CA7396A68D541C85D26508E83_104213621 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_104213621.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_104213621;
        // ---------- Original Method ----------
        //String retval;
        //if (statusLine != null)
            //retval = statusLine.encode() + super.encodeSIPHeaders();
        //else
            //retval = super.encodeSIPHeaders();
        //return retval ;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.593 -0400", hash_original_method = "6F0C3DD571A294E8DFD4F72BBB3CCE7B", hash_generated_method = "3D8ECDC56ACFE4A8588C6DC4B4BA8D47")
    public LinkedList getMessageAsEncodedStrings() {
        LinkedList varB4EAC82CA7396A68D541C85D26508E83_2099808331 = null; //Variable for return #1
        LinkedList retval = super.getMessageAsEncodedStrings();
        retval.addFirst(statusLine.encode());
        varB4EAC82CA7396A68D541C85D26508E83_2099808331 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_2099808331.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2099808331;
        // ---------- Original Method ----------
        //LinkedList retval = super.getMessageAsEncodedStrings();
        //if (statusLine != null)
            //retval.addFirst(statusLine.encode());
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.594 -0400", hash_original_method = "DB86120AE2172E8F10EBF4BE032C0B65", hash_generated_method = "40A89A19DD456D4EDE109DB74085335C")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1536752300 = null; //Variable for return #1
        SIPResponse retval = (SIPResponse) super.clone();
        retval.statusLine = (StatusLine) this.statusLine.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1536752300 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1536752300.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1536752300;
        // ---------- Original Method ----------
        //SIPResponse retval = (SIPResponse) super.clone();
        //if (this.statusLine != null)
            //retval.statusLine = (StatusLine) this.statusLine.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.594 -0400", hash_original_method = "8179D62366D10A1706B482955DEA9790", hash_generated_method = "76083E2A7DF3B36EA3B2FDC167D4B244")
    public boolean equals(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_784409419 = (!this.getClass().equals(other.getClass()));
        } //End collapsed parenthetic
        SIPResponse that = (SIPResponse) other;
        boolean var2E4D82D5A00FDE713CBA592D511F580B_516990060 = (statusLine.equals(that.statusLine) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_514483671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_514483671;
        // ---------- Original Method ----------
        //if (!this.getClass().equals(other.getClass()))
            //return false;
        //SIPResponse that = (SIPResponse) other;
        //return statusLine.equals(that.statusLine) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.595 -0400", hash_original_method = "E3EF862BAAD83B9956A8AA3297016E01", hash_generated_method = "A7B0263A684FBC8BEFE7FF22A9A9ACDA")
    public boolean match(Object matchObj) {
        {
            boolean varE5ABD91269B098FDB02552058FE738E0_414357927 = (!matchObj.getClass().equals(this.getClass()));
            {
                boolean var3D06C934D988FBFEA9FF217EEB1CEB0C_2023068489 = (matchObj == this);
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        SIPResponse that = (SIPResponse) matchObj;
        StatusLine rline = that.statusLine;
        boolean var6F0A9113B429A383C35EED8AD8F98AAE_1285842597 = (super.match(matchObj));
        {
            boolean varA212D68AC1E4A9C32D9D4D8952220840_1578791548 = (statusLine.match(that.statusLine) && super.match(matchObj));
        } //End block
        addTaint(matchObj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_248908189 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_248908189;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.595 -0400", hash_original_method = "8A95B6782662E6180E39BCA19FEC79A2", hash_generated_method = "B83ECF30B5AED3E4E300410AED387617")
    public byte[] encodeAsBytes( String transport ) {
        byte[] slbytes = null;
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
        byte[] superbytes = super.encodeAsBytes( transport );
        byte[] retval = new byte[slbytes.length + superbytes.length];
        System.arraycopy(slbytes, 0, retval, 0, slbytes.length);
        System.arraycopy(superbytes, 0, retval, slbytes.length,
                superbytes.length);
        addTaint(transport.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1298042333 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1298042333;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.596 -0400", hash_original_method = "9D2127AEC1E1548A62DA89BBBF00D215", hash_generated_method = "1426AA9A879208CCC04A6C5844DBFB3F")
    public String getDialogId(boolean isServer) {
        String varB4EAC82CA7396A68D541C85D26508E83_610933961 = null; //Variable for return #1
        CallID cid = (CallID) this.getCallId();
        From from = (From) this.getFrom();
        To to = (To) this.getTo();
        StringBuffer retval = new StringBuffer(cid.getCallId());
        {
            {
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_895776495 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var1BE29C19B15B07BF37F624C6B7042CDF_1223145927 = (to.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(to.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var1BE29C19B15B07BF37F624C6B7042CDF_1147147623 = (to.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(to.getTag());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_1753003871 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_610933961 = retval.toString().toLowerCase();
        addTaint(isServer);
        varB4EAC82CA7396A68D541C85D26508E83_610933961.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_610933961;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.597 -0400", hash_original_method = "6DAE45694664AE2CF5B3EB0BCA54E49B", hash_generated_method = "3489745F61C2713DF245BDA6032D1D07")
    public String getDialogId(boolean isServer, String toTag) {
        String varB4EAC82CA7396A68D541C85D26508E83_1147717259 = null; //Variable for return #1
        CallID cid = (CallID) this.getCallId();
        From from = (From) this.getFrom();
        StringBuffer retval = new StringBuffer(cid.getCallId());
        {
            {
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_1383345957 = (from.getTag() != null);
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
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_197443308 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1147717259 = retval.toString().toLowerCase();
        addTaint(isServer);
        addTaint(toTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1147717259.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1147717259;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.597 -0400", hash_original_method = "20A80D2C7777E602FB41086859FCE7A8", hash_generated_method = "EA15FFCED7BD9E3BAD14FFE9E891CDAF")
    private final void setBranch( Via via, String method ) {
        String branch;
        {
            boolean var4D1E14298D0940533345FEB745E202E5_1391530564 = (method.equals( Request.ACK ));
            {
                {
                    boolean var5D4C73C769DA05A2485ED8FEE0F4734C_1129207140 = (statusLine.getStatusCode() >= 300);
                    {
                        branch = getTopmostVia().getBranch();
                    } //End block
                    {
                        branch = Utils.getInstance().generateBranchId();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var92A9CE588B1D28BBEAFD2D6E5E8923F5_1559570924 = (method.equals( Request.CANCEL ));
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
        addTaint(via.getTaint());
        addTaint(method.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.598 -0400", hash_original_method = "EE95455CDB90A9B95BEE72161BE1B5B8", hash_generated_method = "6092B39620C8A45DADFE787B56D6D73A")
    public String getFirstLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_1832600821 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1131770055 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1832600821 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1131770055 = this.statusLine.encode();
        String varA7E53CE21691AB073D9660D615818899_812842801; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_812842801 = varB4EAC82CA7396A68D541C85D26508E83_1832600821;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_812842801 = varB4EAC82CA7396A68D541C85D26508E83_1131770055;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_812842801.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_812842801;
        // ---------- Original Method ----------
        //if (this.statusLine == null)
            //return null;
        //else
            //return this.statusLine.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.598 -0400", hash_original_method = "7AF9DBED68BFE70E00218B8B8B8BF082", hash_generated_method = "9BFC1956E9C621D1BF195CBEC56C81FA")
    public void setSIPVersion(String sipVersion) {
        this.statusLine.setSipVersion(sipVersion);
        addTaint(sipVersion.getTaint());
        // ---------- Original Method ----------
        //this.statusLine.setSipVersion(sipVersion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.599 -0400", hash_original_method = "81E4A3A86ED8E9389A222C77FFC4E212", hash_generated_method = "9D0CCA2DA47FB78FECD66944E1DFE21D")
    public String getSIPVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_289751901 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_289751901 = this.statusLine.getSipVersion();
        varB4EAC82CA7396A68D541C85D26508E83_289751901.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_289751901;
        // ---------- Original Method ----------
        //return this.statusLine.getSipVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.600 -0400", hash_original_method = "11E3A7EA0BB166C76EF5663B1C05C1DB", hash_generated_method = "81C532CFC182166C4BAACE5CF839A1D5")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1248728001 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_534812275 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1248728001 = "";
        varB4EAC82CA7396A68D541C85D26508E83_534812275 = statusLine.encode() + super.encode();
        String varA7E53CE21691AB073D9660D615818899_1470667305; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1470667305 = varB4EAC82CA7396A68D541C85D26508E83_1248728001;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1470667305 = varB4EAC82CA7396A68D541C85D26508E83_534812275;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1470667305.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1470667305;
        // ---------- Original Method ----------
        //if (statusLine == null) return  "";
        //else return statusLine.encode() + super.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.602 -0400", hash_original_method = "B6A6DA92002B5EA057CE082C91930B65", hash_generated_method = "3B0E4A9B015CF07ACA65CC3E55F2095A")
    public SIPRequest createRequest(SipUri requestURI, Via via, CSeq cseq, From from, To to) {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_726386455 = null; //Variable for return #1
        SIPRequest newRequest = new SIPRequest();
        String method = cseq.getMethod();
        newRequest.setMethod(method);
        newRequest.setRequestURI(requestURI);
        this.setBranch( via, method );
        newRequest.setHeader(via);
        newRequest.setHeader(cseq);
        Iterator headerIterator = getHeaders();
        {
            boolean var1440086C7F6E137687239D414F8ECC74_388182004 = (headerIterator.hasNext());
            {
                SIPHeader nextHeader = (SIPHeader) headerIterator.next();
                {
                    boolean var75C54062C1C143943A1062913C71A6AD_22873382 = (SIPMessage.isResponseHeader(nextHeader)
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
            boolean var896FD3C9C4EED86170D10D69961A19CE_183022873 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_726386455 = newRequest;
        addTaint(requestURI.getTaint());
        addTaint(via.getTaint());
        addTaint(cseq.getTaint());
        addTaint(from.getTaint());
        addTaint(to.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_726386455.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_726386455;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

