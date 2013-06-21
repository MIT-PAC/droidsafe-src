package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class SelectionKey {
    private volatile Object attachment = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.134 -0400", hash_original_method = "506BAEF14D6E9F731FF32E7686B78589", hash_generated_method = "C9F592136899BF1C8C66719DB1AAC6AF")
    @DSModeled(DSC.SAFE)
    protected SelectionKey() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.134 -0400", hash_original_method = "AFA38A9E30799729C39292277D62F43D", hash_generated_method = "E63DC625A3BC64B42322FE90C1A56A82")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.134 -0400", hash_original_method = "F29A40DBFBA770DAC2D3ED3DF7881B6F", hash_generated_method = "5F1F7FCE4F7C2F197FDE051AE699C81C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.135 -0400", hash_original_method = "ED231557F3875B4504449502DA9771AC", hash_generated_method = "941FA46C09203BA8C4C182C58B92F700")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isAcceptable() {
        boolean var3FFF79DDC6269480A262572B7E13C143_876916609 = ((readyOps() & OP_ACCEPT) == OP_ACCEPT);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (readyOps() & OP_ACCEPT) == OP_ACCEPT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.135 -0400", hash_original_method = "2F2EE0183B49AF3C16598E47DE1FB088", hash_generated_method = "41F3C87B8C2AB10764FC18D1965CB517")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isConnectable() {
        boolean var14023F539790F88C79012E483D506513_492496310 = ((readyOps() & OP_CONNECT) == OP_CONNECT);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (readyOps() & OP_CONNECT) == OP_CONNECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.135 -0400", hash_original_method = "B9D7CCBAB6757F436C28ADF7D4904FD5", hash_generated_method = "1B97C1252962DBEAF1DCA0FA84FAC50F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isReadable() {
        boolean varB85443E403489FA18BEAF3232BBB1CD0_364197269 = ((readyOps() & OP_READ) == OP_READ);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (readyOps() & OP_READ) == OP_READ;
    }

    
    public abstract boolean isValid();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.135 -0400", hash_original_method = "FD6385C69AD88B8295913B1A01B9080B", hash_generated_method = "856D798FCCB1ADE9C57C2864447EDB6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isWritable() {
        boolean var6D081738662D189EAD46924D1A918A3B_1396138791 = ((readyOps() & OP_WRITE) == OP_WRITE);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (readyOps() & OP_WRITE) == OP_WRITE;
    }

    
    public abstract int readyOps();

    
    public abstract Selector selector();

    
    public static final int OP_ACCEPT = 16;
    public static final int OP_CONNECT = 8;
    public static final int OP_READ = 1;
    public static final int OP_WRITE = 4;
}

