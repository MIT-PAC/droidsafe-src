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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.305 -0400", hash_original_field = "68EA0DC5C7CD33D02AB22A452F03FE60", hash_generated_field = "6DE612B35C9E8808CBEC2658E9286A57")

    final Object keysLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.305 -0400", hash_original_field = "83A1F06691F0845CE271880E5306F61D", hash_generated_field = "FC886FA77928694F4640D640BCFDF7BE")

    private final Set<SelectionKeyImpl> mutableKeys = new HashSet<SelectionKeyImpl>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.306 -0400", hash_original_field = "06FE9A9785A5E218E61382601BE7AEA9", hash_generated_field = "3DBE34F9B4C5E57002A17A3BD0063AA5")

    private final Set<SelectionKey> unmodifiableKeys = Collections
            .<SelectionKey>unmodifiableSet(mutableKeys);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.306 -0400", hash_original_field = "B39C5824037C8795986A4322D6F60C74", hash_generated_field = "2D8093EE2318D28CDED981CA87DED90A")

    private final Set<SelectionKey> mutableSelectedKeys = new HashSet<SelectionKey>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.306 -0400", hash_original_field = "7C094124CEBE65DD469D3FDD7E9DBCEE", hash_generated_field = "451F342BD781ADBAA504C0DDB5A78C6B")

    private final Set<SelectionKey> selectedKeys = new UnaddableSet<SelectionKey>(mutableSelectedKeys);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.306 -0400", hash_original_field = "1520E765F593638EDCB265402754CD3E", hash_generated_field = "6285C31CC7936F0AB3F1C69023A1F29D")

    private FileDescriptor wakeupIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.306 -0400", hash_original_field = "BCCDE90494ACE5D7D2083A58DE8283E4", hash_generated_field = "B95606F2D0BB7B9FC7D15F5B7CD880CE")

    private FileDescriptor wakeupOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.306 -0400", hash_original_field = "7120FBD1CCE52C44D518F50E24E860AE", hash_generated_field = "EFB3CC6DFEED71DE9DAD42AA06EB7441")

    private final UnsafeArrayList<StructPollfd> pollFds = new UnsafeArrayList<StructPollfd>(StructPollfd.class, 8);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.307 -0400", hash_original_method = "E76FB669EB1C2C846C756C0996AB21F1", hash_generated_method = "5533DE919FB889ECBABBEC60BA4199D7")
    public  SelectorImpl(SelectorProvider selectorProvider) throws IOException {
        super(selectorProvider);
        try 
        {
            FileDescriptor[] pipeFds = Libcore.os.pipe();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.317 -0400", hash_original_method = "79B2402F6F8D60BF0FF9B9A0443FD747", hash_generated_method = "6B89124C0296855C6F6FFC2EF112ADDB")
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
                        Iterator<SelectionKey> var94A27C4332B145E8CBFC3F6CC7B07713_1429462490 = (mutableKeys).iterator();
                        var94A27C4332B145E8CBFC3F6CC7B07713_1429462490.hasNext();
                        SelectionKey sk = var94A27C4332B145E8CBFC3F6CC7B07713_1429462490.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.318 -0400", hash_original_method = "9A9EE2D9A12F669E7C7AAB88B3AE3EAA", hash_generated_method = "D9C2F045D248FE83037BCE5AF90437C9")
    @Override
    protected SelectionKey register(AbstractSelectableChannel channel,
            int operations, Object attachment) {
        SelectionKey varB4EAC82CA7396A68D541C85D26508E83_1605046124 = null; //Variable for return #1
        {
            boolean var4EE4FD3790A594C06AD092C3051A9466_600833181 = (!provider().equals(channel.provider()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalSelectorException();
            } //End block
        } //End collapsed parenthetic
        {
            {
                SelectionKeyImpl selectionKey = new SelectionKeyImpl(channel, operations,
                        attachment, this);
                mutableKeys.add(selectionKey);
                ensurePollFdsCapacity();
                varB4EAC82CA7396A68D541C85D26508E83_1605046124 = selectionKey;
            } //End block
        } //End block
        addTaint(channel.getTaint());
        addTaint(operations);
        addTaint(attachment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1605046124.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1605046124;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.318 -0400", hash_original_method = "6BEEFC0027B3DD3AFC5CFC7324737402", hash_generated_method = "30F27993D9BBCAD4A2EAF68AADB8DB77")
    @Override
    public synchronized Set<SelectionKey> keys() {
        Set<SelectionKey> varB4EAC82CA7396A68D541C85D26508E83_1757960795 = null; //Variable for return #1
        checkClosed();
        varB4EAC82CA7396A68D541C85D26508E83_1757960795 = unmodifiableKeys;
        varB4EAC82CA7396A68D541C85D26508E83_1757960795.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1757960795;
        // ---------- Original Method ----------
        //checkClosed();
        //return unmodifiableKeys;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.318 -0400", hash_original_method = "16DB849132AADD2CAC6FB8494D5700D0", hash_generated_method = "BBC5CEB9A7EB9755A77C42EECFF583EA")
    private void checkClosed() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1544434713 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedSelectorException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedSelectorException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.319 -0400", hash_original_method = "0F4ACBA61BED328D03506D362DC34EE4", hash_generated_method = "362B221C55941AF1FE600BB209C6DE8C")
    @Override
    public int select() throws IOException {
        int varA6E105EBDACFBDA0A96F9A5F6DFD6B27_2088233246 = (selectInternal(-1));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_435278724 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_435278724;
        // ---------- Original Method ----------
        //return selectInternal(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.319 -0400", hash_original_method = "38CB8C7854E3817F0A25B22A5C37D9C3", hash_generated_method = "7E3615FB6977B064B5089DEA9B0DA89B")
    @Override
    public int select(long timeout) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        int var0D45F03F4A67BF8512466CC1D9DB130B_1159114826 = (selectInternal((timeout == 0) ? -1 : timeout)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(timeout);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2101464332 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2101464332;
        // ---------- Original Method ----------
        //if (timeout < 0) {
            //throw new IllegalArgumentException();
        //}
        //return selectInternal((timeout == 0) ? -1 : timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.319 -0400", hash_original_method = "06C4B09F10BB426C607790AD420FF9C5", hash_generated_method = "5098FEB390CA93AB82E00F700F56A514")
    @Override
    public int selectNow() throws IOException {
        int var6420D4C57EB6D1FFB885D8C0BE9626F3_1494426627 = (selectInternal(0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_43951820 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_43951820;
        // ---------- Original Method ----------
        //return selectInternal(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.320 -0400", hash_original_method = "07E877B82AC1C68A90F5E02CD6388406", hash_generated_method = "E896DC630582763C66F8291D540692AD")
    private int selectInternal(long timeout) throws IOException {
        checkClosed();
        {
            {
                {
                    doCancel();
                    boolean isBlock = (timeout != 0);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_786241734 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_786241734;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.320 -0400", hash_original_method = "1864B10FEC667AA8A534CE9CC6FD0BC2", hash_generated_method = "7E4614F9A1B5674332ED755BEFFFFC97")
    private void setPollFd(int i, FileDescriptor fd, int events, Object object) {
        StructPollfd pollFd = pollFds.get(i);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.326 -0400", hash_original_method = "C2C79FE5727E3E67D8033155BDE5FA42", hash_generated_method = "4DF0668E35C96C50D8E05CF657A7FED2")
    private void preparePollFds() {
        int i = 1;
        {
            Iterator<SelectionKeyImpl> var82ED93603CD061EDB7AF7F5D70201C8A_1695186556 = (mutableKeys).iterator();
            var82ED93603CD061EDB7AF7F5D70201C8A_1695186556.hasNext();
            SelectionKeyImpl key = var82ED93603CD061EDB7AF7F5D70201C8A_1695186556.next();
            {
                int interestOps = key.interestOpsNoCheck();
                short eventMask = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.326 -0400", hash_original_method = "561794DF92118E00B9893BD515660DDC", hash_generated_method = "893999A8376D49EFD4244AC014AFA7CA")
    private void ensurePollFdsCapacity() {
        {
            boolean varA3753910DB61ED73725373C90D948E3A_1437171397 = (pollFds.size() < mutableKeys.size() + 1);
            {
                pollFds.add(new StructPollfd());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //while (pollFds.size() < mutableKeys.size() + 1) {
            //pollFds.add(new StructPollfd());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.327 -0400", hash_original_method = "5DC934A1F65A8C13AADF3FD37642D2BD", hash_generated_method = "A92CF3393C3FF71263041324EA5B8F66")
    private int processPollFds() throws IOException {
        {
            boolean var5B510AC5BEB35DA145CBD7DE2BA62698_1908545104 = (pollFds.get(0).revents == POLLIN);
            {
                byte[] buffer = new byte[8];
                {
                    boolean var25A6F2E6F62683C32BEB36E6FCEB6D40_687152312 = (IoBridge.read(wakeupIn, buffer, 0, 1) > 0);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int readyKeyCount = 0;
        {
            int i = 1;
            boolean varCECE08AD7916C7EAFDDA88490C36ECAC_1166071938 = (i < pollFds.size());
            {
                StructPollfd pollFd = pollFds.get(i);
                SelectionKeyImpl key = (SelectionKeyImpl) pollFd.userData;
                pollFd.fd = null;
                pollFd.userData = null;
                int ops = key.interestOpsNoCheck();
                int selectedOp = 0;
                {
                    selectedOp = ops & (OP_ACCEPT | OP_READ);
                } //End block
                {
                    {
                        boolean varDF87DE05B18E5A13B2FF52E824E84E5B_403634149 = (key.isConnected());
                        {
                            selectedOp = ops & OP_WRITE;
                        } //End block
                        {
                            selectedOp = ops & OP_CONNECT;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean wasSelected = mutableSelectedKeys.contains(key);
                    {
                        boolean var3F78B959DDDD2302D129DB39525D5E28_1035492198 = (wasSelected && key.readyOps() != selectedOp);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1535438893 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1535438893;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.328 -0400", hash_original_method = "0EB011B4E4087026D6BA472324142821", hash_generated_method = "ECD592BE9F3A420D800D2A84E02F0335")
    @Override
    public synchronized Set<SelectionKey> selectedKeys() {
        Set<SelectionKey> varB4EAC82CA7396A68D541C85D26508E83_1984032750 = null; //Variable for return #1
        checkClosed();
        varB4EAC82CA7396A68D541C85D26508E83_1984032750 = selectedKeys;
        varB4EAC82CA7396A68D541C85D26508E83_1984032750.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1984032750;
        // ---------- Original Method ----------
        //checkClosed();
        //return selectedKeys;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.339 -0400", hash_original_method = "ECFBB6A45EE52702BEFF3EF78A8EE9C3", hash_generated_method = "DA0C6FB6638EF1FFBCB882054B5B2346")
    private int doCancel() {
        int deselected = 0;
        Set<SelectionKey> cancelledKeys = cancelledKeys();
        {
            {
                boolean varDA5BDE2673A39D0943BBFA42DB73C05D_1310072795 = (cancelledKeys.size() > 0);
                {
                    {
                        Iterator<SelectionKey> varB3EB1F654ACD0BCB98AC7E40841523F0_697447666 = (cancelledKeys).iterator();
                        varB3EB1F654ACD0BCB98AC7E40841523F0_697447666.hasNext();
                        SelectionKey currentKey = varB3EB1F654ACD0BCB98AC7E40841523F0_697447666.next();
                        {
                            mutableKeys.remove(currentKey);
                            deregister((AbstractSelectionKey) currentKey);
                            {
                                boolean var7E2CA0DCD7677691B7BD67D99C584907_351173205 = (mutableSelectedKeys.remove(currentKey));
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    cancelledKeys.clear();
                } //End block
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566723107 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566723107;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.339 -0400", hash_original_method = "BDB632D034A5FFBF79564927E2AB1FFB", hash_generated_method = "D2A1B2DB70E4A86AC35C0CF2E55BA9D0")
    @Override
    public Selector wakeup() {
        Selector varB4EAC82CA7396A68D541C85D26508E83_1338096906 = null; //Variable for return #1
        try 
        {
            Libcore.os.write(wakeupOut, new byte[] { 1 }, 0, 1);
        } //End block
        catch (ErrnoException ignored)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1338096906 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1338096906.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1338096906;
        // ---------- Original Method ----------
        //try {
            //Libcore.os.write(wakeupOut, new byte[] { 1 }, 0, 1);
        //} catch (ErrnoException ignored) {
        //}
        //return this;
    }

    
    private static class UnaddableSet<E> implements Set<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.340 -0400", hash_original_field = "CDAEEEBA9B4A4C5EBF042C0215A7BB0E", hash_generated_field = "9C45C0B407AF9ECDDC9EEE7EDB68F0BC")

        private Set<E> set;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.340 -0400", hash_original_method = "62B3F0681944A36B1514E173BA40D640", hash_generated_method = "24D039260CAE976729B60C3FC4D09830")
          UnaddableSet(Set<E> set) {
            this.set = set;
            // ---------- Original Method ----------
            //this.set = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.340 -0400", hash_original_method = "2B5DAD0814D02A1062AA1260B368EAF3", hash_generated_method = "1BE2698055DF02B86ED586EC259574F9")
        @Override
        public boolean equals(Object object) {
            boolean varEE711F0F2C37A27C8631DAB77534C6D5_1653555268 = (set.equals(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1893476345 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1893476345;
            // ---------- Original Method ----------
            //return set.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.340 -0400", hash_original_method = "37617F952144E382F24B98396CD1D4D1", hash_generated_method = "4BC7BFF7E02F564B2522B610099708CC")
        @Override
        public int hashCode() {
            int var687AE630E82E5F04D274B7201D441CA3_446334509 = (set.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129143116 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129143116;
            // ---------- Original Method ----------
            //return set.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.341 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "2DE363F0006695B6AA26149B651746F0")
        public boolean add(E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1737108326 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1737108326;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.341 -0400", hash_original_method = "A5D17047871533A4FE91F018C1332208", hash_generated_method = "AAAFBE00F858FECAA26F46D2D71020BB")
        public boolean addAll(Collection<? extends E> c) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(c.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1600689593 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1600689593;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.341 -0400", hash_original_method = "3FA453B9F7C92A0D7DD94260C67D9514", hash_generated_method = "10CF0C52087B2BD183B302B8BEE1DA86")
        public void clear() {
            set.clear();
            // ---------- Original Method ----------
            //set.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.341 -0400", hash_original_method = "86589639BC226555A84E0620C45B13EB", hash_generated_method = "E4D0985A18AE08DD3B92A0E73FB363D5")
        public boolean contains(Object object) {
            boolean varB62F3B41EA81674D20ACB4B91E5F369F_92378040 = (set.contains(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_415887256 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_415887256;
            // ---------- Original Method ----------
            //return set.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.342 -0400", hash_original_method = "3FEE08DBC0596E43AC262D36678D5ED8", hash_generated_method = "E72F7A0AEEA611E9C1DB2A13C82067E0")
        public boolean containsAll(Collection<?> c) {
            boolean var4FBF8840906BA8F706DFD15BB30FDF51_1708832035 = (set.containsAll(c));
            addTaint(c.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_848634826 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_848634826;
            // ---------- Original Method ----------
            //return set.containsAll(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.342 -0400", hash_original_method = "77AAB60D4A31FA879BC76A6A4D9C7743", hash_generated_method = "B7CB99CD9A1E82FD39B888DAA2FBE027")
        public boolean isEmpty() {
            boolean var59656714B8D007C863A242B248D8CAB2_1692363110 = (set.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2046164526 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2046164526;
            // ---------- Original Method ----------
            //return set.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.343 -0400", hash_original_method = "7FB7F4965058B71D097578895F541442", hash_generated_method = "C7E0D8AB822CD454B3E39D91BE380DD4")
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_2139507227 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2139507227 = set.iterator();
            varB4EAC82CA7396A68D541C85D26508E83_2139507227.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2139507227;
            // ---------- Original Method ----------
            //return set.iterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.343 -0400", hash_original_method = "2486ACD2DD23466CE4FFA1B67E298992", hash_generated_method = "DE33A6EFF0093500DAA6793B47FE02D1")
        public boolean remove(Object object) {
            boolean var4892D93910CE0A42611177CCAA08D4DC_511722293 = (set.remove(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1620389592 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1620389592;
            // ---------- Original Method ----------
            //return set.remove(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.343 -0400", hash_original_method = "BBEFDF942C9288158521A1B78A605140", hash_generated_method = "74A7C99BF47FB7EA80B8BACB66D2D59F")
        public boolean removeAll(Collection<?> c) {
            boolean var7C5A17588BB8737E6D4E9A388C65E7DA_266558521 = (set.removeAll(c));
            addTaint(c.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_662260447 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_662260447;
            // ---------- Original Method ----------
            //return set.removeAll(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.344 -0400", hash_original_method = "06DB016CCB1303D382A7D35EBEF3182D", hash_generated_method = "063CEFA54DDDD47EF979F80ED40670DB")
        public boolean retainAll(Collection<?> c) {
            boolean var87641AE296EDD6958EE072FAD8F20AC2_828904481 = (set.retainAll(c));
            addTaint(c.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1850397206 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1850397206;
            // ---------- Original Method ----------
            //return set.retainAll(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.344 -0400", hash_original_method = "283365B7154686D5E09A8541EE47F429", hash_generated_method = "0D2316BB9E3418CE83B2D22F7FF43AFE")
        public int size() {
            int var1607BC970B04E573A253638C3626122E_1798084594 = (set.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_566925967 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_566925967;
            // ---------- Original Method ----------
            //return set.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.345 -0400", hash_original_method = "A39D4D1F48CDD6F8823B658123DCFC27", hash_generated_method = "71030E3C381581A5DF2552B25952A1E7")
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1869622394 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1869622394 = set.toArray();
            varB4EAC82CA7396A68D541C85D26508E83_1869622394.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1869622394;
            // ---------- Original Method ----------
            //return set.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.345 -0400", hash_original_method = "820308A08287454AD26ACE5A2E12E893", hash_generated_method = "750798A77671A27F21B184D67DCFD414")
        public <T> T[] toArray(T[] a) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1742308031 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1742308031 = set.toArray(a);
            addTaint(a[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1742308031.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1742308031;
            // ---------- Original Method ----------
            //return set.toArray(a);
        }

        
    }


    
}

