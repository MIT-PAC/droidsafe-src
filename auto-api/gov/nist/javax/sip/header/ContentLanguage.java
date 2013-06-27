package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;

public class ContentLanguage extends SIPHeader implements javax.sip.header.ContentLanguageHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.766 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "90B62845FED5E7253FA0E87D66166425")

    protected Locale locale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.766 -0400", hash_original_method = "04F34AE7A99F7FC60EC2CE238423FC91", hash_generated_method = "B92C196A4B4BAB1C64D53F4B3E22B74A")
    public  ContentLanguage() {
        super(CONTENT_LANGUAGE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.767 -0400", hash_original_method = "AA9A79158F9BAA0E6C86C7EA6B5AA5A0", hash_generated_method = "5B9AC641B839FD0F338D807C0C83B3AA")
    public  ContentLanguage(String languageTag) {
        super(CONTENT_LANGUAGE);
        this.setLanguageTag( languageTag );
        addTaint(languageTag.getTaint());
        // ---------- Original Method ----------
        //this.setLanguageTag( languageTag );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.767 -0400", hash_original_method = "969C0CF9A75C29D747322906DB447799", hash_generated_method = "148E42CD4917FF192CBC8CC6CD87ACA6")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_763465739 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_763465739 = this.getLanguageTag();
        varB4EAC82CA7396A68D541C85D26508E83_763465739.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_763465739;
        // ---------- Original Method ----------
        //return this.getLanguageTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.768 -0400", hash_original_method = "97684B013EF42C114E2563BE4754CC3B", hash_generated_method = "8591709FAB4388EC90C9378338618E0D")
    public String getLanguageTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_399988918 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1390021371 = null; //Variable for return #2
        {
            boolean var3059A4CD948191C6B3DEA9B5815BB9C7_254371417 = ("".equals(locale.getCountry()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_399988918 = locale.getLanguage();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1390021371 = locale.getLanguage() + '-' + locale.getCountry();
            } //End block
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_1384496971; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1384496971 = varB4EAC82CA7396A68D541C85D26508E83_399988918;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1384496971 = varB4EAC82CA7396A68D541C85D26508E83_1390021371;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1384496971.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1384496971;
        // ---------- Original Method ----------
        //if ( "".equals(locale.getCountry())) {
            //return locale.getLanguage();
        //} else {
            //return locale.getLanguage() + '-' + locale.getCountry();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.776 -0400", hash_original_method = "0029980C0556452F57A726D089728FB9", hash_generated_method = "D4DCFB3F4FD083D62E7A893A6818DD0F")
    public void setLanguageTag(String languageTag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.788 -0400", hash_original_method = "BB5B9CEBF2423E9AF1F4569292591142", hash_generated_method = "9B2541FC51242699051F6EDDB09D471C")
    public Locale getContentLanguage() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_9404400 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_9404400 = locale;
        varB4EAC82CA7396A68D541C85D26508E83_9404400.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_9404400;
        // ---------- Original Method ----------
        //return locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.789 -0400", hash_original_method = "7E2DC8255947AB5497CF8DB62C4D31B5", hash_generated_method = "ECC90E2EED8E215D634D57C08DDAA062")
    public void setContentLanguage(Locale language) {
        this.locale = language;
        // ---------- Original Method ----------
        //this.locale = language;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.794 -0400", hash_original_method = "CEAD9E53DA5FB3A31278ED5B9373A85D", hash_generated_method = "97DD0983AA59E95840EF60B53E43D516")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_667173477 = null; //Variable for return #1
        ContentLanguage retval;
        retval = (ContentLanguage) super.clone();
        retval.locale = (Locale) this.locale.clone();
        varB4EAC82CA7396A68D541C85D26508E83_667173477 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_667173477.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_667173477;
        // ---------- Original Method ----------
        //ContentLanguage retval = (ContentLanguage) super.clone();
        //if (this.locale != null)
            //retval.locale = (Locale) this.locale.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.795 -0400", hash_original_field = "A721C8379D729DD5077CCBCF1E7A4FA7", hash_generated_field = "C0725971E911FAC92CCB419DD1F4DB29")

    private static long serialVersionUID = -5195728427134181070L;
}

