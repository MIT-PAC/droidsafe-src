package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.ContentDispositionHeader;
import javax.sip.header.ContentTypeHeader;

public class ContentImpl implements Content {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.254 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "ACC0ED8FE681AE1F8700C32DE8F586D0")

    private Object content;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.254 -0400", hash_original_field = "81FD830C85363675EDB98D2879916D8C", hash_generated_field = "ED35814FA47AF2DBDA1D10B34E2A8ED6")

    private String boundary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.254 -0400", hash_original_field = "FB0BB5CDAA2DA15343996268C7C83C28", hash_generated_field = "386022F5483C72B1DB3C8AA8A89EDC5E")

    private ContentTypeHeader contentTypeHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.254 -0400", hash_original_field = "033C11C30B4138BEFC9D799FFCF0239D", hash_generated_field = "97D8B5913638678D3ACBF7B6AE57F828")

    private ContentDispositionHeader contentDispositionHeader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.255 -0400", hash_original_method = "BFB297926685FC1F358C134CE06B2B50", hash_generated_method = "830F598434B90B9D84711FB0ED686CDB")
    public  ContentImpl( String content, String boundary ) {
        this.content = content;
        this.boundary = boundary;
        // ---------- Original Method ----------
        //this.content = content;
        //this.boundary = boundary;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.255 -0400", hash_original_method = "AC1A4D9E7F01819C7360E12D70B398EB", hash_generated_method = "62E9489CB1A97725F62EAECCA3AE3630")
    public void setContent(Object content) {
        this.content = content;
        // ---------- Original Method ----------
        //this.content = content;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.256 -0400", hash_original_method = "F9A2B83B00823C4E5AAD796119B409F3", hash_generated_method = "05A0880871E2D910CD93D463821FEACB")
    public ContentTypeHeader getContentTypeHeader() {
ContentTypeHeader var3562FC1F10454ABC475529777D44A59E_449712057 =         contentTypeHeader;
        var3562FC1F10454ABC475529777D44A59E_449712057.addTaint(taint);
        return var3562FC1F10454ABC475529777D44A59E_449712057;
        // ---------- Original Method ----------
        //return contentTypeHeader;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.256 -0400", hash_original_method = "29FF4E0F65DE2DF21CD886ED55A6EE33", hash_generated_method = "60FCD600A6EAD01D611446EBB787CC03")
    public Object getContent() {
Object var5B4E22E160A1A738CCEDC8C85B064397_1436766573 =         this.content;
        var5B4E22E160A1A738CCEDC8C85B064397_1436766573.addTaint(taint);
        return var5B4E22E160A1A738CCEDC8C85B064397_1436766573;
        // ---------- Original Method ----------
        //return this.content;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.257 -0400", hash_original_method = "F6C29ED2FF7A16DDC103A61DA5684884", hash_generated_method = "9B03EACE88D82F1C7F3A7C50A7B768E1")
    public String toString() {
    if(boundary == null)        
        {
String var858B7C556F53139D9CB3DB4EE60A0E69_419494478 =             content.toString();
            var858B7C556F53139D9CB3DB4EE60A0E69_419494478.addTaint(taint);
            return var858B7C556F53139D9CB3DB4EE60A0E69_419494478;
        } //End block
        else
        {
    if(this.contentDispositionHeader != null)            
            {
String var01B484ED58E5B82375411C71B76290CE_1180930993 =                 "--" + boundary + "\r\n" + getContentTypeHeader() + 
                    this.getContentDispositionHeader().toString() + "\r\n"
                    + content.toString();
                var01B484ED58E5B82375411C71B76290CE_1180930993.addTaint(taint);
                return var01B484ED58E5B82375411C71B76290CE_1180930993;
            } //End block
            else
            {
String var12F3334FFC53DA9A315A0A003E3B9EF7_343415514 =                 "--" + boundary + "\r\n" + getContentTypeHeader() + "\r\n" +  content.toString();
                var12F3334FFC53DA9A315A0A003E3B9EF7_343415514.addTaint(taint);
                return var12F3334FFC53DA9A315A0A003E3B9EF7_343415514;
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.258 -0400", hash_original_method = "A92668968F751E368038351A92419F09", hash_generated_method = "40CCBC8DEE7734D4E6DB8D46E7E773A4")
    public void setContentDispositionHeader(ContentDispositionHeader contentDispositionHeader) {
        this.contentDispositionHeader = contentDispositionHeader;
        // ---------- Original Method ----------
        //this.contentDispositionHeader = contentDispositionHeader;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.258 -0400", hash_original_method = "5BF192DF8194E4DCDCE4203B3764CB73", hash_generated_method = "2C80AEFA09AE0328912251070D09369A")
    public ContentDispositionHeader getContentDispositionHeader() {
ContentDispositionHeader var6994DFFDA477D863BB6D5AC664F3016F_57907382 =         contentDispositionHeader;
        var6994DFFDA477D863BB6D5AC664F3016F_57907382.addTaint(taint);
        return var6994DFFDA477D863BB6D5AC664F3016F_57907382;
        // ---------- Original Method ----------
        //return contentDispositionHeader;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.258 -0400", hash_original_method = "F204171925CED35F8176E327AB67DEA9", hash_generated_method = "5D04E291BFBB988E3B375A1F60C5A2D0")
    public void setContentTypeHeader(ContentTypeHeader contentTypeHeader) {
        this.contentTypeHeader = contentTypeHeader;
        // ---------- Original Method ----------
        //this.contentTypeHeader = contentTypeHeader;
    }

    
}

