package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.address.GenericURI;
import gov.nist.javax.sip.address.SipUri;
import gov.nist.javax.sip.header.CSeq;
import gov.nist.javax.sip.header.CallID;
import gov.nist.javax.sip.header.ContactList;
import gov.nist.javax.sip.header.ContentLength;
import gov.nist.javax.sip.header.ContentType;
import gov.nist.javax.sip.header.Expires;
import gov.nist.javax.sip.header.From;
import gov.nist.javax.sip.header.MaxForwards;
import gov.nist.javax.sip.header.ProxyAuthorization;
import gov.nist.javax.sip.header.RecordRouteList;
import gov.nist.javax.sip.header.RequestLine;
import gov.nist.javax.sip.header.RouteList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.TimeStamp;
import gov.nist.javax.sip.header.To;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.header.ViaList;
import gov.nist.javax.sip.stack.SIPTransactionStack;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import javax.sip.InvalidArgumentException;
import javax.sip.SipException;
import javax.sip.address.URI;
import javax.sip.header.CSeqHeader;
import javax.sip.header.CallIdHeader;
import javax.sip.header.ContactHeader;
import javax.sip.header.EventHeader;
import javax.sip.header.FromHeader;
import javax.sip.header.Header;
import javax.sip.header.ServerHeader;
import javax.sip.header.SubscriptionStateHeader;
import javax.sip.header.ToHeader;
import javax.sip.header.ViaHeader;
import javax.sip.message.Request;






public final class SIPRequest extends SIPMessage implements javax.sip.message.Request, RequestExt {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.268 -0500", hash_original_method = "7223E3D35B4D52A449DC0E2B1959EDD4", hash_generated_method = "38EAAD4C9286F6207D6B3992C677025D")
    private static void putName(String name) {
        nameTable.put(name, name);
    }

    /**
     * @return true iff the method is a target refresh
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.270 -0500", hash_original_method = "4B4D9F751DB5D79751B154E23562814F", hash_generated_method = "B8C60C757E7C0C8407102784B4612948")
    public static boolean isTargetRefresh(String ucaseMethod) {
        return targetRefreshMethods.contains(ucaseMethod);
    }

    /**
     * @return true iff the method is a dialog creating method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.271 -0500", hash_original_method = "D16E6B2CA91AE223AD7E6F24352D1154", hash_generated_method = "B0728D89B911D5CBBA895D9AD19B51E2")
    public static boolean isDialogCreating(String ucaseMethod) {
        return SIPTransactionStack.isDialogCreated(ucaseMethod);
    }
    
    /**
     * Set to standard constants to speed up processing. this makes equals comparisons run much
     * faster in the stack because then it is just identity comparision. Character by char
     * comparison is not required. The method returns the String CONSTANT corresponding to the
     * String name.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.271 -0500", hash_original_method = "B369F52395BAC04D6C63B54A10908380", hash_generated_method = "5F32E55DB117733E49D73B185834A875")
    public static String getCannonicalName(String method) {

        if (nameTable.containsKey(method))
            return (String) nameTable.get(method);
        else
            return method;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.260 -0500", hash_original_field = "2F7E03671FA7428E68E78FD73A34C001", hash_generated_field = "872206405A4A16CD8A9DEDC93538CD9E")


    private static final long serialVersionUID = 3360720013577322927L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.261 -0500", hash_original_field = "D67B76B4F1A3D493C0761C10F501A61A", hash_generated_field = "B1B406294DA224E8D851E609279BB6BD")


    private static final String DEFAULT_USER = "ip";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.262 -0500", hash_original_field = "EDD6B57B0399F14F646C8CBE1FC4025D", hash_generated_field = "5959AC94E2CA87566C91036A7B7D53CC")


    private static final String DEFAULT_TRANSPORT = "udp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.267 -0500", hash_original_field = "F2483390C3BFBA5FEBCF75A09B78FBDE", hash_generated_field = "CCF32E1955A2FDA02B5213D027D62E47")

    // given cancel request

    /**
     * Set of target refresh methods, currently: INVITE, UPDATE, SUBSCRIBE, NOTIFY, REFER
     * 
     * A target refresh request and its response MUST have a Contact
     */
    private static final Set<String> targetRefreshMethods = new HashSet<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.268 -0500", hash_original_field = "738E0DC1DD4EB261810BDF9899213F30", hash_generated_field = "DE0BEDB7C15A80D8700A3FDB2DA060E8")

    private static final Hashtable<String, String> nameTable = new Hashtable<String, String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.262 -0500", hash_original_field = "0984EA6424A56E65F0ACFFC4BF928BAB", hash_generated_field = "35845A8B5E63218306C5DA0C937C70A8")


    private transient Object transactionPointer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.263 -0500", hash_original_field = "F951789739C700CC5E1AC0F685761512", hash_generated_field = "583EB683C8DCDB7E0E7B7B105FE10943")


    private RequestLine requestLine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.265 -0500", hash_original_field = "C967764303A9F9B6B33640AC03D1FF59", hash_generated_field = "5B17DBC4CAC28991AA6B7114D96A7324")


    private transient Object messageChannel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.266 -0500", hash_original_field = "5F269FC1960C84928AD48F389BF184C5", hash_generated_field = "576FE03392171B0B1591DDE2C13574A7")

    
    

    private transient Object inviteTransaction;

