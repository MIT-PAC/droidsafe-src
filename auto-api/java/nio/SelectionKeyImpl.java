package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.AbstractSelectionKey;

final class SelectionKeyImpl extends AbstractSelectionKey {
    private AbstractSelectableChannel channel;
    private int interestOps;
    private int readyOps;
    private SelectorImpl selector;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.967 -0400", hash_original_method = "00B21AF608B9E98BCADD70D0A49AAABA", hash_generated_method = "FEB590857690846D4E3D5FF3A6616B47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SelectionKeyImpl(AbstractSelectableChannel channel, int operations,
            Object attachment, SelectorImpl selector) {
        dsTaint.addTaint(selector.dsTaint);
        dsTaint.addTaint(attachment.dsTaint);
        dsTaint.addTaint(operations);
        dsTaint.addTaint(channel.dsTaint);
        attach(attachment);
        // ---------- Original Method ----------
        //this.channel = channel;
        //interestOps = operations;
        //this.selector = selector;
        //attach(attachment);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.967 -0400", hash_original_method = "882667334549B80F71299B2D55BDD68C", hash_generated_method = "FB039B32171E33232A5AC8F4D5A739A2")
    @DSModeled(DSC.SAFE)
    @Override
    public SelectableChannel channel() {
        return (SelectableChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return channel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.968 -0400", hash_original_method = "88C76B7DE6B06DD1BF72DD8504F2EE79", hash_generated_method = "46861253C3E9C29BFD254B9D1C13E18F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int interestOps() {
        checkValid();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkValid();
        //synchronized (selector.keysLock) {
            //return interestOps;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.968 -0400", hash_original_method = "0E5852722D76AA650E985E5327BEB666", hash_generated_method = "8131EB835D013F53234068F6922F758A")
    @DSModeled(DSC.SAFE)
     int interestOpsNoCheck() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (selector.keysLock) {
            //return interestOps;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.968 -0400", hash_original_method = "4D6BC0A0A118723D5704E38CA961A8E7", hash_generated_method = "05D7795B0B6AE09F61CA3660D15DBB27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SelectionKey interestOps(int operations) {
        dsTaint.addTaint(operations);
        checkValid();
        {
            boolean var96248264D65BB50EBFBB8AC34C637684_1860263435 = ((operations & ~(channel().validOps())) != 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        return (SelectionKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkValid();
        //if ((operations & ~(channel().validOps())) != 0) {
            //throw new IllegalArgumentException();
        //}
        //synchronized (selector.keysLock) {
            //interestOps = operations;
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.968 -0400", hash_original_method = "D572EFB96E0388A4ABC799875BA302C3", hash_generated_method = "4C4DD9F1E8C7BEAB7F17FC4A5E06AFD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int readyOps() {
        checkValid();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkValid();
        //return readyOps;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.968 -0400", hash_original_method = "4899CDE2873B162644661E5D73296ACA", hash_generated_method = "2B195C1BDB47F26235C2F285A82B264F")
    @DSModeled(DSC.SAFE)
    @Override
    public Selector selector() {
        return (Selector)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return selector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.969 -0400", hash_original_method = "9A32477274F9217DE646A1A1CD8308E4", hash_generated_method = "43A3141D6F28E0C25F541F15CAA0164B")
    @DSModeled(DSC.SAFE)
     void setReadyOps(int readyOps) {
        dsTaint.addTaint(readyOps);
        // ---------- Original Method ----------
        //this.readyOps = readyOps;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.969 -0400", hash_original_method = "3C7107E57611448B023007D9312E8BE0", hash_generated_method = "3FC813E88D698AD0F606C4B44AD36F1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkValid() {
        {
            boolean var2BB7D6C5E35219E80F6351A294486AAA_131278513 = (!isValid());
            {
                if (DroidSafeAndroidRuntime.control) throw new CancelledKeyException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isValid()) {
            //throw new CancelledKeyException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.969 -0400", hash_original_method = "566ADAA0BA7A180A2DDEAD33A7978412", hash_generated_method = "F0C3E753E87449F3AD617FD163D32E41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isConnected() {
        boolean var08D66B4AB10143CEB25DBF301DBA2EC3_1946191436 = (!(channel instanceof SocketChannel) || ((SocketChannel) channel).isConnected());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !(channel instanceof SocketChannel) || ((SocketChannel) channel).isConnected();
    }

    
}

