package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.358 -0400", hash_original_field = "12492E2615AAEE902567F83B53B51169", hash_generated_field = "35845A8B5E63218306C5DA0C937C70A8")

    private transient Object transactionPointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.358 -0400", hash_original_field = "776431FA890572AB0ADBBE09FE6DD67A", hash_generated_field = "583EB683C8DCDB7E0E7B7B105FE10943")

    private RequestLine requestLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.358 -0400", hash_original_field = "503A2A9D99828334753B8F3F6A4C7555", hash_generated_field = "5B17DBC4CAC28991AA6B7114D96A7324")

    private transient Object messageChannel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.358 -0400", hash_original_field = "812E50456F3CD0D4A6427367F4222311", hash_generated_field = "576FE03392171B0B1591DDE2C13574A7")

    private transient Object inviteTransaction;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.359 -0400", hash_original_method = "CD96843F1E97D10004B6B61F026BE84E", hash_generated_method = "17A7559EA941598D9F8A4A095B6BE33D")
    public  SIPRequest() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    private static void putName(String name) {
        nameTable.put(name, name);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isTargetRefresh(String ucaseMethod) {
        return targetRefreshMethods.contains(ucaseMethod);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isDialogCreating(String ucaseMethod) {
        return SIPTransactionStack.isDialogCreated(ucaseMethod);
    }

    
    @DSModeled(DSC.SAFE)
    public static String getCannonicalName(String method) {
        if (nameTable.containsKey(method))
            return (String) nameTable.get(method);
        else
            return method;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.360 -0400", hash_original_method = "10A6E8DED0F9574AB3D1598F76906EF6", hash_generated_method = "C57861E9BDC32A4E28B6DF207718DB1E")
    public RequestLine getRequestLine() {
RequestLine varF7EDF5B98BAB0E7B914DCBBC870E6D6E_178681944 =         requestLine;
        varF7EDF5B98BAB0E7B914DCBBC870E6D6E_178681944.addTaint(taint);
        return varF7EDF5B98BAB0E7B914DCBBC870E6D6E_178681944;
        // ---------- Original Method ----------
        //return requestLine;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.360 -0400", hash_original_method = "B9CB3F60AB911F16367336645DE9DCA3", hash_generated_method = "058C4665ACE5103972748C3D479B673A")
    public void setRequestLine(RequestLine requestLine) {
        this.requestLine = requestLine;
        // ---------- Original Method ----------
        //this.requestLine = requestLine;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.361 -0400", hash_original_method = "38B14A3222BE2105E2C0F39A9CA63E55", hash_generated_method = "B57D260E0BAA91440EBFA6FCB34B5874")
    public String debugDump() {
        String superstring = super.debugDump();
        stringRepresentation = "";
        sprint(SIPRequest.class.getName());
        sprint("{");
        if(requestLine != null)        
        sprint(requestLine.debugDump());
        sprint(superstring);
        sprint("}");
String var8D11C2D110975896438D6F91C60E6D6F_1591694122 =         stringRepresentation;
        var8D11C2D110975896438D6F91C60E6D6F_1591694122.addTaint(taint);
        return var8D11C2D110975896438D6F91C60E6D6F_1591694122;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.362 -0400", hash_original_method = "45144F3B633868FAD50525AF05DB3D15", hash_generated_method = "A917C33E2EB9224F3067200FC8F074F0")
    public void checkHeaders() throws ParseException {
        String prefix = "Missing a required header : ";
        if(getCSeq() == null)        
        {
            ParseException varA9A820E0A0E32C7B9442FCCFC4701EC7_87649836 = new ParseException(prefix + CSeqHeader.NAME, 0);
            varA9A820E0A0E32C7B9442FCCFC4701EC7_87649836.addTaint(taint);
            throw varA9A820E0A0E32C7B9442FCCFC4701EC7_87649836;
        } //End block
        if(getTo() == null)        
        {
            ParseException var1BC36B290B9DDB8008609B20FA633261_106239286 = new ParseException(prefix + ToHeader.NAME, 0);
            var1BC36B290B9DDB8008609B20FA633261_106239286.addTaint(taint);
            throw var1BC36B290B9DDB8008609B20FA633261_106239286;
        } //End block
        if(this.callIdHeader == null || this.callIdHeader.getCallId() == null
                || callIdHeader.getCallId().equals(""))        
        {
            ParseException var1E5762C83830AB358C8BAAF400C44560_838200749 = new ParseException(prefix + CallIdHeader.NAME, 0);
            var1E5762C83830AB358C8BAAF400C44560_838200749.addTaint(taint);
            throw var1E5762C83830AB358C8BAAF400C44560_838200749;
        } //End block
        if(getFrom() == null)        
        {
            ParseException var9AE050D4A0408E018C9BE29C374F3546_650046488 = new ParseException(prefix + FromHeader.NAME, 0);
            var9AE050D4A0408E018C9BE29C374F3546_650046488.addTaint(taint);
            throw var9AE050D4A0408E018C9BE29C374F3546_650046488;
        } //End block
        if(getViaHeaders() == null)        
        {
            ParseException varE8EB15FBDC8EFEE9B618719DD1990C7F_763589726 = new ParseException(prefix + ViaHeader.NAME, 0);
            varE8EB15FBDC8EFEE9B618719DD1990C7F_763589726.addTaint(taint);
            throw varE8EB15FBDC8EFEE9B618719DD1990C7F_763589726;
        } //End block
        if(getTopmostVia() == null)        
        {
        ParseException var38285110E5FC2698E8A6C1A687A33EC8_749082747 = new ParseException("No via header in request! ", 0);
        var38285110E5FC2698E8A6C1A687A33EC8_749082747.addTaint(taint);
        throw var38285110E5FC2698E8A6C1A687A33EC8_749082747;
        }
        if(getMethod().equals(Request.NOTIFY))        
        {
            if(getHeader(SubscriptionStateHeader.NAME) == null)            
            {
            ParseException varFEE1CEB127B96D262B13247507851D90_1494404320 = new ParseException(prefix + SubscriptionStateHeader.NAME, 0);
            varFEE1CEB127B96D262B13247507851D90_1494404320.addTaint(taint);
            throw varFEE1CEB127B96D262B13247507851D90_1494404320;
            }
            if(getHeader(EventHeader.NAME) == null)            
            {
            ParseException var857E80307350F31921C89230F769C6EF_1543406431 = new ParseException(prefix + EventHeader.NAME, 0);
            var857E80307350F31921C89230F769C6EF_1543406431.addTaint(taint);
            throw var857E80307350F31921C89230F769C6EF_1543406431;
            }
        } //End block
        else
        if(getMethod().equals(Request.PUBLISH))        
        {
            if(getHeader(EventHeader.NAME) == null)            
            {
            ParseException var857E80307350F31921C89230F769C6EF_1884406681 = new ParseException(prefix + EventHeader.NAME, 0);
            var857E80307350F31921C89230F769C6EF_1884406681.addTaint(taint);
            throw var857E80307350F31921C89230F769C6EF_1884406681;
            }
        } //End block
        if(requestLine.getMethod().equals(Request.INVITE)
                || requestLine.getMethod().equals(Request.SUBSCRIBE)
                || requestLine.getMethod().equals(Request.REFER))        
        {
            if(this.getContactHeader() == null)            
            {
                if(this.getToTag() == null)                
                {
                ParseException var9E01303A9A7E6BCE01F420870E5BE671_1856549181 = new ParseException(prefix + ContactHeader.NAME, 0);
                var9E01303A9A7E6BCE01F420870E5BE671_1856549181.addTaint(taint);
                throw var9E01303A9A7E6BCE01F420870E5BE671_1856549181;
                }
            } //End block
            if(requestLine.getUri() instanceof SipUri)            
            {
                String scheme = ((SipUri) requestLine.getUri()).getScheme();
                if("sips".equalsIgnoreCase(scheme))                
                {
                    SipUri sipUri = (SipUri) this.getContactHeader().getAddress().getURI();
                    if(!sipUri.getScheme().equals("sips"))                    
                    {
                        ParseException varD89873DCBCB95CBA99791DD4730F598A_671948297 = new ParseException("Scheme for contact should be sips:" + sipUri, 0);
                        varD89873DCBCB95CBA99791DD4730F598A_671948297.addTaint(taint);
                        throw varD89873DCBCB95CBA99791DD4730F598A_671948297;
                    } //End block
                } //End block
            } //End block
        } //End block
        if(this.getContactHeader() == null
                && (this.getMethod().equals(Request.INVITE)
                        || this.getMethod().equals(Request.REFER) || this.getMethod().equals(
                        Request.SUBSCRIBE)))        
        {
            ParseException var589DB102D41C3DA6886240C82C55C977_421090048 = new ParseException("Contact Header is Mandatory for a SIP INVITE", 0);
            var589DB102D41C3DA6886240C82C55C977_421090048.addTaint(taint);
            throw var589DB102D41C3DA6886240C82C55C977_421090048;
        } //End block
        if(requestLine != null && requestLine.getMethod() != null
                && getCSeq().getMethod() != null
                && requestLine.getMethod().compareTo(getCSeq().getMethod()) != 0)        
        {
            ParseException var0DEB3EF1D978CCC02557EB08081A5FC1_337132371 = new ParseException("CSEQ method mismatch with  Request-Line ", 0);
            var0DEB3EF1D978CCC02557EB08081A5FC1_337132371.addTaint(taint);
            throw var0DEB3EF1D978CCC02557EB08081A5FC1_337132371;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.364 -0400", hash_original_method = "B439ED3271619C5D642106B24B6F8DC7", hash_generated_method = "DB85EEDA5853F156143C1DBB84462C9B")
    protected void setDefaults() {
        if(requestLine == null)        
        return;
        String method = requestLine.getMethod();
        if(method == null)        
        return;
        GenericURI u = requestLine.getUri();
        if(u == null)        
        return;
        if(method.compareTo(Request.REGISTER) == 0 || method.compareTo(Request.INVITE) == 0)        
        {
            if(u instanceof SipUri)            
            {
                SipUri sipUri = (SipUri) u;
                sipUri.setUserParam(DEFAULT_USER);
                try 
                {
                    sipUri.setTransportParam(DEFAULT_TRANSPORT);
                } //End block
                catch (ParseException ex)
                {
                } //End block
            } //End block
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.365 -0400", hash_original_method = "ADE7B9A9349FBC47EE36B154FB701376", hash_generated_method = "DD57835DF62B777CF343250A63D157AE")
    protected void setRequestLineDefaults() {
        String method = requestLine.getMethod();
        if(method == null)        
        {
            CSeq cseq = (CSeq) this.getCSeq();
            if(cseq != null)            
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.365 -0400", hash_original_method = "A3406866B9B5846BB9675C9F68E4252E", hash_generated_method = "99E755FADF0815A6D2967D966214CB3E")
    public javax.sip.address.URI getRequestURI() {
        if(this.requestLine == null)        
        {
javax.sip.address.URI var540C13E9E156B687226421B24F2DF178_1344039335 =         null;
        var540C13E9E156B687226421B24F2DF178_1344039335.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1344039335;
        }
        else
        {
javax.sip.address.URI var82D1C2C46F8CAC913B42419B02F7BB1D_1898475717 =         (javax.sip.address.URI) this.requestLine.getUri();
        var82D1C2C46F8CAC913B42419B02F7BB1D_1898475717.addTaint(taint);
        return var82D1C2C46F8CAC913B42419B02F7BB1D_1898475717;
        }
        // ---------- Original Method ----------
        //if (this.requestLine == null)
            //return null;
        //else
            //return (javax.sip.address.URI) this.requestLine.getUri();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.366 -0400", hash_original_method = "9E5CBCE30B3652DB4124768C08B76945", hash_generated_method = "C25F872189C6C220F890A228EEDFA40F")
    public void setRequestURI(URI uri) {
        addTaint(uri.getTaint());
        if(uri == null)        
        {
            NullPointerException var625B768A699E05B1A5EF3FD69B844C69_1266582429 = new NullPointerException("Null request URI");
            var625B768A699E05B1A5EF3FD69B844C69_1266582429.addTaint(taint);
            throw var625B768A699E05B1A5EF3FD69B844C69_1266582429;
        } //End block
        if(this.requestLine == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.366 -0400", hash_original_method = "EB488472F269B62C6CA4000BD2F13691", hash_generated_method = "751854308DB9B65DAB0336B36D8FE893")
    public void setMethod(String method) {
        addTaint(method.getTaint());
        if(method == null)        
        {
        IllegalArgumentException var15F9074B3EC1494748127322B39E7E4F_1123778810 = new IllegalArgumentException("null method");
        var15F9074B3EC1494748127322B39E7E4F_1123778810.addTaint(taint);
        throw var15F9074B3EC1494748127322B39E7E4F_1123778810;
        }
        if(this.requestLine == null)        
        {
            this.requestLine = new RequestLine();
        } //End block
        String meth = getCannonicalName(method);
        this.requestLine.setMethod(meth);
        if(this.cSeqHeader != null)        
        {
            try 
            {
                this.cSeqHeader.setMethod(meth);
            } //End block
            catch (ParseException e)
            {
            } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.367 -0400", hash_original_method = "56F7F917AEB0D8ED6BCAD35E03BA3E4E", hash_generated_method = "1FD36208F99D76989575F4C6244DCC29")
    public String getMethod() {
        if(requestLine == null)        
        {
String var540C13E9E156B687226421B24F2DF178_954161826 =         null;
        var540C13E9E156B687226421B24F2DF178_954161826.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_954161826;
        }
        else
        {
String var67F3F913E795E55F2CE17E60A841C008_1807884898 =         requestLine.getMethod();
        var67F3F913E795E55F2CE17E60A841C008_1807884898.addTaint(taint);
        return var67F3F913E795E55F2CE17E60A841C008_1807884898;
        }
        // ---------- Original Method ----------
        //if (requestLine == null)
            //return null;
        //else
            //return requestLine.getMethod();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.368 -0400", hash_original_method = "A6E50A0D416AE1599A173132FA575828", hash_generated_method = "4187A85A843F36A62EB93C766D0BFB34")
    public String encode() {
        String retval;
        if(requestLine != null)        
        {
            this.setRequestLineDefaults();
            retval = requestLine.encode() + super.encode();
        } //End block
        else
        if(this.isNullRequest())        
        {
            retval = "\r\n\r\n";
        } //End block
        else
        {
            retval = super.encode();
        } //End block
String varF9E19AD6135C970F387F77C6F3DE4477_392705724 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_392705724.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_392705724;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.368 -0400", hash_original_method = "6C6F96FB15913D1AD047295FEBDE6F36", hash_generated_method = "177E2D3D2099D475E869733C4AD4A597")
    public String encodeMessage() {
        String retval;
        if(requestLine != null)        
        {
            this.setRequestLineDefaults();
            retval = requestLine.encode() + super.encodeSIPHeaders();
        } //End block
        else
        if(this.isNullRequest())        
        {
            retval = "\r\n\r\n";
        } //End block
        else
        retval = super.encodeSIPHeaders();
String varF9E19AD6135C970F387F77C6F3DE4477_1149572772 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1149572772.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1149572772;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.369 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "3D2ED022DFB7C9B612962B602CAABAE5")
    public String toString() {
String varB17575D7C845B2C662583710539AAEBB_979125397 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_979125397.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_979125397;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.369 -0400", hash_original_method = "A6367075CC534F28F93FAF1E0E79C3E5", hash_generated_method = "8FF7CD63A21DF330D04E209ED56FE027")
    public Object clone() {
        SIPRequest retval = (SIPRequest) super.clone();
        retval.transactionPointer = null;
        if(this.requestLine != null)        
        retval.requestLine = (RequestLine) this.requestLine.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1035422099 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1035422099.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1035422099;
        // ---------- Original Method ----------
        //SIPRequest retval = (SIPRequest) super.clone();
        //retval.transactionPointer = null;
        //if (this.requestLine != null)
            //retval.requestLine = (RequestLine) this.requestLine.clone();
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.369 -0400", hash_original_method = "9D04458788C457FA55EEFE59B9790011", hash_generated_method = "08946AFE7E80290F6485C63D01C14B59")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(!this.getClass().equals(other.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_336425944 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2081188271 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2081188271;
        }
        SIPRequest that = (SIPRequest) other;
        boolean varB6C86F9BF5D7E279A062A5604B83A277_1944526084 = (requestLine.equals(that.requestLine) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_946925762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_946925762;
        // ---------- Original Method ----------
        //if (!this.getClass().equals(other.getClass()))
            //return false;
        //SIPRequest that = (SIPRequest) other;
        //return requestLine.equals(that.requestLine) && super.equals(other);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.369 -0400", hash_original_method = "6E8F0447EF83A5DA6D1DCD59FBFB3047", hash_generated_method = "A2FC3B1A674DD0099102119F35395149")
    public LinkedList getMessageAsEncodedStrings() {
        LinkedList retval = super.getMessageAsEncodedStrings();
        if(requestLine != null)        
        {
            this.setRequestLineDefaults();
            retval.addFirst(requestLine.encode());
        } //End block
LinkedList varF9E19AD6135C970F387F77C6F3DE4477_859737169 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_859737169.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_859737169;
        // ---------- Original Method ----------
        //LinkedList retval = super.getMessageAsEncodedStrings();
        //if (requestLine != null) {
            //this.setRequestLineDefaults();
            //retval.addFirst(requestLine.encode());
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.370 -0400", hash_original_method = "8262152376D5F60373B8E0AFA26377AD", hash_generated_method = "013AA8AD365D79FF210781620AA92232")
    public boolean match(Object matchObj) {
        addTaint(matchObj.getTaint());
        if(matchObj == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_252096661 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_806269026 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_806269026;
        }
        else
        if(!matchObj.getClass().equals(this.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1480496697 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1367108606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1367108606;
        }
        else
        if(matchObj == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_2042015606 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_992772118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_992772118;
        }
        SIPRequest that = (SIPRequest) matchObj;
        RequestLine rline = that.requestLine;
        if(this.requestLine == null && rline != null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_67863362 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1601725677 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1601725677;
        }
        else
        if(this.requestLine == rline)        
        {
        boolean var5F1371FD9204D55EBC900E55D1EA60BF_1632168248 = (super.match(matchObj));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_722764001 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_722764001;
        }
        boolean varF6B2BC8045A127E6F56113A7FC1E7EAE_825149555 = (requestLine.match(that.requestLine) && super.match(matchObj));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_941896679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_941896679;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.371 -0400", hash_original_method = "0EFA7CFB1786F9D68807C88E11C4B131", hash_generated_method = "315F145848931E967E50A3FE088249D1")
    public String getDialogId(boolean isServer) {
        addTaint(isServer);
        CallID cid = (CallID) this.getCallId();
        StringBuffer retval = new StringBuffer(cid.getCallId());
        From from = (From) this.getFrom();
        To to = (To) this.getTo();
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
String var00A359C12D3BB90F4D7EAC5F002493EE_881644176 =         retval.toString().toLowerCase();
        var00A359C12D3BB90F4D7EAC5F002493EE_881644176.addTaint(taint);
        return var00A359C12D3BB90F4D7EAC5F002493EE_881644176;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.372 -0400", hash_original_method = "08CF48833A43F9A889E4DE3BC734C868", hash_generated_method = "43C84A7A2A58CBF1FFE1EF09BF0A473B")
    public String getDialogId(boolean isServer, String toTag) {
        addTaint(toTag.getTaint());
        addTaint(isServer);
        From from = (From) this.getFrom();
        CallID cid = (CallID) this.getCallId();
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
String var00A359C12D3BB90F4D7EAC5F002493EE_293523564 =         retval.toString().toLowerCase();
        var00A359C12D3BB90F4D7EAC5F002493EE_293523564.addTaint(taint);
        return var00A359C12D3BB90F4D7EAC5F002493EE_293523564;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.373 -0400", hash_original_method = "2AE1DB426BA66F196E718F42EC30B693", hash_generated_method = "7D6565271533E3B67EADF6E8C1E5C438")
    public byte[] encodeAsBytes(String transport) {
        addTaint(transport.getTaint());
        if(this.isNullRequest())        
        {
            byte[] varA19D79F1A82AD7BAAC7F871EF0E337AC_1049408494 = ("\r\n\r\n".getBytes());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1817413775 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1817413775;
        } //End block
        else
        if(this.requestLine == null)        
        {
            byte[] var7B44E8BB9C72EAD38A6BE351B1457003_84915417 = (new byte[0]);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_518273103 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_518273103;
        } //End block
        byte[] rlbytes = null;
        if(requestLine != null)        
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
        byte[] superbytes = super.encodeAsBytes(transport);
        byte[] retval = new byte[rlbytes.length + superbytes.length];
        System.arraycopy(rlbytes, 0, retval, 0, rlbytes.length);
        System.arraycopy(superbytes, 0, retval, rlbytes.length, superbytes.length);
        byte[] var020B759ADEF679A47CB9AFE965BB2314_1779075270 = (retval);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_698126136 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_698126136;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.373 -0400", hash_original_method = "1C55C0FE8476C30A968193AA8AE54F83", hash_generated_method = "D9E1C7A93E4BC88DE953D20F2453DEF2")
    public SIPResponse createResponse(int statusCode) {
        addTaint(statusCode);
        String reasonPhrase = SIPResponse.getReasonPhrase(statusCode);
SIPResponse var604B30A12C0AAD66058E0B3499FDF292_1318883775 =         this.createResponse(statusCode, reasonPhrase);
        var604B30A12C0AAD66058E0B3499FDF292_1318883775.addTaint(taint);
        return var604B30A12C0AAD66058E0B3499FDF292_1318883775;
        // ---------- Original Method ----------
        //String reasonPhrase = SIPResponse.getReasonPhrase(statusCode);
        //return this.createResponse(statusCode, reasonPhrase);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.374 -0400", hash_original_method = "4F64A0C3F2C04A008F76D91B875DAC0D", hash_generated_method = "2A198AE8FC5424F072D6BBE1BF952C2B")
    public SIPResponse createResponse(int statusCode, String reasonPhrase) {
        addTaint(reasonPhrase.getTaint());
        addTaint(statusCode);
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
            IllegalArgumentException var35B2D737D83493AE509D8DA4C15EBB79_695235796 = new IllegalArgumentException("Bad code " + statusCode);
            var35B2D737D83493AE509D8DA4C15EBB79_695235796.addTaint(taint);
            throw var35B2D737D83493AE509D8DA4C15EBB79_695235796;
        } //End block
        if(reasonPhrase != null)        
        newResponse.setReasonPhrase(reasonPhrase);
        else
        newResponse.setReasonPhrase(SIPResponse.getReasonPhrase(statusCode));
        headerIterator = getHeaders();
        while
(headerIterator.hasNext())        
        {
            nextHeader = (SIPHeader) headerIterator.next();
            if(nextHeader instanceof From
                    || nextHeader instanceof To
                    || nextHeader instanceof ViaList
                    || nextHeader instanceof CallID
                    || (nextHeader instanceof RecordRouteList && mustCopyRR(statusCode))
                    || nextHeader instanceof CSeq
                    || nextHeader instanceof TimeStamp)            
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
        } //End block
        if(MessageFactoryImpl.getDefaultServerHeader() != null)        
        {
            newResponse.setHeader(MessageFactoryImpl.getDefaultServerHeader());
        } //End block
        if(newResponse.getStatusCode() == 100)        
        {
            newResponse.getTo().removeParameter("tag");
        } //End block
        ServerHeader server = MessageFactoryImpl.getDefaultServerHeader();
        if(server != null)        
        {
            newResponse.setHeader(server);
        } //End block
SIPResponse var2036E7FD3A3D966BDBCD4AA1915E2AF6_901504981 =         newResponse;
        var2036E7FD3A3D966BDBCD4AA1915E2AF6_901504981.addTaint(taint);
        return var2036E7FD3A3D966BDBCD4AA1915E2AF6_901504981;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.375 -0400", hash_original_method = "B9BF2BAEBA19E8A2F042C98E4A2B8D22", hash_generated_method = "7FFC272B997F1412228FABC073822499")
    private final boolean mustCopyRR( int code ) {
        addTaint(code);
        if(code>100 && code<300)        
        {
            boolean var354FCD40FE1603A5A4CEF0B633162DE0_256508630 = (isDialogCreating( this.getMethod() ) && getToTag() == null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1926183893 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1926183893;
        } //End block
        else
        {
        boolean var68934A3E9455FA72420237EB05902327_1160653971 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1902786560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1902786560;
        }
        // ---------- Original Method ----------
        //if ( code>100 && code<300 ) {
    		//return isDialogCreating( this.getMethod() ) && getToTag() == null;
    	//} else return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.375 -0400", hash_original_method = "8DA892BCFD0BDEE05EB086307BFA5229", hash_generated_method = "853EFA6EA8BC34099D4D1257E0C342E8")
    public SIPRequest createCancelRequest() throws SipException {
        if(!this.getMethod().equals(Request.INVITE))        
        {
        SipException var8C1C999B1E36CFC9DE841842A90094D4_575255724 = new SipException("Attempt to create CANCEL for " + this.getMethod());
        var8C1C999B1E36CFC9DE841842A90094D4_575255724.addTaint(taint);
        throw var8C1C999B1E36CFC9DE841842A90094D4_575255724;
        }
        SIPRequest cancel = new SIPRequest();
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
        if(this.getRouteHeaders() != null)        
        {
            cancel.setHeader((SIPHeaderList< ? >) this.getRouteHeaders().clone());
        } //End block
        if(MessageFactoryImpl.getDefaultUserAgentHeader() != null)        
        {
            cancel.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
        } //End block
SIPRequest var75803EE373E898F71DE593829D9E3AA6_68151981 =         cancel;
        var75803EE373E898F71DE593829D9E3AA6_68151981.addTaint(taint);
        return var75803EE373E898F71DE593829D9E3AA6_68151981;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.378 -0400", hash_original_method = "19E2EF483A3AD0C60513AE35D850A021", hash_generated_method = "AB261BEA59D9A9C46D4DD3DC2B725C61")
    public SIPRequest createAckRequest(To responseToHeader) {
        addTaint(responseToHeader.getTaint());
        SIPRequest newRequest;
        Iterator headerIterator;
        SIPHeader nextHeader;
        newRequest = new SIPRequest();
        newRequest.setRequestLine((RequestLine) this.requestLine.clone());
        newRequest.setMethod(Request.ACK);
        headerIterator = getHeaders();
        while
(headerIterator.hasNext())        
        {
            nextHeader = (SIPHeader) headerIterator.next();
            if(nextHeader instanceof RouteList)            
            {
                continue;
            } //End block
            else
            if(nextHeader instanceof ProxyAuthorization)            
            {
                continue;
            } //End block
            else
            if(nextHeader instanceof ContentLength)            
            {
                nextHeader = (SIPHeader) nextHeader.clone();
                try 
                {
                    ((ContentLength) nextHeader).setContentLength(0);
                } //End block
                catch (InvalidArgumentException e)
                {
                } //End block
            } //End block
            else
            if(nextHeader instanceof ContentType)            
            {
                continue;
            } //End block
            else
            if(nextHeader instanceof CSeq)            
            {
                CSeq cseq = (CSeq) nextHeader.clone();
                try 
                {
                    cseq.setMethod(Request.ACK);
                } //End block
                catch (ParseException e)
                {
                } //End block
                nextHeader = cseq;
            } //End block
            else
            if(nextHeader instanceof To)            
            {
                if(responseToHeader != null)                
                {
                    nextHeader = responseToHeader;
                } //End block
                else
                {
                    nextHeader = (SIPHeader) nextHeader.clone();
                } //End block
            } //End block
            else
            if(nextHeader instanceof ContactList || nextHeader instanceof Expires)            
            {
                continue;
            } //End block
            else
            if(nextHeader instanceof ViaList)            
            {
                nextHeader = (SIPHeader) ((ViaList) nextHeader).getFirst().clone();
            } //End block
            else
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
        if(MessageFactoryImpl.getDefaultUserAgentHeader() != null)        
        {
            newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
        } //End block
SIPRequest var843B90BB67BB5454D25E3643EF8010AB_62415544 =         newRequest;
        var843B90BB67BB5454D25E3643EF8010AB_62415544.addTaint(taint);
        return var843B90BB67BB5454D25E3643EF8010AB_62415544;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.380 -0400", hash_original_method = "7B881B99117D66C1BDF145A59ABEA2E4", hash_generated_method = "197D3478876413FF3C2985D9B1E9CD2A")
    public final SIPRequest createErrorAck(To responseToHeader) throws SipException,
            ParseException {
        addTaint(responseToHeader.getTaint());
        SIPRequest newRequest = new SIPRequest();
        newRequest.setRequestLine((RequestLine) this.requestLine.clone());
        newRequest.setMethod(Request.ACK);
        newRequest.setHeader((Header) this.callIdHeader.clone());
        newRequest.setHeader((Header) this.maxForwardsHeader.clone());
        newRequest.setHeader((Header) this.fromHeader.clone());
        newRequest.setHeader((Header) responseToHeader.clone());
        newRequest.addFirst((Header) this.getTopmostVia().clone());
        newRequest.setHeader((Header) cSeqHeader.clone());
        newRequest.getCSeq().setMethod(Request.ACK);
        if(this.getRouteHeaders() != null)        
        {
            newRequest.setHeader((SIPHeaderList) this.getRouteHeaders().clone());
        } //End block
        if(MessageFactoryImpl.getDefaultUserAgentHeader() != null)        
        {
            newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
        } //End block
SIPRequest var843B90BB67BB5454D25E3643EF8010AB_1276164156 =         newRequest;
        var843B90BB67BB5454D25E3643EF8010AB_1276164156.addTaint(taint);
        return var843B90BB67BB5454D25E3643EF8010AB_1276164156;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.381 -0400", hash_original_method = "88B58E52E2D044E743A1ED3102F3960B", hash_generated_method = "1EF94D08FF535522934F538B0BBD8A99")
    public SIPRequest createSIPRequest(RequestLine requestLine, boolean switchHeaders) {
        addTaint(switchHeaders);
        SIPRequest newRequest = new SIPRequest();
        newRequest.requestLine = requestLine;
        Iterator<SIPHeader> headerIterator = this.getHeaders();
        while
(headerIterator.hasNext())        
        {
            SIPHeader nextHeader = (SIPHeader) headerIterator.next();
            if(nextHeader instanceof CSeq)            
            {
                CSeq newCseq = (CSeq) nextHeader.clone();
                nextHeader = newCseq;
                try 
                {
                    newCseq.setMethod(requestLine.getMethod());
                } //End block
                catch (ParseException e)
                {
                } //End block
            } //End block
            else
            if(nextHeader instanceof ViaList)            
            {
                Via via = (Via) (((ViaList) nextHeader).getFirst().clone());
                via.removeParameter("branch");
                nextHeader = via;
            } //End block
            else
            if(nextHeader instanceof To)            
            {
                To to = (To) nextHeader;
                if(switchHeaders)                
                {
                    nextHeader = new From(to);
                    ((From) nextHeader).removeTag();
                } //End block
                else
                {
                    nextHeader = (SIPHeader) to.clone();
                    ((To) nextHeader).removeTag();
                } //End block
            } //End block
            else
            if(nextHeader instanceof From)            
            {
                From from = (From) nextHeader;
                if(switchHeaders)                
                {
                    nextHeader = new To(from);
                    ((To) nextHeader).removeTag();
                } //End block
                else
                {
                    nextHeader = (SIPHeader) from.clone();
                    ((From) nextHeader).removeTag();
                } //End block
            } //End block
            else
            if(nextHeader instanceof ContentLength)            
            {
                ContentLength cl = (ContentLength) nextHeader.clone();
                try 
                {
                    cl.setContentLength(0);
                } //End block
                catch (InvalidArgumentException e)
                {
                } //End block
                nextHeader = cl;
            } //End block
            else
            if(!(nextHeader instanceof CallID) && !(nextHeader instanceof MaxForwards))            
            {
                continue;
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
        if(MessageFactoryImpl.getDefaultUserAgentHeader() != null)        
        {
            newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
        } //End block
SIPRequest var843B90BB67BB5454D25E3643EF8010AB_1004679410 =         newRequest;
        var843B90BB67BB5454D25E3643EF8010AB_1004679410.addTaint(taint);
        return var843B90BB67BB5454D25E3643EF8010AB_1004679410;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.381 -0400", hash_original_method = "D367B8AD3F620DA29FDBF98B146E85CC", hash_generated_method = "7F083889BB60E1A6244F4FA487D19940")
    public SIPRequest createBYERequest(boolean switchHeaders) {
        addTaint(switchHeaders);
        RequestLine requestLine = (RequestLine) this.requestLine.clone();
        requestLine.setMethod("BYE");
SIPRequest var22841BB7FB7871ECB14B8D5C557FEE3C_1770953715 =         this.createSIPRequest(requestLine, switchHeaders);
        var22841BB7FB7871ECB14B8D5C557FEE3C_1770953715.addTaint(taint);
        return var22841BB7FB7871ECB14B8D5C557FEE3C_1770953715;
        // ---------- Original Method ----------
        //RequestLine requestLine = (RequestLine) this.requestLine.clone();
        //requestLine.setMethod("BYE");
        //return this.createSIPRequest(requestLine, switchHeaders);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.381 -0400", hash_original_method = "F27ED260A28BC4E6AB9113A5229AE82E", hash_generated_method = "E6A83595D5561743519E5A76CF1C96A7")
    public SIPRequest createACKRequest() {
        RequestLine requestLine = (RequestLine) this.requestLine.clone();
        requestLine.setMethod(Request.ACK);
SIPRequest varD118F8475DF0D13252FE657074F7D394_1647264356 =         this.createSIPRequest(requestLine, false);
        varD118F8475DF0D13252FE657074F7D394_1647264356.addTaint(taint);
        return varD118F8475DF0D13252FE657074F7D394_1647264356;
        // ---------- Original Method ----------
        //RequestLine requestLine = (RequestLine) this.requestLine.clone();
        //requestLine.setMethod(Request.ACK);
        //return this.createSIPRequest(requestLine, false);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.382 -0400", hash_original_method = "DA1F7E2B6F3093C6379A0C0D51E796B9", hash_generated_method = "B047E9BBD8CC8763ABAFE95C76164D27")
    public String getViaHost() {
        Via via = (Via) this.getViaHeaders().getFirst();
String varEBD87D88BE1B40AFA2A091E6D60A3C83_67767995 =         via.getHost();
        varEBD87D88BE1B40AFA2A091E6D60A3C83_67767995.addTaint(taint);
        return varEBD87D88BE1B40AFA2A091E6D60A3C83_67767995;
        // ---------- Original Method ----------
        //Via via = (Via) this.getViaHeaders().getFirst();
        //return via.getHost();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.382 -0400", hash_original_method = "C4DF5E381400BD9B0BACC03DD32438B3", hash_generated_method = "2938B925CB95820F50480829B1D09EB1")
    public int getViaPort() {
        Via via = (Via) this.getViaHeaders().getFirst();
        if(via.hasPort())        
        {
        int varCDC173FD1B75CC53EE8D9741B09A99A8_474487951 = (via.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125938323 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125938323;
        }
        else
        {
        int var8D749EA54F6657B0396C204D3148DA60_51005656 = (5060);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_529383101 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_529383101;
        }
        // ---------- Original Method ----------
        //Via via = (Via) this.getViaHeaders().getFirst();
        //if (via.hasPort())
            //return via.getPort();
        //else
            //return 5060;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.382 -0400", hash_original_method = "530E19A2E500806E1A366E25A34AD0D7", hash_generated_method = "AE955BC51E0EEABE484372AC580B2C39")
    public String getFirstLine() {
        if(requestLine == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1148280399 =         null;
        var540C13E9E156B687226421B24F2DF178_1148280399.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1148280399;
        }
        else
        {
String varA967887423115F0AF7BB812FE869E9D9_1991617870 =         this.requestLine.encode();
        varA967887423115F0AF7BB812FE869E9D9_1991617870.addTaint(taint);
        return varA967887423115F0AF7BB812FE869E9D9_1991617870;
        }
        // ---------- Original Method ----------
        //if (requestLine == null)
            //return null;
        //else
            //return this.requestLine.encode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.382 -0400", hash_original_method = "053882D0BB9ABEB2DEF0F19246596664", hash_generated_method = "CC77FB436B6B9B56CE7E66220CB09DC0")
    public void setSIPVersion(String sipVersion) throws ParseException {
        addTaint(sipVersion.getTaint());
        if(sipVersion == null || !sipVersion.equalsIgnoreCase("SIP/2.0"))        
        {
        ParseException var787DB968E9A10B5E944A3D016EFC0303_1219152917 = new ParseException("sipVersion", 0);
        var787DB968E9A10B5E944A3D016EFC0303_1219152917.addTaint(taint);
        throw var787DB968E9A10B5E944A3D016EFC0303_1219152917;
        }
        this.requestLine.setSipVersion(sipVersion);
        // ---------- Original Method ----------
        //if (sipVersion == null || !sipVersion.equalsIgnoreCase("SIP/2.0"))
            //throw new ParseException("sipVersion", 0);
        //this.requestLine.setSipVersion(sipVersion);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.382 -0400", hash_original_method = "00EEF223B95EA2B5E1E6EED25EDEECD3", hash_generated_method = "D286514D9AE64264090C4508D95DD20F")
    public String getSIPVersion() {
String var84054F6E17CE1C0B7AC45D2006648FD4_1591944611 =         this.requestLine.getSipVersion();
        var84054F6E17CE1C0B7AC45D2006648FD4_1591944611.addTaint(taint);
        return var84054F6E17CE1C0B7AC45D2006648FD4_1591944611;
        // ---------- Original Method ----------
        //return this.requestLine.getSipVersion();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.382 -0400", hash_original_method = "1671629A516F35F213CEF63536914216", hash_generated_method = "7B9CE5029C75F560945D297F4BF36E38")
    public Object getTransaction() {
Object var225E6401D736DDE890863AEF75AF0363_1651269820 =         this.transactionPointer;
        var225E6401D736DDE890863AEF75AF0363_1651269820.addTaint(taint);
        return var225E6401D736DDE890863AEF75AF0363_1651269820;
        // ---------- Original Method ----------
        //return this.transactionPointer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.382 -0400", hash_original_method = "29C9F28BA62C1C5D6183FC49B73B119A", hash_generated_method = "94869A7C33E91A92D8453F215213E646")
    public void setTransaction(Object transaction) {
        this.transactionPointer = transaction;
        // ---------- Original Method ----------
        //this.transactionPointer = transaction;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.382 -0400", hash_original_method = "D6849E418A3430D13263F7E766EC96CA", hash_generated_method = "F1688859F8F06CA7E12F042964FB5738")
    public Object getMessageChannel() {
Object varE139B5D6FFD6EE2F4C5160B64C296D0B_853851821 =         this.messageChannel;
        varE139B5D6FFD6EE2F4C5160B64C296D0B_853851821.addTaint(taint);
        return varE139B5D6FFD6EE2F4C5160B64C296D0B_853851821;
        // ---------- Original Method ----------
        //return this.messageChannel;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.383 -0400", hash_original_method = "F021F3118E1F64B2274957A9C076266A", hash_generated_method = "35A1FA712B0E58B7E51DD40258282990")
    public void setMessageChannel(Object messageChannel) {
        this.messageChannel = messageChannel;
        // ---------- Original Method ----------
        //this.messageChannel = messageChannel;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.383 -0400", hash_original_method = "5C56890151E96C66B0B2332BC1750187", hash_generated_method = "5C4515961D2929DCB6F65B78656D0461")
    public String getMergeId() {
        String fromTag = this.getFromTag();
        String cseq = this.cSeqHeader.toString();
        String callId = this.callIdHeader.getCallId();
        String requestUri = this.getRequestURI().toString();
        if(fromTag != null)        
        {
String var02B05F10577AE5BA2F730EECD7C9E27B_1445140678 =             new StringBuffer().append(requestUri).append(":").append(fromTag).append(":").append(cseq).append(":")
                    .append(callId).toString();
            var02B05F10577AE5BA2F730EECD7C9E27B_1445140678.addTaint(taint);
            return var02B05F10577AE5BA2F730EECD7C9E27B_1445140678;
        } //End block
        else
        {
String var540C13E9E156B687226421B24F2DF178_823146538 =         null;
        var540C13E9E156B687226421B24F2DF178_823146538.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_823146538;
        }
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.383 -0400", hash_original_method = "8408AE2B464881D5E749D0715A83122D", hash_generated_method = "D0FB6723A7B923AC4749917A36A0F167")
    public void setInviteTransaction(Object inviteTransaction) {
        this.inviteTransaction = inviteTransaction;
        // ---------- Original Method ----------
        //this.inviteTransaction = inviteTransaction;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.383 -0400", hash_original_method = "E74B555DC4A151C37AF9F95C34B6492D", hash_generated_method = "56879DF38D828D535389070B97A5C211")
    public Object getInviteTransaction() {
Object var39C25C8BDF78CD4A7A7F122E2FE15902_678388194 =         inviteTransaction;
        var39C25C8BDF78CD4A7A7F122E2FE15902_678388194.addTaint(taint);
        return var39C25C8BDF78CD4A7A7F122E2FE15902_678388194;
        // ---------- Original Method ----------
        //return inviteTransaction;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.383 -0400", hash_original_field = "AF1F2C3098CE6F5B251798F428DA7ADF", hash_generated_field = "872206405A4A16CD8A9DEDC93538CD9E")

    private static final long serialVersionUID = 3360720013577322927L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.384 -0400", hash_original_field = "586FC4F17D4338737E9C91CFD70A2ADD", hash_generated_field = "B1B406294DA224E8D851E609279BB6BD")

    private static final String DEFAULT_USER = "ip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.384 -0400", hash_original_field = "D61B4598257D50C1BE3144E43BCC41F6", hash_generated_field = "5959AC94E2CA87566C91036A7B7D53CC")

    private static final String DEFAULT_TRANSPORT = "udp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.384 -0400", hash_original_field = "EC71AA1577C3113BD905305C7B5E5210", hash_generated_field = "6FD8ABD88F8216A87D9323755D44B3BC")

    private static final Set<String> targetRefreshMethods = new HashSet<String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.384 -0400", hash_original_field = "4389E28B96080601985651075AC75C26", hash_generated_field = "DE0BEDB7C15A80D8700A3FDB2DA060E8")

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

