package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.ContentDispositionHeader;
import javax.sip.header.ContentTypeHeader;

public class ContentImpl implements Content {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.852 -0500", hash_original_field = "D0B8E49E3D027D4128A52EE40E051281", hash_generated_field = "ACC0ED8FE681AE1F8700C32DE8F586D0")
   
    private Object content;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.854 -0500", hash_original_field = "5F126137DAFC04B9EEE2456C3083A67E", hash_generated_field = "ED35814FA47AF2DBDA1D10B34E2A8ED6")

    private String boundary;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.857 -0500", hash_original_field = "7B62BAB2183AFC63BE405AA34B524EA0", hash_generated_field = "386022F5483C72B1DB3C8AA8A89EDC5E")
    
    private ContentTypeHeader contentTypeHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.859 -0500", hash_original_field = "BB26073FB24B5744F17A6A0D5BEEAA0D", hash_generated_field = "97D8B5913638678D3ACBF7B6AE57F828")
    
    private ContentDispositionHeader contentDispositionHeader;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.862 -0500", hash_original_method = "BFB297926685FC1F358C134CE06B2B50", hash_generated_method = "034C96C5DD79B98387E33761B7E7FE2D")
    
public ContentImpl( String content, String boundary ) {
        this.content = content;
    
        this.boundary = boundary;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.message.ContentExt#setContent(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.865 -0500", hash_original_method = "AC1A4D9E7F01819C7360E12D70B398EB", hash_generated_method = "36B6B9BEA693C4A910D671DD6E5D1001")
    
public void setContent(Object content) {
        this.content = content;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.message.ContentExt#getContentTypeHeader()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.867 -0500", hash_original_method = "F9A2B83B00823C4E5AAD796119B409F3", hash_generated_method = "A547551ABE92E96A766BA1162C174081")
    
public ContentTypeHeader getContentTypeHeader() {
        return contentTypeHeader;
    }

    /*
     * (non-Javadoc)
     * @see gov.nist.javax.sip.message.Content#getContent()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.869 -0500", hash_original_method = "29FF4E0F65DE2DF21CD886ED55A6EE33", hash_generated_method = "D65A2268B99672B0C8214FB1AFE13DEC")
    
public Object getContent() {
        return this.content;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.message.ContentExt#toString()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.871 -0500", hash_original_method = "F6C29ED2FF7A16DDC103A61DA5684884", hash_generated_method = "63DFFA172D35AC3307AC11CCF0C7B773")
    
public String toString() {
        // This is not part of a multipart message.
        if (boundary == null) {
            return content.toString();
        } else {
           if ( this.contentDispositionHeader != null ) {
            return "--" + boundary + "\r\n" + getContentTypeHeader() + 
                    this.getContentDispositionHeader().toString() + "\r\n"
                    + content.toString();
           } else {
               return "--" + boundary + "\r\n" + getContentTypeHeader() + "\r\n" +  content.toString();
           }
        }
    }

    /**
     * @param contentDispositionHeader the contentDispositionHeader to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.874 -0500", hash_original_method = "A92668968F751E368038351A92419F09", hash_generated_method = "C92C60F0D94480D4CBB0F4403CB5FC3F")
    
public void setContentDispositionHeader(ContentDispositionHeader contentDispositionHeader) {
        this.contentDispositionHeader = contentDispositionHeader;
    }

    /**
     * @return the contentDispositionHeader
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.877 -0500", hash_original_method = "5BF192DF8194E4DCDCE4203B3764CB73", hash_generated_method = "8EDAD567081206A6D388CC0FEF8436D1")
    
public ContentDispositionHeader getContentDispositionHeader() {
        return contentDispositionHeader;
    }

    /**
     * @param contentTypeHeader the contentTypeHeader to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.880 -0500", hash_original_method = "F204171925CED35F8176E327AB67DEA9", hash_generated_method = "5C1F90211032CE3B67D13E3F66BCC943")
    
public void setContentTypeHeader(ContentTypeHeader contentTypeHeader) {
        this.contentTypeHeader = contentTypeHeader;
    }
    
}

