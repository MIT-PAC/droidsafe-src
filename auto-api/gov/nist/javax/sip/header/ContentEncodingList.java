package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public final class ContentEncodingList extends SIPHeaderList<ContentEncoding> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.895 -0400", hash_original_method = "D2B39D5ACAE79985BE6285F6D548E94B", hash_generated_method = "9E0268B063A40FA0BEE5F57BE7734754")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentEncodingList() {
        super( ContentEncoding.class,
            ContentEncodingHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.895 -0400", hash_original_method = "1AD27EAA5BBA618A109A28F19AA4BF35", hash_generated_method = "8F1AF58E829090899CFE79510BD557DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        ContentEncodingList retval;
        retval = new ContentEncodingList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ContentEncodingList retval = new ContentEncodingList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    private static final long serialVersionUID = 7365216146576273970L;
}

