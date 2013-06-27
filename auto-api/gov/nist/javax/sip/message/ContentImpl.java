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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.750 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "ACC0ED8FE681AE1F8700C32DE8F586D0")

    private Object content;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.750 -0400", hash_original_field = "81FD830C85363675EDB98D2879916D8C", hash_generated_field = "ED35814FA47AF2DBDA1D10B34E2A8ED6")

    private String boundary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.750 -0400", hash_original_field = "FB0BB5CDAA2DA15343996268C7C83C28", hash_generated_field = "386022F5483C72B1DB3C8AA8A89EDC5E")

    private ContentTypeHeader contentTypeHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.750 -0400", hash_original_field = "033C11C30B4138BEFC9D799FFCF0239D", hash_generated_field = "97D8B5913638678D3ACBF7B6AE57F828")

    private ContentDispositionHeader contentDispositionHeader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.753 -0400", hash_original_method = "BFB297926685FC1F358C134CE06B2B50", hash_generated_method = "830F598434B90B9D84711FB0ED686CDB")
    public  ContentImpl( String content, String boundary ) {
        this.content = content;
        this.boundary = boundary;
        // ---------- Original Method ----------
        //this.content = content;
        //this.boundary = boundary;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.753 -0400", hash_original_method = "AC1A4D9E7F01819C7360E12D70B398EB", hash_generated_method = "62E9489CB1A97725F62EAECCA3AE3630")
    public void setContent(Object content) {
        this.content = content;
        // ---------- Original Method ----------
        //this.content = content;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.754 -0400", hash_original_method = "F9A2B83B00823C4E5AAD796119B409F3", hash_generated_method = "1DD27D879D721EFDFA79AD2B7430D55E")
    public ContentTypeHeader getContentTypeHeader() {
        ContentTypeHeader varB4EAC82CA7396A68D541C85D26508E83_1186508909 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1186508909 = contentTypeHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1186508909.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1186508909;
        // ---------- Original Method ----------
        //return contentTypeHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.754 -0400", hash_original_method = "29FF4E0F65DE2DF21CD886ED55A6EE33", hash_generated_method = "54F6843B6A6FC184756A7EAE2F226895")
    public Object getContent() {
        Object varB4EAC82CA7396A68D541C85D26508E83_501139149 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_501139149 = this.content;
        varB4EAC82CA7396A68D541C85D26508E83_501139149.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_501139149;
        // ---------- Original Method ----------
        //return this.content;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.759 -0400", hash_original_method = "F6C29ED2FF7A16DDC103A61DA5684884", hash_generated_method = "485168F38781924CB14FAC308F5127A6")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1555636436 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2138381255 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1856748605 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1555636436 = content.toString();
        } //End block
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_2138381255 = "--" + boundary + "\r\n" + getContentTypeHeader() + 
                    this.getContentDispositionHeader().toString() + "\r\n"
                    + content.toString();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1856748605 = "--" + boundary + "\r\n" + getContentTypeHeader() + "\r\n" +  content.toString();
            } //End block
        } //End block
        String varA7E53CE21691AB073D9660D615818899_625443064; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_625443064 = varB4EAC82CA7396A68D541C85D26508E83_1555636436;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_625443064 = varB4EAC82CA7396A68D541C85D26508E83_2138381255;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_625443064 = varB4EAC82CA7396A68D541C85D26508E83_1856748605;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_625443064.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_625443064;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.765 -0400", hash_original_method = "A92668968F751E368038351A92419F09", hash_generated_method = "40CCBC8DEE7734D4E6DB8D46E7E773A4")
    public void setContentDispositionHeader(ContentDispositionHeader contentDispositionHeader) {
        this.contentDispositionHeader = contentDispositionHeader;
        // ---------- Original Method ----------
        //this.contentDispositionHeader = contentDispositionHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.766 -0400", hash_original_method = "5BF192DF8194E4DCDCE4203B3764CB73", hash_generated_method = "D7119B5FD8707269F26FCC3FB77D5432")
    public ContentDispositionHeader getContentDispositionHeader() {
        ContentDispositionHeader varB4EAC82CA7396A68D541C85D26508E83_1565399787 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1565399787 = contentDispositionHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1565399787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1565399787;
        // ---------- Original Method ----------
        //return contentDispositionHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.766 -0400", hash_original_method = "F204171925CED35F8176E327AB67DEA9", hash_generated_method = "5D04E291BFBB988E3B375A1F60C5A2D0")
    public void setContentTypeHeader(ContentTypeHeader contentTypeHeader) {
        this.contentTypeHeader = contentTypeHeader;
        // ---------- Original Method ----------
        //this.contentTypeHeader = contentTypeHeader;
    }

    
}

