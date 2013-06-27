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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.294 -0400", hash_original_field = "68EA0DC5C7CD33D02AB22A452F03FE60", hash_generated_field = "4799F2FA87D10E2424DB0D9E99F61148")

    Object keysLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.294 -0400", hash_original_field = "83A1F06691F0845CE271880E5306F61D", hash_generated_field = "A1508286350B3791922D9F5464C23DEC")

    private Set<SelectionKeyImpl> mutableKeys = new HashSet<SelectionKeyImpl>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.295 -0400", hash_original_field = "06FE9A9785A5E218E61382601BE7AEA9", hash_generated_field = "78D71E068B658BB010756C4ED70D6A35")

    private Set<SelectionKey> unmodifiableKeys = Collections
            .<SelectionKey>unmodifiableSet(mutableKeys);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.295 -0400", hash_original_field = "B39C5824037C8795986A4322D6F60C74", hash_generated_field = "BDD8CDDF501B918DEB10F6358BD7870A")

    private Set<SelectionKey> mutableSelectedKeys = new HashSet<SelectionKey>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.295 -0400", hash_original_field = "7C094124CEBE65DD469D3FDD7E9DBCEE", hash_generated_field = "833CB7B41D4F4810790AA47D5B5699B4")

    private Set<SelectionKey> selectedKeys = new UnaddableSet<SelectionKey>(mutableSelectedKeys);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.312 -0400", hash_original_field = "1520E765F593638EDCB265402754CD3E", hash_generated_field = "6285C31CC7936F0AB3F1C69023A1F29D")

    private FileDescriptor wakeupIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.312 -0400", hash_original_field = "BCCDE90494ACE5D7D2083A58DE8283E4", hash_generated_field = "B95606F2D0BB7B9FC7D15F5B7CD880CE")

    private FileDescriptor wakeupOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.312 -0400", hash_original_field = "7120FBD1CCE52C44D518F50E24E860AE", hash_generated_field = "384B8AC4A9A04095A89794A66675B2F8")

    private UnsafeArrayList<StructPollfd> pollFds = new UnsafeArrayList<StructPollfd>(StructPollfd.class, 8);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.312 -0400", hash_original_method = "E76FB669EB1C2C846C756C0996AB21F1", hash_generated_method = "67533AD6A1A7CB426BED7A5D6CB527C3")
    public  SelectorImpl(SelectorProvider selectorProvider) throws IOException {
        super(selectorProvider);
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
        addTaint(selectorProvider.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.405 -0400", hash_original_method = "79B2402F6F8D60BF0FF9B9A0443FD747", hash_generated_method = "FF914B003B844AAC186263395F7A9A14")
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
                        Iterator<SelectionKey> var94A27C4332B145E8CBFC3F6CC7B07713_176270 = (mutableKeys).iterator();
                        var94A27C4332B145E8CBFC3F6CC7B07713_176270.hasNext();
                        SelectionKey sk = var94A27C4332B145E8CBFC3F6CC7B07713_176270.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.407 -0400", hash_original_method = "9A9EE2D9A12F669E7C7AAB88B3AE3EAA", hash_generated_method = "CBDC9D4138A05B1842DE0E5060705E0D")
    @Override
    protected SelectionKey register(AbstractSelectableChannel channel,
            int operations, Object attachment) {
        SelectionKey varB4EAC82CA7396A68D541C85D26508E83_804619961 = null; //Variable for return #1
        {
            boolean var4EE4FD3790A594C06AD092C3051A9466_2112492907 = (!provider().equals(channel.provider()));
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
                varB4EAC82CA7396A68D541C85D26508E83_804619961 = selectionKey;
            } //End block
        } //End block
        addTaint(channel.getTaint());
        addTaint(operations);
        addTaint(attachment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_804619961.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_804619961;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.416 -0400", hash_original_method = "6BEEFC0027B3DD3AFC5CFC7324737402", hash_generated_method = "787D70EA0B1EC50DB6E3FEE49219FD61")
    @Override
    public synchronized Set<SelectionKey> keys() {
        Set<SelectionKey> varB4EAC82CA7396A68D541C85D26508E83_1853825125 = null; //Variable for return #1
        checkClosed();
        varB4EAC82CA7396A68D541C85D26508E83_1853825125 = unmodifiableKeys;
        varB4EAC82CA7396A68D541C85D26508E83_1853825125.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1853825125;
        // ---------- Original Method ----------
        //checkClosed();
        //return unmodifiableKeys;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.417 -0400", hash_original_method = "16DB849132AADD2CAC6FB8494D5700D0", hash_generated_method = "4D9C342DB9657308D100A2370D3DB765")
    private void checkClosed() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_543629332 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedSelectorException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedSelectorException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.417 -0400", hash_original_method = "0F4ACBA61BED328D03506D362DC34EE4", hash_generated_method = "D42FEB8661D8B14588AE38A31859DF60")
    @Override
    public int select() throws IOException {
        int varA6E105EBDACFBDA0A96F9A5F6DFD6B27_1098233449 = (selectInternal(-1));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310897421 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310897421;
        // ---------- Original Method ----------
        //return selectInternal(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.417 -0400", hash_original_method = "38CB8C7854E3817F0A25B22A5C37D9C3", hash_generated_method = "BD7B146E97FF9B410475D9E65038EAEC")
    @Override
    public int select(long timeout) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        int var0D45F03F4A67BF8512466CC1D9DB130B_1800612383 = (selectInternal((timeout == 0) ? -1 : timeout)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(timeout);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_969742251 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_969742251;
        // ---------- Original Method ----------
        //if (timeout < 0) {
            //throw new IllegalArgumentException();
        //}
        //return selectInternal((timeout == 0) ? -1 : timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.417 -0400", hash_original_method = "06C4B09F10BB426C607790AD420FF9C5", hash_generated_method = "5C4F269A620D7FCA7E9D5E102D6713B8")
    @Override
    public int selectNow() throws IOException {
        int var6420D4C57EB6D1FFB885D8C0BE9626F3_1443613168 = (selectInternal(0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_344257765 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_344257765;
        // ---------- Original Method ----------
        //return selectInternal(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.424 -0400", hash_original_method = "07E877B82AC1C68A90F5E02CD6388406", hash_generated_method = "657ABF60C80856EDC0E1F8993F3441F3")
    private int selectInternal(long timeout) throws IOException {
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
        addTaint(timeout);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132853885 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132853885;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.427 -0400", hash_original_method = "1864B10FEC667AA8A534CE9CC6FD0BC2", hash_generated_method = "6A4B0DCC046EAED64A05D5DAC41863F0")
    private void setPollFd(int i, FileDescriptor fd, int events, Object object) {
        StructPollfd pollFd;
        pollFd = pollFds.get(i);
        pollFd.fd = fd;
        pollFd.events = (short) events;
        pollFd.userData = object;
        addTaint(i);
        addTaint(fd.getTaint());
        addTaint(events);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //StructPollfd pollFd = pollFds.get(i);
        //pollFd.fd = fd;
        //pollFd.events = (short) events;
        //pollFd.userData = object;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.487 -0400", hash_original_method = "C2C79FE5727E3E67D8033155BDE5FA42", hash_generated_method = "B445AF547F03465CABD71F40AAA627A3")
    private void preparePollFds() {
        int i;
        i = 1;
        {
            Iterator<SelectionKeyImpl> var82ED93603CD061EDB7AF7F5D70201C8A_1883830088 = (mutableKeys).iterator();
            var82ED93603CD061EDB7AF7F5D70201C8A_1883830088.hasNext();
            SelectionKeyImpl key = var82ED93603CD061EDB7AF7F5D70201C8A_1883830088.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.500 -0400", hash_original_method = "561794DF92118E00B9893BD515660DDC", hash_generated_method = "05E17C688A82E13CF161DD1525802686")
    private void ensurePollFdsCapacity() {
        {
            boolean varA3753910DB61ED73725373C90D948E3A_1803108828 = (pollFds.size() < mutableKeys.size() + 1);
            {
                pollFds.add(new StructPollfd());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //while (pollFds.size() < mutableKeys.size() + 1) {
            //pollFds.add(new StructPollfd());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.504 -0400", hash_original_method = "5DC934A1F65A8C13AADF3FD37642D2BD", hash_generated_method = "81C80A8C78687A930A6D7E4AFF3ACC31")
    private int processPollFds() throws IOException {
        {
            boolean var5B510AC5BEB35DA145CBD7DE2BA62698_1819949585 = (pollFds.get(0).revents == POLLIN);
            {
                byte[] buffer;
                buffer = new byte[8];
                {
                    boolean var25A6F2E6F62683C32BEB36E6FCEB6D40_1918249069 = (IoBridge.read(wakeupIn, buffer, 0, 1) > 0);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int readyKeyCount;
        readyKeyCount = 0;
        {
            int i;
            i = 1;
            boolean varCECE08AD7916C7EAFDDA88490C36ECAC_558492965 = (i < pollFds.size());
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
                        boolean varDF87DE05B18E5A13B2FF52E824E84E5B_18730705 = (key.isConnected());
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
                        boolean var3F78B959DDDD2302D129DB39525D5E28_1974939402 = (wasSelected && key.readyOps() != selectedOp);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1864570249 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1864570249;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.506 -0400", hash_original_method = "0EB011B4E4087026D6BA472324142821", hash_generated_method = "0C9FA7B9BC5341D57F240587F77BCAD8")
    @Override
    public synchronized Set<SelectionKey> selectedKeys() {
        Set<SelectionKey> varB4EAC82CA7396A68D541C85D26508E83_688045598 = null; //Variable for return #1
        checkClosed();
        varB4EAC82CA7396A68D541C85D26508E83_688045598 = selectedKeys;
        varB4EAC82CA7396A68D541C85D26508E83_688045598.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_688045598;
        // ---------- Original Method ----------
        //checkClosed();
        //return selectedKeys;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.566 -0400", hash_original_method = "ECFBB6A45EE52702BEFF3EF78A8EE9C3", hash_generated_method = "834A556C57F85E4B57FB353CCE7076E8")
    private int doCancel() {
        int deselected;
        deselected = 0;
        Set<SelectionKey> cancelledKeys;
        cancelledKeys = cancelledKeys();
        {
            {
                boolean varDA5BDE2673A39D0943BBFA42DB73C05D_1078900981 = (cancelledKeys.size() > 0);
                {
                    {
                        Iterator<SelectionKey> varB3EB1F654ACD0BCB98AC7E40841523F0_1648618886 = (cancelledKeys).iterator();
                        varB3EB1F654ACD0BCB98AC7E40841523F0_1648618886.hasNext();
                        SelectionKey currentKey = varB3EB1F654ACD0BCB98AC7E40841523F0_1648618886.next();
                        {
                            mutableKeys.remove(currentKey);
                            deregister((AbstractSelectionKey) currentKey);
                            {
                                boolean var7E2CA0DCD7677691B7BD67D99C584907_663104565 = (mutableSelectedKeys.remove(currentKey));
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    cancelledKeys.clear();
                } //End block
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_376615190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_376615190;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.573 -0400", hash_original_method = "BDB632D034A5FFBF79564927E2AB1FFB", hash_generated_method = "24F88A31BCA9CB845352351EBDC45E12")
    @Override
    public Selector wakeup() {
        Selector varB4EAC82CA7396A68D541C85D26508E83_1267952358 = null; //Variable for return #1
        try 
        {
            Libcore.os.write(wakeupOut, new byte[] { 1 }, 0, 1);
        } //End block
        catch (ErrnoException ignored)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1267952358 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1267952358.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1267952358;
        // ---------- Original Method ----------
        //try {
            //Libcore.os.write(wakeupOut, new byte[] { 1 }, 0, 1);
        //} catch (ErrnoException ignored) {
        //}
        //return this;
    }

    
    private static class UnaddableSet<E> implements Set<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.573 -0400", hash_original_field = "CDAEEEBA9B4A4C5EBF042C0215A7BB0E", hash_generated_field = "9C45C0B407AF9ECDDC9EEE7EDB68F0BC")

        private Set<E> set;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.588 -0400", hash_original_method = "62B3F0681944A36B1514E173BA40D640", hash_generated_method = "24D039260CAE976729B60C3FC4D09830")
          UnaddableSet(Set<E> set) {
            this.set = set;
            // ---------- Original Method ----------
            //this.set = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.589 -0400", hash_original_method = "2B5DAD0814D02A1062AA1260B368EAF3", hash_generated_method = "776027CB40441D6BA4D5B0A23CDBD47D")
        @Override
        public boolean equals(Object object) {
            boolean varEE711F0F2C37A27C8631DAB77534C6D5_999153624 = (set.equals(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_940117868 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_940117868;
            // ---------- Original Method ----------
            //return set.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.589 -0400", hash_original_method = "37617F952144E382F24B98396CD1D4D1", hash_generated_method = "E113406B2C57828A21443A40757D2A94")
        @Override
        public int hashCode() {
            int var687AE630E82E5F04D274B7201D441CA3_998731611 = (set.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1641278711 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1641278711;
            // ---------- Original Method ----------
            //return set.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.589 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "895B617DA6996CA3027BA988C0A7C338")
        public boolean add(E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1956515164 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1956515164;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.594 -0400", hash_original_method = "A5D17047871533A4FE91F018C1332208", hash_generated_method = "186CECE237E60221032451D8F8068062")
        public boolean addAll(Collection<? extends E> c) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(c.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_645251695 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_645251695;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.595 -0400", hash_original_method = "3FA453B9F7C92A0D7DD94260C67D9514", hash_generated_method = "10CF0C52087B2BD183B302B8BEE1DA86")
        public void clear() {
            set.clear();
            // ---------- Original Method ----------
            //set.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.596 -0400", hash_original_method = "86589639BC226555A84E0620C45B13EB", hash_generated_method = "AC08DCBA5F9B492A2F5839B5ACB7F072")
        public boolean contains(Object object) {
            boolean varB62F3B41EA81674D20ACB4B91E5F369F_173761406 = (set.contains(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_804350361 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_804350361;
            // ---------- Original Method ----------
            //return set.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.597 -0400", hash_original_method = "3FEE08DBC0596E43AC262D36678D5ED8", hash_generated_method = "DDFA846A76D60DDB45C6C0F86FD75866")
        public boolean containsAll(Collection<?> c) {
            boolean var4FBF8840906BA8F706DFD15BB30FDF51_1385765090 = (set.containsAll(c));
            addTaint(c.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_343795798 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_343795798;
            // ---------- Original Method ----------
            //return set.containsAll(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.597 -0400", hash_original_method = "77AAB60D4A31FA879BC76A6A4D9C7743", hash_generated_method = "4BB2E285573D26E01ABFED0FAFDE7BBC")
        public boolean isEmpty() {
            boolean var59656714B8D007C863A242B248D8CAB2_1143569268 = (set.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1741972380 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1741972380;
            // ---------- Original Method ----------
            //return set.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.598 -0400", hash_original_method = "7FB7F4965058B71D097578895F541442", hash_generated_method = "32A84636C64CC7575E7E05257005223C")
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_472806452 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_472806452 = set.iterator();
            varB4EAC82CA7396A68D541C85D26508E83_472806452.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_472806452;
            // ---------- Original Method ----------
            //return set.iterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.598 -0400", hash_original_method = "2486ACD2DD23466CE4FFA1B67E298992", hash_generated_method = "1CBB406B6536744BF000AC86EFCA455A")
        public boolean remove(Object object) {
            boolean var4892D93910CE0A42611177CCAA08D4DC_1320059925 = (set.remove(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_122504376 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_122504376;
            // ---------- Original Method ----------
            //return set.remove(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.598 -0400", hash_original_method = "BBEFDF942C9288158521A1B78A605140", hash_generated_method = "E3588A085C768E4123FB0A5FA63B66F6")
        public boolean removeAll(Collection<?> c) {
            boolean var7C5A17588BB8737E6D4E9A388C65E7DA_1035765072 = (set.removeAll(c));
            addTaint(c.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_608112756 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_608112756;
            // ---------- Original Method ----------
            //return set.removeAll(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.606 -0400", hash_original_method = "06DB016CCB1303D382A7D35EBEF3182D", hash_generated_method = "C7C161E90CE1106E7BC7BEC279B3AA58")
        public boolean retainAll(Collection<?> c) {
            boolean var87641AE296EDD6958EE072FAD8F20AC2_1867914104 = (set.retainAll(c));
            addTaint(c.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1122337964 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1122337964;
            // ---------- Original Method ----------
            //return set.retainAll(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.606 -0400", hash_original_method = "283365B7154686D5E09A8541EE47F429", hash_generated_method = "AF3798A1E01886EB378B26877BD18DFA")
        public int size() {
            int var1607BC970B04E573A253638C3626122E_1367880717 = (set.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966037848 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966037848;
            // ---------- Original Method ----------
            //return set.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.607 -0400", hash_original_method = "A39D4D1F48CDD6F8823B658123DCFC27", hash_generated_method = "E851202E5165B595AF3A683262ABAFC6")
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_713465259 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_713465259 = set.toArray();
            varB4EAC82CA7396A68D541C85D26508E83_713465259.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_713465259;
            // ---------- Original Method ----------
            //return set.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.611 -0400", hash_original_method = "820308A08287454AD26ACE5A2E12E893", hash_generated_method = "4A39BCBE283E82A8CC6E4C143D70CC7B")
        public <T> T[] toArray(T[] a) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1843813884 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1843813884 = set.toArray(a);
            addTaint(a[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1843813884.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1843813884;
            // ---------- Original Method ----------
            //return set.toArray(a);
        }

        
    }


    
}

