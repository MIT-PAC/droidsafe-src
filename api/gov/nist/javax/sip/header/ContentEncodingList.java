package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;

public final class ContentEncodingList extends SIPHeaderList<ContentEncoding> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.251 -0400", hash_original_method = "D2B39D5ACAE79985BE6285F6D548E94B", hash_generated_method = "9E0268B063A40FA0BEE5F57BE7734754")
    public  ContentEncodingList() {
        super( ContentEncoding.class,
            ContentEncodingHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.251 -0400", hash_original_method = "1AD27EAA5BBA618A109A28F19AA4BF35", hash_generated_method = "254325D89819D3E63E2B1C52AE4E1C36")
    public Object clone() {
        ContentEncodingList retval = new ContentEncodingList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1162786706 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1162786706.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1162786706;
        // ---------- Original Method ----------
        //ContentEncodingList retval = new ContentEncodingList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.251 -0400", hash_original_field = "35F458B67665F3977218E98737514A57", hash_generated_field = "612F67254FCE833D5ACC9D399512B874")

    private static final long serialVersionUID = 7365216146576273970L;
}

