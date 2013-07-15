package java.nio.channels.spi;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractSelector extends Selector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.779 -0400", hash_original_field = "794376DC12B37C66A546427E3AB70DF9", hash_generated_field = "1975670F7C5E1A3B0BE1CC3F39D52629")

    private final AtomicBoolean isOpen = new AtomicBoolean(true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.780 -0400", hash_original_field = "A84D4D80E229BA36EE3D0C6D573ECAAF", hash_generated_field = "89E44FF0276DC637467C9A53214EFEF3")

    private SelectorProvider provider = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.780 -0400", hash_original_field = "F1673D0D652FF183981F85646CD98D79", hash_generated_field = "C16D69A091591918E37AAE11008C49F6")

    private final Set<SelectionKey> cancelledKeysSet = new HashSet<SelectionKey>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.780 -0400", hash_original_field = "33150D8ED2F1190449307B4DADDC93F3", hash_generated_field = "81FD2F18DE20D067CA30F74C258D7012")

    private final Runnable wakeupRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.780 -0400", hash_original_method = "7C4207C049033B8A840024AF7D6007E1", hash_generated_method = "DE46A52DF305552AEC6BF62783C2EE19")
        @Override
        public void run() {
            wakeup();
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.781 -0400", hash_original_method = "56B85F67F1D1FE1953948CC1AC991A83", hash_generated_method = "1EF6A0AD4A4810B794CD069187876910")
    protected  AbstractSelector(SelectorProvider selectorProvider) {
        provider = selectorProvider;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.781 -0400", hash_original_method = "9F8B8FD2F0A9D2575659CC3A12134435", hash_generated_method = "6263F929C17EE536BAEA46A27E2AA650")
    @Override
    public final void close() throws IOException {
        {
            boolean var6E1E593C568999FDADC89A96A2904268_1810796138 = (isOpen.getAndSet(false));
            {
                implCloseSelector();
            } 
        } 
        
        
            
        
    }

    
    protected abstract void implCloseSelector() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.782 -0400", hash_original_method = "4BED6A018F66CD694B83A1B1A043078B", hash_generated_method = "ABF60023E2E9F7678A99128AE0D791C3")
    @Override
    public final boolean isOpen() {
        boolean var613BBC4F15B812C0598465B212033A5E_1289059422 = (isOpen.get());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1866331389 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1866331389;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.783 -0400", hash_original_method = "B098D2E33834ACCBC46AD074E583FD9B", hash_generated_method = "1DAC4633BF53B5E6F3144CBB5D3B71D1")
    @Override
    public final SelectorProvider provider() {
        SelectorProvider varB4EAC82CA7396A68D541C85D26508E83_1672534307 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1672534307 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_1672534307.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1672534307;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.785 -0400", hash_original_method = "DC10B929A0DF63912817926BA3679882", hash_generated_method = "E1C3FEE38307690D08C6F550FA3942CB")
    protected final Set<SelectionKey> cancelledKeys() {
        Set<SelectionKey> varB4EAC82CA7396A68D541C85D26508E83_1712605694 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1712605694 = cancelledKeysSet;
        varB4EAC82CA7396A68D541C85D26508E83_1712605694.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1712605694;
        
        
    }

    
    protected abstract SelectionKey register(AbstractSelectableChannel channel,
            int operations, Object attachment);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.788 -0400", hash_original_method = "763883A5CF1B35837F10911316906562", hash_generated_method = "A5A6AF08F797A3B6BE188A70D7623223")
    protected final void deregister(AbstractSelectionKey key) {
        ((AbstractSelectableChannel) key.channel()).deregister(key);
        key.isValid = false;
        addTaint(key.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.789 -0400", hash_original_method = "AA766DB2603B8BA0677C23360DB2CC44", hash_generated_method = "8222DDE0C91F60DCC81236F2688EE27B")
    protected final void begin() {
        Thread.currentThread().pushInterruptAction$(wakeupRunnable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.790 -0400", hash_original_method = "6596DDA3D801AC8A1D2C849102101590", hash_generated_method = "0600DADCB34C678203658AE168281499")
    protected final void end() {
        Thread.currentThread().popInterruptAction$(wakeupRunnable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.790 -0400", hash_original_method = "7076984DBD0A39CC1D8943756DBBDDA2", hash_generated_method = "FC7B0A382737CE2C8C961E76FB41E3C7")
     void cancel(SelectionKey key) {
        {
            cancelledKeysSet.add(key);
        } 
        addTaint(key.getTaint());
        
        
            
        
    }

    
}

