package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;

public class GestureDetector {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.717 -0500", hash_original_field = "3292E3C407AFFD1ECB63974A48EF6F26", hash_generated_field = "A0C74D07DE33813B70581123FF749A35")

    private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.719 -0500", hash_original_field = "1890900927A925C86536426FAA153831", hash_generated_field = "B2C557FED0C410FD936C94D9C495E66C")

    private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.722 -0500", hash_original_field = "B38F23199EDAB3EC9AEB64805D70A86D", hash_generated_field = "AF4DBB13E8C6A9BFDCE110BEA6959177")

    private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.724 -0500", hash_original_field = "96AD902CB8CC1F973F8F2F99306FF12F", hash_generated_field = "3EDD79F644F06511146F8C3326C425D3")

    private static final int SHOW_PRESS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.727 -0500", hash_original_field = "DA830484F6578D1FA7E355BF15F8A7E5", hash_generated_field = "4E989C39F54DC49F53402A764DC21A3E")

    private static final int LONG_PRESS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.729 -0500", hash_original_field = "D7271B71AB4CDF9866E775AD37C1D459", hash_generated_field = "5FB95885301BF4A2A2BE1CAC2FC68081")

    private static final int TAP = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.705 -0500", hash_original_field = "056F11BF795A5FEF87C68BDBA72552A1", hash_generated_field = "12BE8B5CD241157C9F0107D5273E27D1")

    private int mBiggerTouchSlopSquare = 20 * 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.708 -0500", hash_original_field = "22908E064AB773A0D025345BB08C461C", hash_generated_field = "5E5708EA89972028E86242DA050969CA")

    private int mTouchSlopSquare;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.710 -0500", hash_original_field = "D8CB968A9E00512DAFB6AA042D9A5D66", hash_generated_field = "6A78E5989D06DA4C68BA85646B379C51")

    private int mDoubleTapSlopSquare;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.712 -0500", hash_original_field = "5030B66C4E6C852287D391072C8046A5", hash_generated_field = "19DF3CA9C4A086C5604F6C8FC7721322")

    private int mMinimumFlingVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.715 -0500", hash_original_field = "3B70336BAB0F826E0E6552B2A74F553D", hash_generated_field = "7F5E59D933F0155E107640D32355B310")

    private int mMaximumFlingVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.732 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private  Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.735 -0500", hash_original_field = "1284A2585E50432ED50A1B728A817AEC", hash_generated_field = "0F48D0A94630E1FBE9C08A845F9730F2")

    private  OnGestureListener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.737 -0500", hash_original_field = "34B775570CB5DCC36FC56F21F52D5399", hash_generated_field = "6BFE5EA6164149F540DE4277F8AF3864")

    private OnDoubleTapListener mDoubleTapListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.739 -0500", hash_original_field = "FDFC64EF754B3F40601812552039B1D3", hash_generated_field = "09EA51D062ED44D2275BC8E7A65061C0")

    private boolean mStillDown;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.742 -0500", hash_original_field = "C647D9FF01927E4F18C3E915DCABE3F0", hash_generated_field = "8FA7640B36D34A443E3A43478682F7F9")

    private boolean mInLongPress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.744 -0500", hash_original_field = "C4DA5EC1C08AB3C4511D5C489877E985", hash_generated_field = "54A847320ACF73ACDAB1D622D38FE146")

    private boolean mAlwaysInTapRegion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.746 -0500", hash_original_field = "D7FEB6486753F746ABF41DB7A0F48661", hash_generated_field = "05F405D52B0F8BE7180D2A6B8335B30C")

    private boolean mAlwaysInBiggerTapRegion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.748 -0500", hash_original_field = "7A306BD5FEBB31D162FCC9CE4F00D50B", hash_generated_field = "CAFEE339D8B144D23812ECC71639FEB7")

    private MotionEvent mCurrentDownEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.750 -0500", hash_original_field = "11D60B150A81CDB1C3B9E0F59396F002", hash_generated_field = "2C9915BC9FEEE919EC1B54BA44C7E08E")

    private MotionEvent mPreviousUpEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.752 -0500", hash_original_field = "D6CD53B5B941F0F7D74F7957B18BC84D", hash_generated_field = "36A2227955369181C5427F8675061A2C")

