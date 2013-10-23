package android.content.res;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.170 -0400", hash_original_field = "44CEE0DD1BE1998482D8262782403C60", hash_generated_field = "B4CB39B5E76E4F134AE9FD81F38E628C")

    private int mCompatibilityFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.170 -0400", hash_original_field = "CCF0FB9B0F263F71EE6018A478D4C5B2", hash_generated_field = "D4940D12226C2B60194AF35187704159")

    public int applicationDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.170 -0400", hash_original_field = "1B0B3DCFB15C2ED0E188C58DDA8DD7CD", hash_generated_field = "14E3397589B948719667F1E3AF571289")

    public float applicationScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.170 -0400", hash_original_field = "0C690E3EEBE7CF4097CF724C322C61E7", hash_generated_field = "FB16C6B90478FF3C6286ADC11FCB2FCF")

    public float applicationInvertedScale;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.177 -0400", hash_original_method = "9C59C0A19ADE82EBF59B39AA82601FD9", hash_generated_method = "18AD6CFE6DAC37BD4E5421A1D263A036")
    public  CompatibilityInfo(ApplicationInfo appInfo, int screenLayout, int sw,
            boolean forceCompat) {
        addTaint(forceCompat);
        addTaint(sw);
        addTaint(screenLayout);
        addTaint(appInfo.getTaint());
        int compatFlags = 0;
        if(appInfo.requiresSmallestWidthDp != 0 || appInfo.compatibleWidthLimitDp != 0
                || appInfo.largestWidthLimitDp != 0)        
        {
            int required = appInfo.requiresSmallestWidthDp != 0
                    ? appInfo.requiresSmallestWidthDp
                    : appInfo.compatibleWidthLimitDp;
            if(required == 0)            
            {
                required = appInfo.largestWidthLimitDp;
            } //End block
            int compat = appInfo.compatibleWidthLimitDp != 0
                    ? appInfo.compatibleWidthLimitDp : required;
            if(compat < required)            
            {
                compat = required;
            } //End block
            int largest = appInfo.largestWidthLimitDp;
            if(required > DEFAULT_NORMAL_SHORT_DIMENSION)            
            {
                compatFlags |= NEVER_NEEDS_COMPAT;
            } //End block
            else
            if(largest != 0 && sw > largest)            
            {
                compatFlags |= NEEDS_SCREEN_COMPAT | ALWAYS_NEEDS_COMPAT;
            } //End block
            else
            if(compat >= sw)            
            {
                compatFlags |= NEVER_NEEDS_COMPAT;
            } //End block
            else
            if(forceCompat)            
            {
                compatFlags |= NEEDS_SCREEN_COMPAT;
            } //End block
            applicationDensity = DisplayMetrics.DENSITY_DEVICE;
            applicationScale = 1.0f;
            applicationInvertedScale = 1.0f;
        } //End block
        else
        {
            final int EXPANDABLE = 2;
            final int LARGE_SCREENS = 8;
            final int XLARGE_SCREENS = 32;
            int sizeInfo = 0;
            boolean anyResizeable = false;
            if((appInfo.flags & ApplicationInfo.FLAG_SUPPORTS_LARGE_SCREENS) != 0)            
            {
                sizeInfo |= LARGE_SCREENS;
                anyResizeable = true;
                if(!forceCompat)                
                {
                    sizeInfo |= XLARGE_SCREENS | EXPANDABLE;
                } //End block
            } //End block
            if((appInfo.flags & ApplicationInfo.FLAG_SUPPORTS_XLARGE_SCREENS) != 0)            
            {
                anyResizeable = true;
                if(!forceCompat)                
                {
                    sizeInfo |= XLARGE_SCREENS | EXPANDABLE;
                } //End block
            } //End block
            if((appInfo.flags & ApplicationInfo.FLAG_RESIZEABLE_FOR_SCREENS) != 0)            
            {
                anyResizeable = true;
                sizeInfo |= EXPANDABLE;
            } //End block
            if(forceCompat)            
            {
                sizeInfo &= ~EXPANDABLE;
            } //End block
            compatFlags |= NEEDS_SCREEN_COMPAT;
switch(screenLayout&Configuration.SCREENLAYOUT_SIZE_MASK){
            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
            if((sizeInfo&XLARGE_SCREENS) != 0)            
            {
                compatFlags &= ~NEEDS_SCREEN_COMPAT;
            } //End block
            if((appInfo.flags & ApplicationInfo.FLAG_SUPPORTS_XLARGE_SCREENS) != 0)            
            {
                compatFlags |= NEVER_NEEDS_COMPAT;
            } //End block
            break;
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
            if((sizeInfo&LARGE_SCREENS) != 0)            
            {
                compatFlags &= ~NEEDS_SCREEN_COMPAT;
            } //End block
            if((appInfo.flags & ApplicationInfo.FLAG_SUPPORTS_LARGE_SCREENS) != 0)            
            {
                compatFlags |= NEVER_NEEDS_COMPAT;
            } //End block
            break;
}            if((screenLayout&Configuration.SCREENLAYOUT_COMPAT_NEEDED) != 0)            
            {
                if((sizeInfo&EXPANDABLE) != 0)                
                {
                    compatFlags &= ~NEEDS_SCREEN_COMPAT;
                } //End block
                else
                if(!anyResizeable)                
                {
                    compatFlags |= ALWAYS_NEEDS_COMPAT;
                } //End block
            } //End block
            else
            {
                compatFlags &= ~NEEDS_SCREEN_COMPAT;
                compatFlags |= NEVER_NEEDS_COMPAT;
            } //End block
            if((appInfo.flags & ApplicationInfo.FLAG_SUPPORTS_SCREEN_DENSITIES) != 0)            
            {
                applicationDensity = DisplayMetrics.DENSITY_DEVICE;
                applicationScale = 1.0f;
                applicationInvertedScale = 1.0f;
            } //End block
            else
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.180 -0400", hash_original_method = "A82321676D9C84B0538DAFB6CC61C0CB", hash_generated_method = "D97765B16CE7043641005CA614BC91BD")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.181 -0400", hash_original_method = "3DDB26515D25880873E2C6C7F1DDA6F5", hash_generated_method = "A144E464C092FC9674C214597E793D47")
    private  CompatibilityInfo() {
        this(NEVER_NEEDS_COMPAT, DisplayMetrics.DENSITY_DEVICE,
                1.0f,
                1.0f);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.182 -0400", hash_original_method = "B251F1B77EF355BF6FA118A826DF4F4A", hash_generated_method = "48F71F1044639FA67CF1237AD6C85A09")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.182 -0400", hash_original_method = "E2D07E7BFECA2D29A0CD39AB3E4AD2F4", hash_generated_method = "C42D57D9BDCBE3EA3F96951A94F23C36")
    public boolean isScalingRequired() {
        boolean var6A6CD585B1B2D73D861457664A9CD0F9_712684239 = ((mCompatibilityFlags&SCALING_REQUIRED) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1500890783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1500890783;
        // ---------- Original Method ----------
        //return (mCompatibilityFlags&SCALING_REQUIRED) != 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.183 -0400", hash_original_method = "AEF0832D3207872CC75E4AC6D7849C73", hash_generated_method = "CCF216EE43F89A06F17DFC9F0EDDC23C")
    public boolean supportsScreen() {
        boolean var84D503005FB9552E72FBBDCB72F1ED29_173417250 = ((mCompatibilityFlags&NEEDS_SCREEN_COMPAT) == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2051505765 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2051505765;
        // ---------- Original Method ----------
        //return (mCompatibilityFlags&NEEDS_SCREEN_COMPAT) == 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.183 -0400", hash_original_method = "BD11775B1F66D2736A032A6A37E2552F", hash_generated_method = "A876F26497255640D1715EA5349CD043")
    public boolean neverSupportsScreen() {
        boolean var379E94ED74A64A75DEBC993E9380509C_1191169645 = ((mCompatibilityFlags&ALWAYS_NEEDS_COMPAT) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1516800692 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1516800692;
        // ---------- Original Method ----------
        //return (mCompatibilityFlags&ALWAYS_NEEDS_COMPAT) != 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.183 -0400", hash_original_method = "CFA6F9CFCD9588B682D5F07DFF385684", hash_generated_method = "5571197846216CF8F7A515A71DE2FBEA")
    public boolean alwaysSupportsScreen() {
        boolean var7620E96D5792B82515FAB327536E265B_1266746093 = ((mCompatibilityFlags&NEVER_NEEDS_COMPAT) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_892685461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_892685461;
        // ---------- Original Method ----------
        //return (mCompatibilityFlags&NEVER_NEEDS_COMPAT) != 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.184 -0400", hash_original_method = "93ABC602B8C8A6238860B5CA46099876", hash_generated_method = "100870F2FD485E3A607CC8FF5A6F1F76")
    public Translator getTranslator() {
Translator var6A5072CB73297FFF4B7B0652833EAB52_214876014 =         isScalingRequired() ? new Translator() : null;
        var6A5072CB73297FFF4B7B0652833EAB52_214876014.addTaint(taint);
        return var6A5072CB73297FFF4B7B0652833EAB52_214876014;
        // ---------- Original Method ----------
        //return isScalingRequired() ? new Translator() : null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.186 -0400", hash_original_method = "F5DFBBE3DCF906040672C2B4A4880712", hash_generated_method = "63D1C59C04F2532F2C4828EB4F3A8471")
    public void applyToDisplayMetrics(DisplayMetrics inoutDm) {
        addTaint(inoutDm.getTaint());
        if(!supportsScreen())        
        {
            CompatibilityInfo.computeCompatibleScaling(inoutDm, inoutDm);
        } //End block
        else
        {
            inoutDm.widthPixels = inoutDm.noncompatWidthPixels;
            inoutDm.heightPixels = inoutDm.noncompatHeightPixels;
        } //End block
        if(isScalingRequired())        
        {
            float invertedRatio = applicationInvertedScale;
            inoutDm.density = inoutDm.noncompatDensity * invertedRatio;
            inoutDm.densityDpi = (int)((inoutDm.density*DisplayMetrics.DENSITY_DEFAULT)+.5f);
            inoutDm.scaledDensity = inoutDm.noncompatScaledDensity * invertedRatio;
            inoutDm.xdpi = inoutDm.noncompatXdpi * invertedRatio;
            inoutDm.ydpi = inoutDm.noncompatYdpi * invertedRatio;
            inoutDm.widthPixels = (int) (inoutDm.widthPixels * invertedRatio + 0.5f);
            inoutDm.heightPixels = (int) (inoutDm.heightPixels * invertedRatio + 0.5f);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.188 -0400", hash_original_method = "D1D0A6DB2934A6F26FB8AACA9CE38F1E", hash_generated_method = "427E3E00EF8592BD9A7B55153D4213E4")
    public void applyToConfiguration(Configuration inoutConfig) {
        addTaint(inoutConfig.getTaint());
        if(!supportsScreen())        
        {
            inoutConfig.screenLayout =
                    (inoutConfig.screenLayout&~Configuration.SCREENLAYOUT_SIZE_MASK)
                    | Configuration.SCREENLAYOUT_SIZE_NORMAL;
            inoutConfig.screenWidthDp = inoutConfig.compatScreenWidthDp;
            inoutConfig.screenHeightDp = inoutConfig.compatScreenHeightDp;
            inoutConfig.smallestScreenWidthDp = inoutConfig.compatSmallestScreenWidthDp;
        } //End block
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

    
    @DSModeled(DSC.BAN)
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.190 -0400", hash_original_method = "CD2E846E95D6DD1EBA23C219F15E8AAF", hash_generated_method = "B62009C29715A33582EBAC0E0B217735")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        try 
        {
            CompatibilityInfo oc = (CompatibilityInfo)o;
            if(mCompatibilityFlags != oc.mCompatibilityFlags)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1589347049 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_731996392 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_731996392;
            }
            if(applicationDensity != oc.applicationDensity)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1425062806 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_867334575 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_867334575;
            }
            if(applicationScale != oc.applicationScale)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1899715515 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_819790065 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_819790065;
            }
            if(applicationInvertedScale != oc.applicationInvertedScale)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1332546487 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1373918836 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1373918836;
            }
            boolean varB326B5062B2F0E69046810717534CB09_1413784722 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_277541270 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_277541270;
        } //End block
        catch (ClassCastException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_598563359 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1990324690 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1990324690;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.191 -0400", hash_original_method = "8391774F9F4D17C2A23793FA4442739E", hash_generated_method = "F80665E5E8324B1392942694F6CF4332")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("{");
        sb.append(applicationDensity);
        sb.append("dpi");
        if(isScalingRequired())        
        {
            sb.append(" ");
            sb.append(applicationScale);
            sb.append("x");
        } //End block
        if(!supportsScreen())        
        {
            sb.append(" resizing");
        } //End block
        if(neverSupportsScreen())        
        {
            sb.append(" never-compat");
        } //End block
        if(alwaysSupportsScreen())        
        {
            sb.append(" always-compat");
        } //End block
        sb.append("}");
String var2460B846747F8B22185AD8BE722266A5_1081074771 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1081074771.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1081074771;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.193 -0400", hash_original_method = "8473CF5A5DF2B74B5499D26C5398575D", hash_generated_method = "5098F28B7D5C788A500A66F05A9CCADE")
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + mCompatibilityFlags;
        result = 31 * result + applicationDensity;
        result = 31 * result + Float.floatToIntBits(applicationScale);
        result = 31 * result + Float.floatToIntBits(applicationInvertedScale);
        int varB4A88417B3D0170D754C647C30B7216A_1339467725 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442638367 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442638367;
        // ---------- Original Method ----------
        //int result = 17;
        //result = 31 * result + mCompatibilityFlags;
        //result = 31 * result + applicationDensity;
        //result = 31 * result + Float.floatToIntBits(applicationScale);
        //result = 31 * result + Float.floatToIntBits(applicationInvertedScale);
        //return result;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.193 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "518FA71FA28B2800F2FF828D00586565")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_860711764 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192957646 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192957646;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.194 -0400", hash_original_method = "FEB528FDE7329032F7938F1739557EEE", hash_generated_method = "F0CAF85ABEB3CAC948DCD2C7B515967A")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.194 -0400", hash_original_field = "1B0B3DCFB15C2ED0E188C58DDA8DD7CD", hash_generated_field = "14E3397589B948719667F1E3AF571289")

        public float applicationScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.195 -0400", hash_original_field = "0C690E3EEBE7CF4097CF724C322C61E7", hash_generated_field = "FB16C6B90478FF3C6286ADC11FCB2FCF")

        public float applicationInvertedScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.195 -0400", hash_original_field = "EDE06AC5C744684AABDC17E4C58048FB", hash_generated_field = "C20DA98F4A08CF10BAA7142D933BD66B")

        private Rect mContentInsetsBuffer = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.195 -0400", hash_original_field = "BC4262CACB99DE79E24A559425160C3D", hash_generated_field = "1C9F92E30D2ADEA2CAAF0B834CACAAC8")

        private Rect mVisibleInsetsBuffer = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.195 -0400", hash_original_field = "5DA8752760AFEE3A011AA2DEFA9D2F09", hash_generated_field = "971A29021FD305F495522776D9E154AB")

        private Region mTouchableAreaBuffer = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.196 -0400", hash_original_method = "8F3615DA11565DF9F003F5DF13D87652", hash_generated_method = "0C0DC721E724DDCFF11BBA0EA3D0F318")
          Translator(float applicationScale, float applicationInvertedScale) {
            this.applicationScale = applicationScale;
            this.applicationInvertedScale = applicationInvertedScale;
            // ---------- Original Method ----------
            //this.applicationScale = applicationScale;
            //this.applicationInvertedScale = applicationInvertedScale;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.196 -0400", hash_original_method = "AAEFB3B2AA6A68EC0C613C02DA13C765", hash_generated_method = "B80EA47BCFE059FE1DCE31F0C84B8FFA")
          Translator() {
            this(CompatibilityInfo.this.applicationScale,
                    CompatibilityInfo.this.applicationInvertedScale);
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.197 -0400", hash_original_method = "36CC389463C4EECA1FFAD848C8F58415", hash_generated_method = "3E580084CFB719EE5C7C45B4652F3C8C")
        public void translateRectInScreenToAppWinFrame(Rect rect) {
            addTaint(rect.getTaint());
            rect.scale(applicationInvertedScale);
            // ---------- Original Method ----------
            //rect.scale(applicationInvertedScale);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.197 -0400", hash_original_method = "0A49DDBACE394A9C82B87775AA7B8808", hash_generated_method = "CFEA6109ED9472D4D0AA0D3CDFA7B81A")
        public void translateRegionInWindowToScreen(Region transparentRegion) {
            addTaint(transparentRegion.getTaint());
            transparentRegion.scale(applicationScale);
            // ---------- Original Method ----------
            //transparentRegion.scale(applicationScale);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.197 -0400", hash_original_method = "F6C04E9988D3236CD1A288419E980857", hash_generated_method = "7A0FBBE206BF8F768C2AFFB5324DECAE")
        public void translateCanvas(Canvas canvas) {
            addTaint(canvas.getTaint());
            if(applicationScale == 1.5f)            
            {
                final float tinyOffset = 2.0f / (3 * 255);
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

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.198 -0400", hash_original_method = "4D5FCD5F9907EB8D629A45C5A11C2836", hash_generated_method = "20139CE5E567763905A8500D1C0C1861")
        public void translateEventInScreenToAppWindow(MotionEvent event) {
            addTaint(event.getTaint());
            event.scale(applicationInvertedScale);
            // ---------- Original Method ----------
            //event.scale(applicationInvertedScale);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.198 -0400", hash_original_method = "DE018C3EFE6320C8CBFF22F7586A6AFE", hash_generated_method = "BCB66683F13C1FFC403E533D30C88297")
        public void translateWindowLayout(WindowManager.LayoutParams params) {
            addTaint(params.getTaint());
            params.scale(applicationScale);
            // ---------- Original Method ----------
            //params.scale(applicationScale);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.198 -0400", hash_original_method = "657A8C506709C2AB2507FE170E8B78C8", hash_generated_method = "F0592AB7B34F260DCA3908BB27ECE70F")
        public void translateRectInAppWindowToScreen(Rect rect) {
            addTaint(rect.getTaint());
            rect.scale(applicationScale);
            // ---------- Original Method ----------
            //rect.scale(applicationScale);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.199 -0400", hash_original_method = "5BBB001295BC7F6BF111AF6DC66C9205", hash_generated_method = "38ECC7EE97864264DB470EDD65BC8269")
        public void translateRectInScreenToAppWindow(Rect rect) {
            addTaint(rect.getTaint());
            rect.scale(applicationInvertedScale);
            // ---------- Original Method ----------
            //rect.scale(applicationInvertedScale);
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.199 -0400", hash_original_method = "9DE177160064B2A1F8C9D8228C599CDD", hash_generated_method = "E9ECA9325CF050EB116910023DF44307")
        public void translatePointInScreenToAppWindow(PointF point) {
            addTaint(point.getTaint());
            final float scale = applicationInvertedScale;
            if(scale != 1.0f)            
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

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.200 -0400", hash_original_method = "122ACDBA22A4D3B6B9E93FB00E1FAEC7", hash_generated_method = "3379719A54E32855EF96840676F5252E")
        public void translateLayoutParamsInAppWindowToScreen(LayoutParams params) {
            addTaint(params.getTaint());
            params.scale(applicationScale);
            // ---------- Original Method ----------
            //params.scale(applicationScale);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.200 -0400", hash_original_method = "43D8C9F45845A6C6CC10427CCFCFAF3D", hash_generated_method = "7A4302CB13395DABD91C04F35010EADE")
        public Rect getTranslatedContentInsets(Rect contentInsets) {
            addTaint(contentInsets.getTaint());
            if(mContentInsetsBuffer == null)            
            mContentInsetsBuffer = new Rect();
            mContentInsetsBuffer.set(contentInsets);
            translateRectInAppWindowToScreen(mContentInsetsBuffer);
Rect var50789666040DE8BECD26ECF524635EAB_1098898742 =             mContentInsetsBuffer;
            var50789666040DE8BECD26ECF524635EAB_1098898742.addTaint(taint);
            return var50789666040DE8BECD26ECF524635EAB_1098898742;
            // ---------- Original Method ----------
            //if (mContentInsetsBuffer == null) mContentInsetsBuffer = new Rect();
            //mContentInsetsBuffer.set(contentInsets);
            //translateRectInAppWindowToScreen(mContentInsetsBuffer);
            //return mContentInsetsBuffer;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.201 -0400", hash_original_method = "DB46A5AF3015676AE668EB7338A074FC", hash_generated_method = "F7F894F94636CE680621718EB0C7C392")
        public Rect getTranslatedVisibleInsets(Rect visibleInsets) {
            addTaint(visibleInsets.getTaint());
            if(mVisibleInsetsBuffer == null)            
            mVisibleInsetsBuffer = new Rect();
            mVisibleInsetsBuffer.set(visibleInsets);
            translateRectInAppWindowToScreen(mVisibleInsetsBuffer);
Rect var3CCF2CBB078D5E5EE27DEDCF2052BAE5_1995638641 =             mVisibleInsetsBuffer;
            var3CCF2CBB078D5E5EE27DEDCF2052BAE5_1995638641.addTaint(taint);
            return var3CCF2CBB078D5E5EE27DEDCF2052BAE5_1995638641;
            // ---------- Original Method ----------
            //if (mVisibleInsetsBuffer == null) mVisibleInsetsBuffer = new Rect();
            //mVisibleInsetsBuffer.set(visibleInsets);
            //translateRectInAppWindowToScreen(mVisibleInsetsBuffer);
            //return mVisibleInsetsBuffer;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.201 -0400", hash_original_method = "25CFF327B78CA768A3AFCA299ED2CC8E", hash_generated_method = "363CD96FA7DED67B8BCC06632F190373")
        public Region getTranslatedTouchableArea(Region touchableArea) {
            addTaint(touchableArea.getTaint());
            if(mTouchableAreaBuffer == null)            
            mTouchableAreaBuffer = new Region();
            mTouchableAreaBuffer.set(touchableArea);
            mTouchableAreaBuffer.scale(applicationScale);
Region var897F85AD4AAD10E23518A1C6E002613F_1642350196 =             mTouchableAreaBuffer;
            var897F85AD4AAD10E23518A1C6E002613F_1642350196.addTaint(taint);
            return var897F85AD4AAD10E23518A1C6E002613F_1642350196;
            // ---------- Original Method ----------
            //if (mTouchableAreaBuffer == null) mTouchableAreaBuffer = new Region();
            //mTouchableAreaBuffer.set(touchableArea);
            //mTouchableAreaBuffer.scale(applicationScale);
            //return mTouchableAreaBuffer;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.201 -0400", hash_original_field = "4D62768B5BBBA187A77A708A4E42824A", hash_generated_field = "08F5AA372944765B46BC517FBE4DAD3A")

    public static final CompatibilityInfo DEFAULT_COMPATIBILITY_INFO = new CompatibilityInfo() {
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.201 -0400", hash_original_field = "451C361316AB4D2AB8C1A0D4C769C245", hash_generated_field = "55912B57605F0907923E81814B30C0CE")

    public static final int DEFAULT_NORMAL_SHORT_DIMENSION = 320;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.202 -0400", hash_original_field = "E26C22452B88ED3FAEB17AF976663C39", hash_generated_field = "8D1764CCB355F9E44B73ECAF9C0E1A67")

    public static final float MAXIMUM_ASPECT_RATIO = (854f/480f);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.202 -0400", hash_original_field = "C28A801344B818D09042B9E76A19DD97", hash_generated_field = "FE8F3097DE77D4A5968EA9E99511671D")

    private static final int SCALING_REQUIRED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.202 -0400", hash_original_field = "E39F8903903FD6713DF47E8D72A99A0F", hash_generated_field = "783C1B480AFA79751F1953AF0C3E699E")

    private static final int ALWAYS_NEEDS_COMPAT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.202 -0400", hash_original_field = "A1252321239230719F04378EA51B60DD", hash_generated_field = "E0E953FF12F7A9AC5E30F9487F011934")

    private static final int NEVER_NEEDS_COMPAT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.202 -0400", hash_original_field = "12E72E73A3200A46C182FE5A62237016", hash_generated_field = "BAA6E0AAF402CD0959A7E08540FA5CC3")

    private static final int NEEDS_SCREEN_COMPAT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.202 -0400", hash_original_field = "22851AF58516589EBC6294DD83CB7F2D", hash_generated_field = "DDAA02554421F72326F350E7F40CEA00")

    public static final Parcelable.Creator<CompatibilityInfo> CREATOR
            = new Parcelable.Creator<CompatibilityInfo>() {
        @DSModeled(DSC.BAN)
        public CompatibilityInfo createFromParcel(Parcel source) {
            return new CompatibilityInfo(source);
        }

        @DSModeled(DSC.BAN)
        public CompatibilityInfo[] newArray(int size) {
            return new CompatibilityInfo[size];
        }
    };
    // orphaned legacy method
    public CompatibilityInfo createFromParcel(Parcel source) {
            return new CompatibilityInfo(source);
        }
    
    // orphaned legacy method
    public CompatibilityInfo[] newArray(int size) {
            return new CompatibilityInfo[size];
        }
    
}

