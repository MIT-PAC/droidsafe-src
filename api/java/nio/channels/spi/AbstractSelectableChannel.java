package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.IllegalSelectorException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSelectableChannel extends SelectableChannel {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.087 -0500", hash_original_field = "1FAD89DFFD062186ACED73A3BBE8E6CF", hash_generated_field = "0234634A410EB36D3E632222798EC314")

    private  SelectorProvider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.089 -0500", hash_original_field = "F8566F79FEAED370132E2A7401856489", hash_generated_field = "3B26D8208E36A3AF954A2D369F214698")

    private List<SelectionKey> keyList = new ArrayList<SelectionKey>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.091 -0500", hash_original_field = "CF901D17374CD5132A1B66ECD3B7245E", hash_generated_field = "9DDF47310598FEE3BE8DF77A18102341")

    private final Object blockingLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.094 -0500", hash_original_field = "FBC5E3B60AE9541955B3D463A523710C", hash_generated_field = "FBC5E3B60AE9541955B3D463A523710C")

    boolean isBlocking = true;

    /**
     * Constructs a new {@code AbstractSelectableChannel}.
     *
     * @param selectorProvider
     *            the selector provider that creates this channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.096 -0500", hash_original_method = "C1ED2F1D0A9F053BD27B8788D8E263F6", hash_generated_method = "1034751EBDC1BC10EA8BD3170D796738")
    
protected AbstractSelectableChannel(SelectorProvider selectorProvider) {
        provider = selectorProvider;
    }

    /**
     * Returns the selector provider that has created this channel.
     *
     * @see java.nio.channels.SelectableChannel#provider()
     * @return this channel's selector provider.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.099 -0500", hash_original_method = "B098D2E33834ACCBC46AD074E583FD9B", hash_generated_method = "B1D05E577565AFAE7DA83FF4AD307897")
    
@Override
    public final SelectorProvider provider() {
        return provider;
    }

    /**
     * Indicates whether this channel is registered with one or more selectors.
     *
     * @return {@code true} if this channel is registered with a selector,
     *         {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.101 -0500", hash_original_method = "455A665D6CB2D7E9E28AF0A0296346A0", hash_generated_method = "A5E8AB4487CE891B852303ADDC5DDD94")
    
@Override
    synchronized public final boolean isRegistered() {
        return !keyList.isEmpty();
    }

    /**
     * Gets this channel's selection key for the specified selector.
     *
     * @param selector
     *            the selector with which this channel has been registered.
     * @return the selection key for the channel or {@code null} if this channel
     *         has not been registered with {@code selector}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.104 -0500", hash_original_method = "4195F78E36942EF5DA6AFD3959F769A2", hash_generated_method = "8400A7BBA95E6C235EBBE66866C59038")
    
@Override
    synchronized public final SelectionKey keyFor(Selector selector) {
        for (SelectionKey key : keyList) {
            if (key != null && key.selector() == selector) {
                return key;
            }
        }
        return null;
    }

    /**
     * Registers this channel with the specified selector for the specified
     * interest set. If the channel is already registered with the selector, the
     * {@link SelectionKey interest set} is updated to {@code interestSet} and
     * the corresponding selection key is returned. If the channel is not yet
     * registered, this method calls the {@code register} method of
     * {@code selector} and adds the selection key to this channel's key set.
     *
     * @param selector
     *            the selector with which to register this channel.
     * @param interestSet
     *            this channel's {@link SelectionKey interest set}.
     * @param attachment
     *            the object to attach, can be {@code null}.
     * @return the selection key for this registration.
     * @throws CancelledKeyException
     *             if this channel is registered but its key has been canceled.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws IllegalArgumentException
     *             if {@code interestSet} is not supported by this channel.
     * @throws IllegalBlockingModeException
     *             if this channel is in blocking mode.
     * @throws IllegalSelectorException
     *             if this channel does not have the same provider as the given
     *             selector.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.108 -0500", hash_original_method = "CA2D38B16FDF21D8F80456FE85BBCC03", hash_generated_method = "6F7C657E2C264E9D3768D58F08A9ECA4")
    
@Override
    public final SelectionKey register(Selector selector, int interestSet,
            Object attachment) throws ClosedChannelException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
        if (!((interestSet & ~validOps()) == 0)) {
            throw new IllegalArgumentException();
        }

        synchronized (blockingLock) {
            if (isBlocking) {
                throw new IllegalBlockingModeException();
            }
            if (!selector.isOpen()) {
                if (interestSet == 0) {
                    // throw ISE exactly to keep consistency
                    throw new IllegalSelectorException();
                }
                // throw NPE exactly to keep consistency
                throw new NullPointerException();
            }
            SelectionKey key = keyFor(selector);
            if (key == null) {
                key = ((AbstractSelector) selector).register(this, interestSet, attachment);
                keyList.add(key);
            } else {
                if (!key.isValid()) {
                    throw new CancelledKeyException();
                }
                key.interestOps(interestSet);
                key.attach(attachment);
            }
            return key;
        }
    }

    /**
     * Implements the channel closing behavior. Calls
     * {@code implCloseSelectableChannel()} first, then loops through the list
     * of selection keys and cancels them, which unregisters this channel from
     * all selectors it is registered with.
     *
     * @throws IOException
     *             if a problem occurs while closing the channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.110 -0500", hash_original_method = "924900C80DDDFF3B15A21AACED0AEBE3", hash_generated_method = "656BF99FA2C7C351E6279C4A62217B34")
    
@Override
    synchronized protected final void implCloseChannel() throws IOException {
        implCloseSelectableChannel();
        for (SelectionKey key : keyList) {
            if (key != null) {
                key.cancel();
            }
        }
    }

    /**
     * Implements the closing function of the SelectableChannel. This method is
     * called from {@code implCloseChannel()}.
     *
     * @throws IOException
     *             if an I/O exception occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.113 -0500", hash_original_method = "E2C0C5827942DAA234C491A2081920DD", hash_generated_method = "9F9DA4AFA37B1972404DE81704FEB67A")
    
protected abstract void implCloseSelectableChannel() throws IOException;

    /**
     * Indicates whether this channel is in blocking mode.
     *
     * @return {@code true} if this channel is blocking, {@code false}
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.116 -0500", hash_original_method = "7EB3EC6F0C2C581F383895C93FAEB7C8", hash_generated_method = "D7EDE87CBD0E259F5F70720029B3DC18")
    
@Override
    public final boolean isBlocking() {
        synchronized (blockingLock) {
            return isBlocking;
        }
    }

    /**
     * Gets the object used for the synchronization of {@code register} and
     * {@code configureBlocking}.
     *
     * @return the synchronization object.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.119 -0500", hash_original_method = "CF2B6308C435D16AFC21EE86C3F92787", hash_generated_method = "FA36D79444E8DDCA69DD1A6EA5C660CB")
    
@Override
    public final Object blockingLock() {
        return blockingLock;
    }

    /**
     * Sets the blocking mode of this channel. A call to this method blocks if
     * other calls to this method or to {@code register} are executing. The
     * actual setting of the mode is done by calling
     * {@code implConfigureBlocking(boolean)}.
     *
     * @see java.nio.channels.SelectableChannel#configureBlocking(boolean)
     * @param blockingMode
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
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.122 -0500", hash_original_method = "C1D21D3B957CE63BA941CEBC7A89647F", hash_generated_method = "21B65639256F1F8CA1123E5574C8AC64")
    
@Override
    public final SelectableChannel configureBlocking(boolean blockingMode) throws IOException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
        synchronized (blockingLock) {
            if (isBlocking == blockingMode) {
                return this;
            }
            if (blockingMode && containsValidKeys()) {
                throw new IllegalBlockingModeException();
            }
            implConfigureBlocking(blockingMode);
            isBlocking = blockingMode;
        }
        return this;
    }

    /**
     * Implements the configuration of blocking/non-blocking mode.
     *
     * @param blocking true for blocking, false for non-blocking.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.124 -0500", hash_original_method = "C63B227F52A3721B3F3AB5CE8F9A6DBB", hash_generated_method = "155C40108F0205E4B01B2645BCEC3E31")
    
protected abstract void implConfigureBlocking(boolean blocking) throws IOException;

    /*
     * package private for deregister method in AbstractSelector.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.126 -0500", hash_original_method = "5E0A774ABE1807BF9448EF86554C6BF7", hash_generated_method = "C182BCE8A84B5B9393DEA71114552EC8")
    
synchronized void deregister(SelectionKey k) {
        if (keyList != null) {
            keyList.remove(k);
        }
    }

    /**
     * Returns true if the keyList contains at least 1 valid key and false
     * otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.129 -0500", hash_original_method = "57F0CA9634BB6BE72AE1A3DBAB2B8264", hash_generated_method = "7D907C63E24257235EF3D2BDDB046ED5")
    
private synchronized boolean containsValidKeys() {
        for (SelectionKey key : keyList) {
            if (key != null && key.isValid()) {
                return true;
            }
        }
        return false;
    }
    
}

