package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import android.graphics.Rect;
import android.graphics.Region;





public final class ViewTreeObserver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.341 -0500", hash_original_field = "243C50630FCF204EE9B4C314818DD8FC", hash_generated_field = "04A11831DF9DCFA97CB002FC90812073")

    private CopyOnWriteArrayList<OnGlobalFocusChangeListener> mOnGlobalFocusListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.342 -0500", hash_original_field = "81A9643E1301BEA5ABF16AC06B3499CF", hash_generated_field = "641FAF3C0B812A14F87065C5D95E0F1B")

    private CopyOnWriteArrayList<OnGlobalLayoutListener> mOnGlobalLayoutListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.342 -0500", hash_original_field = "4FECA7949FF2396B915CE2531D73CAFD", hash_generated_field = "E6EEF6A7A09467C36B955957711EDDA9")

    private CopyOnWriteArrayList<OnTouchModeChangeListener> mOnTouchModeChangeListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.343 -0500", hash_original_field = "798D2D7D5EC1F753443E2719E5E39A49", hash_generated_field = "CA326802630E403AB34378F380EC96FA")

    private CopyOnWriteArrayList<OnComputeInternalInsetsListener> mOnComputeInternalInsetsListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.344 -0500", hash_original_field = "6ED1A3932F1A5CA755F9393EA60B11AA", hash_generated_field = "396479BE9B2B318ADA7B284E5032E19C")

    private CopyOnWriteArrayList<OnScrollChangedListener> mOnScrollChangedListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.345 -0500", hash_original_field = "1ECF8A21CD5F262BC61A5D1368F4D167", hash_generated_field = "11B3569796A6DE177A2F599E7C4842DD")

    private ArrayList<OnPreDrawListener> mOnPreDrawListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.345 -0500", hash_original_field = "2C2FECB1103C140EDEB3757207C903EA", hash_generated_field = "74CC761352E6A72E73CEEE65FB0BF6E6")


    private boolean mAlive = true;

    /**
     * Creates a new ViewTreeObserver. This constructor should not be called
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.365 -0500", hash_original_method = "CC9985AE6D7058390B2C51E91CCE49A3", hash_generated_method = "CC9985AE6D7058390B2C51E91CCE49A3")
    ViewTreeObserver() {
    }

    /**
     * Merges all the listeners registered on the specified observer with the listeners
     * registered on this object. After this method is invoked, the specified observer
     * will return false in {@link #isAlive()} and should not be used anymore.
     *
     * @param observer The ViewTreeObserver whose listeners must be added to this observer
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.366 -0500", hash_original_method = "FB8092EEF2FD22B43D0D69D64D0387FF", hash_generated_method = "FB8092EEF2FD22B43D0D69D64D0387FF")
    void merge(ViewTreeObserver observer) {
        if (observer.mOnGlobalFocusListeners != null) {
            if (mOnGlobalFocusListeners != null) {
                mOnGlobalFocusListeners.addAll(observer.mOnGlobalFocusListeners);
            } else {
                mOnGlobalFocusListeners = observer.mOnGlobalFocusListeners;
            }
        }

        if (observer.mOnGlobalLayoutListeners != null) {
            if (mOnGlobalLayoutListeners != null) {
                mOnGlobalLayoutListeners.addAll(observer.mOnGlobalLayoutListeners);
            } else {
                mOnGlobalLayoutListeners = observer.mOnGlobalLayoutListeners;
            }
        }

        if (observer.mOnPreDrawListeners != null) {
            if (mOnPreDrawListeners != null) {
                mOnPreDrawListeners.addAll(observer.mOnPreDrawListeners);
            } else {
                mOnPreDrawListeners = observer.mOnPreDrawListeners;
            }
        }

        if (observer.mOnTouchModeChangeListeners != null) {
            if (mOnTouchModeChangeListeners != null) {
                mOnTouchModeChangeListeners.addAll(observer.mOnTouchModeChangeListeners);
            } else {
                mOnTouchModeChangeListeners = observer.mOnTouchModeChangeListeners;
            }
        }

        if (observer.mOnComputeInternalInsetsListeners != null) {
            if (mOnComputeInternalInsetsListeners != null) {
                mOnComputeInternalInsetsListeners.addAll(observer.mOnComputeInternalInsetsListeners);
            } else {
                mOnComputeInternalInsetsListeners = observer.mOnComputeInternalInsetsListeners;
            }
        }

        observer.kill();
    }

    /**
     * Register a callback to be invoked when the focus state within the view tree changes.
     *
     * @param listener The callback to add
     *
     * @throws IllegalStateException If {@link #isAlive()} returns false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.367 -0500", hash_original_method = "A6A84348B82F6717F3C52BBBB15E789E", hash_generated_method = "B5BD797D49FF325BF511905C86429535")
    public void addOnGlobalFocusChangeListener(OnGlobalFocusChangeListener listener) {
        checkIsAlive();

        if (mOnGlobalFocusListeners == null) {
            mOnGlobalFocusListeners = new CopyOnWriteArrayList<OnGlobalFocusChangeListener>();
        }

        mOnGlobalFocusListeners.add(listener);
    }

    /**
     * Remove a previously installed focus change callback.
     *
     * @param victim The callback to remove
     *
     * @throws IllegalStateException If {@link #isAlive()} returns false
     *
     * @see #addOnGlobalFocusChangeListener(OnGlobalFocusChangeListener)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.368 -0500", hash_original_method = "96877EDD4D0178D607F096D2B02117DA", hash_generated_method = "B7C9DCC112021D3C3AAFF92EE65942C4")
    public void removeOnGlobalFocusChangeListener(OnGlobalFocusChangeListener victim) {
        checkIsAlive();
        if (mOnGlobalFocusListeners == null) {
            return;
        }
        mOnGlobalFocusListeners.remove(victim);
    }

    /**
     * Register a callback to be invoked when the global layout state or the visibility of views
     * within the view tree changes
     *
     * @param listener The callback to add
     *
     * @throws IllegalStateException If {@link #isAlive()} returns false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.369 -0500", hash_original_method = "14BEFF226C3B053CD01922ACD8EBA6F7", hash_generated_method = "21D32B1A4A7F03865063E5D1186EA3C1")
    public void addOnGlobalLayoutListener(OnGlobalLayoutListener listener) {
        checkIsAlive();

        if (mOnGlobalLayoutListeners == null) {
            mOnGlobalLayoutListeners = new CopyOnWriteArrayList<OnGlobalLayoutListener>();
        }

        mOnGlobalLayoutListeners.add(listener);
    }

    /**
     * Remove a previously installed global layout callback
     *
     * @param victim The callback to remove
     *
     * @throws IllegalStateException If {@link #isAlive()} returns false
     *
     * @see #addOnGlobalLayoutListener(OnGlobalLayoutListener)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.369 -0500", hash_original_method = "539A16F59B949D9890B1866DB4369A8D", hash_generated_method = "6F541C7A2EB78354BEC9FF61FBFBB133")
    public void removeGlobalOnLayoutListener(OnGlobalLayoutListener victim) {
        checkIsAlive();
        if (mOnGlobalLayoutListeners == null) {
            return;
        }
        mOnGlobalLayoutListeners.remove(victim);
    }

    /**
     * Register a callback to be invoked when the view tree is about to be drawn
     *
     * @param listener The callback to add
     *
     * @throws IllegalStateException If {@link #isAlive()} returns false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.370 -0500", hash_original_method = "920335313557C11873B99900CD6A6F78", hash_generated_method = "2D22CBF5AA9C339EDCB7380AFE56B730")
    public void addOnPreDrawListener(OnPreDrawListener listener) {
        checkIsAlive();

        if (mOnPreDrawListeners == null) {
            mOnPreDrawListeners = new ArrayList<OnPreDrawListener>();
        }

        mOnPreDrawListeners.add(listener);
    }

    /**
     * Remove a previously installed pre-draw callback
     *
     * @param victim The callback to remove
     *
     * @throws IllegalStateException If {@link #isAlive()} returns false
     *
     * @see #addOnPreDrawListener(OnPreDrawListener)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.371 -0500", hash_original_method = "D174E8E7C134C5C8B17339E89BF31A77", hash_generated_method = "14E8A60A5AA3AB4E71732E2E135AE777")
    public void removeOnPreDrawListener(OnPreDrawListener victim) {
        checkIsAlive();
        if (mOnPreDrawListeners == null) {
            return;
        }
        mOnPreDrawListeners.remove(victim);
    }

    /**
     * Register a callback to be invoked when a view has been scrolled.
     *
     * @param listener The callback to add
     *
     * @throws IllegalStateException If {@link #isAlive()} returns false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.372 -0500", hash_original_method = "CACC041FFA65A020B6AC1A976C2F46C3", hash_generated_method = "5D60E6FFDA2905C8A428445873DF152D")
    public void addOnScrollChangedListener(OnScrollChangedListener listener) {
        checkIsAlive();

        if (mOnScrollChangedListeners == null) {
            mOnScrollChangedListeners = new CopyOnWriteArrayList<OnScrollChangedListener>();
        }

        mOnScrollChangedListeners.add(listener);
    }

    /**
     * Remove a previously installed scroll-changed callback
     *
     * @param victim The callback to remove
     *
     * @throws IllegalStateException If {@link #isAlive()} returns false
     *
     * @see #addOnScrollChangedListener(OnScrollChangedListener)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.373 -0500", hash_original_method = "6198A3897D62B61D814225738CA4D351", hash_generated_method = "9DBE0311CEE86E15BD6C7B0DB39F3997")
    public void removeOnScrollChangedListener(OnScrollChangedListener victim) {
        checkIsAlive();
        if (mOnScrollChangedListeners == null) {
            return;
        }
        mOnScrollChangedListeners.remove(victim);
    }

    /**
     * Register a callback to be invoked when the invoked when the touch mode changes.
     *
     * @param listener The callback to add
     *
     * @throws IllegalStateException If {@link #isAlive()} returns false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.374 -0500", hash_original_method = "B309A69A91E26B4D51118B3E70AE0659", hash_generated_method = "E852BE5CCDE9836E44116A5C43788F76")
    public void addOnTouchModeChangeListener(OnTouchModeChangeListener listener) {
        checkIsAlive();

        if (mOnTouchModeChangeListeners == null) {
            mOnTouchModeChangeListeners = new CopyOnWriteArrayList<OnTouchModeChangeListener>();
        }

        mOnTouchModeChangeListeners.add(listener);
    }

    /**
     * Remove a previously installed touch mode change callback
     *
     * @param victim The callback to remove
     *
     * @throws IllegalStateException If {@link #isAlive()} returns false
     *
     * @see #addOnTouchModeChangeListener(OnTouchModeChangeListener)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.375 -0500", hash_original_method = "6CC5D76BF64E678A17AA54A0B0DC5C75", hash_generated_method = "10858D634132D3D57B87C1B272A0DA16")
    public void removeOnTouchModeChangeListener(OnTouchModeChangeListener victim) {
        checkIsAlive();
        if (mOnTouchModeChangeListeners == null) {
            return;
        }
        mOnTouchModeChangeListeners.remove(victim);
    }

    /**
     * Register a callback to be invoked when the invoked when it is time to
     * compute the window's internal insets.
     *
     * @param listener The callback to add
     *
     * @throws IllegalStateException If {@link #isAlive()} returns false
     * 
     * We are not yet ready to commit to this API and support it, so
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.375 -0500", hash_original_method = "D493AB47B92C8586FE24EDC32C42D722", hash_generated_method = "734E8FC95304BFEFEAF2F63DF7634D6C")
    public void addOnComputeInternalInsetsListener(OnComputeInternalInsetsListener listener) {
        checkIsAlive();

        if (mOnComputeInternalInsetsListeners == null) {
            mOnComputeInternalInsetsListeners =
                    new CopyOnWriteArrayList<OnComputeInternalInsetsListener>();
        }

        mOnComputeInternalInsetsListeners.add(listener);
    }

    /**
     * Remove a previously installed internal insets computation callback
     *
     * @param victim The callback to remove
     *
     * @throws IllegalStateException If {@link #isAlive()} returns false
     *
     * @see #addOnComputeInternalInsetsListener(OnComputeInternalInsetsListener)
     * 
     * We are not yet ready to commit to this API and support it, so
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.376 -0500", hash_original_method = "C4CB9160F62AB89C28812971D6DA3A2B", hash_generated_method = "EFD7CA9DDE0A979DC979D7960AFA6D0F")
    public void removeOnComputeInternalInsetsListener(OnComputeInternalInsetsListener victim) {
        checkIsAlive();
        if (mOnComputeInternalInsetsListeners == null) {
            return;
        }
        mOnComputeInternalInsetsListeners.remove(victim);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.377 -0500", hash_original_method = "09DE926E739DABD1095FDB2AAECCB187", hash_generated_method = "FFBABD4D25B104F5682D07CA2325A330")
    private void checkIsAlive() {
        if (!mAlive) {
            throw new IllegalStateException("This ViewTreeObserver is not alive, call "
                    + "getViewTreeObserver() again");
        }
    }

    /**
     * Indicates whether this ViewTreeObserver is alive. When an observer is not alive,
     * any call to a method (except this one) will throw an exception.
     *
     * If an application keeps a long-lived reference to this ViewTreeObserver, it should
     * always check for the result of this method before calling any other method.
     *
     * @return True if this object is alive and be used, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.378 -0500", hash_original_method = "8E102E0046F857D94D6EB92859BCA09E", hash_generated_method = "D88ABEB2C09A24180CD65E034DC4D01E")
    public boolean isAlive() {
        return mAlive;
    }

    /**
     * Marks this ViewTreeObserver as not alive. After invoking this method, invoking
     * any other method but {@link #isAlive()} and {@link #kill()} will throw an Exception.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.378 -0500", hash_original_method = "CE15D88AAF79A195F4E8949632256817", hash_generated_method = "E7C848C3D31C92E3FD118F4B74E2023E")
    private void kill() {
        mAlive = false;
    }

    /**
     * Notifies registered listeners that focus has changed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.379 -0500", hash_original_method = "811076DC02481277282C8AE588FEF9F4", hash_generated_method = "0B2674435C3ADAA3F53B0D1EB876CCF3")
    final void dispatchOnGlobalFocusChange(View oldFocus, View newFocus) {
        // NOTE: because of the use of CopyOnWriteArrayList, we *must* use an iterator to
        // perform the dispatching. The iterator is a safe guard against listeners that
        // could mutate the list by calling the various add/remove methods. This prevents
        // the array from being modified while we iterate it.
        final CopyOnWriteArrayList<OnGlobalFocusChangeListener> listeners = mOnGlobalFocusListeners;
        if (listeners != null && listeners.size() > 0) {
            for (OnGlobalFocusChangeListener listener : listeners) {
                listener.onGlobalFocusChanged(oldFocus, newFocus);
            }
        }
    }

    /**
     * Notifies registered listeners that a global layout happened. This can be called
     * manually if you are forcing a layout on a View or a hierarchy of Views that are
     * not attached to a Window or in the GONE state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.381 -0500", hash_original_method = "500AF4B5F4AA363828C439EF6D5AF0CA", hash_generated_method = "347E15221D9965A8A5625448EE734655")
    public final void dispatchOnGlobalLayout() {
        // NOTE: because of the use of CopyOnWriteArrayList, we *must* use an iterator to
        // perform the dispatching. The iterator is a safe guard against listeners that
        // could mutate the list by calling the various add/remove methods. This prevents
        // the array from being modified while we iterate it.
        final CopyOnWriteArrayList<OnGlobalLayoutListener> listeners = mOnGlobalLayoutListeners;
        if (listeners != null && listeners.size() > 0) {
            for (OnGlobalLayoutListener listener : listeners) {
                listener.onGlobalLayout();
            }
        }
    }

    /**
     * Notifies registered listeners that the drawing pass is about to start. If a
     * listener returns true, then the drawing pass is canceled and rescheduled. This can
     * be called manually if you are forcing the drawing on a View or a hierarchy of Views
     * that are not attached to a Window or in the GONE state.
     *
     * @return True if the current draw should be canceled and resceduled, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.382 -0500", hash_original_method = "81257F2850CF1393D415233A83FF9A37", hash_generated_method = "32433F4AA56276F4C94CA9A399DB9001")
    public final boolean dispatchOnPreDraw() {
        // NOTE: we *must* clone the listener list to perform the dispatching.
        // The clone is a safe guard against listeners that
        // could mutate the list by calling the various add/remove methods. This prevents
        // the array from being modified while we process it.
        boolean cancelDraw = false;
        if (mOnPreDrawListeners != null && mOnPreDrawListeners.size() > 0) {
            final ArrayList<OnPreDrawListener> listeners =
                    (ArrayList<OnPreDrawListener>) mOnPreDrawListeners.clone();
            int numListeners = listeners.size();
            for (int i = 0; i < numListeners; ++i) {
                cancelDraw |= !(listeners.get(i).onPreDraw());
            }
        }
        return cancelDraw;
    }

    /**
     * Notifies registered listeners that the touch mode has changed.
     *
     * @param inTouchMode True if the touch mode is now enabled, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.382 -0500", hash_original_method = "21795A7BDDB42F1334F3A5AC55A2B47D", hash_generated_method = "4E059443B7D0C15728C7B4D65724A755")
    final void dispatchOnTouchModeChanged(boolean inTouchMode) {
        final CopyOnWriteArrayList<OnTouchModeChangeListener> listeners =
                mOnTouchModeChangeListeners;
        if (listeners != null && listeners.size() > 0) {
            for (OnTouchModeChangeListener listener : listeners) {
                listener.onTouchModeChanged(inTouchMode);
            }
        }
    }

    /**
     * Notifies registered listeners that something has scrolled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.383 -0500", hash_original_method = "B2875E16B1AB55A20CB42509779AE060", hash_generated_method = "F6F78DDD5CA26B1B8B2265AC05BD68D5")
    final void dispatchOnScrollChanged() {
        // NOTE: because of the use of CopyOnWriteArrayList, we *must* use an iterator to
        // perform the dispatching. The iterator is a safe guard against listeners that
        // could mutate the list by calling the various add/remove methods. This prevents
        // the array from being modified while we iterate it.
        final CopyOnWriteArrayList<OnScrollChangedListener> listeners = mOnScrollChangedListeners;
        if (listeners != null && listeners.size() > 0) {
            for (OnScrollChangedListener listener : listeners) {
                listener.onScrollChanged();
            }
        }
    }

    /**
     * Returns whether there are listeners for computing internal insets.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.384 -0500", hash_original_method = "2C6DB6195F93A39A64EFB728D1470871", hash_generated_method = "A8A1F2731498B47C58B115DC2D723291")
    final boolean hasComputeInternalInsetsListeners() {
        final CopyOnWriteArrayList<OnComputeInternalInsetsListener> listeners =
                mOnComputeInternalInsetsListeners;
        return (listeners != null && listeners.size() > 0);
    }
    
    /**
     * Calls all listeners to compute the current insets.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.385 -0500", hash_original_method = "669AA7D13CEA0FF03A0D4565737F27DE", hash_generated_method = "77C0DD376B673FEC9B67F6C9E26F43A4")
    final void dispatchOnComputeInternalInsets(InternalInsetsInfo inoutInfo) {
        // NOTE: because of the use of CopyOnWriteArrayList, we *must* use an iterator to
        // perform the dispatching. The iterator is a safe guard against listeners that
        // could mutate the list by calling the various add/remove methods. This prevents
        // the array from being modified while we iterate it.
        final CopyOnWriteArrayList<OnComputeInternalInsetsListener> listeners =
                mOnComputeInternalInsetsListeners;
        if (listeners != null && listeners.size() > 0) {
            for (OnComputeInternalInsetsListener listener : listeners) {
                listener.onComputeInternalInsets(inoutInfo);
            }
        }
    }

    
    public final static class InternalInsetsInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.354 -0500", hash_original_field = "F5E115DC24246FBD5BC969EF50847E03", hash_generated_field = "7F6E87AFCA4A72E51380B03E5BB0A18C")

        public static final int TOUCHABLE_INSETS_FRAME = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.356 -0500", hash_original_field = "DCB62CD1DFC0E1A6D3476A6F786D3447", hash_generated_field = "57F3D76E043179883F9ECE5FFBC59445")

        public static final int TOUCHABLE_INSETS_CONTENT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.356 -0500", hash_original_field = "3DDF4C617F3CD851E79FA713D49BE2D8", hash_generated_field = "DCC9BBCBE257EB5DF44F3F3BE5C8A923")

        public static final int TOUCHABLE_INSETS_VISIBLE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.357 -0500", hash_original_field = "C46CB2B7400063D85AD5777BFF5D274F", hash_generated_field = "5989E7FD539B175CFC448972835B63FB")

        public static final int TOUCHABLE_INSETS_REGION = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.351 -0500", hash_original_field = "17C3DDEBF1E739E00C00CCB417FE887E", hash_generated_field = "6FEAC9FA8718B489DA85D1466C8EAE8A")

        public final Rect contentInsets = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.352 -0500", hash_original_field = "3C5D35F886081A3C1EF8C7E0F6668C34", hash_generated_field = "A6AF2F792B0CF72E04B7F493CF741654")

        public final Rect visibleInsets = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.353 -0500", hash_original_field = "0DC76966B2C3F66EA9CE70AE083247B7", hash_generated_field = "F49DB2DF83C2B114A730FA19005C8733")

        public final Region touchableRegion = new Region();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.360 -0500", hash_original_field = "B6D68575B2D268B82B7DDC000A8998CF", hash_generated_field = "B6D68575B2D268B82B7DDC000A8998CF")

        
        int mTouchableInsets;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.884 -0400", hash_original_method = "892C39758A803740C8313A0D5A4EBBE8", hash_generated_method = "892C39758A803740C8313A0D5A4EBBE8")
        public InternalInsetsInfo ()
        {
            //Synthesized constructor
        }

        /**
         * Set which parts of the window can be touched: either
         * {@link #TOUCHABLE_INSETS_FRAME}, {@link #TOUCHABLE_INSETS_CONTENT},
         * {@link #TOUCHABLE_INSETS_VISIBLE}, or {@link #TOUCHABLE_INSETS_REGION}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.358 -0500", hash_original_method = "01F6FFADBD331B04D5C349DCEDD59961", hash_generated_method = "6115A614A033F047E8D12A3748BFF287")
        public void setTouchableInsets(int val) {
            mTouchableInsets = val;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.359 -0500", hash_original_method = "22281D8629688FB4A664F43EE105A786", hash_generated_method = "4E3166A68793833ADF50447134B9BCB3")
        public int getTouchableInsets() {
            return mTouchableInsets;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.361 -0500", hash_original_method = "3ADAEF811DF438E3299A293554314ABB", hash_generated_method = "3ADAEF811DF438E3299A293554314ABB")
        void reset() {
            contentInsets.setEmpty();
            visibleInsets.setEmpty();
            touchableRegion.setEmpty();
            mTouchableInsets = TOUCHABLE_INSETS_FRAME;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.362 -0500", hash_original_method = "1A7DC8D0BD4F165A6F4B2FD7EA5CEAEE", hash_generated_method = "C3D9895F1CA1169274955CB5F29FB7CA")
        @Override
public boolean equals(Object o) {
            try {
                if (o == null) {
                    return false;
                }
                InternalInsetsInfo other = (InternalInsetsInfo)o;
                if (mTouchableInsets != other.mTouchableInsets) {
                    return false;
                }
                if (!contentInsets.equals(other.contentInsets)) {
                    return false;
                }
                if (!visibleInsets.equals(other.visibleInsets)) {
                    return false;
                }
                return touchableRegion.equals(other.touchableRegion);
            } catch (ClassCastException e) {
                return false;
            }
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.362 -0500", hash_original_method = "FE3D6C607F0C914A7D0E564444F4D096", hash_generated_method = "FE3D6C607F0C914A7D0E564444F4D096")
        void set(InternalInsetsInfo other) {
            contentInsets.set(other.contentInsets);
            visibleInsets.set(other.visibleInsets);
            touchableRegion.set(other.touchableRegion);
            mTouchableInsets = other.mTouchableInsets;
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

