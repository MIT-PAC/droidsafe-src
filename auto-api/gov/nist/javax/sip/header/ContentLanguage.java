package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;

public class ContentLanguage extends SIPHeader implements javax.sip.header.ContentLanguageHeader {
    protected Locale locale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.898 -0400", hash_original_method = "04F34AE7A99F7FC60EC2CE238423FC91", hash_generated_method = "B92C196A4B4BAB1C64D53F4B3E22B74A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentLanguage() {
        super(CONTENT_LANGUAGE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.898 -0400", hash_original_method = "AA9A79158F9BAA0E6C86C7EA6B5AA5A0", hash_generated_method = "2D55BD4F96EABE3F4ACBD28AB94075B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentLanguage(String languageTag) {
        super(CONTENT_LANGUAGE);
        dsTaint.addTaint(languageTag);
        this.setLanguageTag( languageTag );
        // ---------- Original Method ----------
        //this.setLanguageTag( languageTag );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.898 -0400", hash_original_method = "969C0CF9A75C29D747322906DB447799", hash_generated_method = "EC48B18322D045003F1747B4A37ED27D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String varE8C00E1A7C6B81A50B8BAD178A3275C5_1626633717 = (this.getLanguageTag());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getLanguageTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.898 -0400", hash_original_method = "97684B013EF42C114E2563BE4754CC3B", hash_generated_method = "D6441FEDAF3ADDD3774063C9A7F81BE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLanguageTag() {
        {
            boolean var3059A4CD948191C6B3DEA9B5815BB9C7_1988297789 = ("".equals(locale.getCountry()));
            {
                String var48F848193B38D18A87A696AECF1249F9_1453044941 = (locale.getLanguage());
            } //End block
            {
                String var20D61F02D82DEE1F1D54B52B6476575A_1419169643 = (locale.getLanguage() + '-' + locale.getCountry());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if ( "".equals(locale.getCountry())) {
            //return locale.getLanguage();
        //} else {
            //return locale.getLanguage() + '-' + locale.getCountry();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.899 -0400", hash_original_method = "0029980C0556452F57A726D089728FB9", hash_generated_method = "1BB07A0FAA3D419ECDDCACF2B135AD1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLanguageTag(String languageTag) {
        dsTaint.addTaint(languageTag);
        int slash;
        slash = languageTag.indexOf('-');
        {
            this.locale = new Locale(languageTag.substring(0,slash), languageTag.substring(slash+1) );
        } //End block
        {
            this.locale = new Locale(languageTag);
        } //End block
        // ---------- Original Method ----------
        //final int slash = languageTag.indexOf('-');
        //if (slash>=0) {
            //this.locale = new Locale(languageTag.substring(0,slash), languageTag.substring(slash+1) );
        //} else {
            //this.locale = new Locale(languageTag);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.899 -0400", hash_original_method = "BB5B9CEBF2423E9AF1F4569292591142", hash_generated_method = "7883AC9FE670A72E3322F01D91D544DC")
    @DSModeled(DSC.SAFE)
    public Locale getContentLanguage() {
        return (Locale)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.899 -0400", hash_original_method = "7E2DC8255947AB5497CF8DB62C4D31B5", hash_generated_method = "4C4BC295A1E5230E54D23C31773A70A5")
    @DSModeled(DSC.SAFE)
    public void setContentLanguage(Locale language) {
        dsTaint.addTaint(language.dsTaint);
        // ---------- Original Method ----------
        //this.locale = language;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.899 -0400", hash_original_method = "CEAD9E53DA5FB3A31278ED5B9373A85D", hash_generated_method = "665E7F9BAEEC27C8BF8CE6F1A7FACF36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        ContentLanguage retval;
        retval = (ContentLanguage) super.clone();
        retval.locale = (Locale) this.locale.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ContentLanguage retval = (ContentLanguage) super.clone();
        //if (this.locale != null)
            //retval.locale = (Locale) this.locale.clone();
        //return retval;
    }

    
    private static final long serialVersionUID = -5195728427134181070L;
}

