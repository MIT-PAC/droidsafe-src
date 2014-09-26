package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.SIPConstants;
import gov.nist.javax.sip.Utils;
import gov.nist.javax.sip.header.AlertInfo;
import gov.nist.javax.sip.header.Authorization;
import gov.nist.javax.sip.header.CSeq;
import gov.nist.javax.sip.header.CallID;
import gov.nist.javax.sip.header.Contact;
import gov.nist.javax.sip.header.ContactList;
import gov.nist.javax.sip.header.ContentLength;
import gov.nist.javax.sip.header.ContentType;
import gov.nist.javax.sip.header.ErrorInfo;
import gov.nist.javax.sip.header.ErrorInfoList;
import gov.nist.javax.sip.header.From;
import gov.nist.javax.sip.header.InReplyTo;
import gov.nist.javax.sip.header.MaxForwards;
import gov.nist.javax.sip.header.Priority;
import gov.nist.javax.sip.header.ProxyAuthenticate;
import gov.nist.javax.sip.header.ProxyAuthorization;
import gov.nist.javax.sip.header.ProxyRequire;
import gov.nist.javax.sip.header.ProxyRequireList;
import gov.nist.javax.sip.header.RSeq;
import gov.nist.javax.sip.header.RecordRouteList;
import gov.nist.javax.sip.header.RetryAfter;
import gov.nist.javax.sip.header.Route;
import gov.nist.javax.sip.header.RouteList;
import gov.nist.javax.sip.header.SIPETag;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.SIPHeaderNamesCache;
import gov.nist.javax.sip.header.SIPIfMatch;
import gov.nist.javax.sip.header.Server;
import gov.nist.javax.sip.header.Subject;
import gov.nist.javax.sip.header.To;
import gov.nist.javax.sip.header.Unsupported;
import gov.nist.javax.sip.header.UserAgent;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.header.ViaList;
import gov.nist.javax.sip.header.WWWAuthenticate;
import gov.nist.javax.sip.header.Warning;
import gov.nist.javax.sip.parser.HeaderParser;
import gov.nist.javax.sip.parser.ParserFactory;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.sip.InvalidArgumentException;
import javax.sip.SipException;
import javax.sip.header.AuthorizationHeader;
import javax.sip.header.CSeqHeader;
import javax.sip.header.CallIdHeader;
import javax.sip.header.ContactHeader;
import javax.sip.header.ContentDispositionHeader;
import javax.sip.header.ContentEncodingHeader;
import javax.sip.header.ContentLanguageHeader;
import javax.sip.header.ContentLengthHeader;
import javax.sip.header.ContentTypeHeader;
import javax.sip.header.ExpiresHeader;
import javax.sip.header.FromHeader;
import javax.sip.header.Header;
import javax.sip.header.MaxForwardsHeader;
import javax.sip.header.RecordRouteHeader;
import javax.sip.header.RouteHeader;
import javax.sip.header.ToHeader;
import javax.sip.header.ViaHeader;
import javax.sip.message.Request;

public abstract class SIPMessage extends MessageObject implements javax.sip.message.Message, MessageExt {

