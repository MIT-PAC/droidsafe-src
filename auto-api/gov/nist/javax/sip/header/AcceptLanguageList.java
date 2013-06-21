package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class AcceptLanguageList extends SIPHeaderList<AcceptLanguage> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.647 -0400", hash_original_method = "240BB3B9B24C078BD16B4E527289E882", hash_generated_method = "11DB9C05848E7350775B5746176F17CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AcceptLanguageList() {
        super(AcceptLanguage.class, AcceptLanguageHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.648 -0400", hash_original_method = "D59E3796661CC485086FCE096143E912", hash_generated_method = "3141DCD9BF9D77F4334B3C5356652267")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        AcceptLanguageList retval;
        retval = new AcceptLanguageList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AcceptLanguageList retval = new AcceptLanguageList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.648 -0400", hash_original_method = "4EAA649C6A43B8603903A57164247286", hash_generated_method = "1949AEE47EBA481A4F732899B9AC880E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AcceptLanguage getFirst() {
        AcceptLanguage retval;
        retval = (AcceptLanguage) super.getFirst();
        AcceptLanguage varCF5552F5C7970DBD1EF24E9DC35FF42B_674987322 = (new AcceptLanguage());
        return (AcceptLanguage)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AcceptLanguage retval = (AcceptLanguage) super.getFirst();
        //if (retval != null)
            //return retval;
        //else
            //return new AcceptLanguage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.648 -0400", hash_original_method = "D3074C13DEFE0D00E21551F82106E50D", hash_generated_method = "DAEA4B207A05B189FED049D447C61450")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AcceptLanguage getLast() {
        AcceptLanguage retval;
        retval = (AcceptLanguage) super.getLast();
        AcceptLanguage varCF5552F5C7970DBD1EF24E9DC35FF42B_681707461 = (new AcceptLanguage());
        return (AcceptLanguage)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AcceptLanguage retval = (AcceptLanguage) super.getLast();
        //if (retval != null)
            //return retval;
        //else
            //return new AcceptLanguage();
    }

    
    private static final long serialVersionUID = -3289606805203488840L;
}

