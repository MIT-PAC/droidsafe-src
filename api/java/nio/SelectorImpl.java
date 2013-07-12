package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.234 -0400", hash_original_field = "68EA0DC5C7CD33D02AB22A452F03FE60", hash_generated_field = "6DE612B35C9E8808CBEC2658E9286A57")

    final Object keysLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.234 -0400", hash_original_field = "83A1F06691F0845CE271880E5306F61D", hash_generated_field = "FC886FA77928694F4640D640BCFDF7BE")

    private final Set<SelectionKeyImpl> mutableKeys = new HashSet<SelectionKeyImpl>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.234 -0400", hash_original_field = "06FE9A9785A5E218E61382601BE7AEA9", hash_generated_field = "3DBE34F9B4C5E57002A17A3BD0063AA5")

    private final Set<SelectionKey> unmodifiableKeys = Collections
            .<SelectionKey>unmodifiableSet(mutableKeys);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.234 -0400", hash_original_field = "B39C5824037C8795986A4322D6F60C74", hash_generated_field = "2D8093EE2318D28CDED981CA87DED90A")

    private final Set<SelectionKey> mutableSelectedKeys = new HashSet<SelectionKey>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.235 -0400", hash_original_field = "7C094124CEBE65DD469D3FDD7E9DBCEE", hash_generated_field = "451F342BD781ADBAA504C0DDB5A78C6B")

    private final Set<SelectionKey> selectedKeys = new UnaddableSet<SelectionKey>(mutableSelectedKeys);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.235 -0400", hash_original_field = "1520E765F593638EDCB265402754CD3E", hash_generated_field = "6285C31CC7936F0AB3F1C69023A1F29D")

    private FileDescriptor wakeupIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.235 -0400", hash_original_field = "BCCDE90494ACE5D7D2083A58DE8283E4", hash_generated_field = "B95606F2D0BB7B9FC7D15F5B7CD880CE")

    private FileDescriptor wakeupOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.235 -0400", hash_original_field = "7120FBD1CCE52C44D518F50E24E860AE", hash_generated_field = "EFB3CC6DFEED71DE9DAD42AA06EB7441")

    private final UnsafeArrayList<StructPollfd> pollFds = new UnsafeArrayList<StructPollfd>(StructPollfd.class, 8);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.242 -0400", hash_original_method = "E76FB669EB1C2C846C756C0996AB21F1", hash_generated_method = "7EBF04E8B2E6E712B1E03CE219A935FB")
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
        } 
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_850281378 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_850281378.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_850281378;
        } 
        
        
            
            
            
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.242 -0400", hash_original_method = "79B2402F6F8D60BF0FF9B9A0443FD747", hash_generated_method = "70E27ED7321DB7468FFF319F085D615D")
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
                    } 
                } 
            } 
        } 
        
        
        
            
                
                    
                    
                    
                    
                        
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.243 -0400", hash_original_method = "9A9EE2D9A12F669E7C7AAB88B3AE3EAA", hash_generated_method = "951E10C08CA64DC763C026BA000F1B55")
    @Override
    protected SelectionKey register(AbstractSelectableChannel channel,
            int operations, Object attachment) {
        addTaint(attachment.getTaint());
        addTaint(operations);
        addTaint(channel.getTaint());
    if(!provider().equals(channel.provider()))        
        {
            IllegalSelectorException varA988BB20ADD0DC658BE68F9A5362E806_1852100615 = new IllegalSelectorException();
            varA988BB20ADD0DC658BE68F9A5362E806_1852100615.addTaint(taint);
            throw varA988BB20ADD0DC658BE68F9A5362E806_1852100615;
        } 
        synchronized
(this)        {
            synchronized
(unmodifiableKeys)            {
                SelectionKeyImpl selectionKey = new SelectionKeyImpl(channel, operations,
                        attachment, this);
                mutableKeys.add(selectionKey);
                ensurePollFdsCapacity();
SelectionKey var4F9CDD7F2704ACF6152924C37B86941A_1863938183 =                 selectionKey;
                var4F9CDD7F2704ACF6152924C37B86941A_1863938183.addTaint(taint);
                return var4F9CDD7F2704ACF6152924C37B86941A_1863938183;
            } 
        } 
        
        
            
        
        
            
                
                        
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.244 -0400", hash_original_method = "6BEEFC0027B3DD3AFC5CFC7324737402", hash_generated_method = "EB927477B6D941372BA2BAC459597BB7")
    @Override
    public synchronized Set<SelectionKey> keys() {
        checkClosed();
Set<SelectionKey> varE297A0460B7287415A581826D165DD43_2019360523 =         unmodifiableKeys;
        varE297A0460B7287415A581826D165DD43_2019360523.addTaint(taint);
        return varE297A0460B7287415A581826D165DD43_2019360523;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.244 -0400", hash_original_method = "16DB849132AADD2CAC6FB8494D5700D0", hash_generated_method = "389C6F23D9BF1A9CCD7D651175B1698B")
    private void checkClosed() {
    if(!isOpen())        
        {
            ClosedSelectorException varA7F8757A661402ADD77C64CBC6015103_501848141 = new ClosedSelectorException();
            varA7F8757A661402ADD77C64CBC6015103_501848141.addTaint(taint);
            throw varA7F8757A661402ADD77C64CBC6015103_501848141;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.244 -0400", hash_original_method = "0F4ACBA61BED328D03506D362DC34EE4", hash_generated_method = "238561D63C5BE98F178302B166B51BB4")
    @Override
    public int select() throws IOException {
        int var3ACA056F0F9F97AB4732FD27F29A9127_1188495450 = (selectInternal(-1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399412731 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399412731;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.245 -0400", hash_original_method = "38CB8C7854E3817F0A25B22A5C37D9C3", hash_generated_method = "0C942A91D8773EA6F343A0D30A1A3C5C")
    @Override
    public int select(long timeout) throws IOException {
        addTaint(timeout);
    if(timeout < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1902619348 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1902619348.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1902619348;
        } 
        int var794100697C784F731F6EA977C2846181_1522243628 = (selectInternal((timeout == 0) ? -1 : timeout));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1275526820 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1275526820;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.245 -0400", hash_original_method = "06C4B09F10BB426C607790AD420FF9C5", hash_generated_method = "FC157C209501B15E9B8F1CC43E81405E")
    @Override
    public int selectNow() throws IOException {
        int var5611EC62D1E37E168CF6DB481DD252DF_270944065 = (selectInternal(0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396324633 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396324633;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.266 -0400", hash_original_method = "07E877B82AC1C68A90F5E02CD6388406", hash_generated_method = "07F342A318AC755FC7D5A5A3C67D31F9")
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
                    } 
                    int rc;
                    try 
                    {
    if(isBlock)                        
                        {
                            begin();
                        } 
                        try 
                        {
                            rc = Libcore.os.poll(pollFds.array(), (int) timeout);
                        } 
                        catch (ErrnoException errnoException)
                        {
                            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_1713401656 = errnoException.rethrowAsIOException();
                            var533DBF3F7D78874DC97ED285C3BC3B22_1713401656.addTaint(taint);
                            throw var533DBF3F7D78874DC97ED285C3BC3B22_1713401656;
                        } 
                    } 
                    finally 
                    {
    if(isBlock)                        
                        {
                            end();
                        } 
                    } 
                    int readyCount = (rc > 0) ? processPollFds() : 0;
                    readyCount -= doCancel();
                    int varD7662A05551DC308495E8EB1B372825A_252301316 = (readyCount);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707757533 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707757533;
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.267 -0400", hash_original_method = "1864B10FEC667AA8A534CE9CC6FD0BC2", hash_generated_method = "491C65C71FDA317098D7EF3A364A9198")
    private void setPollFd(int i, FileDescriptor fd, int events, Object object) {
        addTaint(object.getTaint());
        addTaint(events);
        addTaint(fd.getTaint());
        addTaint(i);
        StructPollfd pollFd = pollFds.get(i);
        pollFd.fd = fd;
        pollFd.events = (short) events;
        pollFd.userData = object;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.268 -0400", hash_original_method = "C2C79FE5727E3E67D8033155BDE5FA42", hash_generated_method = "0239ABC7D1648C3C8AD66B2BB6D18196")
    private void preparePollFds() {
        int i = 1;
for(SelectionKeyImpl key : mutableKeys)
        {
            int interestOps = key.interestOpsNoCheck();
            short eventMask = 0;
    if(((OP_ACCEPT | OP_READ) & interestOps) != 0)            
            {
                eventMask |= POLLIN;
            } 
    if(((OP_CONNECT | OP_WRITE) & interestOps) != 0)            
            {
                eventMask |= POLLOUT;
            } 
    if(eventMask != 0)            
            {
                setPollFd(i++, ((FileDescriptorChannel) key.channel()).getFD(), eventMask, key);
            } 
        } 
        
        
        
            
            
            
                
            
            
                
            
            
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.268 -0400", hash_original_method = "561794DF92118E00B9893BD515660DDC", hash_generated_method = "9C36A453C6F6647C691C85BECA480CFE")
    private void ensurePollFdsCapacity() {
        while
(pollFds.size() < mutableKeys.size() + 1)        
        {
            pollFds.add(new StructPollfd());
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.270 -0400", hash_original_method = "5DC934A1F65A8C13AADF3FD37642D2BD", hash_generated_method = "8300F361DCB52FE2D0178AA2B45A5A3F")
    private int processPollFds() throws IOException {
    if(pollFds.get(0).revents == POLLIN)        
        {
            byte[] buffer = new byte[8];
            while
(IoBridge.read(wakeupIn, buffer, 0, 1) > 0)            
            {
            } 
        } 
        int readyKeyCount = 0;
for(int i = 1;i < pollFds.size();++i)
        {
            StructPollfd pollFd = pollFds.get(i);
    if(pollFd.revents == 0)            
            {
                continue;
            } 
    if(pollFd.fd == null)            
            {
                break;
            } 
            SelectionKeyImpl key = (SelectionKeyImpl) pollFd.userData;
            pollFd.fd = null;
            pollFd.userData = null;
            int ops = key.interestOpsNoCheck();
            int selectedOp = 0;
    if((pollFd.revents & POLLIN) != 0)            
            {
                selectedOp = ops & (OP_ACCEPT | OP_READ);
            } 
            else
    if((pollFd.revents & POLLOUT) != 0)            
            {
    if(key.isConnected())                
                {
                    selectedOp = ops & OP_WRITE;
                } 
                else
                {
                    selectedOp = ops & OP_CONNECT;
                } 
            } 
    if(selectedOp != 0)            
            {
                boolean wasSelected = mutableSelectedKeys.contains(key);
    if(wasSelected && key.readyOps() != selectedOp)                
                {
                    key.setReadyOps(key.readyOps() | selectedOp);
                    ++readyKeyCount;
                } 
                else
    if(!wasSelected)                
                {
                    key.setReadyOps(selectedOp);
                    mutableSelectedKeys.add(key);
                    ++readyKeyCount;
                } 
            } 
        } 
        int varD5B4E54470B2177FDDFB63AB47B62A38_1620697806 = (readyKeyCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1360884023 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1360884023;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.270 -0400", hash_original_method = "0EB011B4E4087026D6BA472324142821", hash_generated_method = "53A0B74E374FF7D7F983772FE117DE48")
    @Override
    public synchronized Set<SelectionKey> selectedKeys() {
        checkClosed();
Set<SelectionKey> varD4515E6E6CFA065CDA39E787B1F4334B_771629127 =         selectedKeys;
        varD4515E6E6CFA065CDA39E787B1F4334B_771629127.addTaint(taint);
        return varD4515E6E6CFA065CDA39E787B1F4334B_771629127;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.271 -0400", hash_original_method = "ECFBB6A45EE52702BEFF3EF78A8EE9C3", hash_generated_method = "9CF8C137CE2A2C7A668EC15440D0996A")
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
                    } 
                } 
                cancelledKeys.clear();
            } 
        } 
        int var4B58344620E1135E0EBB235B8686828A_1654721758 = (deselected);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_416695973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_416695973;
        
        
        
        
            
                
                    
                    
                    
                        
                    
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.271 -0400", hash_original_method = "BDB632D034A5FFBF79564927E2AB1FFB", hash_generated_method = "E98296024AC57EC9253961A9696EDE32")
    @Override
    public Selector wakeup() {
        try 
        {
            Libcore.os.write(wakeupOut, new byte[] { 1 }, 0, 1);
        } 
        catch (ErrnoException ignored)
        {
        } 
Selector var72A74007B2BE62B849F475C7BDA4658B_1451014659 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1451014659.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1451014659;
        
        
            
        
        
        
    }

    
    private static class UnaddableSet<E> implements Set<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.272 -0400", hash_original_field = "CDAEEEBA9B4A4C5EBF042C0215A7BB0E", hash_generated_field = "9C45C0B407AF9ECDDC9EEE7EDB68F0BC")

        private Set<E> set;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.272 -0400", hash_original_method = "62B3F0681944A36B1514E173BA40D640", hash_generated_method = "24D039260CAE976729B60C3FC4D09830")
          UnaddableSet(Set<E> set) {
            this.set = set;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.273 -0400", hash_original_method = "2B5DAD0814D02A1062AA1260B368EAF3", hash_generated_method = "7786CEB87FD7E59FED323AB707EDE163")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            boolean varD09302992C43151231B741B6CCC9F445_1423567770 = (set.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_120559725 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_120559725;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.274 -0400", hash_original_method = "37617F952144E382F24B98396CD1D4D1", hash_generated_method = "D3116A2074C5C0BCFBCBC3BF5EB29A70")
        @Override
        public int hashCode() {
            int varEB2ECC48AB1A8B015D6D672DC48B8DC4_428798053 = (set.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1733798258 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1733798258;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.274 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "CD1ACAFCBB7DF545DAD15ACA32C524CF")
        public boolean add(E object) {
            addTaint(object.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_79454978 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_79454978.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_79454978;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.274 -0400", hash_original_method = "A5D17047871533A4FE91F018C1332208", hash_generated_method = "70DC2B33927580C92C771097A6041E30")
        public boolean addAll(Collection<? extends E> c) {
            addTaint(c.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_332104707 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_332104707.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_332104707;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.275 -0400", hash_original_method = "3FA453B9F7C92A0D7DD94260C67D9514", hash_generated_method = "10CF0C52087B2BD183B302B8BEE1DA86")
        public void clear() {
            set.clear();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.275 -0400", hash_original_method = "86589639BC226555A84E0620C45B13EB", hash_generated_method = "E7DF1B5987A05198F9EE0DF65A1D60A4")
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var23679C1C5586286BA5F568BFFB1B9E25_1035777572 = (set.contains(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_274725896 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_274725896;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.275 -0400", hash_original_method = "3FEE08DBC0596E43AC262D36678D5ED8", hash_generated_method = "43970A84501FD22D96B40DB8C1A26094")
        public boolean containsAll(Collection<?> c) {
            addTaint(c.getTaint());
            boolean varB832275728841535AC926024BCEC145F_1220234701 = (set.containsAll(c));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1691646545 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1691646545;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.276 -0400", hash_original_method = "77AAB60D4A31FA879BC76A6A4D9C7743", hash_generated_method = "85C8DC142E8CCB376E7A328C1ED928CD")
        public boolean isEmpty() {
            boolean var08EDAD7A98754E14B01D22C183E68FB5_857461218 = (set.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1145988005 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1145988005;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.276 -0400", hash_original_method = "7FB7F4965058B71D097578895F541442", hash_generated_method = "7F497D372B165C9B4754BB7BC3DD900F")
        public Iterator<E> iterator() {
Iterator<E> var8F246CA48C5D8CF09BCA9BB23A08E21D_2015743163 =             set.iterator();
            var8F246CA48C5D8CF09BCA9BB23A08E21D_2015743163.addTaint(taint);
            return var8F246CA48C5D8CF09BCA9BB23A08E21D_2015743163;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.276 -0400", hash_original_method = "2486ACD2DD23466CE4FFA1B67E298992", hash_generated_method = "CBD59627E3D05BA8F0B98975B8106814")
        public boolean remove(Object object) {
            addTaint(object.getTaint());
            boolean var72E39E1DF9CC73C527F9C7BDAC6B612C_1842666562 = (set.remove(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1229546104 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1229546104;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.277 -0400", hash_original_method = "BBEFDF942C9288158521A1B78A605140", hash_generated_method = "62BE32B4132EC652C30E653FBF3B1206")
        public boolean removeAll(Collection<?> c) {
            addTaint(c.getTaint());
            boolean var32B1AF55F57B58331E9EFAC1095A1A6C_927850845 = (set.removeAll(c));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2117602093 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2117602093;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.277 -0400", hash_original_method = "06DB016CCB1303D382A7D35EBEF3182D", hash_generated_method = "4117B91E27885486D6830D2DA627174F")
        public boolean retainAll(Collection<?> c) {
            addTaint(c.getTaint());
            boolean varF4736845F3B97EDCDFB67BDFB56448BA_366072413 = (set.retainAll(c));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1333798734 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1333798734;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.278 -0400", hash_original_method = "283365B7154686D5E09A8541EE47F429", hash_generated_method = "A37F9424CF0B0A4D44CB1673F56755C5")
        public int size() {
            int varC11C5BB059CE54FB66F4294B0D28BA2A_1393482101 = (set.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1570418708 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1570418708;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.278 -0400", hash_original_method = "A39D4D1F48CDD6F8823B658123DCFC27", hash_generated_method = "D38B079E92DBC120649788CF220DA2B6")
        public Object[] toArray() {
Object[] varDC748A26B5BB4C3F420CE5782606A6AD_167495555 =             set.toArray();
            varDC748A26B5BB4C3F420CE5782606A6AD_167495555.addTaint(taint);
            return varDC748A26B5BB4C3F420CE5782606A6AD_167495555;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.279 -0400", hash_original_method = "820308A08287454AD26ACE5A2E12E893", hash_generated_method = "ECDF1D72F0EDC6AFA4A8AF7C2B2927BB")
        public <T> T[] toArray(T[] a) {
            addTaint(a[0].getTaint());
T[] varBD37699932362128D1DCA08F9CDDCC12_66582927 =             set.toArray(a);
            varBD37699932362128D1DCA08F9CDDCC12_66582927.addTaint(taint);
            return varBD37699932362128D1DCA08F9CDDCC12_66582927;
            
            
        }

        
    }


    
}

