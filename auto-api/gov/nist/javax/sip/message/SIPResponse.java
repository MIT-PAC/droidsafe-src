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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.208 -0400", hash_original_field = "8462E9D9B0BB0450DAF299F1B5423B07", hash_generated_field = "4214B75EEFCC2F5FE0C8E2F4EEF5B95F")

    protected StatusLine statusLine;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.222 -0400", hash_original_method = "65DF8DACE365B596A00FB19E5D885842", hash_generated_method = "AE416E6D4DED1C87AFAE2A281AEC29CD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.225 -0400", hash_original_method = "13FB64FAC5CAB193CAEE311D629E27B6", hash_generated_method = "488E9D18B5912AC5509D20E8DF5928BC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.226 -0400", hash_original_method = "A01A6E14359F44471B36FBE20B7B7D3C", hash_generated_method = "5462D5558FD7B9E0EB119A686DBEE1D6")
    public StatusLine getStatusLine() {
        StatusLine varB4EAC82CA7396A68D541C85D26508E83_1541394296 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1541394296 = statusLine;
        varB4EAC82CA7396A68D541C85D26508E83_1541394296.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1541394296;
        // ---------- Original Method ----------
        //return statusLine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.226 -0400", hash_original_method = "83A312D9FCEFB6DCEE53922D19363429", hash_generated_method = "9E85BBFA5E52A17FC11346A8CC972E63")
    public int getStatusCode() {
        int varD859CC97397DB96E8F5EB83FBBCBB1EC_547224827 = (statusLine.getStatusCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2107363105 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2107363105;
        // ---------- Original Method ----------
        //return statusLine.getStatusCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.242 -0400", hash_original_method = "1E99C1E53099DAE9563D2AD677513193", hash_generated_method = "DD36F23BFABCF8B0A47C7AC0CEC7703C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.243 -0400", hash_original_method = "116CF5266E081CFEF1340E67E2A6CB5B", hash_generated_method = "87E5EF99C09A7C6CB9E4B9D4DB09E317")
    public String getReasonPhrase() {
        String varB4EAC82CA7396A68D541C85D26508E83_1175579025 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_605347925 = null; //Variable for return #2
        {
            boolean varD79B996C15B8224204D233914DDF1C6A_1070063753 = (statusLine == null || statusLine.getReasonPhrase() == null);
            varB4EAC82CA7396A68D541C85D26508E83_1175579025 = "";
            varB4EAC82CA7396A68D541C85D26508E83_605347925 = statusLine.getReasonPhrase();
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_1448863327; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1448863327 = varB4EAC82CA7396A68D541C85D26508E83_1175579025;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1448863327 = varB4EAC82CA7396A68D541C85D26508E83_605347925;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1448863327.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1448863327;
        // ---------- Original Method ----------
        //if (statusLine == null || statusLine.getReasonPhrase() == null)
            //return "";
        //else
            //return statusLine.getReasonPhrase();
    }

    
        public static boolean isFinalResponse(int rc) {
        return rc >= 200 && rc < 700;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.244 -0400", hash_original_method = "298BCAB11064A058FB155FBEF5B04212", hash_generated_method = "5EC656278E1CB806F7B36891D7754969")
    public boolean isFinalResponse() {
        boolean var3591EB911E6267E97669918E320A7B29_2030472865 = (isFinalResponse(statusLine.getStatusCode()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1785911350 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1785911350;
        // ---------- Original Method ----------
        //return isFinalResponse(statusLine.getStatusCode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.245 -0400", hash_original_method = "7D2F1602DEBC36BCE0009AF9416F7471", hash_generated_method = "78471822E05FC292C5738D1D96B9B746")
    public void setStatusLine(StatusLine sl) {
        statusLine = sl;
        // ---------- Original Method ----------
        //statusLine = sl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.250 -0400", hash_original_method = "55B8B2C74AE8EFAFCF07CA3753E23BB0", hash_generated_method = "1A83F8C5710558ADEDDA2F1DDAB556E8")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_869228900 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_869228900 = stringRepresentation;
        varB4EAC82CA7396A68D541C85D26508E83_869228900.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_869228900;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.255 -0400", hash_original_method = "C990BF11F3A1B0CB0383B4A73773ED5B", hash_generated_method = "5ECA4BB75E90D44A79B4CEECD8949B7E")
    public void checkHeaders() throws ParseException {
        {
            boolean var6342A96FD7DE6C1AD71DF5E6F041816B_249441593 = (getCSeq() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(CSeq.NAME+ " Is missing ", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var028720CEB12D4FCC08D30523F58E270F_853122599 = (getTo() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(To.NAME+ " Is missing ", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var59B1519B8C7900F9210D51C7E88064B0_486446108 = (getFrom() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(From.NAME+ " Is missing ", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCE8B10FB91FF6C0A5E135CD4C2A83BAD_1237474758 = (getViaHeaders() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(Via.NAME+ " Is missing ", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBA60822AA10D06D1B72B8431F8364BB6_1494477835 = (getCallId() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(CallID.NAME + " Is missing ", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF2E7FF4AFF0DD92AB829FDA3E8D58905_134798795 = (getStatusCode() > 699);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.270 -0400", hash_original_method = "B07DBFC1814EC442DAADA17506313119", hash_generated_method = "EDAAF11DDD5B68E7C0F3DE2CF8FBF169")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1214689565 = null; //Variable for return #1
        String retval;
        retval = statusLine.encode() + super.encode();
        retval = super.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1214689565 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1214689565.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1214689565;
        // ---------- Original Method ----------
        //String retval;
        //if (statusLine != null)
            //retval = statusLine.encode() + super.encode();
        //else
            //retval = super.encode();
        //return retval ;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.281 -0400", hash_original_method = "BE972BED58D414983B801FA7B0B8948D", hash_generated_method = "6024549B378ADB1991D76269F172C240")
    public String encodeMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1245753787 = null; //Variable for return #1
        String retval;
        retval = statusLine.encode() + super.encodeSIPHeaders();
        retval = super.encodeSIPHeaders();
        varB4EAC82CA7396A68D541C85D26508E83_1245753787 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1245753787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1245753787;
        // ---------- Original Method ----------
        //String retval;
        //if (statusLine != null)
            //retval = statusLine.encode() + super.encodeSIPHeaders();
        //else
            //retval = super.encodeSIPHeaders();
        //return retval ;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.281 -0400", hash_original_method = "6F0C3DD571A294E8DFD4F72BBB3CCE7B", hash_generated_method = "8AE0F9CEE23AD1A1D76E73B29F95F7DE")
    public LinkedList getMessageAsEncodedStrings() {
        LinkedList varB4EAC82CA7396A68D541C85D26508E83_75978195 = null; //Variable for return #1
        LinkedList retval;
        retval = super.getMessageAsEncodedStrings();
        retval.addFirst(statusLine.encode());
        varB4EAC82CA7396A68D541C85D26508E83_75978195 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_75978195.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_75978195;
        // ---------- Original Method ----------
        //LinkedList retval = super.getMessageAsEncodedStrings();
        //if (statusLine != null)
            //retval.addFirst(statusLine.encode());
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.283 -0400", hash_original_method = "DB86120AE2172E8F10EBF4BE032C0B65", hash_generated_method = "62C47C72B21A237C43146AB9B8C87E50")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1942353214 = null; //Variable for return #1
        SIPResponse retval;
        retval = (SIPResponse) super.clone();
        retval.statusLine = (StatusLine) this.statusLine.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1942353214 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1942353214.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1942353214;
        // ---------- Original Method ----------
        //SIPResponse retval = (SIPResponse) super.clone();
        //if (this.statusLine != null)
            //retval.statusLine = (StatusLine) this.statusLine.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.283 -0400", hash_original_method = "8179D62366D10A1706B482955DEA9790", hash_generated_method = "6F243A521232E95871EB94FCC6CE50EB")
    public boolean equals(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_2077726450 = (!this.getClass().equals(other.getClass()));
        } //End collapsed parenthetic
        SIPResponse that;
        that = (SIPResponse) other;
        boolean var2E4D82D5A00FDE713CBA592D511F580B_1266987909 = (statusLine.equals(that.statusLine) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2016245889 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2016245889;
        // ---------- Original Method ----------
        //if (!this.getClass().equals(other.getClass()))
            //return false;
        //SIPResponse that = (SIPResponse) other;
        //return statusLine.equals(that.statusLine) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.299 -0400", hash_original_method = "E3EF862BAAD83B9956A8AA3297016E01", hash_generated_method = "DFB1DA287E79DBA721794600EAFB2BC7")
    public boolean match(Object matchObj) {
        {
            boolean varE5ABD91269B098FDB02552058FE738E0_1571718167 = (!matchObj.getClass().equals(this.getClass()));
            {
                boolean var3D06C934D988FBFEA9FF217EEB1CEB0C_423578524 = (matchObj == this);
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        SIPResponse that;
        that = (SIPResponse) matchObj;
        StatusLine rline;
        rline = that.statusLine;
        boolean var6F0A9113B429A383C35EED8AD8F98AAE_1249644760 = (super.match(matchObj));
        {
            boolean varA212D68AC1E4A9C32D9D4D8952220840_2068500682 = (statusLine.match(that.statusLine) && super.match(matchObj));
        } //End block
        addTaint(matchObj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1071018133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1071018133;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.300 -0400", hash_original_method = "8A95B6782662E6180E39BCA19FEC79A2", hash_generated_method = "BDE72F664A8121A6D42A7C6B9493C96E")
    public byte[] encodeAsBytes( String transport ) {
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
        addTaint(transport.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1212328638 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1212328638;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.302 -0400", hash_original_method = "9D2127AEC1E1548A62DA89BBBF00D215", hash_generated_method = "823DAEE4BE34B143DEDED89EDCB3A1EB")
    public String getDialogId(boolean isServer) {
        String varB4EAC82CA7396A68D541C85D26508E83_2125202125 = null; //Variable for return #1
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
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_1475201043 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var1BE29C19B15B07BF37F624C6B7042CDF_118664805 = (to.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(to.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var1BE29C19B15B07BF37F624C6B7042CDF_280348133 = (to.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(to.getTag());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_2010050058 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2125202125 = retval.toString().toLowerCase();
        addTaint(isServer);
        varB4EAC82CA7396A68D541C85D26508E83_2125202125.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2125202125;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.310 -0400", hash_original_method = "6DAE45694664AE2CF5B3EB0BCA54E49B", hash_generated_method = "002EFE1A1D3EB641D25BA744D2AD16D3")
    public String getDialogId(boolean isServer, String toTag) {
        String varB4EAC82CA7396A68D541C85D26508E83_1881948978 = null; //Variable for return #1
        CallID cid;
        cid = (CallID) this.getCallId();
        From from;
        from = (From) this.getFrom();
        StringBuffer retval;
        retval = new StringBuffer(cid.getCallId());
        {
            {
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_1953099146 = (from.getTag() != null);
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
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_269415860 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1881948978 = retval.toString().toLowerCase();
        addTaint(isServer);
        addTaint(toTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1881948978.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1881948978;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.311 -0400", hash_original_method = "20A80D2C7777E602FB41086859FCE7A8", hash_generated_method = "ACE596D4E3903A45A4A1064FF1B7155B")
    private final void setBranch( Via via, String method ) {
        String branch;
        {
            boolean var4D1E14298D0940533345FEB745E202E5_424475390 = (method.equals( Request.ACK ));
            {
                {
                    boolean var5D4C73C769DA05A2485ED8FEE0F4734C_439738149 = (statusLine.getStatusCode() >= 300);
                    {
                        branch = getTopmostVia().getBranch();
                    } //End block
                    {
                        branch = Utils.getInstance().generateBranchId();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var92A9CE588B1D28BBEAFD2D6E5E8923F5_882879696 = (method.equals( Request.CANCEL ));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.312 -0400", hash_original_method = "EE95455CDB90A9B95BEE72161BE1B5B8", hash_generated_method = "AC3CD53D8A7CCDD5AC799C207EEA6C16")
    public String getFirstLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_2097351128 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_89773107 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_2097351128 = null;
        varB4EAC82CA7396A68D541C85D26508E83_89773107 = this.statusLine.encode();
        String varA7E53CE21691AB073D9660D615818899_1130849749; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1130849749 = varB4EAC82CA7396A68D541C85D26508E83_2097351128;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1130849749 = varB4EAC82CA7396A68D541C85D26508E83_89773107;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1130849749.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1130849749;
        // ---------- Original Method ----------
        //if (this.statusLine == null)
            //return null;
        //else
            //return this.statusLine.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.312 -0400", hash_original_method = "7AF9DBED68BFE70E00218B8B8B8BF082", hash_generated_method = "9BFC1956E9C621D1BF195CBEC56C81FA")
    public void setSIPVersion(String sipVersion) {
        this.statusLine.setSipVersion(sipVersion);
        addTaint(sipVersion.getTaint());
        // ---------- Original Method ----------
        //this.statusLine.setSipVersion(sipVersion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.395 -0400", hash_original_method = "81E4A3A86ED8E9389A222C77FFC4E212", hash_generated_method = "9720711B04460727ABD77CA641E9C9D2")
    public String getSIPVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_1268594432 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1268594432 = this.statusLine.getSipVersion();
        varB4EAC82CA7396A68D541C85D26508E83_1268594432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1268594432;
        // ---------- Original Method ----------
        //return this.statusLine.getSipVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.396 -0400", hash_original_method = "11E3A7EA0BB166C76EF5663B1C05C1DB", hash_generated_method = "16DB7DB036EF3109483C911A19AB1D77")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1558275731 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_111996032 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1558275731 = "";
        varB4EAC82CA7396A68D541C85D26508E83_111996032 = statusLine.encode() + super.encode();
        String varA7E53CE21691AB073D9660D615818899_115041201; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_115041201 = varB4EAC82CA7396A68D541C85D26508E83_1558275731;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_115041201 = varB4EAC82CA7396A68D541C85D26508E83_111996032;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_115041201.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_115041201;
        // ---------- Original Method ----------
        //if (statusLine == null) return  "";
        //else return statusLine.encode() + super.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.404 -0400", hash_original_method = "B6A6DA92002B5EA057CE082C91930B65", hash_generated_method = "E21CA58624B90C684FAE9FC1C3C171E6")
    public SIPRequest createRequest(SipUri requestURI, Via via, CSeq cseq, From from, To to) {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_1258113600 = null; //Variable for return #1
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
            boolean var1440086C7F6E137687239D414F8ECC74_1027957489 = (headerIterator.hasNext());
            {
                SIPHeader nextHeader;
                nextHeader = (SIPHeader) headerIterator.next();
                {
                    boolean var75C54062C1C143943A1062913C71A6AD_2114526972 = (SIPMessage.isResponseHeader(nextHeader)
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
            boolean var896FD3C9C4EED86170D10D69961A19CE_2093004124 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1258113600 = newRequest;
        addTaint(requestURI.getTaint());
        addTaint(via.getTaint());
        addTaint(cseq.getTaint());
        addTaint(from.getTaint());
        addTaint(to.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1258113600.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1258113600;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

