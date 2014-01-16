package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.FloatMath;

public class ScaleGestureDetector {

    /**
     * MotionEvent has no getRawX(int) method; simulate it pending future API approval.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.632 -0500", hash_original_method = "1C74B9CEBA7069C1C46FE5AC2377DD74", hash_generated_method = "9F535709078E10633F597DAC5E474805")
    
private static float getRawX(MotionEvent event, int pointerIndex) {
        if (pointerIndex < 0) return Float.MIN_VALUE;
        if (pointerIndex == 0) return event.getRawX();
        float offset = event.getRawX() - event.getX();
        return event.getX(pointerIndex) + offset;
    }

    /**
     * MotionEvent has no getRawY(int) method; simulate it pending future API approval.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.635 -0500", hash_original_method = "E9D933E20849778B1DB8C91D44A0DC56", hash_generated_method = "F03B96929C9C0CCA5FAA5D104052F336")
    
private static float getRawY(MotionEvent event, int pointerIndex) {
        if (pointerIndex < 0) return Float.MIN_VALUE;
        if (pointerIndex == 0) return event.getRawY();
        float offset = event.getRawY() - event.getY();
        return event.getY(pointerIndex) + offset;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.540 -0500", hash_original_field = "331FAAD620AC9265B21867D644F5430D", hash_generated_field = "4649FA3572602ADAEA386A657BBBCE55")

    private static final String TAG = "ScaleGestureDetector";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.555 -0500", hash_original_field = "9C4324BCE05687C3ED02592173562D2E", hash_generated_field = "1E49C39436E310C8A58BEAD71FF9190C")

    private static final float PRESSURE_THRESHOLD = 0.67f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.557 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.560 -0500", hash_original_field = "3F9C288FC21567876B56BAC69B9C34B8", hash_generated_field = "A08AF84037A8352C0A5AC97B5C4711DA")

    private  OnScaleGestureListener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.562 -0500", hash_original_field = "7B8F1FCB6755EB9F4128F6C80C41E76B", hash_generated_field = "503643741A4ED297FCB738F860325A5C")

    private boolean mGestureInProgress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.564 -0500", hash_original_field = "4B8A42063191A4133FB9114EC0E506C0", hash_generated_field = "3C7A422FE0E65BBDCD9090B91410FF41")

    private MotionEvent mPrevEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.567 -0500", hash_original_field = "8A847D642C38B926624E7F00D555AF79", hash_generated_field = "D61C81DE46CCD592C64D38B586C58E19")

    private MotionEvent mCurrEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.569 -0500", hash_original_field = "94A353B58E248D99854FB0B964DBEA35", hash_generated_field = "9E3ECCCE67853EF67D401BC85D54FCDD")

    private float mFocusX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.571 -0500", hash_original_field = "C5B54888D0BE6CAF4CFCD322A758FD24", hash_generated_field = "E01C42CAE2152A2827127C5E1618E0BF")

    private float mFocusY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.573 -0500", hash_original_field = "6A2E606F16606BEBBBD563985785B425", hash_generated_field = "9B5A74F081F5922B1785428D638AF7EB")

    private float mPrevFingerDiffX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.576 -0500", hash_original_field = "1CD2B9268AF4FD344C0A40D06A0B41F6", hash_generated_field = "A4ECFDC00DFED0488AC11C35F6454D1A")

    private float mPrevFingerDiffY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.578 -0500", hash_original_field = "720D2D06E2FA012FBA5AEE0A603ACCF2", hash_generated_field = "0084D8F5F5AEBC86A46E65C48DD6EDDA")

    private float mCurrFingerDiffX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.581 -0500", hash_original_field = "AA1A093EF49345E40EF3200E72F0BA11", hash_generated_field = "F58F567C97D8A5647C27000A75D3AF16")

    private float mCurrFingerDiffY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.583 -0500", hash_original_field = "F5488CDB40B0CEC78627A4C4216BC323", hash_generated_field = "933BC37DA68F2A67EB299CEE160CB2FB")

    private float mCurrLen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.586 -0500", hash_original_field = "656063DB55272F5CDDB664F6308EA24D", hash_generated_field = "1E334C6DA5FA5EB33F386FAD0E8F6E8B")

    private float mPrevLen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.588 -0500", hash_original_field = "8A96B400B2B68DBF7A24CC8C2559781A", hash_generated_field = "A57936439C19DE90F2AB86ED42237D31")

    private float mScaleFactor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.590 -0500", hash_original_field = "AF0D7C0AE11B112217FD68FBDF0169BB", hash_generated_field = "4CF3DF6E70478D8056347848EFB18503")

    private float mCurrPressure;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.592 -0500", hash_original_field = "067AB454DC6546BF0AAE09FED310C1C4", hash_generated_field = "2E7516100A12B928A7F1D7C2C6815166")

    private float mPrevPressure;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.594 -0500", hash_original_field = "491ED61B5F60945314E800AA8C3F920A", hash_generated_field = "24C21D8C9544B70EF997F0DEE65D3C96")

    private long mTimeDelta;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.597 -0500", hash_original_field = "DE07563BC74B44DF2762265E237775A0", hash_generated_field = "87E1CD70AA880AA0038E22EA3C795791")

    private  float mEdgeSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.599 -0500", hash_original_field = "9E5157F61681DC41BED18235E2C2204F", hash_generated_field = "B70D199FA23802CA3820F738CE6BECA4")

    private float mRightSlopEdge;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.601 -0500", hash_original_field = "F2C3FFABC6DD5CF680D9CFA9489D3CCA", hash_generated_field = "875320F67CC4A12055E0E780DF25AC3E")

    private float mBottomSlopEdge;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.604 -0500", hash_original_field = "DD750ED63B618F89F0E77CC92C9092A1", hash_generated_field = "F35E4D613A73F5F87B9D2DA4EE86D79A")

    private boolean mSloppyGesture;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.606 -0500", hash_original_field = "B6F9669B99FFE1AA1420470702A25CD8", hash_generated_field = "D40C9FA5D0FB38FD10587BC7707BC6F3")

    private boolean mInvalidGesture;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.608 -0500", hash_original_field = "147B62ECF05DEB187E31C8B7B71FD38B", hash_generated_field = "5955F7D0EA4751A3620710E99C5064B8")

    private int mActiveId0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.610 -0500", hash_original_field = "3F16BBC27057A508129F78057C21D522", hash_generated_field = "6F4F186E958896A650E911389B88CCC0")

    private int mActiveId1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.613 -0500", hash_original_field = "4C5A26BE170ACACBA61C57BDCB2A51FD", hash_generated_field = "78AA2DF7FA2FB872FE42414156BB2883")

    private boolean mActive0MostRecent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.615 -0500", hash_original_field = "91D8782EBDEF9C65BF9D8D5A67EE9546", hash_generated_field = "69B49DB79681808A97D2CCE1BF25440C")

    private final InputEventConsistencyVerifier mInputEventConsistencyVerifier =
            InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.618 -0500", hash_original_method = "3F765CE5C3F1587A362200597A84993F", hash_generated_method = "217CEF97C4071E1B88932ECA3337007E")
    
public ScaleGestureDetector(Context context, OnScaleGestureListener listener) {
        ViewConfiguration config = ViewConfiguration.get(context);
        mContext = context;
        mListener = listener;
        mEdgeSlop = config.getScaledEdgeSlop();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.626 -0500", hash_original_method = "3D0907AC17DE553CA8E37D6A8A0F580A", hash_generated_method = "2899A9CAEC2BB20FA674AFA1FFAB3F59")
    
public boolean onTouchEvent(MotionEvent event) {
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onTouchEvent(event, 0);
        }

        final int action = event.getActionMasked();

        if (action == MotionEvent.ACTION_DOWN) {
            reset(); // Start fresh
        }

        boolean handled = true;
        if (mInvalidGesture) {
            handled = false;
        } else if (!mGestureInProgress) {
            switch (action) {
            case MotionEvent.ACTION_DOWN: {
                mActiveId0 = event.getPointerId(0);
                mActive0MostRecent = true;
            }
            break;

            case MotionEvent.ACTION_UP:
                reset();
                break;

            case MotionEvent.ACTION_POINTER_DOWN: {
                // We have a new multi-finger gesture

                // as orientation can change, query the metrics in touch down
                DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
                mRightSlopEdge = metrics.widthPixels - mEdgeSlop;
                mBottomSlopEdge = metrics.heightPixels - mEdgeSlop;

                if (mPrevEvent != null) mPrevEvent.recycle();
                mPrevEvent = MotionEvent.obtain(event);
                mTimeDelta = 0;

                int index1 = event.getActionIndex();
                int index0 = event.findPointerIndex(mActiveId0);
                mActiveId1 = event.getPointerId(index1);
                if (index0 < 0 || index0 == index1) {
                    // Probably someone sending us a broken event stream.
                    index0 = findNewActiveIndex(event, index0 == index1 ? -1 : mActiveId1, index0);
                    mActiveId0 = event.getPointerId(index0);
                }
                mActive0MostRecent = false;

                setContext(event);

                // Check if we have a sloppy gesture. If so, delay
                // the beginning of the gesture until we're sure that's
                // what the user wanted. Sloppy gestures can happen if the
                // edge of the user's hand is touching the screen, for example.
                final float edgeSlop = mEdgeSlop;
                final float rightSlop = mRightSlopEdge;
                final float bottomSlop = mBottomSlopEdge;
                float x0 = getRawX(event, index0);
                float y0 = getRawY(event, index0);
                float x1 = getRawX(event, index1);
                float y1 = getRawY(event, index1);

                boolean p0sloppy = x0 < edgeSlop || y0 < edgeSlop
                        || x0 > rightSlop || y0 > bottomSlop;
                boolean p1sloppy = x1 < edgeSlop || y1 < edgeSlop
                        || x1 > rightSlop || y1 > bottomSlop;

                if (p0sloppy && p1sloppy) {
                    mFocusX = -1;
                    mFocusY = -1;
                    mSloppyGesture = true;
                } else if (p0sloppy) {
                    mFocusX = event.getX(index1);
                    mFocusY = event.getY(index1);
                    mSloppyGesture = true;
                } else if (p1sloppy) {
                    mFocusX = event.getX(index0);
                    mFocusY = event.getY(index0);
                    mSloppyGesture = true;
                } else {
                    mSloppyGesture = false;
                    mGestureInProgress = mListener.onScaleBegin(this);
                }
            }
            break;

            case MotionEvent.ACTION_MOVE:
                if (mSloppyGesture) {
                    // Initiate sloppy gestures if we've moved outside of the slop area.
                    final float edgeSlop = mEdgeSlop;
                    final float rightSlop = mRightSlopEdge;
                    final float bottomSlop = mBottomSlopEdge;
                    int index0 = event.findPointerIndex(mActiveId0);
                    int index1 = event.findPointerIndex(mActiveId1);

                    float x0 = getRawX(event, index0);
                    float y0 = getRawY(event, index0);
                    float x1 = getRawX(event, index1);
                    float y1 = getRawY(event, index1);

                    boolean p0sloppy = x0 < edgeSlop || y0 < edgeSlop
                            || x0 > rightSlop || y0 > bottomSlop;
                    boolean p1sloppy = x1 < edgeSlop || y1 < edgeSlop
                            || x1 > rightSlop || y1 > bottomSlop;

                    if (p0sloppy) {
                        // Do we have a different pointer that isn't sloppy?
                        int index = findNewActiveIndex(event, mActiveId1, index0);
                        if (index >= 0) {
                            index0 = index;
                            mActiveId0 = event.getPointerId(index);
                            x0 = getRawX(event, index);
                            y0 = getRawY(event, index);
                            p0sloppy = false;
                        }
                    }

                    if (p1sloppy) {
                        // Do we have a different pointer that isn't sloppy?
                        int index = findNewActiveIndex(event, mActiveId0, index1);
                        if (index >= 0) {
                            index1 = index;
                            mActiveId1 = event.getPointerId(index);
                            x1 = getRawX(event, index);
                            y1 = getRawY(event, index);
                            p1sloppy = false;
                        }
                    }

                    if(p0sloppy && p1sloppy) {
                        mFocusX = -1;
                        mFocusY = -1;
                    } else if (p0sloppy) {
                        mFocusX = event.getX(index1);
                        mFocusY = event.getY(index1);
                    } else if (p1sloppy) {
                        mFocusX = event.getX(index0);
                        mFocusY = event.getY(index0);
                    } else {
                        mSloppyGesture = false;
                        mGestureInProgress = mListener.onScaleBegin(this);
                    }
                }
                break;

            case MotionEvent.ACTION_POINTER_UP:
                if (mSloppyGesture) {
                    final int pointerCount = event.getPointerCount();
                    final int actionIndex = event.getActionIndex();
                    final int actionId = event.getPointerId(actionIndex);

                    if (pointerCount > 2) {
                        if (actionId == mActiveId0) {
                            final int newIndex = findNewActiveIndex(event, mActiveId1, actionIndex);
                            if (newIndex >= 0) mActiveId0 = event.getPointerId(newIndex);
                        } else if (actionId == mActiveId1) {
                            final int newIndex = findNewActiveIndex(event, mActiveId0, actionIndex);
                            if (newIndex >= 0) mActiveId1 = event.getPointerId(newIndex);
                        }
                    } else {
                        // Set focus point to the remaining finger
                        final int index = event.findPointerIndex(actionId == mActiveId0 ?
                                mActiveId1 : mActiveId0);
                        if (index < 0) {
                            mInvalidGesture = true;
                            Log.e(TAG, "Invalid MotionEvent stream detected.", new Throwable());
                            if (mGestureInProgress) {
                                mListener.onScaleEnd(this);
                            }
                            return false;
                        }

                        mActiveId0 = event.getPointerId(index);

                        mActive0MostRecent = true;
                        mActiveId1 = -1;
                        mFocusX = event.getX(index);
                        mFocusY = event.getY(index);
                    }
                }
                break;
            }
        } else {
            // Transform gesture in progress - attempt to handle it
            switch (action) {
                case MotionEvent.ACTION_POINTER_DOWN: {
                    // End the old gesture and begin a new one with the most recent two fingers.
                    mListener.onScaleEnd(this);
                    final int oldActive0 = mActiveId0;
                    final int oldActive1 = mActiveId1;
                    reset();

                    mPrevEvent = MotionEvent.obtain(event);
                    mActiveId0 = mActive0MostRecent ? oldActive0 : oldActive1;
                    mActiveId1 = event.getPointerId(event.getActionIndex());
                    mActive0MostRecent = false;

                    int index0 = event.findPointerIndex(mActiveId0);
                    if (index0 < 0 || mActiveId0 == mActiveId1) {
                        // Probably someone sending us a broken event stream.
                        Log.e(TAG, "Got " + MotionEvent.actionToString(action) +
                                " with bad state while a gesture was in progress. " +
                                "Did you forget to pass an event to " +
                                "ScaleGestureDetector#onTouchEvent?");
                        index0 = findNewActiveIndex(event,
                                mActiveId0 == mActiveId1 ? -1 : mActiveId1, index0);
                        mActiveId0 = event.getPointerId(index0);
                    }

                    setContext(event);

                    mGestureInProgress = mListener.onScaleBegin(this);
                }
                break;

                case MotionEvent.ACTION_POINTER_UP: {
                    final int pointerCount = event.getPointerCount();
                    final int actionIndex = event.getActionIndex();
                    final int actionId = event.getPointerId(actionIndex);

                    boolean gestureEnded = false;
                    if (pointerCount > 2) {
                        if (actionId == mActiveId0) {
                            final int newIndex = findNewActiveIndex(event, mActiveId1, actionIndex);
                            if (newIndex >= 0) {
                                mListener.onScaleEnd(this);
                                mActiveId0 = event.getPointerId(newIndex);
                                mActive0MostRecent = true;
                                mPrevEvent = MotionEvent.obtain(event);
                                setContext(event);
                                mGestureInProgress = mListener.onScaleBegin(this);
                            } else {
                                gestureEnded = true;
                            }
                        } else if (actionId == mActiveId1) {
                            final int newIndex = findNewActiveIndex(event, mActiveId0, actionIndex);
                            if (newIndex >= 0) {
                                mListener.onScaleEnd(this);
                                mActiveId1 = event.getPointerId(newIndex);
                                mActive0MostRecent = false;
                                mPrevEvent = MotionEvent.obtain(event);
                                setContext(event);
                                mGestureInProgress = mListener.onScaleBegin(this);
                            } else {
                                gestureEnded = true;
                            }
                        }
                        mPrevEvent.recycle();
                        mPrevEvent = MotionEvent.obtain(event);
                        setContext(event);
                    } else {
                        gestureEnded = true;
                    }

                    if (gestureEnded) {
                        // Gesture ended
                        setContext(event);

                        // Set focus point to the remaining finger
                        final int activeId = actionId == mActiveId0 ? mActiveId1 : mActiveId0;
                        final int index = event.findPointerIndex(activeId);
                        mFocusX = event.getX(index);
                        mFocusY = event.getY(index);

                        mListener.onScaleEnd(this);
                        reset();
                        mActiveId0 = activeId;
                        mActive0MostRecent = true;
                    }
                }
                break;

                case MotionEvent.ACTION_CANCEL:
                    mListener.onScaleEnd(this);
                    reset();
                    break;

                case MotionEvent.ACTION_UP:
                    reset();
                    break;

                case MotionEvent.ACTION_MOVE: {
                    setContext(event);

                    // Only accept the event if our relative pressure is within
                    // a certain limit - this can help filter shaky data as a
                    // finger is lifted.
                    if (mCurrPressure / mPrevPressure > PRESSURE_THRESHOLD) {
                        final boolean updatePrevious = mListener.onScale(this);

                        if (updatePrevious) {
                            mPrevEvent.recycle();
                            mPrevEvent = MotionEvent.obtain(event);
                        }
                    }
                }
                break;
            }
        }

        if (!handled && mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        }
        return handled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.629 -0500", hash_original_method = "26EE043A8FDD34A9021E8F106FD508B5", hash_generated_method = "EF1EA35B0066A0E9C3683A21C34593BE")
    
private int findNewActiveIndex(MotionEvent ev, int otherActiveId, int oldIndex) {
        final int pointerCount = ev.getPointerCount();

        // It's ok if this isn't found and returns -1, it simply won't match.
        final int otherActiveIndex = ev.findPointerIndex(otherActiveId);
        int newActiveIndex = -1;

        // Pick a new id and update tracking state. Only pick pointers not on the slop edges.
        for (int i = 0; i < pointerCount; i++) {
            if (i != oldIndex && i != otherActiveIndex) {
                final float edgeSlop = mEdgeSlop;
                final float rightSlop = mRightSlopEdge;
                final float bottomSlop = mBottomSlopEdge;
                float x = getRawX(ev, i);
                float y = getRawY(ev, i);
                if (x >= edgeSlop && y >= edgeSlop && x <= rightSlop && y <= bottomSlop) {
                    newActiveIndex = i;
                    break;
                }
            }
        }

        return newActiveIndex;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.638 -0500", hash_original_method = "E851AC8F08388EEFFE10C17212886186", hash_generated_method = "7A8ABF540AAF47F5874C72CC582870AF")
    
private void setContext(MotionEvent curr) {
        if (mCurrEvent != null) {
            mCurrEvent.recycle();
        }
        mCurrEvent = MotionEvent.obtain(curr);

        mCurrLen = -1;
        mPrevLen = -1;
        mScaleFactor = -1;

        final MotionEvent prev = mPrevEvent;

        final int prevIndex0 = prev.findPointerIndex(mActiveId0);
        final int prevIndex1 = prev.findPointerIndex(mActiveId1);
        final int currIndex0 = curr.findPointerIndex(mActiveId0);
        final int currIndex1 = curr.findPointerIndex(mActiveId1);

        if (prevIndex0 < 0 || prevIndex1 < 0 || currIndex0 < 0 || currIndex1 < 0) {
            mInvalidGesture = true;
            Log.e(TAG, "Invalid MotionEvent stream detected.", new Throwable());
            if (mGestureInProgress) {
                mListener.onScaleEnd(this);
            }
            return;
        }

        final float px0 = prev.getX(prevIndex0);
        final float py0 = prev.getY(prevIndex0);
        final float px1 = prev.getX(prevIndex1);
        final float py1 = prev.getY(prevIndex1);
        final float cx0 = curr.getX(currIndex0);
        final float cy0 = curr.getY(currIndex0);
        final float cx1 = curr.getX(currIndex1);
        final float cy1 = curr.getY(currIndex1);

        final float pvx = px1 - px0;
        final float pvy = py1 - py0;
        final float cvx = cx1 - cx0;
        final float cvy = cy1 - cy0;
        mPrevFingerDiffX = pvx;
        mPrevFingerDiffY = pvy;
        mCurrFingerDiffX = cvx;
        mCurrFingerDiffY = cvy;

        mFocusX = cx0 + cvx * 0.5f;
        mFocusY = cy0 + cvy * 0.5f;
        mTimeDelta = curr.getEventTime() - prev.getEventTime();
        mCurrPressure = curr.getPressure(currIndex0) + curr.getPressure(currIndex1);
        mPrevPressure = prev.getPressure(prevIndex0) + prev.getPressure(prevIndex1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.641 -0500", hash_original_method = "F9E5E3809E5750745599790F573B8504", hash_generated_method = "C3F79E6854FF5192D6DB4BF6DB9FE0CB")
    
private void reset() {
        if (mPrevEvent != null) {
            mPrevEvent.recycle();
            mPrevEvent = null;
        }
        if (mCurrEvent != null) {
            mCurrEvent.recycle();
            mCurrEvent = null;
        }
        mSloppyGesture = false;
        mGestureInProgress = false;
        mActiveId0 = -1;
        mActiveId1 = -1;
        mInvalidGesture = false;
    }

    /**
     * Returns {@code true} if a two-finger scale gesture is in progress.
     * @return {@code true} if a scale gesture is in progress, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.644 -0500", hash_original_method = "898B0555390D80294F48D1832D7CA7F1", hash_generated_method = "BD723F8FD46CAFFB70BE1C28FB61A544")
    
public boolean isInProgress() {
        return mGestureInProgress;
    }

    /**
     * Get the X coordinate of the current gesture's focal point.
     * If a gesture is in progress, the focal point is directly between
     * the two pointers forming the gesture.
     * If a gesture is ending, the focal point is the location of the
     * remaining pointer on the screen.
     * If {@link #isInProgress()} would return false, the result of this
     * function is undefined.
     *
     * @return X coordinate of the focal point in pixels.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.646 -0500", hash_original_method = "5AA73E7030B433A4A506EA714645F254", hash_generated_method = "874F5478AF4E1A1071A9C4A3A37AE4B7")
    
public float getFocusX() {
        return mFocusX;
    }

    /**
     * Get the Y coordinate of the current gesture's focal point.
     * If a gesture is in progress, the focal point is directly between
     * the two pointers forming the gesture.
     * If a gesture is ending, the focal point is the location of the
     * remaining pointer on the screen.
     * If {@link #isInProgress()} would return false, the result of this
     * function is undefined.
     *
     * @return Y coordinate of the focal point in pixels.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.648 -0500", hash_original_method = "1634272865979B530C4105679871001B", hash_generated_method = "52632C775F6D9632E170A544D6AF35B4")
    
public float getFocusY() {
        return mFocusY;
    }

    /**
     * Return the current distance between the two pointers forming the
     * gesture in progress.
     *
     * @return Distance between pointers in pixels.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.650 -0500", hash_original_method = "AB0C6BF3BCA5EEB3D5CA8E031A94ABD9", hash_generated_method = "9A443A8813356E79567BCE141AAD82A1")
    
public float getCurrentSpan() {
        if (mCurrLen == -1) {
            final float cvx = mCurrFingerDiffX;
            final float cvy = mCurrFingerDiffY;
            mCurrLen = FloatMath.sqrt(cvx*cvx + cvy*cvy);
        }
        return mCurrLen;
    }

    /**
     * Return the current x distance between the two pointers forming the
     * gesture in progress.
     *
     * @return Distance between pointers in pixels.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.653 -0500", hash_original_method = "96703DCF80F0F42B9182D748E24B5F12", hash_generated_method = "8B0183DC7299A6B053C8D69245CA25F4")
    
public float getCurrentSpanX() {
        return mCurrFingerDiffX;
    }

    /**
     * Return the current y distance between the two pointers forming the
     * gesture in progress.
     *
     * @return Distance between pointers in pixels.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.655 -0500", hash_original_method = "46ABD98E7ABFBBE92F1E1C8C1A82F921", hash_generated_method = "6BF22D246C72964B6F75995BCD712B33")
    
public float getCurrentSpanY() {
        return mCurrFingerDiffY;
    }

    /**
     * Return the previous distance between the two pointers forming the
     * gesture in progress.
     *
     * @return Previous distance between pointers in pixels.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.658 -0500", hash_original_method = "61588E4085777CBFF7E61092314CDCD6", hash_generated_method = "B5025A01863C639B80517B503F62FA5D")
    
public float getPreviousSpan() {
        if (mPrevLen == -1) {
            final float pvx = mPrevFingerDiffX;
            final float pvy = mPrevFingerDiffY;
            mPrevLen = FloatMath.sqrt(pvx*pvx + pvy*pvy);
        }
        return mPrevLen;
    }

    /**
     * Return the previous x distance between the two pointers forming the
     * gesture in progress.
     *
     * @return Previous distance between pointers in pixels.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.660 -0500", hash_original_method = "0AFCA4EC344BB39A6FBEFCC5BD88D7B6", hash_generated_method = "F31C03262F40CF8FBF0A243142C92154")
    
public float getPreviousSpanX() {
        return mPrevFingerDiffX;
    }

    /**
     * Return the previous y distance between the two pointers forming the
     * gesture in progress.
     *
     * @return Previous distance between pointers in pixels.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.663 -0500", hash_original_method = "F0E427EE2F15CB9D89F340FD227EA8BF", hash_generated_method = "9AC564B3BEFF1C2B1952B36F03089934")
    
public float getPreviousSpanY() {
        return mPrevFingerDiffY;
    }

    /**
     * Return the scaling factor from the previous scale event to the current
     * event. This value is defined as
     * ({@link #getCurrentSpan()} / {@link #getPreviousSpan()}).
     *
     * @return The current scaling factor.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.665 -0500", hash_original_method = "EF10CCD331D0CD8126F652B47BBB1296", hash_generated_method = "B64B6879A3ADD500F55A9708EB600516")
    
public float getScaleFactor() {
        if (mScaleFactor == -1) {
            mScaleFactor = getCurrentSpan() / getPreviousSpan();
        }
        return mScaleFactor;
    }
    
    public static class SimpleOnScaleGestureListener implements OnScaleGestureListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.002 -0400", hash_original_method = "AD1F4E6C43CD567296DC4B26B7E79B23", hash_generated_method = "AD1F4E6C43CD567296DC4B26B7E79B23")
        public SimpleOnScaleGestureListener ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.545 -0500", hash_original_method = "F1A51F1E1A44A60BDE5250CC79B6BF22", hash_generated_method = "6E3C993127F3CBEB20A9A785F6ECE206")
        
public boolean onScale(ScaleGestureDetector detector) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.548 -0500", hash_original_method = "2018A466C052949DAB40F7C8547E8FA5", hash_generated_method = "705386BE02420A3F65E5E666CED6D424")
        
public boolean onScaleBegin(ScaleGestureDetector detector) {
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.551 -0500", hash_original_method = "5B9499EAA38A4A49EE469DC4AE83A358", hash_generated_method = "A245D427617C164350D989283A413ED1")
        
public void onScaleEnd(ScaleGestureDetector detector) {
            // Intentionally empty
        }
        
    }
    
    public interface OnScaleGestureListener {
        
        public boolean onScale(ScaleGestureDetector detector);
        
        public boolean onScaleBegin(ScaleGestureDetector detector);
        
        public void onScaleEnd(ScaleGestureDetector detector);
    }

    /**
     * Return the time difference in milliseconds between the previous
     * accepted scaling event and the current scaling event.
     *
     * @return Time difference since the last scaling event in milliseconds.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.667 -0500", hash_original_method = "478681CCF9BA4A844274161522001BDE", hash_generated_method = "D0C71CFDA1C49596A9CBB5571787A8EA")
    
public long getTimeDelta() {
        return mTimeDelta;
    }

    /**
     * Return the event time of the current event being processed.
     *
     * @return Current event time in milliseconds.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:16.669 -0500", hash_original_method = "93D380EA2FE2DB10568746F6E0FB3B8E", hash_generated_method = "BB0593FC7E733EF2FF53909574109C0D")
    
public long getEventTime() {
        return mCurrEvent.getEventTime();
    }
}

