package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Rect;
import android.graphics.Region;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public final class ViewTreeObserver {
    private CopyOnWriteArrayList<OnGlobalFocusChangeListener> mOnGlobalFocusListeners;
    private CopyOnWriteArrayList<OnGlobalLayoutListener> mOnGlobalLayoutListeners;
    private CopyOnWriteArrayList<OnTouchModeChangeListener> mOnTouchModeChangeListeners;
    private CopyOnWriteArrayList<OnComputeInternalInsetsListener> mOnComputeInternalInsetsListeners;
    private CopyOnWriteArrayList<OnScrollChangedListener> mOnScrollChangedListeners;
    private ArrayList<OnPreDrawListener> mOnPreDrawListeners;
    private boolean mAlive = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.587 -0400", hash_original_method = "CC9985AE6D7058390B2C51E91CCE49A3", hash_generated_method = "5739F6075FCB84039D6115D26517DF4C")
    @DSModeled(DSC.SAFE)
     ViewTreeObserver() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.587 -0400", hash_original_method = "FB8092EEF2FD22B43D0D69D64D0387FF", hash_generated_method = "A5384D346246EADEB2A23C96D2C6562E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void merge(ViewTreeObserver observer) {
        dsTaint.addTaint(observer.dsTaint);
        {
            {
                mOnGlobalFocusListeners.addAll(observer.mOnGlobalFocusListeners);
            } //End block
            {
                mOnGlobalFocusListeners = observer.mOnGlobalFocusListeners;
            } //End block
        } //End block
        {
            {
                mOnGlobalLayoutListeners.addAll(observer.mOnGlobalLayoutListeners);
            } //End block
            {
                mOnGlobalLayoutListeners = observer.mOnGlobalLayoutListeners;
            } //End block
        } //End block
        {
            {
                mOnPreDrawListeners.addAll(observer.mOnPreDrawListeners);
            } //End block
            {
                mOnPreDrawListeners = observer.mOnPreDrawListeners;
            } //End block
        } //End block
        {
            {
                mOnTouchModeChangeListeners.addAll(observer.mOnTouchModeChangeListeners);
            } //End block
            {
                mOnTouchModeChangeListeners = observer.mOnTouchModeChangeListeners;
            } //End block
        } //End block
        {
            {
                mOnComputeInternalInsetsListeners.addAll(observer.mOnComputeInternalInsetsListeners);
            } //End block
            {
                mOnComputeInternalInsetsListeners = observer.mOnComputeInternalInsetsListeners;
            } //End block
        } //End block
        observer.kill();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.587 -0400", hash_original_method = "A6A84348B82F6717F3C52BBBB15E789E", hash_generated_method = "CF24266696334393F6CCEE1AE15964CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addOnGlobalFocusChangeListener(OnGlobalFocusChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        checkIsAlive();
        {
            mOnGlobalFocusListeners = new CopyOnWriteArrayList<OnGlobalFocusChangeListener>();
        } //End block
        mOnGlobalFocusListeners.add(listener);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnGlobalFocusListeners == null) {
            //mOnGlobalFocusListeners = new CopyOnWriteArrayList<OnGlobalFocusChangeListener>();
        //}
        //mOnGlobalFocusListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.588 -0400", hash_original_method = "96877EDD4D0178D607F096D2B02117DA", hash_generated_method = "C8CDA8E34C17F3B629DE179A1557BC4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeOnGlobalFocusChangeListener(OnGlobalFocusChangeListener victim) {
        dsTaint.addTaint(victim.dsTaint);
        checkIsAlive();
        mOnGlobalFocusListeners.remove(victim);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnGlobalFocusListeners == null) {
            //return;
        //}
        //mOnGlobalFocusListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.588 -0400", hash_original_method = "14BEFF226C3B053CD01922ACD8EBA6F7", hash_generated_method = "532E499131EE5A2D8A347A4E31501458")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addOnGlobalLayoutListener(OnGlobalLayoutListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        checkIsAlive();
        {
            mOnGlobalLayoutListeners = new CopyOnWriteArrayList<OnGlobalLayoutListener>();
        } //End block
        mOnGlobalLayoutListeners.add(listener);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnGlobalLayoutListeners == null) {
            //mOnGlobalLayoutListeners = new CopyOnWriteArrayList<OnGlobalLayoutListener>();
        //}
        //mOnGlobalLayoutListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.588 -0400", hash_original_method = "539A16F59B949D9890B1866DB4369A8D", hash_generated_method = "4EF8F83840F3934156B4D19941BCF229")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeGlobalOnLayoutListener(OnGlobalLayoutListener victim) {
        dsTaint.addTaint(victim.dsTaint);
        checkIsAlive();
        mOnGlobalLayoutListeners.remove(victim);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnGlobalLayoutListeners == null) {
            //return;
        //}
        //mOnGlobalLayoutListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.588 -0400", hash_original_method = "920335313557C11873B99900CD6A6F78", hash_generated_method = "CCE936350360444644D760E1248440CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addOnPreDrawListener(OnPreDrawListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        checkIsAlive();
        {
            mOnPreDrawListeners = new ArrayList<OnPreDrawListener>();
        } //End block
        mOnPreDrawListeners.add(listener);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnPreDrawListeners == null) {
            //mOnPreDrawListeners = new ArrayList<OnPreDrawListener>();
        //}
        //mOnPreDrawListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.588 -0400", hash_original_method = "D174E8E7C134C5C8B17339E89BF31A77", hash_generated_method = "29E1E0CE134046F91210E46CB7F9C058")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeOnPreDrawListener(OnPreDrawListener victim) {
        dsTaint.addTaint(victim.dsTaint);
        checkIsAlive();
        mOnPreDrawListeners.remove(victim);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnPreDrawListeners == null) {
            //return;
        //}
        //mOnPreDrawListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.589 -0400", hash_original_method = "CACC041FFA65A020B6AC1A976C2F46C3", hash_generated_method = "E11258D5222719563FC20D61C3D4A4EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addOnScrollChangedListener(OnScrollChangedListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        checkIsAlive();
        {
            mOnScrollChangedListeners = new CopyOnWriteArrayList<OnScrollChangedListener>();
        } //End block
        mOnScrollChangedListeners.add(listener);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnScrollChangedListeners == null) {
            //mOnScrollChangedListeners = new CopyOnWriteArrayList<OnScrollChangedListener>();
        //}
        //mOnScrollChangedListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.589 -0400", hash_original_method = "6198A3897D62B61D814225738CA4D351", hash_generated_method = "DA365BDEF7735921ABD65F7FB8C2ED66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeOnScrollChangedListener(OnScrollChangedListener victim) {
        dsTaint.addTaint(victim.dsTaint);
        checkIsAlive();
        mOnScrollChangedListeners.remove(victim);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnScrollChangedListeners == null) {
            //return;
        //}
        //mOnScrollChangedListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.589 -0400", hash_original_method = "B309A69A91E26B4D51118B3E70AE0659", hash_generated_method = "D209221870A8C1D9EE49726BADA1BE0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addOnTouchModeChangeListener(OnTouchModeChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        checkIsAlive();
        {
            mOnTouchModeChangeListeners = new CopyOnWriteArrayList<OnTouchModeChangeListener>();
        } //End block
        mOnTouchModeChangeListeners.add(listener);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnTouchModeChangeListeners == null) {
            //mOnTouchModeChangeListeners = new CopyOnWriteArrayList<OnTouchModeChangeListener>();
        //}
        //mOnTouchModeChangeListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.589 -0400", hash_original_method = "6CC5D76BF64E678A17AA54A0B0DC5C75", hash_generated_method = "33BB5A4C9F230B3B6E99AE8803DE10A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeOnTouchModeChangeListener(OnTouchModeChangeListener victim) {
        dsTaint.addTaint(victim.dsTaint);
        checkIsAlive();
        mOnTouchModeChangeListeners.remove(victim);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnTouchModeChangeListeners == null) {
            //return;
        //}
        //mOnTouchModeChangeListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.590 -0400", hash_original_method = "D493AB47B92C8586FE24EDC32C42D722", hash_generated_method = "CB078AEC37E30EC1E029E93080D58039")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addOnComputeInternalInsetsListener(OnComputeInternalInsetsListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        checkIsAlive();
        {
            mOnComputeInternalInsetsListeners =
                    new CopyOnWriteArrayList<OnComputeInternalInsetsListener>();
        } //End block
        mOnComputeInternalInsetsListeners.add(listener);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnComputeInternalInsetsListeners == null) {
            //mOnComputeInternalInsetsListeners =
                    //new CopyOnWriteArrayList<OnComputeInternalInsetsListener>();
        //}
        //mOnComputeInternalInsetsListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.590 -0400", hash_original_method = "C4CB9160F62AB89C28812971D6DA3A2B", hash_generated_method = "DCD95C839BE98BE7B78E4B583D7B0090")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeOnComputeInternalInsetsListener(OnComputeInternalInsetsListener victim) {
        dsTaint.addTaint(victim.dsTaint);
        checkIsAlive();
        mOnComputeInternalInsetsListeners.remove(victim);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnComputeInternalInsetsListeners == null) {
            //return;
        //}
        //mOnComputeInternalInsetsListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.590 -0400", hash_original_method = "09DE926E739DABD1095FDB2AAECCB187", hash_generated_method = "500A0F254BC3B579493EB41B061876F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkIsAlive() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("This ViewTreeObserver is not alive, call "
                    + "getViewTreeObserver() again");
        } //End block
        // ---------- Original Method ----------
        //if (!mAlive) {
            //throw new IllegalStateException("This ViewTreeObserver is not alive, call "
                    //+ "getViewTreeObserver() again");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.590 -0400", hash_original_method = "8E102E0046F857D94D6EB92859BCA09E", hash_generated_method = "FF46751CDE339EF28A769721F4ECBC1F")
    @DSModeled(DSC.SAFE)
    public boolean isAlive() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAlive;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.590 -0400", hash_original_method = "CE15D88AAF79A195F4E8949632256817", hash_generated_method = "ADAC88CFF01E50F749BE8EE5F2A18844")
    @DSModeled(DSC.SAFE)
    private void kill() {
        mAlive = false;
        // ---------- Original Method ----------
        //mAlive = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.595 -0400", hash_original_method = "811076DC02481277282C8AE588FEF9F4", hash_generated_method = "A4D15C1ECE7EA3404CF6C3ABA52B2422")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void dispatchOnGlobalFocusChange(View oldFocus, View newFocus) {
        dsTaint.addTaint(oldFocus.dsTaint);
        dsTaint.addTaint(newFocus.dsTaint);
        CopyOnWriteArrayList<OnGlobalFocusChangeListener> listeners;
        listeners = mOnGlobalFocusListeners;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_683133143 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnGlobalFocusChangeListener> var7A98234764E956E91DA8A394AFDB6376_244150346 = (listeners).iterator();
                    var7A98234764E956E91DA8A394AFDB6376_244150346.hasNext();
                    OnGlobalFocusChangeListener listener = var7A98234764E956E91DA8A394AFDB6376_244150346.next();
                    {
                        listener.onGlobalFocusChanged(oldFocus, newFocus);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final CopyOnWriteArrayList<OnGlobalFocusChangeListener> listeners = mOnGlobalFocusListeners;
        //if (listeners != null && listeners.size() > 0) {
            //for (OnGlobalFocusChangeListener listener : listeners) {
                //listener.onGlobalFocusChanged(oldFocus, newFocus);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.599 -0400", hash_original_method = "500AF4B5F4AA363828C439EF6D5AF0CA", hash_generated_method = "4AD4CAA3ACF6F2746E095BD9469EC888")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void dispatchOnGlobalLayout() {
        CopyOnWriteArrayList<OnGlobalLayoutListener> listeners;
        listeners = mOnGlobalLayoutListeners;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_1701546741 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnGlobalLayoutListener> var02C1B6C27E93AF1BF997E51F917D95E9_1710483508 = (listeners).iterator();
                    var02C1B6C27E93AF1BF997E51F917D95E9_1710483508.hasNext();
                    OnGlobalLayoutListener listener = var02C1B6C27E93AF1BF997E51F917D95E9_1710483508.next();
                    {
                        listener.onGlobalLayout();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final CopyOnWriteArrayList<OnGlobalLayoutListener> listeners = mOnGlobalLayoutListeners;
        //if (listeners != null && listeners.size() > 0) {
            //for (OnGlobalLayoutListener listener : listeners) {
                //listener.onGlobalLayout();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.600 -0400", hash_original_method = "81257F2850CF1393D415233A83FF9A37", hash_generated_method = "BB96C7B1DC75E0C9880CEA80BB06C957")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean dispatchOnPreDraw() {
        boolean cancelDraw;
        cancelDraw = false;
        {
            boolean var2391D555EE6834B061EF560800F34961_1209674443 = (mOnPreDrawListeners != null && mOnPreDrawListeners.size() > 0);
            {
                ArrayList<OnPreDrawListener> listeners;
                listeners = (ArrayList<OnPreDrawListener>) mOnPreDrawListeners.clone();
                int numListeners;
                numListeners = listeners.size();
                {
                    int i;
                    i = 0;
                    {
                        cancelDraw |= !(listeners.get(i).onPreDraw());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean cancelDraw = false;
        //if (mOnPreDrawListeners != null && mOnPreDrawListeners.size() > 0) {
            //final ArrayList<OnPreDrawListener> listeners =
                    //(ArrayList<OnPreDrawListener>) mOnPreDrawListeners.clone();
            //int numListeners = listeners.size();
            //for (int i = 0; i < numListeners; ++i) {
                //cancelDraw |= !(listeners.get(i).onPreDraw());
            //}
        //}
        //return cancelDraw;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.603 -0400", hash_original_method = "21795A7BDDB42F1334F3A5AC55A2B47D", hash_generated_method = "E0E0D094A5891C1145CD121F141D45CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void dispatchOnTouchModeChanged(boolean inTouchMode) {
        dsTaint.addTaint(inTouchMode);
        CopyOnWriteArrayList<OnTouchModeChangeListener> listeners;
        listeners = mOnTouchModeChangeListeners;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_176066117 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnTouchModeChangeListener> var5BDB6DB73C97A7AE707FC5DFEF30A014_556872575 = (listeners).iterator();
                    var5BDB6DB73C97A7AE707FC5DFEF30A014_556872575.hasNext();
                    OnTouchModeChangeListener listener = var5BDB6DB73C97A7AE707FC5DFEF30A014_556872575.next();
                    {
                        listener.onTouchModeChanged(inTouchMode);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final CopyOnWriteArrayList<OnTouchModeChangeListener> listeners =
                //mOnTouchModeChangeListeners;
        //if (listeners != null && listeners.size() > 0) {
            //for (OnTouchModeChangeListener listener : listeners) {
                //listener.onTouchModeChanged(inTouchMode);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.606 -0400", hash_original_method = "B2875E16B1AB55A20CB42509779AE060", hash_generated_method = "E8AD66BBB43E49E2E995E11201DA6959")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void dispatchOnScrollChanged() {
        CopyOnWriteArrayList<OnScrollChangedListener> listeners;
        listeners = mOnScrollChangedListeners;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_1663921808 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnScrollChangedListener> var0B46372821778E80A8D567D858E01F84_561817678 = (listeners).iterator();
                    var0B46372821778E80A8D567D858E01F84_561817678.hasNext();
                    OnScrollChangedListener listener = var0B46372821778E80A8D567D858E01F84_561817678.next();
                    {
                        listener.onScrollChanged();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final CopyOnWriteArrayList<OnScrollChangedListener> listeners = mOnScrollChangedListeners;
        //if (listeners != null && listeners.size() > 0) {
            //for (OnScrollChangedListener listener : listeners) {
                //listener.onScrollChanged();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.606 -0400", hash_original_method = "2C6DB6195F93A39A64EFB728D1470871", hash_generated_method = "6BC9248AB4E4771C902BB90B733D6F46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean hasComputeInternalInsetsListeners() {
        CopyOnWriteArrayList<OnComputeInternalInsetsListener> listeners;
        listeners = mOnComputeInternalInsetsListeners;
        boolean var233860A17AF3E54B07A56CF5069B1172_21489667 = ((listeners != null && listeners.size() > 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final CopyOnWriteArrayList<OnComputeInternalInsetsListener> listeners =
                //mOnComputeInternalInsetsListeners;
        //return (listeners != null && listeners.size() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.610 -0400", hash_original_method = "669AA7D13CEA0FF03A0D4565737F27DE", hash_generated_method = "82624BE1EA7540E34BA4DA9A9E5EE0CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void dispatchOnComputeInternalInsets(InternalInsetsInfo inoutInfo) {
        dsTaint.addTaint(inoutInfo.dsTaint);
        CopyOnWriteArrayList<OnComputeInternalInsetsListener> listeners;
        listeners = mOnComputeInternalInsetsListeners;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_1243006703 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnComputeInternalInsetsListener> varE7B0806474281BD8972102572AA142E1_778136759 = (listeners).iterator();
                    varE7B0806474281BD8972102572AA142E1_778136759.hasNext();
                    OnComputeInternalInsetsListener listener = varE7B0806474281BD8972102572AA142E1_778136759.next();
                    {
                        listener.onComputeInternalInsets(inoutInfo);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final CopyOnWriteArrayList<OnComputeInternalInsetsListener> listeners =
                //mOnComputeInternalInsetsListeners;
        //if (listeners != null && listeners.size() > 0) {
            //for (OnComputeInternalInsetsListener listener : listeners) {
                //listener.onComputeInternalInsets(inoutInfo);
            //}
        //}
    }

    
    public final static class InternalInsetsInfo {
        public Rect contentInsets = new Rect();
        public Rect visibleInsets = new Rect();
        public Region touchableRegion = new Region();
        int mTouchableInsets;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.610 -0400", hash_original_method = "97D6401592843AE03D0B640B1B772632", hash_generated_method = "97D6401592843AE03D0B640B1B772632")
                public InternalInsetsInfo ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.610 -0400", hash_original_method = "01F6FFADBD331B04D5C349DCEDD59961", hash_generated_method = "6EE41CF944F63F07E45D1AC90D528D8F")
        @DSModeled(DSC.SAFE)
        public void setTouchableInsets(int val) {
            dsTaint.addTaint(val);
            // ---------- Original Method ----------
            //mTouchableInsets = val;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.610 -0400", hash_original_method = "22281D8629688FB4A664F43EE105A786", hash_generated_method = "5FF701B1D0807AAB3D36C08AB64F1763")
        @DSModeled(DSC.SAFE)
        public int getTouchableInsets() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mTouchableInsets;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.611 -0400", hash_original_method = "3ADAEF811DF438E3299A293554314ABB", hash_generated_method = "23494F31333826983529A29D152FE74F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void reset() {
            contentInsets.setEmpty();
            visibleInsets.setEmpty();
            touchableRegion.setEmpty();
            mTouchableInsets = TOUCHABLE_INSETS_FRAME;
            // ---------- Original Method ----------
            //contentInsets.setEmpty();
            //visibleInsets.setEmpty();
            //touchableRegion.setEmpty();
            //mTouchableInsets = TOUCHABLE_INSETS_FRAME;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.611 -0400", hash_original_method = "1A7DC8D0BD4F165A6F4B2FD7EA5CEAEE", hash_generated_method = "ED3AFCA5113C88B7E81B6E8E388CAADC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            try 
            {
                InternalInsetsInfo other;
                other = (InternalInsetsInfo)o;
                {
                    boolean varF8197FD6716A4DC8EA1564616E3AEFD3_1038475199 = (!contentInsets.equals(other.contentInsets));
                } //End collapsed parenthetic
                {
                    boolean varD11BBD458E0571A6132940A120BAD8DA_120011314 = (!visibleInsets.equals(other.visibleInsets));
                } //End collapsed parenthetic
                boolean var92F272DE3D4E93EB7FCECFB0391002D2_1004012346 = (touchableRegion.equals(other.touchableRegion));
            } //End block
            catch (ClassCastException e)
            { }
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //try {
                //if (o == null) {
                    //return false;
                //}
                //InternalInsetsInfo other = (InternalInsetsInfo)o;
                //if (mTouchableInsets != other.mTouchableInsets) {
                    //return false;
                //}
                //if (!contentInsets.equals(other.contentInsets)) {
                    //return false;
                //}
                //if (!visibleInsets.equals(other.visibleInsets)) {
                    //return false;
                //}
                //return touchableRegion.equals(other.touchableRegion);
            //} catch (ClassCastException e) {
                //return false;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.611 -0400", hash_original_method = "FE3D6C607F0C914A7D0E564444F4D096", hash_generated_method = "BBFCE236D26AC4C7928308097AF0424A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void set(InternalInsetsInfo other) {
            dsTaint.addTaint(other.dsTaint);
            contentInsets.set(other.contentInsets);
            visibleInsets.set(other.visibleInsets);
            touchableRegion.set(other.touchableRegion);
            mTouchableInsets = other.mTouchableInsets;
            // ---------- Original Method ----------
            //contentInsets.set(other.contentInsets);
            //visibleInsets.set(other.visibleInsets);
            //touchableRegion.set(other.touchableRegion);
            //mTouchableInsets = other.mTouchableInsets;
        }

        
        public static final int TOUCHABLE_INSETS_FRAME = 0;
        public static final int TOUCHABLE_INSETS_CONTENT = 1;
        public static final int TOUCHABLE_INSETS_VISIBLE = 2;
        public static final int TOUCHABLE_INSETS_REGION = 3;
    }


    
    public interface OnGlobalFocusChangeListener {
        
        public void onGlobalFocusChanged(View oldFocus, View newFocus);
    }
    
    public interface OnGlobalLayoutListener {
        
        public void onGlobalLayout();
    }
    
    public interface OnPreDrawListener {
        
        public boolean onPreDraw();
    }
    
    public interface OnTouchModeChangeListener {
        
        public void onTouchModeChanged(boolean isInTouchMode);
    }
    
    public interface OnScrollChangedListener {
        
        public void onScrollChanged();
    }
    
    public interface OnComputeInternalInsetsListener {
        
        public void onComputeInternalInsets(InternalInsetsInfo inoutInfo);
    }
    
}

