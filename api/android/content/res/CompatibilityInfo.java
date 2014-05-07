package android.content.res;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.pm.ApplicationInfo;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class CompatibilityInfo implements Parcelable {

    /**
     * Compute the frame Rect for applications runs under compatibility mode.
     *
     * @param dm the display metrics used to compute the frame size.
     * @param orientation the orientation of the screen.
     * @param outRect the output parameter which will contain the result.
     * @return Returns the scaling factor for the window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.201 -0500", hash_original_method = "5B98F5827867C3DC60F60E22E81275D2", hash_generated_method = "F06992E51E8E0196730E3864224731B8")
    
public static float computeCompatibleScaling(DisplayMetrics dm, DisplayMetrics outDm) {
        final int width = dm.noncompatWidthPixels;
        final int height = dm.noncompatHeightPixels;
        int shortSize, longSize;
        if (width < height) {
            shortSize = width;
            longSize = height;
        } else {
            shortSize = height;
            longSize = width;
        }
        int newShortSize = (int)(DEFAULT_NORMAL_SHORT_DIMENSION * dm.density + 0.5f);
        float aspect = ((float)longSize) / shortSize;
        if (aspect > MAXIMUM_ASPECT_RATIO) {
            aspect = MAXIMUM_ASPECT_RATIO;
        }
        int newLongSize = (int)(newShortSize * aspect + 0.5f);
        int newWidth, newHeight;
        if (width < height) {
            newWidth = newShortSize;
            newHeight = newLongSize;
        } else {
            newWidth = newLongSize;
            newHeight = newShortSize;
        }

        float sw = width/(float)newWidth;
        float sh = height/(float)newHeight;
        float scale = sw < sh ? sw : sh;
        if (scale < 1) {
            scale = 1;
        }

        if (outDm != null) {
            outDm.widthPixels = newWidth;
            outDm.heightPixels = newHeight;
        }

        return scale;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.102 -0500", hash_original_field = "24D7DD93100E12671A8B11BA9EB294E7", hash_generated_field = "08F5AA372944765B46BC517FBE4DAD3A")

    public static final CompatibilityInfo DEFAULT_COMPATIBILITY_INFO = new CompatibilityInfo() {
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.104 -0500", hash_original_field = "2DEBCA9B4E75DE24C978F7242AD31BF6", hash_generated_field = "55912B57605F0907923E81814B30C0CE")

    public static final int DEFAULT_NORMAL_SHORT_DIMENSION = 320;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.106 -0500", hash_original_field = "9D2DAB1867EF9BC26D5BEC4181431E33", hash_generated_field = "8D1764CCB355F9E44B73ECAF9C0E1A67")

    public static final float MAXIMUM_ASPECT_RATIO = (854f/480f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.111 -0500", hash_original_field = "87DF0C32185DB143129174F4AB47551C", hash_generated_field = "FE8F3097DE77D4A5968EA9E99511671D")

    private static final int SCALING_REQUIRED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.113 -0500", hash_original_field = "79A8F7261F85A720E99D0E78F88481EE", hash_generated_field = "783C1B480AFA79751F1953AF0C3E699E")

    private static final int ALWAYS_NEEDS_COMPAT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.116 -0500", hash_original_field = "071B61C8A1944AEB594BFCC49A9F58B7", hash_generated_field = "E0E953FF12F7A9AC5E30F9487F011934")

    private static final int NEVER_NEEDS_COMPAT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.118 -0500", hash_original_field = "55B91A0114E520EBBECA15EA2992BAA2", hash_generated_field = "BAA6E0AAF402CD0959A7E08540FA5CC3")

    private static final int NEEDS_SCREEN_COMPAT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.202 -0400", hash_original_field = "22851AF58516589EBC6294DD83CB7F2D", hash_generated_field = "DDAA02554421F72326F350E7F40CEA00")

    public static final Parcelable.Creator<CompatibilityInfo> CREATOR
            = new Parcelable.Creator<CompatibilityInfo>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.216 -0500", hash_original_method = "2114E6EBB23116BFD4134066FF759826", hash_generated_method = "89274CD61C251EA445D8CD9D28BC58BE")
        
public CompatibilityInfo createFromParcel(Parcel source) {
            return new CompatibilityInfo(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.218 -0500", hash_original_method = "005F3B39CF5633E13C56EF8C7CCB7246", hash_generated_method = "7F2D9C8D16FED6519D9855D340807E83")
        
public CompatibilityInfo[] newArray(int size) {
            return new CompatibilityInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.109 -0500", hash_original_field = "8DF635377EEFC745F4433FB1D0E1B6C8", hash_generated_field = "B4CB39B5E76E4F134AE9FD81F38E628C")

    private  int mCompatibilityFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.120 -0500", hash_original_field = "F8B31777EC6471CEDD19807009559AD7", hash_generated_field = "D4940D12226C2B60194AF35187704159")

    public  int applicationDensity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.122 -0500", hash_original_field = "7DEEE262D55E0BA5F3DCA380FFEC5E0C", hash_generated_field = "14E3397589B948719667F1E3AF571289")

    public  float applicationScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.124 -0500", hash_original_field = "73726C643777E4057E9D09447815395E", hash_generated_field = "FB16C6B90478FF3C6286ADC11FCB2FCF")

    public  float applicationInvertedScale;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.129 -0500", hash_original_method = "9C59C0A19ADE82EBF59B39AA82601FD9", hash_generated_method = "3EE26DA37586942F4937648FAC38A9AD")
    
public CompatibilityInfo(ApplicationInfo appInfo, int screenLayout, int sw,
            boolean forceCompat) {
        int compatFlags = 0;

        if (appInfo.requiresSmallestWidthDp != 0 || appInfo.compatibleWidthLimitDp != 0
                || appInfo.largestWidthLimitDp != 0) {
            // New style screen requirements spec.
            int required = appInfo.requiresSmallestWidthDp != 0
                    ? appInfo.requiresSmallestWidthDp
                    : appInfo.compatibleWidthLimitDp;
            if (required == 0) {
                required = appInfo.largestWidthLimitDp;
            }
            int compat = appInfo.compatibleWidthLimitDp != 0
                    ? appInfo.compatibleWidthLimitDp : required;
            if (compat < required)  {
                compat = required;
            }
            int largest = appInfo.largestWidthLimitDp;

            if (required > DEFAULT_NORMAL_SHORT_DIMENSION) {
                // For now -- if they require a size larger than the only
                // size we can do in compatibility mode, then don't ever
                // allow the app to go in to compat mode.  Trying to run
                // it at a smaller size it can handle will make it far more
                // broken than running at a larger size than it wants or
                // thinks it can handle.
                compatFlags |= NEVER_NEEDS_COMPAT;
            } else if (largest != 0 && sw > largest) {
                // If the screen size is larger than the largest size the
                // app thinks it can work with, then always force it in to
                // compatibility mode.
                compatFlags |= NEEDS_SCREEN_COMPAT | ALWAYS_NEEDS_COMPAT;
            } else if (compat >= sw) {
                // The screen size is something the app says it was designed
                // for, so never do compatibility mode.
                compatFlags |= NEVER_NEEDS_COMPAT;
            } else if (forceCompat) {
                // The app may work better with or without compatibility mode.
                // Let the user decide.
                compatFlags |= NEEDS_SCREEN_COMPAT;
            }

            // Modern apps always support densities.
            applicationDensity = DisplayMetrics.DENSITY_DEVICE;
            applicationScale = 1.0f;
            applicationInvertedScale = 1.0f;

        } else {
            /**
             * Has the application said that its UI is expandable?  Based on the
             * <supports-screen> android:expandible in the manifest.
             */
            final int EXPANDABLE = 2;

            /**
             * Has the application said that its UI supports large screens?  Based on the
             * <supports-screen> android:largeScreens in the manifest.
             */
            final int LARGE_SCREENS = 8;

            /**
             * Has the application said that its UI supports xlarge screens?  Based on the
             * <supports-screen> android:xlargeScreens in the manifest.
             */
            final int XLARGE_SCREENS = 32;

            int sizeInfo = 0;

            // We can't rely on the application always setting
            // FLAG_RESIZEABLE_FOR_SCREENS so will compute it based on various input.
            boolean anyResizeable = false;

            if ((appInfo.flags & ApplicationInfo.FLAG_SUPPORTS_LARGE_SCREENS) != 0) {
                sizeInfo |= LARGE_SCREENS;
                anyResizeable = true;
                if (!forceCompat) {
                    // If we aren't forcing the app into compatibility mode, then
                    // assume if it supports large screens that we should allow it
                    // to use the full space of an xlarge screen as well.
                    sizeInfo |= XLARGE_SCREENS | EXPANDABLE;
                }
            }
            if ((appInfo.flags & ApplicationInfo.FLAG_SUPPORTS_XLARGE_SCREENS) != 0) {
                anyResizeable = true;
                if (!forceCompat) {
                    sizeInfo |= XLARGE_SCREENS | EXPANDABLE;
                }
            }
            if ((appInfo.flags & ApplicationInfo.FLAG_RESIZEABLE_FOR_SCREENS) != 0) {
                anyResizeable = true;
                sizeInfo |= EXPANDABLE;
            }

            if (forceCompat) {
                // If we are forcing compatibility mode, then ignore an app that
                // just says it is resizable for screens.  We'll only have it fill
                // the screen if it explicitly says it supports the screen size we
                // are running in.
                sizeInfo &= ~EXPANDABLE;
            }

            compatFlags |= NEEDS_SCREEN_COMPAT;
            switch (screenLayout&Configuration.SCREENLAYOUT_SIZE_MASK) {
                case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                    if ((sizeInfo&XLARGE_SCREENS) != 0) {
                        compatFlags &= ~NEEDS_SCREEN_COMPAT;
                    }
                    if ((appInfo.flags & ApplicationInfo.FLAG_SUPPORTS_XLARGE_SCREENS) != 0) {
                        compatFlags |= NEVER_NEEDS_COMPAT;
                    }
                    break;
                case Configuration.SCREENLAYOUT_SIZE_LARGE:
                    if ((sizeInfo&LARGE_SCREENS) != 0) {
                        compatFlags &= ~NEEDS_SCREEN_COMPAT;
                    }
                    if ((appInfo.flags & ApplicationInfo.FLAG_SUPPORTS_LARGE_SCREENS) != 0) {
                        compatFlags |= NEVER_NEEDS_COMPAT;
                    }
                    break;
            }

            if ((screenLayout&Configuration.SCREENLAYOUT_COMPAT_NEEDED) != 0) {
                if ((sizeInfo&EXPANDABLE) != 0) {
                    compatFlags &= ~NEEDS_SCREEN_COMPAT;
                } else if (!anyResizeable) {
                    compatFlags |= ALWAYS_NEEDS_COMPAT;
                }
            } else {
                compatFlags &= ~NEEDS_SCREEN_COMPAT;
                compatFlags |= NEVER_NEEDS_COMPAT;
            }

            if ((appInfo.flags & ApplicationInfo.FLAG_SUPPORTS_SCREEN_DENSITIES) != 0) {
                applicationDensity = DisplayMetrics.DENSITY_DEVICE;
                applicationScale = 1.0f;
                applicationInvertedScale = 1.0f;
            } else {
                applicationDensity = DisplayMetrics.DENSITY_DEFAULT;
                applicationScale = DisplayMetrics.DENSITY_DEVICE
                        / (float) DisplayMetrics.DENSITY_DEFAULT;
                applicationInvertedScale = 1.0f / applicationScale;
                compatFlags |= SCALING_REQUIRED;
            }
        }

        mCompatibilityFlags = compatFlags;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.132 -0500", hash_original_method = "A82321676D9C84B0538DAFB6CC61C0CB", hash_generated_method = "99F15940337421297145D82B025205D1")
    
