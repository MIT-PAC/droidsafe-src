package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;

public final class InReplyToList extends SIPHeaderList<InReplyTo> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.544 -0400", hash_original_method = "352B2862B115206F092911A984BAE33E", hash_generated_method = "52313BE3C7A7A4FFFFF799BC507758A6")
    public  InReplyToList() {
        super(InReplyTo.class, InReplyToHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.544 -0400", hash_original_method = "DCD4BD1433043890DC84CD67AE62360B", hash_generated_method = "9FDCF10600318E43827AB6C549377D9C")
    public Object clone() {
        InReplyToList retval = new InReplyToList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1561099804 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1561099804.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1561099804;
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.545 -0400", hash_original_field = "2A446AA5963733707A1B3F286FE94EB3", hash_generated_field = "A3E5ABCB1257722D07C0C4A7F8ADE615")

    private static final long serialVersionUID = -7993498496830999237L;
}

