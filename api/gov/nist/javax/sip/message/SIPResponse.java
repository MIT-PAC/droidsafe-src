package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.352 -0400", hash_original_field = "8462E9D9B0BB0450DAF299F1B5423B07", hash_generated_field = "4214B75EEFCC2F5FE0C8E2F4EEF5B95F")

    protected StatusLine statusLine;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.352 -0400", hash_original_method = "65DF8DACE365B596A00FB19E5D885842", hash_generated_method = "AE416E6D4DED1C87AFAE2A281AEC29CD")
    public  SIPResponse() {
        super();
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.354 -0400", hash_original_method = "13FB64FAC5CAB193CAEE311D629E27B6", hash_generated_method = "3C7965E9C90EE1CBECF98FEFEB506EA1")
    public void setStatusCode(int statusCode) throws ParseException {
        addTaint(statusCode);
    if(statusCode < 100 || statusCode > 699)        
        {
        ParseException var1031974175ACF305863DFA9CC458BFC0_941719707 = new ParseException("bad status code", 0);
        var1031974175ACF305863DFA9CC458BFC0_941719707.addTaint(taint);
        throw var1031974175ACF305863DFA9CC458BFC0_941719707;
        }
    if(this.statusLine == null)        
        this.statusLine = new StatusLine();
        this.statusLine.setStatusCode(statusCode);
        // ---------- Original Method ----------
        //if (statusCode < 100 || statusCode > 699)
            //throw new ParseException("bad status code", 0);
        //if (this.statusLine == null)
            //this.statusLine = new StatusLine();
        //this.statusLine.setStatusCode(statusCode);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.354 -0400", hash_original_method = "A01A6E14359F44471B36FBE20B7B7D3C", hash_generated_method = "1AD7325D2450116E25A8F211A25DAAE6")
    public StatusLine getStatusLine() {
StatusLine var85DBBD945A449462F4B20B9C5986C926_390799921 =         statusLine;
        var85DBBD945A449462F4B20B9C5986C926_390799921.addTaint(taint);
        return var85DBBD945A449462F4B20B9C5986C926_390799921;
        // ---------- Original Method ----------
        //return statusLine;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.354 -0400", hash_original_method = "83A312D9FCEFB6DCEE53922D19363429", hash_generated_method = "DF831D1A2B517AED395A16DD85E78381")
    public int getStatusCode() {
        int varCCB2EBBAEE29BB5ABC43D6B524E50D65_282883600 = (statusLine.getStatusCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_738274745 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_738274745;
        // ---------- Original Method ----------
        //return statusLine.getStatusCode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.355 -0400", hash_original_method = "1E99C1E53099DAE9563D2AD677513193", hash_generated_method = "C3C0E0DE4D56EE5FE4989C4CAD85B319")
    public void setReasonPhrase(String reasonPhrase) {
        addTaint(reasonPhrase.getTaint());
    if(reasonPhrase == null)        
        {
        IllegalArgumentException var0C3CFB63225103A579A39672BE2EAEB6_1221434093 = new IllegalArgumentException("Bad reason phrase");
        var0C3CFB63225103A579A39672BE2EAEB6_1221434093.addTaint(taint);
        throw var0C3CFB63225103A579A39672BE2EAEB6_1221434093;
        }
    if(this.statusLine == null)        
        this.statusLine = new StatusLine();
        this.statusLine.setReasonPhrase(reasonPhrase);
        // ---------- Original Method ----------
        //if (reasonPhrase == null)
            //throw new IllegalArgumentException("Bad reason phrase");
        //if (this.statusLine == null)
            //this.statusLine = new StatusLine();
        //this.statusLine.setReasonPhrase(reasonPhrase);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.355 -0400", hash_original_method = "116CF5266E081CFEF1340E67E2A6CB5B", hash_generated_method = "07AFAD7859E5DB488E8F9FC733857BF4")
    public String getReasonPhrase() {
    if(statusLine == null || statusLine.getReasonPhrase() == null)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_2094289583 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_2094289583.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_2094289583;
        }
        else
        {
String var9CCE10BE4440A073ACA6FCD8DA3FCEA0_1704405646 =         statusLine.getReasonPhrase();
        var9CCE10BE4440A073ACA6FCD8DA3FCEA0_1704405646.addTaint(taint);
        return var9CCE10BE4440A073ACA6FCD8DA3FCEA0_1704405646;
        }
        // ---------- Original Method ----------
        //if (statusLine == null || statusLine.getReasonPhrase() == null)
            //return "";
        //else
            //return statusLine.getReasonPhrase();
    }

    
        @DSModeled(DSC.SAFE)
    public static boolean isFinalResponse(int rc) {
        return rc >= 200 && rc < 700;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.355 -0400", hash_original_method = "298BCAB11064A058FB155FBEF5B04212", hash_generated_method = "5033870707F9F2AE33AF85282161940E")
    public boolean isFinalResponse() {
        boolean varC0F98A992F9657586CD63877488F6C3C_573641614 = (isFinalResponse(statusLine.getStatusCode()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_652511080 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_652511080;
        // ---------- Original Method ----------
        //return isFinalResponse(statusLine.getStatusCode());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.356 -0400", hash_original_method = "7D2F1602DEBC36BCE0009AF9416F7471", hash_generated_method = "78471822E05FC292C5738D1D96B9B746")
    public void setStatusLine(StatusLine sl) {
        statusLine = sl;
        // ---------- Original Method ----------
        //statusLine = sl;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.356 -0400", hash_original_method = "55B8B2C74AE8EFAFCF07CA3753E23BB0", hash_generated_method = "9D0A2C192E5401D25894E25E40C87738")
    public String debugDump() {
        String superstring = super.debugDump();
        stringRepresentation = "";
        sprint(SIPResponse.class.getCanonicalName());
        sprint("{");
    if(statusLine != null)        
        {
            sprint(statusLine.debugDump());
        } //End block
        sprint(superstring);
        sprint("}");
String var8D11C2D110975896438D6F91C60E6D6F_581916837 =         stringRepresentation;
        var8D11C2D110975896438D6F91C60E6D6F_581916837.addTaint(taint);
        return var8D11C2D110975896438D6F91C60E6D6F_581916837;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.357 -0400", hash_original_method = "C990BF11F3A1B0CB0383B4A73773ED5B", hash_generated_method = "1E56E04F683F64A188E01A49F3575F59")
    public void checkHeaders() throws ParseException {
    if(getCSeq() == null)        
        {
            ParseException varE347EB4AC459CB6EEED9B01064BCEA9F_771406442 = new ParseException(CSeq.NAME+ " Is missing ", 0);
            varE347EB4AC459CB6EEED9B01064BCEA9F_771406442.addTaint(taint);
            throw varE347EB4AC459CB6EEED9B01064BCEA9F_771406442;
        } //End block
    if(getTo() == null)        
        {
            ParseException varD9A29FF7881C6AB66C26714A3C0BF4D2_454349054 = new ParseException(To.NAME+ " Is missing ", 0);
            varD9A29FF7881C6AB66C26714A3C0BF4D2_454349054.addTaint(taint);
            throw varD9A29FF7881C6AB66C26714A3C0BF4D2_454349054;
        } //End block
    if(getFrom() == null)        
        {
            ParseException varC1D56BEC372E16830C40D9F52206E488_570282265 = new ParseException(From.NAME+ " Is missing ", 0);
            varC1D56BEC372E16830C40D9F52206E488_570282265.addTaint(taint);
            throw varC1D56BEC372E16830C40D9F52206E488_570282265;
        } //End block
    if(getViaHeaders() == null)        
        {
            ParseException varACFF2F4EB07F264EF3B8691B569E5E7E_101222207 = new ParseException(Via.NAME+ " Is missing ", 0);
            varACFF2F4EB07F264EF3B8691B569E5E7E_101222207.addTaint(taint);
            throw varACFF2F4EB07F264EF3B8691B569E5E7E_101222207;
        } //End block
    if(getCallId() == null)        
        {
            ParseException varB04D10C7406469EC1F1ACF85F4970329_1064372044 = new ParseException(CallID.NAME + " Is missing ", 0);
            varB04D10C7406469EC1F1ACF85F4970329_1064372044.addTaint(taint);
            throw varB04D10C7406469EC1F1ACF85F4970329_1064372044;
        } //End block
    if(getStatusCode() > 699)        
        {
            ParseException varE02E84223124D15FD37F77B3834651C7_1864067925 = new ParseException("Unknown error code!" + getStatusCode(), 0);
            varE02E84223124D15FD37F77B3834651C7_1864067925.addTaint(taint);
            throw varE02E84223124D15FD37F77B3834651C7_1864067925;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.357 -0400", hash_original_method = "B07DBFC1814EC442DAADA17506313119", hash_generated_method = "EC9639703DA994555B11D18CCEF12F08")
    public String encode() {
        String retval;
    if(statusLine != null)        
        retval = statusLine.encode() + super.encode();
        else
        retval = super.encode();
String varF9E19AD6135C970F387F77C6F3DE4477_1714003295 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1714003295.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1714003295;
        // ---------- Original Method ----------
        //String retval;
        //if (statusLine != null)
            //retval = statusLine.encode() + super.encode();
        //else
            //retval = super.encode();
        //return retval ;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.358 -0400", hash_original_method = "BE972BED58D414983B801FA7B0B8948D", hash_generated_method = "6564A5F0B03C73D73BC4EFB3FCBF018C")
    public String encodeMessage() {
        String retval;
    if(statusLine != null)        
        retval = statusLine.encode() + super.encodeSIPHeaders();
        else
        retval = super.encodeSIPHeaders();
String varF9E19AD6135C970F387F77C6F3DE4477_301691035 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_301691035.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_301691035;
        // ---------- Original Method ----------
        //String retval;
        //if (statusLine != null)
            //retval = statusLine.encode() + super.encodeSIPHeaders();
        //else
            //retval = super.encodeSIPHeaders();
        //return retval ;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.358 -0400", hash_original_method = "6F0C3DD571A294E8DFD4F72BBB3CCE7B", hash_generated_method = "6175C37559193F380BDF365142B7B618")
    public LinkedList getMessageAsEncodedStrings() {
        LinkedList retval = super.getMessageAsEncodedStrings();
    if(statusLine != null)        
        retval.addFirst(statusLine.encode());
LinkedList varF9E19AD6135C970F387F77C6F3DE4477_1890259603 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1890259603.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1890259603;
        // ---------- Original Method ----------
        //LinkedList retval = super.getMessageAsEncodedStrings();
        //if (statusLine != null)
            //retval.addFirst(statusLine.encode());
        //return retval;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.359 -0400", hash_original_method = "DB86120AE2172E8F10EBF4BE032C0B65", hash_generated_method = "33F164E776EC6FE27D690456579AF950")
    public Object clone() {
        SIPResponse retval = (SIPResponse) super.clone();
    if(this.statusLine != null)        
        retval.statusLine = (StatusLine) this.statusLine.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_2146043815 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_2146043815.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_2146043815;
        // ---------- Original Method ----------
        //SIPResponse retval = (SIPResponse) super.clone();
        //if (this.statusLine != null)
            //retval.statusLine = (StatusLine) this.statusLine.clone();
        //return retval;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.359 -0400", hash_original_method = "8179D62366D10A1706B482955DEA9790", hash_generated_method = "EF7201B712FE65A154218D120713A6CB")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(!this.getClass().equals(other.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_996700020 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2145377555 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2145377555;
        }
        SIPResponse that = (SIPResponse) other;
        boolean var656BF73EE18AAA44305218DDD7953BA0_1029472404 = (statusLine.equals(that.statusLine) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1257859884 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1257859884;
        // ---------- Original Method ----------
        //if (!this.getClass().equals(other.getClass()))
            //return false;
        //SIPResponse that = (SIPResponse) other;
        //return statusLine.equals(that.statusLine) && super.equals(other);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.359 -0400", hash_original_method = "E3EF862BAAD83B9956A8AA3297016E01", hash_generated_method = "05998A68A9006B3DCDE2ADAA5CCB0607")
    public boolean match(Object matchObj) {
        addTaint(matchObj.getTaint());
    if(matchObj == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_78619208 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_916074816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_916074816;
        }
        else
    if(!matchObj.getClass().equals(this.getClass()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1338755310 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_651429745 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_651429745;
        } //End block
        else
    if(matchObj == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1172678084 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_596389095 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_596389095;
        }
        SIPResponse that = (SIPResponse) matchObj;
        StatusLine rline = that.statusLine;
    if(this.statusLine == null && rline != null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_2087750187 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_379005979 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_379005979;
        }
        else
    if(this.statusLine == rline)        
        {
        boolean var5F1371FD9204D55EBC900E55D1EA60BF_2032184665 = (super.match(matchObj));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1385256339 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1385256339;
        }
        else
        {
            boolean varA628C5365F162668E09099D97767EC1E_1231614278 = (statusLine.match(that.statusLine) && super.match(matchObj));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_437976435 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_437976435;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.360 -0400", hash_original_method = "8A95B6782662E6180E39BCA19FEC79A2", hash_generated_method = "6FC61505824B46CD470A658BDE1F37F6")
    public byte[] encodeAsBytes( String transport ) {
        addTaint(transport.getTaint());
        byte[] slbytes = null;
    if(statusLine != null)        
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
        byte[] var020B759ADEF679A47CB9AFE965BB2314_611738974 = (retval);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_154967670 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_154967670;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.361 -0400", hash_original_method = "9D2127AEC1E1548A62DA89BBBF00D215", hash_generated_method = "4DEE4E608366B463FA517BCBF43136DB")
    public String getDialogId(boolean isServer) {
        addTaint(isServer);
        CallID cid = (CallID) this.getCallId();
        From from = (From) this.getFrom();
        To to = (To) this.getTo();
        StringBuffer retval = new StringBuffer(cid.getCallId());
    if(!isServer)        
        {
    if(from.getTag() != null)            
            {
                retval.append(COLON);
                retval.append(from.getTag());
            } //End block
    if(to.getTag() != null)            
            {
                retval.append(COLON);
                retval.append(to.getTag());
            } //End block
        } //End block
        else
        {
    if(to.getTag() != null)            
            {
                retval.append(COLON);
                retval.append(to.getTag());
            } //End block
    if(from.getTag() != null)            
            {
                retval.append(COLON);
                retval.append(from.getTag());
            } //End block
        } //End block
String var00A359C12D3BB90F4D7EAC5F002493EE_577844017 =         retval.toString().toLowerCase();
        var00A359C12D3BB90F4D7EAC5F002493EE_577844017.addTaint(taint);
        return var00A359C12D3BB90F4D7EAC5F002493EE_577844017;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.362 -0400", hash_original_method = "6DAE45694664AE2CF5B3EB0BCA54E49B", hash_generated_method = "30D6540AFB34C7E26BC43291B0983300")
    public String getDialogId(boolean isServer, String toTag) {
        addTaint(toTag.getTaint());
        addTaint(isServer);
        CallID cid = (CallID) this.getCallId();
        From from = (From) this.getFrom();
        StringBuffer retval = new StringBuffer(cid.getCallId());
    if(!isServer)        
        {
    if(from.getTag() != null)            
            {
                retval.append(COLON);
                retval.append(from.getTag());
            } //End block
    if(toTag != null)            
            {
                retval.append(COLON);
                retval.append(toTag);
            } //End block
        } //End block
        else
        {
    if(toTag != null)            
            {
                retval.append(COLON);
                retval.append(toTag);
            } //End block
    if(from.getTag() != null)            
            {
                retval.append(COLON);
                retval.append(from.getTag());
            } //End block
        } //End block
String var00A359C12D3BB90F4D7EAC5F002493EE_1553109545 =         retval.toString().toLowerCase();
        var00A359C12D3BB90F4D7EAC5F002493EE_1553109545.addTaint(taint);
        return var00A359C12D3BB90F4D7EAC5F002493EE_1553109545;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.363 -0400", hash_original_method = "20A80D2C7777E602FB41086859FCE7A8", hash_generated_method = "28919BF5ADE6028FFE59E682C0032210")
    private final void setBranch( Via via, String method ) {
        addTaint(method.getTaint());
        addTaint(via.getTaint());
        String branch;
    if(method.equals( Request.ACK ))        
        {
    if(statusLine.getStatusCode() >= 300)            
            {
                branch = getTopmostVia().getBranch();
            } //End block
            else
            {
                branch = Utils.getInstance().generateBranchId();
            } //End block
        } //End block
        else
    if(method.equals( Request.CANCEL ))        
        {
            branch = getTopmostVia().getBranch();
        } //End block
        else
        return;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.363 -0400", hash_original_method = "EE95455CDB90A9B95BEE72161BE1B5B8", hash_generated_method = "7860018232BE076F0D9575735E6343F1")
    public String getFirstLine() {
    if(this.statusLine == null)        
        {
String var540C13E9E156B687226421B24F2DF178_162519789 =         null;
        var540C13E9E156B687226421B24F2DF178_162519789.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_162519789;
        }
        else
        {
String varEE87E1E7EB945625D2B267C02FB78DE1_1584160451 =         this.statusLine.encode();
        varEE87E1E7EB945625D2B267C02FB78DE1_1584160451.addTaint(taint);
        return varEE87E1E7EB945625D2B267C02FB78DE1_1584160451;
        }
        // ---------- Original Method ----------
        //if (this.statusLine == null)
            //return null;
        //else
            //return this.statusLine.encode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.364 -0400", hash_original_method = "7AF9DBED68BFE70E00218B8B8B8BF082", hash_generated_method = "94D3BE220E69D98C37CF410130B3FBCA")
    public void setSIPVersion(String sipVersion) {
        addTaint(sipVersion.getTaint());
        this.statusLine.setSipVersion(sipVersion);
        // ---------- Original Method ----------
        //this.statusLine.setSipVersion(sipVersion);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.364 -0400", hash_original_method = "81E4A3A86ED8E9389A222C77FFC4E212", hash_generated_method = "5C79DC2AC6B4BFC147AE2F3796BB33F6")
    public String getSIPVersion() {
String varC295307604D5BC9055D49A9C609E8BB3_286912944 =         this.statusLine.getSipVersion();
        varC295307604D5BC9055D49A9C609E8BB3_286912944.addTaint(taint);
        return varC295307604D5BC9055D49A9C609E8BB3_286912944;
        // ---------- Original Method ----------
        //return this.statusLine.getSipVersion();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.364 -0400", hash_original_method = "11E3A7EA0BB166C76EF5663B1C05C1DB", hash_generated_method = "32750E1FEDE85F9C91BE3A2601D07E5A")
    public String toString() {
    if(statusLine == null)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1330465015 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1330465015.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1330465015;
        }
        else
        {
String var822854B97D2102A3952AE5BBC00EB7E3_577362215 =         statusLine.encode() + super.encode();
        var822854B97D2102A3952AE5BBC00EB7E3_577362215.addTaint(taint);
        return var822854B97D2102A3952AE5BBC00EB7E3_577362215;
        }
        // ---------- Original Method ----------
        //if (statusLine == null) return  "";
        //else return statusLine.encode() + super.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.365 -0400", hash_original_method = "B6A6DA92002B5EA057CE082C91930B65", hash_generated_method = "6EF983E19C803A8DECCB0CD33E2D19F8")
    public SIPRequest createRequest(SipUri requestURI, Via via, CSeq cseq, From from, To to) {
        addTaint(to.getTaint());
        addTaint(from.getTaint());
        addTaint(cseq.getTaint());
        addTaint(via.getTaint());
        addTaint(requestURI.getTaint());
        SIPRequest newRequest = new SIPRequest();
        String method = cseq.getMethod();
        newRequest.setMethod(method);
        newRequest.setRequestURI(requestURI);
        this.setBranch( via, method );
        newRequest.setHeader(via);
        newRequest.setHeader(cseq);
        Iterator headerIterator = getHeaders();
        while
(headerIterator.hasNext())        
        {
            SIPHeader nextHeader = (SIPHeader) headerIterator.next();
    if(SIPMessage.isResponseHeader(nextHeader)
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
                || nextHeader instanceof ReasonList)            
            {
                continue;
            } //End block
    if(nextHeader instanceof To)            
            nextHeader = (SIPHeader) to;
            else
    if(nextHeader instanceof From)            
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
        try 
        {
            newRequest.attachHeader( new MaxForwards(70), false);
        } //End block
        catch (Exception d)
        {
        } //End block
    if(MessageFactoryImpl.getDefaultUserAgentHeader() != null)        
        {
            newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
        } //End block
SIPRequest var843B90BB67BB5454D25E3643EF8010AB_133417729 =         newRequest;
        var843B90BB67BB5454D25E3643EF8010AB_133417729.addTaint(taint);
        return var843B90BB67BB5454D25E3643EF8010AB_133417729;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

