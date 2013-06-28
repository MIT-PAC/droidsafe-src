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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.621 -0400", hash_original_field = "E2253A00D2C191692AC03B2939EC7FDB", hash_generated_field = "04A11831DF9DCFA97CB002FC90812073")

    private CopyOnWriteArrayList<OnGlobalFocusChangeListener> mOnGlobalFocusListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.621 -0400", hash_original_field = "72400345A7D4A5721478024E9C678A75", hash_generated_field = "641FAF3C0B812A14F87065C5D95E0F1B")

    private CopyOnWriteArrayList<OnGlobalLayoutListener> mOnGlobalLayoutListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.621 -0400", hash_original_field = "D6A13C045D8D43334B7DA8C25F099C9B", hash_generated_field = "E6EEF6A7A09467C36B955957711EDDA9")

    private CopyOnWriteArrayList<OnTouchModeChangeListener> mOnTouchModeChangeListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.621 -0400", hash_original_field = "ED386A60A4834B7AABE36625B2E3EA93", hash_generated_field = "CA326802630E403AB34378F380EC96FA")

    private CopyOnWriteArrayList<OnComputeInternalInsetsListener> mOnComputeInternalInsetsListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.621 -0400", hash_original_field = "D0BF66547360A2CE9909C78CB0D9EC5E", hash_generated_field = "396479BE9B2B318ADA7B284E5032E19C")

    private CopyOnWriteArrayList<OnScrollChangedListener> mOnScrollChangedListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.621 -0400", hash_original_field = "D59DDB4D74769DB3398BB46CEB9A24EE", hash_generated_field = "11B3569796A6DE177A2F599E7C4842DD")

    private ArrayList<OnPreDrawListener> mOnPreDrawListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.621 -0400", hash_original_field = "7D0CB0A4DF7C29E6F3E02B91B962D45B", hash_generated_field = "74CC761352E6A72E73CEEE65FB0BF6E6")

    private boolean mAlive = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.622 -0400", hash_original_method = "CC9985AE6D7058390B2C51E91CCE49A3", hash_generated_method = "5739F6075FCB84039D6115D26517DF4C")
      ViewTreeObserver() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.622 -0400", hash_original_method = "FB8092EEF2FD22B43D0D69D64D0387FF", hash_generated_method = "F88E2946C1A9488CD5515DD6A7E1D36A")
     void merge(ViewTreeObserver observer) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.623 -0400", hash_original_method = "A6A84348B82F6717F3C52BBBB15E789E", hash_generated_method = "36A3CE7F114E5B72390EE1C9FA9C5470")
    public void addOnGlobalFocusChangeListener(OnGlobalFocusChangeListener listener) {
        checkIsAlive();
        {
            mOnGlobalFocusListeners = new CopyOnWriteArrayList<OnGlobalFocusChangeListener>();
        } //End block
        mOnGlobalFocusListeners.add(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnGlobalFocusListeners == null) {
            //mOnGlobalFocusListeners = new CopyOnWriteArrayList<OnGlobalFocusChangeListener>();
        //}
        //mOnGlobalFocusListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.623 -0400", hash_original_method = "96877EDD4D0178D607F096D2B02117DA", hash_generated_method = "998A1F6BD4E3D3F6137216611D4714D1")
    public void removeOnGlobalFocusChangeListener(OnGlobalFocusChangeListener victim) {
        checkIsAlive();
        mOnGlobalFocusListeners.remove(victim);
        addTaint(victim.getTaint());
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnGlobalFocusListeners == null) {
            //return;
        //}
        //mOnGlobalFocusListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.624 -0400", hash_original_method = "14BEFF226C3B053CD01922ACD8EBA6F7", hash_generated_method = "7D9C05F381037B780C47F57732F51F7F")
    public void addOnGlobalLayoutListener(OnGlobalLayoutListener listener) {
        checkIsAlive();
        {
            mOnGlobalLayoutListeners = new CopyOnWriteArrayList<OnGlobalLayoutListener>();
        } //End block
        mOnGlobalLayoutListeners.add(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnGlobalLayoutListeners == null) {
            //mOnGlobalLayoutListeners = new CopyOnWriteArrayList<OnGlobalLayoutListener>();
        //}
        //mOnGlobalLayoutListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.624 -0400", hash_original_method = "539A16F59B949D9890B1866DB4369A8D", hash_generated_method = "1AE2B866BA7DCA7E7F4FA1526CFC82B3")
    public void removeGlobalOnLayoutListener(OnGlobalLayoutListener victim) {
        checkIsAlive();
        mOnGlobalLayoutListeners.remove(victim);
        addTaint(victim.getTaint());
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnGlobalLayoutListeners == null) {
            //return;
        //}
        //mOnGlobalLayoutListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.625 -0400", hash_original_method = "920335313557C11873B99900CD6A6F78", hash_generated_method = "96072D3D73A5745AF986AA651ADE42B1")
    public void addOnPreDrawListener(OnPreDrawListener listener) {
        checkIsAlive();
        {
            mOnPreDrawListeners = new ArrayList<OnPreDrawListener>();
        } //End block
        mOnPreDrawListeners.add(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnPreDrawListeners == null) {
            //mOnPreDrawListeners = new ArrayList<OnPreDrawListener>();
        //}
        //mOnPreDrawListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.625 -0400", hash_original_method = "D174E8E7C134C5C8B17339E89BF31A77", hash_generated_method = "BF340389EC939E03F5D4322BE9E0AAE8")
    public void removeOnPreDrawListener(OnPreDrawListener victim) {
        checkIsAlive();
        mOnPreDrawListeners.remove(victim);
        addTaint(victim.getTaint());
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnPreDrawListeners == null) {
            //return;
        //}
        //mOnPreDrawListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.625 -0400", hash_original_method = "CACC041FFA65A020B6AC1A976C2F46C3", hash_generated_method = "2C5C80E06BEB930E9C3A4F2F52C86F3C")
    public void addOnScrollChangedListener(OnScrollChangedListener listener) {
        checkIsAlive();
        {
            mOnScrollChangedListeners = new CopyOnWriteArrayList<OnScrollChangedListener>();
        } //End block
        mOnScrollChangedListeners.add(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnScrollChangedListeners == null) {
            //mOnScrollChangedListeners = new CopyOnWriteArrayList<OnScrollChangedListener>();
        //}
        //mOnScrollChangedListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.626 -0400", hash_original_method = "6198A3897D62B61D814225738CA4D351", hash_generated_method = "995762D66A284E61333A32DE7C5128EE")
    public void removeOnScrollChangedListener(OnScrollChangedListener victim) {
        checkIsAlive();
        mOnScrollChangedListeners.remove(victim);
        addTaint(victim.getTaint());
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnScrollChangedListeners == null) {
            //return;
        //}
        //mOnScrollChangedListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.626 -0400", hash_original_method = "B309A69A91E26B4D51118B3E70AE0659", hash_generated_method = "0DDAE23185085105FF12E220158D0164")
    public void addOnTouchModeChangeListener(OnTouchModeChangeListener listener) {
        checkIsAlive();
        {
            mOnTouchModeChangeListeners = new CopyOnWriteArrayList<OnTouchModeChangeListener>();
        } //End block
        mOnTouchModeChangeListeners.add(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnTouchModeChangeListeners == null) {
            //mOnTouchModeChangeListeners = new CopyOnWriteArrayList<OnTouchModeChangeListener>();
        //}
        //mOnTouchModeChangeListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.626 -0400", hash_original_method = "6CC5D76BF64E678A17AA54A0B0DC5C75", hash_generated_method = "DB5AE13A4668E7330461F932FF9BECB4")
    public void removeOnTouchModeChangeListener(OnTouchModeChangeListener victim) {
        checkIsAlive();
        mOnTouchModeChangeListeners.remove(victim);
        addTaint(victim.getTaint());
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnTouchModeChangeListeners == null) {
            //return;
        //}
        //mOnTouchModeChangeListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.627 -0400", hash_original_method = "D493AB47B92C8586FE24EDC32C42D722", hash_generated_method = "6869AB92C98DF94FFDA9D5FE6338214A")
    public void addOnComputeInternalInsetsListener(OnComputeInternalInsetsListener listener) {
        checkIsAlive();
        {
            mOnComputeInternalInsetsListeners =
                    new CopyOnWriteArrayList<OnComputeInternalInsetsListener>();
        } //End block
        mOnComputeInternalInsetsListeners.add(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnComputeInternalInsetsListeners == null) {
            //mOnComputeInternalInsetsListeners =
                    //new CopyOnWriteArrayList<OnComputeInternalInsetsListener>();
        //}
        //mOnComputeInternalInsetsListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.627 -0400", hash_original_method = "C4CB9160F62AB89C28812971D6DA3A2B", hash_generated_method = "A69CF151A3E15AA534C60AD68B1E5AC4")
    public void removeOnComputeInternalInsetsListener(OnComputeInternalInsetsListener victim) {
        checkIsAlive();
        mOnComputeInternalInsetsListeners.remove(victim);
        addTaint(victim.getTaint());
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnComputeInternalInsetsListeners == null) {
            //return;
        //}
        //mOnComputeInternalInsetsListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.627 -0400", hash_original_method = "09DE926E739DABD1095FDB2AAECCB187", hash_generated_method = "500A0F254BC3B579493EB41B061876F8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.628 -0400", hash_original_method = "8E102E0046F857D94D6EB92859BCA09E", hash_generated_method = "153CE4BC57F12ACF1400F11519E5EF82")
    public boolean isAlive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1689986747 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1689986747;
        // ---------- Original Method ----------
        //return mAlive;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.628 -0400", hash_original_method = "CE15D88AAF79A195F4E8949632256817", hash_generated_method = "ADAC88CFF01E50F749BE8EE5F2A18844")
    private void kill() {
        mAlive = false;
        // ---------- Original Method ----------
        //mAlive = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.632 -0400", hash_original_method = "811076DC02481277282C8AE588FEF9F4", hash_generated_method = "EF62BC85DA45730A364AA44204016C2A")
    final void dispatchOnGlobalFocusChange(View oldFocus, View newFocus) {
        final CopyOnWriteArrayList<OnGlobalFocusChangeListener> listeners = mOnGlobalFocusListeners;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_140573051 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnGlobalFocusChangeListener> var7A98234764E956E91DA8A394AFDB6376_927880005 = (listeners).iterator();
                    var7A98234764E956E91DA8A394AFDB6376_927880005.hasNext();
                    OnGlobalFocusChangeListener listener = var7A98234764E956E91DA8A394AFDB6376_927880005.next();
                    {
                        listener.onGlobalFocusChanged(oldFocus, newFocus);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(oldFocus.getTaint());
        addTaint(newFocus.getTaint());
        // ---------- Original Method ----------
        //final CopyOnWriteArrayList<OnGlobalFocusChangeListener> listeners = mOnGlobalFocusListeners;
        //if (listeners != null && listeners.size() > 0) {
            //for (OnGlobalFocusChangeListener listener : listeners) {
                //listener.onGlobalFocusChanged(oldFocus, newFocus);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.637 -0400", hash_original_method = "500AF4B5F4AA363828C439EF6D5AF0CA", hash_generated_method = "D658BEA8FB56E530D95F0078A7822AC0")
    public final void dispatchOnGlobalLayout() {
        final CopyOnWriteArrayList<OnGlobalLayoutListener> listeners = mOnGlobalLayoutListeners;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_183315506 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnGlobalLayoutListener> var02C1B6C27E93AF1BF997E51F917D95E9_1007548404 = (listeners).iterator();
                    var02C1B6C27E93AF1BF997E51F917D95E9_1007548404.hasNext();
                    OnGlobalLayoutListener listener = var02C1B6C27E93AF1BF997E51F917D95E9_1007548404.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.637 -0400", hash_original_method = "81257F2850CF1393D415233A83FF9A37", hash_generated_method = "911A58DF2BA2456A20E0D6615B3BF23A")
    public final boolean dispatchOnPreDraw() {
        boolean cancelDraw = false;
        {
            boolean var2391D555EE6834B061EF560800F34961_960657737 = (mOnPreDrawListeners != null && mOnPreDrawListeners.size() > 0);
            {
                final ArrayList<OnPreDrawListener> listeners = (ArrayList<OnPreDrawListener>) mOnPreDrawListeners.clone();
                int numListeners = listeners.size();
                {
                    int i = 0;
                    {
                        cancelDraw |= !(listeners.get(i).onPreDraw());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1457841671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1457841671;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.642 -0400", hash_original_method = "21795A7BDDB42F1334F3A5AC55A2B47D", hash_generated_method = "0BA0947B43E4688F89B597469DECB1F6")
    final void dispatchOnTouchModeChanged(boolean inTouchMode) {
        final CopyOnWriteArrayList<OnTouchModeChangeListener> listeners = mOnTouchModeChangeListeners;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_2141959596 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnTouchModeChangeListener> var5BDB6DB73C97A7AE707FC5DFEF30A014_1673825612 = (listeners).iterator();
                    var5BDB6DB73C97A7AE707FC5DFEF30A014_1673825612.hasNext();
                    OnTouchModeChangeListener listener = var5BDB6DB73C97A7AE707FC5DFEF30A014_1673825612.next();
                    {
                        listener.onTouchModeChanged(inTouchMode);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(inTouchMode);
        // ---------- Original Method ----------
        //final CopyOnWriteArrayList<OnTouchModeChangeListener> listeners =
                //mOnTouchModeChangeListeners;
        //if (listeners != null && listeners.size() > 0) {
            //for (OnTouchModeChangeListener listener : listeners) {
                //listener.onTouchModeChanged(inTouchMode);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.645 -0400", hash_original_method = "B2875E16B1AB55A20CB42509779AE060", hash_generated_method = "DEEC8501B752504E03A091366AFCB1B2")
    final void dispatchOnScrollChanged() {
        final CopyOnWriteArrayList<OnScrollChangedListener> listeners = mOnScrollChangedListeners;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_130442389 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnScrollChangedListener> var0B46372821778E80A8D567D858E01F84_1334839238 = (listeners).iterator();
                    var0B46372821778E80A8D567D858E01F84_1334839238.hasNext();
                    OnScrollChangedListener listener = var0B46372821778E80A8D567D858E01F84_1334839238.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.646 -0400", hash_original_method = "2C6DB6195F93A39A64EFB728D1470871", hash_generated_method = "DD7BF55BABE460377291ACB4D48EED40")
    final boolean hasComputeInternalInsetsListeners() {
        final CopyOnWriteArrayList<OnComputeInternalInsetsListener> listeners = mOnComputeInternalInsetsListeners;
        boolean var233860A17AF3E54B07A56CF5069B1172_10028153 = ((listeners != null && listeners.size() > 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1290278599 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1290278599;
        // ---------- Original Method ----------
        //final CopyOnWriteArrayList<OnComputeInternalInsetsListener> listeners =
                //mOnComputeInternalInsetsListeners;
        //return (listeners != null && listeners.size() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.651 -0400", hash_original_method = "669AA7D13CEA0FF03A0D4565737F27DE", hash_generated_method = "210FD5409B3C9816F7A94E12F518F8B0")
    final void dispatchOnComputeInternalInsets(InternalInsetsInfo inoutInfo) {
        final CopyOnWriteArrayList<OnComputeInternalInsetsListener> listeners = mOnComputeInternalInsetsListeners;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_1324189280 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnComputeInternalInsetsListener> varE7B0806474281BD8972102572AA142E1_393836313 = (listeners).iterator();
                    varE7B0806474281BD8972102572AA142E1_393836313.hasNext();
                    OnComputeInternalInsetsListener listener = varE7B0806474281BD8972102572AA142E1_393836313.next();
                    {
                        listener.onComputeInternalInsets(inoutInfo);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(inoutInfo.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.651 -0400", hash_original_field = "363745BBD66875733C04A6ABF1057263", hash_generated_field = "6FEAC9FA8718B489DA85D1466C8EAE8A")

        public final Rect contentInsets = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.651 -0400", hash_original_field = "C3E9E323485191498E30590BEC03FAD6", hash_generated_field = "A6AF2F792B0CF72E04B7F493CF741654")

        public final Rect visibleInsets = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.651 -0400", hash_original_field = "5CC4EAB992E3E01BAE580BFE4B7ACFD9", hash_generated_field = "F49DB2DF83C2B114A730FA19005C8733")

        public final Region touchableRegion = new Region();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.651 -0400", hash_original_field = "81F903742DA4C92623CAE8BEAA067BDE", hash_generated_field = "B6D68575B2D268B82B7DDC000A8998CF")

        int mTouchableInsets;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.651 -0400", hash_original_method = "892C39758A803740C8313A0D5A4EBBE8", hash_generated_method = "892C39758A803740C8313A0D5A4EBBE8")
        public InternalInsetsInfo ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.652 -0400", hash_original_method = "01F6FFADBD331B04D5C349DCEDD59961", hash_generated_method = "8DEE7B19E2DFEBD717CC580FD498B385")
        public void setTouchableInsets(int val) {
            mTouchableInsets = val;
            // ---------- Original Method ----------
            //mTouchableInsets = val;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.652 -0400", hash_original_method = "22281D8629688FB4A664F43EE105A786", hash_generated_method = "89C6DA539F001E086465C4E7D0FD2B6C")
        public int getTouchableInsets() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059125030 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059125030;
            // ---------- Original Method ----------
            //return mTouchableInsets;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.652 -0400", hash_original_method = "3ADAEF811DF438E3299A293554314ABB", hash_generated_method = "23494F31333826983529A29D152FE74F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.653 -0400", hash_original_method = "1A7DC8D0BD4F165A6F4B2FD7EA5CEAEE", hash_generated_method = "9EC7D59E6599A694DEEC6A9A36B58B22")
        @Override
        public boolean equals(Object o) {
            try 
            {
                InternalInsetsInfo other = (InternalInsetsInfo)o;
                {
                    boolean varF8197FD6716A4DC8EA1564616E3AEFD3_185103123 = (!contentInsets.equals(other.contentInsets));
                } //End collapsed parenthetic
                {
                    boolean varD11BBD458E0571A6132940A120BAD8DA_392072794 = (!visibleInsets.equals(other.visibleInsets));
                } //End collapsed parenthetic
                boolean var92F272DE3D4E93EB7FCECFB0391002D2_1318526786 = (touchableRegion.equals(other.touchableRegion));
            } //End block
            catch (ClassCastException e)
            { }
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400579976 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_400579976;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.653 -0400", hash_original_method = "FE3D6C607F0C914A7D0E564444F4D096", hash_generated_method = "87AFC457AA0AD3A9A01E035B26F17C58")
         void set(InternalInsetsInfo other) {
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.653 -0400", hash_original_field = "6AF1451968A913910A3944F4A11D0003", hash_generated_field = "7F6E87AFCA4A72E51380B03E5BB0A18C")

        public static final int TOUCHABLE_INSETS_FRAME = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.653 -0400", hash_original_field = "656C2DF39092ABC9C9B1AC32A4366026", hash_generated_field = "57F3D76E043179883F9ECE5FFBC59445")

        public static final int TOUCHABLE_INSETS_CONTENT = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.653 -0400", hash_original_field = "1405E6D702BB07938CDE50FB3FEEC4C7", hash_generated_field = "DCC9BBCBE257EB5DF44F3F3BE5C8A923")

        public static final int TOUCHABLE_INSETS_VISIBLE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.653 -0400", hash_original_field = "F5FEF116600C61224F2414100DB64DAD", hash_generated_field = "5989E7FD539B175CFC448972835B63FB")

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

