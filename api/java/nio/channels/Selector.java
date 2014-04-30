package java.nio.channels;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

public abstract class Selector {

    /**
     * Returns a selector returned by {@link SelectorProvider#provider}'s
     * {@link SelectorProvider#openSelector} method.
     *
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSComment("IO movement methodName")
    @DSSafe(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.528 -0500", hash_original_method = "D2B63EBEB5E56482EA1EC71E4ADC6B8F", hash_generated_method = "D9D2632C8FA47BFA91F51C1B152ECC92")
    
public static Selector open() throws IOException {
        return SelectorProvider.provider().openSelector();
    }

    /**
     * Constructs a new {@code Selector}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.530 -0500", hash_original_method = "9524E27FB2E16D9605DE08EA9659D1CB", hash_generated_method = "A38AB5A6C71920FB58A9669AE4FBE902")
    
protected Selector() {
    }

    /**
     * Closes this selector. Ongoing calls to the {@code select} methods of this
     * selector will get interrupted. This interruption behaves as if the
     * {@link #wakeup()} method of this selector is called. After this, all keys
     * that are still valid are invalidated and their channels are unregistered.
     * All resources held by this selector are released.
     * <p>
     * Any further attempt of using this selector after this method has been
     * called (except calling {@link #close()} or {@link #wakeup()}) results in
     * a {@link ClosedSelectorException} being thrown.
     *
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.533 -0500", hash_original_method = "4E507319564A7E0BFD2A58D57A800811", hash_generated_method = "2228FF14FE1AFC53EB7399AA035D1509")
    
public abstract void close() throws IOException;

    /**
     * Indicates whether this selector is open.
     *
     * @return {@code true} if this selector is not closed, {@code false}
     *         otherwise.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.535 -0500", hash_original_method = "3859B86249112A7F92BB670FE39C106E", hash_generated_method = "A6E9E1944A6F13F6632987071763E93D")
    
public abstract boolean isOpen();

    /**
     * Gets the set of registered keys. The set is immutable and is not thread-
     * safe.
     *
     * @return the set of registered keys.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.537 -0500", hash_original_method = "3D740AA82C43C55A0EA14A5D7A87B32C", hash_generated_method = "406D8244664E464C6CFD740BCBBB050C")
    
public abstract Set<SelectionKey> keys();

    /**
     * Gets the provider of this selector.
     *
     * @return the provider of this selector.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.540 -0500", hash_original_method = "16691AB71F358568043BE374C6495F90", hash_generated_method = "98718A80D4D5481D996D395828ED0646")
    
public abstract SelectorProvider provider();

    /**
     * Detects if any of the registered channels is ready for I/O operations
     * according to its {@link SelectionKey interest set}. This method does not
     * return until at least one channel is ready, {@link #wakeup()} is
     * invoked or the calling thread is interrupted.
     *
     * @return the number of channels that are ready for operation.
     * @throws IOException
     *             if an I/O error occurs.
     * @throws ClosedSelectorException
     *             if the selector is closed.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.543 -0500", hash_original_method = "946B8B6001771822B58A1F20DD3DE098", hash_generated_method = "4E0C41B9FCDEF1035F599F68EFF8A1D7")
    
public abstract int select() throws IOException;

    /**
     * Detects if any of the registered channels is ready for I/O operations
     * according to its {@link SelectionKey interest set}. This method does not
     * return until at least one channel is ready, {@link #wakeup()} is invoked,
     * the calling thread is interrupted or the specified {@code timeout}
     * expires.
     *
     * @param timeout
     *            the non-negative timeout in millisecond; 0 will block forever
     *            if no channels get ready.
     * @return the number of channels that are ready for operation.
     * @throws ClosedSelectorException
     *             if the selector is closed.
     * @throws IllegalArgumentException
     *             if the given timeout argument is less than zero.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.545 -0500", hash_original_method = "740A715E9DCC21A0FC2516F124091346", hash_generated_method = "1DC0A0B3464FE703AF89DD7517B7B817")
    
public abstract int select(long timeout) throws IOException;

    /**
     * Gets the selection keys whose channels are ready for operation. The set
     * is not thread-safe and no keys may be added to it. Removing keys is
     * allowed.
     *
     * @return the selection keys whose channels are ready for operation.
     * @throws ClosedSelectorException
     *             if the selector is closed.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.548 -0500", hash_original_method = "490F9E171813FF024137F574377AE5EF", hash_generated_method = "7546BF6D634D14B4D39D7777D52810AA")
    
public abstract Set<SelectionKey> selectedKeys();

    /**
     * Detects if any of the registered channels is ready for I/O operations
     * according to its {@link SelectionKey interest set}. This operation will
     * return immediately.
     *
     * @return the number of channels that are ready for operation, 0 if none is
     *         ready.
     * @throws IOException
     *             if an I/O error occurrs.
     * @throws ClosedSelectorException
     *             if the selector is closed.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.551 -0500", hash_original_method = "F933A052DB439CAF9A71EC65B043D50B", hash_generated_method = "6B0F786ECDCF31AA21DDEF960F56D712")
    
public abstract int selectNow() throws IOException;

    /**
     * Forces blocked {@code select} operations to return immediately.
     * <p>
     * If no {@code select} operation is blocked when {@code wakeup()} is called
     * then the next {@code select} operation will return immediately. This can
     * be undone by a call to {@code selectNow()}; after calling
     * {@code selectNow()}, a subsequent call of {@code select} can block
     * again.
     *
     * @return this selector.
     * @throws ClosedSelectorException
     *             if the selector is closed.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.554 -0500", hash_original_method = "8C31B4EE7A3DB9AE0B77B5A6C5713FF8", hash_generated_method = "F9518A2DA2076A59BF0D3FBE2971D639")
    
public abstract Selector wakeup();
    
}

