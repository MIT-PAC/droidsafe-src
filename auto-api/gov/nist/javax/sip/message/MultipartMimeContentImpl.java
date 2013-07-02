package gov.nist.javax.sip.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.871 -0400", hash_original_field = "1405CE9A3C3312B897AB90A8EB46A75F", hash_generated_field = "FD0E7DDD1AF822BB0A779B8E067816D9")

    private List<Content> contentList = new LinkedList<Content>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.871 -0400", hash_original_field = "E5B9309EA09247F9D21AF6D605EAB11E", hash_generated_field = "CE73E72EF711E1E06248C7F0F370E9AA")

    private ContentTypeHeader multipartMimeContentTypeHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.871 -0400", hash_original_field = "81FD830C85363675EDB98D2879916D8C", hash_generated_field = "ED35814FA47AF2DBDA1D10B34E2A8ED6")

    private String boundary;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.871 -0400", hash_original_method = "2BDD067347267A613FC6CB4251D41452", hash_generated_method = "0FA7E4EBDBFC8D2D5E32009F85807634")
    public  MultipartMimeContentImpl(ContentTypeHeader contentTypeHeader) {
        this.multipartMimeContentTypeHeader = contentTypeHeader;
        this.boundary = contentTypeHeader.getParameter(BOUNDARY);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.871 -0400", hash_original_method = "B89677B4178E2DAF7E61A39544E04AE5", hash_generated_method = "20B5BE9E33992F83D4D8092A6FA5541D")
    public boolean add(Content content) {
        boolean varA68F685D0CC10459739E65FD0BF87C7D_519382280 = (contentList.add((ContentImpl) content));
        addTaint(content.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1174615571 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1174615571;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.872 -0400", hash_original_method = "4590DD0C77A768FED1E8ACE7CF0313E8", hash_generated_method = "B11A61E4DD0E2261A0627BFA5212E68A")
    public ContentTypeHeader getContentTypeHeader() {
        ContentTypeHeader varB4EAC82CA7396A68D541C85D26508E83_116858198 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_116858198 = multipartMimeContentTypeHeader;
        varB4EAC82CA7396A68D541C85D26508E83_116858198.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_116858198;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.876 -0400", hash_original_method = "1253C501D0F5CE66AF0270C83E3A62D6", hash_generated_method = "CC9BA702855130F429C4AE1815C16108")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_380236936 = null; 
        StringBuffer stringBuffer = new StringBuffer();
        {
            Iterator<Content> var6E413069D239ECC55CE8E2D17947347F_1760371584 = (this.contentList).iterator();
            var6E413069D239ECC55CE8E2D17947347F_1760371584.hasNext();
            Content content = var6E413069D239ECC55CE8E2D17947347F_1760371584.next();
            {
                stringBuffer.append(content.toString());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_380236936 = stringBuffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_380236936.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_380236936;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.898 -0400", hash_original_method = "968D057F7853F8246DB89EBE38C4B30E", hash_generated_method = "772B39E9A7DA43C686418A218ABBEC4C")
    public void createContentList(String body) throws ParseException {
        try 
        {
            HeaderFactoryExt headerFactory = new HeaderFactoryImpl();
            String delimiter = this.getContentTypeHeader().getParameter(BOUNDARY);
            {
                this.contentList = new LinkedList<Content>();
                ContentImpl content = new ContentImpl(body, delimiter);
                content.setContentTypeHeader(this.getContentTypeHeader());
                this.contentList.add(content);
            } 
            String[] fragments = body.split("--" + delimiter + "\r\n");
            {
                String nextPart = fragments[0];
                {
                    StringBuffer strbuf = new StringBuffer(nextPart);
                    {
                        boolean varF6B34452D9317EB430FD16C9EB750636_1210883093 = (strbuf.length() > 0
                        && (strbuf.charAt(0) == '\r' || strbuf.charAt(0) == '\n'));
                        strbuf.deleteCharAt(0);
                    } 
                    {
                        boolean var86EAD981F1663D4F8BE3173251430A52_1608303888 = (strbuf.length() == 0);
                    } 
                    nextPart = strbuf.toString();
                    int position = nextPart.indexOf("\r\n\r\n");
                    int off = 4;
                    {
                        position = nextPart.indexOf("\n");
                        off = 2;
                    } 
                    if (DroidSafeAndroidRuntime.control) throw new ParseException("no content type header found in " + nextPart, 0);
                    String rest = nextPart.substring(position + off);
                    if (DroidSafeAndroidRuntime.control) throw new ParseException("No content [" + nextPart + "]", 0);
                    String headers = nextPart.substring(0, position);
                    ContentImpl content = new ContentImpl(rest, boundary);
                    String[] headerArray = headers.split("\r\n");
                    {
                        String hdr = headerArray[0];
                        {
                            Header header = headerFactory.createHeader(hdr);
                            {
                                content.setContentTypeHeader((ContentTypeHeader) header);
                            } 
                            {
                                content.setContentDispositionHeader((ContentDispositionHeader) header);
                            } 
                            {
                                if (DroidSafeAndroidRuntime.control) throw new ParseException("Unexpected header type " + header.getName(), 0);
                            } 
                            contentList.add(content);
                        } 
                    } 
                } 
            } 
        } 
        catch (StringIndexOutOfBoundsException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException("Invalid Multipart mime format", 0);
        } 
        addTaint(body.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.903 -0400", hash_original_method = "3C7197D83A3DC33713AACEA2691D16BA", hash_generated_method = "4B0529C9913DE7515512EEB36929774A")
    public Content getContentByType(String contentType, String contentSubtype) {
        Content varB4EAC82CA7396A68D541C85D26508E83_1529035201 = null; 
        Content varB4EAC82CA7396A68D541C85D26508E83_1343674635 = null; 
        Content retval = null;
        varB4EAC82CA7396A68D541C85D26508E83_1529035201 = null;
        {
            Iterator<Content> varA98691AACA259DB31819633E0D4CADFB_90949096 = (contentList).iterator();
            varA98691AACA259DB31819633E0D4CADFB_90949096.hasNext();
            Content content = varA98691AACA259DB31819633E0D4CADFB_90949096.next();
            {
                {
                    boolean varA576A6C8757808F54C881C4105946187_173028693 = (content.getContentTypeHeader().getContentType().equalsIgnoreCase(contentType)
                    && content.getContentTypeHeader().getContentSubType().equalsIgnoreCase(
                            contentSubtype));
                    {
                        retval = content;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1343674635 = retval;
        addTaint(contentType.getTaint());
        addTaint(contentSubtype.getTaint());
        Content varA7E53CE21691AB073D9660D615818899_2035532650; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2035532650 = varB4EAC82CA7396A68D541C85D26508E83_1529035201;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2035532650 = varB4EAC82CA7396A68D541C85D26508E83_1343674635;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2035532650.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2035532650;
        
        
        
            
        
            
                    
                            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.903 -0400", hash_original_method = "5D236D4E42081CC93B2BC0976B6D3581", hash_generated_method = "61FDD4044E49C6BE51FF0776C167A96C")
    public void addContent(Content content) {
        this.add(content);
        addTaint(content.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.904 -0400", hash_original_method = "DFB35A5106E2AD2A9D629D81C13D382C", hash_generated_method = "A32DD3431E5FDC69EC0CD76139C571B0")
    public Iterator<Content> getContents() {
        Iterator<Content> varB4EAC82CA7396A68D541C85D26508E83_496433213 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_496433213 = this.contentList.iterator();
        varB4EAC82CA7396A68D541C85D26508E83_496433213.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_496433213;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.904 -0400", hash_original_method = "B0C4727628A80D66AB97702342F94FFA", hash_generated_method = "5F8C6B3850750FD4AB1BF39DC5626C7E")
    public int getContentCount() {
        int var48A67136D94FF8B65B3931EDBD6C7D85_1506599067 = (this.contentList.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1596783309 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1596783309;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.904 -0400", hash_original_field = "2F0EF796951D6A4B81B056A52B0C99F3", hash_generated_field = "9E4348587CD55FA4C6062879941EE6EC")

    public static String BOUNDARY = "boundary";
}

