package gov.nist.javax.sip.header;

// Droidsafe Imports
import javax.sip.header.InReplyToHeader;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class InReplyToList extends SIPHeaderList<InReplyTo> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.532 -0400", hash_original_method = "352B2862B115206F092911A984BAE33E", hash_generated_method = "52313BE3C7A7A4FFFFF799BC507758A6")
    public  InReplyToList() {
        super(InReplyTo.class, InReplyToHeader.NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.532 -0400", hash_original_method = "DCD4BD1433043890DC84CD67AE62360B", hash_generated_method = "6C14E28A184FA4BBCAE463A3D82C9480")
    public Object clone() {
        InReplyToList retval = new InReplyToList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1310609053 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1310609053.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1310609053;
        // ---------- Original Method ----------
        //InReplyToList retval = new InReplyToList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.532 -0400", hash_original_field = "2A446AA5963733707A1B3F286FE94EB3", hash_generated_field = "A3E5ABCB1257722D07C0C4A7F8ADE615")

    private static final long serialVersionUID = -7993498496830999237L;
}

