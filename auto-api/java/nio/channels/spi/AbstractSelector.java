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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.778 -0400", hash_original_field = "794376DC12B37C66A546427E3AB70DF9", hash_generated_field = "B8FA5D91281783548590853309C56636")

    private AtomicBoolean isOpen = new AtomicBoolean(true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.778 -0400", hash_original_field = "A84D4D80E229BA36EE3D0C6D573ECAAF", hash_generated_field = "89E44FF0276DC637467C9A53214EFEF3")

    private SelectorProvider provider = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.778 -0400", hash_original_field = "F1673D0D652FF183981F85646CD98D79", hash_generated_field = "8B4279465A8A5B7B9C137A2ABDAB2546")

    private Set<SelectionKey> cancelledKeysSet = new HashSet<SelectionKey>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.779 -0400", hash_original_field = "33150D8ED2F1190449307B4DADDC93F3", hash_generated_field = "7B0B79067269D1C3E2C497E30B04D2BE")

    private Runnable wakeupRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.779 -0400", hash_original_method = "7C4207C049033B8A840024AF7D6007E1", hash_generated_method = "DE46A52DF305552AEC6BF62783C2EE19")
        @Override
        public void run() {
            wakeup();
            // ---------- Original Method ----------
            //wakeup();
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.779 -0400", hash_original_method = "56B85F67F1D1FE1953948CC1AC991A83", hash_generated_method = "1EF6A0AD4A4810B794CD069187876910")
    protected  AbstractSelector(SelectorProvider selectorProvider) {
        provider = selectorProvider;
        // ---------- Original Method ----------
        //provider = selectorProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.782 -0400", hash_original_method = "9F8B8FD2F0A9D2575659CC3A12134435", hash_generated_method = "75E4A1D1B00C6BA26204BF2D7B9B53B5")
    @Override
    public final void close() throws IOException {
        {
            boolean var6E1E593C568999FDADC89A96A2904268_558500892 = (isOpen.getAndSet(false));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.782 -0400", hash_original_method = "4BED6A018F66CD694B83A1B1A043078B", hash_generated_method = "45C894F5E64D6F586150FE03574D4D5E")
    @Override
    public final boolean isOpen() {
        boolean var613BBC4F15B812C0598465B212033A5E_1801809751 = (isOpen.get());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221194369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_221194369;
        // ---------- Original Method ----------
        //return isOpen.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.783 -0400", hash_original_method = "B098D2E33834ACCBC46AD074E583FD9B", hash_generated_method = "925ED9840588F424A91984364A7ECA78")
    @Override
    public final SelectorProvider provider() {
        SelectorProvider varB4EAC82CA7396A68D541C85D26508E83_968046826 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_968046826 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_968046826.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_968046826;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.784 -0400", hash_original_method = "DC10B929A0DF63912817926BA3679882", hash_generated_method = "2F9A9851B228DB5E89C85DD6279C78AF")
    protected final Set<SelectionKey> cancelledKeys() {
        Set<SelectionKey> varB4EAC82CA7396A68D541C85D26508E83_2137130189 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2137130189 = cancelledKeysSet;
        varB4EAC82CA7396A68D541C85D26508E83_2137130189.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2137130189;
        // ---------- Original Method ----------
        //return cancelledKeysSet;
    }

    
    protected abstract SelectionKey register(AbstractSelectableChannel channel,
            int operations, Object attachment);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.784 -0400", hash_original_method = "763883A5CF1B35837F10911316906562", hash_generated_method = "A5A6AF08F797A3B6BE188A70D7623223")
    protected final void deregister(AbstractSelectionKey key) {
        ((AbstractSelectableChannel) key.channel()).deregister(key);
        key.isValid = false;
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //((AbstractSelectableChannel) key.channel()).deregister(key);
        //key.isValid = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.784 -0400", hash_original_method = "AA766DB2603B8BA0677C23360DB2CC44", hash_generated_method = "8222DDE0C91F60DCC81236F2688EE27B")
    protected final void begin() {
        Thread.currentThread().pushInterruptAction$(wakeupRunnable);
        // ---------- Original Method ----------
        //Thread.currentThread().pushInterruptAction$(wakeupRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.800 -0400", hash_original_method = "6596DDA3D801AC8A1D2C849102101590", hash_generated_method = "0600DADCB34C678203658AE168281499")
    protected final void end() {
        Thread.currentThread().popInterruptAction$(wakeupRunnable);
        // ---------- Original Method ----------
        //Thread.currentThread().popInterruptAction$(wakeupRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.803 -0400", hash_original_method = "7076984DBD0A39CC1D8943756DBBDDA2", hash_generated_method = "FC7B0A382737CE2C8C961E76FB41E3C7")
     void cancel(SelectionKey key) {
        {
            cancelledKeysSet.add(key);
        } //End block
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //synchronized (cancelledKeysSet) {
            //cancelledKeysSet.add(key);
        //}
    }

    
}

