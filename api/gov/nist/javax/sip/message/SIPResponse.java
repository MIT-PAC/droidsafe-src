package gov.nist.javax.sip.message;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class SIPResponse extends SIPMessage implements javax.sip.message.Response, ResponseExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.500 -0400", hash_original_field = "8462E9D9B0BB0450DAF299F1B5423B07", hash_generated_field = "4214B75EEFCC2F5FE0C8E2F4EEF5B95F")

    protected StatusLine statusLine;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.500 -0400", hash_original_method = "65DF8DACE365B596A00FB19E5D885842", hash_generated_method = "AE416E6D4DED1C87AFAE2A281AEC29CD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.501 -0400", hash_original_method = "13FB64FAC5CAB193CAEE311D629E27B6", hash_generated_method = "B6D19FA1CB1F8706B5DC6F994BBCC512")
    public void setStatusCode(int statusCode) throws ParseException {
        addTaint(statusCode);
        if(statusCode < 100 || statusCode > 699)        
        {
        ParseException var1031974175ACF305863DFA9CC458BFC0_1916926161 = new ParseException("bad status code", 0);
        var1031974175ACF305863DFA9CC458BFC0_1916926161.addTaint(taint);
        throw var1031974175ACF305863DFA9CC458BFC0_1916926161;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.502 -0400", hash_original_method = "A01A6E14359F44471B36FBE20B7B7D3C", hash_generated_method = "AE828BB8EBB1CF5744C5966E6AADC3A0")
    public StatusLine getStatusLine() {
StatusLine var85DBBD945A449462F4B20B9C5986C926_395851477 =         statusLine;
        var85DBBD945A449462F4B20B9C5986C926_395851477.addTaint(taint);
        return var85DBBD945A449462F4B20B9C5986C926_395851477;
        // ---------- Original Method ----------
        //return statusLine;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.502 -0400", hash_original_method = "83A312D9FCEFB6DCEE53922D19363429", hash_generated_method = "C4FB00E4F6E3ED54FD9DEE8680C9D824")
    public int getStatusCode() {
        int varCCB2EBBAEE29BB5ABC43D6B524E50D65_460137643 = (statusLine.getStatusCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1065608128 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1065608128;
        // ---------- Original Method ----------
        //return statusLine.getStatusCode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.502 -0400", hash_original_method = "1E99C1E53099DAE9563D2AD677513193", hash_generated_method = "5732CB581CCA01B076ECBFFEC763F25B")
    public void setReasonPhrase(String reasonPhrase) {
        addTaint(reasonPhrase.getTaint());
        if(reasonPhrase == null)        
        {
        IllegalArgumentException var0C3CFB63225103A579A39672BE2EAEB6_56729113 = new IllegalArgumentException("Bad reason phrase");
        var0C3CFB63225103A579A39672BE2EAEB6_56729113.addTaint(taint);
        throw var0C3CFB63225103A579A39672BE2EAEB6_56729113;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.502 -0400", hash_original_method = "116CF5266E081CFEF1340E67E2A6CB5B", hash_generated_method = "AB2321A80F89F204AB7A51DC58DF9003")
    public String getReasonPhrase() {
        if(statusLine == null || statusLine.getReasonPhrase() == null)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1319789936 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1319789936.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1319789936;
        }
        else
        {
String var9CCE10BE4440A073ACA6FCD8DA3FCEA0_487770711 =         statusLine.getReasonPhrase();
        var9CCE10BE4440A073ACA6FCD8DA3FCEA0_487770711.addTaint(taint);
        return var9CCE10BE4440A073ACA6FCD8DA3FCEA0_487770711;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.503 -0400", hash_original_method = "298BCAB11064A058FB155FBEF5B04212", hash_generated_method = "FF7D515C00913B91D91F5E77CE926916")
    public boolean isFinalResponse() {
        boolean varC0F98A992F9657586CD63877488F6C3C_1788783887 = (isFinalResponse(statusLine.getStatusCode()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1359876665 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1359876665;
        // ---------- Original Method ----------
        //return isFinalResponse(statusLine.getStatusCode());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.503 -0400", hash_original_method = "7D2F1602DEBC36BCE0009AF9416F7471", hash_generated_method = "78471822E05FC292C5738D1D96B9B746")
    public void setStatusLine(StatusLine sl) {
        statusLine = sl;
        // ---------- Original Method ----------
        //statusLine = sl;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.504 -0400", hash_original_method = "55B8B2C74AE8EFAFCF07CA3753E23BB0", hash_generated_method = "9BA29BA0011CD63C5665DDE399E7F0C8")
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
String var8D11C2D110975896438D6F91C60E6D6F_460471573 =         stringRepresentation;
        var8D11C2D110975896438D6F91C60E6D6F_460471573.addTaint(taint);
        return var8D11C2D110975896438D6F91C60E6D6F_460471573;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.504 -0400", hash_original_method = "C990BF11F3A1B0CB0383B4A73773ED5B", hash_generated_method = "F4DF56D089073DE4278A703B2A0B165C")
    public void checkHeaders() throws ParseException {
        if(getCSeq() == null)        
        {
            ParseException varE347EB4AC459CB6EEED9B01064BCEA9F_9892780 = new ParseException(CSeq.NAME+ " Is missing ", 0);
            varE347EB4AC459CB6EEED9B01064BCEA9F_9892780.addTaint(taint);
            throw varE347EB4AC459CB6EEED9B01064BCEA9F_9892780;
        } //End block
        if(getTo() == null)        
        {
            ParseException varD9A29FF7881C6AB66C26714A3C0BF4D2_419946996 = new ParseException(To.NAME+ " Is missing ", 0);
            varD9A29FF7881C6AB66C26714A3C0BF4D2_419946996.addTaint(taint);
            throw varD9A29FF7881C6AB66C26714A3C0BF4D2_419946996;
        } //End block
        if(getFrom() == null)        
        {
            ParseException varC1D56BEC372E16830C40D9F52206E488_2057956904 = new ParseException(From.NAME+ " Is missing ", 0);
            varC1D56BEC372E16830C40D9F52206E488_2057956904.addTaint(taint);
            throw varC1D56BEC372E16830C40D9F52206E488_2057956904;
        } //End block
        if(getViaHeaders() == null)        
        {
            ParseException varACFF2F4EB07F264EF3B8691B569E5E7E_297929543 = new ParseException(Via.NAME+ " Is missing ", 0);
            varACFF2F4EB07F264EF3B8691B569E5E7E_297929543.addTaint(taint);
            throw varACFF2F4EB07F264EF3B8691B569E5E7E_297929543;
        } //End block
        if(getCallId() == null)        
        {
            ParseException varB04D10C7406469EC1F1ACF85F4970329_174984183 = new ParseException(CallID.NAME + " Is missing ", 0);
            varB04D10C7406469EC1F1ACF85F4970329_174984183.addTaint(taint);
            throw varB04D10C7406469EC1F1ACF85F4970329_174984183;
        } //End block
        if(getStatusCode() > 699)        
        {
            ParseException varE02E84223124D15FD37F77B3834651C7_1338315300 = new ParseException("Unknown error code!" + getStatusCode(), 0);
            varE02E84223124D15FD37F77B3834651C7_1338315300.addTaint(taint);
            throw varE02E84223124D15FD37F77B3834651C7_1338315300;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.505 -0400", hash_original_method = "B07DBFC1814EC442DAADA17506313119", hash_generated_method = "D920381F6A0FB11A3ABDE30B64663426")
    public String encode() {
        String retval;
        if(statusLine != null)        
        retval = statusLine.encode() + super.encode();
        else
        retval = super.encode();
String varF9E19AD6135C970F387F77C6F3DE4477_944173897 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_944173897.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_944173897;
        // ---------- Original Method ----------
        //String retval;
        //if (statusLine != null)
            //retval = statusLine.encode() + super.encode();
        //else
            //retval = super.encode();
        //return retval ;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.505 -0400", hash_original_method = "BE972BED58D414983B801FA7B0B8948D", hash_generated_method = "D05E4F22D12EDA16D746B6A4684D9524")
    public String encodeMessage() {
        String retval;
        if(statusLine != null)        
        retval = statusLine.encode() + super.encodeSIPHeaders();
        else
        retval = super.encodeSIPHeaders();
String varF9E19AD6135C970F387F77C6F3DE4477_800453910 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_800453910.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_800453910;
        // ---------- Original Method ----------
        //String retval;
        //if (statusLine != null)
            //retval = statusLine.encode() + super.encodeSIPHeaders();
        //else
            //retval = super.encodeSIPHeaders();
        //return retval ;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.505 -0400", hash_original_method = "6F0C3DD571A294E8DFD4F72BBB3CCE7B", hash_generated_method = "2064865E58BFBF2118AA42BA941ED074")
    public LinkedList getMessageAsEncodedStrings() {
        LinkedList retval = super.getMessageAsEncodedStrings();
        if(statusLine != null)        
        retval.addFirst(statusLine.encode());
LinkedList varF9E19AD6135C970F387F77C6F3DE4477_588254566 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_588254566.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_588254566;
        // ---------- Original Method ----------
        //LinkedList retval = super.getMessageAsEncodedStrings();
        //if (statusLine != null)
            //retval.addFirst(statusLine.encode());
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.506 -0400", hash_original_method = "DB86120AE2172E8F10EBF4BE032C0B65", hash_generated_method = "E02E0B936D0768FAB6B01C84D684F816")
    public Object clone() {
        SIPResponse retval = (SIPResponse) super.clone();
        if(this.statusLine != null)        
        retval.statusLine = (StatusLine) this.statusLine.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_902569414 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_902569414.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_902569414;
        // ---------- Original Method ----------
        //SIPResponse retval = (SIPResponse) super.clone();
        //if (this.statusLine != null)
            //retval.statusLine = (StatusLine) this.statusLine.clone();
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.506 -0400", hash_original_method = "8179D62366D10A1706B482955DEA9790", hash_generated_method = "4A4BCF96ACF032EB9C0EC2156DD88BB6")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(!this.getClass().equals(other.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_462657036 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1245939928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1245939928;
        }
        SIPResponse that = (SIPResponse) other;
        boolean var656BF73EE18AAA44305218DDD7953BA0_1032109033 = (statusLine.equals(that.statusLine) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1390439114 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1390439114;
        // ---------- Original Method ----------
        //if (!this.getClass().equals(other.getClass()))
            //return false;
        //SIPResponse that = (SIPResponse) other;
        //return statusLine.equals(that.statusLine) && super.equals(other);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.507 -0400", hash_original_method = "E3EF862BAAD83B9956A8AA3297016E01", hash_generated_method = "0CE274104D507BCA38E83D95001B3F05")
    public boolean match(Object matchObj) {
        addTaint(matchObj.getTaint());
        if(matchObj == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_2024163127 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1033908486 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1033908486;
        }
        else
        if(!matchObj.getClass().equals(this.getClass()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1131165225 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2003872928 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2003872928;
        } //End block
        else
        if(matchObj == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_962540629 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_401552393 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_401552393;
        }
        SIPResponse that = (SIPResponse) matchObj;
        StatusLine rline = that.statusLine;
        if(this.statusLine == null && rline != null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1879074398 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2079065456 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2079065456;
        }
        else
        if(this.statusLine == rline)        
        {
        boolean var5F1371FD9204D55EBC900E55D1EA60BF_62936819 = (super.match(matchObj));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_261759967 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_261759967;
        }
        else
        {
            boolean varA628C5365F162668E09099D97767EC1E_1541840387 = (statusLine.match(that.statusLine) && super.match(matchObj));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_339657504 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_339657504;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.508 -0400", hash_original_method = "8A95B6782662E6180E39BCA19FEC79A2", hash_generated_method = "BE68FE02322FCD1FA08F90BDDDA60334")
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
        byte[] var020B759ADEF679A47CB9AFE965BB2314_1397803188 = (retval);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_391088629 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_391088629;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.509 -0400", hash_original_method = "9D2127AEC1E1548A62DA89BBBF00D215", hash_generated_method = "60911DBD4CA06DD0EBD8787F55C65729")
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
String var00A359C12D3BB90F4D7EAC5F002493EE_1803399901 =         retval.toString().toLowerCase();
        var00A359C12D3BB90F4D7EAC5F002493EE_1803399901.addTaint(taint);
        return var00A359C12D3BB90F4D7EAC5F002493EE_1803399901;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.509 -0400", hash_original_method = "6DAE45694664AE2CF5B3EB0BCA54E49B", hash_generated_method = "B15E6017B482E65B38D730BF69FF733A")
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
String var00A359C12D3BB90F4D7EAC5F002493EE_1249660882 =         retval.toString().toLowerCase();
        var00A359C12D3BB90F4D7EAC5F002493EE_1249660882.addTaint(taint);
        return var00A359C12D3BB90F4D7EAC5F002493EE_1249660882;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.509 -0400", hash_original_method = "20A80D2C7777E602FB41086859FCE7A8", hash_generated_method = "28919BF5ADE6028FFE59E682C0032210")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.510 -0400", hash_original_method = "EE95455CDB90A9B95BEE72161BE1B5B8", hash_generated_method = "3A4AACC1281F976D26F7E44169D9D386")
    public String getFirstLine() {
        if(this.statusLine == null)        
        {
String var540C13E9E156B687226421B24F2DF178_826522416 =         null;
        var540C13E9E156B687226421B24F2DF178_826522416.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_826522416;
        }
        else
        {
String varEE87E1E7EB945625D2B267C02FB78DE1_723779911 =         this.statusLine.encode();
        varEE87E1E7EB945625D2B267C02FB78DE1_723779911.addTaint(taint);
        return varEE87E1E7EB945625D2B267C02FB78DE1_723779911;
        }
        // ---------- Original Method ----------
        //if (this.statusLine == null)
            //return null;
        //else
            //return this.statusLine.encode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.510 -0400", hash_original_method = "7AF9DBED68BFE70E00218B8B8B8BF082", hash_generated_method = "94D3BE220E69D98C37CF410130B3FBCA")
    public void setSIPVersion(String sipVersion) {
        addTaint(sipVersion.getTaint());
        this.statusLine.setSipVersion(sipVersion);
        // ---------- Original Method ----------
        //this.statusLine.setSipVersion(sipVersion);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.510 -0400", hash_original_method = "81E4A3A86ED8E9389A222C77FFC4E212", hash_generated_method = "595169D3022BA9B5699F14A014559300")
    public String getSIPVersion() {
String varC295307604D5BC9055D49A9C609E8BB3_773676310 =         this.statusLine.getSipVersion();
        varC295307604D5BC9055D49A9C609E8BB3_773676310.addTaint(taint);
        return varC295307604D5BC9055D49A9C609E8BB3_773676310;
        // ---------- Original Method ----------
        //return this.statusLine.getSipVersion();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.510 -0400", hash_original_method = "11E3A7EA0BB166C76EF5663B1C05C1DB", hash_generated_method = "9F20B66E3B7C7AE3ECB8318FCF5460C6")
    public String toString() {
        if(statusLine == null)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_596580385 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_596580385.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_596580385;
        }
        else
        {
String var822854B97D2102A3952AE5BBC00EB7E3_199504374 =         statusLine.encode() + super.encode();
        var822854B97D2102A3952AE5BBC00EB7E3_199504374.addTaint(taint);
        return var822854B97D2102A3952AE5BBC00EB7E3_199504374;
        }
        // ---------- Original Method ----------
        //if (statusLine == null) return  "";
        //else return statusLine.encode() + super.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.511 -0400", hash_original_method = "B6A6DA92002B5EA057CE082C91930B65", hash_generated_method = "9BABC257376D4E73D41648422AA9305D")
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
SIPRequest var843B90BB67BB5454D25E3643EF8010AB_50829093 =         newRequest;
        var843B90BB67BB5454D25E3643EF8010AB_50829093.addTaint(taint);
        return var843B90BB67BB5454D25E3643EF8010AB_50829093;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

