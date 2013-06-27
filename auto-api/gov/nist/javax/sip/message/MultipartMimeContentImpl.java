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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.617 -0400", hash_original_field = "1405CE9A3C3312B897AB90A8EB46A75F", hash_generated_field = "FD0E7DDD1AF822BB0A779B8E067816D9")

    private List<Content> contentList = new LinkedList<Content>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.618 -0400", hash_original_field = "E5B9309EA09247F9D21AF6D605EAB11E", hash_generated_field = "CE73E72EF711E1E06248C7F0F370E9AA")

    private ContentTypeHeader multipartMimeContentTypeHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.618 -0400", hash_original_field = "81FD830C85363675EDB98D2879916D8C", hash_generated_field = "ED35814FA47AF2DBDA1D10B34E2A8ED6")

    private String boundary;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.618 -0400", hash_original_method = "2BDD067347267A613FC6CB4251D41452", hash_generated_method = "0FA7E4EBDBFC8D2D5E32009F85807634")
    public  MultipartMimeContentImpl(ContentTypeHeader contentTypeHeader) {
        this.multipartMimeContentTypeHeader = contentTypeHeader;
        this.boundary = contentTypeHeader.getParameter(BOUNDARY);
        // ---------- Original Method ----------
        //this.multipartMimeContentTypeHeader = contentTypeHeader;
        //this.boundary = contentTypeHeader.getParameter(BOUNDARY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.632 -0400", hash_original_method = "B89677B4178E2DAF7E61A39544E04AE5", hash_generated_method = "65417FE435FA0A35E4FB71EF201A600D")
    public boolean add(Content content) {
        boolean varA68F685D0CC10459739E65FD0BF87C7D_358143632 = (contentList.add((ContentImpl) content));
        addTaint(content.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1815788904 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1815788904;
        // ---------- Original Method ----------
        //return contentList.add((ContentImpl) content);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.634 -0400", hash_original_method = "4590DD0C77A768FED1E8ACE7CF0313E8", hash_generated_method = "64B569E6930546F525DF1367AB818676")
    public ContentTypeHeader getContentTypeHeader() {
        ContentTypeHeader varB4EAC82CA7396A68D541C85D26508E83_187473806 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_187473806 = multipartMimeContentTypeHeader;
        varB4EAC82CA7396A68D541C85D26508E83_187473806.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_187473806;
        // ---------- Original Method ----------
        //return multipartMimeContentTypeHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.681 -0400", hash_original_method = "1253C501D0F5CE66AF0270C83E3A62D6", hash_generated_method = "143CAD14DF329D4856494D3B1FD2FCD4")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_908435391 = null; //Variable for return #1
        StringBuffer stringBuffer;
        stringBuffer = new StringBuffer();
        {
            Iterator<Content> var6E413069D239ECC55CE8E2D17947347F_1941941377 = (this.contentList).iterator();
            var6E413069D239ECC55CE8E2D17947347F_1941941377.hasNext();
            Content content = var6E413069D239ECC55CE8E2D17947347F_1941941377.next();
            {
                stringBuffer.append(content.toString());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_908435391 = stringBuffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_908435391.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_908435391;
        // ---------- Original Method ----------
        //StringBuffer stringBuffer = new StringBuffer();
        //for (Content content : this.contentList) {
            //stringBuffer.append(content.toString());
        //}
        //return stringBuffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.964 -0400", hash_original_method = "968D057F7853F8246DB89EBE38C4B30E", hash_generated_method = "1C11650D27D94A4BBEE1F2058A7E5762")
    public void createContentList(String body) throws ParseException {
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
                        boolean varF6B34452D9317EB430FD16C9EB750636_397040158 = (strbuf.length() > 0
                        && (strbuf.charAt(0) == '\r' || strbuf.charAt(0) == '\n'));
                        strbuf.deleteCharAt(0);
                    } //End collapsed parenthetic
                    {
                        boolean var86EAD981F1663D4F8BE3173251430A52_1788164021 = (strbuf.length() == 0);
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
        addTaint(body.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.008 -0400", hash_original_method = "3C7197D83A3DC33713AACEA2691D16BA", hash_generated_method = "A66F56546CAD8ACF98AD1CBE761F79F2")
    public Content getContentByType(String contentType, String contentSubtype) {
        Content varB4EAC82CA7396A68D541C85D26508E83_1512957067 = null; //Variable for return #1
        Content varB4EAC82CA7396A68D541C85D26508E83_172284676 = null; //Variable for return #2
        Content retval;
        retval = null;
        varB4EAC82CA7396A68D541C85D26508E83_1512957067 = null;
        {
            Iterator<Content> varA98691AACA259DB31819633E0D4CADFB_893501465 = (contentList).iterator();
            varA98691AACA259DB31819633E0D4CADFB_893501465.hasNext();
            Content content = varA98691AACA259DB31819633E0D4CADFB_893501465.next();
            {
                {
                    boolean varA576A6C8757808F54C881C4105946187_567307995 = (content.getContentTypeHeader().getContentType().equalsIgnoreCase(contentType)
                    && content.getContentTypeHeader().getContentSubType().equalsIgnoreCase(
                            contentSubtype));
                    {
                        retval = content;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_172284676 = retval;
        addTaint(contentType.getTaint());
        addTaint(contentSubtype.getTaint());
        Content varA7E53CE21691AB073D9660D615818899_1293325384; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1293325384 = varB4EAC82CA7396A68D541C85D26508E83_1512957067;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1293325384 = varB4EAC82CA7396A68D541C85D26508E83_172284676;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1293325384.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1293325384;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.018 -0400", hash_original_method = "5D236D4E42081CC93B2BC0976B6D3581", hash_generated_method = "61FDD4044E49C6BE51FF0776C167A96C")
    public void addContent(Content content) {
        this.add(content);
        addTaint(content.getTaint());
        // ---------- Original Method ----------
        //this.add(content);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.019 -0400", hash_original_method = "DFB35A5106E2AD2A9D629D81C13D382C", hash_generated_method = "82D17B26BDDE315B513C7F676AEB3CFC")
    public Iterator<Content> getContents() {
        Iterator<Content> varB4EAC82CA7396A68D541C85D26508E83_1165680129 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1165680129 = this.contentList.iterator();
        varB4EAC82CA7396A68D541C85D26508E83_1165680129.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1165680129;
        // ---------- Original Method ----------
        //return this.contentList.iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.019 -0400", hash_original_method = "B0C4727628A80D66AB97702342F94FFA", hash_generated_method = "6A3A1C164CF601AE190F4E0823924E0B")
    public int getContentCount() {
        int var48A67136D94FF8B65B3931EDBD6C7D85_1926074530 = (this.contentList.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_152592779 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_152592779;
        // ---------- Original Method ----------
        //return this.contentList.size();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.019 -0400", hash_original_field = "2F0EF796951D6A4B81B056A52B0C99F3", hash_generated_field = "9E4348587CD55FA4C6062879941EE6EC")

    public static String BOUNDARY = "boundary";
}

