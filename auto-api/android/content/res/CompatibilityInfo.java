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
    private int mCompatibilityFlags;
    public int applicationDensity;
    public float applicationScale;
    public float applicationInvertedScale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.154 -0400", hash_original_method = "9C59C0A19ADE82EBF59B39AA82601FD9", hash_generated_method = "7C955C1841F30C2B05B3CF80E4EEE66F")
    @DSModeled(DSC.SAFE)
    public CompatibilityInfo(ApplicationInfo appInfo, int screenLayout, int sw,
            boolean forceCompat) {
        dsTaint.addTaint(forceCompat);
        dsTaint.addTaint(screenLayout);
        dsTaint.addTaint(appInfo.dsTaint);
        dsTaint.addTaint(sw);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.156 -0400", hash_original_method = "A82321676D9C84B0538DAFB6CC61C0CB", hash_generated_method = "1A5C3F6D6599DF87557FCCB4960751C7")
    @DSModeled(DSC.SAFE)
    private CompatibilityInfo(int compFlags,
            int dens, float scale, float invertedScale) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(invertedScale);
        dsTaint.addTaint(compFlags);
        dsTaint.addTaint(dens);
        // ---------- Original Method ----------
        //mCompatibilityFlags = compFlags;
        //applicationDensity = dens;
        //applicationScale = scale;
        //applicationInvertedScale = invertedScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.157 -0400", hash_original_method = "3DDB26515D25880873E2C6C7F1DDA6F5", hash_generated_method = "A144E464C092FC9674C214597E793D47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CompatibilityInfo() {
        this(NEVER_NEEDS_COMPAT, DisplayMetrics.DENSITY_DEVICE,
                1.0f,
                1.0f);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.159 -0400", hash_original_method = "B251F1B77EF355BF6FA118A826DF4F4A", hash_generated_method = "2ADB89D112A8559EFFB6D8104E0F8182")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CompatibilityInfo(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.159 -0400", hash_original_method = "E2D07E7BFECA2D29A0CD39AB3E4AD2F4", hash_generated_method = "1FAAF24D78F04F535EB54E7297FE2757")
    @DSModeled(DSC.SAFE)
    public boolean isScalingRequired() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mCompatibilityFlags&SCALING_REQUIRED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.159 -0400", hash_original_method = "AEF0832D3207872CC75E4AC6D7849C73", hash_generated_method = "7A464D2E7B6DF73C5850B3C5789BF628")
    @DSModeled(DSC.SAFE)
    public boolean supportsScreen() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mCompatibilityFlags&NEEDS_SCREEN_COMPAT) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.160 -0400", hash_original_method = "BD11775B1F66D2736A032A6A37E2552F", hash_generated_method = "C6BD36EEA91B59F75293D3761A089CA4")
    @DSModeled(DSC.SAFE)
    public boolean neverSupportsScreen() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mCompatibilityFlags&ALWAYS_NEEDS_COMPAT) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.160 -0400", hash_original_method = "CFA6F9CFCD9588B682D5F07DFF385684", hash_generated_method = "323A1E05F9FF26C0940BE4F6CF2B6165")
    @DSModeled(DSC.SAFE)
    public boolean alwaysSupportsScreen() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mCompatibilityFlags&NEVER_NEEDS_COMPAT) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.160 -0400", hash_original_method = "93ABC602B8C8A6238860B5CA46099876", hash_generated_method = "99519D88AC1D2C26C4D44024E5626D47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Translator getTranslator() {
        {
            boolean var99116A7FA4A89F4892D46EF5C786E5AD_1692790325 = (isScalingRequired());
            Object var10CB01929708C0AD9636F030CA26D86A_2041851153 = (new Translator());
        } //End flattened ternary
        return (Translator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return isScalingRequired() ? new Translator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.161 -0400", hash_original_method = "F5DFBBE3DCF906040672C2B4A4880712", hash_generated_method = "F0745F782D09E199F9C38DF23ECD294A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void applyToDisplayMetrics(DisplayMetrics inoutDm) {
        dsTaint.addTaint(inoutDm.dsTaint);
        {
            boolean varE7167D48931C006010D8B5CB5972BC1F_123810090 = (!supportsScreen());
            {
                CompatibilityInfo.computeCompatibleScaling(inoutDm, inoutDm);
            } //End block
            {
                inoutDm.widthPixels = inoutDm.noncompatWidthPixels;
                inoutDm.heightPixels = inoutDm.noncompatHeightPixels;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var99116A7FA4A89F4892D46EF5C786E5AD_44336262 = (isScalingRequired());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.161 -0400", hash_original_method = "D1D0A6DB2934A6F26FB8AACA9CE38F1E", hash_generated_method = "9989EA821F987593383E51AD852CFE12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void applyToConfiguration(Configuration inoutConfig) {
        dsTaint.addTaint(inoutConfig.dsTaint);
        {
            boolean varE7167D48931C006010D8B5CB5972BC1F_1462612158 = (!supportsScreen());
            {
                inoutConfig.screenLayout =
                    (inoutConfig.screenLayout&~Configuration.SCREENLAYOUT_SIZE_MASK)
                    | Configuration.SCREENLAYOUT_SIZE_NORMAL;
                inoutConfig.screenWidthDp = inoutConfig.compatScreenWidthDp;
                inoutConfig.screenHeightDp = inoutConfig.compatScreenHeightDp;
                inoutConfig.smallestScreenWidthDp = inoutConfig.compatSmallestScreenWidthDp;
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.162 -0400", hash_original_method = "CD2E846E95D6DD1EBA23C219F15E8AAF", hash_generated_method = "B125A8AF43A701E9117F39B18D977DC6")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        try 
        {
            CompatibilityInfo oc;
            oc = (CompatibilityInfo)o;
        } //End block
        catch (ClassCastException e)
        { }
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.162 -0400", hash_original_method = "8391774F9F4D17C2A23793FA4442739E", hash_generated_method = "2B909FFEAFBECC9CC499651B7D0A9F90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(128);
        sb.append("{");
        sb.append(applicationDensity);
        sb.append("dpi");
        {
            boolean var99116A7FA4A89F4892D46EF5C786E5AD_734510784 = (isScalingRequired());
            {
                sb.append(" ");
                sb.append(applicationScale);
                sb.append("x");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE7167D48931C006010D8B5CB5972BC1F_1365350360 = (!supportsScreen());
            {
                sb.append(" resizing");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCA1EFE893AA8EA68DFD50ADCAC7E67DF_1782788026 = (neverSupportsScreen());
            {
                sb.append(" never-compat");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8FD3A043FAF334062C55758AA955AB0F_984261158 = (alwaysSupportsScreen());
            {
                sb.append(" always-compat");
            } //End block
        } //End collapsed parenthetic
        sb.append("}");
        String var806458D832AB974D230FEE4CBBDBD390_531223224 = (sb.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.163 -0400", hash_original_method = "8473CF5A5DF2B74B5499D26C5398575D", hash_generated_method = "101DC586F3A388F2FF415064763B0004")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int result;
        result = 17;
        result = 31 * result + mCompatibilityFlags;
        result = 31 * result + applicationDensity;
        result = 31 * result + Float.floatToIntBits(applicationScale);
        result = 31 * result + Float.floatToIntBits(applicationInvertedScale);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = 17;
        //result = 31 * result + mCompatibilityFlags;
        //result = 31 * result + applicationDensity;
        //result = 31 * result + Float.floatToIntBits(applicationScale);
        //result = 31 * result + Float.floatToIntBits(applicationInvertedScale);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.163 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.163 -0400", hash_original_method = "FEB528FDE7329032F7938F1739557EEE", hash_generated_method = "F16882AF0A1A89D543F1A0BBB11A82A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mCompatibilityFlags);
        dest.writeInt(applicationDensity);
        dest.writeFloat(applicationScale);
        dest.writeFloat(applicationInvertedScale);
        // ---------- Original Method ----------
        //dest.writeInt(mCompatibilityFlags);
        //dest.writeInt(applicationDensity);
        //dest.writeFloat(applicationScale);
        //dest.writeFloat(applicationInvertedScale);
    }

    
    public class Translator {
        public float applicationScale;
        public float applicationInvertedScale;
        private Rect mContentInsetsBuffer = null;
        private Rect mVisibleInsetsBuffer = null;
        private Region mTouchableAreaBuffer = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.164 -0400", hash_original_method = "8F3615DA11565DF9F003F5DF13D87652", hash_generated_method = "40B304E465823C90A5C6BD541844135B")
        @DSModeled(DSC.SAFE)
         Translator(float applicationScale, float applicationInvertedScale) {
            dsTaint.addTaint(applicationInvertedScale);
            dsTaint.addTaint(applicationScale);
            // ---------- Original Method ----------
            //this.applicationScale = applicationScale;
            //this.applicationInvertedScale = applicationInvertedScale;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.164 -0400", hash_original_method = "AAEFB3B2AA6A68EC0C613C02DA13C765", hash_generated_method = "B80EA47BCFE059FE1DCE31F0C84B8FFA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Translator() {
            this(CompatibilityInfo.this.applicationScale,
                    CompatibilityInfo.this.applicationInvertedScale);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.164 -0400", hash_original_method = "36CC389463C4EECA1FFAD848C8F58415", hash_generated_method = "4DC6AA937E0A66EF6752BBE66EEEE7DA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void translateRectInScreenToAppWinFrame(Rect rect) {
            dsTaint.addTaint(rect.dsTaint);
            rect.scale(applicationInvertedScale);
            // ---------- Original Method ----------
            //rect.scale(applicationInvertedScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.164 -0400", hash_original_method = "0A49DDBACE394A9C82B87775AA7B8808", hash_generated_method = "1C797095531CA5DD5BC35822783CD1C4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void translateRegionInWindowToScreen(Region transparentRegion) {
            dsTaint.addTaint(transparentRegion.dsTaint);
            transparentRegion.scale(applicationScale);
            // ---------- Original Method ----------
            //transparentRegion.scale(applicationScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.165 -0400", hash_original_method = "F6C04E9988D3236CD1A288419E980857", hash_generated_method = "40FAB90CF79D52F21C27DA5F4C441519")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void translateCanvas(Canvas canvas) {
            dsTaint.addTaint(canvas.dsTaint);
            {
                float tinyOffset;
                tinyOffset = 2.0f / (3 * 255);
                canvas.translate(tinyOffset, tinyOffset);
            } //End block
            canvas.scale(applicationScale, applicationScale);
            // ---------- Original Method ----------
            //if (applicationScale == 1.5f) {
                //final float tinyOffset = 2.0f / (3 * 255);
                //canvas.translate(tinyOffset, tinyOffset);
            //}
            //canvas.scale(applicationScale, applicationScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.165 -0400", hash_original_method = "4D5FCD5F9907EB8D629A45C5A11C2836", hash_generated_method = "623EDABBC4F4E1750B8771FE1AEDF01A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void translateEventInScreenToAppWindow(MotionEvent event) {
            dsTaint.addTaint(event.dsTaint);
            event.scale(applicationInvertedScale);
            // ---------- Original Method ----------
            //event.scale(applicationInvertedScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.165 -0400", hash_original_method = "DE018C3EFE6320C8CBFF22F7586A6AFE", hash_generated_method = "01CA78EE8C4CD5D180CE44EC26C50899")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void translateWindowLayout(WindowManager.LayoutParams params) {
            dsTaint.addTaint(params.dsTaint);
            params.scale(applicationScale);
            // ---------- Original Method ----------
            //params.scale(applicationScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.165 -0400", hash_original_method = "657A8C506709C2AB2507FE170E8B78C8", hash_generated_method = "0B26A3B7717E7B8B5D61366E6E3096E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void translateRectInAppWindowToScreen(Rect rect) {
            dsTaint.addTaint(rect.dsTaint);
            rect.scale(applicationScale);
            // ---------- Original Method ----------
            //rect.scale(applicationScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.166 -0400", hash_original_method = "5BBB001295BC7F6BF111AF6DC66C9205", hash_generated_method = "21CF053E550A514DA4F53CC64A30096F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void translateRectInScreenToAppWindow(Rect rect) {
            dsTaint.addTaint(rect.dsTaint);
            rect.scale(applicationInvertedScale);
            // ---------- Original Method ----------
            //rect.scale(applicationInvertedScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.166 -0400", hash_original_method = "9DE177160064B2A1F8C9D8228C599CDD", hash_generated_method = "8CEB6B385F55CF715AC542F9909F48B0")
        @DSModeled(DSC.SAFE)
        public void translatePointInScreenToAppWindow(PointF point) {
            dsTaint.addTaint(point.dsTaint);
            float scale;
            scale = applicationInvertedScale;
            {
                point.x *= scale;
                point.y *= scale;
            } //End block
            // ---------- Original Method ----------
            //final float scale = applicationInvertedScale;
            //if (scale != 1.0f) {
                //point.x *= scale;
                //point.y *= scale;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.166 -0400", hash_original_method = "122ACDBA22A4D3B6B9E93FB00E1FAEC7", hash_generated_method = "7D6D8C05D0198DAAA6330945F6C1F93E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void translateLayoutParamsInAppWindowToScreen(LayoutParams params) {
            dsTaint.addTaint(params.dsTaint);
            params.scale(applicationScale);
            // ---------- Original Method ----------
            //params.scale(applicationScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.166 -0400", hash_original_method = "43D8C9F45845A6C6CC10427CCFCFAF3D", hash_generated_method = "8D4E86A37B403428040A1A701E1E3AE6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Rect getTranslatedContentInsets(Rect contentInsets) {
            dsTaint.addTaint(contentInsets.dsTaint);
            mContentInsetsBuffer = new Rect();
            mContentInsetsBuffer.set(contentInsets);
            translateRectInAppWindowToScreen(mContentInsetsBuffer);
            return (Rect)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mContentInsetsBuffer == null) mContentInsetsBuffer = new Rect();
            //mContentInsetsBuffer.set(contentInsets);
            //translateRectInAppWindowToScreen(mContentInsetsBuffer);
            //return mContentInsetsBuffer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.167 -0400", hash_original_method = "DB46A5AF3015676AE668EB7338A074FC", hash_generated_method = "8AAE4896629E7110CDB772673DB0EE15")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Rect getTranslatedVisibleInsets(Rect visibleInsets) {
            dsTaint.addTaint(visibleInsets.dsTaint);
            mVisibleInsetsBuffer = new Rect();
            mVisibleInsetsBuffer.set(visibleInsets);
            translateRectInAppWindowToScreen(mVisibleInsetsBuffer);
            return (Rect)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mVisibleInsetsBuffer == null) mVisibleInsetsBuffer = new Rect();
            //mVisibleInsetsBuffer.set(visibleInsets);
            //translateRectInAppWindowToScreen(mVisibleInsetsBuffer);
            //return mVisibleInsetsBuffer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.167 -0400", hash_original_method = "25CFF327B78CA768A3AFCA299ED2CC8E", hash_generated_method = "F2B2863C499CE8EBA5E3B46A63B4F5D4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Region getTranslatedTouchableArea(Region touchableArea) {
            dsTaint.addTaint(touchableArea.dsTaint);
            mTouchableAreaBuffer = new Region();
            mTouchableAreaBuffer.set(touchableArea);
            mTouchableAreaBuffer.scale(applicationScale);
            return (Region)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mTouchableAreaBuffer == null) mTouchableAreaBuffer = new Region();
            //mTouchableAreaBuffer.set(touchableArea);
            //mTouchableAreaBuffer.scale(applicationScale);
            //return mTouchableAreaBuffer;
        }

        
    }


    
    public static final CompatibilityInfo DEFAULT_COMPATIBILITY_INFO = new CompatibilityInfo() {        
}; //Transformed anonymous class
    public static final int DEFAULT_NORMAL_SHORT_DIMENSION = 320;
    public static final float MAXIMUM_ASPECT_RATIO = (854f/480f);
    private static final int SCALING_REQUIRED = 1;
    private static final int ALWAYS_NEEDS_COMPAT = 2;
    private static final int NEVER_NEEDS_COMPAT = 4;
    private static final int NEEDS_SCREEN_COMPAT = 8;
    public static final Parcelable.Creator<CompatibilityInfo> CREATOR = new Parcelable.Creator<CompatibilityInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.167 -0400", hash_original_method = "2114E6EBB23116BFD4134066FF759826", hash_generated_method = "6D7BFFD5415DA29756A6E4E3E608545D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CompatibilityInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            CompatibilityInfo varC5BB9C0D74A336952D25269F28182455_432239684 = (new CompatibilityInfo(source));
            return (CompatibilityInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CompatibilityInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.167 -0400", hash_original_method = "005F3B39CF5633E13C56EF8C7CCB7246", hash_generated_method = "C6214EF364D60C4D522308307BCF7F55")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CompatibilityInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            CompatibilityInfo[] varEAE0B76516748B5601E8CDF99990D6A4_14718799 = (new CompatibilityInfo[size]);
            return (CompatibilityInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CompatibilityInfo[size];
        }

        
}; //Transformed anonymous class
}