private CompatibilityInfo(int compFlags,
            int dens, float scale, float invertedScale) {
        mCompatibilityFlags = compFlags;
        applicationDensity = dens;
        applicationScale = scale;
        applicationInvertedScale = invertedScale;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.135 -0500", hash_original_method = "3DDB26515D25880873E2C6C7F1DDA6F5", hash_generated_method = "2817656ABBA0B85869FD1B589629376D")
    
private CompatibilityInfo() {
        this(NEVER_NEEDS_COMPAT, DisplayMetrics.DENSITY_DEVICE,
                1.0f,
                1.0f);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.224 -0500", hash_original_method = "B251F1B77EF355BF6FA118A826DF4F4A", hash_generated_method = "1C24C499A40E0EAF4FCB6630E02B4573")
    
private CompatibilityInfo(Parcel source) {
        mCompatibilityFlags = source.readInt();
        applicationDensity = source.readInt();
        applicationScale = source.readFloat();
        applicationInvertedScale = source.readFloat();
    }

    /**
     * @return true if the scaling is required
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.137 -0500", hash_original_method = "E2D07E7BFECA2D29A0CD39AB3E4AD2F4", hash_generated_method = "CE3ECB8A302D492657575F56F106DDC0")
    
public boolean isScalingRequired() {
        return toTaintBoolean(mCompatibilityFlags&SCALING_REQUIRED);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.139 -0500", hash_original_method = "AEF0832D3207872CC75E4AC6D7849C73", hash_generated_method = "63741BA273D23971F1DD1BD664397649")
    
public boolean supportsScreen() {
        return toTaintBoolean(mCompatibilityFlags&NEEDS_SCREEN_COMPAT);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.141 -0500", hash_original_method = "BD11775B1F66D2736A032A6A37E2552F", hash_generated_method = "DFAB80F286B6871F3C74F69E74D52217")
    
public boolean neverSupportsScreen() {
        return toTaintBoolean(mCompatibilityFlags&ALWAYS_NEEDS_COMPAT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.144 -0500", hash_original_method = "CFA6F9CFCD9588B682D5F07DFF385684", hash_generated_method = "ADBF8E57DB7043C0B1D7DA74EE10E29B")
    
public boolean alwaysSupportsScreen() {
        return toTaintBoolean(mCompatibilityFlags&NEVER_NEEDS_COMPAT);
    }
    
    public class Translator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.149 -0500", hash_original_field = "7DEEE262D55E0BA5F3DCA380FFEC5E0C", hash_generated_field = "14E3397589B948719667F1E3AF571289")

         public float applicationScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.151 -0500", hash_original_field = "73726C643777E4057E9D09447815395E", hash_generated_field = "FB16C6B90478FF3C6286ADC11FCB2FCF")

         public float applicationInvertedScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.154 -0500", hash_original_field = "2A4BEE6C2588E84372B845F2C5A81EFA", hash_generated_field = "C20DA98F4A08CF10BAA7142D933BD66B")
        
        private Rect mContentInsetsBuffer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.156 -0500", hash_original_field = "2CA50AF598DDAF6290D1E4A05BF40D5B", hash_generated_field = "1C9F92E30D2ADEA2CAAF0B834CACAAC8")

        private Rect mVisibleInsetsBuffer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.158 -0500", hash_original_field = "DBD92DD5019C51C6E2DB04DC77C8FD7C", hash_generated_field = "971A29021FD305F495522776D9E154AB")

        private Region mTouchableAreaBuffer = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.161 -0500", hash_original_method = "8F3615DA11565DF9F003F5DF13D87652", hash_generated_method = "8F3615DA11565DF9F003F5DF13D87652")
        
Translator(float applicationScale, float applicationInvertedScale) {
            this.applicationScale = applicationScale;
            this.applicationInvertedScale = applicationInvertedScale;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.163 -0500", hash_original_method = "AAEFB3B2AA6A68EC0C613C02DA13C765", hash_generated_method = "AAEFB3B2AA6A68EC0C613C02DA13C765")
        
Translator() {
            this(CompatibilityInfo.this.applicationScale,
                    CompatibilityInfo.this.applicationInvertedScale);
        }

        /**
         * Translate the screen rect to the application frame.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.165 -0500", hash_original_method = "36CC389463C4EECA1FFAD848C8F58415", hash_generated_method = "62D8E0A4D8CCC7877B84B1CF12FFBF67")
        
public void translateRectInScreenToAppWinFrame(Rect rect) {
            rect.scale(applicationInvertedScale);
        }

        /**
         * Translate the region in window to screen. 
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.167 -0500", hash_original_method = "0A49DDBACE394A9C82B87775AA7B8808", hash_generated_method = "293BD915A2442BE026647A9A084D12D6")
        
public void translateRegionInWindowToScreen(Region transparentRegion) {
            transparentRegion.scale(applicationScale);
        }

        /**
         * Apply translation to the canvas that is necessary to draw the content.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.170 -0500", hash_original_method = "F6C04E9988D3236CD1A288419E980857", hash_generated_method = "7612AE10D13E81EDBA912B57B2D15B6D")
        
public void translateCanvas(Canvas canvas) {
            if (applicationScale == 1.5f) {
                /*  When we scale for compatibility, we can put our stretched
                    bitmaps and ninepatches on exacty 1/2 pixel boundaries,
                    which can give us inconsistent drawing due to imperfect
                    float precision in the graphics engine's inverse matrix.
                 
                    As a work-around, we translate by a tiny amount to avoid
                    landing on exact pixel centers and boundaries, giving us
                    the slop we need to draw consistently.
                 
                    This constant is meant to resolve to 1/255 after it is
                    scaled by 1.5 (applicationScale). Note, this is just a guess
                    as to what is small enough not to create its own artifacts,
                    and big enough to avoid the precision problems. Feel free
                    to experiment with smaller values as you choose.
                 */
                final float tinyOffset = 2.0f / (3 * 255);
                canvas.translate(tinyOffset, tinyOffset);
            }
            canvas.scale(applicationScale, applicationScale);
        }

        /**
         * Translate the motion event captured on screen to the application's window.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.172 -0500", hash_original_method = "4D5FCD5F9907EB8D629A45C5A11C2836", hash_generated_method = "34E607555BAE9F09B76A03C80F6A69F4")
        
public void translateEventInScreenToAppWindow(MotionEvent event) {
            event.scale(applicationInvertedScale);
        }

        /**
         * Translate the window's layout parameter, from application's view to
         * Screen's view.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.174 -0500", hash_original_method = "DE018C3EFE6320C8CBFF22F7586A6AFE", hash_generated_method = "99D4E31A8067C1F45C3E6784449B085B")
        
public void translateWindowLayout(WindowManager.LayoutParams params) {
            params.scale(applicationScale);
        }
        
        /**
         * Translate a Rect in application's window to screen.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.177 -0500", hash_original_method = "657A8C506709C2AB2507FE170E8B78C8", hash_generated_method = "CE8E2EC64AF62D6056C312FC6A164F9E")
        
public void translateRectInAppWindowToScreen(Rect rect) {
            rect.scale(applicationScale);
        }
 
        /**
         * Translate a Rect in screen coordinates into the app window's coordinates.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.179 -0500", hash_original_method = "5BBB001295BC7F6BF111AF6DC66C9205", hash_generated_method = "32B9B1D5AFC82207FB6EB8CF12436D3C")
        
public void translateRectInScreenToAppWindow(Rect rect) {
            rect.scale(applicationInvertedScale);
        }

        /**
         * Translate a Point in screen coordinates into the app window's coordinates.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.181 -0500", hash_original_method = "9DE177160064B2A1F8C9D8228C599CDD", hash_generated_method = "99855744DDC8DFBEDF34A8222C83CBF1")
        
public void translatePointInScreenToAppWindow(PointF point) {
            final float scale = applicationInvertedScale;
            if (scale != 1.0f) {
                point.x *= scale;
                point.y *= scale;
            }
        }

        /**
         * Translate the location of the sub window.
         * @param params
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.183 -0500", hash_original_method = "122ACDBA22A4D3B6B9E93FB00E1FAEC7", hash_generated_method = "2CCCACA7DE24F82A4B382CB9AEC20A70")
        
public void translateLayoutParamsInAppWindowToScreen(LayoutParams params) {
            params.scale(applicationScale);
        }

        /**
         * Translate the content insets in application window to Screen. This uses
         * the internal buffer for content insets to avoid extra object allocation.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.186 -0500", hash_original_method = "43D8C9F45845A6C6CC10427CCFCFAF3D", hash_generated_method = "A8D3417DD351B38B5A1BCE2011F2B9AF")
        
public Rect getTranslatedContentInsets(Rect contentInsets) {
            if (mContentInsetsBuffer == null) mContentInsetsBuffer = new Rect();
            mContentInsetsBuffer.set(contentInsets);
            translateRectInAppWindowToScreen(mContentInsetsBuffer);
            return mContentInsetsBuffer;
        }

        /**
         * Translate the visible insets in application window to Screen. This uses
         * the internal buffer for visible insets to avoid extra object allocation.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.189 -0500", hash_original_method = "DB46A5AF3015676AE668EB7338A074FC", hash_generated_method = "F6CF5ABCB151C32350958C8E1777F0A2")
        
public Rect getTranslatedVisibleInsets(Rect visibleInsets) {
            if (mVisibleInsetsBuffer == null) mVisibleInsetsBuffer = new Rect();
            mVisibleInsetsBuffer.set(visibleInsets);
            translateRectInAppWindowToScreen(mVisibleInsetsBuffer);
            return mVisibleInsetsBuffer;
        }

        /**
         * Translate the touchable area in application window to Screen. This uses
         * the internal buffer for touchable area to avoid extra object allocation.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.191 -0500", hash_original_method = "25CFF327B78CA768A3AFCA299ED2CC8E", hash_generated_method = "89B0C97888476B1C2E9BEB649369ACBC")
        
public Region getTranslatedTouchableArea(Region touchableArea) {
            if (mTouchableAreaBuffer == null) mTouchableAreaBuffer = new Region();
            mTouchableAreaBuffer.set(touchableArea);
            mTouchableAreaBuffer.scale(applicationScale);
            return mTouchableAreaBuffer;
        }
        
    }

    /**
     * Returns the translator which translates the coordinates in compatibility mode.
     * @param params the window's parameter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.146 -0500", hash_original_method = "93ABC602B8C8A6238860B5CA46099876", hash_generated_method = "CE46908278E605522D18B81C54930843")
    
public Translator getTranslator() {
        return isScalingRequired() ? new Translator() : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.196 -0500", hash_original_method = "F5DFBBE3DCF906040672C2B4A4880712", hash_generated_method = "74E9CBD1694558CAEF2BD58D741C7831")
    
public void applyToDisplayMetrics(DisplayMetrics inoutDm) {
        if (!supportsScreen()) {
            // This is a larger screen device and the app is not
            // compatible with large screens, so diddle it.
            CompatibilityInfo.computeCompatibleScaling(inoutDm, inoutDm);
        } else {
            inoutDm.widthPixels = inoutDm.noncompatWidthPixels;
            inoutDm.heightPixels = inoutDm.noncompatHeightPixels;
        }

        if (isScalingRequired()) {
            float invertedRatio = applicationInvertedScale;
            inoutDm.density = inoutDm.noncompatDensity * invertedRatio;
            inoutDm.densityDpi = (int)((inoutDm.density*DisplayMetrics.DENSITY_DEFAULT)+.5f);
            inoutDm.scaledDensity = inoutDm.noncompatScaledDensity * invertedRatio;
            inoutDm.xdpi = inoutDm.noncompatXdpi * invertedRatio;
            inoutDm.ydpi = inoutDm.noncompatYdpi * invertedRatio;
            inoutDm.widthPixels = (int) (inoutDm.widthPixels * invertedRatio + 0.5f);
            inoutDm.heightPixels = (int) (inoutDm.heightPixels * invertedRatio + 0.5f);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.199 -0500", hash_original_method = "D1D0A6DB2934A6F26FB8AACA9CE38F1E", hash_generated_method = "764817F496D51A1529DEB02FAEE61D77")
    
public void applyToConfiguration(Configuration inoutConfig) {
        if (!supportsScreen()) {
            // This is a larger screen device and the app is not
            // compatible with large screens, so we are forcing it to
            // run as if the screen is normal size.
            inoutConfig.screenLayout =
                    (inoutConfig.screenLayout&~Configuration.SCREENLAYOUT_SIZE_MASK)
                    | Configuration.SCREENLAYOUT_SIZE_NORMAL;
            inoutConfig.screenWidthDp = inoutConfig.compatScreenWidthDp;
            inoutConfig.screenHeightDp = inoutConfig.compatScreenHeightDp;
            inoutConfig.smallestScreenWidthDp = inoutConfig.compatSmallestScreenWidthDp;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.204 -0500", hash_original_method = "CD2E846E95D6DD1EBA23C219F15E8AAF", hash_generated_method = "6C5E82572C3EA72593F6A9928A69E8C6")
    
@Override
    public boolean equals(Object o) {
        try {
            CompatibilityInfo oc = (CompatibilityInfo)o;
            if (mCompatibilityFlags != oc.mCompatibilityFlags) return false;
            if (applicationDensity != oc.applicationDensity) return false;
            if (applicationScale != oc.applicationScale) return false;
            if (applicationInvertedScale != oc.applicationInvertedScale) return false;

            return toTaintBoolean(getTaintInt() + o.getTaintInt() +
                                 mCompatibilityFlags  + oc.mCompatibilityFlags +
                                 applicationScale + oc.applicationScale + 
                                 applicationInvertedScale + oc.applicationInvertedScale);

        } catch (ClassCastException e) {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.207 -0500", hash_original_method = "8391774F9F4D17C2A23793FA4442739E", hash_generated_method = "685B7658A0AF5FABA6D96E9C4AE873B4")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("{");
        sb.append(applicationDensity);
        sb.append("dpi");
        if (isScalingRequired()) {
            sb.append(" ");
            sb.append(applicationScale);
            sb.append("x");
        }
        if (!supportsScreen()) {
            sb.append(" resizing");
        }
        if (neverSupportsScreen()) {
            sb.append(" never-compat");
        }
        if (alwaysSupportsScreen()) {
            sb.append(" always-compat");
        }
        sb.append("}");
        return sb.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.209 -0500", hash_original_method = "8473CF5A5DF2B74B5499D26C5398575D", hash_generated_method = "DF1EE684444B3CA8ADE151223057C4D3")
    
@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + mCompatibilityFlags;
        result = 31 * result + applicationDensity;
        result = 31 * result + Float.floatToIntBits(applicationScale);
        result = 31 * result + Float.floatToIntBits(applicationInvertedScale);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.211 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.213 -0500", hash_original_method = "FEB528FDE7329032F7938F1739557EEE", hash_generated_method = "0045DEDBE51AE1C127E965BE999951E3")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mCompatibilityFlags);
        dest.writeInt(applicationDensity);
        dest.writeFloat(applicationScale);
        dest.writeFloat(applicationInvertedScale);
    }
    // orphaned legacy method
    public CompatibilityInfo createFromParcel(Parcel source) {
            return new CompatibilityInfo(source);
        }
    
    // orphaned legacy method
    public CompatibilityInfo[] newArray(int size) {
            return new CompatibilityInfo[size];
        }
    
}

