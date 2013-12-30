package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.AcceptLanguageHeader;






public class AcceptLanguageList extends SIPHeaderList<AcceptLanguage> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.384 -0500", hash_original_field = "3B88016CC39BABB27158BD84AEED3A23", hash_generated_field = "7EA90335ABAD53EEB534CFBDFF1F0433")



    private static final long serialVersionUID = -3289606805203488840L;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.391 -0500", hash_original_method = "240BB3B9B24C078BD16B4E527289E882", hash_generated_method = "3E83EBD18B1DE187BD967F92DA52EE4B")
    
public AcceptLanguageList() {
        super(AcceptLanguage.class, AcceptLanguageHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.388 -0500", hash_original_method = "D59E3796661CC485086FCE096143E912", hash_generated_method = "03A83275E60D6404210400900BC142E2")
    
@Override
    public Object clone() {
        AcceptLanguageList retval = new AcceptLanguageList();
        retval.clonehlist(this.hlist);
        return retval;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.394 -0500", hash_original_method = "4EAA649C6A43B8603903A57164247286", hash_generated_method = "1F7DE68755099C27F78E58477863060F")
    
public AcceptLanguage getFirst() {
        AcceptLanguage retval = (AcceptLanguage) super.getFirst();
        if (retval != null)
            return retval;
        else
            return new AcceptLanguage();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.397 -0500", hash_original_method = "D3074C13DEFE0D00E21551F82106E50D", hash_generated_method = "2658A3B001939B556FD5F0B5A223EB5E")
    
public AcceptLanguage getLast() {
        AcceptLanguage retval = (AcceptLanguage) super.getLast();
        if (retval != null)
            return retval;
        else
            return new AcceptLanguage();
    }
}