    private boolean mIsDoubleTapping;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.754 -0500", hash_original_field = "3611C70C88BA02D959402D97DECB16F3", hash_generated_field = "2D88D85D441545A6227529A03C0B4E71")

    private float mLastMotionY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.757 -0500", hash_original_field = "AF635AE840C182EEA99A9AE862C0C835", hash_generated_field = "90F53F7625CC0EEE4DC6EBCFF5E518A6")

    private float mLastMotionX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.759 -0500", hash_original_field = "D68DA72D16EA5A899A89E6EEBF535A9F", hash_generated_field = "A200AEA4E8786AAB09346E7991B4CE6C")

    private boolean mIsLongpressEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.761 -0500", hash_original_field = "EF7E9E5596D312046F679D7BC19B9999", hash_generated_field = "2B51C50DE25129E94BCC4EA38A0389E2")

    private boolean mIgnoreMultitouch;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.763 -0500", hash_original_field = "507D8F8387EDC230B54D84A5AD8E5830", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.766 -0500", hash_original_field = "91D8782EBDEF9C65BF9D8D5A67EE9546", hash_generated_field = "69B49DB79681808A97D2CCE1BF25440C")

    private final InputEventConsistencyVerifier mInputEventConsistencyVerifier =
            InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;

    /**
     * Creates a GestureDetector with the supplied listener.
     * This variant of the constructor should be used from a non-UI thread 
     * (as it allows specifying the Handler).
     * 
     * @param listener the listener invoked for all the callbacks, this must
     * not be null.
     * @param handler the handler to use
     *
     * @throws NullPointerException if either {@code listener} or
     * {@code handler} is null.
     *
     * @deprecated Use {@link #GestureDetector(android.content.Context,
     *      android.view.GestureDetector.OnGestureListener, android.os.Handler)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.779 -0500", hash_original_method = "A860FCB0BF3B13241916CBB6D51694FF", hash_generated_method = "483A0378504B2A0BA9280087D88B032E")
    
@Deprecated
    public GestureDetector(OnGestureListener listener, Handler handler) {
        this(null, listener, handler);
    }

    /**
     * Creates a GestureDetector with the supplied listener.
     * You may only use this constructor from a UI thread (this is the usual situation).
     * @see android.os.Handler#Handler()
     * 
     * @param listener the listener invoked for all the callbacks, this must
     * not be null.
     * 
     * @throws NullPointerException if {@code listener} is null.
     *
     * @deprecated Use {@link #GestureDetector(android.content.Context,
     *      android.view.GestureDetector.OnGestureListener)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.782 -0500", hash_original_method = "6A4A0666EC699D6858654C1F91F62135", hash_generated_method = "99BD04EE9FBE8B984F91705EAEE67716")
    
@Deprecated
    public GestureDetector(OnGestureListener listener) {
        this(null, listener, null);
    }

    /**
     * Creates a GestureDetector with the supplied listener.
     * You may only use this constructor from a UI thread (this is the usual situation).
     * @see android.os.Handler#Handler()
     *
     * @param context the application's context
     * @param listener the listener invoked for all the callbacks, this must
     * not be null.
     *
     * @throws NullPointerException if {@code listener} is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.785 -0500", hash_original_method = "D6C1A078025AA71050A12C76B6AD8601", hash_generated_method = "5419B561FCBBBBCD0F236CE7EE9B24FC")
    
public GestureDetector(Context context, OnGestureListener listener) {
        this(context, listener, null);
    }

    /**
     * Creates a GestureDetector with the supplied listener.
     * You may only use this constructor from a UI thread (this is the usual situation).
     * @see android.os.Handler#Handler()
     *
     * @param context the application's context
     * @param listener the listener invoked for all the callbacks, this must
     * not be null.
     * @param handler the handler to use     
     *
     * @throws NullPointerException if {@code listener} is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.788 -0500", hash_original_method = "D04E727BBFBC862644FCD26897C3FDE9", hash_generated_method = "D8AB09B5C4D5F3E22791F8D7E0B84762")
    
public GestureDetector(Context context, OnGestureListener listener, Handler handler) {
        this(context, listener, handler, context != null &&
                context.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.FROYO);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.340 -0400", hash_original_method = "3A200FED7280634DDE54E1C354EDC878", hash_generated_method = "2ACD6CA9F5DEC57A33DA67091312F2BF")
    public  GestureDetector(Context context, OnGestureListener listener, Handler handler,
            boolean ignoreMultitouch) {
        addTaint(ignoreMultitouch);
        addTaint(context.getTaint());
        if(handler != null)        
        {
            mHandler = new GestureHandler(handler);
        } //End block
        else
        {
            mHandler = new GestureHandler();
        } //End block
        mListener = listener;
        
        listener.onDown(MotionEvent.droidsafeObtainEvent());
        listener.onFling(MotionEvent.droidsafeObtainEvent(), MotionEvent.droidsafeObtainEvent(),
                        getTaintInt(), getTaintInt());
        listener.onLongPress(MotionEvent.droidsafeObtainEvent());
        listener.onScroll(MotionEvent.droidsafeObtainEvent(), MotionEvent.droidsafeObtainEvent(),
                          getTaintFloat(), getTaintFloat());
       
        listener.onShowPress(MotionEvent.droidsafeObtainEvent());
        listener.onSingleTapUp(MotionEvent.droidsafeObtainEvent());
        
        if(listener instanceof OnDoubleTapListener)        
        {
            setOnDoubleTapListener((OnDoubleTapListener) listener);
        } //End block
        init(context, ignoreMultitouch);

        // ---------- Original Method ----------
        //if (handler != null) {
            //mHandler = new GestureHandler(handler);
        //} else {
            //mHandler = new GestureHandler();
        //}
        //mListener = listener;
        //if (listener instanceof OnDoubleTapListener) {
            //setOnDoubleTapListener((OnDoubleTapListener) listener);
        //}
        //init(context, ignoreMultitouch);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.793 -0500", hash_original_method = "452594061FCEBDDF878D27E65F4EBA07", hash_generated_method = "29A2551A3E7034A3CD54CE8556A96781")
    
private void init(Context context, boolean ignoreMultitouch) {
        if (mListener == null) {
            throw new NullPointerException("OnGestureListener must not be null");
        }
        mIsLongpressEnabled = true;
        mIgnoreMultitouch = ignoreMultitouch;

        // Fallback to support pre-donuts releases
        int touchSlop, doubleTapSlop;
        if (context == null) {
            //noinspection deprecation
            touchSlop = ViewConfiguration.getTouchSlop();
            doubleTapSlop = ViewConfiguration.getDoubleTapSlop();
            //noinspection deprecation
            mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
            mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
        } else {
            final ViewConfiguration configuration = ViewConfiguration.get(context);
            touchSlop = configuration.getScaledTouchSlop();
            doubleTapSlop = configuration.getScaledDoubleTapSlop();
            mMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
            mMaximumFlingVelocity = configuration.getScaledMaximumFlingVelocity();
        }
        mTouchSlopSquare = touchSlop * touchSlop;
        mDoubleTapSlopSquare = doubleTapSlop * doubleTapSlop;
    }
        
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.342 -0400", hash_original_method = "571B39F87736E3994F3A317209D7E1C6", hash_generated_method = "8874C66605DB2FF6FE5F0E858C5BB080")
    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        mDoubleTapListener = onDoubleTapListener;
        
        onDoubleTapListener.onDoubleTap(MotionEvent.droidsafeObtainEvent());
        onDoubleTapListener.onDoubleTapEvent(MotionEvent.droidsafeObtainEvent());
        onDoubleTapListener.onSingleTapConfirmed(MotionEvent.droidsafeObtainEvent());
        // ---------- Original Method ----------
        //mDoubleTapListener = onDoubleTapListener;
    }
    
    public static class SimpleOnGestureListener implements OnGestureListener, OnDoubleTapListener {
        
        @DSComment("potential callback called inside method")
        @DSSpec(DSCat.TO_MODEL)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.349 -0400", hash_original_method = "6EE8AB65667171335D0E5E557D623FF3", hash_generated_method = "6EE8AB65667171335D0E5E557D623FF3")
        public SimpleOnGestureListener ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.681 -0500", hash_original_method = "6CD5191C407A0B3CBB6F0A0F3D91B6D6", hash_generated_method = "F1C17BECC5417032DE6EA8755F8D44C0")
        
public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @DSComment("normal android callback")
        @DSSafe(DSCat.ANDROID_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.684 -0500", hash_original_method = "E609FB951BEBFF493B5A5F179A09A7F5", hash_generated_method = "1427813CB8FD0FECD33CD789FA773A1E")
        
public void onLongPress(MotionEvent e) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.687 -0500", hash_original_method = "3D0A16086A925B93F4340895FE1B4CBC", hash_generated_method = "94A5CDB9EEDB8388B6F46AFEF8AC63B4")
        
public boolean onScroll(MotionEvent e1, MotionEvent e2,
                float distanceX, float distanceY) {
            return false;
        }

        @DSComment("normal android callback")
        @DSSafe(DSCat.ANDROID_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.690 -0500", hash_original_method = "BDBE517451C02C6DD8B1C60030C3C43A", hash_generated_method = "A7CC59BCECD4BCD630D07EC7C1E9E0D4")
        
public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                float velocityY) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.692 -0500", hash_original_method = "54A2BF3809B435C5302401FC76B54B22", hash_generated_method = "6513E9F2A0B7FC94EDB3BBA119443F8C")
        
public void onShowPress(MotionEvent e) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.694 -0500", hash_original_method = "124BA11CC014942E61EFD87F7F37262C", hash_generated_method = "B3A81FAA49F630EF27C6AFFA59CBE49F")
        
public boolean onDown(MotionEvent e) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.697 -0500", hash_original_method = "40BA7E2512EA076BF84D5B49A825B220", hash_generated_method = "8D5435A7FB257A64E64A837E55DABCF5")
        
public boolean onDoubleTap(MotionEvent e) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.699 -0500", hash_original_method = "D3FAA1FBAE0BE329BB5AEDA3CD619E7D", hash_generated_method = "F2909936AC699A2498E3CC3AD78BCEDB")
        
public boolean onDoubleTapEvent(MotionEvent e) {
            return false;
        }

        @DSComment("normal android callback")
        @DSSafe(DSCat.ANDROID_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.701 -0500", hash_original_method = "5E9F34FF920329D07D248580C4BBB180", hash_generated_method = "8A1688630F94AC9659A2A1B9905B0947")
        
public boolean onSingleTapConfirmed(MotionEvent e) {
            return false;
        }
        
    }
    
    private class GestureHandler extends Handler {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.769 -0500", hash_original_method = "9D2431BB2A48CA4B74BDD0A31919D26A", hash_generated_method = "9D2431BB2A48CA4B74BDD0A31919D26A")
        
GestureHandler() {
            super();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.771 -0500", hash_original_method = "EA154705C095D614E912EA5301C442EC", hash_generated_method = "EA154705C095D614E912EA5301C442EC")
        
GestureHandler(Handler handler) {
            super(handler.getLooper());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.774 -0500", hash_original_method = "B97857986444DBB6880EA006296E5D03", hash_generated_method = "B97F6FF383B743F8B003FC1DC3D263B5")
        
@Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case SHOW_PRESS:
                mListener.onShowPress(mCurrentDownEvent);
                break;
                
            case LONG_PRESS:
                dispatchLongPress();
                break;
                
            case TAP:
                // If the user's finger is still down, do not count it as a tap
                if (mDoubleTapListener != null && !mStillDown) {
                    mDoubleTapListener.onSingleTapConfirmed(mCurrentDownEvent);
                }
                break;

            default:
                throw new RuntimeException("Unknown message " + msg); //never
            }
        }
        
    }
    
    public interface OnGestureListener {
        
        boolean onDown(MotionEvent e);
        
        void onShowPress(MotionEvent e);
        
        boolean onSingleTapUp(MotionEvent e);
        
        boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY);
        
        void onLongPress(MotionEvent e);
        
        boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY);
    }
    
    public interface OnDoubleTapListener {
        
        boolean onSingleTapConfirmed(MotionEvent e);
        
        boolean onDoubleTap(MotionEvent e);
        
        boolean onDoubleTapEvent(MotionEvent e);
    }

    /**
     * Set whether longpress is enabled, if this is enabled when a user
     * presses and holds down you get a longpress event and nothing further.
     * If it's disabled the user can press and hold down and then later
     * moved their finger and you will get scroll events. By default
     * longpress is enabled.
     *
     * @param isLongpressEnabled whether longpress should be enabled.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.797 -0500", hash_original_method = "14829325F18703625EF98BC2472601E3", hash_generated_method = "51336A8A06442CD62CB3C2FE846AC26F")
    
public void setIsLongpressEnabled(boolean isLongpressEnabled) {
        mIsLongpressEnabled = isLongpressEnabled;
    }

    /**
     * @return true if longpress is enabled, else false.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.800 -0500", hash_original_method = "880D3BB55D8069819877BA46CC6F055B", hash_generated_method = "66E0EA8C34A58B1875D8A044AC247580")
    
public boolean isLongpressEnabled() {
        return mIsLongpressEnabled;
    }

    /**
     * Analyzes the given motion event and if applicable triggers the
     * appropriate callbacks on the {@link OnGestureListener} supplied.
     *
     * @param ev The current motion event.
     * @return true if the {@link OnGestureListener} consumed the event,
     *              else false.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.805 -0500", hash_original_method = "83C7BED09A17CDEA8B0FB9700395D72F", hash_generated_method = "E33AC3F11292615C5E27A92B5D08A42F")
    
public boolean onTouchEvent(MotionEvent ev) {
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onTouchEvent(ev, 0);
        }

        final int action = ev.getAction();
        final float y = ev.getY();
        final float x = ev.getX();

        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(ev);

        boolean handled = false;

        switch (action & MotionEvent.ACTION_MASK) {
        case MotionEvent.ACTION_POINTER_DOWN:
            if (mIgnoreMultitouch) {
                // Multitouch event - abort.
                cancel();
            }
            break;

        case MotionEvent.ACTION_POINTER_UP:
            // Ending a multitouch gesture and going back to 1 finger
            if (mIgnoreMultitouch && ev.getPointerCount() == 2) {
                int index = (((action & MotionEvent.ACTION_POINTER_INDEX_MASK)
                        >> MotionEvent.ACTION_POINTER_INDEX_SHIFT) == 0) ? 1 : 0;
                mLastMotionX = ev.getX(index);
                mLastMotionY = ev.getY(index);
                mVelocityTracker.recycle();
                mVelocityTracker = VelocityTracker.obtain();
            }
            break;

        case MotionEvent.ACTION_DOWN:
            if (mDoubleTapListener != null) {
                boolean hadTapMessage = mHandler.hasMessages(TAP);
                if (hadTapMessage) mHandler.removeMessages(TAP);
                if ((mCurrentDownEvent != null) && (mPreviousUpEvent != null) && hadTapMessage &&
                        isConsideredDoubleTap(mCurrentDownEvent, mPreviousUpEvent, ev)) {
                    // This is a second tap
                    mIsDoubleTapping = true;
                    // Give a callback with the first tap of the double-tap
                    handled |= mDoubleTapListener.onDoubleTap(mCurrentDownEvent);
                    // Give a callback with down event of the double-tap
                    handled |= mDoubleTapListener.onDoubleTapEvent(ev);
                } else {
                    // This is a first tap
                    mHandler.sendEmptyMessageDelayed(TAP, DOUBLE_TAP_TIMEOUT);
                }
            }

            mLastMotionX = x;
            mLastMotionY = y;
            if (mCurrentDownEvent != null) {
                mCurrentDownEvent.recycle();
            }
            mCurrentDownEvent = MotionEvent.obtain(ev);
            mAlwaysInTapRegion = true;
            mAlwaysInBiggerTapRegion = true;
            mStillDown = true;
            mInLongPress = false;
            
            if (mIsLongpressEnabled) {
                mHandler.removeMessages(LONG_PRESS);
                mHandler.sendEmptyMessageAtTime(LONG_PRESS, mCurrentDownEvent.getDownTime()
                        + TAP_TIMEOUT + LONGPRESS_TIMEOUT);
            }
            mHandler.sendEmptyMessageAtTime(SHOW_PRESS, mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
            handled |= mListener.onDown(ev);
            break;

        case MotionEvent.ACTION_MOVE:
            if (mInLongPress || (mIgnoreMultitouch && ev.getPointerCount() > 1)) {
                break;
            }
            final float scrollX = mLastMotionX - x;
            final float scrollY = mLastMotionY - y;
            if (mIsDoubleTapping) {
                // Give the move events of the double-tap
                handled |= mDoubleTapListener.onDoubleTapEvent(ev);
            } else if (mAlwaysInTapRegion) {
                final int deltaX = (int) (x - mCurrentDownEvent.getX());
                final int deltaY = (int) (y - mCurrentDownEvent.getY());
                int distance = (deltaX * deltaX) + (deltaY * deltaY);
                if (distance > mTouchSlopSquare) {
                    handled = mListener.onScroll(mCurrentDownEvent, ev, scrollX, scrollY);
                    mLastMotionX = x;
                    mLastMotionY = y;
                    mAlwaysInTapRegion = false;
                    mHandler.removeMessages(TAP);
                    mHandler.removeMessages(SHOW_PRESS);
                    mHandler.removeMessages(LONG_PRESS);
                }
                if (distance > mBiggerTouchSlopSquare) {
                    mAlwaysInBiggerTapRegion = false;
                }
            } else if ((Math.abs(scrollX) >= 1) || (Math.abs(scrollY) >= 1)) {
                handled = mListener.onScroll(mCurrentDownEvent, ev, scrollX, scrollY);
                mLastMotionX = x;
                mLastMotionY = y;
            }
            break;

        case MotionEvent.ACTION_UP:
            mStillDown = false;
            MotionEvent currentUpEvent = MotionEvent.obtain(ev);
            if (mIsDoubleTapping) {
                // Finally, give the up event of the double-tap
                handled |= mDoubleTapListener.onDoubleTapEvent(ev);
            } else if (mInLongPress) {
                mHandler.removeMessages(TAP);
                mInLongPress = false;
            } else if (mAlwaysInTapRegion) {
                handled = mListener.onSingleTapUp(ev);
            } else {

                // A fling must travel the minimum tap distance
                final VelocityTracker velocityTracker = mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
                final float velocityY = velocityTracker.getYVelocity();
                final float velocityX = velocityTracker.getXVelocity();

                if ((Math.abs(velocityY) > mMinimumFlingVelocity)
                        || (Math.abs(velocityX) > mMinimumFlingVelocity)){
                    handled = mListener.onFling(mCurrentDownEvent, ev, velocityX, velocityY);
                }
            }
            if (mPreviousUpEvent != null) {
                mPreviousUpEvent.recycle();
            }
            // Hold the event we obtained above - listeners may have changed the original.
            mPreviousUpEvent = currentUpEvent;
            mVelocityTracker.recycle();
            mVelocityTracker = null;
            mIsDoubleTapping = false;
            mHandler.removeMessages(SHOW_PRESS);
            mHandler.removeMessages(LONG_PRESS);
            break;

        case MotionEvent.ACTION_CANCEL:
            cancel();
            break;
        }

        if (!handled && mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onUnhandledEvent(ev, 0);
        }
        return handled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.808 -0500", hash_original_method = "9B9F1964085C6E9CB79BA6CBFD2B9081", hash_generated_method = "C5A172A598ACA3A87A4925C4C503E659")
    
private void cancel() {
        mHandler.removeMessages(SHOW_PRESS);
        mHandler.removeMessages(LONG_PRESS);
        mHandler.removeMessages(TAP);
        mVelocityTracker.recycle();
        mVelocityTracker = null;
        mIsDoubleTapping = false;
        mStillDown = false;
        mAlwaysInTapRegion = false;
        mAlwaysInBiggerTapRegion = false;
        if (mInLongPress) {
            mInLongPress = false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.811 -0500", hash_original_method = "EA18A75BD47C1C65D8FE280884C192C1", hash_generated_method = "350379EFD91AC9A9AC3665FE74AB5D18")
    
private boolean isConsideredDoubleTap(MotionEvent firstDown, MotionEvent firstUp,
            MotionEvent secondDown) {
        if (!mAlwaysInBiggerTapRegion) {
            return false;
        }

        if (secondDown.getEventTime() - firstUp.getEventTime() > DOUBLE_TAP_TIMEOUT) {
            return false;
        }

        int deltaX = (int) firstDown.getX() - (int) secondDown.getX();
        int deltaY = (int) firstDown.getY() - (int) secondDown.getY();
        return (deltaX * deltaX + deltaY * deltaY < mDoubleTapSlopSquare);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:03.813 -0500", hash_original_method = "1B110E72A2C7F37DAF94A595462A9E07", hash_generated_method = "5605DFE52E2DFD6F15B82DC5FFE09AED")
    
private void dispatchLongPress() {
        mHandler.removeMessages(TAP);
        mInLongPress = true;
        mListener.onLongPress(mCurrentDownEvent);
    }
}

