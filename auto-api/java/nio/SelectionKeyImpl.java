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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.269 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "E125EF1A670EBEF5649D9B822EF15475")

    private AbstractSelectableChannel channel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.269 -0400", hash_original_field = "A1B9517AC1BCC584B5EB90E61E1DEA41", hash_generated_field = "99D2BA400CD7DBB29DFED003AED91D48")

    private int interestOps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.269 -0400", hash_original_field = "781C6E835DA172D16E588587D41D9FF6", hash_generated_field = "410007A56D30CA888F4024F6CCB6F8C8")

    private int readyOps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.269 -0400", hash_original_field = "5B3C32009797FEB79096D52E56A56B82", hash_generated_field = "5473DE3E076906AD060E0C9087021F2C")

    private SelectorImpl selector;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.270 -0400", hash_original_method = "00B21AF608B9E98BCADD70D0A49AAABA", hash_generated_method = "F8AB9F0E11168D63693995133858F054")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.270 -0400", hash_original_method = "882667334549B80F71299B2D55BDD68C", hash_generated_method = "E2E3437B6497838133E1298B707C0727")
    @Override
    public SelectableChannel channel() {
        SelectableChannel varB4EAC82CA7396A68D541C85D26508E83_1142218158 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1142218158 = channel;
        varB4EAC82CA7396A68D541C85D26508E83_1142218158.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1142218158;
        // ---------- Original Method ----------
        //return channel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.271 -0400", hash_original_method = "88C76B7DE6B06DD1BF72DD8504F2EE79", hash_generated_method = "FFE780122700DD457788B714A1A7E1B6")
    @Override
    public int interestOps() {
        checkValid();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1577692725 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1577692725;
        // ---------- Original Method ----------
        //checkValid();
        //synchronized (selector.keysLock) {
            //return interestOps;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.271 -0400", hash_original_method = "0E5852722D76AA650E985E5327BEB666", hash_generated_method = "5A36CB8CBB3397911D73E5658562C363")
     int interestOpsNoCheck() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_427893964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_427893964;
        // ---------- Original Method ----------
        //synchronized (selector.keysLock) {
            //return interestOps;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.272 -0400", hash_original_method = "4D6BC0A0A118723D5704E38CA961A8E7", hash_generated_method = "C969E0FA2420559C13EDD7D775A23788")
    @Override
    public SelectionKey interestOps(int operations) {
        SelectionKey varB4EAC82CA7396A68D541C85D26508E83_1499863035 = null; //Variable for return #1
        checkValid();
        {
            boolean var96248264D65BB50EBFBB8AC34C637684_1162268106 = ((operations & ~(channel().validOps())) != 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            interestOps = operations;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1499863035 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1499863035.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1499863035;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.272 -0400", hash_original_method = "D572EFB96E0388A4ABC799875BA302C3", hash_generated_method = "19CB7D352E5CD6291601E9E94E9E726B")
    @Override
    public int readyOps() {
        checkValid();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2068455271 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2068455271;
        // ---------- Original Method ----------
        //checkValid();
        //return readyOps;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.272 -0400", hash_original_method = "4899CDE2873B162644661E5D73296ACA", hash_generated_method = "987FCDF6C4274543684F392314DEEFF5")
    @Override
    public Selector selector() {
        Selector varB4EAC82CA7396A68D541C85D26508E83_612559449 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_612559449 = selector;
        varB4EAC82CA7396A68D541C85D26508E83_612559449.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_612559449;
        // ---------- Original Method ----------
        //return selector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.273 -0400", hash_original_method = "9A32477274F9217DE646A1A1CD8308E4", hash_generated_method = "E8E8564E22AE6A9CE6C9C6D694C9BEC6")
     void setReadyOps(int readyOps) {
        this.readyOps = readyOps;
        // ---------- Original Method ----------
        //this.readyOps = readyOps;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.273 -0400", hash_original_method = "3C7107E57611448B023007D9312E8BE0", hash_generated_method = "CBEF0B37B44B5DAF4E1C940AB45EBD74")
    private void checkValid() {
        {
            boolean var2BB7D6C5E35219E80F6351A294486AAA_1253033604 = (!isValid());
            {
                if (DroidSafeAndroidRuntime.control) throw new CancelledKeyException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isValid()) {
            //throw new CancelledKeyException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.273 -0400", hash_original_method = "566ADAA0BA7A180A2DDEAD33A7978412", hash_generated_method = "888BE1AAAD71EBE752698D327C3D1464")
     boolean isConnected() {
        boolean var08D66B4AB10143CEB25DBF301DBA2EC3_482183838 = (!(channel instanceof SocketChannel) || ((SocketChannel) channel).isConnected());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591400022 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591400022;
        // ---------- Original Method ----------
        //return !(channel instanceof SocketChannel) || ((SocketChannel) channel).isConnected();
    }

    
}

