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
    private transient Object transactionPointer;
    private RequestLine requestLine;
    private transient Object messageChannel;
    private transient Object inviteTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.104 -0400", hash_original_method = "CD96843F1E97D10004B6B61F026BE84E", hash_generated_method = "17A7559EA941598D9F8A4A095B6BE33D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPRequest() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.104 -0400", hash_original_method = "10A6E8DED0F9574AB3D1598F76906EF6", hash_generated_method = "F72D03CE5234FC2526DCA7279AACC000")
    @DSModeled(DSC.SAFE)
    public RequestLine getRequestLine() {
        return (RequestLine)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return requestLine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.104 -0400", hash_original_method = "B9CB3F60AB911F16367336645DE9DCA3", hash_generated_method = "E4D5929AF3FE177F5764FF53C898EB06")
    @DSModeled(DSC.SAFE)
    public void setRequestLine(RequestLine requestLine) {
        dsTaint.addTaint(requestLine.dsTaint);
        // ---------- Original Method ----------
        //this.requestLine = requestLine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.105 -0400", hash_original_method = "38B14A3222BE2105E2C0F39A9CA63E55", hash_generated_method = "F81691B9EBD9F97102868231249DC7E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String debugDump() {
        String superstring;
        superstring = super.debugDump();
        stringRepresentation = "";
        sprint(SIPRequest.class.getName());
        sprint("{");
        sprint(requestLine.debugDump());
        sprint(superstring);
        sprint("}");
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.106 -0400", hash_original_method = "45144F3B633868FAD50525AF05DB3D15", hash_generated_method = "2AA6FAC3BE31953ECE33877E746EC0F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void checkHeaders() throws ParseException {
        String prefix;
        prefix = "Missing a required header : ";
        {
            boolean var6342A96FD7DE6C1AD71DF5E6F041816B_1740889529 = (getCSeq() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + CSeqHeader.NAME, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var028720CEB12D4FCC08D30523F58E270F_1996113770 = (getTo() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + ToHeader.NAME, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA4C07F37F4DEE003A91119A5E25F4D42_1870568562 = (this.callIdHeader == null || this.callIdHeader.getCallId() == null
                || callIdHeader.getCallId().equals(""));
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + CallIdHeader.NAME, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var59B1519B8C7900F9210D51C7E88064B0_2038122001 = (getFrom() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + FromHeader.NAME, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCE8B10FB91FF6C0A5E135CD4C2A83BAD_488907168 = (getViaHeaders() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + ViaHeader.NAME, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var292458B06CDBCC788CBB5739EE0BF2D9_822850383 = (getTopmostVia() == null);
            if (DroidSafeAndroidRuntime.control) throw new ParseException("No via header in request! ", 0);
        } //End collapsed parenthetic
        {
            boolean varBCC3B65263B4D2C7C3C710D19F9F559A_439898782 = (getMethod().equals(Request.NOTIFY));
            {
                {
                    boolean var348C543D718BA18069EA2B0B9CD973FF_249895193 = (getHeader(SubscriptionStateHeader.NAME) == null);
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + SubscriptionStateHeader.NAME, 0);
                } //End collapsed parenthetic
                {
                    boolean var3EC878BA20DA34D196AFE3B13F74EFD8_96687547 = (getHeader(EventHeader.NAME) == null);
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + EventHeader.NAME, 0);
                } //End collapsed parenthetic
            } //End block
            {
                boolean var01A575B4428128F8CCED27EB67F4502F_1347084700 = (getMethod().equals(Request.PUBLISH));
                {
                    {
                        boolean var9652A5554F950E03E4043C0D502B519A_174400347 = (getHeader(EventHeader.NAME) == null);
                        if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + EventHeader.NAME, 0);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean var2E3231C6B811CD5BDE653D17B9D491D1_1232603758 = (requestLine.getMethod().equals(Request.INVITE)
                || requestLine.getMethod().equals(Request.SUBSCRIBE)
                || requestLine.getMethod().equals(Request.REFER));
            {
                {
                    boolean var871ACE9F2BC9EA9EE286F28B85BC3666_412875509 = (this.getContactHeader() == null);
                    {
                        {
                            boolean var92D8C540B966996D1D76EDC3A718669C_1838664009 = (this.getToTag() == null);
                            if (DroidSafeAndroidRuntime.control) throw new ParseException(prefix + ContactHeader.NAME, 0);
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var52A3B9A52C79C136908CBC40D09DC6B6_1487761417 = (requestLine.getUri() instanceof SipUri);
                    {
                        String scheme;
                        scheme = ((SipUri) requestLine.getUri()).getScheme();
                        {
                            boolean var95624149895EEF611065487097ED967B_1389589655 = ("sips".equalsIgnoreCase(scheme));
                            {
                                SipUri sipUri;
                                sipUri = (SipUri) this.getContactHeader().getAddress().getURI();
                                {
                                    boolean var45030BE7A36FEB306DE64ECBDD520486_1418038694 = (!sipUri.getScheme().equals("sips"));
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
            boolean varE94317BC12B8BC816E0A83D7C9CEFE95_1822806925 = (this.getContactHeader() == null
                && (this.getMethod().equals(Request.INVITE)
                        || this.getMethod().equals(Request.REFER) || this.getMethod().equals(
                        Request.SUBSCRIBE)));
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Contact Header is Mandatory for a SIP INVITE", 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF91EA73B7515A8CA1C091BD18727A961_1675947474 = (requestLine != null && requestLine.getMethod() != null
                && getCSeq().getMethod() != null
                && requestLine.getMethod().compareTo(getCSeq().getMethod()) != 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("CSEQ method mismatch with  Request-Line ", 0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.106 -0400", hash_original_method = "B439ED3271619C5D642106B24B6F8DC7", hash_generated_method = "D9F834503932CB60367EA3A758DA4386")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setDefaults() {
        String method;
        method = requestLine.getMethod();
        GenericURI u;
        u = requestLine.getUri();
        {
            boolean var013184272FD98399DAFD4719701E8C72_620744827 = (method.compareTo(Request.REGISTER) == 0 || method.compareTo(Request.INVITE) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.106 -0400", hash_original_method = "ADE7B9A9349FBC47EE36B154FB701376", hash_generated_method = "1EA6B6F56F0718B063C62BDDDF3E9F14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.106 -0400", hash_original_method = "A3406866B9B5846BB9675C9F68E4252E", hash_generated_method = "E9B853E659843F083B5941BBC3A58C35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.address.URI getRequestURI() {
        javax.sip.address.URI var274799A45C350FBD9B32EBF197F780CC_1757857610 = ((javax.sip.address.URI) this.requestLine.getUri());
        return (javax.sip.address.URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this.requestLine == null)
            //return null;
        //else
            //return (javax.sip.address.URI) this.requestLine.getUri();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.107 -0400", hash_original_method = "9E5CBCE30B3652DB4124768C08B76945", hash_generated_method = "D4BCFD416086A60D967535A1F45524B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRequestURI(URI uri) {
        dsTaint.addTaint(uri.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null request URI");
        } //End block
        {
            this.requestLine = new RequestLine();
        } //End block
        this.requestLine.setUri((GenericURI) uri);
        this.nullRequest = false;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.107 -0400", hash_original_method = "EB488472F269B62C6CA4000BD2F13691", hash_generated_method = "1651C627070BD3E553F5E3B8A88C6CD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMethod(String method) {
        dsTaint.addTaint(method);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.107 -0400", hash_original_method = "56F7F917AEB0D8ED6BCAD35E03BA3E4E", hash_generated_method = "852815970F7D7CFBFA687D3516B5E10E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMethod() {
        String varEC057380A8D747A1D53A40C57AF0BAE7_1770773663 = (requestLine.getMethod());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (requestLine == null)
            //return null;
        //else
            //return requestLine.getMethod();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.107 -0400", hash_original_method = "A6E50A0D416AE1599A173132FA575828", hash_generated_method = "EF24515C1D568ED1A541C9EAB91ECC22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String retval;
        {
            this.setRequestLineDefaults();
            retval = requestLine.encode() + super.encode();
        } //End block
        {
            boolean var2826E038A84582C8F51AAE38820F51B2_694793457 = (this.isNullRequest());
            {
                retval = "\r\n\r\n";
            } //End block
            {
                retval = super.encode();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.108 -0400", hash_original_method = "6C6F96FB15913D1AD047295FEBDE6F36", hash_generated_method = "05166272350CFA816B7E762488CB5318")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeMessage() {
        String retval;
        {
            this.setRequestLineDefaults();
            retval = requestLine.encode() + super.encodeSIPHeaders();
        } //End block
        {
            boolean var2826E038A84582C8F51AAE38820F51B2_1357483941 = (this.isNullRequest());
            {
                retval = "\r\n\r\n";
            } //End block
            retval = super.encodeSIPHeaders();
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.108 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "B0AB261167C995B62D10865542B321CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var002E8E97D996E9DD2E7B0E1B0BD6187C_1980938363 = (this.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.108 -0400", hash_original_method = "A6367075CC534F28F93FAF1E0E79C3E5", hash_generated_method = "8A8B52345DE4CAA2D91FD93A733FE639")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        SIPRequest retval;
        retval = (SIPRequest) super.clone();
        retval.transactionPointer = null;
        retval.requestLine = (RequestLine) this.requestLine.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SIPRequest retval = (SIPRequest) super.clone();
        //retval.transactionPointer = null;
        //if (this.requestLine != null)
            //retval.requestLine = (RequestLine) this.requestLine.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.108 -0400", hash_original_method = "9D04458788C457FA55EEFE59B9790011", hash_generated_method = "EEE839089625254E03DE3D7347C1F7C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_1844961780 = (!this.getClass().equals(other.getClass()));
        } //End collapsed parenthetic
        SIPRequest that;
        that = (SIPRequest) other;
        boolean var5416E6F50E239486726CCD9DC982D290_1850027461 = (requestLine.equals(that.requestLine) && super.equals(other));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!this.getClass().equals(other.getClass()))
            //return false;
        //SIPRequest that = (SIPRequest) other;
        //return requestLine.equals(that.requestLine) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.109 -0400", hash_original_method = "6E8F0447EF83A5DA6D1DCD59FBFB3047", hash_generated_method = "8318E5072C28E4C279BE8BD018B0B6AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedList getMessageAsEncodedStrings() {
        LinkedList retval;
        retval = super.getMessageAsEncodedStrings();
        {
            this.setRequestLineDefaults();
            retval.addFirst(requestLine.encode());
        } //End block
        return (LinkedList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LinkedList retval = super.getMessageAsEncodedStrings();
        //if (requestLine != null) {
            //this.setRequestLineDefaults();
            //retval.addFirst(requestLine.encode());
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.109 -0400", hash_original_method = "8262152376D5F60373B8E0AFA26377AD", hash_generated_method = "9551B535137C28E13FF7913191083292")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean match(Object matchObj) {
        dsTaint.addTaint(matchObj.dsTaint);
        {
            boolean varE5ABD91269B098FDB02552058FE738E0_280327682 = (!matchObj.getClass().equals(this.getClass()));
            {
                boolean var3D06C934D988FBFEA9FF217EEB1CEB0C_857986535 = (matchObj == this);
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        SIPRequest that;
        that = (SIPRequest) matchObj;
        RequestLine rline;
        rline = that.requestLine;
        boolean var6F0A9113B429A383C35EED8AD8F98AAE_623008680 = (super.match(matchObj));
        boolean varE74623C3A1280A38A25E43201CF1F802_822929807 = (requestLine.match(that.requestLine) && super.match(matchObj));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.109 -0400", hash_original_method = "0EFA7CFB1786F9D68807C88E11C4B131", hash_generated_method = "0C19C0BA59B9912609BDEA54CFDFCE03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDialogId(boolean isServer) {
        dsTaint.addTaint(isServer);
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
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_302020666 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var1BE29C19B15B07BF37F624C6B7042CDF_699885210 = (to.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(to.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var1BE29C19B15B07BF37F624C6B7042CDF_1679044082 = (to.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(to.getTag());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_188142840 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        String var83C56777869B6188025C813E0B2FBE18_1258189950 = (retval.toString().toLowerCase());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.110 -0400", hash_original_method = "08CF48833A43F9A889E4DE3BC734C868", hash_generated_method = "C8BE741065C1FAD49B107E4DC080FD65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDialogId(boolean isServer, String toTag) {
        dsTaint.addTaint(toTag);
        dsTaint.addTaint(isServer);
        From from;
        from = (From) this.getFrom();
        CallID cid;
        cid = (CallID) this.getCallId();
        StringBuffer retval;
        retval = new StringBuffer(cid.getCallId());
        {
            {
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_1238459340 = (from.getTag() != null);
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
                boolean var9C3AFB15083CBFB9F65BF5E8DAA1CA8D_1627974211 = (from.getTag() != null);
                {
                    retval.append(COLON);
                    retval.append(from.getTag());
                } //End block
            } //End collapsed parenthetic
        } //End block
        String var83C56777869B6188025C813E0B2FBE18_2090521032 = (retval.toString().toLowerCase());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.110 -0400", hash_original_method = "2AE1DB426BA66F196E718F42EC30B693", hash_generated_method = "530F3DFC86C721A75D30276A2821D76B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] encodeAsBytes(String transport) {
        dsTaint.addTaint(transport);
        {
            boolean var2826E038A84582C8F51AAE38820F51B2_172335613 = (this.isNullRequest());
            {
                byte[] varEEF83FE8F2414029AB57C6129B64128C_1978721466 = ("\r\n\r\n".getBytes());
            } //End block
            {
                byte[] varBE3FB34956974956A0E259C2754046A5_1024169627 = (new byte[0]);
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
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.111 -0400", hash_original_method = "1C55C0FE8476C30A968193AA8AE54F83", hash_generated_method = "C8DC67A4BCAC172E882DB63C19CE15B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPResponse createResponse(int statusCode) {
        dsTaint.addTaint(statusCode);
        String reasonPhrase;
        reasonPhrase = SIPResponse.getReasonPhrase(statusCode);
        SIPResponse varED22FD73F0C9877412D6646C11A06FCB_1251465484 = (this.createResponse(statusCode, reasonPhrase));
        return (SIPResponse)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String reasonPhrase = SIPResponse.getReasonPhrase(statusCode);
        //return this.createResponse(statusCode, reasonPhrase);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.111 -0400", hash_original_method = "4F64A0C3F2C04A008F76D91B875DAC0D", hash_generated_method = "1A1D8AA4897F3DCFB41659B04ADEB161")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPResponse createResponse(int statusCode, String reasonPhrase) {
        dsTaint.addTaint(statusCode);
        dsTaint.addTaint(reasonPhrase);
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
            boolean var1440086C7F6E137687239D414F8ECC74_1087010476 = (headerIterator.hasNext());
            {
                nextHeader = (SIPHeader) headerIterator.next();
                {
                    boolean var154A7966FCDCD95D25E63CFDADBC607B_549661590 = (nextHeader instanceof From
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
            boolean varE71367B7FC420DF364496FD57FDD6F25_68746717 = (MessageFactoryImpl.getDefaultServerHeader() != null);
            {
                newResponse.setHeader(MessageFactoryImpl.getDefaultServerHeader());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var315E7E2DABE74C9BD4384840ADC4BCCE_1539931183 = (newResponse.getStatusCode() == 100);
            {
                newResponse.getTo().removeParameter("tag");
            } //End block
        } //End collapsed parenthetic
        ServerHeader server;
        server = MessageFactoryImpl.getDefaultServerHeader();
        {
            newResponse.setHeader(server);
        } //End block
        return (SIPResponse)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.111 -0400", hash_original_method = "B9BF2BAEBA19E8A2F042C98E4A2B8D22", hash_generated_method = "AF9E8B5684FE87CD979E36CD42C197F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final boolean mustCopyRR( int code ) {
        dsTaint.addTaint(code);
        {
            boolean var077A836254DECCEE29A7CCA1784E5786_1744603169 = (isDialogCreating( this.getMethod() ) && getToTag() == null);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if ( code>100 && code<300 ) {
    		//return isDialogCreating( this.getMethod() ) && getToTag() == null;
    	//} else return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.112 -0400", hash_original_method = "8DA892BCFD0BDEE05EB086307BFA5229", hash_generated_method = "B20CD257D99F5D5794DE5769B32860D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPRequest createCancelRequest() throws SipException {
        {
            boolean var003FF941DD84787B07735917FE25C187_1255149996 = (!this.getMethod().equals(Request.INVITE));
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
            boolean var3DB531AB02CB977CBC8A97A334A03D84_1915635434 = (this.getRouteHeaders() != null);
            {
                cancel.setHeader((SIPHeaderList< ? >) this.getRouteHeaders().clone());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var896FD3C9C4EED86170D10D69961A19CE_1957066522 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                cancel.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        return (SIPRequest)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.113 -0400", hash_original_method = "19E2EF483A3AD0C60513AE35D850A021", hash_generated_method = "A12F27B17CD33D1950C53881D1471C4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPRequest createAckRequest(To responseToHeader) {
        dsTaint.addTaint(responseToHeader.dsTaint);
        SIPRequest newRequest;
        Iterator headerIterator;
        SIPHeader nextHeader;
        newRequest = new SIPRequest();
        newRequest.setRequestLine((RequestLine) this.requestLine.clone());
        newRequest.setMethod(Request.ACK);
        headerIterator = getHeaders();
        {
            boolean var1440086C7F6E137687239D414F8ECC74_2099143912 = (headerIterator.hasNext());
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
            boolean var896FD3C9C4EED86170D10D69961A19CE_8550660 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        return (SIPRequest)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.113 -0400", hash_original_method = "7B881B99117D66C1BDF145A59ABEA2E4", hash_generated_method = "0ACDB4752F7F589CD670064F7DEACC41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final SIPRequest createErrorAck(To responseToHeader) throws SipException,
            ParseException {
        dsTaint.addTaint(responseToHeader.dsTaint);
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
            boolean var3DB531AB02CB977CBC8A97A334A03D84_1870971441 = (this.getRouteHeaders() != null);
            {
                newRequest.setHeader((SIPHeaderList) this.getRouteHeaders().clone());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var896FD3C9C4EED86170D10D69961A19CE_469046172 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        return (SIPRequest)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.114 -0400", hash_original_method = "88B58E52E2D044E743A1ED3102F3960B", hash_generated_method = "C267ED3DA0F2273DB2F534041B0085C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPRequest createSIPRequest(RequestLine requestLine, boolean switchHeaders) {
        dsTaint.addTaint(requestLine.dsTaint);
        dsTaint.addTaint(switchHeaders);
        SIPRequest newRequest;
        newRequest = new SIPRequest();
        newRequest.requestLine = requestLine;
        Iterator<SIPHeader> headerIterator;
        headerIterator = this.getHeaders();
        {
            boolean var1440086C7F6E137687239D414F8ECC74_1173908718 = (headerIterator.hasNext());
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
            boolean var896FD3C9C4EED86170D10D69961A19CE_783620595 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        return (SIPRequest)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.114 -0400", hash_original_method = "D367B8AD3F620DA29FDBF98B146E85CC", hash_generated_method = "BFF8CDF6E81CFBC07EB7B11D808D5404")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPRequest createBYERequest(boolean switchHeaders) {
        dsTaint.addTaint(switchHeaders);
        RequestLine requestLine;
        requestLine = (RequestLine) this.requestLine.clone();
        requestLine.setMethod("BYE");
        SIPRequest var048F62D46148E7E53A0CC5AEBC80048E_697269330 = (this.createSIPRequest(requestLine, switchHeaders));
        return (SIPRequest)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RequestLine requestLine = (RequestLine) this.requestLine.clone();
        //requestLine.setMethod("BYE");
        //return this.createSIPRequest(requestLine, switchHeaders);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.114 -0400", hash_original_method = "F27ED260A28BC4E6AB9113A5229AE82E", hash_generated_method = "CFB6EE57803EB0934A745DC7DA39748D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPRequest createACKRequest() {
        RequestLine requestLine;
        requestLine = (RequestLine) this.requestLine.clone();
        requestLine.setMethod(Request.ACK);
        SIPRequest var709238CFD690616822FD248D207A911D_381019455 = (this.createSIPRequest(requestLine, false));
        return (SIPRequest)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RequestLine requestLine = (RequestLine) this.requestLine.clone();
        //requestLine.setMethod(Request.ACK);
        //return this.createSIPRequest(requestLine, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.114 -0400", hash_original_method = "DA1F7E2B6F3093C6379A0C0D51E796B9", hash_generated_method = "AED76D1E440DA963B9B56FB6E8D53259")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getViaHost() {
        Via via;
        via = (Via) this.getViaHeaders().getFirst();
        String varCFE655FEDCA8A8C007E7DAE5868DF08A_1882787281 = (via.getHost());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Via via = (Via) this.getViaHeaders().getFirst();
        //return via.getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.115 -0400", hash_original_method = "C4DF5E381400BD9B0BACC03DD32438B3", hash_generated_method = "163A3FD21916E32ECA6C77AD5DA3EAE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getViaPort() {
        Via via;
        via = (Via) this.getViaHeaders().getFirst();
        {
            boolean var27E48064627BFABA5E460911669067D3_560051073 = (via.hasPort());
            int varF76A67835AC57BE66ADBC036AF6A64B8_1878437523 = (via.getPort());
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Via via = (Via) this.getViaHeaders().getFirst();
        //if (via.hasPort())
            //return via.getPort();
        //else
            //return 5060;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.115 -0400", hash_original_method = "530E19A2E500806E1A366E25A34AD0D7", hash_generated_method = "F52F75856B840E2C047FA4F026904102")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getFirstLine() {
        String varA5A7173F6FBAFA432FECD5E31CDCDD6F_1860243029 = (this.requestLine.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (requestLine == null)
            //return null;
        //else
            //return this.requestLine.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.115 -0400", hash_original_method = "053882D0BB9ABEB2DEF0F19246596664", hash_generated_method = "20252141480B2819BFCBEE256D69D104")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSIPVersion(String sipVersion) throws ParseException {
        dsTaint.addTaint(sipVersion);
        {
            boolean varE966623B38FBA4E1C15009CDDDA6677E_1381959226 = (sipVersion == null || !sipVersion.equalsIgnoreCase("SIP/2.0"));
            if (DroidSafeAndroidRuntime.control) throw new ParseException("sipVersion", 0);
        } //End collapsed parenthetic
        this.requestLine.setSipVersion(sipVersion);
        // ---------- Original Method ----------
        //if (sipVersion == null || !sipVersion.equalsIgnoreCase("SIP/2.0"))
            //throw new ParseException("sipVersion", 0);
        //this.requestLine.setSipVersion(sipVersion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.115 -0400", hash_original_method = "00EEF223B95EA2B5E1E6EED25EDEECD3", hash_generated_method = "056E57705B09ADD9E90C82F2621BB9A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSIPVersion() {
        String varF55EF9D522BACF5455CE2471B255FD71_777252927 = (this.requestLine.getSipVersion());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.requestLine.getSipVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.115 -0400", hash_original_method = "1671629A516F35F213CEF63536914216", hash_generated_method = "1957F853C2DA6F2CCA85F4DA44860BAE")
    @DSModeled(DSC.SAFE)
    public Object getTransaction() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.transactionPointer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.116 -0400", hash_original_method = "29C9F28BA62C1C5D6183FC49B73B119A", hash_generated_method = "D1E54D4D46FAE2A9E5B2953CE842EE3F")
    @DSModeled(DSC.SAFE)
    public void setTransaction(Object transaction) {
        dsTaint.addTaint(transaction.dsTaint);
        // ---------- Original Method ----------
        //this.transactionPointer = transaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.116 -0400", hash_original_method = "D6849E418A3430D13263F7E766EC96CA", hash_generated_method = "598FFAF6764FC6459CA0CB8DC5DEF090")
    @DSModeled(DSC.SAFE)
    public Object getMessageChannel() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.messageChannel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.116 -0400", hash_original_method = "F021F3118E1F64B2274957A9C076266A", hash_generated_method = "4C26E09B11476313D868231445CD39B0")
    @DSModeled(DSC.SAFE)
    public void setMessageChannel(Object messageChannel) {
        dsTaint.addTaint(messageChannel.dsTaint);
        // ---------- Original Method ----------
        //this.messageChannel = messageChannel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.116 -0400", hash_original_method = "5C56890151E96C66B0B2332BC1750187", hash_generated_method = "FE13AAD67E7B383174AF6C39E6433C6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMergeId() {
        String fromTag;
        fromTag = this.getFromTag();
        String cseq;
        cseq = this.cSeqHeader.toString();
        String callId;
        callId = this.callIdHeader.getCallId();
        String requestUri;
        requestUri = this.getRequestURI().toString();
        {
            String var6F5C05B7B004EBE6650F82448ABD7966_1904163104 = (new StringBuffer().append(requestUri).append(":").append(fromTag).append(":").append(cseq).append(":")
                    .append(callId).toString());
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.116 -0400", hash_original_method = "8408AE2B464881D5E749D0715A83122D", hash_generated_method = "43B59C208917D973B6599A7D2595FCED")
    @DSModeled(DSC.SAFE)
    public void setInviteTransaction(Object inviteTransaction) {
        dsTaint.addTaint(inviteTransaction.dsTaint);
        // ---------- Original Method ----------
        //this.inviteTransaction = inviteTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.117 -0400", hash_original_method = "E74B555DC4A151C37AF9F95C34B6492D", hash_generated_method = "D33951E0B679AEC520352050AF5AC008")
    @DSModeled(DSC.SAFE)
    public Object getInviteTransaction() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return inviteTransaction;
    }

    
    private static final long serialVersionUID = 3360720013577322927L;
    private static final String DEFAULT_USER = "ip";
    private static final String DEFAULT_TRANSPORT = "udp";
    private static final Set<String> targetRefreshMethods = new HashSet<String>();
    private static final Hashtable<String, String> nameTable = new Hashtable<String, String>();
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