    /**
     * Return true if the header belongs only in a Request.
     * 
     * @param sipHeader is the header to test.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.155 -0500", hash_original_method = "E6C3BF9440F9D4E769311D421DB6DB1E", hash_generated_method = "8C3C2DF7DD15D1B9C1EC58FD8281CE16")
    
public static boolean isRequestHeader(SIPHeader sipHeader) {
        return sipHeader instanceof AlertInfo || sipHeader instanceof InReplyTo
                || sipHeader instanceof Authorization || sipHeader instanceof MaxForwards
                || sipHeader instanceof UserAgent || sipHeader instanceof Priority
                || sipHeader instanceof ProxyAuthorization || sipHeader instanceof ProxyRequire
                || sipHeader instanceof ProxyRequireList || sipHeader instanceof Route
                || sipHeader instanceof RouteList || sipHeader instanceof Subject
                || sipHeader instanceof SIPIfMatch;
    }

    /**
     * Return true if the header belongs only in a response.
     * 
     * @param sipHeader is the header to test.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.158 -0500", hash_original_method = "44F0E4C1BA5D8C5BE264ACC97874B646", hash_generated_method = "23656348C0CC1CA4CABE86568065B247")
    
public static boolean isResponseHeader(SIPHeader sipHeader) {
        return sipHeader instanceof ErrorInfo || sipHeader instanceof ProxyAuthenticate
                || sipHeader instanceof Server || sipHeader instanceof Unsupported
                || sipHeader instanceof RetryAfter || sipHeader instanceof Warning
                || sipHeader instanceof WWWAuthenticate || sipHeader instanceof SIPETag
                || sipHeader instanceof RSeq;

    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.233 -0500", hash_original_field = "140583C7D6A7B27A3D80E3A8BB7B4A11", hash_generated_field = "3904126BA9BA221FEEB83EA7E49FDA36")
    
    private static final String CONTENT_TYPE_LOWERCASE = SIPHeaderNamesCache
    .toLowerCase(ContentTypeHeader.NAME);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.243 -0500", hash_original_field = "384ED9F5B65FDBCDF82E256C2C50F502", hash_generated_field = "2A8E8F0E3F29FFFF710437740FFE07B1")

    private static final String ERROR_LOWERCASE = SIPHeaderNamesCache.toLowerCase(ErrorInfo.NAME);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.249 -0500", hash_original_field = "299D40657FFB8B99846F35F69FA2E500", hash_generated_field = "3BB82B473CACCC793FC18D6F0CF9300E")

    private static final String CONTACT_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ContactHeader.NAME);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.257 -0500", hash_original_field = "6E58821CED9BEE0C59F73F9B976F84BA", hash_generated_field = "51278ECFB8FC893D338CBD35C1B5F8F7")

    private static final String VIA_LOWERCASE = SIPHeaderNamesCache.toLowerCase(ViaHeader.NAME);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.272 -0500", hash_original_field = "FF64FB72636E61DBB702ED5DFB0CDB84", hash_generated_field = "F10B3CAD8FB507F5BDFF22A8AD4FFF13")

    private static final String AUTHORIZATION_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(AuthorizationHeader.NAME);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.282 -0500", hash_original_field = "963D5153C1D1D6789130333CC984AFFD", hash_generated_field = "BE5A48849228660E6DA6589746E7D093")

    private static final String ROUTE_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(RouteHeader.NAME);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.294 -0500", hash_original_field = "06B08B687FBFA0767CC49D4A92CF5D51", hash_generated_field = "0F29B176C2B3A3AA106F93F963532E79")

    private static final String RECORDROUTE_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(RecordRouteHeader.NAME);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.388 -0500", hash_original_field = "3F8F8E2298F923B771AA7F2562571228", hash_generated_field = "6AF602A3153F2C32B93DA6F98A935DA5")

    private static final String CONTENT_DISPOSITION_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ContentDispositionHeader.NAME);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.393 -0500", hash_original_field = "CBA9C5B72E09132A26484FA584259563", hash_generated_field = "6D27C3CBA91F0C290360A638D7DF519E")

    private static final String CONTENT_ENCODING_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ContentEncodingHeader.NAME);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.398 -0500", hash_original_field = "0CCD9469DD923818AEB820184FACC25E", hash_generated_field = "376511CEFEB33BD270D266CD58BF159F")

    private static final String CONTENT_LANGUAGE_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ContentLanguageHeader.NAME);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.403 -0500", hash_original_field = "B4F2ABE961D0018E20A8A6602766205A", hash_generated_field = "5C2E81EB8278F47B64608EF8A7BB04DF")

    private static final String EXPIRES_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ExpiresHeader.NAME);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.116 -0500", hash_original_field = "AD4A6BC8594622E95277DB1F0F9D694A", hash_generated_field = "4BA5E6BB1036D79534D4BE3D73466535")

    private String contentEncodingCharset = MessageFactoryImpl.getDefaultContentEncodingCharset();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.119 -0500", hash_original_field = "5DD97C271EE931C870E3396E8FDB3AE9", hash_generated_field = "3D632899724829D8B5950E7FD03861B1")

    protected boolean nullRequest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.121 -0500", hash_original_field = "6491AB79EE286A5F5BB3ACBC597C1079", hash_generated_field = "E835C2C2C7A6613C6BF5AAA84C167353")

    protected LinkedList<String> unrecognizedHeaders;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.123 -0500", hash_original_field = "FAF059A17ACECE875BE60B2EF013FDA1", hash_generated_field = "247E0138E51DEE8295CE7FD03B5C7C7F")

    protected ConcurrentLinkedQueue<SIPHeader> headers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.126 -0500", hash_original_field = "5B311F43E678C5EE8CC1882F4F762103", hash_generated_field = "41941E45293112AC36DC5E7BE4DFF5AE")

    protected From fromHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.128 -0500", hash_original_field = "0EC70AF0BA3CF671255C069BE1EF5A29", hash_generated_field = "386FEF496B2D00FF2AEEA4F647EAA2EC")

    protected To toHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.130 -0500", hash_original_field = "97F2621E58544EB5857FA617766383AF", hash_generated_field = "9243D81B8C37269C34D9BD3D6292835A")

    protected CSeq cSeqHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.133 -0500", hash_original_field = "19B8FB08B553EF9A4349BACE86FA8AAE", hash_generated_field = "471E372FA6B60996CC5D5DA482544660")

    protected CallID callIdHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.135 -0500", hash_original_field = "DC087804B6A332FFEF3AAFD8FA219B42", hash_generated_field = "BD2FD117E706370D42DF61B188BF8940")

    protected ContentLength contentLengthHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.137 -0500", hash_original_field = "6239D14961A7E96DEC4801ABA1461276", hash_generated_field = "19F23DC4282A0EF2D6622C8B0C1149E7")

    protected MaxForwards maxForwardsHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.139 -0500", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "BEC7808019D8AD57BF06A5469459FF0A")

    protected int size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.142 -0500", hash_original_field = "82D862303EC55ACC9914DE3E6E6D865D", hash_generated_field = "BDA818F16CAD309D41556EC35AB6E563")

    private String messageContent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.144 -0500", hash_original_field = "95F7D92AA7E61DA15548358D0500E443", hash_generated_field = "3E3D2657E47D4DE2C783823CF246BBAB")

    private byte[] messageContentBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.147 -0500", hash_original_field = "E06771BF0AF78CC5FF2D374B53AB4258", hash_generated_field = "1560325BE0E32978EBE2ECDE71A6C345")

    private Object messageContentObject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.149 -0500", hash_original_field = "A38DB47C89E5187A9BF8ECB115A68CA2", hash_generated_field = "1C03D389CB46F0B01812A6FDFBD5DD7D")

    private Hashtable<String, SIPHeader> nameTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.152 -0500", hash_original_field = "324CFAE3E8224AEDE88E789E229FDCE3", hash_generated_field = "89FDF1CBFFC083F61390A7888D3F82DE")

    protected Object applicationData;

    /**
     * Constructor: Initializes lists and list headers. All the headers for which there can be
     * multiple occurances in a message are derived from the SIPHeaderListClass. All singleton
     * headers are derived from SIPHeader class.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.190 -0500", hash_original_method = "7EF8FE4247F4A54A74550FF503F5DF85", hash_generated_method = "0F2A3ECA62D279DBBB696F4C055DD2C2")
    
public SIPMessage() {
        this.unrecognizedHeaders = new LinkedList<String>();
        this.headers = new ConcurrentLinkedQueue<SIPHeader>();
        nameTable = new Hashtable<String, SIPHeader>();
        try {
            this.attachHeader(new ContentLength(0), false);
        } catch (Exception ex) {
        }
    }

    /**
     * Get the headers as a linked list of encoded Strings
     * 
     * @return a linked list with each element of the list containing a string encoded header in
     *         canonical form.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.160 -0500", hash_original_method = "4E875487FBA3E9E3C25B636513844812", hash_generated_method = "75A5849C5E1DBE999CA6570BB06D5D24")
    
public LinkedList<String> getMessageAsEncodedStrings() {
        LinkedList<String> retval = new LinkedList<String>();
        Iterator<SIPHeader> li = headers.iterator();
        while (li.hasNext()) {
            SIPHeader sipHeader = (SIPHeader) li.next();
            if (sipHeader instanceof SIPHeaderList) {
                SIPHeaderList< ? > shl = (SIPHeaderList< ? >) sipHeader;
                retval.addAll(shl.getHeadersAsEncodedStrings());
            } else {
                retval.add(sipHeader.encode());
            }
        }

        return retval;
    }

    /**
     * Encode only the message and exclude the contents (for debugging);
     * 
     * @return a string with all the headers encoded.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.163 -0500", hash_original_method = "A27900405272FB61F2D6362A05DA41D6", hash_generated_method = "E9A5E2820A2C3B091DACE695E759D769")
    
protected String encodeSIPHeaders() {
        StringBuffer encoding = new StringBuffer();
        Iterator<SIPHeader> it = this.headers.iterator();

        while (it.hasNext()) {
            SIPHeader siphdr = (SIPHeader) it.next();
            if (!(siphdr instanceof ContentLength))
                siphdr.encode(encoding);
        }

        return contentLengthHeader.encode(encoding).append(NEWLINE).toString();
    }

    /**
     * Encode all the headers except the contents. For debug logging.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.165 -0500", hash_original_method = "0E20F7A3255DC8C8EF78B7F684A06AF5", hash_generated_method = "4A16183285D0E0C3DFDA0213F27EB58B")
    
public abstract String encodeMessage();

    /**
     * Get A dialog identifier constructed from this messsage. This is an id that can be used to
     * identify dialogs.
     * 
     * @param isServerTransaction is a flag that indicates whether this is a server transaction.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.168 -0500", hash_original_method = "AF7976790CA90C9E0005CC51A6DBDF36", hash_generated_method = "28626D974B6C4A749823105C2A5AB67C")
    
public abstract String getDialogId(boolean isServerTransaction);

    /**
     * Template match for SIP messages. The matchObj is a SIPMessage template to match against.
     * This method allows you to do pattern matching with incoming SIP messages. Null matches wild
     * card.
     * 
     * @param other is the match template to match against.
     * @return true if a match occured and false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.172 -0500", hash_original_method = "AC5B2D97481875B2502EE3A7FDAB3C5D", hash_generated_method = "B35601702C86ECCC79F47F9F1545930F")
    
public boolean match(Object other) {
        if (other == null)
            return true;
        if (!other.getClass().equals(this.getClass()))
            return false;
        SIPMessage matchObj = (SIPMessage) other;
        Iterator<SIPHeader> li = matchObj.getHeaders();
        while (li.hasNext()) {
            SIPHeader hisHeaders = (SIPHeader) li.next();
            List<SIPHeader> myHeaders = this.getHeaderList(hisHeaders.getHeaderName());

            // Could not find a header to match his header.
            if (myHeaders == null || myHeaders.size() == 0)
                return false;

            if (hisHeaders instanceof SIPHeaderList) {
                ListIterator< ? > outerIterator = ((SIPHeaderList< ? >) hisHeaders)
                        .listIterator();
                while (outerIterator.hasNext()) {
                    SIPHeader hisHeader = (SIPHeader) outerIterator.next();
                    if (hisHeader instanceof ContentLength)
                        continue;
                    ListIterator< ? > innerIterator = myHeaders.listIterator();
                    boolean found = false;
                    while (innerIterator.hasNext()) {
                        SIPHeader myHeader = (SIPHeader) innerIterator.next();
                        if (myHeader.match(hisHeader)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        return false;
                }
            } else {
                SIPHeader hisHeader = hisHeaders;
                ListIterator<SIPHeader> innerIterator = myHeaders.listIterator();
                boolean found = false;
                while (innerIterator.hasNext()) {
                    SIPHeader myHeader = (SIPHeader) innerIterator.next();
                    if (myHeader.match(hisHeader)) {
                        found = true;
                        break;
                    }
                }
                if (!found)
                    return false;
            }
        }
        return true;

    }

    /**
     * Merge a request with a template
     * 
     * @param template -- template to merge with.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.174 -0500", hash_original_method = "789EABA7F64EF1819B9EE91356F4E918", hash_generated_method = "FD751A0809AE6FE37CEBBBACB3728C03")
    
public void merge(Object template) {
        if (!template.getClass().equals(this.getClass()))
            throw new IllegalArgumentException("Bad class " + template.getClass());
        SIPMessage templateMessage = (SIPMessage) template;
        Object[] templateHeaders = templateMessage.headers.toArray();
        for (int i = 0; i < templateHeaders.length; i++) {
            SIPHeader hdr = (SIPHeader) templateHeaders[i];
            String hdrName = hdr.getHeaderName();
            List<SIPHeader> myHdrs = this.getHeaderList(hdrName);
            if (myHdrs == null) {
                this.attachHeader(hdr);
            } else {
                ListIterator<SIPHeader> it = myHdrs.listIterator();
                while (it.hasNext()) {
                    SIPHeader sipHdr = (SIPHeader) it.next();
                    sipHdr.merge(hdr);
                }
            }
        }

    }

    /**
     * Encode this message as a string. This is more efficient when the payload is a string
     * (rather than a binary array of bytes). If the payload cannot be encoded as a UTF-8 string
     * then it is simply ignored (will not appear in the encoded message).
     * 
     * @return The Canonical String representation of the message (including the canonical string
     *         representation of the SDP payload if it exists).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.177 -0500", hash_original_method = "79C45AA8D92059F002F56259D7022AFE", hash_generated_method = "BFE6BB93C3085DADA6F76A302E461FD5")
    
public String encode() {
        StringBuffer encoding = new StringBuffer();
        Iterator<SIPHeader> it = this.headers.iterator();

        while (it.hasNext()) {
            SIPHeader siphdr = (SIPHeader) it.next();
            if (!(siphdr instanceof ContentLength))
                encoding.append(siphdr.encode());
        }
        // Append the unrecognized headers. Headers that are not
        // recognized are passed through unchanged.
        for (String unrecognized : this.unrecognizedHeaders) {
            encoding.append(unrecognized).append(NEWLINE);
        }

        encoding.append(contentLengthHeader.encode()).append(NEWLINE);

        if (this.messageContentObject != null) {
            String mbody = this.getContent().toString();

            encoding.append(mbody);
        } else if (this.messageContent != null || this.messageContentBytes != null) {

            String content = null;
            try {
                if (messageContent != null)
                    content = messageContent;
                else {
                	// JvB: Check for 'charset' parameter which overrides the default UTF-8
                    content = new String(messageContentBytes, getCharset() );
                }
            } catch (UnsupportedEncodingException ex) {
            	InternalErrorHandler.handleException(ex);
            }

            encoding.append(content);
        }
        return encoding.toString();
    }

    /**
     * Encode the message as a byte array. Use this when the message payload is a binary byte
     * array.
     * 
     * @return The Canonical byte array representation of the message (including the canonical
     *         byte array representation of the SDP payload if it exists all in one contiguous
     *         byte array).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.180 -0500", hash_original_method = "716A084604DD8483BAA5EE270A2C01EC", hash_generated_method = "2F30D9803EDDB84BAA70C974E369880C")
    
public byte[] encodeAsBytes(String transport) {
        if (this instanceof SIPRequest && ((SIPRequest) this).isNullRequest()) {
            return "\r\n\r\n".getBytes();
        }
        // JvB: added to fix case where application provides the wrong transport
        // in the topmost Via header
        ViaHeader topVia = (ViaHeader) this.getHeader(ViaHeader.NAME);
        try {
            topVia.setTransport(transport);
        } catch (ParseException e) {
            InternalErrorHandler.handleException(e);
        }

        StringBuffer encoding = new StringBuffer();
        synchronized (this.headers) {
            Iterator<SIPHeader> it = this.headers.iterator();

            while (it.hasNext()) {
                SIPHeader siphdr = (SIPHeader) it.next();
                if (!(siphdr instanceof ContentLength))
                    siphdr.encode(encoding);

            }
        }
        contentLengthHeader.encode(encoding);
        encoding.append(NEWLINE);

        byte[] retval = null;
        byte[] content = this.getRawContent();
        if (content != null) {
            // Append the content

            byte[] msgarray = null;
            try {
                msgarray = encoding.toString().getBytes( getCharset() );
            } catch (UnsupportedEncodingException ex) {
                InternalErrorHandler.handleException(ex);
            }

            retval = new byte[msgarray.length + content.length];
            System.arraycopy(msgarray, 0, retval, 0, msgarray.length);
            System.arraycopy(content, 0, retval, msgarray.length, content.length);
        } else {
            // Message content does not exist.

            try {
                retval = encoding.toString().getBytes( getCharset() );
            } catch (UnsupportedEncodingException ex) {
                InternalErrorHandler.handleException(ex);
            }
        }
        return retval;
    }

    /**
     * clone this message (create a new deep physical copy). All headers in the message are
     * cloned. You can modify the cloned copy without affecting the original. The content is
     * handled as follows: If the content is a String, or a byte array, a new copy of the content
     * is allocated and copied over. If the content is an Object that supports the clone method,
     * then the clone method is invoked and the cloned content is the new content. Otherwise, the
     * content of the new message is set equal to the old one.
     * 
     * @return A cloned copy of this object.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.183 -0500", hash_original_method = "CAA2D0A800A8BA91CFE25E08D1466992", hash_generated_method = "441794B8EC21652DE9A4976EB05D7714")
    
public Object clone() {
        SIPMessage retval = (SIPMessage) super.clone();
        retval.nameTable = new Hashtable<String, SIPHeader>();
        retval.fromHeader = null;
        retval.toHeader = null;
        retval.cSeqHeader = null;
        retval.callIdHeader = null;
        retval.contentLengthHeader = null;
        retval.maxForwardsHeader = null;
        if (this.headers != null) {
            retval.headers = new ConcurrentLinkedQueue<SIPHeader>();
            for (Iterator<SIPHeader> iter = headers.iterator(); iter.hasNext();) {
                SIPHeader hdr = (SIPHeader) iter.next();
                retval.attachHeader((SIPHeader) hdr.clone());
            }

        }
        if (this.messageContentBytes != null)
            retval.messageContentBytes = (byte[]) this.messageContentBytes.clone();
        if (this.messageContentObject != null)
            retval.messageContentObject = makeClone(messageContentObject);
        retval.unrecognizedHeaders = this.unrecognizedHeaders;
        return retval;
    }

    /**
     * Get the string representation of this header (for pretty printing the generated structure).
     * 
     * @return Formatted string representation of the object. Note that this is NOT the same as
     *         encode(). This is used mainly for debugging purposes.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.187 -0500", hash_original_method = "CE435A19EF4C3C8ADC65C5BBD44452BB", hash_generated_method = "90F835D7DA784CAC2638DF85A20787B0")
    
public String debugDump() {
        stringRepresentation = "";
        sprint("SIPMessage:");
        sprint("{");
        try {

            Field[] fields = this.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                Class< ? > fieldType = f.getType();
                String fieldName = f.getName();
                if (f.get(this) != null && SIPHeader.class.isAssignableFrom(fieldType)
                        && fieldName.compareTo("headers") != 0) {
                    sprint(fieldName + "=");
                    sprint(((SIPHeader) f.get(this)).debugDump());
                }
            }
        } catch (Exception ex) {
            InternalErrorHandler.handleException(ex);
        }

        sprint("List of headers : ");
        sprint(headers.toString());
        sprint("messageContent = ");
        sprint("{");
        sprint(messageContent);
        sprint("}");
        if (this.getContent() != null) {
            sprint(this.getContent().toString());
        }
        sprint("}");
        return stringRepresentation;
    }

    /**
     * Attach a header and die if you get a duplicate header exception.
     * 
     * @param h SIPHeader to attach.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.192 -0500", hash_original_method = "D9E90811A837F48EC447FF925318738A", hash_generated_method = "A2FD5EC2E0763D8225EB819393C96237")
    
private void attachHeader(SIPHeader h) {
        if (h == null)
            throw new IllegalArgumentException("null header!");
        try {
            if (h instanceof SIPHeaderList) {
                SIPHeaderList< ? > hl = (SIPHeaderList< ? >) h;
                if (hl.isEmpty()) {
                    return;
                }
            }
            attachHeader(h, false, false);
        } catch (SIPDuplicateHeaderException ex) {
            // InternalErrorHandler.handleException(ex);
        }
    }

    /**
     * Attach a header (replacing the original header).
     * 
     * @param sipHeader SIPHeader that replaces a header of the same type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.195 -0500", hash_original_method = "230B17E5A17A83111BEC4A023E8D6F14", hash_generated_method = "3929740DCAB0E0E751C3FF7FDBE1A66E")
    
public void setHeader(Header sipHeader) {
        SIPHeader header = (SIPHeader) sipHeader;
        if (header == null)
            throw new IllegalArgumentException("null header!");
        try {
            if (header instanceof SIPHeaderList) {
                SIPHeaderList< ? > hl = (SIPHeaderList< ? >) header;
                // Ignore empty lists.
                if (hl.isEmpty())
                    return;
            }
            this.removeHeader(header.getHeaderName());
            attachHeader(header, true, false);
        } catch (SIPDuplicateHeaderException ex) {
            InternalErrorHandler.handleException(ex);
        }
    }

    /**
     * Set a header from a linked list of headers.
     * 
     * @param headers -- a list of headers to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.198 -0500", hash_original_method = "DC88726E428D89A7A7082B0D5F94DA0F", hash_generated_method = "DEB60F5AF83C454D29723281F3124C15")
    
public void setHeaders(java.util.List<SIPHeader> headers) {
        ListIterator<SIPHeader> listIterator = headers.listIterator();
        while (listIterator.hasNext()) {
            SIPHeader sipHeader = (SIPHeader) listIterator.next();
            try {
                this.attachHeader(sipHeader, false);
            } catch (SIPDuplicateHeaderException ex) {
            }
        }
    }

    /**
     * Attach a header to the end of the existing headers in this SIPMessage structure. This is
     * equivalent to the attachHeader(SIPHeader,replaceflag,false); which is the normal way in
     * which headers are attached. This was added in support of JAIN-SIP.
     * 
     * @param h header to attach.
     * @param replaceflag if true then replace a header if it exists.
     * @throws SIPDuplicateHeaderException If replaceFlag is false and only a singleton header is
     *         allowed (fpr example CSeq).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.200 -0500", hash_original_method = "9B17545BC9FC78AB24684381D78F3E60", hash_generated_method = "B0127195EE15F0D896422C96B48C4A06")
    
public void attachHeader(SIPHeader h, boolean replaceflag) throws SIPDuplicateHeaderException {
        this.attachHeader(h, replaceflag, false);
    }

    /**
     * Attach the header to the SIP Message structure at a specified position in its list of
     * headers.
     * 
     * @param header Header to attach.
     * @param replaceFlag If true then replace the existing header.
     * @param top Location in the header list to insert the header.
     * @exception SIPDuplicateHeaderException if the header is of a type that cannot tolerate
     *            duplicates and one of this type already exists (e.g. CSeq header).
     * @throws IndexOutOfBoundsException If the index specified is greater than the number of
     *         headers that are in this message.
     */

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.204 -0500", hash_original_method = "7BE2AED7224623BF9774680F8F08FE9F", hash_generated_method = "F69412DD175DEC64229D6EA1510505DB")
    
public void attachHeader(SIPHeader header, boolean replaceFlag, boolean top)
            throws SIPDuplicateHeaderException {
        if (header == null) {
            throw new NullPointerException("null header");
        }

        SIPHeader h;

        if (ListMap.hasList(header) && !SIPHeaderList.class.isAssignableFrom(header.getClass())) {
            SIPHeaderList<SIPHeader> hdrList = ListMap.getList(header);
            hdrList.add(header);
            h = hdrList;
        } else {
            h = header;
        }

        String headerNameLowerCase = SIPHeaderNamesCache.toLowerCase(h.getName());
        if (replaceFlag) {
            nameTable.remove(headerNameLowerCase);
        } else if (nameTable.containsKey(headerNameLowerCase) && !(h instanceof SIPHeaderList)) {
            if (h instanceof ContentLength) {
                try {
                    ContentLength cl = (ContentLength) h;
                    contentLengthHeader.setContentLength(cl.getContentLength());
                } catch (InvalidArgumentException e) {
                }
            }
            // Just ignore duplicate header.
            return;
        }

        SIPHeader originalHeader = (SIPHeader) getHeader(header.getName());

        // Delete the original header from our list structure.
        if (originalHeader != null) {
            Iterator<SIPHeader> li = headers.iterator();
            while (li.hasNext()) {
                SIPHeader next = (SIPHeader) li.next();
                if (next.equals(originalHeader)) {
                    li.remove();
                }
            }
        }

        if (!nameTable.containsKey(headerNameLowerCase)) {
            nameTable.put(headerNameLowerCase, h);
            headers.add(h);
        } else {
            if (h instanceof SIPHeaderList) {
                SIPHeaderList< ? > hdrlist = (SIPHeaderList< ? >) nameTable
                        .get(headerNameLowerCase);
                if (hdrlist != null)
                    hdrlist.concatenate((SIPHeaderList) h, top);
                else
                    nameTable.put(headerNameLowerCase, h);
            } else {
                nameTable.put(headerNameLowerCase, h);
            }
        }

        // Direct accessor fields for frequently accessed headers.
        if (h instanceof From) {
            this.fromHeader = (From) h;
        } else if (h instanceof ContentLength) {
            this.contentLengthHeader = (ContentLength) h;
        } else if (h instanceof To) {
            this.toHeader = (To) h;
        } else if (h instanceof CSeq) {
            this.cSeqHeader = (CSeq) h;
        } else if (h instanceof CallID) {
            this.callIdHeader = (CallID) h;
        } else if (h instanceof MaxForwards) {
            this.maxForwardsHeader = (MaxForwards) h;
        }

    }

