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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.237 -0400", hash_original_field = "68EA0DC5C7CD33D02AB22A452F03FE60", hash_generated_field = "4799F2FA87D10E2424DB0D9E99F61148")

    Object keysLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.237 -0400", hash_original_field = "83A1F06691F0845CE271880E5306F61D", hash_generated_field = "A1508286350B3791922D9F5464C23DEC")

    private Set<SelectionKeyImpl> mutableKeys = new HashSet<SelectionKeyImpl>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.237 -0400", hash_original_field = "06FE9A9785A5E218E61382601BE7AEA9", hash_generated_field = "78D71E068B658BB010756C4ED70D6A35")

    private Set<SelectionKey> unmodifiableKeys = Collections
            .<SelectionKey>unmodifiableSet(mutableKeys);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.237 -0400", hash_original_field = "B39C5824037C8795986A4322D6F60C74", hash_generated_field = "BDD8CDDF501B918DEB10F6358BD7870A")

    private Set<SelectionKey> mutableSelectedKeys = new HashSet<SelectionKey>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.237 -0400", hash_original_field = "7C094124CEBE65DD469D3FDD7E9DBCEE", hash_generated_field = "833CB7B41D4F4810790AA47D5B5699B4")

    private Set<SelectionKey> selectedKeys = new UnaddableSet<SelectionKey>(mutableSelectedKeys);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.237 -0400", hash_original_field = "1520E765F593638EDCB265402754CD3E", hash_generated_field = "6285C31CC7936F0AB3F1C69023A1F29D")

    private FileDescriptor wakeupIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.237 -0400", hash_original_field = "BCCDE90494ACE5D7D2083A58DE8283E4", hash_generated_field = "B95606F2D0BB7B9FC7D15F5B7CD880CE")

    private FileDescriptor wakeupOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.237 -0400", hash_original_field = "7120FBD1CCE52C44D518F50E24E860AE", hash_generated_field = "384B8AC4A9A04095A89794A66675B2F8")

    private UnsafeArrayList<StructPollfd> pollFds = new UnsafeArrayList<StructPollfd>(StructPollfd.class, 8);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.246 -0400", hash_original_method = "E76FB669EB1C2C846C756C0996AB21F1", hash_generated_method = "67533AD6A1A7CB426BED7A5D6CB527C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.356 -0400", hash_original_method = "79B2402F6F8D60BF0FF9B9A0443FD747", hash_generated_method = "74576499C88F229F0DDE09154FD8CADD")
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
                        Iterator<SelectionKey> var94A27C4332B145E8CBFC3F6CC7B07713_783704338 = (mutableKeys).iterator();
                        var94A27C4332B145E8CBFC3F6CC7B07713_783704338.hasNext();
                        SelectionKey sk = var94A27C4332B145E8CBFC3F6CC7B07713_783704338.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.359 -0400", hash_original_method = "9A9EE2D9A12F669E7C7AAB88B3AE3EAA", hash_generated_method = "47C145FD568C53EC5C7EF81DF7417E2A")
    @Override
    protected SelectionKey register(AbstractSelectableChannel channel,
            int operations, Object attachment) {
        SelectionKey varB4EAC82CA7396A68D541C85D26508E83_2136734675 = null; //Variable for return #1
        {
            boolean var4EE4FD3790A594C06AD092C3051A9466_1084673902 = (!provider().equals(channel.provider()));
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
                varB4EAC82CA7396A68D541C85D26508E83_2136734675 = selectionKey;
            } //End block
        } //End block
        addTaint(channel.getTaint());
        addTaint(operations);
        addTaint(attachment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2136734675.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2136734675;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.365 -0400", hash_original_method = "6BEEFC0027B3DD3AFC5CFC7324737402", hash_generated_method = "0289F6EF13E8C5FA81A710855F0C2D50")
    @Override
    public synchronized Set<SelectionKey> keys() {
        Set<SelectionKey> varB4EAC82CA7396A68D541C85D26508E83_766530434 = null; //Variable for return #1
        checkClosed();
        varB4EAC82CA7396A68D541C85D26508E83_766530434 = unmodifiableKeys;
        varB4EAC82CA7396A68D541C85D26508E83_766530434.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_766530434;
        // ---------- Original Method ----------
        //checkClosed();
        //return unmodifiableKeys;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.365 -0400", hash_original_method = "16DB849132AADD2CAC6FB8494D5700D0", hash_generated_method = "09A60AE6697439C827416473B664AD99")
    private void checkClosed() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1333495724 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedSelectorException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedSelectorException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.365 -0400", hash_original_method = "0F4ACBA61BED328D03506D362DC34EE4", hash_generated_method = "D9A0307336F48EEE4A5BADCC5B906B84")
    @Override
    public int select() throws IOException {
        int varA6E105EBDACFBDA0A96F9A5F6DFD6B27_1780119268 = (selectInternal(-1));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_597525379 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_597525379;
        // ---------- Original Method ----------
        //return selectInternal(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.366 -0400", hash_original_method = "38CB8C7854E3817F0A25B22A5C37D9C3", hash_generated_method = "1048F26A9C4B64AAA4A363F8A1A8AC8D")
    @Override
    public int select(long timeout) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        int var0D45F03F4A67BF8512466CC1D9DB130B_323595182 = (selectInternal((timeout == 0) ? -1 : timeout)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(timeout);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525776320 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525776320;
        // ---------- Original Method ----------
        //if (timeout < 0) {
            //throw new IllegalArgumentException();
        //}
        //return selectInternal((timeout == 0) ? -1 : timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.366 -0400", hash_original_method = "06C4B09F10BB426C607790AD420FF9C5", hash_generated_method = "1F35EF125085AA79CE14101F42BBAD96")
    @Override
    public int selectNow() throws IOException {
        int var6420D4C57EB6D1FFB885D8C0BE9626F3_764896978 = (selectInternal(0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607279467 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607279467;
        // ---------- Original Method ----------
        //return selectInternal(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.367 -0400", hash_original_method = "07E877B82AC1C68A90F5E02CD6388406", hash_generated_method = "D3C09B595381762EE2D0EED2A72493F8")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717680507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717680507;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.367 -0400", hash_original_method = "1864B10FEC667AA8A534CE9CC6FD0BC2", hash_generated_method = "6A4B0DCC046EAED64A05D5DAC41863F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.440 -0400", hash_original_method = "C2C79FE5727E3E67D8033155BDE5FA42", hash_generated_method = "8CAAEEDBEF58225352ADE47033EE89E8")
    private void preparePollFds() {
        int i;
        i = 1;
        {
            Iterator<SelectionKeyImpl> var82ED93603CD061EDB7AF7F5D70201C8A_2037204265 = (mutableKeys).iterator();
            var82ED93603CD061EDB7AF7F5D70201C8A_2037204265.hasNext();
            SelectionKeyImpl key = var82ED93603CD061EDB7AF7F5D70201C8A_2037204265.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.441 -0400", hash_original_method = "561794DF92118E00B9893BD515660DDC", hash_generated_method = "A526EF4433EC0AB0D8DF92015CE82909")
    private void ensurePollFdsCapacity() {
        {
            boolean varA3753910DB61ED73725373C90D948E3A_72490010 = (pollFds.size() < mutableKeys.size() + 1);
            {
                pollFds.add(new StructPollfd());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //while (pollFds.size() < mutableKeys.size() + 1) {
            //pollFds.add(new StructPollfd());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.470 -0400", hash_original_method = "5DC934A1F65A8C13AADF3FD37642D2BD", hash_generated_method = "33AA64811996857F4683B2877BB59EEB")
    private int processPollFds() throws IOException {
        {
            boolean var5B510AC5BEB35DA145CBD7DE2BA62698_528433432 = (pollFds.get(0).revents == POLLIN);
            {
                byte[] buffer;
                buffer = new byte[8];
                {
                    boolean var25A6F2E6F62683C32BEB36E6FCEB6D40_1250117938 = (IoBridge.read(wakeupIn, buffer, 0, 1) > 0);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int readyKeyCount;
        readyKeyCount = 0;
        {
            int i;
            i = 1;
            boolean varCECE08AD7916C7EAFDDA88490C36ECAC_1975552610 = (i < pollFds.size());
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
                        boolean varDF87DE05B18E5A13B2FF52E824E84E5B_1688227137 = (key.isConnected());
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
                        boolean var3F78B959DDDD2302D129DB39525D5E28_533298114 = (wasSelected && key.readyOps() != selectedOp);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_875313987 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_875313987;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.478 -0400", hash_original_method = "0EB011B4E4087026D6BA472324142821", hash_generated_method = "F9CFDD34128110C8A04D046338549CF3")
    @Override
    public synchronized Set<SelectionKey> selectedKeys() {
        Set<SelectionKey> varB4EAC82CA7396A68D541C85D26508E83_394163190 = null; //Variable for return #1
        checkClosed();
        varB4EAC82CA7396A68D541C85D26508E83_394163190 = selectedKeys;
        varB4EAC82CA7396A68D541C85D26508E83_394163190.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_394163190;
        // ---------- Original Method ----------
        //checkClosed();
        //return selectedKeys;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.524 -0400", hash_original_method = "ECFBB6A45EE52702BEFF3EF78A8EE9C3", hash_generated_method = "081F71E00454E4819321B36AD1CD0B13")
    private int doCancel() {
        int deselected;
        deselected = 0;
        Set<SelectionKey> cancelledKeys;
        cancelledKeys = cancelledKeys();
        {
            {
                boolean varDA5BDE2673A39D0943BBFA42DB73C05D_76131988 = (cancelledKeys.size() > 0);
                {
                    {
                        Iterator<SelectionKey> varB3EB1F654ACD0BCB98AC7E40841523F0_105303936 = (cancelledKeys).iterator();
                        varB3EB1F654ACD0BCB98AC7E40841523F0_105303936.hasNext();
                        SelectionKey currentKey = varB3EB1F654ACD0BCB98AC7E40841523F0_105303936.next();
                        {
                            mutableKeys.remove(currentKey);
                            deregister((AbstractSelectionKey) currentKey);
                            {
                                boolean var7E2CA0DCD7677691B7BD67D99C584907_1230237631 = (mutableSelectedKeys.remove(currentKey));
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    cancelledKeys.clear();
                } //End block
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299704584 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299704584;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.529 -0400", hash_original_method = "BDB632D034A5FFBF79564927E2AB1FFB", hash_generated_method = "1E1CBE49E465E903C6CDCA7BBB21373F")
    @Override
    public Selector wakeup() {
        Selector varB4EAC82CA7396A68D541C85D26508E83_284258856 = null; //Variable for return #1
        try 
        {
            Libcore.os.write(wakeupOut, new byte[] { 1 }, 0, 1);
        } //End block
        catch (ErrnoException ignored)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_284258856 = this;
        varB4EAC82CA7396A68D541C85D26508E83_284258856.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_284258856;
        // ---------- Original Method ----------
        //try {
            //Libcore.os.write(wakeupOut, new byte[] { 1 }, 0, 1);
        //} catch (ErrnoException ignored) {
        //}
        //return this;
    }

    
    private static class UnaddableSet<E> implements Set<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.529 -0400", hash_original_field = "CDAEEEBA9B4A4C5EBF042C0215A7BB0E", hash_generated_field = "9C45C0B407AF9ECDDC9EEE7EDB68F0BC")

        private Set<E> set;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.529 -0400", hash_original_method = "62B3F0681944A36B1514E173BA40D640", hash_generated_method = "24D039260CAE976729B60C3FC4D09830")
          UnaddableSet(Set<E> set) {
            this.set = set;
            // ---------- Original Method ----------
            //this.set = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.529 -0400", hash_original_method = "2B5DAD0814D02A1062AA1260B368EAF3", hash_generated_method = "C5AD7ED4B167B01271E2DA70198E2A45")
        @Override
        public boolean equals(Object object) {
            boolean varEE711F0F2C37A27C8631DAB77534C6D5_758469181 = (set.equals(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1455984899 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1455984899;
            // ---------- Original Method ----------
            //return set.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.531 -0400", hash_original_method = "37617F952144E382F24B98396CD1D4D1", hash_generated_method = "9B4A556F9E6BD4C44B227DA567523743")
        @Override
        public int hashCode() {
            int var687AE630E82E5F04D274B7201D441CA3_1921367611 = (set.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858019799 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858019799;
            // ---------- Original Method ----------
            //return set.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.532 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "834743E3B2C53E4EA77CB1EE2FB3091C")
        public boolean add(E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_311508646 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_311508646;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.532 -0400", hash_original_method = "A5D17047871533A4FE91F018C1332208", hash_generated_method = "49E0836941924F4121237364EBD685EB")
        public boolean addAll(Collection<? extends E> c) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(c.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_228257769 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_228257769;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.540 -0400", hash_original_method = "3FA453B9F7C92A0D7DD94260C67D9514", hash_generated_method = "10CF0C52087B2BD183B302B8BEE1DA86")
        public void clear() {
            set.clear();
            // ---------- Original Method ----------
            //set.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.543 -0400", hash_original_method = "86589639BC226555A84E0620C45B13EB", hash_generated_method = "03467C3866E4D41FDD13C1E53EB1EB88")
        public boolean contains(Object object) {
            boolean varB62F3B41EA81674D20ACB4B91E5F369F_1260302449 = (set.contains(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_211054497 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_211054497;
            // ---------- Original Method ----------
            //return set.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.557 -0400", hash_original_method = "3FEE08DBC0596E43AC262D36678D5ED8", hash_generated_method = "749C5C0CD221234EB0DBAC02D20E9303")
        public boolean containsAll(Collection<?> c) {
            boolean var4FBF8840906BA8F706DFD15BB30FDF51_824402781 = (set.containsAll(c));
            addTaint(c.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1259851345 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1259851345;
            // ---------- Original Method ----------
            //return set.containsAll(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.560 -0400", hash_original_method = "77AAB60D4A31FA879BC76A6A4D9C7743", hash_generated_method = "F5191BBF34FCBC31CBFAC3C09CC9DE0F")
        public boolean isEmpty() {
            boolean var59656714B8D007C863A242B248D8CAB2_813958639 = (set.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1398353894 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1398353894;
            // ---------- Original Method ----------
            //return set.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.560 -0400", hash_original_method = "7FB7F4965058B71D097578895F541442", hash_generated_method = "CDB277543F48E5EA29862EB71E48E411")
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1138242484 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1138242484 = set.iterator();
            varB4EAC82CA7396A68D541C85D26508E83_1138242484.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1138242484;
            // ---------- Original Method ----------
            //return set.iterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.561 -0400", hash_original_method = "2486ACD2DD23466CE4FFA1B67E298992", hash_generated_method = "8C17C0B75ED3D753C29CC38521B6B935")
        public boolean remove(Object object) {
            boolean var4892D93910CE0A42611177CCAA08D4DC_732904024 = (set.remove(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_791309979 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_791309979;
            // ---------- Original Method ----------
            //return set.remove(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.561 -0400", hash_original_method = "BBEFDF942C9288158521A1B78A605140", hash_generated_method = "5A0A487AFAE5DDE0CC2D0364D451918A")
        public boolean removeAll(Collection<?> c) {
            boolean var7C5A17588BB8737E6D4E9A388C65E7DA_1933468840 = (set.removeAll(c));
            addTaint(c.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_395578497 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_395578497;
            // ---------- Original Method ----------
            //return set.removeAll(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.561 -0400", hash_original_method = "06DB016CCB1303D382A7D35EBEF3182D", hash_generated_method = "A6796ACDB61BF5136DE740552BA30139")
        public boolean retainAll(Collection<?> c) {
            boolean var87641AE296EDD6958EE072FAD8F20AC2_1946372944 = (set.retainAll(c));
            addTaint(c.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_655237282 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_655237282;
            // ---------- Original Method ----------
            //return set.retainAll(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.561 -0400", hash_original_method = "283365B7154686D5E09A8541EE47F429", hash_generated_method = "50D78F2F391806FEF5EDBA59A5F485FE")
        public int size() {
            int var1607BC970B04E573A253638C3626122E_296679773 = (set.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2022434942 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2022434942;
            // ---------- Original Method ----------
            //return set.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.562 -0400", hash_original_method = "A39D4D1F48CDD6F8823B658123DCFC27", hash_generated_method = "6BABFB578D5523BBD97FBCC9373CFE10")
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1849858939 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1849858939 = set.toArray();
            varB4EAC82CA7396A68D541C85D26508E83_1849858939.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1849858939;
            // ---------- Original Method ----------
            //return set.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.562 -0400", hash_original_method = "820308A08287454AD26ACE5A2E12E893", hash_generated_method = "DB302D7A7B9001CB7E00878E3AC50EC5")
        public <T> T[] toArray(T[] a) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_82840419 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_82840419 = set.toArray(a);
            addTaint(a[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_82840419.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_82840419;
            // ---------- Original Method ----------
            //return set.toArray(a);
        }

        
    }


    
}

