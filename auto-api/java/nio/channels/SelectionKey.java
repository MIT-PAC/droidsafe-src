package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public abstract class SelectionKey {
    public static final int OP_ACCEPT = 16;
    public static final int OP_CONNECT = 8;
    public static final int OP_READ = 1;
    public static final int OP_WRITE = 4;
    private volatile Object attachment = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.489 -0400", hash_original_method = "506BAEF14D6E9F731FF32E7686B78589", hash_generated_method = "CCCD58A555F336219A688362ABAFDDFA")
    @DSModeled(DSC.SAFE)
    protected SelectionKey() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.489 -0400", hash_original_method = "AFA38A9E30799729C39292277D62F43D", hash_generated_method = "6CC98B1BE9A1AB901D45860D067516B7")
    @DSModeled(DSC.SAFE)
    public final Object attach(Object anObject) {
        dsTaint.addTaint(anObject.dsTaint);
        Object oldAttachment;
        oldAttachment = attachment;
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object oldAttachment = attachment;
        //attachment = anObject;
        //return oldAttachment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.489 -0400", hash_original_method = "F29A40DBFBA770DAC2D3ED3DF7881B6F", hash_generated_method = "4396DB71B37958DCF1192EE26DE1D5D5")
    @DSModeled(DSC.SAFE)
    public final Object attachment() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return attachment;
    }

    
    public abstract void cancel();

    
    public abstract SelectableChannel channel();

    
    public abstract int interestOps();

    
    public abstract SelectionKey interestOps(int operations);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.489 -0400", hash_original_method = "ED231557F3875B4504449502DA9771AC", hash_generated_method = "E8C42E066585F2690A956AC7928182AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isAcceptable() {
        boolean var3FFF79DDC6269480A262572B7E13C143_22335242 = ((readyOps() & OP_ACCEPT) == OP_ACCEPT);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (readyOps() & OP_ACCEPT) == OP_ACCEPT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.489 -0400", hash_original_method = "2F2EE0183B49AF3C16598E47DE1FB088", hash_generated_method = "E56DC156FC6C6A762883B01736DF97E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isConnectable() {
        boolean var14023F539790F88C79012E483D506513_1581252640 = ((readyOps() & OP_CONNECT) == OP_CONNECT);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (readyOps() & OP_CONNECT) == OP_CONNECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.489 -0400", hash_original_method = "B9D7CCBAB6757F436C28ADF7D4904FD5", hash_generated_method = "9FEB27574F7A063DE60A657C2DF1AC12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isReadable() {
        boolean varB85443E403489FA18BEAF3232BBB1CD0_901743661 = ((readyOps() & OP_READ) == OP_READ);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (readyOps() & OP_READ) == OP_READ;
    }

    
    public abstract boolean isValid();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.489 -0400", hash_original_method = "FD6385C69AD88B8295913B1A01B9080B", hash_generated_method = "935A8C2F4A54AF12A54A34265DC85568")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isWritable() {
        boolean var6D081738662D189EAD46924D1A918A3B_1488608457 = ((readyOps() & OP_WRITE) == OP_WRITE);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (readyOps() & OP_WRITE) == OP_WRITE;
    }

    
    public abstract int readyOps();

    
    public abstract Selector selector();

    
}


