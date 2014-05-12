/*
 * Copyright (C) 2012 The Android Open Source Project
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

package android.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.IRemoteCallback;
import android.os.RemoteException;
import android.view.View;

/**
 * Helper class for building an options Bundle that can be used with
 * {@link android.content.Context#startActivity(android.content.Intent, android.os.Bundle)
 * Context.startActivity(Intent, Bundle)} and related methods.
 */
public class ActivityOptions {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.110 -0500", hash_original_field = "F1396ADE619C02044E4FBBD18D4F6257", hash_generated_field = "E0CD74ADB08EEA39003A52F83EE0DC2D")

    public static final String KEY_PACKAGE_NAME = "android:packageName";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.122 -0500", hash_original_field = "3398E0C1E141929EDA2C59782D730F4E", hash_generated_field = "E467E3EAC3540C7FFD90032826881FA1")

    public static final String KEY_ANIM_TYPE = "android:animType";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.131 -0500", hash_original_field = "325DA2F9695900CD4FA134C38871F075", hash_generated_field = "0DCEC2EC4C33136B23B032BB5521A381")

    public static final String KEY_ANIM_ENTER_RES_ID = "android:animEnterRes";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.141 -0500", hash_original_field = "6638773ABAE5CDEF5C2BA583B1805C68", hash_generated_field = "97DEF94D6DADB5BEE758BC71880C89BA")

    public static final String KEY_ANIM_EXIT_RES_ID = "android:animExitRes";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.151 -0500", hash_original_field = "7984E8E41A93C2769E00E72BBC060DD9", hash_generated_field = "23A32937015B7015BBA3F6F982AE9652")

    public static final String KEY_ANIM_THUMBNAIL = "android:animThumbnail";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.172 -0500", hash_original_field = "2744C527FC162460EF74EBFF902A8BE6", hash_generated_field = "7F36A563E91837A64DA52FB428658FEA")

    public static final String KEY_ANIM_START_X = "android:animStartX";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.181 -0500", hash_original_field = "F69F5D933DF40F581AFF00D7855431F7", hash_generated_field = "F96B419E9E931F9254C66C15A9EF2CE4")

