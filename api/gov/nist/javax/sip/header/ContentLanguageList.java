package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.ContentLanguageHeader;

public final class ContentLanguageList extends SIPHeaderList<ContentLanguage> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.761 -0500", hash_original_field = "7255F85E6FFABE4B114CE2A5FD264884", hash_generated_field = "A837F709DA8FC19EFF6B22ACC8726356")

    private static final long serialVersionUID = -5302265987802886465L;
        /** Default constructor
         */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.767 -0500", hash_original_method = "E0E10BF5A133A10286DF9F5F2B3DD32A", hash_generated_method = "DBA43601A18718A9E3D899BADC35A520")
    
public ContentLanguageList () {
        super(ContentLanguage.class,
            ContentLanguageHeader.NAME);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.764 -0500", hash_original_method = "7F1D883A3CFE2424D76B8075C1055DCD", hash_generated_method = "6163721B2507CBE737CA9EDE02FB4358")
    
public Object clone() {
        ContentLanguageList retval = new ContentLanguageList();
        retval.clonehlist(this.hlist);
        return retval;
    }
}