    /**
     * Remove a header given its name. If multiple headers of a given name are present then the
     * top flag determines which end to remove headers from.
     * 
     * @param headerName is the name of the header to remove.
     * @param top -- flag that indicates which end of header list to process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.208 -0500", hash_original_method = "870FE8D30093D63C50FAB8B7342DE2BD", hash_generated_method = "2DF442C7007651007CABB20199113E6A")
    
public void removeHeader(String headerName, boolean top) {

        String headerNameLowerCase = SIPHeaderNamesCache.toLowerCase(headerName);
        SIPHeader toRemove = (SIPHeader) nameTable.get(headerNameLowerCase);
        // nothing to do then we are done.
        if (toRemove == null)
            return;
        if (toRemove instanceof SIPHeaderList) {
            SIPHeaderList< ? > hdrList = (SIPHeaderList< ? >) toRemove;
            if (top)
                hdrList.removeFirst();
            else
                hdrList.removeLast();
            // Clean up empty list
            if (hdrList.isEmpty()) {
                Iterator<SIPHeader> li = this.headers.iterator();
                while (li.hasNext()) {
                    SIPHeader sipHeader = (SIPHeader) li.next();
                    if (sipHeader.getName().equalsIgnoreCase(headerNameLowerCase))
                        li.remove();
                }

                // JvB: also remove it from the nameTable! Else NPE in
                // DefaultRouter
                nameTable.remove(headerNameLowerCase);
            }
        } else {
            this.nameTable.remove(headerNameLowerCase);
            if (toRemove instanceof From) {
                this.fromHeader = null;
            } else if (toRemove instanceof To) {
                this.toHeader = null;
            } else if (toRemove instanceof CSeq) {
                this.cSeqHeader = null;
            } else if (toRemove instanceof CallID) {
                this.callIdHeader = null;
            } else if (toRemove instanceof MaxForwards) {
                this.maxForwardsHeader = null;
            } else if (toRemove instanceof ContentLength) {
                this.contentLengthHeader = null;
            }
            Iterator<SIPHeader> li = this.headers.iterator();
            while (li.hasNext()) {
                SIPHeader sipHeader = (SIPHeader) li.next();
                if (sipHeader.getName().equalsIgnoreCase(headerName))
                    li.remove();
            }
        }

    }

    /**
     * Remove all headers given its name.
     * 
     * @param headerName is the name of the header to remove.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.212 -0500", hash_original_method = "A43C3FE911C5904FA81F0CAD0EBF40FE", hash_generated_method = "FEE0D3B3776658FFDE2128592D10D6E6")
    
public void removeHeader(String headerName) {

        if (headerName == null)
            throw new NullPointerException("null arg");
        String headerNameLowerCase = SIPHeaderNamesCache.toLowerCase(headerName);
        SIPHeader removed = (SIPHeader) nameTable.remove(headerNameLowerCase);
        // nothing to do then we are done.
        if (removed == null)
            return;

        // Remove the fast accessor fields.
        if (removed instanceof From) {
            this.fromHeader = null;
        } else if (removed instanceof To) {
            this.toHeader = null;
        } else if (removed instanceof CSeq) {
            this.cSeqHeader = null;
        } else if (removed instanceof CallID) {
            this.callIdHeader = null;
        } else if (removed instanceof MaxForwards) {
            this.maxForwardsHeader = null;
        } else if (removed instanceof ContentLength) {
            this.contentLengthHeader = null;
        }

        Iterator<SIPHeader> li = this.headers.iterator();
        while (li.hasNext()) {
            SIPHeader sipHeader = (SIPHeader) li.next();
            if (sipHeader.getName().equalsIgnoreCase(headerNameLowerCase))
                li.remove();

        }
    }

    /**
     * Generate (compute) a transaction ID for this SIP message.
     * 
     * @return A string containing the concatenation of various portions of the From,To,Via and
     *         RequestURI portions of this message as specified in RFC 2543: All responses to a
     *         request contain the same values in the Call-ID, CSeq, To, and From fields (with the
     *         possible addition of a tag in the To field (section 10.43)). This allows responses
     *         to be matched with requests. Incorporates a bug fix for a bug sent in by Gordon
     *         Ledgard of IPera for generating transactionIDs when no port is present in the via
     *         header. Incorporates a bug fix for a bug report sent in by Chris Mills of Nortel
     *         Networks (converts to lower case when returning the transaction identifier).
     * 
     * @return a string that can be used as a transaction identifier for this message. This can be
     *         used for matching responses and requests (i.e. an outgoing request and its matching
     *         response have the same computed transaction identifier).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.215 -0500", hash_original_method = "04B79D458A896A4F330B98FD27925CCB", hash_generated_method = "8CB9CE1A8CD3290AC02DA0C251F9494A")
    
public String getTransactionId() {
        Via topVia = null;
        if (!this.getViaHeaders().isEmpty()) {
            topVia = (Via) this.getViaHeaders().getFirst();
        }
        // Have specified a branch Identifier so we can use it to identify
        // the transaction. BranchId is not case sensitive.
        // Branch Id prefix is not case sensitive.
        if (topVia != null
                && topVia.getBranch() != null
                && topVia.getBranch().toUpperCase().startsWith(
                        SIPConstants.BRANCH_MAGIC_COOKIE_UPPER_CASE)) {
            // Bis 09 compatible branch assignment algorithm.
            // implies that the branch id can be used as a transaction
            // identifier.
            if (this.getCSeq().getMethod().equals(Request.CANCEL))
                return (topVia.getBranch() + ":" + this.getCSeq().getMethod()).toLowerCase();
            else
                return topVia.getBranch().toLowerCase();
        } else {
            // Old style client so construct the transaction identifier
            // from various fields of the request.
            StringBuffer retval = new StringBuffer();
            From from = (From) this.getFrom();
            To to = (To) this.getTo();
            // String hpFrom = from.getUserAtHostPort();
            // retval.append(hpFrom).append(":");
            if (from.hasTag())
                retval.append(from.getTag()).append("-");
            // String hpTo = to.getUserAtHostPort();
            // retval.append(hpTo).append(":");
            String cid = this.callIdHeader.getCallId();
            retval.append(cid).append("-");
            retval.append(this.cSeqHeader.getSequenceNumber()).append("-").append(
                    this.cSeqHeader.getMethod());
            if (topVia != null) {
                retval.append("-").append(topVia.getSentBy().encode());
                if (!topVia.getSentBy().hasPort()) {
                    retval.append("-").append(5060);
                }
            }
            if (this.getCSeq().getMethod().equals(Request.CANCEL)) {
                retval.append(Request.CANCEL);
            }
            return retval.toString().toLowerCase().replace(":", "-").replace("@", "-")
                    + Utils.getSignature();
        }
    }

    /**
     * Override the hashcode method ( see issue # 55 ) Note that if you try to use this method
     * before you assemble a valid request, you will get a constant ( -1 ). Beware of placing any
     * half formed requests in a table.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.218 -0500", hash_original_method = "2D96B4A52CFB118A97F95400511B110F", hash_generated_method = "F18BD120E60C62335D3C70E4A429E621")
    
public int hashCode() {
        if (this.callIdHeader == null)
            throw new RuntimeException(
                    "Invalid message! Cannot compute hashcode! call-id header is missing !");
        else
            return this.callIdHeader.getCallId().hashCode();
    }

    /**
     * Return true if this message has a body.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.220 -0500", hash_original_method = "0B4068F7FDD81C59C44EF10BE948C047", hash_generated_method = "8A5C333F1592F8A628699A0C7F79AED9")
    
public boolean hasContent() {
        return messageContent != null || messageContentBytes != null;
    }

    /**
     * Return an iterator for the list of headers in this message.
     * 
     * @return an Iterator for the headers of this message.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.223 -0500", hash_original_method = "16CF6C29A1D923EBFDFB9DE65000093A", hash_generated_method = "A3CBBCB183B159EC9B6AF6FBB6F89D38")
    
public Iterator<SIPHeader> getHeaders() {
        return headers.iterator();
    }

    /**
     * Get the first header of the given name.
     * 
     * @return header -- the first header of the given name.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.225 -0500", hash_original_method = "1ADD77F2239C280F0A32414969B68312", hash_generated_method = "C0D099FDF35CAB36C6CF8318CEF8301C")
    
public Header getHeader(String headerName) {
        return getHeaderLowerCase(SIPHeaderNamesCache.toLowerCase(headerName));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.227 -0500", hash_original_method = "32A79E235DDCC6E80E2B12189B346373", hash_generated_method = "DF5E82B9478109623784FE7AD0341CB9")
    
private Header getHeaderLowerCase(String lowerCaseHeaderName) {
        if (lowerCaseHeaderName == null)
            throw new NullPointerException("bad name");
        SIPHeader sipHeader = (SIPHeader) nameTable.get(lowerCaseHeaderName);
        if (sipHeader instanceof SIPHeaderList)
            return (Header) ((SIPHeaderList) sipHeader).getFirst();
        else
            return (Header) sipHeader;
    }

    /**
     * Get the contentType header (null if one does not exist).
     * 
     * @return contentType header
     */
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.230 -0500", hash_original_method = "094433154D44236D0991BBCF366E0E6A", hash_generated_method = "F5209DB546C0F6B4EF27600A0DC37C79")
    
public ContentType getContentTypeHeader() {
        return (ContentType) getHeaderLowerCase(CONTENT_TYPE_LOWERCASE);
    }
    
