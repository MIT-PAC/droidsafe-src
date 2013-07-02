package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.ContentTypeHeader;
import java.text.ParseException;

public class ContentType extends ParametersHeader implements javax.sip.header.ContentTypeHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.459 -0400", hash_original_field = "658105D0D44EEADF22FE9B4C6C740531", hash_generated_field = "FE54B36640417CD311E956ED780B7202")

    protected MediaRange mediaRange;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.459 -0400", hash_original_method = "DFB0ACA07F1EF34999053FFFBC3153AF", hash_generated_method = "D69CDBB6EDF548FF307DB3C54F1E561D")
    public  ContentType() {
        super(CONTENT_TYPE);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.459 -0400", hash_original_method = "97EC00F8B2220E42E6B0126E7CC0F3E7", hash_generated_method = "86207ABBEC84EF02BBB88B8E1E0958C0")
    public  ContentType(String contentType, String contentSubtype) {
        this();
        this.setContentType(contentType, contentSubtype);
        addTaint(contentType.getTaint());
        addTaint(contentSubtype.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.460 -0400", hash_original_method = "2022581A914A53DEAB486C7C21721639", hash_generated_method = "E9D471E74C3EB59417ECE5348E74DB46")
    public int compareMediaRange(String media) {
        int var31BD664D906CC223AB49E1F3E17406AD_867166482 = ((
            mediaRange.type + "/" + mediaRange.subtype).compareToIgnoreCase(
            media));
        addTaint(media.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598857102 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598857102;
        
        
            
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.460 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "E40ADC54FC2917CEDBFAC369EF8358EC")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1583772897 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1583772897 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1583772897.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1583772897;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.461 -0400", hash_original_method = "2667754E6FC706178FFA281551626F8E", hash_generated_method = "F967EE05A234561538EABA1AB9062569")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1990534196 = null; 
        mediaRange.encode(buffer);
        {
            boolean var866376E1CB223B1F9654A217121E1D39_709374572 = (hasParameters());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1990534196 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1990534196.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1990534196;
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.461 -0400", hash_original_method = "95EC1B8E6B4FF94ADCA4E5294FD4A8E3", hash_generated_method = "495449F88ADD21BE05AA0B632960D728")
    public MediaRange getMediaRange() {
        MediaRange varB4EAC82CA7396A68D541C85D26508E83_1511246957 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1511246957 = mediaRange;
        varB4EAC82CA7396A68D541C85D26508E83_1511246957.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1511246957;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.462 -0400", hash_original_method = "71A8EC95A25C2B8732F46A6E9FE1A552", hash_generated_method = "5A0AF379912301D1F7895E2B626B0DFE")
    public String getMediaType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1584093506 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1584093506 = mediaRange.type;
        varB4EAC82CA7396A68D541C85D26508E83_1584093506.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1584093506;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.462 -0400", hash_original_method = "EEE1854610A538C776591DF3242D2F30", hash_generated_method = "3E8B3268B8EF035F4C91A6F1C5A08577")
    public String getMediaSubType() {
        String varB4EAC82CA7396A68D541C85D26508E83_894083819 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_894083819 = mediaRange.subtype;
        varB4EAC82CA7396A68D541C85D26508E83_894083819.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_894083819;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.463 -0400", hash_original_method = "8BA245F79ADA117CDC825C68939B2C5E", hash_generated_method = "ED274E1B1ADF417B7F92CB1CCBF383AD")
    public String getContentSubType() {
        String varB4EAC82CA7396A68D541C85D26508E83_698206024 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_698206024 = mediaRange == null ? null : mediaRange.getSubtype();
        varB4EAC82CA7396A68D541C85D26508E83_698206024.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_698206024;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.463 -0400", hash_original_method = "13593DF0637733E8B4FF50555F8020B8", hash_generated_method = "515F949C720FF366D17ABEE470E0AD68")
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1775768607 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1775768607 = mediaRange == null ? null : mediaRange.getType();
        varB4EAC82CA7396A68D541C85D26508E83_1775768607.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1775768607;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.463 -0400", hash_original_method = "706F14B8E3FC5B0A8E41E785E1C48F47", hash_generated_method = "28B0E6848BD3674033F221AABD15FCB6")
    public String getCharset() {
        String varB4EAC82CA7396A68D541C85D26508E83_780181175 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_780181175 = this.getParameter("charset");
        varB4EAC82CA7396A68D541C85D26508E83_780181175.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_780181175;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.463 -0400", hash_original_method = "E4AF328E0ACDB3837FCDCFA232CB922B", hash_generated_method = "D4B8159947A4E1D723FD3764612CBB21")
    public void setMediaRange(MediaRange m) {
        mediaRange = m;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.464 -0400", hash_original_method = "255C5DEA7C1BA0115D227FF364F117E1", hash_generated_method = "EBFDDF745E83CABF77C90F6B8FE5952E")
    public void setContentType(String contentType, String contentSubType) {
        mediaRange = new MediaRange();
        mediaRange.setType(contentType);
        mediaRange.setSubtype(contentSubType);
        addTaint(contentType.getTaint());
        addTaint(contentSubType.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.464 -0400", hash_original_method = "D590DDC03635869B8BF7D8A74B8AFC87", hash_generated_method = "B0DBAED4DC7BE314DF6A6E676B859217")
    public void setContentType(String contentType) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        mediaRange = new MediaRange();
        mediaRange.setType(contentType);
        addTaint(contentType.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.464 -0400", hash_original_method = "0B1F5B2677CEADEDD2A1902A7B2F0CE3", hash_generated_method = "11C51D08A662385FB0CA20E9C93988EC")
    public void setContentSubType(String contentType) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        mediaRange = new MediaRange();
        mediaRange.setSubtype(contentType);
        addTaint(contentType.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.465 -0400", hash_original_method = "EAF7A0BAA68C7F455EB82B27B83B3C3F", hash_generated_method = "B7BAC88D7BE866621B195D250BF98900")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1746139475 = null; 
        ContentType retval = (ContentType) super.clone();
        retval.mediaRange = (MediaRange) this.mediaRange.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1746139475 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1746139475.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1746139475;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.465 -0400", hash_original_method = "34166B5115AC7B46D5451CCD077A72C8", hash_generated_method = "D67711CB4385064B4B164994D5C7AA70")
    public boolean equals(Object other) {
        {
            final ContentTypeHeader o = (ContentTypeHeader) other;
            boolean varD4B944F37DAA43CBA4FEF8DB5969C12E_2061073981 = (this.getContentType().equalsIgnoreCase( o.getContentType() )
                && this.getContentSubType().equalsIgnoreCase( o.getContentSubType() )
                && equalParameters( o ));
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_258883375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_258883375;
        
        
            
            
                
                
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.465 -0400", hash_original_field = "7EC829A2BDD9F0C20CFC8BC464500A23", hash_generated_field = "F8C109B71FF1A33F443977543E5F5F99")

    private static final long serialVersionUID = 8475682204373446610L;
}

