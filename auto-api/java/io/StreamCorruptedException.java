package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class StreamCorruptedException extends ObjectStreamException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.052 -0400", hash_original_method = "03146CFF1C14D5173926865A5139AFE4", hash_generated_method = "58327F1F20247974100B1AF168E65E97")
    public  StreamCorruptedException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.052 -0400", hash_original_method = "6AA6DFEF93503E81D7AC2485347FBC08", hash_generated_method = "29C57103E445384F5FD6D420BE45AEA0")
    public  StreamCorruptedException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.052 -0400", hash_original_field = "C81D07EEDBE96789F2215A96129AD6D9", hash_generated_field = "C02478F50E87CEA242ED68632349F681")

    private static final long serialVersionUID = 8983558202217591746L;
}

