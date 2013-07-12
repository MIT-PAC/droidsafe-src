package java.lang.ref;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class PhantomReference<T> extends Reference<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:52.126 -0400", hash_original_method = "269EAD0EE18A562FFF5DDE7409E1AEEE", hash_generated_method = "881ED6D7D199FC3186279F6D5E9477FF")
    public  PhantomReference(T r, ReferenceQueue<? super T> q) {
        super(r, q);
        addTaint(q.getTaint());
        addTaint(r.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:52.127 -0400", hash_original_method = "11AC17D1A4195077BEA3CC915127101C", hash_generated_method = "4B5320F6E3C0CEBFCC6570F2534A582B")
    @Override
    public T get() {
T var540C13E9E156B687226421B24F2DF178_1201659714 =         null;
        var540C13E9E156B687226421B24F2DF178_1201659714.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1201659714;
        
        
    }

    
}

