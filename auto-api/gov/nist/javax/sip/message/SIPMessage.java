package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import gov.nist.javax.sip.parser.PipelinedMsgParser;
import gov.nist.javax.sip.parser.StringMsgParser;
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
    private String contentEncodingCharset = MessageFactoryImpl.getDefaultContentEncodingCharset();
    protected boolean nullRequest;
    protected LinkedList<String> unrecognizedHeaders;
    protected ConcurrentLinkedQueue<SIPHeader> headers;
    protected From fromHeader;
    protected To toHeader;
    protected CSeq cSeqHeader;
    protected CallID callIdHeader;
    protected ContentLength contentLengthHeader;
    protected MaxForwards maxForwardsHeader;
    protected int size;
    private String messageContent;
    private byte[] messageContentBytes;
    private Object messageContentObject;
    private Hashtable<String, SIPHeader> nameTable;
    protected Object applicationData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.990 -0400", hash_original_method = "7EF8FE4247F4A54A74550FF503F5DF85", hash_generated_method = "9DF4127C06DEBDC679265FCD9AB742DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPMessage() {
        this.unrecognizedHeaders = new LinkedList<String>();
        this.headers = new ConcurrentLinkedQueue<SIPHeader>();
        nameTable = new Hashtable<String, SIPHeader>();
        try 
        {
            this.attachHeader(new ContentLength(0), false);
        } //End block
        catch (Exception ex)
        { }
        // ---------- Original Method ----------
        //this.unrecognizedHeaders = new LinkedList<String>();
        //this.headers = new ConcurrentLinkedQueue<SIPHeader>();
        //nameTable = new Hashtable<String, SIPHeader>();
        //try {
            //this.attachHeader(new ContentLength(0), false);
        //} catch (Exception ex) {
        //}
    }

    
        public static boolean isRequestHeader(SIPHeader sipHeader) {
        return sipHeader instanceof AlertInfo || sipHeader instanceof InReplyTo
                || sipHeader instanceof Authorization || sipHeader instanceof MaxForwards
                || sipHeader instanceof UserAgent || sipHeader instanceof Priority
                || sipHeader instanceof ProxyAuthorization || sipHeader instanceof ProxyRequire
                || sipHeader instanceof ProxyRequireList || sipHeader instanceof Route
                || sipHeader instanceof RouteList || sipHeader instanceof Subject
                || sipHeader instanceof SIPIfMatch;
    }

    
        public static boolean isResponseHeader(SIPHeader sipHeader) {
        return sipHeader instanceof ErrorInfo || sipHeader instanceof ProxyAuthenticate
                || sipHeader instanceof Server || sipHeader instanceof Unsupported
                || sipHeader instanceof RetryAfter || sipHeader instanceof Warning
                || sipHeader instanceof WWWAuthenticate || sipHeader instanceof SIPETag
                || sipHeader instanceof RSeq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.990 -0400", hash_original_method = "4E875487FBA3E9E3C25B636513844812", hash_generated_method = "2C8B496E833E0BC713D3C6A6FF53F0BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedList<String> getMessageAsEncodedStrings() {
        LinkedList<String> retval;
        retval = new LinkedList<String>();
        Iterator<SIPHeader> li;
        li = headers.iterator();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_690337617 = (li.hasNext());
            {
                SIPHeader sipHeader;
                sipHeader = (SIPHeader) li.next();
                {
                    SIPHeaderList< ? > shl;
                    shl = (SIPHeaderList< ? >) sipHeader;
                    retval.addAll(shl.getHeadersAsEncodedStrings());
                } //End block
                {
                    retval.add(sipHeader.encode());
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (LinkedList<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LinkedList<String> retval = new LinkedList<String>();
        //Iterator<SIPHeader> li = headers.iterator();
        //while (li.hasNext()) {
            //SIPHeader sipHeader = (SIPHeader) li.next();
            //if (sipHeader instanceof SIPHeaderList) {
                //SIPHeaderList< ? > shl = (SIPHeaderList< ? >) sipHeader;
                //retval.addAll(shl.getHeadersAsEncodedStrings());
            //} else {
                //retval.add(sipHeader.encode());
            //}
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.991 -0400", hash_original_method = "A27900405272FB61F2D6362A05DA41D6", hash_generated_method = "82ED62D06937C22B2D58D25D0B717853")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeSIPHeaders() {
        StringBuffer encoding;
        encoding = new StringBuffer();
        Iterator<SIPHeader> it;
        it = this.headers.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_753411019 = (it.hasNext());
            {
                SIPHeader siphdr;
                siphdr = (SIPHeader) it.next();
                siphdr.encode(encoding);
            } //End block
        } //End collapsed parenthetic
        String var19268621C0ADE5741B150EE79F15164C_293802784 = (contentLengthHeader.encode(encoding).append(NEWLINE).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer encoding = new StringBuffer();
        //Iterator<SIPHeader> it = this.headers.iterator();
        //while (it.hasNext()) {
            //SIPHeader siphdr = (SIPHeader) it.next();
            //if (!(siphdr instanceof ContentLength))
                //siphdr.encode(encoding);
        //}
        //return contentLengthHeader.encode(encoding).append(NEWLINE).toString();
    }

    
    public abstract String encodeMessage();

    
    public abstract String getDialogId(boolean isServerTransaction);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.991 -0400", hash_original_method = "AC5B2D97481875B2502EE3A7FDAB3C5D", hash_generated_method = "EDF6F1562D497A47DDD397D78AA9FC9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean match(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_217084540 = (!other.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        SIPMessage matchObj;
        matchObj = (SIPMessage) other;
        Iterator<SIPHeader> li;
        li = matchObj.getHeaders();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_2113342696 = (li.hasNext());
            {
                SIPHeader hisHeaders;
                hisHeaders = (SIPHeader) li.next();
                List<SIPHeader> myHeaders;
                myHeaders = this.getHeaderList(hisHeaders.getHeaderName());
                {
                    boolean var1A87CEBFEDCDEA34F4CA0D4A3EFEF656_326169812 = (myHeaders == null || myHeaders.size() == 0);
                } //End collapsed parenthetic
                {
                    ListIterator< ? > outerIterator;
                    outerIterator = ((SIPHeaderList< ? >) hisHeaders)
                        .listIterator();
                    {
                        boolean var4B5292B8CB3E98B12515573A3508C4DF_1913409397 = (outerIterator.hasNext());
                        {
                            SIPHeader hisHeader;
                            hisHeader = (SIPHeader) outerIterator.next();
                            ListIterator< ? > innerIterator;
                            innerIterator = myHeaders.listIterator();
                            boolean found;
                            found = false;
                            {
                                boolean varB2E7926CCD2DEA34339CB3F15E1E57D6_1114573067 = (innerIterator.hasNext());
                                {
                                    SIPHeader myHeader;
                                    myHeader = (SIPHeader) innerIterator.next();
                                    {
                                        boolean varB96E7D72BCDF0CE20043B09547ED5B50_1650185179 = (myHeader.match(hisHeader));
                                        {
                                            found = true;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    SIPHeader hisHeader;
                    hisHeader = hisHeaders;
                    ListIterator<SIPHeader> innerIterator;
                    innerIterator = myHeaders.listIterator();
                    boolean found;
                    found = false;
                    {
                        boolean varB3D6059B83D121ABA5AE6C0435970C24_1148476220 = (innerIterator.hasNext());
                        {
                            SIPHeader myHeader;
                            myHeader = (SIPHeader) innerIterator.next();
                            {
                                boolean var6566F8FAB9C32C1FD403D502EB8A4D9C_1088869961 = (myHeader.match(hisHeader));
                                {
                                    found = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.992 -0400", hash_original_method = "789EABA7F64EF1819B9EE91356F4E918", hash_generated_method = "7818627801AB8CDDE5BA129BFD80E65F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void merge(Object template) {
        dsTaint.addTaint(template.dsTaint);
        {
            boolean var283342AFB2702617040FEF7CDFDA21F1_542777268 = (!template.getClass().equals(this.getClass()));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad class " + template.getClass());
        } //End collapsed parenthetic
        SIPMessage templateMessage;
        templateMessage = (SIPMessage) template;
        Object[] templateHeaders;
        templateHeaders = templateMessage.headers.toArray();
        {
            int i;
            i = 0;
            {
                SIPHeader hdr;
                hdr = (SIPHeader) templateHeaders[i];
                String hdrName;
                hdrName = hdr.getHeaderName();
                List<SIPHeader> myHdrs;
                myHdrs = this.getHeaderList(hdrName);
                {
                    this.attachHeader(hdr);
                } //End block
                {
                    ListIterator<SIPHeader> it;
                    it = myHdrs.listIterator();
                    {
                        boolean var4CA2EDBF7D27138D75E73CCD01CCB025_493576823 = (it.hasNext());
                        {
                            SIPHeader sipHdr;
                            sipHdr = (SIPHeader) it.next();
                            sipHdr.merge(hdr);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.998 -0400", hash_original_method = "79C45AA8D92059F002F56259D7022AFE", hash_generated_method = "52D337DE3AAC6507492125A3D3BD9482")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        StringBuffer encoding;
        encoding = new StringBuffer();
        Iterator<SIPHeader> it;
        it = this.headers.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_2081538905 = (it.hasNext());
            {
                SIPHeader siphdr;
                siphdr = (SIPHeader) it.next();
                encoding.append(siphdr.encode());
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<String> varFA17E7EA4EAE757CB30CF87AB56BCB8E_778283278 = (this.unrecognizedHeaders).iterator();
            varFA17E7EA4EAE757CB30CF87AB56BCB8E_778283278.hasNext();
            String unrecognized = varFA17E7EA4EAE757CB30CF87AB56BCB8E_778283278.next();
            {
                encoding.append(unrecognized).append(NEWLINE);
            } //End block
        } //End collapsed parenthetic
        encoding.append(contentLengthHeader.encode()).append(NEWLINE);
        {
            String mbody;
            mbody = this.getContent().toString();
            encoding.append(mbody);
        } //End block
        {
            String content;
            content = null;
            try 
            {
                content = messageContent;
                {
                    content = new String(messageContentBytes, getCharset() );
                } //End block
            } //End block
            catch (UnsupportedEncodingException ex)
            {
                InternalErrorHandler.handleException(ex);
            } //End block
            encoding.append(content);
        } //End block
        String varB81683B37658DAABB0D3F9E81B4869CA_1629502514 = (encoding.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.998 -0400", hash_original_method = "716A084604DD8483BAA5EE270A2C01EC", hash_generated_method = "F1C41FDA8E7CB25F919CA1928B6CD049")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] encodeAsBytes(String transport) {
        dsTaint.addTaint(transport);
        {
            boolean varA83D0D387E30A4710F38765D733091FF_348100409 = (this instanceof SIPRequest && ((SIPRequest) this).isNullRequest());
            {
                byte[] varEEF83FE8F2414029AB57C6129B64128C_359655929 = ("\r\n\r\n".getBytes());
            } //End block
        } //End collapsed parenthetic
        ViaHeader topVia;
        topVia = (ViaHeader) this.getHeader(ViaHeader.NAME);
        try 
        {
            topVia.setTransport(transport);
        } //End block
        catch (ParseException e)
        {
            InternalErrorHandler.handleException(e);
        } //End block
        StringBuffer encoding;
        encoding = new StringBuffer();
        {
            Iterator<SIPHeader> it;
            it = this.headers.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_90708006 = (it.hasNext());
                {
                    SIPHeader siphdr;
                    siphdr = (SIPHeader) it.next();
                    siphdr.encode(encoding);
                } //End block
            } //End collapsed parenthetic
        } //End block
        contentLengthHeader.encode(encoding);
        encoding.append(NEWLINE);
        byte[] retval;
        retval = null;
        byte[] content;
        content = this.getRawContent();
        {
            byte[] msgarray;
            msgarray = null;
            try 
            {
                msgarray = encoding.toString().getBytes( getCharset() );
            } //End block
            catch (UnsupportedEncodingException ex)
            {
                InternalErrorHandler.handleException(ex);
            } //End block
            retval = new byte[msgarray.length + content.length];
            System.arraycopy(msgarray, 0, retval, 0, msgarray.length);
            System.arraycopy(content, 0, retval, msgarray.length, content.length);
        } //End block
        {
            try 
            {
                retval = encoding.toString().getBytes( getCharset() );
            } //End block
            catch (UnsupportedEncodingException ex)
            {
                InternalErrorHandler.handleException(ex);
            } //End block
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.999 -0400", hash_original_method = "CAA2D0A800A8BA91CFE25E08D1466992", hash_generated_method = "046AFE04E8329C8778AA5AF36EF3F695")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        SIPMessage retval;
        retval = (SIPMessage) super.clone();
        retval.nameTable = new Hashtable<String, SIPHeader>();
        retval.fromHeader = null;
        retval.toHeader = null;
        retval.cSeqHeader = null;
        retval.callIdHeader = null;
        retval.contentLengthHeader = null;
        retval.maxForwardsHeader = null;
        {
            retval.headers = new ConcurrentLinkedQueue<SIPHeader>();
            {
                Iterator<SIPHeader> iter;
                iter = headers.iterator();
                boolean var8492AE2C695A56B730381A28B8BA3F6D_1287703626 = (iter.hasNext());
                {
                    SIPHeader hdr;
                    hdr = (SIPHeader) iter.next();
                    retval.attachHeader((SIPHeader) hdr.clone());
                } //End block
            } //End collapsed parenthetic
        } //End block
        retval.messageContentBytes = (byte[]) this.messageContentBytes.clone();
        retval.messageContentObject = makeClone(messageContentObject);
        retval.unrecognizedHeaders = this.unrecognizedHeaders;
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.999 -0400", hash_original_method = "CE435A19EF4C3C8ADC65C5BBD44452BB", hash_generated_method = "DF8DCA95B185161056117CC367F85131")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String debugDump() {
        stringRepresentation = "";
        sprint("SIPMessage:");
        sprint("{");
        try 
        {
            Field[] fields;
            fields = this.getClass().getDeclaredFields();
            {
                int i;
                i = 0;
                {
                    Field f;
                    f = fields[i];
                    Class< ? > fieldType;
                    fieldType = f.getType();
                    String fieldName;
                    fieldName = f.getName();
                    {
                        boolean var23F939341918CCB039A47328F0B892FA_598896559 = (f.get(this) != null && SIPHeader.class.isAssignableFrom(fieldType)
                        && fieldName.compareTo("headers") != 0);
                        {
                            sprint(fieldName + "=");
                            sprint(((SIPHeader) f.get(this)).debugDump());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        sprint("List of headers : ");
        sprint(headers.toString());
        sprint("messageContent = ");
        sprint("{");
        sprint(messageContent);
        sprint("}");
        {
            boolean var4C7E5D19EA905354F5CD428885C482C2_1456291963 = (this.getContent() != null);
            {
                sprint(this.getContent().toString());
            } //End block
        } //End collapsed parenthetic
        sprint("}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.000 -0400", hash_original_method = "D9E90811A837F48EC447FF925318738A", hash_generated_method = "4444D734C3CFD06328B5EC2490A40FFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void attachHeader(SIPHeader h) {
        dsTaint.addTaint(h.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("null header!");
        try 
        {
            {
                SIPHeaderList< ? > hl;
                hl = (SIPHeaderList< ? >) h;
                {
                    boolean var394E2F20856295BBEFBFAE80A46F780D_2133801706 = (hl.isEmpty());
                } //End collapsed parenthetic
            } //End block
            attachHeader(h, false, false);
        } //End block
        catch (SIPDuplicateHeaderException ex)
        { }
        // ---------- Original Method ----------
        //if (h == null)
            //throw new IllegalArgumentException("null header!");
        //try {
            //if (h instanceof SIPHeaderList) {
                //SIPHeaderList< ? > hl = (SIPHeaderList< ? >) h;
                //if (hl.isEmpty()) {
                    //return;
                //}
            //}
            //attachHeader(h, false, false);
        //} catch (SIPDuplicateHeaderException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.000 -0400", hash_original_method = "230B17E5A17A83111BEC4A023E8D6F14", hash_generated_method = "BF0A4B54EBC0461AF09FACB43FB8D42B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHeader(Header sipHeader) {
        dsTaint.addTaint(sipHeader.dsTaint);
        SIPHeader header;
        header = (SIPHeader) sipHeader;
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("null header!");
        try 
        {
            {
                SIPHeaderList< ? > hl;
                hl = (SIPHeaderList< ? >) header;
                {
                    boolean var394E2F20856295BBEFBFAE80A46F780D_156128863 = (hl.isEmpty());
                } //End collapsed parenthetic
            } //End block
            this.removeHeader(header.getHeaderName());
            attachHeader(header, true, false);
        } //End block
        catch (SIPDuplicateHeaderException ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        // ---------- Original Method ----------
        //SIPHeader header = (SIPHeader) sipHeader;
        //if (header == null)
            //throw new IllegalArgumentException("null header!");
        //try {
            //if (header instanceof SIPHeaderList) {
                //SIPHeaderList< ? > hl = (SIPHeaderList< ? >) header;
                //if (hl.isEmpty())
                    //return;
            //}
            //this.removeHeader(header.getHeaderName());
            //attachHeader(header, true, false);
        //} catch (SIPDuplicateHeaderException ex) {
            //InternalErrorHandler.handleException(ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.000 -0400", hash_original_method = "DC88726E428D89A7A7082B0D5F94DA0F", hash_generated_method = "A331E5EE20784E69FD047DA812B5EEB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHeaders(java.util.List<SIPHeader> headers) {
        dsTaint.addTaint(headers.dsTaint);
        ListIterator<SIPHeader> listIterator;
        listIterator = headers.listIterator();
        {
            boolean var64B293ABD2B064B3F6A70551787AFBD5_583999785 = (listIterator.hasNext());
            {
                SIPHeader sipHeader;
                sipHeader = (SIPHeader) listIterator.next();
                try 
                {
                    this.attachHeader(sipHeader, false);
                } //End block
                catch (SIPDuplicateHeaderException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //ListIterator<SIPHeader> listIterator = headers.listIterator();
        //while (listIterator.hasNext()) {
            //SIPHeader sipHeader = (SIPHeader) listIterator.next();
            //try {
                //this.attachHeader(sipHeader, false);
            //} catch (SIPDuplicateHeaderException ex) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.000 -0400", hash_original_method = "9B17545BC9FC78AB24684381D78F3E60", hash_generated_method = "9CB6C09C2166F4983C8733046F0A9EF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void attachHeader(SIPHeader h, boolean replaceflag) throws SIPDuplicateHeaderException {
        dsTaint.addTaint(replaceflag);
        dsTaint.addTaint(h.dsTaint);
        this.attachHeader(h, replaceflag, false);
        // ---------- Original Method ----------
        //this.attachHeader(h, replaceflag, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.001 -0400", hash_original_method = "7BE2AED7224623BF9774680F8F08FE9F", hash_generated_method = "CC0BF96FDB783D6EA2C27AC0FA9E79B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void attachHeader(SIPHeader header, boolean replaceFlag, boolean top) throws SIPDuplicateHeaderException {
        dsTaint.addTaint(replaceFlag);
        dsTaint.addTaint(header.dsTaint);
        dsTaint.addTaint(top);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null header");
        } //End block
        SIPHeader h;
        {
            boolean varFDBDF2C7B3EA303E85FC4F475643B632_166007609 = (ListMap.hasList(header) && !SIPHeaderList.class.isAssignableFrom(header.getClass()));
            {
                SIPHeaderList<SIPHeader> hdrList;
                hdrList = ListMap.getList(header);
                hdrList.add(header);
                h = hdrList;
            } //End block
            {
                h = header;
            } //End block
        } //End collapsed parenthetic
        String headerNameLowerCase;
        headerNameLowerCase = SIPHeaderNamesCache.toLowerCase(h.getName());
        {
            nameTable.remove(headerNameLowerCase);
        } //End block
        {
            boolean varFD544112D28585F2EA3523A14E11B4D2_345875909 = (nameTable.containsKey(headerNameLowerCase) && !(h instanceof SIPHeaderList));
            {
                {
                    try 
                    {
                        ContentLength cl;
                        cl = (ContentLength) h;
                        contentLengthHeader.setContentLength(cl.getContentLength());
                    } //End block
                    catch (InvalidArgumentException e)
                    { }
                } //End block
            } //End block
        } //End collapsed parenthetic
        SIPHeader originalHeader;
        originalHeader = (SIPHeader) getHeader(header.getName());
        {
            Iterator<SIPHeader> li;
            li = headers.iterator();
            {
                boolean varD1722E42EA3CA8952F93B6521D875E61_1414471696 = (li.hasNext());
                {
                    SIPHeader next;
                    next = (SIPHeader) li.next();
                    {
                        boolean varF7DF1CC74D70E774011938D4CD0C0F10_2088947249 = (next.equals(originalHeader));
                        {
                            li.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varE6233AB522C882584164D87B1A152DBC_1987229484 = (!nameTable.containsKey(headerNameLowerCase));
            {
                nameTable.put(headerNameLowerCase, h);
                headers.add(h);
            } //End block
            {
                {
                    SIPHeaderList< ? > hdrlist;
                    hdrlist = (SIPHeaderList< ? >) nameTable
                        .get(headerNameLowerCase);
                    hdrlist.concatenate((SIPHeaderList) h, top);
                    nameTable.put(headerNameLowerCase, h);
                } //End block
                {
                    nameTable.put(headerNameLowerCase, h);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            this.fromHeader = (From) h;
        } //End block
        {
            this.contentLengthHeader = (ContentLength) h;
        } //End block
        {
            this.toHeader = (To) h;
        } //End block
        {
            this.cSeqHeader = (CSeq) h;
        } //End block
        {
            this.callIdHeader = (CallID) h;
        } //End block
        {
            this.maxForwardsHeader = (MaxForwards) h;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.002 -0400", hash_original_method = "870FE8D30093D63C50FAB8B7342DE2BD", hash_generated_method = "3061AE3416B1C51C6AE8C0B1148C7F40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeHeader(String headerName, boolean top) {
        dsTaint.addTaint(headerName);
        dsTaint.addTaint(top);
        String headerNameLowerCase;
        headerNameLowerCase = SIPHeaderNamesCache.toLowerCase(headerName);
        SIPHeader toRemove;
        toRemove = (SIPHeader) nameTable.get(headerNameLowerCase);
        {
            SIPHeaderList< ? > hdrList;
            hdrList = (SIPHeaderList< ? >) toRemove;
            hdrList.removeFirst();
            hdrList.removeLast();
            {
                boolean var07A70300EBEAD4C7EF18232220E71612_569859720 = (hdrList.isEmpty());
                {
                    Iterator<SIPHeader> li;
                    li = this.headers.iterator();
                    {
                        boolean var3B4C388F9F77D89F36DAE45711DE06F7_1661959598 = (li.hasNext());
                        {
                            SIPHeader sipHeader;
                            sipHeader = (SIPHeader) li.next();
                            {
                                boolean var009E1FF0FE664B4BBC785303E466D8DE_1628556065 = (sipHeader.getName().equalsIgnoreCase(headerNameLowerCase));
                                li.remove();
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    nameTable.remove(headerNameLowerCase);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            this.nameTable.remove(headerNameLowerCase);
            {
                this.fromHeader = null;
            } //End block
            {
                this.toHeader = null;
            } //End block
            {
                this.cSeqHeader = null;
            } //End block
            {
                this.callIdHeader = null;
            } //End block
            {
                this.maxForwardsHeader = null;
            } //End block
            {
                this.contentLengthHeader = null;
            } //End block
            Iterator<SIPHeader> li;
            li = this.headers.iterator();
            {
                boolean varD1722E42EA3CA8952F93B6521D875E61_2000360413 = (li.hasNext());
                {
                    SIPHeader sipHeader;
                    sipHeader = (SIPHeader) li.next();
                    {
                        boolean var330E19EEBCC4008A3544282ED6FC5397_1176924400 = (sipHeader.getName().equalsIgnoreCase(headerName));
                        li.remove();
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.002 -0400", hash_original_method = "A43C3FE911C5904FA81F0CAD0EBF40FE", hash_generated_method = "BE19502CAE053DD30C6B59C5FC0957AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeHeader(String headerName) {
        dsTaint.addTaint(headerName);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        String headerNameLowerCase;
        headerNameLowerCase = SIPHeaderNamesCache.toLowerCase(headerName);
        SIPHeader removed;
        removed = (SIPHeader) nameTable.remove(headerNameLowerCase);
        {
            this.fromHeader = null;
        } //End block
        {
            this.toHeader = null;
        } //End block
        {
            this.cSeqHeader = null;
        } //End block
        {
            this.callIdHeader = null;
        } //End block
        {
            this.maxForwardsHeader = null;
        } //End block
        {
            this.contentLengthHeader = null;
        } //End block
        Iterator<SIPHeader> li;
        li = this.headers.iterator();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_476960165 = (li.hasNext());
            {
                SIPHeader sipHeader;
                sipHeader = (SIPHeader) li.next();
                {
                    boolean varFFF8027342880D91B8946C60AFFB1639_1098047798 = (sipHeader.getName().equalsIgnoreCase(headerNameLowerCase));
                    li.remove();
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.003 -0400", hash_original_method = "04B79D458A896A4F330B98FD27925CCB", hash_generated_method = "FE87E272EB3BF197C04C85EFFF613DF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTransactionId() {
        Via topVia;
        topVia = null;
        {
            boolean var45427AD504224B42EAB753EE244922DA_2033607894 = (!this.getViaHeaders().isEmpty());
            {
                topVia = (Via) this.getViaHeaders().getFirst();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var056F2938B12C580EE182B380BF3D72E4_266696317 = (topVia != null
                && topVia.getBranch() != null
                && topVia.getBranch().toUpperCase().startsWith(
                        SIPConstants.BRANCH_MAGIC_COOKIE_UPPER_CASE));
            {
                {
                    boolean varC5B42D35EFD1E3730754821E02818371_371286408 = (this.getCSeq().getMethod().equals(Request.CANCEL));
                    String var337BFAEE86A617343F2051318818C7E1_673240140 = ((topVia.getBranch() + ":" + this.getCSeq().getMethod()).toLowerCase());
                    String var69B1DA6E6B24DE9B815D1AE5BD1363E0_451709519 = (topVia.getBranch().toLowerCase());
                } //End collapsed parenthetic
            } //End block
            {
                StringBuffer retval;
                retval = new StringBuffer();
                From from;
                from = (From) this.getFrom();
                To to;
                to = (To) this.getTo();
                {
                    boolean var6A7392F4B3488A548307196F7AD78D4D_1913968615 = (from.hasTag());
                    retval.append(from.getTag()).append("-");
                } //End collapsed parenthetic
                String cid;
                cid = this.callIdHeader.getCallId();
                retval.append(cid).append("-");
                retval.append(this.cSeqHeader.getSequenceNumber()).append("-").append(
                    this.cSeqHeader.getMethod());
                {
                    retval.append("-").append(topVia.getSentBy().encode());
                    {
                        boolean var739F416062AF6DDEEFA862BDC661C203_555231803 = (!topVia.getSentBy().hasPort());
                        {
                            retval.append("-").append(5060);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varC5B42D35EFD1E3730754821E02818371_2035810540 = (this.getCSeq().getMethod().equals(Request.CANCEL));
                    {
                        retval.append(Request.CANCEL);
                    } //End block
                } //End collapsed parenthetic
                String var4E35407A5FF00AD9EB1E8F1CE46453AD_429304195 = (retval.toString().toLowerCase().replace(":", "-").replace("@", "-")
                    + Utils.getSignature());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.003 -0400", hash_original_method = "2D96B4A52CFB118A97F95400511B110F", hash_generated_method = "DE369D9EE46136A0A2064D884AAB7A33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Invalid message! Cannot compute hashcode! call-id header is missing !");
        int var16C3388685D263B76B89DE8120886CF4_644271161 = (this.callIdHeader.getCallId().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (this.callIdHeader == null)
            //throw new RuntimeException(
                    //"Invalid message! Cannot compute hashcode! call-id header is missing !");
        //else
            //return this.callIdHeader.getCallId().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.003 -0400", hash_original_method = "0B4068F7FDD81C59C44EF10BE948C047", hash_generated_method = "1765A846DE28AB1BCA3EE3588FA55DF5")
    @DSModeled(DSC.SAFE)
    public boolean hasContent() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return messageContent != null || messageContentBytes != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.004 -0400", hash_original_method = "16CF6C29A1D923EBFDFB9DE65000093A", hash_generated_method = "BE7E7FFD6466576380B3FD653839A5C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<SIPHeader> getHeaders() {
        Iterator<SIPHeader> var4BD74022A9AE592208A10B64261FB732_22775401 = (headers.iterator());
        return (Iterator<SIPHeader>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return headers.iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.004 -0400", hash_original_method = "1ADD77F2239C280F0A32414969B68312", hash_generated_method = "9BFA63AB54AFD097B400C9BC3594089A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Header getHeader(String headerName) {
        dsTaint.addTaint(headerName);
        Header var05BAFD934A4674A35E61E5715975D633_1719576952 = (getHeaderLowerCase(SIPHeaderNamesCache.toLowerCase(headerName)));
        return (Header)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getHeaderLowerCase(SIPHeaderNamesCache.toLowerCase(headerName));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.004 -0400", hash_original_method = "32A79E235DDCC6E80E2B12189B346373", hash_generated_method = "F3829A2A3825067586AA8821DA8D803C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Header getHeaderLowerCase(String lowerCaseHeaderName) {
        dsTaint.addTaint(lowerCaseHeaderName);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad name");
        SIPHeader sipHeader;
        sipHeader = (SIPHeader) nameTable.get(lowerCaseHeaderName);
        Header var0039F077AD32644F4AE8559254DDE653_634008439 = ((Header) ((SIPHeaderList) sipHeader).getFirst());
        return (Header)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (lowerCaseHeaderName == null)
            //throw new NullPointerException("bad name");
        //SIPHeader sipHeader = (SIPHeader) nameTable.get(lowerCaseHeaderName);
        //if (sipHeader instanceof SIPHeaderList)
            //return (Header) ((SIPHeaderList) sipHeader).getFirst();
        //else
            //return (Header) sipHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.004 -0400", hash_original_method = "094433154D44236D0991BBCF366E0E6A", hash_generated_method = "62CFCA487F8B461482C1294798183E69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentType getContentTypeHeader() {
        ContentType var8FABC5FC4B42A7B5BF5AB71A90A0F4FF_971647984 = ((ContentType) getHeaderLowerCase(CONTENT_TYPE_LOWERCASE));
        return (ContentType)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (ContentType) getHeaderLowerCase(CONTENT_TYPE_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.004 -0400", hash_original_method = "F29DC29143C65AC3E05B010248583D2F", hash_generated_method = "6F0B5435366E6ABF80348BC2EDC2232B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentLengthHeader getContentLengthHeader() {
        ContentLengthHeader var299BB4CEA2608AB3E7400A6FDD8CAA57_1634631282 = (this.getContentLength());
        return (ContentLengthHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.getContentLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.004 -0400", hash_original_method = "E10DCB9A2200DABE5E8DE063DD5342F3", hash_generated_method = "4110D9DDA2335F696F2716AE547E8546")
    @DSModeled(DSC.SAFE)
    public FromHeader getFrom() {
        return (FromHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (FromHeader) fromHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.005 -0400", hash_original_method = "10D7F219ADDA2D1F9DA30C2C2F401D03", hash_generated_method = "DFDD100BBE8CE361EB678600195D329D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ErrorInfoList getErrorInfoHeaders() {
        ErrorInfoList var71ED31A64933A532D005D9C3BA2A9D1B_1289499140 = ((ErrorInfoList) getSIPHeaderListLowerCase(ERROR_LOWERCASE));
        return (ErrorInfoList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (ErrorInfoList) getSIPHeaderListLowerCase(ERROR_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.005 -0400", hash_original_method = "6BBB646E6D7D64808CC70B68BEB17C86", hash_generated_method = "8FDF6168E78397990EBCD92F3ABA677C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContactList getContactHeaders() {
        ContactList var934DB6E152CA98F88D5F59FA963FB2FD_139639044 = ((ContactList) this.getSIPHeaderListLowerCase(CONTACT_LOWERCASE));
        return (ContactList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (ContactList) this.getSIPHeaderListLowerCase(CONTACT_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.005 -0400", hash_original_method = "7930A8382B37585900D6B0ADAEF5E908", hash_generated_method = "43395FC1D86075CD2CDD3B10353226DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Contact getContactHeader() {
        ContactList clist;
        clist = this.getContactHeaders();
        {
            Contact var9AA9975600A1FD9D6D5606683A3D25DD_2102015291 = ((Contact) clist.getFirst());
        } //End block
        return (Contact)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ContactList clist = this.getContactHeaders();
        //if (clist != null) {
            //return (Contact) clist.getFirst();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.005 -0400", hash_original_method = "F913627528E03E7BE96F6FC26EC1EAB5", hash_generated_method = "94B8253BE41D90EB65694C7137B1DA86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViaList getViaHeaders() {
        ViaList var8BD7CDDAD677CF0B3A38295150B42AD4_68095081 = ((ViaList) getSIPHeaderListLowerCase(VIA_LOWERCASE));
        return (ViaList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (ViaList) getSIPHeaderListLowerCase(VIA_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.005 -0400", hash_original_method = "4714C62FF03EE4A312864AB7EDBC16A3", hash_generated_method = "80298A791DA177D85FAF81E7CDB53630")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVia(java.util.List viaList) {
        dsTaint.addTaint(viaList.dsTaint);
        ViaList vList;
        vList = new ViaList();
        ListIterator it;
        it = viaList.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_76340344 = (it.hasNext());
            {
                Via via;
                via = (Via) it.next();
                vList.add(via);
            } //End block
        } //End collapsed parenthetic
        this.setHeader(vList);
        // ---------- Original Method ----------
        //ViaList vList = new ViaList();
        //ListIterator it = viaList.listIterator();
        //while (it.hasNext()) {
            //Via via = (Via) it.next();
            //vList.add(via);
        //}
        //this.setHeader(vList);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.006 -0400", hash_original_method = "458FFC69EFF172F74B60E661629859D7", hash_generated_method = "37DA6A237494606E871DA1CC75EF5365")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHeader(SIPHeaderList<Via> sipHeaderList) {
        dsTaint.addTaint(sipHeaderList.dsTaint);
        this.setHeader((Header) sipHeaderList);
        // ---------- Original Method ----------
        //this.setHeader((Header) sipHeaderList);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.006 -0400", hash_original_method = "D8225C1F89A591B431137F8AC67C8011", hash_generated_method = "B0A11D6296A0C27C66349B97CB1BA9E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Via getTopmostVia() {
        {
            boolean var7008E835C5FBF6766081DAE39E1151D8_1496277858 = (this.getViaHeaders() == null);
            Via var6B6D9F0D621E376384143DE3408BEF7E_1890369456 = ((Via) (getViaHeaders().getFirst()));
        } //End collapsed parenthetic
        return (Via)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this.getViaHeaders() == null)
            //return null;
        //else
            //return (Via) (getViaHeaders().getFirst());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.006 -0400", hash_original_method = "734B287C3C9508BBD63962A2764D9C01", hash_generated_method = "2DD6B7E297ABBEA990936BF60429DA7E")
    @DSModeled(DSC.SAFE)
    public CSeqHeader getCSeq() {
        return (CSeqHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (CSeqHeader) cSeqHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.006 -0400", hash_original_method = "6A92E6492A4EA537FE7E1089912E5A2E", hash_generated_method = "544177741BDFBC8067BF23948B6BBE86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Authorization getAuthorization() {
        Authorization varE567B257206F58F0AE77D8DA839CEEAE_1543350386 = ((Authorization) getHeaderLowerCase(AUTHORIZATION_LOWERCASE));
        return (Authorization)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Authorization) getHeaderLowerCase(AUTHORIZATION_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.006 -0400", hash_original_method = "1941B7A53D19F77542CA45C05AFF9884", hash_generated_method = "AAFEC8F62D9AF94FD9EC444EBE53036C")
    @DSModeled(DSC.SAFE)
    public MaxForwardsHeader getMaxForwards() {
        return (MaxForwardsHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return maxForwardsHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.007 -0400", hash_original_method = "08224707CDDBB2C37148D3B618E2B6B7", hash_generated_method = "B60997F30B8E8BD32AF7961379B7C3F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMaxForwards(MaxForwardsHeader maxForwards) {
        dsTaint.addTaint(maxForwards.dsTaint);
        this.setHeader(maxForwards);
        // ---------- Original Method ----------
        //this.setHeader(maxForwards);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.007 -0400", hash_original_method = "7800F88C4B689BC7D7C78CBE850678CA", hash_generated_method = "B32A8E8D9ABF809AAE43FE087FF07D73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RouteList getRouteHeaders() {
        RouteList var4BA5B6FC35D3F378DAB54128FB776E18_1129165364 = ((RouteList) getSIPHeaderListLowerCase(ROUTE_LOWERCASE));
        return (RouteList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (RouteList) getSIPHeaderListLowerCase(ROUTE_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.007 -0400", hash_original_method = "9DA69A74904D39D3267E3E1010C409F3", hash_generated_method = "50D54D6DA69F9F707456FA4967BB9BE1")
    @DSModeled(DSC.SAFE)
    public CallIdHeader getCallId() {
        return (CallIdHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return callIdHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.007 -0400", hash_original_method = "5127E494FA29164B5CB6A74D7F3B176F", hash_generated_method = "247BF5C4BCBE5B273F366CC8C038CC4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCallId(CallIdHeader callId) {
        dsTaint.addTaint(callId.dsTaint);
        this.setHeader(callId);
        // ---------- Original Method ----------
        //this.setHeader(callId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.007 -0400", hash_original_method = "16037BFD4917B839A558D81FBF251209", hash_generated_method = "61D521CC2EAC1F67DFC1A553253BA261")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCallId(String callId) throws java.text.ParseException {
        dsTaint.addTaint(callId);
        {
            this.setHeader(new CallID());
        } //End block
        callIdHeader.setCallId(callId);
        // ---------- Original Method ----------
        //if (callIdHeader == null) {
            //this.setHeader(new CallID());
        //}
        //callIdHeader.setCallId(callId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.008 -0400", hash_original_method = "6FCB806D3659BA1DF59CA318834E3C35", hash_generated_method = "D003EA90A64CB690DED1E302C3CCE9A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RecordRouteList getRecordRouteHeaders() {
        RecordRouteList var89744DC1589B2FB661C8FD627A1883F8_1041951687 = ((RecordRouteList) this.getSIPHeaderListLowerCase(RECORDROUTE_LOWERCASE));
        return (RecordRouteList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (RecordRouteList) this.getSIPHeaderListLowerCase(RECORDROUTE_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.008 -0400", hash_original_method = "D2F3523F315E42C3CDB78FE4D7DBD860", hash_generated_method = "A4C5D9D8E1C98176463FFECD4B3BB051")
    @DSModeled(DSC.SAFE)
    public ToHeader getTo() {
        return (ToHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (ToHeader) toHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.008 -0400", hash_original_method = "AA146219F068967CE3F55E3F637E86D7", hash_generated_method = "08E45E51480E9E603E8630DB5ACE3F1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTo(ToHeader to) {
        dsTaint.addTaint(to.dsTaint);
        this.setHeader(to);
        // ---------- Original Method ----------
        //this.setHeader(to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.008 -0400", hash_original_method = "61E9A0C02A79622F4076A17D3E8275D9", hash_generated_method = "9EF318709DCD641352DB0F74C12C6E0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFrom(FromHeader from) {
        dsTaint.addTaint(from.dsTaint);
        this.setHeader(from);
        // ---------- Original Method ----------
        //this.setHeader(from);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.008 -0400", hash_original_method = "BF14C97BBADF5B6B3DD1A606FFB97154", hash_generated_method = "9E3047D60853D83BC553C699328C53BA")
    @DSModeled(DSC.SAFE)
    public ContentLengthHeader getContentLength() {
        return (ContentLengthHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.contentLengthHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.008 -0400", hash_original_method = "40D47E0A8FD809ED2EC3170259DB7692", hash_generated_method = "C7FDE46D7976B73DED8437F2C835286A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMessageContent() throws UnsupportedEncodingException {
        {
            this.messageContent = new String(messageContentBytes, getCharset() );
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (this.messageContent == null && this.messageContentBytes == null)
            //return null;
        //else if (this.messageContent == null) {
            //this.messageContent = new String(messageContentBytes, getCharset() );
        //}
        //return this.messageContent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.009 -0400", hash_original_method = "0A8A11F2CA57642B3F77F3FF48221ABE", hash_generated_method = "9745CBA270404B99BFA8A5A0795C89DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getRawContent() {
        try 
        {
            {
                String messageContent;
                messageContent = this.messageContentObject.toString();
                this.messageContentBytes = messageContent.getBytes( getCharset() );
            } //End block
            {
                this.messageContentBytes = messageContent.getBytes( getCharset() );
            } //End block
        } //End block
        catch (UnsupportedEncodingException ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //try {
            //if ( this.messageContentBytes != null ) {
            //} else if (this.messageContentObject != null) {
                //String messageContent = this.messageContentObject.toString();
                //this.messageContentBytes = messageContent.getBytes( getCharset() );
            //} else if (this.messageContent != null) {
            	//this.messageContentBytes = messageContent.getBytes( getCharset() );                
            //}
            //return this.messageContentBytes;
        //} catch (UnsupportedEncodingException ex) {
            //InternalErrorHandler.handleException(ex);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.009 -0400", hash_original_method = "AF476AB0E969B944040525792C5BC52E", hash_generated_method = "71EE7428A470EF90BF6F70E3F33BFE05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMessageContent(String type, String subType, String messageContent) {
        dsTaint.addTaint(subType);
        dsTaint.addTaint(messageContent);
        dsTaint.addTaint(type);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("messgeContent is null");
        ContentType ct;
        ct = new ContentType(type, subType);
        this.setHeader(ct);
        this.messageContentBytes = null;
        this.messageContentObject = null;
        computeContentLength(messageContent);
        // ---------- Original Method ----------
        //if (messageContent == null)
            //throw new IllegalArgumentException("messgeContent is null");
        //ContentType ct = new ContentType(type, subType);
        //this.setHeader(ct);
        //this.messageContent = messageContent;
        //this.messageContentBytes = null;
        //this.messageContentObject = null;
        //computeContentLength(messageContent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.010 -0400", hash_original_method = "F6727728B1118BFFD3FCC04534FCE621", hash_generated_method = "4828FD6E61FE21FA48117F9D96807572")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContent(Object content, ContentTypeHeader contentTypeHeader) throws ParseException {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(contentTypeHeader.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null content");
        this.setHeader(contentTypeHeader);
        this.messageContent = null;
        this.messageContentBytes = null;
        this.messageContentObject = null;
        {
            this.messageContent = (String) content;
        } //End block
        {
            this.messageContentBytes = (byte[]) content;
        } //End block
        computeContentLength(content);
        // ---------- Original Method ----------
        //if (content == null)
            //throw new NullPointerException("null content");
        //this.setHeader(contentTypeHeader);
        //this.messageContent = null;
        //this.messageContentBytes = null;
        //this.messageContentObject = null;
        //if (content instanceof String) {
            //this.messageContent = (String) content;
        //} else if (content instanceof byte[]) {
            //this.messageContentBytes = (byte[]) content;
        //} else
            //this.messageContentObject = content;
        //computeContentLength(content);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.010 -0400", hash_original_method = "54FC52177A1CB92C02565C30A4F8CE94", hash_generated_method = "2A8B6F5E0DB0EB60CF13CF5D01C31892")
    @DSModeled(DSC.SAFE)
    public Object getContent() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this.messageContentObject != null)
            //return messageContentObject;
        //else if (this.messageContent != null)
            //return this.messageContent;
        //else if (this.messageContentBytes != null)
            //return this.messageContentBytes;
        //else
            //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.010 -0400", hash_original_method = "567464035ABE474ACDCFF614F9D534B5", hash_generated_method = "3F7E16E659F366AE0D5A8E107DA925EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMessageContent(String type, String subType, byte[] messageContent) {
        dsTaint.addTaint(subType);
        dsTaint.addTaint(messageContent[0]);
        dsTaint.addTaint(type);
        ContentType ct;
        ct = new ContentType(type, subType);
        this.setHeader(ct);
        this.setMessageContent(messageContent);
        computeContentLength(messageContent);
        // ---------- Original Method ----------
        //ContentType ct = new ContentType(type, subType);
        //this.setHeader(ct);
        //this.setMessageContent(messageContent);
        //computeContentLength(messageContent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.010 -0400", hash_original_method = "39F2BE1EDB04320A3B64ACD0EA831DED", hash_generated_method = "8FD178995F945F40343D7CAF12657C7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMessageContent(String content, boolean strict, boolean computeContentLength, int givenLength) throws ParseException {
        dsTaint.addTaint(content);
        dsTaint.addTaint(givenLength);
        dsTaint.addTaint(computeContentLength);
        dsTaint.addTaint(strict);
        computeContentLength(content);
        {
            {
                boolean var7F2E7916F611D748ECF2BCAD4DD266ED_417730455 = ((!strict && this.contentLengthHeader.getContentLength() != givenLength) 
                    || this.contentLengthHeader.getContentLength() < givenLength);
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException("Invalid content length "
                        + this.contentLengthHeader.getContentLength() + " / " + givenLength, 0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        messageContentBytes = null;
        messageContentObject = null;
        // ---------- Original Method ----------
        //computeContentLength(content);
        //if ((!computeContentLength)) {
            //if ( (!strict && this.contentLengthHeader.getContentLength() != givenLength) 
                    //|| this.contentLengthHeader.getContentLength() < givenLength) {
                //throw new ParseException("Invalid content length "
                        //+ this.contentLengthHeader.getContentLength() + " / " + givenLength, 0);
            //}
        //}
        //messageContent = content;
        //messageContentBytes = null;
        //messageContentObject = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.011 -0400", hash_original_method = "19C7E154661732280AD152F3E186944D", hash_generated_method = "D5FD91F5BD699B596E63C58BAE1B3F20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMessageContent(byte[] content) {
        dsTaint.addTaint(content[0]);
        computeContentLength(content);
        messageContent = null;
        messageContentObject = null;
        // ---------- Original Method ----------
        //computeContentLength(content);
        //messageContentBytes = content;
        //messageContent = null;
        //messageContentObject = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.011 -0400", hash_original_method = "677A53CE4E6B4035F9B12FCECD3E865E", hash_generated_method = "56A3A38C2F2635FF82F955C7197748F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMessageContent(byte[] content, boolean computeContentLength, int givenLength) throws ParseException {
        dsTaint.addTaint(content[0]);
        dsTaint.addTaint(givenLength);
        dsTaint.addTaint(computeContentLength);
        computeContentLength(content);
        {
            boolean var53E9258046341087EA338AE330779B8F_1052091113 = ((!computeContentLength) && this.contentLengthHeader.getContentLength() < givenLength);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Invalid content length "
                    + this.contentLengthHeader.getContentLength() + " / " + givenLength, 0);
            } //End block
        } //End collapsed parenthetic
        messageContent = null;
        messageContentObject = null;
        // ---------- Original Method ----------
        //computeContentLength(content);
        //if ((!computeContentLength) && this.contentLengthHeader.getContentLength() < givenLength) {
            //throw new ParseException("Invalid content length "
                    //+ this.contentLengthHeader.getContentLength() + " / " + givenLength, 0);
        //}
        //messageContentBytes = content;
        //messageContent = null;
        //messageContentObject = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.011 -0400", hash_original_method = "D3327D918F93ECC2995A4C67A415A1A5", hash_generated_method = "6A337C8809E4413DB6CA4ED101BA69DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void computeContentLength(Object content) {
        dsTaint.addTaint(content.dsTaint);
        int length;
        length = 0;
        {
            {
                try 
                {
                    length = ((String) content).getBytes( getCharset() ).length;
                } //End block
                catch (UnsupportedEncodingException ex)
                {
                    InternalErrorHandler.handleException(ex);
                } //End block
            } //End block
            {
                length = ((byte[]) content).length;
            } //End block
            {
                length = content.toString().length();
            } //End block
        } //End block
        try 
        {
            contentLengthHeader.setContentLength(length);
        } //End block
        catch (InvalidArgumentException e)
        { }
        // ---------- Original Method ----------
        //int length = 0;
        //if (content != null) {
            //if (content instanceof String) {
                //try {
                    //length = ((String) content).getBytes( getCharset() ).length;
                //} catch (UnsupportedEncodingException ex) {
                    //InternalErrorHandler.handleException(ex);
                //}
            //} else if (content instanceof byte[]) {
                //length = ((byte[]) content).length;
            //} else {
                //length = content.toString().length();
            //}
        //}
        //try {
            //contentLengthHeader.setContentLength(length);
        //} catch (InvalidArgumentException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.012 -0400", hash_original_method = "B09AA5FB20D2965ADCD41D53860CDBE3", hash_generated_method = "EC9C60094C43878E3E0EBD84910DA36F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeContent() {
        messageContent = null;
        messageContentBytes = null;
        messageContentObject = null;
        try 
        {
            this.contentLengthHeader.setContentLength(0);
        } //End block
        catch (InvalidArgumentException ex)
        { }
        // ---------- Original Method ----------
        //messageContent = null;
        //messageContentBytes = null;
        //messageContentObject = null;
        //try {
            //this.contentLengthHeader.setContentLength(0);
        //} catch (InvalidArgumentException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.012 -0400", hash_original_method = "B51D33B6E886062DB169564C9DA9DCD8", hash_generated_method = "696E3440037DB64D0F44669D7B04B340")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public ListIterator<SIPHeader> getHeaders(String headerName) {
        dsTaint.addTaint(headerName);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null headerName");
        SIPHeader sipHeader;
        sipHeader = (SIPHeader) nameTable.get(SIPHeaderNamesCache
                .toLowerCase(headerName));
        ListIterator<SIPHeader> var7ECCF7E67BA81840EF3027EF4BC58D94_1688390140 = (new LinkedList<SIPHeader>().listIterator());
        {
            ListIterator<SIPHeader> var692D4D125D00D1B95B8C42836038F08A_1143230053 = (((SIPHeaderList<SIPHeader>) sipHeader).listIterator());
        } //End block
        {
            ListIterator<SIPHeader> var3320CDA44B36A7F6D56F5D007C25D1D5_2042292182 = (new HeaderIterator(this, sipHeader));
        } //End block
        return (ListIterator<SIPHeader>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (headerName == null)
            //throw new NullPointerException("null headerName");
        //SIPHeader sipHeader = (SIPHeader) nameTable.get(SIPHeaderNamesCache
                //.toLowerCase(headerName));
        //if (sipHeader == null)
            //return new LinkedList<SIPHeader>().listIterator();
        //if (sipHeader instanceof SIPHeaderList) {
            //return ((SIPHeaderList<SIPHeader>) sipHeader).listIterator();
        //} else {
            //return new HeaderIterator(this, sipHeader);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.012 -0400", hash_original_method = "6CE50AA271DA9876F1700D8E280EAFD1", hash_generated_method = "1B7F2C1626E371A0708E1B8F5E9538AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHeaderAsFormattedString(String name) {
        dsTaint.addTaint(name);
        String lowerCaseName;
        lowerCaseName = name.toLowerCase();
        {
            boolean varC2A08EC06B69AD4EEFB5CF0E06463703_531723602 = (this.nameTable.containsKey(lowerCaseName));
            {
                String var20B121387E1DB06EDA79959D01445417_802974540 = (this.nameTable.get(lowerCaseName).toString());
            } //End block
            {
                String varA5C47B0FEA0DD3F7D09F0538504C3E6B_1303362868 = (this.getHeader(name).toString());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String lowerCaseName = name.toLowerCase();
        //if (this.nameTable.containsKey(lowerCaseName)) {
            //return this.nameTable.get(lowerCaseName).toString();
        //} else {
            //return this.getHeader(name).toString();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.012 -0400", hash_original_method = "2723C6F27F309BF6F386C5DF25AB6032", hash_generated_method = "154A997E117CF60ADB61AB453F497040")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SIPHeader getSIPHeaderListLowerCase(String lowerCaseHeaderName) {
        dsTaint.addTaint(lowerCaseHeaderName);
        SIPHeader var855A207A743858BCD0DF173525588C56_2039186176 = (nameTable.get(lowerCaseHeaderName));
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return nameTable.get(lowerCaseHeaderName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.012 -0400", hash_original_method = "9F4B7A8AFA1B725FEEE6FA6CFA2755DF", hash_generated_method = "B149871B6DF48939C5BB23723F2076D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    private List<SIPHeader> getHeaderList(String headerName) {
        dsTaint.addTaint(headerName);
        SIPHeader sipHeader;
        sipHeader = (SIPHeader) nameTable.get(SIPHeaderNamesCache
                .toLowerCase(headerName));
        List<SIPHeader> var6F147AD2215A9E792CA381688656A2A1_158616059 = ((List<SIPHeader>) (((SIPHeaderList< ? >) sipHeader).getHeaderList()));
        {
            LinkedList<SIPHeader> ll;
            ll = new LinkedList<SIPHeader>();
            ll.add(sipHeader);
        } //End block
        return (List<SIPHeader>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SIPHeader sipHeader = (SIPHeader) nameTable.get(SIPHeaderNamesCache
                //.toLowerCase(headerName));
        //if (sipHeader == null)
            //return null;
        //else if (sipHeader instanceof SIPHeaderList)
            //return (List<SIPHeader>) (((SIPHeaderList< ? >) sipHeader).getHeaderList());
        //else {
            //LinkedList<SIPHeader> ll = new LinkedList<SIPHeader>();
            //ll.add(sipHeader);
            //return ll;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.013 -0400", hash_original_method = "6DBF8105DE4FD1DC6BA28CCFFFEEC680", hash_generated_method = "57261ACE283C4233E775469FFD36D882")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasHeader(String headerName) {
        dsTaint.addTaint(headerName);
        boolean var8F92FAB8130AFDAD062FD4FCF8454941_1957584086 = (nameTable.containsKey(SIPHeaderNamesCache.toLowerCase(headerName)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nameTable.containsKey(SIPHeaderNamesCache.toLowerCase(headerName));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.013 -0400", hash_original_method = "4231E4F79F4F1EB89656879CE689B66E", hash_generated_method = "D7351E924313A6C5A956DD278B5F9575")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasFromTag() {
        boolean var0911B64052451985C6CF9283DDE5ABCA_229223104 = (fromHeader != null && fromHeader.getTag() != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return fromHeader != null && fromHeader.getTag() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.013 -0400", hash_original_method = "62BEDD072F48BB9AA18DBB87956D8F3D", hash_generated_method = "BF84B6BC0E711B70BF04BA0FE2CB6193")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasToTag() {
        boolean varD9AA5806DF483D6615D6AF7918F3DCC2_2126930672 = (toHeader != null && toHeader.getTag() != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return toHeader != null && toHeader.getTag() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.013 -0400", hash_original_method = "5C72A9C802C6EC574622DB27171F7A2E", hash_generated_method = "E48932EFF875D9B56E22AC18B70CFA02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getFromTag() {
        {
            Object varDF6D3C992BAEC5917A190B88CAFE2FA6_1758717290 = (fromHeader.getTag());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return fromHeader == null ? null : fromHeader.getTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.014 -0400", hash_original_method = "2974ECBC3FF627B3CB2268B4D90C9E07", hash_generated_method = "CC0CA6DF542403DB16E9368C40D6BEC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFromTag(String tag) {
        dsTaint.addTaint(tag);
        try 
        {
            fromHeader.setTag(tag);
        } //End block
        catch (ParseException e)
        { }
        // ---------- Original Method ----------
        //try {
            //fromHeader.setTag(tag);
        //} catch (ParseException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.014 -0400", hash_original_method = "7DFC8A6205B3CBC36E5183721A30EB01", hash_generated_method = "0C4FD00FFF66516104ECC410D89F7B29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setToTag(String tag) {
        dsTaint.addTaint(tag);
        try 
        {
            toHeader.setTag(tag);
        } //End block
        catch (ParseException e)
        { }
        // ---------- Original Method ----------
        //try {
            //toHeader.setTag(tag);
        //} catch (ParseException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.014 -0400", hash_original_method = "5B9C84C201385B92B0E684584F1ECF7E", hash_generated_method = "FEA6F135D590BE0F019B70CBC2A07407")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getToTag() {
        {
            Object var83AE8C99321DD4E96337F4CBB5EDFA99_214527682 = (toHeader.getTag());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return toHeader == null ? null : toHeader.getTag();
    }

    
    public abstract String getFirstLine();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.014 -0400", hash_original_method = "34A83ACBA422BB4E8AD74511B9BCE335", hash_generated_method = "3B5662A55C12DDAAF29614075AD3AEB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addHeader(Header sipHeader) {
        dsTaint.addTaint(sipHeader.dsTaint);
        SIPHeader sh;
        sh = (SIPHeader) sipHeader;
        try 
        {
            {
                attachHeader(sh, false, true);
            } //End block
            {
                attachHeader(sh, false, false);
            } //End block
        } //End block
        catch (SIPDuplicateHeaderException ex)
        {
            try 
            {
                {
                    ContentLength cl;
                    cl = (ContentLength) sipHeader;
                    contentLengthHeader.setContentLength(cl.getContentLength());
                } //End block
            } //End block
            catch (InvalidArgumentException e)
            { }
        } //End block
        // ---------- Original Method ----------
        //SIPHeader sh = (SIPHeader) sipHeader;
        //try {
            //if ((sipHeader instanceof ViaHeader) || (sipHeader instanceof RecordRouteHeader)) {
                //attachHeader(sh, false, true);
            //} else {
                //attachHeader(sh, false, false);
            //}
        //} catch (SIPDuplicateHeaderException ex) {
            //try {
                //if (sipHeader instanceof ContentLength) {
                    //ContentLength cl = (ContentLength) sipHeader;
                    //contentLengthHeader.setContentLength(cl.getContentLength());
                //}
            //} catch (InvalidArgumentException e) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.015 -0400", hash_original_method = "8AEC9EB78EF51FE3B48C263748A725D0", hash_generated_method = "35079973855B85C0CF711BF80920FF8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addUnparsed(String unparsed) {
        dsTaint.addTaint(unparsed);
        this.unrecognizedHeaders.add(unparsed);
        // ---------- Original Method ----------
        //this.unrecognizedHeaders.add(unparsed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.015 -0400", hash_original_method = "8ACC7204C4B122EB788CE6764EA1EA77", hash_generated_method = "497DFD256A44E73169D350392C2C4D7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addHeader(String sipHeader) {
        dsTaint.addTaint(sipHeader);
        String hdrString;
        hdrString = sipHeader.trim() + "\n";
        try 
        {
            HeaderParser parser;
            parser = ParserFactory.createParser(sipHeader);
            SIPHeader sh;
            sh = parser.parse();
            this.attachHeader(sh, false);
        } //End block
        catch (ParseException ex)
        {
            this.unrecognizedHeaders.add(hdrString);
        } //End block
        // ---------- Original Method ----------
        //String hdrString = sipHeader.trim() + "\n";
        //try {
            //HeaderParser parser = ParserFactory.createParser(sipHeader);
            //SIPHeader sh = parser.parse();
            //this.attachHeader(sh, false);
        //} catch (ParseException ex) {
            //this.unrecognizedHeaders.add(hdrString);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.015 -0400", hash_original_method = "F4B3A65BCC1C141571353972EC488146", hash_generated_method = "5A7172B551C50B192356A6D43115212C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListIterator<String> getUnrecognizedHeaders() {
        ListIterator<String> var9A7F26FF600D26EF99A513F30E21BAF6_1555016124 = (this.unrecognizedHeaders.listIterator());
        return (ListIterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.unrecognizedHeaders.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.015 -0400", hash_original_method = "C08D5FBD41C305191A05DA7EC6E8BA34", hash_generated_method = "39566FC6D2678709C804303789543323")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListIterator<String> getHeaderNames() {
        Iterator<SIPHeader> li;
        li = this.headers.iterator();
        LinkedList<String> retval;
        retval = new LinkedList<String>();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_956332463 = (li.hasNext());
            {
                SIPHeader sipHeader;
                sipHeader = (SIPHeader) li.next();
                String name;
                name = sipHeader.getName();
                retval.add(name);
            } //End block
        } //End collapsed parenthetic
        ListIterator<String> var4719AF0D120BC745937EBCE7A3F4B20D_549800699 = (retval.listIterator());
        return (ListIterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Iterator<SIPHeader> li = this.headers.iterator();
        //LinkedList<String> retval = new LinkedList<String>();
        //while (li.hasNext()) {
            //SIPHeader sipHeader = (SIPHeader) li.next();
            //String name = sipHeader.getName();
            //retval.add(name);
        //}
        //return retval.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.016 -0400", hash_original_method = "19862554CF2CF162312B89332E1831C0", hash_generated_method = "997F9EC391E9105C4776827A3AF0E5A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_1654101795 = (!other.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        SIPMessage otherMessage;
        otherMessage = (SIPMessage) other;
        Collection<SIPHeader> values;
        values = this.nameTable.values();
        Iterator<SIPHeader> it;
        it = values.iterator();
        {
            boolean varEA188AE5A9018452EA1222E9093CB12B_1629345376 = (nameTable.size() != otherMessage.nameTable.size());
        } //End collapsed parenthetic
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_132359852 = (it.hasNext());
            {
                SIPHeader mine;
                mine = (SIPHeader) it.next();
                SIPHeader his;
                his = (SIPHeader) (otherMessage.nameTable.get(SIPHeaderNamesCache
                    .toLowerCase(mine.getName())));
                {
                    boolean var3911B8F0C4C9004033662F49D485738C_1980389290 = (!his.equals(mine));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!other.getClass().equals(this.getClass())) {
            //return false;
        //}
        //SIPMessage otherMessage = (SIPMessage) other;
        //Collection<SIPHeader> values = this.nameTable.values();
        //Iterator<SIPHeader> it = values.iterator();
        //if (nameTable.size() != otherMessage.nameTable.size()) {
            //return false;
        //}
        //while (it.hasNext()) {
            //SIPHeader mine = (SIPHeader) it.next();
            //SIPHeader his = (SIPHeader) (otherMessage.nameTable.get(SIPHeaderNamesCache
                    //.toLowerCase(mine.getName())));
            //if (his == null) {
                //return false;
            //} else if (!his.equals(mine)) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.016 -0400", hash_original_method = "3C4825ADE695C84AAF8B57CDEA1CF4CB", hash_generated_method = "0BD43126BBCCE081BBA4282D602B2CE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.header.ContentDispositionHeader getContentDisposition() {
        javax.sip.header.ContentDispositionHeader varEB99E9915630BCE2C87A918252DCACD7_1702620130 = ((ContentDispositionHeader) getHeaderLowerCase(CONTENT_DISPOSITION_LOWERCASE));
        return (javax.sip.header.ContentDispositionHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (ContentDispositionHeader) getHeaderLowerCase(CONTENT_DISPOSITION_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.016 -0400", hash_original_method = "46C03ED253FA9F93BF664C06918E9287", hash_generated_method = "2A9DFC11DA6783864C5747BE29A326F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.header.ContentEncodingHeader getContentEncoding() {
        javax.sip.header.ContentEncodingHeader var7DBC8A4F3FBD106A5B1E2C416C53AE8D_1086585397 = ((ContentEncodingHeader) getHeaderLowerCase(CONTENT_ENCODING_LOWERCASE));
        return (javax.sip.header.ContentEncodingHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (ContentEncodingHeader) getHeaderLowerCase(CONTENT_ENCODING_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.016 -0400", hash_original_method = "7F8FF7046ECB01AA1B56D3558C9342AE", hash_generated_method = "34390809D519323E686E259F80AF9361")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.header.ContentLanguageHeader getContentLanguage() {
        javax.sip.header.ContentLanguageHeader varC4A65A7503A944BD9B0E7337C31F23C6_673030189 = ((ContentLanguageHeader) getHeaderLowerCase(CONTENT_LANGUAGE_LOWERCASE));
        return (javax.sip.header.ContentLanguageHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (ContentLanguageHeader) getHeaderLowerCase(CONTENT_LANGUAGE_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.016 -0400", hash_original_method = "9AC8AD6CCC74995A67CEDA1778D18415", hash_generated_method = "D365F793E0FC5979E3AFE70F5EC7161C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.header.ExpiresHeader getExpires() {
        javax.sip.header.ExpiresHeader var268B473CB54475A0C3C89D5D2A61D9E0_1724763102 = ((ExpiresHeader) getHeaderLowerCase(EXPIRES_LOWERCASE));
        return (javax.sip.header.ExpiresHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (ExpiresHeader) getHeaderLowerCase(EXPIRES_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.017 -0400", hash_original_method = "729B7ABDA713D8DD91F71F3C7E5D92DE", hash_generated_method = "E358A7E2B2A85F19AACA8D85785C01A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExpires(ExpiresHeader expiresHeader) {
        dsTaint.addTaint(expiresHeader.dsTaint);
        this.setHeader(expiresHeader);
        // ---------- Original Method ----------
        //this.setHeader(expiresHeader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.017 -0400", hash_original_method = "9820BC2E150668B0FD803FA9E719FCCB", hash_generated_method = "E14414F396A6688BA39B361F42A0BC17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentDisposition(ContentDispositionHeader contentDispositionHeader) {
        dsTaint.addTaint(contentDispositionHeader.dsTaint);
        this.setHeader(contentDispositionHeader);
        // ---------- Original Method ----------
        //this.setHeader(contentDispositionHeader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.017 -0400", hash_original_method = "664B5D910990D19402FB830D30BD43E8", hash_generated_method = "AED73E9C9C1D8F3AE643BB198F476594")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentEncoding(ContentEncodingHeader contentEncodingHeader) {
        dsTaint.addTaint(contentEncodingHeader.dsTaint);
        this.setHeader(contentEncodingHeader);
        // ---------- Original Method ----------
        //this.setHeader(contentEncodingHeader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.017 -0400", hash_original_method = "F5B59DEA81E2E529FE4037C765469E44", hash_generated_method = "7A72D0644DD1762ECA6A0FF015BAC713")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentLanguage(ContentLanguageHeader contentLanguageHeader) {
        dsTaint.addTaint(contentLanguageHeader.dsTaint);
        this.setHeader(contentLanguageHeader);
        // ---------- Original Method ----------
        //this.setHeader(contentLanguageHeader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.017 -0400", hash_original_method = "5BC3E664403E9FC36E24FA33AD51CF36", hash_generated_method = "C78D4A9CB4F5FFFA87E177CEB40428C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentLength(ContentLengthHeader contentLength) {
        dsTaint.addTaint(contentLength.dsTaint);
        try 
        {
            this.contentLengthHeader.setContentLength(contentLength.getContentLength());
        } //End block
        catch (InvalidArgumentException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //this.contentLengthHeader.setContentLength(contentLength.getContentLength());
        //} catch (InvalidArgumentException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.017 -0400", hash_original_method = "B722E58F0DD8E1CBC622964AAF1F9B26", hash_generated_method = "E75F6863F6FFB38FA7F9B2AEDDC96A64")
    @DSModeled(DSC.SAFE)
    public void setSize(int size) {
        dsTaint.addTaint(size);
        // ---------- Original Method ----------
        //this.size = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.018 -0400", hash_original_method = "54E84843E0EEE275508F3EB8305B3F4F", hash_generated_method = "E01873135ED0D928CC928ACC708D625A")
    @DSModeled(DSC.SAFE)
    public int getSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.018 -0400", hash_original_method = "51B72F61F828A2C6A4124D3A8929AD68", hash_generated_method = "6851948A8844B09C000F63C2494019DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addLast(Header header) throws SipException, NullPointerException {
        dsTaint.addTaint(header.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg!");
        try 
        {
            this.attachHeader((SIPHeader) header, false, false);
        } //End block
        catch (SIPDuplicateHeaderException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot add header - header already exists");
        } //End block
        // ---------- Original Method ----------
        //if (header == null)
            //throw new NullPointerException("null arg!");
        //try {
            //this.attachHeader((SIPHeader) header, false, false);
        //} catch (SIPDuplicateHeaderException ex) {
            //throw new SipException("Cannot add header - header already exists");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.018 -0400", hash_original_method = "FB58DD3E1F3A0D99159750C09E15B568", hash_generated_method = "9ABBD47EEC61924C4D4F14123E8B2352")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addFirst(Header header) throws SipException, NullPointerException {
        dsTaint.addTaint(header.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg!");
        try 
        {
            this.attachHeader((SIPHeader) header, false, true);
        } //End block
        catch (SIPDuplicateHeaderException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot add header - header already exists");
        } //End block
        // ---------- Original Method ----------
        //if (header == null)
            //throw new NullPointerException("null arg!");
        //try {
            //this.attachHeader((SIPHeader) header, false, true);
        //} catch (SIPDuplicateHeaderException ex) {
            //throw new SipException("Cannot add header - header already exists");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.018 -0400", hash_original_method = "F7D2F7162E4B2A1EDD2D78AF07F98ED3", hash_generated_method = "7A5694BF17DADD11FA9E36E6E71F1529")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeFirst(String headerName) throws NullPointerException {
        dsTaint.addTaint(headerName);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null argument Provided!");
        this.removeHeader(headerName, true);
        // ---------- Original Method ----------
        //if (headerName == null)
            //throw new NullPointerException("Null argument Provided!");
        //this.removeHeader(headerName, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.018 -0400", hash_original_method = "B1A0AEB4CA388E0A9ED7E42FB6DA96D3", hash_generated_method = "CC322BA262BC39715FE1F90B7B9F4E00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeLast(String headerName) {
        dsTaint.addTaint(headerName);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null argument Provided!");
        this.removeHeader(headerName, false);
        // ---------- Original Method ----------
        //if (headerName == null)
            //throw new NullPointerException("Null argument Provided!");
        //this.removeHeader(headerName, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.019 -0400", hash_original_method = "1B0E35DCABA77A6424B3D6172B19A4B7", hash_generated_method = "EEBE233FC6242B31CAB487C7EC2CB7FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCSeq(CSeqHeader cseqHeader) {
        dsTaint.addTaint(cseqHeader.dsTaint);
        this.setHeader(cseqHeader);
        // ---------- Original Method ----------
        //this.setHeader(cseqHeader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.019 -0400", hash_original_method = "552E0456C33D24CD63C8EBCDAC1D019B", hash_generated_method = "8D4DDB013B0F594611E074B5CF4E663E")
    @DSModeled(DSC.SAFE)
    public void setApplicationData(Object applicationData) {
        dsTaint.addTaint(applicationData.dsTaint);
        // ---------- Original Method ----------
        //this.applicationData = applicationData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.019 -0400", hash_original_method = "5F924FC61375970A4DC758380BEBFF0F", hash_generated_method = "38CB1AED90A48D60BFA15010A96EEDEF")
    @DSModeled(DSC.SAFE)
    public Object getApplicationData() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.applicationData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.019 -0400", hash_original_method = "3FB4581572217B4D34EC8E3A9F62CA88", hash_generated_method = "8D8BA83C5C6A9E88BD0078F15BEE5E63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MultipartMimeContent getMultipartMimeContent() throws ParseException {
        {
            boolean var2CC093753E0ADFD0794491E557D23CC9_524053298 = (this.contentLengthHeader.getContentLength() == 0);
        } //End collapsed parenthetic
        MultipartMimeContentImpl retval;
        retval = new MultipartMimeContentImpl(this
                .getContentTypeHeader());
        byte[] rawContent;
        rawContent = getRawContent();
        try 
        {
            String body;
            body = new String( rawContent, getCharset() );
            retval.createContentList(body);
        } //End block
        catch (UnsupportedEncodingException e)
        {
            InternalErrorHandler.handleException(e);
        } //End block
        return (MultipartMimeContent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this.contentLengthHeader.getContentLength() == 0) {
            //return null;
        //}
        //MultipartMimeContentImpl retval = new MultipartMimeContentImpl(this
                //.getContentTypeHeader());
        //byte[] rawContent = getRawContent();
        //try {
			//String body = new String( rawContent, getCharset() );
	        //retval.createContentList(body);
	        //return retval;
		//} catch (UnsupportedEncodingException e) {
			//InternalErrorHandler.handleException(e);
			//return null;
		//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.019 -0400", hash_original_method = "6A8980AC46BDEC47E118DEA889F580E2", hash_generated_method = "04F2E272C42A43A8FE4ED6F535E7AA17")
    @DSModeled(DSC.SAFE)
    public CallIdHeader getCallIdHeader() {
        return (CallIdHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.callIdHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.020 -0400", hash_original_method = "616E19996CDDFB660618161B80D5BB27", hash_generated_method = "CBB75F7C9F6F1F9F6C0081119D0C38C8")
    @DSModeled(DSC.SAFE)
    public FromHeader getFromHeader() {
        return (FromHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.fromHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.020 -0400", hash_original_method = "9C43D5663CBD78C15545690BFB01C4BF", hash_generated_method = "A9D6B5A5FBB0979FDB231A541A5F6BA0")
    @DSModeled(DSC.SAFE)
    public ToHeader getToHeader() {
        return (ToHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.toHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.020 -0400", hash_original_method = "FE98900B9C779953579B6764E7283FC2", hash_generated_method = "0C5C6464B7F0F9E59D710D80E5CC34CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViaHeader getTopmostViaHeader() {
        ViaHeader var1E5181D00548F0E8A036DFF7707B698B_725114496 = (this.getTopmostVia());
        return (ViaHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.getTopmostVia();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.020 -0400", hash_original_method = "2CE1B7EDE28DB048E923E7FFD28A72BE", hash_generated_method = "D3DAABFDE37AFF09546C504454371C59")
    @DSModeled(DSC.SAFE)
    public CSeqHeader getCSeqHeader() {
        return (CSeqHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.cSeqHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.020 -0400", hash_original_method = "5D0D1F0E94EB86910B32FB17BCD97869", hash_generated_method = "9634D1CF243E2713F9E1D6974C97E7A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final String getCharset() {
        ContentType ct;
        ct = getContentTypeHeader();
        {
            String c;
            c = ct.getCharset();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //ContentType ct = getContentTypeHeader();
        //if (ct!=null) {
    		//String c = ct.getCharset();
    		//return c!=null ? c : contentEncodingCharset;
    	//} else return contentEncodingCharset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.020 -0400", hash_original_method = "F8575631397F30A77B6575B01C9E50F5", hash_generated_method = "1251A7015B33B27BFEEE3FDEB80B0EE4")
    @DSModeled(DSC.SAFE)
    public boolean isNullRequest() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return  this.nullRequest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.020 -0400", hash_original_method = "76987385F34084CF4A8C6AA1CD858E63", hash_generated_method = "9270889C04904F8C78507597689FCBFB")
    @DSModeled(DSC.SAFE)
    public void setNullRequest() {
        this.nullRequest = true;
        // ---------- Original Method ----------
        //this.nullRequest = true;
    }

    
    public abstract void setSIPVersion(String sipVersion) throws ParseException;

    
    public abstract String getSIPVersion();

    
    public abstract String toString();

    
    private static final String CONTENT_TYPE_LOWERCASE = SIPHeaderNamesCache
    .toLowerCase(ContentTypeHeader.NAME);
    private static final String ERROR_LOWERCASE = SIPHeaderNamesCache.toLowerCase(ErrorInfo.NAME);
    private static final String CONTACT_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ContactHeader.NAME);
    private static final String VIA_LOWERCASE = SIPHeaderNamesCache.toLowerCase(ViaHeader.NAME);
    private static final String AUTHORIZATION_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(AuthorizationHeader.NAME);
    private static final String ROUTE_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(RouteHeader.NAME);
    private static final String RECORDROUTE_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(RecordRouteHeader.NAME);
    private static final String CONTENT_DISPOSITION_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ContentDispositionHeader.NAME);
    private static final String CONTENT_ENCODING_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ContentEncodingHeader.NAME);
    private static final String CONTENT_LANGUAGE_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ContentLanguageHeader.NAME);
    private static final String EXPIRES_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ExpiresHeader.NAME);
}

