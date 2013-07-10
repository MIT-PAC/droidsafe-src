package java.nio.channels.spi;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.748 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0234634A410EB36D3E632222798EC314")

    private SelectorProvider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.748 -0400", hash_original_field = "26C871B41538315A5B97363A6A0B7C0F", hash_generated_field = "3B26D8208E36A3AF954A2D369F214698")

    private List<SelectionKey> keyList = new ArrayList<SelectionKey>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.748 -0400", hash_original_field = "123EFAD404EAB8F3DD3157D8F919C9E8", hash_generated_field = "9DDF47310598FEE3BE8DF77A18102341")

    private final Object blockingLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.748 -0400", hash_original_field = "87D2BB8F426AAF2B023F1238B6188AF2", hash_generated_field = "FBC5E3B60AE9541955B3D463A523710C")

    boolean isBlocking = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.749 -0400", hash_original_method = "C1ED2F1D0A9F053BD27B8788D8E263F6", hash_generated_method = "CDC2687EFBB1875408EB822640372289")
    protected  AbstractSelectableChannel(SelectorProvider selectorProvider) {
        provider = selectorProvider;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.750 -0400", hash_original_method = "B098D2E33834ACCBC46AD074E583FD9B", hash_generated_method = "BAFC17F02B80EDA34FC72C0FB23B666B")
    @Override
    public final SelectorProvider provider() {
        SelectorProvider varB4EAC82CA7396A68D541C85D26508E83_1189689117 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1189689117 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_1189689117.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1189689117;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.750 -0400", hash_original_method = "455A665D6CB2D7E9E28AF0A0296346A0", hash_generated_method = "ED379FD4C18D3E6482E73E488174FB26")
    @Override
    synchronized public final boolean isRegistered() {
        boolean var2A0AA4A5AD5C173363E5A71D1D62507A_1170918359 = (!keyList.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1082900439 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1082900439;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.754 -0400", hash_original_method = "4195F78E36942EF5DA6AFD3959F769A2", hash_generated_method = "54051BBF28A351F5328B62009BC640A7")
    @Override
    synchronized public final SelectionKey keyFor(Selector selector) {
        SelectionKey varB4EAC82CA7396A68D541C85D26508E83_1254613241 = null; 
        SelectionKey varB4EAC82CA7396A68D541C85D26508E83_769513310 = null; 
        {
            Iterator<SelectionKey> varC1F62F2EA7BD54E755C9918034449484_2053837028 = (keyList).iterator();
            varC1F62F2EA7BD54E755C9918034449484_2053837028.hasNext();
            SelectionKey key = varC1F62F2EA7BD54E755C9918034449484_2053837028.next();
            {
                {
                    boolean var90AC5A9C726BE7F47DCD01E5BC19F7E7_1115672977 = (key != null && key.selector() == selector);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1254613241 = key;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_769513310 = null;
        addTaint(selector.getTaint());
        SelectionKey varA7E53CE21691AB073D9660D615818899_467793550; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_467793550 = varB4EAC82CA7396A68D541C85D26508E83_1254613241;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_467793550 = varB4EAC82CA7396A68D541C85D26508E83_769513310;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_467793550.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_467793550;
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.755 -0400", hash_original_method = "CA2D38B16FDF21D8F80456FE85BBCC03", hash_generated_method = "B8FB15A873D4CEA131D715FFB021F134")
    @Override
    public final SelectionKey register(Selector selector, int interestSet,
            Object attachment) throws ClosedChannelException {
        SelectionKey varB4EAC82CA7396A68D541C85D26508E83_1489865591 = null; 
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1584493519 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } 
        } 
        {
            boolean varC6747048DC9A6C29F5E2D03CB8DD17AC_294242251 = (!((interestSet & ~validOps()) == 0));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
        } 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
            } 
            {
                boolean varB6073B4D1239886C11DC4DA3FD749175_2129458686 = (!selector.isOpen());
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalSelectorException();
                    } 
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                } 
            } 
            SelectionKey key = keyFor(selector);
            {
                key = ((AbstractSelector) selector).register(this, interestSet, attachment);
                keyList.add(key);
            } 
            {
                {
                    boolean var9F04A2B363242ECBF1ED998B2E98DDB8_2090082064 = (!key.isValid());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new CancelledKeyException();
                    } 
                } 
                key.interestOps(interestSet);
                key.attach(attachment);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1489865591 = key;
        } 
        addTaint(selector.getTaint());
        addTaint(interestSet);
        addTaint(attachment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1489865591.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1489865591;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.760 -0400", hash_original_method = "924900C80DDDFF3B15A21AACED0AEBE3", hash_generated_method = "A63E07CA00CFAFF644EB19AB8B9EDCBE")
    @Override
    synchronized protected final void implCloseChannel() throws IOException {
        implCloseSelectableChannel();
        {
            Iterator<SelectionKey> varC1F62F2EA7BD54E755C9918034449484_1626825715 = (keyList).iterator();
            varC1F62F2EA7BD54E755C9918034449484_1626825715.hasNext();
            SelectionKey key = varC1F62F2EA7BD54E755C9918034449484_1626825715.next();
            {
                {
                    key.cancel();
                } 
            } 
        } 
        
        
        
            
                
            
        
    }

    
    protected abstract void implCloseSelectableChannel() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.763 -0400", hash_original_method = "7EB3EC6F0C2C581F383895C93FAEB7C8", hash_generated_method = "27E1F3C517A96483650209DCD9780477")
    @Override
    public final boolean isBlocking() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1519101528 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1519101528;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.764 -0400", hash_original_method = "CF2B6308C435D16AFC21EE86C3F92787", hash_generated_method = "1E257070049614C1623D2F5FA6C1D934")
    @Override
    public final Object blockingLock() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1029213958 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1029213958 = blockingLock;
        varB4EAC82CA7396A68D541C85D26508E83_1029213958.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1029213958;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.766 -0400", hash_original_method = "C1D21D3B957CE63BA941CEBC7A89647F", hash_generated_method = "194E68F9493D0080970AA871E486CC95")
    @Override
    public final SelectableChannel configureBlocking(boolean blockingMode) throws IOException {
        SelectableChannel varB4EAC82CA7396A68D541C85D26508E83_1693222019 = null; 
        SelectableChannel varB4EAC82CA7396A68D541C85D26508E83_796018932 = null; 
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_737481371 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } 
        } 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1693222019 = this;
            } 
            {
                boolean varA1EE497A2C565C716AFB7F027C302B60_1551701461 = (blockingMode && containsValidKeys());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } 
            } 
            implConfigureBlocking(blockingMode);
            isBlocking = blockingMode;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_796018932 = this;
        SelectableChannel varA7E53CE21691AB073D9660D615818899_1594777451; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1594777451 = varB4EAC82CA7396A68D541C85D26508E83_1693222019;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1594777451 = varB4EAC82CA7396A68D541C85D26508E83_796018932;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1594777451.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1594777451;
        
        
            
        
        
            
                
            
            
                
            
            
            
        
        
    }

    
    protected abstract void implConfigureBlocking(boolean blocking) throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.766 -0400", hash_original_method = "5E0A774ABE1807BF9448EF86554C6BF7", hash_generated_method = "3318E43F0A42478F2F33666E30A67376")
    synchronized void deregister(SelectionKey k) {
        {
            keyList.remove(k);
        } 
        addTaint(k.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.769 -0400", hash_original_method = "57F0CA9634BB6BE72AE1A3DBAB2B8264", hash_generated_method = "40FEE35CE30D21616125D41AE2F07769")
    private synchronized boolean containsValidKeys() {
        {
            Iterator<SelectionKey> varC1F62F2EA7BD54E755C9918034449484_575063761 = (keyList).iterator();
            varC1F62F2EA7BD54E755C9918034449484_575063761.hasNext();
            SelectionKey key = varC1F62F2EA7BD54E755C9918034449484_575063761.next();
            {
                {
                    boolean var38DC38D0794E14EE99B4E06A070E5D5F_616911530 = (key != null && key.isValid());
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682927 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_682927;
        
        
            
                
            
        
        
    }

    
}

