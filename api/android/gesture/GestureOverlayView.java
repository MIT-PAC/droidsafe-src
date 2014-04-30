/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.gesture;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.os.SystemClock;
import android.annotation.Widget;
import com.android.internal.R;

import java.util.ArrayList;

/**
 * A transparent overlay for gesture input that can be placed on top of other
 * widgets or contain other widgets.
 *
 * @attr ref android.R.styleable#GestureOverlayView_eventsInterceptionEnabled
 * @attr ref android.R.styleable#GestureOverlayView_fadeDuration
 * @attr ref android.R.styleable#GestureOverlayView_fadeOffset
 * @attr ref android.R.styleable#GestureOverlayView_fadeEnabled
 * @attr ref android.R.styleable#GestureOverlayView_gestureStrokeWidth
 * @attr ref android.R.styleable#GestureOverlayView_gestureStrokeAngleThreshold
 * @attr ref android.R.styleable#GestureOverlayView_gestureStrokeLengthThreshold
 * @attr ref android.R.styleable#GestureOverlayView_gestureStrokeSquarenessThreshold
 * @attr ref android.R.styleable#GestureOverlayView_gestureStrokeType
 * @attr ref android.R.styleable#GestureOverlayView_gestureColor
 * @attr ref android.R.styleable#GestureOverlayView_orientation
 * @attr ref android.R.styleable#GestureOverlayView_uncertainGestureColor
 */
