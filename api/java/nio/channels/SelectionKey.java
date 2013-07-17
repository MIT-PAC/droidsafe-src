package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class SelectionKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.273 -0400", hash_original_field = "F7F53EC97D9FAA3231B5FB90D8D61205", hash_generated_field = "7B0B71636F0A6FD9185511547501EE96")

    private volatile Object attachment = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.273 -0400", hash_original_method = "506BAEF14D6E9F731FF32E7686B78589", hash_generated_method = "C9F592136899BF1C8C66719DB1AAC6AF")
    protected  SelectionKey() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.275 -0400", hash_original_method = "AFA38A9E30799729C39292277D62F43D", hash_generated_method = "4CCA8E3C40C44D7ED5C556DA58591304")
    public final Object attach(Object anObject) {
        Object oldAttachment = attachment;
        attachment = anObject;
Object var12F0D7B0ACC665DAE79CBE5C1E855DC9_736033836 =         oldAttachment;
        var12F0D7B0ACC665DAE79CBE5C1E855DC9_736033836.addTaint(taint);
        return var12F0D7B0ACC665DAE79CBE5C1E855DC9_736033836;
        // ---------- Original Method ----------
        //Object oldAttachment = attachment;
        //attachment = anObject;
        //return oldAttachment;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.275 -0400", hash_original_method = "F29A40DBFBA770DAC2D3ED3DF7881B6F", hash_generated_method = "67EAFC0E79AD7C0E5AADC57207A233E6")
    public final Object attachment() {
Object var654DB21DFA380501361FCD413C8E6A16_1233369378 =         attachment;
        var654DB21DFA380501361FCD413C8E6A16_1233369378.addTaint(taint);
        return var654DB21DFA380501361FCD413C8E6A16_1233369378;
        // ---------- Original Method ----------
        //return attachment;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void cancel();

    
    @DSModeled(DSC.SAFE)
    public abstract SelectableChannel channel();

    
    @DSModeled(DSC.SAFE)
    public abstract int interestOps();

    
    @DSModeled(DSC.SAFE)
    public abstract SelectionKey interestOps(int operations);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.277 -0400", hash_original_method = "ED231557F3875B4504449502DA9771AC", hash_generated_method = "FF5E8C9FBF77EC134158842D70BCFCC8")
    public final boolean isAcceptable() {
        boolean var184BFDC257D997348D948C238F624ED0_1534615599 = ((readyOps() & OP_ACCEPT) == OP_ACCEPT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1900249532 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1900249532;
        // ---------- Original Method ----------
        //return (readyOps() & OP_ACCEPT) == OP_ACCEPT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.277 -0400", hash_original_method = "2F2EE0183B49AF3C16598E47DE1FB088", hash_generated_method = "4B91BB86F437BCD4315DA4C20B2E8FF1")
    public final boolean isConnectable() {
        boolean varF330DA86349725C7DD104FDBFF474BC8_548903452 = ((readyOps() & OP_CONNECT) == OP_CONNECT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1515801761 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1515801761;
        // ---------- Original Method ----------
        //return (readyOps() & OP_CONNECT) == OP_CONNECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.277 -0400", hash_original_method = "B9D7CCBAB6757F436C28ADF7D4904FD5", hash_generated_method = "C9881A59CE0AE3F5977BBEAE321475E2")
    public final boolean isReadable() {
        boolean var5BCD0D05F92B38BD9369FBE6A9C7F333_1084926686 = ((readyOps() & OP_READ) == OP_READ);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1502652660 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1502652660;
        // ---------- Original Method ----------
        //return (readyOps() & OP_READ) == OP_READ;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isValid();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.278 -0400", hash_original_method = "FD6385C69AD88B8295913B1A01B9080B", hash_generated_method = "F479E98B32F5540C1647174033A098C4")
    public final boolean isWritable() {
        boolean var3E834C73360B37193989B72021E0B1A0_1540431269 = ((readyOps() & OP_WRITE) == OP_WRITE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1494228092 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1494228092;
        // ---------- Original Method ----------
        //return (readyOps() & OP_WRITE) == OP_WRITE;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract int readyOps();

    
    @DSModeled(DSC.SAFE)
    public abstract Selector selector();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.279 -0400", hash_original_field = "DBBC1F1E4CF8E2C8950D3C421EAB6668", hash_generated_field = "C7033B07AB2380EEC61C6B834AFE8243")

    public static final int OP_ACCEPT = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.279 -0400", hash_original_field = "20BAE7A1B61C03BBBC60FBA895374759", hash_generated_field = "98D8B6069299F205A6C0690AECE873DE")

    public static final int OP_CONNECT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.279 -0400", hash_original_field = "CEB32A79E20403AC7E6CCE4BA29D2805", hash_generated_field = "D875CBDC7BEE6AE76B8093E3ABE67080")

    public static final int OP_READ = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.279 -0400", hash_original_field = "3DDDC137B525E34E28EADF89D092C4AA", hash_generated_field = "774DF0D205A7727252316C3B8AA23F6A")

    public static final int OP_WRITE = 4;
}

