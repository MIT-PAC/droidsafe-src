package libcore.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class StructTimeval {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.969 -0400", hash_original_field = "A65B042F30CAE0D134F96C10EC496FB7", hash_generated_field = "2551EFE5101A37E7C85A5BFE55D02013")

    public long tv_sec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.970 -0400", hash_original_field = "73B168672D39761C8FCC534E4BA40D5F", hash_generated_field = "F91E150980001C89401E423DD993ED18")

    public long tv_usec;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.970 -0400", hash_original_method = "2F5BA123079D794DD3CCFA1F00DAAB1E", hash_generated_method = "42769DF311439066BE5B81919D5EE4CF")
    private  StructTimeval(long tv_sec, long tv_usec) {
        this.tv_sec = tv_sec;
        this.tv_usec = tv_usec;
        
        
        
    }

    
        public static StructTimeval fromMillis(long millis) {
        long tv_sec = millis / 1000;
        long tv_usec = (millis - (tv_sec * 1000)) * 1000;
        return new StructTimeval(tv_sec, tv_usec);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.971 -0400", hash_original_method = "D7D8FCD49C11BCD20431CC831BF1CCDC", hash_generated_method = "4022DA7A73A7CB9AA35B7C7B303CA2E6")
    public long toMillis() {
        long var3673DBE55B214193F59EC713B7869D47_1991797408 = ((tv_sec * 1000) + (tv_usec / 1000));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_42836238 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_42836238;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.971 -0400", hash_original_method = "0C66DEC6052711C5671EFCEF17FE1D94", hash_generated_method = "0C4EA134718FC7BE708E52132AABAAE1")
    @Override
    public String toString() {
String var227B2F1F7B818243AD5BEE376C80779D_254218985 =         "StructTimeval[tv_sec=" + tv_sec + ",tv_usec=" + tv_usec + "]";
        var227B2F1F7B818243AD5BEE376C80779D_254218985.addTaint(taint);
        return var227B2F1F7B818243AD5BEE376C80779D_254218985;
        
        
    }

    
}