@Widget
public class GestureOverlayView extends FrameLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.571 -0500", hash_original_field = "F3B6A8FA94726EA88E308F505BCB3702", hash_generated_field = "483DCC1F5BC9BA70CE3063632BB9BA63")

    public static final int GESTURE_STROKE_TYPE_SINGLE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.576 -0500", hash_original_field = "EE710980C2DCB8F6D4F46759C5B78FDE", hash_generated_field = "58EE74484A6E7F2511B6772316308ADC")

    public static final int GESTURE_STROKE_TYPE_MULTIPLE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.581 -0500", hash_original_field = "52A309EB0E3683A7462D15119396AD5F", hash_generated_field = "F5AA8D432C85B67F2F1A59A2F86C9B4F")

    public static final int ORIENTATION_HORIZONTAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.587 -0500", hash_original_field = "676F5EBA34BAB3502E0DFDCC4B4606F0", hash_generated_field = "F0C280EF3D60F4930A958E8EA2B6AC4A")

    public static final int ORIENTATION_VERTICAL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.591 -0500", hash_original_field = "9A07AA42A262110A7DFD729AF0B167A1", hash_generated_field = "CEEBD65F6001366032FE15AB80DA5212")

    private static final int FADE_ANIMATION_RATE = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.596 -0500", hash_original_field = "EB08919EC2EBEFDFCDFB246B382FA97E", hash_generated_field = "D05A97BE31019579FED4EB7FDC30D6E1")

    private static final boolean GESTURE_RENDERING_ANTIALIAS = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.601 -0500", hash_original_field = "5958766EB00DC2EFC43FAE95A9ABB2C0", hash_generated_field = "FBDD41EEF31CCC0AB0E1B5AA30324CFE")

    private static final boolean DITHER_FLAG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.606 -0500", hash_original_field = "50AF1A7309F30140E7CA65A6BCC3EA53", hash_generated_field = "479EAB42222A96049EBE27F444ED9B01")

    private final Paint mGesturePaint = new Paint();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.610 -0500", hash_original_field = "AEE21B4D28055AC35B356CDC3D7F6198", hash_generated_field = "A126B8FD1FB1147AABAF0124CED0E792")

    private long mFadeDuration = 150;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.614 -0500", hash_original_field = "B2152E30024531B1607EB43DB65F4B9F", hash_generated_field = "3A944B14D56B40E1FF0156E0C92A7D05")

    private long mFadeOffset = 420;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.618 -0500", hash_original_field = "00FE85EE260109F71B452E4D62DDF2E0", hash_generated_field = "3494C1A9B54A0D3F732E42490ACA3615")

    private long mFadingStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.621 -0500", hash_original_field = "7F6FA35EF7180B60F63C862058AF1FC5", hash_generated_field = "A18BFADF30996185707E3F6F21BDC675")

    private boolean mFadingHasStarted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.625 -0500", hash_original_field = "9A068ED180A3C5241C39E34958C6F456", hash_generated_field = "003BE0EBD892781532AB497C7E2E800C")

    private boolean mFadeEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.630 -0500", hash_original_field = "177551318CAD9CD123B2D7C3BB0D805E", hash_generated_field = "38B5DFACC590CC89DF2B5575EDA9CFCD")

    private int mCurrentColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.634 -0500", hash_original_field = "107078F79900840F4B2DEEEDC6C8E919", hash_generated_field = "BF61072394273599ACFF700A74AF6493")

    private int mCertainGestureColor = 0xFFFFFF00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.638 -0500", hash_original_field = "0D0E112409B231F1DD869717AF5BF095", hash_generated_field = "EDA4D8C154535E6C4BA412EBA9355229")

    private int mUncertainGestureColor = 0x48FFFF00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.642 -0500", hash_original_field = "62AF40E54B562CE3CB367464296EFDF4", hash_generated_field = "F9CD1C4C7C7D452DF37B7D9C2B41D271")

    private float mGestureStrokeWidth = 12.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.646 -0500", hash_original_field = "3DFEE44513045CD15B9E5CCB821ED319", hash_generated_field = "27E8234D10D00BE99FA503372538EDDC")

    private int mInvalidateExtraBorder = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.650 -0500", hash_original_field = "FA7CC50884AA8252BE5B9EBC59E75A20", hash_generated_field = "CE4EDBB52190ADD57103E661BE2AA1BC")

    private int mGestureStrokeType = GESTURE_STROKE_TYPE_SINGLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.654 -0500", hash_original_field = "9D44C1C61BB407B8D1051493616D70EC", hash_generated_field = "C7F0545F3FED6F399EA25C1EDC03DBE4")

    private float mGestureStrokeLengthThreshold = 50.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.659 -0500", hash_original_field = "A20BAA1E319F825C1562939C75EC26B7", hash_generated_field = "3B5F4E470BEFE7BECAEB90D2A3123354")

    private float mGestureStrokeSquarenessTreshold = 0.275f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.662 -0500", hash_original_field = "C15F4AF87C6E9203EC18ADB71411F186", hash_generated_field = "662FF2536C953A7631F047593090B6CA")

    private float mGestureStrokeAngleThreshold = 40.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.666 -0500", hash_original_field = "382A52DEF1457A276AB94F4A12A86CEC", hash_generated_field = "358F100671988652DB1F92C6C12DC772")

    private int mOrientation = ORIENTATION_VERTICAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.670 -0500", hash_original_field = "A31E2FA3BADB841F3C7DA6F140830C12", hash_generated_field = "7419BDB406EE3A78930F7DD605CD17A7")

    private final Rect mInvalidRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.675 -0500", hash_original_field = "9F8A427DBED06081C76DCB512FA4C1C6", hash_generated_field = "1C9B38C7F9B71799B7B8F281B135448B")

    private final Path mPath = new Path();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.679 -0500", hash_original_field = "3B8350A621028B48CADB0F8D2357FB15", hash_generated_field = "D2D432385D57B37DC351B2A0C4DC9C95")

    private boolean mGestureVisible = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.682 -0500", hash_original_field = "8174733DF249E326666A04F4BE58CCC8", hash_generated_field = "4B20CDC18EBFA25CB5A845DE66FEE33E")

    private float mX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.687 -0500", hash_original_field = "5EA984BC6FFFB7EE5487B162E48C8CE7", hash_generated_field = "4A4EBB51050C24C2B262E3BAA3D2DD27")

    private float mY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.690 -0500", hash_original_field = "2A075AB9BBD7B647D478A5D498BEB6B8", hash_generated_field = "5B0D0CE43F2397829EF22DEED867B3B8")

    private float mCurveEndX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.694 -0500", hash_original_field = "8A150517B92F308B0B029CC1E90C677C", hash_generated_field = "26D615A313A619EB5BB2E61BD0C8494A")

    private float mCurveEndY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.698 -0500", hash_original_field = "246E47CC094CB4C5FAD9FB1FD6C41033", hash_generated_field = "2C825ADD3051870796FDEAABFD509AA3")

    private float mTotalLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.703 -0500", hash_original_field = "71BF694C4E99D11D41216945DF9115DB", hash_generated_field = "580FB3AA57A533873CA0A385D15702E0")

    private boolean mIsGesturing = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.706 -0500", hash_original_field = "322DD5B5C20E6FD14427C6FE235C90C8", hash_generated_field = "92AACF26774C28A2A39CC5BF74BDBD1C")

    private boolean mPreviousWasGesturing = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.710 -0500", hash_original_field = "4209D10E537D144B622E99891E66F383", hash_generated_field = "C2B7ACAB49C962FB08D43069EB68F499")

    private boolean mInterceptEvents = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.713 -0500", hash_original_field = "5DE6B465363D534035FCAF4D9DF23F01", hash_generated_field = "0CDE20B3499CC42D5C61CFE98929A04B")

    private boolean mIsListeningForGestures;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.718 -0500", hash_original_field = "9B36954FDE82CFED31005B69E9F25FF8", hash_generated_field = "7FD139142F161CB3117D7C68C26010E6")

    private boolean mResetGesture;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.722 -0500", hash_original_field = "5351316D9ADE7A6F28FD46D83E2B0FD8", hash_generated_field = "CAB0AF3D124AF5373EB4CECB031B1F1D")

    private Gesture mCurrentGesture;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.727 -0500", hash_original_field = "F9D4E39B1909F6F79F489F9146ACFE3E", hash_generated_field = "A017AAEC6C10C4B813CF306E4553DCBC")

    private final ArrayList<GesturePoint> mStrokeBuffer = new ArrayList<GesturePoint>(100);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.731 -0500", hash_original_field = "03835BF3E52137A785BFE112CCEE4A43", hash_generated_field = "5599814D81DBF098A40D9B331D22C75A")

    private final ArrayList<OnGestureListener> mOnGestureListeners =
            new ArrayList<OnGestureListener>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.735 -0500", hash_original_field = "35371FA5BCA70D061D44E363B86FA610", hash_generated_field = "E0819676325120CE901A5D68A7435F68")

    private final ArrayList<OnGesturePerformedListener> mOnGesturePerformedListeners =
            new ArrayList<OnGesturePerformedListener>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.740 -0500", hash_original_field = "B56E0D1077C1B9769CCBD28BC40F14FB", hash_generated_field = "2A21ED952E44030A94E124FF76501CAA")

    private final ArrayList<OnGesturingListener> mOnGesturingListeners =
            new ArrayList<OnGesturingListener>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.744 -0500", hash_original_field = "481123107ADEF2AE0B495091378F022D", hash_generated_field = "923A30D46A856F5085B3E37D7E75156A")

    private boolean mHandleGestureActions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.747 -0500", hash_original_field = "6663C30FD0EE8FE940346862A69C9217", hash_generated_field = "0334DA4FC1CF5337DF4C056ADE9D729F")

    private boolean mIsFadingOut = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.752 -0500", hash_original_field = "AF87003A3E7434FE3B12AE1931349615", hash_generated_field = "0C7A5C3FC57D9E86B3FAAEEC46F17987")

    private float mFadingAlpha = 1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.756 -0500", hash_original_field = "5E0E13FD0F2B612A6B105147287BC575", hash_generated_field = "90995957A873B5AB4274A67FD7D1FBAF")

    private final AccelerateDecelerateInterpolator mInterpolator =
            new AccelerateDecelerateInterpolator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.760 -0500", hash_original_field = "1E4DBF91775627A5C89416CC0C1B72C6", hash_generated_field = "38D768E60C8583DA83B2BD6AFAC7AB12")

    private final FadeOutRunnable mFadingOut = new FadeOutRunnable();

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.763 -0500", hash_original_method = "5F4969C68D604539D10BBB23C41E999A", hash_generated_method = "A05CBBFF2522ABDD22C6C7D57C5ED304")
    
