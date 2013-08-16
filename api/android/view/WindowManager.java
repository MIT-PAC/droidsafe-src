package android.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;

public interface WindowManager extends ViewManager {
    
    public static class BadTokenException extends RuntimeException {
        @DSModeled(DSC.SAFE)
        public BadTokenException() {
        }

        @DSModeled(DSC.SAFE)
        public BadTokenException(String name) {
            super(name);
        }
    }

    
    public Display getDefaultDisplay();
    
    
    public void removeViewImmediate(View view);
    
    
    public boolean isHardwareAccelerated();
    
    public static class LayoutParams extends ViewGroup.LayoutParams
            implements Parcelable {
        
        @ViewDebug.ExportedProperty
        public int x;
        
        
        @ViewDebug.ExportedProperty
        public int y;

        
        @ViewDebug.ExportedProperty
        public float horizontalWeight;

        
        @ViewDebug.ExportedProperty
        public float verticalWeight;

        
        @ViewDebug.ExportedProperty(mapping = {
            @ViewDebug.IntToString(from = TYPE_BASE_APPLICATION, to = "TYPE_BASE_APPLICATION"),
            @ViewDebug.IntToString(from = TYPE_APPLICATION, to = "TYPE_APPLICATION"),
            @ViewDebug.IntToString(from = TYPE_APPLICATION_STARTING, to = "TYPE_APPLICATION_STARTING"),
            @ViewDebug.IntToString(from = TYPE_APPLICATION_PANEL, to = "TYPE_APPLICATION_PANEL"),
            @ViewDebug.IntToString(from = TYPE_APPLICATION_MEDIA, to = "TYPE_APPLICATION_MEDIA"),
            @ViewDebug.IntToString(from = TYPE_APPLICATION_SUB_PANEL, to = "TYPE_APPLICATION_SUB_PANEL"),
            @ViewDebug.IntToString(from = TYPE_APPLICATION_ATTACHED_DIALOG, to = "TYPE_APPLICATION_ATTACHED_DIALOG"),
            @ViewDebug.IntToString(from = TYPE_STATUS_BAR, to = "TYPE_STATUS_BAR"),
            @ViewDebug.IntToString(from = TYPE_SEARCH_BAR, to = "TYPE_SEARCH_BAR"),
            @ViewDebug.IntToString(from = TYPE_PHONE, to = "TYPE_PHONE"),
            @ViewDebug.IntToString(from = TYPE_SYSTEM_ALERT, to = "TYPE_SYSTEM_ALERT"),
            @ViewDebug.IntToString(from = TYPE_KEYGUARD, to = "TYPE_KEYGUARD"),
            @ViewDebug.IntToString(from = TYPE_TOAST, to = "TYPE_TOAST"),
            @ViewDebug.IntToString(from = TYPE_SYSTEM_OVERLAY, to = "TYPE_SYSTEM_OVERLAY"),
            @ViewDebug.IntToString(from = TYPE_PRIORITY_PHONE, to = "TYPE_PRIORITY_PHONE"),
            @ViewDebug.IntToString(from = TYPE_STATUS_BAR_PANEL, to = "TYPE_STATUS_BAR_PANEL"),
            @ViewDebug.IntToString(from = TYPE_STATUS_BAR_SUB_PANEL, to = "TYPE_STATUS_BAR_SUB_PANEL"),
            @ViewDebug.IntToString(from = TYPE_SYSTEM_DIALOG, to = "TYPE_SYSTEM_DIALOG"),
            @ViewDebug.IntToString(from = TYPE_KEYGUARD_DIALOG, to = "TYPE_KEYGUARD_DIALOG"),
            @ViewDebug.IntToString(from = TYPE_SYSTEM_ERROR, to = "TYPE_SYSTEM_ERROR"),
            @ViewDebug.IntToString(from = TYPE_INPUT_METHOD, to = "TYPE_INPUT_METHOD"),
            @ViewDebug.IntToString(from = TYPE_INPUT_METHOD_DIALOG, to = "TYPE_INPUT_METHOD_DIALOG"),
            @ViewDebug.IntToString(from = TYPE_WALLPAPER, to = "TYPE_WALLPAPER"),
            @ViewDebug.IntToString(from = TYPE_STATUS_BAR_PANEL, to = "TYPE_STATUS_BAR_PANEL"),
            @ViewDebug.IntToString(from = TYPE_SECURE_SYSTEM_OVERLAY, to = "TYPE_SECURE_SYSTEM_OVERLAY"),
            @ViewDebug.IntToString(from = TYPE_DRAG, to = "TYPE_DRAG"),
            @ViewDebug.IntToString(from = TYPE_STATUS_BAR_SUB_PANEL, to = "TYPE_STATUS_BAR_SUB_PANEL"),
            @ViewDebug.IntToString(from = TYPE_POINTER, to = "TYPE_POINTER"),
            @ViewDebug.IntToString(from = TYPE_NAVIGATION_BAR, to = "TYPE_NAVIGATION_BAR"),
            @ViewDebug.IntToString(from = TYPE_VOLUME_OVERLAY, to = "TYPE_VOLUME_OVERLAY"),
            @ViewDebug.IntToString(from = TYPE_BOOT_PROGRESS, to = "TYPE_BOOT_PROGRESS")
        })
        public int type;
    
        
        public static final int FIRST_APPLICATION_WINDOW = 1;
        
        
        public static final int TYPE_BASE_APPLICATION   = 1;
        
        
        public static final int TYPE_APPLICATION        = 2;
    
        
        public static final int TYPE_APPLICATION_STARTING = 3;
    
        
        public static final int LAST_APPLICATION_WINDOW = 99;
    
        
        public static final int FIRST_SUB_WINDOW        = 1000;
    
        
        public static final int TYPE_APPLICATION_PANEL  = FIRST_SUB_WINDOW;
    
        
        public static final int TYPE_APPLICATION_MEDIA  = FIRST_SUB_WINDOW+1;
    
        
        public static final int TYPE_APPLICATION_SUB_PANEL = FIRST_SUB_WINDOW+2;

        
        public static final int TYPE_APPLICATION_ATTACHED_DIALOG = FIRST_SUB_WINDOW+3;
        
        
        public static final int TYPE_APPLICATION_MEDIA_OVERLAY  = FIRST_SUB_WINDOW+4;
    
        
        public static final int LAST_SUB_WINDOW         = 1999;
        
        
        public static final int FIRST_SYSTEM_WINDOW     = 2000;
    
        
        public static final int TYPE_STATUS_BAR         = FIRST_SYSTEM_WINDOW;
    
        
        public static final int TYPE_SEARCH_BAR         = FIRST_SYSTEM_WINDOW+1;
    
        
        public static final int TYPE_PHONE              = FIRST_SYSTEM_WINDOW+2;
    
        
        public static final int TYPE_SYSTEM_ALERT       = FIRST_SYSTEM_WINDOW+3;
        
        
        public static final int TYPE_KEYGUARD           = FIRST_SYSTEM_WINDOW+4;
        
        
        public static final int TYPE_TOAST              = FIRST_SYSTEM_WINDOW+5;
        
        
        public static final int TYPE_SYSTEM_OVERLAY     = FIRST_SYSTEM_WINDOW+6;
        
        
        public static final int TYPE_PRIORITY_PHONE     = FIRST_SYSTEM_WINDOW+7;
        
        
        public static final int TYPE_SYSTEM_DIALOG      = FIRST_SYSTEM_WINDOW+8;
    
        
        public static final int TYPE_KEYGUARD_DIALOG    = FIRST_SYSTEM_WINDOW+9;
        
        
        public static final int TYPE_SYSTEM_ERROR       = FIRST_SYSTEM_WINDOW+10;
        
        
        public static final int TYPE_INPUT_METHOD       = FIRST_SYSTEM_WINDOW+11;

        
        public static final int TYPE_INPUT_METHOD_DIALOG= FIRST_SYSTEM_WINDOW+12;

        
        public static final int TYPE_WALLPAPER          = FIRST_SYSTEM_WINDOW+13;

        
        public static final int TYPE_STATUS_BAR_PANEL   = FIRST_SYSTEM_WINDOW+14;

        
        public static final int TYPE_SECURE_SYSTEM_OVERLAY = FIRST_SYSTEM_WINDOW+15;

        
        public static final int TYPE_DRAG               = FIRST_SYSTEM_WINDOW+16;

        
        public static final int TYPE_STATUS_BAR_SUB_PANEL = FIRST_SYSTEM_WINDOW+17;

        
        public static final int TYPE_POINTER = FIRST_SYSTEM_WINDOW+18;

        
        public static final int TYPE_NAVIGATION_BAR = FIRST_SYSTEM_WINDOW+19;

        
        public static final int TYPE_VOLUME_OVERLAY = FIRST_SYSTEM_WINDOW+20;

        
        public static final int TYPE_BOOT_PROGRESS = FIRST_SYSTEM_WINDOW+21;

        
        public static final int TYPE_HIDDEN_NAV_CONSUMER = FIRST_SYSTEM_WINDOW+22;

        
        public static final int LAST_SYSTEM_WINDOW      = 2999;

        
        @Deprecated
        public static final int MEMORY_TYPE_NORMAL = 0;
        
        @Deprecated
        public static final int MEMORY_TYPE_HARDWARE = 1;
        
        @Deprecated
        public static final int MEMORY_TYPE_GPU = 2;
        
        @Deprecated
        public static final int MEMORY_TYPE_PUSH_BUFFERS = 3;
        
        
        @Deprecated
        public int memoryType;
        
        
        public static final int FLAG_ALLOW_LOCK_WHILE_SCREEN_ON     = 0x00000001;

        
        public static final int FLAG_DIM_BEHIND        = 0x00000002;

        
        @Deprecated
        public static final int FLAG_BLUR_BEHIND        = 0x00000004;

        
        public static final int FLAG_NOT_FOCUSABLE      = 0x00000008;
        
        
        public static final int FLAG_NOT_TOUCHABLE      = 0x00000010;
        
        
        public static final int FLAG_NOT_TOUCH_MODAL    = 0x00000020;
        
        
        public static final int FLAG_TOUCHABLE_WHEN_WAKING = 0x00000040;
        
        
        public static final int FLAG_KEEP_SCREEN_ON     = 0x00000080;
        
        
        public static final int FLAG_LAYOUT_IN_SCREEN   = 0x00000100;
        
        
        public static final int FLAG_LAYOUT_NO_LIMITS   = 0x00000200;
        
        
        public static final int FLAG_FULLSCREEN      = 0x00000400;
        
        
        public static final int FLAG_FORCE_NOT_FULLSCREEN   = 0x00000800;
        
        
        public static final int FLAG_DITHER             = 0x00001000;
        
        
        public static final int FLAG_SECURE             = 0x00002000;
        
        
        public static final int FLAG_SCALED             = 0x00004000;
        
        
        public static final int FLAG_IGNORE_CHEEK_PRESSES    = 0x00008000;
        
        
        public static final int FLAG_LAYOUT_INSET_DECOR = 0x00010000;
        
        
        public static final int FLAG_ALT_FOCUSABLE_IM = 0x00020000;
        
        
        public static final int FLAG_WATCH_OUTSIDE_TOUCH = 0x00040000;
        
        
        public static final int FLAG_SHOW_WHEN_LOCKED = 0x00080000;

        
        public static final int FLAG_SHOW_WALLPAPER = 0x00100000;
        
        
        public static final int FLAG_TURN_SCREEN_ON = 0x00200000;
        
        
        public static final int FLAG_DISMISS_KEYGUARD = 0x00400000;
        
        
        public static final int FLAG_SPLIT_TOUCH = 0x00800000;
        
        
        public static final int FLAG_HARDWARE_ACCELERATED = 0x01000000;

        
        

        
        public static final int FLAG_SLIPPERY = 0x04000000;

        
        public static final int FLAG_NEEDS_MENU_KEY = 0x08000000;

        
        public static final int FLAG_KEEP_SURFACE_WHILE_ANIMATING = 0x10000000;
        
        
        public static final int FLAG_COMPATIBLE_WINDOW = 0x20000000;

        
        public static final int FLAG_SYSTEM_ERROR = 0x40000000;

        
        @ViewDebug.ExportedProperty(flagMapping = {
            @ViewDebug.FlagToString(mask = FLAG_ALLOW_LOCK_WHILE_SCREEN_ON, equals = FLAG_ALLOW_LOCK_WHILE_SCREEN_ON,
                    name = "FLAG_ALLOW_LOCK_WHILE_SCREEN_ON"),
            @ViewDebug.FlagToString(mask = FLAG_DIM_BEHIND, equals = FLAG_DIM_BEHIND,
                    name = "FLAG_DIM_BEHIND"),
            @ViewDebug.FlagToString(mask = FLAG_BLUR_BEHIND, equals = FLAG_BLUR_BEHIND,
                    name = "FLAG_BLUR_BEHIND"),
            @ViewDebug.FlagToString(mask = FLAG_NOT_FOCUSABLE, equals = FLAG_NOT_FOCUSABLE,
                    name = "FLAG_NOT_FOCUSABLE"),
            @ViewDebug.FlagToString(mask = FLAG_NOT_TOUCHABLE, equals = FLAG_NOT_TOUCHABLE,
                    name = "FLAG_NOT_TOUCHABLE"),
            @ViewDebug.FlagToString(mask = FLAG_NOT_TOUCH_MODAL, equals = FLAG_NOT_TOUCH_MODAL,
                    name = "FLAG_NOT_TOUCH_MODAL"),
            @ViewDebug.FlagToString(mask = FLAG_TOUCHABLE_WHEN_WAKING, equals = FLAG_TOUCHABLE_WHEN_WAKING,
                    name = "FLAG_TOUCHABLE_WHEN_WAKING"),
            @ViewDebug.FlagToString(mask = FLAG_KEEP_SCREEN_ON, equals = FLAG_KEEP_SCREEN_ON,
                    name = "FLAG_KEEP_SCREEN_ON"),
            @ViewDebug.FlagToString(mask = FLAG_LAYOUT_IN_SCREEN, equals = FLAG_LAYOUT_IN_SCREEN,
                    name = "FLAG_LAYOUT_IN_SCREEN"),
            @ViewDebug.FlagToString(mask = FLAG_LAYOUT_NO_LIMITS, equals = FLAG_LAYOUT_NO_LIMITS,
                    name = "FLAG_LAYOUT_NO_LIMITS"),
            @ViewDebug.FlagToString(mask = FLAG_FULLSCREEN, equals = FLAG_FULLSCREEN,
                    name = "FLAG_FULLSCREEN"),
            @ViewDebug.FlagToString(mask = FLAG_FORCE_NOT_FULLSCREEN, equals = FLAG_FORCE_NOT_FULLSCREEN,
                    name = "FLAG_FORCE_NOT_FULLSCREEN"),
            @ViewDebug.FlagToString(mask = FLAG_DITHER, equals = FLAG_DITHER,
                    name = "FLAG_DITHER"),
            @ViewDebug.FlagToString(mask = FLAG_SECURE, equals = FLAG_SECURE,
                    name = "FLAG_SECURE"),
            @ViewDebug.FlagToString(mask = FLAG_SCALED, equals = FLAG_SCALED,
                    name = "FLAG_SCALED"),
            @ViewDebug.FlagToString(mask = FLAG_IGNORE_CHEEK_PRESSES, equals = FLAG_IGNORE_CHEEK_PRESSES,
                    name = "FLAG_IGNORE_CHEEK_PRESSES"),
            @ViewDebug.FlagToString(mask = FLAG_LAYOUT_INSET_DECOR, equals = FLAG_LAYOUT_INSET_DECOR,
                    name = "FLAG_LAYOUT_INSET_DECOR"),
            @ViewDebug.FlagToString(mask = FLAG_ALT_FOCUSABLE_IM, equals = FLAG_ALT_FOCUSABLE_IM,
                    name = "FLAG_ALT_FOCUSABLE_IM"),
            @ViewDebug.FlagToString(mask = FLAG_WATCH_OUTSIDE_TOUCH, equals = FLAG_WATCH_OUTSIDE_TOUCH,
                    name = "FLAG_WATCH_OUTSIDE_TOUCH"),
            @ViewDebug.FlagToString(mask = FLAG_SHOW_WHEN_LOCKED, equals = FLAG_SHOW_WHEN_LOCKED,
                    name = "FLAG_SHOW_WHEN_LOCKED"),
            @ViewDebug.FlagToString(mask = FLAG_SHOW_WALLPAPER, equals = FLAG_SHOW_WALLPAPER,
                    name = "FLAG_SHOW_WALLPAPER"),
            @ViewDebug.FlagToString(mask = FLAG_TURN_SCREEN_ON, equals = FLAG_TURN_SCREEN_ON,
                    name = "FLAG_TURN_SCREEN_ON"),
            @ViewDebug.FlagToString(mask = FLAG_DISMISS_KEYGUARD, equals = FLAG_DISMISS_KEYGUARD,
                    name = "FLAG_DISMISS_KEYGUARD"),
            @ViewDebug.FlagToString(mask = FLAG_SPLIT_TOUCH, equals = FLAG_SPLIT_TOUCH,
                    name = "FLAG_SPLIT_TOUCH"),
            @ViewDebug.FlagToString(mask = FLAG_HARDWARE_ACCELERATED, equals = FLAG_HARDWARE_ACCELERATED,
                    name = "FLAG_HARDWARE_ACCELERATED")
        })
        public int flags;

        
        public static final int PRIVATE_FLAG_FAKE_HARDWARE_ACCELERATED = 0x00000001;

        
        public static final int PRIVATE_FLAG_FORCE_HARDWARE_ACCELERATED = 0x00000002;

        
        public static final int PRIVATE_FLAG_WANTS_OFFSET_NOTIFICATIONS = 0x00000004;

        
        public static final int PRIVATE_FLAG_SET_NEEDS_MENU_KEY = 0x00000008;

        
        public int privateFlags;

        
        @DSModeled(DSC.SAFE)
        public static boolean mayUseInputMethod(int flags) {
            switch (flags&(FLAG_NOT_FOCUSABLE|FLAG_ALT_FOCUSABLE_IM)) {
                case 0:
                case FLAG_NOT_FOCUSABLE|FLAG_ALT_FOCUSABLE_IM:
                    return true;
            }
            return false;
        }
        
        
        public static final int SOFT_INPUT_MASK_STATE = 0x0f;
        
        
        public static final int SOFT_INPUT_STATE_UNSPECIFIED = 0;
        
        
        public static final int SOFT_INPUT_STATE_UNCHANGED = 1;
        
        
        public static final int SOFT_INPUT_STATE_HIDDEN = 2;
        
        
        public static final int SOFT_INPUT_STATE_ALWAYS_HIDDEN = 3;
        
        
        public static final int SOFT_INPUT_STATE_VISIBLE = 4;
        
        
        public static final int SOFT_INPUT_STATE_ALWAYS_VISIBLE = 5;
        
        
        public static final int SOFT_INPUT_MASK_ADJUST = 0xf0;
        
        
        public static final int SOFT_INPUT_ADJUST_UNSPECIFIED = 0x00;
        
        
        public static final int SOFT_INPUT_ADJUST_RESIZE = 0x10;
        
        
        public static final int SOFT_INPUT_ADJUST_PAN = 0x20;
        
        
        public static final int SOFT_INPUT_ADJUST_NOTHING = 0x30;

        
        public static final int SOFT_INPUT_IS_FORWARD_NAVIGATION = 0x100;

        
        public int softInputMode;
        
        
        public int gravity;
    
        
        public float horizontalMargin;
    
        
        public float verticalMargin;
    
        
        public int format;
    
        
        public int windowAnimations;
    
        
        public float alpha = 1.0f;
    
        
        public float dimAmount = 1.0f;

        
        public static final float BRIGHTNESS_OVERRIDE_NONE = -1.0f;

        
        public static final float BRIGHTNESS_OVERRIDE_OFF = 0.0f;

        
        public static final float BRIGHTNESS_OVERRIDE_FULL = 1.0f;
    
        
        public float screenBrightness = BRIGHTNESS_OVERRIDE_NONE;
        
        
        public float buttonBrightness = BRIGHTNESS_OVERRIDE_NONE;

        
        public IBinder token = null;
    
        
        public String packageName = null;
        
        
        public int screenOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;

        
        public int systemUiVisibility;

        
        public int subtreeSystemUiVisibility;

        
        public boolean hasSystemUiListeners;

        
        public static final int INPUT_FEATURE_DISABLE_POINTER_GESTURES = 0x00000001;

        
        public static final int INPUT_FEATURE_NO_INPUT_CHANNEL = 0x00000002;

        
        public int inputFeatures;

        @DSModeled(DSC.SAFE)
        public LayoutParams() {
            super(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            type = TYPE_APPLICATION;
            format = PixelFormat.OPAQUE;
        }
        
        @DSModeled(DSC.SAFE)
        public LayoutParams(int _type) {
            super(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            type = _type;
            format = PixelFormat.OPAQUE;
        }
    
        @DSModeled(DSC.SAFE)
        public LayoutParams(int _type, int _flags) {
            super(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            type = _type;
            flags = _flags;
            format = PixelFormat.OPAQUE;
        }
    
        @DSModeled(DSC.SAFE)
        public LayoutParams(int _type, int _flags, int _format) {
            super(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            type = _type;
            flags = _flags;
            format = _format;
        }
        
        @DSModeled(DSC.SAFE)
        public LayoutParams(int w, int h, int _type, int _flags, int _format) {
            super(w, h);
            type = _type;
            flags = _flags;
            format = _format;
        }
        
        @DSModeled(DSC.SAFE)
        public LayoutParams(int w, int h, int xpos, int ypos, int _type,
                int _flags, int _format) {
            super(w, h);
            x = xpos;
            y = ypos;
            type = _type;
            flags = _flags;
            format = _format;
        }
    
        @DSModeled(DSC.SAFE)
        public final void setTitle(CharSequence title) {
            if (null == title)
                title = "";
    
            mTitle = TextUtils.stringOrSpannedString(title);
        }
    
        @DSModeled(DSC.SAFE)
        public final CharSequence getTitle() {
            return mTitle;
        }
    
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return 0;
        }

        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel out, int parcelableFlags) {
            out.writeInt(width);
            out.writeInt(height);
            out.writeInt(x);
            out.writeInt(y);
            out.writeInt(type);
            out.writeInt(flags);
            out.writeInt(privateFlags);
            out.writeInt(softInputMode);
            out.writeInt(gravity);
            out.writeFloat(horizontalMargin);
            out.writeFloat(verticalMargin);
            out.writeInt(format);
            out.writeInt(windowAnimations);
            out.writeFloat(alpha);
            out.writeFloat(dimAmount);
            out.writeFloat(screenBrightness);
            out.writeFloat(buttonBrightness);
            out.writeStrongBinder(token);
            out.writeString(packageName);
            TextUtils.writeToParcel(mTitle, out, parcelableFlags);
            out.writeInt(screenOrientation);
            out.writeInt(systemUiVisibility);
            out.writeInt(subtreeSystemUiVisibility);
            out.writeInt(hasSystemUiListeners ? 1 : 0);
            out.writeInt(inputFeatures);
        }
        
        public static final Parcelable.Creator<LayoutParams> CREATOR
                    = new Parcelable.Creator<LayoutParams>() {
            @DSModeled(DSC.SAFE)
            public LayoutParams createFromParcel(Parcel in) {
                return new LayoutParams(in);
            }
    
            @DSModeled(DSC.SAFE)
            public LayoutParams[] newArray(int size) {
                return new LayoutParams[size];
            }
        };
    
    
        @DSModeled(DSC.SAFE)
        public LayoutParams(Parcel in) {
            width = in.readInt();
            height = in.readInt();
            x = in.readInt();
            y = in.readInt();
            type = in.readInt();
            flags = in.readInt();
            privateFlags = in.readInt();
            softInputMode = in.readInt();
            gravity = in.readInt();
            horizontalMargin = in.readFloat();
            verticalMargin = in.readFloat();
            format = in.readInt();
            windowAnimations = in.readInt();
            alpha = in.readFloat();
            dimAmount = in.readFloat();
            screenBrightness = in.readFloat();
            buttonBrightness = in.readFloat();
            token = in.readStrongBinder();
            packageName = in.readString();
            mTitle = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            screenOrientation = in.readInt();
            systemUiVisibility = in.readInt();
            subtreeSystemUiVisibility = in.readInt();
            hasSystemUiListeners = in.readInt() != 0;
            inputFeatures = in.readInt();
        }
    
        @SuppressWarnings({"PointlessBitwiseExpression"})
        public static final int LAYOUT_CHANGED = 1<<0;
        public static final int TYPE_CHANGED = 1<<1;
        public static final int FLAGS_CHANGED = 1<<2;
        public static final int FORMAT_CHANGED = 1<<3;
        public static final int ANIMATION_CHANGED = 1<<4;
        public static final int DIM_AMOUNT_CHANGED = 1<<5;
        public static final int TITLE_CHANGED = 1<<6;
        public static final int ALPHA_CHANGED = 1<<7;
        public static final int MEMORY_TYPE_CHANGED = 1<<8;
        public static final int SOFT_INPUT_MODE_CHANGED = 1<<9;
        public static final int SCREEN_ORIENTATION_CHANGED = 1<<10;
        public static final int SCREEN_BRIGHTNESS_CHANGED = 1<<11;
        
        public static final int BUTTON_BRIGHTNESS_CHANGED = 1<<12;
        
        public static final int SYSTEM_UI_VISIBILITY_CHANGED = 1<<13;
        
        public static final int SYSTEM_UI_LISTENER_CHANGED = 1<<14;
        
        public static final int INPUT_FEATURES_CHANGED = 1<<15;
        
        public static final int PRIVATE_FLAGS_CHANGED = 1<<16;
        
        public static final int EVERYTHING_CHANGED = 0xffffffff;

        
        private int[] mCompatibilityParamsBackup = null;
        
        @DSModeled(DSC.SAFE)
        public final int copyFrom(LayoutParams o) {
            int changes = 0;
    
            if (width != o.width) {
                width = o.width;
                changes |= LAYOUT_CHANGED;
            }
            if (height != o.height) {
                height = o.height;
                changes |= LAYOUT_CHANGED;
            }
            if (x != o.x) {
                x = o.x;
                changes |= LAYOUT_CHANGED;
            }
            if (y != o.y) {
                y = o.y;
                changes |= LAYOUT_CHANGED;
            }
            if (horizontalWeight != o.horizontalWeight) {
                horizontalWeight = o.horizontalWeight;
                changes |= LAYOUT_CHANGED;
            }
            if (verticalWeight != o.verticalWeight) {
                verticalWeight = o.verticalWeight;
                changes |= LAYOUT_CHANGED;
            }
            if (horizontalMargin != o.horizontalMargin) {
                horizontalMargin = o.horizontalMargin;
                changes |= LAYOUT_CHANGED;
            }
            if (verticalMargin != o.verticalMargin) {
                verticalMargin = o.verticalMargin;
                changes |= LAYOUT_CHANGED;
            }
            if (type != o.type) {
                type = o.type;
                changes |= TYPE_CHANGED;
            }
            if (flags != o.flags) {
                flags = o.flags;
                changes |= FLAGS_CHANGED;
            }
            if (privateFlags != o.privateFlags) {
                privateFlags = o.privateFlags;
                changes |= PRIVATE_FLAGS_CHANGED;
            }
            if (softInputMode != o.softInputMode) {
                softInputMode = o.softInputMode;
                changes |= SOFT_INPUT_MODE_CHANGED;
            }
            if (gravity != o.gravity) {
                gravity = o.gravity;
                changes |= LAYOUT_CHANGED;
            }
            if (format != o.format) {
                format = o.format;
                changes |= FORMAT_CHANGED;
            }
            if (windowAnimations != o.windowAnimations) {
                windowAnimations = o.windowAnimations;
                changes |= ANIMATION_CHANGED;
            }
            if (token == null) {
                
                
                token = o.token;
            }
            if (packageName == null) {
                
                
                packageName = o.packageName;
            }
            if (!mTitle.equals(o.mTitle)) {
                mTitle = o.mTitle;
                changes |= TITLE_CHANGED;
            }
            if (alpha != o.alpha) {
                alpha = o.alpha;
                changes |= ALPHA_CHANGED;
            }
            if (dimAmount != o.dimAmount) {
                dimAmount = o.dimAmount;
                changes |= DIM_AMOUNT_CHANGED;
            }
            if (screenBrightness != o.screenBrightness) {
                screenBrightness = o.screenBrightness;
                changes |= SCREEN_BRIGHTNESS_CHANGED;
            }
            if (buttonBrightness != o.buttonBrightness) {
                buttonBrightness = o.buttonBrightness;
                changes |= BUTTON_BRIGHTNESS_CHANGED;
            }
    
            if (screenOrientation != o.screenOrientation) {
                screenOrientation = o.screenOrientation;
                changes |= SCREEN_ORIENTATION_CHANGED;
            }

            if (systemUiVisibility != o.systemUiVisibility
                    || subtreeSystemUiVisibility != o.subtreeSystemUiVisibility) {
                systemUiVisibility = o.systemUiVisibility;
                subtreeSystemUiVisibility = o.subtreeSystemUiVisibility;
                changes |= SYSTEM_UI_VISIBILITY_CHANGED;
            }

            if (hasSystemUiListeners != o.hasSystemUiListeners) {
                hasSystemUiListeners = o.hasSystemUiListeners;
                changes |= SYSTEM_UI_LISTENER_CHANGED;
            }

            if (inputFeatures != o.inputFeatures) {
                inputFeatures = o.inputFeatures;
                changes |= INPUT_FEATURES_CHANGED;
            }

            return changes;
        }
    
        @DSModeled(DSC.SAFE)
        @Override
        public String debug(String output) {
            output += "Contents of " + this + ":";
            Log.d("Debug", output);
            output = super.debug("");
            Log.d("Debug", output);
            Log.d("Debug", "");
            Log.d("Debug", "WindowManager.LayoutParams={title=" + mTitle + "}");
            return "";
        }
    
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(256);
            sb.append("WM.LayoutParams{");
            sb.append("(");
            sb.append(x);
            sb.append(',');
            sb.append(y);
            sb.append(")(");
            sb.append((width== MATCH_PARENT ?"fill":(width==WRAP_CONTENT?"wrap":width)));
            sb.append('x');
            sb.append((height== MATCH_PARENT ?"fill":(height==WRAP_CONTENT?"wrap":height)));
            sb.append(")");
            if (horizontalMargin != 0) {
                sb.append(" hm=");
                sb.append(horizontalMargin);
            }
            if (verticalMargin != 0) {
                sb.append(" vm=");
                sb.append(verticalMargin);
            }
            if (gravity != 0) {
                sb.append(" gr=#");
                sb.append(Integer.toHexString(gravity));
            }
            if (softInputMode != 0) {
                sb.append(" sim=#");
                sb.append(Integer.toHexString(softInputMode));
            }
            sb.append(" ty=");
            sb.append(type);
            sb.append(" fl=#");
            sb.append(Integer.toHexString(flags));
            if (privateFlags != 0) {
                sb.append(" pfl=0x").append(Integer.toHexString(privateFlags));
            }
            if (format != PixelFormat.OPAQUE) {
                sb.append(" fmt=");
                sb.append(format);
            }
            if (windowAnimations != 0) {
                sb.append(" wanim=0x");
                sb.append(Integer.toHexString(windowAnimations));
            }
            if (screenOrientation != ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {
                sb.append(" or=");
                sb.append(screenOrientation);
            }
            if (alpha != 1.0f) {
                sb.append(" alpha=");
                sb.append(alpha);
            }
            if (screenBrightness != BRIGHTNESS_OVERRIDE_NONE) {
                sb.append(" sbrt=");
                sb.append(screenBrightness);
            }
            if (buttonBrightness != BRIGHTNESS_OVERRIDE_NONE) {
                sb.append(" bbrt=");
                sb.append(buttonBrightness);
            }
            if ((flags & FLAG_COMPATIBLE_WINDOW) != 0) {
                sb.append(" compatible=true");
            }
            if (systemUiVisibility != 0) {
                sb.append(" sysui=0x");
                sb.append(Integer.toHexString(systemUiVisibility));
            }
            if (subtreeSystemUiVisibility != 0) {
                sb.append(" vsysui=0x");
                sb.append(Integer.toHexString(subtreeSystemUiVisibility));
            }
            if (hasSystemUiListeners) {
                sb.append(" sysuil=");
                sb.append(hasSystemUiListeners);
            }
            if (inputFeatures != 0) {
                sb.append(" if=0x").append(Integer.toHexString(inputFeatures));
            }
            sb.append('}');
            return sb.toString();
        }

        
        @DSModeled(DSC.BAN)
        public void scale(float scale) {
            x = (int) (x * scale + 0.5f);
            y = (int) (y * scale + 0.5f);
            if (width > 0) {
                width = (int) (width * scale + 0.5f);
            }
            if (height > 0) {
                height = (int) (height * scale + 0.5f);
            }
        }

        
        @DSModeled(DSC.SAFE)
        void backup() {
            int[] backup = mCompatibilityParamsBackup;
            if (backup == null) {
                
                backup = mCompatibilityParamsBackup = new int[4];
            }
            backup[0] = x;
            backup[1] = y;
            backup[2] = width;
            backup[3] = height;
        }

        
        @DSModeled(DSC.SAFE)
        void restore() {
            int[] backup = mCompatibilityParamsBackup;
            if (backup != null) {
                x = backup[0];
                y = backup[1];
                width = backup[2];
                height = backup[3];
            }
        }

        private CharSequence mTitle = "";
    }
}
