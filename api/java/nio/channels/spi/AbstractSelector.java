package java.nio.channels.spi;

// Droidsafe Imports
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class AbstractSelector extends Selector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.360 -0400", hash_original_field = "794376DC12B37C66A546427E3AB70DF9", hash_generated_field = "1975670F7C5E1A3B0BE1CC3F39D52629")

    private final AtomicBoolean isOpen = new AtomicBoolean(true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.360 -0400", hash_original_field = "A84D4D80E229BA36EE3D0C6D573ECAAF", hash_generated_field = "89E44FF0276DC637467C9A53214EFEF3")

    private SelectorProvider provider = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.360 -0400", hash_original_field = "F1673D0D652FF183981F85646CD98D79", hash_generated_field = "C16D69A091591918E37AAE11008C49F6")

    private final Set<SelectionKey> cancelledKeysSet = new HashSet<SelectionKey>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.780 -0400", hash_original_field = "33150D8ED2F1190449307B4DADDC93F3", hash_generated_field = "81FD2F18DE20D067CA30F74C258D7012")

    private final Runnable wakeupRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.780 -0400", hash_original_method = "7C4207C049033B8A840024AF7D6007E1", hash_generated_method = "DE46A52DF305552AEC6BF62783C2EE19")
        @Override
        public void run() {
            wakeup();
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.360 -0400", hash_original_method = "56B85F67F1D1FE1953948CC1AC991A83", hash_generated_method = "1EF6A0AD4A4810B794CD069187876910")
    protected  AbstractSelector(SelectorProvider selectorProvider) {
        provider = selectorProvider;
        // ---------- Original Method ----------
        //provider = selectorProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.361 -0400", hash_original_method = "9F8B8FD2F0A9D2575659CC3A12134435", hash_generated_method = "06D4016A5161F3AD8BA8BBF5AC8949D8")
    @Override
    public final void close() throws IOException {
        if(isOpen.getAndSet(false))        
        {
            implCloseSelector();
        } //End block
        // ---------- Original Method ----------
        //if (isOpen.getAndSet(false)) {
            //implCloseSelector();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void implCloseSelector() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.361 -0400", hash_original_method = "4BED6A018F66CD694B83A1B1A043078B", hash_generated_method = "07D68938E01C5D05E0DFFCA73587E363")
    @Override
    public final boolean isOpen() {
        boolean varA9BD2A9A78890AD5528095EA0674C311_831600798 = (isOpen.get());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1515494456 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1515494456;
        // ---------- Original Method ----------
        //return isOpen.get();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.362 -0400", hash_original_method = "B098D2E33834ACCBC46AD074E583FD9B", hash_generated_method = "82D31879B24FF672CDC49F68CB222206")
    @Override
    public final SelectorProvider provider() {
SelectorProvider varC1EB7B12CCABB27D431E5B91E5FF9ECB_1389013230 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_1389013230.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_1389013230;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.362 -0400", hash_original_method = "DC10B929A0DF63912817926BA3679882", hash_generated_method = "3E41E6263215AD1127CBF06B032B029F")
    protected final Set<SelectionKey> cancelledKeys() {
Set<SelectionKey> var091462B1A8133F0DFC29D67499143648_305077311 =         cancelledKeysSet;
        var091462B1A8133F0DFC29D67499143648_305077311.addTaint(taint);
        return var091462B1A8133F0DFC29D67499143648_305077311;
        // ---------- Original Method ----------
        //return cancelledKeysSet;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract SelectionKey register(AbstractSelectableChannel channel,
            int operations, Object attachment);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.363 -0400", hash_original_method = "763883A5CF1B35837F10911316906562", hash_generated_method = "A858860A4861DF331051452CAD3612EC")
    protected final void deregister(AbstractSelectionKey key) {
        addTaint(key.getTaint());
        ((AbstractSelectableChannel) key.channel()).deregister(key);
        key.isValid = false;
        // ---------- Original Method ----------
        //((AbstractSelectableChannel) key.channel()).deregister(key);
        //key.isValid = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.363 -0400", hash_original_method = "AA766DB2603B8BA0677C23360DB2CC44", hash_generated_method = "8222DDE0C91F60DCC81236F2688EE27B")
    protected final void begin() {
        Thread.currentThread().pushInterruptAction$(wakeupRunnable);
        // ---------- Original Method ----------
        //Thread.currentThread().pushInterruptAction$(wakeupRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.363 -0400", hash_original_method = "6596DDA3D801AC8A1D2C849102101590", hash_generated_method = "0600DADCB34C678203658AE168281499")
    protected final void end() {
        Thread.currentThread().popInterruptAction$(wakeupRunnable);
        // ---------- Original Method ----------
        //Thread.currentThread().popInterruptAction$(wakeupRunnable);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.364 -0400", hash_original_method = "7076984DBD0A39CC1D8943756DBBDDA2", hash_generated_method = "00857F0EB67BC9BB4B02DCF6D6590303")
     void cancel(SelectionKey key) {
        addTaint(key.getTaint());
        synchronized
(cancelledKeysSet)        {
            cancelledKeysSet.add(key);
        } //End block
        // ---------- Original Method ----------
        //synchronized (cancelledKeysSet) {
            //cancelledKeysSet.add(key);
        //}
    }

    
}

