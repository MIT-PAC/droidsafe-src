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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.107 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "E125EF1A670EBEF5649D9B822EF15475")

    private AbstractSelectableChannel channel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.107 -0400", hash_original_field = "A1B9517AC1BCC584B5EB90E61E1DEA41", hash_generated_field = "99D2BA400CD7DBB29DFED003AED91D48")

    private int interestOps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.107 -0400", hash_original_field = "781C6E835DA172D16E588587D41D9FF6", hash_generated_field = "410007A56D30CA888F4024F6CCB6F8C8")

    private int readyOps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.107 -0400", hash_original_field = "5B3C32009797FEB79096D52E56A56B82", hash_generated_field = "5473DE3E076906AD060E0C9087021F2C")

    private SelectorImpl selector;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.108 -0400", hash_original_method = "00B21AF608B9E98BCADD70D0A49AAABA", hash_generated_method = "F8AB9F0E11168D63693995133858F054")
    public  SelectionKeyImpl(AbstractSelectableChannel channel, int operations,
            Object attachment, SelectorImpl selector) {
        this.channel = channel;
        interestOps = operations;
        this.selector = selector;
        attach(attachment);
        addTaint(attachment.getTaint());
        // ---------- Original Method ----------
        //this.channel = channel;
        //interestOps = operations;
        //this.selector = selector;
        //attach(attachment);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.109 -0400", hash_original_method = "882667334549B80F71299B2D55BDD68C", hash_generated_method = "7ABC6C93CC1B648B69D2A9A49C4B5486")
    @Override
    public SelectableChannel channel() {
        SelectableChannel varB4EAC82CA7396A68D541C85D26508E83_881815618 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_881815618 = channel;
        varB4EAC82CA7396A68D541C85D26508E83_881815618.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_881815618;
        // ---------- Original Method ----------
        //return channel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.109 -0400", hash_original_method = "88C76B7DE6B06DD1BF72DD8504F2EE79", hash_generated_method = "158561D2123C6BF6F2BA2683CD2EC8E3")
    @Override
    public int interestOps() {
        checkValid();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_158102104 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_158102104;
        // ---------- Original Method ----------
        //checkValid();
        //synchronized (selector.keysLock) {
            //return interestOps;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.110 -0400", hash_original_method = "0E5852722D76AA650E985E5327BEB666", hash_generated_method = "12964A16E29D2C79EBEB059F53C5FD07")
     int interestOpsNoCheck() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1629965349 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1629965349;
        // ---------- Original Method ----------
        //synchronized (selector.keysLock) {
            //return interestOps;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.111 -0400", hash_original_method = "4D6BC0A0A118723D5704E38CA961A8E7", hash_generated_method = "A001BD3CECC372AB1A18D8B4898935B4")
    @Override
    public SelectionKey interestOps(int operations) {
        SelectionKey varB4EAC82CA7396A68D541C85D26508E83_2067783956 = null; //Variable for return #1
        checkValid();
        {
            boolean var96248264D65BB50EBFBB8AC34C637684_1583517959 = ((operations & ~(channel().validOps())) != 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            interestOps = operations;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2067783956 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2067783956.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2067783956;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.111 -0400", hash_original_method = "D572EFB96E0388A4ABC799875BA302C3", hash_generated_method = "76AF59863B6BFE84FCB0D772CD25AE6F")
    @Override
    public int readyOps() {
        checkValid();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878328927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878328927;
        // ---------- Original Method ----------
        //checkValid();
        //return readyOps;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.125 -0400", hash_original_method = "4899CDE2873B162644661E5D73296ACA", hash_generated_method = "D03D858AA6FD8C003A15D9D239EEDE6B")
    @Override
    public Selector selector() {
        Selector varB4EAC82CA7396A68D541C85D26508E83_1875790844 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1875790844 = selector;
        varB4EAC82CA7396A68D541C85D26508E83_1875790844.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1875790844;
        // ---------- Original Method ----------
        //return selector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.126 -0400", hash_original_method = "9A32477274F9217DE646A1A1CD8308E4", hash_generated_method = "E8E8564E22AE6A9CE6C9C6D694C9BEC6")
     void setReadyOps(int readyOps) {
        this.readyOps = readyOps;
        // ---------- Original Method ----------
        //this.readyOps = readyOps;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.126 -0400", hash_original_method = "3C7107E57611448B023007D9312E8BE0", hash_generated_method = "64625A5CDF1C54AB720737AFF2DB57F0")
    private void checkValid() {
        {
            boolean var2BB7D6C5E35219E80F6351A294486AAA_210885104 = (!isValid());
            {
                if (DroidSafeAndroidRuntime.control) throw new CancelledKeyException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isValid()) {
            //throw new CancelledKeyException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.130 -0400", hash_original_method = "566ADAA0BA7A180A2DDEAD33A7978412", hash_generated_method = "93190E8346F22B86306D1F45C1008D3D")
     boolean isConnected() {
        boolean var08D66B4AB10143CEB25DBF301DBA2EC3_1610096799 = (!(channel instanceof SocketChannel) || ((SocketChannel) channel).isConnected());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_105236589 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_105236589;
        // ---------- Original Method ----------
        //return !(channel instanceof SocketChannel) || ((SocketChannel) channel).isConnected();
    }

    
}

