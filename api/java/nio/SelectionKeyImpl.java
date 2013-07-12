package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.AbstractSelectionKey;

final class SelectionKeyImpl extends AbstractSelectionKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.199 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "E125EF1A670EBEF5649D9B822EF15475")

    private AbstractSelectableChannel channel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.200 -0400", hash_original_field = "A1B9517AC1BCC584B5EB90E61E1DEA41", hash_generated_field = "99D2BA400CD7DBB29DFED003AED91D48")

    private int interestOps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.200 -0400", hash_original_field = "781C6E835DA172D16E588587D41D9FF6", hash_generated_field = "410007A56D30CA888F4024F6CCB6F8C8")

    private int readyOps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.200 -0400", hash_original_field = "5B3C32009797FEB79096D52E56A56B82", hash_generated_field = "5473DE3E076906AD060E0C9087021F2C")

    private SelectorImpl selector;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.201 -0400", hash_original_method = "00B21AF608B9E98BCADD70D0A49AAABA", hash_generated_method = "B7E5B94132625F5F813F5FE9020AEB3A")
    public  SelectionKeyImpl(AbstractSelectableChannel channel, int operations,
            Object attachment, SelectorImpl selector) {
        addTaint(attachment.getTaint());
        this.channel = channel;
        interestOps = operations;
        this.selector = selector;
        attach(attachment);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.201 -0400", hash_original_method = "882667334549B80F71299B2D55BDD68C", hash_generated_method = "76237773ED41797AB218228E48713965")
    @Override
    public SelectableChannel channel() {
SelectableChannel var99BA3483FD74E36EACD435CEE6BD5D6F_242933927 =         channel;
        var99BA3483FD74E36EACD435CEE6BD5D6F_242933927.addTaint(taint);
        return var99BA3483FD74E36EACD435CEE6BD5D6F_242933927;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.201 -0400", hash_original_method = "88C76B7DE6B06DD1BF72DD8504F2EE79", hash_generated_method = "0DDCA6221C221A10C743E4339721D516")
    @Override
    public int interestOps() {
        checkValid();
        synchronized
(selector.keysLock)        {
            int varA1B9517AC1BCC584B5EB90E61E1DEA41_342113224 = (interestOps);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1818986895 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1818986895;
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.202 -0400", hash_original_method = "0E5852722D76AA650E985E5327BEB666", hash_generated_method = "9B00AF7785A1B61AA0C532C39A4705C7")
     int interestOpsNoCheck() {
        synchronized
(selector.keysLock)        {
            int varA1B9517AC1BCC584B5EB90E61E1DEA41_1537643590 = (interestOps);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1382953267 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1382953267;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.202 -0400", hash_original_method = "4D6BC0A0A118723D5704E38CA961A8E7", hash_generated_method = "01DDC79D9E744DA7ABA8DD687D52E904")
    @Override
    public SelectionKey interestOps(int operations) {
        checkValid();
    if((operations & ~(channel().validOps())) != 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1769298450 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1769298450.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1769298450;
        } 
        synchronized
(selector.keysLock)        {
            interestOps = operations;
        } 
SelectionKey var72A74007B2BE62B849F475C7BDA4658B_354628124 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_354628124.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_354628124;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.202 -0400", hash_original_method = "D572EFB96E0388A4ABC799875BA302C3", hash_generated_method = "D0BC8BD678DD4CD600E1CB0C10C1C5CF")
    @Override
    public int readyOps() {
        checkValid();
        int var781C6E835DA172D16E588587D41D9FF6_588026426 = (readyOps);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_659704047 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_659704047;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.203 -0400", hash_original_method = "4899CDE2873B162644661E5D73296ACA", hash_generated_method = "5A5DDDCFCE89886252A4F63C75A3F129")
    @Override
    public Selector selector() {
Selector var755D5516CC9C857A99E0A4197911305D_1139338094 =         selector;
        var755D5516CC9C857A99E0A4197911305D_1139338094.addTaint(taint);
        return var755D5516CC9C857A99E0A4197911305D_1139338094;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.203 -0400", hash_original_method = "9A32477274F9217DE646A1A1CD8308E4", hash_generated_method = "E8E8564E22AE6A9CE6C9C6D694C9BEC6")
     void setReadyOps(int readyOps) {
        this.readyOps = readyOps;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.204 -0400", hash_original_method = "3C7107E57611448B023007D9312E8BE0", hash_generated_method = "70F9A4C470C308CE3932983184FF0F31")
    private void checkValid() {
    if(!isValid())        
        {
            CancelledKeyException var553A2CCCDE6F10D534FECE0C24924D0C_2080313317 = new CancelledKeyException();
            var553A2CCCDE6F10D534FECE0C24924D0C_2080313317.addTaint(taint);
            throw var553A2CCCDE6F10D534FECE0C24924D0C_2080313317;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.204 -0400", hash_original_method = "566ADAA0BA7A180A2DDEAD33A7978412", hash_generated_method = "E4DF1B232D2DF0F69A64B0629646B042")
     boolean isConnected() {
        boolean var22FD297A02B4C946ADA3777BC98F2729_1252999784 = (!(channel instanceof SocketChannel) || ((SocketChannel) channel).isConnected());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_431052728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_431052728;
        
        
    }

    
}