    /**
     * Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.274 -0500", hash_original_method = "CD96843F1E97D10004B6B61F026BE84E", hash_generated_method = "298D3F4037F1E431175B5ECCFB75FF39")
    public SIPRequest() {
        super();
    }

    /**
     * Get the Request Line of the SIPRequest.
     * 
     * @return the request line of the SIP Request.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.272 -0500", hash_original_method = "10A6E8DED0F9574AB3D1598F76906EF6", hash_generated_method = "C351B571FCC01AB678C4144B808FFC5D")
    public RequestLine getRequestLine() {
        return requestLine;
    }

    /**
     * Set the request line of the SIP Request.
     * 
     * @param requestLine is the request line to set in the SIP Request.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.273 -0500", hash_original_method = "B9CB3F60AB911F16367336645DE9DCA3", hash_generated_method = "EA3BA3600DC8DB83BE5C3E6B59289214")
    public void setRequestLine(RequestLine requestLine) {
        this.requestLine = requestLine;
    }

    /**
     * Convert to a formatted string for pretty printing. Note that the encode method converts
     * this into a sip message that is suitable for transmission. Note hack here if you want to
     * convert the nice curly brackets into some grotesque XML tag.
     * 
     * @return a string which can be used to examine the message contents.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.275 -0500", hash_original_method = "38B14A3222BE2105E2C0F39A9CA63E55", hash_generated_method = "94356BC9AE374861585560E86A5DBCCC")
    public String debugDump() {
        String superstring = super.debugDump();
        stringRepresentation = "";
        sprint(SIPRequest.class.getName());
        sprint("{");
        if (requestLine != null)
            sprint(requestLine.debugDump());
        sprint(superstring);
        sprint("}");
        return stringRepresentation;
    }

    /**
     * Check header for constraints. (1) Invite options and bye requests can only have SIP URIs in
     * the contact headers. (2) Request must have cseq, to and from and via headers. (3) Method in
     * request URI must match that in CSEQ.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.277 -0500", hash_original_method = "45144F3B633868FAD50525AF05DB3D15", hash_generated_method = "0F8BF8C945388E9EA49BEDC098E3099E")
    public void checkHeaders() throws ParseException {
        String prefix = "Missing a required header : ";

        /* Check for required headers */

        if (getCSeq() == null) {
            throw new ParseException(prefix + CSeqHeader.NAME, 0);
        }
        if (getTo() == null) {
            throw new ParseException(prefix + ToHeader.NAME, 0);
        }

        if (this.callIdHeader == null || this.callIdHeader.getCallId() == null
                || callIdHeader.getCallId().equals("")) {
            throw new ParseException(prefix + CallIdHeader.NAME, 0);
        }
        if (getFrom() == null) {
            throw new ParseException(prefix + FromHeader.NAME, 0);
        }
        if (getViaHeaders() == null) {
            throw new ParseException(prefix + ViaHeader.NAME, 0);
        }
        // BEGIN android-deleted
        /*
        if (getMaxForwards() == null) {
            throw new ParseException(prefix + MaxForwardsHeader.NAME, 0);
        }
        */
        // END android-deleted

        if (getTopmostVia() == null)
            throw new ParseException("No via header in request! ", 0);

        if (getMethod().equals(Request.NOTIFY)) {
            if (getHeader(SubscriptionStateHeader.NAME) == null)
                throw new ParseException(prefix + SubscriptionStateHeader.NAME, 0);

            if (getHeader(EventHeader.NAME) == null)
                throw new ParseException(prefix + EventHeader.NAME, 0);

        } else if (getMethod().equals(Request.PUBLISH)) {
            /*
             * For determining the type of the published event state, the EPA MUST include a
             * single Event header field in PUBLISH requests. The value of this header field
             * indicates the event package for which this request is publishing event state.
             */
            if (getHeader(EventHeader.NAME) == null)
                throw new ParseException(prefix + EventHeader.NAME, 0);
        }

        /*
         * RFC 3261 8.1.1.8 The Contact header field MUST be present and contain exactly one SIP
         * or SIPS URI in any request that can result in the establishment of a dialog. For the
         * methods defined in this specification, that includes only the INVITE request. For these
         * requests, the scope of the Contact is global. That is, the Contact header field value
         * contains the URI at which the UA would like to receive requests, and this URI MUST be
         * valid even if used in subsequent requests outside of any dialogs.
         * 
         * If the Request-URI or top Route header field value contains a SIPS URI, the Contact
         * header field MUST contain a SIPS URI as well.
         */
        if (requestLine.getMethod().equals(Request.INVITE)
                || requestLine.getMethod().equals(Request.SUBSCRIBE)
                || requestLine.getMethod().equals(Request.REFER)) {
            if (this.getContactHeader() == null) {
                // Make sure this is not a target refresh. If this is a target
                // refresh its ok not to have a contact header. Otherwise
                // contact header is mandatory.
                if (this.getToTag() == null)
                    throw new ParseException(prefix + ContactHeader.NAME, 0);
            }

            if (requestLine.getUri() instanceof SipUri) {
                String scheme = ((SipUri) requestLine.getUri()).getScheme();
                if ("sips".equalsIgnoreCase(scheme)) {
                    SipUri sipUri = (SipUri) this.getContactHeader().getAddress().getURI();
                    if (!sipUri.getScheme().equals("sips")) {
                        throw new ParseException("Scheme for contact should be sips:" + sipUri, 0);
                    }
                }
            }
        }

        /*
         * Contact header is mandatory for a SIP INVITE request.
         */
        if (this.getContactHeader() == null
                && (this.getMethod().equals(Request.INVITE)
                        || this.getMethod().equals(Request.REFER) || this.getMethod().equals(
                        Request.SUBSCRIBE))) {
            throw new ParseException("Contact Header is Mandatory for a SIP INVITE", 0);
        }

