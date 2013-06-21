package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.IllegalSelectorException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import static java.nio.channels.SelectionKey.*;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.AbstractSelectionKey;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Arrays;
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
import libcore.util.EmptyArray;
import static libcore.io.OsConstants.*;

final class SelectorImpl extends AbstractSelector {
    Object keysLock = new Object();
    private Set<SelectionKeyImpl> mutableKeys = new HashSet<SelectionKeyImpl>();
    private Set<SelectionKey> unmodifiableKeys = Collections
            .<SelectionKey>unmodifiableSet(mutableKeys);
    private Set<SelectionKey> mutableSelectedKeys = new HashSet<SelectionKey>();
    private Set<SelectionKey> selectedKeys
            = new UnaddableSet<SelectionKey>(mutableSelectedKeys);
    private FileDescriptor wakeupIn;
    private FileDescriptor wakeupOut;
    private UnsafeArrayList<StructPollfd> pollFds = new UnsafeArrayList<StructPollfd>(StructPollfd.class, 8);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.982 -0400", hash_original_method = "E76FB669EB1C2C846C756C0996AB21F1", hash_generated_method = "B8423BCAB00FA3F35DB40995C98AD616")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SelectorImpl(SelectorProvider selectorProvider) throws IOException {
        super(selectorProvider);
        dsTaint.addTaint(selectorProvider.dsTaint);
        try 
        {
            FileDescriptor[] pipeFds;
            pipeFds = Libcore.os.pipe();
            wakeupIn = pipeFds[0];
            wakeupOut = pipeFds[1];
            IoUtils.setBlocking(wakeupIn, false);
            pollFds.add(new StructPollfd());
            setPollFd(0, wakeupIn, POLLIN, null);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        // ---------- Original Method ----------
        //try {
            //FileDescriptor[] pipeFds = Libcore.os.pipe();
            //wakeupIn = pipeFds[0];
            //wakeupOut = pipeFds[1];
            //IoUtils.setBlocking(wakeupIn, false);
            //pollFds.add(new StructPollfd());
            //setPollFd(0, wakeupIn, POLLIN, null);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.991 -0400", hash_original_method = "79B2402F6F8D60BF0FF9B9A0443FD747", hash_generated_method = "BAD4698A0F517F7D244145D6686F2AD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void implCloseSelector() throws IOException {
        wakeup();
        {
            {
                {
                    IoUtils.close(wakeupIn);
                    IoUtils.close(wakeupOut);
                    doCancel();
                    {
                        Iterator<SelectionKey> var94A27C4332B145E8CBFC3F6CC7B07713_843196650 = (mutableKeys).iterator();
                        var94A27C4332B145E8CBFC3F6CC7B07713_843196650.hasNext();
                        SelectionKey sk = var94A27C4332B145E8CBFC3F6CC7B07713_843196650.next();
                        {
                            deregister((AbstractSelectionKey) sk);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //wakeup();
        //synchronized (this) {
            //synchronized (unmodifiableKeys) {
                //synchronized (selectedKeys) {
                    //IoUtils.close(wakeupIn);
                    //IoUtils.close(wakeupOut);
                    //doCancel();
                    //for (SelectionKey sk : mutableKeys) {
                        //deregister((AbstractSelectionKey) sk);
                    //}
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.992 -0400", hash_original_method = "9A9EE2D9A12F669E7C7AAB88B3AE3EAA", hash_generated_method = "90A7A367FD05D1EE7DE811F8A1A9421B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected SelectionKey register(AbstractSelectableChannel channel,
            int operations, Object attachment) {
        dsTaint.addTaint(attachment.dsTaint);
        dsTaint.addTaint(operations);
        dsTaint.addTaint(channel.dsTaint);
        {
            boolean var4EE4FD3790A594C06AD092C3051A9466_1558516909 = (!provider().equals(channel.provider()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalSelectorException();
            } //End block
        } //End collapsed parenthetic
        {
            {
                SelectionKeyImpl selectionKey;
                selectionKey = new SelectionKeyImpl(channel, operations,
                        attachment, this);
                mutableKeys.add(selectionKey);
                ensurePollFdsCapacity();
            } //End block
        } //End block
        return (SelectionKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!provider().equals(channel.provider())) {
            //throw new IllegalSelectorException();
        //}
        //synchronized (this) {
            //synchronized (unmodifiableKeys) {
                //SelectionKeyImpl selectionKey = new SelectionKeyImpl(channel, operations,
                        //attachment, this);
                //mutableKeys.add(selectionKey);
                //ensurePollFdsCapacity();
                //return selectionKey;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.992 -0400", hash_original_method = "6BEEFC0027B3DD3AFC5CFC7324737402", hash_generated_method = "1A12186F91673F6FF969775EA8F61B07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized Set<SelectionKey> keys() {
        checkClosed();
        return (Set<SelectionKey>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkClosed();
        //return unmodifiableKeys;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.992 -0400", hash_original_method = "16DB849132AADD2CAC6FB8494D5700D0", hash_generated_method = "8BE546337B927B4ECD12D695A9F47891")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkClosed() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_2011724265 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedSelectorException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedSelectorException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.992 -0400", hash_original_method = "0F4ACBA61BED328D03506D362DC34EE4", hash_generated_method = "FBEE480765D61D74AF33C5CF3EF2B2AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int select() throws IOException {
        int varA6E105EBDACFBDA0A96F9A5F6DFD6B27_1947989878 = (selectInternal(-1));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return selectInternal(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.992 -0400", hash_original_method = "38CB8C7854E3817F0A25B22A5C37D9C3", hash_generated_method = "6BCA975C72FC49BD0520D752EDEF6BDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int select(long timeout) throws IOException {
        dsTaint.addTaint(timeout);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        int var0D45F03F4A67BF8512466CC1D9DB130B_2066234458 = (selectInternal((timeout == 0) ? -1 : timeout)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (timeout < 0) {
            //throw new IllegalArgumentException();
        //}
        //return selectInternal((timeout == 0) ? -1 : timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.993 -0400", hash_original_method = "06C4B09F10BB426C607790AD420FF9C5", hash_generated_method = "E173ACEAFB89AABCF3897207F388DC3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int selectNow() throws IOException {
        int var6420D4C57EB6D1FFB885D8C0BE9626F3_2079179394 = (selectInternal(0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return selectInternal(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.993 -0400", hash_original_method = "07E877B82AC1C68A90F5E02CD6388406", hash_generated_method = "24F779F3A0041CBA419C828094BFBB92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int selectInternal(long timeout) throws IOException {
        dsTaint.addTaint(timeout);
        checkClosed();
        {
            {
                {
                    doCancel();
                    boolean isBlock;
                    isBlock = (timeout != 0);
                    {
                        preparePollFds();
                    } //End block
                    int rc;
                    try 
                    {
                        {
                            begin();
                        } //End block
                        try 
                        {
                            rc = Libcore.os.poll(pollFds.array(), (int) timeout);
                        } //End block
                        catch (ErrnoException errnoException)
                        {
                            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
                        } //End block
                    } //End block
                    finally 
                    {
                        {
                            end();
                        } //End block
                    } //End block
                    int readyCount;
                    readyCount = processPollFds();
                    readyCount = 0;
                    readyCount -= doCancel();
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.993 -0400", hash_original_method = "1864B10FEC667AA8A534CE9CC6FD0BC2", hash_generated_method = "1CC451F791F9150390DB603F7B6D9763")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setPollFd(int i, FileDescriptor fd, int events, Object object) {
        dsTaint.addTaint(events);
        dsTaint.addTaint(object.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(i);
        StructPollfd pollFd;
        pollFd = pollFds.get(i);
        pollFd.fd = fd;
        pollFd.events = (short) events;
        pollFd.userData = object;
        // ---------- Original Method ----------
        //StructPollfd pollFd = pollFds.get(i);
        //pollFd.fd = fd;
        //pollFd.events = (short) events;
        //pollFd.userData = object;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.997 -0400", hash_original_method = "C2C79FE5727E3E67D8033155BDE5FA42", hash_generated_method = "8E5B65FB9520ECDBE218177ABF213767")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void preparePollFds() {
        int i;
        i = 1;
        {
            Iterator<SelectionKeyImpl> var82ED93603CD061EDB7AF7F5D70201C8A_177947730 = (mutableKeys).iterator();
            var82ED93603CD061EDB7AF7F5D70201C8A_177947730.hasNext();
            SelectionKeyImpl key = var82ED93603CD061EDB7AF7F5D70201C8A_177947730.next();
            {
                int interestOps;
                interestOps = key.interestOpsNoCheck();
                short eventMask;
                eventMask = 0;
                {
                    eventMask |= POLLIN;
                } //End block
                {
                    eventMask |= POLLOUT;
                } //End block
                {
                    setPollFd(i++, ((FileDescriptorChannel) key.channel()).getFD(), eventMask, key);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int i = 1;
        //for (SelectionKeyImpl key : mutableKeys) {
            //int interestOps = key.interestOpsNoCheck();
            //short eventMask = 0;
            //if (((OP_ACCEPT | OP_READ) & interestOps) != 0) {
                //eventMask |= POLLIN;
            //}
            //if (((OP_CONNECT | OP_WRITE) & interestOps) != 0) {
                //eventMask |= POLLOUT;
            //}
            //if (eventMask != 0) {
                //setPollFd(i++, ((FileDescriptorChannel) key.channel()).getFD(), eventMask, key);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.998 -0400", hash_original_method = "561794DF92118E00B9893BD515660DDC", hash_generated_method = "9306889B8CDBC3CA40BF4AB167A13D77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensurePollFdsCapacity() {
        {
            boolean varA3753910DB61ED73725373C90D948E3A_474002531 = (pollFds.size() < mutableKeys.size() + 1);
            {
                pollFds.add(new StructPollfd());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //while (pollFds.size() < mutableKeys.size() + 1) {
            //pollFds.add(new StructPollfd());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.998 -0400", hash_original_method = "5DC934A1F65A8C13AADF3FD37642D2BD", hash_generated_method = "8129AD0CEC0853ECA9E1A6579305E041")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int processPollFds() throws IOException {
        {
            boolean var5B510AC5BEB35DA145CBD7DE2BA62698_1894683459 = (pollFds.get(0).revents == POLLIN);
            {
                byte[] buffer;
                buffer = new byte[8];
                {
                    boolean var25A6F2E6F62683C32BEB36E6FCEB6D40_1160340340 = (IoBridge.read(wakeupIn, buffer, 0, 1) > 0);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int readyKeyCount;
        readyKeyCount = 0;
        {
            int i;
            i = 1;
            boolean varCECE08AD7916C7EAFDDA88490C36ECAC_1141792952 = (i < pollFds.size());
            {
                StructPollfd pollFd;
                pollFd = pollFds.get(i);
                SelectionKeyImpl key;
                key = (SelectionKeyImpl) pollFd.userData;
                pollFd.fd = null;
                pollFd.userData = null;
                int ops;
                ops = key.interestOpsNoCheck();
                int selectedOp;
                selectedOp = 0;
                {
                    selectedOp = ops & (OP_ACCEPT | OP_READ);
                } //End block
                {
                    {
                        boolean varDF87DE05B18E5A13B2FF52E824E84E5B_139068165 = (key.isConnected());
                        {
                            selectedOp = ops & OP_WRITE;
                        } //End block
                        {
                            selectedOp = ops & OP_CONNECT;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean wasSelected;
                    wasSelected = mutableSelectedKeys.contains(key);
                    {
                        boolean var3F78B959DDDD2302D129DB39525D5E28_1804986251 = (wasSelected && key.readyOps() != selectedOp);
                        {
                            key.setReadyOps(key.readyOps() | selectedOp);
                        } //End block
                        {
                            key.setReadyOps(selectedOp);
                            mutableSelectedKeys.add(key);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.998 -0400", hash_original_method = "0EB011B4E4087026D6BA472324142821", hash_generated_method = "CA195A31C2E5937D1B3C0BCEFFF26C4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized Set<SelectionKey> selectedKeys() {
        checkClosed();
        return (Set<SelectionKey>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkClosed();
        //return selectedKeys;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.005 -0400", hash_original_method = "ECFBB6A45EE52702BEFF3EF78A8EE9C3", hash_generated_method = "136EFEF3C172E3C85D5F22D4B0177E6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int doCancel() {
        int deselected;
        deselected = 0;
        Set<SelectionKey> cancelledKeys;
        cancelledKeys = cancelledKeys();
        {
            {
                boolean varDA5BDE2673A39D0943BBFA42DB73C05D_1746240373 = (cancelledKeys.size() > 0);
                {
                    {
                        Iterator<SelectionKey> varB3EB1F654ACD0BCB98AC7E40841523F0_521793361 = (cancelledKeys).iterator();
                        varB3EB1F654ACD0BCB98AC7E40841523F0_521793361.hasNext();
                        SelectionKey currentKey = varB3EB1F654ACD0BCB98AC7E40841523F0_521793361.next();
                        {
                            mutableKeys.remove(currentKey);
                            deregister((AbstractSelectionKey) currentKey);
                            {
                                boolean var7E2CA0DCD7677691B7BD67D99C584907_695658694 = (mutableSelectedKeys.remove(currentKey));
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    cancelledKeys.clear();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int deselected = 0;
        //Set<SelectionKey> cancelledKeys = cancelledKeys();
        //synchronized (cancelledKeys) {
            //if (cancelledKeys.size() > 0) {
                //for (SelectionKey currentKey : cancelledKeys) {
                    //mutableKeys.remove(currentKey);
                    //deregister((AbstractSelectionKey) currentKey);
                    //if (mutableSelectedKeys.remove(currentKey)) {
                        //deselected++;
                    //}
                //}
                //cancelledKeys.clear();
            //}
        //}
        //return deselected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.005 -0400", hash_original_method = "BDB632D034A5FFBF79564927E2AB1FFB", hash_generated_method = "65F8FC45EAD642FB979CE46CEBE59182")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Selector wakeup() {
        try 
        {
            Libcore.os.write(wakeupOut, new byte[] { 1 }, 0, 1);
        } //End block
        catch (ErrnoException ignored)
        { }
        return (Selector)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //Libcore.os.write(wakeupOut, new byte[] { 1 }, 0, 1);
        //} catch (ErrnoException ignored) {
        //}
        //return this;
    }

    
    private static class UnaddableSet<E> implements Set<E> {
        private Set<E> set;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.006 -0400", hash_original_method = "62B3F0681944A36B1514E173BA40D640", hash_generated_method = "39A43EE9B6E34CE8CA51CDC87112DA10")
        @DSModeled(DSC.SAFE)
         UnaddableSet(Set<E> set) {
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
            //this.set = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.006 -0400", hash_original_method = "2B5DAD0814D02A1062AA1260B368EAF3", hash_generated_method = "A4F0C4F4BEA220B504DFB4DC65390268")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varEE711F0F2C37A27C8631DAB77534C6D5_1292900273 = (set.equals(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return set.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.006 -0400", hash_original_method = "37617F952144E382F24B98396CD1D4D1", hash_generated_method = "733E0508B7C18CA7B4FD2CFE6FCDC713")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var687AE630E82E5F04D274B7201D441CA3_2084669020 = (set.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return set.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.006 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "730BA02FE922492A93F90D5EB9404E86")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean add(E object) {
            dsTaint.addTaint(object.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.006 -0400", hash_original_method = "A5D17047871533A4FE91F018C1332208", hash_generated_method = "AD1E2BF78E71280CB49CE69D658F3011")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean addAll(Collection<? extends E> c) {
            dsTaint.addTaint(c.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.006 -0400", hash_original_method = "3FA453B9F7C92A0D7DD94260C67D9514", hash_generated_method = "10CF0C52087B2BD183B302B8BEE1DA86")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void clear() {
            set.clear();
            // ---------- Original Method ----------
            //set.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.007 -0400", hash_original_method = "86589639BC226555A84E0620C45B13EB", hash_generated_method = "B74057020930D2536BFAD88741573640")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varB62F3B41EA81674D20ACB4B91E5F369F_2116590498 = (set.contains(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return set.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.007 -0400", hash_original_method = "3FEE08DBC0596E43AC262D36678D5ED8", hash_generated_method = "EEB5925C73B09FA0E40A55AB6CEE8F22")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean containsAll(Collection<?> c) {
            dsTaint.addTaint(c.dsTaint);
            boolean var4FBF8840906BA8F706DFD15BB30FDF51_764147228 = (set.containsAll(c));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return set.containsAll(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.007 -0400", hash_original_method = "77AAB60D4A31FA879BC76A6A4D9C7743", hash_generated_method = "1BB560794AF56368C7480C0FE942E472")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isEmpty() {
            boolean var59656714B8D007C863A242B248D8CAB2_677912474 = (set.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return set.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.007 -0400", hash_original_method = "7FB7F4965058B71D097578895F541442", hash_generated_method = "0021351DE9A9102F72015B3BA8413AC4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Iterator<E> iterator() {
            Iterator<E> var7B7E1D209897FB27A68BD9E36BAFC888_1081519100 = (set.iterator());
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return set.iterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.007 -0400", hash_original_method = "2486ACD2DD23466CE4FFA1B67E298992", hash_generated_method = "EA97B899B4596B5C626DD68215B8D966")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var4892D93910CE0A42611177CCAA08D4DC_1113502932 = (set.remove(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return set.remove(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.007 -0400", hash_original_method = "BBEFDF942C9288158521A1B78A605140", hash_generated_method = "F60095FDF4B94CB82F64FA0433090519")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean removeAll(Collection<?> c) {
            dsTaint.addTaint(c.dsTaint);
            boolean var7C5A17588BB8737E6D4E9A388C65E7DA_123854493 = (set.removeAll(c));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return set.removeAll(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.008 -0400", hash_original_method = "06DB016CCB1303D382A7D35EBEF3182D", hash_generated_method = "6B70E0A6E25902077E7A2D946C3B3D54")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean retainAll(Collection<?> c) {
            dsTaint.addTaint(c.dsTaint);
            boolean var87641AE296EDD6958EE072FAD8F20AC2_942845415 = (set.retainAll(c));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return set.retainAll(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.008 -0400", hash_original_method = "283365B7154686D5E09A8541EE47F429", hash_generated_method = "7FBB1EB2470E6E0FB6309E5D9AF6A2B1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int size() {
            int var1607BC970B04E573A253638C3626122E_1328895475 = (set.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return set.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.008 -0400", hash_original_method = "A39D4D1F48CDD6F8823B658123DCFC27", hash_generated_method = "B3D9AE1577F3F631BF59AC12E09A1E61")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object[] toArray() {
            Object[] var3BC6D272D0F1D7B69A24223E33F8E549_695838554 = (set.toArray());
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return set.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.008 -0400", hash_original_method = "820308A08287454AD26ACE5A2E12E893", hash_generated_method = "1FC5A4D0E2B10F4EE978322127DECE1B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> T[] toArray(T[] a) {
            dsTaint.addTaint(a[0].dsTaint);
            T[] var96765A582F285BE3A70F66E4EB7C5AB7_1053436521 = (set.toArray(a));
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return set.toArray(a);
        }

        
    }


    
}

