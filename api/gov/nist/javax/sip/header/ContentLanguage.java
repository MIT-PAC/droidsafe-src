package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;

public class ContentLanguage extends SIPHeader implements javax.sip.header.ContentLanguageHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.252 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "90B62845FED5E7253FA0E87D66166425")

    protected Locale locale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.252 -0400", hash_original_method = "04F34AE7A99F7FC60EC2CE238423FC91", hash_generated_method = "B92C196A4B4BAB1C64D53F4B3E22B74A")
    public  ContentLanguage() {
        super(CONTENT_LANGUAGE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.252 -0400", hash_original_method = "AA9A79158F9BAA0E6C86C7EA6B5AA5A0", hash_generated_method = "804930ED1A84BE81881C2A3AE488B310")
    public  ContentLanguage(String languageTag) {
        super(CONTENT_LANGUAGE);
        addTaint(languageTag.getTaint());
        this.setLanguageTag( languageTag );
        // ---------- Original Method ----------
        //this.setLanguageTag( languageTag );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.253 -0400", hash_original_method = "969C0CF9A75C29D747322906DB447799", hash_generated_method = "F6A6D814C00CAC111D18861111F05101")
    public String encodeBody() {
String var8C1CD6F54EF4D18C716132A3D390019B_1284191483 =         this.getLanguageTag();
        var8C1CD6F54EF4D18C716132A3D390019B_1284191483.addTaint(taint);
        return var8C1CD6F54EF4D18C716132A3D390019B_1284191483;
        // ---------- Original Method ----------
        //return this.getLanguageTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.253 -0400", hash_original_method = "97684B013EF42C114E2563BE4754CC3B", hash_generated_method = "78B6B7ACC2046468519090AACBF1CBBB")
    public String getLanguageTag() {
        if("".equals(locale.getCountry()))        
        {
String var83CEAEBE4B936D4AAED30065F0E63287_2068756241 =             locale.getLanguage();
            var83CEAEBE4B936D4AAED30065F0E63287_2068756241.addTaint(taint);
            return var83CEAEBE4B936D4AAED30065F0E63287_2068756241;
        } //End block
        else
        {
String var9D965CDE9A5FC69D278845CD5ADE967F_1586847057 =             locale.getLanguage() + '-' + locale.getCountry();
            var9D965CDE9A5FC69D278845CD5ADE967F_1586847057.addTaint(taint);
            return var9D965CDE9A5FC69D278845CD5ADE967F_1586847057;
        } //End block
        // ---------- Original Method ----------
        //if ( "".equals(locale.getCountry())) {
            //return locale.getLanguage();
        //} else {
            //return locale.getLanguage() + '-' + locale.getCountry();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.254 -0400", hash_original_method = "0029980C0556452F57A726D089728FB9", hash_generated_method = "E2436C436119A4905888B65FE5AA03D8")
    public void setLanguageTag(String languageTag) {
        final int slash = languageTag.indexOf('-');
        if(slash>=0)        
        {
            this.locale = new Locale(languageTag.substring(0,slash), languageTag.substring(slash+1) );
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.255 -0400", hash_original_method = "BB5B9CEBF2423E9AF1F4569292591142", hash_generated_method = "BE85C44F5D44D7F922561FAAC3C69726")
    public Locale getContentLanguage() {
Locale varB14E682FEAD06D8198D8ADBCBD62DEDB_2104013633 =         locale;
        varB14E682FEAD06D8198D8ADBCBD62DEDB_2104013633.addTaint(taint);
        return varB14E682FEAD06D8198D8ADBCBD62DEDB_2104013633;
        // ---------- Original Method ----------
        //return locale;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.256 -0400", hash_original_method = "7E2DC8255947AB5497CF8DB62C4D31B5", hash_generated_method = "ECC90E2EED8E215D634D57C08DDAA062")
    public void setContentLanguage(Locale language) {
        this.locale = language;
        // ---------- Original Method ----------
        //this.locale = language;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.257 -0400", hash_original_method = "CEAD9E53DA5FB3A31278ED5B9373A85D", hash_generated_method = "43A2F82A1AF7C41C9BB9457EA98ACFCD")
    public Object clone() {
        ContentLanguage retval = (ContentLanguage) super.clone();
        if(this.locale != null)        
        retval.locale = (Locale) this.locale.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_440090470 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_440090470.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_440090470;
        // ---------- Original Method ----------
        //ContentLanguage retval = (ContentLanguage) super.clone();
        //if (this.locale != null)
            //retval.locale = (Locale) this.locale.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.257 -0400", hash_original_field = "A721C8379D729DD5077CCBCF1E7A4FA7", hash_generated_field = "51CDCD95970F98C01DA5ED4493E40EC1")

    private static final long serialVersionUID = -5195728427134181070L;
}