        if (requestLine != null && requestLine.getMethod() != null
                && getCSeq().getMethod() != null
                && requestLine.getMethod().compareTo(getCSeq().getMethod()) != 0) {
            throw new ParseException("CSEQ method mismatch with  Request-Line ", 0);

        }

    }

    /**
     * Set the default values in the request URI if necessary.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.278 -0500", hash_original_method = "B439ED3271619C5D642106B24B6F8DC7", hash_generated_method = "6E3C53FE950A265432CFD867E717C9DA")
    protected void setDefaults() {
        // The request line may be unparseable (set to null by the
        // exception handler.
        if (requestLine == null)
            return;
        String method = requestLine.getMethod();
        // The requestLine may be malformed!
        if (method == null)
            return;
        GenericURI u = requestLine.getUri();
        if (u == null)
            return;
        if (method.compareTo(Request.REGISTER) == 0 || method.compareTo(Request.INVITE) == 0) {
            if (u instanceof SipUri) {
                SipUri sipUri = (SipUri) u;
                sipUri.setUserParam(DEFAULT_USER);
                try {
                    sipUri.setTransportParam(DEFAULT_TRANSPORT);
                } catch (ParseException ex) {
                }
            }
        }
    }

    /**
     * Patch up the request line as necessary.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.279 -0500", hash_original_method = "ADE7B9A9349FBC47EE36B154FB701376", hash_generated_method = "D1F177180D4CD834534B31903624023E")
    protected void setRequestLineDefaults() {
        String method = requestLine.getMethod();
        if (method == null) {
            CSeq cseq = (CSeq) this.getCSeq();
            if (cseq != null) {
                method = getCannonicalName(cseq.getMethod());
                requestLine.setMethod(method);
            }
        }
    }

    /**
     * A conveniance function to access the Request URI.
     * 
     * @return the requestURI if it exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.280 -0500", hash_original_method = "A3406866B9B5846BB9675C9F68E4252E", hash_generated_method = "235793A464A8A9A39B0A3C9BDDC2A8D0")
    public javax.sip.address.URI getRequestURI() {
        if (this.requestLine == null)
            return null;
        else
            return (javax.sip.address.URI) this.requestLine.getUri();
    }

    /**
     * Sets the RequestURI of Request. The Request-URI is a SIP or SIPS URI or a general URI. It
     * indicates the user or service to which this request is being addressed. SIP elements MAY
     * support Request-URIs with schemes other than "sip" and "sips", for example the "tel" URI
     * scheme. SIP elements MAY translate non-SIP URIs using any mechanism at their disposal,
     * resulting in SIP URI, SIPS URI, or some other scheme.
     * 
     * @param uri the new Request URI of this request message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.281 -0500", hash_original_method = "9E5CBCE30B3652DB4124768C08B76945", hash_generated_method = "C1A23F081B84643B489C698C294A965D")
    public void setRequestURI(URI uri) {
        if ( uri == null ) {
            throw new NullPointerException("Null request URI");
        }
        if (this.requestLine == null) {
            this.requestLine = new RequestLine();
        }
        this.requestLine.setUri((GenericURI) uri);
        this.nullRequest = false;
    }

    /**
     * Set the method.
     * 
     * @param method is the method to set.
     * @throws IllegalArgumentException if the method is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.282 -0500", hash_original_method = "EB488472F269B62C6CA4000BD2F13691", hash_generated_method = "C8D2A71EE9F2AEE7ABFBDF1447AB0D63")
    public void setMethod(String method) {
        if (method == null)
            throw new IllegalArgumentException("null method");
        if (this.requestLine == null) {
            this.requestLine = new RequestLine();
        }

        // Set to standard constants to speed up processing.
        // this makes equals compares run much faster in the
        // stack because then it is just identity comparision

        String meth = getCannonicalName(method);
        this.requestLine.setMethod(meth);

        if (this.cSeqHeader != null) {
            try {
                this.cSeqHeader.setMethod(meth);
            } catch (ParseException e) {
            }
        }
    }

    /**
     * Get the method from the request line.
     * 
     * @return the method from the request line if the method exits and null if the request line
     *         or the method does not exist.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.283 -0500", hash_original_method = "56F7F917AEB0D8ED6BCAD35E03BA3E4E", hash_generated_method = "DA6D693C83A9A282D440E0689F236A6B")
    public String getMethod() {
        if (requestLine == null)
            return null;
        else
            return requestLine.getMethod();
    }

    /**
     * Encode the SIP Request as a string.
     * 
     * @return an encoded String containing the encoded SIP Message.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.284 -0500", hash_original_method = "A6E50A0D416AE1599A173132FA575828", hash_generated_method = "885324DC4EA9CD2FF7BCAD839152E915")
    public String encode() {
        String retval;
        if (requestLine != null) {
            this.setRequestLineDefaults();
            retval = requestLine.encode() + super.encode();
        } else if (this.isNullRequest()) {
            retval = "\r\n\r\n";
        } else {       
            retval = super.encode();
        }
        return retval;
    }

    /**
     * Encode only the headers and not the content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.285 -0500", hash_original_method = "6C6F96FB15913D1AD047295FEBDE6F36", hash_generated_method = "FF4D73C7C312E8F535E4F06C81F56B2A")
    public String encodeMessage() {
        String retval;
        if (requestLine != null) {
            this.setRequestLineDefaults();
            retval = requestLine.encode() + super.encodeSIPHeaders();
        } else if (this.isNullRequest()) {
            retval = "\r\n\r\n";
        } else
            retval = super.encodeSIPHeaders();
        return retval;

    }

    /**
     * ALias for encode above.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.286 -0500", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "0E38B803B5F7EA7FC3B7A952B8C48B78")
    public String toString() {
        return this.encode();
    }

    /**
     * Make a clone (deep copy) of this object. You can use this if you want to modify a request
     * while preserving the original
     * 
     * @return a deep copy of this object.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.287 -0500", hash_original_method = "A6367075CC534F28F93FAF1E0E79C3E5", hash_generated_method = "FA6F6FAFF263F064F6AE83CAFD47C7EB")
    public Object clone() {
        SIPRequest retval = (SIPRequest) super.clone();
        // Do not copy over the tx pointer -- this is only for internal
        // tracking.
        retval.transactionPointer = null;
        if (this.requestLine != null)
            retval.requestLine = (RequestLine) this.requestLine.clone();

        return retval;
    }

    /**
     * Compare for equality.
     * 
     * @param other object to compare ourselves with.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.288 -0500", hash_original_method = "9D04458788C457FA55EEFE59B9790011", hash_generated_method = "F9160B47FE25D2E57A379C9F1C1F8D67")
    public boolean equals(Object other) {
        if (!this.getClass().equals(other.getClass()))
            return false;
        SIPRequest that = (SIPRequest) other;

        return requestLine.equals(that.requestLine) && super.equals(other);
    }

    /**
     * Get the message as a linked list of strings. Use this if you want to iterate through the
     * message.
     * 
     * @return a linked list containing the request line and headers encoded as strings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.289 -0500", hash_original_method = "6E8F0447EF83A5DA6D1DCD59FBFB3047", hash_generated_method = "CA5FAF5A8EB0E319196A8334A659F7FE")
    public LinkedList getMessageAsEncodedStrings() {
        LinkedList retval = super.getMessageAsEncodedStrings();
        if (requestLine != null) {
            this.setRequestLineDefaults();
            retval.addFirst(requestLine.encode());
        }
        return retval;

    }

    /**
     * Match with a template. You can use this if you want to match incoming messages with a
     * pattern and do something when you find a match. This is useful for building filters/pattern
     * matching responders etc.
     * 
     * @param matchObj object to match ourselves with (null matches wildcard)
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.290 -0500", hash_original_method = "8262152376D5F60373B8E0AFA26377AD", hash_generated_method = "BC119D8F436168A72D4F83C32096CA47")
    public boolean match(Object matchObj) {
        if (matchObj == null)
            return true;
        else if (!matchObj.getClass().equals(this.getClass()))
            return false;
        else if (matchObj == this)
            return true;
        SIPRequest that = (SIPRequest) matchObj;
        RequestLine rline = that.requestLine;
        if (this.requestLine == null && rline != null)
            return false;
        else if (this.requestLine == rline)
            return super.match(matchObj);
        return requestLine.match(that.requestLine) && super.match(matchObj);

    }

    /**
     * Get a dialog identifier. Generates a string that can be used as a dialog identifier.
     * 
     * @param isServer is set to true if this is the UAS and set to false if this is the UAC
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.291 -0500", hash_original_method = "0EFA7CFB1786F9D68807C88E11C4B131", hash_generated_method = "B2A0C498CD2A21AC57E352CD96DF879F")
    public String getDialogId(boolean isServer) {
        CallID cid = (CallID) this.getCallId();
        StringBuffer retval = new StringBuffer(cid.getCallId());
        From from = (From) this.getFrom();
        To to = (To) this.getTo();
        if (!isServer) {
            // retval.append(COLON).append(from.getUserAtHostPort());
            if (from.getTag() != null) {
                retval.append(COLON);
                retval.append(from.getTag());
            }
            // retval.append(COLON).append(to.getUserAtHostPort());
            if (to.getTag() != null) {
                retval.append(COLON);
                retval.append(to.getTag());
            }
        } else {
            // retval.append(COLON).append(to.getUserAtHostPort());
            if (to.getTag() != null) {
                retval.append(COLON);
                retval.append(to.getTag());
            }
            // retval.append(COLON).append(from.getUserAtHostPort());
            if (from.getTag() != null) {
                retval.append(COLON);
                retval.append(from.getTag());
            }
        }
        return retval.toString().toLowerCase();

    }

    /**
     * Get a dialog id given the remote tag.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.292 -0500", hash_original_method = "08CF48833A43F9A889E4DE3BC734C868", hash_generated_method = "ED6C187FFC430F9F7022FD998832B098")
    public String getDialogId(boolean isServer, String toTag) {
        From from = (From) this.getFrom();
        CallID cid = (CallID) this.getCallId();
        StringBuffer retval = new StringBuffer(cid.getCallId());
        if (!isServer) {
            // retval.append(COLON).append(from.getUserAtHostPort());
            if (from.getTag() != null) {
                retval.append(COLON);
                retval.append(from.getTag());
            }
            // retval.append(COLON).append(to.getUserAtHostPort());
            if (toTag != null) {
                retval.append(COLON);
                retval.append(toTag);
            }
        } else {
            // retval.append(COLON).append(to.getUserAtHostPort());
            if (toTag != null) {
                retval.append(COLON);
                retval.append(toTag);
            }
            // retval.append(COLON).append(from.getUserAtHostPort());
            if (from.getTag() != null) {
                retval.append(COLON);
                retval.append(from.getTag());
            }
        }
        return retval.toString().toLowerCase();
    }

    /**
     * Encode this into a byte array. This is used when the body has been set as a binary array
     * and you want to encode the body as a byte array for transmission.
     * 
     * @return a byte array containing the SIPRequest encoded as a byte array.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.293 -0500", hash_original_method = "2AE1DB426BA66F196E718F42EC30B693", hash_generated_method = "78A913CBFB33499650BFF4E14048024E")
    public byte[] encodeAsBytes(String transport) {
        if (this.isNullRequest()) {
            // Encoding a null message for keepalive.
            return "\r\n\r\n".getBytes();
        } else if ( this.requestLine == null ) {
            return new byte[0];
        }

        byte[] rlbytes = null;
        if (requestLine != null) {
            try {
                rlbytes = requestLine.encode().getBytes("UTF-8");
            } catch (UnsupportedEncodingException ex) {
                InternalErrorHandler.handleException(ex);
            }
        }
        byte[] superbytes = super.encodeAsBytes(transport);
        byte[] retval = new byte[rlbytes.length + superbytes.length];
        System.arraycopy(rlbytes, 0, retval, 0, rlbytes.length);
        System.arraycopy(superbytes, 0, retval, rlbytes.length, superbytes.length);
        return retval;
    }

    /**
     * Creates a default SIPResponse message for this request. Note You must add the necessary
     * tags to outgoing responses if need be. For efficiency, this method does not clone the
     * incoming request. If you want to modify the outgoing response, be sure to clone the
     * incoming request as the headers are shared and any modification to the headers of the
     * outgoing response will result in a modification of the incoming request. Tag fields are
     * just copied from the incoming request. Contact headers are removed from the incoming
     * request. Added by Jeff Keyser.
     * 
     * @param statusCode Status code for the response. Reason phrase is generated.
     * 
     * @return A SIPResponse with the status and reason supplied, and a copy of all the original
     *         headers from this request.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.294 -0500", hash_original_method = "1C55C0FE8476C30A968193AA8AE54F83", hash_generated_method = "045E3A0EB62AA10F2DF081F21E99535F")
    public SIPResponse createResponse(int statusCode) {

        String reasonPhrase = SIPResponse.getReasonPhrase(statusCode);
        return this.createResponse(statusCode, reasonPhrase);

    }

    /**
     * Creates a default SIPResponse message for this request. Note You must add the necessary
     * tags to outgoing responses if need be. For efficiency, this method does not clone the
     * incoming request. If you want to modify the outgoing response, be sure to clone the
     * incoming request as the headers are shared and any modification to the headers of the
     * outgoing response will result in a modification of the incoming request. Tag fields are
     * just copied from the incoming request. Contact headers are removed from the incoming
     * request. Added by Jeff Keyser. Route headers are not added to the response.
     * 
     * @param statusCode Status code for the response.
     * @param reasonPhrase Reason phrase for this response.
     * 
     * @return A SIPResponse with the status and reason supplied, and a copy of all the original
     *         headers from this request except the ones that are not supposed to be part of the
     *         response .
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.296 -0500", hash_original_method = "4F64A0C3F2C04A008F76D91B875DAC0D", hash_generated_method = "C8EDEC31BDA79F97EF024E56F171B440")
    public SIPResponse createResponse(int statusCode, String reasonPhrase) {
        SIPResponse newResponse;
        Iterator headerIterator;
        SIPHeader nextHeader;

        newResponse = new SIPResponse();
        try {
            newResponse.setStatusCode(statusCode);
        } catch (ParseException ex) {
            throw new IllegalArgumentException("Bad code " + statusCode);
        }
        if (reasonPhrase != null)
            newResponse.setReasonPhrase(reasonPhrase);
        else
            newResponse.setReasonPhrase(SIPResponse.getReasonPhrase(statusCode));
        headerIterator = getHeaders();
        while (headerIterator.hasNext()) {
            nextHeader = (SIPHeader) headerIterator.next();
            if (nextHeader instanceof From
                    || nextHeader instanceof To
                    || nextHeader instanceof ViaList
                    || nextHeader instanceof CallID
                    || (nextHeader instanceof RecordRouteList && mustCopyRR(statusCode))
                    || nextHeader instanceof CSeq
                    // We just copy TimeStamp for all headers (not just 100).
                    || nextHeader instanceof TimeStamp) {

                try {

                    newResponse.attachHeader((SIPHeader) nextHeader.clone(), false);
                } catch (SIPDuplicateHeaderException e) {
                    e.printStackTrace();
                }
            }
        }
        if (MessageFactoryImpl.getDefaultServerHeader() != null) {
            newResponse.setHeader(MessageFactoryImpl.getDefaultServerHeader());

        }
        if (newResponse.getStatusCode() == 100) {
            // Trying is never supposed to have the tag parameter set.
            newResponse.getTo().removeParameter("tag");

        }
        ServerHeader server = MessageFactoryImpl.getDefaultServerHeader();
        if (server != null) {
            newResponse.setHeader(server);
        }
        return newResponse;
    }

    // Helper method for createResponse, to avoid copying Record-Route unless needed
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.297 -0500", hash_original_method = "B9BF2BAEBA19E8A2F042C98E4A2B8D22", hash_generated_method = "B5EE47E336A8FF2ACCD3D24A763BD037")
    private final boolean mustCopyRR( int code ) {
    	// Only for 1xx-2xx, not for 100 or errors
    	if ( code>100 && code<300 ) {
    		return isDialogCreating( this.getMethod() ) && getToTag() == null;
    	} else return false;
    }
    
    /**
     * Creates a default SIPResquest message that would cancel this request. Note that tag
     * assignment and removal of is left to the caller (we use whatever tags are present in the
     * original request).
     * 
     * @return A CANCEL SIPRequest constructed according to RFC3261 section 9.1
     * 
     * @throws SipException
     * @throws ParseException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.298 -0500", hash_original_method = "8DA892BCFD0BDEE05EB086307BFA5229", hash_generated_method = "40EE86BB9C4D2CFC328F760DD3DF07D0")
    public SIPRequest createCancelRequest() throws SipException {

        // see RFC3261 9.1

        // A CANCEL request SHOULD NOT be sent to cancel a request other than
        // INVITE

        if (!this.getMethod().equals(Request.INVITE))
            throw new SipException("Attempt to create CANCEL for " + this.getMethod());

        /*
         * The following procedures are used to construct a CANCEL request. The Request-URI,
         * Call-ID, To, the numeric part of CSeq, and From header fields in the CANCEL request
         * MUST be identical to those in the request being cancelled, including tags. A CANCEL
         * constructed by a client MUST have only a single Via header field value matching the top
         * Via value in the request being cancelled. Using the same values for these header fields
         * allows the CANCEL to be matched with the request it cancels (Section 9.2 indicates how
         * such matching occurs). However, the method part of the CSeq header field MUST have a
         * value of CANCEL. This allows it to be identified and processed as a transaction in its
         * own right (See Section 17).
         */
        SIPRequest cancel = new SIPRequest();
        cancel.setRequestLine((RequestLine) this.requestLine.clone());
        cancel.setMethod(Request.CANCEL);
        cancel.setHeader((Header) this.callIdHeader.clone());
        cancel.setHeader((Header) this.toHeader.clone());
        cancel.setHeader((Header) cSeqHeader.clone());
        try {
            cancel.getCSeq().setMethod(Request.CANCEL);
        } catch (ParseException e) {
            e.printStackTrace(); // should not happen
        }
        cancel.setHeader((Header) this.fromHeader.clone());

        cancel.addFirst((Header) this.getTopmostVia().clone());
        cancel.setHeader((Header) this.maxForwardsHeader.clone());

        /*
         * If the request being cancelled contains a Route header field, the CANCEL request MUST
         * include that Route header field's values.
         */
        if (this.getRouteHeaders() != null) {
            cancel.setHeader((SIPHeaderList< ? >) this.getRouteHeaders().clone());
        }
        if (MessageFactoryImpl.getDefaultUserAgentHeader() != null) {
            cancel.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());

        }
        return cancel;
    }

    /**
     * Creates a default ACK SIPRequest message for this original request. Note that the
     * defaultACK SIPRequest does not include the content of the original SIPRequest. If
     * responseToHeader is null then the toHeader of this request is used to construct the ACK.
     * Note that tag fields are just copied from the original SIP Request. Added by Jeff Keyser.
     * 
     * @param responseToHeader To header to use for this request.
     * 
     * @return A SIPRequest with an ACK method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.299 -0500", hash_original_method = "19E2EF483A3AD0C60513AE35D850A021", hash_generated_method = "B36994A490A24608EA801CABF753A3F7")
    public SIPRequest createAckRequest(To responseToHeader) {
        SIPRequest newRequest;
        Iterator headerIterator;
        SIPHeader nextHeader;

        newRequest = new SIPRequest();
        newRequest.setRequestLine((RequestLine) this.requestLine.clone());
        newRequest.setMethod(Request.ACK);
        headerIterator = getHeaders();
        while (headerIterator.hasNext()) {
            nextHeader = (SIPHeader) headerIterator.next();
            if (nextHeader instanceof RouteList) {
                // Ack and cancel do not get ROUTE headers.
                // Route header for ACK is assigned by the
                // Dialog if necessary.
                continue;
            } else if (nextHeader instanceof ProxyAuthorization) {
                // Remove proxy auth header.
                // Assigned by the Dialog if necessary.
                continue;
            } else if (nextHeader instanceof ContentLength) {
                // Adding content is responsibility of user.
                nextHeader = (SIPHeader) nextHeader.clone();
                try {
                    ((ContentLength) nextHeader).setContentLength(0);
                } catch (InvalidArgumentException e) {
                }
            } else if (nextHeader instanceof ContentType) {
                // Content type header is removed since
                // content length is 0.
                continue;
            } else if (nextHeader instanceof CSeq) {
                // The CSeq header field in the
                // ACK MUST contain the same value for the
                // sequence number as was present in the
                // original request, but the method parameter
                // MUST be equal to "ACK".
                CSeq cseq = (CSeq) nextHeader.clone();
                try {
                    cseq.setMethod(Request.ACK);
                } catch (ParseException e) {
                }
                nextHeader = cseq;
            } else if (nextHeader instanceof To) {
                if (responseToHeader != null) {
                    nextHeader = responseToHeader;
                } else {
                    nextHeader = (SIPHeader) nextHeader.clone();
                }
            } else if (nextHeader instanceof ContactList || nextHeader instanceof Expires) {
                // CONTACT header does not apply for ACK requests.
                continue;
            } else if (nextHeader instanceof ViaList) {
                // Bug reported by Gianluca Martinello
                // The ACK MUST contain a single Via header field,
                // and this MUST be equal to the top Via header
                // field of the original
                // request.

                nextHeader = (SIPHeader) ((ViaList) nextHeader).getFirst().clone();
            } else {
                nextHeader = (SIPHeader) nextHeader.clone();
            }

            try {
                newRequest.attachHeader(nextHeader, false);
            } catch (SIPDuplicateHeaderException e) {
                e.printStackTrace();
            }
        }
        if (MessageFactoryImpl.getDefaultUserAgentHeader() != null) {
            newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());

        }
        return newRequest;
    }

    /**
     * Creates an ACK for non-2xx responses according to RFC3261 17.1.1.3
     * 
     * @return A SIPRequest with an ACK method.
     * @throws SipException
     * @throws NullPointerException
     * @throws ParseException
     * 
     * @author jvb
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.300 -0500", hash_original_method = "7B881B99117D66C1BDF145A59ABEA2E4", hash_generated_method = "6D4D21FFADBEBA8B3BCD864B371D97DD")
    public final SIPRequest createErrorAck(To responseToHeader) throws SipException,
            ParseException {

        /*
         * The ACK request constructed by the client transaction MUST contain values for the
         * Call-ID, From, and Request-URI that are equal to the values of those header fields in
         * the request passed to the transport by the client transaction (call this the "original
         * request"). The To header field in the ACK MUST equal the To header field in the
         * response being acknowledged, and therefore will usually differ from the To header field
         * in the original request by the addition of the tag parameter. The ACK MUST contain a
         * single Via header field, and this MUST be equal to the top Via header field of the
         * original request. The CSeq header field in the ACK MUST contain the same value for the
         * sequence number as was present in the original request, but the method parameter MUST
         * be equal to "ACK".
         */
        SIPRequest newRequest = new SIPRequest();
        newRequest.setRequestLine((RequestLine) this.requestLine.clone());
        newRequest.setMethod(Request.ACK);
        newRequest.setHeader((Header) this.callIdHeader.clone());
        newRequest.setHeader((Header) this.maxForwardsHeader.clone()); // ISSUE
        // 130
        // fix
        newRequest.setHeader((Header) this.fromHeader.clone());
        newRequest.setHeader((Header) responseToHeader.clone());
        newRequest.addFirst((Header) this.getTopmostVia().clone());
        newRequest.setHeader((Header) cSeqHeader.clone());
        newRequest.getCSeq().setMethod(Request.ACK);

        /*
         * If the INVITE request whose response is being acknowledged had Route header fields,
         * those header fields MUST appear in the ACK. This is to ensure that the ACK can be
         * routed properly through any downstream stateless proxies.
         */
        if (this.getRouteHeaders() != null) {
            newRequest.setHeader((SIPHeaderList) this.getRouteHeaders().clone());
        }
        if (MessageFactoryImpl.getDefaultUserAgentHeader() != null) {
            newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());

        }
        return newRequest;
    }

    /**
     * Create a new default SIPRequest from the original request. Warning: the newly created
     * SIPRequest, shares the headers of this request but we generate any new headers that we need
     * to modify so the original request is umodified. However, if you modify the shared headers
     * after this request is created, then the newly created request will also be modified. If you
     * want to modify the original request without affecting the returned Request make sure you
     * clone it before calling this method.
     * 
     * Only required headers are copied.
     * <ul>
     * <li> Contact headers are not included in the newly created request. Setting the appropriate
     * sequence number is the responsibility of the caller. </li>
     * <li> RouteList is not copied for ACK and CANCEL </li>
     * <li> Note that we DO NOT copy the body of the argument into the returned header. We do not
     * copy the content type header from the original request either. These have to be added
     * seperately and the content length has to be correctly set if necessary the content length
     * is set to 0 in the returned header. </li>
     * <li>Contact List is not copied from the original request.</li>
     * <li>RecordRoute List is not included from original request. </li>
     * <li>Via header is not included from the original request. </li>
     * </ul>
     * 
     * @param requestLine is the new request line.
     * 
     * @param switchHeaders is a boolean flag that causes to and from headers to switch (set this
     *        to true if you are the server of the transaction and are generating a BYE request).
     *        If the headers are switched, we generate new From and To headers otherwise we just
     *        use the incoming headers.
     * 
     * @return a new Default SIP Request which has the requestLine specified.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.302 -0500", hash_original_method = "88B58E52E2D044E743A1ED3102F3960B", hash_generated_method = "4B082871EC06B81A20DC9FE95803F51A")
    public SIPRequest createSIPRequest(RequestLine requestLine, boolean switchHeaders) {
        SIPRequest newRequest = new SIPRequest();
        newRequest.requestLine = requestLine;
        Iterator<SIPHeader> headerIterator = this.getHeaders();
        while (headerIterator.hasNext()) {
            SIPHeader nextHeader = (SIPHeader) headerIterator.next();
            // For BYE and cancel set the CSeq header to the
            // appropriate method.
            if (nextHeader instanceof CSeq) {
                CSeq newCseq = (CSeq) nextHeader.clone();
                nextHeader = newCseq;
                try {
                    newCseq.setMethod(requestLine.getMethod());
                } catch (ParseException e) {
                }
            } else if (nextHeader instanceof ViaList) {
                Via via = (Via) (((ViaList) nextHeader).getFirst().clone());
                via.removeParameter("branch");
                nextHeader = via;
                // Cancel and ACK preserve the branch ID.
            } else if (nextHeader instanceof To) {
                To to = (To) nextHeader;
                if (switchHeaders) {
                    nextHeader = new From(to);
                    ((From) nextHeader).removeTag();
                } else {
                    nextHeader = (SIPHeader) to.clone();
                    ((To) nextHeader).removeTag();
                }
            } else if (nextHeader instanceof From) {
                From from = (From) nextHeader;
                if (switchHeaders) {
                    nextHeader = new To(from);
                    ((To) nextHeader).removeTag();
                } else {
                    nextHeader = (SIPHeader) from.clone();
                    ((From) nextHeader).removeTag();
                }
            } else if (nextHeader instanceof ContentLength) {
                ContentLength cl = (ContentLength) nextHeader.clone();
                try {
                    cl.setContentLength(0);
                } catch (InvalidArgumentException e) {
                }
                nextHeader = cl;
            } else if (!(nextHeader instanceof CallID) && !(nextHeader instanceof MaxForwards)) {
                // Route is kept by dialog.
                // RR is added by the caller.
                // Contact is added by the Caller
                // Any extension headers must be added
                // by the caller.
                continue;
            }
            try {
                newRequest.attachHeader(nextHeader, false);
            } catch (SIPDuplicateHeaderException e) {
                e.printStackTrace();
            }
        }
        if (MessageFactoryImpl.getDefaultUserAgentHeader() != null) {
            newRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());

        }
        return newRequest;

    }

    /**
     * Create a BYE request from this request.
     * 
     * @param switchHeaders is a boolean flag that causes from and isServerTransaction to headers
     *        to be swapped. Set this to true if you are the server of the dialog and are
     *        generating a BYE request for the dialog.
     * @return a new default BYE request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.303 -0500", hash_original_method = "D367B8AD3F620DA29FDBF98B146E85CC", hash_generated_method = "57AD9C3F19CEBCC5998187D7C8E03D64")
    public SIPRequest createBYERequest(boolean switchHeaders) {
        RequestLine requestLine = (RequestLine) this.requestLine.clone();
        requestLine.setMethod("BYE");
        return this.createSIPRequest(requestLine, switchHeaders);
    }

    /**
     * Create an ACK request from this request. This is suitable for generating an ACK for an
     * INVITE client transaction.
     * 
     * @return an ACK request that is generated from this request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.303 -0500", hash_original_method = "F27ED260A28BC4E6AB9113A5229AE82E", hash_generated_method = "E395A3E2468207D799D865AD71404D75")
    public SIPRequest createACKRequest() {
        RequestLine requestLine = (RequestLine) this.requestLine.clone();
        requestLine.setMethod(Request.ACK);
        return this.createSIPRequest(requestLine, false);
    }

    /**
     * Get the host from the topmost via header.
     * 
     * @return the string representation of the host from the topmost via header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.304 -0500", hash_original_method = "DA1F7E2B6F3093C6379A0C0D51E796B9", hash_generated_method = "8C3B498A589A9BBAC3081A6FDDC2DDFE")
    public String getViaHost() {
        Via via = (Via) this.getViaHeaders().getFirst();
        return via.getHost();

    }

    /**
     * Get the port from the topmost via header.
     * 
     * @return the port from the topmost via header (5060 if there is no port indicated).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.305 -0500", hash_original_method = "C4DF5E381400BD9B0BACC03DD32438B3", hash_generated_method = "C4B3E6974FA40C9984A0CC03791EBEF2")
    public int getViaPort() {
        Via via = (Via) this.getViaHeaders().getFirst();
        if (via.hasPort())
            return via.getPort();
        else
            return 5060;
    }

    /**
     * Get the first line encoded.
     * 
     * @return a string containing the encoded request line.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.306 -0500", hash_original_method = "530E19A2E500806E1A366E25A34AD0D7", hash_generated_method = "977B38D5AF034A140DCC65094CC33BB0")
    public String getFirstLine() {
        if (requestLine == null)
            return null;
        else
            return this.requestLine.encode();
    }

    /**
     * Set the sip version.
     * 
     * @param sipVersion the sip version to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.307 -0500", hash_original_method = "053882D0BB9ABEB2DEF0F19246596664", hash_generated_method = "B8CE7D3E7DE115D844D87B1923C630C8")
    public void setSIPVersion(String sipVersion) throws ParseException {
        if (sipVersion == null || !sipVersion.equalsIgnoreCase("SIP/2.0"))
            throw new ParseException("sipVersion", 0);
        this.requestLine.setSipVersion(sipVersion);
    }

    /**
     * Get the SIP version.
     * 
     * @return the SIP version from the request line.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.307 -0500", hash_original_method = "00EEF223B95EA2B5E1E6EED25EDEECD3", hash_generated_method = "8E1DE621232B5ACFC8889585FAF80D75")
    public String getSIPVersion() {
        return this.requestLine.getSipVersion();
    }

    /**
     * Book keeping method to return the current tx for the request if one exists.
     * 
     * @return the assigned tx.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.308 -0500", hash_original_method = "1671629A516F35F213CEF63536914216", hash_generated_method = "B8941DDFB8CB4BCDD4F54B4A768BFE08")
    public Object getTransaction() {
        // Return an opaque pointer to the transaction object.
        // This is for consistency checking and quick lookup.
        return this.transactionPointer;
    }

    /**
     * Book keeping field to set the current tx for the request.
     * 
     * @param transaction
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.309 -0500", hash_original_method = "29C9F28BA62C1C5D6183FC49B73B119A", hash_generated_method = "F1C114FFF0E10042BEABAB399767B77E")
    public void setTransaction(Object transaction) {
        this.transactionPointer = transaction;
    }

    /**
     * Book keeping method to get the messasge channel for the request.
     * 
     * @return the message channel for the request.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.311 -0500", hash_original_method = "D6849E418A3430D13263F7E766EC96CA", hash_generated_method = "17794CAFBB0F76E66B0AC0D7EF8B2CF6")
    public Object getMessageChannel() {
        // return opaque ptr to the message chanel on
        // which the message was recieved. For consistency
        // checking and lookup.
        return this.messageChannel;
    }

    /**
     * Set the message channel for the request ( bookkeeping field ).
     * 
     * @param messageChannel
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.312 -0500", hash_original_method = "F021F3118E1F64B2274957A9C076266A", hash_generated_method = "FEE6F6D1A2FFD025AE9EA86DD5363287")
    public void setMessageChannel(Object messageChannel) {
        this.messageChannel = messageChannel;
    }

    /**
     * Generates an Id for checking potentially merged requests.
     * 
     * @return String to check for merged requests
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.313 -0500", hash_original_method = "5C56890151E96C66B0B2332BC1750187", hash_generated_method = "DF76C059C3BF23664B8AE42F1C166C32")
    public String getMergeId() {
        /*
         * generate an identifier from the From tag, Call-ID, and CSeq
         */
        String fromTag = this.getFromTag();
        String cseq = this.cSeqHeader.toString();
        String callId = this.callIdHeader.getCallId();
        /* NOTE : The RFC does NOT specify you need to include a Request URI 
         * This is added here for the case of Back to Back User Agents.
         */
        String requestUri = this.getRequestURI().toString();

        if (fromTag != null) {
            return new StringBuffer().append(requestUri).append(":").append(fromTag).append(":").append(cseq).append(":")
                    .append(callId).toString();
        } else
            return null;

    }

    /**
     * @param inviteTransaction the inviteTransaction to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.313 -0500", hash_original_method = "8408AE2B464881D5E749D0715A83122D", hash_generated_method = "6599E59DA005C3E62F85BD38959E2416")
    public void setInviteTransaction(Object inviteTransaction) {
        this.inviteTransaction = inviteTransaction;
    }

    /**
     * @return the inviteTransaction
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.314 -0500", hash_original_method = "E74B555DC4A151C37AF9F95C34B6492D", hash_generated_method = "16EEFF983AD06A3889E9EFD0B615869C")
    public Object getInviteTransaction() {
        return inviteTransaction;
    }
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

