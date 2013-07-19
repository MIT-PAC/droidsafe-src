package java.nio;

// Droidsafe Imports
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
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

final class SelectorImpl extends AbstractSelector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.853 -0400", hash_original_field = "68EA0DC5C7CD33D02AB22A452F03FE60", hash_generated_field = "6DE612B35C9E8808CBEC2658E9286A57")

    final Object keysLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.853 -0400", hash_original_field = "83A1F06691F0845CE271880E5306F61D", hash_generated_field = "FC886FA77928694F4640D640BCFDF7BE")

    private final Set<SelectionKeyImpl> mutableKeys = new HashSet<SelectionKeyImpl>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.854 -0400", hash_original_field = "06FE9A9785A5E218E61382601BE7AEA9", hash_generated_field = "3DBE34F9B4C5E57002A17A3BD0063AA5")

    private final Set<SelectionKey> unmodifiableKeys = Collections
            .<SelectionKey>unmodifiableSet(mutableKeys);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.854 -0400", hash_original_field = "B39C5824037C8795986A4322D6F60C74", hash_generated_field = "2D8093EE2318D28CDED981CA87DED90A")

    private final Set<SelectionKey> mutableSelectedKeys = new HashSet<SelectionKey>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.854 -0400", hash_original_field = "7C094124CEBE65DD469D3FDD7E9DBCEE", hash_generated_field = "451F342BD781ADBAA504C0DDB5A78C6B")

    private final Set<SelectionKey> selectedKeys = new UnaddableSet<SelectionKey>(mutableSelectedKeys);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.854 -0400", hash_original_field = "1520E765F593638EDCB265402754CD3E", hash_generated_field = "6285C31CC7936F0AB3F1C69023A1F29D")

    private FileDescriptor wakeupIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.854 -0400", hash_original_field = "BCCDE90494ACE5D7D2083A58DE8283E4", hash_generated_field = "B95606F2D0BB7B9FC7D15F5B7CD880CE")

    private FileDescriptor wakeupOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.854 -0400", hash_original_field = "7120FBD1CCE52C44D518F50E24E860AE", hash_generated_field = "EFB3CC6DFEED71DE9DAD42AA06EB7441")

    private final UnsafeArrayList<StructPollfd> pollFds = new UnsafeArrayList<StructPollfd>(StructPollfd.class, 8);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.863 -0400", hash_original_method = "E76FB669EB1C2C846C756C0996AB21F1", hash_generated_method = "0D9E1647B78BE0B9097C1A41C340E265")
    public  SelectorImpl(SelectorProvider selectorProvider) throws IOException {
        super(selectorProvider);
        addTaint(selectorProvider.getTaint());
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
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_1441731948 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_1441731948.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_1441731948;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.863 -0400", hash_original_method = "79B2402F6F8D60BF0FF9B9A0443FD747", hash_generated_method = "70E27ED7321DB7468FFF319F085D615D")
    @Override
    protected void implCloseSelector() throws IOException {
        wakeup();
        synchronized
(this)        {
            synchronized
(unmodifiableKeys)            {
                synchronized
(selectedKeys)                {
                    IoUtils.close(wakeupIn);
                    IoUtils.close(wakeupOut);
                    doCancel();
for(SelectionKey sk : mutableKeys)
                    {
                        deregister((AbstractSelectionKey) sk);
                    } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.864 -0400", hash_original_method = "9A9EE2D9A12F669E7C7AAB88B3AE3EAA", hash_generated_method = "BBEC3840B68DBC4B89274938EDAFA0AE")
    @Override
    protected SelectionKey register(AbstractSelectableChannel channel,
            int operations, Object attachment) {
        addTaint(attachment.getTaint());
        addTaint(operations);
        addTaint(channel.getTaint());
        if(!provider().equals(channel.provider()))        
        {
            IllegalSelectorException varA988BB20ADD0DC658BE68F9A5362E806_1582360702 = new IllegalSelectorException();
            varA988BB20ADD0DC658BE68F9A5362E806_1582360702.addTaint(taint);
            throw varA988BB20ADD0DC658BE68F9A5362E806_1582360702;
        } //End block
        synchronized
(this)        {
            synchronized
(unmodifiableKeys)            {
                SelectionKeyImpl selectionKey = new SelectionKeyImpl(channel, operations,
                        attachment, this);
                mutableKeys.add(selectionKey);
                ensurePollFdsCapacity();
SelectionKey var4F9CDD7F2704ACF6152924C37B86941A_607645589 =                 selectionKey;
                var4F9CDD7F2704ACF6152924C37B86941A_607645589.addTaint(taint);
                return var4F9CDD7F2704ACF6152924C37B86941A_607645589;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.864 -0400", hash_original_method = "6BEEFC0027B3DD3AFC5CFC7324737402", hash_generated_method = "7771B31C059185734609AB6006A47EF7")
    @Override
    public synchronized Set<SelectionKey> keys() {
        checkClosed();
Set<SelectionKey> varE297A0460B7287415A581826D165DD43_1192850091 =         unmodifiableKeys;
        varE297A0460B7287415A581826D165DD43_1192850091.addTaint(taint);
        return varE297A0460B7287415A581826D165DD43_1192850091;
        // ---------- Original Method ----------
        //checkClosed();
        //return unmodifiableKeys;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.865 -0400", hash_original_method = "16DB849132AADD2CAC6FB8494D5700D0", hash_generated_method = "2B4032921A17EBB066EE04BD5ED8FE7F")
    private void checkClosed() {
        if(!isOpen())        
        {
            ClosedSelectorException varA7F8757A661402ADD77C64CBC6015103_1171429103 = new ClosedSelectorException();
            varA7F8757A661402ADD77C64CBC6015103_1171429103.addTaint(taint);
            throw varA7F8757A661402ADD77C64CBC6015103_1171429103;
        } //End block
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedSelectorException();
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.865 -0400", hash_original_method = "0F4ACBA61BED328D03506D362DC34EE4", hash_generated_method = "AE2A683CDF735ACCB371DBDF78C84C2C")
    @Override
    public int select() throws IOException {
        int var3ACA056F0F9F97AB4732FD27F29A9127_1821088631 = (selectInternal(-1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1367094704 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1367094704;
        // ---------- Original Method ----------
        //return selectInternal(-1);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.865 -0400", hash_original_method = "38CB8C7854E3817F0A25B22A5C37D9C3", hash_generated_method = "5C052E26FB2000F3798BAE31796A6B26")
    @Override
    public int select(long timeout) throws IOException {
        addTaint(timeout);
        if(timeout < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_71869620 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_71869620.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_71869620;
        } //End block
        int var794100697C784F731F6EA977C2846181_157720476 = (selectInternal((timeout == 0) ? -1 : timeout));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592894650 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592894650;
        // ---------- Original Method ----------
        //if (timeout < 0) {
            //throw new IllegalArgumentException();
        //}
        //return selectInternal((timeout == 0) ? -1 : timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.866 -0400", hash_original_method = "06C4B09F10BB426C607790AD420FF9C5", hash_generated_method = "F29FF2F2684C976BBFADDF0F03A9EC6C")
    @Override
    public int selectNow() throws IOException {
        int var5611EC62D1E37E168CF6DB481DD252DF_1834340897 = (selectInternal(0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_95087766 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_95087766;
        // ---------- Original Method ----------
        //return selectInternal(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.891 -0400", hash_original_method = "07E877B82AC1C68A90F5E02CD6388406", hash_generated_method = "F438C1EEB0AABA819FBDCA35CC69D6ED")
    private int selectInternal(long timeout) throws IOException {
        addTaint(timeout);
        checkClosed();
        synchronized
(this)        {
            synchronized
(unmodifiableKeys)            {
                synchronized
(selectedKeys)                {
                    doCancel();
                    boolean isBlock = (timeout != 0);
                    synchronized
(keysLock)                    {
                        preparePollFds();
                    } //End block
                    int rc;
                    try 
                    {
                        if(isBlock)                        
                        {
                            begin();
                        } //End block
                        try 
                        {
                            rc = Libcore.os.poll(pollFds.array(), (int) timeout);
                        } //End block
                        catch (ErrnoException errnoException)
                        {
                            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_1205828802 = errnoException.rethrowAsIOException();
                            var533DBF3F7D78874DC97ED285C3BC3B22_1205828802.addTaint(taint);
                            throw var533DBF3F7D78874DC97ED285C3BC3B22_1205828802;
                        } //End block
                    } //End block
                    finally 
                    {
                        if(isBlock)                        
                        {
                            end();
                        } //End block
                    } //End block
                    int readyCount = (rc > 0) ? processPollFds() : 0;
                    readyCount -= doCancel();
                    int varD7662A05551DC308495E8EB1B372825A_746945854 = (readyCount);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548473161 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548473161;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.892 -0400", hash_original_method = "1864B10FEC667AA8A534CE9CC6FD0BC2", hash_generated_method = "491C65C71FDA317098D7EF3A364A9198")
    private void setPollFd(int i, FileDescriptor fd, int events, Object object) {
        addTaint(object.getTaint());
        addTaint(events);
        addTaint(fd.getTaint());
        addTaint(i);
        StructPollfd pollFd = pollFds.get(i);
        pollFd.fd = fd;
        pollFd.events = (short) events;
        pollFd.userData = object;
        // ---------- Original Method ----------
        //StructPollfd pollFd = pollFds.get(i);
        //pollFd.fd = fd;
        //pollFd.events = (short) events;
        //pollFd.userData = object;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.892 -0400", hash_original_method = "C2C79FE5727E3E67D8033155BDE5FA42", hash_generated_method = "0239ABC7D1648C3C8AD66B2BB6D18196")
    private void preparePollFds() {
        int i = 1;
for(SelectionKeyImpl key : mutableKeys)
        {
            int interestOps = key.interestOpsNoCheck();
            short eventMask = 0;
            if(((OP_ACCEPT | OP_READ) & interestOps) != 0)            
            {
                eventMask |= POLLIN;
            } //End block
            if(((OP_CONNECT | OP_WRITE) & interestOps) != 0)            
            {
                eventMask |= POLLOUT;
            } //End block
            if(eventMask != 0)            
            {
                setPollFd(i++, ((FileDescriptorChannel) key.channel()).getFD(), eventMask, key);
            } //End block
        } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.893 -0400", hash_original_method = "561794DF92118E00B9893BD515660DDC", hash_generated_method = "9C36A453C6F6647C691C85BECA480CFE")
    private void ensurePollFdsCapacity() {
        while
(pollFds.size() < mutableKeys.size() + 1)        
        {
            pollFds.add(new StructPollfd());
        } //End block
        // ---------- Original Method ----------
        //while (pollFds.size() < mutableKeys.size() + 1) {
            //pollFds.add(new StructPollfd());
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.894 -0400", hash_original_method = "5DC934A1F65A8C13AADF3FD37642D2BD", hash_generated_method = "E548464CF6F8C196D8B863A685889923")
    private int processPollFds() throws IOException {
        if(pollFds.get(0).revents == POLLIN)        
        {
            byte[] buffer = new byte[8];
            while
(IoBridge.read(wakeupIn, buffer, 0, 1) > 0)            
            {
            } //End block
        } //End block
        int readyKeyCount = 0;
for(int i = 1;i < pollFds.size();++i)
        {
            StructPollfd pollFd = pollFds.get(i);
            if(pollFd.revents == 0)            
            {
                continue;
            } //End block
            if(pollFd.fd == null)            
            {
                break;
            } //End block
            SelectionKeyImpl key = (SelectionKeyImpl) pollFd.userData;
            pollFd.fd = null;
            pollFd.userData = null;
            int ops = key.interestOpsNoCheck();
            int selectedOp = 0;
            if((pollFd.revents & POLLIN) != 0)            
            {
                selectedOp = ops & (OP_ACCEPT | OP_READ);
            } //End block
            else
            if((pollFd.revents & POLLOUT) != 0)            
            {
                if(key.isConnected())                
                {
                    selectedOp = ops & OP_WRITE;
                } //End block
                else
                {
                    selectedOp = ops & OP_CONNECT;
                } //End block
            } //End block
            if(selectedOp != 0)            
            {
                boolean wasSelected = mutableSelectedKeys.contains(key);
                if(wasSelected && key.readyOps() != selectedOp)                
                {
                    key.setReadyOps(key.readyOps() | selectedOp);
                    ++readyKeyCount;
                } //End block
                else
                if(!wasSelected)                
                {
                    key.setReadyOps(selectedOp);
                    mutableSelectedKeys.add(key);
                    ++readyKeyCount;
                } //End block
            } //End block
        } //End block
        int varD5B4E54470B2177FDDFB63AB47B62A38_497531375 = (readyKeyCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287504043 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287504043;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.894 -0400", hash_original_method = "0EB011B4E4087026D6BA472324142821", hash_generated_method = "576B16C00903A3B8864D4B9C25ADE439")
    @Override
    public synchronized Set<SelectionKey> selectedKeys() {
        checkClosed();
Set<SelectionKey> varD4515E6E6CFA065CDA39E787B1F4334B_235757191 =         selectedKeys;
        varD4515E6E6CFA065CDA39E787B1F4334B_235757191.addTaint(taint);
        return varD4515E6E6CFA065CDA39E787B1F4334B_235757191;
        // ---------- Original Method ----------
        //checkClosed();
        //return selectedKeys;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.895 -0400", hash_original_method = "ECFBB6A45EE52702BEFF3EF78A8EE9C3", hash_generated_method = "3E6C15FBBF84F8664E50DCF3A94B13A8")
    private int doCancel() {
        int deselected = 0;
        Set<SelectionKey> cancelledKeys = cancelledKeys();
        synchronized
(cancelledKeys)        {
            if(cancelledKeys.size() > 0)            
            {
for(SelectionKey currentKey : cancelledKeys)
                {
                    mutableKeys.remove(currentKey);
                    deregister((AbstractSelectionKey) currentKey);
                    if(mutableSelectedKeys.remove(currentKey))                    
                    {
                        deselected++;
                    } //End block
                } //End block
                cancelledKeys.clear();
            } //End block
        } //End block
        int var4B58344620E1135E0EBB235B8686828A_835034098 = (deselected);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_822849184 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_822849184;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.895 -0400", hash_original_method = "BDB632D034A5FFBF79564927E2AB1FFB", hash_generated_method = "6F099BD1D1B9A0B6B5B68E95BACCD532")
    @Override
    public Selector wakeup() {
        try 
        {
            Libcore.os.write(wakeupOut, new byte[] { 1 }, 0, 1);
        } //End block
        catch (ErrnoException ignored)
        {
        } //End block
Selector var72A74007B2BE62B849F475C7BDA4658B_655359479 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_655359479.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_655359479;
        // ---------- Original Method ----------
        //try {
            //Libcore.os.write(wakeupOut, new byte[] { 1 }, 0, 1);
        //} catch (ErrnoException ignored) {
        //}
        //return this;
    }

    
    private static class UnaddableSet<E> implements Set<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.896 -0400", hash_original_field = "CDAEEEBA9B4A4C5EBF042C0215A7BB0E", hash_generated_field = "9C45C0B407AF9ECDDC9EEE7EDB68F0BC")

        private Set<E> set;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.896 -0400", hash_original_method = "62B3F0681944A36B1514E173BA40D640", hash_generated_method = "24D039260CAE976729B60C3FC4D09830")
          UnaddableSet(Set<E> set) {
            this.set = set;
            // ---------- Original Method ----------
            //this.set = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.897 -0400", hash_original_method = "2B5DAD0814D02A1062AA1260B368EAF3", hash_generated_method = "EC0A658AF3AAB161EB7E7CDE49F68C2C")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            boolean varD09302992C43151231B741B6CCC9F445_1347726226 = (set.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1834002943 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1834002943;
            // ---------- Original Method ----------
            //return set.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.897 -0400", hash_original_method = "37617F952144E382F24B98396CD1D4D1", hash_generated_method = "E1341A0A850A3B05DA8C7CD5125C5A67")
        @Override
        public int hashCode() {
            int varEB2ECC48AB1A8B015D6D672DC48B8DC4_428459482 = (set.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_356883305 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_356883305;
            // ---------- Original Method ----------
            //return set.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.897 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "49963853E7F1B9BD03F53BC04CCF9061")
        public boolean add(E object) {
            addTaint(object.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1091116129 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1091116129.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1091116129;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.898 -0400", hash_original_method = "A5D17047871533A4FE91F018C1332208", hash_generated_method = "77B70C9AD52619A8FB358E2D67C75937")
        public boolean addAll(Collection<? extends E> c) {
            addTaint(c.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1179781410 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1179781410.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1179781410;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.898 -0400", hash_original_method = "3FA453B9F7C92A0D7DD94260C67D9514", hash_generated_method = "10CF0C52087B2BD183B302B8BEE1DA86")
        public void clear() {
            set.clear();
            // ---------- Original Method ----------
            //set.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.899 -0400", hash_original_method = "86589639BC226555A84E0620C45B13EB", hash_generated_method = "BD25583E2E90C1E13BCD6AA570754DAA")
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var23679C1C5586286BA5F568BFFB1B9E25_1768150734 = (set.contains(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1861733487 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1861733487;
            // ---------- Original Method ----------
            //return set.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.899 -0400", hash_original_method = "3FEE08DBC0596E43AC262D36678D5ED8", hash_generated_method = "519E311B92FF528C32E6EB92D40C7504")
        public boolean containsAll(Collection<?> c) {
            addTaint(c.getTaint());
            boolean varB832275728841535AC926024BCEC145F_136737603 = (set.containsAll(c));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2086566606 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2086566606;
            // ---------- Original Method ----------
            //return set.containsAll(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.899 -0400", hash_original_method = "77AAB60D4A31FA879BC76A6A4D9C7743", hash_generated_method = "351C6EBDF1C8BA25DA8D1357083867E5")
        public boolean isEmpty() {
            boolean var08EDAD7A98754E14B01D22C183E68FB5_956915836 = (set.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1386204493 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1386204493;
            // ---------- Original Method ----------
            //return set.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.900 -0400", hash_original_method = "7FB7F4965058B71D097578895F541442", hash_generated_method = "46A692B483BF35203A34804B433D98ED")
        public Iterator<E> iterator() {
Iterator<E> var8F246CA48C5D8CF09BCA9BB23A08E21D_556578248 =             set.iterator();
            var8F246CA48C5D8CF09BCA9BB23A08E21D_556578248.addTaint(taint);
            return var8F246CA48C5D8CF09BCA9BB23A08E21D_556578248;
            // ---------- Original Method ----------
            //return set.iterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.901 -0400", hash_original_method = "2486ACD2DD23466CE4FFA1B67E298992", hash_generated_method = "E145E639896E77FB385F71B77B622114")
        public boolean remove(Object object) {
            addTaint(object.getTaint());
            boolean var72E39E1DF9CC73C527F9C7BDAC6B612C_2093529723 = (set.remove(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1608794416 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1608794416;
            // ---------- Original Method ----------
            //return set.remove(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.901 -0400", hash_original_method = "BBEFDF942C9288158521A1B78A605140", hash_generated_method = "2A92FFDBA3D2BA44956D003AEAE50F05")
        public boolean removeAll(Collection<?> c) {
            addTaint(c.getTaint());
            boolean var32B1AF55F57B58331E9EFAC1095A1A6C_1713888506 = (set.removeAll(c));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_34909492 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_34909492;
            // ---------- Original Method ----------
            //return set.removeAll(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.902 -0400", hash_original_method = "06DB016CCB1303D382A7D35EBEF3182D", hash_generated_method = "D26954D8E6F0E10D3A40DE2F91D275EA")
        public boolean retainAll(Collection<?> c) {
            addTaint(c.getTaint());
            boolean varF4736845F3B97EDCDFB67BDFB56448BA_1413342803 = (set.retainAll(c));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_779671103 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_779671103;
            // ---------- Original Method ----------
            //return set.retainAll(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.902 -0400", hash_original_method = "283365B7154686D5E09A8541EE47F429", hash_generated_method = "D6049B384B9789525ABC93B9CC9CE83A")
        public int size() {
            int varC11C5BB059CE54FB66F4294B0D28BA2A_909515838 = (set.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1560304024 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1560304024;
            // ---------- Original Method ----------
            //return set.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.903 -0400", hash_original_method = "A39D4D1F48CDD6F8823B658123DCFC27", hash_generated_method = "052FF75D0051CF99CE77AFA27EED385C")
        public Object[] toArray() {
Object[] varDC748A26B5BB4C3F420CE5782606A6AD_2002771206 =             set.toArray();
            varDC748A26B5BB4C3F420CE5782606A6AD_2002771206.addTaint(taint);
            return varDC748A26B5BB4C3F420CE5782606A6AD_2002771206;
            // ---------- Original Method ----------
            //return set.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.903 -0400", hash_original_method = "820308A08287454AD26ACE5A2E12E893", hash_generated_method = "C858378E5DE3F08ADC16EF2E7BFADF34")
        public <T> T[] toArray(T[] a) {
            addTaint(a[0].getTaint());
T[] varBD37699932362128D1DCA08F9CDDCC12_2067346240 =             set.toArray(a);
            varBD37699932362128D1DCA08F9CDDCC12_2067346240.addTaint(taint);
            return varBD37699932362128D1DCA08F9CDDCC12_2067346240;
            // ---------- Original Method ----------
            //return set.toArray(a);
        }

        
    }


    
}

