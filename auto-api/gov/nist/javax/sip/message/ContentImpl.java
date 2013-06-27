package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ContentDispositionHeader;
import javax.sip.header.ContentTypeHeader;

public class ContentImpl implements Content {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.537 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "ACC0ED8FE681AE1F8700C32DE8F586D0")

    private Object content;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.537 -0400", hash_original_field = "81FD830C85363675EDB98D2879916D8C", hash_generated_field = "ED35814FA47AF2DBDA1D10B34E2A8ED6")

    private String boundary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.537 -0400", hash_original_field = "FB0BB5CDAA2DA15343996268C7C83C28", hash_generated_field = "386022F5483C72B1DB3C8AA8A89EDC5E")

    private ContentTypeHeader contentTypeHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.537 -0400", hash_original_field = "033C11C30B4138BEFC9D799FFCF0239D", hash_generated_field = "97D8B5913638678D3ACBF7B6AE57F828")

    private ContentDispositionHeader contentDispositionHeader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.556 -0400", hash_original_method = "BFB297926685FC1F358C134CE06B2B50", hash_generated_method = "830F598434B90B9D84711FB0ED686CDB")
    public  ContentImpl( String content, String boundary ) {
        this.content = content;
        this.boundary = boundary;
        // ---------- Original Method ----------
        //this.content = content;
        //this.boundary = boundary;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.556 -0400", hash_original_method = "AC1A4D9E7F01819C7360E12D70B398EB", hash_generated_method = "62E9489CB1A97725F62EAECCA3AE3630")
    public void setContent(Object content) {
        this.content = content;
        // ---------- Original Method ----------
        //this.content = content;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.557 -0400", hash_original_method = "F9A2B83B00823C4E5AAD796119B409F3", hash_generated_method = "95DD7A1066B4F5B9A0E7BDCE3C630AEC")
    public ContentTypeHeader getContentTypeHeader() {
        ContentTypeHeader varB4EAC82CA7396A68D541C85D26508E83_1183060169 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1183060169 = contentTypeHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1183060169.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1183060169;
        // ---------- Original Method ----------
        //return contentTypeHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.557 -0400", hash_original_method = "29FF4E0F65DE2DF21CD886ED55A6EE33", hash_generated_method = "606FD5573C8CBBDC99C658D40B39EDDF")
    public Object getContent() {
        Object varB4EAC82CA7396A68D541C85D26508E83_729337617 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_729337617 = this.content;
        varB4EAC82CA7396A68D541C85D26508E83_729337617.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_729337617;
        // ---------- Original Method ----------
        //return this.content;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.558 -0400", hash_original_method = "F6C29ED2FF7A16DDC103A61DA5684884", hash_generated_method = "7C7646A3F7DC90E8E07291E90EC94D23")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_764297260 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1040073092 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1726417847 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_764297260 = content.toString();
        } //End block
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1040073092 = "--" + boundary + "\r\n" + getContentTypeHeader() + 
                    this.getContentDispositionHeader().toString() + "\r\n"
                    + content.toString();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1726417847 = "--" + boundary + "\r\n" + getContentTypeHeader() + "\r\n" +  content.toString();
            } //End block
        } //End block
        String varA7E53CE21691AB073D9660D615818899_687044976; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_687044976 = varB4EAC82CA7396A68D541C85D26508E83_764297260;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_687044976 = varB4EAC82CA7396A68D541C85D26508E83_1040073092;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_687044976 = varB4EAC82CA7396A68D541C85D26508E83_1726417847;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_687044976.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_687044976;
        // ---------- Original Method ----------
        //if (boundary == null) {
            //return content.toString();
        //} else {
           //if ( this.contentDispositionHeader != null ) {
            //return "--" + boundary + "\r\n" + getContentTypeHeader() + 
                    //this.getContentDispositionHeader().toString() + "\r\n"
                    //+ content.toString();
           //} else {
               //return "--" + boundary + "\r\n" + getContentTypeHeader() + "\r\n" +  content.toString();
           //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.573 -0400", hash_original_method = "A92668968F751E368038351A92419F09", hash_generated_method = "40CCBC8DEE7734D4E6DB8D46E7E773A4")
    public void setContentDispositionHeader(ContentDispositionHeader contentDispositionHeader) {
        this.contentDispositionHeader = contentDispositionHeader;
        // ---------- Original Method ----------
        //this.contentDispositionHeader = contentDispositionHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.574 -0400", hash_original_method = "5BF192DF8194E4DCDCE4203B3764CB73", hash_generated_method = "49C503CABF5277B200E435D9A199A0EC")
    public ContentDispositionHeader getContentDispositionHeader() {
        ContentDispositionHeader varB4EAC82CA7396A68D541C85D26508E83_1987735907 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1987735907 = contentDispositionHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1987735907.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1987735907;
        // ---------- Original Method ----------
        //return contentDispositionHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.574 -0400", hash_original_method = "F204171925CED35F8176E327AB67DEA9", hash_generated_method = "5D04E291BFBB988E3B375A1F60C5A2D0")
    public void setContentTypeHeader(ContentTypeHeader contentTypeHeader) {
        this.contentTypeHeader = contentTypeHeader;
        // ---------- Original Method ----------
        //this.contentTypeHeader = contentTypeHeader;
    }

    
}

