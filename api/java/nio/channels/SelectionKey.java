package java.nio.channels;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class SelectionKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.655 -0400", hash_original_field = "F7F53EC97D9FAA3231B5FB90D8D61205", hash_generated_field = "7B0B71636F0A6FD9185511547501EE96")

    private volatile Object attachment = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.655 -0400", hash_original_method = "506BAEF14D6E9F731FF32E7686B78589", hash_generated_method = "C9F592136899BF1C8C66719DB1AAC6AF")
    protected  SelectionKey() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.656 -0400", hash_original_method = "AFA38A9E30799729C39292277D62F43D", hash_generated_method = "571561C95D7BE4368FFFF6C2507C6624")
    public final Object attach(Object anObject) {
        Object oldAttachment = attachment;
        attachment = anObject;
Object var12F0D7B0ACC665DAE79CBE5C1E855DC9_1841057787 =         oldAttachment;
        var12F0D7B0ACC665DAE79CBE5C1E855DC9_1841057787.addTaint(taint);
        return var12F0D7B0ACC665DAE79CBE5C1E855DC9_1841057787;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.656 -0400", hash_original_method = "F29A40DBFBA770DAC2D3ED3DF7881B6F", hash_generated_method = "55FCB155CACFA8DD50DBB7F3CABAD21B")
    public final Object attachment() {
Object var654DB21DFA380501361FCD413C8E6A16_1479336359 =         attachment;
        var654DB21DFA380501361FCD413C8E6A16_1479336359.addTaint(taint);
        return var654DB21DFA380501361FCD413C8E6A16_1479336359;
        
        
    }

    
    public abstract void cancel();

    
    public abstract SelectableChannel channel();

    
    public abstract int interestOps();

    
    public abstract SelectionKey interestOps(int operations);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.657 -0400", hash_original_method = "ED231557F3875B4504449502DA9771AC", hash_generated_method = "862BEC7CC313BB650EF90ED0BA402951")
    public final boolean isAcceptable() {
        boolean var184BFDC257D997348D948C238F624ED0_800575142 = ((readyOps() & OP_ACCEPT) == OP_ACCEPT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1678541651 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1678541651;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.657 -0400", hash_original_method = "2F2EE0183B49AF3C16598E47DE1FB088", hash_generated_method = "D91F4E1001EB85BAEC67210A80C6378D")
    public final boolean isConnectable() {
        boolean varF330DA86349725C7DD104FDBFF474BC8_679243941 = ((readyOps() & OP_CONNECT) == OP_CONNECT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_88086132 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_88086132;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.658 -0400", hash_original_method = "B9D7CCBAB6757F436C28ADF7D4904FD5", hash_generated_method = "9A1A4145EB67BA294744649211899C0E")
    public final boolean isReadable() {
        boolean var5BCD0D05F92B38BD9369FBE6A9C7F333_2039525941 = ((readyOps() & OP_READ) == OP_READ);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_996025962 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_996025962;
        
        
    }

    
    public abstract boolean isValid();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.658 -0400", hash_original_method = "FD6385C69AD88B8295913B1A01B9080B", hash_generated_method = "918EC9AA333367D95CD9F4DD7931FE92")
    public final boolean isWritable() {
        boolean var3E834C73360B37193989B72021E0B1A0_641413360 = ((readyOps() & OP_WRITE) == OP_WRITE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_661773468 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_661773468;
        
        
    }

    
    public abstract int readyOps();

    
    public abstract Selector selector();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.659 -0400", hash_original_field = "DBBC1F1E4CF8E2C8950D3C421EAB6668", hash_generated_field = "C7033B07AB2380EEC61C6B834AFE8243")

    public static final int OP_ACCEPT = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.659 -0400", hash_original_field = "20BAE7A1B61C03BBBC60FBA895374759", hash_generated_field = "98D8B6069299F205A6C0690AECE873DE")

    public static final int OP_CONNECT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.659 -0400", hash_original_field = "CEB32A79E20403AC7E6CCE4BA29D2805", hash_generated_field = "D875CBDC7BEE6AE76B8093E3ABE67080")

    public static final int OP_READ = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.659 -0400", hash_original_field = "3DDDC137B525E34E28EADF89D092C4AA", hash_generated_field = "774DF0D205A7727252316C3B8AA23F6A")

    public static final int OP_WRITE = 4;
}

