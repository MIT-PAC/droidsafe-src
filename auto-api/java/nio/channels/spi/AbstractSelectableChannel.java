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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:58.642 -0400", hash_original_method = "C1ED2F1D0A9F053BD27B8788D8E263F6", hash_generated_method = "2356522CF413755BE88D4FDB75566EAA")
    @DSModeled(DSC.SAFE)
    protected AbstractSelectableChannel(SelectorProvider selectorProvider) {
        dsTaint.addTaint(selectorProvider.dsTaint);
        // ---------- Original Method ----------
        //provider = selectorProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:58.648 -0400", hash_original_method = "B098D2E33834ACCBC46AD074E583FD9B", hash_generated_method = "9A37A83850234ADAE67E7E6919973380")
    @DSModeled(DSC.SAFE)
    @Override
    public final SelectorProvider provider() {
        return (SelectorProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:58.655 -0400", hash_original_method = "455A665D6CB2D7E9E28AF0A0296346A0", hash_generated_method = "0BF280F804FB05A7D774DCA854CE0212")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    synchronized public final boolean isRegistered() {
        boolean var2A0AA4A5AD5C173363E5A71D1D62507A_1640351334 = (!keyList.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !keyList.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:58.664 -0400", hash_original_method = "4195F78E36942EF5DA6AFD3959F769A2", hash_generated_method = "F76A5D07673CC45B82E5005F840720EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    synchronized public final SelectionKey keyFor(Selector selector) {
        dsTaint.addTaint(selector.dsTaint);
        {
            Iterator<SelectionKey> seatecAstronomy42 = keyList.iterator();
            seatecAstronomy42.hasNext();
            SelectionKey key = seatecAstronomy42.next();
            {
                {
                    boolean var90AC5A9C726BE7F47DCD01E5BC19F7E7_695115836 = (key != null && key.selector() == selector);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:58.692 -0400", hash_original_method = "CA2D38B16FDF21D8F80456FE85BBCC03", hash_generated_method = "FCCDEE6C155374B9FD47833886AF2303")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final SelectionKey register(Selector selector, int interestSet,
            Object attachment) throws ClosedChannelException {
        dsTaint.addTaint(selector.dsTaint);
        dsTaint.addTaint(interestSet);
        dsTaint.addTaint(attachment.dsTaint);
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1738413062 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC6747048DC9A6C29F5E2D03CB8DD17AC_50614190 = (!((interestSet & ~validOps()) == 0));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
            } //End block
            {
                boolean varB6073B4D1239886C11DC4DA3FD749175_2102496711 = (!selector.isOpen());
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
                    boolean var9F04A2B363242ECBF1ED998B2E98DDB8_1627975921 = (!key.isValid());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:58.716 -0400", hash_original_method = "924900C80DDDFF3B15A21AACED0AEBE3", hash_generated_method = "539C51BF5B02A8DD2A7715FA8DF7C621")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    synchronized protected final void implCloseChannel() throws IOException {
        implCloseSelectableChannel();
        {
            Iterator<SelectionKey> seatecAstronomy42 = keyList.iterator();
            seatecAstronomy42.hasNext();
            SelectionKey key = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:58.724 -0400", hash_original_method = "7EB3EC6F0C2C581F383895C93FAEB7C8", hash_generated_method = "6253280D84D9113A468093FD51AC62D2")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isBlocking() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (blockingLock) {
            //return isBlocking;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:58.729 -0400", hash_original_method = "CF2B6308C435D16AFC21EE86C3F92787", hash_generated_method = "FBEE4E5FAF5EA1B15586247F05033545")
    @DSModeled(DSC.SAFE)
    @Override
    public final Object blockingLock() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return blockingLock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:58.739 -0400", hash_original_method = "C1D21D3B957CE63BA941CEBC7A89647F", hash_generated_method = "701276091CA23597E7CD45E2687115D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final SelectableChannel configureBlocking(boolean blockingMode) throws IOException {
        dsTaint.addTaint(blockingMode);
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1112575997 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varA1EE497A2C565C716AFB7F027C302B60_496218504 = (blockingMode && containsValidKeys());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:58.754 -0400", hash_original_method = "5E0A774ABE1807BF9448EF86554C6BF7", hash_generated_method = "F2997F7BF18F06DD9A623E493281257D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:58.765 -0400", hash_original_method = "57F0CA9634BB6BE72AE1A3DBAB2B8264", hash_generated_method = "95EE8462B3E02112267EC08872280973")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized boolean containsValidKeys() {
        {
            Iterator<SelectionKey> seatecAstronomy42 = keyList.iterator();
            seatecAstronomy42.hasNext();
            SelectionKey key = seatecAstronomy42.next();
            {
                {
                    boolean var38DC38D0794E14EE99B4E06A070E5D5F_453698846 = (key != null && key.isValid());
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


