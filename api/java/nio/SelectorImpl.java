package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static java.nio.channels.SelectionKey.OP_ACCEPT;
import static java.nio.channels.SelectionKey.OP_CONNECT;
import static java.nio.channels.SelectionKey.OP_READ;
import static java.nio.channels.SelectionKey.OP_WRITE;
import static libcore.io.OsConstants.POLLIN;
import static libcore.io.OsConstants.POLLOUT;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.IllegalSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.AbstractSelectionKey;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UnsafeArrayList;

import libcore.io.ErrnoException;
import libcore.io.IoBridge;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import libcore.io.StructPollfd;

final class SelectorImpl extends AbstractSelector {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.977 -0500", hash_original_field = "4799F2FA87D10E2424DB0D9E99F61148", hash_generated_field = "6DE612B35C9E8808CBEC2658E9286A57")

    final Object keysLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.979 -0500", hash_original_field = "BC6F6BAB7C8D703BA0EF1E6FB9669BEF", hash_generated_field = "FC886FA77928694F4640D640BCFDF7BE")

    private final Set<SelectionKeyImpl> mutableKeys = new HashSet<SelectionKeyImpl>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.982 -0500", hash_original_field = "0A023B17E701A8F999194659EECDACA7", hash_generated_field = "3DBE34F9B4C5E57002A17A3BD0063AA5")

    private final Set<SelectionKey> unmodifiableKeys = Collections
            .<SelectionKey>unmodifiableSet(mutableKeys);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.984 -0500", hash_original_field = "28E6010F5DD2CB1505084E056C78CC21", hash_generated_field = "2D8093EE2318D28CDED981CA87DED90A")

    private final Set<SelectionKey> mutableSelectedKeys = new HashSet<SelectionKey>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.987 -0500", hash_original_field = "3EF55FCF65B970351E0A63253C122DCE", hash_generated_field = "451F342BD781ADBAA504C0DDB5A78C6B")

    private final Set<SelectionKey> selectedKeys
            = new UnaddableSet<SelectionKey>(mutableSelectedKeys);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.989 -0500", hash_original_field = "3FD1D438F12B39F9D670429500156791", hash_generated_field = "6285C31CC7936F0AB3F1C69023A1F29D")

    private  FileDescriptor wakeupIn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.991 -0500", hash_original_field = "898092ACAD7246C6EF6B8C3645851C5F", hash_generated_field = "B95606F2D0BB7B9FC7D15F5B7CD880CE")

    private  FileDescriptor wakeupOut;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.994 -0500", hash_original_field = "2B7103EC06FD9EFCB085BDE297812B2F", hash_generated_field = "EFB3CC6DFEED71DE9DAD42AA06EB7441")

