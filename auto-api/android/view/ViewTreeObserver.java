package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.773 -0400", hash_original_method = "CC9985AE6D7058390B2C51E91CCE49A3", hash_generated_method = "A9001F17A189BA28DEAAC1777E046669")
    @DSModeled(DSC.SAFE)
     ViewTreeObserver() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.773 -0400", hash_original_method = "FB8092EEF2FD22B43D0D69D64D0387FF", hash_generated_method = "5420E8AD47720C949A6347D0E62302A4")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.774 -0400", hash_original_method = "A6A84348B82F6717F3C52BBBB15E789E", hash_generated_method = "10950B9CBCC527FA334CF6D06A82C764")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.774 -0400", hash_original_method = "96877EDD4D0178D607F096D2B02117DA", hash_generated_method = "3BCE0BE29EE662FDE361655CD5E19E5E")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.774 -0400", hash_original_method = "14BEFF226C3B053CD01922ACD8EBA6F7", hash_generated_method = "FA18B657D5A936149DE4007042E08FAB")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.774 -0400", hash_original_method = "539A16F59B949D9890B1866DB4369A8D", hash_generated_method = "DD50E6FD76E1BD055565B47D00C4BA1D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.774 -0400", hash_original_method = "920335313557C11873B99900CD6A6F78", hash_generated_method = "392A855BDAB08E2F0105D117AFD164BB")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.774 -0400", hash_original_method = "D174E8E7C134C5C8B17339E89BF31A77", hash_generated_method = "2970051591A04A2696D24FF74C57E028")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.774 -0400", hash_original_method = "CACC041FFA65A020B6AC1A976C2F46C3", hash_generated_method = "26904C4E080725AF8C1097804629D6C6")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.774 -0400", hash_original_method = "6198A3897D62B61D814225738CA4D351", hash_generated_method = "20993E9D5DAAA4ED1B2A9106C845F078")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.774 -0400", hash_original_method = "B309A69A91E26B4D51118B3E70AE0659", hash_generated_method = "8EB172D6A66444C55BF66EF8CD67FA99")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.774 -0400", hash_original_method = "6CC5D76BF64E678A17AA54A0B0DC5C75", hash_generated_method = "FFA74FBB10E6A80B349AF9EACC4BB9EA")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.774 -0400", hash_original_method = "D493AB47B92C8586FE24EDC32C42D722", hash_generated_method = "69A144A83FED7FF0BCA25F46018BBEC1")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.775 -0400", hash_original_method = "C4CB9160F62AB89C28812971D6DA3A2B", hash_generated_method = "25FBD39EEC39488335ABD821B404560E")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.775 -0400", hash_original_method = "09DE926E739DABD1095FDB2AAECCB187", hash_generated_method = "69C907DC94E1ED0407FAEFFE81FD3E9B")
    @DSModeled(DSC.SAFE)
    private void checkIsAlive() {
        {
            throw new IllegalStateException("This ViewTreeObserver is not alive, call "
                    + "getViewTreeObserver() again");
        } //End block
        // ---------- Original Method ----------
        //if (!mAlive) {
            //throw new IllegalStateException("This ViewTreeObserver is not alive, call "
                    //+ "getViewTreeObserver() again");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.775 -0400", hash_original_method = "8E102E0046F857D94D6EB92859BCA09E", hash_generated_method = "62D77ABF121DF45C78A749A162077450")
    @DSModeled(DSC.SAFE)
    public boolean isAlive() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAlive;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.775 -0400", hash_original_method = "CE15D88AAF79A195F4E8949632256817", hash_generated_method = "35B7CA2EF04077F4F1EE11B073A8C927")
    @DSModeled(DSC.SAFE)
    private void kill() {
        mAlive = false;
        // ---------- Original Method ----------
        //mAlive = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.775 -0400", hash_original_method = "811076DC02481277282C8AE588FEF9F4", hash_generated_method = "A849A9A51FA0F9CC411EBE3E84F31397")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void dispatchOnGlobalFocusChange(View oldFocus, View newFocus) {
        dsTaint.addTaint(oldFocus.dsTaint);
        dsTaint.addTaint(newFocus.dsTaint);
        final CopyOnWriteArrayList<OnGlobalFocusChangeListener> listeners;
        listeners = mOnGlobalFocusListeners;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_998240099 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnGlobalFocusChangeListener> seatecAstronomy42 = listeners.iterator();
                    seatecAstronomy42.hasNext();
                    OnGlobalFocusChangeListener listener = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.775 -0400", hash_original_method = "500AF4B5F4AA363828C439EF6D5AF0CA", hash_generated_method = "79FFCBE9FDEC4DE00B0C8CF609C7A4F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void dispatchOnGlobalLayout() {
        final CopyOnWriteArrayList<OnGlobalLayoutListener> listeners;
        listeners = mOnGlobalLayoutListeners;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_1640481569 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnGlobalLayoutListener> seatecAstronomy42 = listeners.iterator();
                    seatecAstronomy42.hasNext();
                    OnGlobalLayoutListener listener = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.775 -0400", hash_original_method = "81257F2850CF1393D415233A83FF9A37", hash_generated_method = "83C67A7078BE2C9FAF2E10D872379970")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean dispatchOnPreDraw() {
        boolean cancelDraw;
        cancelDraw = false;
        {
            boolean var2391D555EE6834B061EF560800F34961_1732388502 = (mOnPreDrawListeners != null && mOnPreDrawListeners.size() > 0);
            {
                final ArrayList<OnPreDrawListener> listeners;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.775 -0400", hash_original_method = "21795A7BDDB42F1334F3A5AC55A2B47D", hash_generated_method = "8BE530A2BA211EBC4543A9CB55D75030")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void dispatchOnTouchModeChanged(boolean inTouchMode) {
        dsTaint.addTaint(inTouchMode);
        final CopyOnWriteArrayList<OnTouchModeChangeListener> listeners;
        listeners = mOnTouchModeChangeListeners;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_464869154 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnTouchModeChangeListener> seatecAstronomy42 = listeners.iterator();
                    seatecAstronomy42.hasNext();
                    OnTouchModeChangeListener listener = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.776 -0400", hash_original_method = "B2875E16B1AB55A20CB42509779AE060", hash_generated_method = "9CD578DF827BEF96679EDBF167464FAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void dispatchOnScrollChanged() {
        final CopyOnWriteArrayList<OnScrollChangedListener> listeners;
        listeners = mOnScrollChangedListeners;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_284990769 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnScrollChangedListener> seatecAstronomy42 = listeners.iterator();
                    seatecAstronomy42.hasNext();
                    OnScrollChangedListener listener = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.776 -0400", hash_original_method = "2C6DB6195F93A39A64EFB728D1470871", hash_generated_method = "317B7360BA93899B00DAFA1BE569A10A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean hasComputeInternalInsetsListeners() {
        final CopyOnWriteArrayList<OnComputeInternalInsetsListener> listeners;
        listeners = mOnComputeInternalInsetsListeners;
        boolean var233860A17AF3E54B07A56CF5069B1172_1484089098 = ((listeners != null && listeners.size() > 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final CopyOnWriteArrayList<OnComputeInternalInsetsListener> listeners =
                //mOnComputeInternalInsetsListeners;
        //return (listeners != null && listeners.size() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.776 -0400", hash_original_method = "669AA7D13CEA0FF03A0D4565737F27DE", hash_generated_method = "0DC7EEC4F0666716A86C7AAADB87D428")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void dispatchOnComputeInternalInsets(InternalInsetsInfo inoutInfo) {
        dsTaint.addTaint(inoutInfo.dsTaint);
        final CopyOnWriteArrayList<OnComputeInternalInsetsListener> listeners;
        listeners = mOnComputeInternalInsetsListeners;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_841694103 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnComputeInternalInsetsListener> seatecAstronomy42 = listeners.iterator();
                    seatecAstronomy42.hasNext();
                    OnComputeInternalInsetsListener listener = seatecAstronomy42.next();
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
        public final Rect contentInsets = new Rect();
        public final Rect visibleInsets = new Rect();
        public final Region touchableRegion = new Region();
        public static final int TOUCHABLE_INSETS_FRAME = 0;
        public static final int TOUCHABLE_INSETS_CONTENT = 1;
        public static final int TOUCHABLE_INSETS_VISIBLE = 2;
        public static final int TOUCHABLE_INSETS_REGION = 3;
        int mTouchableInsets;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.776 -0400", hash_original_method = "01F6FFADBD331B04D5C349DCEDD59961", hash_generated_method = "A11652816F7A17F6975360977C30431E")
        @DSModeled(DSC.SAFE)
        public void setTouchableInsets(int val) {
            dsTaint.addTaint(val);
            // ---------- Original Method ----------
            //mTouchableInsets = val;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.776 -0400", hash_original_method = "22281D8629688FB4A664F43EE105A786", hash_generated_method = "2742714E0D5AFBDCFCA8180F7D8731AA")
        @DSModeled(DSC.SAFE)
        public int getTouchableInsets() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mTouchableInsets;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.776 -0400", hash_original_method = "3ADAEF811DF438E3299A293554314ABB", hash_generated_method = "B41D6003C59B60EBDEE3EFA0ABA26090")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.776 -0400", hash_original_method = "1A7DC8D0BD4F165A6F4B2FD7EA5CEAEE", hash_generated_method = "A7063D106555993F40A50352D8F5CFF0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            try 
            {
                InternalInsetsInfo other;
                other = (InternalInsetsInfo)o;
                {
                    boolean varF8197FD6716A4DC8EA1564616E3AEFD3_141542447 = (!contentInsets.equals(other.contentInsets));
                } //End collapsed parenthetic
                {
                    boolean varD11BBD458E0571A6132940A120BAD8DA_1817554676 = (!visibleInsets.equals(other.visibleInsets));
                } //End collapsed parenthetic
                boolean var92F272DE3D4E93EB7FCECFB0391002D2_494075155 = (touchableRegion.equals(other.touchableRegion));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.776 -0400", hash_original_method = "FE3D6C607F0C914A7D0E564444F4D096", hash_generated_method = "F810DFDBC95BEB5EA34DA1B082206CBF")
        @DSModeled(DSC.SAFE)
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


