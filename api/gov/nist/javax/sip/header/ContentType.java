package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.ContentTypeHeader;

public class ContentType extends ParametersHeader implements javax.sip.header.ContentTypeHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.391 -0500", hash_original_field = "7BA0516880DD2AA311344E5EDF675622", hash_generated_field = "F8C109B71FF1A33F443977543E5F5F99")

    private static final long serialVersionUID = 8475682204373446610L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.394 -0500", hash_original_field = "10939969C90ADF65B68245FF3D46F7FC", hash_generated_field = "FE54B36640417CD311E956ED780B7202")

    protected MediaRange mediaRange;

    /** Default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.397 -0500", hash_original_method = "DFB0ACA07F1EF34999053FFFBC3153AF", hash_generated_method = "91D1A3B70B932D9094CCB4912BAFC4B1")
    
public ContentType() {
        super(CONTENT_TYPE);
    }

    /** Constructor given a content type and subtype.
    *@param contentType is the content type.
    *@param contentSubtype is the content subtype
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.401 -0500", hash_original_method = "97EC00F8B2220E42E6B0126E7CC0F3E7", hash_generated_method = "AC80A1A0380E5FC543AA906F218D1B20")
    
public ContentType(String contentType, String contentSubtype) {
        this();
        this.setContentType(contentType, contentSubtype);
    }

    /** compare two MediaRange headers.
     * @param media String to set
     * @return int.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.403 -0500", hash_original_method = "2022581A914A53DEAB486C7C21721639", hash_generated_method = "0B028D7882C237D4D15E9A31C97182E9")
    
public int compareMediaRange(String media) {
        return (
            mediaRange.type + "/" + mediaRange.subtype).compareToIgnoreCase(
            media);
    }

    /**
     * Encode into a canonical string.
     * @return String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.406 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "74B066602ECC20A74FD97E770D65E8BD")
    
public String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.409 -0500", hash_original_method = "2667754E6FC706178FFA281551626F8E", hash_generated_method = "4E74C7F42A5175CAE182244A71723F86")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        mediaRange.encode(buffer);
        if (hasParameters()) {
            buffer.append(SEMICOLON);
            parameters.encode(buffer);
        }
        return buffer;
    }

    /** get the mediaRange field.
     * @return MediaRange.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.412 -0500", hash_original_method = "95EC1B8E6B4FF94ADCA4E5294FD4A8E3", hash_generated_method = "0B6D6C1ABE19E2582C3C4BB50CA1EDFA")
    
public MediaRange getMediaRange() {
        return mediaRange;
    }

    /** get the Media Type.
     * @return String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.415 -0500", hash_original_method = "71A8EC95A25C2B8732F46A6E9FE1A552", hash_generated_method = "E83B2494B9461062A2FDDAF3DC290288")
    
public String getMediaType() {
        return mediaRange.type;
    }

    /** get the MediaSubType field.
     * @return String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.417 -0500", hash_original_method = "EEE1854610A538C776591DF3242D2F30", hash_generated_method = "C3FFE958E0E4B51AE98A5BDFE574832B")
    
public String getMediaSubType() {
        return mediaRange.subtype;
    }

    /** Get the content subtype.
    *@return the content subtype string (or null if not set).
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.420 -0500", hash_original_method = "8BA245F79ADA117CDC825C68939B2C5E", hash_generated_method = "D50487336DF5EA676FC0876A8565A6EC")
    
public String getContentSubType() {
        return mediaRange == null ? null : mediaRange.getSubtype();
    }

    /** Get the content subtype.
    *@return the content tyep string (or null if not set).
    */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.423 -0500", hash_original_method = "13593DF0637733E8B4FF50555F8020B8", hash_generated_method = "8B4ABECBF848B177A2577F392D8DA7A8")
    
public String getContentType() {
        return mediaRange == null ? null : mediaRange.getType();
    }

    /** Get the charset parameter.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.425 -0500", hash_original_method = "706F14B8E3FC5B0A8E41E785E1C48F47", hash_generated_method = "8AFA5A9460F662206C220EA2887E7A97")
    
public String getCharset() {
        return this.getParameter("charset");
    }

    /**
     * Set the mediaRange member
     * @param m mediaRange field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.428 -0500", hash_original_method = "E4AF328E0ACDB3837FCDCFA232CB922B", hash_generated_method = "1D841C5C65337DCD91C6EF84344F82A0")
    
public void setMediaRange(MediaRange m) {
        mediaRange = m;
    }

    /**
    * set the content type and subtype.
    *@param contentType Content type string.
    *@param contentSubType content subtype string
    */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.431 -0500", hash_original_method = "255C5DEA7C1BA0115D227FF364F117E1", hash_generated_method = "83ADF05B5CD8F5BA8564FED874B6DDF0")
    
public void setContentType(String contentType, String contentSubType) {
        if (mediaRange == null)
            mediaRange = new MediaRange();
        mediaRange.setType(contentType);
        mediaRange.setSubtype(contentSubType);
    }

    /**
    * set the content type.
    *@param contentType Content type string.
    */

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.434 -0500", hash_original_method = "D590DDC03635869B8BF7D8A74B8AFC87", hash_generated_method = "82AB572602AB8E73BDB47CF09B09CDDF")
    
public void setContentType(String contentType) throws ParseException {
        if (contentType == null)
            throw new NullPointerException("null arg");
        if (mediaRange == null)
            mediaRange = new MediaRange();
        mediaRange.setType(contentType);

    }

    /** Set the content subtype.
         * @param contentType String to set
         */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.437 -0500", hash_original_method = "0B1F5B2677CEADEDD2A1902A7B2F0CE3", hash_generated_method = "99E05A0D8012EB75DD0FFFA0A8B4971A")
    
public void setContentSubType(String contentType) throws ParseException {
        if (contentType == null)
            throw new NullPointerException("null arg");
        if (mediaRange == null)
            mediaRange = new MediaRange();
        mediaRange.setSubtype(contentType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.440 -0500", hash_original_method = "EAF7A0BAA68C7F455EB82B27B83B3C3F", hash_generated_method = "982966B77FCEAD13C7635BFA2F2890C4")
    
public Object clone() {
        ContentType retval = (ContentType) super.clone();
        if (this.mediaRange != null)
            retval.mediaRange = (MediaRange) this.mediaRange.clone();
        return retval;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.443 -0500", hash_original_method = "34166B5115AC7B46D5451CCD077A72C8", hash_generated_method = "13BBFB317A22822E8032D14165032626")
    
public boolean equals(Object other) {
        if (other instanceof ContentTypeHeader) {
            final ContentTypeHeader o = (ContentTypeHeader) other;
            return this.getContentType().equalsIgnoreCase( o.getContentType() )
                && this.getContentSubType().equalsIgnoreCase( o.getContentSubType() )
                && equalParameters( o );
        }
        return false;
    }
}

