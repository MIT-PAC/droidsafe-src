package gov.nist.javax.sip.message;

// Droidsafe Imports
import gov.nist.javax.sip.header.HeaderFactoryExt;
import gov.nist.javax.sip.header.HeaderFactoryImpl;

import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.sip.header.ContentDispositionHeader;
import javax.sip.header.ContentTypeHeader;
import javax.sip.header.Header;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class MultipartMimeContentImpl implements MultipartMimeContent {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.880 -0400", hash_original_field = "1405CE9A3C3312B897AB90A8EB46A75F", hash_generated_field = "FD0E7DDD1AF822BB0A779B8E067816D9")

    private List<Content> contentList = new LinkedList<Content>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.880 -0400", hash_original_field = "E5B9309EA09247F9D21AF6D605EAB11E", hash_generated_field = "CE73E72EF711E1E06248C7F0F370E9AA")

    private ContentTypeHeader multipartMimeContentTypeHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.880 -0400", hash_original_field = "81FD830C85363675EDB98D2879916D8C", hash_generated_field = "ED35814FA47AF2DBDA1D10B34E2A8ED6")

    private String boundary;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.881 -0400", hash_original_method = "2BDD067347267A613FC6CB4251D41452", hash_generated_method = "0FA7E4EBDBFC8D2D5E32009F85807634")
    public  MultipartMimeContentImpl(ContentTypeHeader contentTypeHeader) {
        this.multipartMimeContentTypeHeader = contentTypeHeader;
        this.boundary = contentTypeHeader.getParameter(BOUNDARY);
        // ---------- Original Method ----------
        //this.multipartMimeContentTypeHeader = contentTypeHeader;
        //this.boundary = contentTypeHeader.getParameter(BOUNDARY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.881 -0400", hash_original_method = "B89677B4178E2DAF7E61A39544E04AE5", hash_generated_method = "7B6379D35A945CDE3B12CC9C7727578D")
    public boolean add(Content content) {
        addTaint(content.getTaint());
        boolean var008040580DEC4A70AAD8694F2220AB74_98859460 = (contentList.add((ContentImpl) content));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_27624878 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_27624878;
        // ---------- Original Method ----------
        //return contentList.add((ContentImpl) content);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.881 -0400", hash_original_method = "4590DD0C77A768FED1E8ACE7CF0313E8", hash_generated_method = "E59912D7185FEFE0161EF0A377C7E050")
    public ContentTypeHeader getContentTypeHeader() {
ContentTypeHeader varB0AA2702CAE096DD9EF25111BD0D4CE0_2047193931 =         multipartMimeContentTypeHeader;
        varB0AA2702CAE096DD9EF25111BD0D4CE0_2047193931.addTaint(taint);
        return varB0AA2702CAE096DD9EF25111BD0D4CE0_2047193931;
        // ---------- Original Method ----------
        //return multipartMimeContentTypeHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.882 -0400", hash_original_method = "1253C501D0F5CE66AF0270C83E3A62D6", hash_generated_method = "3E72B18EE96F69D962953A99134C8B19")
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
for(Content content : this.contentList)
        {
            stringBuffer.append(content.toString());
        } //End block
String varAF2C4DDBAB4CE8345BFD016271B18ED0_1927642939 =         stringBuffer.toString();
        varAF2C4DDBAB4CE8345BFD016271B18ED0_1927642939.addTaint(taint);
        return varAF2C4DDBAB4CE8345BFD016271B18ED0_1927642939;
        // ---------- Original Method ----------
        //StringBuffer stringBuffer = new StringBuffer();
        //for (Content content : this.contentList) {
            //stringBuffer.append(content.toString());
        //}
        //return stringBuffer.toString();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.885 -0400", hash_original_method = "968D057F7853F8246DB89EBE38C4B30E", hash_generated_method = "8E62AAF4F9C8A46932A9DEFEACE297B8")
    public void createContentList(String body) throws ParseException {
        addTaint(body.getTaint());
        try 
        {
            HeaderFactoryExt headerFactory = new HeaderFactoryImpl();
            String delimiter = this.getContentTypeHeader().getParameter(BOUNDARY);
            if(delimiter == null)            
            {
                this.contentList = new LinkedList<Content>();
                ContentImpl content = new ContentImpl(body, delimiter);
                content.setContentTypeHeader(this.getContentTypeHeader());
                this.contentList.add(content);
                return;
            } //End block
            String[] fragments = body.split("--" + delimiter + "\r\n");
for(String nextPart : fragments)
            {
                if(nextPart == null)                
                {
                    return;
                } //End block
                StringBuffer strbuf = new StringBuffer(nextPart);
                while
(strbuf.length() > 0
                        && (strbuf.charAt(0) == '\r' || strbuf.charAt(0) == '\n'))                
                strbuf.deleteCharAt(0);
                if(strbuf.length() == 0)                
                continue;
                nextPart = strbuf.toString();
                int position = nextPart.indexOf("\r\n\r\n");
                int off = 4;
                if(position == -1)                
                {
                    position = nextPart.indexOf("\n");
                    off = 2;
                } //End block
                if(position == -1)                
                {
                ParseException var4EEEC391A6F6CE8B3ECCA7A616B8304F_1594467372 = new ParseException("no content type header found in " + nextPart, 0);
                var4EEEC391A6F6CE8B3ECCA7A616B8304F_1594467372.addTaint(taint);
                throw var4EEEC391A6F6CE8B3ECCA7A616B8304F_1594467372;
                }
                String rest = nextPart.substring(position + off);
                if(rest == null)                
                {
                ParseException var16234AA9E30E01C37738174550CA354C_457630373 = new ParseException("No content [" + nextPart + "]", 0);
                var16234AA9E30E01C37738174550CA354C_457630373.addTaint(taint);
                throw var16234AA9E30E01C37738174550CA354C_457630373;
                }
                String headers = nextPart.substring(0, position);
                ContentImpl content = new ContentImpl(rest, boundary);
                String[] headerArray = headers.split("\r\n");
for(String hdr : headerArray)
                {
                    Header header = headerFactory.createHeader(hdr);
                    if(header instanceof ContentTypeHeader)                    
                    {
                        content.setContentTypeHeader((ContentTypeHeader) header);
                    } //End block
                    else
                    if(header instanceof ContentDispositionHeader)                    
                    {
                        content.setContentDispositionHeader((ContentDispositionHeader) header);
                    } //End block
                    else
                    {
                        ParseException var533A03E41F65A189FCB9F0D4FEAD24DB_1413061853 = new ParseException("Unexpected header type " + header.getName(), 0);
                        var533A03E41F65A189FCB9F0D4FEAD24DB_1413061853.addTaint(taint);
                        throw var533A03E41F65A189FCB9F0D4FEAD24DB_1413061853;
                    } //End block
                    contentList.add(content);
                } //End block
            } //End block
        } //End block
        catch (StringIndexOutOfBoundsException ex)
        {
            ParseException var6C204A8A75769374AA63FAA548D3EB60_709122820 = new ParseException("Invalid Multipart mime format", 0);
            var6C204A8A75769374AA63FAA548D3EB60_709122820.addTaint(taint);
            throw var6C204A8A75769374AA63FAA548D3EB60_709122820;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.887 -0400", hash_original_method = "3C7197D83A3DC33713AACEA2691D16BA", hash_generated_method = "503BB45EBC3C3CB8E6F8666198A5D22A")
    public Content getContentByType(String contentType, String contentSubtype) {
        addTaint(contentSubtype.getTaint());
        addTaint(contentType.getTaint());
        Content retval = null;
        if(contentList == null)        
        {
Content var540C13E9E156B687226421B24F2DF178_624234801 =         null;
        var540C13E9E156B687226421B24F2DF178_624234801.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_624234801;
        }
for(Content content : contentList)
        {
            if(content.getContentTypeHeader().getContentType().equalsIgnoreCase(contentType)
                    && content.getContentTypeHeader().getContentSubType().equalsIgnoreCase(
                            contentSubtype))            
            {
                retval = content;
                break;
            } //End block
        } //End block
Content varF9E19AD6135C970F387F77C6F3DE4477_1932803780 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1932803780.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1932803780;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.888 -0400", hash_original_method = "5D236D4E42081CC93B2BC0976B6D3581", hash_generated_method = "A4D9F85A9E9AE541CFEEA8C1C43E1EBE")
    public void addContent(Content content) {
        addTaint(content.getTaint());
        this.add(content);
        // ---------- Original Method ----------
        //this.add(content);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.888 -0400", hash_original_method = "DFB35A5106E2AD2A9D629D81C13D382C", hash_generated_method = "CFD1F6AEEF1079E0BA95C30D92B5AAC6")
    public Iterator<Content> getContents() {
Iterator<Content> var78005D39F9311C6A323E697692687A79_467180609 =         this.contentList.iterator();
        var78005D39F9311C6A323E697692687A79_467180609.addTaint(taint);
        return var78005D39F9311C6A323E697692687A79_467180609;
        // ---------- Original Method ----------
        //return this.contentList.iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.889 -0400", hash_original_method = "B0C4727628A80D66AB97702342F94FFA", hash_generated_method = "30D7F7AD6BCA95F8A2372E6E3D61A63F")
    public int getContentCount() {
        int var793568623107BB2DF4FE5C24C7E1A820_540337492 = (this.contentList.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_387856829 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_387856829;
        // ---------- Original Method ----------
        //return this.contentList.size();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.889 -0400", hash_original_field = "2F0EF796951D6A4B81B056A52B0C99F3", hash_generated_field = "9E4348587CD55FA4C6062879941EE6EC")

    public static String BOUNDARY = "boundary";
}