    /**
     * Get the contentLength header.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.236 -0500", hash_original_method = "F29DC29143C65AC3E05B010248583D2F", hash_generated_method = "E813B40A5EE8BDEA0B9AC78A309C0341")
    
public ContentLengthHeader getContentLengthHeader() {
        return this.getContentLength();
    }
  
    /**
     * Get the from header.
     * 
     * @return -- the from header.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.238 -0500", hash_original_method = "E10DCB9A2200DABE5E8DE063DD5342F3", hash_generated_method = "E8D18277FE70FA5C9B0BB7C991AC9988")
    
public FromHeader getFrom() {
        return (FromHeader) fromHeader;
    }

    /**
     * Get the ErrorInfo list of headers (null if one does not exist).
     * 
     * @return List containing ErrorInfo headers.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.241 -0500", hash_original_method = "10D7F219ADDA2D1F9DA30C2C2F401D03", hash_generated_method = "4C3518C0D5E2EA7DE26B9F6A997DB938")
    
public ErrorInfoList getErrorInfoHeaders() {
        return (ErrorInfoList) getSIPHeaderListLowerCase(ERROR_LOWERCASE);
    }

    /**
     * Get the Contact list of headers (null if one does not exist).
     * 
     * @return List containing Contact headers.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.246 -0500", hash_original_method = "6BBB646E6D7D64808CC70B68BEB17C86", hash_generated_method = "63B9CDDC16CEAD0C74F58EA4B07DA9DF")
    
public ContactList getContactHeaders() {
        return (ContactList) this.getSIPHeaderListLowerCase(CONTACT_LOWERCASE);
    }

    /**
     * Get the contact header ( the first contact header) which is all we need for the most part.
     * 
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.251 -0500", hash_original_method = "7930A8382B37585900D6B0ADAEF5E908", hash_generated_method = "2ADC15288826236ADC6853FD36B7F468")
    
public Contact getContactHeader() {
        ContactList clist = this.getContactHeaders();
        if (clist != null) {
            return (Contact) clist.getFirst();

        } else {
            return null;
        }
    }

    /**
     * Get the Via list of headers (null if one does not exist).
     * 
     * @return List containing Via headers.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.254 -0500", hash_original_method = "F913627528E03E7BE96F6FC26EC1EAB5", hash_generated_method = "F1C8E308C74B320D7496C23E00A590AA")
    
public ViaList getViaHeaders() {
        return (ViaList) getSIPHeaderListLowerCase(VIA_LOWERCASE);
    }

    /**
     * Set A list of via headers.
     * 
     * @param viaList a list of via headers to add.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.259 -0500", hash_original_method = "4714C62FF03EE4A312864AB7EDBC16A3", hash_generated_method = "127ADB3CC5A4E85E1E5FD896AFD05BD7")
    
public void setVia(java.util.List viaList) {
        ViaList vList = new ViaList();
        ListIterator it = viaList.listIterator();
        while (it.hasNext()) {
            Via via = (Via) it.next();
            vList.add(via);
        }
        this.setHeader(vList);
    }

    /**
     * Set the header given a list of headers.
     * 
     * @param sipHeaderList a headerList to set
     */

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.262 -0500", hash_original_method = "458FFC69EFF172F74B60E661629859D7", hash_generated_method = "C64029C85E2CF2EE28CB0520C141718E")
    
public void setHeader(SIPHeaderList<Via> sipHeaderList) {
        this.setHeader((Header) sipHeaderList);
    }

