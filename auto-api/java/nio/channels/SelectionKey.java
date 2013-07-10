package java.nio.channels;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class SelectionKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.693 -0400", hash_original_field = "F7F53EC97D9FAA3231B5FB90D8D61205", hash_generated_field = "7B0B71636F0A6FD9185511547501EE96")

    private volatile Object attachment = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.693 -0400", hash_original_method = "506BAEF14D6E9F731FF32E7686B78589", hash_generated_method = "C9F592136899BF1C8C66719DB1AAC6AF")
    protected  SelectionKey() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.694 -0400", hash_original_method = "AFA38A9E30799729C39292277D62F43D", hash_generated_method = "DB8EA6C75FBAD67847A757124D6893FC")
    public final Object attach(Object anObject) {
        Object varB4EAC82CA7396A68D541C85D26508E83_526511671 = null; 
        Object oldAttachment = attachment;
        attachment = anObject;
        varB4EAC82CA7396A68D541C85D26508E83_526511671 = oldAttachment;
        varB4EAC82CA7396A68D541C85D26508E83_526511671.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_526511671;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.694 -0400", hash_original_method = "F29A40DBFBA770DAC2D3ED3DF7881B6F", hash_generated_method = "CBBF28A2F0C39F35BFD0FC968AD32DF9")
    public final Object attachment() {
        Object varB4EAC82CA7396A68D541C85D26508E83_310622010 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_310622010 = attachment;
        varB4EAC82CA7396A68D541C85D26508E83_310622010.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_310622010;
        
        
    }

    
    public abstract void cancel();

    
    public abstract SelectableChannel channel();

    
    public abstract int interestOps();

    
    public abstract SelectionKey interestOps(int operations);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.695 -0400", hash_original_method = "ED231557F3875B4504449502DA9771AC", hash_generated_method = "CBBB31319DA2366247F49DDCA84ADD26")
    public final boolean isAcceptable() {
        boolean var3FFF79DDC6269480A262572B7E13C143_1398625079 = ((readyOps() & OP_ACCEPT) == OP_ACCEPT);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1026067313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1026067313;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.695 -0400", hash_original_method = "2F2EE0183B49AF3C16598E47DE1FB088", hash_generated_method = "C2396E28EE66F7EA6D22969C58761F0A")
    public final boolean isConnectable() {
        boolean var14023F539790F88C79012E483D506513_811928250 = ((readyOps() & OP_CONNECT) == OP_CONNECT);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_178913203 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_178913203;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.695 -0400", hash_original_method = "B9D7CCBAB6757F436C28ADF7D4904FD5", hash_generated_method = "7A10E73A5A18C92B02C594D6E9BB3E54")
    public final boolean isReadable() {
        boolean varB85443E403489FA18BEAF3232BBB1CD0_118829785 = ((readyOps() & OP_READ) == OP_READ);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1930553501 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1930553501;
        
        
    }

    
    public abstract boolean isValid();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.696 -0400", hash_original_method = "FD6385C69AD88B8295913B1A01B9080B", hash_generated_method = "33252B937E30E63B26B8B378D7FD1930")
    public final boolean isWritable() {
        boolean var6D081738662D189EAD46924D1A918A3B_338000753 = ((readyOps() & OP_WRITE) == OP_WRITE);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1722924661 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1722924661;
        
        
    }

    
    public abstract int readyOps();

    
    public abstract Selector selector();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.696 -0400", hash_original_field = "DBBC1F1E4CF8E2C8950D3C421EAB6668", hash_generated_field = "C7033B07AB2380EEC61C6B834AFE8243")

    public static final int OP_ACCEPT = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.696 -0400", hash_original_field = "20BAE7A1B61C03BBBC60FBA895374759", hash_generated_field = "98D8B6069299F205A6C0690AECE873DE")

    public static final int OP_CONNECT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.696 -0400", hash_original_field = "CEB32A79E20403AC7E6CCE4BA29D2805", hash_generated_field = "D875CBDC7BEE6AE76B8093E3ABE67080")

    public static final int OP_READ = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.696 -0400", hash_original_field = "3DDDC137B525E34E28EADF89D092C4AA", hash_generated_field = "774DF0D205A7727252316C3B8AA23F6A")

    public static final int OP_WRITE = 4;
}

