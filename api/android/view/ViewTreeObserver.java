package android.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import android.graphics.Rect;
import android.graphics.Region;





public final class ViewTreeObserver {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.873 -0400", hash_original_field = "E2253A00D2C191692AC03B2939EC7FDB", hash_generated_field = "04A11831DF9DCFA97CB002FC90812073")

    private CopyOnWriteArrayList<OnGlobalFocusChangeListener> mOnGlobalFocusListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.873 -0400", hash_original_field = "72400345A7D4A5721478024E9C678A75", hash_generated_field = "641FAF3C0B812A14F87065C5D95E0F1B")

    private CopyOnWriteArrayList<OnGlobalLayoutListener> mOnGlobalLayoutListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.873 -0400", hash_original_field = "D6A13C045D8D43334B7DA8C25F099C9B", hash_generated_field = "E6EEF6A7A09467C36B955957711EDDA9")

    private CopyOnWriteArrayList<OnTouchModeChangeListener> mOnTouchModeChangeListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.873 -0400", hash_original_field = "ED386A60A4834B7AABE36625B2E3EA93", hash_generated_field = "CA326802630E403AB34378F380EC96FA")

    private CopyOnWriteArrayList<OnComputeInternalInsetsListener> mOnComputeInternalInsetsListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.873 -0400", hash_original_field = "D0BF66547360A2CE9909C78CB0D9EC5E", hash_generated_field = "396479BE9B2B318ADA7B284E5032E19C")

    private CopyOnWriteArrayList<OnScrollChangedListener> mOnScrollChangedListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.873 -0400", hash_original_field = "D59DDB4D74769DB3398BB46CEB9A24EE", hash_generated_field = "11B3569796A6DE177A2F599E7C4842DD")

    private ArrayList<OnPreDrawListener> mOnPreDrawListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.873 -0400", hash_original_field = "7D0CB0A4DF7C29E6F3E02B91B962D45B", hash_generated_field = "74CC761352E6A72E73CEEE65FB0BF6E6")