    public static final String KEY_ANIM_START_Y = "android:animStartY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.190 -0500", hash_original_field = "00C914C2B57AC4FED3000AAF83654DF1", hash_generated_field = "5A46B070D53E513A85608E325BC88BC1")

    public static final String KEY_ANIM_START_WIDTH = "android:animStartWidth";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.199 -0500", hash_original_field = "C17612351869793A18CDA129B231D6DC", hash_generated_field = "686FC3F981BBBFE6B57C1DA8285116E3")

    public static final String KEY_ANIM_START_HEIGHT = "android:animStartHeight";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.208 -0500", hash_original_field = "11043C39E7F2A07D21DC7EDE180E00E0", hash_generated_field = "258DA8B5DA2A30BDF39479544A1BD2E1")

    public static final String KEY_ANIM_START_LISTENER = "android:animStartListener";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.217 -0500", hash_original_field = "00985C9C40285314BDFDC9F32B097B33", hash_generated_field = "7A9A16FDE5EC7CC7CAD72373C6FF65E9")

    public static final int ANIM_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.224 -0500", hash_original_field = "5D695238A32948C04408149AAD8B7DA1", hash_generated_field = "36636277AD191DA27C80E67DDA19C693")

    public static final int ANIM_CUSTOM = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.232 -0500", hash_original_field = "BEF0CBAF21DF6DB97D7969779602E9ED", hash_generated_field = "897E8DE6D0CDEEB56116BF13CA97C5A6")

    public static final int ANIM_SCALE_UP = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.242 -0500", hash_original_field = "5C5BA6034F9F0054A4B495875940B594", hash_generated_field = "67C74A2957602FCAB89D5D4A445F915C")

    public static final int ANIM_THUMBNAIL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.249 -0500", hash_original_field = "213B693F0093E1F758FCE61D29CD18DD", hash_generated_field = "BDC1F9327302E2559221106B090347E1")

    public static final int ANIM_THUMBNAIL_DELAYED = 4;

    /**
     * Create an ActivityOptions specifying a custom animation to run when
     * the activity is displayed.
     *
     * @param context Who is defining this.  This is the application that the
     * animation resources will be loaded from.
     * @param enterResId A resource ID of the animation resource to use for
     * the incoming activity.  Use 0 for no animation.
     * @param exitResId A resource ID of the animation resource to use for
     * the outgoing activity.  Use 0 for no animation.
     * @return Returns a new ActivityOptions object that you can use to
     * supply these options as the options Bundle when starting an activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.330 -0500", hash_original_method = "CEDE12801DF56E653A233586E7709351", hash_generated_method = "2E567183B4E2CF19055EC43F12605856")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public static ActivityOptions makeCustomAnimation(Context context,
            int enterResId, int exitResId) {
        return makeCustomAnimation(context, enterResId, exitResId, null, null);
    }

    /**
     * Create an ActivityOptions specifying a custom animation to run when
     * the activity is displayed.
     *
     * @param context Who is defining this.  This is the application that the
     * animation resources will be loaded from.
     * @param enterResId A resource ID of the animation resource to use for
     * the incoming activity.  Use 0 for no animation.
     * @param exitResId A resource ID of the animation resource to use for
     * the outgoing activity.  Use 0 for no animation.
     * @param handler If <var>listener</var> is non-null this must be a valid
     * Handler on which to dispatch the callback; otherwise it should be null.
     * @param listener Optional OnAnimationStartedListener to find out when the
     * requested animation has started running.  If for some reason the animation
     * is not executed, the callback will happen immediately.
     * @return Returns a new ActivityOptions object that you can use to
     * supply these options as the options Bundle when starting an activity.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.340 -0500", hash_original_method = "C056608B1B43FC7E05EB6DDDF8AB154B", hash_generated_method = "7EE9DEE5E48F36AA692B4D8BEA1A8F11")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public static ActivityOptions makeCustomAnimation(Context context,
            int enterResId, int exitResId, Handler handler, OnAnimationStartedListener listener) {
        ActivityOptions opts = new ActivityOptions();
        opts.mPackageName = context.getPackageName();
        opts.mAnimationType = ANIM_CUSTOM;
        opts.mCustomEnterResId = enterResId;
        opts.mCustomExitResId = exitResId;
        opts.setListener(handler, listener);
        return opts;
    }

    /**
     * Create an ActivityOptions specifying an animation where the new
     * activity is scaled from a small originating area of the screen to
     * its final full representation.
     *
     * <p>If the Intent this is being used with has not set its
     * {@link android.content.Intent#setSourceBounds Intent.setSourceBounds},
     * those bounds will be filled in for you based on the initial
     * bounds passed in here.
     *
     * @param source The View that the new activity is animating from.  This
     * defines the coordinate space for <var>startX</var> and <var>startY</var>.
     * @param startX The x starting location of the new activity, relative to <var>source</var>.
     * @param startY The y starting location of the activity, relative to <var>source</var>.
     * @param startWidth The initial width of the new activity.
     * @param startHeight The initial height of the new activity.
     * @return Returns a new ActivityOptions object that you can use to
     * supply these options as the options Bundle when starting an activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.391 -0500", hash_original_method = "DB80D681214740909D7AC4832CA0A7BA", hash_generated_method = "35306BF168D4E8975EEEBC6BEAB48E70")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public static ActivityOptions makeScaleUpAnimation(View source,
            int startX, int startY, int startWidth, int startHeight) {
        ActivityOptions opts = new ActivityOptions();
        opts.mPackageName = source.getContext().getPackageName();
        opts.mAnimationType = ANIM_SCALE_UP;
        int[] pts = new int[2];
        source.getLocationOnScreen(pts);
        opts.mStartX = pts[0] + startX;
        opts.mStartY = pts[1] + startY;
        opts.mStartWidth = startWidth;
        opts.mStartHeight = startHeight;
        return opts;
    }

    /**
     * Create an ActivityOptions specifying an animation where a thumbnail
     * is scaled from a given position to the new activity window that is
     * being started.
     *
     * <p>If the Intent this is being used with has not set its
     * {@link android.content.Intent#setSourceBounds Intent.setSourceBounds},
     * those bounds will be filled in for you based on the initial
     * thumbnail location and size provided here.
     *
     * @param source The View that this thumbnail is animating from.  This
     * defines the coordinate space for <var>startX</var> and <var>startY</var>.
     * @param thumbnail The bitmap that will be shown as the initial thumbnail
     * of the animation.
     * @param startX The x starting location of the bitmap, relative to <var>source</var>.
     * @param startY The y starting location of the bitmap, relative to <var>source</var>.
     * @return Returns a new ActivityOptions object that you can use to
     * supply these options as the options Bundle when starting an activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.400 -0500", hash_original_method = "3CEA83F9538DC1A353C202D53A012E3F", hash_generated_method = "4308427CD11FED63EB4FEE15A756ADAE")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public static ActivityOptions makeThumbnailScaleUpAnimation(View source,
            Bitmap thumbnail, int startX, int startY) {
        return makeThumbnailScaleUpAnimation(source, thumbnail, startX, startY, null);
    }

    /**
     * Create an ActivityOptions specifying an animation where a thumbnail
     * is scaled from a given position to the new activity window that is
     * being started.
     *
     * @param source The View that this thumbnail is animating from.  This
     * defines the coordinate space for <var>startX</var> and <var>startY</var>.
     * @param thumbnail The bitmap that will be shown as the initial thumbnail
     * of the animation.
     * @param startX The x starting location of the bitmap, relative to <var>source</var>.
     * @param startY The y starting location of the bitmap, relative to <var>source</var>.
     * @param listener Optional OnAnimationStartedListener to find out when the
     * requested animation has started running.  If for some reason the animation
     * is not executed, the callback will happen immediately.
     * @return Returns a new ActivityOptions object that you can use to
     * supply these options as the options Bundle when starting an activity.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.408 -0500", hash_original_method = "A4F6CEFF6C7E622CBE69C862D323E9B1", hash_generated_method = "8AF2F8D2EACA05D5DD5BE6E96E115752")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public static ActivityOptions makeThumbnailScaleUpAnimation(View source,
            Bitmap thumbnail, int startX, int startY, OnAnimationStartedListener listener) {
        return makeThumbnailScaleUpAnimation(source, thumbnail, startX, startY, listener, false);
    }

    /**
     * Create an ActivityOptions specifying an animation where a thumbnail
     * is scaled from a given position to the new activity window that is
     * being started. Before the animation, there is a short delay.
     *
     * @param source The View that this thumbnail is animating from.  This
     * defines the coordinate space for <var>startX</var> and <var>startY</var>.
     * @param thumbnail The bitmap that will be shown as the initial thumbnail
     * of the animation.
     * @param startX The x starting location of the bitmap, relative to <var>source</var>.
     * @param startY The y starting location of the bitmap, relative to <var>source</var>.
     * @param listener Optional OnAnimationStartedListener to find out when the
     * requested animation has started running.  If for some reason the animation
     * is not executed, the callback will happen immediately.
     * @return Returns a new ActivityOptions object that you can use to
     * supply these options as the options Bundle when starting an activity.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.417 -0500", hash_original_method = "1FAFB6F6B48EC66CD9F95A4BBF964714", hash_generated_method = "47F8387D2DBBFDEDEA9FD6E67385E4EE")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public static ActivityOptions makeDelayedThumbnailScaleUpAnimation(View source,
            Bitmap thumbnail, int startX, int startY, OnAnimationStartedListener listener) {
        return makeThumbnailScaleUpAnimation(source, thumbnail, startX, startY, listener, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.427 -0500", hash_original_method = "A04E8A694EF6E677608BABF7B29F457F", hash_generated_method = "5D4278489A49B5F407A2715824F8FB64")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
private static ActivityOptions makeThumbnailScaleUpAnimation(View source,
            Bitmap thumbnail, int startX, int startY, OnAnimationStartedListener listener,
            boolean delayed) {
        ActivityOptions opts = new ActivityOptions();
        opts.mPackageName = source.getContext().getPackageName();
        opts.mAnimationType = delayed ? ANIM_THUMBNAIL_DELAYED : ANIM_THUMBNAIL;
        opts.mThumbnail = thumbnail;
        int[] pts = new int[2];
        source.getLocationOnScreen(pts);
        opts.mStartX = pts[0] + startX;
        opts.mStartY = pts[1] + startY;
        opts.setListener(source.getHandler(), listener);
        return opts;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.521 -0500", hash_original_method = "D26E3B8553B7E2BA423AECA3756CF102", hash_generated_method = "36193AE496C352A6F467A6DC825807DA")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public static void abort(Bundle options) {
        if (options != null) {
            (new ActivityOptions(options)).abort();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.257 -0500", hash_original_field = "7A5990DF4A54BF373C395B6501E20B02", hash_generated_field = "6F81845A3A2771C3EC987E5A01DBA4C6")

    private String mPackageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.264 -0500", hash_original_field = "CE05B131079505A74A08C78D5F9ACED4", hash_generated_field = "0C208BC6EF045352D05E326BD173C934")

    private int mAnimationType = ANIM_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.271 -0500", hash_original_field = "61C079FAC1CA746F30B32FBE2067D14B", hash_generated_field = "3D319434076DA08365EEA64EF68A7DBB")

    private int mCustomEnterResId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.278 -0500", hash_original_field = "98E6C8316FCA575E109603C4D0A194BA", hash_generated_field = "5B4A954BAC6FE9233C22A49653622F36")

    private int mCustomExitResId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.285 -0500", hash_original_field = "AB836E5DEC1CD154ACE913A398465EA6", hash_generated_field = "6DBBA1DA8EF7EE69BE6833A18C318437")

    private Bitmap mThumbnail;

    /**
     * Callback for use with {@link ActivityOptions#makeThumbnailScaleUpAnimation}
     * to find out when the given animation has started running.
     * @hide
     */
    public interface OnAnimationStartedListener {
        void onAnimationStarted();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.291 -0500", hash_original_field = "7F2FA150F8D8A76C750DD698B8BF6CB5", hash_generated_field = "28E51E686EEF26C8A77C03ED820E724F")

    private int mStartX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.297 -0500", hash_original_field = "81022B59B7942B83F7EE5FF6915DB938", hash_generated_field = "2C4FD2F4594E993A1C0AA896A5F50971")

    private int mStartY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.308 -0500", hash_original_field = "3794E371792BC3BE0AE9AB18FA25A826", hash_generated_field = "BB27C8D84348F4CEB278A1B5CA5496B5")

    private int mStartWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.314 -0500", hash_original_field = "88261EFD8598FCA8F01B07DDAB4EF092", hash_generated_field = "A48BDAE16BA29783432A789CB3AF06C7")

    private int mStartHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.322 -0500", hash_original_field = "9ABF321E392E1C786507CB227D7B099F", hash_generated_field = "E7895D9A8EEADB235B6F8C10288CB55A")

    private IRemoteCallback mAnimationStartedListener;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.435 -0500", hash_original_method = "5641DFA4B190048B959BE9ED14016F28", hash_generated_method = "83F73EC2FEC1600076E5B15E247F359E")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
private ActivityOptions() {
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.449 -0500", hash_original_method = "984CAD3542189ADE4C5676B364AC6C41", hash_generated_method = "7C686A75500C071596C33EA36457CC99")
    @DSComment("Constructor")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS) 
public ActivityOptions(Bundle opts) {
        mPackageName = opts.getString(KEY_PACKAGE_NAME);
        mAnimationType = opts.getInt(KEY_ANIM_TYPE);
        if (mAnimationType == ANIM_CUSTOM) {
            mCustomEnterResId = opts.getInt(KEY_ANIM_ENTER_RES_ID, 0);
            mCustomExitResId = opts.getInt(KEY_ANIM_EXIT_RES_ID, 0);
            mAnimationStartedListener = IRemoteCallback.Stub.asInterface(
                    opts.getIBinder(KEY_ANIM_START_LISTENER));
        } else if (mAnimationType == ANIM_SCALE_UP) {
            mStartX = opts.getInt(KEY_ANIM_START_X, 0);
            mStartY = opts.getInt(KEY_ANIM_START_Y, 0);
            mStartWidth = opts.getInt(KEY_ANIM_START_WIDTH, 0);
            mStartHeight = opts.getInt(KEY_ANIM_START_HEIGHT, 0);
        } else if (mAnimationType == ANIM_THUMBNAIL ||
                mAnimationType == ANIM_THUMBNAIL_DELAYED) {
            mThumbnail = (Bitmap)opts.getParcelable(KEY_ANIM_THUMBNAIL);
            mStartX = opts.getInt(KEY_ANIM_START_X, 0);
            mStartY = opts.getInt(KEY_ANIM_START_Y, 0);
            mAnimationStartedListener = IRemoteCallback.Stub.asInterface(
                    opts.getIBinder(KEY_ANIM_START_LISTENER));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.374 -0500", hash_original_method = "5F56EF7A0397F8A3B7027EF66D2A8E86", hash_generated_method = "A65583C5EBE27CB606BDB524E20E7B79")
    
private void setListener(Handler handler, OnAnimationStartedListener listener) {
        if (listener != null) {
            final Handler h = handler;
            final OnAnimationStartedListener finalListener = listener;
            mAnimationStartedListener = new IRemoteCallback.Stub() {
                @Override public void sendResult(Bundle data) throws RemoteException {
                    h.post(new Runnable() {
                        @Override public void run() {
                            finalListener.onAnimationStarted();
                        }
                    });
                }
            };
            if (listener != null) {
               listener.onAnimationStarted(); 
            }
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.455 -0500", hash_original_method = "B3E128BBA0564CAE955B890D71B1CE7C", hash_generated_method = "BFA44CE53EBFEE02C805A4272C4E472E")
    
public String getPackageName() {
        return mPackageName;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.462 -0500", hash_original_method = "E00D09F8A1812D1C93EB28AC71CE1CF9", hash_generated_method = "E036540FF32FA7A726A0F64984A87CA9")
    
public int getAnimationType() {
        return mAnimationType;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.468 -0500", hash_original_method = "833B3B43F85E2F8CDAA35D47BEE78A75", hash_generated_method = "DE73E74CDF0E1EB32E8516157B268760")
    
public int getCustomEnterResId() {
        return mCustomEnterResId;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.473 -0500", hash_original_method = "CFF0E407F4C6FCBA02A9808CC0D7E701", hash_generated_method = "1618766447B2EB233BA652B1C7B9C694")
    
public int getCustomExitResId() {
        return mCustomExitResId;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.479 -0500", hash_original_method = "75CFAA01FAA5FA9166B3C44C2A8353E7", hash_generated_method = "B9E00509DB2D52CD9E1092F72DF06169")
    
public Bitmap getThumbnail() {
        return mThumbnail;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.485 -0500", hash_original_method = "E9E5B4E6E70EEEC71B101472B8ED332D", hash_generated_method = "429FCFA22391E8A6C5CBF28A1384FF69")
    
public int getStartX() {
        return mStartX;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.491 -0500", hash_original_method = "96DB239ADDDE6565887119C487206B3B", hash_generated_method = "3C6E802AE056B6D5C36D17857D3E3BE2")
    
public int getStartY() {
        return mStartY;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.497 -0500", hash_original_method = "27E3FCB544FD73B89503F25E8009A0F8", hash_generated_method = "AAFE0DDF8177B0EC8EDA32977B641EEA")
    
public int getStartWidth() {
        return mStartWidth;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.502 -0500", hash_original_method = "6CEC8DD022FC1ABA58C317BA3E7E6D56", hash_generated_method = "4E9042E9E1F8608596A84351287C69F3")
    
public int getStartHeight() {
        return mStartHeight;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.509 -0500", hash_original_method = "6E61319A0B7DCD22A1A58CC538C88860", hash_generated_method = "7034ECA5CD60467157BE5D70DE45D221")
    
public IRemoteCallback getOnAnimationStartListener() {
        return mAnimationStartedListener;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.515 -0500", hash_original_method = "60A25F1B78521948C63CF10761954F64", hash_generated_method = "3BB7039D699FD1AF4034ABEF80CFA5B9")
    
public void abort() {
        if (mAnimationStartedListener != null) {
            try {
                mAnimationStartedListener.sendResult(null);
            } catch (RemoteException e) {
            }
        }
    }

    /**
     * Update the current values in this ActivityOptions from those supplied
     * in <var>otherOptions</var>.  Any values
     * defined in <var>otherOptions</var> replace those in the base options.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.545 -0500", hash_original_method = "9B13EBC80B32DFC7505D14D510432240", hash_generated_method = "C55AF96C9F5963D0DE9B8F956B320FF3")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public void update(ActivityOptions otherOptions) {
        if (otherOptions.mPackageName != null) {
            mPackageName = otherOptions.mPackageName;
        }
        switch (otherOptions.mAnimationType) {
            case ANIM_CUSTOM:
                mAnimationType = otherOptions.mAnimationType;
                mCustomEnterResId = otherOptions.mCustomEnterResId;
                mCustomExitResId = otherOptions.mCustomExitResId;
                mThumbnail = null;
                if (otherOptions.mAnimationStartedListener != null) {
                    try {
                        otherOptions.mAnimationStartedListener.sendResult(null);
                    } catch (RemoteException e) {
                    }
                }
                mAnimationStartedListener = otherOptions.mAnimationStartedListener;
                break;
            case ANIM_SCALE_UP:
                mAnimationType = otherOptions.mAnimationType;
                mStartX = otherOptions.mStartX;
                mStartY = otherOptions.mStartY;
                mStartWidth = otherOptions.mStartWidth;
                mStartHeight = otherOptions.mStartHeight;
                if (otherOptions.mAnimationStartedListener != null) {
                    try {
                        otherOptions.mAnimationStartedListener.sendResult(null);
                    } catch (RemoteException e) {
                    }
                }
                mAnimationStartedListener = null;
                break;
            case ANIM_THUMBNAIL:
            case ANIM_THUMBNAIL_DELAYED:
                mAnimationType = otherOptions.mAnimationType;
                mThumbnail = otherOptions.mThumbnail;
                mStartX = otherOptions.mStartX;
                mStartY = otherOptions.mStartY;
                if (otherOptions.mAnimationStartedListener != null) {
                    try {
                        otherOptions.mAnimationStartedListener.sendResult(null);
                    } catch (RemoteException e) {
                    }
                }
                mAnimationStartedListener = otherOptions.mAnimationStartedListener;
                break;
        }
    }

    /**
     * Returns the created options as a Bundle, which can be passed to
     * {@link android.content.Context#startActivity(android.content.Intent, android.os.Bundle)
     * Context.startActivity(Intent, Bundle)} and related methods.
     * Note that the returned Bundle is still owned by the ActivityOptions
     * object; you must not modify it, but can supply it to the startActivity
     * methods that take an options Bundle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 15:55:43.554 -0500", hash_original_method = "D8F2B07CBFC7C474AD12B4D6F0266F5C", hash_generated_method = "452A0985510371E861E6C97B96C2FDD8")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public Bundle toBundle() {
        Bundle b = new Bundle();
        if (mPackageName != null) {
            b.putString(KEY_PACKAGE_NAME, mPackageName);
        }
        switch (mAnimationType) {
            case ANIM_CUSTOM:
                b.putInt(KEY_ANIM_TYPE, mAnimationType);
                b.putInt(KEY_ANIM_ENTER_RES_ID, mCustomEnterResId);
                b.putInt(KEY_ANIM_EXIT_RES_ID, mCustomExitResId);
                b.putIBinder(KEY_ANIM_START_LISTENER, mAnimationStartedListener
                        != null ? mAnimationStartedListener.asBinder() : null);
                break;
            case ANIM_SCALE_UP:
                b.putInt(KEY_ANIM_TYPE, mAnimationType);
                b.putInt(KEY_ANIM_START_X, mStartX);
                b.putInt(KEY_ANIM_START_Y, mStartY);
                b.putInt(KEY_ANIM_START_WIDTH, mStartWidth);
                b.putInt(KEY_ANIM_START_HEIGHT, mStartHeight);
                break;
            case ANIM_THUMBNAIL:
            case ANIM_THUMBNAIL_DELAYED:
                b.putInt(KEY_ANIM_TYPE, mAnimationType);
                b.putParcelable(KEY_ANIM_THUMBNAIL, mThumbnail);
                b.putInt(KEY_ANIM_START_X, mStartX);
                b.putInt(KEY_ANIM_START_Y, mStartY);
                b.putIBinder(KEY_ANIM_START_LISTENER, mAnimationStartedListener
                        != null ? mAnimationStartedListener.asBinder() : null);
                break;
        }
        return b;
    }
}
