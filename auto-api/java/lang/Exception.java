package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Exception extends Throwable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.987 -0400", hash_original_method = "D33746B9B653741A49B1BE35D2346C75", hash_generated_method = "D55E5C538C9FDD634751B5C812941F3B")
    public  Exception() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.988 -0400", hash_original_method = "830A2EF4A7E30C0BE0D23F3C6E3EB88B", hash_generated_method = "8D4DA9019DC6E366EB528208F895CA69")
    public  Exception(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.988 -0400", hash_original_method = "1CCC5FB7B2239F395100A328B05F71D2", hash_generated_method = "7F43DA671129ABBBB6A38AA627608A1E")
    public  Exception(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
        addTaint(detailMessage.getTaint());
        addTaint(throwable.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.988 -0400", hash_original_method = "521C63C689E06CBA8E8D56AF626D043A", hash_generated_method = "49A11CC9C11AA0E14DB3B0F036DE895A")
    public  Exception(Throwable throwable) {
        super(throwable);
        addTaint(throwable.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.988 -0400", hash_original_field = "17467F8A82DD34708AEE23B21DF9BE6E", hash_generated_field = "F7EDE40BB9DA19762EC547780842C1FC")

    private static final long serialVersionUID = -3387516993124229948L;
}