public GestureOverlayView(Context context) {
        super(context);
        init();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.767 -0500", hash_original_method = "07C3ECF4E7F63F312E8076CE7D57AE8D", hash_generated_method = "69643E98B73F7D479D8E3A19A1C102C8")
    
public GestureOverlayView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.gestureOverlayViewStyle);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.773 -0500", hash_original_method = "4403B612E3FBF9C0D5C8293235B72DDB", hash_generated_method = "C1442319C059C00AACC7655B06B1D03A")
    
public GestureOverlayView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.GestureOverlayView, defStyle, 0);

        mGestureStrokeWidth = a.getFloat(R.styleable.GestureOverlayView_gestureStrokeWidth,
                mGestureStrokeWidth);
        mInvalidateExtraBorder = Math.max(1, ((int) mGestureStrokeWidth) - 1);
        mCertainGestureColor = a.getColor(R.styleable.GestureOverlayView_gestureColor,
                mCertainGestureColor);
        mUncertainGestureColor = a.getColor(R.styleable.GestureOverlayView_uncertainGestureColor,
                mUncertainGestureColor);
        mFadeDuration = a.getInt(R.styleable.GestureOverlayView_fadeDuration, (int) mFadeDuration);
        mFadeOffset = a.getInt(R.styleable.GestureOverlayView_fadeOffset, (int) mFadeOffset);
        mGestureStrokeType = a.getInt(R.styleable.GestureOverlayView_gestureStrokeType,
                mGestureStrokeType);
        mGestureStrokeLengthThreshold = a.getFloat(
                R.styleable.GestureOverlayView_gestureStrokeLengthThreshold,
                mGestureStrokeLengthThreshold);
        mGestureStrokeAngleThreshold = a.getFloat(
                R.styleable.GestureOverlayView_gestureStrokeAngleThreshold,
                mGestureStrokeAngleThreshold);
        mGestureStrokeSquarenessTreshold = a.getFloat(
                R.styleable.GestureOverlayView_gestureStrokeSquarenessThreshold,
                mGestureStrokeSquarenessTreshold);
        mInterceptEvents = a.getBoolean(R.styleable.GestureOverlayView_eventsInterceptionEnabled,
                mInterceptEvents);
        mFadeEnabled = a.getBoolean(R.styleable.GestureOverlayView_fadeEnabled,
                mFadeEnabled);
        mOrientation = a.getInt(R.styleable.GestureOverlayView_orientation, mOrientation);

        a.recycle();

        init();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.777 -0500", hash_original_method = "3CD723C45CDBEDDF70FB65B70E7AAB8B", hash_generated_method = "832151102B4542DAF5C20CE5D637E78B")
    
