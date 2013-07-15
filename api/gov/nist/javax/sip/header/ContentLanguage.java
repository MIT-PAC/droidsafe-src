package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;

public class ContentLanguage extends SIPHeader implements javax.sip.header.ContentLanguageHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.266 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "90B62845FED5E7253FA0E87D66166425")

    protected Locale locale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.266 -0400", hash_original_method = "04F34AE7A99F7FC60EC2CE238423FC91", hash_generated_method = "B92C196A4B4BAB1C64D53F4B3E22B74A")
    public  ContentLanguage() {
        super(CONTENT_LANGUAGE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.266 -0400", hash_original_method = "AA9A79158F9BAA0E6C86C7EA6B5AA5A0", hash_generated_method = "804930ED1A84BE81881C2A3AE488B310")
    public  ContentLanguage(String languageTag) {
        super(CONTENT_LANGUAGE);
        addTaint(languageTag.getTaint());
        this.setLanguageTag( languageTag );
        // ---------- Original Method ----------
        //this.setLanguageTag( languageTag );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.266 -0400", hash_original_method = "969C0CF9A75C29D747322906DB447799", hash_generated_method = "29D3C19637C7519934AEDCDF07BC00F7")
    public String encodeBody() {
String var8C1CD6F54EF4D18C716132A3D390019B_1422151184 =         this.getLanguageTag();
        var8C1CD6F54EF4D18C716132A3D390019B_1422151184.addTaint(taint);
        return var8C1CD6F54EF4D18C716132A3D390019B_1422151184;
        // ---------- Original Method ----------
        //return this.getLanguageTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.267 -0400", hash_original_method = "97684B013EF42C114E2563BE4754CC3B", hash_generated_method = "D6225E19005A382110793F1A75F0D9F2")
    public String getLanguageTag() {
    if("".equals(locale.getCountry()))        
        {
String var83CEAEBE4B936D4AAED30065F0E63287_431949153 =             locale.getLanguage();
            var83CEAEBE4B936D4AAED30065F0E63287_431949153.addTaint(taint);
            return var83CEAEBE4B936D4AAED30065F0E63287_431949153;
        } //End block
        else
        {
String var9D965CDE9A5FC69D278845CD5ADE967F_1616933772 =             locale.getLanguage() + '-' + locale.getCountry();
            var9D965CDE9A5FC69D278845CD5ADE967F_1616933772.addTaint(taint);
            return var9D965CDE9A5FC69D278845CD5ADE967F_1616933772;
        } //End block
        // ---------- Original Method ----------
        //if ( "".equals(locale.getCountry())) {
            //return locale.getLanguage();
        //} else {
            //return locale.getLanguage() + '-' + locale.getCountry();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.268 -0400", hash_original_method = "0029980C0556452F57A726D089728FB9", hash_generated_method = "E2436C436119A4905888B65FE5AA03D8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.268 -0400", hash_original_method = "BB5B9CEBF2423E9AF1F4569292591142", hash_generated_method = "2BC19841DA48D39F14BF693D92BBDE3A")
    public Locale getContentLanguage() {
Locale varB14E682FEAD06D8198D8ADBCBD62DEDB_1961161150 =         locale;
        varB14E682FEAD06D8198D8ADBCBD62DEDB_1961161150.addTaint(taint);
        return varB14E682FEAD06D8198D8ADBCBD62DEDB_1961161150;
        // ---------- Original Method ----------
        //return locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.268 -0400", hash_original_method = "7E2DC8255947AB5497CF8DB62C4D31B5", hash_generated_method = "ECC90E2EED8E215D634D57C08DDAA062")
    public void setContentLanguage(Locale language) {
        this.locale = language;
        // ---------- Original Method ----------
        //this.locale = language;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.269 -0400", hash_original_method = "CEAD9E53DA5FB3A31278ED5B9373A85D", hash_generated_method = "2443311F4BA95576371EA17F93088CFB")
    public Object clone() {
        ContentLanguage retval = (ContentLanguage) super.clone();
    if(this.locale != null)        
        retval.locale = (Locale) this.locale.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1079576836 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1079576836.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1079576836;
        // ---------- Original Method ----------
        //ContentLanguage retval = (ContentLanguage) super.clone();
        //if (this.locale != null)
            //retval.locale = (Locale) this.locale.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.269 -0400", hash_original_field = "A721C8379D729DD5077CCBCF1E7A4FA7", hash_generated_field = "51CDCD95970F98C01DA5ED4493E40EC1")

    private static final long serialVersionUID = -5195728427134181070L;
}

