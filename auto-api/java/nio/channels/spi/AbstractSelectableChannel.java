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
    private SelectorProvider provider;
    private List<SelectionKey> keyList = new ArrayList<SelectionKey>();
    private Object blockingLock = new Object();
    boolean isBlocking = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.152 -0400", hash_original_method = "C1ED2F1D0A9F053BD27B8788D8E263F6", hash_generated_method = "F5912ADA0BDDA087901EBA53038291EE")
    @DSModeled(DSC.SAFE)
    protected AbstractSelectableChannel(SelectorProvider selectorProvider) {
        dsTaint.addTaint(selectorProvider.dsTaint);
        // ---------- Original Method ----------
        //provider = selectorProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.153 -0400", hash_original_method = "B098D2E33834ACCBC46AD074E583FD9B", hash_generated_method = "EE813F03495FAF53CE2281AF0BF98745")
    @DSModeled(DSC.SAFE)
    @Override
    public final SelectorProvider provider() {
        return (SelectorProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.153 -0400", hash_original_method = "455A665D6CB2D7E9E28AF0A0296346A0", hash_generated_method = "58BF7022C0CF9C4D2AD314D89A0939BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    synchronized public final boolean isRegistered() {
        boolean var2A0AA4A5AD5C173363E5A71D1D62507A_1666819599 = (!keyList.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !keyList.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.155 -0400", hash_original_method = "4195F78E36942EF5DA6AFD3959F769A2", hash_generated_method = "C26449A029025BF388207CEDE259C87E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    synchronized public final SelectionKey keyFor(Selector selector) {
        dsTaint.addTaint(selector.dsTaint);
        {
            Iterator<SelectionKey> varC1F62F2EA7BD54E755C9918034449484_1455255990 = (keyList).iterator();
            varC1F62F2EA7BD54E755C9918034449484_1455255990.hasNext();
            SelectionKey key = varC1F62F2EA7BD54E755C9918034449484_1455255990.next();
            {
                {
                    boolean var90AC5A9C726BE7F47DCD01E5BC19F7E7_82292259 = (key != null && key.selector() == selector);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (SelectionKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        //for (SelectionKey key : keyList) {
            //if (key != null && key.selector() == selector) {
                //return key;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.156 -0400", hash_original_method = "CA2D38B16FDF21D8F80456FE85BBCC03", hash_generated_method = "2E70E106052D3715679EFB427BF1F15C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final SelectionKey register(Selector selector, int interestSet,
            Object attachment) throws ClosedChannelException {
        dsTaint.addTaint(selector.dsTaint);
        dsTaint.addTaint(interestSet);
        dsTaint.addTaint(attachment.dsTaint);
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1117485662 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC6747048DC9A6C29F5E2D03CB8DD17AC_1190212480 = (!((interestSet & ~validOps()) == 0));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
            } //End block
            {
                boolean varB6073B4D1239886C11DC4DA3FD749175_1107037505 = (!selector.isOpen());
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
                    boolean var9F04A2B363242ECBF1ED998B2E98DDB8_1720163044 = (!key.isValid());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new CancelledKeyException();
                    } //End block
                } //End collapsed parenthetic
                key.interestOps(interestSet);
                key.attach(attachment);
            } //End block
        } //End block
        return (SelectionKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.158 -0400", hash_original_method = "924900C80DDDFF3B15A21AACED0AEBE3", hash_generated_method = "2EAF9907D9997971E8516CEF36C3B101")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    synchronized protected final void implCloseChannel() throws IOException {
        implCloseSelectableChannel();
        {
            Iterator<SelectionKey> varC1F62F2EA7BD54E755C9918034449484_1274698765 = (keyList).iterator();
            varC1F62F2EA7BD54E755C9918034449484_1274698765.hasNext();
            SelectionKey key = varC1F62F2EA7BD54E755C9918034449484_1274698765.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.159 -0400", hash_original_method = "7EB3EC6F0C2C581F383895C93FAEB7C8", hash_generated_method = "37535F1370E79A15842CAD122AB2E12D")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isBlocking() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (blockingLock) {
            //return isBlocking;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.159 -0400", hash_original_method = "CF2B6308C435D16AFC21EE86C3F92787", hash_generated_method = "8357721D5FCE7C1B2B46B4E35E67289A")
    @DSModeled(DSC.SAFE)
    @Override
    public final Object blockingLock() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return blockingLock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.159 -0400", hash_original_method = "C1D21D3B957CE63BA941CEBC7A89647F", hash_generated_method = "7C3BB640C4C4E19CA68C27579D6CC3FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final SelectableChannel configureBlocking(boolean blockingMode) throws IOException {
        dsTaint.addTaint(blockingMode);
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_2044713344 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varA1EE497A2C565C716AFB7F027C302B60_1597592036 = (blockingMode && containsValidKeys());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            implConfigureBlocking(blockingMode);
        } //End block
        return (SelectableChannel)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.160 -0400", hash_original_method = "5E0A774ABE1807BF9448EF86554C6BF7", hash_generated_method = "BACD31E8750C9F920618F18753BECAF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void deregister(SelectionKey k) {
        dsTaint.addTaint(k.dsTaint);
        {
            keyList.remove(k);
        } //End block
        // ---------- Original Method ----------
        //if (keyList != null) {
            //keyList.remove(k);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.163 -0400", hash_original_method = "57F0CA9634BB6BE72AE1A3DBAB2B8264", hash_generated_method = "692D82361D7BA76308CD585A1C067480")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized boolean containsValidKeys() {
        {
            Iterator<SelectionKey> varC1F62F2EA7BD54E755C9918034449484_965073127 = (keyList).iterator();
            varC1F62F2EA7BD54E755C9918034449484_965073127.hasNext();
            SelectionKey key = varC1F62F2EA7BD54E755C9918034449484_965073127.next();
            {
                {
                    boolean var38DC38D0794E14EE99B4E06A070E5D5F_664665257 = (key != null && key.isValid());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //for (SelectionKey key : keyList) {
            //if (key != null && key.isValid()) {
                //return true;
            //}
        //}
        //return false;
    }

    
}

