package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    public static final CompatibilityInfo DEFAULT_COMPATIBILITY_INFO = new CompatibilityInfo() {        
}; //Transformed anonymous class
    public static final int DEFAULT_NORMAL_SHORT_DIMENSION = 320;
    public static final float MAXIMUM_ASPECT_RATIO = (854f/480f);
    private final int mCompatibilityFlags;
    private static final int SCALING_REQUIRED = 1;
    private static final int ALWAYS_NEEDS_COMPAT = 2;
    private static final int NEVER_NEEDS_COMPAT = 4;
    private static final int NEEDS_SCREEN_COMPAT = 8;
    public final int applicationDensity;
    public final float applicationScale;
    public final float applicationInvertedScale;
    public static final Parcelable.Creator<CompatibilityInfo> CREATOR = new Parcelable.Creator<CompatibilityInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.269 -0400", hash_original_method = "2114E6EBB23116BFD4134066FF759826", hash_generated_method = "28C2F31A65092BF16869E8C14856816E")
        @DSModeled(DSC.SAFE)
        public CompatibilityInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (CompatibilityInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CompatibilityInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.269 -0400", hash_original_method = "005F3B39CF5633E13C56EF8C7CCB7246", hash_generated_method = "467752BF63ED0D507D830180A01965E3")
        @DSModeled(DSC.SAFE)
        public CompatibilityInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            return (CompatibilityInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CompatibilityInfo[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.270 -0400", hash_original_method = "9C59C0A19ADE82EBF59B39AA82601FD9", hash_generated_method = "13A3490A73F8BF65E2371F340B8F6802")
    @DSModeled(DSC.SAFE)
    public CompatibilityInfo(ApplicationInfo appInfo, int screenLayout, int sw,
            boolean forceCompat) {
        dsTaint.addTaint(screenLayout);
        dsTaint.addTaint(forceCompat);
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
            final int EXPANDABLE;
            EXPANDABLE = 2;
            final int LARGE_SCREENS;
            LARGE_SCREENS = 8;
            final int XLARGE_SCREENS;
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
           
        } //End block
        mCompatibilityFlags = compatFlags;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.270 -0400", hash_original_method = "A82321676D9C84B0538DAFB6CC61C0CB", hash_generated_method = "77E444AC124DB07AE5B05D61880C8C9B")
    @DSModeled(DSC.SAFE)
    private CompatibilityInfo(int compFlags,
            int dens, float scale, float invertedScale) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(compFlags);
        dsTaint.addTaint(invertedScale);
        dsTaint.addTaint(dens);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.270 -0400", hash_original_method = "3DDB26515D25880873E2C6C7F1DDA6F5", hash_generated_method = "561656DEB0F2A30E0EB4497F346219AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CompatibilityInfo() {
        this(NEVER_NEEDS_COMPAT, DisplayMetrics.DENSITY_DEVICE,
                1.0f,
                1.0f);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.270 -0400", hash_original_method = "B251F1B77EF355BF6FA118A826DF4F4A", hash_generated_method = "4DEAB1E8550C48B902E049FF3B0188FD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.271 -0400", hash_original_method = "E2D07E7BFECA2D29A0CD39AB3E4AD2F4", hash_generated_method = "85BDF07C939A826FCA2E2B309B317B12")
    @DSModeled(DSC.SAFE)
    public boolean isScalingRequired() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mCompatibilityFlags&SCALING_REQUIRED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.271 -0400", hash_original_method = "AEF0832D3207872CC75E4AC6D7849C73", hash_generated_method = "AD0F07C2417F20816E951930A725A860")
    @DSModeled(DSC.SAFE)
    public boolean supportsScreen() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mCompatibilityFlags&NEEDS_SCREEN_COMPAT) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.271 -0400", hash_original_method = "BD11775B1F66D2736A032A6A37E2552F", hash_generated_method = "98D035110F489677F76E3B8BD9294611")
    @DSModeled(DSC.SAFE)
    public boolean neverSupportsScreen() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mCompatibilityFlags&ALWAYS_NEEDS_COMPAT) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.271 -0400", hash_original_method = "CFA6F9CFCD9588B682D5F07DFF385684", hash_generated_method = "5F33C96642522E7ED335A8816D5508CC")
    @DSModeled(DSC.SAFE)
    public boolean alwaysSupportsScreen() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mCompatibilityFlags&NEVER_NEEDS_COMPAT) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.271 -0400", hash_original_method = "93ABC602B8C8A6238860B5CA46099876", hash_generated_method = "6122030E0733E00360930567F47321A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Translator getTranslator() {
        {
            boolean var99116A7FA4A89F4892D46EF5C786E5AD_1462652880 = (isScalingRequired());
        } //End flattened ternary
        return (Translator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return isScalingRequired() ? new Translator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.272 -0400", hash_original_method = "F5DFBBE3DCF906040672C2B4A4880712", hash_generated_method = "78A00BAA64895B4413C99BF271C6B98E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void applyToDisplayMetrics(DisplayMetrics inoutDm) {
        dsTaint.addTaint(inoutDm.dsTaint);
        {
            boolean varE7167D48931C006010D8B5CB5972BC1F_1043754989 = (!supportsScreen());
            {
                CompatibilityInfo.computeCompatibleScaling(inoutDm, inoutDm);
            } //End block
            {
                inoutDm.widthPixels = inoutDm.noncompatWidthPixels;
                inoutDm.heightPixels = inoutDm.noncompatHeightPixels;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var99116A7FA4A89F4892D46EF5C786E5AD_1047003800 = (isScalingRequired());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.272 -0400", hash_original_method = "D1D0A6DB2934A6F26FB8AACA9CE38F1E", hash_generated_method = "F18E5D74C6C645D3936E082E3E3A0917")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void applyToConfiguration(Configuration inoutConfig) {
        dsTaint.addTaint(inoutConfig.dsTaint);
        {
            boolean varE7167D48931C006010D8B5CB5972BC1F_448241172 = (!supportsScreen());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.272 -0400", hash_original_method = "5B98F5827867C3DC60F60E22E81275D2", hash_generated_method = "F06992E51E8E0196730E3864224731B8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.273 -0400", hash_original_method = "CD2E846E95D6DD1EBA23C219F15E8AAF", hash_generated_method = "9C1C50738DF6E0EA87B9C2F23A8FE93D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.273 -0400", hash_original_method = "8391774F9F4D17C2A23793FA4442739E", hash_generated_method = "5F3AF8B9FFF48B10D32E3FE670556A3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(128);
        sb.append("{");
        sb.append(applicationDensity);
        sb.append("dpi");
        {
            boolean var99116A7FA4A89F4892D46EF5C786E5AD_1555563282 = (isScalingRequired());
            {
                sb.append(" ");
                sb.append(applicationScale);
                sb.append("x");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE7167D48931C006010D8B5CB5972BC1F_297254780 = (!supportsScreen());
            {
                sb.append(" resizing");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCA1EFE893AA8EA68DFD50ADCAC7E67DF_1893550811 = (neverSupportsScreen());
            {
                sb.append(" never-compat");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8FD3A043FAF334062C55758AA955AB0F_1034993567 = (alwaysSupportsScreen());
            {
                sb.append(" always-compat");
            } //End block
        } //End collapsed parenthetic
        sb.append("}");
        String var806458D832AB974D230FEE4CBBDBD390_437692333 = (sb.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.273 -0400", hash_original_method = "8473CF5A5DF2B74B5499D26C5398575D", hash_generated_method = "5956EB30AEE4D608D49CECABAEA2C808")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.274 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "826038BB7EBD5D3C24D01F025676D20A")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.274 -0400", hash_original_method = "FEB528FDE7329032F7938F1739557EEE", hash_generated_method = "C1FF2EFD16B8312ED0399463A0EF2777")
    @DSModeled(DSC.SAFE)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
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
        final public float applicationScale;
        final public float applicationInvertedScale;
        private Rect mContentInsetsBuffer = null;
        private Rect mVisibleInsetsBuffer = null;
        private Region mTouchableAreaBuffer = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.274 -0400", hash_original_method = "8F3615DA11565DF9F003F5DF13D87652", hash_generated_method = "0B8A5ECB6A4D2F5F8189CF20709B3EA7")
        @DSModeled(DSC.SAFE)
         Translator(float applicationScale, float applicationInvertedScale) {
            dsTaint.addTaint(applicationInvertedScale);
            dsTaint.addTaint(applicationScale);
            this.applicationScale = applicationScale;
            this.applicationInvertedScale = applicationInvertedScale;
            // ---------- Original Method ----------
            //this.applicationScale = applicationScale;
            //this.applicationInvertedScale = applicationInvertedScale;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.274 -0400", hash_original_method = "AAEFB3B2AA6A68EC0C613C02DA13C765", hash_generated_method = "B73EBC9A511E96EBE40570663962F476")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Translator() {
            this(CompatibilityInfo.this.applicationScale,
                    CompatibilityInfo.this.applicationInvertedScale);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.274 -0400", hash_original_method = "36CC389463C4EECA1FFAD848C8F58415", hash_generated_method = "199DBD48580C4D362E7034A22C774709")
        @DSModeled(DSC.SAFE)
        public void translateRectInScreenToAppWinFrame(Rect rect) {
            dsTaint.addTaint(rect.dsTaint);
            rect.scale(applicationInvertedScale);
            // ---------- Original Method ----------
            //rect.scale(applicationInvertedScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.275 -0400", hash_original_method = "0A49DDBACE394A9C82B87775AA7B8808", hash_generated_method = "E4A080D5CCAB763B8D8F689BCCDF60F1")
        @DSModeled(DSC.SAFE)
        public void translateRegionInWindowToScreen(Region transparentRegion) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(transparentRegion.dsTaint);
            transparentRegion.scale(applicationScale);
            // ---------- Original Method ----------
            //transparentRegion.scale(applicationScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.275 -0400", hash_original_method = "F6C04E9988D3236CD1A288419E980857", hash_generated_method = "611BF06B653E98CBF8E3C88892537A2C")
        @DSModeled(DSC.SAFE)
        public void translateCanvas(Canvas canvas) {
            dsTaint.addTaint(canvas.dsTaint);
            {
                final float tinyOffset;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.275 -0400", hash_original_method = "4D5FCD5F9907EB8D629A45C5A11C2836", hash_generated_method = "4E0D06CC6B016370117E9F47BD3F566B")
        @DSModeled(DSC.SAFE)
        public void translateEventInScreenToAppWindow(MotionEvent event) {
            dsTaint.addTaint(event.dsTaint);
            event.scale(applicationInvertedScale);
            // ---------- Original Method ----------
            //event.scale(applicationInvertedScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.275 -0400", hash_original_method = "DE018C3EFE6320C8CBFF22F7586A6AFE", hash_generated_method = "4CA9865E5689E48E79AC422FE63AA113")
        @DSModeled(DSC.SAFE)
        public void translateWindowLayout(WindowManager.LayoutParams params) {
            dsTaint.addTaint(params.dsTaint);
            params.scale(applicationScale);
            // ---------- Original Method ----------
            //params.scale(applicationScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.275 -0400", hash_original_method = "657A8C506709C2AB2507FE170E8B78C8", hash_generated_method = "18505DE9AE2AA5F68EC44275F782B423")
        @DSModeled(DSC.SAFE)
        public void translateRectInAppWindowToScreen(Rect rect) {
            dsTaint.addTaint(rect.dsTaint);
            rect.scale(applicationScale);
            // ---------- Original Method ----------
            //rect.scale(applicationScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.276 -0400", hash_original_method = "5BBB001295BC7F6BF111AF6DC66C9205", hash_generated_method = "07B791398AA3CB5965E60DCA5535CA05")
        @DSModeled(DSC.SAFE)
        public void translateRectInScreenToAppWindow(Rect rect) {
            dsTaint.addTaint(rect.dsTaint);
            rect.scale(applicationInvertedScale);
            // ---------- Original Method ----------
            //rect.scale(applicationInvertedScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.276 -0400", hash_original_method = "9DE177160064B2A1F8C9D8228C599CDD", hash_generated_method = "58FDC04897DCFE0DC99AA3E9E9BAB71B")
        @DSModeled(DSC.SAFE)
        public void translatePointInScreenToAppWindow(PointF point) {
            dsTaint.addTaint(point.dsTaint);
            final float scale;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.276 -0400", hash_original_method = "122ACDBA22A4D3B6B9E93FB00E1FAEC7", hash_generated_method = "ECB0AC7B38BA997C846D70B8E12973E4")
        @DSModeled(DSC.SAFE)
        public void translateLayoutParamsInAppWindowToScreen(LayoutParams params) {
            dsTaint.addTaint(params.dsTaint);
            params.scale(applicationScale);
            // ---------- Original Method ----------
            //params.scale(applicationScale);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.276 -0400", hash_original_method = "43D8C9F45845A6C6CC10427CCFCFAF3D", hash_generated_method = "BB6FB04439A1772D8E871D1551B58477")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.276 -0400", hash_original_method = "DB46A5AF3015676AE668EB7338A074FC", hash_generated_method = "8008242811A2D1115B6CD514E553C308")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.277 -0400", hash_original_method = "25CFF327B78CA768A3AFCA299ED2CC8E", hash_generated_method = "7B24C96A8541BB543F86F83B10ACB26E")
        @DSModeled(DSC.SAFE)
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


    
}


