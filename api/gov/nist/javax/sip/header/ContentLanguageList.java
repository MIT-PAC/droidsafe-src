package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.header.ContentLanguageHeader;






public final class ContentLanguageList extends SIPHeaderList<ContentLanguage> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.262 -0400", hash_original_method = "E0E10BF5A133A10286DF9F5F2B3DD32A", hash_generated_method = "B287B041EB942C3779176FC9062E1E91")
    public  ContentLanguageList() {
        super(ContentLanguage.class,
            ContentLanguageHeader.NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.263 -0400", hash_original_method = "7F1D883A3CFE2424D76B8075C1055DCD", hash_generated_method = "E8AB8A8FB57BF647310E84CB4058C1E6")
    public Object clone() {
        ContentLanguageList retval = new ContentLanguageList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1337889187 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1337889187.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1337889187;
        // ---------- Original Method ----------
        //ContentLanguageList retval = new ContentLanguageList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.264 -0400", hash_original_field = "2FCBD6BE5A8E47E65A4185F7407B6E53", hash_generated_field = "A837F709DA8FC19EFF6B22ACC8726356")

    private static final long serialVersionUID = -5302265987802886465L;
}

