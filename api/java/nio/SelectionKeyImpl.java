package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.AbstractSelectionKey;






final class SelectionKeyImpl extends AbstractSelectionKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.812 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "E125EF1A670EBEF5649D9B822EF15475")

    private AbstractSelectableChannel channel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.813 -0400", hash_original_field = "A1B9517AC1BCC584B5EB90E61E1DEA41", hash_generated_field = "99D2BA400CD7DBB29DFED003AED91D48")

    private int interestOps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.813 -0400", hash_original_field = "781C6E835DA172D16E588587D41D9FF6", hash_generated_field = "410007A56D30CA888F4024F6CCB6F8C8")

    private int readyOps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.813 -0400", hash_original_field = "5B3C32009797FEB79096D52E56A56B82", hash_generated_field = "5473DE3E076906AD060E0C9087021F2C")

    private SelectorImpl selector;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.814 -0400", hash_original_method = "00B21AF608B9E98BCADD70D0A49AAABA", hash_generated_method = "B7E5B94132625F5F813F5FE9020AEB3A")
    public  SelectionKeyImpl(AbstractSelectableChannel channel, int operations,
            Object attachment, SelectorImpl selector) {
        addTaint(attachment.getTaint());
        this.channel = channel;
        interestOps = operations;
        this.selector = selector;
        attach(attachment);
        // ---------- Original Method ----------
        //this.channel = channel;
        //interestOps = operations;
        //this.selector = selector;
        //attach(attachment);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.814 -0400", hash_original_method = "882667334549B80F71299B2D55BDD68C", hash_generated_method = "D066EC9BB295136CDD47FE33F883F043")
    @Override
    public SelectableChannel channel() {
SelectableChannel var99BA3483FD74E36EACD435CEE6BD5D6F_2069342971 =         channel;
        var99BA3483FD74E36EACD435CEE6BD5D6F_2069342971.addTaint(taint);
        return var99BA3483FD74E36EACD435CEE6BD5D6F_2069342971;
        // ---------- Original Method ----------
        //return channel;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.814 -0400", hash_original_method = "88C76B7DE6B06DD1BF72DD8504F2EE79", hash_generated_method = "1175ED9D0083C0CAF461E5D27387AB26")
    @Override
    public int interestOps() {
        checkValid();
        synchronized
(selector.keysLock)        {
            int varA1B9517AC1BCC584B5EB90E61E1DEA41_1985083516 = (interestOps);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221140726 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221140726;
        } //End block
        // ---------- Original Method ----------
        //checkValid();
        //synchronized (selector.keysLock) {
            //return interestOps;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.814 -0400", hash_original_method = "0E5852722D76AA650E985E5327BEB666", hash_generated_method = "D05E579CE8D856D5CB9F01A3496E731D")
     int interestOpsNoCheck() {
        synchronized
(selector.keysLock)        {
            int varA1B9517AC1BCC584B5EB90E61E1DEA41_1052593789 = (interestOps);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1987874290 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1987874290;
        } //End block
        // ---------- Original Method ----------
        //synchronized (selector.keysLock) {
            //return interestOps;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.815 -0400", hash_original_method = "4D6BC0A0A118723D5704E38CA961A8E7", hash_generated_method = "B8F107D0C80FDD0AB66204613FB9CF45")
    @Override
    public SelectionKey interestOps(int operations) {
        checkValid();
        if((operations & ~(channel().validOps())) != 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1848776929 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1848776929.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1848776929;
        } //End block
        synchronized
(selector.keysLock)        {
            interestOps = operations;
        } //End block
SelectionKey var72A74007B2BE62B849F475C7BDA4658B_2139324627 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2139324627.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2139324627;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.815 -0400", hash_original_method = "D572EFB96E0388A4ABC799875BA302C3", hash_generated_method = "234BE2294C90B940BF55746C836F06D5")
    @Override
    public int readyOps() {
        checkValid();
        int var781C6E835DA172D16E588587D41D9FF6_120035466 = (readyOps);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1551367327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1551367327;
        // ---------- Original Method ----------
        //checkValid();
        //return readyOps;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.815 -0400", hash_original_method = "4899CDE2873B162644661E5D73296ACA", hash_generated_method = "1B625754335B3FD31054D6F37DE13952")
    @Override
    public Selector selector() {
Selector var755D5516CC9C857A99E0A4197911305D_2037244143 =         selector;
        var755D5516CC9C857A99E0A4197911305D_2037244143.addTaint(taint);
        return var755D5516CC9C857A99E0A4197911305D_2037244143;
        // ---------- Original Method ----------
        //return selector;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.816 -0400", hash_original_method = "9A32477274F9217DE646A1A1CD8308E4", hash_generated_method = "E8E8564E22AE6A9CE6C9C6D694C9BEC6")
     void setReadyOps(int readyOps) {
        this.readyOps = readyOps;
        // ---------- Original Method ----------
        //this.readyOps = readyOps;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.816 -0400", hash_original_method = "3C7107E57611448B023007D9312E8BE0", hash_generated_method = "69FCACABCB11EF4D0B247554B6EA413F")
    private void checkValid() {
        if(!isValid())        
        {
            CancelledKeyException var553A2CCCDE6F10D534FECE0C24924D0C_1931136112 = new CancelledKeyException();
            var553A2CCCDE6F10D534FECE0C24924D0C_1931136112.addTaint(taint);
            throw var553A2CCCDE6F10D534FECE0C24924D0C_1931136112;
        } //End block
        // ---------- Original Method ----------
        //if (!isValid()) {
            //throw new CancelledKeyException();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.816 -0400", hash_original_method = "566ADAA0BA7A180A2DDEAD33A7978412", hash_generated_method = "78D8F272B412B95D7EC4221E0E664CC1")
     boolean isConnected() {
        boolean var22FD297A02B4C946ADA3777BC98F2729_1204462140 = (!(channel instanceof SocketChannel) || ((SocketChannel) channel).isConnected());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_102612994 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_102612994;
        // ---------- Original Method ----------
        //return !(channel instanceof SocketChannel) || ((SocketChannel) channel).isConnected();
    }

    
}

