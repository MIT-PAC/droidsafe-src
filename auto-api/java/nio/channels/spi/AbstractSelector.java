package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractSelector extends Selector {
    private final AtomicBoolean isOpen = new AtomicBoolean(true);
    private SelectorProvider provider = null;
    private final Set<SelectionKey> cancelledKeysSet = new HashSet<SelectionKey>();
    private final Runnable wakeupRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.499 -0400", hash_original_method = "7C4207C049033B8A840024AF7D6007E1", hash_generated_method = "5B7457B2AACE0784ED0237D3262FEC3A")
        @DSModeled(DSC.SAFE)
        @Override
        public void run() {
            wakeup();
            // ---------- Original Method ----------
            //wakeup();
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.499 -0400", hash_original_method = "56B85F67F1D1FE1953948CC1AC991A83", hash_generated_method = "01BF67C36B6DAA5476AB9D62E52DB145")
    @DSModeled(DSC.SAFE)
    protected AbstractSelector(SelectorProvider selectorProvider) {
        dsTaint.addTaint(selectorProvider.dsTaint);
        // ---------- Original Method ----------
        //provider = selectorProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.499 -0400", hash_original_method = "9F8B8FD2F0A9D2575659CC3A12134435", hash_generated_method = "C7F2BA42F62E50FE8075A383DA6E4124")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final void close() throws IOException {
        {
            boolean var6E1E593C568999FDADC89A96A2904268_501894534 = (isOpen.getAndSet(false));
            {
                implCloseSelector();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isOpen.getAndSet(false)) {
            //implCloseSelector();
        //}
    }

    
    protected abstract void implCloseSelector() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.499 -0400", hash_original_method = "4BED6A018F66CD694B83A1B1A043078B", hash_generated_method = "219E21805254AAFAEFCEB620270248CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final boolean isOpen() {
        boolean var613BBC4F15B812C0598465B212033A5E_1835656172 = (isOpen.get());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isOpen.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.499 -0400", hash_original_method = "B098D2E33834ACCBC46AD074E583FD9B", hash_generated_method = "9A37A83850234ADAE67E7E6919973380")
    @DSModeled(DSC.SAFE)
    @Override
    public final SelectorProvider provider() {
        return (SelectorProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.499 -0400", hash_original_method = "DC10B929A0DF63912817926BA3679882", hash_generated_method = "7633A3178B1C33D6D5F58BB8C669558D")
    @DSModeled(DSC.SAFE)
    protected final Set<SelectionKey> cancelledKeys() {
        return (Set<SelectionKey>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cancelledKeysSet;
    }

    
    protected abstract SelectionKey register(AbstractSelectableChannel channel,
            int operations, Object attachment);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.499 -0400", hash_original_method = "763883A5CF1B35837F10911316906562", hash_generated_method = "14C4C70D6846F56AF1C4609C0B321320")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void deregister(AbstractSelectionKey key) {
        dsTaint.addTaint(key.dsTaint);
        ((AbstractSelectableChannel) key.channel()).deregister(key);
        key.isValid = false;
        // ---------- Original Method ----------
        //((AbstractSelectableChannel) key.channel()).deregister(key);
        //key.isValid = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.499 -0400", hash_original_method = "AA766DB2603B8BA0677C23360DB2CC44", hash_generated_method = "003ED7A38BEA6633B86FBCE165FB5A2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void begin() {
        Thread.currentThread().pushInterruptAction$(wakeupRunnable);
        // ---------- Original Method ----------
        //Thread.currentThread().pushInterruptAction$(wakeupRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.499 -0400", hash_original_method = "6596DDA3D801AC8A1D2C849102101590", hash_generated_method = "DDFBD890C4B629847ABD879F7DD3F2ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void end() {
        Thread.currentThread().popInterruptAction$(wakeupRunnable);
        // ---------- Original Method ----------
        //Thread.currentThread().popInterruptAction$(wakeupRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.499 -0400", hash_original_method = "7076984DBD0A39CC1D8943756DBBDDA2", hash_generated_method = "8FBE72DBC8B77688DB40B6DF9EC2031C")
    @DSModeled(DSC.SAFE)
     void cancel(SelectionKey key) {
        dsTaint.addTaint(key.dsTaint);
        {
            cancelledKeysSet.add(key);
        } //End block
        // ---------- Original Method ----------
        //synchronized (cancelledKeysSet) {
            //cancelledKeysSet.add(key);
        //}
    }

    
}


