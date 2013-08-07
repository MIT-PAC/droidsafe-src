package java.nio.channels.spi;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.336 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0234634A410EB36D3E632222798EC314")

    private SelectorProvider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.336 -0400", hash_original_field = "26C871B41538315A5B97363A6A0B7C0F", hash_generated_field = "3B26D8208E36A3AF954A2D369F214698")

    private List<SelectionKey> keyList = new ArrayList<SelectionKey>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.336 -0400", hash_original_field = "123EFAD404EAB8F3DD3157D8F919C9E8", hash_generated_field = "9DDF47310598FEE3BE8DF77A18102341")

    private final Object blockingLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.336 -0400", hash_original_field = "87D2BB8F426AAF2B023F1238B6188AF2", hash_generated_field = "FBC5E3B60AE9541955B3D463A523710C")

    boolean isBlocking = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.337 -0400", hash_original_method = "C1ED2F1D0A9F053BD27B8788D8E263F6", hash_generated_method = "CDC2687EFBB1875408EB822640372289")
    protected  AbstractSelectableChannel(SelectorProvider selectorProvider) {
        provider = selectorProvider;
        // ---------- Original Method ----------
        //provider = selectorProvider;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.337 -0400", hash_original_method = "B098D2E33834ACCBC46AD074E583FD9B", hash_generated_method = "7E6FDE3C96DB2CF76F30A6BE453CB260")
    @Override
    public final SelectorProvider provider() {
SelectorProvider varC1EB7B12CCABB27D431E5B91E5FF9ECB_107796638 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_107796638.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_107796638;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.337 -0400", hash_original_method = "455A665D6CB2D7E9E28AF0A0296346A0", hash_generated_method = "26BF10C4D20A1A81FB955BD0D3BDA1E3")
    @Override
    synchronized public final boolean isRegistered() {
        boolean varB374C57CC5C93FDCD7C83C0F8B703F45_1188842316 = (!keyList.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1967987280 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1967987280;
        // ---------- Original Method ----------
        //return !keyList.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.338 -0400", hash_original_method = "4195F78E36942EF5DA6AFD3959F769A2", hash_generated_method = "6036BDA3E0590C575830AA886665FF8E")
    @Override
    synchronized public final SelectionKey keyFor(Selector selector) {
        addTaint(selector.getTaint());
for(SelectionKey key : keyList)
        {
            if(key != null && key.selector() == selector)            
            {
SelectionKey var6A95247616A3A8B93CFF7783DABD08D4_397850454 =                 key;
                var6A95247616A3A8B93CFF7783DABD08D4_397850454.addTaint(taint);
                return var6A95247616A3A8B93CFF7783DABD08D4_397850454;
            } //End block
        } //End block
SelectionKey var540C13E9E156B687226421B24F2DF178_1086697152 =         null;
        var540C13E9E156B687226421B24F2DF178_1086697152.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1086697152;
        // ---------- Original Method ----------
        //for (SelectionKey key : keyList) {
            //if (key != null && key.selector() == selector) {
                //return key;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.339 -0400", hash_original_method = "CA2D38B16FDF21D8F80456FE85BBCC03", hash_generated_method = "54790A405139D90228BF51435046D2C2")
    @Override
    public final SelectionKey register(Selector selector, int interestSet,
            Object attachment) throws ClosedChannelException {
        addTaint(attachment.getTaint());
        addTaint(interestSet);
        addTaint(selector.getTaint());
        if(!isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_515703757 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_515703757.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_515703757;
        } //End block
        if(!((interestSet & ~validOps()) == 0))        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_820726949 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_820726949.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_820726949;
        } //End block
        synchronized
(blockingLock)        {
            if(isBlocking)            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_1658070362 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_1658070362.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_1658070362;
            } //End block
            if(!selector.isOpen())            
            {
                if(interestSet == 0)                
                {
                    IllegalSelectorException varA988BB20ADD0DC658BE68F9A5362E806_447696643 = new IllegalSelectorException();
                    varA988BB20ADD0DC658BE68F9A5362E806_447696643.addTaint(taint);
                    throw varA988BB20ADD0DC658BE68F9A5362E806_447696643;
                } //End block
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_38221262 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_38221262.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_38221262;
            } //End block
            SelectionKey key = keyFor(selector);
            if(key == null)            
            {
                key = ((AbstractSelector) selector).register(this, interestSet, attachment);
                keyList.add(key);
            } //End block
            else
            {
                if(!key.isValid())                
                {
                    CancelledKeyException var553A2CCCDE6F10D534FECE0C24924D0C_804728153 = new CancelledKeyException();
                    var553A2CCCDE6F10D534FECE0C24924D0C_804728153.addTaint(taint);
                    throw var553A2CCCDE6F10D534FECE0C24924D0C_804728153;
                } //End block
                key.interestOps(interestSet);
                key.attach(attachment);
            } //End block
SelectionKey var6A95247616A3A8B93CFF7783DABD08D4_1292101784 =             key;
            var6A95247616A3A8B93CFF7783DABD08D4_1292101784.addTaint(taint);
            return var6A95247616A3A8B93CFF7783DABD08D4_1292101784;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.339 -0400", hash_original_method = "924900C80DDDFF3B15A21AACED0AEBE3", hash_generated_method = "73D2EB32BC024D30A937162171C96B24")
    @Override
    synchronized protected final void implCloseChannel() throws IOException {
        implCloseSelectableChannel();
for(SelectionKey key : keyList)
        {
            if(key != null)            
            {
                key.cancel();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //implCloseSelectableChannel();
        //for (SelectionKey key : keyList) {
            //if (key != null) {
                //key.cancel();
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void implCloseSelectableChannel() throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.340 -0400", hash_original_method = "7EB3EC6F0C2C581F383895C93FAEB7C8", hash_generated_method = "3E58774005EA277B9BCBAE4FE68E0322")
    @Override
    public final boolean isBlocking() {
        synchronized
(blockingLock)        {
            boolean varA7062875ADCCB2443088E00053F868E8_1511769431 = (isBlocking);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2119461148 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2119461148;
        } //End block
        // ---------- Original Method ----------
        //synchronized (blockingLock) {
            //return isBlocking;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.340 -0400", hash_original_method = "CF2B6308C435D16AFC21EE86C3F92787", hash_generated_method = "2B49F99CF9851BC3ED1064AA987430E3")
    @Override
    public final Object blockingLock() {
Object var55ED10741B3646C9474CE7499E01CE99_459328493 =         blockingLock;
        var55ED10741B3646C9474CE7499E01CE99_459328493.addTaint(taint);
        return var55ED10741B3646C9474CE7499E01CE99_459328493;
        // ---------- Original Method ----------
        //return blockingLock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.341 -0400", hash_original_method = "C1D21D3B957CE63BA941CEBC7A89647F", hash_generated_method = "D96661E9520B96C2968423C467823A2A")
    @Override
    public final SelectableChannel configureBlocking(boolean blockingMode) throws IOException {
        if(!isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_1922549592 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_1922549592.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_1922549592;
        } //End block
        synchronized
(blockingLock)        {
            if(isBlocking == blockingMode)            
            {
SelectableChannel var72A74007B2BE62B849F475C7BDA4658B_1953035584 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1953035584.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1953035584;
            } //End block
            if(blockingMode && containsValidKeys())            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_566534176 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_566534176.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_566534176;
            } //End block
            implConfigureBlocking(blockingMode);
            isBlocking = blockingMode;
        } //End block
SelectableChannel var72A74007B2BE62B849F475C7BDA4658B_1197868880 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1197868880.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1197868880;
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedChannelException();
        //}
        //synchronized (blockingLock) {
            //if (isBlocking == blockingMode) {
                //return this;
            //}
            //if (blockingMode && containsValidKeys()) {
                //throw new IllegalBlockingModeException();
            //}
            //implConfigureBlocking(blockingMode);
            //isBlocking = blockingMode;
        //}
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void implConfigureBlocking(boolean blocking) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.341 -0400", hash_original_method = "5E0A774ABE1807BF9448EF86554C6BF7", hash_generated_method = "A51AE6DD1CF72C5C8AA20038A863DA90")
    synchronized void deregister(SelectionKey k) {
        addTaint(k.getTaint());
        if(keyList != null)        
        {
            keyList.remove(k);
        } //End block
        // ---------- Original Method ----------
        //if (keyList != null) {
            //keyList.remove(k);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.342 -0400", hash_original_method = "57F0CA9634BB6BE72AE1A3DBAB2B8264", hash_generated_method = "3C597EE140BDF2C10EE17FF36B2399A5")
    private synchronized boolean containsValidKeys() {
for(SelectionKey key : keyList)
        {
            if(key != null && key.isValid())            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1067336470 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1162996869 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1162996869;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_377514851 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1350941413 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1350941413;
        // ---------- Original Method ----------
        //for (SelectionKey key : keyList) {
            //if (key != null && key.isValid()) {
                //return true;
            //}
        //}
        //return false;
    }

    
}

