package gov.nist.javax.sip.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ContentDispositionHeader;
import javax.sip.header.ContentTypeHeader;

public class ContentImpl implements Content {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.617 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "ACC0ED8FE681AE1F8700C32DE8F586D0")

    private Object content;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.617 -0400", hash_original_field = "81FD830C85363675EDB98D2879916D8C", hash_generated_field = "ED35814FA47AF2DBDA1D10B34E2A8ED6")

    private String boundary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.618 -0400", hash_original_field = "FB0BB5CDAA2DA15343996268C7C83C28", hash_generated_field = "386022F5483C72B1DB3C8AA8A89EDC5E")

    private ContentTypeHeader contentTypeHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.618 -0400", hash_original_field = "033C11C30B4138BEFC9D799FFCF0239D", hash_generated_field = "97D8B5913638678D3ACBF7B6AE57F828")

    private ContentDispositionHeader contentDispositionHeader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.618 -0400", hash_original_method = "BFB297926685FC1F358C134CE06B2B50", hash_generated_method = "830F598434B90B9D84711FB0ED686CDB")
    public  ContentImpl( String content, String boundary ) {
        this.content = content;
        this.boundary = boundary;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.618 -0400", hash_original_method = "AC1A4D9E7F01819C7360E12D70B398EB", hash_generated_method = "62E9489CB1A97725F62EAECCA3AE3630")
    public void setContent(Object content) {
        this.content = content;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.619 -0400", hash_original_method = "F9A2B83B00823C4E5AAD796119B409F3", hash_generated_method = "3480DD208511B96C390483183CFDA03C")
    public ContentTypeHeader getContentTypeHeader() {
        ContentTypeHeader varB4EAC82CA7396A68D541C85D26508E83_1449695506 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1449695506 = contentTypeHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1449695506.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1449695506;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.619 -0400", hash_original_method = "29FF4E0F65DE2DF21CD886ED55A6EE33", hash_generated_method = "2DA9AFAD49587B8AF6E5F7BE2F517C8F")
    public Object getContent() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1192920590 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1192920590 = this.content;
        varB4EAC82CA7396A68D541C85D26508E83_1192920590.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1192920590;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.620 -0400", hash_original_method = "F6C29ED2FF7A16DDC103A61DA5684884", hash_generated_method = "63012B5E452921BA677D712B0DA6C262")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1823454694 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_665533273 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1316786187 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1823454694 = content.toString();
        } 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_665533273 = "--" + boundary + "\r\n" + getContentTypeHeader() + 
                    this.getContentDispositionHeader().toString() + "\r\n"
                    + content.toString();
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1316786187 = "--" + boundary + "\r\n" + getContentTypeHeader() + "\r\n" +  content.toString();
            } 
        } 
        String varA7E53CE21691AB073D9660D615818899_1608826841; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1608826841 = varB4EAC82CA7396A68D541C85D26508E83_1823454694;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1608826841 = varB4EAC82CA7396A68D541C85D26508E83_665533273;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1608826841 = varB4EAC82CA7396A68D541C85D26508E83_1316786187;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1608826841.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1608826841;
        
        
            
        
           
            
                    
                    
           
               
           
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.620 -0400", hash_original_method = "A92668968F751E368038351A92419F09", hash_generated_method = "40CCBC8DEE7734D4E6DB8D46E7E773A4")
    public void setContentDispositionHeader(ContentDispositionHeader contentDispositionHeader) {
        this.contentDispositionHeader = contentDispositionHeader;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.621 -0400", hash_original_method = "5BF192DF8194E4DCDCE4203B3764CB73", hash_generated_method = "5983099A2EC5A2605FEB547088E32D2A")
    public ContentDispositionHeader getContentDispositionHeader() {
        ContentDispositionHeader varB4EAC82CA7396A68D541C85D26508E83_1908874335 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1908874335 = contentDispositionHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1908874335.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1908874335;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.621 -0400", hash_original_method = "F204171925CED35F8176E327AB67DEA9", hash_generated_method = "5D04E291BFBB988E3B375A1F60C5A2D0")
    public void setContentTypeHeader(ContentTypeHeader contentTypeHeader) {
        this.contentTypeHeader = contentTypeHeader;
        
        
    }

    
}

