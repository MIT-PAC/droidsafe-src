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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.423 -0400", hash_original_field = "12492E2615AAEE902567F83B53B51169", hash_generated_field = "35845A8B5E63218306C5DA0C937C70A8")

    private transient Object transactionPointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.423 -0400", hash_original_field = "776431FA890572AB0ADBBE09FE6DD67A", hash_generated_field = "583EB683C8DCDB7E0E7B7B105FE10943")

    private RequestLine requestLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.423 -0400", hash_original_field = "503A2A9D99828334753B8F3F6A4C7555", hash_generated_field = "5B17DBC4CAC28991AA6B7114D96A7324")

    private transient Object messageChannel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.423 -0400", hash_original_field = "812E50456F3CD0D4A6427367F4222311", hash_generated_field = "576FE03392171B0B1591DDE2C13574A7")

    private transient Object inviteTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.423 -0400", hash_original_method = "CD96843F1E97D10004B6B61F026BE84E", hash_generated_method = "17A7559EA941598D9F8A4A095B6BE33D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.431 -0400", hash_original_method = "10A6E8DED0F9574AB3D1598F76906EF6", hash_generated_method = "E4E4706B76B79D8DF0576E3E4F2F71B7")
    public RequestLine getRequestLine() {
        RequestLine varB4EAC82CA7396A68D541C85D26508E83_220015808 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_220015808 = requestLine;
        varB4EAC82CA7396A68D541C85D26508E83_220015808.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_220015808;
        // ---------- Original Method ----------
        //return requestLine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.432 -0400", hash_original_method = "B9CB3F60AB911F16367336645DE9DCA3", hash_generated_method = "058C4665ACE5103972748C3D479B673A")
    public void setRequestLine(RequestLine requestLine) {
        this.requestLine = requestLine;
        // ---------- Original Method ----------
        //this.requestLine = requestLine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.432 -0400", hash_original_method = "38B14A3222BE2105E2C0F39A9CA63E55", hash_generated_method = "F39247FC382D53E4F0A4B5696B18C288")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_1432939309 = null; //Variable for return #1
        String superstring;
        superstring = super.debugDump();
        stringRepresentation = "";
        sprint(SIPRequest.class.getName());
        sprint("{");
        sprint(requestLine.debugDump());
        sprint(superstring);
        sprint("}");
        varB4EAC82CA7396A68D541C85D26508E83_1432939309 = stringRepresentation;
        varB4EAC82CA7396A68D541C85D26508E83_1432939309.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1432939309;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.476 -0400", hash_original_method = "45144F3B633868FAD50525AF05DB3D15", hash_generated_method = "2808BC096B67925DE122537DCDED4336")
    public void checkHeaders() throws ParseException {
        String prefix;
        prefix = "Missing a required header : ";
        {
            boolean var6342A96FD7DE6C1AD71DF5E6F041816B_1530575001 = (getCSeq() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + CSeqHeader.NAME, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var028720CEB12D4FCC08D30523F58E270F_274803162 = (getTo() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + ToHeader.NAME, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA4C07F37F4DEE003A91119A5E25F4D42_1501903846 = (this.callIdHeader == null || this.callIdHeader.getCallId() == null
                || callIdHeader.getCallId().equals(""));
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + CallIdHeader.NAME, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var59B1519B8C7900F9210D51C7E88064B0_1449674773 = (getFrom() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + FromHeader.NAME, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCE8B10FB91FF6C0A5E135CD4C2A83BAD_93706391 = (getViaHeaders() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + ViaHeader.NAME, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var292458B06CDBCC788CBB5739EE0BF2D9_1004490841 = (getTopmostVia() == null);
            if (DroidSafeAndroidRuntime.control) throw new ParseException("No via header in request! ", 0);
        } //End collapsed parenthetic
        {
            boolean varBCC3B65263B4D2C7C3C710D19F9F559A_315061043 = (getMethod().equals(Request.NOTIFY));
            {
                {
                    boolean var348C543D718BA18069EA2B0B9CD973FF_373629904 = (getHeader(SubscriptionStateHeader.NAME) == null);
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + SubscriptionStateHeader.NAME, 0);
                } //End collapsed parenthetic
                {
                    boolean var3EC878BA20DA34D196AFE3B13F74EFD8_1932899773 = (getHeader(EventHeader.NAME) == null);
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + EventHeader.NAME, 0);
                } //End collapsed parenthetic
            } //End block
            {
                boolean var01A575B4428128F8CCED27EB67F4502F_83429091 = (getMethod().equals(Request.PUBLISH));
                {
                    {
                        boolean var9652A5554F950E03E4043C0D502B519A_1677140998 = (getHeader(EventHeader.NAME) == null);
                        if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + EventHeader.NAME, 0);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean var2E3231C6B811CD5BDE653D17B9D491D1_640258085 = (requestLine.getMethod().equals(Request.INVITE)
                || requestLine.getMethod().equals(Request.SUBSCRIBE)
                || requestLine.getMethod().equals(Request.REFER));
            {
                {
                    boolean var871ACE9F2BC9EA9EE286F28B85BC3666_469796174 = (this.getContactHeader() == null);
                    {
                        {
                            boolean var92D8C540B966996D1D76EDC3A718669C_1807974080 = (this.getToTag() == null);
                            if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + ContactHeader.NAME, 0);
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var52A3B9A52C79C136908CBC40D09DC6B6_1672116390 = (requestLine.getUri() instanceof SipUri);
                    {
                        String scheme;
                        scheme = ((SipUri) requestLine.getUri()).getScheme();
                        {
                            boolean var95624149895EEF611065487097ED967B_669315390 = ("sips".equalsIgnoreCase(scheme));
                            {
                                SipUri sipUri;
                                sipUri = (SipUri) this.getContactHeader().getAddress().getURI();
                                {
                                    boolean var45030BE7A36FEB306DE64ECBDD520486_87256511 = (!sipUri.getScheme().equals("sips"));
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
            boolean varE94317BC12B8BC816E0A83D7C9CEFE95_130977748 = (this.getContactHeader() == null
                && (this.getMethod().equals(Request.INVITE)
                        || this.getMethod().equals(Request.REFER) || this.getMethod().equals(
                        Request.SUBSCRIBE)));
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Contact Header is Mandatory for a SIP INVITE", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF91EA73B7515A8CA1C091BD18727A961_1713544150 = (requestLine != null && requestLine.getMethod() != null
                && getCSeq().getMethod() != null
                && requestLine.getMethod().compareTo(getCSeq().getMethod()) != 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("CSEQ method mismatch with  Request-Line ", 0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.478 -0400", hash_original_method = "B439ED3271619C5D642106B24B6F8DC7", hash_generated_method = "EDDCBAE806743DE36186B0D3EC471E47")
    protected void setDefaults() {
        String method;
        method = requestLine.getMethod();
        GenericURI u;
        u = requestLine.getUri();
        {
            boolean var013184272FD98399DAFD4719701E8C72_599465468 = (method.compareTo(Request.REGISTER) == 0 || method.compareTo(Request.INVITE) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.479 -0400", hash_original_method = "ADE7B9A9349FBC47EE36B154FB701376", hash_generated_method = "1EA6B6F56F0718B063C62BDDDF3E9F14")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.489 -0400", hash_original_method = "A3406866B9B5846BB9675C9F68E4252E", hash_generated_method = "6FBBE7CB3D03FFC19D4F33DF042EDBCC")
    public javax.sip.address.URI getRequestURI() {
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_1904867550 = null; //Variable for return #1
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_1614559671 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1904867550 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1614559671 = (javax.sip.address.URI) this.requestLine.getUri();
        javax.sip.address.URI varA7E53CE21691AB073D9660D615818899_992955079; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_992955079 = varB4EAC82CA7396A68D541C85D26508E83_1904867550;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_992955079 = varB4EAC82CA7396A68D541C85D26508E83_1614559671;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_992955079.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_992955079;
        // ---------- Original Method ----------
        //if (this.requestLine == null)
            //return null;
        //else
            //return (javax.sip.address.URI) this.requestLine.getUri();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.498 -0400", hash_original_method = "9E5CBCE30B3652DB4124768C08B76945", hash_generated_method = "7D6DA007B1114DE86EACEF85DF111A90")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.499 -0400", hash_original_method = "EB488472F269B62C6CA4000BD2F13691", hash_generated_method = "AAB1E57A573D67ABC0F0FBB14A89D59E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.520 -0400", hash_original_method = "56F7F917AEB0D8ED6BCAD35E03BA3E4E", hash_generated_method = "8B25F0C606B65448EFD692C1112155A0")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_64378536 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_730695996 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_64378536 = null;
        varB4EAC82CA7396A68D541C85D26508E83_730695996 = requestLine.getMethod();
        String varA7E53CE21691AB073D9660D615818899_287559655; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_287559655 = varB4EAC82CA7396A68D541C85D26508E83_64378536;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_287559655 = varB4EAC82CA7396A68D541C85D26508E83_730695996;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_287559655.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_287559655;
        // ---------- Original Method ----------
        //if (requestLine == null)
            //return null;
        //else
            //return requestLine.getMethod();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.521 -0400", hash_original_method = "A6E50A0D416AE1599A173132FA575828", hash_generated_method = "1338BD31ECD3DE7FCDF5BE1CED6077B4")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1557029214 = null; //Variable for return #1
        String retval;
        {
            this.setRequestLineDefaults();
            retval = requestLine.encode() + super.encode();
        } //End block
        {
            boolean var2826E038A84582C8F51AAE38820F51B2_1824151703 = (this.isNullRequest());
            {
                retval = "\r\n\r\n";
            } //End block
            {
                retval = super.encode();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1557029214 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1557029214.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1557029214;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.527 -0400", hash_original_method = "6C6F96FB15913D1AD047295FEBDE6F36", hash_generated_method = "2DD6401E1D57E2B4A4D4F1D21229B901")
    public String encodeMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1895311056 = null; //Variable for return #1
        String retval;
        {
            this.setRequestLineDefaults();
            retval = requestLine.encode() + super.encodeSIPHeaders();
        } //End block
        {
            boolean var2826E038A84582C8F51AAE38820F51B2_542809047 = (this.isNullRequest());
            {
                retval = "\r\n\r\n";
            } //End block
            retval = super.encodeSIPHeaders();
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1895311056 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1895311056.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1895311056;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.544 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "8C2BB1C86C27318E02E80791403F28EA")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1923206536 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1923206536 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1923206536.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1923206536;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.546 -0400", hash_original_method = "A6367075CC534F28F93FAF1E0E79C3E5", hash_generated_method = "55D976C0760C44D9E10977D18C22D0F7")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1384155373 = null; //Variable for return #1
        SIPRequest retval;
        retval = (SIPRequest) super.clone();
        retval.transactionPointer = null;
        retval.requestLine = (RequestLine) this.requestLine.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1384155373 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1384155373.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1384155373;
        // ---------- Original Method ----------
        //SIPRequest retval = (SIPRequest) super.clone();
        //retval.transactionPointer = null;
        //if (this.requestLine != null)
            //retval.requestLine = (RequestLine) this.requestLine.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.546 -0400", hash_original_method = "9D04458788C457FA55EEFE59B9790011", hash_generated_method = "ED766F99F8FD1D42411EDFEAB45165B7")
    public boolean equals(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_1699746141 = (!this.getClass().equals(other.getClass()));
        } //End collapsed parenthetic
        SIPRequest that;
        that = (SIPRequest) other;
        boolean var5416E6F50E239486726CCD9DC982D290_1338573811 = (requestLine.equals(that.requestLine) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_152763257 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_152763257;
        // ---------- Original Method ----------
        //if (!this.getClass().equals(other.getClass()))
            //return false;
        //SIPRequest that = (SIPRequest) other;
        //return requestLine.equals(that.requestLine) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.555 -0400", hash_original_method = "6E8F0447EF83A5DA6D1DCD59FBFB3047", hash_generated_method = "B3F6DBD25A70EFC57304492886F0E3E3")
    public LinkedList getMessageAsEncodedStrings() {
        LinkedList varB4EAC82CA7396A68D541C85D26508E83_762718428 = null; //Variable for return #1
        LinkedList retval;
        retval = super.getMessageAsEncodedStrings();
        {
            this.setRequestLineDefaults();
            retval.addFirst(requestLine.encode());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_762718428 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_762718428.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_762718428;
        // ---------- Original Method ----------
        //LinkedList retval = super.getMessageAsEncodedStrings();
        //if (requestLine != null) {
            //this.setRequestLineDefaults();
            //retval.addFirst(requestLine.encode());
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.567 -0400", hash_original_method = "8262152376D5F60373B8E0AFA26377AD", hash_generated_method = "6944F5F4D6F757E26712F18731F180DF")
    public boolean match(Object matchObj) {
        {
            boolean varE5ABD91269B098FDB02552058FE738E0_1515604633 = (!matchObj.getClass().equals(this.getClass()));
            {
                boolean var3D06C934D988FBFEA9FF217EEB1CEB0C_1199988807 = (matchObj == this);
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        SIPRequest that;
        that = (SIPRequest) matchObj;
        RequestLine rline;
        rline = that.requestLine;
        boolean var6F0A9113B429A383C35EED8AD8F98AAE_23923959 = (super.match(matchObj));
        boolean varE74623C3A1280A38A25E43201CF1F802_1228185121 = (requestLine.match(that.requestLine) && super.match(matchObj));
        addTaint(matchObj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1708254705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1708254705;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.571 -0400", hash_original_method = "0EFA7CFB1786F9D68807C88E11C4B131", hash_generated_method = "64BC9C3C155B986148D677380B4146CC")
    public String getDialogId(boolean isServer) {
        String varB4EAC82CA7396A68D541C85D26508E83_297659364 = null; //Variable for return #1
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
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_252893647 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var1BE29C19B15B07BF37F624C6B7042CDF_885233003 = (to.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(to.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var1BE29C19B15B07BF37F624C6B7042CDF_618854872 = (to.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(to.getTag());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_1826556170 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_297659364 = retval.toString().toLowerCase();
        addTaint(isServer);
        varB4EAC82CA7396A68D541C85D26508E83_297659364.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_297659364;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.572 -0400", hash_original_method = "08CF48833A43F9A889E4DE3BC734C868", hash_generated_method = "3F3E2297B8E607FC82A4F25CB5CEA512")
    public String getDialogId(boolean isServer, String toTag) {
        String varB4EAC82CA7396A68D541C85D26508E83_1823389273 = null; //Variable for return #1
        From from;
        from = (From) this.getFrom();
        CallID cid;
        cid = (CallID) this.getCallId();
        StringBuffer retval;
        retval = new StringBuffer(cid.getCallId());
        {
            {
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_1922001326 = (from.getTag() != null);
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
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_1831490025 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1823389273 = retval.toString().toLowerCase();
        addTaint(isServer);
        addTaint(toTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1823389273.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1823389273;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.573 -0400", hash_original_method = "2AE1DB426BA66F196E718F42EC30B693", hash_generated_method = "6B4DBC1B588EC0E77CE162058B87C1C1")
    public byte[] encodeAsBytes(String transport) {
        {
            boolean var2826E038A84582C8F51AAE38820F51B2_18126618 = (this.isNullRequest());
            {
                byte[] varEEF83FE8F2414029AB57C6129B64128C_56836107 = ("\r\n\r\n".getBytes());
            } //End block
            {
                byte[] varBE3FB34956974956A0E259C2754046A5_7242850 = (new byte[0]);
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1183410976 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1183410976;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.573 -0400", hash_original_method = "1C55C0FE8476C30A968193AA8AE54F83", hash_generated_method = "E85842BFED13489CA538AD07EDBAF5F1")
    public SIPResponse createResponse(int statusCode) {
        SIPResponse varB4EAC82CA7396A68D541C85D26508E83_491006235 = null; //Variable for return #1
        String reasonPhrase;
        reasonPhrase = SIPResponse.getReasonPhrase(statusCode);
        varB4EAC82CA7396A68D541C85D26508E83_491006235 = this.createResponse(statusCode, reasonPhrase);
        addTaint(statusCode);
        varB4EAC82CA7396A68D541C85D26508E83_491006235.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_491006235;
        // ---------- Original Method ----------
        //String reasonPhrase = SIPResponse.getReasonPhrase(statusCode);
        //return this.createResponse(statusCode, reasonPhrase);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.590 -0400", hash_original_method = "4F64A0C3F2C04A008F76D91B875DAC0D", hash_generated_method = "CE00FE66C817650BA3502EFD8A18B0AD")
    public SIPResponse createResponse(int statusCode, String reasonPhrase) {
        SIPResponse varB4EAC82CA7396A68D541C85D26508E83_1110047456 = null; //Variable for return #1
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
            boolean var1440086C7F6E137687239D414F8ECC74_1761658448 = (headerIterator.hasNext());
            {
                nextHeader = (SIPHeader) headerIterator.next();
                {
                    boolean var154A7966FCDCD95D25E63CFDADBC607B_1504958997 = (nextHeader instanceof From
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
            boolean varE71367B7FC420DF364496FD57FDD6F25_897364167 = (MessageFactoryImpl.getDefaultServerHeader() != null);
            {
                newResponse.setHeader(MessageFactoryImpl.getDefaultServerHeader());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var315E7E2DABE74C9BD4384840ADC4BCCE_1046091886 = (newResponse.getStatusCode() == 100);
            {
                newResponse.getTo().removeParameter("tag");
            } //End block
        } //End collapsed parenthetic
        ServerHeader server;
        server = MessageFactoryImpl.getDefaultServerHeader();
        {
            newResponse.setHeader(server);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1110047456 = newResponse;
        addTaint(statusCode);
        addTaint(reasonPhrase.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1110047456.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1110047456;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.591 -0400", hash_original_method = "B9BF2BAEBA19E8A2F042C98E4A2B8D22", hash_generated_method = "D52B14F0A9A5869DE950D19B28F5EC85")
    private final boolean mustCopyRR( int code ) {
        {
            boolean var077A836254DECCEE29A7CCA1784E5786_1309512054 = (isDialogCreating( this.getMethod() ) && getToTag() == null);
        } //End block
        addTaint(code);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1888341348 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1888341348;
        // ---------- Original Method ----------
        //if ( code>100 && code<300 ) {
    		//return isDialogCreating( this.getMethod() ) && getToTag() == null;
    	//} else return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.615 -0400", hash_original_method = "8DA892BCFD0BDEE05EB086307BFA5229", hash_generated_method = "EB9DF591351797587F37AE134943D6A0")
    public SIPRequest createCancelRequest() throws SipException {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_1576322194 = null; //Variable for return #1
        {
            boolean var003FF941DD84787B07735917FE25C187_477850124 = (!this.getMethod().equals(Request.INVITE));
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
            boolean var3DB531AB02CB977CBC8A97A334A03D84_991675467 = (this.getRouteHeaders() != null);
            {
                cancel.setHeader((SIPHeaderList< ? >) this.getRouteHeaders().clone());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var896FD3C9C4EED86170D10D69961A19CE_1143874624 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                cancel.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1576322194 = cancel;
        varB4EAC82CA7396A68D541C85D26508E83_1576322194.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1576322194;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.631 -0400", hash_original_method = "19E2EF483A3AD0C60513AE35D850A021", hash_generated_method = "70C12581A20F5DAD678BFC0E3660F4C3")
    public SIPRequest createAckRequest(To responseToHeader) {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_1461521257 = null; //Variable for return #1
        SIPRequest newRequest;
        Iterator headerIterator;
        SIPHeader nextHeader;
        newRequest = new SIPRequest();
        newRequest.setRequestLine((RequestLine) this.requestLine.clone());
        newRequest.setMethod(Request.ACK);
        headerIterator = getHeaders();
        {
            boolean var1440086C7F6E137687239D414F8ECC74_685491459 = (headerIterator.hasNext());
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
            boolean var896FD3C9C4EED86170D10D69961A19CE_757427193 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1461521257 = newRequest;
        addTaint(responseToHeader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1461521257.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1461521257;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.632 -0400", hash_original_method = "7B881B99117D66C1BDF145A59ABEA2E4", hash_generated_method = "01CD1A1E71D2D16E1AA686CC04E794FC")
    public final SIPRequest createErrorAck(To responseToHeader) throws SipException,
            ParseException {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_1160771111 = null; //Variable for return #1
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
            boolean var3DB531AB02CB977CBC8A97A334A03D84_834812983 = (this.getRouteHeaders() != null);
            {
                newRequest.setHeader((SIPHeaderList) this.getRouteHeaders().clone());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var896FD3C9C4EED86170D10D69961A19CE_1043114359 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1160771111 = newRequest;
        addTaint(responseToHeader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1160771111.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1160771111;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.637 -0400", hash_original_method = "88B58E52E2D044E743A1ED3102F3960B", hash_generated_method = "92B21A33540F83FE53FF395F79241232")
    public SIPRequest createSIPRequest(RequestLine requestLine, boolean switchHeaders) {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_1400750788 = null; //Variable for return #1
        SIPRequest newRequest;
        newRequest = new SIPRequest();
        newRequest.requestLine = requestLine;
        Iterator<SIPHeader> headerIterator;
        headerIterator = this.getHeaders();
        {
            boolean var1440086C7F6E137687239D414F8ECC74_2040700959 = (headerIterator.hasNext());
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
            boolean var896FD3C9C4EED86170D10D69961A19CE_1485913162 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1400750788 = newRequest;
        addTaint(switchHeaders);
        varB4EAC82CA7396A68D541C85D26508E83_1400750788.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1400750788;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.641 -0400", hash_original_method = "D367B8AD3F620DA29FDBF98B146E85CC", hash_generated_method = "A1A783D9A08730F4649FC868E23D053F")
    public SIPRequest createBYERequest(boolean switchHeaders) {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_124205689 = null; //Variable for return #1
        RequestLine requestLine;
        requestLine = (RequestLine) this.requestLine.clone();
        requestLine.setMethod("BYE");
        varB4EAC82CA7396A68D541C85D26508E83_124205689 = this.createSIPRequest(requestLine, switchHeaders);
        addTaint(switchHeaders);
        varB4EAC82CA7396A68D541C85D26508E83_124205689.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_124205689;
        // ---------- Original Method ----------
        //RequestLine requestLine = (RequestLine) this.requestLine.clone();
        //requestLine.setMethod("BYE");
        //return this.createSIPRequest(requestLine, switchHeaders);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.641 -0400", hash_original_method = "F27ED260A28BC4E6AB9113A5229AE82E", hash_generated_method = "71514CD7EE9DFCED8D584C7878F783B2")
    public SIPRequest createACKRequest() {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_1949352843 = null; //Variable for return #1
        RequestLine requestLine;
        requestLine = (RequestLine) this.requestLine.clone();
        requestLine.setMethod(Request.ACK);
        varB4EAC82CA7396A68D541C85D26508E83_1949352843 = this.createSIPRequest(requestLine, false);
        varB4EAC82CA7396A68D541C85D26508E83_1949352843.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1949352843;
        // ---------- Original Method ----------
        //RequestLine requestLine = (RequestLine) this.requestLine.clone();
        //requestLine.setMethod(Request.ACK);
        //return this.createSIPRequest(requestLine, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.644 -0400", hash_original_method = "DA1F7E2B6F3093C6379A0C0D51E796B9", hash_generated_method = "EEDED98D2E85C8A094B237315F8AD111")
    public String getViaHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_655315753 = null; //Variable for return #1
        Via via;
        via = (Via) this.getViaHeaders().getFirst();
        varB4EAC82CA7396A68D541C85D26508E83_655315753 = via.getHost();
        varB4EAC82CA7396A68D541C85D26508E83_655315753.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_655315753;
        // ---------- Original Method ----------
        //Via via = (Via) this.getViaHeaders().getFirst();
        //return via.getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.645 -0400", hash_original_method = "C4DF5E381400BD9B0BACC03DD32438B3", hash_generated_method = "77D5B14DBC4757C99E6A994B254579F1")
    public int getViaPort() {
        Via via;
        via = (Via) this.getViaHeaders().getFirst();
        {
            boolean var27E48064627BFABA5E460911669067D3_1622126012 = (via.hasPort());
            int varF76A67835AC57BE66ADBC036AF6A64B8_1122712047 = (via.getPort());
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1374454675 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1374454675;
        // ---------- Original Method ----------
        //Via via = (Via) this.getViaHeaders().getFirst();
        //if (via.hasPort())
            //return via.getPort();
        //else
            //return 5060;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.651 -0400", hash_original_method = "530E19A2E500806E1A366E25A34AD0D7", hash_generated_method = "A3F0BADEFEA78F4E031AD42A241652C7")
    public String getFirstLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_1532823805 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_832743866 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1532823805 = null;
        varB4EAC82CA7396A68D541C85D26508E83_832743866 = this.requestLine.encode();
        String varA7E53CE21691AB073D9660D615818899_81377600; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_81377600 = varB4EAC82CA7396A68D541C85D26508E83_1532823805;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_81377600 = varB4EAC82CA7396A68D541C85D26508E83_832743866;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_81377600.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_81377600;
        // ---------- Original Method ----------
        //if (requestLine == null)
            //return null;
        //else
            //return this.requestLine.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.652 -0400", hash_original_method = "053882D0BB9ABEB2DEF0F19246596664", hash_generated_method = "4C4D742933C74EF62DB1838F64ED4628")
    public void setSIPVersion(String sipVersion) throws ParseException {
        {
            boolean varE966623B38FBA4E1C15009CDDDA6677E_185480683 = (sipVersion == null || !sipVersion.equalsIgnoreCase("SIP/2.0"));
            if (DroidSafeAndroidRuntime.control) throw new ParseException("sipVersion", 0);
        } //End collapsed parenthetic
        this.requestLine.setSipVersion(sipVersion);
        addTaint(sipVersion.getTaint());
        // ---------- Original Method ----------
        //if (sipVersion == null || !sipVersion.equalsIgnoreCase("SIP/2.0"))
            //throw new ParseException("sipVersion", 0);
        //this.requestLine.setSipVersion(sipVersion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.652 -0400", hash_original_method = "00EEF223B95EA2B5E1E6EED25EDEECD3", hash_generated_method = "67E9145E8D40CF41BAFA69266DAA3494")
    public String getSIPVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_1599877276 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1599877276 = this.requestLine.getSipVersion();
        varB4EAC82CA7396A68D541C85D26508E83_1599877276.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1599877276;
        // ---------- Original Method ----------
        //return this.requestLine.getSipVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.662 -0400", hash_original_method = "1671629A516F35F213CEF63536914216", hash_generated_method = "CE88EC927EEE62FF5E94A94218551BF6")
    public Object getTransaction() {
        Object varB4EAC82CA7396A68D541C85D26508E83_981511602 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_981511602 = this.transactionPointer;
        varB4EAC82CA7396A68D541C85D26508E83_981511602.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_981511602;
        // ---------- Original Method ----------
        //return this.transactionPointer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.662 -0400", hash_original_method = "29C9F28BA62C1C5D6183FC49B73B119A", hash_generated_method = "94869A7C33E91A92D8453F215213E646")
    public void setTransaction(Object transaction) {
        this.transactionPointer = transaction;
        // ---------- Original Method ----------
        //this.transactionPointer = transaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.676 -0400", hash_original_method = "D6849E418A3430D13263F7E766EC96CA", hash_generated_method = "644A3C5471F122837D2BB6883CAEA451")
    public Object getMessageChannel() {
        Object varB4EAC82CA7396A68D541C85D26508E83_259812478 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_259812478 = this.messageChannel;
        varB4EAC82CA7396A68D541C85D26508E83_259812478.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_259812478;
        // ---------- Original Method ----------
        //return this.messageChannel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.677 -0400", hash_original_method = "F021F3118E1F64B2274957A9C076266A", hash_generated_method = "35A1FA712B0E58B7E51DD40258282990")
    public void setMessageChannel(Object messageChannel) {
        this.messageChannel = messageChannel;
        // ---------- Original Method ----------
        //this.messageChannel = messageChannel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.679 -0400", hash_original_method = "5C56890151E96C66B0B2332BC1750187", hash_generated_method = "41F376361C3A688D0AF1D3059665B0B3")
    public String getMergeId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1416545542 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1132451408 = null; //Variable for return #2
        String fromTag;
        fromTag = this.getFromTag();
        String cseq;
        cseq = this.cSeqHeader.toString();
        String callId;
        callId = this.callIdHeader.getCallId();
        String requestUri;
        requestUri = this.getRequestURI().toString();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1416545542 = new StringBuffer().append(requestUri).append(":").append(fromTag).append(":").append(cseq).append(":")
                    .append(callId).toString();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1132451408 = null;
        String varA7E53CE21691AB073D9660D615818899_151338754; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_151338754 = varB4EAC82CA7396A68D541C85D26508E83_1416545542;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_151338754 = varB4EAC82CA7396A68D541C85D26508E83_1132451408;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_151338754.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_151338754;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.679 -0400", hash_original_method = "8408AE2B464881D5E749D0715A83122D", hash_generated_method = "D0FB6723A7B923AC4749917A36A0F167")
    public void setInviteTransaction(Object inviteTransaction) {
        this.inviteTransaction = inviteTransaction;
        // ---------- Original Method ----------
        //this.inviteTransaction = inviteTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.680 -0400", hash_original_method = "E74B555DC4A151C37AF9F95C34B6492D", hash_generated_method = "DC62111007042855BBDDC439C8A09215")
    public Object getInviteTransaction() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1235240563 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1235240563 = inviteTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_1235240563.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1235240563;
        // ---------- Original Method ----------
        //return inviteTransaction;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.680 -0400", hash_original_field = "AF1F2C3098CE6F5B251798F428DA7ADF", hash_generated_field = "B8561CE122A2D14C8122464C29DD1D4A")

    private static long serialVersionUID = 3360720013577322927L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.680 -0400", hash_original_field = "586FC4F17D4338737E9C91CFD70A2ADD", hash_generated_field = "92C48F1001428EFEB2EC4164921C9EB7")

    private static String DEFAULT_USER = "ip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.680 -0400", hash_original_field = "D61B4598257D50C1BE3144E43BCC41F6", hash_generated_field = "C3B122849CFA8672EB47BF0310275CC4")

    private static String DEFAULT_TRANSPORT = "udp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.680 -0400", hash_original_field = "EC71AA1577C3113BD905305C7B5E5210", hash_generated_field = "007A9B174B8F7EB4D2667D2018C73529")

    private static Set<String> targetRefreshMethods = new HashSet<String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.680 -0400", hash_original_field = "4389E28B96080601985651075AC75C26", hash_generated_field = "6F38E402D58BCF6D3BA977047908B9F1")

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