    private boolean mAlive = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.873 -0400", hash_original_method = "CC9985AE6D7058390B2C51E91CCE49A3", hash_generated_method = "5739F6075FCB84039D6115D26517DF4C")
      ViewTreeObserver() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.875 -0400", hash_original_method = "FB8092EEF2FD22B43D0D69D64D0387FF", hash_generated_method = "0346D862D59AA70A62DFFB1F3D141E1A")
     void merge(ViewTreeObserver observer) {
        if(observer.mOnGlobalFocusListeners != null)        
        {
            if(mOnGlobalFocusListeners != null)            
            {
                mOnGlobalFocusListeners.addAll(observer.mOnGlobalFocusListeners);
            } //End block
            else
            {
                mOnGlobalFocusListeners = observer.mOnGlobalFocusListeners;
            } //End block
        } //End block
        if(observer.mOnGlobalLayoutListeners != null)        
        {
            if(mOnGlobalLayoutListeners != null)            
            {
                mOnGlobalLayoutListeners.addAll(observer.mOnGlobalLayoutListeners);
            } //End block
            else
            {
                mOnGlobalLayoutListeners = observer.mOnGlobalLayoutListeners;
            } //End block
        } //End block
        if(observer.mOnPreDrawListeners != null)        
        {
            if(mOnPreDrawListeners != null)            
            {
                mOnPreDrawListeners.addAll(observer.mOnPreDrawListeners);
            } //End block
            else
            {
                mOnPreDrawListeners = observer.mOnPreDrawListeners;
            } //End block
        } //End block
        if(observer.mOnTouchModeChangeListeners != null)        
        {
            if(mOnTouchModeChangeListeners != null)            
            {
                mOnTouchModeChangeListeners.addAll(observer.mOnTouchModeChangeListeners);
            } //End block
            else
            {
                mOnTouchModeChangeListeners = observer.mOnTouchModeChangeListeners;
            } //End block
        } //End block
        if(observer.mOnComputeInternalInsetsListeners != null)        
        {
            if(mOnComputeInternalInsetsListeners != null)            
            {
                mOnComputeInternalInsetsListeners.addAll(observer.mOnComputeInternalInsetsListeners);
            } //End block
            else
            {
                mOnComputeInternalInsetsListeners = observer.mOnComputeInternalInsetsListeners;
            } //End block
        } //End block
        observer.kill();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.876 -0400", hash_original_method = "A6A84348B82F6717F3C52BBBB15E789E", hash_generated_method = "B06C8EF4CD67B4D4927C6132AFEB6599")
    public void addOnGlobalFocusChangeListener(OnGlobalFocusChangeListener listener) {
        addTaint(listener.getTaint());
        checkIsAlive();
        if(mOnGlobalFocusListeners == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.877 -0400", hash_original_method = "96877EDD4D0178D607F096D2B02117DA", hash_generated_method = "4AF3CBA607F20C8DFFBFD7E141F1552A")
    public void removeOnGlobalFocusChangeListener(OnGlobalFocusChangeListener victim) {
        addTaint(victim.getTaint());
        checkIsAlive();
        if(mOnGlobalFocusListeners == null)        
        {
            return;
        } //End block
        mOnGlobalFocusListeners.remove(victim);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnGlobalFocusListeners == null) {
            //return;
        //}
        //mOnGlobalFocusListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.877 -0400", hash_original_method = "14BEFF226C3B053CD01922ACD8EBA6F7", hash_generated_method = "65F4D7DFFCFB51D9BF1B9D6AAD8C89F5")
    public void addOnGlobalLayoutListener(OnGlobalLayoutListener listener) {
        addTaint(listener.getTaint());
        checkIsAlive();
        if(mOnGlobalLayoutListeners == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.877 -0400", hash_original_method = "539A16F59B949D9890B1866DB4369A8D", hash_generated_method = "77320CBEB483D8FC9217BF5FE3EA23A1")
    public void removeGlobalOnLayoutListener(OnGlobalLayoutListener victim) {
        addTaint(victim.getTaint());
        checkIsAlive();
        if(mOnGlobalLayoutListeners == null)        
        {
            return;
        } //End block
        mOnGlobalLayoutListeners.remove(victim);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnGlobalLayoutListeners == null) {
            //return;
        //}
        //mOnGlobalLayoutListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.878 -0400", hash_original_method = "920335313557C11873B99900CD6A6F78", hash_generated_method = "329949021E3D975B49DA9802546117D4")
    public void addOnPreDrawListener(OnPreDrawListener listener) {
        addTaint(listener.getTaint());
        checkIsAlive();
        if(mOnPreDrawListeners == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.878 -0400", hash_original_method = "D174E8E7C134C5C8B17339E89BF31A77", hash_generated_method = "E7C344190CD48A5FF824A18831CC6C41")
    public void removeOnPreDrawListener(OnPreDrawListener victim) {
        addTaint(victim.getTaint());
        checkIsAlive();
        if(mOnPreDrawListeners == null)        
        {
            return;
        } //End block
        mOnPreDrawListeners.remove(victim);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnPreDrawListeners == null) {
            //return;
        //}
        //mOnPreDrawListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.878 -0400", hash_original_method = "CACC041FFA65A020B6AC1A976C2F46C3", hash_generated_method = "EFFF0C63A4AC8DAA39653D195EF93BB2")
    public void addOnScrollChangedListener(OnScrollChangedListener listener) {
        addTaint(listener.getTaint());
        checkIsAlive();
        if(mOnScrollChangedListeners == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.878 -0400", hash_original_method = "6198A3897D62B61D814225738CA4D351", hash_generated_method = "C7A1F3DD8193642A5725FD244BC0C583")
    public void removeOnScrollChangedListener(OnScrollChangedListener victim) {
        addTaint(victim.getTaint());
        checkIsAlive();
        if(mOnScrollChangedListeners == null)        
        {
            return;
        } //End block
        mOnScrollChangedListeners.remove(victim);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnScrollChangedListeners == null) {
            //return;
        //}
        //mOnScrollChangedListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.879 -0400", hash_original_method = "B309A69A91E26B4D51118B3E70AE0659", hash_generated_method = "674D6DC5B96242CD3AF3EBDF5307446F")
    public void addOnTouchModeChangeListener(OnTouchModeChangeListener listener) {
        addTaint(listener.getTaint());
        checkIsAlive();
        if(mOnTouchModeChangeListeners == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.879 -0400", hash_original_method = "6CC5D76BF64E678A17AA54A0B0DC5C75", hash_generated_method = "437A2FA4CAAEB848589C7F15CEBF1F3E")
    public void removeOnTouchModeChangeListener(OnTouchModeChangeListener victim) {
        addTaint(victim.getTaint());
        checkIsAlive();
        if(mOnTouchModeChangeListeners == null)        
        {
            return;
        } //End block
        mOnTouchModeChangeListeners.remove(victim);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnTouchModeChangeListeners == null) {
            //return;
        //}
        //mOnTouchModeChangeListeners.remove(victim);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.879 -0400", hash_original_method = "D493AB47B92C8586FE24EDC32C42D722", hash_generated_method = "F48E8EF1EA59BB17138A255802106E98")
    public void addOnComputeInternalInsetsListener(OnComputeInternalInsetsListener listener) {
        addTaint(listener.getTaint());
        checkIsAlive();
        if(mOnComputeInternalInsetsListeners == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.880 -0400", hash_original_method = "C4CB9160F62AB89C28812971D6DA3A2B", hash_generated_method = "B740FC7F141157A4C88E29CE237DE9F7")
    public void removeOnComputeInternalInsetsListener(OnComputeInternalInsetsListener victim) {
        addTaint(victim.getTaint());
        checkIsAlive();
        if(mOnComputeInternalInsetsListeners == null)        
        {
            return;
        } //End block
        mOnComputeInternalInsetsListeners.remove(victim);
        // ---------- Original Method ----------
        //checkIsAlive();
        //if (mOnComputeInternalInsetsListeners == null) {
            //return;
        //}
        //mOnComputeInternalInsetsListeners.remove(victim);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.880 -0400", hash_original_method = "09DE926E739DABD1095FDB2AAECCB187", hash_generated_method = "3088AF6132E7110CDCBD60CE9D243E4D")
    private void checkIsAlive() {
        if(!mAlive)        
        {
            IllegalStateException varB733061FC4333142380D0C2AE2F117CC_1576179796 = new IllegalStateException("This ViewTreeObserver is not alive, call "
                    + "getViewTreeObserver() again");
            varB733061FC4333142380D0C2AE2F117CC_1576179796.addTaint(taint);
            throw varB733061FC4333142380D0C2AE2F117CC_1576179796;
        } //End block
        // ---------- Original Method ----------
        //if (!mAlive) {
            //throw new IllegalStateException("This ViewTreeObserver is not alive, call "
                    //+ "getViewTreeObserver() again");
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.880 -0400", hash_original_method = "8E102E0046F857D94D6EB92859BCA09E", hash_generated_method = "570B0AD17139F6A33BF263F625C00627")
    public boolean isAlive() {
        boolean varD5ADB51FA651F2BDB10432197B9FBD03_1750211624 = (mAlive);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69725452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_69725452;
        // ---------- Original Method ----------
        //return mAlive;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.881 -0400", hash_original_method = "CE15D88AAF79A195F4E8949632256817", hash_generated_method = "ADAC88CFF01E50F749BE8EE5F2A18844")
    private void kill() {
        mAlive = false;
        // ---------- Original Method ----------
        //mAlive = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.881 -0400", hash_original_method = "811076DC02481277282C8AE588FEF9F4", hash_generated_method = "C2FEF8E2D7BDFE913435033A363C714C")
    final void dispatchOnGlobalFocusChange(View oldFocus, View newFocus) {
        addTaint(newFocus.getTaint());
        addTaint(oldFocus.getTaint());
        final CopyOnWriteArrayList<OnGlobalFocusChangeListener> listeners = mOnGlobalFocusListeners;
        if(listeners != null && listeners.size() > 0)        
        {
for(OnGlobalFocusChangeListener listener : listeners)
            {
                listener.onGlobalFocusChanged(oldFocus, newFocus);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final CopyOnWriteArrayList<OnGlobalFocusChangeListener> listeners = mOnGlobalFocusListeners;
        //if (listeners != null && listeners.size() > 0) {
            //for (OnGlobalFocusChangeListener listener : listeners) {
                //listener.onGlobalFocusChanged(oldFocus, newFocus);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.881 -0400", hash_original_method = "500AF4B5F4AA363828C439EF6D5AF0CA", hash_generated_method = "8418BE658641286F11F0357608CAF332")
    public final void dispatchOnGlobalLayout() {
        final CopyOnWriteArrayList<OnGlobalLayoutListener> listeners = mOnGlobalLayoutListeners;
        if(listeners != null && listeners.size() > 0)        
        {
for(OnGlobalLayoutListener listener : listeners)
            {
                listener.onGlobalLayout();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final CopyOnWriteArrayList<OnGlobalLayoutListener> listeners = mOnGlobalLayoutListeners;
        //if (listeners != null && listeners.size() > 0) {
            //for (OnGlobalLayoutListener listener : listeners) {
                //listener.onGlobalLayout();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.882 -0400", hash_original_method = "81257F2850CF1393D415233A83FF9A37", hash_generated_method = "57207E7FBB82720050180E0236F94E7F")
    public final boolean dispatchOnPreDraw() {
        boolean cancelDraw = false;
        if(mOnPreDrawListeners != null && mOnPreDrawListeners.size() > 0)        
        {
            final ArrayList<OnPreDrawListener> listeners = (ArrayList<OnPreDrawListener>) mOnPreDrawListeners.clone();
            int numListeners = listeners.size();
for(int i = 0;i < numListeners;++i)
            {
                cancelDraw |= !(listeners.get(i).onPreDraw());
            } //End block
        } //End block
        boolean var3FB5CD885FE486F533BAF6ACA8DC5700_1038972519 = (cancelDraw);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1519948180 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1519948180;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.882 -0400", hash_original_method = "21795A7BDDB42F1334F3A5AC55A2B47D", hash_generated_method = "1D582A410182D6661AFFE9F1ABACAAA4")
    final void dispatchOnTouchModeChanged(boolean inTouchMode) {
        addTaint(inTouchMode);
        final CopyOnWriteArrayList<OnTouchModeChangeListener> listeners = mOnTouchModeChangeListeners;
        if(listeners != null && listeners.size() > 0)        
        {
for(OnTouchModeChangeListener listener : listeners)
            {
                listener.onTouchModeChanged(inTouchMode);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final CopyOnWriteArrayList<OnTouchModeChangeListener> listeners =
                //mOnTouchModeChangeListeners;
        //if (listeners != null && listeners.size() > 0) {
            //for (OnTouchModeChangeListener listener : listeners) {
                //listener.onTouchModeChanged(inTouchMode);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.883 -0400", hash_original_method = "B2875E16B1AB55A20CB42509779AE060", hash_generated_method = "39E4AE7615F3456FB7B29A0D22902E1D")
    final void dispatchOnScrollChanged() {
        final CopyOnWriteArrayList<OnScrollChangedListener> listeners = mOnScrollChangedListeners;
        if(listeners != null && listeners.size() > 0)        
        {
for(OnScrollChangedListener listener : listeners)
            {
                listener.onScrollChanged();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final CopyOnWriteArrayList<OnScrollChangedListener> listeners = mOnScrollChangedListeners;
        //if (listeners != null && listeners.size() > 0) {
            //for (OnScrollChangedListener listener : listeners) {
                //listener.onScrollChanged();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.883 -0400", hash_original_method = "2C6DB6195F93A39A64EFB728D1470871", hash_generated_method = "A356D4A0C39466B02599976FF69DBDB7")
    final boolean hasComputeInternalInsetsListeners() {
        final CopyOnWriteArrayList<OnComputeInternalInsetsListener> listeners = mOnComputeInternalInsetsListeners;
        boolean varF719817FFCF79D951E7B9023876E5F4C_110261153 = ((listeners != null && listeners.size() > 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1739395878 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1739395878;
        // ---------- Original Method ----------
        //final CopyOnWriteArrayList<OnComputeInternalInsetsListener> listeners =
                //mOnComputeInternalInsetsListeners;
        //return (listeners != null && listeners.size() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.883 -0400", hash_original_method = "669AA7D13CEA0FF03A0D4565737F27DE", hash_generated_method = "1AF38C77AAF15F1F56DD40F6AE3DE188")
    final void dispatchOnComputeInternalInsets(InternalInsetsInfo inoutInfo) {
        addTaint(inoutInfo.getTaint());
        final CopyOnWriteArrayList<OnComputeInternalInsetsListener> listeners = mOnComputeInternalInsetsListeners;
        if(listeners != null && listeners.size() > 0)        
        {
for(OnComputeInternalInsetsListener listener : listeners)
            {
                listener.onComputeInternalInsets(inoutInfo);
            } //End block
        } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.884 -0400", hash_original_field = "363745BBD66875733C04A6ABF1057263", hash_generated_field = "6FEAC9FA8718B489DA85D1466C8EAE8A")

        public final Rect contentInsets = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.884 -0400", hash_original_field = "C3E9E323485191498E30590BEC03FAD6", hash_generated_field = "A6AF2F792B0CF72E04B7F493CF741654")

        public final Rect visibleInsets = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.884 -0400", hash_original_field = "5CC4EAB992E3E01BAE580BFE4B7ACFD9", hash_generated_field = "F49DB2DF83C2B114A730FA19005C8733")

        public final Region touchableRegion = new Region();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.884 -0400", hash_original_field = "81F903742DA4C92623CAE8BEAA067BDE", hash_generated_field = "B6D68575B2D268B82B7DDC000A8998CF")

        int mTouchableInsets;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.884 -0400", hash_original_method = "892C39758A803740C8313A0D5A4EBBE8", hash_generated_method = "892C39758A803740C8313A0D5A4EBBE8")
        public InternalInsetsInfo ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.885 -0400", hash_original_method = "01F6FFADBD331B04D5C349DCEDD59961", hash_generated_method = "8DEE7B19E2DFEBD717CC580FD498B385")
        public void setTouchableInsets(int val) {
            mTouchableInsets = val;
            // ---------- Original Method ----------
            //mTouchableInsets = val;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.885 -0400", hash_original_method = "22281D8629688FB4A664F43EE105A786", hash_generated_method = "AED918718D87C39F109E1A7C9DCA06FC")
        public int getTouchableInsets() {
            int var81F903742DA4C92623CAE8BEAA067BDE_1547780516 = (mTouchableInsets);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1044573128 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1044573128;
            // ---------- Original Method ----------
            //return mTouchableInsets;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.886 -0400", hash_original_method = "3ADAEF811DF438E3299A293554314ABB", hash_generated_method = "23494F31333826983529A29D152FE74F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.886 -0400", hash_original_method = "1A7DC8D0BD4F165A6F4B2FD7EA5CEAEE", hash_generated_method = "DEAB04F6A2A10D1A5FD3195AC95671A1")
        @Override
        public boolean equals(Object o) {
            addTaint(o.getTaint());
            try 
            {
                if(o == null)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_4581149 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_37113166 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_37113166;
                } //End block
                InternalInsetsInfo other = (InternalInsetsInfo)o;
                if(mTouchableInsets != other.mTouchableInsets)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_2019109111 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_177977214 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_177977214;
                } //End block
                if(!contentInsets.equals(other.contentInsets))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_510428412 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1993250377 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1993250377;
                } //End block
                if(!visibleInsets.equals(other.visibleInsets))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_326879906 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2088633545 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2088633545;
                } //End block
                boolean var6E3EC6374F730B50962418E9FB8FF8D1_1962294904 = (touchableRegion.equals(other.touchableRegion));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1872228293 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1872228293;
            } //End block
            catch (ClassCastException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_373020769 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_372005914 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_372005914;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.888 -0400", hash_original_method = "FE3D6C607F0C914A7D0E564444F4D096", hash_generated_method = "87AFC457AA0AD3A9A01E035B26F17C58")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.888 -0400", hash_original_field = "6AF1451968A913910A3944F4A11D0003", hash_generated_field = "7F6E87AFCA4A72E51380B03E5BB0A18C")

        public static final int TOUCHABLE_INSETS_FRAME = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.888 -0400", hash_original_field = "656C2DF39092ABC9C9B1AC32A4366026", hash_generated_field = "57F3D76E043179883F9ECE5FFBC59445")

        public static final int TOUCHABLE_INSETS_CONTENT = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.888 -0400", hash_original_field = "1405E6D702BB07938CDE50FB3FEEC4C7", hash_generated_field = "DCC9BBCBE257EB5DF44F3F3BE5C8A923")

        public static final int TOUCHABLE_INSETS_VISIBLE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.888 -0400", hash_original_field = "F5FEF116600C61224F2414100DB64DAD", hash_generated_field = "5989E7FD539B175CFC448972835B63FB")

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

