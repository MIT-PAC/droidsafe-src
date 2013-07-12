package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Iterator;
import javax.sip.header.*;

public class UnsupportedList extends SIPHeaderList<Unsupported> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.556 -0400", hash_original_method = "CBBAF1558631750DDBDF9DAEDB7A572C", hash_generated_method = "8F7A7A782386B52882B87C6BD42B708B")
    public  UnsupportedList() {
        super(Unsupported.class, UnsupportedHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.556 -0400", hash_original_method = "586FD49C37A8AA9D6CC092649E8819BF", hash_generated_method = "EDE237798BD9A170FBCB0A6D97008B9F")
    public Object clone() {
        UnsupportedList retval = new UnsupportedList();
Object varF627329B9209466293A1BF71D9AF7B2B_1673048013 =         retval.clonehlist(this.hlist);
        varF627329B9209466293A1BF71D9AF7B2B_1673048013.addTaint(taint);
        return varF627329B9209466293A1BF71D9AF7B2B_1673048013;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.556 -0400", hash_original_field = "043C2460CDAFC725D54C2CA7401A9DF9", hash_generated_field = "127841856DFEDCF98BA424B546FA09BC")

    private static final long serialVersionUID = -4052610269407058661L;
}

