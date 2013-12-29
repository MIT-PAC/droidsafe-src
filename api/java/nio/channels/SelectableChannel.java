package java.nio.channels;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.nio.channels.spi.SelectorProvider;





public abstract class SelectableChannel extends AbstractInterruptibleChannel implements Channel {

    /**
     * Constructs a new {@code SelectableChannel}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:36.120 -0500", hash_original_method = "134796BB126CC075543A5858F980D0FB", hash_generated_method = "BC0C1F6680988B6C0F8648856F2CE483")
    protected SelectableChannel() {
    }

    /**
     * Gets the blocking lock which synchronizes the {@code configureBlocking}
     * and {@code register} methods.
     *
     * @return the blocking object as lock.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:36.121 -0500", hash_original_method = "2E192193615D7EEFA25C6422BFD6D26E", hash_generated_method = "24811C6B2D8CCA17562F0EF8B81873FA")
    public abstract Object blockingLock();

    /**
     * Sets the blocking mode of this channel. A call to this method blocks if
     * other calls to this method or to a {@code register} method are executing.
     * The new blocking mode is valid for calls to other methods that are
     * invoked after the call to this method. If other methods are already
     * executing when this method is called, they still have the old mode and
     * the call to this method might block depending on the implementation.
     *
     * @param block
     *            {@code true} for setting this channel's mode to blocking,
     *            {@code false} to set it to non-blocking.
     * @return this channel.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws IllegalBlockingModeException
     *             if {@code block} is {@code true} and this channel has been
     *             registered with at least one selector.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:36.122 -0500", hash_original_method = "21DB17E6C51E37682F8EA397C436E96E", hash_generated_method = "BA37478B634729C2D7E0A5B08FB466F0")
    public abstract SelectableChannel configureBlocking(boolean block)
            throws IOException;

    /**
     * Indicates whether this channel is in blocking mode.
     *
     * @return {@code true} if this channel is blocking, undefined if this
     *         channel is closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:36.122 -0500", hash_original_method = "7E9BC8041DAE305D9005BF04D0F90DF9", hash_generated_method = "19A54000AD0D6086A655B0B2C02272D6")
    public abstract boolean isBlocking();

    /**
     * Indicates whether this channel is registered with at least one selector.
     *
     * @return {@code true} if this channel is registered, {@code false}
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:36.123 -0500", hash_original_method = "B09F725F9534BF401052EB6B0DDF05E6", hash_generated_method = "6304460E41687883CFEC11BCA89CBC0B")
    public abstract boolean isRegistered();

    /**
     * Gets this channel's selection key for the specified selector.
     *
     * @param sel
     *            the selector with which this channel has been registered.
     * @return the selection key for the channel or {@code null} if this channel
     *         has not been registered with {@code sel}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:36.124 -0500", hash_original_method = "E142EAADB6D6B83087D91F829F1AAF88", hash_generated_method = "04C1D3917ABB4610130E622046B2E5E0")
    public abstract SelectionKey keyFor(Selector sel);

    /**
     * Gets the provider of this channel.
     *
     * @return the provider of this channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:36.125 -0500", hash_original_method = "16691AB71F358568043BE374C6495F90", hash_generated_method = "98718A80D4D5481D996D395828ED0646")
    public abstract SelectorProvider provider();

    /**
     * Registers this channel with the specified selector for the specified
     * interest set. If the channel is already registered with the selector, the
     * corresponding selection key is returned but the
     * {@link SelectionKey interest set} is updated to {@code operations}. The
     * returned key is canceled if the channel is closed while registering is in
     * progress.
     * <p>
     * Calling this method is valid at any time. If another thread executes this
     * method or the {@code configureBlocking(boolean} method then this call is
     * blocked until the other call finishes. After that, it will synchronize on
     * the key set of the selector and thus may again block if other threads
     * also hold locks on the key set of the same selector.
     * <p>
     * Calling this method is equivalent to calling
     * {@code register(selector, operations, null)}.
     *
     * @param selector
     *            the selector with which to register this channel.
     * @param operations
     *            this channel's {@link SelectionKey interest set}.
     * @return the selection key for this registration.
     * @throws ClosedChannelException
     *             if the channel is closed.
     * @throws IllegalBlockingModeException
     *             if the channel is in blocking mode.
     * @throws IllegalSelectorException
     *             if this channel does not have the same provider as the given
     *             selector.
     * @throws CancelledKeyException
     *             if this channel is registered but its key has been canceled.
     * @throws IllegalArgumentException
     *             if the operation given is not supported by this channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:36.126 -0500", hash_original_method = "9EF0D8B0DC0E3104C0F2D3C59F2DDC24", hash_generated_method = "1C9A11BE9729A3914363B7EB05FAC26C")
    public final SelectionKey register(Selector selector, int operations)
            throws ClosedChannelException {
        return register(selector, operations, null);
    }

    /**
     * Registers this channel with the specified selector for the specified
     * interest set and an object to attach. If the channel is already
     * registered with the selector, the corresponding selection key is returned
     * but its {@link SelectionKey interest set} is updated to {@code ops} and
     * the attached object is updated to {@code att}. The returned key is
     * canceled if the channel is closed while registering is in progress.
     * <p>
     * Calling this method is valid at any time. If another thread executes this
     * method or the {@code configureBlocking(boolean)} method then this call is
     * blocked until the other call finishes. After that, it will synchronize on
     * the key set of the selector and thus may again block if other threads
     * also hold locks on the key set of the same selector.
     *
     * @param sel
     *            the selector with which to register this channel.
     * @param ops
     *            this channel's {@link SelectionKey interest set}.
     * @param att
     *            the object to attach, can be {@code null}.
     * @return the selection key for this registration.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws IllegalArgumentException
     *             if {@code ops} is not supported by this channel.
     * @throws IllegalBlockingModeException
     *             if this channel is in blocking mode.
     * @throws IllegalSelectorException
     *             if this channel does not have the same provider as the given
     *             selector.
     * @throws CancelledKeyException
     *             if this channel is registered but its key has been canceled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:36.127 -0500", hash_original_method = "779FC9C1152041835F6C6467E1F8DA69", hash_generated_method = "80731282758076702486D2DCEAF1F1C8")
    public abstract SelectionKey register(Selector sel, int ops, Object att)
            throws ClosedChannelException;

    /**
     * Gets the set of valid {@link SelectionKey operations} of this channel.
     * Instances of a concrete channel class always return the same value.
     *
     * @return the set of operations that this channel supports.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:36.128 -0500", hash_original_method = "33B79DBFF75C6C01F6D678C6A0E94BA6", hash_generated_method = "2ACF24C06FF02F12A8656ACBE4F244F6")
    public abstract int validOps();

    
}

