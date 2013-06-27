package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.618 -0400", hash_original_field = "44CEE0DD1BE1998482D8262782403C60", hash_generated_field = "B4CB39B5E76E4F134AE9FD81F38E628C")

    private int mCompatibilityFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.618 -0400", hash_original_field = "CCF0FB9B0F263F71EE6018A478D4C5B2", hash_generated_field = "D4940D12226C2B60194AF35187704159")

    public int applicationDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.618 -0400", hash_original_field = "1B0B3DCFB15C2ED0E188C58DDA8DD7CD", hash_generated_field = "14E3397589B948719667F1E3AF571289")

    public float applicationScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.618 -0400", hash_original_field = "0C690E3EEBE7CF4097CF724C322C61E7", hash_generated_field = "FB16C6B90478FF3C6286ADC11FCB2FCF")

    public float applicationInvertedScale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.677 -0400", hash_original_method = "9C59C0A19ADE82EBF59B39AA82601FD9", hash_generated_method = "32A03F91A666A26CF52466651E44C36F")
    public  CompatibilityInfo(ApplicationInfo appInfo, int screenLayout, int sw,
            boolean forceCompat) {
        int compatFlags;
        compatFlags = 0;
        {
            int required;
            required = appInfo.requiresSmallestWidthDp;
            required = appInfo.compatibleWidthLimitDp;
            {
                required = appInfo.largestWidthLimitDp;
            } //End block
            int compat;
            compat = appInfo.compatibleWidthLimitDp;
            compat = required;
            {
                compat = required;
            } //End block
            int largest;
            largest = appInfo.largestWidthLimitDp;
            {
                compatFlags |= NEVER_NEEDS_COMPAT;
            } //End block
            {
                compatFlags |= NEEDS_SCREEN_COMPAT | ALWAYS_NEEDS_COMPAT;
            } //End block
            {
                compatFlags |= NEVER_NEEDS_COMPAT;
            } //End block
            {
                compatFlags |= NEEDS_SCREEN_COMPAT;
            } //End block
            applicationDensity = DisplayMetrics.DENSITY_DEVICE;
            applicationScale = 1.0f;
            applicationInvertedScale = 1.0f;
        } //End block
        {
            int EXPANDABLE;
            EXPANDABLE = 2;
            int LARGE_SCREENS;
            LARGE_SCREENS = 8;
            int XLARGE_SCREENS;
            XLARGE_SCREENS = 32;
            int sizeInfo;
            sizeInfo = 0;
            boolean anyResizeable;
            anyResizeable = false;
            {
                sizeInfo |= LARGE_SCREENS;
                anyResizeable = true;
                {
                    sizeInfo |= XLARGE_SCREENS | EXPANDABLE;
                } //End block
            } //End block
            {
                anyResizeable = true;
                {
                    sizeInfo |= XLARGE_SCREENS | EXPANDABLE;
                } //End block
            } //End block
            {
                anyResizeable = true;
                sizeInfo |= EXPANDABLE;
            } //End block
            {
                sizeInfo &= ~EXPANDABLE;
            } //End block
            compatFlags |= NEEDS_SCREEN_COMPAT;
            //Begin case Configuration.SCREENLAYOUT_SIZE_XLARGE 
            {
                compatFlags &= ~NEEDS_SCREEN_COMPAT;
            } //End block
            //End case Configuration.SCREENLAYOUT_SIZE_XLARGE 
            //Begin case Configuration.SCREENLAYOUT_SIZE_XLARGE 
            {
                compatFlags |= NEVER_NEEDS_COMPAT;
            } //End block
            //End case Configuration.SCREENLAYOUT_SIZE_XLARGE 
            //Begin case Configuration.SCREENLAYOUT_SIZE_LARGE 
            {
                compatFlags &= ~NEEDS_SCREEN_COMPAT;
            } //End block
            //End case Configuration.SCREENLAYOUT_SIZE_LARGE 
            //Begin case Configuration.SCREENLAYOUT_SIZE_LARGE 
            {
                compatFlags |= NEVER_NEEDS_COMPAT;
            } //End block
            //End case Configuration.SCREENLAYOUT_SIZE_LARGE 
            {
                {
                    compatFlags &= ~NEEDS_SCREEN_COMPAT;
                } //End block
                {
                    compatFlags |= ALWAYS_NEEDS_COMPAT;
                } //End block
            } //End block
            {
                compatFlags &= ~NEEDS_SCREEN_COMPAT;
                compatFlags |= NEVER_NEEDS_COMPAT;
            } //End block
            {
                applicationDensity = DisplayMetrics.DENSITY_DEVICE;
                applicationScale = 1.0f;
                applicationInvertedScale = 1.0f;
            } //End block
            {
                applicationDensity = DisplayMetrics.DENSITY_DEFAULT;
                applicationScale = DisplayMetrics.DENSITY_DEVICE
                        / (float) DisplayMetrics.DENSITY_DEFAULT;
                applicationInvertedScale = 1.0f / applicationScale;
                compatFlags |= SCALING_REQUIRED;
            } //End block
        } //End block
        mCompatibilityFlags = compatFlags;
        addTaint(appInfo.getTaint());
        addTaint(screenLayout);
        addTaint(sw);
        addTaint(forceCompat);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.685 -0400", hash_original_method = "A82321676D9C84B0538DAFB6CC61C0CB", hash_generated_method = "D97765B16CE7043641005CA614BC91BD")
    private  CompatibilityInfo(int compFlags,
            int dens, float scale, float invertedScale) {
        mCompatibilityFlags = compFlags;
        applicationDensity = dens;
        applicationScale = scale;
        applicationInvertedScale = invertedScale;
        // ---------- Original Method ----------
        //mCompatibilityFlags = compFlags;
        //applicationDensity = dens;
        //applicationScale = scale;
        //applicationInvertedScale = invertedScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.686 -0400", hash_original_method = "3DDB26515D25880873E2C6C7F1DDA6F5", hash_generated_method = "A144E464C092FC9674C214597E793D47")
    private  CompatibilityInfo() {
        this(NEVER_NEEDS_COMPAT, DisplayMetrics.DENSITY_DEVICE,
                1.0f,
                1.0f);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.704 -0400", hash_original_method = "B251F1B77EF355BF6FA118A826DF4F4A", hash_generated_method = "48F71F1044639FA67CF1237AD6C85A09")
    private  CompatibilityInfo(Parcel source) {
        mCompatibilityFlags = source.readInt();
        applicationDensity = source.readInt();
        applicationScale = source.readFloat();
        applicationInvertedScale = source.readFloat();
        // ---------- Original Method ----------
        //mCompatibilityFlags = source.readInt();
        //applicationDensity = source.readInt();
        //applicationScale = source.readFloat();
        //applicationInvertedScale = source.readFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.705 -0400", hash_original_method = "E2D07E7BFECA2D29A0CD39AB3E4AD2F4", hash_generated_method = "EE990A11570DD9E16B96440045A6AAF8")
    public boolean isScalingRequired() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_459895161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_459895161;
        // ---------- Original Method ----------
        //return (mCompatibilityFlags&SCALING_REQUIRED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.706 -0400", hash_original_method = "AEF0832D3207872CC75E4AC6D7849C73", hash_generated_method = "AB2B3D5EDA0C3CAEF7E70EE0075A8FF8")
    public boolean supportsScreen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2126186317 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2126186317;
        // ---------- Original Method ----------
        //return (mCompatibilityFlags&NEEDS_SCREEN_COMPAT) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.710 -0400", hash_original_method = "BD11775B1F66D2736A032A6A37E2552F", hash_generated_method = "0502636C210AD506930E0D7B898DCD35")
    public boolean neverSupportsScreen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1408884135 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1408884135;
        // ---------- Original Method ----------
        //return (mCompatibilityFlags&ALWAYS_NEEDS_COMPAT) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.711 -0400", hash_original_method = "CFA6F9CFCD9588B682D5F07DFF385684", hash_generated_method = "1B46152A6929076F6E3F89EE623FED44")
    public boolean alwaysSupportsScreen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_225460765 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_225460765;
        // ---------- Original Method ----------
        //return (mCompatibilityFlags&NEVER_NEEDS_COMPAT) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.717 -0400", hash_original_method = "93ABC602B8C8A6238860B5CA46099876", hash_generated_method = "ADC8584396D2CE67BEE426499D6DA4FD")
    public Translator getTranslator() {
        Translator varB4EAC82CA7396A68D541C85D26508E83_1844786966 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1844786966 = isScalingRequired() ? new Translator() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1844786966.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1844786966;
        // ---------- Original Method ----------
        //return isScalingRequired() ? new Translator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.749 -0400", hash_original_method = "F5DFBBE3DCF906040672C2B4A4880712", hash_generated_method = "CC0A6F00469F35630A0351B0C39C4280")
    public void applyToDisplayMetrics(DisplayMetrics inoutDm) {
        {
            boolean varE7167D48931C006010D8B5CB5972BC1F_207062434 = (!supportsScreen());
            {
                CompatibilityInfo.computeCompatibleScaling(inoutDm, inoutDm);
            } //End block
            {
                inoutDm.widthPixels = inoutDm.noncompatWidthPixels;
                inoutDm.heightPixels = inoutDm.noncompatHeightPixels;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var99116A7FA4A89F4892D46EF5C786E5AD_1746955230 = (isScalingRequired());
            {
                float invertedRatio;
                invertedRatio = applicationInvertedScale;
                inoutDm.density = inoutDm.noncompatDensity * invertedRatio;
                inoutDm.densityDpi = (int)((inoutDm.density*DisplayMetrics.DENSITY_DEFAULT)+.5f);
                inoutDm.scaledDensity = inoutDm.noncompatScaledDensity * invertedRatio;
                inoutDm.xdpi = inoutDm.noncompatXdpi * invertedRatio;
                inoutDm.ydpi = inoutDm.noncompatYdpi * invertedRatio;
                inoutDm.widthPixels = (int) (inoutDm.widthPixels * invertedRatio + 0.5f);
                inoutDm.heightPixels = (int) (inoutDm.heightPixels * invertedRatio + 0.5f);
            } //End block
        } //End collapsed parenthetic
        addTaint(inoutDm.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.759 -0400", hash_original_method = "D1D0A6DB2934A6F26FB8AACA9CE38F1E", hash_generated_method = "819387518D3BBEADA631E560369ED43C")
    public void applyToConfiguration(Configuration inoutConfig) {
        {
            boolean varE7167D48931C006010D8B5CB5972BC1F_1536244384 = (!supportsScreen());
            {
                inoutConfig.screenLayout =
                    (inoutConfig.screenLayout&~Configuration.SCREENLAYOUT_SIZE_MASK)
                    | Configuration.SCREENLAYOUT_SIZE_NORMAL;
                inoutConfig.screenWidthDp = inoutConfig.compatScreenWidthDp;
                inoutConfig.screenHeightDp = inoutConfig.compatScreenHeightDp;
                inoutConfig.smallestScreenWidthDp = inoutConfig.compatSmallestScreenWidthDp;
            } //End block
        } //End collapsed parenthetic
        addTaint(inoutConfig.getTaint());
        // ---------- Original Method ----------
        //if (!supportsScreen()) {
            //inoutConfig.screenLayout =
                    //(inoutConfig.screenLayout&~Configuration.SCREENLAYOUT_SIZE_MASK)
                    //| Configuration.SCREENLAYOUT_SIZE_NORMAL;
            //inoutConfig.screenWidthDp = inoutConfig.compatScreenWidthDp;
            //inoutConfig.screenHeightDp = inoutConfig.compatScreenHeightDp;
            //inoutConfig.smallestScreenWidthDp = inoutConfig.compatSmallestScreenWidthDp;
        //}
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.772 -0400", hash_original_method = "CD2E846E95D6DD1EBA23C219F15E8AAF", hash_generated_method = "9519AED73856F9828DE7A3DA417655CA")
    @Override
    public boolean equals(Object o) {
        try 
        {
            CompatibilityInfo oc;
            oc = (CompatibilityInfo)o;
        } //End block
        catch (ClassCastException e)
        { }
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_646136003 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_646136003;
        // ---------- Original Method ----------
        //try {
            //CompatibilityInfo oc = (CompatibilityInfo)o;
            //if (mCompatibilityFlags != oc.mCompatibilityFlags) return false;
            //if (applicationDensity != oc.applicationDensity) return false;
            //if (applicationScale != oc.applicationScale) return false;
            //if (applicationInvertedScale != oc.applicationInvertedScale) return false;
            //return true;
        //} catch (ClassCastException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.775 -0400", hash_original_method = "8391774F9F4D17C2A23793FA4442739E", hash_generated_method = "A91CD63BB2DE36B018B7A341914041BD")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1256856854 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(128);
        sb.append("{");
        sb.append(applicationDensity);
        sb.append("dpi");
        {
            boolean var99116A7FA4A89F4892D46EF5C786E5AD_1212199870 = (isScalingRequired());
            {
                sb.append(" ");
                sb.append(applicationScale);
                sb.append("x");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE7167D48931C006010D8B5CB5972BC1F_1179680020 = (!supportsScreen());
            {
                sb.append(" resizing");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCA1EFE893AA8EA68DFD50ADCAC7E67DF_793877798 = (neverSupportsScreen());
            {
                sb.append(" never-compat");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8FD3A043FAF334062C55758AA955AB0F_1628455193 = (alwaysSupportsScreen());
            {
                sb.append(" always-compat");
            } //End block
        } //End collapsed parenthetic
        sb.append("}");
        varB4EAC82CA7396A68D541C85D26508E83_1256856854 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1256856854.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1256856854;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(128);
        //sb.append("{");
        //sb.append(applicationDensity);
        //sb.append("dpi");
        //if (isScalingRequired()) {
            //sb.append(" ");
            //sb.append(applicationScale);
            //sb.append("x");
        //}
        //if (!supportsScreen()) {
            //sb.append(" resizing");
        //}
        //if (neverSupportsScreen()) {
            //sb.append(" never-compat");
        //}
        //if (alwaysSupportsScreen()) {
            //sb.append(" always-compat");
        //}
        //sb.append("}");
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.800 -0400", hash_original_method = "8473CF5A5DF2B74B5499D26C5398575D", hash_generated_method = "3C3941077B23C4633035DFBCF568BDCD")
    @Override
    public int hashCode() {
        int result;
        result = 17;
        result = 31 * result + mCompatibilityFlags;
        result = 31 * result + applicationDensity;
        result = 31 * result + Float.floatToIntBits(applicationScale);
        result = 31 * result + Float.floatToIntBits(applicationInvertedScale);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_385147519 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_385147519;
        // ---------- Original Method ----------
        //int result = 17;
        //result = 31 * result + mCompatibilityFlags;
        //result = 31 * result + applicationDensity;
        //result = 31 * result + Float.floatToIntBits(applicationScale);
        //result = 31 * result + Float.floatToIntBits(applicationInvertedScale);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.811 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "CC6A85A8A1E3CAC152ADF7830A930B96")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1291978467 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1291978467;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.812 -0400", hash_original_method = "FEB528FDE7329032F7938F1739557EEE", hash_generated_method = "44F0311BA66B4F20FAADDBCFA4181B07")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mCompatibilityFlags);
        dest.writeInt(applicationDensity);
        dest.writeFloat(applicationScale);
        dest.writeFloat(applicationInvertedScale);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mCompatibilityFlags);
        //dest.writeInt(applicationDensity);
        //dest.writeFloat(applicationScale);
        //dest.writeFloat(applicationInvertedScale);
    }

    
    public class Translator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.814 -0400", hash_original_field = "1B0B3DCFB15C2ED0E188C58DDA8DD7CD", hash_generated_field = "14E3397589B948719667F1E3AF571289")

        public float applicationScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.814 -0400", hash_original_field = "0C690E3EEBE7CF4097CF724C322C61E7", hash_generated_field = "FB16C6B90478FF3C6286ADC11FCB2FCF")

        public float applicationInvertedScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.814 -0400", hash_original_field = "EDE06AC5C744684AABDC17E4C58048FB", hash_generated_field = "C20DA98F4A08CF10BAA7142D933BD66B")

        private Rect mContentInsetsBuffer = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.814 -0400", hash_original_field = "BC4262CACB99DE79E24A559425160C3D", hash_generated_field = "1C9F92E30D2ADEA2CAAF0B834CACAAC8")

        private Rect mVisibleInsetsBuffer = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.814 -0400", hash_original_field = "5DA8752760AFEE3A011AA2DEFA9D2F09", hash_generated_field = "971A29021FD305F495522776D9E154AB")

        private Region mTouchableAreaBuffer = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.816 -0400", hash_original_method = "8F3615DA11565DF9F003F5DF13D87652", hash_generated_method = "0C0DC721E724DDCFF11BBA0EA3D0F318")
          Translator(float applicationScale, float applicationInvertedScale) {
            this.applicationScale = applicationScale;
            this.applicationInvertedScale = applicationInvertedScale;
            // ---------- Original Method ----------
            //this.applicationScale = applicationScale;
            //this.applicationInvertedScale = applicationInvertedScale;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.817 -0400", hash_original_method = "AAEFB3B2AA6A68EC0C613C02DA13C765", hash_generated_method = "B80EA47BCFE059FE1DCE31F0C84B8FFA")
          Translator() {
            this(CompatibilityInfo.this.applicationScale,
                    CompatibilityInfo.this.applicationInvertedScale);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.833 -0400", hash_original_method = "36CC389463C4EECA1FFAD848C8F58415", hash_generated_method = "6A95F75DF2FA2A3157C2E7AFCD6A3196")
        public void translateRectInScreenToAppWinFrame(Rect rect) {
            rect.scale(applicationInvertedScale);
            addTaint(rect.getTaint());
            // ---------- Original Method ----------
            //rect.scale(applicationInvertedScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.834 -0400", hash_original_method = "0A49DDBACE394A9C82B87775AA7B8808", hash_generated_method = "6A7314117C8269CDEA9C55F128F0FA9A")
        public void translateRegionInWindowToScreen(Region transparentRegion) {
            transparentRegion.scale(applicationScale);
            addTaint(transparentRegion.getTaint());
            // ---------- Original Method ----------
            //transparentRegion.scale(applicationScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.835 -0400", hash_original_method = "F6C04E9988D3236CD1A288419E980857", hash_generated_method = "9C89197DD97C52F9ECBE4CBB9AB42D8D")
        public void translateCanvas(Canvas canvas) {
            {
                float tinyOffset;
                tinyOffset = 2.0f / (3 * 255);
                canvas.translate(tinyOffset, tinyOffset);
            } //End block
            canvas.scale(applicationScale, applicationScale);
            addTaint(canvas.getTaint());
            // ---------- Original Method ----------
            //if (applicationScale == 1.5f) {
                //final float tinyOffset = 2.0f / (3 * 255);
                //canvas.translate(tinyOffset, tinyOffset);
            //}
            //canvas.scale(applicationScale, applicationScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.847 -0400", hash_original_method = "4D5FCD5F9907EB8D629A45C5A11C2836", hash_generated_method = "6CC0903C2B98DAE3F8446802376C4BA3")
        public void translateEventInScreenToAppWindow(MotionEvent event) {
            event.scale(applicationInvertedScale);
            addTaint(event.getTaint());
            // ---------- Original Method ----------
            //event.scale(applicationInvertedScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.848 -0400", hash_original_method = "DE018C3EFE6320C8CBFF22F7586A6AFE", hash_generated_method = "356F781F7177FCAAA0744976DB7DE008")
        public void translateWindowLayout(WindowManager.LayoutParams params) {
            params.scale(applicationScale);
            addTaint(params.getTaint());
            // ---------- Original Method ----------
            //params.scale(applicationScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.849 -0400", hash_original_method = "657A8C506709C2AB2507FE170E8B78C8", hash_generated_method = "36FA054FF09E8D512AD131218F319098")
        public void translateRectInAppWindowToScreen(Rect rect) {
            rect.scale(applicationScale);
            addTaint(rect.getTaint());
            // ---------- Original Method ----------
            //rect.scale(applicationScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.849 -0400", hash_original_method = "5BBB001295BC7F6BF111AF6DC66C9205", hash_generated_method = "91B5CF534CFE3D622E1E0379580CB483")
        public void translateRectInScreenToAppWindow(Rect rect) {
            rect.scale(applicationInvertedScale);
            addTaint(rect.getTaint());
            // ---------- Original Method ----------
            //rect.scale(applicationInvertedScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.865 -0400", hash_original_method = "9DE177160064B2A1F8C9D8228C599CDD", hash_generated_method = "19DCED688543C8E1B7300FC3C7CB5A8B")
        public void translatePointInScreenToAppWindow(PointF point) {
            float scale;
            scale = applicationInvertedScale;
            {
                point.x *= scale;
                point.y *= scale;
            } //End block
            addTaint(point.getTaint());
            // ---------- Original Method ----------
            //final float scale = applicationInvertedScale;
            //if (scale != 1.0f) {
                //point.x *= scale;
                //point.y *= scale;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.867 -0400", hash_original_method = "122ACDBA22A4D3B6B9E93FB00E1FAEC7", hash_generated_method = "D9FA42D278E92F5C1AD5CE1913C17798")
        public void translateLayoutParamsInAppWindowToScreen(LayoutParams params) {
            params.scale(applicationScale);
            addTaint(params.getTaint());
            // ---------- Original Method ----------
            //params.scale(applicationScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.868 -0400", hash_original_method = "43D8C9F45845A6C6CC10427CCFCFAF3D", hash_generated_method = "9D87EC76F9882D05D60088A9D9ACEA3A")
        public Rect getTranslatedContentInsets(Rect contentInsets) {
            Rect varB4EAC82CA7396A68D541C85D26508E83_871910378 = null; //Variable for return #1
            mContentInsetsBuffer = new Rect();
            mContentInsetsBuffer.set(contentInsets);
            translateRectInAppWindowToScreen(mContentInsetsBuffer);
            varB4EAC82CA7396A68D541C85D26508E83_871910378 = mContentInsetsBuffer;
            addTaint(contentInsets.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_871910378.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_871910378;
            // ---------- Original Method ----------
            //if (mContentInsetsBuffer == null) mContentInsetsBuffer = new Rect();
            //mContentInsetsBuffer.set(contentInsets);
            //translateRectInAppWindowToScreen(mContentInsetsBuffer);
            //return mContentInsetsBuffer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.885 -0400", hash_original_method = "DB46A5AF3015676AE668EB7338A074FC", hash_generated_method = "F14729052C223E0E7F1CF2B78D28A3D1")
        public Rect getTranslatedVisibleInsets(Rect visibleInsets) {
            Rect varB4EAC82CA7396A68D541C85D26508E83_2088427444 = null; //Variable for return #1
            mVisibleInsetsBuffer = new Rect();
            mVisibleInsetsBuffer.set(visibleInsets);
            translateRectInAppWindowToScreen(mVisibleInsetsBuffer);
            varB4EAC82CA7396A68D541C85D26508E83_2088427444 = mVisibleInsetsBuffer;
            addTaint(visibleInsets.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2088427444.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2088427444;
            // ---------- Original Method ----------
            //if (mVisibleInsetsBuffer == null) mVisibleInsetsBuffer = new Rect();
            //mVisibleInsetsBuffer.set(visibleInsets);
            //translateRectInAppWindowToScreen(mVisibleInsetsBuffer);
            //return mVisibleInsetsBuffer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.890 -0400", hash_original_method = "25CFF327B78CA768A3AFCA299ED2CC8E", hash_generated_method = "9FE95DA20162302970334EB8D67597AC")
        public Region getTranslatedTouchableArea(Region touchableArea) {
            Region varB4EAC82CA7396A68D541C85D26508E83_283846991 = null; //Variable for return #1
            mTouchableAreaBuffer = new Region();
            mTouchableAreaBuffer.set(touchableArea);
            mTouchableAreaBuffer.scale(applicationScale);
            varB4EAC82CA7396A68D541C85D26508E83_283846991 = mTouchableAreaBuffer;
            addTaint(touchableArea.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_283846991.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_283846991;
            // ---------- Original Method ----------
            //if (mTouchableAreaBuffer == null) mTouchableAreaBuffer = new Region();
            //mTouchableAreaBuffer.set(touchableArea);
            //mTouchableAreaBuffer.scale(applicationScale);
            //return mTouchableAreaBuffer;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.890 -0400", hash_original_field = "4D62768B5BBBA187A77A708A4E42824A", hash_generated_field = "08F5AA372944765B46BC517FBE4DAD3A")

    public static final CompatibilityInfo DEFAULT_COMPATIBILITY_INFO = new CompatibilityInfo() {
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.890 -0400", hash_original_field = "451C361316AB4D2AB8C1A0D4C769C245", hash_generated_field = "55912B57605F0907923E81814B30C0CE")

    public static final int DEFAULT_NORMAL_SHORT_DIMENSION = 320;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.890 -0400", hash_original_field = "E26C22452B88ED3FAEB17AF976663C39", hash_generated_field = "8D1764CCB355F9E44B73ECAF9C0E1A67")

    public static final float MAXIMUM_ASPECT_RATIO = (854f/480f);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.890 -0400", hash_original_field = "C28A801344B818D09042B9E76A19DD97", hash_generated_field = "B09C1324679AC4320442901B091A839D")

    private static int SCALING_REQUIRED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.891 -0400", hash_original_field = "E39F8903903FD6713DF47E8D72A99A0F", hash_generated_field = "25197CB34B6D91DC93A2310CB6AB64C4")

    private static int ALWAYS_NEEDS_COMPAT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.891 -0400", hash_original_field = "A1252321239230719F04378EA51B60DD", hash_generated_field = "8A8DB12BF9B04D84EEFE98E343EAE171")

    private static int NEVER_NEEDS_COMPAT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.891 -0400", hash_original_field = "12E72E73A3200A46C182FE5A62237016", hash_generated_field = "84E6D1E1561A620FC0E2D237B7651E76")

    private static int NEEDS_SCREEN_COMPAT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.891 -0400", hash_original_field = "22851AF58516589EBC6294DD83CB7F2D", hash_generated_field = "DDAA02554421F72326F350E7F40CEA00")

    public static final Parcelable.Creator<CompatibilityInfo> CREATOR
            = new Parcelable.Creator<CompatibilityInfo>() {
        public CompatibilityInfo createFromParcel(Parcel source) {
            return new CompatibilityInfo(source);
        }

        public CompatibilityInfo[] newArray(int size) {
            return new CompatibilityInfo[size];
        }
    };
}

