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
    private Object content;
    private String boundary;
    private ContentTypeHeader contentTypeHeader;
    private ContentDispositionHeader contentDispositionHeader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.676 -0400", hash_original_method = "BFB297926685FC1F358C134CE06B2B50", hash_generated_method = "12665D0121E2BBBF4F7B745C97575569")
    @DSModeled(DSC.SAFE)
    public ContentImpl( String content, String boundary ) {
        dsTaint.addTaint(content);
        dsTaint.addTaint(boundary);
        // ---------- Original Method ----------
        //this.content = content;
        //this.boundary = boundary;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.676 -0400", hash_original_method = "AC1A4D9E7F01819C7360E12D70B398EB", hash_generated_method = "FB1A26477B90C9DCC5837B1398B18B92")
    @DSModeled(DSC.SAFE)
    public void setContent(Object content) {
        dsTaint.addTaint(content.dsTaint);
        // ---------- Original Method ----------
        //this.content = content;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.676 -0400", hash_original_method = "F9A2B83B00823C4E5AAD796119B409F3", hash_generated_method = "134A1E3EF9D21A0E5990E0FDF85C92BB")
    @DSModeled(DSC.SAFE)
    public ContentTypeHeader getContentTypeHeader() {
        return (ContentTypeHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return contentTypeHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.677 -0400", hash_original_method = "29FF4E0F65DE2DF21CD886ED55A6EE33", hash_generated_method = "5AA0E8CCB6D4315AE685A7404A8B52F4")
    @DSModeled(DSC.SAFE)
    public Object getContent() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.content;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.677 -0400", hash_original_method = "F6C29ED2FF7A16DDC103A61DA5684884", hash_generated_method = "7327F7A12A695B082867656F4145718E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        {
            String var1DE9FB00DB2FBF7C1BA39998D91C447D_960854337 = (content.toString());
        } //End block
        {
            {
                String varE97A5E63874E020B91A1BEA0C5ECCF8D_192567360 = ("--" + boundary + "\r\n" + getContentTypeHeader() + 
                    this.getContentDispositionHeader().toString() + "\r\n"
                    + content.toString());
            } //End block
            {
                String var532406F80B811603077AE2DEE7573AC4_1510983532 = ("--" + boundary + "\r\n" + getContentTypeHeader() + "\r\n" +  content.toString());
            } //End block
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.677 -0400", hash_original_method = "A92668968F751E368038351A92419F09", hash_generated_method = "D49DC44C242ECB051817BBA73416C3E3")
    @DSModeled(DSC.SAFE)
    public void setContentDispositionHeader(ContentDispositionHeader contentDispositionHeader) {
        dsTaint.addTaint(contentDispositionHeader.dsTaint);
        // ---------- Original Method ----------
        //this.contentDispositionHeader = contentDispositionHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.677 -0400", hash_original_method = "5BF192DF8194E4DCDCE4203B3764CB73", hash_generated_method = "A2F48AB47268164D216C7B2FB86F1C23")
    @DSModeled(DSC.SAFE)
    public ContentDispositionHeader getContentDispositionHeader() {
        return (ContentDispositionHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return contentDispositionHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.678 -0400", hash_original_method = "F204171925CED35F8176E327AB67DEA9", hash_generated_method = "E85E4C1596676ECB30ECCAB13015EA94")
    @DSModeled(DSC.SAFE)
    public void setContentTypeHeader(ContentTypeHeader contentTypeHeader) {
        dsTaint.addTaint(contentTypeHeader.dsTaint);
        // ---------- Original Method ----------
        //this.contentTypeHeader = contentTypeHeader;
    }

    
}