private void init() {
        setWillNotDraw(false);

        final Paint gesturePaint = mGesturePaint;
        gesturePaint.setAntiAlias(GESTURE_RENDERING_ANTIALIAS);
        gesturePaint.setColor(mCertainGestureColor);
        gesturePaint.setStyle(Paint.Style.STROKE);
        gesturePaint.setStrokeJoin(Paint.Join.ROUND);
        gesturePaint.setStrokeCap(Paint.Cap.ROUND);
        gesturePaint.setStrokeWidth(mGestureStrokeWidth);
        gesturePaint.setDither(DITHER_FLAG);

        mCurrentColor = mCertainGestureColor;
        setPaintAlpha(255);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.781 -0500", hash_original_method = "63B9FF7E2A62CA59C59591BF9364EF20", hash_generated_method = "3DE749C5E58E78D86F72EBAE7DCCBECB")
    
public ArrayList<GesturePoint> getCurrentStroke() {
        return mStrokeBuffer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.784 -0500", hash_original_method = "6BA82D6B625174A8AC80664141F0D361", hash_generated_method = "BD403A9700920A99F22D5BAAE290999D")
    
public int getOrientation() {
        return mOrientation;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.787 -0500", hash_original_method = "F059BEA018C060B8AF19EC0186D2EAFF", hash_generated_method = "2A5B54B208BB54C5BBC827439F7666A7")
    
public void setOrientation(int orientation) {
        mOrientation = orientation;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.790 -0500", hash_original_method = "DC370FD4C16E494C7E0CF1EB61E6DF7C", hash_generated_method = "B4345ABB57B565AA62C77DE0455228B0")
    
public void setGestureColor(int color) {
        mCertainGestureColor = color;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.795 -0500", hash_original_method = "3B544AB80E72D1B326BEE0AB70F6C60F", hash_generated_method = "1A05DFFB7A64113BD71B70A080562221")
    
public void setUncertainGestureColor(int color) {
        mUncertainGestureColor = color;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.798 -0500", hash_original_method = "4BE1DF24B868389E5BADB6013D5979B4", hash_generated_method = "FC33DC28E9685DB96D843509C4127847")
    
public int getUncertainGestureColor() {
        return mUncertainGestureColor;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.802 -0500", hash_original_method = "D17CF62187DB42ABE5C5A463485D49F2", hash_generated_method = "62E5040C0030B88284671F43B9F41D82")
    
public int getGestureColor() {
        return mCertainGestureColor;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.805 -0500", hash_original_method = "0073F53982A7774542B1336A19108B15", hash_generated_method = "5A4F14E69527374CCA2444ABD594C883")
    
public float getGestureStrokeWidth() {
        return mGestureStrokeWidth;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.808 -0500", hash_original_method = "378D0C50C09D1CD32ACC6F9384FE9A98", hash_generated_method = "104F0518D3337809770165D68E9030DF")
    
public void setGestureStrokeWidth(float gestureStrokeWidth) {
        mGestureStrokeWidth = gestureStrokeWidth;
        mInvalidateExtraBorder = Math.max(1, ((int) gestureStrokeWidth) - 1);
        mGesturePaint.setStrokeWidth(gestureStrokeWidth);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.811 -0500", hash_original_method = "4AB435963D9C0F5ACF9B359A07D5757A", hash_generated_method = "243B4B48A349FAE6498B9AC05E8482CD")
    
public int getGestureStrokeType() {
        return mGestureStrokeType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.814 -0500", hash_original_method = "863282B47E1CCCA20A62CFFA1AD1FFA2", hash_generated_method = "60F3F82A5A4D6AA66EA47EEC0FBC23A5")
    
public void setGestureStrokeType(int gestureStrokeType) {
        mGestureStrokeType = gestureStrokeType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.817 -0500", hash_original_method = "2FF72DD801A83A721D45AA30126E129A", hash_generated_method = "C967C60BA2E8B1CE871E734CB7982D76")
    
public float getGestureStrokeLengthThreshold() {
        return mGestureStrokeLengthThreshold;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.820 -0500", hash_original_method = "76F6719A1D9E114A3BB9A82AE93C2B40", hash_generated_method = "B8E76CA15E7043367AB8EF9EA26E6680")
    
public void setGestureStrokeLengthThreshold(float gestureStrokeLengthThreshold) {
        mGestureStrokeLengthThreshold = gestureStrokeLengthThreshold;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.823 -0500", hash_original_method = "6B3199C9171EEB89C7311075034198B2", hash_generated_method = "4D38E3D88D6169C9E4BD2351042912F0")
    
public float getGestureStrokeSquarenessTreshold() {
        return mGestureStrokeSquarenessTreshold;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.827 -0500", hash_original_method = "C5950D22E025A60940076840F11BF890", hash_generated_method = "8FEFA21ECCADEE21251FED364FC88FC9")
    
public void setGestureStrokeSquarenessTreshold(float gestureStrokeSquarenessTreshold) {
        mGestureStrokeSquarenessTreshold = gestureStrokeSquarenessTreshold;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.830 -0500", hash_original_method = "580C179F88A332B84AB6202E18D2C85B", hash_generated_method = "7E8EBD1C99375020FE3DCC5535030387")
    
public float getGestureStrokeAngleThreshold() {
        return mGestureStrokeAngleThreshold;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.833 -0500", hash_original_method = "DBC672CC41CF38BF01CC1139A11A9496", hash_generated_method = "070D705219B852BF209625472C7BD5C9")
    
public void setGestureStrokeAngleThreshold(float gestureStrokeAngleThreshold) {
        mGestureStrokeAngleThreshold = gestureStrokeAngleThreshold;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.836 -0500", hash_original_method = "DA4512A6B931F34A26BD997C7AA75BD4", hash_generated_method = "8368F8E0732405FD1D5B2606F10C4A40")
    
public boolean isEventsInterceptionEnabled() {
        return mInterceptEvents;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.840 -0500", hash_original_method = "E88E386677CC7794F824EFCBE8BF7E2C", hash_generated_method = "6CA53CB2EEFDB6233C5B93D8DEDC8C97")
    
public void setEventsInterceptionEnabled(boolean enabled) {
        mInterceptEvents = enabled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.843 -0500", hash_original_method = "8D284DE38255BACD8065A8D486EC5BC6", hash_generated_method = "74C0D7593D8C0147020F1A1ED10D65A8")
    
public boolean isFadeEnabled() {
        return mFadeEnabled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.846 -0500", hash_original_method = "EAE0B498271CE8578A8DF71F53A53DA7", hash_generated_method = "CE173F46E73000003E8948E09860FAFE")
    
public void setFadeEnabled(boolean fadeEnabled) {
        mFadeEnabled = fadeEnabled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.849 -0500", hash_original_method = "7378DBEA36715DD6718C0E5C49525678", hash_generated_method = "4CEFC4460ECDF82F242C6475BA9A5D7D")
    
public Gesture getGesture() {
        return mCurrentGesture;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.853 -0500", hash_original_method = "32F131485A71C83C7DCCC485D1C422E2", hash_generated_method = "07DCB144145ADE8E8C6AAF1ABB1F86D8")
    
public void setGesture(Gesture gesture) {
        if (mCurrentGesture != null) {
            clear(false);
        }

        setCurrentColor(mCertainGestureColor);
        mCurrentGesture = gesture;

        final Path path = mCurrentGesture.toPath();
        final RectF bounds = new RectF();
        path.computeBounds(bounds, true);

        // TODO: The path should also be scaled to fit inside this view
        mPath.rewind();
        mPath.addPath(path, -bounds.left + (getWidth() - bounds.width()) / 2.0f,
                -bounds.top + (getHeight() - bounds.height()) / 2.0f);

        mResetGesture = true;

        invalidate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.856 -0500", hash_original_method = "E35BA78D7BDD4A9D7A182B4B6BDE2DCC", hash_generated_method = "40450D6EEFDD5D79E8AC25423D5BDD2B")
    
public Path getGesturePath() {
        return mPath;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.859 -0500", hash_original_method = "14F32AB42A3F4415FAFDC0D5CB944C04", hash_generated_method = "CB1081AE22A59AC976F65CD13751009E")
    
public Path getGesturePath(Path path) {
        path.set(mPath);
        return path;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.862 -0500", hash_original_method = "C723A5CEC649EDA794C82FB4435BD605", hash_generated_method = "EB22C43BD6339A3BDB01357B7C32F331")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS) 
public boolean isGestureVisible() {
        return mGestureVisible;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.865 -0500", hash_original_method = "14084EF9744ED695A1AD772CA43D9E9C", hash_generated_method = "4D1850E4D115C346EDEA524A25735137")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS) 
public void setGestureVisible(boolean visible) {
        mGestureVisible = visible;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.869 -0500", hash_original_method = "83DE427855A81E9D93BCC823E70BE549", hash_generated_method = "8CAC307EF4A7E20B4F4FD11ADF3F332D")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS) 
public long getFadeOffset() {
        return mFadeOffset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.872 -0500", hash_original_method = "15622D130A6BE1D2B3AB957DEB06A187", hash_generated_method = "05778514A0619866F482CEB8BA0032A9")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS) 
public void setFadeOffset(long fadeOffset) {
        mFadeOffset = fadeOffset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.876 -0500", hash_original_method = "9CA2FCE2A8AEA2A999EA1294F5369972", hash_generated_method = "94392C3431017DC0D0E29F8338CB228B")

    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void addOnGestureListener(OnGestureListener listener) {
        mOnGestureListeners.add(listener);
        if (listener != null) {
            listener.onGesture(this,  new MotionEvent());
            listener.onGestureStarted(this,  new MotionEvent());
            listener.onGestureEnded(this, new MotionEvent());
            listener.onGestureCancelled(this, new MotionEvent());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.879 -0500", hash_original_method = "7B53A7D56517E0EDAF05163735BB75D4", hash_generated_method = "684E0DA6FE7303F7EB44990DD09E25AF")
    
public void removeOnGestureListener(OnGestureListener listener) {
        mOnGestureListeners.remove(listener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.881 -0500", hash_original_method = "98567D7C1D7F9405686588882FE2846D", hash_generated_method = "A704EAC9430C5CD02619E68C3CE629DB")
    
public void removeAllOnGestureListeners() {
        mOnGestureListeners.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.886 -0500", hash_original_method = "E5B428B6ABE72363DA7D1F1EC46C0C69", hash_generated_method = "2A6064C4D9E9B92519D63DD7EC53C5F7")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void addOnGesturePerformedListener(OnGesturePerformedListener listener) {
        mOnGesturePerformedListeners.add(listener);
        if (mOnGesturePerformedListeners.size() > 0) {
            mHandleGestureActions = true;
            Gesture gesture = new Gesture();
            gesture.addTaint(getTaint());
            listener.onGesturePerformed(this, gesture);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.889 -0500", hash_original_method = "45F6C6D8548A3684D322026B781031FC", hash_generated_method = "92665B52791E85465DB1795EEE7F9692")
    
public void removeOnGesturePerformedListener(OnGesturePerformedListener listener) {
        mOnGesturePerformedListeners.remove(listener);
        if (mOnGesturePerformedListeners.size() <= 0) {
            mHandleGestureActions = false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.892 -0500", hash_original_method = "2B865F5DDE6369158529A7F8F09F071F", hash_generated_method = "77D415C8950A87DFF182B9D9A884952B")
    
public void removeAllOnGesturePerformedListeners() {
        mOnGesturePerformedListeners.clear();
        mHandleGestureActions = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.896 -0500", hash_original_method = "62280BA83BD1D441A2ED86699D3FA414", hash_generated_method = "E1C7DD1E7E39AD562F9035FF3B14D6E2")
    
public void addOnGesturingListener(OnGesturingListener listener) {
        mOnGesturingListeners.add(listener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.899 -0500", hash_original_method = "07CE2CEDD38D8CCFFEEDF7B726462D25", hash_generated_method = "17639E57AAB0A00F78012DB1B1A36B2B")
    
public void removeOnGesturingListener(OnGesturingListener listener) {
        mOnGesturingListeners.remove(listener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.902 -0500", hash_original_method = "3A9315DD708A906745DE7B2A0D1689C3", hash_generated_method = "249D567A7C7F3F79A4082F218CAA3BB7")
    
public void removeAllOnGesturingListeners() {
        mOnGesturingListeners.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.905 -0500", hash_original_method = "6DDBA51B5BACA49FE86C57C6F39857C3", hash_generated_method = "4035034D02B6B4A3F0CD4CC5C8367B30")
    
public boolean isGesturing() {
        return mIsGesturing;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.908 -0500", hash_original_method = "32DB18D77A2576AE86D59FADF22B59E6", hash_generated_method = "A81AFE843991AF60064366EE244E7F71")
    
private void setCurrentColor(int color) {
        mCurrentColor = color;
        if (mFadingHasStarted) {
            setPaintAlpha((int) (255 * mFadingAlpha));
        } else {
            setPaintAlpha(255);
        }
        invalidate();
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.911 -0500", hash_original_method = "DA54101E632B91C91BD4A0911291FBF1", hash_generated_method = "B8FC215DC9F61F3DC7C5A23C0B775877")
    
public Paint getGesturePaint() {
        return mGesturePaint;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.915 -0500", hash_original_method = "B1F37402DEDC0F27F2826810362D4757", hash_generated_method = "667D888EFA51D2CF8E0481D774ECEC3C")
    
@Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if (mCurrentGesture != null && mGestureVisible) {
            canvas.drawPath(mPath, mGesturePaint);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.918 -0500", hash_original_method = "98DA823C5FDFEF0ABE492E1BB4E187E9", hash_generated_method = "8C6DF2A2BF32B76B51869BC3A8D3DFB9")
    
private void setPaintAlpha(int alpha) {
        alpha += alpha >> 7;
        final int baseAlpha = mCurrentColor >>> 24;
        final int useAlpha = baseAlpha * alpha >> 8;
        mGesturePaint.setColor((mCurrentColor << 8 >>> 8) | (useAlpha << 24));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.921 -0500", hash_original_method = "B0B5C975555FF1C6B4FAC8477747B662", hash_generated_method = "3638AD6DE54290754AB99297063E6EB3")
    
public void clear(boolean animated) {
        clear(animated, false, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.925 -0500", hash_original_method = "EA9CED2E4E833C151CFB8537CF1E6A27", hash_generated_method = "1B053088B847353709AC28A56FC9B2C2")
    
private void clear(boolean animated, boolean fireActionPerformed, boolean immediate) {
        setPaintAlpha(255);
        removeCallbacks(mFadingOut);
        mResetGesture = false;
        mFadingOut.fireActionPerformed = fireActionPerformed;
        mFadingOut.resetMultipleStrokes = false;

        if (animated && mCurrentGesture != null) {
            mFadingAlpha = 1.0f;
            mIsFadingOut = true;
            mFadingHasStarted = false;
            mFadingStart = AnimationUtils.currentAnimationTimeMillis() + mFadeOffset;

            postDelayed(mFadingOut, mFadeOffset);
        } else {
            mFadingAlpha = 1.0f;
            mIsFadingOut = false;
            mFadingHasStarted = false;

            if (immediate) {
                mCurrentGesture = null;
                mPath.rewind();
                invalidate();
            } else if (fireActionPerformed) {
                postDelayed(mFadingOut, mFadeOffset);
            } else if (mGestureStrokeType == GESTURE_STROKE_TYPE_MULTIPLE) {
                mFadingOut.resetMultipleStrokes = true;
                postDelayed(mFadingOut, mFadeOffset);
            } else {
                mCurrentGesture = null;
                mPath.rewind();
                invalidate();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.929 -0500", hash_original_method = "609CB910EF71FA8577B10953EFEB3C6B", hash_generated_method = "09B10BA73ABFFC40392E34F015038EF1")
    
public void cancelClearAnimation() {
        setPaintAlpha(255);
        mIsFadingOut = false;
        mFadingHasStarted = false;
        removeCallbacks(mFadingOut);
        mPath.rewind();
        mCurrentGesture = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.933 -0500", hash_original_method = "1CEA0523825143953D3C3C9D6427B1BD", hash_generated_method = "7DEAEDBA2496D17EA918A37450A30525")
    
public void cancelGesture() {
        mIsListeningForGestures = false;

        // add the stroke to the current gesture
        mCurrentGesture.addStroke(new GestureStroke(mStrokeBuffer));

        // pass the event to handlers
        final long now = SystemClock.uptimeMillis();
        final MotionEvent event = MotionEvent.obtain(now, now,
                MotionEvent.ACTION_CANCEL, 0.0f, 0.0f, 0);

        final ArrayList<OnGestureListener> listeners = mOnGestureListeners;
        int count = listeners.size();
        for (int i = 0; i < count; i++) {
            listeners.get(i).onGestureCancelled(this, event);
        }

        event.recycle();

        clear(false);
        mIsGesturing = false;
        mPreviousWasGesturing = false;
        mStrokeBuffer.clear();

        final ArrayList<OnGesturingListener> otherListeners = mOnGesturingListeners;
        count = otherListeners.size();
        for (int i = 0; i < count; i++) {
            otherListeners.get(i).onGesturingEnded(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.936 -0500", hash_original_method = "AE1745A3BB4455156D5EB2F3E3913FE3", hash_generated_method = "AB006783B71AA7D13D1666FB077FCB93")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    protected void onDetachedFromWindow() {
        cancelClearAnimation();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.940 -0500", hash_original_method = "CFC919DDDE19519F2E04BB144505E830", hash_generated_method = "9E142ACC7A82CA90C9D7DD79050E1B24")
    
@Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (isEnabled()) {
            final boolean cancelDispatch = (mIsGesturing || (mCurrentGesture != null &&
                    mCurrentGesture.getStrokesCount() > 0 && mPreviousWasGesturing)) &&
                    mInterceptEvents;

            processEvent(event);

            if (cancelDispatch) {
                event.setAction(MotionEvent.ACTION_CANCEL);
            }

            super.dispatchTouchEvent(event);

            return true;
        }

        return super.dispatchTouchEvent(event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.945 -0500", hash_original_method = "205735C2ED9AE02A766BE00A3EE1AEAA", hash_generated_method = "D43EE02BA070FC4A9665AE05748978B0")
    
private boolean processEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchDown(event);
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                if (mIsListeningForGestures) {
                    Rect rect = touchMove(event);
                    if (rect != null) {
                        invalidate(rect);
                    }
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                if (mIsListeningForGestures) {
                    touchUp(event, false);
                    invalidate();
                    return true;
                }
                break;
            case MotionEvent.ACTION_CANCEL:
                if (mIsListeningForGestures) {
                    touchUp(event, true);
                    invalidate();
                    return true;
                }
        }

        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.950 -0500", hash_original_method = "42A725D8476EF8E365B78D471A0FB719", hash_generated_method = "3887DEF120B41F4F3129953F21A76408")
    
private void touchDown(MotionEvent event) {
        mIsListeningForGestures = true;

        float x = event.getX();
        float y = event.getY();

        mX = x;
        mY = y;

        mTotalLength = 0;
        mIsGesturing = false;

        if (mGestureStrokeType == GESTURE_STROKE_TYPE_SINGLE || mResetGesture) {
            if (mHandleGestureActions) setCurrentColor(mUncertainGestureColor);
            mResetGesture = false;
            mCurrentGesture = null;
            mPath.rewind();
        } else if (mCurrentGesture == null || mCurrentGesture.getStrokesCount() == 0) {
            if (mHandleGestureActions) setCurrentColor(mUncertainGestureColor);
        }

        // if there is fading out going on, stop it.
        if (mFadingHasStarted) {
            cancelClearAnimation();
        } else if (mIsFadingOut) {
            setPaintAlpha(255);
            mIsFadingOut = false;
            mFadingHasStarted = false;
            removeCallbacks(mFadingOut);
        }

        if (mCurrentGesture == null) {
            mCurrentGesture = new Gesture();
        }

        mStrokeBuffer.add(new GesturePoint(x, y, event.getEventTime()));
        mPath.moveTo(x, y);

        final int border = mInvalidateExtraBorder;
        mInvalidRect.set((int) x - border, (int) y - border, (int) x + border, (int) y + border);

        mCurveEndX = x;
        mCurveEndY = y;

        // pass the event to handlers
        final ArrayList<OnGestureListener> listeners = mOnGestureListeners;
        final int count = listeners.size();
        for (int i = 0; i < count; i++) {
            listeners.get(i).onGestureStarted(this, event);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.956 -0500", hash_original_method = "9435E87EB0A9174A890E1EB5C00EE016", hash_generated_method = "85279B2D8C59C8C61AD95951D80589F4")
    
private Rect touchMove(MotionEvent event) {
        Rect areaToRefresh = null;

        final float x = event.getX();
        final float y = event.getY();

        final float previousX = mX;
        final float previousY = mY;

        final float dx = Math.abs(x - previousX);
        final float dy = Math.abs(y - previousY);

        if (dx >= GestureStroke.TOUCH_TOLERANCE || dy >= GestureStroke.TOUCH_TOLERANCE) {
            areaToRefresh = mInvalidRect;

            // start with the curve end
            final int border = mInvalidateExtraBorder;
            areaToRefresh.set((int) mCurveEndX - border, (int) mCurveEndY - border,
                    (int) mCurveEndX + border, (int) mCurveEndY + border);

            float cX = mCurveEndX = (x + previousX) / 2;
            float cY = mCurveEndY = (y + previousY) / 2;

            mPath.quadTo(previousX, previousY, cX, cY);

            // union with the control point of the new curve
            areaToRefresh.union((int) previousX - border, (int) previousY - border,
                    (int) previousX + border, (int) previousY + border);

            // union with the end point of the new curve
            areaToRefresh.union((int) cX - border, (int) cY - border,
                    (int) cX + border, (int) cY + border);

            mX = x;
            mY = y;

            mStrokeBuffer.add(new GesturePoint(x, y, event.getEventTime()));

            if (mHandleGestureActions && !mIsGesturing) {
                mTotalLength += (float) Math.sqrt(dx * dx + dy * dy);

                if (mTotalLength > mGestureStrokeLengthThreshold) {
                    final OrientedBoundingBox box =
                            GestureUtils.computeOrientedBoundingBox(mStrokeBuffer);

                    float angle = Math.abs(box.orientation);
                    if (angle > 90) {
                        angle = 180 - angle;
                    }

                    if (box.squareness > mGestureStrokeSquarenessTreshold ||
                            (mOrientation == ORIENTATION_VERTICAL ?
                                    angle < mGestureStrokeAngleThreshold :
                                    angle > mGestureStrokeAngleThreshold)) {

                        mIsGesturing = true;
                        setCurrentColor(mCertainGestureColor);

                        final ArrayList<OnGesturingListener> listeners = mOnGesturingListeners;
                        int count = listeners.size();
                        for (int i = 0; i < count; i++) {
                            listeners.get(i).onGesturingStarted(this);
                        }
                    }
                }
            }

            // pass the event to handlers
            final ArrayList<OnGestureListener> listeners = mOnGestureListeners;
            final int count = listeners.size();
            for (int i = 0; i < count; i++) {
                listeners.get(i).onGesture(this, event);
            }
        }

        return areaToRefresh;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.961 -0500", hash_original_method = "43E4A904B970F6854F2ABD79656B660C", hash_generated_method = "DB554D50BCA4C06C5E8C74D9ABF753CF")
    
private void touchUp(MotionEvent event, boolean cancel) {
        mIsListeningForGestures = false;

        // A gesture wasn't started or was cancelled
        if (mCurrentGesture != null) {
            // add the stroke to the current gesture
            mCurrentGesture.addStroke(new GestureStroke(mStrokeBuffer));

            if (!cancel) {
                // pass the event to handlers
                final ArrayList<OnGestureListener> listeners = mOnGestureListeners;
                int count = listeners.size();
                for (int i = 0; i < count; i++) {
                    listeners.get(i).onGestureEnded(this, event);
                }

                clear(mHandleGestureActions && mFadeEnabled, mHandleGestureActions && mIsGesturing,
                        false);
            } else {
                cancelGesture(event);

            }
        } else {
            cancelGesture(event);
        }

        mStrokeBuffer.clear();
        mPreviousWasGesturing = mIsGesturing;
        mIsGesturing = false;

        final ArrayList<OnGesturingListener> listeners = mOnGesturingListeners;
        int count = listeners.size();
        for (int i = 0; i < count; i++) {
            listeners.get(i).onGesturingEnded(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.964 -0500", hash_original_method = "F2561228492E8DD249340EE7F0D481C3", hash_generated_method = "A04817AF30BC4FBBD78E5AEF654B018D")
    
private void cancelGesture(MotionEvent event) {
        // pass the event to handlers
        final ArrayList<OnGestureListener> listeners = mOnGestureListeners;
        final int count = listeners.size();
        for (int i = 0; i < count; i++) {
            listeners.get(i).onGestureCancelled(this, event);
        }

        clear(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.967 -0500", hash_original_method = "1DA797E89FB2A4D929949584E00E64EE", hash_generated_method = "D75192800F4DE37A5364A21DAB4DFA09")
    
private void fireOnGesturePerformed() {
        final ArrayList<OnGesturePerformedListener> actionListeners = mOnGesturePerformedListeners;
        final int count = actionListeners.size();
        for (int i = 0; i < count; i++) {
            actionListeners.get(i).onGesturePerformed(GestureOverlayView.this, mCurrentGesture);
        }
    }

    private class FadeOutRunnable implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.971 -0500", hash_original_field = "B163589D548200426D9B4252FA1385CD", hash_generated_field = "B163589D548200426D9B4252FA1385CD")

        boolean fireActionPerformed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.975 -0500", hash_original_field = "8F2F7C9C72E300FF51F3687654EE6968", hash_generated_field = "8F2F7C9C72E300FF51F3687654EE6968")

        boolean resetMultipleStrokes;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:07.980 -0500", hash_original_method = "6C15F19885498187B870CF9A8480A3C6", hash_generated_method = "63DA417F9F211B48327EBC2087108667")
        
public void run() {
            if (mIsFadingOut) {
                final long now = AnimationUtils.currentAnimationTimeMillis();
                final long duration = now - mFadingStart;

                if (duration > mFadeDuration) {
                    if (fireActionPerformed) {
                        fireOnGesturePerformed();
                    }

                    mPreviousWasGesturing = false;
                    mIsFadingOut = false;
                    mFadingHasStarted = false;
                    mPath.rewind();
                    mCurrentGesture = null;
                    setPaintAlpha(255);
                } else {
                    mFadingHasStarted = true;
                    float interpolatedTime = Math.max(0.0f,
                            Math.min(1.0f, duration / (float) mFadeDuration));
                    mFadingAlpha = 1.0f - mInterpolator.getInterpolation(interpolatedTime);
                    setPaintAlpha((int) (255 * mFadingAlpha));
                    postDelayed(this, FADE_ANIMATION_RATE);
                }
            } else if (resetMultipleStrokes) {
                mResetGesture = true;
            } else {
                fireOnGesturePerformed();

                mFadingHasStarted = false;
                mPath.rewind();
                mCurrentGesture = null;
                mPreviousWasGesturing = false;
                setPaintAlpha(255);
            }

            invalidate();
        }
    }

    public static interface OnGesturingListener {
        void onGesturingStarted(GestureOverlayView overlay);

        void onGesturingEnded(GestureOverlayView overlay);
    }

    public static interface OnGestureListener {
        void onGestureStarted(GestureOverlayView overlay, MotionEvent event);

        void onGesture(GestureOverlayView overlay, MotionEvent event);

        void onGestureEnded(GestureOverlayView overlay, MotionEvent event);

        void onGestureCancelled(GestureOverlayView overlay, MotionEvent event);
    }

    public static interface OnGesturePerformedListener {
        void onGesturePerformed(GestureOverlayView overlay, Gesture gesture);
    }
}
