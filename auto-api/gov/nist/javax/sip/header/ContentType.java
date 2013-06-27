package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.ContentTypeHeader;
import java.text.ParseException;

public class ContentType extends ParametersHeader implements javax.sip.header.ContentTypeHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.853 -0400", hash_original_field = "658105D0D44EEADF22FE9B4C6C740531", hash_generated_field = "FE54B36640417CD311E956ED780B7202")

    protected MediaRange mediaRange;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.853 -0400", hash_original_method = "DFB0ACA07F1EF34999053FFFBC3153AF", hash_generated_method = "D69CDBB6EDF548FF307DB3C54F1E561D")
    public  ContentType() {
        super(CONTENT_TYPE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.915 -0400", hash_original_method = "97EC00F8B2220E42E6B0126E7CC0F3E7", hash_generated_method = "86207ABBEC84EF02BBB88B8E1E0958C0")
    public  ContentType(String contentType, String contentSubtype) {
        this();
        this.setContentType(contentType, contentSubtype);
        addTaint(contentType.getTaint());
        addTaint(contentSubtype.getTaint());
        // ---------- Original Method ----------
        //this.setContentType(contentType, contentSubtype);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.916 -0400", hash_original_method = "2022581A914A53DEAB486C7C21721639", hash_generated_method = "25737300EA92A4491898D6143B765D29")
    public int compareMediaRange(String media) {
        int var31BD664D906CC223AB49E1F3E17406AD_1556326436 = ((
            mediaRange.type + "/" + mediaRange.subtype).compareToIgnoreCase(
            media));
        addTaint(media.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816935365 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816935365;
        // ---------- Original Method ----------
        //return (
            //mediaRange.type + "/" + mediaRange.subtype).compareToIgnoreCase(
            //media);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.917 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "CDD72AE05595ACE9B203233C4703692E")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_156728056 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_156728056 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_156728056.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_156728056;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.918 -0400", hash_original_method = "2667754E6FC706178FFA281551626F8E", hash_generated_method = "AA6F9D7C9AEFBF67820B6A8C7B7ED61B")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_2122564835 = null; //Variable for return #1
        mediaRange.encode(buffer);
        {
            boolean var866376E1CB223B1F9654A217121E1D39_195909593 = (hasParameters());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2122564835 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2122564835.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2122564835;
        // ---------- Original Method ----------
        //mediaRange.encode(buffer);
        //if (hasParameters()) {
            //buffer.append(SEMICOLON);
            //parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.918 -0400", hash_original_method = "95EC1B8E6B4FF94ADCA4E5294FD4A8E3", hash_generated_method = "2F234E7BA82B198C0BC047530FE73DE1")
    public MediaRange getMediaRange() {
        MediaRange varB4EAC82CA7396A68D541C85D26508E83_1705956325 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1705956325 = mediaRange;
        varB4EAC82CA7396A68D541C85D26508E83_1705956325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1705956325;
        // ---------- Original Method ----------
        //return mediaRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.919 -0400", hash_original_method = "71A8EC95A25C2B8732F46A6E9FE1A552", hash_generated_method = "4CA6C7FA91CB936A057CC573B760A8E7")
    public String getMediaType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1685981613 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1685981613 = mediaRange.type;
        varB4EAC82CA7396A68D541C85D26508E83_1685981613.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1685981613;
        // ---------- Original Method ----------
        //return mediaRange.type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.919 -0400", hash_original_method = "EEE1854610A538C776591DF3242D2F30", hash_generated_method = "C2C549462AE098AA30FD616D2BD49E11")
    public String getMediaSubType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1576510103 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1576510103 = mediaRange.subtype;
        varB4EAC82CA7396A68D541C85D26508E83_1576510103.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1576510103;
        // ---------- Original Method ----------
        //return mediaRange.subtype;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.922 -0400", hash_original_method = "8BA245F79ADA117CDC825C68939B2C5E", hash_generated_method = "224131023BD5B535E2C8989C76EEB327")
    public String getContentSubType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1510235911 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1510235911 = mediaRange == null ? null : mediaRange.getSubtype();
        varB4EAC82CA7396A68D541C85D26508E83_1510235911.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1510235911;
        // ---------- Original Method ----------
        //return mediaRange == null ? null : mediaRange.getSubtype();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.922 -0400", hash_original_method = "13593DF0637733E8B4FF50555F8020B8", hash_generated_method = "1DB060BEE8DD3EF5B047E691D118741B")
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1594599414 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1594599414 = mediaRange == null ? null : mediaRange.getType();
        varB4EAC82CA7396A68D541C85D26508E83_1594599414.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1594599414;
        // ---------- Original Method ----------
        //return mediaRange == null ? null : mediaRange.getType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.939 -0400", hash_original_method = "706F14B8E3FC5B0A8E41E785E1C48F47", hash_generated_method = "07A528710982A5D890D4A866CCD2D71A")
    public String getCharset() {
        String varB4EAC82CA7396A68D541C85D26508E83_1512340573 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1512340573 = this.getParameter("charset");
        varB4EAC82CA7396A68D541C85D26508E83_1512340573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1512340573;
        // ---------- Original Method ----------
        //return this.getParameter("charset");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.939 -0400", hash_original_method = "E4AF328E0ACDB3837FCDCFA232CB922B", hash_generated_method = "D4B8159947A4E1D723FD3764612CBB21")
    public void setMediaRange(MediaRange m) {
        mediaRange = m;
        // ---------- Original Method ----------
        //mediaRange = m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.939 -0400", hash_original_method = "255C5DEA7C1BA0115D227FF364F117E1", hash_generated_method = "EBFDDF745E83CABF77C90F6B8FE5952E")
    public void setContentType(String contentType, String contentSubType) {
        mediaRange = new MediaRange();
        mediaRange.setType(contentType);
        mediaRange.setSubtype(contentSubType);
        addTaint(contentType.getTaint());
        addTaint(contentSubType.getTaint());
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setType(contentType);
        //mediaRange.setSubtype(contentSubType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.940 -0400", hash_original_method = "D590DDC03635869B8BF7D8A74B8AFC87", hash_generated_method = "B0DBAED4DC7BE314DF6A6E676B859217")
    public void setContentType(String contentType) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        mediaRange = new MediaRange();
        mediaRange.setType(contentType);
        addTaint(contentType.getTaint());
        // ---------- Original Method ----------
        //if (contentType == null)
            //throw new NullPointerException("null arg");
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setType(contentType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.940 -0400", hash_original_method = "0B1F5B2677CEADEDD2A1902A7B2F0CE3", hash_generated_method = "11C51D08A662385FB0CA20E9C93988EC")
    public void setContentSubType(String contentType) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        mediaRange = new MediaRange();
        mediaRange.setSubtype(contentType);
        addTaint(contentType.getTaint());
        // ---------- Original Method ----------
        //if (contentType == null)
            //throw new NullPointerException("null arg");
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setSubtype(contentType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.945 -0400", hash_original_method = "EAF7A0BAA68C7F455EB82B27B83B3C3F", hash_generated_method = "19EF95AA0D12491067A5CEF7E5E00B75")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2072355637 = null; //Variable for return #1
        ContentType retval;
        retval = (ContentType) super.clone();
        retval.mediaRange = (MediaRange) this.mediaRange.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2072355637 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_2072355637.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2072355637;
        // ---------- Original Method ----------
        //ContentType retval = (ContentType) super.clone();
        //if (this.mediaRange != null)
            //retval.mediaRange = (MediaRange) this.mediaRange.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.946 -0400", hash_original_method = "34166B5115AC7B46D5451CCD077A72C8", hash_generated_method = "3F717009D578570FE71DDAA4A1F44B9D")
    public boolean equals(Object other) {
        {
            ContentTypeHeader o;
            o = (ContentTypeHeader) other;
            boolean varD4B944F37DAA43CBA4FEF8DB5969C12E_396739247 = (this.getContentType().equalsIgnoreCase( o.getContentType() )
                && this.getContentSubType().equalsIgnoreCase( o.getContentSubType() )
                && equalParameters( o ));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1526368381 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1526368381;
        // ---------- Original Method ----------
        //if (other instanceof ContentTypeHeader) {
            //final ContentTypeHeader o = (ContentTypeHeader) other;
            //return this.getContentType().equalsIgnoreCase( o.getContentType() )
                //&& this.getContentSubType().equalsIgnoreCase( o.getContentSubType() )
                //&& equalParameters( o );
        //}
        //return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.946 -0400", hash_original_field = "7EC829A2BDD9F0C20CFC8BC464500A23", hash_generated_field = "88288C690EF97502D73CA158A39907C5")

    private static long serialVersionUID = 8475682204373446610L;
}

