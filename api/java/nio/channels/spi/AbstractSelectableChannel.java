package java.nio.channels.spi;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.695 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0234634A410EB36D3E632222798EC314")

    private SelectorProvider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.695 -0400", hash_original_field = "26C871B41538315A5B97363A6A0B7C0F", hash_generated_field = "3B26D8208E36A3AF954A2D369F214698")

    private List<SelectionKey> keyList = new ArrayList<SelectionKey>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.695 -0400", hash_original_field = "123EFAD404EAB8F3DD3157D8F919C9E8", hash_generated_field = "9DDF47310598FEE3BE8DF77A18102341")

    private final Object blockingLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.695 -0400", hash_original_field = "87D2BB8F426AAF2B023F1238B6188AF2", hash_generated_field = "FBC5E3B60AE9541955B3D463A523710C")

    boolean isBlocking = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.695 -0400", hash_original_method = "C1ED2F1D0A9F053BD27B8788D8E263F6", hash_generated_method = "CDC2687EFBB1875408EB822640372289")
    protected  AbstractSelectableChannel(SelectorProvider selectorProvider) {
        provider = selectorProvider;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.696 -0400", hash_original_method = "B098D2E33834ACCBC46AD074E583FD9B", hash_generated_method = "AE0C7357094BFB8963B3D56A0609844F")
    @Override
    public final SelectorProvider provider() {
SelectorProvider varC1EB7B12CCABB27D431E5B91E5FF9ECB_391910708 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_391910708.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_391910708;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.696 -0400", hash_original_method = "455A665D6CB2D7E9E28AF0A0296346A0", hash_generated_method = "940471077021123C40040256623B4170")
    @Override
    synchronized public final boolean isRegistered() {
        boolean varB374C57CC5C93FDCD7C83C0F8B703F45_1468813688 = (!keyList.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666910776 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666910776;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.696 -0400", hash_original_method = "4195F78E36942EF5DA6AFD3959F769A2", hash_generated_method = "0C99CC2CB36F64355C41ED0D554B32B2")
    @Override
    synchronized public final SelectionKey keyFor(Selector selector) {
        addTaint(selector.getTaint());
for(SelectionKey key : keyList)
        {
    if(key != null && key.selector() == selector)            
            {
SelectionKey var6A95247616A3A8B93CFF7783DABD08D4_374377409 =                 key;
                var6A95247616A3A8B93CFF7783DABD08D4_374377409.addTaint(taint);
                return var6A95247616A3A8B93CFF7783DABD08D4_374377409;
            } 
        } 
SelectionKey var540C13E9E156B687226421B24F2DF178_1343860324 =         null;
        var540C13E9E156B687226421B24F2DF178_1343860324.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1343860324;
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.697 -0400", hash_original_method = "CA2D38B16FDF21D8F80456FE85BBCC03", hash_generated_method = "4A828133F125DA02F1C33966E25176BC")
    @Override
    public final SelectionKey register(Selector selector, int interestSet,
            Object attachment) throws ClosedChannelException {
        addTaint(attachment.getTaint());
        addTaint(interestSet);
        addTaint(selector.getTaint());
    if(!isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_1554049330 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_1554049330.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_1554049330;
        } 
    if(!((interestSet & ~validOps()) == 0))        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_144404576 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_144404576.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_144404576;
        } 
        synchronized
(blockingLock)        {
    if(isBlocking)            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_8559436 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_8559436.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_8559436;
            } 
    if(!selector.isOpen())            
            {
    if(interestSet == 0)                
                {
                    IllegalSelectorException varA988BB20ADD0DC658BE68F9A5362E806_1324017280 = new IllegalSelectorException();
                    varA988BB20ADD0DC658BE68F9A5362E806_1324017280.addTaint(taint);
                    throw varA988BB20ADD0DC658BE68F9A5362E806_1324017280;
                } 
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_421307477 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_421307477.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_421307477;
            } 
            SelectionKey key = keyFor(selector);
    if(key == null)            
            {
                key = ((AbstractSelector) selector).register(this, interestSet, attachment);
                keyList.add(key);
            } 
            else
            {
    if(!key.isValid())                
                {
                    CancelledKeyException var553A2CCCDE6F10D534FECE0C24924D0C_1340541763 = new CancelledKeyException();
                    var553A2CCCDE6F10D534FECE0C24924D0C_1340541763.addTaint(taint);
                    throw var553A2CCCDE6F10D534FECE0C24924D0C_1340541763;
                } 
                key.interestOps(interestSet);
                key.attach(attachment);
            } 
SelectionKey var6A95247616A3A8B93CFF7783DABD08D4_631002894 =             key;
            var6A95247616A3A8B93CFF7783DABD08D4_631002894.addTaint(taint);
            return var6A95247616A3A8B93CFF7783DABD08D4_631002894;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.698 -0400", hash_original_method = "924900C80DDDFF3B15A21AACED0AEBE3", hash_generated_method = "73D2EB32BC024D30A937162171C96B24")
    @Override
    synchronized protected final void implCloseChannel() throws IOException {
        implCloseSelectableChannel();
for(SelectionKey key : keyList)
        {
    if(key != null)            
            {
                key.cancel();
            } 
        } 
        
        
        
            
                
            
        
    }

    
    protected abstract void implCloseSelectableChannel() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.699 -0400", hash_original_method = "7EB3EC6F0C2C581F383895C93FAEB7C8", hash_generated_method = "BA20A2BE27BFF3C69AA5A5EDE6DF681B")
    @Override
    public final boolean isBlocking() {
        synchronized
(blockingLock)        {
            boolean varA7062875ADCCB2443088E00053F868E8_1191749633 = (isBlocking);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1663047696 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1663047696;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.699 -0400", hash_original_method = "CF2B6308C435D16AFC21EE86C3F92787", hash_generated_method = "198FB616A108938883B3AEA298BACCF1")
    @Override
    public final Object blockingLock() {
Object var55ED10741B3646C9474CE7499E01CE99_24435609 =         blockingLock;
        var55ED10741B3646C9474CE7499E01CE99_24435609.addTaint(taint);
        return var55ED10741B3646C9474CE7499E01CE99_24435609;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.700 -0400", hash_original_method = "C1D21D3B957CE63BA941CEBC7A89647F", hash_generated_method = "841C5D4F70B08C7E36042FFBC37DA1D4")
    @Override
    public final SelectableChannel configureBlocking(boolean blockingMode) throws IOException {
    if(!isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_1276726560 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_1276726560.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_1276726560;
        } 
        synchronized
(blockingLock)        {
    if(isBlocking == blockingMode)            
            {
SelectableChannel var72A74007B2BE62B849F475C7BDA4658B_1727692215 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1727692215.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1727692215;
            } 
    if(blockingMode && containsValidKeys())            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_1502731484 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_1502731484.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_1502731484;
            } 
            implConfigureBlocking(blockingMode);
            isBlocking = blockingMode;
        } 
SelectableChannel var72A74007B2BE62B849F475C7BDA4658B_912805683 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_912805683.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_912805683;
        
        
            
        
        
            
                
            
            
                
            
            
            
        
        
    }

    
    protected abstract void implConfigureBlocking(boolean blocking) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.700 -0400", hash_original_method = "5E0A774ABE1807BF9448EF86554C6BF7", hash_generated_method = "A51AE6DD1CF72C5C8AA20038A863DA90")
    synchronized void deregister(SelectionKey k) {
        addTaint(k.getTaint());
    if(keyList != null)        
        {
            keyList.remove(k);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.701 -0400", hash_original_method = "57F0CA9634BB6BE72AE1A3DBAB2B8264", hash_generated_method = "3482D7931CF6EF32CE29AEC77D46278C")
    private synchronized boolean containsValidKeys() {
for(SelectionKey key : keyList)
        {
    if(key != null && key.isValid())            
            {
                boolean varB326B5062B2F0E69046810717534CB09_224108011 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_876144900 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_876144900;
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_395595891 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_608270704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_608270704;
        
        
            
                
            
        
        
    }

    
}

