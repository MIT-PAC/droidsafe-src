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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.815 -0400", hash_original_field = "1405CE9A3C3312B897AB90A8EB46A75F", hash_generated_field = "FD0E7DDD1AF822BB0A779B8E067816D9")

    private List<Content> contentList = new LinkedList<Content>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.815 -0400", hash_original_field = "E5B9309EA09247F9D21AF6D605EAB11E", hash_generated_field = "CE73E72EF711E1E06248C7F0F370E9AA")

    private ContentTypeHeader multipartMimeContentTypeHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.815 -0400", hash_original_field = "81FD830C85363675EDB98D2879916D8C", hash_generated_field = "ED35814FA47AF2DBDA1D10B34E2A8ED6")

    private String boundary;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.815 -0400", hash_original_method = "2BDD067347267A613FC6CB4251D41452", hash_generated_method = "0FA7E4EBDBFC8D2D5E32009F85807634")
    public  MultipartMimeContentImpl(ContentTypeHeader contentTypeHeader) {
        this.multipartMimeContentTypeHeader = contentTypeHeader;
        this.boundary = contentTypeHeader.getParameter(BOUNDARY);
        // ---------- Original Method ----------
        //this.multipartMimeContentTypeHeader = contentTypeHeader;
        //this.boundary = contentTypeHeader.getParameter(BOUNDARY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.821 -0400", hash_original_method = "B89677B4178E2DAF7E61A39544E04AE5", hash_generated_method = "99E5F18EE9281B30F3B48AD577D0EE29")
    public boolean add(Content content) {
        boolean varA68F685D0CC10459739E65FD0BF87C7D_1258906882 = (contentList.add((ContentImpl) content));
        addTaint(content.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2069302293 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2069302293;
        // ---------- Original Method ----------
        //return contentList.add((ContentImpl) content);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.822 -0400", hash_original_method = "4590DD0C77A768FED1E8ACE7CF0313E8", hash_generated_method = "5F38F9636D982FCB630409C159DA1F8E")
    public ContentTypeHeader getContentTypeHeader() {
        ContentTypeHeader varB4EAC82CA7396A68D541C85D26508E83_1223117929 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1223117929 = multipartMimeContentTypeHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1223117929.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1223117929;
        // ---------- Original Method ----------
        //return multipartMimeContentTypeHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.836 -0400", hash_original_method = "1253C501D0F5CE66AF0270C83E3A62D6", hash_generated_method = "EB00C302BC8910754CDE3E5D3CA430E4")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_186990898 = null; //Variable for return #1
        StringBuffer stringBuffer;
        stringBuffer = new StringBuffer();
        {
            Iterator<Content> var6E413069D239ECC55CE8E2D17947347F_457360564 = (this.contentList).iterator();
            var6E413069D239ECC55CE8E2D17947347F_457360564.hasNext();
            Content content = var6E413069D239ECC55CE8E2D17947347F_457360564.next();
            {
                stringBuffer.append(content.toString());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_186990898 = stringBuffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_186990898.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_186990898;
        // ---------- Original Method ----------
        //StringBuffer stringBuffer = new StringBuffer();
        //for (Content content : this.contentList) {
            //stringBuffer.append(content.toString());
        //}
        //return stringBuffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.084 -0400", hash_original_method = "968D057F7853F8246DB89EBE38C4B30E", hash_generated_method = "3B6640C61A43BF6DC6E24AE4BDA9A39E")
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
                        boolean varF6B34452D9317EB430FD16C9EB750636_1318337404 = (strbuf.length() > 0
                        && (strbuf.charAt(0) == '\r' || strbuf.charAt(0) == '\n'));
                        strbuf.deleteCharAt(0);
                    } //End collapsed parenthetic
                    {
                        boolean var86EAD981F1663D4F8BE3173251430A52_1015744355 = (strbuf.length() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.126 -0400", hash_original_method = "3C7197D83A3DC33713AACEA2691D16BA", hash_generated_method = "AE39114C99DC57BC6F08AEE88DD1A519")
    public Content getContentByType(String contentType, String contentSubtype) {
        Content varB4EAC82CA7396A68D541C85D26508E83_409644531 = null; //Variable for return #1
        Content varB4EAC82CA7396A68D541C85D26508E83_125595470 = null; //Variable for return #2
        Content retval;
        retval = null;
        varB4EAC82CA7396A68D541C85D26508E83_409644531 = null;
        {
            Iterator<Content> varA98691AACA259DB31819633E0D4CADFB_1272933173 = (contentList).iterator();
            varA98691AACA259DB31819633E0D4CADFB_1272933173.hasNext();
            Content content = varA98691AACA259DB31819633E0D4CADFB_1272933173.next();
            {
                {
                    boolean varA576A6C8757808F54C881C4105946187_1154904 = (content.getContentTypeHeader().getContentType().equalsIgnoreCase(contentType)
                    && content.getContentTypeHeader().getContentSubType().equalsIgnoreCase(
                            contentSubtype));
                    {
                        retval = content;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_125595470 = retval;
        addTaint(contentType.getTaint());
        addTaint(contentSubtype.getTaint());
        Content varA7E53CE21691AB073D9660D615818899_1572958405; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1572958405 = varB4EAC82CA7396A68D541C85D26508E83_409644531;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1572958405 = varB4EAC82CA7396A68D541C85D26508E83_125595470;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1572958405.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1572958405;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.127 -0400", hash_original_method = "5D236D4E42081CC93B2BC0976B6D3581", hash_generated_method = "61FDD4044E49C6BE51FF0776C167A96C")
    public void addContent(Content content) {
        this.add(content);
        addTaint(content.getTaint());
        // ---------- Original Method ----------
        //this.add(content);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.127 -0400", hash_original_method = "DFB35A5106E2AD2A9D629D81C13D382C", hash_generated_method = "099467EC5425F86A684F77A63E0418B0")
    public Iterator<Content> getContents() {
        Iterator<Content> varB4EAC82CA7396A68D541C85D26508E83_532069951 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_532069951 = this.contentList.iterator();
        varB4EAC82CA7396A68D541C85D26508E83_532069951.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_532069951;
        // ---------- Original Method ----------
        //return this.contentList.iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.128 -0400", hash_original_method = "B0C4727628A80D66AB97702342F94FFA", hash_generated_method = "D21EEE6D928D02E391BC1A0A667F8B44")
    public int getContentCount() {
        int var48A67136D94FF8B65B3931EDBD6C7D85_84302911 = (this.contentList.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842603984 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842603984;
        // ---------- Original Method ----------
        //return this.contentList.size();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.128 -0400", hash_original_field = "2F0EF796951D6A4B81B056A52B0C99F3", hash_generated_field = "9E4348587CD55FA4C6062879941EE6EC")

    public static String BOUNDARY = "boundary";
}

