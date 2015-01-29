package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.HeaderFactoryExt;
import gov.nist.javax.sip.header.HeaderFactoryImpl;

import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.sip.header.ContentDispositionHeader;
import javax.sip.header.ContentTypeHeader;
import javax.sip.header.Header;

public class MultipartMimeContentImpl implements MultipartMimeContent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:37.210 -0500", hash_original_field = "B753BF064F1AAAC492A2DC8B8E945F72", hash_generated_field = "9E4348587CD55FA4C6062879941EE6EC")

    public static String BOUNDARY = "boundary";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:37.202 -0500", hash_original_field = "F9DD76EC9604308FE65CF18537F96FBD", hash_generated_field = "FD0E7DDD1AF822BB0A779B8E067816D9")

    private List<Content> contentList = new LinkedList<Content>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:37.204 -0500", hash_original_field = "23F314B2CFF312300C9F929A45254C2F", hash_generated_field = "CE73E72EF711E1E06248C7F0F370E9AA")

    private ContentTypeHeader multipartMimeContentTypeHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:37.207 -0500", hash_original_field = "5F126137DAFC04B9EEE2456C3083A67E", hash_generated_field = "ED35814FA47AF2DBDA1D10B34E2A8ED6")

    private String boundary;

    /**
     * Creates a default content list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:37.212 -0500", hash_original_method = "2BDD067347267A613FC6CB4251D41452", hash_generated_method = "0D38EFB89EE99F9EEE3DBF2A665B5D22")
    
public MultipartMimeContentImpl(ContentTypeHeader contentTypeHeader) {
        this.multipartMimeContentTypeHeader = contentTypeHeader;
        this.boundary = contentTypeHeader.getParameter(BOUNDARY);

    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.nist.javax.sip.message.MultipartMimeContentExt#add(gov.nist.javax.sip.message.Content)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:37.215 -0500", hash_original_method = "B89677B4178E2DAF7E61A39544E04AE5", hash_generated_method = "54E1D30633AF059002A8DFA9643439E9")
    
public boolean add(Content content) {
        return contentList.add((ContentImpl) content);
    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.nist.javax.sip.message.MultipartMimeContentExt#getContentTypeHeader()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:37.217 -0500", hash_original_method = "4590DD0C77A768FED1E8ACE7CF0313E8", hash_generated_method = "F7078A53193E3585492F31F72681D34E")
    
public ContentTypeHeader getContentTypeHeader() {
        return multipartMimeContentTypeHeader;
    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.nist.javax.sip.message.MultipartMimeContentExt#toString()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:37.219 -0500", hash_original_method = "1253C501D0F5CE66AF0270C83E3A62D6", hash_generated_method = "AF26BB27E070B51980579965CE9A5ED0")
    
@Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        for (Content content : this.contentList) {
            stringBuffer.append(content.toString());
        }
        return stringBuffer.toString();

    }

    /**
     * unpack a multipart mime packet and return a list of content packets.
     * 
     * @return -- an iterator of Content blocks.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:37.224 -0500", hash_original_method = "968D057F7853F8246DB89EBE38C4B30E", hash_generated_method = "8E380029F1DF53CB7C2229165B6B06C1")
    
public void createContentList(String body) throws ParseException {
        try {
            HeaderFactoryExt headerFactory = new HeaderFactoryImpl();
            String delimiter = this.getContentTypeHeader().getParameter(BOUNDARY);

            if (delimiter == null) {
                this.contentList = new LinkedList<Content>();
                ContentImpl content = new ContentImpl(body, delimiter);
                content.setContentTypeHeader(this.getContentTypeHeader());
                this.contentList.add(content);
                return;
            }

            String[] fragments = body.split("--" + delimiter + "\r\n");

            for (String nextPart : fragments) {
                // NOTE - we are not hanlding line folding for the sip header here.

                if (nextPart == null) {
                    return;
                }
                StringBuffer strbuf = new StringBuffer(nextPart);
                while (strbuf.length() > 0
                        && (strbuf.charAt(0) == '\r' || strbuf.charAt(0) == '\n'))
                    strbuf.deleteCharAt(0);

                if (strbuf.length() == 0)
                    continue;
                nextPart = strbuf.toString();
                int position = nextPart.indexOf("\r\n\r\n");
                int off = 4;
                if (position == -1) {
                    position = nextPart.indexOf("\n");
                    off = 2;
                }
                if (position == -1)
                    throw new ParseException("no content type header found in " + nextPart, 0);
                String rest = nextPart.substring(position + off);

                if (rest == null)
                    throw new ParseException("No content [" + nextPart + "]", 0);
                // logger.debug("rest = [[" + rest + "]]");
                String headers = nextPart.substring(0, position);
                ContentImpl content = new ContentImpl(rest, boundary);

                String[] headerArray = headers.split("\r\n");
                for (String hdr : headerArray) {
                    Header header = headerFactory.createHeader(hdr);
                    if (header instanceof ContentTypeHeader) {
                        content.setContentTypeHeader((ContentTypeHeader) header);
                    } else if (header instanceof ContentDispositionHeader) {
                        content.setContentDispositionHeader((ContentDispositionHeader) header);
                    } else {
                        throw new ParseException("Unexpected header type " + header.getName(), 0);
                    }
                    contentList.add(content);
                }

            }
        } catch (StringIndexOutOfBoundsException ex) {
            throw new ParseException("Invalid Multipart mime format", 0);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.nist.javax.sip.message.MultipartMimeContentExt#getContentByType(java.lang.String,
     *      java.lang.String)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:37.226 -0500", hash_original_method = "3C7197D83A3DC33713AACEA2691D16BA", hash_generated_method = "889A4D50C4375D50C2CAC7AF6E4880E0")
    
public Content getContentByType(String contentType, String contentSubtype) {
        Content retval = null;
        if (contentList == null)
            return null;
        for (Content content : contentList) {
            if (content.getContentTypeHeader().getContentType().equalsIgnoreCase(contentType)
                    && content.getContentTypeHeader().getContentSubType().equalsIgnoreCase(
                            contentSubtype)) {
                retval = content;
                break;
            }

        }
        return retval;
    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.nist.javax.sip.message.MultipartMimeContentExt#setContent(java.lang.String,
     *      java.lang.String, gov.nist.javax.sip.message.Content)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:37.228 -0500", hash_original_method = "5D236D4E42081CC93B2BC0976B6D3581", hash_generated_method = "23DD2FBD1DD2414CFC6B068CF8964F96")
    
public void addContent(Content content) {
        this.add(content);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:37.231 -0500", hash_original_method = "DFB35A5106E2AD2A9D629D81C13D382C", hash_generated_method = "21198AD56E87C68151DECA5CFF9CC573")
    
public Iterator<Content> getContents() {
        return this.contentList.iterator();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:37.234 -0500", hash_original_method = "B0C4727628A80D66AB97702342F94FFA", hash_generated_method = "E211D52C5206E29CE9992FAD9FC50119")
    
public int getContentCount() {
        return this.contentList.size();
    }
}

