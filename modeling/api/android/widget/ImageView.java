/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;

public class ImageView extends View {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.931 -0500", hash_original_method = "794DDCD2F1CC379DC73569DF9A81912A", hash_generated_method = "54FF3F645443323781BB5CB61724FCA8")
    
private static Matrix.ScaleToFit scaleTypeToScaleToFit(ScaleType st)  {
        // ScaleToFit enum to their corresponding Matrix.ScaleToFit values
        return sS2FArray[st.nativeInt - 1];
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.849 -0500", hash_original_field = "1BEEEE80B9B1ED7C64A99F1694709124", hash_generated_field = "49F3AE1F9A33DAD969F75FE221C01603")

    private static final ScaleType[] sScaleTypeArray = {
        ScaleType.MATRIX,
        ScaleType.FIT_XY,
        ScaleType.FIT_START,
        ScaleType.FIT_CENTER,
        ScaleType.FIT_END,
        ScaleType.CENTER,
        ScaleType.CENTER_CROP,
        ScaleType.CENTER_INSIDE
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.929 -0500", hash_original_field = "7493F22E5B069F589FD71E7C1B52CAC6", hash_generated_field = "6A6FB41DF0BD10A3E546839DDC4FEEB8")

    private static final Matrix.ScaleToFit[] sS2FArray = {
        Matrix.ScaleToFit.FILL,
        Matrix.ScaleToFit.START,
        Matrix.ScaleToFit.CENTER,
        Matrix.ScaleToFit.END
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.798 -0500", hash_original_field = "49226456B4CE4E55A779249DE3DC63D4", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

    private Uri mUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.800 -0500", hash_original_field = "D0BBA4752F49E04A108487B12701FBEA", hash_generated_field = "A1149776195D9A81C2251417049A8983")

    private int mResource = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.802 -0500", hash_original_field = "ECC1E936684D992B258D335000C3D72A", hash_generated_field = "19EDBF8F5E96D57B14276EDE6AD2F400")

    private Matrix mMatrix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.804 -0500", hash_original_field = "10D4ADA6B90029464961AEC2A760DC5A", hash_generated_field = "D019EEE3A15FE9FAE26B5448B9F5829B")

    private ScaleType mScaleType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.806 -0500", hash_original_field = "6528C85159177027E6C5270BE403086B", hash_generated_field = "A9F2FED4F49AAE6AC6AEAF755030819C")

    private boolean mHaveFrame = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.809 -0500", hash_original_field = "14E66A0B75E2EEEA90C43F0061DCF872", hash_generated_field = "0CE29D9D9A45271B43F0AD7DE06F84E1")

    private boolean mAdjustViewBounds = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.811 -0500", hash_original_field = "7923988CB2BF485CE356C2C41363F3B6", hash_generated_field = "63C7BFD9234113D05BBC54B620020077")

    private int mMaxWidth = Integer.MAX_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.813 -0500", hash_original_field = "C533AAE74AA4075E61C99869C4FD017F", hash_generated_field = "3586D5CEDE91E2DE59FB9742E85FA3AD")

    private int mMaxHeight = Integer.MAX_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.815 -0500", hash_original_field = "FDF54A2FE886548299B21698A652A06E", hash_generated_field = "5D6D299C9DDEDCCB11EFFA1C147C3DF6")

    private ColorFilter mColorFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.817 -0500", hash_original_field = "A6B19F1E237A801306F5C3BB6F56FD1D", hash_generated_field = "D85E4CEC9C06A2D96EB98C9ADB4E0FF6")

    private int mAlpha = 255;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.819 -0500", hash_original_field = "1D2B1641B3CB45181194168D7C2AB808", hash_generated_field = "7D8AB2121554DAB4C026523E1BE546D1")

    private int mViewAlphaScale = 256;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.821 -0500", hash_original_field = "9ED5DBC7C5BD0E00F0173804225F2E43", hash_generated_field = "F19CF311EA8DC507DE046A521B9697AE")

    private boolean mColorMod = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.823 -0500", hash_original_field = "8AC7F8A91CAABDD8C266F61B46BEBED9", hash_generated_field = "4203E503DD280EB595B89035662691AC")

    private Drawable mDrawable = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.825 -0500", hash_original_field = "D2B723E6656C8CD2970F2823B4398553", hash_generated_field = "55E5EFD87E77F38783CE10C9BF766B2D")

    private int[] mState = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.828 -0500", hash_original_field = "2F49264A14D5F731D4A5FBEE51932B86", hash_generated_field = "CD0E3EB62F2EEB3E7C6BC89E581F03D0")

    private boolean mMergeState = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.830 -0500", hash_original_field = "9308AE6FD010F418842CB5F45F406B14", hash_generated_field = "D66D669C7CB840BE2CC0AE88CB04AECF")

    private int mLevel = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.832 -0500", hash_original_field = "9F26D2326A1D3F92E944576B2362CAD2", hash_generated_field = "A392E3876AEB7B9CD42C742144EAE0B2")

    private int mDrawableWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.834 -0500", hash_original_field = "864DBD8391AFF3FE056861DD4BF74521", hash_generated_field = "87D310E7F957167B4F609DB1F09D884D")

    private int mDrawableHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.836 -0500", hash_original_field = "A2B7CB34B37E9788F45D5E6E14843EEE", hash_generated_field = "90F6D022B92E991BB20BB870E8BC3FF7")

    private Matrix mDrawMatrix = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.838 -0500", hash_original_field = "A9191DE873CD22956F542C733D822BB9", hash_generated_field = "4822CDFF0200FBD929D8DC006BC82F04")

    private RectF mTempSrc = new RectF();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.840 -0500", hash_original_field = "0BFB1E478B3486656B4333080D24BF12", hash_generated_field = "3F7FC79A12F840875E4DB52E36F649AD")

    private RectF mTempDst = new RectF();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.842 -0500", hash_original_field = "B15F5C9CCEFAAC7046F407CFC0D19760", hash_generated_field = "2A167B0395D5D689B5161FD76D7714AC")

    private boolean mCropToPadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.844 -0500", hash_original_field = "AA759664711376E49D5BE27103EA5136", hash_generated_field = "FEB7CA79CE658BB3A037CDF3395A66FC")

    private int mBaseline = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.847 -0500", hash_original_field = "B945E19F480AEA937B2B6E93510EDBC9", hash_generated_field = "43E60ED5A18EF5C89E67168564FB92E1")

    private boolean mBaselineAlignBottom = false;

    @DSVerified
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.852 -0500", hash_original_method = "3103DD3B06C95633A5076C8A302A640B", hash_generated_method = "A9312934B320F52AF3B76BC1947F3486")
    
public ImageView(Context context) {
        super(context);
        initImageView();
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.854 -0500", hash_original_method = "67FF47760B585BF8195A474475D955DB", hash_generated_method = "97AB01D65DE1CF05D3F3DCCA4747DE30")
    
public ImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.857 -0500", hash_original_method = "8CC4CE610519C30A909B4E591A3E5936", hash_generated_method = "7733C97D46F188090692509C5C8D271A")
    
public ImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initImageView();

        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ImageView, defStyle, 0);

        Drawable d = a.getDrawable(com.android.internal.R.styleable.ImageView_src);
        if (d != null) {
            setImageDrawable(d);
        }

        mBaselineAlignBottom = a.getBoolean(
                com.android.internal.R.styleable.ImageView_baselineAlignBottom, false);

        mBaseline = a.getDimensionPixelSize(
                com.android.internal.R.styleable.ImageView_baseline, -1);

        setAdjustViewBounds(
            a.getBoolean(com.android.internal.R.styleable.ImageView_adjustViewBounds,
            false));

        setMaxWidth(a.getDimensionPixelSize(
                com.android.internal.R.styleable.ImageView_maxWidth, Integer.MAX_VALUE));
        
        setMaxHeight(a.getDimensionPixelSize(
                com.android.internal.R.styleable.ImageView_maxHeight, Integer.MAX_VALUE));
        
        int index = a.getInt(com.android.internal.R.styleable.ImageView_scaleType, -1);
        if (index >= 0) {
            setScaleType(sScaleTypeArray[index]);
        }

        int tint = a.getInt(com.android.internal.R.styleable.ImageView_tint, 0);
        if (tint != 0) {
            setColorFilter(tint);
        }
        
        int alpha = a.getInt(com.android.internal.R.styleable.ImageView_drawableAlpha, 255);
        if (alpha != 255) {
            setAlpha(alpha);
        }

        mCropToPadding = a.getBoolean(
                com.android.internal.R.styleable.ImageView_cropToPadding, false);
        
        a.recycle();

        //need inflate syntax/reader for matrix
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.861 -0500", hash_original_method = "1C158315B1207DD6F7DBD78E9AF6090A", hash_generated_method = "21D11F4FE028BE3BF86D61203CBEA7CA")
    
private void initImageView() {
        mMatrix     = new Matrix();
        mScaleType  = ScaleType.FIT_CENTER;
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.863 -0500", hash_original_method = "D798939B4195D6D5668E5F7C7E8DA2D2", hash_generated_method = "E3284A20BEB69813C85C6FAFDC58D309")
    
@Override
    protected boolean verifyDrawable(Drawable dr) {
        return mDrawable == dr || super.verifyDrawable(dr);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.865 -0500", hash_original_method = "EFC358D3732AB4D7E168E7965D2C4CA0", hash_generated_method = "7DA256BA5278B524B100470106252ED5")
    
@Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (mDrawable != null) mDrawable.jumpToCurrentState();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.867 -0500", hash_original_method = "EB3EC256D00C5FC794745B960350792B", hash_generated_method = "CD6421F6254EAC50863B194D8EE65B2A")
    
@Override
    public void invalidateDrawable(Drawable dr) {
        if (dr == mDrawable) {
            /* we invalidate the whole view in this case because it's very
             * hard to know where the drawable actually is. This is made
             * complicated because of the offsets and transformations that
             * can be applied. In theory we could get the drawable's bounds
             * and run them through the transformation and offsets, but this
             * is probably not worth the effort.
             */
            invalidate();
        } else {
            super.invalidateDrawable(dr);
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.870 -0500", hash_original_method = "792DD4F5E748125528D3BF6C27B77C70", hash_generated_method = "CAC9E44D081081CF5690A5F0878D987F")
    
@Override
    public int getResolvedLayoutDirection(Drawable dr) {
        return (dr == mDrawable) ?
                getResolvedLayoutDirection() : super.getResolvedLayoutDirection(dr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.872 -0500", hash_original_method = "000365A595FBC289F16F7AD48241010C", hash_generated_method = "DFD0230A554EAD043FDC6868D4878101")
    
@Override
    protected boolean onSetAlpha(int alpha) {
        if (getBackground() == null) {
            int scale = alpha + (alpha >> 7);
            if (mViewAlphaScale != scale) {
                mViewAlphaScale = scale;
                mColorMod = true;
                applyColorMod();
            }
            return true;
        }
        return false;
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.874 -0500", hash_original_method = "9770981DD4DB73204B697C6119742B6F", hash_generated_method = "59A05CE79686C7A9B9C91885A0E512AA")
    
@Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        CharSequence contentDescription = getContentDescription();
        if (!TextUtils.isEmpty(contentDescription)) {
            event.getText().add(contentDescription);
        }
    }

    /**
     * Set this to true if you want the ImageView to adjust its bounds
     * to preserve the aspect ratio of its drawable.
     * @param adjustViewBounds Whether to adjust the bounds of this view
     * to presrve the original aspect ratio of the drawable
     * 
     * @attr ref android.R.styleable#ImageView_adjustViewBounds
     */
    @DSComment("Safe excetp setImageURI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.877 -0500", hash_original_method = "3F8BE319328C68420F5075492EAAB722", hash_generated_method = "F0B36AE7E464DFD8ACED97C2ACB4F0AF")
    
@android.view.RemotableViewMethod
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        mAdjustViewBounds = adjustViewBounds;
        if (adjustViewBounds) {
            setScaleType(ScaleType.FIT_CENTER);
        }
    }
    
    /**
     * An optional argument to supply a maximum width for this view. Only valid if
     * {@link #setAdjustViewBounds(boolean)} has been set to true. To set an image to be a maximum
     * of 100 x 100 while preserving the original aspect ratio, do the following: 1) set
     * adjustViewBounds to true 2) set maxWidth and maxHeight to 100 3) set the height and width
     * layout params to WRAP_CONTENT.
     * 
     * <p>
     * Note that this view could be still smaller than 100 x 100 using this approach if the original
     * image is small. To set an image to a fixed size, specify that size in the layout params and
     * then use {@link #setScaleType(android.widget.ImageView.ScaleType)} to determine how to fit
     * the image within the bounds.
     * </p>
     * 
     * @param maxWidth maximum width for this view
     * 
     * @attr ref android.R.styleable#ImageView_maxWidth
     */
    @DSComment("Safe excetp setImageURI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.879 -0500", hash_original_method = "EB73857FE18ECB168F084B0FAC346FEA", hash_generated_method = "2CE7E42FFE2C31E1A22305F9A1E43AE0")
    
@android.view.RemotableViewMethod
    public void setMaxWidth(int maxWidth) {
        mMaxWidth = maxWidth;
    }
    
    /**
     * An optional argument to supply a maximum height for this view. Only valid if
     * {@link #setAdjustViewBounds(boolean)} has been set to true. To set an image to be a
     * maximum of 100 x 100 while preserving the original aspect ratio, do the following: 1) set
     * adjustViewBounds to true 2) set maxWidth and maxHeight to 100 3) set the height and width
     * layout params to WRAP_CONTENT.
     * 
     * <p>
     * Note that this view could be still smaller than 100 x 100 using this approach if the original
     * image is small. To set an image to a fixed size, specify that size in the layout params and
     * then use {@link #setScaleType(android.widget.ImageView.ScaleType)} to determine how to fit
     * the image within the bounds.
     * </p>
     * 
     * @param maxHeight maximum height for this view
     * 
     * @attr ref android.R.styleable#ImageView_maxHeight
     */
    @DSComment("Safe excetp setImageURI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.881 -0500", hash_original_method = "9473C5CB1AE9899AEC7CB726EABA77F7", hash_generated_method = "A002710690767296259F2CD92EF811D6")
    
@android.view.RemotableViewMethod
    public void setMaxHeight(int maxHeight) {
        mMaxHeight = maxHeight;
    }

    /** Return the view's drawable, or null if no drawable has been
        assigned.
    */
    @DSComment("Safe excetp setImageURI")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.883 -0500", hash_original_method = "53D05784890C72350FD6879A6582F7F3", hash_generated_method = "DF96164158117DC7A0136AF51CE8F171")
    
public Drawable getDrawable() {
        return mDrawable;
    }

    /**
     * Sets a drawable as the content of this ImageView.
     *
     * <p class="note">This does Bitmap reading and decoding on the UI
     * thread, which can cause a latency hiccup.  If that's a concern,
     * consider using {@link #setImageDrawable(android.graphics.drawable.Drawable)} or
     * {@link #setImageBitmap(android.graphics.Bitmap)} and
     * {@link android.graphics.BitmapFactory} instead.</p>
     *
     * @param resId the resource identifier of the the drawable
     *
     * @attr ref android.R.styleable#ImageView_src
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.885 -0500", hash_original_method = "FEA329647011282E5AA15854AC819C8B", hash_generated_method = "1B3E5E42D142B65A1EE79330B36AB68D")
    
@android.view.RemotableViewMethod
    public void setImageResource(int resId) {
        if (mUri != null || mResource != resId) {
            updateDrawable(null);
            mResource = resId;
            mUri = null;
            resolveUri();
            requestLayout();
            invalidate();
        }
    }

    /**
     * Sets the content of this ImageView to the specified Uri.
     *
     * <p class="note">This does Bitmap reading and decoding on the UI
     * thread, which can cause a latency hiccup.  If that's a concern,
     * consider using {@link #setImageDrawable(android.graphics.drawable.Drawable)} or
     * {@link #setImageBitmap(android.graphics.Bitmap)} and
     * {@link android.graphics.BitmapFactory} instead.</p>
     *
     * @param uri The Uri of an image
     */
    @DSComment("Safe excetp setImageURI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.888 -0500", hash_original_method = "796039DEA15F6465B0D947F27F5B4F32", hash_generated_method = "B77D6E63EE3023176451D7CD68FF83F3")
    
@android.view.RemotableViewMethod
    public void setImageURI(Uri uri) {
        if (mResource != 0 ||
                (mUri != uri &&
                 (uri == null || mUri == null || !uri.equals(mUri)))) {
            updateDrawable(null);
            mResource = 0;
            mUri = uri;
            resolveUri();
            requestLayout();
            invalidate();
        }
    }

    /**
     * Sets a drawable as the content of this ImageView.
     * 
     * @param drawable The drawable to set
     */
    @DSComment("Safe excetp setImageURI")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.891 -0500", hash_original_method = "5426F5FAF3C8635D29ADE0169269A6F9", hash_generated_method = "37AAC6991023BB22E48327E3EA2C66CF")
    
public void setImageDrawable(Drawable drawable) {
        if (mDrawable != drawable) {
            mResource = 0;
            mUri = null;

            int oldWidth = mDrawableWidth;
            int oldHeight = mDrawableHeight;

            updateDrawable(drawable);

            if (oldWidth != mDrawableWidth || oldHeight != mDrawableHeight) {
                requestLayout();
            }
            invalidate();
        }
    }

    /**
     * Sets a Bitmap as the content of this ImageView.
     * 
     * @param bm The bitmap to set
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.893 -0500", hash_original_method = "5EFFAF8EE29E35792B081E6E83A7DFE3", hash_generated_method = "02829D3E86CB5FA2EC39813FBB35490C")
@android.view.RemotableViewMethod
    public void setImageBitmap(Bitmap bm) {
        // if this is used frequently, may handle bitmaps explicitly
        // to reduce the intermediate drawable object
        setImageDrawable(new BitmapDrawable(mContext.getResources(), bm));
    }

    @DSComment("Safe excetp setImageURI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.895 -0500", hash_original_method = "B00DD17D168377A844733E90ECCFE75B", hash_generated_method = "CEDF11FC1C80235ABD6BE1A8080A67AA")
    
public void setImageState(int[] state, boolean merge) {
        mState = state;
        mMergeState = merge;
        if (mDrawable != null) {
            refreshDrawableState();
            resizeFromDrawable();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.897 -0500", hash_original_method = "44CE6C01D324B2DC91AFD69B5F1BB742", hash_generated_method = "598BD5D57A4E32C3151CA42FAA846E12")
    
@Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        resizeFromDrawable();
    }

    /**
     * Sets the image level, when it is constructed from a 
     * {@link android.graphics.drawable.LevelListDrawable}.
     *
     * @param level The new level for the image.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.900 -0500", hash_original_method = "0A74FF8303919E2F74751A8C668C95F0", hash_generated_method = "844E4E43E119D6E9BF172C23ABC4A8F1")
    
@android.view.RemotableViewMethod
    public void setImageLevel(int level) {
        mLevel = level;
        if (mDrawable != null) {
            mDrawable.setLevel(level);
            resizeFromDrawable();
        }
    }

    /**
     * Controls how the image should be resized or moved to match the size
     * of this ImageView.
     * 
     * @param scaleType The desired scaling mode.
     * 
     * @attr ref android.R.styleable#ImageView_scaleType
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.910 -0500", hash_original_method = "63CC1440F0B24F3C6377C34C34E172F5", hash_generated_method = "9751751983FC74916A33102A2920D3D2")
    
public void setScaleType(ScaleType scaleType) {
        if (scaleType == null) {
            throw new NullPointerException();
        }

        if (mScaleType != scaleType) {
            mScaleType = scaleType;

            setWillNotCacheDrawing(mScaleType == ScaleType.CENTER);

            requestLayout();
            invalidate();
        }
    }
    
    /**
     * Return the current scale type in use by this ImageView.
     *
     * @see ImageView.ScaleType
     *
     * @attr ref android.R.styleable#ImageView_scaleType
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.912 -0500", hash_original_method = "84B4F1338E9C8554FC089CA7254325E0", hash_generated_method = "CC3C270B87F1214C4EF6FC1CA2D7633D")
    
public ScaleType getScaleType() {
        return mScaleType;
    }

    /** Return the view's optional matrix. This is applied to the
        view's drawable when it is drawn. If there is not matrix,
        this method will return null.
        Do not change this matrix in place. If you want a different matrix
        applied to the drawable, be sure to call setImageMatrix().
    */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.914 -0500", hash_original_method = "5B9FD9A0A164EA90D695E910523F6E96", hash_generated_method = "963AEFA2CB190844C895D26ABA80C3B5")
    
public Matrix getImageMatrix() {
        return mMatrix;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.916 -0500", hash_original_method = "A32A82AEE544A388BA62C8178AC7E88C", hash_generated_method = "5C00E4DE6909583021DDD7B5864A64A4")
    
public void setImageMatrix(Matrix matrix) {
        // collaps null and identity to just null
        if (matrix != null && matrix.isIdentity()) {
            matrix = null;
        }
        
        // don't invalidate unless we're actually changing our matrix
        if (matrix == null && !mMatrix.isIdentity() ||
                matrix != null && !mMatrix.equals(matrix)) {
            mMatrix.set(matrix);
            configureBounds();
            invalidate();
        }
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.919 -0500", hash_original_method = "16B1589372902AF87B2F0F65CBDC5B57", hash_generated_method = "9E444513D7A3946D402700F5F97124E8")
    
private void resolveUri() {
        if (mDrawable != null) {
            return;
        }

        Resources rsrc = getResources();
        if (rsrc == null) {
            return;
        }

        Drawable d = null;

        if (mResource != 0) {
            try {
                d = rsrc.getDrawable(mResource);
            } catch (Exception e) {
                Log.w("ImageView", "Unable to find resource: " + mResource, e);
                // Don't try again.
                mUri = null;
            }
        } else if (mUri != null) {
            String scheme = mUri.getScheme();
            if (ContentResolver.SCHEME_ANDROID_RESOURCE.equals(scheme)) {
                try {
                    // Load drawable through Resources, to get the source density information
                    ContentResolver.OpenResourceIdResult r =
                            mContext.getContentResolver().getResourceId(mUri);
                    d = r.r.getDrawable(r.id);
                } catch (Exception e) {
                    Log.w("ImageView", "Unable to open content: " + mUri, e);
                }
            } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)
                    || ContentResolver.SCHEME_FILE.equals(scheme)) {
                try {
                    d = Drawable.createFromStream(
                        mContext.getContentResolver().openInputStream(mUri),
                        null);
                } catch (Exception e) {
                    Log.w("ImageView", "Unable to open content: " + mUri, e);
                }
            } else {
                d = Drawable.createFromPath(mUri.toString());
            }
    
            if (d == null) {
                System.out.println("resolveUri failed on bad bitmap uri: "
                                   + mUri);
                // Don't try again.
                mUri = null;
            }
        } else {
            return;
        }

        updateDrawable(d);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.922 -0500", hash_original_method = "F00D7A8DB32B373F9AAF90A3CC19DF16", hash_generated_method = "E97103B7FB1E1BDB8A8F4E51FAA6E936")
    
@Override
    public int[] onCreateDrawableState(int extraSpace) {
        if (mState == null) {
            return super.onCreateDrawableState(extraSpace);
        } else if (!mMergeState) {
            return mState;
        } else {
            return mergeDrawableStates(
                    super.onCreateDrawableState(extraSpace + mState.length), mState);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.924 -0500", hash_original_method = "ADE7139D7C0A9B2AE00EA96739AFBDE5", hash_generated_method = "80B1FEE40FC36960351DCCFEA52EF2A7")
    
private void updateDrawable(Drawable d) {
        if (mDrawable != null) {
            mDrawable.setCallback(null);
            unscheduleDrawable(mDrawable);
        }
        mDrawable = d;
        if (d != null) {
            d.setCallback(this);
            if (d.isStateful()) {
                d.setState(getDrawableState());
            }
            d.setLevel(mLevel);
            mDrawableWidth = d.getIntrinsicWidth();
            mDrawableHeight = d.getIntrinsicHeight();
            applyColorMod();
            configureBounds();
        } else {
            mDrawableWidth = mDrawableHeight = -1;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.926 -0500", hash_original_method = "E1DD34F979587974CF0EAF8DF3CFC3FF", hash_generated_method = "17408C02AC3DAA1C31766AA624CC92D6")
    
private void resizeFromDrawable() {
        Drawable d = mDrawable;
        if (d != null) {
            int w = d.getIntrinsicWidth();
            if (w < 0) w = mDrawableWidth;
            int h = d.getIntrinsicHeight();
            if (h < 0) h = mDrawableHeight;
            if (w != mDrawableWidth || h != mDrawableHeight) {
                mDrawableWidth = w;
                mDrawableHeight = h;
                requestLayout();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.935 -0500", hash_original_method = "5D5C8E0C5B3B131983F43D2E85F23CCE", hash_generated_method = "8319D3DB8BBFBDB5D1DFCB3D599269D0")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        resolveUri();
        int w;
        int h;
        
        // Desired aspect ratio of the view's contents (not including padding)
        float desiredAspect = 0.0f;
        
        // We are allowed to change the view's width
        boolean resizeWidth = false;
        
        // We are allowed to change the view's height
        boolean resizeHeight = false;
        
        final int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        if (mDrawable == null) {
            // If no drawable, its intrinsic size is 0.
            mDrawableWidth = -1;
            mDrawableHeight = -1;
            w = h = 0;
        } else {
            w = mDrawableWidth;
            h = mDrawableHeight;
            if (w <= 0) w = 1;
            if (h <= 0) h = 1;

            // We are supposed to adjust view bounds to match the aspect
            // ratio of our drawable. See if that is possible.
            if (mAdjustViewBounds) {
                resizeWidth = widthSpecMode != MeasureSpec.EXACTLY;
                resizeHeight = heightSpecMode != MeasureSpec.EXACTLY;
                
                desiredAspect = (float) w / (float) h;
            }
        }
        
        int pleft = mPaddingLeft;
        int pright = mPaddingRight;
        int ptop = mPaddingTop;
        int pbottom = mPaddingBottom;

        int widthSize;
        int heightSize;

        if (resizeWidth || resizeHeight) {
            /* If we get here, it means we want to resize to match the
                drawables aspect ratio, and we have the freedom to change at
                least one dimension. 
            */

            // Get the max possible width given our constraints
            widthSize = resolveAdjustedSize(w + pleft + pright, mMaxWidth, widthMeasureSpec);

            // Get the max possible height given our constraints
            heightSize = resolveAdjustedSize(h + ptop + pbottom, mMaxHeight, heightMeasureSpec);

            if (desiredAspect != 0.0f) {
                // See what our actual aspect ratio is
                float actualAspect = (float)(widthSize - pleft - pright) /
                                        (heightSize - ptop - pbottom);
                
                if (Math.abs(actualAspect - desiredAspect) > 0.0000001) {
                    
                    boolean done = false;
                    
                    // Try adjusting width to be proportional to height
                    if (resizeWidth) {
                        int newWidth = (int)(desiredAspect * (heightSize - ptop - pbottom)) +
                                pleft + pright;
                        if (newWidth <= widthSize) {
                            widthSize = newWidth;
                            done = true;
                        } 
                    }
                    
                    // Try adjusting height to be proportional to width
                    if (!done && resizeHeight) {
                        int newHeight = (int)((widthSize - pleft - pright) / desiredAspect) +
                                ptop + pbottom;
                        if (newHeight <= heightSize) {
                            heightSize = newHeight;
                        }
                    }
                }
            }
        } else {
            /* We are either don't want to preserve the drawables aspect ratio,
               or we are not allowed to change view dimensions. Just measure in
               the normal way.
            */
            w += pleft + pright;
            h += ptop + pbottom;
                
            w = Math.max(w, getSuggestedMinimumWidth());
            h = Math.max(h, getSuggestedMinimumHeight());

            widthSize = resolveSizeAndState(w, widthMeasureSpec, 0);
            heightSize = resolveSizeAndState(h, heightMeasureSpec, 0);
        }

        setMeasuredDimension(widthSize, heightSize);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.938 -0500", hash_original_method = "6790E6B3204D72187344DF3593244181", hash_generated_method = "ED96FBCE6F6543E0C8770FCCFDAE4D32")
    
private int resolveAdjustedSize(int desiredSize, int maxSize,
                                   int measureSpec) {
        int result = desiredSize;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize =  MeasureSpec.getSize(measureSpec);
        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
                /* Parent says we can be as big as we want. Just don't be larger
                   than max size imposed on ourselves.
                */
                result = Math.min(desiredSize, maxSize);
                break;
            case MeasureSpec.AT_MOST:
                // Parent says we can be as big as we want, up to specSize. 
                // Don't be larger than specSize, and don't be larger than 
                // the max size imposed on ourselves.
                result = Math.min(Math.min(desiredSize, specSize), maxSize);
                break;
            case MeasureSpec.EXACTLY:
                // No choice. Do what we are told.
                result = specSize;
                break;
        }
        return result;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.941 -0500", hash_original_method = "7ED99727E4B1435AFDB83292B92819BD", hash_generated_method = "876449C83FF72421E42296BD5B0C29C3")
    
@Override
    protected boolean setFrame(int l, int t, int r, int b) {
        boolean changed = super.setFrame(l, t, r, b);
        mHaveFrame = true;
        configureBounds();
        return changed;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.944 -0500", hash_original_method = "3A8E22D575255E0F3266968983CC3C02", hash_generated_method = "3939CC816FBF686E2BC72F2560042F62")
    
private void configureBounds() {
        if (mDrawable == null || !mHaveFrame) {
            return;
        }

        int dwidth = mDrawableWidth;
        int dheight = mDrawableHeight;

        int vwidth = getWidth() - mPaddingLeft - mPaddingRight;
        int vheight = getHeight() - mPaddingTop - mPaddingBottom;

        boolean fits = (dwidth < 0 || vwidth == dwidth) &&
                       (dheight < 0 || vheight == dheight);

        if (dwidth <= 0 || dheight <= 0 || ScaleType.FIT_XY == mScaleType) {
            /* If the drawable has no intrinsic size, or we're told to
                scaletofit, then we just fill our entire view.
            */
            mDrawable.setBounds(0, 0, vwidth, vheight);
            mDrawMatrix = null;
        } else {
            // We need to do the scaling ourself, so have the drawable
            // use its native size.
            mDrawable.setBounds(0, 0, dwidth, dheight);

            if (ScaleType.MATRIX == mScaleType) {
                // Use the specified matrix as-is.
                if (mMatrix.isIdentity()) {
                    mDrawMatrix = null;
                } else {
                    mDrawMatrix = mMatrix;
                }
            } else if (fits) {
                // The bitmap fits exactly, no transform needed.
                mDrawMatrix = null;
            } else if (ScaleType.CENTER == mScaleType) {
                // Center bitmap in view, no scaling.
                mDrawMatrix = mMatrix;
                mDrawMatrix.setTranslate((int) ((vwidth - dwidth) * 0.5f + 0.5f),
                                         (int) ((vheight - dheight) * 0.5f + 0.5f));
            } else if (ScaleType.CENTER_CROP == mScaleType) {
                mDrawMatrix = mMatrix;

                float scale;
                float dx = 0, dy = 0;

                if (dwidth * vheight > vwidth * dheight) {
                    scale = (float) vheight / (float) dheight; 
                    dx = (vwidth - dwidth * scale) * 0.5f;
                } else {
                    scale = (float) vwidth / (float) dwidth;
                    dy = (vheight - dheight * scale) * 0.5f;
                }

                mDrawMatrix.setScale(scale, scale);
                mDrawMatrix.postTranslate((int) (dx + 0.5f), (int) (dy + 0.5f));
            } else if (ScaleType.CENTER_INSIDE == mScaleType) {
                mDrawMatrix = mMatrix;
                float scale;
                float dx;
                float dy;
                
                if (dwidth <= vwidth && dheight <= vheight) {
                    scale = 1.0f;
                } else {
                    scale = Math.min((float) vwidth / (float) dwidth,
                            (float) vheight / (float) dheight);
                }
                
                dx = (int) ((vwidth - dwidth * scale) * 0.5f + 0.5f);
                dy = (int) ((vheight - dheight * scale) * 0.5f + 0.5f);

                mDrawMatrix.setScale(scale, scale);
                mDrawMatrix.postTranslate(dx, dy);
            } else {
                // Generate the required transform.
                mTempSrc.set(0, 0, dwidth, dheight);
                mTempDst.set(0, 0, vwidth, vheight);
                
                mDrawMatrix = mMatrix;
                mDrawMatrix.setRectToRect(mTempSrc, mTempDst, scaleTypeToScaleToFit(mScaleType));
            }
        }
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.947 -0500", hash_original_method = "D78E25577A68DABE40154D5E4D97E50D", hash_generated_method = "CFB86CD773D46F6966C7A0C21D7978F2")
    
@Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable d = mDrawable;
        if (d != null && d.isStateful()) {
            d.setState(getDrawableState());
        }
    }

    @DSVerified("Called from View construction")
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.949 -0500", hash_original_method = "355C7834E61DDE917A6F527556974749", hash_generated_method = "1C9D798A9510D9155570D002AE5DB66C")
    
@Override 
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mDrawable == null) {
            return; // couldn't resolve the URI
        }

        if (mDrawableWidth == 0 || mDrawableHeight == 0) {
            return;     // nothing to draw (empty bounds)
        }

        if (mDrawMatrix == null && mPaddingTop == 0 && mPaddingLeft == 0) {
            mDrawable.draw(canvas);
        } else {
            int saveCount = canvas.getSaveCount();
            canvas.save();
            
            if (mCropToPadding) {
                final int scrollX = mScrollX;
                final int scrollY = mScrollY;
                canvas.clipRect(scrollX + mPaddingLeft, scrollY + mPaddingTop,
                        scrollX + mRight - mLeft - mPaddingRight,
                        scrollY + mBottom - mTop - mPaddingBottom);
            }
            
            canvas.translate(mPaddingLeft, mPaddingTop);

            if (mDrawMatrix != null) {
                canvas.concat(mDrawMatrix);
            }
            mDrawable.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    /**
     * <p>Return the offset of the widget's text baseline from the widget's top
     * boundary. </p>
     *
     * @return the offset of the baseline within the widget's bounds or -1
     *         if baseline alignment is not supported.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.952 -0500", hash_original_method = "697E0DCA3A40ADA0E60547E8AD02CB08", hash_generated_method = "6EB491C14EA109A0AB1664B84B756DAF")
    
@Override
    @ViewDebug.ExportedProperty(category = "layout")
    public int getBaseline() {
        if (mBaselineAlignBottom) {
            return getMeasuredHeight();
        } else {
            return mBaseline;
        }
    }

    /**
     * <p>Set the offset of the widget's text baseline from the widget's top
     * boundary.  This value is overridden by the {@link #setBaselineAlignBottom(boolean)}
     * property.</p>
     *
     * @param baseline The baseline to use, or -1 if none is to be provided.
     *
     * @see #setBaseline(int) 
     * @attr ref android.R.styleable#ImageView_baseline
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.954 -0500", hash_original_method = "8108AC4FDDF644F63A2CB47972E74B33", hash_generated_method = "83600EE97B058D095A2D10FFFFBB3746")
    
public void setBaseline(int baseline) {
        if (mBaseline != baseline) {
            mBaseline = baseline;
            requestLayout();
        }
    }

    /**
     * Set whether to set the baseline of this view to the bottom of the view.
     * Setting this value overrides any calls to setBaseline.
     *
     * @param aligned If true, the image view will be baseline aligned with
     *      based on its bottom edge.
     *
     * @attr ref android.R.styleable#ImageView_baselineAlignBottom
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.956 -0500", hash_original_method = "ACC3D162C0B2FC40FF806607AF970BEE", hash_generated_method = "E377A5C610637DED1C9C3EFAF40E53C3")
    
public void setBaselineAlignBottom(boolean aligned) {
        if (mBaselineAlignBottom != aligned) {
            mBaselineAlignBottom = aligned;
            requestLayout();
        }
    }

    /**
     * Return whether this view's baseline will be considered the bottom of the view.
     *
     * @see #setBaselineAlignBottom(boolean)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.958 -0500", hash_original_method = "7D3365C5D6F47846F65EFD0480835D79", hash_generated_method = "2994E74552E351861F3CAEEAFD355B13")
    
public boolean getBaselineAlignBottom() {
        return mBaselineAlignBottom;
    }

    /**
     * Set a tinting option for the image.
     * 
     * @param color Color tint to apply.
     * @param mode How to apply the color.  The standard mode is
     * {@link PorterDuff.Mode#SRC_ATOP}
     * 
     * @attr ref android.R.styleable#ImageView_tint
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.960 -0500", hash_original_method = "F0522F608E5F96C5D99BDA1CF055B16B", hash_generated_method = "A86C859E0F7D8CCCBFCF8B9E55E093B7")
    
public final void setColorFilter(int color, PorterDuff.Mode mode) {
        setColorFilter(new PorterDuffColorFilter(color, mode));
    }

    /**
     * Set a tinting option for the image. Assumes
     * {@link PorterDuff.Mode#SRC_ATOP} blending mode.
     *
     * @param color Color tint to apply.
     * @attr ref android.R.styleable#ImageView_tint
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.964 -0500", hash_original_method = "50A13570451A3C69931555EF0FE8C15D", hash_generated_method = "49C84EA77644D9EE4E13B1955DA23D44")
    
@RemotableViewMethod
    public final void setColorFilter(int color) {
        setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.966 -0500", hash_original_method = "B358CFD4AAFD748C624F742F21F12081", hash_generated_method = "EFE3CA9A1FD4315CFE95DE39833162C9")
    
public final void clearColorFilter() {
        setColorFilter(null);
    }
    
    /**
     * Apply an arbitrary colorfilter to the image.
     *
     * @param cf the colorfilter to apply (may be null)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.968 -0500", hash_original_method = "0E997722FEDD3E607A6B49B3558418D6", hash_generated_method = "8831A4BEFC9FE8E4D7C3095C72020B73")
    
public void setColorFilter(ColorFilter cf) {
        if (mColorFilter != cf) {
            mColorFilter = cf;
            mColorMod = true;
            applyColorMod();
            invalidate();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.970 -0500", hash_original_method = "F29539FC5DE82D33A1732D8CBDF1B3F0", hash_generated_method = "FA4FC55525E8C03A0249EAF7F7D3F5DA")
    
@RemotableViewMethod
    public void setAlpha(int alpha) {
        alpha &= 0xFF;          // keep it legal
        if (mAlpha != alpha) {
            mAlpha = alpha;
            mColorMod = true;
            applyColorMod();
            invalidate();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.972 -0500", hash_original_method = "91840135D820437FBAEF19E5465CA144", hash_generated_method = "C9250591CCE93258AD6133AF380965D2")
    
private void applyColorMod() {
        // Only mutate and apply when modifications have occurred. This should
        // not reset the mColorMod flag, since these filters need to be
        // re-applied if the Drawable is changed.
        if (mDrawable != null && mColorMod) {
            mDrawable = mDrawable.mutate();
            mDrawable.setColorFilter(mColorFilter);
            mDrawable.setAlpha(mAlpha * mViewAlphaScale >> 8);
        }
    }

    @DSComment("Safe excetp setImageURI")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.975 -0500", hash_original_method = "C6B07741C64FD260DDE5C02AC0455E05", hash_generated_method = "AFDD61839AA6E68F5AC2CEE81161A784")
    
@RemotableViewMethod
    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (mDrawable != null) {
            mDrawable.setVisible(visibility == VISIBLE, false);
        }
    }
    
    public enum ScaleType {
        MATRIX      (0),
        FIT_XY      (1),
        FIT_START   (2),
        FIT_CENTER  (3),
        FIT_END     (4),
        CENTER      (5),
        CENTER_CROP (6),
        CENTER_INSIDE (7);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.904 -0500", hash_original_method = "F41181DAFC695E4B905332BC9C26078F", hash_generated_method = "F41181DAFC695E4B905332BC9C26078F")
            
ScaleType(int ni) {
            nativeInt = ni;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.906 -0500", hash_original_field = "6B116C6445FBD920A2653C64D32C9FB3", hash_generated_field = "6B116C6445FBD920A2653C64D32C9FB3")

         int nativeInt;
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.977 -0500", hash_original_method = "3717E0990FC85EED7B1343A97507698D", hash_generated_method = "E9CFEA04097042E9FE4E2353AE312A91")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mDrawable != null) {
            mDrawable.setVisible(getVisibility() == VISIBLE, false);
        }
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:15.979 -0500", hash_original_method = "66E6E711A91B2172E1C35BB591AC6445", hash_generated_method = "1DC3531588F772DCE2F68275AE751A24")
    
@Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mDrawable != null) {
            mDrawable.setVisible(false, false);
        }
    }
}