    private final UnsafeArrayList<StructPollfd> pollFds = new UnsafeArrayList<StructPollfd>(StructPollfd.class, 8);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.997 -0500", hash_original_method = "E76FB669EB1C2C846C756C0996AB21F1", hash_generated_method = "9AA6D092B939DA82EFB2614C2E4D3024")
    
public SelectorImpl(SelectorProvider selectorProvider) throws IOException {
        super(selectorProvider);

        /*
         * Create a pipes to trigger wakeup. We can't use a NIO pipe because it
         * would be closed if the selecting thread is interrupted. Also
         * configure the pipe so we can fully drain it without blocking.
         */
        try {
            FileDescriptor[] pipeFds = Libcore.os.pipe();
            wakeupIn = pipeFds[0];
            wakeupOut = pipeFds[1];
            IoUtils.setBlocking(wakeupIn, false);
            pollFds.add(new StructPollfd());
            setPollFd(0, wakeupIn, POLLIN, null);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.001 -0500", hash_original_method = "79B2402F6F8D60BF0FF9B9A0443FD747", hash_generated_method = "1C1D97980251BCA0A6F421AA01E3DF2A")
    
@Override protected void implCloseSelector() throws IOException {
        wakeup();
        synchronized (this) {
            synchronized (unmodifiableKeys) {
                synchronized (selectedKeys) {
                    IoUtils.close(wakeupIn);
                    IoUtils.close(wakeupOut);
                    doCancel();
                    for (SelectionKey sk : mutableKeys) {
                        deregister((AbstractSelectionKey) sk);
                    }
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.004 -0500", hash_original_method = "9A9EE2D9A12F669E7C7AAB88B3AE3EAA", hash_generated_method = "61EBCDE3A7A8BBB82D9E0D7BFD039487")
    
@Override protected SelectionKey register(AbstractSelectableChannel channel,
            int operations, Object attachment) {
        if (!provider().equals(channel.provider())) {
            throw new IllegalSelectorException();
        }
        synchronized (this) {
            synchronized (unmodifiableKeys) {
                SelectionKeyImpl selectionKey = new SelectionKeyImpl(channel, operations,
                        attachment, this);
                mutableKeys.add(selectionKey);
                ensurePollFdsCapacity();
                return selectionKey;
            }
        }
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.006 -0500", hash_original_method = "6BEEFC0027B3DD3AFC5CFC7324737402", hash_generated_method = "19F9D67FA1C2CC54A025B01F0B15EFB8")
    
@Override public synchronized Set<SelectionKey> keys() {
        checkClosed();
        return unmodifiableKeys;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.009 -0500", hash_original_method = "16DB849132AADD2CAC6FB8494D5700D0", hash_generated_method = "A613AD8F32CDABEF7079BFDAD53BDDAD")
    
private void checkClosed() {
        if (!isOpen()) {
            throw new ClosedSelectorException();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.011 -0500", hash_original_method = "0F4ACBA61BED328D03506D362DC34EE4", hash_generated_method = "FAE8ABB4E549225250D24D24E9BDFDFC")
    
@Override public int select() throws IOException {
        // Blocks until some fd is ready.
        return selectInternal(-1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.014 -0500", hash_original_method = "38CB8C7854E3817F0A25B22A5C37D9C3", hash_generated_method = "54B30DFFB09C6AF6E620D23D97BE0087")
    
@Override public int select(long timeout) throws IOException {
        if (timeout < 0) {
            throw new IllegalArgumentException();
        }
        // Our timeout is interpreted differently to Unix's --- 0 means block. See selectNow.
        return selectInternal((timeout == 0) ? -1 : timeout);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.016 -0500", hash_original_method = "06C4B09F10BB426C607790AD420FF9C5", hash_generated_method = "6CA5D0B7ABB41D178CF5BA122681A45F")
    
@Override public int selectNow() throws IOException {
        return selectInternal(0);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.019 -0500", hash_original_method = "07E877B82AC1C68A90F5E02CD6388406", hash_generated_method = "5A95E6835843354EBC1E779EE93C738A")
    
private int selectInternal(long timeout) throws IOException {
        checkClosed();
        synchronized (this) {
            synchronized (unmodifiableKeys) {
                synchronized (selectedKeys) {
                    doCancel();
                    boolean isBlock = (timeout != 0);
                    synchronized (keysLock) {
                        preparePollFds();
                    }
                    int rc;
                    try {
                        if (isBlock) {
                            begin();
                        }
                        try {
                            rc = Libcore.os.poll(pollFds.array(), (int) timeout);
                        } catch (ErrnoException errnoException) {
                            throw errnoException.rethrowAsIOException();
                        }
                    } finally {
                        if (isBlock) {
                            end();
                        }
                    }

                    int readyCount = (rc > 0) ? processPollFds() : 0;
                    readyCount -= doCancel();
                    return readyCount;
                }
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.021 -0500", hash_original_method = "1864B10FEC667AA8A534CE9CC6FD0BC2", hash_generated_method = "ED40BCE6B992E202F2D560DBB7A1C73F")
    
private void setPollFd(int i, FileDescriptor fd, int events, Object object) {
        StructPollfd pollFd = pollFds.get(i);
        pollFd.fd = fd;
        pollFd.events = (short) events;
        pollFd.userData = object;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.024 -0500", hash_original_method = "C2C79FE5727E3E67D8033155BDE5FA42", hash_generated_method = "1A5543532813873332AC1DD3AEA580B7")
    
private void preparePollFds() {
        int i = 1; // Our wakeup pipe comes before all the user's fds.
        for (SelectionKeyImpl key : mutableKeys) {
            int interestOps = key.interestOpsNoCheck();
            short eventMask = 0;
            if (((OP_ACCEPT | OP_READ) & interestOps) != 0) {
                eventMask |= POLLIN;
            }
            if (((OP_CONNECT | OP_WRITE) & interestOps) != 0) {
                eventMask |= POLLOUT;
            }
            if (eventMask != 0) {
                setPollFd(i++, ((FileDescriptorChannel) key.channel()).getFD(), eventMask, key);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.026 -0500", hash_original_method = "561794DF92118E00B9893BD515660DDC", hash_generated_method = "13B9BF3F2C85C7F7A5EDE15E23D497C6")
    
private void ensurePollFdsCapacity() {
        // We need one slot for each element of mutableKeys, plus one for the wakeup pipe.
        while (pollFds.size() < mutableKeys.size() + 1) {
            pollFds.add(new StructPollfd());
        }
    }

    /**
     * Updates the key ready ops and selected key set.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.030 -0500", hash_original_method = "5DC934A1F65A8C13AADF3FD37642D2BD", hash_generated_method = "0A6A7C8D7ECB8D2FD01AD136CFCB11FF")
    
private int processPollFds() throws IOException {
        if (pollFds.get(0).revents == POLLIN) {
            // Read bytes from the wakeup pipe until the pipe is empty.
            byte[] buffer = new byte[8];
            while (IoBridge.read(wakeupIn, buffer, 0, 1) > 0) {
            }
        }

        int readyKeyCount = 0;
        for (int i = 1; i < pollFds.size(); ++i) {
            StructPollfd pollFd = pollFds.get(i);
            if (pollFd.revents == 0) {
                continue;
            }
            if (pollFd.fd == null) {
                break;
            }

            SelectionKeyImpl key = (SelectionKeyImpl) pollFd.userData;

            pollFd.fd = null;
            pollFd.userData = null;

            int ops = key.interestOpsNoCheck();
            int selectedOp = 0;
            if ((pollFd.revents & POLLIN) != 0) {
                selectedOp = ops & (OP_ACCEPT | OP_READ);
            } else if ((pollFd.revents & POLLOUT) != 0) {
                if (key.isConnected()) {
                    selectedOp = ops & OP_WRITE;
                } else {
                    selectedOp = ops & OP_CONNECT;
                }
            }

            if (selectedOp != 0) {
                boolean wasSelected = mutableSelectedKeys.contains(key);
                if (wasSelected && key.readyOps() != selectedOp) {
                    key.setReadyOps(key.readyOps() | selectedOp);
                    ++readyKeyCount;
                } else if (!wasSelected) {
                    key.setReadyOps(selectedOp);
                    mutableSelectedKeys.add(key);
                    ++readyKeyCount;
                }
            }
        }

        return readyKeyCount;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.033 -0500", hash_original_method = "0EB011B4E4087026D6BA472324142821", hash_generated_method = "22D639DB95DB32BBCBC318EA4F80B5B4")
    
@Override public synchronized Set<SelectionKey> selectedKeys() {
        checkClosed();
        return selectedKeys;
    }

    /**
     * Removes cancelled keys from the key set and selected key set, and
     * deregisters the corresponding channels. Returns the number of keys
     * removed from the selected key set.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.035 -0500", hash_original_method = "ECFBB6A45EE52702BEFF3EF78A8EE9C3", hash_generated_method = "5147012B6A9D5605058E46ED1E5CC400")
    
private int doCancel() {
        int deselected = 0;

        Set<SelectionKey> cancelledKeys = cancelledKeys();
        synchronized (cancelledKeys) {
            if (cancelledKeys.size() > 0) {
                for (SelectionKey currentKey : cancelledKeys) {
                    mutableKeys.remove(currentKey);
                    deregister((AbstractSelectionKey) currentKey);
                    if (mutableSelectedKeys.remove(currentKey)) {
                        deselected++;
                    }
                }
                cancelledKeys.clear();
            }
        }

        return deselected;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.037 -0500", hash_original_method = "BDB632D034A5FFBF79564927E2AB1FFB", hash_generated_method = "4B8459B46FD08D0EC6985BF5D222E0AC")
    
@Override public Selector wakeup() {
        try {
            Libcore.os.write(wakeupOut, new byte[] { 1 }, 0, 1);
        } catch (ErrnoException ignored) {
        }
        return this;
    }
    
    private static class UnaddableSet<E> implements Set<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.040 -0500", hash_original_field = "1B7D8B9EFD416D2DA50204CC5903E05E", hash_generated_field = "9C45C0B407AF9ECDDC9EEE7EDB68F0BC")

        private  Set<E> set;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.044 -0500", hash_original_method = "62B3F0681944A36B1514E173BA40D640", hash_generated_method = "62B3F0681944A36B1514E173BA40D640")
        
UnaddableSet(Set<E> set) {
            this.set = set;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.047 -0500", hash_original_method = "2B5DAD0814D02A1062AA1260B368EAF3", hash_generated_method = "DC5A2F39A9BF6251B1263432FB0E308D")
        
@Override
        public boolean equals(Object object) {
            return set.equals(object);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.049 -0500", hash_original_method = "37617F952144E382F24B98396CD1D4D1", hash_generated_method = "12693150B12B1DEEEC1033ECA731A187")
        
@Override
        public int hashCode() {
            return set.hashCode();
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.052 -0500", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "E25483782CC49F27215F0FDEB89DACF8")
        
public boolean add(E object) {
            throw new UnsupportedOperationException();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.054 -0500", hash_original_method = "A5D17047871533A4FE91F018C1332208", hash_generated_method = "7896A435B1DE6491EB39D814970996B0")
        
public boolean addAll(Collection<? extends E> c) {
            throw new UnsupportedOperationException();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.057 -0500", hash_original_method = "3FA453B9F7C92A0D7DD94260C67D9514", hash_generated_method = "902EFA9A8DDA5FE4D8BD2B02A4325D89")
        
public void clear() {
            set.clear();
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.059 -0500", hash_original_method = "86589639BC226555A84E0620C45B13EB", hash_generated_method = "827E1558500285F252D98C591F425381")
        
public boolean contains(Object object) {
            return set.contains(object);
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.061 -0500", hash_original_method = "3FEE08DBC0596E43AC262D36678D5ED8", hash_generated_method = "23022D918CFA6513B01B2EDFDC6D5E97")
        
public boolean containsAll(Collection<?> c) {
            return set.containsAll(c);
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.064 -0500", hash_original_method = "77AAB60D4A31FA879BC76A6A4D9C7743", hash_generated_method = "AF0B83B4B9B9A2F0830A5CCE711032C8")
        
public boolean isEmpty() {
            return set.isEmpty();
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.066 -0500", hash_original_method = "7FB7F4965058B71D097578895F541442", hash_generated_method = "971472AD879713F2C7F3041145B0C2AD")
        
public Iterator<E> iterator() {
            return set.iterator();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.069 -0500", hash_original_method = "2486ACD2DD23466CE4FFA1B67E298992", hash_generated_method = "E99F7A299EECFFB0F247AB8E717C382F")
        
public boolean remove(Object object) {
            return set.remove(object);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.071 -0500", hash_original_method = "BBEFDF942C9288158521A1B78A605140", hash_generated_method = "DB440D0030148FA35DB5BED89557F461")
        
public boolean removeAll(Collection<?> c) {
            return set.removeAll(c);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.074 -0500", hash_original_method = "06DB016CCB1303D382A7D35EBEF3182D", hash_generated_method = "D76350C67CEEE0248B3E9DB6C4A732D1")
        
public boolean retainAll(Collection<?> c) {
            return set.retainAll(c);
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.076 -0500", hash_original_method = "283365B7154686D5E09A8541EE47F429", hash_generated_method = "357C4F7A3AB6F76F7971FD49DE2E828E")
        
public int size() {
            return set.size();
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.079 -0500", hash_original_method = "A39D4D1F48CDD6F8823B658123DCFC27", hash_generated_method = "1EC811B702EA553E91564648267E084B")
        
public Object[] toArray() {
            return set.toArray();
        }
        
        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.903 -0400", hash_original_method = "820308A08287454AD26ACE5A2E12E893", hash_generated_method = "C858378E5DE3F08ADC16EF2E7BFADF34")
        public <T> T[] toArray(T[] a) {
            addTaint(a[0].getTaint());
T[] varBD37699932362128D1DCA08F9CDDCC12_2067346240 =             set.toArray(a);
            varBD37699932362128D1DCA08F9CDDCC12_2067346240.addTaint(getTaint());
            return varBD37699932362128D1DCA08F9CDDCC12_2067346240;
            // ---------- Original Method ----------
            //return set.toArray(a);
        }
        
    }
    
}

