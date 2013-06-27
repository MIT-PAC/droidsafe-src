package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.613 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0234634A410EB36D3E632222798EC314")

    private SelectorProvider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.613 -0400", hash_original_field = "26C871B41538315A5B97363A6A0B7C0F", hash_generated_field = "3B26D8208E36A3AF954A2D369F214698")

    private List<SelectionKey> keyList = new ArrayList<SelectionKey>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.613 -0400", hash_original_field = "123EFAD404EAB8F3DD3157D8F919C9E8", hash_generated_field = "34718EC08910593D2875527349AF303A")

    private Object blockingLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.613 -0400", hash_original_field = "87D2BB8F426AAF2B023F1238B6188AF2", hash_generated_field = "FBC5E3B60AE9541955B3D463A523710C")

    boolean isBlocking = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.614 -0400", hash_original_method = "C1ED2F1D0A9F053BD27B8788D8E263F6", hash_generated_method = "CDC2687EFBB1875408EB822640372289")
    protected  AbstractSelectableChannel(SelectorProvider selectorProvider) {
        provider = selectorProvider;
        // ---------- Original Method ----------
        //provider = selectorProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.621 -0400", hash_original_method = "B098D2E33834ACCBC46AD074E583FD9B", hash_generated_method = "ADE1DEFBF6082F87E17246490882269C")
    @Override
    public final SelectorProvider provider() {
        SelectorProvider varB4EAC82CA7396A68D541C85D26508E83_126900939 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_126900939 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_126900939.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_126900939;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.622 -0400", hash_original_method = "455A665D6CB2D7E9E28AF0A0296346A0", hash_generated_method = "5DE6AF0B25436B457C31553BD9364B57")
    @Override
    synchronized public final boolean isRegistered() {
        boolean var2A0AA4A5AD5C173363E5A71D1D62507A_2053800950 = (!keyList.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1342593540 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1342593540;
        // ---------- Original Method ----------
        //return !keyList.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.635 -0400", hash_original_method = "4195F78E36942EF5DA6AFD3959F769A2", hash_generated_method = "1535433D32ADB23F4737421E6BA82A8B")
    @Override
    synchronized public final SelectionKey keyFor(Selector selector) {
        SelectionKey varB4EAC82CA7396A68D541C85D26508E83_1080090676 = null; //Variable for return #1
        SelectionKey varB4EAC82CA7396A68D541C85D26508E83_1886789472 = null; //Variable for return #2
        {
            Iterator<SelectionKey> varC1F62F2EA7BD54E755C9918034449484_2055144941 = (keyList).iterator();
            varC1F62F2EA7BD54E755C9918034449484_2055144941.hasNext();
            SelectionKey key = varC1F62F2EA7BD54E755C9918034449484_2055144941.next();
            {
                {
                    boolean var90AC5A9C726BE7F47DCD01E5BC19F7E7_361867899 = (key != null && key.selector() == selector);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1080090676 = key;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1886789472 = null;
        addTaint(selector.getTaint());
        SelectionKey varA7E53CE21691AB073D9660D615818899_1211400624; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1211400624 = varB4EAC82CA7396A68D541C85D26508E83_1080090676;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1211400624 = varB4EAC82CA7396A68D541C85D26508E83_1886789472;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1211400624.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1211400624;
        // ---------- Original Method ----------
        //for (SelectionKey key : keyList) {
            //if (key != null && key.selector() == selector) {
                //return key;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.642 -0400", hash_original_method = "CA2D38B16FDF21D8F80456FE85BBCC03", hash_generated_method = "483D53888D6FDC2C0944F11094636D29")
    @Override
    public final SelectionKey register(Selector selector, int interestSet,
            Object attachment) throws ClosedChannelException {
        SelectionKey varB4EAC82CA7396A68D541C85D26508E83_545481404 = null; //Variable for return #1
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_479718917 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC6747048DC9A6C29F5E2D03CB8DD17AC_1644254618 = (!((interestSet & ~validOps()) == 0));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
            } //End block
            {
                boolean varB6073B4D1239886C11DC4DA3FD749175_14013212 = (!selector.isOpen());
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalSelectorException();
                    } //End block
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                } //End block
            } //End collapsed parenthetic
            SelectionKey key;
            key = keyFor(selector);
            {
                key = ((AbstractSelector) selector).register(this, interestSet, attachment);
                keyList.add(key);
            } //End block
            {
                {
                    boolean var9F04A2B363242ECBF1ED998B2E98DDB8_505733374 = (!key.isValid());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new CancelledKeyException();
                    } //End block
                } //End collapsed parenthetic
                key.interestOps(interestSet);
                key.attach(attachment);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_545481404 = key;
        } //End block
        addTaint(selector.getTaint());
        addTaint(interestSet);
        addTaint(attachment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_545481404.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_545481404;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.670 -0400", hash_original_method = "924900C80DDDFF3B15A21AACED0AEBE3", hash_generated_method = "7BED4EB22ED0889193FD2AF32DBECF24")
    @Override
    synchronized protected final void implCloseChannel() throws IOException {
        implCloseSelectableChannel();
        {
            Iterator<SelectionKey> varC1F62F2EA7BD54E755C9918034449484_1713815659 = (keyList).iterator();
            varC1F62F2EA7BD54E755C9918034449484_1713815659.hasNext();
            SelectionKey key = varC1F62F2EA7BD54E755C9918034449484_1713815659.next();
            {
                {
                    key.cancel();
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //implCloseSelectableChannel();
        //for (SelectionKey key : keyList) {
            //if (key != null) {
                //key.cancel();
            //}
        //}
    }

    
    protected abstract void implCloseSelectableChannel() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.684 -0400", hash_original_method = "7EB3EC6F0C2C581F383895C93FAEB7C8", hash_generated_method = "7030930D077CCA9213A1391BC4CE51AC")
    @Override
    public final boolean isBlocking() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_299461758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_299461758;
        // ---------- Original Method ----------
        //synchronized (blockingLock) {
            //return isBlocking;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.685 -0400", hash_original_method = "CF2B6308C435D16AFC21EE86C3F92787", hash_generated_method = "4AEB20CE2AC8D135AAD2BFAD113AD71D")
    @Override
    public final Object blockingLock() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1791958279 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1791958279 = blockingLock;
        varB4EAC82CA7396A68D541C85D26508E83_1791958279.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1791958279;
        // ---------- Original Method ----------
        //return blockingLock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.686 -0400", hash_original_method = "C1D21D3B957CE63BA941CEBC7A89647F", hash_generated_method = "C8B131EFA1EF2E35A885AA22829041CC")
    @Override
    public final SelectableChannel configureBlocking(boolean blockingMode) throws IOException {
        SelectableChannel varB4EAC82CA7396A68D541C85D26508E83_1618482030 = null; //Variable for return #1
        SelectableChannel varB4EAC82CA7396A68D541C85D26508E83_578155218 = null; //Variable for return #2
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1817844913 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1618482030 = this;
            } //End block
            {
                boolean varA1EE497A2C565C716AFB7F027C302B60_1113913108 = (blockingMode && containsValidKeys());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            implConfigureBlocking(blockingMode);
            isBlocking = blockingMode;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_578155218 = this;
        SelectableChannel varA7E53CE21691AB073D9660D615818899_285539267; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_285539267 = varB4EAC82CA7396A68D541C85D26508E83_1618482030;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_285539267 = varB4EAC82CA7396A68D541C85D26508E83_578155218;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_285539267.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_285539267;
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

    
    protected abstract void implConfigureBlocking(boolean blocking) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.687 -0400", hash_original_method = "5E0A774ABE1807BF9448EF86554C6BF7", hash_generated_method = "3318E43F0A42478F2F33666E30A67376")
    synchronized void deregister(SelectionKey k) {
        {
            keyList.remove(k);
        } //End block
        addTaint(k.getTaint());
        // ---------- Original Method ----------
        //if (keyList != null) {
            //keyList.remove(k);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.708 -0400", hash_original_method = "57F0CA9634BB6BE72AE1A3DBAB2B8264", hash_generated_method = "9B3C23670811AA3ADA88B7C3C62FE37E")
    private synchronized boolean containsValidKeys() {
        {
            Iterator<SelectionKey> varC1F62F2EA7BD54E755C9918034449484_1846022956 = (keyList).iterator();
            varC1F62F2EA7BD54E755C9918034449484_1846022956.hasNext();
            SelectionKey key = varC1F62F2EA7BD54E755C9918034449484_1846022956.next();
            {
                {
                    boolean var38DC38D0794E14EE99B4E06A070E5D5F_1029737582 = (key != null && key.isValid());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1084351332 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1084351332;
        // ---------- Original Method ----------
        //for (SelectionKey key : keyList) {
            //if (key != null && key.isValid()) {
                //return true;
            //}
        //}
        //return false;
    }

    
}

