package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.HeaderFactoryExt;
import gov.nist.javax.sip.header.HeaderFactoryImpl;
import gov.nist.javax.sip.parser.StringMsgParser;
import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.sip.header.ContentDispositionHeader;
import javax.sip.header.ContentTypeHeader;
import javax.sip.header.Header;
import javax.sip.header.HeaderFactory;
import javax.sip.message.Message;

public class MultipartMimeContentImpl implements MultipartMimeContent {
    private List<Content> contentList = new LinkedList<Content>();
    private ContentTypeHeader multipartMimeContentTypeHeader;
    private String boundary;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.847 -0400", hash_original_method = "2BDD067347267A613FC6CB4251D41452", hash_generated_method = "22D73382FF87A13636C08CFCAA49FF98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MultipartMimeContentImpl(ContentTypeHeader contentTypeHeader) {
        dsTaint.addTaint(contentTypeHeader.dsTaint);
        this.boundary = contentTypeHeader.getParameter(BOUNDARY);
        // ---------- Original Method ----------
        //this.multipartMimeContentTypeHeader = contentTypeHeader;
        //this.boundary = contentTypeHeader.getParameter(BOUNDARY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.847 -0400", hash_original_method = "B89677B4178E2DAF7E61A39544E04AE5", hash_generated_method = "003007E722D6DD2ADEFC5917D288B63B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean add(Content content) {
        dsTaint.addTaint(content.dsTaint);
        boolean varA68F685D0CC10459739E65FD0BF87C7D_493504041 = (contentList.add((ContentImpl) content));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return contentList.add((ContentImpl) content);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.847 -0400", hash_original_method = "4590DD0C77A768FED1E8ACE7CF0313E8", hash_generated_method = "D2DD55D603A8E4CAB9A8C034CDA97549")
    @DSModeled(DSC.SAFE)
    public ContentTypeHeader getContentTypeHeader() {
        return (ContentTypeHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return multipartMimeContentTypeHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.849 -0400", hash_original_method = "1253C501D0F5CE66AF0270C83E3A62D6", hash_generated_method = "B3E52F003768620BC462F7D54733C73F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuffer stringBuffer;
        stringBuffer = new StringBuffer();
        {
            Iterator<Content> var6E413069D239ECC55CE8E2D17947347F_832808297 = (this.contentList).iterator();
            var6E413069D239ECC55CE8E2D17947347F_832808297.hasNext();
            Content content = var6E413069D239ECC55CE8E2D17947347F_832808297.next();
            {
                stringBuffer.append(content.toString());
            } //End block
        } //End collapsed parenthetic
        String varDA81C9F07CC59CC4C40534A05D59CCBA_58820003 = (stringBuffer.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer stringBuffer = new StringBuffer();
        //for (Content content : this.contentList) {
            //stringBuffer.append(content.toString());
        //}
        //return stringBuffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.874 -0400", hash_original_method = "968D057F7853F8246DB89EBE38C4B30E", hash_generated_method = "20A0A7CFB006E78E3AD1F183AAB6BCD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void createContentList(String body) throws ParseException {
        dsTaint.addTaint(body);
        try 
        {
            HeaderFactoryExt headerFactory;
            headerFactory = new HeaderFactoryImpl();
            String delimiter;
            delimiter = this.getContentTypeHeader().getParameter(BOUNDARY);
            {
                this.contentList = new LinkedList<Content>();
                ContentImpl content;
                content = new ContentImpl(body, delimiter);
                content.setContentTypeHeader(this.getContentTypeHeader());
                this.contentList.add(content);
            } //End block
            String[] fragments;
            fragments = body.split("--" + delimiter + "\r\n");
            {
                String nextPart = fragments[0];
                {
                    StringBuffer strbuf;
                    strbuf = new StringBuffer(nextPart);
                    {
                        boolean varF6B34452D9317EB430FD16C9EB750636_73554541 = (strbuf.length() > 0
                        && (strbuf.charAt(0) == '\r' || strbuf.charAt(0) == '\n'));
                        strbuf.deleteCharAt(0);
                    } //End collapsed parenthetic
                    {
                        boolean var86EAD981F1663D4F8BE3173251430A52_1355213005 = (strbuf.length() == 0);
                    } //End collapsed parenthetic
                    nextPart = strbuf.toString();
                    int position;
                    position = nextPart.indexOf("\r\n\r\n");
                    int off;
                    off = 4;
                    {
                        position = nextPart.indexOf("\n");
                        off = 2;
                    } //End block
                    if (DroidSafeAndroidRuntime.control) throw new ParseException("no content type header found in " + nextPart, 0);
                    String rest;
                    rest = nextPart.substring(position + off);
                    if (DroidSafeAndroidRuntime.control) throw new ParseException("No content [" + nextPart + "]", 0);
                    String headers;
                    headers = nextPart.substring(0, position);
                    ContentImpl content;
                    content = new ContentImpl(rest, boundary);
                    String[] headerArray;
                    headerArray = headers.split("\r\n");
                    {
                        String hdr = headerArray[0];
                        {
                            Header header;
                            header = headerFactory.createHeader(hdr);
                            {
                                content.setContentTypeHeader((ContentTypeHeader) header);
                            } //End block
                            {
                                content.setContentDispositionHeader((ContentDispositionHeader) header);
                            } //End block
                            {
                                if (DroidSafeAndroidRuntime.control) throw new ParseException("Unexpected header type " + header.getName(), 0);
                            } //End block
                            contentList.add(content);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (StringIndexOutOfBoundsException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException("Invalid Multipart mime format", 0);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.877 -0400", hash_original_method = "3C7197D83A3DC33713AACEA2691D16BA", hash_generated_method = "2BA5BF683C4F1D1537C8F3F874092933")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Content getContentByType(String contentType, String contentSubtype) {
        dsTaint.addTaint(contentType);
        dsTaint.addTaint(contentSubtype);
        Content retval;
        retval = null;
        {
            Iterator<Content> varA98691AACA259DB31819633E0D4CADFB_44004028 = (contentList).iterator();
            varA98691AACA259DB31819633E0D4CADFB_44004028.hasNext();
            Content content = varA98691AACA259DB31819633E0D4CADFB_44004028.next();
            {
                {
                    boolean varA576A6C8757808F54C881C4105946187_1480452792 = (content.getContentTypeHeader().getContentType().equalsIgnoreCase(contentType)
                    && content.getContentTypeHeader().getContentSubType().equalsIgnoreCase(
                            contentSubtype));
                    {
                        retval = content;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (Content)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Content retval = null;
        //if (contentList == null)
            //return null;
        //for (Content content : contentList) {
            //if (content.getContentTypeHeader().getContentType().equalsIgnoreCase(contentType)
                    //&& content.getContentTypeHeader().getContentSubType().equalsIgnoreCase(
                            //contentSubtype)) {
                //retval = content;
                //break;
            //}
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.877 -0400", hash_original_method = "5D236D4E42081CC93B2BC0976B6D3581", hash_generated_method = "E4452FE18C12950A573BA94055DA7649")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addContent(Content content) {
        dsTaint.addTaint(content.dsTaint);
        this.add(content);
        // ---------- Original Method ----------
        //this.add(content);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.877 -0400", hash_original_method = "DFB35A5106E2AD2A9D629D81C13D382C", hash_generated_method = "595F63E1AD3379A1C7FA9D46C89E2AD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<Content> getContents() {
        Iterator<Content> varC3B15954D445CEE3C992E42758EF8307_1073256971 = (this.contentList.iterator());
        return (Iterator<Content>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.contentList.iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.877 -0400", hash_original_method = "B0C4727628A80D66AB97702342F94FFA", hash_generated_method = "A073845C3C5E303329FC3C2D494EFB44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getContentCount() {
        int var48A67136D94FF8B65B3931EDBD6C7D85_494687146 = (this.contentList.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.contentList.size();
    }

    
    public static String BOUNDARY = "boundary";
}

