package java.nio.channels;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class SelectionKey {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.167 -0500", hash_original_field = "EBC0869EFF30D5C8BE613FC946BA1AD7", hash_generated_field = "C7033B07AB2380EEC61C6B834AFE8243")

    public static final int OP_ACCEPT = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.170 -0500", hash_original_field = "636457CFB89B5B3335991CE64A9FB882", hash_generated_field = "98D8B6069299F205A6C0690AECE873DE")

    public static final int OP_CONNECT = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.173 -0500", hash_original_field = "FAFABCC820046F43A238617C0905202D", hash_generated_field = "D875CBDC7BEE6AE76B8093E3ABE67080")

    public static final int OP_READ = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.175 -0500", hash_original_field = "69A5A46D0A9CFF8D359B6273C2AA533B", hash_generated_field = "774DF0D205A7727252316C3B8AA23F6A")

    public static final int OP_WRITE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.178 -0500", hash_original_field = "CD4901CD0ECA070EC6EEA4569BB6F20E", hash_generated_field = "7B0B71636F0A6FD9185511547501EE96")

    private volatile Object attachment = null;

    /**
     * Constructs a new {@code SelectionKey}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.180 -0500", hash_original_method = "506BAEF14D6E9F731FF32E7686B78589", hash_generated_method = "F0644C046FE50CCFCA76332566892C03")
    
protected SelectionKey() {
    }

    /**
     * Attaches an object to this key. It is acceptable to attach {@code null},
     * this discards the old attachment.
     *
     * @param anObject
     *            the object to attach, or {@code null} to discard the current
     *            attachment.
     * @return the last attached object or {@code null} if no object has been
     *         attached.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.183 -0500", hash_original_method = "AFA38A9E30799729C39292277D62F43D", hash_generated_method = "B54AE609D7C0FC0B67C4C164D9302A9E")
    
public final Object attach(Object anObject) {
        Object oldAttachment = attachment;
        attachment = anObject;
        return oldAttachment;
    }

    /**
     * Gets the attached object.
     *
     * @return the attached object or {@code null} if no object has been
     *         attached.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.186 -0500", hash_original_method = "F29A40DBFBA770DAC2D3ED3DF7881B6F", hash_generated_method = "8BA2F3446477E1CEF6EBC6E7B1482BDB")
    
public final Object attachment() {
        return attachment;
    }

    /**
     * Cancels this key.
     * <p>
     * A key that has been canceled is no longer valid. Calling this method on
     * an already canceled key does nothing.
     * <p>
     * Calling this method is safe at any time. The call might block until
     * another ongoing call to a method of this selector has finished. The
     * reason is that it is synchronizing on the key set of the selector. After
     * this call finishes, the key will have been added to the selectors
     * canceled-keys set and will not be included in any future selects of this
     * selector.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.189 -0500", hash_original_method = "BA1BF94FB859172DDE80A7E9000639D0", hash_generated_method = "6D2C251EA0784ADEFD27C351E9E0B5A6")
    
public abstract void cancel();

    /**
     * Gets the channel of this key.
     *
     * @return the channel of this key.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.191 -0500", hash_original_method = "A96F47B526978A006380DE215C852EE6", hash_generated_method = "8FEDD3EB21EEFBE8F103B7BB3A0ADFEB")
    
public abstract SelectableChannel channel();

    /**
     * Gets this key's {@link SelectionKey interest set}. The returned set has
     * only those bits set that are valid for this key's channel.
     *
     * @return the interest set of this key.
     * @throws CancelledKeyException
     *             if the key has already been canceled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.193 -0500", hash_original_method = "78422C81123C4D37C8FE06F27419342C", hash_generated_method = "F65B80C6BA29ABE55D61E052EE9CA5D7")
    
public abstract int interestOps();

    /**
     * Sets the {@link SelectionKey interest set} for this key.
     *
     * @param operations
     *            the new interest set.
     * @return this key.
     * @throws IllegalArgumentException
     *             if a bit in {@code operations} is not in the set of
     *             {@link SelectableChannel#validOps() valid operations} of this
     *             key's channel.
     * @throws CancelledKeyException
     *             if the key has already been canceled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.196 -0500", hash_original_method = "80BDE0F6570E7C1C49E762ED6594C3D2", hash_generated_method = "873E1FA71A8833E8EB21E863581A8F49")
    
public abstract SelectionKey interestOps(int operations);

    /**
     * Indicates whether this key's channel is interested in the accept
     * operation and is ready to accept new connections. A call to this method
     * is equal to executing {@code (readyOps() & OP_ACCEPT) == OP_ACCEPT}.
     *
     * @return {@code true} if the channel is interested in the accept operation
     *         and is ready to accept new connections, {@code false} otherwise.
     * @throws CancelledKeyException
     *             if the key has already been canceled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.198 -0500", hash_original_method = "ED231557F3875B4504449502DA9771AC", hash_generated_method = "277DEE9DB38700130441807200B4F2BD")
    
public final boolean isAcceptable() {
        return (readyOps() & OP_ACCEPT) == OP_ACCEPT;
    }

    /**
     * Indicates whether this key's channel is interested in the connect
     * operation and is ready to connect. A call to this method is equal to
     * executing {@code (readyOps() & OP_CONNECT) == OP_CONNECT}.
     *
     * @return {@code true} if the channel is interested in the connect
     *         operation and is ready to connect, {@code false} otherwise.
     * @throws CancelledKeyException
     *             if the key has already been canceled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.201 -0500", hash_original_method = "2F2EE0183B49AF3C16598E47DE1FB088", hash_generated_method = "D843236A4EA7EB5401F715B6298F7961")
    
public final boolean isConnectable() {
        return (readyOps() & OP_CONNECT) == OP_CONNECT;
    }

    /**
     * Indicates whether this key's channel is interested in the read operation
     * and is ready to read. A call to this method is equal to executing
     * {@code (readyOps() & OP_READ) == OP_READ}.
     *
     * @return {@code true} if the channel is interested in the read operation
     *         and is ready to read, {@code false} otherwise.
     * @throws CancelledKeyException
     *             if the key has already been canceled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.203 -0500", hash_original_method = "B9D7CCBAB6757F436C28ADF7D4904FD5", hash_generated_method = "27947B142D3B5371E4A37141CC41BEF5")
    
public final boolean isReadable() {
        return (readyOps() & OP_READ) == OP_READ;
    }

    /**
     * Indicates whether this key is valid. A key is valid as long as it has not
     * been canceled.
     *
     * @return {@code true} if this key has not been canceled, {@code false}
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.206 -0500", hash_original_method = "F1240C06AF1BA9E648B2E780B8155F1C", hash_generated_method = "DEB105C1692FABA897B5C0B0EC6247FE")
    
public abstract boolean isValid();

    /**
     * Indicates whether this key's channel is interested in the write operation
     * and is ready to write. A call to this method is equal to executing
     * {@code (readyOps() & OP_WRITE) == OP_WRITE}.
     *
     * @return {@code true} if the channel is interested in the write operation
     *         and is ready to write, {@code false} otherwise.
     * @throws CancelledKeyException
     *             if the key has already been canceled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.208 -0500", hash_original_method = "FD6385C69AD88B8295913B1A01B9080B", hash_generated_method = "4EE9117D91CF5E1B1523A5C13C09F778")
    
public final boolean isWritable() {
        return (readyOps() & OP_WRITE) == OP_WRITE;
    }

    /**
     * Gets the set of operations that are ready. The returned set has only
     * those bits set that are valid for this key's channel.
     *
     * @return the operations for which this key's channel is ready.
     * @throws CancelledKeyException
     *             if the key has already been canceled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.211 -0500", hash_original_method = "D8A25344F20E8DE2EBB055E5538E1A27", hash_generated_method = "7694C63AEE61E2806F98612DA5B82C38")
    
public abstract int readyOps();

    /**
     * Gets the selector for which this key's channel is registered.
     *
     * @return the related selector.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.213 -0500", hash_original_method = "4643185428A8E030AC9F19E1ADCCCBAB", hash_generated_method = "04BCA10CE76B374DE12BB83FBF9321FC")
    
public abstract Selector selector();
}

