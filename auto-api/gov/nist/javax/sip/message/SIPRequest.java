package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.address.*;
import gov.nist.core.*;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import javax.sip.address.URI;
import javax.sip.message.*;
import java.text.ParseException;
import javax.sip.*;
import javax.sip.header.*;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.stack.SIPTransactionStack;

public final class SIPRequest extends SIPMessage implements javax.sip.message.Request, RequestExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.446 -0400", hash_original_field = "12492E2615AAEE902567F83B53B51169", hash_generated_field = "35845A8B5E63218306C5DA0C937C70A8")

    private transient Object transactionPointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.446 -0400", hash_original_field = "776431FA890572AB0ADBBE09FE6DD67A", hash_generated_field = "583EB683C8DCDB7E0E7B7B105FE10943")

    private RequestLine requestLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.446 -0400", hash_original_field = "503A2A9D99828334753B8F3F6A4C7555", hash_generated_field = "5B17DBC4CAC28991AA6B7114D96A7324")

    private transient Object messageChannel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.446 -0400", hash_original_field = "812E50456F3CD0D4A6427367F4222311", hash_generated_field = "576FE03392171B0B1591DDE2C13574A7")

    private transient Object inviteTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.447 -0400", hash_original_method = "CD96843F1E97D10004B6B61F026BE84E", hash_generated_method = "17A7559EA941598D9F8A4A095B6BE33D")
    public  SIPRequest() {
        super();
        // ---------- Original Method ----------
    }

    
        private static void putName(String name) {
        nameTable.put(name, name);
    }

    
        public static boolean isTargetRefresh(String ucaseMethod) {
        return targetRefreshMethods.contains(ucaseMethod);
    }

    
        public static boolean isDialogCreating(String ucaseMethod) {
        return SIPTransactionStack.isDialogCreated(ucaseMethod);
    }

    
        public static String getCannonicalName(String method) {
        if (nameTable.containsKey(method))
            return (String) nameTable.get(method);
        else
            return method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.448 -0400", hash_original_method = "10A6E8DED0F9574AB3D1598F76906EF6", hash_generated_method = "E5EA7459E6CA44A106EC87E94CF1B606")
    public RequestLine getRequestLine() {
        RequestLine varB4EAC82CA7396A68D541C85D26508E83_899310065 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_899310065 = requestLine;
        varB4EAC82CA7396A68D541C85D26508E83_899310065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_899310065;
        // ---------- Original Method ----------
        //return requestLine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.448 -0400", hash_original_method = "B9CB3F60AB911F16367336645DE9DCA3", hash_generated_method = "058C4665ACE5103972748C3D479B673A")
    public void setRequestLine(RequestLine requestLine) {
        this.requestLine = requestLine;
        // ---------- Original Method ----------
        //this.requestLine = requestLine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.453 -0400", hash_original_method = "38B14A3222BE2105E2C0F39A9CA63E55", hash_generated_method = "87DC6FEA5379E9C4617CBCEEF9FB8B31")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_1798803105 = null; //Variable for return #1
        String superstring;
        superstring = super.debugDump();
        stringRepresentation = "";
        sprint(SIPRequest.class.getName());
        sprint("{");
        sprint(requestLine.debugDump());
        sprint(superstring);
        sprint("}");
        varB4EAC82CA7396A68D541C85D26508E83_1798803105 = stringRepresentation;
        varB4EAC82CA7396A68D541C85D26508E83_1798803105.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1798803105;
        // ---------- Original Method ----------
        //String superstring = super.debugDump();
        //stringRepresentation = "";
        //sprint(SIPRequest.class.getName());
        //sprint("{");
        //if (requestLine != null)
            //sprint(requestLine.debugDump());
        //sprint(superstring);
        //sprint("}");
        //return stringRepresentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.455 -0400", hash_original_method = "45144F3B633868FAD50525AF05DB3D15", hash_generated_method = "887DA447612089258ED40BB46A3C60F1")
    public void checkHeaders() throws ParseException {
        String prefix;
        prefix = "Missing a required header : ";
        {
            boolean var6342A96FD7DE6C1AD71DF5E6F041816B_460623139 = (getCSeq() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + CSeqHeader.NAME, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var028720CEB12D4FCC08D30523F58E270F_1702835689 = (getTo() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + ToHeader.NAME, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA4C07F37F4DEE003A91119A5E25F4D42_999567941 = (this.callIdHeader == null || this.callIdHeader.getCallId() == null
                || callIdHeader.getCallId().equals(""));
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + CallIdHeader.NAME, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var59B1519B8C7900F9210D51C7E88064B0_1739141501 = (getFrom() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + FromHeader.NAME, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCE8B10FB91FF6C0A5E135CD4C2A83BAD_2100173622 = (getViaHeaders() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + ViaHeader.NAME, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var292458B06CDBCC788CBB5739EE0BF2D9_71331669 = (getTopmostVia() == null);
            if (DroidSafeAndroidRuntime.control) throw new ParseException("No via header in request! ", 0);
        } //End collapsed parenthetic
        {
            boolean varBCC3B65263B4D2C7C3C710D19F9F559A_1056286928 = (getMethod().equals(Request.NOTIFY));
            {
                {
                    boolean var348C543D718BA18069EA2B0B9CD973FF_708129627 = (getHeader(SubscriptionStateHeader.NAME) == null);
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + SubscriptionStateHeader.NAME, 0);
                } //End collapsed parenthetic
                {
                    boolean var3EC878BA20DA34D196AFE3B13F74EFD8_1715788596 = (getHeader(EventHeader.NAME) == null);
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + EventHeader.NAME, 0);
                } //End collapsed parenthetic
            } //End block
            {
                boolean var01A575B4428128F8CCED27EB67F4502F_1819508755 = (getMethod().equals(Request.PUBLISH));
                {
                    {
                        boolean var9652A5554F950E03E4043C0D502B519A_428244610 = (getHeader(EventHeader.NAME) == null);
                        if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + EventHeader.NAME, 0);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean var2E3231C6B811CD5BDE653D17B9D491D1_1515796046 = (requestLine.getMethod().equals(Request.INVITE)
                || requestLine.getMethod().equals(Request.SUBSCRIBE)
                || requestLine.getMethod().equals(Request.REFER));
            {
                {
                    boolean var871ACE9F2BC9EA9EE286F28B85BC3666_1270984567 = (this.getContactHeader() == null);
                    {
                        {
                            boolean var92D8C540B966996D1D76EDC3A718669C_1760445624 = (this.getToTag() == null);
                            if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + ContactHeader.NAME, 0);
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var52A3B9A52C79C136908CBC40D09DC6B6_1281703173 = (requestLine.getUri() instanceof SipUri);
                    {
                        String scheme;
                        scheme = ((SipUri) requestLine.getUri()).getScheme();
                        {
                            boolean var95624149895EEF611065487097ED967B_1336849561 = ("sips".equalsIgnoreCase(scheme));
                            {
                                SipUri sipUri;
                                sipUri = (SipUri) this.getContactHeader().getAddress().getURI();
                                {
                                    boolean var45030BE7A36FEB306DE64ECBDD520486_1563112006 = (!sipUri.getScheme().equals("sips"));
                                    {
                                        if (DroidSafeAndroidRuntime.control) throw new ParseException("Scheme for contact should be sips:" + sipUri, 0);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE94317BC12B8BC816E0A83D7C9CEFE95_151234573 = (this.getContactHeader() == null
                && (this.getMethod().equals(Request.INVITE)
                        || this.getMethod().equals(Request.REFER) || this.getMethod().equals(
                        Request.SUBSCRIBE)));
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Contact Header is Mandatory for a SIP INVITE", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF91EA73B7515A8CA1C091BD18727A961_1704760949 = (requestLine != null && requestLine.getMethod() != null
                && getCSeq().getMethod() != null
                && requestLine.getMethod().compareTo(getCSeq().getMethod()) != 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("CSEQ method mismatch with  Request-Line ", 0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.468 -0400", hash_original_method = "B439ED3271619C5D642106B24B6F8DC7", hash_generated_method = "E4142CBABA18B7BBD24935293203096A")
    protected void setDefaults() {
        String method;
        method = requestLine.getMethod();
        GenericURI u;
        u = requestLine.getUri();
        {
            boolean var013184272FD98399DAFD4719701E8C72_364057614 = (method.compareTo(Request.REGISTER) == 0 || method.compareTo(Request.INVITE) == 0);
            {
                {
                    SipUri sipUri;
                    sipUri = (SipUri) u;
                    sipUri.setUserParam(DEFAULT_USER);
                    try 
                    {
                        sipUri.setTransportParam(DEFAULT_TRANSPORT);
                    } //End block
                    catch (ParseException ex)
                    { }
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (requestLine == null)
            //return;
        //String method = requestLine.getMethod();
        //if (method == null)
            //return;
        //GenericURI u = requestLine.getUri();
        //if (u == null)
            //return;
        //if (method.compareTo(Request.REGISTER) == 0 || method.compareTo(Request.INVITE) == 0) {
            //if (u instanceof SipUri) {
                //SipUri sipUri = (SipUri) u;
                //sipUri.setUserParam(DEFAULT_USER);
                //try {
                    //sipUri.setTransportParam(DEFAULT_TRANSPORT);
                //} catch (ParseException ex) {
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.470 -0400", hash_original_method = "ADE7B9A9349FBC47EE36B154FB701376", hash_generated_method = "1EA6B6F56F0718B063C62BDDDF3E9F14")
    protected void setRequestLineDefaults() {
        String method;
        method = requestLine.getMethod();
        {
            CSeq cseq;
            cseq = (CSeq) this.getCSeq();
            {
                method = getCannonicalName(cseq.getMethod());
                requestLine.setMethod(method);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //String method = requestLine.getMethod();
        //if (method == null) {
            //CSeq cseq = (CSeq) this.getCSeq();
            //if (cseq != null) {
                //method = getCannonicalName(cseq.getMethod());
                //requestLine.setMethod(method);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.471 -0400", hash_original_method = "A3406866B9B5846BB9675C9F68E4252E", hash_generated_method = "77DA0EC0897F44BDE5A1C400AC2B1214")
    public javax.sip.address.URI getRequestURI() {
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_1685617801 = null; //Variable for return #1
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_267809569 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1685617801 = null;
        varB4EAC82CA7396A68D541C85D26508E83_267809569 = (javax.sip.address.URI) this.requestLine.getUri();
        javax.sip.address.URI varA7E53CE21691AB073D9660D615818899_2004107622; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2004107622 = varB4EAC82CA7396A68D541C85D26508E83_1685617801;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2004107622 = varB4EAC82CA7396A68D541C85D26508E83_267809569;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2004107622.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2004107622;
        // ---------- Original Method ----------
        //if (this.requestLine == null)
            //return null;
        //else
            //return (javax.sip.address.URI) this.requestLine.getUri();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.480 -0400", hash_original_method = "9E5CBCE30B3652DB4124768C08B76945", hash_generated_method = "7D6DA007B1114DE86EACEF85DF111A90")
    public void setRequestURI(URI uri) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null request URI");
        } //End block
        {
            this.requestLine = new RequestLine();
        } //End block
        this.requestLine.setUri((GenericURI) uri);
        this.nullRequest = false;
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
        //if ( uri == null ) {
            //throw new NullPointerException("Null request URI");
        //}
        //if (this.requestLine == null) {
            //this.requestLine = new RequestLine();
        //}
        //this.requestLine.setUri((GenericURI) uri);
        //this.nullRequest = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.492 -0400", hash_original_method = "EB488472F269B62C6CA4000BD2F13691", hash_generated_method = "AAB1E57A573D67ABC0F0FBB14A89D59E")
    public void setMethod(String method) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("null method");
        {
            this.requestLine = new RequestLine();
        } //End block
        String meth;
        meth = getCannonicalName(method);
        this.requestLine.setMethod(meth);
        {
            try 
            {
                this.cSeqHeader.setMethod(meth);
            } //End block
            catch (ParseException e)
            { }
        } //End block
        addTaint(method.getTaint());
        // ---------- Original Method ----------
        //if (method == null)
            //throw new IllegalArgumentException("null method");
        //if (this.requestLine == null) {
            //this.requestLine = new RequestLine();
        //}
        //String meth = getCannonicalName(method);
        //this.requestLine.setMethod(meth);
        //if (this.cSeqHeader != null) {
            //try {
                //this.cSeqHeader.setMethod(meth);
            //} catch (ParseException e) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.493 -0400", hash_original_method = "56F7F917AEB0D8ED6BCAD35E03BA3E4E", hash_generated_method = "E3C830F19F580C95A37FFEDE42C3DBCC")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_140243208 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2037552429 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_140243208 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2037552429 = requestLine.getMethod();
        String varA7E53CE21691AB073D9660D615818899_1068333642; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1068333642 = varB4EAC82CA7396A68D541C85D26508E83_140243208;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1068333642 = varB4EAC82CA7396A68D541C85D26508E83_2037552429;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1068333642.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1068333642;
        // ---------- Original Method ----------
        //if (requestLine == null)
            //return null;
        //else
            //return requestLine.getMethod();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.494 -0400", hash_original_method = "A6E50A0D416AE1599A173132FA575828", hash_generated_method = "F7D8C5C805FFF52A97A4D881E2106E72")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_113506326 = null; //Variable for return #1
        String retval;
        {
            this.setRequestLineDefaults();
            retval = requestLine.encode() + super.encode();
        } //End block
        {
            boolean var2826E038A84582C8F51AAE38820F51B2_1116000644 = (this.isNullRequest());
            {
                retval = "\r\n\r\n";
            } //End block
            {
                retval = super.encode();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_113506326 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_113506326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_113506326;
        // ---------- Original Method ----------
        //String retval;
        //if (requestLine != null) {
            //this.setRequestLineDefaults();
            //retval = requestLine.encode() + super.encode();
        //} else if (this.isNullRequest()) {
            //retval = "\r\n\r\n";
        //} else {       
            //retval = super.encode();
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.495 -0400", hash_original_method = "6C6F96FB15913D1AD047295FEBDE6F36", hash_generated_method = "339F8672097D51ABEF82E80054BAB4B7")
    public String encodeMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_547601446 = null; //Variable for return #1
        String retval;
        {
            this.setRequestLineDefaults();
            retval = requestLine.encode() + super.encodeSIPHeaders();
        } //End block
        {
            boolean var2826E038A84582C8F51AAE38820F51B2_73017156 = (this.isNullRequest());
            {
                retval = "\r\n\r\n";
            } //End block
            retval = super.encodeSIPHeaders();
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_547601446 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_547601446.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_547601446;
        // ---------- Original Method ----------
        //String retval;
        //if (requestLine != null) {
            //this.setRequestLineDefaults();
            //retval = requestLine.encode() + super.encodeSIPHeaders();
        //} else if (this.isNullRequest()) {
            //retval = "\r\n\r\n";
        //} else
            //retval = super.encodeSIPHeaders();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.496 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "B83DCD0D9B5FF7DBF57B2E9B241637DC")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_860221702 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_860221702 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_860221702.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_860221702;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.497 -0400", hash_original_method = "A6367075CC534F28F93FAF1E0E79C3E5", hash_generated_method = "6FFA304DBF6C3203B87CA28F30D8148F")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_789506434 = null; //Variable for return #1
        SIPRequest retval;
        retval = (SIPRequest) super.clone();
        retval.transactionPointer = null;
        retval.requestLine = (RequestLine) this.requestLine.clone();
        varB4EAC82CA7396A68D541C85D26508E83_789506434 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_789506434.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_789506434;
        // ---------- Original Method ----------
        //SIPRequest retval = (SIPRequest) super.clone();
        //retval.transactionPointer = null;
        //if (this.requestLine != null)
            //retval.requestLine = (RequestLine) this.requestLine.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.498 -0400", hash_original_method = "9D04458788C457FA55EEFE59B9790011", hash_generated_method = "BE623E4B381AA610BBE4BF39FD0073DB")
    public boolean equals(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_671994295 = (!this.getClass().equals(other.getClass()));
        } //End collapsed parenthetic
        SIPRequest that;
        that = (SIPRequest) other;
        boolean var5416E6F50E239486726CCD9DC982D290_532521141 = (requestLine.equals(that.requestLine) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_208887699 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_208887699;
        // ---------- Original Method ----------
        //if (!this.getClass().equals(other.getClass()))
            //return false;
        //SIPRequest that = (SIPRequest) other;
        //return requestLine.equals(that.requestLine) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.508 -0400", hash_original_method = "6E8F0447EF83A5DA6D1DCD59FBFB3047", hash_generated_method = "BCF1A820F91E73F87327AFF5922C28E3")
    public LinkedList getMessageAsEncodedStrings() {
        LinkedList varB4EAC82CA7396A68D541C85D26508E83_379060367 = null; //Variable for return #1
        LinkedList retval;
        retval = super.getMessageAsEncodedStrings();
        {
            this.setRequestLineDefaults();
            retval.addFirst(requestLine.encode());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_379060367 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_379060367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_379060367;
        // ---------- Original Method ----------
        //LinkedList retval = super.getMessageAsEncodedStrings();
        //if (requestLine != null) {
            //this.setRequestLineDefaults();
            //retval.addFirst(requestLine.encode());
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.518 -0400", hash_original_method = "8262152376D5F60373B8E0AFA26377AD", hash_generated_method = "FEA0499A2CC8D3B4FAB82A5AD30AE71A")
    public boolean match(Object matchObj) {
        {
            boolean varE5ABD91269B098FDB02552058FE738E0_384001324 = (!matchObj.getClass().equals(this.getClass()));
            {
                boolean var3D06C934D988FBFEA9FF217EEB1CEB0C_1245573272 = (matchObj == this);
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        SIPRequest that;
        that = (SIPRequest) matchObj;
        RequestLine rline;
        rline = that.requestLine;
        boolean var6F0A9113B429A383C35EED8AD8F98AAE_688356220 = (super.match(matchObj));
        boolean varE74623C3A1280A38A25E43201CF1F802_391686397 = (requestLine.match(that.requestLine) && super.match(matchObj));
        addTaint(matchObj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_407673483 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_407673483;
        // ---------- Original Method ----------
        //if (matchObj == null)
            //return true;
        //else if (!matchObj.getClass().equals(this.getClass()))
            //return false;
        //else if (matchObj == this)
            //return true;
        //SIPRequest that = (SIPRequest) matchObj;
        //RequestLine rline = that.requestLine;
        //if (this.requestLine == null && rline != null)
            //return false;
        //else if (this.requestLine == rline)
            //return super.match(matchObj);
        //return requestLine.match(that.requestLine) && super.match(matchObj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.520 -0400", hash_original_method = "0EFA7CFB1786F9D68807C88E11C4B131", hash_generated_method = "0115F2A81E8CF3B4AB38A99AD2FE23E8")
    public String getDialogId(boolean isServer) {
        String varB4EAC82CA7396A68D541C85D26508E83_151020993 = null; //Variable for return #1
        CallID cid;
        cid = (CallID) this.getCallId();
        StringBuffer retval;
        retval = new StringBuffer(cid.getCallId());
        From from;
        from = (From) this.getFrom();
        To to;
        to = (To) this.getTo();
        {
            {
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_1745630303 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var1BE29C19B15B07BF37F624C6B7042CDF_1470993692 = (to.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(to.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var1BE29C19B15B07BF37F624C6B7042CDF_246827057 = (to.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(to.getTag());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_255384977 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_151020993 = retval.toString().toLowerCase();
        addTaint(isServer);
        varB4EAC82CA7396A68D541C85D26508E83_151020993.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_151020993;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.528 -0400", hash_original_method = "08CF48833A43F9A889E4DE3BC734C868", hash_generated_method = "B9FCDA42A8A8AD4C3C6DC3D8068214F5")
    public String getDialogId(boolean isServer, String toTag) {
        String varB4EAC82CA7396A68D541C85D26508E83_1038524821 = null; //Variable for return #1
        From from;
        from = (From) this.getFrom();
        CallID cid;
        cid = (CallID) this.getCallId();
        StringBuffer retval;
        retval = new StringBuffer(cid.getCallId());
        {
            {
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_1437049566 = (from.getTag() != null);
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
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_2051796946 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1038524821 = retval.toString().toLowerCase();
        addTaint(isServer);
        addTaint(toTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1038524821.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1038524821;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.529 -0400", hash_original_method = "2AE1DB426BA66F196E718F42EC30B693", hash_generated_method = "5EAC7879CDD6DA79E338EF2F7383E98C")
    public byte[] encodeAsBytes(String transport) {
        {
            boolean var2826E038A84582C8F51AAE38820F51B2_1757663916 = (this.isNullRequest());
            {
                byte[] varEEF83FE8F2414029AB57C6129B64128C_2072102883 = ("\r\n\r\n".getBytes());
            } //End block
            {
                byte[] varBE3FB34956974956A0E259C2754046A5_91101648 = (new byte[0]);
            } //End block
        } //End collapsed parenthetic
        byte[] rlbytes;
        rlbytes = null;
        {
            try 
            {
                rlbytes = requestLine.encode().getBytes("UTF-8");
            } //End block
            catch (UnsupportedEncodingException ex)
            {
                InternalErrorHandler.handleException(ex);
            } //End block
        } //End block
        byte[] superbytes;
        superbytes = super.encodeAsBytes(transport);
        byte[] retval;
        retval = new byte[rlbytes.length + superbytes.length];
        System.arraycopy(rlbytes, 0, retval, 0, rlbytes.length);
        System.arraycopy(superbytes, 0, retval, rlbytes.length, superbytes.length);
        addTaint(transport.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2062807821 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2062807821;
        // ---------- Original Method ----------
        //if (this.isNullRequest()) {
            //return "\r\n\r\n".getBytes();
        //} else if ( this.requestLine == null ) {
            //return new byte[0];
        //}
        //byte[] rlbytes = null;
        //if (requestLine != null) {
            //try {
                //rlbytes = requestLine.encode().getBytes("UTF-8");
            //} catch (UnsupportedEncodingException ex) {
                //InternalErrorHandler.handleException(ex);
            //}
        //}
        //byte[] superbytes = super.encodeAsBytes(transport);
        //byte[] retval = new byte[rlbytes.length + superbytes.length];
        //System.arraycopy(rlbytes, 0, retval, 0, rlbytes.length);
        //System.arraycopy(superbytes, 0, retval, rlbytes.length, superbytes.length);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.537 -0400", hash_original_method = "1C55C0FE8476C30A968193AA8AE54F83", hash_generated_method = "4C0AC19382C45361D43FA7EACE35F789")
    public SIPResponse createResponse(int statusCode) {
        SIPResponse varB4EAC82CA7396A68D541C85D26508E83_1945757716 = null; //Variable for return #1
        String reasonPhrase;
        reasonPhrase = SIPResponse.getReasonPhrase(statusCode);
        varB4EAC82CA7396A68D541C85D26508E83_1945757716 = this.createResponse(statusCode, reasonPhrase);
        addTaint(statusCode);
        varB4EAC82CA7396A68D541C85D26508E83_1945757716.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1945757716;
        // ---------- Original Method ----------
        //String reasonPhrase = SIPResponse.getReasonPhrase(statusCode);
        //return this.createResponse(statusCode, reasonPhrase);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.554 -0400", hash_original_method = "4F64A0C3F2C04A008F76D91B875DAC0D", hash_generated_method = "CC1FC2D6B88FE3F2C3519A255209A704")
    public SIPResponse createResponse(int statusCode, String reasonPhrase) {
        SIPResponse varB4EAC82CA7396A68D541C85D26508E83_1886926382 = null; //Variable for return #1
        SIPResponse newResponse;
        Iterator headerIterator;
        SIPHeader nextHeader;
        newResponse = new SIPResponse();
        try 
        {
            newResponse.setStatusCode(statusCode);
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad code " + statusCode);
        } //End block
        newResponse.setReasonPhrase(reasonPhrase);
        newResponse.setReasonPhrase(SIPResponse.getReasonPhrase(statusCode));
        headerIterator = getHeaders();
        {
            boolean var1440086C7F6E137687239D414F8ECC74_729400500 = (headerIterator.hasNext());
            {
                nextHeader = (SIPHeader) headerIterator.next();
                {
                    boolean var154A7966FCDCD95D25E63CFDADBC607B_1028436608 = (nextHeader instanceof From
                    || nextHeader instanceof To
                    || nextHeader instanceof ViaList
                    || nextHeader instanceof CallID
                    || (nextHeader instanceof RecordRouteList && mustCopyRR(statusCode))
                    || nextHeader instanceof CSeq
                    || nextHeader instanceof TimeStamp);
                    {
                        try 
                        {
                            newResponse.attachHeader((SIPHeader) nextHeader.clone(), false);
                        } //End block
                        catch (SIPDuplicateHeaderException e)
                        {
                            e.printStackTrace();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE71367B7FC420DF364496FD57FDD6F25_330390387 = (MessageFactoryImpl.getDefaultServerHeader() != null);
            {
                newResponse.setHeader(MessageFactoryImpl.getDefaultServerHeader());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var315E7E2DABE74C9BD4384840ADC4BCCE_334807069 = (newResponse.getStatusCode() == 100);
            {
                newResponse.getTo().removeParameter("tag");
            } //End block
        } //End collapsed parenthetic
        ServerHeader server;
        server = MessageFactoryImpl.getDefaultServerHeader();
        {
            newResponse.setHeader(server);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1886926382 = newResponse;
        addTaint(statusCode);
        addTaint(reasonPhrase.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1886926382.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1886926382;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.555 -0400", hash_original_method = "B9BF2BAEBA19E8A2F042C98E4A2B8D22", hash_generated_method = "8490E0A587F1187F2766DB02C323269A")
    private final boolean mustCopyRR( int code ) {
        {
            boolean var077A836254DECCEE29A7CCA1784E5786_350130993 = (isDialogCreating( this.getMethod() ) && getToTag() == null);
        } //End block
        addTaint(code);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_200427365 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_200427365;
        // ---------- Original Method ----------
        //if ( code>100 && code<300 ) {
    		//return isDialogCreating( this.getMethod() ) && getToTag() == null;
    	//} else return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.556 -0400", hash_original_method = "8DA892BCFD0BDEE05EB086307BFA5229", hash_generated_method = "9E011935DD972C50326BE2BD23D99838")
    public SIPRequest createCancelRequest() throws SipException {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_961294859 = null; //Variable for return #1
        {
            boolean var003FF941DD84787B07735917FE25C187_737587377 = (!this.getMethod().equals(Request.INVITE));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Attempt to create CANCEL for " + this.getMethod());
        } //End collapsed parenthetic
        SIPRequest cancel;
        cancel = new SIPRequest();
        cancel.setRequestLine((RequestLine) this.requestLine.clone());
        cancel.setMethod(Request.CANCEL);
        cancel.setHeader((Header) this.callIdHeader.clone());
        cancel.setHeader((Header) this.toHeader.clone());
        cancel.setHeader((Header) cSeqHeader.clone());
        try 
        {
            cancel.getCSeq().setMethod(Request.CANCEL);
        } //End block
        catch (ParseException e)
        {
            e.printStackTrace();
        } //End block
        cancel.setHeader((Header) this.fromHeader.clone());
        cancel.addFirst((Header) this.getTopmostVia().clone());
        cancel.setHeader((Header) this.maxForwardsHeader.clone());
        {
            boolean var3DB531AB02CB977CBC8A97A334A03D84_1342798089 = (this.getRouteHeaders() != null);
            {
                cancel.setHeader((SIPHeaderList< ? >) this.getRouteHeaders().clone());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var896FD3C9C4EED86170D10D69961A19CE_1273477499 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                cancel.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_961294859 = cancel;
        varB4EAC82CA7396A68D541C85D26508E83_961294859.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_961294859;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.569 -0400", hash_original_method = "19E2EF483A3AD0C60513AE35D850A021", hash_generated_method = "D846B53DCC1D7D89794986C8EFDC73E4")
    public SIPRequest createAckRequest(To responseToHeader) {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_154671657 = null; //Variable for return #1
        SIPRequest newRequest;
        Iterator headerIterator;
        SIPHeader nextHeader;
        newRequest = new SIPRequest();
        newRequest.setRequestLine((RequestLine) this.requestLine.clone());
        newRequest.setMethod(Request.ACK);
        headerIterator = getHeaders();
        {
            boolean var1440086C7F6E137687239D414F8ECC74_1766192694 = (headerIterator.hasNext());
            {
                nextHeader = (SIPHeader) headerIterator.next();
                {
                    nextHeader = (SIPHeader) nextHeader.clone();
                    try 
                    {
                        ((ContentLength) nextHeader).setContentLength(0);
                    } //End block
                    catch (InvalidArgumentException e)
                    { }
                } //End block
                {
                    CSeq cseq;
                    cseq = (CSeq) nextHeader.clone();
                    try 
                    {
                        cseq.setMethod(Request.ACK);
                    } //End block
                    catch (ParseException e)
                    { }
                    nextHeader = cseq;
                } //End block
                {
                    {
                        nextHeader = responseToHeader;
                    } //End block
                    {
                        nextHeader = (SIPHeader) nextHeader.clone();
                    } //End block
                } //End block
                {
                    nextHeader = (SIPHeader) ((ViaList) nextHeader).getFirst().clone();
                } //End block
                {
                    nextHeader = (SIPHeader) nextHeader.clone();
                } //End block
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
        {
            boolean var896FD3C9C4EED86170D10D69961A19CE_1578285355 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_154671657 = newRequest;
        addTaint(responseToHeader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_154671657.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_154671657;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.571 -0400", hash_original_method = "7B881B99117D66C1BDF145A59ABEA2E4", hash_generated_method = "384040953E6C350518B3FFBFEDCC7F3A")
    public final SIPRequest createErrorAck(To responseToHeader) throws SipException,
            ParseException {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_943351274 = null; //Variable for return #1
        SIPRequest newRequest;
        newRequest = new SIPRequest();
        newRequest.setRequestLine((RequestLine) this.requestLine.clone());
        newRequest.setMethod(Request.ACK);
        newRequest.setHeader((Header) this.callIdHeader.clone());
        newRequest.setHeader((Header) this.maxForwardsHeader.clone());
        newRequest.setHeader((Header) this.fromHeader.clone());
        newRequest.setHeader((Header) responseToHeader.clone());
        newRequest.addFirst((Header) this.getTopmostVia().clone());
        newRequest.setHeader((Header) cSeqHeader.clone());
        newRequest.getCSeq().setMethod(Request.ACK);
        {
            boolean var3DB531AB02CB977CBC8A97A334A03D84_1778022079 = (this.getRouteHeaders() != null);
            {
                newRequest.setHeader((SIPHeaderList) this.getRouteHeaders().clone());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var896FD3C9C4EED86170D10D69961A19CE_2109369659 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_943351274 = newRequest;
        addTaint(responseToHeader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_943351274.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_943351274;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.588 -0400", hash_original_method = "88B58E52E2D044E743A1ED3102F3960B", hash_generated_method = "76AFEC0D8F1DB654F6A9F53031FA2E5E")
    public SIPRequest createSIPRequest(RequestLine requestLine, boolean switchHeaders) {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_730694701 = null; //Variable for return #1
        SIPRequest newRequest;
        newRequest = new SIPRequest();
        newRequest.requestLine = requestLine;
        Iterator<SIPHeader> headerIterator;
        headerIterator = this.getHeaders();
        {
            boolean var1440086C7F6E137687239D414F8ECC74_1646254995 = (headerIterator.hasNext());
            {
                SIPHeader nextHeader;
                nextHeader = (SIPHeader) headerIterator.next();
                {
                    CSeq newCseq;
                    newCseq = (CSeq) nextHeader.clone();
                    nextHeader = newCseq;
                    try 
                    {
                        newCseq.setMethod(requestLine.getMethod());
                    } //End block
                    catch (ParseException e)
                    { }
                } //End block
                {
                    Via via;
                    via = (Via) (((ViaList) nextHeader).getFirst().clone());
                    via.removeParameter("branch");
                    nextHeader = via;
                } //End block
                {
                    To to;
                    to = (To) nextHeader;
                    {
                        nextHeader = new From(to);
                        ((From) nextHeader).removeTag();
                    } //End block
                    {
                        nextHeader = (SIPHeader) to.clone();
                        ((To) nextHeader).removeTag();
                    } //End block
                } //End block
                {
                    From from;
                    from = (From) nextHeader;
                    {
                        nextHeader = new To(from);
                        ((To) nextHeader).removeTag();
                    } //End block
                    {
                        nextHeader = (SIPHeader) from.clone();
                        ((From) nextHeader).removeTag();
                    } //End block
                } //End block
                {
                    ContentLength cl;
                    cl = (ContentLength) nextHeader.clone();
                    try 
                    {
                        cl.setContentLength(0);
                    } //End block
                    catch (InvalidArgumentException e)
                    { }
                    nextHeader = cl;
                } //End block
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
        {
            boolean var896FD3C9C4EED86170D10D69961A19CE_787100232 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_730694701 = newRequest;
        addTaint(switchHeaders);
        varB4EAC82CA7396A68D541C85D26508E83_730694701.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_730694701;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.600 -0400", hash_original_method = "D367B8AD3F620DA29FDBF98B146E85CC", hash_generated_method = "DDE0103172A228F8F785721C9FC7F966")
    public SIPRequest createBYERequest(boolean switchHeaders) {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_311543787 = null; //Variable for return #1
        RequestLine requestLine;
        requestLine = (RequestLine) this.requestLine.clone();
        requestLine.setMethod("BYE");
        varB4EAC82CA7396A68D541C85D26508E83_311543787 = this.createSIPRequest(requestLine, switchHeaders);
        addTaint(switchHeaders);
        varB4EAC82CA7396A68D541C85D26508E83_311543787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_311543787;
        // ---------- Original Method ----------
        //RequestLine requestLine = (RequestLine) this.requestLine.clone();
        //requestLine.setMethod("BYE");
        //return this.createSIPRequest(requestLine, switchHeaders);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.601 -0400", hash_original_method = "F27ED260A28BC4E6AB9113A5229AE82E", hash_generated_method = "F1619F92359AF1DD838849388762B940")
    public SIPRequest createACKRequest() {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_1742595768 = null; //Variable for return #1
        RequestLine requestLine;
        requestLine = (RequestLine) this.requestLine.clone();
        requestLine.setMethod(Request.ACK);
        varB4EAC82CA7396A68D541C85D26508E83_1742595768 = this.createSIPRequest(requestLine, false);
        varB4EAC82CA7396A68D541C85D26508E83_1742595768.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1742595768;
        // ---------- Original Method ----------
        //RequestLine requestLine = (RequestLine) this.requestLine.clone();
        //requestLine.setMethod(Request.ACK);
        //return this.createSIPRequest(requestLine, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.602 -0400", hash_original_method = "DA1F7E2B6F3093C6379A0C0D51E796B9", hash_generated_method = "EB26D2181DDE3313E422F62B5127F365")
    public String getViaHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_499335662 = null; //Variable for return #1
        Via via;
        via = (Via) this.getViaHeaders().getFirst();
        varB4EAC82CA7396A68D541C85D26508E83_499335662 = via.getHost();
        varB4EAC82CA7396A68D541C85D26508E83_499335662.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_499335662;
        // ---------- Original Method ----------
        //Via via = (Via) this.getViaHeaders().getFirst();
        //return via.getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.602 -0400", hash_original_method = "C4DF5E381400BD9B0BACC03DD32438B3", hash_generated_method = "B6EB72FF6379CA3CB5C9A3F0C933FB99")
    public int getViaPort() {
        Via via;
        via = (Via) this.getViaHeaders().getFirst();
        {
            boolean var27E48064627BFABA5E460911669067D3_303204276 = (via.hasPort());
            int varF76A67835AC57BE66ADBC036AF6A64B8_464103875 = (via.getPort());
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_247036150 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_247036150;
        // ---------- Original Method ----------
        //Via via = (Via) this.getViaHeaders().getFirst();
        //if (via.hasPort())
            //return via.getPort();
        //else
            //return 5060;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.604 -0400", hash_original_method = "530E19A2E500806E1A366E25A34AD0D7", hash_generated_method = "C465B36B06165EC894992480561EF6B4")
    public String getFirstLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_1997802672 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1433723225 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1997802672 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1433723225 = this.requestLine.encode();
        String varA7E53CE21691AB073D9660D615818899_2126151748; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2126151748 = varB4EAC82CA7396A68D541C85D26508E83_1997802672;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2126151748 = varB4EAC82CA7396A68D541C85D26508E83_1433723225;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2126151748.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2126151748;
        // ---------- Original Method ----------
        //if (requestLine == null)
            //return null;
        //else
            //return this.requestLine.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.604 -0400", hash_original_method = "053882D0BB9ABEB2DEF0F19246596664", hash_generated_method = "22A204C2F39F2708FE6201246C128D81")
    public void setSIPVersion(String sipVersion) throws ParseException {
        {
            boolean varE966623B38FBA4E1C15009CDDDA6677E_1648283420 = (sipVersion == null || !sipVersion.equalsIgnoreCase("SIP/2.0"));
            if (DroidSafeAndroidRuntime.control) throw new ParseException("sipVersion", 0);
        } //End collapsed parenthetic
        this.requestLine.setSipVersion(sipVersion);
        addTaint(sipVersion.getTaint());
        // ---------- Original Method ----------
        //if (sipVersion == null || !sipVersion.equalsIgnoreCase("SIP/2.0"))
            //throw new ParseException("sipVersion", 0);
        //this.requestLine.setSipVersion(sipVersion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.616 -0400", hash_original_method = "00EEF223B95EA2B5E1E6EED25EDEECD3", hash_generated_method = "CDF2ABDBCBDF4853BEBFDCB77E4F1973")
    public String getSIPVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_1931982134 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1931982134 = this.requestLine.getSipVersion();
        varB4EAC82CA7396A68D541C85D26508E83_1931982134.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1931982134;
        // ---------- Original Method ----------
        //return this.requestLine.getSipVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.617 -0400", hash_original_method = "1671629A516F35F213CEF63536914216", hash_generated_method = "8969186166E3F028097787321D62BA37")
    public Object getTransaction() {
        Object varB4EAC82CA7396A68D541C85D26508E83_687753941 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_687753941 = this.transactionPointer;
        varB4EAC82CA7396A68D541C85D26508E83_687753941.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_687753941;
        // ---------- Original Method ----------
        //return this.transactionPointer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.618 -0400", hash_original_method = "29C9F28BA62C1C5D6183FC49B73B119A", hash_generated_method = "94869A7C33E91A92D8453F215213E646")
    public void setTransaction(Object transaction) {
        this.transactionPointer = transaction;
        // ---------- Original Method ----------
        //this.transactionPointer = transaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.618 -0400", hash_original_method = "D6849E418A3430D13263F7E766EC96CA", hash_generated_method = "465851A79A83E0576459C47134DB9C72")
    public Object getMessageChannel() {
        Object varB4EAC82CA7396A68D541C85D26508E83_200513563 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_200513563 = this.messageChannel;
        varB4EAC82CA7396A68D541C85D26508E83_200513563.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_200513563;
        // ---------- Original Method ----------
        //return this.messageChannel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.623 -0400", hash_original_method = "F021F3118E1F64B2274957A9C076266A", hash_generated_method = "35A1FA712B0E58B7E51DD40258282990")
    public void setMessageChannel(Object messageChannel) {
        this.messageChannel = messageChannel;
        // ---------- Original Method ----------
        //this.messageChannel = messageChannel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.629 -0400", hash_original_method = "5C56890151E96C66B0B2332BC1750187", hash_generated_method = "DF49C0AAB5A2758CA43C191F2708B440")
    public String getMergeId() {
        String varB4EAC82CA7396A68D541C85D26508E83_732184919 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1993019728 = null; //Variable for return #2
        String fromTag;
        fromTag = this.getFromTag();
        String cseq;
        cseq = this.cSeqHeader.toString();
        String callId;
        callId = this.callIdHeader.getCallId();
        String requestUri;
        requestUri = this.getRequestURI().toString();
        {
            varB4EAC82CA7396A68D541C85D26508E83_732184919 = new StringBuffer().append(requestUri).append(":").append(fromTag).append(":").append(cseq).append(":")
                    .append(callId).toString();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1993019728 = null;
        String varA7E53CE21691AB073D9660D615818899_399130836; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_399130836 = varB4EAC82CA7396A68D541C85D26508E83_732184919;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_399130836 = varB4EAC82CA7396A68D541C85D26508E83_1993019728;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_399130836.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_399130836;
        // ---------- Original Method ----------
        //String fromTag = this.getFromTag();
        //String cseq = this.cSeqHeader.toString();
        //String callId = this.callIdHeader.getCallId();
        //String requestUri = this.getRequestURI().toString();
        //if (fromTag != null) {
            //return new StringBuffer().append(requestUri).append(":").append(fromTag).append(":").append(cseq).append(":")
                    //.append(callId).toString();
        //} else
            //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.630 -0400", hash_original_method = "8408AE2B464881D5E749D0715A83122D", hash_generated_method = "D0FB6723A7B923AC4749917A36A0F167")
    public void setInviteTransaction(Object inviteTransaction) {
        this.inviteTransaction = inviteTransaction;
        // ---------- Original Method ----------
        //this.inviteTransaction = inviteTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.631 -0400", hash_original_method = "E74B555DC4A151C37AF9F95C34B6492D", hash_generated_method = "F7F0BAF11F28EEC7114A206BEC43A7DB")
    public Object getInviteTransaction() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1291232361 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1291232361 = inviteTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_1291232361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1291232361;
        // ---------- Original Method ----------
        //return inviteTransaction;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.641 -0400", hash_original_field = "AF1F2C3098CE6F5B251798F428DA7ADF", hash_generated_field = "B8561CE122A2D14C8122464C29DD1D4A")

    private static long serialVersionUID = 3360720013577322927L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.641 -0400", hash_original_field = "586FC4F17D4338737E9C91CFD70A2ADD", hash_generated_field = "92C48F1001428EFEB2EC4164921C9EB7")

    private static String DEFAULT_USER = "ip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.641 -0400", hash_original_field = "D61B4598257D50C1BE3144E43BCC41F6", hash_generated_field = "C3B122849CFA8672EB47BF0310275CC4")

    private static String DEFAULT_TRANSPORT = "udp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.641 -0400", hash_original_field = "EC71AA1577C3113BD905305C7B5E5210", hash_generated_field = "007A9B174B8F7EB4D2667D2018C73529")

    private static Set<String> targetRefreshMethods = new HashSet<String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.641 -0400", hash_original_field = "4389E28B96080601985651075AC75C26", hash_generated_field = "6F38E402D58BCF6D3BA977047908B9F1")

    private static Hashtable<String, String> nameTable = new Hashtable<String, String>();
    static {
        targetRefreshMethods.add(Request.INVITE);
        targetRefreshMethods.add(Request.UPDATE);
        targetRefreshMethods.add(Request.SUBSCRIBE);
        targetRefreshMethods.add(Request.NOTIFY);
        targetRefreshMethods.add(Request.REFER);
        putName(Request.INVITE);
        putName(Request.BYE);
        putName(Request.CANCEL);
        putName(Request.ACK);
        putName(Request.PRACK);
        putName(Request.INFO);
        putName(Request.MESSAGE);
        putName(Request.NOTIFY);
        putName(Request.OPTIONS);
        putName(Request.PRACK);
        putName(Request.PUBLISH);
        putName(Request.REFER);
        putName(Request.REGISTER);
        putName(Request.SUBSCRIBE);
        putName(Request.UPDATE);
    }
    
}

