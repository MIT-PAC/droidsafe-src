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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.536 -0400", hash_original_field = "1E0E36F4EE56089C28BCB9B0F9B200D4", hash_generated_field = "4BA5E6BB1036D79534D4BE3D73466535")

    private String contentEncodingCharset = MessageFactoryImpl.getDefaultContentEncodingCharset();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.536 -0400", hash_original_field = "56B43B060CEE73356D58D497BA1C84EF", hash_generated_field = "3D632899724829D8B5950E7FD03861B1")

    protected boolean nullRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.536 -0400", hash_original_field = "8068711CC630B2B1E236623A9F225BDE", hash_generated_field = "E835C2C2C7A6613C6BF5AAA84C167353")

    protected LinkedList<String> unrecognizedHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.536 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "247E0138E51DEE8295CE7FD03B5C7C7F")

    protected ConcurrentLinkedQueue<SIPHeader> headers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.536 -0400", hash_original_field = "AC7113BAC9CAF3E84139BDAB33B013CD", hash_generated_field = "41941E45293112AC36DC5E7BE4DFF5AE")

    protected From fromHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.536 -0400", hash_original_field = "B779FC79043D8E24F2CB866B1B31BF4F", hash_generated_field = "386FEF496B2D00FF2AEEA4F647EAA2EC")

    protected To toHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.536 -0400", hash_original_field = "1124446E2524DA4D31B54C124ED3B1EA", hash_generated_field = "9243D81B8C37269C34D9BD3D6292835A")

    protected CSeq cSeqHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.536 -0400", hash_original_field = "F4E470CD8970EBBE1902E50EB09F4952", hash_generated_field = "471E372FA6B60996CC5D5DA482544660")

    protected CallID callIdHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.536 -0400", hash_original_field = "D7AC18F96FF3D69F56F179B05471A942", hash_generated_field = "BD2FD117E706370D42DF61B188BF8940")

    protected ContentLength contentLengthHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.536 -0400", hash_original_field = "237F1BDE377EF84E632D622E7809F04B", hash_generated_field = "19F23DC4282A0EF2D6622C8B0C1149E7")

    protected MaxForwards maxForwardsHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.536 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "BEC7808019D8AD57BF06A5469459FF0A")

    protected int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.536 -0400", hash_original_field = "2ECFA4ADA27CE6869BB8F49F338F1D05", hash_generated_field = "BDA818F16CAD309D41556EC35AB6E563")

    private String messageContent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.536 -0400", hash_original_field = "F39EF8B0045FE162F4D1F6DFC1649F07", hash_generated_field = "3E3D2657E47D4DE2C783823CF246BBAB")

    private byte[] messageContentBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.536 -0400", hash_original_field = "BDA0AA4A25131E44F152C2811CF23974", hash_generated_field = "1560325BE0E32978EBE2ECDE71A6C345")

    private Object messageContentObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.536 -0400", hash_original_field = "4BEA1CEB6A7BE38EA2C72D63BB1811A8", hash_generated_field = "1C03D389CB46F0B01812A6FDFBD5DD7D")

    private Hashtable<String, SIPHeader> nameTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.536 -0400", hash_original_field = "756C73A51ADF7F04942C8BE97A032000", hash_generated_field = "89FDF1CBFFC083F61390A7888D3F82DE")

    protected Object applicationData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.537 -0400", hash_original_method = "7EF8FE4247F4A54A74550FF503F5DF85", hash_generated_method = "9DF4127C06DEBDC679265FCD9AB742DC")
    public  SIPMessage() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.548 -0400", hash_original_method = "4E875487FBA3E9E3C25B636513844812", hash_generated_method = "12F0F98E0FD27F7952ADFCBEEB5A1422")
    public LinkedList<String> getMessageAsEncodedStrings() {
        LinkedList<String> varB4EAC82CA7396A68D541C85D26508E83_280315259 = null; //Variable for return #1
        LinkedList<String> retval;
        retval = new LinkedList<String>();
        Iterator<SIPHeader> li;
        li = headers.iterator();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_792183004 = (li.hasNext());
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
        varB4EAC82CA7396A68D541C85D26508E83_280315259 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_280315259.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_280315259;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.549 -0400", hash_original_method = "A27900405272FB61F2D6362A05DA41D6", hash_generated_method = "2A4602A8E457C7A92007AEAD19AC96FB")
    protected String encodeSIPHeaders() {
        String varB4EAC82CA7396A68D541C85D26508E83_2085598618 = null; //Variable for return #1
        StringBuffer encoding;
        encoding = new StringBuffer();
        Iterator<SIPHeader> it;
        it = this.headers.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1575898202 = (it.hasNext());
            {
                SIPHeader siphdr;
                siphdr = (SIPHeader) it.next();
                siphdr.encode(encoding);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2085598618 = contentLengthHeader.encode(encoding).append(NEWLINE).toString();
        varB4EAC82CA7396A68D541C85D26508E83_2085598618.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2085598618;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.564 -0400", hash_original_method = "AC5B2D97481875B2502EE3A7FDAB3C5D", hash_generated_method = "65CDDA3E774DE400C4BD6EEC4C778F49")
    public boolean match(Object other) {
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_733574207 = (!other.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        SIPMessage matchObj;
        matchObj = (SIPMessage) other;
        Iterator<SIPHeader> li;
        li = matchObj.getHeaders();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_811763422 = (li.hasNext());
            {
                SIPHeader hisHeaders;
                hisHeaders = (SIPHeader) li.next();
                List<SIPHeader> myHeaders;
                myHeaders = this.getHeaderList(hisHeaders.getHeaderName());
                {
                    boolean var1A87CEBFEDCDEA34F4CA0D4A3EFEF656_673920138 = (myHeaders == null || myHeaders.size() == 0);
                } //End collapsed parenthetic
                {
                    ListIterator< ? > outerIterator;
                    outerIterator = ((SIPHeaderList< ? >) hisHeaders)
                        .listIterator();
                    {
                        boolean var4B5292B8CB3E98B12515573A3508C4DF_2015971105 = (outerIterator.hasNext());
                        {
                            SIPHeader hisHeader;
                            hisHeader = (SIPHeader) outerIterator.next();
                            ListIterator< ? > innerIterator;
                            innerIterator = myHeaders.listIterator();
                            boolean found;
                            found = false;
                            {
                                boolean varB2E7926CCD2DEA34339CB3F15E1E57D6_2031613141 = (innerIterator.hasNext());
                                {
                                    SIPHeader myHeader;
                                    myHeader = (SIPHeader) innerIterator.next();
                                    {
                                        boolean varB96E7D72BCDF0CE20043B09547ED5B50_602977116 = (myHeader.match(hisHeader));
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
                        boolean varB3D6059B83D121ABA5AE6C0435970C24_1560324274 = (innerIterator.hasNext());
                        {
                            SIPHeader myHeader;
                            myHeader = (SIPHeader) innerIterator.next();
                            {
                                boolean var6566F8FAB9C32C1FD403D502EB8A4D9C_1261886559 = (myHeader.match(hisHeader));
                                {
                                    found = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_929160888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_929160888;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.565 -0400", hash_original_method = "789EABA7F64EF1819B9EE91356F4E918", hash_generated_method = "61BD591D0B26320BE7DFE32AE77ECC4D")
    public void merge(Object template) {
        {
            boolean var283342AFB2702617040FEF7CDFDA21F1_664011282 = (!template.getClass().equals(this.getClass()));
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
                        boolean var4CA2EDBF7D27138D75E73CCD01CCB025_481364601 = (it.hasNext());
                        {
                            SIPHeader sipHdr;
                            sipHdr = (SIPHeader) it.next();
                            sipHdr.merge(hdr);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(template.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.641 -0400", hash_original_method = "79C45AA8D92059F002F56259D7022AFE", hash_generated_method = "D9C4EF6037F415C05C5510C09ECD17C5")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_658676819 = null; //Variable for return #1
        StringBuffer encoding;
        encoding = new StringBuffer();
        Iterator<SIPHeader> it;
        it = this.headers.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1062112523 = (it.hasNext());
            {
                SIPHeader siphdr;
                siphdr = (SIPHeader) it.next();
                encoding.append(siphdr.encode());
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<String> varFA17E7EA4EAE757CB30CF87AB56BCB8E_1196352775 = (this.unrecognizedHeaders).iterator();
            varFA17E7EA4EAE757CB30CF87AB56BCB8E_1196352775.hasNext();
            String unrecognized = varFA17E7EA4EAE757CB30CF87AB56BCB8E_1196352775.next();
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
        varB4EAC82CA7396A68D541C85D26508E83_658676819 = encoding.toString();
        varB4EAC82CA7396A68D541C85D26508E83_658676819.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_658676819;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.648 -0400", hash_original_method = "716A084604DD8483BAA5EE270A2C01EC", hash_generated_method = "B5947BEFBC8058B66542C1E71EAA0150")
    public byte[] encodeAsBytes(String transport) {
        {
            boolean varA83D0D387E30A4710F38765D733091FF_1241853577 = (this instanceof SIPRequest && ((SIPRequest) this).isNullRequest());
            {
                byte[] varEEF83FE8F2414029AB57C6129B64128C_1816081314 = ("\r\n\r\n".getBytes());
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
                boolean varB2FF4435B274CC4BE01D264DEA08F957_217243983 = (it.hasNext());
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
        addTaint(transport.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1470626556 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1470626556;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.665 -0400", hash_original_method = "CAA2D0A800A8BA91CFE25E08D1466992", hash_generated_method = "6501A61FC553904263677552EDC1A257")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_28021731 = null; //Variable for return #1
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
                boolean var8492AE2C695A56B730381A28B8BA3F6D_1136007480 = (iter.hasNext());
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
        varB4EAC82CA7396A68D541C85D26508E83_28021731 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_28021731.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_28021731;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.667 -0400", hash_original_method = "CE435A19EF4C3C8ADC65C5BBD44452BB", hash_generated_method = "DD944A6798D089EE1019358D28F7EEDC")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_975511538 = null; //Variable for return #1
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
                        boolean var23F939341918CCB039A47328F0B892FA_1559078203 = (f.get(this) != null && SIPHeader.class.isAssignableFrom(fieldType)
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
            boolean var4C7E5D19EA905354F5CD428885C482C2_1892723299 = (this.getContent() != null);
            {
                sprint(this.getContent().toString());
            } //End block
        } //End collapsed parenthetic
        sprint("}");
        varB4EAC82CA7396A68D541C85D26508E83_975511538 = stringRepresentation;
        varB4EAC82CA7396A68D541C85D26508E83_975511538.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_975511538;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.668 -0400", hash_original_method = "D9E90811A837F48EC447FF925318738A", hash_generated_method = "330D74D1C00FFE0AC8BE369EB6D9BEAB")
    private void attachHeader(SIPHeader h) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("null header!");
        try 
        {
            {
                SIPHeaderList< ? > hl;
                hl = (SIPHeaderList< ? >) h;
                {
                    boolean var394E2F20856295BBEFBFAE80A46F780D_1757076642 = (hl.isEmpty());
                } //End collapsed parenthetic
            } //End block
            attachHeader(h, false, false);
        } //End block
        catch (SIPDuplicateHeaderException ex)
        { }
        addTaint(h.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.668 -0400", hash_original_method = "230B17E5A17A83111BEC4A023E8D6F14", hash_generated_method = "07D9CBA29DCB641943DDCDB900A9DD85")
    public void setHeader(Header sipHeader) {
        SIPHeader header;
        header = (SIPHeader) sipHeader;
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("null header!");
        try 
        {
            {
                SIPHeaderList< ? > hl;
                hl = (SIPHeaderList< ? >) header;
                {
                    boolean var394E2F20856295BBEFBFAE80A46F780D_1632560374 = (hl.isEmpty());
                } //End collapsed parenthetic
            } //End block
            this.removeHeader(header.getHeaderName());
            attachHeader(header, true, false);
        } //End block
        catch (SIPDuplicateHeaderException ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        addTaint(sipHeader.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.669 -0400", hash_original_method = "DC88726E428D89A7A7082B0D5F94DA0F", hash_generated_method = "FC05D13A49A690C7241C15B158D3AE1C")
    public void setHeaders(java.util.List<SIPHeader> headers) {
        ListIterator<SIPHeader> listIterator;
        listIterator = headers.listIterator();
        {
            boolean var64B293ABD2B064B3F6A70551787AFBD5_1996185706 = (listIterator.hasNext());
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
        addTaint(headers.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.669 -0400", hash_original_method = "9B17545BC9FC78AB24684381D78F3E60", hash_generated_method = "E410CC311470FEC5545821CB8000708C")
    public void attachHeader(SIPHeader h, boolean replaceflag) throws SIPDuplicateHeaderException {
        this.attachHeader(h, replaceflag, false);
        addTaint(h.getTaint());
        addTaint(replaceflag);
        // ---------- Original Method ----------
        //this.attachHeader(h, replaceflag, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.681 -0400", hash_original_method = "7BE2AED7224623BF9774680F8F08FE9F", hash_generated_method = "F6F7729FAE3A2D30D2C04AD1DE0CE1D7")
    public void attachHeader(SIPHeader header, boolean replaceFlag, boolean top) throws SIPDuplicateHeaderException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null header");
        } //End block
        SIPHeader h;
        {
            boolean varFDBDF2C7B3EA303E85FC4F475643B632_198347703 = (ListMap.hasList(header) && !SIPHeaderList.class.isAssignableFrom(header.getClass()));
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
            boolean varFD544112D28585F2EA3523A14E11B4D2_1619349486 = (nameTable.containsKey(headerNameLowerCase) && !(h instanceof SIPHeaderList));
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
                boolean varD1722E42EA3CA8952F93B6521D875E61_1916728737 = (li.hasNext());
                {
                    SIPHeader next;
                    next = (SIPHeader) li.next();
                    {
                        boolean varF7DF1CC74D70E774011938D4CD0C0F10_1758527986 = (next.equals(originalHeader));
                        {
                            li.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varE6233AB522C882584164D87B1A152DBC_1456502274 = (!nameTable.containsKey(headerNameLowerCase));
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
        addTaint(header.getTaint());
        addTaint(replaceFlag);
        addTaint(top);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.697 -0400", hash_original_method = "870FE8D30093D63C50FAB8B7342DE2BD", hash_generated_method = "462C488A54ACAB683D4E64FFFEE1F5AB")
    public void removeHeader(String headerName, boolean top) {
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
                boolean var07A70300EBEAD4C7EF18232220E71612_981134559 = (hdrList.isEmpty());
                {
                    Iterator<SIPHeader> li;
                    li = this.headers.iterator();
                    {
                        boolean var3B4C388F9F77D89F36DAE45711DE06F7_1249506427 = (li.hasNext());
                        {
                            SIPHeader sipHeader;
                            sipHeader = (SIPHeader) li.next();
                            {
                                boolean var009E1FF0FE664B4BBC785303E466D8DE_553529472 = (sipHeader.getName().equalsIgnoreCase(headerNameLowerCase));
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
                boolean varD1722E42EA3CA8952F93B6521D875E61_158474661 = (li.hasNext());
                {
                    SIPHeader sipHeader;
                    sipHeader = (SIPHeader) li.next();
                    {
                        boolean var330E19EEBCC4008A3544282ED6FC5397_499009092 = (sipHeader.getName().equalsIgnoreCase(headerName));
                        li.remove();
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(headerName.getTaint());
        addTaint(top);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.699 -0400", hash_original_method = "A43C3FE911C5904FA81F0CAD0EBF40FE", hash_generated_method = "90379E349F2B094237DCD745ED0D2EC9")
    public void removeHeader(String headerName) {
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
            boolean varBC3D864DE8830EFC1098D2C2F456529D_14884981 = (li.hasNext());
            {
                SIPHeader sipHeader;
                sipHeader = (SIPHeader) li.next();
                {
                    boolean varFFF8027342880D91B8946C60AFFB1639_151526710 = (sipHeader.getName().equalsIgnoreCase(headerNameLowerCase));
                    li.remove();
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(headerName.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.711 -0400", hash_original_method = "04B79D458A896A4F330B98FD27925CCB", hash_generated_method = "62EDC7C69C540A2DBEC5DD532D0D7618")
    public String getTransactionId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1893789870 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1054104550 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_473521190 = null; //Variable for return #3
        Via topVia;
        topVia = null;
        {
            boolean var45427AD504224B42EAB753EE244922DA_1156971883 = (!this.getViaHeaders().isEmpty());
            {
                topVia = (Via) this.getViaHeaders().getFirst();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var056F2938B12C580EE182B380BF3D72E4_1098408667 = (topVia != null
                && topVia.getBranch() != null
                && topVia.getBranch().toUpperCase().startsWith(
                        SIPConstants.BRANCH_MAGIC_COOKIE_UPPER_CASE));
            {
                {
                    boolean varC5B42D35EFD1E3730754821E02818371_99302466 = (this.getCSeq().getMethod().equals(Request.CANCEL));
                    varB4EAC82CA7396A68D541C85D26508E83_1893789870 = (topVia.getBranch() + ":" + this.getCSeq().getMethod()).toLowerCase();
                    varB4EAC82CA7396A68D541C85D26508E83_1054104550 = topVia.getBranch().toLowerCase();
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
                    boolean var6A7392F4B3488A548307196F7AD78D4D_696619130 = (from.hasTag());
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
                        boolean var739F416062AF6DDEEFA862BDC661C203_2007162259 = (!topVia.getSentBy().hasPort());
                        {
                            retval.append("-").append(5060);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varC5B42D35EFD1E3730754821E02818371_477269391 = (this.getCSeq().getMethod().equals(Request.CANCEL));
                    {
                        retval.append(Request.CANCEL);
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_473521190 = retval.toString().toLowerCase().replace(":", "-").replace("@", "-")
                    + Utils.getSignature();
            } //End block
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_425807536; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_425807536 = varB4EAC82CA7396A68D541C85D26508E83_1893789870;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_425807536 = varB4EAC82CA7396A68D541C85D26508E83_1054104550;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_425807536 = varB4EAC82CA7396A68D541C85D26508E83_473521190;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_425807536.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_425807536;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.712 -0400", hash_original_method = "2D96B4A52CFB118A97F95400511B110F", hash_generated_method = "35BA38EF853C3F68F936400E27D00F72")
    public int hashCode() {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Invalid message! Cannot compute hashcode! call-id header is missing !");
        int var16C3388685D263B76B89DE8120886CF4_1901993850 = (this.callIdHeader.getCallId().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260924886 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260924886;
        // ---------- Original Method ----------
        //if (this.callIdHeader == null)
            //throw new RuntimeException(
                    //"Invalid message! Cannot compute hashcode! call-id header is missing !");
        //else
            //return this.callIdHeader.getCallId().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.729 -0400", hash_original_method = "0B4068F7FDD81C59C44EF10BE948C047", hash_generated_method = "6557A7593B0366F629E6E67C2EE2C50E")
    public boolean hasContent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_291954352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_291954352;
        // ---------- Original Method ----------
        //return messageContent != null || messageContentBytes != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.730 -0400", hash_original_method = "16CF6C29A1D923EBFDFB9DE65000093A", hash_generated_method = "C45C890DA52010C9523DB5C3CC340E46")
    public Iterator<SIPHeader> getHeaders() {
        Iterator<SIPHeader> varB4EAC82CA7396A68D541C85D26508E83_1344706737 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1344706737 = headers.iterator();
        varB4EAC82CA7396A68D541C85D26508E83_1344706737.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1344706737;
        // ---------- Original Method ----------
        //return headers.iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.730 -0400", hash_original_method = "1ADD77F2239C280F0A32414969B68312", hash_generated_method = "7EBDDA1637711150C8D9CA862369A419")
    public Header getHeader(String headerName) {
        Header varB4EAC82CA7396A68D541C85D26508E83_1405129006 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1405129006 = getHeaderLowerCase(SIPHeaderNamesCache.toLowerCase(headerName));
        addTaint(headerName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1405129006.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1405129006;
        // ---------- Original Method ----------
        //return getHeaderLowerCase(SIPHeaderNamesCache.toLowerCase(headerName));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.735 -0400", hash_original_method = "32A79E235DDCC6E80E2B12189B346373", hash_generated_method = "69B83FCF29043A56D951A10238C96A7E")
    private Header getHeaderLowerCase(String lowerCaseHeaderName) {
        Header varB4EAC82CA7396A68D541C85D26508E83_987509987 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_466178659 = null; //Variable for return #2
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad name");
        SIPHeader sipHeader;
        sipHeader = (SIPHeader) nameTable.get(lowerCaseHeaderName);
        varB4EAC82CA7396A68D541C85D26508E83_987509987 = (Header) ((SIPHeaderList) sipHeader).getFirst();
        varB4EAC82CA7396A68D541C85D26508E83_466178659 = (Header) sipHeader;
        addTaint(lowerCaseHeaderName.getTaint());
        Header varA7E53CE21691AB073D9660D615818899_67150535; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_67150535 = varB4EAC82CA7396A68D541C85D26508E83_987509987;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_67150535 = varB4EAC82CA7396A68D541C85D26508E83_466178659;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_67150535.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_67150535;
        // ---------- Original Method ----------
        //if (lowerCaseHeaderName == null)
            //throw new NullPointerException("bad name");
        //SIPHeader sipHeader = (SIPHeader) nameTable.get(lowerCaseHeaderName);
        //if (sipHeader instanceof SIPHeaderList)
            //return (Header) ((SIPHeaderList) sipHeader).getFirst();
        //else
            //return (Header) sipHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.735 -0400", hash_original_method = "094433154D44236D0991BBCF366E0E6A", hash_generated_method = "AFBA1BFC3FAC39883634C3FD250EB771")
    public ContentType getContentTypeHeader() {
        ContentType varB4EAC82CA7396A68D541C85D26508E83_1866447829 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1866447829 = (ContentType) getHeaderLowerCase(CONTENT_TYPE_LOWERCASE);
        varB4EAC82CA7396A68D541C85D26508E83_1866447829.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1866447829;
        // ---------- Original Method ----------
        //return (ContentType) getHeaderLowerCase(CONTENT_TYPE_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.736 -0400", hash_original_method = "F29DC29143C65AC3E05B010248583D2F", hash_generated_method = "412368EAC7762316996BCCFD3F9F3F1B")
    public ContentLengthHeader getContentLengthHeader() {
        ContentLengthHeader varB4EAC82CA7396A68D541C85D26508E83_1171896689 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1171896689 = this.getContentLength();
        varB4EAC82CA7396A68D541C85D26508E83_1171896689.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1171896689;
        // ---------- Original Method ----------
        //return this.getContentLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.737 -0400", hash_original_method = "E10DCB9A2200DABE5E8DE063DD5342F3", hash_generated_method = "C4EE76A4BD74638A046CB884399FFC33")
    public FromHeader getFrom() {
        FromHeader varB4EAC82CA7396A68D541C85D26508E83_1252642518 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1252642518 = (FromHeader) fromHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1252642518.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1252642518;
        // ---------- Original Method ----------
        //return (FromHeader) fromHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.740 -0400", hash_original_method = "10D7F219ADDA2D1F9DA30C2C2F401D03", hash_generated_method = "B97E03150EBD0C8B847A06EC27C76421")
    public ErrorInfoList getErrorInfoHeaders() {
        ErrorInfoList varB4EAC82CA7396A68D541C85D26508E83_1596471554 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1596471554 = (ErrorInfoList) getSIPHeaderListLowerCase(ERROR_LOWERCASE);
        varB4EAC82CA7396A68D541C85D26508E83_1596471554.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1596471554;
        // ---------- Original Method ----------
        //return (ErrorInfoList) getSIPHeaderListLowerCase(ERROR_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.741 -0400", hash_original_method = "6BBB646E6D7D64808CC70B68BEB17C86", hash_generated_method = "0DEF9C9CDB6548D0378AB1DC8ED79E8E")
    public ContactList getContactHeaders() {
        ContactList varB4EAC82CA7396A68D541C85D26508E83_1276697995 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1276697995 = (ContactList) this.getSIPHeaderListLowerCase(CONTACT_LOWERCASE);
        varB4EAC82CA7396A68D541C85D26508E83_1276697995.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1276697995;
        // ---------- Original Method ----------
        //return (ContactList) this.getSIPHeaderListLowerCase(CONTACT_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.751 -0400", hash_original_method = "7930A8382B37585900D6B0ADAEF5E908", hash_generated_method = "14898D30B22834B627ED3BF9ACD5BFEF")
    public Contact getContactHeader() {
        Contact varB4EAC82CA7396A68D541C85D26508E83_1002667730 = null; //Variable for return #1
        Contact varB4EAC82CA7396A68D541C85D26508E83_681812636 = null; //Variable for return #2
        ContactList clist;
        clist = this.getContactHeaders();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1002667730 = (Contact) clist.getFirst();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_681812636 = null;
        } //End block
        Contact varA7E53CE21691AB073D9660D615818899_1146751208; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1146751208 = varB4EAC82CA7396A68D541C85D26508E83_1002667730;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1146751208 = varB4EAC82CA7396A68D541C85D26508E83_681812636;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1146751208.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1146751208;
        // ---------- Original Method ----------
        //ContactList clist = this.getContactHeaders();
        //if (clist != null) {
            //return (Contact) clist.getFirst();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.779 -0400", hash_original_method = "F913627528E03E7BE96F6FC26EC1EAB5", hash_generated_method = "AAE488DBF7F165BD943A7713AF3C85C5")
    public ViaList getViaHeaders() {
        ViaList varB4EAC82CA7396A68D541C85D26508E83_838015988 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_838015988 = (ViaList) getSIPHeaderListLowerCase(VIA_LOWERCASE);
        varB4EAC82CA7396A68D541C85D26508E83_838015988.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_838015988;
        // ---------- Original Method ----------
        //return (ViaList) getSIPHeaderListLowerCase(VIA_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.779 -0400", hash_original_method = "4714C62FF03EE4A312864AB7EDBC16A3", hash_generated_method = "FA5CCB1DB04BF88FFA7A7B4A9B5FC2D2")
    public void setVia(java.util.List viaList) {
        ViaList vList;
        vList = new ViaList();
        ListIterator it;
        it = viaList.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_2010703660 = (it.hasNext());
            {
                Via via;
                via = (Via) it.next();
                vList.add(via);
            } //End block
        } //End collapsed parenthetic
        this.setHeader(vList);
        addTaint(viaList.getTaint());
        // ---------- Original Method ----------
        //ViaList vList = new ViaList();
        //ListIterator it = viaList.listIterator();
        //while (it.hasNext()) {
            //Via via = (Via) it.next();
            //vList.add(via);
        //}
        //this.setHeader(vList);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.780 -0400", hash_original_method = "458FFC69EFF172F74B60E661629859D7", hash_generated_method = "67EDF1CD86F2C25AE371B91BD0C09BC3")
    public void setHeader(SIPHeaderList<Via> sipHeaderList) {
        this.setHeader((Header) sipHeaderList);
        addTaint(sipHeaderList.getTaint());
        // ---------- Original Method ----------
        //this.setHeader((Header) sipHeaderList);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.780 -0400", hash_original_method = "D8225C1F89A591B431137F8AC67C8011", hash_generated_method = "D1F53DA4F9361CCFECA4C221C197DE7E")
    public Via getTopmostVia() {
        Via varB4EAC82CA7396A68D541C85D26508E83_2026977689 = null; //Variable for return #1
        Via varB4EAC82CA7396A68D541C85D26508E83_1592829137 = null; //Variable for return #2
        {
            boolean var7008E835C5FBF6766081DAE39E1151D8_672374038 = (this.getViaHeaders() == null);
            varB4EAC82CA7396A68D541C85D26508E83_2026977689 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1592829137 = (Via) (getViaHeaders().getFirst());
        } //End collapsed parenthetic
        Via varA7E53CE21691AB073D9660D615818899_1954727490; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1954727490 = varB4EAC82CA7396A68D541C85D26508E83_2026977689;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1954727490 = varB4EAC82CA7396A68D541C85D26508E83_1592829137;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1954727490.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1954727490;
        // ---------- Original Method ----------
        //if (this.getViaHeaders() == null)
            //return null;
        //else
            //return (Via) (getViaHeaders().getFirst());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.781 -0400", hash_original_method = "734B287C3C9508BBD63962A2764D9C01", hash_generated_method = "8EA6D471B6FCA7C2AE40B5F06CEECB50")
    public CSeqHeader getCSeq() {
        CSeqHeader varB4EAC82CA7396A68D541C85D26508E83_2035680558 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2035680558 = (CSeqHeader) cSeqHeader;
        varB4EAC82CA7396A68D541C85D26508E83_2035680558.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2035680558;
        // ---------- Original Method ----------
        //return (CSeqHeader) cSeqHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.782 -0400", hash_original_method = "6A92E6492A4EA537FE7E1089912E5A2E", hash_generated_method = "E64805ED86A732A639ED33F8708C2E55")
    public Authorization getAuthorization() {
        Authorization varB4EAC82CA7396A68D541C85D26508E83_1678175699 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1678175699 = (Authorization) getHeaderLowerCase(AUTHORIZATION_LOWERCASE);
        varB4EAC82CA7396A68D541C85D26508E83_1678175699.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1678175699;
        // ---------- Original Method ----------
        //return (Authorization) getHeaderLowerCase(AUTHORIZATION_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.783 -0400", hash_original_method = "1941B7A53D19F77542CA45C05AFF9884", hash_generated_method = "D7047EA411EB6AA91DD046DECE1706B1")
    public MaxForwardsHeader getMaxForwards() {
        MaxForwardsHeader varB4EAC82CA7396A68D541C85D26508E83_1463375926 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1463375926 = maxForwardsHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1463375926.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1463375926;
        // ---------- Original Method ----------
        //return maxForwardsHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.783 -0400", hash_original_method = "08224707CDDBB2C37148D3B618E2B6B7", hash_generated_method = "C7782781DD6A03E28DECD79DAD99D8FE")
    public void setMaxForwards(MaxForwardsHeader maxForwards) {
        this.setHeader(maxForwards);
        addTaint(maxForwards.getTaint());
        // ---------- Original Method ----------
        //this.setHeader(maxForwards);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.783 -0400", hash_original_method = "7800F88C4B689BC7D7C78CBE850678CA", hash_generated_method = "85D2D7D883F0F656E366294DBFBBED9D")
    public RouteList getRouteHeaders() {
        RouteList varB4EAC82CA7396A68D541C85D26508E83_600515931 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_600515931 = (RouteList) getSIPHeaderListLowerCase(ROUTE_LOWERCASE);
        varB4EAC82CA7396A68D541C85D26508E83_600515931.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_600515931;
        // ---------- Original Method ----------
        //return (RouteList) getSIPHeaderListLowerCase(ROUTE_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.785 -0400", hash_original_method = "9DA69A74904D39D3267E3E1010C409F3", hash_generated_method = "51613D146958DED7F6C0C01843916A64")
    public CallIdHeader getCallId() {
        CallIdHeader varB4EAC82CA7396A68D541C85D26508E83_107652894 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_107652894 = callIdHeader;
        varB4EAC82CA7396A68D541C85D26508E83_107652894.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_107652894;
        // ---------- Original Method ----------
        //return callIdHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.788 -0400", hash_original_method = "5127E494FA29164B5CB6A74D7F3B176F", hash_generated_method = "93D4EC778359912FC3F69DC75D69A78A")
    public void setCallId(CallIdHeader callId) {
        this.setHeader(callId);
        addTaint(callId.getTaint());
        // ---------- Original Method ----------
        //this.setHeader(callId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.788 -0400", hash_original_method = "16037BFD4917B839A558D81FBF251209", hash_generated_method = "F3D09F4F11A0A28101BC189451A23614")
    public void setCallId(String callId) throws java.text.ParseException {
        {
            this.setHeader(new CallID());
        } //End block
        callIdHeader.setCallId(callId);
        addTaint(callId.getTaint());
        // ---------- Original Method ----------
        //if (callIdHeader == null) {
            //this.setHeader(new CallID());
        //}
        //callIdHeader.setCallId(callId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.789 -0400", hash_original_method = "6FCB806D3659BA1DF59CA318834E3C35", hash_generated_method = "1DD0604C8C83D10512EAE8B4076EBAD9")
    public RecordRouteList getRecordRouteHeaders() {
        RecordRouteList varB4EAC82CA7396A68D541C85D26508E83_390764286 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_390764286 = (RecordRouteList) this.getSIPHeaderListLowerCase(RECORDROUTE_LOWERCASE);
        varB4EAC82CA7396A68D541C85D26508E83_390764286.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_390764286;
        // ---------- Original Method ----------
        //return (RecordRouteList) this.getSIPHeaderListLowerCase(RECORDROUTE_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.789 -0400", hash_original_method = "D2F3523F315E42C3CDB78FE4D7DBD860", hash_generated_method = "847E97554E6CA48A97740E8AD30F11B9")
    public ToHeader getTo() {
        ToHeader varB4EAC82CA7396A68D541C85D26508E83_831290123 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_831290123 = (ToHeader) toHeader;
        varB4EAC82CA7396A68D541C85D26508E83_831290123.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_831290123;
        // ---------- Original Method ----------
        //return (ToHeader) toHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.789 -0400", hash_original_method = "AA146219F068967CE3F55E3F637E86D7", hash_generated_method = "2054F00F6867314407CF3FA28F4FDE51")
    public void setTo(ToHeader to) {
        this.setHeader(to);
        addTaint(to.getTaint());
        // ---------- Original Method ----------
        //this.setHeader(to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.789 -0400", hash_original_method = "61E9A0C02A79622F4076A17D3E8275D9", hash_generated_method = "E26DF63DDF37B39138EA3D063BD4E1F4")
    public void setFrom(FromHeader from) {
        this.setHeader(from);
        addTaint(from.getTaint());
        // ---------- Original Method ----------
        //this.setHeader(from);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.790 -0400", hash_original_method = "BF14C97BBADF5B6B3DD1A606FFB97154", hash_generated_method = "3FDEC7943130D362C60E399265CAA888")
    public ContentLengthHeader getContentLength() {
        ContentLengthHeader varB4EAC82CA7396A68D541C85D26508E83_637941315 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_637941315 = this.contentLengthHeader;
        varB4EAC82CA7396A68D541C85D26508E83_637941315.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_637941315;
        // ---------- Original Method ----------
        //return this.contentLengthHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.792 -0400", hash_original_method = "40D47E0A8FD809ED2EC3170259DB7692", hash_generated_method = "BF2EC68D685A2C1A3346ADA5A9AF1760")
    public String getMessageContent() throws UnsupportedEncodingException {
        String varB4EAC82CA7396A68D541C85D26508E83_17530424 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2001714292 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_17530424 = null;
        {
            this.messageContent = new String(messageContentBytes, getCharset() );
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2001714292 = this.messageContent;
        String varA7E53CE21691AB073D9660D615818899_980008578; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_980008578 = varB4EAC82CA7396A68D541C85D26508E83_17530424;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_980008578 = varB4EAC82CA7396A68D541C85D26508E83_2001714292;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_980008578.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_980008578;
        // ---------- Original Method ----------
        //if (this.messageContent == null && this.messageContentBytes == null)
            //return null;
        //else if (this.messageContent == null) {
            //this.messageContent = new String(messageContentBytes, getCharset() );
        //}
        //return this.messageContent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.792 -0400", hash_original_method = "0A8A11F2CA57642B3F77F3FF48221ABE", hash_generated_method = "4545D172EB617581E37940246F9CF90E")
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2105528699 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2105528699;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.793 -0400", hash_original_method = "AF476AB0E969B944040525792C5BC52E", hash_generated_method = "21B618C6C7A31C64E1158733A6D4B327")
    public void setMessageContent(String type, String subType, String messageContent) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("messgeContent is null");
        ContentType ct;
        ct = new ContentType(type, subType);
        this.setHeader(ct);
        this.messageContent = messageContent;
        this.messageContentBytes = null;
        this.messageContentObject = null;
        computeContentLength(messageContent);
        addTaint(type.getTaint());
        addTaint(subType.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.803 -0400", hash_original_method = "F6727728B1118BFFD3FCC04534FCE621", hash_generated_method = "ABCBE7C0F118C12CBAD6D5858BBBB712")
    public void setContent(Object content, ContentTypeHeader contentTypeHeader) throws ParseException {
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
        this.messageContentObject = content;
        computeContentLength(content);
        addTaint(contentTypeHeader.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.804 -0400", hash_original_method = "54FC52177A1CB92C02565C30A4F8CE94", hash_generated_method = "0ADC80CCC90C95A3218BA6618E9755B4")
    public Object getContent() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1555614492 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1563236276 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_603678704 = null; //Variable for return #3
        Object varB4EAC82CA7396A68D541C85D26508E83_1755994458 = null; //Variable for return #4
        varB4EAC82CA7396A68D541C85D26508E83_1555614492 = messageContentObject;
        varB4EAC82CA7396A68D541C85D26508E83_1563236276 = this.messageContent;
        varB4EAC82CA7396A68D541C85D26508E83_603678704 = this.messageContentBytes;
        varB4EAC82CA7396A68D541C85D26508E83_1755994458 = null;
        Object varA7E53CE21691AB073D9660D615818899_1118972404; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1118972404 = varB4EAC82CA7396A68D541C85D26508E83_1555614492;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1118972404 = varB4EAC82CA7396A68D541C85D26508E83_1563236276;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1118972404 = varB4EAC82CA7396A68D541C85D26508E83_603678704;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1118972404 = varB4EAC82CA7396A68D541C85D26508E83_1755994458;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1118972404.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1118972404;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.804 -0400", hash_original_method = "567464035ABE474ACDCFF614F9D534B5", hash_generated_method = "192CE7C31B0E17C2398FDD2D0C5BD23E")
    public void setMessageContent(String type, String subType, byte[] messageContent) {
        ContentType ct;
        ct = new ContentType(type, subType);
        this.setHeader(ct);
        this.setMessageContent(messageContent);
        computeContentLength(messageContent);
        addTaint(type.getTaint());
        addTaint(subType.getTaint());
        addTaint(messageContent[0]);
        // ---------- Original Method ----------
        //ContentType ct = new ContentType(type, subType);
        //this.setHeader(ct);
        //this.setMessageContent(messageContent);
        //computeContentLength(messageContent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.808 -0400", hash_original_method = "39F2BE1EDB04320A3B64ACD0EA831DED", hash_generated_method = "8A95F2264FDFA9E5A1EAF2CDF2BD1F90")
    public void setMessageContent(String content, boolean strict, boolean computeContentLength, int givenLength) throws ParseException {
        computeContentLength(content);
        {
            {
                boolean var7F2E7916F611D748ECF2BCAD4DD266ED_1116665351 = ((!strict && this.contentLengthHeader.getContentLength() != givenLength) 
                    || this.contentLengthHeader.getContentLength() < givenLength);
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException("Invalid content length "
                        + this.contentLengthHeader.getContentLength() + " / " + givenLength, 0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        messageContent = content;
        messageContentBytes = null;
        messageContentObject = null;
        addTaint(strict);
        addTaint(computeContentLength);
        addTaint(givenLength);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.811 -0400", hash_original_method = "19C7E154661732280AD152F3E186944D", hash_generated_method = "FE4B2F2B2435BA47A415DC55253399E0")
    public void setMessageContent(byte[] content) {
        computeContentLength(content);
        messageContentBytes = content;
        messageContent = null;
        messageContentObject = null;
        // ---------- Original Method ----------
        //computeContentLength(content);
        //messageContentBytes = content;
        //messageContent = null;
        //messageContentObject = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.812 -0400", hash_original_method = "677A53CE4E6B4035F9B12FCECD3E865E", hash_generated_method = "E38A81BBD73F91DFE45F5F82A4752781")
    public void setMessageContent(byte[] content, boolean computeContentLength, int givenLength) throws ParseException {
        computeContentLength(content);
        {
            boolean var53E9258046341087EA338AE330779B8F_1136312913 = ((!computeContentLength) && this.contentLengthHeader.getContentLength() < givenLength);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Invalid content length "
                    + this.contentLengthHeader.getContentLength() + " / " + givenLength, 0);
            } //End block
        } //End collapsed parenthetic
        messageContentBytes = content;
        messageContent = null;
        messageContentObject = null;
        addTaint(computeContentLength);
        addTaint(givenLength);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.813 -0400", hash_original_method = "D3327D918F93ECC2995A4C67A415A1A5", hash_generated_method = "2B5D747060AF0F624BCF432147E14A0A")
    private void computeContentLength(Object content) {
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
        addTaint(content.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.814 -0400", hash_original_method = "B09AA5FB20D2965ADCD41D53860CDBE3", hash_generated_method = "EC9C60094C43878E3E0EBD84910DA36F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.815 -0400", hash_original_method = "B51D33B6E886062DB169564C9DA9DCD8", hash_generated_method = "2A937D18CA9F47877E8CC885081A4118")
    @SuppressWarnings("unchecked")
    public ListIterator<SIPHeader> getHeaders(String headerName) {
        ListIterator<SIPHeader> varB4EAC82CA7396A68D541C85D26508E83_448445048 = null; //Variable for return #1
        ListIterator<SIPHeader> varB4EAC82CA7396A68D541C85D26508E83_1443218235 = null; //Variable for return #2
        ListIterator<SIPHeader> varB4EAC82CA7396A68D541C85D26508E83_378329313 = null; //Variable for return #3
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null headerName");
        SIPHeader sipHeader;
        sipHeader = (SIPHeader) nameTable.get(SIPHeaderNamesCache
                .toLowerCase(headerName));
        varB4EAC82CA7396A68D541C85D26508E83_448445048 = new LinkedList<SIPHeader>().listIterator();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1443218235 = ((SIPHeaderList<SIPHeader>) sipHeader).listIterator();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_378329313 = new HeaderIterator(this, sipHeader);
        } //End block
        addTaint(headerName.getTaint());
        ListIterator<SIPHeader> varA7E53CE21691AB073D9660D615818899_2013342976; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2013342976 = varB4EAC82CA7396A68D541C85D26508E83_448445048;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2013342976 = varB4EAC82CA7396A68D541C85D26508E83_1443218235;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2013342976 = varB4EAC82CA7396A68D541C85D26508E83_378329313;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2013342976.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2013342976;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.826 -0400", hash_original_method = "6CE50AA271DA9876F1700D8E280EAFD1", hash_generated_method = "BBFA92F5A48C6F9767A5C45889040C85")
    public String getHeaderAsFormattedString(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_607172529 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_539140035 = null; //Variable for return #2
        String lowerCaseName;
        lowerCaseName = name.toLowerCase();
        {
            boolean varC2A08EC06B69AD4EEFB5CF0E06463703_496957346 = (this.nameTable.containsKey(lowerCaseName));
            {
                varB4EAC82CA7396A68D541C85D26508E83_607172529 = this.nameTable.get(lowerCaseName).toString();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_539140035 = this.getHeader(name).toString();
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1493611613; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1493611613 = varB4EAC82CA7396A68D541C85D26508E83_607172529;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1493611613 = varB4EAC82CA7396A68D541C85D26508E83_539140035;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1493611613.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1493611613;
        // ---------- Original Method ----------
        //String lowerCaseName = name.toLowerCase();
        //if (this.nameTable.containsKey(lowerCaseName)) {
            //return this.nameTable.get(lowerCaseName).toString();
        //} else {
            //return this.getHeader(name).toString();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.827 -0400", hash_original_method = "2723C6F27F309BF6F386C5DF25AB6032", hash_generated_method = "27B148CFC313D81E196AD88249D2FBE6")
    private SIPHeader getSIPHeaderListLowerCase(String lowerCaseHeaderName) {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1222850346 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1222850346 = nameTable.get(lowerCaseHeaderName);
        addTaint(lowerCaseHeaderName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1222850346.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1222850346;
        // ---------- Original Method ----------
        //return nameTable.get(lowerCaseHeaderName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.828 -0400", hash_original_method = "9F4B7A8AFA1B725FEEE6FA6CFA2755DF", hash_generated_method = "19552FE721736A6D3C3EDD5CDB2DAD5A")
    @SuppressWarnings("unchecked")
    private List<SIPHeader> getHeaderList(String headerName) {
        List<SIPHeader> varB4EAC82CA7396A68D541C85D26508E83_81694956 = null; //Variable for return #1
        List<SIPHeader> varB4EAC82CA7396A68D541C85D26508E83_1217369849 = null; //Variable for return #2
        List<SIPHeader> varB4EAC82CA7396A68D541C85D26508E83_1949641126 = null; //Variable for return #3
        SIPHeader sipHeader;
        sipHeader = (SIPHeader) nameTable.get(SIPHeaderNamesCache
                .toLowerCase(headerName));
        varB4EAC82CA7396A68D541C85D26508E83_81694956 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1217369849 = (List<SIPHeader>) (((SIPHeaderList< ? >) sipHeader).getHeaderList());
        {
            LinkedList<SIPHeader> ll;
            ll = new LinkedList<SIPHeader>();
            ll.add(sipHeader);
            varB4EAC82CA7396A68D541C85D26508E83_1949641126 = ll;
        } //End block
        addTaint(headerName.getTaint());
        List<SIPHeader> varA7E53CE21691AB073D9660D615818899_672165570; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_672165570 = varB4EAC82CA7396A68D541C85D26508E83_81694956;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_672165570 = varB4EAC82CA7396A68D541C85D26508E83_1217369849;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_672165570 = varB4EAC82CA7396A68D541C85D26508E83_1949641126;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_672165570.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_672165570;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.828 -0400", hash_original_method = "6DBF8105DE4FD1DC6BA28CCFFFEEC680", hash_generated_method = "68C41E5F557DA1C8ADAAE09A57ED9735")
    public boolean hasHeader(String headerName) {
        boolean var8F92FAB8130AFDAD062FD4FCF8454941_1839012302 = (nameTable.containsKey(SIPHeaderNamesCache.toLowerCase(headerName)));
        addTaint(headerName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_517161951 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_517161951;
        // ---------- Original Method ----------
        //return nameTable.containsKey(SIPHeaderNamesCache.toLowerCase(headerName));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.831 -0400", hash_original_method = "4231E4F79F4F1EB89656879CE689B66E", hash_generated_method = "E7C6FA50A53E9A266B561C94DE663F91")
    public boolean hasFromTag() {
        boolean var0911B64052451985C6CF9283DDE5ABCA_113524918 = (fromHeader != null && fromHeader.getTag() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_519770169 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_519770169;
        // ---------- Original Method ----------
        //return fromHeader != null && fromHeader.getTag() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.831 -0400", hash_original_method = "62BEDD072F48BB9AA18DBB87956D8F3D", hash_generated_method = "F289FE6B5B55BECDA59DCDFC126C7901")
    public boolean hasToTag() {
        boolean varD9AA5806DF483D6615D6AF7918F3DCC2_1687264569 = (toHeader != null && toHeader.getTag() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_747551998 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_747551998;
        // ---------- Original Method ----------
        //return toHeader != null && toHeader.getTag() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.831 -0400", hash_original_method = "5C72A9C802C6EC574622DB27171F7A2E", hash_generated_method = "23196A9768846113284F13E9C0A2BB95")
    public String getFromTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_276661922 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_276661922 = fromHeader == null ? null : fromHeader.getTag();
        varB4EAC82CA7396A68D541C85D26508E83_276661922.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_276661922;
        // ---------- Original Method ----------
        //return fromHeader == null ? null : fromHeader.getTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.832 -0400", hash_original_method = "2974ECBC3FF627B3CB2268B4D90C9E07", hash_generated_method = "382BC4877621725C2DA497EEB1546B6B")
    public void setFromTag(String tag) {
        try 
        {
            fromHeader.setTag(tag);
        } //End block
        catch (ParseException e)
        { }
        addTaint(tag.getTaint());
        // ---------- Original Method ----------
        //try {
            //fromHeader.setTag(tag);
        //} catch (ParseException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.833 -0400", hash_original_method = "7DFC8A6205B3CBC36E5183721A30EB01", hash_generated_method = "4417ED4E158BB7A1C22A138733D5DA53")
    public void setToTag(String tag) {
        try 
        {
            toHeader.setTag(tag);
        } //End block
        catch (ParseException e)
        { }
        addTaint(tag.getTaint());
        // ---------- Original Method ----------
        //try {
            //toHeader.setTag(tag);
        //} catch (ParseException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.834 -0400", hash_original_method = "5B9C84C201385B92B0E684584F1ECF7E", hash_generated_method = "80CB866132EC7B3A4692F76C476AC673")
    public String getToTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1661642255 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1661642255 = toHeader == null ? null : toHeader.getTag();
        varB4EAC82CA7396A68D541C85D26508E83_1661642255.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1661642255;
        // ---------- Original Method ----------
        //return toHeader == null ? null : toHeader.getTag();
    }

    
    public abstract String getFirstLine();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.842 -0400", hash_original_method = "34A83ACBA422BB4E8AD74511B9BCE335", hash_generated_method = "36EBECAA2F71F186AE0CA22C9536C921")
    public void addHeader(Header sipHeader) {
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
        addTaint(sipHeader.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.844 -0400", hash_original_method = "8AEC9EB78EF51FE3B48C263748A725D0", hash_generated_method = "DEA0E19CDDDD5158D2B32F93CBF87B4A")
    public void addUnparsed(String unparsed) {
        this.unrecognizedHeaders.add(unparsed);
        addTaint(unparsed.getTaint());
        // ---------- Original Method ----------
        //this.unrecognizedHeaders.add(unparsed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.845 -0400", hash_original_method = "8ACC7204C4B122EB788CE6764EA1EA77", hash_generated_method = "B98160B2126575919C2266D27C5A3BBB")
    public void addHeader(String sipHeader) {
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
        addTaint(sipHeader.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.848 -0400", hash_original_method = "F4B3A65BCC1C141571353972EC488146", hash_generated_method = "1A4CFDA095B31E22101C3BA22D431A59")
    public ListIterator<String> getUnrecognizedHeaders() {
        ListIterator<String> varB4EAC82CA7396A68D541C85D26508E83_1826616064 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1826616064 = this.unrecognizedHeaders.listIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1826616064.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1826616064;
        // ---------- Original Method ----------
        //return this.unrecognizedHeaders.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.857 -0400", hash_original_method = "C08D5FBD41C305191A05DA7EC6E8BA34", hash_generated_method = "4950130E5A79076A61D3E6123B039C97")
    public ListIterator<String> getHeaderNames() {
        ListIterator<String> varB4EAC82CA7396A68D541C85D26508E83_1761686595 = null; //Variable for return #1
        Iterator<SIPHeader> li;
        li = this.headers.iterator();
        LinkedList<String> retval;
        retval = new LinkedList<String>();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_461682523 = (li.hasNext());
            {
                SIPHeader sipHeader;
                sipHeader = (SIPHeader) li.next();
                String name;
                name = sipHeader.getName();
                retval.add(name);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1761686595 = retval.listIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1761686595.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1761686595;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.857 -0400", hash_original_method = "19862554CF2CF162312B89332E1831C0", hash_generated_method = "96E51C66D87C4412978A0A626657C183")
    public boolean equals(Object other) {
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_1527151044 = (!other.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        SIPMessage otherMessage;
        otherMessage = (SIPMessage) other;
        Collection<SIPHeader> values;
        values = this.nameTable.values();
        Iterator<SIPHeader> it;
        it = values.iterator();
        {
            boolean varEA188AE5A9018452EA1222E9093CB12B_48184617 = (nameTable.size() != otherMessage.nameTable.size());
        } //End collapsed parenthetic
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1392541602 = (it.hasNext());
            {
                SIPHeader mine;
                mine = (SIPHeader) it.next();
                SIPHeader his;
                his = (SIPHeader) (otherMessage.nameTable.get(SIPHeaderNamesCache
                    .toLowerCase(mine.getName())));
                {
                    boolean var3911B8F0C4C9004033662F49D485738C_1585302132 = (!his.equals(mine));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_24539633 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_24539633;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.859 -0400", hash_original_method = "3C4825ADE695C84AAF8B57CDEA1CF4CB", hash_generated_method = "A8B39B7EBD65E3272C4CCE47A35C2BD5")
    public javax.sip.header.ContentDispositionHeader getContentDisposition() {
        javax.sip.header.ContentDispositionHeader varB4EAC82CA7396A68D541C85D26508E83_1917374607 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1917374607 = (ContentDispositionHeader) getHeaderLowerCase(CONTENT_DISPOSITION_LOWERCASE);
        varB4EAC82CA7396A68D541C85D26508E83_1917374607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1917374607;
        // ---------- Original Method ----------
        //return (ContentDispositionHeader) getHeaderLowerCase(CONTENT_DISPOSITION_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.860 -0400", hash_original_method = "46C03ED253FA9F93BF664C06918E9287", hash_generated_method = "D5055319E9878BFFB480FA3A7607C38E")
    public javax.sip.header.ContentEncodingHeader getContentEncoding() {
        javax.sip.header.ContentEncodingHeader varB4EAC82CA7396A68D541C85D26508E83_391035412 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_391035412 = (ContentEncodingHeader) getHeaderLowerCase(CONTENT_ENCODING_LOWERCASE);
        varB4EAC82CA7396A68D541C85D26508E83_391035412.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_391035412;
        // ---------- Original Method ----------
        //return (ContentEncodingHeader) getHeaderLowerCase(CONTENT_ENCODING_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.861 -0400", hash_original_method = "7F8FF7046ECB01AA1B56D3558C9342AE", hash_generated_method = "2E26658F4FF1828335E2BDA6B9E01B61")
    public javax.sip.header.ContentLanguageHeader getContentLanguage() {
        javax.sip.header.ContentLanguageHeader varB4EAC82CA7396A68D541C85D26508E83_1731189852 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1731189852 = (ContentLanguageHeader) getHeaderLowerCase(CONTENT_LANGUAGE_LOWERCASE);
        varB4EAC82CA7396A68D541C85D26508E83_1731189852.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1731189852;
        // ---------- Original Method ----------
        //return (ContentLanguageHeader) getHeaderLowerCase(CONTENT_LANGUAGE_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.866 -0400", hash_original_method = "9AC8AD6CCC74995A67CEDA1778D18415", hash_generated_method = "23E3E216FF009AB475464F04180B2D08")
    public javax.sip.header.ExpiresHeader getExpires() {
        javax.sip.header.ExpiresHeader varB4EAC82CA7396A68D541C85D26508E83_1186413193 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1186413193 = (ExpiresHeader) getHeaderLowerCase(EXPIRES_LOWERCASE);
        varB4EAC82CA7396A68D541C85D26508E83_1186413193.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1186413193;
        // ---------- Original Method ----------
        //return (ExpiresHeader) getHeaderLowerCase(EXPIRES_LOWERCASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.867 -0400", hash_original_method = "729B7ABDA713D8DD91F71F3C7E5D92DE", hash_generated_method = "94E069E2EB0360CBF333D21DF7ABFFDA")
    public void setExpires(ExpiresHeader expiresHeader) {
        this.setHeader(expiresHeader);
        addTaint(expiresHeader.getTaint());
        // ---------- Original Method ----------
        //this.setHeader(expiresHeader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.867 -0400", hash_original_method = "9820BC2E150668B0FD803FA9E719FCCB", hash_generated_method = "B2E7602D273568777C5927D56E478925")
    public void setContentDisposition(ContentDispositionHeader contentDispositionHeader) {
        this.setHeader(contentDispositionHeader);
        addTaint(contentDispositionHeader.getTaint());
        // ---------- Original Method ----------
        //this.setHeader(contentDispositionHeader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.867 -0400", hash_original_method = "664B5D910990D19402FB830D30BD43E8", hash_generated_method = "905EE132837454DB2AD93EF4693EF1CD")
    public void setContentEncoding(ContentEncodingHeader contentEncodingHeader) {
        this.setHeader(contentEncodingHeader);
        addTaint(contentEncodingHeader.getTaint());
        // ---------- Original Method ----------
        //this.setHeader(contentEncodingHeader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.868 -0400", hash_original_method = "F5B59DEA81E2E529FE4037C765469E44", hash_generated_method = "E555A9AF374818536A532DA9B3FA2107")
    public void setContentLanguage(ContentLanguageHeader contentLanguageHeader) {
        this.setHeader(contentLanguageHeader);
        addTaint(contentLanguageHeader.getTaint());
        // ---------- Original Method ----------
        //this.setHeader(contentLanguageHeader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.869 -0400", hash_original_method = "5BC3E664403E9FC36E24FA33AD51CF36", hash_generated_method = "CE391EFE0A7DDF04A48FCCC05B6FB971")
    public void setContentLength(ContentLengthHeader contentLength) {
        try 
        {
            this.contentLengthHeader.setContentLength(contentLength.getContentLength());
        } //End block
        catch (InvalidArgumentException ex)
        { }
        addTaint(contentLength.getTaint());
        // ---------- Original Method ----------
        //try {
            //this.contentLengthHeader.setContentLength(contentLength.getContentLength());
        //} catch (InvalidArgumentException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.881 -0400", hash_original_method = "B722E58F0DD8E1CBC622964AAF1F9B26", hash_generated_method = "2BDE89A0FF22729ECAFC892EB96A087D")
    public void setSize(int size) {
        this.size = size;
        // ---------- Original Method ----------
        //this.size = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.882 -0400", hash_original_method = "54E84843E0EEE275508F3EB8305B3F4F", hash_generated_method = "8EC90B071C898E42A7BE02519BFC5A3D")
    public int getSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_943706718 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_943706718;
        // ---------- Original Method ----------
        //return this.size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.882 -0400", hash_original_method = "51B72F61F828A2C6A4124D3A8929AD68", hash_generated_method = "65D6A0B55D71F54F626FFB0F1225ACBF")
    public void addLast(Header header) throws SipException, NullPointerException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg!");
        try 
        {
            this.attachHeader((SIPHeader) header, false, false);
        } //End block
        catch (SIPDuplicateHeaderException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot add header - header already exists");
        } //End block
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //if (header == null)
            //throw new NullPointerException("null arg!");
        //try {
            //this.attachHeader((SIPHeader) header, false, false);
        //} catch (SIPDuplicateHeaderException ex) {
            //throw new SipException("Cannot add header - header already exists");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.883 -0400", hash_original_method = "FB58DD3E1F3A0D99159750C09E15B568", hash_generated_method = "7CEBCA8C6BD42BA5CC640DABD0B4D334")
    public void addFirst(Header header) throws SipException, NullPointerException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg!");
        try 
        {
            this.attachHeader((SIPHeader) header, false, true);
        } //End block
        catch (SIPDuplicateHeaderException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot add header - header already exists");
        } //End block
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //if (header == null)
            //throw new NullPointerException("null arg!");
        //try {
            //this.attachHeader((SIPHeader) header, false, true);
        //} catch (SIPDuplicateHeaderException ex) {
            //throw new SipException("Cannot add header - header already exists");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.883 -0400", hash_original_method = "F7D2F7162E4B2A1EDD2D78AF07F98ED3", hash_generated_method = "6798C97874DC7872F91387272829C9D6")
    public void removeFirst(String headerName) throws NullPointerException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null argument Provided!");
        this.removeHeader(headerName, true);
        addTaint(headerName.getTaint());
        // ---------- Original Method ----------
        //if (headerName == null)
            //throw new NullPointerException("Null argument Provided!");
        //this.removeHeader(headerName, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.883 -0400", hash_original_method = "B1A0AEB4CA388E0A9ED7E42FB6DA96D3", hash_generated_method = "BBD5B9CBE93C6962DBAB77BA763F4862")
    public void removeLast(String headerName) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null argument Provided!");
        this.removeHeader(headerName, false);
        addTaint(headerName.getTaint());
        // ---------- Original Method ----------
        //if (headerName == null)
            //throw new NullPointerException("Null argument Provided!");
        //this.removeHeader(headerName, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.884 -0400", hash_original_method = "1B0E35DCABA77A6424B3D6172B19A4B7", hash_generated_method = "FE547DB1F0CA5E958E466C839E26E083")
    public void setCSeq(CSeqHeader cseqHeader) {
        this.setHeader(cseqHeader);
        addTaint(cseqHeader.getTaint());
        // ---------- Original Method ----------
        //this.setHeader(cseqHeader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.884 -0400", hash_original_method = "552E0456C33D24CD63C8EBCDAC1D019B", hash_generated_method = "E17DD994BC845C3BDBBD70ECC432242E")
    public void setApplicationData(Object applicationData) {
        this.applicationData = applicationData;
        // ---------- Original Method ----------
        //this.applicationData = applicationData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.887 -0400", hash_original_method = "5F924FC61375970A4DC758380BEBFF0F", hash_generated_method = "AE41F3B602ECE681A875BAB548B28E07")
    public Object getApplicationData() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1246302535 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1246302535 = this.applicationData;
        varB4EAC82CA7396A68D541C85D26508E83_1246302535.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1246302535;
        // ---------- Original Method ----------
        //return this.applicationData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.894 -0400", hash_original_method = "3FB4581572217B4D34EC8E3A9F62CA88", hash_generated_method = "5E3C328306E74A95C0320926AC31B0BF")
    public MultipartMimeContent getMultipartMimeContent() throws ParseException {
        MultipartMimeContent varB4EAC82CA7396A68D541C85D26508E83_84350268 = null; //Variable for return #1
        MultipartMimeContent varB4EAC82CA7396A68D541C85D26508E83_196015778 = null; //Variable for return #2
        MultipartMimeContent varB4EAC82CA7396A68D541C85D26508E83_1797671991 = null; //Variable for return #3
        {
            boolean var2CC093753E0ADFD0794491E557D23CC9_1619375395 = (this.contentLengthHeader.getContentLength() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_84350268 = null;
            } //End block
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
            varB4EAC82CA7396A68D541C85D26508E83_196015778 = retval;
        } //End block
        catch (UnsupportedEncodingException e)
        {
            InternalErrorHandler.handleException(e);
            varB4EAC82CA7396A68D541C85D26508E83_1797671991 = null;
        } //End block
        MultipartMimeContent varA7E53CE21691AB073D9660D615818899_407005462; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_407005462 = varB4EAC82CA7396A68D541C85D26508E83_84350268;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_407005462 = varB4EAC82CA7396A68D541C85D26508E83_196015778;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_407005462 = varB4EAC82CA7396A68D541C85D26508E83_1797671991;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_407005462.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_407005462;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.904 -0400", hash_original_method = "6A8980AC46BDEC47E118DEA889F580E2", hash_generated_method = "FC0EF7F260D42169C9C8286188F595DD")
    public CallIdHeader getCallIdHeader() {
        CallIdHeader varB4EAC82CA7396A68D541C85D26508E83_281708866 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_281708866 = this.callIdHeader;
        varB4EAC82CA7396A68D541C85D26508E83_281708866.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_281708866;
        // ---------- Original Method ----------
        //return this.callIdHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.905 -0400", hash_original_method = "616E19996CDDFB660618161B80D5BB27", hash_generated_method = "AD2A3B89333AA152C8684CAE3D5A7C66")
    public FromHeader getFromHeader() {
        FromHeader varB4EAC82CA7396A68D541C85D26508E83_1442731155 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1442731155 = this.fromHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1442731155.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1442731155;
        // ---------- Original Method ----------
        //return this.fromHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.905 -0400", hash_original_method = "9C43D5663CBD78C15545690BFB01C4BF", hash_generated_method = "E5612BB7BED5C125BA16EE2772EA3AD1")
    public ToHeader getToHeader() {
        ToHeader varB4EAC82CA7396A68D541C85D26508E83_1857052027 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1857052027 = this.toHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1857052027.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1857052027;
        // ---------- Original Method ----------
        //return this.toHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.906 -0400", hash_original_method = "FE98900B9C779953579B6764E7283FC2", hash_generated_method = "3A05533CF2A2E24B6D84DBE43CAC2417")
    public ViaHeader getTopmostViaHeader() {
        ViaHeader varB4EAC82CA7396A68D541C85D26508E83_2066078627 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2066078627 = this.getTopmostVia();
        varB4EAC82CA7396A68D541C85D26508E83_2066078627.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2066078627;
        // ---------- Original Method ----------
        //return this.getTopmostVia();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.906 -0400", hash_original_method = "2CE1B7EDE28DB048E923E7FFD28A72BE", hash_generated_method = "98A38BA6AE10EFBAC4AAAEEE5D2F4022")
    public CSeqHeader getCSeqHeader() {
        CSeqHeader varB4EAC82CA7396A68D541C85D26508E83_517286765 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_517286765 = this.cSeqHeader;
        varB4EAC82CA7396A68D541C85D26508E83_517286765.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_517286765;
        // ---------- Original Method ----------
        //return this.cSeqHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.917 -0400", hash_original_method = "5D0D1F0E94EB86910B32FB17BCD97869", hash_generated_method = "051EFDB3E84836185DE84D01C5FB004C")
    protected final String getCharset() {
        String varB4EAC82CA7396A68D541C85D26508E83_1703243630 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1696740474 = null; //Variable for return #2
        ContentType ct;
        ct = getContentTypeHeader();
        {
            String c;
            c = ct.getCharset();
            varB4EAC82CA7396A68D541C85D26508E83_1703243630 = c!=null ? c : contentEncodingCharset;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1696740474 = contentEncodingCharset;
        String varA7E53CE21691AB073D9660D615818899_907398184; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_907398184 = varB4EAC82CA7396A68D541C85D26508E83_1703243630;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_907398184 = varB4EAC82CA7396A68D541C85D26508E83_1696740474;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_907398184.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_907398184;
        // ---------- Original Method ----------
        //ContentType ct = getContentTypeHeader();
        //if (ct!=null) {
    		//String c = ct.getCharset();
    		//return c!=null ? c : contentEncodingCharset;
    	//} else return contentEncodingCharset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.918 -0400", hash_original_method = "F8575631397F30A77B6575B01C9E50F5", hash_generated_method = "C6EC474C99A14CE2591236A3B9F8E570")
    public boolean isNullRequest() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2031677690 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2031677690;
        // ---------- Original Method ----------
        //return  this.nullRequest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.919 -0400", hash_original_method = "76987385F34084CF4A8C6AA1CD858E63", hash_generated_method = "9270889C04904F8C78507597689FCBFB")
    public void setNullRequest() {
        this.nullRequest = true;
        // ---------- Original Method ----------
        //this.nullRequest = true;
    }

    
    public abstract void setSIPVersion(String sipVersion) throws ParseException;

    
    public abstract String getSIPVersion();

    
    public abstract String toString();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.922 -0400", hash_original_field = "75E2CD6B096F7C9EA9F441F09C141816", hash_generated_field = "068D223E1748F06573357D6E0C93718F")

    private static String CONTENT_TYPE_LOWERCASE = SIPHeaderNamesCache
    .toLowerCase(ContentTypeHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.922 -0400", hash_original_field = "29DF28A4B352F1941ADD2F1574849F4C", hash_generated_field = "CB3AF27778792F966750AACA6A38F463")

    private static String ERROR_LOWERCASE = SIPHeaderNamesCache.toLowerCase(ErrorInfo.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.923 -0400", hash_original_field = "1BA2C1C4DCDE1F624162F4131AAE2119", hash_generated_field = "590BE103DF5E29902DC51A34B94DF180")

    private static String CONTACT_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ContactHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.923 -0400", hash_original_field = "48FC9BF18DDD312165B5D66B273DFFB9", hash_generated_field = "4BC3CDA715084CA31B0ADE6B2173B634")

    private static String VIA_LOWERCASE = SIPHeaderNamesCache.toLowerCase(ViaHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.923 -0400", hash_original_field = "7412D18F37312CBCB0F4A06C575DDCDC", hash_generated_field = "1B421A7E66A645377F0CDBFA175E598E")

    private static String AUTHORIZATION_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(AuthorizationHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.923 -0400", hash_original_field = "189EC181787A87BAA9A37498164BF033", hash_generated_field = "7DBB14FF48CF74D0DE3A5CA709382258")

    private static String ROUTE_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(RouteHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.923 -0400", hash_original_field = "9C1ABF37105D0FE67D77A0E330DBA041", hash_generated_field = "5CBC5FBDD576A95665BBB5154509E377")

    private static String RECORDROUTE_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(RecordRouteHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.923 -0400", hash_original_field = "684B374F6D97A99BC68D07DD28F9F302", hash_generated_field = "A671CFA4DAEEF27CB28B29359EB48594")

    private static String CONTENT_DISPOSITION_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ContentDispositionHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.923 -0400", hash_original_field = "E2D2A30A5E5BCE2B69AEF1546064737F", hash_generated_field = "3E50C78FA482AC0229816B5CCAA59214")

    private static String CONTENT_ENCODING_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ContentEncodingHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.923 -0400", hash_original_field = "2871455B28BED5523B66335711F93B13", hash_generated_field = "5AD8BE2469CBED0F46AB241AF331532B")

    private static String CONTENT_LANGUAGE_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ContentLanguageHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.923 -0400", hash_original_field = "DC12CEF71CECD7CA0E5991B99573EE4A", hash_generated_field = "085B7037647C056863DFFBADB79EF703")

    private static String EXPIRES_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ExpiresHeader.NAME);
}

