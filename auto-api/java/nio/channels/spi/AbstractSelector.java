package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractSelector extends Selector {
    private AtomicBoolean isOpen = new AtomicBoolean(true);
    private SelectorProvider provider = null;
    private Set<SelectionKey> cancelledKeysSet = new HashSet<SelectionKey>();
    private final Runnable wakeupRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.167 -0400", hash_original_method = "7C4207C049033B8A840024AF7D6007E1", hash_generated_method = "DE46A52DF305552AEC6BF62783C2EE19")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void run() {
            wakeup();
            // ---------- Original Method ----------
            //wakeup();
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.167 -0400", hash_original_method = "56B85F67F1D1FE1953948CC1AC991A83", hash_generated_method = "6E90D8466C84F122072A0FE8D8F3317D")
    @DSModeled(DSC.SAFE)
    protected AbstractSelector(SelectorProvider selectorProvider) {
        dsTaint.addTaint(selectorProvider.dsTaint);
        // ---------- Original Method ----------
        //provider = selectorProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.167 -0400", hash_original_method = "9F8B8FD2F0A9D2575659CC3A12134435", hash_generated_method = "2FEC1C4E84836D539A7C0A0DA5A12239")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final void close() throws IOException {
        {
            boolean var6E1E593C568999FDADC89A96A2904268_1648307788 = (isOpen.getAndSet(false));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.167 -0400", hash_original_method = "4BED6A018F66CD694B83A1B1A043078B", hash_generated_method = "44F2F827E0311DC26003276DD8E97D39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final boolean isOpen() {
        boolean var613BBC4F15B812C0598465B212033A5E_206081216 = (isOpen.get());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isOpen.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.167 -0400", hash_original_method = "B098D2E33834ACCBC46AD074E583FD9B", hash_generated_method = "EE813F03495FAF53CE2281AF0BF98745")
    @DSModeled(DSC.SAFE)
    @Override
    public final SelectorProvider provider() {
        return (SelectorProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.167 -0400", hash_original_method = "DC10B929A0DF63912817926BA3679882", hash_generated_method = "ACB27ADC663687E404D877222F987D59")
    @DSModeled(DSC.SAFE)
    protected final Set<SelectionKey> cancelledKeys() {
        return (Set<SelectionKey>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cancelledKeysSet;
    }

    
    protected abstract SelectionKey register(AbstractSelectableChannel channel,
            int operations, Object attachment);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.168 -0400", hash_original_method = "763883A5CF1B35837F10911316906562", hash_generated_method = "56F00A6E319CB34E7DCEC3732E1FD4F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void deregister(AbstractSelectionKey key) {
        dsTaint.addTaint(key.dsTaint);
        ((AbstractSelectableChannel) key.channel()).deregister(key);
        key.isValid = false;
        // ---------- Original Method ----------
        //((AbstractSelectableChannel) key.channel()).deregister(key);
        //key.isValid = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.168 -0400", hash_original_method = "AA766DB2603B8BA0677C23360DB2CC44", hash_generated_method = "8222DDE0C91F60DCC81236F2688EE27B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void begin() {
        Thread.currentThread().pushInterruptAction$(wakeupRunnable);
        // ---------- Original Method ----------
        //Thread.currentThread().pushInterruptAction$(wakeupRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.168 -0400", hash_original_method = "6596DDA3D801AC8A1D2C849102101590", hash_generated_method = "0600DADCB34C678203658AE168281499")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void end() {
        Thread.currentThread().popInterruptAction$(wakeupRunnable);
        // ---------- Original Method ----------
        //Thread.currentThread().popInterruptAction$(wakeupRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.168 -0400", hash_original_method = "7076984DBD0A39CC1D8943756DBBDDA2", hash_generated_method = "F8E04E6BE71A6C1B440D1181928B7B52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

