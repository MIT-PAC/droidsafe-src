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
    protected MediaRange mediaRange;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.913 -0400", hash_original_method = "DFB0ACA07F1EF34999053FFFBC3153AF", hash_generated_method = "D69CDBB6EDF548FF307DB3C54F1E561D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentType() {
        super(CONTENT_TYPE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.913 -0400", hash_original_method = "97EC00F8B2220E42E6B0126E7CC0F3E7", hash_generated_method = "84451E9C2704B7ED976B5F7ACB0B477D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentType(String contentType, String contentSubtype) {
        this();
        dsTaint.addTaint(contentType);
        dsTaint.addTaint(contentSubtype);
        this.setContentType(contentType, contentSubtype);
        // ---------- Original Method ----------
        //this.setContentType(contentType, contentSubtype);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.913 -0400", hash_original_method = "2022581A914A53DEAB486C7C21721639", hash_generated_method = "350D3AF4663CACEE8BA1A8FD8D8A5B31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareMediaRange(String media) {
        dsTaint.addTaint(media);
        int var31BD664D906CC223AB49E1F3E17406AD_576480743 = ((
            mediaRange.type + "/" + mediaRange.subtype).compareToIgnoreCase(
            media));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (
            //mediaRange.type + "/" + mediaRange.subtype).compareToIgnoreCase(
            //media);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.914 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "9DAA276E9D183E9C4DF1E08F40DF0C64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_158782054 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.914 -0400", hash_original_method = "2667754E6FC706178FFA281551626F8E", hash_generated_method = "4E909F3E9EE239F061154CF6E9D0E5E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        mediaRange.encode(buffer);
        {
            boolean var866376E1CB223B1F9654A217121E1D39_1364614042 = (hasParameters());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mediaRange.encode(buffer);
        //if (hasParameters()) {
            //buffer.append(SEMICOLON);
            //parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.914 -0400", hash_original_method = "95EC1B8E6B4FF94ADCA4E5294FD4A8E3", hash_generated_method = "4EAD22EF415BE692AD7FB9E4BB2368F8")
    @DSModeled(DSC.SAFE)
    public MediaRange getMediaRange() {
        return (MediaRange)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mediaRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.914 -0400", hash_original_method = "71A8EC95A25C2B8732F46A6E9FE1A552", hash_generated_method = "73AEC3BEE1A6D83CD25BBC7D8C0E3572")
    @DSModeled(DSC.SAFE)
    public String getMediaType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mediaRange.type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.914 -0400", hash_original_method = "EEE1854610A538C776591DF3242D2F30", hash_generated_method = "89E9B3A2BE0E108B4627F85370A7D3B1")
    @DSModeled(DSC.SAFE)
    public String getMediaSubType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mediaRange.subtype;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.915 -0400", hash_original_method = "8BA245F79ADA117CDC825C68939B2C5E", hash_generated_method = "84B1A2A9790A91A8E70EC5354B2671D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getContentSubType() {
        {
            Object var1D7139014B5EFD8DEA38D893A4AAC23F_761502202 = (mediaRange.getSubtype());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mediaRange == null ? null : mediaRange.getSubtype();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.915 -0400", hash_original_method = "13593DF0637733E8B4FF50555F8020B8", hash_generated_method = "3FF9C597D53E2137834E9D60F2CE4190")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getContentType() {
        {
            Object var7EEA99F0D4F9EDB9E2339C78EABA9716_1627994292 = (mediaRange.getType());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mediaRange == null ? null : mediaRange.getType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.915 -0400", hash_original_method = "706F14B8E3FC5B0A8E41E785E1C48F47", hash_generated_method = "822ABCBF7B47191DA19B5477A8956451")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCharset() {
        String var6EB97685C6EC606ECFDFAD2B13329845_1671093133 = (this.getParameter("charset"));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getParameter("charset");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.915 -0400", hash_original_method = "E4AF328E0ACDB3837FCDCFA232CB922B", hash_generated_method = "2E62B77BB68A7FC60960883C990D9F70")
    @DSModeled(DSC.SAFE)
    public void setMediaRange(MediaRange m) {
        dsTaint.addTaint(m.dsTaint);
        // ---------- Original Method ----------
        //mediaRange = m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.915 -0400", hash_original_method = "255C5DEA7C1BA0115D227FF364F117E1", hash_generated_method = "051F82B051D3BE9094196F6C875270DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentType(String contentType, String contentSubType) {
        dsTaint.addTaint(contentSubType);
        dsTaint.addTaint(contentType);
        mediaRange = new MediaRange();
        mediaRange.setType(contentType);
        mediaRange.setSubtype(contentSubType);
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setType(contentType);
        //mediaRange.setSubtype(contentSubType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.916 -0400", hash_original_method = "D590DDC03635869B8BF7D8A74B8AFC87", hash_generated_method = "B49DB118C4CB3782260A913CC3AB148A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentType(String contentType) throws ParseException {
        dsTaint.addTaint(contentType);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        mediaRange = new MediaRange();
        mediaRange.setType(contentType);
        // ---------- Original Method ----------
        //if (contentType == null)
            //throw new NullPointerException("null arg");
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setType(contentType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.916 -0400", hash_original_method = "0B1F5B2677CEADEDD2A1902A7B2F0CE3", hash_generated_method = "57B106B0225DE26D767EA33367188F95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentSubType(String contentType) throws ParseException {
        dsTaint.addTaint(contentType);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        mediaRange = new MediaRange();
        mediaRange.setSubtype(contentType);
        // ---------- Original Method ----------
        //if (contentType == null)
            //throw new NullPointerException("null arg");
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setSubtype(contentType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.916 -0400", hash_original_method = "EAF7A0BAA68C7F455EB82B27B83B3C3F", hash_generated_method = "91152E5B2AA347D5107E30FD7894738B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        ContentType retval;
        retval = (ContentType) super.clone();
        retval.mediaRange = (MediaRange) this.mediaRange.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ContentType retval = (ContentType) super.clone();
        //if (this.mediaRange != null)
            //retval.mediaRange = (MediaRange) this.mediaRange.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.916 -0400", hash_original_method = "34166B5115AC7B46D5451CCD077A72C8", hash_generated_method = "F8111AE54D02F8D5E8F61CC58B79C9F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            ContentTypeHeader o;
            o = (ContentTypeHeader) other;
            boolean varD4B944F37DAA43CBA4FEF8DB5969C12E_1160550831 = (this.getContentType().equalsIgnoreCase( o.getContentType() )
                && this.getContentSubType().equalsIgnoreCase( o.getContentSubType() )
                && equalParameters( o ));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (other instanceof ContentTypeHeader) {
            //final ContentTypeHeader o = (ContentTypeHeader) other;
            //return this.getContentType().equalsIgnoreCase( o.getContentType() )
                //&& this.getContentSubType().equalsIgnoreCase( o.getContentSubType() )
                //&& equalParameters( o );
        //}
        //return false;
    }

    
    private static final long serialVersionUID = 8475682204373446610L;
}

