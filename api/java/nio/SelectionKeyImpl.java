package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.AbstractSelectionKey;






final class SelectionKeyImpl extends AbstractSelectionKey {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.291 -0500", hash_original_field = "FEFAC73692D7E17DB18C4E769106B5E2", hash_generated_field = "E125EF1A670EBEF5649D9B822EF15475")


    private AbstractSelectableChannel channel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.292 -0500", hash_original_field = "381160572B7D65DA766EB935C94A98D6", hash_generated_field = "99D2BA400CD7DBB29DFED003AED91D48")


    private int interestOps;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.293 -0500", hash_original_field = "BF82598D36DA59E4D21ADA19BAF48464", hash_generated_field = "410007A56D30CA888F4024F6CCB6F8C8")


    private int readyOps;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.293 -0500", hash_original_field = "D72B1E8B218DD9CE14F4033905AA4F41", hash_generated_field = "5473DE3E076906AD060E0C9087021F2C")


    private SelectorImpl selector;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.296 -0500", hash_original_method = "00B21AF608B9E98BCADD70D0A49AAABA", hash_generated_method = "550C7685E871695F1776BDC18D24C968")
    public SelectionKeyImpl(AbstractSelectableChannel channel, int operations,
            Object attachment, SelectorImpl selector) {
        this.channel = channel;
        interestOps = operations;
        this.selector = selector;
        attach(attachment);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.297 -0500", hash_original_method = "882667334549B80F71299B2D55BDD68C", hash_generated_method = "17F74C9ED9C7367CD6BCD5E6AA0DABE6")
    @Override
public SelectableChannel channel() {
        return channel;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.297 -0500", hash_original_method = "88C76B7DE6B06DD1BF72DD8504F2EE79", hash_generated_method = "DA0EC1937E65D0D4E1CDE2880C6A7526")
    @Override
public int interestOps() {
        checkValid();
        synchronized (selector.keysLock) {
            return interestOps;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.298 -0500", hash_original_method = "0E5852722D76AA650E985E5327BEB666", hash_generated_method = "0E5852722D76AA650E985E5327BEB666")
    int interestOpsNoCheck() {
        synchronized (selector.keysLock) {
            return interestOps;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.299 -0500", hash_original_method = "4D6BC0A0A118723D5704E38CA961A8E7", hash_generated_method = "9C16C1AB6088FA2DA2BEBACB660A767C")
    @Override
public SelectionKey interestOps(int operations) {
        checkValid();
        if ((operations & ~(channel().validOps())) != 0) {
            throw new IllegalArgumentException();
        }
        synchronized (selector.keysLock) {
            interestOps = operations;
        }
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.300 -0500", hash_original_method = "D572EFB96E0388A4ABC799875BA302C3", hash_generated_method = "B7AE2A8B2DE248A405DAFE26655115A5")
    @Override
public int readyOps() {
        checkValid();
        return readyOps;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.301 -0500", hash_original_method = "4899CDE2873B162644661E5D73296ACA", hash_generated_method = "9D075E5D6FB12CC57E0FD2447C218E20")
    @Override
public Selector selector() {
        return selector;
    }

    /*
     * package private method for setting the ready operation by selector
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.302 -0500", hash_original_method = "9A32477274F9217DE646A1A1CD8308E4", hash_generated_method = "9A32477274F9217DE646A1A1CD8308E4")
    void setReadyOps(int readyOps) {
        this.readyOps = readyOps;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.303 -0500", hash_original_method = "3C7107E57611448B023007D9312E8BE0", hash_generated_method = "F91A0CD9DF37B4321768C6E647EB893D")
    private void checkValid() {
        if (!isValid()) {
            throw new CancelledKeyException();
        }
    }

    /**
     * Returns true if the channel for this key is connected. If the channel
     * does not need connecting, this always return true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.303 -0500", hash_original_method = "566ADAA0BA7A180A2DDEAD33A7978412", hash_generated_method = "566ADAA0BA7A180A2DDEAD33A7978412")
    boolean isConnected() {
        return !(channel instanceof SocketChannel) || ((SocketChannel) channel).isConnected();
    }

    
}

