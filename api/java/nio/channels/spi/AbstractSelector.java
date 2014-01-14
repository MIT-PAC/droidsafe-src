package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractSelector extends Selector {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.936 -0500", hash_original_field = "7315FC1FE9FC9EFE3D8AD2B5E3CCD853", hash_generated_field = "1975670F7C5E1A3B0BE1CC3F39D52629")

    private final AtomicBoolean isOpen = new AtomicBoolean(true);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.938 -0500", hash_original_field = "6B7D498973D24EE245B343DF130AA1D4", hash_generated_field = "89E44FF0276DC637467C9A53214EFEF3")

    private SelectorProvider provider = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.940 -0500", hash_original_field = "BC188EB1D901AEB09BEC5642BF386968", hash_generated_field = "C16D69A091591918E37AAE11008C49F6")

    private final Set<SelectionKey> cancelledKeysSet = new HashSet<SelectionKey>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.780 -0400", hash_original_field = "33150D8ED2F1190449307B4DADDC93F3", hash_generated_field = "81FD2F18DE20D067CA30F74C258D7012")

    private final Runnable wakeupRunnable = new Runnable() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.780 -0400", hash_original_method = "7C4207C049033B8A840024AF7D6007E1", hash_generated_method = "DE46A52DF305552AEC6BF62783C2EE19")
        @Override
        public void run() {
            wakeup();
            
        }
        
};

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.948 -0500", hash_original_method = "56B85F67F1D1FE1953948CC1AC991A83", hash_generated_method = "790848F42B1331BEFC9F7748026193C5")
    
protected AbstractSelector(SelectorProvider selectorProvider) {
        provider = selectorProvider;
    }

    /**
     * Closes this selector. This method does nothing if this selector is
     * already closed. The actual closing must be implemented by subclasses in
     * {@code implCloseSelector()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.951 -0500", hash_original_method = "9F8B8FD2F0A9D2575659CC3A12134435", hash_generated_method = "0A39B328F996F8CAB33E177988E579AB")
    
@Override
    public final void close() throws IOException {
        if (isOpen.getAndSet(false)) {
            implCloseSelector();
        }
    }

    /**
     * Implements the closing of this channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.953 -0500", hash_original_method = "5FE7DCB0F468BAD1C9BA7F9A5F7A9F36", hash_generated_method = "870A346C768AC2510FED8033A3A2756C")
    
protected abstract void implCloseSelector() throws IOException;

    /**
     * Returns true if this selector is open.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.956 -0500", hash_original_method = "4BED6A018F66CD694B83A1B1A043078B", hash_generated_method = "39B1B0C30A76F920C21D6AFE814BD237")
    
@Override
    public final boolean isOpen() {
        return isOpen.get();
    }

    /**
     * Returns this selector's provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.959 -0500", hash_original_method = "B098D2E33834ACCBC46AD074E583FD9B", hash_generated_method = "B1D05E577565AFAE7DA83FF4AD307897")
    
@Override
    public final SelectorProvider provider() {
        return provider;
    }

    /**
     * Returns this channel's set of canceled selection keys.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.962 -0500", hash_original_method = "DC10B929A0DF63912817926BA3679882", hash_generated_method = "79FB30E575A87660AD930CAE78043B1A")
    
protected final Set<SelectionKey> cancelledKeys() {
        return cancelledKeysSet;
    }

    /**
     * Registers {@code channel} with this selector.
     *
     * @param operations the {@link SelectionKey interest set} of {@code
     *     channel}.
     * @param attachment the attachment for the selection key.
     * @return the key related to the channel and this selector.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.964 -0500", hash_original_method = "4F5EED7EF37B890A788F78CA5BD260CF", hash_generated_method = "A2B54A7B7C7864BE343F8A7FAAF5ED4D")
    
protected abstract SelectionKey register(AbstractSelectableChannel channel,
            int operations, Object attachment);

    /**
     * Deletes the key from the channel's key set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.967 -0500", hash_original_method = "763883A5CF1B35837F10911316906562", hash_generated_method = "B6C4925B86C37D98F530F9C5F3E47BF6")
    
protected final void deregister(AbstractSelectionKey key) {
        ((AbstractSelectableChannel) key.channel()).deregister(key);
        key.isValid = false;
    }

    /**
     * Indicates the beginning of a code section that includes an I/O operation
     * that is potentially blocking. After this operation, the application
     * should invoke the corresponding {@code end(boolean)} method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.969 -0500", hash_original_method = "AA766DB2603B8BA0677C23360DB2CC44", hash_generated_method = "AB884261BF3AFEB2C0C370CDC17EDBCA")
    
protected final void begin() {
        Thread.currentThread().pushInterruptAction$(wakeupRunnable);
    }

    /**
     * Indicates the end of a code section that has been started with
     * {@code begin()} and that includes a potentially blocking I/O operation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.972 -0500", hash_original_method = "6596DDA3D801AC8A1D2C849102101590", hash_generated_method = "568D7E8A31D733EE826E2A65E2BD5D08")
    
protected final void end() {
        Thread.currentThread().popInterruptAction$(wakeupRunnable);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.974 -0500", hash_original_method = "7076984DBD0A39CC1D8943756DBBDDA2", hash_generated_method = "7076984DBD0A39CC1D8943756DBBDDA2")
    
void cancel(SelectionKey key) {
        synchronized (cancelledKeysSet) {
            cancelledKeysSet.add(key);
        }
    }
    
}

