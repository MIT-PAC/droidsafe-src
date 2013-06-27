package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class SelectionKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.725 -0400", hash_original_field = "F7F53EC97D9FAA3231B5FB90D8D61205", hash_generated_field = "7B0B71636F0A6FD9185511547501EE96")

    private volatile Object attachment = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.734 -0400", hash_original_method = "506BAEF14D6E9F731FF32E7686B78589", hash_generated_method = "C9F592136899BF1C8C66719DB1AAC6AF")
    protected  SelectionKey() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.735 -0400", hash_original_method = "AFA38A9E30799729C39292277D62F43D", hash_generated_method = "545C076AA999D2C4E00CB509F9D55634")
    public final Object attach(Object anObject) {
        Object varB4EAC82CA7396A68D541C85D26508E83_2058673370 = null; //Variable for return #1
        Object oldAttachment;
        oldAttachment = attachment;
        attachment = anObject;
        varB4EAC82CA7396A68D541C85D26508E83_2058673370 = oldAttachment;
        varB4EAC82CA7396A68D541C85D26508E83_2058673370.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2058673370;
        // ---------- Original Method ----------
        //Object oldAttachment = attachment;
        //attachment = anObject;
        //return oldAttachment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.735 -0400", hash_original_method = "F29A40DBFBA770DAC2D3ED3DF7881B6F", hash_generated_method = "B9E6220B21F4D84AD47FF732C337929D")
    public final Object attachment() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1830553267 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1830553267 = attachment;
        varB4EAC82CA7396A68D541C85D26508E83_1830553267.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1830553267;
        // ---------- Original Method ----------
        //return attachment;
    }

    
    public abstract void cancel();

    
    public abstract SelectableChannel channel();

    
    public abstract int interestOps();

    
    public abstract SelectionKey interestOps(int operations);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.737 -0400", hash_original_method = "ED231557F3875B4504449502DA9771AC", hash_generated_method = "DA94A00D7FFB6BE41FF6CAC5177DFAFC")
    public final boolean isAcceptable() {
        boolean var3FFF79DDC6269480A262572B7E13C143_1153753252 = ((readyOps() & OP_ACCEPT) == OP_ACCEPT);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_721613990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_721613990;
        // ---------- Original Method ----------
        //return (readyOps() & OP_ACCEPT) == OP_ACCEPT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.748 -0400", hash_original_method = "2F2EE0183B49AF3C16598E47DE1FB088", hash_generated_method = "BC42E59D23EB4A892EEAB625B87D8997")
    public final boolean isConnectable() {
        boolean var14023F539790F88C79012E483D506513_1758478751 = ((readyOps() & OP_CONNECT) == OP_CONNECT);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1335944139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1335944139;
        // ---------- Original Method ----------
        //return (readyOps() & OP_CONNECT) == OP_CONNECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.749 -0400", hash_original_method = "B9D7CCBAB6757F436C28ADF7D4904FD5", hash_generated_method = "357B58A1E6469C26F1D9B3D4D41EFEE9")
    public final boolean isReadable() {
        boolean varB85443E403489FA18BEAF3232BBB1CD0_2091479011 = ((readyOps() & OP_READ) == OP_READ);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1625120579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1625120579;
        // ---------- Original Method ----------
        //return (readyOps() & OP_READ) == OP_READ;
    }

    
    public abstract boolean isValid();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.754 -0400", hash_original_method = "FD6385C69AD88B8295913B1A01B9080B", hash_generated_method = "E43899C5836ADD2A5EF8A33C9F3A2413")
    public final boolean isWritable() {
        boolean var6D081738662D189EAD46924D1A918A3B_1958419625 = ((readyOps() & OP_WRITE) == OP_WRITE);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979107746 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979107746;
        // ---------- Original Method ----------
        //return (readyOps() & OP_WRITE) == OP_WRITE;
    }

    
    public abstract int readyOps();

    
    public abstract Selector selector();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.754 -0400", hash_original_field = "DBBC1F1E4CF8E2C8950D3C421EAB6668", hash_generated_field = "C7033B07AB2380EEC61C6B834AFE8243")

    public static final int OP_ACCEPT = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.754 -0400", hash_original_field = "20BAE7A1B61C03BBBC60FBA895374759", hash_generated_field = "98D8B6069299F205A6C0690AECE873DE")

    public static final int OP_CONNECT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.754 -0400", hash_original_field = "CEB32A79E20403AC7E6CCE4BA29D2805", hash_generated_field = "D875CBDC7BEE6AE76B8093E3ABE67080")

    public static final int OP_READ = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.755 -0400", hash_original_field = "3DDDC137B525E34E28EADF89D092C4AA", hash_generated_field = "774DF0D205A7727252316C3B8AA23F6A")

    public static final int OP_WRITE = 4;
}

