package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.155 -0400", hash_original_field = "1E0E36F4EE56089C28BCB9B0F9B200D4", hash_generated_field = "4BA5E6BB1036D79534D4BE3D73466535")

    private String contentEncodingCharset = MessageFactoryImpl.getDefaultContentEncodingCharset();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.155 -0400", hash_original_field = "56B43B060CEE73356D58D497BA1C84EF", hash_generated_field = "3D632899724829D8B5950E7FD03861B1")

    protected boolean nullRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.155 -0400", hash_original_field = "8068711CC630B2B1E236623A9F225BDE", hash_generated_field = "E835C2C2C7A6613C6BF5AAA84C167353")

    protected LinkedList<String> unrecognizedHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.155 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "247E0138E51DEE8295CE7FD03B5C7C7F")

    protected ConcurrentLinkedQueue<SIPHeader> headers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.155 -0400", hash_original_field = "AC7113BAC9CAF3E84139BDAB33B013CD", hash_generated_field = "41941E45293112AC36DC5E7BE4DFF5AE")

    protected From fromHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.155 -0400", hash_original_field = "B779FC79043D8E24F2CB866B1B31BF4F", hash_generated_field = "386FEF496B2D00FF2AEEA4F647EAA2EC")

    protected To toHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.155 -0400", hash_original_field = "1124446E2524DA4D31B54C124ED3B1EA", hash_generated_field = "9243D81B8C37269C34D9BD3D6292835A")

    protected CSeq cSeqHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.155 -0400", hash_original_field = "F4E470CD8970EBBE1902E50EB09F4952", hash_generated_field = "471E372FA6B60996CC5D5DA482544660")

    protected CallID callIdHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.155 -0400", hash_original_field = "D7AC18F96FF3D69F56F179B05471A942", hash_generated_field = "BD2FD117E706370D42DF61B188BF8940")

    protected ContentLength contentLengthHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.155 -0400", hash_original_field = "237F1BDE377EF84E632D622E7809F04B", hash_generated_field = "19F23DC4282A0EF2D6622C8B0C1149E7")

    protected MaxForwards maxForwardsHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.155 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "BEC7808019D8AD57BF06A5469459FF0A")

    protected int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.155 -0400", hash_original_field = "2ECFA4ADA27CE6869BB8F49F338F1D05", hash_generated_field = "BDA818F16CAD309D41556EC35AB6E563")

    private String messageContent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.155 -0400", hash_original_field = "F39EF8B0045FE162F4D1F6DFC1649F07", hash_generated_field = "3E3D2657E47D4DE2C783823CF246BBAB")

    private byte[] messageContentBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.155 -0400", hash_original_field = "BDA0AA4A25131E44F152C2811CF23974", hash_generated_field = "1560325BE0E32978EBE2ECDE71A6C345")

    private Object messageContentObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.155 -0400", hash_original_field = "4BEA1CEB6A7BE38EA2C72D63BB1811A8", hash_generated_field = "1C03D389CB46F0B01812A6FDFBD5DD7D")

    private Hashtable<String, SIPHeader> nameTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.156 -0400", hash_original_field = "756C73A51ADF7F04942C8BE97A032000", hash_generated_field = "89FDF1CBFFC083F61390A7888D3F82DE")

    protected Object applicationData;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.156 -0400", hash_original_method = "7EF8FE4247F4A54A74550FF503F5DF85", hash_generated_method = "68D380DBA20A2D78EF34207CFD9F99DB")
    public  SIPMessage() {
        this.unrecognizedHeaders = new LinkedList<String>();
        this.headers = new ConcurrentLinkedQueue<SIPHeader>();
        nameTable = new Hashtable<String, SIPHeader>();
        try 
        {
            this.attachHeader(new ContentLength(0), false);
        } //End block
        catch (Exception ex)
        {
        } //End block
        // ---------- Original Method ----------
        //this.unrecognizedHeaders = new LinkedList<String>();
        //this.headers = new ConcurrentLinkedQueue<SIPHeader>();
        //nameTable = new Hashtable<String, SIPHeader>();
        //try {
            //this.attachHeader(new ContentLength(0), false);
        //} catch (Exception ex) {
        //}
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isRequestHeader(SIPHeader sipHeader) {
        return sipHeader instanceof AlertInfo || sipHeader instanceof InReplyTo
                || sipHeader instanceof Authorization || sipHeader instanceof MaxForwards
                || sipHeader instanceof UserAgent || sipHeader instanceof Priority
                || sipHeader instanceof ProxyAuthorization || sipHeader instanceof ProxyRequire
                || sipHeader instanceof ProxyRequireList || sipHeader instanceof Route
                || sipHeader instanceof RouteList || sipHeader instanceof Subject
                || sipHeader instanceof SIPIfMatch;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isResponseHeader(SIPHeader sipHeader) {
        return sipHeader instanceof ErrorInfo || sipHeader instanceof ProxyAuthenticate
                || sipHeader instanceof Server || sipHeader instanceof Unsupported
                || sipHeader instanceof RetryAfter || sipHeader instanceof Warning
                || sipHeader instanceof WWWAuthenticate || sipHeader instanceof SIPETag
                || sipHeader instanceof RSeq;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.158 -0400", hash_original_method = "4E875487FBA3E9E3C25B636513844812", hash_generated_method = "00830A596D387778CD5FB0C560955538")
    public LinkedList<String> getMessageAsEncodedStrings() {
        LinkedList<String> retval = new LinkedList<String>();
        Iterator<SIPHeader> li = headers.iterator();
        while
(li.hasNext())        
        {
            SIPHeader sipHeader = (SIPHeader) li.next();
            if(sipHeader instanceof SIPHeaderList)            
            {
                SIPHeaderList< ? > shl = (SIPHeaderList< ? >) sipHeader;
                retval.addAll(shl.getHeadersAsEncodedStrings());
            } //End block
            else
            {
                retval.add(sipHeader.encode());
            } //End block
        } //End block
LinkedList<String> varF9E19AD6135C970F387F77C6F3DE4477_515457415 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_515457415.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_515457415;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.158 -0400", hash_original_method = "A27900405272FB61F2D6362A05DA41D6", hash_generated_method = "937D4AB1083EB421687DF7635D61CC4E")
    protected String encodeSIPHeaders() {
        StringBuffer encoding = new StringBuffer();
        Iterator<SIPHeader> it = this.headers.iterator();
        while
(it.hasNext())        
        {
            SIPHeader siphdr = (SIPHeader) it.next();
            if(!(siphdr instanceof ContentLength))            
            siphdr.encode(encoding);
        } //End block
String var2D67BB46AD10FAB14B45E2CB0673323E_1501656117 =         contentLengthHeader.encode(encoding).append(NEWLINE).toString();
        var2D67BB46AD10FAB14B45E2CB0673323E_1501656117.addTaint(taint);
        return var2D67BB46AD10FAB14B45E2CB0673323E_1501656117;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.160 -0400", hash_original_method = "AC5B2D97481875B2502EE3A7FDAB3C5D", hash_generated_method = "0646F46F8F10889899333E1C8EDA6CD8")
    public boolean match(Object other) {
        addTaint(other.getTaint());
        if(other == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1665083653 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2144238937 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2144238937;
        }
        if(!other.getClass().equals(this.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_66162224 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1925974006 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1925974006;
        }
        SIPMessage matchObj = (SIPMessage) other;
        Iterator<SIPHeader> li = matchObj.getHeaders();
        while
(li.hasNext())        
        {
            SIPHeader hisHeaders = (SIPHeader) li.next();
            List<SIPHeader> myHeaders = this.getHeaderList(hisHeaders.getHeaderName());
            if(myHeaders == null || myHeaders.size() == 0)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1441340186 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_212545965 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_212545965;
            }
            if(hisHeaders instanceof SIPHeaderList)            
            {
                ListIterator< ? > outerIterator = ((SIPHeaderList< ? >) hisHeaders)
                        .listIterator();
                while
(outerIterator.hasNext())                
                {
                    SIPHeader hisHeader = (SIPHeader) outerIterator.next();
                    if(hisHeader instanceof ContentLength)                    
                    continue;
                    ListIterator< ? > innerIterator = myHeaders.listIterator();
                    boolean found = false;
                    while
(innerIterator.hasNext())                    
                    {
                        SIPHeader myHeader = (SIPHeader) innerIterator.next();
                        if(myHeader.match(hisHeader))                        
                        {
                            found = true;
                            break;
                        } //End block
                    } //End block
                    if(!found)                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_976332323 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_962964518 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_962964518;
                    }
                } //End block
            } //End block
            else
            {
                SIPHeader hisHeader = hisHeaders;
                ListIterator<SIPHeader> innerIterator = myHeaders.listIterator();
                boolean found = false;
                while
(innerIterator.hasNext())                
                {
                    SIPHeader myHeader = (SIPHeader) innerIterator.next();
                    if(myHeader.match(hisHeader))                    
                    {
                        found = true;
                        break;
                    } //End block
                } //End block
                if(!found)                
                {
                boolean var68934A3E9455FA72420237EB05902327_920172185 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_761184631 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_761184631;
                }
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_403846990 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_237501306 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_237501306;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.161 -0400", hash_original_method = "789EABA7F64EF1819B9EE91356F4E918", hash_generated_method = "992055713D9E049161C6F9DC4515ACBC")
    public void merge(Object template) {
        addTaint(template.getTaint());
        if(!template.getClass().equals(this.getClass()))        
        {
        IllegalArgumentException var1F968F00CDA56D8CD4A19316765D6714_1065642737 = new IllegalArgumentException("Bad class " + template.getClass());
        var1F968F00CDA56D8CD4A19316765D6714_1065642737.addTaint(taint);
        throw var1F968F00CDA56D8CD4A19316765D6714_1065642737;
        }
        SIPMessage templateMessage = (SIPMessage) template;
        Object[] templateHeaders = templateMessage.headers.toArray();
for(int i = 0;i < templateHeaders.length;i++)
        {
            SIPHeader hdr = (SIPHeader) templateHeaders[i];
            String hdrName = hdr.getHeaderName();
            List<SIPHeader> myHdrs = this.getHeaderList(hdrName);
            if(myHdrs == null)            
            {
                this.attachHeader(hdr);
            } //End block
            else
            {
                ListIterator<SIPHeader> it = myHdrs.listIterator();
                while
(it.hasNext())                
                {
                    SIPHeader sipHdr = (SIPHeader) it.next();
                    sipHdr.merge(hdr);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.162 -0400", hash_original_method = "79C45AA8D92059F002F56259D7022AFE", hash_generated_method = "6FF4428456B93CB1BC3BC76CB0087B3C")
    public String encode() {
        StringBuffer encoding = new StringBuffer();
        Iterator<SIPHeader> it = this.headers.iterator();
        while
(it.hasNext())        
        {
            SIPHeader siphdr = (SIPHeader) it.next();
            if(!(siphdr instanceof ContentLength))            
            encoding.append(siphdr.encode());
        } //End block
for(String unrecognized : this.unrecognizedHeaders)
        {
            encoding.append(unrecognized).append(NEWLINE);
        } //End block
        encoding.append(contentLengthHeader.encode()).append(NEWLINE);
        if(this.messageContentObject != null)        
        {
            String mbody = this.getContent().toString();
            encoding.append(mbody);
        } //End block
        else
        if(this.messageContent != null || this.messageContentBytes != null)        
        {
            String content = null;
            try 
            {
                if(messageContent != null)                
                content = messageContent;
                else
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
String varD48A745DC29A29C7851286E6A426D0D0_683262936 =         encoding.toString();
        varD48A745DC29A29C7851286E6A426D0D0_683262936.addTaint(taint);
        return varD48A745DC29A29C7851286E6A426D0D0_683262936;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.163 -0400", hash_original_method = "716A084604DD8483BAA5EE270A2C01EC", hash_generated_method = "1F0DA4A6BA039CD94FF59A56BA97E728")
    public byte[] encodeAsBytes(String transport) {
        addTaint(transport.getTaint());
        if(this instanceof SIPRequest && ((SIPRequest) this).isNullRequest())        
        {
            byte[] varA19D79F1A82AD7BAAC7F871EF0E337AC_707532789 = ("\r\n\r\n".getBytes());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1120326109 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1120326109;
        } //End block
        ViaHeader topVia = (ViaHeader) this.getHeader(ViaHeader.NAME);
        try 
        {
            topVia.setTransport(transport);
        } //End block
        catch (ParseException e)
        {
            InternalErrorHandler.handleException(e);
        } //End block
        StringBuffer encoding = new StringBuffer();
        synchronized
(this.headers)        {
            Iterator<SIPHeader> it = this.headers.iterator();
            while
(it.hasNext())            
            {
                SIPHeader siphdr = (SIPHeader) it.next();
                if(!(siphdr instanceof ContentLength))                
                siphdr.encode(encoding);
            } //End block
        } //End block
        contentLengthHeader.encode(encoding);
        encoding.append(NEWLINE);
        byte[] retval = null;
        byte[] content = this.getRawContent();
        if(content != null)        
        {
            byte[] msgarray = null;
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
        else
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
        byte[] var020B759ADEF679A47CB9AFE965BB2314_1750471607 = (retval);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1933935743 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1933935743;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.165 -0400", hash_original_method = "CAA2D0A800A8BA91CFE25E08D1466992", hash_generated_method = "D81D8487E38ADFBDEEB17ACB2EDDF503")
    public Object clone() {
        SIPMessage retval = (SIPMessage) super.clone();
        retval.nameTable = new Hashtable<String, SIPHeader>();
        retval.fromHeader = null;
        retval.toHeader = null;
        retval.cSeqHeader = null;
        retval.callIdHeader = null;
        retval.contentLengthHeader = null;
        retval.maxForwardsHeader = null;
        if(this.headers != null)        
        {
            retval.headers = new ConcurrentLinkedQueue<SIPHeader>();
for(Iterator<SIPHeader> iter = headers.iterator();iter.hasNext();)
            {
                SIPHeader hdr = (SIPHeader) iter.next();
                retval.attachHeader((SIPHeader) hdr.clone());
            } //End block
        } //End block
        if(this.messageContentBytes != null)        
        retval.messageContentBytes = (byte[]) this.messageContentBytes.clone();
        if(this.messageContentObject != null)        
        retval.messageContentObject = makeClone(messageContentObject);
        retval.unrecognizedHeaders = this.unrecognizedHeaders;
Object varF9E19AD6135C970F387F77C6F3DE4477_419925759 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_419925759.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_419925759;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.166 -0400", hash_original_method = "CE435A19EF4C3C8ADC65C5BBD44452BB", hash_generated_method = "5B69F9830351CDFCF6AB280753FD11A2")
    public String debugDump() {
        stringRepresentation = "";
        sprint("SIPMessage:");
        sprint("{");
        try 
        {
            Field[] fields = this.getClass().getDeclaredFields();
for(int i = 0;i < fields.length;i++)
            {
                Field f = fields[i];
                Class< ? > fieldType = f.getType();
                String fieldName = f.getName();
                if(f.get(this) != null && SIPHeader.class.isAssignableFrom(fieldType)
                        && fieldName.compareTo("headers") != 0)                
                {
                    sprint(fieldName + "=");
                    sprint(((SIPHeader) f.get(this)).debugDump());
                } //End block
            } //End block
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
        if(this.getContent() != null)        
        {
            sprint(this.getContent().toString());
        } //End block
        sprint("}");
String var8D11C2D110975896438D6F91C60E6D6F_180011674 =         stringRepresentation;
        var8D11C2D110975896438D6F91C60E6D6F_180011674.addTaint(taint);
        return var8D11C2D110975896438D6F91C60E6D6F_180011674;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.167 -0400", hash_original_method = "D9E90811A837F48EC447FF925318738A", hash_generated_method = "A8F9FDB2BA0BDD3F289F15A0FF88DC6E")
    private void attachHeader(SIPHeader h) {
        addTaint(h.getTaint());
        if(h == null)        
        {
        IllegalArgumentException var71B67E23ABD34FA8AE7CA598ED76EC98_894284863 = new IllegalArgumentException("null header!");
        var71B67E23ABD34FA8AE7CA598ED76EC98_894284863.addTaint(taint);
        throw var71B67E23ABD34FA8AE7CA598ED76EC98_894284863;
        }
        try 
        {
            if(h instanceof SIPHeaderList)            
            {
                SIPHeaderList< ? > hl = (SIPHeaderList< ? >) h;
                if(hl.isEmpty())                
                {
                    return;
                } //End block
            } //End block
            attachHeader(h, false, false);
        } //End block
        catch (SIPDuplicateHeaderException ex)
        {
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.167 -0400", hash_original_method = "230B17E5A17A83111BEC4A023E8D6F14", hash_generated_method = "9EB27F4AC909139975F716D8D4DE330B")
    public void setHeader(Header sipHeader) {
        addTaint(sipHeader.getTaint());
        SIPHeader header = (SIPHeader) sipHeader;
        if(header == null)        
        {
        IllegalArgumentException var71B67E23ABD34FA8AE7CA598ED76EC98_235299799 = new IllegalArgumentException("null header!");
        var71B67E23ABD34FA8AE7CA598ED76EC98_235299799.addTaint(taint);
        throw var71B67E23ABD34FA8AE7CA598ED76EC98_235299799;
        }
        try 
        {
            if(header instanceof SIPHeaderList)            
            {
                SIPHeaderList< ? > hl = (SIPHeaderList< ? >) header;
                if(hl.isEmpty())                
                return;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.168 -0400", hash_original_method = "DC88726E428D89A7A7082B0D5F94DA0F", hash_generated_method = "AFACD4C2AFD6ECE1B27F26BC3ED3414C")
    public void setHeaders(java.util.List<SIPHeader> headers) {
        addTaint(headers.getTaint());
        ListIterator<SIPHeader> listIterator = headers.listIterator();
        while
(listIterator.hasNext())        
        {
            SIPHeader sipHeader = (SIPHeader) listIterator.next();
            try 
            {
                this.attachHeader(sipHeader, false);
            } //End block
            catch (SIPDuplicateHeaderException ex)
            {
            } //End block
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.168 -0400", hash_original_method = "9B17545BC9FC78AB24684381D78F3E60", hash_generated_method = "854FB2D1DB68B7F1CBAE645D4468DED4")
    public void attachHeader(SIPHeader h, boolean replaceflag) throws SIPDuplicateHeaderException {
        addTaint(replaceflag);
        addTaint(h.getTaint());
        this.attachHeader(h, replaceflag, false);
        // ---------- Original Method ----------
        //this.attachHeader(h, replaceflag, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.170 -0400", hash_original_method = "7BE2AED7224623BF9774680F8F08FE9F", hash_generated_method = "8A2E50DC77F1FA0EBF396B8466E049C7")
    public void attachHeader(SIPHeader header, boolean replaceFlag, boolean top) throws SIPDuplicateHeaderException {
        addTaint(top);
        addTaint(replaceFlag);
        addTaint(header.getTaint());
        if(header == null)        
        {
            NullPointerException var2AC0C65B83BB8A77F0FA298CDD02C890_1556170901 = new NullPointerException("null header");
            var2AC0C65B83BB8A77F0FA298CDD02C890_1556170901.addTaint(taint);
            throw var2AC0C65B83BB8A77F0FA298CDD02C890_1556170901;
        } //End block
        SIPHeader h;
        if(ListMap.hasList(header) && !SIPHeaderList.class.isAssignableFrom(header.getClass()))        
        {
            SIPHeaderList<SIPHeader> hdrList = ListMap.getList(header);
            hdrList.add(header);
            h = hdrList;
        } //End block
        else
        {
            h = header;
        } //End block
        String headerNameLowerCase = SIPHeaderNamesCache.toLowerCase(h.getName());
        if(replaceFlag)        
        {
            nameTable.remove(headerNameLowerCase);
        } //End block
        else
        if(nameTable.containsKey(headerNameLowerCase) && !(h instanceof SIPHeaderList))        
        {
            if(h instanceof ContentLength)            
            {
                try 
                {
                    ContentLength cl = (ContentLength) h;
                    contentLengthHeader.setContentLength(cl.getContentLength());
                } //End block
                catch (InvalidArgumentException e)
                {
                } //End block
            } //End block
            return;
        } //End block
        SIPHeader originalHeader = (SIPHeader) getHeader(header.getName());
        if(originalHeader != null)        
        {
            Iterator<SIPHeader> li = headers.iterator();
            while
(li.hasNext())            
            {
                SIPHeader next = (SIPHeader) li.next();
                if(next.equals(originalHeader))                
                {
                    li.remove();
                } //End block
            } //End block
        } //End block
        if(!nameTable.containsKey(headerNameLowerCase))        
        {
            nameTable.put(headerNameLowerCase, h);
            headers.add(h);
        } //End block
        else
        {
            if(h instanceof SIPHeaderList)            
            {
                SIPHeaderList< ? > hdrlist = (SIPHeaderList< ? >) nameTable
                        .get(headerNameLowerCase);
                if(hdrlist != null)                
                hdrlist.concatenate((SIPHeaderList) h, top);
                else
                nameTable.put(headerNameLowerCase, h);
            } //End block
            else
            {
                nameTable.put(headerNameLowerCase, h);
            } //End block
        } //End block
        if(h instanceof From)        
        {
            this.fromHeader = (From) h;
        } //End block
        else
        if(h instanceof ContentLength)        
        {
            this.contentLengthHeader = (ContentLength) h;
        } //End block
        else
        if(h instanceof To)        
        {
            this.toHeader = (To) h;
        } //End block
        else
        if(h instanceof CSeq)        
        {
            this.cSeqHeader = (CSeq) h;
        } //End block
        else
        if(h instanceof CallID)        
        {
            this.callIdHeader = (CallID) h;
        } //End block
        else
        if(h instanceof MaxForwards)        
        {
            this.maxForwardsHeader = (MaxForwards) h;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.173 -0400", hash_original_method = "870FE8D30093D63C50FAB8B7342DE2BD", hash_generated_method = "CFFE3606CA354FC384BA5073B87C52F5")
    public void removeHeader(String headerName, boolean top) {
        addTaint(top);
        addTaint(headerName.getTaint());
        String headerNameLowerCase = SIPHeaderNamesCache.toLowerCase(headerName);
        SIPHeader toRemove = (SIPHeader) nameTable.get(headerNameLowerCase);
        if(toRemove == null)        
        return;
        if(toRemove instanceof SIPHeaderList)        
        {
            SIPHeaderList< ? > hdrList = (SIPHeaderList< ? >) toRemove;
            if(top)            
            hdrList.removeFirst();
            else
            hdrList.removeLast();
            if(hdrList.isEmpty())            
            {
                Iterator<SIPHeader> li = this.headers.iterator();
                while
(li.hasNext())                
                {
                    SIPHeader sipHeader = (SIPHeader) li.next();
                    if(sipHeader.getName().equalsIgnoreCase(headerNameLowerCase))                    
                    li.remove();
                } //End block
                nameTable.remove(headerNameLowerCase);
            } //End block
        } //End block
        else
        {
            this.nameTable.remove(headerNameLowerCase);
            if(toRemove instanceof From)            
            {
                this.fromHeader = null;
            } //End block
            else
            if(toRemove instanceof To)            
            {
                this.toHeader = null;
            } //End block
            else
            if(toRemove instanceof CSeq)            
            {
                this.cSeqHeader = null;
            } //End block
            else
            if(toRemove instanceof CallID)            
            {
                this.callIdHeader = null;
            } //End block
            else
            if(toRemove instanceof MaxForwards)            
            {
                this.maxForwardsHeader = null;
            } //End block
            else
            if(toRemove instanceof ContentLength)            
            {
                this.contentLengthHeader = null;
            } //End block
            Iterator<SIPHeader> li = this.headers.iterator();
            while
(li.hasNext())            
            {
                SIPHeader sipHeader = (SIPHeader) li.next();
                if(sipHeader.getName().equalsIgnoreCase(headerName))                
                li.remove();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.174 -0400", hash_original_method = "A43C3FE911C5904FA81F0CAD0EBF40FE", hash_generated_method = "129A4FBE3CD698749828D0B7D208E75A")
    public void removeHeader(String headerName) {
        addTaint(headerName.getTaint());
        if(headerName == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_67314800 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_67314800.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_67314800;
        }
        String headerNameLowerCase = SIPHeaderNamesCache.toLowerCase(headerName);
        SIPHeader removed = (SIPHeader) nameTable.remove(headerNameLowerCase);
        if(removed == null)        
        return;
        if(removed instanceof From)        
        {
            this.fromHeader = null;
        } //End block
        else
        if(removed instanceof To)        
        {
            this.toHeader = null;
        } //End block
        else
        if(removed instanceof CSeq)        
        {
            this.cSeqHeader = null;
        } //End block
        else
        if(removed instanceof CallID)        
        {
            this.callIdHeader = null;
        } //End block
        else
        if(removed instanceof MaxForwards)        
        {
            this.maxForwardsHeader = null;
        } //End block
        else
        if(removed instanceof ContentLength)        
        {
            this.contentLengthHeader = null;
        } //End block
        Iterator<SIPHeader> li = this.headers.iterator();
        while
(li.hasNext())        
        {
            SIPHeader sipHeader = (SIPHeader) li.next();
            if(sipHeader.getName().equalsIgnoreCase(headerNameLowerCase))            
            li.remove();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.175 -0400", hash_original_method = "04B79D458A896A4F330B98FD27925CCB", hash_generated_method = "EDEFF51CF51D1A3D8EEDAEBBDBE4680F")
    public String getTransactionId() {
        Via topVia = null;
        if(!this.getViaHeaders().isEmpty())        
        {
            topVia = (Via) this.getViaHeaders().getFirst();
        } //End block
        if(topVia != null
                && topVia.getBranch() != null
                && topVia.getBranch().toUpperCase().startsWith(
                        SIPConstants.BRANCH_MAGIC_COOKIE_UPPER_CASE))        
        {
            if(this.getCSeq().getMethod().equals(Request.CANCEL))            
            {
String var7807027C3160A60114210C6B0FF56C6C_1718840829 =             (topVia.getBranch() + ":" + this.getCSeq().getMethod()).toLowerCase();
            var7807027C3160A60114210C6B0FF56C6C_1718840829.addTaint(taint);
            return var7807027C3160A60114210C6B0FF56C6C_1718840829;
            }
            else
            {
String var716648118C574616DFF8CC502E40403B_719602154 =             topVia.getBranch().toLowerCase();
            var716648118C574616DFF8CC502E40403B_719602154.addTaint(taint);
            return var716648118C574616DFF8CC502E40403B_719602154;
            }
        } //End block
        else
        {
            StringBuffer retval = new StringBuffer();
            From from = (From) this.getFrom();
            To to = (To) this.getTo();
            if(from.hasTag())            
            retval.append(from.getTag()).append("-");
            String cid = this.callIdHeader.getCallId();
            retval.append(cid).append("-");
            retval.append(this.cSeqHeader.getSequenceNumber()).append("-").append(
                    this.cSeqHeader.getMethod());
            if(topVia != null)            
            {
                retval.append("-").append(topVia.getSentBy().encode());
                if(!topVia.getSentBy().hasPort())                
                {
                    retval.append("-").append(5060);
                } //End block
            } //End block
            if(this.getCSeq().getMethod().equals(Request.CANCEL))            
            {
                retval.append(Request.CANCEL);
            } //End block
String var74489726A6E091DB52CBF99C7496DFAB_251647241 =             retval.toString().toLowerCase().replace(":", "-").replace("@", "-")
                    + Utils.getSignature();
            var74489726A6E091DB52CBF99C7496DFAB_251647241.addTaint(taint);
            return var74489726A6E091DB52CBF99C7496DFAB_251647241;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.175 -0400", hash_original_method = "2D96B4A52CFB118A97F95400511B110F", hash_generated_method = "C2F327293A606EF569B3DA5F6A567762")
    public int hashCode() {
        if(this.callIdHeader == null)        
        {
        RuntimeException varC046FF62BAC05F7E31E7C1721C566274_987110947 = new RuntimeException(
                    "Invalid message! Cannot compute hashcode! call-id header is missing !");
        varC046FF62BAC05F7E31E7C1721C566274_987110947.addTaint(taint);
        throw varC046FF62BAC05F7E31E7C1721C566274_987110947;
        }
        else
        {
        int var2A08699429A105F8136EA4EB7EC8A742_1727895770 = (this.callIdHeader.getCallId().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1842410995 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1842410995;
        }
        // ---------- Original Method ----------
        //if (this.callIdHeader == null)
            //throw new RuntimeException(
                    //"Invalid message! Cannot compute hashcode! call-id header is missing !");
        //else
            //return this.callIdHeader.getCallId().hashCode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.175 -0400", hash_original_method = "0B4068F7FDD81C59C44EF10BE948C047", hash_generated_method = "597243C47B97008626BB65A35E67EB0E")
    public boolean hasContent() {
        boolean var5D9A09772781E199458818160705ED78_292581887 = (messageContent != null || messageContentBytes != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1000831482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1000831482;
        // ---------- Original Method ----------
        //return messageContent != null || messageContentBytes != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.175 -0400", hash_original_method = "16CF6C29A1D923EBFDFB9DE65000093A", hash_generated_method = "F7FA68CCB8A45D9337EACC2A619D10FD")
    public Iterator<SIPHeader> getHeaders() {
Iterator<SIPHeader> var169085E2B47E3BF8416E299E951072CC_636816550 =         headers.iterator();
        var169085E2B47E3BF8416E299E951072CC_636816550.addTaint(taint);
        return var169085E2B47E3BF8416E299E951072CC_636816550;
        // ---------- Original Method ----------
        //return headers.iterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.175 -0400", hash_original_method = "1ADD77F2239C280F0A32414969B68312", hash_generated_method = "BB0B63AE4C7F9D7BA3166B47F2364597")
    public Header getHeader(String headerName) {
        addTaint(headerName.getTaint());
Header varCCB0AD9CF7E1F5AFBE8B1DF0A30B8415_1578699432 =         getHeaderLowerCase(SIPHeaderNamesCache.toLowerCase(headerName));
        varCCB0AD9CF7E1F5AFBE8B1DF0A30B8415_1578699432.addTaint(taint);
        return varCCB0AD9CF7E1F5AFBE8B1DF0A30B8415_1578699432;
        // ---------- Original Method ----------
        //return getHeaderLowerCase(SIPHeaderNamesCache.toLowerCase(headerName));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.176 -0400", hash_original_method = "32A79E235DDCC6E80E2B12189B346373", hash_generated_method = "12FA061C5C92A88AA4CF0FAA78158891")
    private Header getHeaderLowerCase(String lowerCaseHeaderName) {
        addTaint(lowerCaseHeaderName.getTaint());
        if(lowerCaseHeaderName == null)        
        {
        NullPointerException varF8E41E74DC7E4A1BFFD590DA02D269D3_2046601465 = new NullPointerException("bad name");
        varF8E41E74DC7E4A1BFFD590DA02D269D3_2046601465.addTaint(taint);
        throw varF8E41E74DC7E4A1BFFD590DA02D269D3_2046601465;
        }
        SIPHeader sipHeader = (SIPHeader) nameTable.get(lowerCaseHeaderName);
        if(sipHeader instanceof SIPHeaderList)        
        {
Header var7CAD833627878FD3F7B863ACAAFB2E71_1675450894 =         (Header) ((SIPHeaderList) sipHeader).getFirst();
        var7CAD833627878FD3F7B863ACAAFB2E71_1675450894.addTaint(taint);
        return var7CAD833627878FD3F7B863ACAAFB2E71_1675450894;
        }
        else
        {
Header varDF77B5B4168F45421B89B792E9510A4B_36606888 =         (Header) sipHeader;
        varDF77B5B4168F45421B89B792E9510A4B_36606888.addTaint(taint);
        return varDF77B5B4168F45421B89B792E9510A4B_36606888;
        }
        // ---------- Original Method ----------
        //if (lowerCaseHeaderName == null)
            //throw new NullPointerException("bad name");
        //SIPHeader sipHeader = (SIPHeader) nameTable.get(lowerCaseHeaderName);
        //if (sipHeader instanceof SIPHeaderList)
            //return (Header) ((SIPHeaderList) sipHeader).getFirst();
        //else
            //return (Header) sipHeader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.176 -0400", hash_original_method = "094433154D44236D0991BBCF366E0E6A", hash_generated_method = "F79E91B9AB7A01A2A52736312858D5D7")
    public ContentType getContentTypeHeader() {
ContentType var503E7451F54F9039473F136B95CD15E8_1349939276 =         (ContentType) getHeaderLowerCase(CONTENT_TYPE_LOWERCASE);
        var503E7451F54F9039473F136B95CD15E8_1349939276.addTaint(taint);
        return var503E7451F54F9039473F136B95CD15E8_1349939276;
        // ---------- Original Method ----------
        //return (ContentType) getHeaderLowerCase(CONTENT_TYPE_LOWERCASE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.176 -0400", hash_original_method = "F29DC29143C65AC3E05B010248583D2F", hash_generated_method = "79900A8BC054FA217891BC33E934D89F")
    public ContentLengthHeader getContentLengthHeader() {
ContentLengthHeader var0E116520CA9F97032B794A62953662D9_1189332043 =         this.getContentLength();
        var0E116520CA9F97032B794A62953662D9_1189332043.addTaint(taint);
        return var0E116520CA9F97032B794A62953662D9_1189332043;
        // ---------- Original Method ----------
        //return this.getContentLength();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.176 -0400", hash_original_method = "E10DCB9A2200DABE5E8DE063DD5342F3", hash_generated_method = "1360C3B26735E446DAD2ACC264F0AF01")
    public FromHeader getFrom() {
FromHeader var7E8616B95CCA52C5507153D700D0B24C_1585648725 =         (FromHeader) fromHeader;
        var7E8616B95CCA52C5507153D700D0B24C_1585648725.addTaint(taint);
        return var7E8616B95CCA52C5507153D700D0B24C_1585648725;
        // ---------- Original Method ----------
        //return (FromHeader) fromHeader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.176 -0400", hash_original_method = "10D7F219ADDA2D1F9DA30C2C2F401D03", hash_generated_method = "E55D1B6C3872163E348761AE7E5FA46B")
    public ErrorInfoList getErrorInfoHeaders() {
ErrorInfoList var036CD60E11ECF3BF75B0E9B9E834ACEC_988229636 =         (ErrorInfoList) getSIPHeaderListLowerCase(ERROR_LOWERCASE);
        var036CD60E11ECF3BF75B0E9B9E834ACEC_988229636.addTaint(taint);
        return var036CD60E11ECF3BF75B0E9B9E834ACEC_988229636;
        // ---------- Original Method ----------
        //return (ErrorInfoList) getSIPHeaderListLowerCase(ERROR_LOWERCASE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.176 -0400", hash_original_method = "6BBB646E6D7D64808CC70B68BEB17C86", hash_generated_method = "25FA9D889F83A4A2FFE24C6D50530EBF")
    public ContactList getContactHeaders() {
ContactList varAA8B9C443D692B0636D9210B1B99FEB4_2049144583 =         (ContactList) this.getSIPHeaderListLowerCase(CONTACT_LOWERCASE);
        varAA8B9C443D692B0636D9210B1B99FEB4_2049144583.addTaint(taint);
        return varAA8B9C443D692B0636D9210B1B99FEB4_2049144583;
        // ---------- Original Method ----------
        //return (ContactList) this.getSIPHeaderListLowerCase(CONTACT_LOWERCASE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.176 -0400", hash_original_method = "7930A8382B37585900D6B0ADAEF5E908", hash_generated_method = "D128F1B24037DA64CEEF69AD30CF3217")
    public Contact getContactHeader() {
        ContactList clist = this.getContactHeaders();
        if(clist != null)        
        {
Contact varC94C518DC90763FBBD067E1AA06B4C82_1217858500 =             (Contact) clist.getFirst();
            varC94C518DC90763FBBD067E1AA06B4C82_1217858500.addTaint(taint);
            return varC94C518DC90763FBBD067E1AA06B4C82_1217858500;
        } //End block
        else
        {
Contact var540C13E9E156B687226421B24F2DF178_535131723 =             null;
            var540C13E9E156B687226421B24F2DF178_535131723.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_535131723;
        } //End block
        // ---------- Original Method ----------
        //ContactList clist = this.getContactHeaders();
        //if (clist != null) {
            //return (Contact) clist.getFirst();
        //} else {
            //return null;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.176 -0400", hash_original_method = "F913627528E03E7BE96F6FC26EC1EAB5", hash_generated_method = "5E5E81C72AD529B2531F7EE72EBEAD23")
    public ViaList getViaHeaders() {
ViaList varE4963E1622596596C3AFE385A55A1E9A_409930546 =         (ViaList) getSIPHeaderListLowerCase(VIA_LOWERCASE);
        varE4963E1622596596C3AFE385A55A1E9A_409930546.addTaint(taint);
        return varE4963E1622596596C3AFE385A55A1E9A_409930546;
        // ---------- Original Method ----------
        //return (ViaList) getSIPHeaderListLowerCase(VIA_LOWERCASE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.176 -0400", hash_original_method = "4714C62FF03EE4A312864AB7EDBC16A3", hash_generated_method = "09B60E41928A0343A5CE1F94CD911BF5")
    public void setVia(java.util.List viaList) {
        addTaint(viaList.getTaint());
        ViaList vList = new ViaList();
        ListIterator it = viaList.listIterator();
        while
(it.hasNext())        
        {
            Via via = (Via) it.next();
            vList.add(via);
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.177 -0400", hash_original_method = "458FFC69EFF172F74B60E661629859D7", hash_generated_method = "54E49F2F21AF4B6DDD33B5C78B897EDC")
    public void setHeader(SIPHeaderList<Via> sipHeaderList) {
        addTaint(sipHeaderList.getTaint());
        this.setHeader((Header) sipHeaderList);
        // ---------- Original Method ----------
        //this.setHeader((Header) sipHeaderList);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.177 -0400", hash_original_method = "D8225C1F89A591B431137F8AC67C8011", hash_generated_method = "79E513E07D36B9AEE3ED96935ABDA208")
    public Via getTopmostVia() {
        if(this.getViaHeaders() == null)        
        {
Via var540C13E9E156B687226421B24F2DF178_880026375 =         null;
        var540C13E9E156B687226421B24F2DF178_880026375.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_880026375;
        }
        else
        {
Via var1BDC64DDD514EFAB50D16B7E00DBDB95_560866416 =         (Via) (getViaHeaders().getFirst());
        var1BDC64DDD514EFAB50D16B7E00DBDB95_560866416.addTaint(taint);
        return var1BDC64DDD514EFAB50D16B7E00DBDB95_560866416;
        }
        // ---------- Original Method ----------
        //if (this.getViaHeaders() == null)
            //return null;
        //else
            //return (Via) (getViaHeaders().getFirst());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.177 -0400", hash_original_method = "734B287C3C9508BBD63962A2764D9C01", hash_generated_method = "4CCEEDC1FF5CE1F72BE7227317708E1A")
    public CSeqHeader getCSeq() {
CSeqHeader var0371EB3DF60DCD3E5DB5804B1DA468CE_1311800688 =         (CSeqHeader) cSeqHeader;
        var0371EB3DF60DCD3E5DB5804B1DA468CE_1311800688.addTaint(taint);
        return var0371EB3DF60DCD3E5DB5804B1DA468CE_1311800688;
        // ---------- Original Method ----------
        //return (CSeqHeader) cSeqHeader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.177 -0400", hash_original_method = "6A92E6492A4EA537FE7E1089912E5A2E", hash_generated_method = "6B937CF7631800671326D271CB222FA0")
    public Authorization getAuthorization() {
Authorization varF9F736C1A1FC4A7AE6CF26AB986434D5_453778522 =         (Authorization) getHeaderLowerCase(AUTHORIZATION_LOWERCASE);
        varF9F736C1A1FC4A7AE6CF26AB986434D5_453778522.addTaint(taint);
        return varF9F736C1A1FC4A7AE6CF26AB986434D5_453778522;
        // ---------- Original Method ----------
        //return (Authorization) getHeaderLowerCase(AUTHORIZATION_LOWERCASE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.177 -0400", hash_original_method = "1941B7A53D19F77542CA45C05AFF9884", hash_generated_method = "8DE9FC20B23A8A499F891CC59115FD73")
    public MaxForwardsHeader getMaxForwards() {
MaxForwardsHeader varEF725751D19AC70C4F57F9BFAAC191D7_1855875623 =         maxForwardsHeader;
        varEF725751D19AC70C4F57F9BFAAC191D7_1855875623.addTaint(taint);
        return varEF725751D19AC70C4F57F9BFAAC191D7_1855875623;
        // ---------- Original Method ----------
        //return maxForwardsHeader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.177 -0400", hash_original_method = "08224707CDDBB2C37148D3B618E2B6B7", hash_generated_method = "CF135258C84BD8E6D2854DBA92CDED20")
    public void setMaxForwards(MaxForwardsHeader maxForwards) {
        addTaint(maxForwards.getTaint());
        this.setHeader(maxForwards);
        // ---------- Original Method ----------
        //this.setHeader(maxForwards);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.177 -0400", hash_original_method = "7800F88C4B689BC7D7C78CBE850678CA", hash_generated_method = "6922CCBFD49AD2B2F7B1A1C627442C1C")
    public RouteList getRouteHeaders() {
RouteList varD88E9995CB472A568317A79450686765_1783129184 =         (RouteList) getSIPHeaderListLowerCase(ROUTE_LOWERCASE);
        varD88E9995CB472A568317A79450686765_1783129184.addTaint(taint);
        return varD88E9995CB472A568317A79450686765_1783129184;
        // ---------- Original Method ----------
        //return (RouteList) getSIPHeaderListLowerCase(ROUTE_LOWERCASE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.177 -0400", hash_original_method = "9DA69A74904D39D3267E3E1010C409F3", hash_generated_method = "13645F037D31CA4EDC1A15C2764021C3")
    public CallIdHeader getCallId() {
CallIdHeader var2512F43A36DEB920CEA89B5BA464D4B4_2115964058 =         callIdHeader;
        var2512F43A36DEB920CEA89B5BA464D4B4_2115964058.addTaint(taint);
        return var2512F43A36DEB920CEA89B5BA464D4B4_2115964058;
        // ---------- Original Method ----------
        //return callIdHeader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.177 -0400", hash_original_method = "5127E494FA29164B5CB6A74D7F3B176F", hash_generated_method = "4B6CC3F25B69F43940D6327B43A25A55")
    public void setCallId(CallIdHeader callId) {
        addTaint(callId.getTaint());
        this.setHeader(callId);
        // ---------- Original Method ----------
        //this.setHeader(callId);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.178 -0400", hash_original_method = "16037BFD4917B839A558D81FBF251209", hash_generated_method = "59A37871E8B1DF4ED7BDFDD2669DAC25")
    public void setCallId(String callId) throws java.text.ParseException {
        addTaint(callId.getTaint());
        if(callIdHeader == null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.178 -0400", hash_original_method = "6FCB806D3659BA1DF59CA318834E3C35", hash_generated_method = "119B8765F11C8D93196E2DE3D4189663")
    public RecordRouteList getRecordRouteHeaders() {
RecordRouteList var1588548A9B02ACBEF48523119ABFF6A9_1929114526 =         (RecordRouteList) this.getSIPHeaderListLowerCase(RECORDROUTE_LOWERCASE);
        var1588548A9B02ACBEF48523119ABFF6A9_1929114526.addTaint(taint);
        return var1588548A9B02ACBEF48523119ABFF6A9_1929114526;
        // ---------- Original Method ----------
        //return (RecordRouteList) this.getSIPHeaderListLowerCase(RECORDROUTE_LOWERCASE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.178 -0400", hash_original_method = "D2F3523F315E42C3CDB78FE4D7DBD860", hash_generated_method = "724BD2369B78FB926A6AF5979BD0B9B9")
    public ToHeader getTo() {
ToHeader varF7A555A948C2C4B404B57534A94E4D37_64004494 =         (ToHeader) toHeader;
        varF7A555A948C2C4B404B57534A94E4D37_64004494.addTaint(taint);
        return varF7A555A948C2C4B404B57534A94E4D37_64004494;
        // ---------- Original Method ----------
        //return (ToHeader) toHeader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.178 -0400", hash_original_method = "AA146219F068967CE3F55E3F637E86D7", hash_generated_method = "5797DA27E97DA9467A667D6BAFA3F5D2")
    public void setTo(ToHeader to) {
        addTaint(to.getTaint());
        this.setHeader(to);
        // ---------- Original Method ----------
        //this.setHeader(to);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.178 -0400", hash_original_method = "61E9A0C02A79622F4076A17D3E8275D9", hash_generated_method = "2DA4E980183CF318802824B52CD7E3DA")
    public void setFrom(FromHeader from) {
        addTaint(from.getTaint());
        this.setHeader(from);
        // ---------- Original Method ----------
        //this.setHeader(from);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.178 -0400", hash_original_method = "BF14C97BBADF5B6B3DD1A606FFB97154", hash_generated_method = "B8E1B2723948E785D1DB0F53F38657CF")
    public ContentLengthHeader getContentLength() {
ContentLengthHeader varEAA2B9DD673B76B698F2B6C64694CC67_816592870 =         this.contentLengthHeader;
        varEAA2B9DD673B76B698F2B6C64694CC67_816592870.addTaint(taint);
        return varEAA2B9DD673B76B698F2B6C64694CC67_816592870;
        // ---------- Original Method ----------
        //return this.contentLengthHeader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.179 -0400", hash_original_method = "40D47E0A8FD809ED2EC3170259DB7692", hash_generated_method = "DE8E6962ECA6B0C124CD1C9C5F83B4E1")
    public String getMessageContent() throws UnsupportedEncodingException {
        if(this.messageContent == null && this.messageContentBytes == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1019342797 =         null;
        var540C13E9E156B687226421B24F2DF178_1019342797.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1019342797;
        }
        else
        if(this.messageContent == null)        
        {
            this.messageContent = new String(messageContentBytes, getCharset() );
        } //End block
String varF829FB8E72DE477DA0945F7BFAD27FF7_998879707 =         this.messageContent;
        varF829FB8E72DE477DA0945F7BFAD27FF7_998879707.addTaint(taint);
        return varF829FB8E72DE477DA0945F7BFAD27FF7_998879707;
        // ---------- Original Method ----------
        //if (this.messageContent == null && this.messageContentBytes == null)
            //return null;
        //else if (this.messageContent == null) {
            //this.messageContent = new String(messageContentBytes, getCharset() );
        //}
        //return this.messageContent;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.179 -0400", hash_original_method = "0A8A11F2CA57642B3F77F3FF48221ABE", hash_generated_method = "18BE198D71318D75C003AACA1282D152")
    public byte[] getRawContent() {
        try 
        {
            if(this.messageContentBytes != null)            
            {
            } //End block
            else
            if(this.messageContentObject != null)            
            {
                String messageContent = this.messageContentObject.toString();
                this.messageContentBytes = messageContent.getBytes( getCharset() );
            } //End block
            else
            if(this.messageContent != null)            
            {
                this.messageContentBytes = messageContent.getBytes( getCharset() );
            } //End block
            byte[] varE214FD574169EC834A5D96756F754486_914100357 = (this.messageContentBytes);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1853266569 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1853266569;
        } //End block
        catch (UnsupportedEncodingException ex)
        {
            InternalErrorHandler.handleException(ex);
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1509053426 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1872915882 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1872915882;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.179 -0400", hash_original_method = "AF476AB0E969B944040525792C5BC52E", hash_generated_method = "FB0FF982BE500FC9DBA2CAB842DC81ED")
    public void setMessageContent(String type, String subType, String messageContent) {
        addTaint(subType.getTaint());
        addTaint(type.getTaint());
        if(messageContent == null)        
        {
        IllegalArgumentException var53352562DD4E9F6FF56D4EBB0C135D2F_933304039 = new IllegalArgumentException("messgeContent is null");
        var53352562DD4E9F6FF56D4EBB0C135D2F_933304039.addTaint(taint);
        throw var53352562DD4E9F6FF56D4EBB0C135D2F_933304039;
        }
        ContentType ct = new ContentType(type, subType);
        this.setHeader(ct);
        this.messageContent = messageContent;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.180 -0400", hash_original_method = "F6727728B1118BFFD3FCC04534FCE621", hash_generated_method = "34AD9BFB285FAA4B2B250839F6DD9885")
    public void setContent(Object content, ContentTypeHeader contentTypeHeader) throws ParseException {
        addTaint(contentTypeHeader.getTaint());
        if(content == null)        
        {
        NullPointerException varA715441409EE18D92F04D645DADEF1DF_578546720 = new NullPointerException("null content");
        varA715441409EE18D92F04D645DADEF1DF_578546720.addTaint(taint);
        throw varA715441409EE18D92F04D645DADEF1DF_578546720;
        }
        this.setHeader(contentTypeHeader);
        this.messageContent = null;
        this.messageContentBytes = null;
        this.messageContentObject = null;
        if(content instanceof String)        
        {
            this.messageContent = (String) content;
        } //End block
        else
        if(content instanceof byte[])        
        {
            this.messageContentBytes = (byte[]) content;
        } //End block
        else
        this.messageContentObject = content;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.180 -0400", hash_original_method = "54FC52177A1CB92C02565C30A4F8CE94", hash_generated_method = "BC967BB8BE2214894395FD05DCE1F918")
    public Object getContent() {
        if(this.messageContentObject != null)        
        {
Object var4EE1E0DB22464FCD432669156BDFA9EF_1335849756 =         messageContentObject;
        var4EE1E0DB22464FCD432669156BDFA9EF_1335849756.addTaint(taint);
        return var4EE1E0DB22464FCD432669156BDFA9EF_1335849756;
        }
        else
        if(this.messageContent != null)        
        {
Object varF829FB8E72DE477DA0945F7BFAD27FF7_796979287 =         this.messageContent;
        varF829FB8E72DE477DA0945F7BFAD27FF7_796979287.addTaint(taint);
        return varF829FB8E72DE477DA0945F7BFAD27FF7_796979287;
        }
        else
        if(this.messageContentBytes != null)        
        {
Object var25D458C48519FF5C4DE95168DEF4E2FA_1656590005 =         this.messageContentBytes;
        var25D458C48519FF5C4DE95168DEF4E2FA_1656590005.addTaint(taint);
        return var25D458C48519FF5C4DE95168DEF4E2FA_1656590005;
        }
        else
        {
Object var540C13E9E156B687226421B24F2DF178_370877119 =         null;
        var540C13E9E156B687226421B24F2DF178_370877119.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_370877119;
        }
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.180 -0400", hash_original_method = "567464035ABE474ACDCFF614F9D534B5", hash_generated_method = "C12E6E953020DAB31745A7CAFC39BA3E")
    public void setMessageContent(String type, String subType, byte[] messageContent) {
        addTaint(messageContent[0]);
        addTaint(subType.getTaint());
        addTaint(type.getTaint());
        ContentType ct = new ContentType(type, subType);
        this.setHeader(ct);
        this.setMessageContent(messageContent);
        computeContentLength(messageContent);
        // ---------- Original Method ----------
        //ContentType ct = new ContentType(type, subType);
        //this.setHeader(ct);
        //this.setMessageContent(messageContent);
        //computeContentLength(messageContent);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.180 -0400", hash_original_method = "39F2BE1EDB04320A3B64ACD0EA831DED", hash_generated_method = "0CA297C8DB1C0475A533503D41D813AA")
    public void setMessageContent(String content, boolean strict, boolean computeContentLength, int givenLength) throws ParseException {
        addTaint(givenLength);
        addTaint(computeContentLength);
        addTaint(strict);
        computeContentLength(content);
        if((!computeContentLength))        
        {
            if((!strict && this.contentLengthHeader.getContentLength() != givenLength) 
                    || this.contentLengthHeader.getContentLength() < givenLength)            
            {
                ParseException varCF21858D3319094F0C12CC25E1BF308A_1092224115 = new ParseException("Invalid content length "
                        + this.contentLengthHeader.getContentLength() + " / " + givenLength, 0);
                varCF21858D3319094F0C12CC25E1BF308A_1092224115.addTaint(taint);
                throw varCF21858D3319094F0C12CC25E1BF308A_1092224115;
            } //End block
        } //End block
        messageContent = content;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.181 -0400", hash_original_method = "19C7E154661732280AD152F3E186944D", hash_generated_method = "FE4B2F2B2435BA47A415DC55253399E0")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.181 -0400", hash_original_method = "677A53CE4E6B4035F9B12FCECD3E865E", hash_generated_method = "B813FF63BFD2F9CE89A06CEF19516DD4")
    public void setMessageContent(byte[] content, boolean computeContentLength, int givenLength) throws ParseException {
        addTaint(givenLength);
        addTaint(computeContentLength);
        computeContentLength(content);
        if((!computeContentLength) && this.contentLengthHeader.getContentLength() < givenLength)        
        {
            ParseException varCF21858D3319094F0C12CC25E1BF308A_1963343410 = new ParseException("Invalid content length "
                    + this.contentLengthHeader.getContentLength() + " / " + givenLength, 0);
            varCF21858D3319094F0C12CC25E1BF308A_1963343410.addTaint(taint);
            throw varCF21858D3319094F0C12CC25E1BF308A_1963343410;
        } //End block
        messageContentBytes = content;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.181 -0400", hash_original_method = "D3327D918F93ECC2995A4C67A415A1A5", hash_generated_method = "E4A07DFF382A07C6F220F461C866E952")
    private void computeContentLength(Object content) {
        addTaint(content.getTaint());
        int length = 0;
        if(content != null)        
        {
            if(content instanceof String)            
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
            else
            if(content instanceof byte[])            
            {
                length = ((byte[]) content).length;
            } //End block
            else
            {
                length = content.toString().length();
            } //End block
        } //End block
        try 
        {
            contentLengthHeader.setContentLength(length);
        } //End block
        catch (InvalidArgumentException e)
        {
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.182 -0400", hash_original_method = "B09AA5FB20D2965ADCD41D53860CDBE3", hash_generated_method = "C433687F37F78D6DB58F9B2BE25DC4C8")
    public void removeContent() {
        messageContent = null;
        messageContentBytes = null;
        messageContentObject = null;
        try 
        {
            this.contentLengthHeader.setContentLength(0);
        } //End block
        catch (InvalidArgumentException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //messageContent = null;
        //messageContentBytes = null;
        //messageContentObject = null;
        //try {
            //this.contentLengthHeader.setContentLength(0);
        //} catch (InvalidArgumentException ex) {
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.182 -0400", hash_original_method = "B51D33B6E886062DB169564C9DA9DCD8", hash_generated_method = "EFA4AFB003310F67429FEB9D865A7F05")
    @SuppressWarnings("unchecked")
    public ListIterator<SIPHeader> getHeaders(String headerName) {
        addTaint(headerName.getTaint());
        if(headerName == null)        
        {
        NullPointerException var64392218EC4146E61D6599BF9AF52741_1146366277 = new NullPointerException("null headerName");
        var64392218EC4146E61D6599BF9AF52741_1146366277.addTaint(taint);
        throw var64392218EC4146E61D6599BF9AF52741_1146366277;
        }
        SIPHeader sipHeader = (SIPHeader) nameTable.get(SIPHeaderNamesCache
                .toLowerCase(headerName));
        if(sipHeader == null)        
        {
ListIterator<SIPHeader> var27A089332AD01D48DEAA5EFD0D05728A_508717556 =         new LinkedList<SIPHeader>().listIterator();
        var27A089332AD01D48DEAA5EFD0D05728A_508717556.addTaint(taint);
        return var27A089332AD01D48DEAA5EFD0D05728A_508717556;
        }
        if(sipHeader instanceof SIPHeaderList)        
        {
ListIterator<SIPHeader> varDBE0950779D540B5F9547ECF090AAED9_322048735 =             ((SIPHeaderList<SIPHeader>) sipHeader).listIterator();
            varDBE0950779D540B5F9547ECF090AAED9_322048735.addTaint(taint);
            return varDBE0950779D540B5F9547ECF090AAED9_322048735;
        } //End block
        else
        {
ListIterator<SIPHeader> var359DBD5FF7CDD10C9EF326ED7D065DC7_1743516918 =             new HeaderIterator(this, sipHeader);
            var359DBD5FF7CDD10C9EF326ED7D065DC7_1743516918.addTaint(taint);
            return var359DBD5FF7CDD10C9EF326ED7D065DC7_1743516918;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.182 -0400", hash_original_method = "6CE50AA271DA9876F1700D8E280EAFD1", hash_generated_method = "8A670B077DA720BD426D4A8E16B75B35")
    public String getHeaderAsFormattedString(String name) {
        addTaint(name.getTaint());
        String lowerCaseName = name.toLowerCase();
        if(this.nameTable.containsKey(lowerCaseName))        
        {
String var67F7CD1A54D3B8D5A3B6D0A9F7DF3814_1227735245 =             this.nameTable.get(lowerCaseName).toString();
            var67F7CD1A54D3B8D5A3B6D0A9F7DF3814_1227735245.addTaint(taint);
            return var67F7CD1A54D3B8D5A3B6D0A9F7DF3814_1227735245;
        } //End block
        else
        {
String var4A58D553E11CF1284D32C65807D538A0_1646029635 =             this.getHeader(name).toString();
            var4A58D553E11CF1284D32C65807D538A0_1646029635.addTaint(taint);
            return var4A58D553E11CF1284D32C65807D538A0_1646029635;
        } //End block
        // ---------- Original Method ----------
        //String lowerCaseName = name.toLowerCase();
        //if (this.nameTable.containsKey(lowerCaseName)) {
            //return this.nameTable.get(lowerCaseName).toString();
        //} else {
            //return this.getHeader(name).toString();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.183 -0400", hash_original_method = "2723C6F27F309BF6F386C5DF25AB6032", hash_generated_method = "0A86A169A23525DDBC8D2FFF0F81B79C")
    private SIPHeader getSIPHeaderListLowerCase(String lowerCaseHeaderName) {
        addTaint(lowerCaseHeaderName.getTaint());
SIPHeader var9F84BCDE7A03E3F19EFF3E75A8D0C3B5_1131633331 =         nameTable.get(lowerCaseHeaderName);
        var9F84BCDE7A03E3F19EFF3E75A8D0C3B5_1131633331.addTaint(taint);
        return var9F84BCDE7A03E3F19EFF3E75A8D0C3B5_1131633331;
        // ---------- Original Method ----------
        //return nameTable.get(lowerCaseHeaderName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.183 -0400", hash_original_method = "9F4B7A8AFA1B725FEEE6FA6CFA2755DF", hash_generated_method = "37D4751BD559FF0F9817B96E8A4FDDB3")
    @SuppressWarnings("unchecked")
    private List<SIPHeader> getHeaderList(String headerName) {
        addTaint(headerName.getTaint());
        SIPHeader sipHeader = (SIPHeader) nameTable.get(SIPHeaderNamesCache
                .toLowerCase(headerName));
        if(sipHeader == null)        
        {
List<SIPHeader> var540C13E9E156B687226421B24F2DF178_2037364143 =         null;
        var540C13E9E156B687226421B24F2DF178_2037364143.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2037364143;
        }
        else
        if(sipHeader instanceof SIPHeaderList)        
        {
List<SIPHeader> var21F1C23F6CFBC6CA95D90D071117E296_2048986069 =         (List<SIPHeader>) (((SIPHeaderList< ? >) sipHeader).getHeaderList());
        var21F1C23F6CFBC6CA95D90D071117E296_2048986069.addTaint(taint);
        return var21F1C23F6CFBC6CA95D90D071117E296_2048986069;
        }
        else
        {
            LinkedList<SIPHeader> ll = new LinkedList<SIPHeader>();
            ll.add(sipHeader);
List<SIPHeader> var53BD4E0B8E8668757CB18B1D2E5DB6FB_1149049450 =             ll;
            var53BD4E0B8E8668757CB18B1D2E5DB6FB_1149049450.addTaint(taint);
            return var53BD4E0B8E8668757CB18B1D2E5DB6FB_1149049450;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.183 -0400", hash_original_method = "6DBF8105DE4FD1DC6BA28CCFFFEEC680", hash_generated_method = "8D0B8FBF4DB3670DE9A26F062A99D9B4")
    public boolean hasHeader(String headerName) {
        addTaint(headerName.getTaint());
        boolean var6868733DB4D439323ACD251C003A4E2A_1097536892 = (nameTable.containsKey(SIPHeaderNamesCache.toLowerCase(headerName)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_870600680 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_870600680;
        // ---------- Original Method ----------
        //return nameTable.containsKey(SIPHeaderNamesCache.toLowerCase(headerName));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.183 -0400", hash_original_method = "4231E4F79F4F1EB89656879CE689B66E", hash_generated_method = "D61EC2D3A17AE6CDE261ACEC566650D5")
    public boolean hasFromTag() {
        boolean varE9818AEC36D5AB232033D7F3832A5DFF_444242782 = (fromHeader != null && fromHeader.getTag() != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_967369633 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_967369633;
        // ---------- Original Method ----------
        //return fromHeader != null && fromHeader.getTag() != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.184 -0400", hash_original_method = "62BEDD072F48BB9AA18DBB87956D8F3D", hash_generated_method = "73F6C6960C34857A794AE3AEE9E1B2F1")
    public boolean hasToTag() {
        boolean var018B7C5541312476336C310A7ADC802C_1448828474 = (toHeader != null && toHeader.getTag() != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1000277940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1000277940;
        // ---------- Original Method ----------
        //return toHeader != null && toHeader.getTag() != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.184 -0400", hash_original_method = "5C72A9C802C6EC574622DB27171F7A2E", hash_generated_method = "C7105AEFF1F04C80F5E2FF8A5AEECBBB")
    public String getFromTag() {
String var8D362156A1E0C71E78338EF5B9B04177_406384689 =         fromHeader == null ? null : fromHeader.getTag();
        var8D362156A1E0C71E78338EF5B9B04177_406384689.addTaint(taint);
        return var8D362156A1E0C71E78338EF5B9B04177_406384689;
        // ---------- Original Method ----------
        //return fromHeader == null ? null : fromHeader.getTag();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.184 -0400", hash_original_method = "2974ECBC3FF627B3CB2268B4D90C9E07", hash_generated_method = "0890AEDD9876CF7C342DD6ACEC0297CA")
    public void setFromTag(String tag) {
        addTaint(tag.getTaint());
        try 
        {
            fromHeader.setTag(tag);
        } //End block
        catch (ParseException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //fromHeader.setTag(tag);
        //} catch (ParseException e) {
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.184 -0400", hash_original_method = "7DFC8A6205B3CBC36E5183721A30EB01", hash_generated_method = "DA53511CDC1ADC6DBCF7048CD1941616")
    public void setToTag(String tag) {
        addTaint(tag.getTaint());
        try 
        {
            toHeader.setTag(tag);
        } //End block
        catch (ParseException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //toHeader.setTag(tag);
        //} catch (ParseException e) {
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.184 -0400", hash_original_method = "5B9C84C201385B92B0E684584F1ECF7E", hash_generated_method = "540F4AB098D318C5FDFFECC4E3027903")
    public String getToTag() {
String var1E8D6A1AFE73FE2CAA8B49D42AEF9694_1077360347 =         toHeader == null ? null : toHeader.getTag();
        var1E8D6A1AFE73FE2CAA8B49D42AEF9694_1077360347.addTaint(taint);
        return var1E8D6A1AFE73FE2CAA8B49D42AEF9694_1077360347;
        // ---------- Original Method ----------
        //return toHeader == null ? null : toHeader.getTag();
    }

    
    public abstract String getFirstLine();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.185 -0400", hash_original_method = "34A83ACBA422BB4E8AD74511B9BCE335", hash_generated_method = "66B188E74EB4300D6E0E41B1A3BBCBE8")
    public void addHeader(Header sipHeader) {
        addTaint(sipHeader.getTaint());
        SIPHeader sh = (SIPHeader) sipHeader;
        try 
        {
            if((sipHeader instanceof ViaHeader) || (sipHeader instanceof RecordRouteHeader))            
            {
                attachHeader(sh, false, true);
            } //End block
            else
            {
                attachHeader(sh, false, false);
            } //End block
        } //End block
        catch (SIPDuplicateHeaderException ex)
        {
            try 
            {
                if(sipHeader instanceof ContentLength)                
                {
                    ContentLength cl = (ContentLength) sipHeader;
                    contentLengthHeader.setContentLength(cl.getContentLength());
                } //End block
            } //End block
            catch (InvalidArgumentException e)
            {
            } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.185 -0400", hash_original_method = "8AEC9EB78EF51FE3B48C263748A725D0", hash_generated_method = "D0E5371C761D9250B5A63AA197035B65")
    public void addUnparsed(String unparsed) {
        addTaint(unparsed.getTaint());
        this.unrecognizedHeaders.add(unparsed);
        // ---------- Original Method ----------
        //this.unrecognizedHeaders.add(unparsed);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.185 -0400", hash_original_method = "8ACC7204C4B122EB788CE6764EA1EA77", hash_generated_method = "4AB7F96F10B288BD60F60E0EFA1ADCB4")
    public void addHeader(String sipHeader) {
        addTaint(sipHeader.getTaint());
        String hdrString = sipHeader.trim() + "\n";
        try 
        {
            HeaderParser parser = ParserFactory.createParser(sipHeader);
            SIPHeader sh = parser.parse();
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.186 -0400", hash_original_method = "F4B3A65BCC1C141571353972EC488146", hash_generated_method = "C32FE74605E68571496EC89E97F60308")
    public ListIterator<String> getUnrecognizedHeaders() {
ListIterator<String> varDBB72A2BAA4A67B704AF5950B205E051_92480942 =         this.unrecognizedHeaders.listIterator();
        varDBB72A2BAA4A67B704AF5950B205E051_92480942.addTaint(taint);
        return varDBB72A2BAA4A67B704AF5950B205E051_92480942;
        // ---------- Original Method ----------
        //return this.unrecognizedHeaders.listIterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.186 -0400", hash_original_method = "C08D5FBD41C305191A05DA7EC6E8BA34", hash_generated_method = "BF24C2B3FE9EDE94A73992A034EA743E")
    public ListIterator<String> getHeaderNames() {
        Iterator<SIPHeader> li = this.headers.iterator();
        LinkedList<String> retval = new LinkedList<String>();
        while
(li.hasNext())        
        {
            SIPHeader sipHeader = (SIPHeader) li.next();
            String name = sipHeader.getName();
            retval.add(name);
        } //End block
ListIterator<String> varE5CB21342F743C2789E32811BD0E4C88_1803424082 =         retval.listIterator();
        varE5CB21342F743C2789E32811BD0E4C88_1803424082.addTaint(taint);
        return varE5CB21342F743C2789E32811BD0E4C88_1803424082;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.186 -0400", hash_original_method = "19862554CF2CF162312B89332E1831C0", hash_generated_method = "CFAAFDA2613F88A8A915052DDC8000FD")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(!other.getClass().equals(this.getClass()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_745812132 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1108823013 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1108823013;
        } //End block
        SIPMessage otherMessage = (SIPMessage) other;
        Collection<SIPHeader> values = this.nameTable.values();
        Iterator<SIPHeader> it = values.iterator();
        if(nameTable.size() != otherMessage.nameTable.size())        
        {
            boolean var68934A3E9455FA72420237EB05902327_283095087 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18673039 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_18673039;
        } //End block
        while
(it.hasNext())        
        {
            SIPHeader mine = (SIPHeader) it.next();
            SIPHeader his = (SIPHeader) (otherMessage.nameTable.get(SIPHeaderNamesCache
                    .toLowerCase(mine.getName())));
            if(his == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_908307755 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1711652581 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1711652581;
            } //End block
            else
            if(!his.equals(mine))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1616626716 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1893091833 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1893091833;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_325436921 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1721566520 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1721566520;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.186 -0400", hash_original_method = "3C4825ADE695C84AAF8B57CDEA1CF4CB", hash_generated_method = "796AEE950FCEAC561968133DE07D2991")
    public javax.sip.header.ContentDispositionHeader getContentDisposition() {
javax.sip.header.ContentDispositionHeader var0C3CF09A84B7387B5D513DFBB63065C9_1248437629 =         (ContentDispositionHeader) getHeaderLowerCase(CONTENT_DISPOSITION_LOWERCASE);
        var0C3CF09A84B7387B5D513DFBB63065C9_1248437629.addTaint(taint);
        return var0C3CF09A84B7387B5D513DFBB63065C9_1248437629;
        // ---------- Original Method ----------
        //return (ContentDispositionHeader) getHeaderLowerCase(CONTENT_DISPOSITION_LOWERCASE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.186 -0400", hash_original_method = "46C03ED253FA9F93BF664C06918E9287", hash_generated_method = "40E3D4D22A5FAEDB943A7B2B19A9E28F")
    public javax.sip.header.ContentEncodingHeader getContentEncoding() {
javax.sip.header.ContentEncodingHeader varC6E3235EA647D2810EA39E3A1F9012F6_1165071922 =         (ContentEncodingHeader) getHeaderLowerCase(CONTENT_ENCODING_LOWERCASE);
        varC6E3235EA647D2810EA39E3A1F9012F6_1165071922.addTaint(taint);
        return varC6E3235EA647D2810EA39E3A1F9012F6_1165071922;
        // ---------- Original Method ----------
        //return (ContentEncodingHeader) getHeaderLowerCase(CONTENT_ENCODING_LOWERCASE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.186 -0400", hash_original_method = "7F8FF7046ECB01AA1B56D3558C9342AE", hash_generated_method = "BFA4C3032F642639A55D036586EBE113")
    public javax.sip.header.ContentLanguageHeader getContentLanguage() {
javax.sip.header.ContentLanguageHeader var61C269B8BA190EE217406EE4EDBBA0AE_1312448629 =         (ContentLanguageHeader) getHeaderLowerCase(CONTENT_LANGUAGE_LOWERCASE);
        var61C269B8BA190EE217406EE4EDBBA0AE_1312448629.addTaint(taint);
        return var61C269B8BA190EE217406EE4EDBBA0AE_1312448629;
        // ---------- Original Method ----------
        //return (ContentLanguageHeader) getHeaderLowerCase(CONTENT_LANGUAGE_LOWERCASE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.187 -0400", hash_original_method = "9AC8AD6CCC74995A67CEDA1778D18415", hash_generated_method = "0AD319A6A243468921448A022B091FC2")
    public javax.sip.header.ExpiresHeader getExpires() {
javax.sip.header.ExpiresHeader var59689CAA2553FE76D9CF3160828DFD83_1100620632 =         (ExpiresHeader) getHeaderLowerCase(EXPIRES_LOWERCASE);
        var59689CAA2553FE76D9CF3160828DFD83_1100620632.addTaint(taint);
        return var59689CAA2553FE76D9CF3160828DFD83_1100620632;
        // ---------- Original Method ----------
        //return (ExpiresHeader) getHeaderLowerCase(EXPIRES_LOWERCASE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.187 -0400", hash_original_method = "729B7ABDA713D8DD91F71F3C7E5D92DE", hash_generated_method = "252719CE4412C739601CC1C306D95C9B")
    public void setExpires(ExpiresHeader expiresHeader) {
        addTaint(expiresHeader.getTaint());
        this.setHeader(expiresHeader);
        // ---------- Original Method ----------
        //this.setHeader(expiresHeader);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.187 -0400", hash_original_method = "9820BC2E150668B0FD803FA9E719FCCB", hash_generated_method = "B0F6E4E280B331FB60FAD30B38356686")
    public void setContentDisposition(ContentDispositionHeader contentDispositionHeader) {
        addTaint(contentDispositionHeader.getTaint());
        this.setHeader(contentDispositionHeader);
        // ---------- Original Method ----------
        //this.setHeader(contentDispositionHeader);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.187 -0400", hash_original_method = "664B5D910990D19402FB830D30BD43E8", hash_generated_method = "97D305AF7527163C522C9DE8A9553384")
    public void setContentEncoding(ContentEncodingHeader contentEncodingHeader) {
        addTaint(contentEncodingHeader.getTaint());
        this.setHeader(contentEncodingHeader);
        // ---------- Original Method ----------
        //this.setHeader(contentEncodingHeader);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.187 -0400", hash_original_method = "F5B59DEA81E2E529FE4037C765469E44", hash_generated_method = "F272A27E90DB85C019DE456C5574EA1F")
    public void setContentLanguage(ContentLanguageHeader contentLanguageHeader) {
        addTaint(contentLanguageHeader.getTaint());
        this.setHeader(contentLanguageHeader);
        // ---------- Original Method ----------
        //this.setHeader(contentLanguageHeader);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.187 -0400", hash_original_method = "5BC3E664403E9FC36E24FA33AD51CF36", hash_generated_method = "EC82C8E000A189149A89231BADB2FD12")
    public void setContentLength(ContentLengthHeader contentLength) {
        addTaint(contentLength.getTaint());
        try 
        {
            this.contentLengthHeader.setContentLength(contentLength.getContentLength());
        } //End block
        catch (InvalidArgumentException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //this.contentLengthHeader.setContentLength(contentLength.getContentLength());
        //} catch (InvalidArgumentException ex) {
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.187 -0400", hash_original_method = "B722E58F0DD8E1CBC622964AAF1F9B26", hash_generated_method = "2BDE89A0FF22729ECAFC892EB96A087D")
    public void setSize(int size) {
        this.size = size;
        // ---------- Original Method ----------
        //this.size = size;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.188 -0400", hash_original_method = "54E84843E0EEE275508F3EB8305B3F4F", hash_generated_method = "A4550C9DBC86F563186C86A212ADD5E3")
    public int getSize() {
        int varFE91D8EC738CF7D8BE7D802E3604E3B0_1822219359 = (this.size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1177252684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1177252684;
        // ---------- Original Method ----------
        //return this.size;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.188 -0400", hash_original_method = "51B72F61F828A2C6A4124D3A8929AD68", hash_generated_method = "23D3ED625D5A298FFD27AD21EDCD5C9F")
    public void addLast(Header header) throws SipException, NullPointerException {
        addTaint(header.getTaint());
        if(header == null)        
        {
        NullPointerException var46DC74EA01AD115A93A248B83CD80DF3_1816220061 = new NullPointerException("null arg!");
        var46DC74EA01AD115A93A248B83CD80DF3_1816220061.addTaint(taint);
        throw var46DC74EA01AD115A93A248B83CD80DF3_1816220061;
        }
        try 
        {
            this.attachHeader((SIPHeader) header, false, false);
        } //End block
        catch (SIPDuplicateHeaderException ex)
        {
            SipException var335A012BDA6C4ABF14A801F54E929ED8_1598654329 = new SipException("Cannot add header - header already exists");
            var335A012BDA6C4ABF14A801F54E929ED8_1598654329.addTaint(taint);
            throw var335A012BDA6C4ABF14A801F54E929ED8_1598654329;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.188 -0400", hash_original_method = "FB58DD3E1F3A0D99159750C09E15B568", hash_generated_method = "E030AA6296D0B50BE96B836D4283F7F3")
    public void addFirst(Header header) throws SipException, NullPointerException {
        addTaint(header.getTaint());
        if(header == null)        
        {
        NullPointerException var46DC74EA01AD115A93A248B83CD80DF3_618758195 = new NullPointerException("null arg!");
        var46DC74EA01AD115A93A248B83CD80DF3_618758195.addTaint(taint);
        throw var46DC74EA01AD115A93A248B83CD80DF3_618758195;
        }
        try 
        {
            this.attachHeader((SIPHeader) header, false, true);
        } //End block
        catch (SIPDuplicateHeaderException ex)
        {
            SipException var335A012BDA6C4ABF14A801F54E929ED8_633265375 = new SipException("Cannot add header - header already exists");
            var335A012BDA6C4ABF14A801F54E929ED8_633265375.addTaint(taint);
            throw var335A012BDA6C4ABF14A801F54E929ED8_633265375;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.189 -0400", hash_original_method = "F7D2F7162E4B2A1EDD2D78AF07F98ED3", hash_generated_method = "C4A8FE299C98CA756545CFAE1EA50392")
    public void removeFirst(String headerName) throws NullPointerException {
        addTaint(headerName.getTaint());
        if(headerName == null)        
        {
        NullPointerException var24FFA634E2767433C794670624BFD777_349012906 = new NullPointerException("Null argument Provided!");
        var24FFA634E2767433C794670624BFD777_349012906.addTaint(taint);
        throw var24FFA634E2767433C794670624BFD777_349012906;
        }
        this.removeHeader(headerName, true);
        // ---------- Original Method ----------
        //if (headerName == null)
            //throw new NullPointerException("Null argument Provided!");
        //this.removeHeader(headerName, true);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.189 -0400", hash_original_method = "B1A0AEB4CA388E0A9ED7E42FB6DA96D3", hash_generated_method = "AC8F2ABB7E7B8F23007EF4834470343A")
    public void removeLast(String headerName) {
        addTaint(headerName.getTaint());
        if(headerName == null)        
        {
        NullPointerException var24FFA634E2767433C794670624BFD777_934399670 = new NullPointerException("Null argument Provided!");
        var24FFA634E2767433C794670624BFD777_934399670.addTaint(taint);
        throw var24FFA634E2767433C794670624BFD777_934399670;
        }
        this.removeHeader(headerName, false);
        // ---------- Original Method ----------
        //if (headerName == null)
            //throw new NullPointerException("Null argument Provided!");
        //this.removeHeader(headerName, false);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.189 -0400", hash_original_method = "1B0E35DCABA77A6424B3D6172B19A4B7", hash_generated_method = "0766B39F8BB4941FEAF016E08ED531C4")
    public void setCSeq(CSeqHeader cseqHeader) {
        addTaint(cseqHeader.getTaint());
        this.setHeader(cseqHeader);
        // ---------- Original Method ----------
        //this.setHeader(cseqHeader);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.189 -0400", hash_original_method = "552E0456C33D24CD63C8EBCDAC1D019B", hash_generated_method = "E17DD994BC845C3BDBBD70ECC432242E")
    public void setApplicationData(Object applicationData) {
        this.applicationData = applicationData;
        // ---------- Original Method ----------
        //this.applicationData = applicationData;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.189 -0400", hash_original_method = "5F924FC61375970A4DC758380BEBFF0F", hash_generated_method = "854AA9FBB3748B5DBFB6AAB736B42870")
    public Object getApplicationData() {
Object varAC81821DD38AD6A8C7609D7C76D213BC_1570980918 =         this.applicationData;
        varAC81821DD38AD6A8C7609D7C76D213BC_1570980918.addTaint(taint);
        return varAC81821DD38AD6A8C7609D7C76D213BC_1570980918;
        // ---------- Original Method ----------
        //return this.applicationData;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.190 -0400", hash_original_method = "3FB4581572217B4D34EC8E3A9F62CA88", hash_generated_method = "BE63B9043704D5A632ECDF9346334E95")
    public MultipartMimeContent getMultipartMimeContent() throws ParseException {
        if(this.contentLengthHeader.getContentLength() == 0)        
        {
MultipartMimeContent var540C13E9E156B687226421B24F2DF178_2074581764 =             null;
            var540C13E9E156B687226421B24F2DF178_2074581764.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2074581764;
        } //End block
        MultipartMimeContentImpl retval = new MultipartMimeContentImpl(this
                .getContentTypeHeader());
        byte[] rawContent = getRawContent();
        try 
        {
            String body = new String( rawContent, getCharset() );
            retval.createContentList(body);
MultipartMimeContent varF9E19AD6135C970F387F77C6F3DE4477_1603656612 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_1603656612.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_1603656612;
        } //End block
        catch (UnsupportedEncodingException e)
        {
            InternalErrorHandler.handleException(e);
MultipartMimeContent var540C13E9E156B687226421B24F2DF178_1477137541 =             null;
            var540C13E9E156B687226421B24F2DF178_1477137541.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1477137541;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.190 -0400", hash_original_method = "6A8980AC46BDEC47E118DEA889F580E2", hash_generated_method = "389DFAEE621627CF5D568791A7FC95F9")
    public CallIdHeader getCallIdHeader() {
CallIdHeader var0A1A7D5AA74854841C64078E07B44310_1086447940 =         this.callIdHeader;
        var0A1A7D5AA74854841C64078E07B44310_1086447940.addTaint(taint);
        return var0A1A7D5AA74854841C64078E07B44310_1086447940;
        // ---------- Original Method ----------
        //return this.callIdHeader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.190 -0400", hash_original_method = "616E19996CDDFB660618161B80D5BB27", hash_generated_method = "2357EBD645CA27119FA0F1BB77CDE0A2")
    public FromHeader getFromHeader() {
FromHeader var72AF2DF6C5ECAD84AD712323E664F963_1901252988 =         this.fromHeader;
        var72AF2DF6C5ECAD84AD712323E664F963_1901252988.addTaint(taint);
        return var72AF2DF6C5ECAD84AD712323E664F963_1901252988;
        // ---------- Original Method ----------
        //return this.fromHeader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.193 -0400", hash_original_method = "9C43D5663CBD78C15545690BFB01C4BF", hash_generated_method = "89C170989A7EEB2BB15748DF8E3D0BF8")
    public ToHeader getToHeader() {
ToHeader varD91F8239BCF28C00671F0A5C73087FCE_714291110 =         this.toHeader;
        varD91F8239BCF28C00671F0A5C73087FCE_714291110.addTaint(taint);
        return varD91F8239BCF28C00671F0A5C73087FCE_714291110;
        // ---------- Original Method ----------
        //return this.toHeader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.193 -0400", hash_original_method = "FE98900B9C779953579B6764E7283FC2", hash_generated_method = "BFE1866D850660CD5F7F86833A0E4228")
    public ViaHeader getTopmostViaHeader() {
ViaHeader varFC1D9495E0A1F8DC30CB7DE024DD62C3_1759326580 =         this.getTopmostVia();
        varFC1D9495E0A1F8DC30CB7DE024DD62C3_1759326580.addTaint(taint);
        return varFC1D9495E0A1F8DC30CB7DE024DD62C3_1759326580;
        // ---------- Original Method ----------
        //return this.getTopmostVia();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.193 -0400", hash_original_method = "2CE1B7EDE28DB048E923E7FFD28A72BE", hash_generated_method = "68149CEE2E2F024480AD67D505525D36")
    public CSeqHeader getCSeqHeader() {
CSeqHeader varA6B6B804DB86DE21D039C99E75A063C6_1304013659 =         this.cSeqHeader;
        varA6B6B804DB86DE21D039C99E75A063C6_1304013659.addTaint(taint);
        return varA6B6B804DB86DE21D039C99E75A063C6_1304013659;
        // ---------- Original Method ----------
        //return this.cSeqHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.193 -0400", hash_original_method = "5D0D1F0E94EB86910B32FB17BCD97869", hash_generated_method = "CEF24CD18B0309C55C23788EA182D52D")
    protected final String getCharset() {
        ContentType ct = getContentTypeHeader();
        if(ct!=null)        
        {
            String c = ct.getCharset();
String varE6864545B2E37081CA5857286A98F47A_1537587344 =             c!=null ? c : contentEncodingCharset;
            varE6864545B2E37081CA5857286A98F47A_1537587344.addTaint(taint);
            return varE6864545B2E37081CA5857286A98F47A_1537587344;
        } //End block
        else
        {
String var1813311D7651DBE75E34FA9918664FA9_193110026 =         contentEncodingCharset;
        var1813311D7651DBE75E34FA9918664FA9_193110026.addTaint(taint);
        return var1813311D7651DBE75E34FA9918664FA9_193110026;
        }
        // ---------- Original Method ----------
        //ContentType ct = getContentTypeHeader();
        //if (ct!=null) {
    		//String c = ct.getCharset();
    		//return c!=null ? c : contentEncodingCharset;
    	//} else return contentEncodingCharset;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.193 -0400", hash_original_method = "F8575631397F30A77B6575B01C9E50F5", hash_generated_method = "E0156180DFB9C35C40944662FD2DF3F7")
    public boolean isNullRequest() {
        boolean var146ADE144DD4FFEF759B25BCE7E6ACB1_317350919 = (this.nullRequest);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_395511191 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_395511191;
        // ---------- Original Method ----------
        //return  this.nullRequest;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.194 -0400", hash_original_method = "76987385F34084CF4A8C6AA1CD858E63", hash_generated_method = "9270889C04904F8C78507597689FCBFB")
    public void setNullRequest() {
        this.nullRequest = true;
        // ---------- Original Method ----------
        //this.nullRequest = true;
    }

    
    public abstract void setSIPVersion(String sipVersion) throws ParseException;

    
    public abstract String getSIPVersion();

    
    public abstract String toString();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.197 -0400", hash_original_field = "75E2CD6B096F7C9EA9F441F09C141816", hash_generated_field = "3904126BA9BA221FEEB83EA7E49FDA36")

    private static final String CONTENT_TYPE_LOWERCASE = SIPHeaderNamesCache
    .toLowerCase(ContentTypeHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.197 -0400", hash_original_field = "29DF28A4B352F1941ADD2F1574849F4C", hash_generated_field = "2A8E8F0E3F29FFFF710437740FFE07B1")

    private static final String ERROR_LOWERCASE = SIPHeaderNamesCache.toLowerCase(ErrorInfo.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.197 -0400", hash_original_field = "1BA2C1C4DCDE1F624162F4131AAE2119", hash_generated_field = "3BB82B473CACCC793FC18D6F0CF9300E")

    private static final String CONTACT_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ContactHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.197 -0400", hash_original_field = "48FC9BF18DDD312165B5D66B273DFFB9", hash_generated_field = "51278ECFB8FC893D338CBD35C1B5F8F7")

    private static final String VIA_LOWERCASE = SIPHeaderNamesCache.toLowerCase(ViaHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.197 -0400", hash_original_field = "7412D18F37312CBCB0F4A06C575DDCDC", hash_generated_field = "F10B3CAD8FB507F5BDFF22A8AD4FFF13")

    private static final String AUTHORIZATION_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(AuthorizationHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.197 -0400", hash_original_field = "189EC181787A87BAA9A37498164BF033", hash_generated_field = "BE5A48849228660E6DA6589746E7D093")

    private static final String ROUTE_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(RouteHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.197 -0400", hash_original_field = "9C1ABF37105D0FE67D77A0E330DBA041", hash_generated_field = "0F29B176C2B3A3AA106F93F963532E79")

    private static final String RECORDROUTE_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(RecordRouteHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.197 -0400", hash_original_field = "684B374F6D97A99BC68D07DD28F9F302", hash_generated_field = "6AF602A3153F2C32B93DA6F98A935DA5")

    private static final String CONTENT_DISPOSITION_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ContentDispositionHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.197 -0400", hash_original_field = "E2D2A30A5E5BCE2B69AEF1546064737F", hash_generated_field = "6D27C3CBA91F0C290360A638D7DF519E")

    private static final String CONTENT_ENCODING_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ContentEncodingHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.197 -0400", hash_original_field = "2871455B28BED5523B66335711F93B13", hash_generated_field = "376511CEFEB33BD270D266CD58BF159F")

    private static final String CONTENT_LANGUAGE_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ContentLanguageHeader.NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.197 -0400", hash_original_field = "DC12CEF71CECD7CA0E5991B99573EE4A", hash_generated_field = "5C2E81EB8278F47B64608EF8A7BB04DF")

    private static final String EXPIRES_LOWERCASE = SIPHeaderNamesCache
            .toLowerCase(ExpiresHeader.NAME);
}