    /**
     * Get the topmost via header.
     * 
     * @return the top most via header if one exists or null if none exists.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.264 -0500", hash_original_method = "D8225C1F89A591B431137F8AC67C8011", hash_generated_method = "72FEE0AE3DE5A492EA5E2BC8DA97CEF5")
    
public Via getTopmostVia() {
        if (this.getViaHeaders() == null)
            return null;
        else
            return (Via) (getViaHeaders().getFirst());
    }

    /**
     * Get the CSeq list of header (null if one does not exist).
     * 
     * @return CSeq header
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.267 -0500", hash_original_method = "734B287C3C9508BBD63962A2764D9C01", hash_generated_method = "9C7BCFC7FADB19E10C43CC4B2AA78768")
    
public CSeqHeader getCSeq() {
        return (CSeqHeader) cSeqHeader;
    }

    /**
     * Get the Authorization header (null if one does not exist).
     * 
     * @return Authorization header.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.269 -0500", hash_original_method = "6A92E6492A4EA537FE7E1089912E5A2E", hash_generated_method = "FF948DA769F88316039690A89A505B46")
    
public Authorization getAuthorization() {
        return (Authorization) getHeaderLowerCase(AUTHORIZATION_LOWERCASE);
    }

    /**
     * Get the MaxForwards header (null if one does not exist).
     * 
     * @return Max-Forwards header
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.274 -0500", hash_original_method = "1941B7A53D19F77542CA45C05AFF9884", hash_generated_method = "CE66032576DFD2CE16D4E789AC1836E1")
    
public MaxForwardsHeader getMaxForwards() {
        return maxForwardsHeader;
    }

    /**
     * Set the max forwards header.
     * 
     * @param maxForwards is the MaxForwardsHeader to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.277 -0500", hash_original_method = "08224707CDDBB2C37148D3B618E2B6B7", hash_generated_method = "F2F17709C19C48B580725AF9B3ADD9AA")
    
public void setMaxForwards(MaxForwardsHeader maxForwards) {
        this.setHeader(maxForwards);
    }

    /**
     * Get the Route List of headers (null if one does not exist).
     * 
     * @return List containing Route headers
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.279 -0500", hash_original_method = "7800F88C4B689BC7D7C78CBE850678CA", hash_generated_method = "29EC90BAB917556FE014629ED8F0ADAA")
    
public RouteList getRouteHeaders() {
        return (RouteList) getSIPHeaderListLowerCase(ROUTE_LOWERCASE);
    }

    /**
     * Get the CallID header (null if one does not exist)
     * 
     * @return Call-ID header .
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.284 -0500", hash_original_method = "9DA69A74904D39D3267E3E1010C409F3", hash_generated_method = "22CD19FCA90C7D5D3294D66B4E3C86CE")
    
public CallIdHeader getCallId() {
        return callIdHeader;
    }

    /**
     * Set the call id header.
     * 
     * @param callId call idHeader (what else could it be?)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.287 -0500", hash_original_method = "5127E494FA29164B5CB6A74D7F3B176F", hash_generated_method = "5187B7DBB417886A8E6B85AB5844C52A")
    
public void setCallId(CallIdHeader callId) {
        this.setHeader(callId);
    }

    /**
     * Get the CallID header (null if one does not exist)
     * 
     * @param callId -- the call identifier to be assigned to the call id header
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.289 -0500", hash_original_method = "16037BFD4917B839A558D81FBF251209", hash_generated_method = "40F37147C0A24EBFED7983181C26D53B")
    
public void setCallId(String callId) throws java.text.ParseException {
        if (callIdHeader == null) {
            this.setHeader(new CallID());
        }
        callIdHeader.setCallId(callId);
    }

    /**
     * Get the RecordRoute header list (null if one does not exist).
     * 
     * @return Record-Route header
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.292 -0500", hash_original_method = "6FCB806D3659BA1DF59CA318834E3C35", hash_generated_method = "856DF26E31E706BBFA9D3469EDE3B241")
    
public RecordRouteList getRecordRouteHeaders() {
        return (RecordRouteList) this.getSIPHeaderListLowerCase(RECORDROUTE_LOWERCASE);
    }

    /**
     * Get the To header (null if one does not exist).
     * 
     * @return To header
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.297 -0500", hash_original_method = "D2F3523F315E42C3CDB78FE4D7DBD860", hash_generated_method = "7BA193BDADD87EFDA6C02494898A6335")
    
public ToHeader getTo() {
        return (ToHeader) toHeader;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.300 -0500", hash_original_method = "AA146219F068967CE3F55E3F637E86D7", hash_generated_method = "584E1B9F567812CE8D67E03FFDEFCBE6")
    
public void setTo(ToHeader to) {
        this.setHeader(to);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.302 -0500", hash_original_method = "61E9A0C02A79622F4076A17D3E8275D9", hash_generated_method = "895A6A77D1B6D97903FD6B4D08578276")
    
public void setFrom(FromHeader from) {
        this.setHeader(from);

    }

    /**
     * Get the ContentLength header (null if one does not exist).
     * 
     * @return content-length header.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.305 -0500", hash_original_method = "BF14C97BBADF5B6B3DD1A606FFB97154", hash_generated_method = "F0B966CFF8D9137BFEF2C3552BE980B2")
    
public ContentLengthHeader getContentLength() {
        return this.contentLengthHeader;
    }

    /**
     * Get the message body as a string. If the message contains a content type header with a
     * specified charset, and if the payload has been read as a byte array, then it is returned
     * encoded into this charset.
     * 
     * @return Message body (as a string)
     * @throws UnsupportedEncodingException if the platform does not support the charset specified
     *         in the content type header.
     * 
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.307 -0500", hash_original_method = "40D47E0A8FD809ED2EC3170259DB7692", hash_generated_method = "91A45F58E83E8E0C9A71BD68F698CFEF")
    
public String getMessageContent() throws UnsupportedEncodingException {
        if (this.messageContent == null && this.messageContentBytes == null)
            return null;
        else if (this.messageContent == null) {
            this.messageContent = new String(messageContentBytes, getCharset() );
        }
        return this.messageContent;
    }

    /**
     * Get the message content as an array of bytes. If the payload has been read as a String then
     * it is decoded using the charset specified in the content type header if it exists.
     * Otherwise, it is encoded using the default encoding which is UTF-8.
     * 
     * @return an array of bytes that is the message payload.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.310 -0500", hash_original_method = "0A8A11F2CA57642B3F77F3FF48221ABE", hash_generated_method = "5B262A6CC099D5D8507D75CC43FD2D0F")
    
public byte[] getRawContent() {
        try {
            if ( this.messageContentBytes != null ) {
                // return messageContentBytes;
            } else if (this.messageContentObject != null) {
                String messageContent = this.messageContentObject.toString();
                this.messageContentBytes = messageContent.getBytes( getCharset() );
            } else if (this.messageContent != null) {
            	this.messageContentBytes = messageContent.getBytes( getCharset() );                
            }
            return this.messageContentBytes;
        } catch (UnsupportedEncodingException ex) {
            InternalErrorHandler.handleException(ex);
            return null;
        }
    }

    /**
     * Set the message content given type and subtype.
     * 
     * @param type is the message type (eg. application)
     * @param subType is the message sybtype (eg. sdp)
     * @param messageContent is the messge content as a string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.312 -0500", hash_original_method = "AF476AB0E969B944040525792C5BC52E", hash_generated_method = "2C745353340FDE6689442F24793980E2")
    
public void setMessageContent(String type, String subType, String messageContent) {
        if (messageContent == null)
            throw new IllegalArgumentException("messgeContent is null");
        ContentType ct = new ContentType(type, subType);
        this.setHeader(ct);
        this.messageContent = messageContent;
        this.messageContentBytes = null;
        this.messageContentObject = null;
        // Could be double byte so we need to compute length
        // after converting to byte[]
        computeContentLength(messageContent);
    }

    /**
     * Set the message content after converting the given object to a String.
     * 
     * @param content -- content to set.
     * @param contentTypeHeader -- content type header corresponding to content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.315 -0500", hash_original_method = "F6727728B1118BFFD3FCC04534FCE621", hash_generated_method = "D93E5BD467C441FA363684ED9989C687")
    
public void setContent(Object content, ContentTypeHeader contentTypeHeader)
            throws ParseException {
        if (content == null)
            throw new NullPointerException("null content");
        this.setHeader(contentTypeHeader);

        this.messageContent = null;
        this.messageContentBytes = null;
        this.messageContentObject = null;

        if (content instanceof String) {
            this.messageContent = (String) content;
        } else if (content instanceof byte[]) {
            this.messageContentBytes = (byte[]) content;
        } else
            this.messageContentObject = content;

        computeContentLength(content);
    }

    /**
     * Get the content (body) of the message.
     * 
     * @return the content of the sip message.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.318 -0500", hash_original_method = "54FC52177A1CB92C02565C30A4F8CE94", hash_generated_method = "81F53B3012E132FF8110E84E51FC5468")
    
public Object getContent() {
        if (this.messageContentObject != null)
            return messageContentObject;
        else if (this.messageContent != null)
            return this.messageContent;
        else if (this.messageContentBytes != null)
            return this.messageContentBytes;
        else
            return null;
    }

    /**
     * Set the message content for a given type and subtype.
     * 
     * @param type is the messge type.
     * @param subType is the message subType.
     * @param messageContent is the message content as a byte array.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.321 -0500", hash_original_method = "567464035ABE474ACDCFF614F9D534B5", hash_generated_method = "D820D8BA2A766F41CE770386C33A80DA")
    
public void setMessageContent(String type, String subType, byte[] messageContent) {
        ContentType ct = new ContentType(type, subType);
        this.setHeader(ct);
        this.setMessageContent(messageContent);

        computeContentLength(messageContent);
    }

    /**
     * Set the message content for this message.
     * 
     * @param content Message body as a string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.324 -0500", hash_original_method = "39F2BE1EDB04320A3B64ACD0EA831DED", hash_generated_method = "57759FEBDA887BE74C58B8C4AF545152")
    
public void setMessageContent(String content, boolean strict, boolean computeContentLength, int givenLength)
            throws ParseException {
        // Note that that this could be a double byte character
        // set - bug report by Masafumi Watanabe
        computeContentLength(content);
        if ((!computeContentLength)) {
            if ( (!strict && this.contentLengthHeader.getContentLength() != givenLength) 
                    || this.contentLengthHeader.getContentLength() < givenLength) {
                throw new ParseException("Invalid content length "
                        + this.contentLengthHeader.getContentLength() + " / " + givenLength, 0);
            }
        }

        messageContent = content;
        messageContentBytes = null;
        messageContentObject = null;
    }

    /**
     * Set the message content as an array of bytes.
     * 
     * @param content is the content of the message as an array of bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.326 -0500", hash_original_method = "19C7E154661732280AD152F3E186944D", hash_generated_method = "C099A98C484C295608B671C6583CD87A")
    
public void setMessageContent(byte[] content) {
        computeContentLength(content);

        messageContentBytes = content;
        messageContent = null;
        messageContentObject = null;
    }

    /**
     * Method to set the content - called by the parser
     * 
     * @param content
     * @throws ParseException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.329 -0500", hash_original_method = "677A53CE4E6B4035F9B12FCECD3E865E", hash_generated_method = "7FF05BFF3D979612F7767A0B8657776D")
    
public void setMessageContent(byte[] content, boolean computeContentLength, int givenLength)
            throws ParseException {
        computeContentLength(content);
        if ((!computeContentLength) && this.contentLengthHeader.getContentLength() < givenLength) {
            // System.out.println("!!!!!!!!!!! MISMATCH !!!!!!!!!!!");
            throw new ParseException("Invalid content length "
                    + this.contentLengthHeader.getContentLength() + " / " + givenLength, 0);
        }
        messageContentBytes = content;
        messageContent = null;
        messageContentObject = null;
    }

    /**
     * Compute and set the Content-length header based on the given content object.
     * 
     * @param content is the content, as String, array of bytes, or other object.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.331 -0500", hash_original_method = "D3327D918F93ECC2995A4C67A415A1A5", hash_generated_method = "8E37A790165C92EF426C2052DDFE3B26")
    
private void computeContentLength(Object content) {
        int length = 0;
        if (content != null) {
            if (content instanceof String) {
                try {
                    length = ((String) content).getBytes( getCharset() ).length;
                } catch (UnsupportedEncodingException ex) {
                    InternalErrorHandler.handleException(ex);
                }
            } else if (content instanceof byte[]) {
                length = ((byte[]) content).length;
            } else {
                length = content.toString().length();
            }
        }

        try {
            contentLengthHeader.setContentLength(length);
        } catch (InvalidArgumentException e) {
            // Cannot happen.
        }
    }

    /**
     * Remove the message content if it exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.334 -0500", hash_original_method = "B09AA5FB20D2965ADCD41D53860CDBE3", hash_generated_method = "7DFF009D87BCA317F9EE751CF2E0CEE5")
    
public void removeContent() {
        messageContent = null;
        messageContentBytes = null;
        messageContentObject = null;
        try {
            this.contentLengthHeader.setContentLength(0);
        } catch (InvalidArgumentException ex) {
        }
    }

    /**
     * Get a SIP header or Header list given its name.
     * 
     * @param headerName is the name of the header to get.
     * @return a header or header list that contians the retrieved header.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.337 -0500", hash_original_method = "B51D33B6E886062DB169564C9DA9DCD8", hash_generated_method = "1B50EDCA294B397004721F77C292A540")
    
@SuppressWarnings("unchecked")
    public ListIterator<SIPHeader> getHeaders(String headerName) {
        if (headerName == null)
            throw new NullPointerException("null headerName");
        SIPHeader sipHeader = (SIPHeader) nameTable.get(SIPHeaderNamesCache
                .toLowerCase(headerName));
        // empty iterator
        if (sipHeader == null)
            return new LinkedList<SIPHeader>().listIterator();
        if (sipHeader instanceof SIPHeaderList) {
            return ((SIPHeaderList<SIPHeader>) sipHeader).listIterator();
        } else {
            return new HeaderIterator(this, sipHeader);
        }
    }

    /**
     * Get a header of the given name as a string. This concatenates the headers of a given type
     * as a comma separted list. This is useful for formatting and printing headers.
     * 
     * @param name
     * @return the header as a formatted string
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.340 -0500", hash_original_method = "6CE50AA271DA9876F1700D8E280EAFD1", hash_generated_method = "526268425EE69EAEA90E09A7AEFA5289")
    
public String getHeaderAsFormattedString(String name) {
        String lowerCaseName = name.toLowerCase();
        if (this.nameTable.containsKey(lowerCaseName)) {
            return this.nameTable.get(lowerCaseName).toString();
        } else {
            return this.getHeader(name).toString();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.342 -0500", hash_original_method = "2723C6F27F309BF6F386C5DF25AB6032", hash_generated_method = "707C13AAAB45AFB25F3F4B754361CFE4")
    
private SIPHeader getSIPHeaderListLowerCase(String lowerCaseHeaderName) {
        return nameTable.get(lowerCaseHeaderName);
    }

    /**
     * Get a list of headers of the given name ( or null if no such header exists ).
     * 
     * @param headerName -- a header name from which to retrieve the list.
     * @return -- a list of headers with that name.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.346 -0500", hash_original_method = "9F4B7A8AFA1B725FEEE6FA6CFA2755DF", hash_generated_method = "7DBC8A25724003A6F1BD2592E626EC3B")
    
@SuppressWarnings("unchecked")
    private List<SIPHeader> getHeaderList(String headerName) {
        SIPHeader sipHeader = (SIPHeader) nameTable.get(SIPHeaderNamesCache
                .toLowerCase(headerName));
        if (sipHeader == null)
            return null;
        else if (sipHeader instanceof SIPHeaderList)
            return (List<SIPHeader>) (((SIPHeaderList< ? >) sipHeader).getHeaderList());
        else {
            LinkedList<SIPHeader> ll = new LinkedList<SIPHeader>();
            ll.add(sipHeader);
            return ll;
        }
    }

    /**
     * Return true if the SIPMessage has a header of the given name.
     * 
     * @param headerName is the header name for which we are testing.
     * @return true if the header is present in the message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.348 -0500", hash_original_method = "6DBF8105DE4FD1DC6BA28CCFFFEEC680", hash_generated_method = "0A6E046B702B545853452B92F52A7A20")
    
public boolean hasHeader(String headerName) {
        return nameTable.containsKey(SIPHeaderNamesCache.toLowerCase(headerName));
    }

    /**
     * Return true if the message has a From header tag.
     * 
     * @return true if the message has a from header and that header has a tag.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.351 -0500", hash_original_method = "4231E4F79F4F1EB89656879CE689B66E", hash_generated_method = "60E0AAF98D4945D7E3879F184AF66CAD")
    
public boolean hasFromTag() {
        return fromHeader != null && fromHeader.getTag() != null;
    }

    /**
     * Return true if the message has a To header tag.
     * 
     * @return true if the message has a to header and that header has a tag.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.353 -0500", hash_original_method = "62BEDD072F48BB9AA18DBB87956D8F3D", hash_generated_method = "3FAAA012D722FEEFE8A82FC258530278")
    
public boolean hasToTag() {
        return toHeader != null && toHeader.getTag() != null;
    }

    /**
     * Return the from tag.
     * 
     * @return the tag from the from header.
     * 
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.356 -0500", hash_original_method = "5C72A9C802C6EC574622DB27171F7A2E", hash_generated_method = "32B6A83A681E62F9170475BD9F88995A")
    
public String getFromTag() {
        return fromHeader == null ? null : fromHeader.getTag();
    }

    /**
     * Set the From Tag.
     * 
     * @param tag -- tag to set in the from header.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.358 -0500", hash_original_method = "2974ECBC3FF627B3CB2268B4D90C9E07", hash_generated_method = "7B59FEFAE51EE1B0B71318055116B426")
    
public void setFromTag(String tag) {
        try {
            fromHeader.setTag(tag);
        } catch (ParseException e) {
        }
    }

    /**
     * Set the to tag.
     * 
     * @param tag -- tag to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.360 -0500", hash_original_method = "7DFC8A6205B3CBC36E5183721A30EB01", hash_generated_method = "B33E6523870B8F39F6874EFBE0A8D113")
    
public void setToTag(String tag) {
        try {
            toHeader.setTag(tag);
        } catch (ParseException e) {
        }
    }

    /**
     * Return the to tag.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.363 -0500", hash_original_method = "5B9C84C201385B92B0E684584F1ECF7E", hash_generated_method = "F771BD90253AE41B15B36D2EEC84F422")
    
public String getToTag() {
        return toHeader == null ? null : toHeader.getTag();
    }

    /**
     * Return the encoded first line.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.366 -0500", hash_original_method = "C01DA63F5366D214166075A38E468E9A", hash_generated_method = "58411A571541317B14D7188D5E1265EB")
    
public abstract String getFirstLine();

    /**
     * Add a SIP header.
     * 
     * @param sipHeader -- sip header to add.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.369 -0500", hash_original_method = "34A83ACBA422BB4E8AD74511B9BCE335", hash_generated_method = "16DE6FB77D26A6670630292E4D8E8F8A")
    
public void addHeader(Header sipHeader) {
        // Content length is never stored. Just computed.
        SIPHeader sh = (SIPHeader) sipHeader;
        try {
            if ((sipHeader instanceof ViaHeader) || (sipHeader instanceof RecordRouteHeader)) {
                attachHeader(sh, false, true);
            } else {
                attachHeader(sh, false, false);
            }
        } catch (SIPDuplicateHeaderException ex) {
            try {
                if (sipHeader instanceof ContentLength) {
                    ContentLength cl = (ContentLength) sipHeader;
                    contentLengthHeader.setContentLength(cl.getContentLength());
                }
            } catch (InvalidArgumentException e) {
            }
        }
    }

    /**
     * Add a header to the unparsed list of headers.
     * 
     * @param unparsed -- unparsed header to add to the list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.371 -0500", hash_original_method = "8AEC9EB78EF51FE3B48C263748A725D0", hash_generated_method = "DD98CBD5F6912A2EB064EA16F36ADE36")
    
public void addUnparsed(String unparsed) {
        this.unrecognizedHeaders.add(unparsed);
    }

    /**
     * Add a SIP header.
     * 
     * @param sipHeader -- string version of SIP header to add.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.374 -0500", hash_original_method = "8ACC7204C4B122EB788CE6764EA1EA77", hash_generated_method = "36725E3FC714C4E73319B26EFA3C14AC")
    
public void addHeader(String sipHeader) {
        String hdrString = sipHeader.trim() + "\n";
        try {
            HeaderParser parser = ParserFactory.createParser(sipHeader);
            SIPHeader sh = parser.parse();
            this.attachHeader(sh, false);
        } catch (ParseException ex) {
            this.unrecognizedHeaders.add(hdrString);
        }
    }

    /**
     * Get a list containing the unrecognized headers.
     * 
     * @return a linked list containing unrecongnized headers.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.376 -0500", hash_original_method = "F4B3A65BCC1C141571353972EC488146", hash_generated_method = "E1F6DD7376E5599ABDED1BA6245AA40D")
    
public ListIterator<String> getUnrecognizedHeaders() {
        return this.unrecognizedHeaders.listIterator();
    }

    /**
     * Get the header names.
     * 
     * @return a list iterator to a list of header names. These are ordered in the same order as
     *         are present in the message.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.379 -0500", hash_original_method = "C08D5FBD41C305191A05DA7EC6E8BA34", hash_generated_method = "6454CEF7F76D0E7E2400734F097CCEB0")
    
public ListIterator<String> getHeaderNames() {
        Iterator<SIPHeader> li = this.headers.iterator();
        LinkedList<String> retval = new LinkedList<String>();
        while (li.hasNext()) {
            SIPHeader sipHeader = (SIPHeader) li.next();
            String name = sipHeader.getName();
            retval.add(name);
        }
        return retval.listIterator();
    }

    /**
     * Compare for equality.
     * 
     * @param other -- the other object to compare with.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.382 -0500", hash_original_method = "19862554CF2CF162312B89332E1831C0", hash_generated_method = "041CE66554807199C6A38DEDA682C188")
    
public boolean equals(Object other) {
        if (!other.getClass().equals(this.getClass())) {
            return false;
        }
        SIPMessage otherMessage = (SIPMessage) other;
        Collection<SIPHeader> values = this.nameTable.values();
        Iterator<SIPHeader> it = values.iterator();
        if (nameTable.size() != otherMessage.nameTable.size()) {
            return false;
        }

        while (it.hasNext()) {
            SIPHeader mine = (SIPHeader) it.next();
            SIPHeader his = (SIPHeader) (otherMessage.nameTable.get(SIPHeaderNamesCache
                    .toLowerCase(mine.getName())));
            if (his == null) {
                return false;
            } else if (!his.equals(mine)) {
                return false;
            }
        }
        return true;
    }

    /**
     * get content disposition header or null if no such header exists.
     * 
     * @return the contentDisposition header
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.385 -0500", hash_original_method = "3C4825ADE695C84AAF8B57CDEA1CF4CB", hash_generated_method = "FA715F84C4095B339BB308FDCBF0F63C")
    
public javax.sip.header.ContentDispositionHeader getContentDisposition() {
        return (ContentDispositionHeader) getHeaderLowerCase(CONTENT_DISPOSITION_LOWERCASE);
    }

    /**
     * get the content encoding header.
     * 
     * @return the contentEncoding header.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.390 -0500", hash_original_method = "46C03ED253FA9F93BF664C06918E9287", hash_generated_method = "F71D6CC51B7F60B3410B54C1DA88B37A")
    
public javax.sip.header.ContentEncodingHeader getContentEncoding() {
        return (ContentEncodingHeader) getHeaderLowerCase(CONTENT_ENCODING_LOWERCASE);
    }

    /**
     * Get the contentLanguage header.
     * 
     * @return the content language header.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.395 -0500", hash_original_method = "7F8FF7046ECB01AA1B56D3558C9342AE", hash_generated_method = "5FC0C5F17B70244A9976D0149FE394FB")
    
public javax.sip.header.ContentLanguageHeader getContentLanguage() {
        return (ContentLanguageHeader) getHeaderLowerCase(CONTENT_LANGUAGE_LOWERCASE);
    }

    /**
     * Get the exipres header.
     * 
     * @return the expires header or null if one does not exist.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.400 -0500", hash_original_method = "9AC8AD6CCC74995A67CEDA1778D18415", hash_generated_method = "01D00D86641159886EFF4CCD512C1EF7")
    
public javax.sip.header.ExpiresHeader getExpires() {
        return (ExpiresHeader) getHeaderLowerCase(EXPIRES_LOWERCASE);
    }

    /**
     * Set the expiresHeader
     * 
     * @param expiresHeader -- the expires header to set.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.405 -0500", hash_original_method = "729B7ABDA713D8DD91F71F3C7E5D92DE", hash_generated_method = "C02CDC7B78D76B7631B67CB809161B58")
    
public void setExpires(ExpiresHeader expiresHeader) {
        this.setHeader(expiresHeader);
    }

    /**
     * Set the content disposition header.
     * 
     * @param contentDispositionHeader -- content disposition header.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.407 -0500", hash_original_method = "9820BC2E150668B0FD803FA9E719FCCB", hash_generated_method = "91DBDC3E57B2E795CAC142591CEE35D5")
    
public void setContentDisposition(ContentDispositionHeader contentDispositionHeader) {
        this.setHeader(contentDispositionHeader);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.410 -0500", hash_original_method = "664B5D910990D19402FB830D30BD43E8", hash_generated_method = "3D8B0090381AFE83EAB42AAEE3BA1FF5")
    
public void setContentEncoding(ContentEncodingHeader contentEncodingHeader) {
        this.setHeader(contentEncodingHeader);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.413 -0500", hash_original_method = "F5B59DEA81E2E529FE4037C765469E44", hash_generated_method = "8FD44B92555FCA4DFF9919236189E787")
    
public void setContentLanguage(ContentLanguageHeader contentLanguageHeader) {
        this.setHeader(contentLanguageHeader);
    }

    /**
     * Set the content length header.
     * 
     * @param contentLength -- content length header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.415 -0500", hash_original_method = "5BC3E664403E9FC36E24FA33AD51CF36", hash_generated_method = "E7EEC0274962BC44F6B62546C3D8B5A0")
    
public void setContentLength(ContentLengthHeader contentLength) {
        try {
            this.contentLengthHeader.setContentLength(contentLength.getContentLength());
        } catch (InvalidArgumentException ex) {
        }

    }

    /**
     * Set the size of all the headers. This is for book keeping. Called by the parser.
     * 
     * @param size -- size of the headers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.418 -0500", hash_original_method = "B722E58F0DD8E1CBC622964AAF1F9B26", hash_generated_method = "70858565486BE6A9C00CCDD7CF18951B")
    
public void setSize(int size) {
        this.size = size;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.420 -0500", hash_original_method = "54E84843E0EEE275508F3EB8305B3F4F", hash_generated_method = "E4C490CCF23F67A9F71E17DDE93323F8")
    
public int getSize() {
        return this.size;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.message.Message#addLast(javax.sip.header.Header)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.423 -0500", hash_original_method = "51B72F61F828A2C6A4124D3A8929AD68", hash_generated_method = "B4AC22C283BB492118A953009B9C64F2")
    
public void addLast(Header header) throws SipException, NullPointerException {
        if (header == null)
            throw new NullPointerException("null arg!");

        try {
            this.attachHeader((SIPHeader) header, false, false);
        } catch (SIPDuplicateHeaderException ex) {
            throw new SipException("Cannot add header - header already exists");
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.message.Message#addFirst(javax.sip.header.Header)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.425 -0500", hash_original_method = "FB58DD3E1F3A0D99159750C09E15B568", hash_generated_method = "0E4BB4EAEC8B2264AB0A4ACE083E7936")
    
public void addFirst(Header header) throws SipException, NullPointerException {

        if (header == null)
            throw new NullPointerException("null arg!");

        try {
            this.attachHeader((SIPHeader) header, false, true);
        } catch (SIPDuplicateHeaderException ex) {
            throw new SipException("Cannot add header - header already exists");
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.message.Message#removeFirst(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.428 -0500", hash_original_method = "F7D2F7162E4B2A1EDD2D78AF07F98ED3", hash_generated_method = "B2362F280157179846C8092B6F25A6EF")
    
public void removeFirst(String headerName) throws NullPointerException {
        if (headerName == null)
            throw new NullPointerException("Null argument Provided!");
        this.removeHeader(headerName, true);

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.message.Message#removeLast(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.430 -0500", hash_original_method = "B1A0AEB4CA388E0A9ED7E42FB6DA96D3", hash_generated_method = "1EEADE833B31298A69C80A91BC0DC54A")
    
public void removeLast(String headerName) {
        if (headerName == null)
            throw new NullPointerException("Null argument Provided!");
        this.removeHeader(headerName, false);

    }

    /**
     * Set the CSeq header.
     * 
     * @param cseqHeader -- CSeq Header.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.432 -0500", hash_original_method = "1B0E35DCABA77A6424B3D6172B19A4B7", hash_generated_method = "E094930CF100550635B2F3F710A88630")
    
public void setCSeq(CSeqHeader cseqHeader) {
        this.setHeader(cseqHeader);
    }

    /**
     * Set the application data pointer. This method is not used the stack. It is provided as a
     * convenient way of storing book-keeping data for applications. Note that null clears the
     * application data pointer (releases it).
     * 
     * @param applicationData -- application data pointer to set. null clears the application data
     *        pointer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.435 -0500", hash_original_method = "552E0456C33D24CD63C8EBCDAC1D019B", hash_generated_method = "801F39B66BF2D8C554DCF3937EA2F8CE")
    
public void setApplicationData(Object applicationData) {
        this.applicationData = applicationData;
    }

    /**
     * Get the application data associated with this message.
     * 
     * @return stored application data.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.438 -0500", hash_original_method = "5F924FC61375970A4DC758380BEBFF0F", hash_generated_method = "65575224A94F45AA5C180B0ED3AF02CA")
    
public Object getApplicationData() {
        return this.applicationData;
    }

    /**
     * Get the multipart MIME content
     * 
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.441 -0500", hash_original_method = "3FB4581572217B4D34EC8E3A9F62CA88", hash_generated_method = "72DE370694ABCA4F119294AF83E853D9")
    
public MultipartMimeContent getMultipartMimeContent() throws ParseException {
        if (this.contentLengthHeader.getContentLength() == 0) {
            return null;
        }
        MultipartMimeContentImpl retval = new MultipartMimeContentImpl(this
                .getContentTypeHeader());
        byte[] rawContent = getRawContent();
		try {
			String body = new String( rawContent, getCharset() );
	        retval.createContentList(body);
	        return retval;
		} catch (UnsupportedEncodingException e) {
			InternalErrorHandler.handleException(e);
			return null;
		}
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.443 -0500", hash_original_method = "6A8980AC46BDEC47E118DEA889F580E2", hash_generated_method = "614D43E76AD5E54A6A6D769091A2DB17")
    
public CallIdHeader getCallIdHeader() {
        return this.callIdHeader;
    }
   
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.446 -0500", hash_original_method = "616E19996CDDFB660618161B80D5BB27", hash_generated_method = "75138080FA03089EA328657F10891A94")
    
public FromHeader getFromHeader() {
        return this.fromHeader;
    }
   
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.448 -0500", hash_original_method = "9C43D5663CBD78C15545690BFB01C4BF", hash_generated_method = "8B12838DAE69E8373A6B87B8293CB511")
    
public ToHeader getToHeader() {
        return this.toHeader;
    }
  
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.451 -0500", hash_original_method = "FE98900B9C779953579B6764E7283FC2", hash_generated_method = "FDFAC33C949167265F43186BA98D4FD7")
    
public ViaHeader getTopmostViaHeader() {
        return this.getTopmostVia();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.453 -0500", hash_original_method = "2CE1B7EDE28DB048E923E7FFD28A72BE", hash_generated_method = "305C413E35665B4C44CFC40011E54795")
    
public CSeqHeader getCSeqHeader() {
        return this.cSeqHeader;
    }
 
    /**
     * Returns the charset to use for encoding/decoding the body of this message
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.455 -0500", hash_original_method = "5D0D1F0E94EB86910B32FB17BCD97869", hash_generated_method = "760CF147EE1651FDA24B009425443FB0")
    
protected final String getCharset() {
    	ContentType ct = getContentTypeHeader();
    	if (ct!=null) {
    		String c = ct.getCharset();
    		return c!=null ? c : contentEncodingCharset;
    	} else return contentEncodingCharset;
    }
    
    /**
     * Return true if this is a null request (i.e. does not have a request line ).
     * 
     * @return true if null request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.458 -0500", hash_original_method = "F8575631397F30A77B6575B01C9E50F5", hash_generated_method = "614E4B0CA83C8B2553887F95233799FC")
    
public boolean isNullRequest() {
        return  this.nullRequest;
    }
    
    /**
     * Set a flag to indiate this is a special message ( encoded with CRLFCRLF ).
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.460 -0500", hash_original_method = "76987385F34084CF4A8C6AA1CD858E63", hash_generated_method = "EF13C130616596463D2B4BFA15384047")
    
public void setNullRequest() {
        this.nullRequest = true;
    }
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.463 -0500", hash_original_method = "CFE860B19AD3D57A0F1F7E2F8E62600E", hash_generated_method = "35F6989AA4DE4044BBBF57E6D95A0E43")
    
public abstract void setSIPVersion(String sipVersion) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.465 -0500", hash_original_method = "F69BDFBBEC93FDCAB46687974EA5BE73", hash_generated_method = "1AAFAF4422DE746C3637CE78448ED0F2")
    
public abstract String getSIPVersion();

    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:39.468 -0500", hash_original_method = "D4E4943029EE450E10D723A13B21ADBA", hash_generated_method = "7EA90E50E51652C3FF11C3BD32031D10")
    
public abstract String toString();
}

