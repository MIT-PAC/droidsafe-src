package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.ContentEncodingHeader;

public final class ContentEncodingList extends SIPHeaderList<ContentEncoding> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.495 -0500", hash_original_field = "C51CF2C7806172099A1A439D77B7F1E3", hash_generated_field = "612F67254FCE833D5ACC9D399512B874")

    private static final long serialVersionUID = 7365216146576273970L;

        /** Default constructor.
         */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.502 -0500", hash_original_method = "D2B39D5ACAE79985BE6285F6D548E94B", hash_generated_method = "8D6F5C593EF1CD32905280314D56F0A3")
    
public ContentEncodingList () {
        super( ContentEncoding.class,
            ContentEncodingHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.498 -0500", hash_original_method = "1AD27EAA5BBA618A109A28F19AA4BF35", hash_generated_method = "2D81C1D39EBC2B60DA8BD38BCDBB211D")
    
public Object clone() {
        ContentEncodingList retval = new ContentEncodingList();
        retval.clonehlist(this.hlist);
        return retval;
    }
}

