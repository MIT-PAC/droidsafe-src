package android.content.res;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.589 -0400", hash_original_field = "44CEE0DD1BE1998482D8262782403C60", hash_generated_field = "B4CB39B5E76E4F134AE9FD81F38E628C")

    private int mCompatibilityFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.589 -0400", hash_original_field = "CCF0FB9B0F263F71EE6018A478D4C5B2", hash_generated_field = "D4940D12226C2B60194AF35187704159")

    public int applicationDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.589 -0400", hash_original_field = "1B0B3DCFB15C2ED0E188C58DDA8DD7CD", hash_generated_field = "14E3397589B948719667F1E3AF571289")

    public float applicationScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.589 -0400", hash_original_field = "0C690E3EEBE7CF4097CF724C322C61E7", hash_generated_field = "FB16C6B90478FF3C6286ADC11FCB2FCF")

    public float applicationInvertedScale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.591 -0400", hash_original_method = "9C59C0A19ADE82EBF59B39AA82601FD9", hash_generated_method = "BF13824D7E101F7E39774FCD7D1136DA")
    public  CompatibilityInfo(ApplicationInfo appInfo, int screenLayout, int sw,
            boolean forceCompat) {
        int compatFlags = 0;
        {
            int required;
            required = appInfo.requiresSmallestWidthDp;
            required = appInfo.compatibleWidthLimitDp;
            {
                required = appInfo.largestWidthLimitDp;
            } 
            int compat;
            compat = appInfo.compatibleWidthLimitDp;
            compat = required;
            {
                compat = required;
            } 
            int largest = appInfo.largestWidthLimitDp;
            {
                compatFlags |= NEVER_NEEDS_COMPAT;
            } 
            {
                compatFlags |= NEEDS_SCREEN_COMPAT | ALWAYS_NEEDS_COMPAT;
            } 
            {
                compatFlags |= NEVER_NEEDS_COMPAT;
            } 
            {
                compatFlags |= NEEDS_SCREEN_COMPAT;
            } 
            applicationDensity = DisplayMetrics.DENSITY_DEVICE;
            applicationScale = 1.0f;
            applicationInvertedScale = 1.0f;
        } 
        {
            final int EXPANDABLE = 2;
            final int LARGE_SCREENS = 8;
            final int XLARGE_SCREENS = 32;
            int sizeInfo = 0;
            boolean anyResizeable = false;
            {
                sizeInfo |= LARGE_SCREENS;
                anyResizeable = true;
                {
                    sizeInfo |= XLARGE_SCREENS | EXPANDABLE;
                } 
            } 
            {
                anyResizeable = true;
                {
                    sizeInfo |= XLARGE_SCREENS | EXPANDABLE;
                } 
            } 
            {
                anyResizeable = true;
                sizeInfo |= EXPANDABLE;
            } 
            {
                sizeInfo &= ~EXPANDABLE;
            } 
            compatFlags |= NEEDS_SCREEN_COMPAT;
            
            {
                compatFlags &= ~NEEDS_SCREEN_COMPAT;
            } 
            
            
            {
                compatFlags |= NEVER_NEEDS_COMPAT;
            } 
            
            
            {
                compatFlags &= ~NEEDS_SCREEN_COMPAT;
            } 
            
            
            {
                compatFlags |= NEVER_NEEDS_COMPAT;
            } 
            
            {
                {
                    compatFlags &= ~NEEDS_SCREEN_COMPAT;
                } 
                {
                    compatFlags |= ALWAYS_NEEDS_COMPAT;
                } 
            } 
            {
                compatFlags &= ~NEEDS_SCREEN_COMPAT;
                compatFlags |= NEVER_NEEDS_COMPAT;
            } 
            {
                applicationDensity = DisplayMetrics.DENSITY_DEVICE;
                applicationScale = 1.0f;
                applicationInvertedScale = 1.0f;
            } 
            {
                applicationDensity = DisplayMetrics.DENSITY_DEFAULT;
                applicationScale = DisplayMetrics.DENSITY_DEVICE
                        / (float) DisplayMetrics.DENSITY_DEFAULT;
                applicationInvertedScale = 1.0f / applicationScale;
                compatFlags |= SCALING_REQUIRED;
            } 
        } 
        mCompatibilityFlags = compatFlags;
        addTaint(appInfo.getTaint());
        addTaint(screenLayout);
        addTaint(sw);
        addTaint(forceCompat);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.591 -0400", hash_original_method = "A82321676D9C84B0538DAFB6CC61C0CB", hash_generated_method = "D97765B16CE7043641005CA614BC91BD")
    private  CompatibilityInfo(int compFlags,
            int dens, float scale, float invertedScale) {
        mCompatibilityFlags = compFlags;
        applicationDensity = dens;
        applicationScale = scale;
        applicationInvertedScale = invertedScale;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.592 -0400", hash_original_method = "3DDB26515D25880873E2C6C7F1DDA6F5", hash_generated_method = "A144E464C092FC9674C214597E793D47")
    private  CompatibilityInfo() {
        this(NEVER_NEEDS_COMPAT, DisplayMetrics.DENSITY_DEVICE,
                1.0f,
                1.0f);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.593 -0400", hash_original_method = "B251F1B77EF355BF6FA118A826DF4F4A", hash_generated_method = "48F71F1044639FA67CF1237AD6C85A09")
    private  CompatibilityInfo(Parcel source) {
        mCompatibilityFlags = source.readInt();
        applicationDensity = source.readInt();
        applicationScale = source.readFloat();
        applicationInvertedScale = source.readFloat();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.594 -0400", hash_original_method = "E2D07E7BFECA2D29A0CD39AB3E4AD2F4", hash_generated_method = "70CA2B42EAEB8864F1C1314241E5A455")
    public boolean isScalingRequired() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1845227384 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1845227384;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.594 -0400", hash_original_method = "AEF0832D3207872CC75E4AC6D7849C73", hash_generated_method = "830DE4E793977E4F3AEC3AA1EC102F6E")
    public boolean supportsScreen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1543645364 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1543645364;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.595 -0400", hash_original_method = "BD11775B1F66D2736A032A6A37E2552F", hash_generated_method = "371B886A7A9FE2BA8BC2400A5440EED3")
    public boolean neverSupportsScreen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1869638235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1869638235;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.595 -0400", hash_original_method = "CFA6F9CFCD9588B682D5F07DFF385684", hash_generated_method = "1E7B3DDC4876956D2581A5F31E9635AD")
    public boolean alwaysSupportsScreen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1529164691 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1529164691;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.596 -0400", hash_original_method = "93ABC602B8C8A6238860B5CA46099876", hash_generated_method = "02A47A6060397B693AD61532D30B8BC3")
    public Translator getTranslator() {
        Translator varB4EAC82CA7396A68D541C85D26508E83_1674455502 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1674455502 = isScalingRequired() ? new Translator() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1674455502.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1674455502;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.597 -0400", hash_original_method = "F5DFBBE3DCF906040672C2B4A4880712", hash_generated_method = "0CDB511ACD99B96C0D604C78156E3D7C")
    public void applyToDisplayMetrics(DisplayMetrics inoutDm) {
        {
            boolean varE7167D48931C006010D8B5CB5972BC1F_2035723236 = (!supportsScreen());
            {
                CompatibilityInfo.computeCompatibleScaling(inoutDm, inoutDm);
            } 
            {
                inoutDm.widthPixels = inoutDm.noncompatWidthPixels;
                inoutDm.heightPixels = inoutDm.noncompatHeightPixels;
            } 
        } 
        {
            boolean var99116A7FA4A89F4892D46EF5C786E5AD_1499802570 = (isScalingRequired());
            {
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
        addTaint(inoutDm.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.598 -0400", hash_original_method = "D1D0A6DB2934A6F26FB8AACA9CE38F1E", hash_generated_method = "2845E939AF9A229103E7150E762DD5C7")
    public void applyToConfiguration(Configuration inoutConfig) {
        {
            boolean varE7167D48931C006010D8B5CB5972BC1F_528298746 = (!supportsScreen());
            {
                inoutConfig.screenLayout =
                    (inoutConfig.screenLayout&~Configuration.SCREENLAYOUT_SIZE_MASK)
                    | Configuration.SCREENLAYOUT_SIZE_NORMAL;
                inoutConfig.screenWidthDp = inoutConfig.compatScreenWidthDp;
                inoutConfig.screenHeightDp = inoutConfig.compatScreenHeightDp;
                inoutConfig.smallestScreenWidthDp = inoutConfig.compatSmallestScreenWidthDp;
            } 
        } 
        addTaint(inoutConfig.getTaint());
        
        
            
                    
                    
            
            
            
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.599 -0400", hash_original_method = "CD2E846E95D6DD1EBA23C219F15E8AAF", hash_generated_method = "47E46D7E07C29CBB7B289D49BEF0F58D")
    @Override
    public boolean equals(Object o) {
        try 
        {
            CompatibilityInfo oc = (CompatibilityInfo)o;
        } 
        catch (ClassCastException e)
        { }
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_356751627 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_356751627;
        
        
            
            
            
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.600 -0400", hash_original_method = "8391774F9F4D17C2A23793FA4442739E", hash_generated_method = "A3554F162D8CAABD2E522FCB996C64BE")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_236314581 = null; 
        StringBuilder sb = new StringBuilder(128);
        sb.append("{");
        sb.append(applicationDensity);
        sb.append("dpi");
        {
            boolean var99116A7FA4A89F4892D46EF5C786E5AD_1641799738 = (isScalingRequired());
            {
                sb.append(" ");
                sb.append(applicationScale);
                sb.append("x");
            } 
        } 
        {
            boolean varE7167D48931C006010D8B5CB5972BC1F_1311130032 = (!supportsScreen());
            {
                sb.append(" resizing");
            } 
        } 
        {
            boolean varCA1EFE893AA8EA68DFD50ADCAC7E67DF_2142377609 = (neverSupportsScreen());
            {
                sb.append(" never-compat");
            } 
        } 
        {
            boolean var8FD3A043FAF334062C55758AA955AB0F_2084795143 = (alwaysSupportsScreen());
            {
                sb.append(" always-compat");
            } 
        } 
        sb.append("}");
        varB4EAC82CA7396A68D541C85D26508E83_236314581 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_236314581.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_236314581;
        
        
        
        
        
        
            
            
            
        
        
            
        
        
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.600 -0400", hash_original_method = "8473CF5A5DF2B74B5499D26C5398575D", hash_generated_method = "A3A67A34577FD326EF7FF09C1369BD65")
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + mCompatibilityFlags;
        result = 31 * result + applicationDensity;
        result = 31 * result + Float.floatToIntBits(applicationScale);
        result = 31 * result + Float.floatToIntBits(applicationInvertedScale);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1782533594 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1782533594;
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.601 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "03CC114A182804145E898D4EAA4A1407")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1954851725 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1954851725;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.602 -0400", hash_original_method = "FEB528FDE7329032F7938F1739557EEE", hash_generated_method = "44F0311BA66B4F20FAADDBCFA4181B07")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mCompatibilityFlags);
        dest.writeInt(applicationDensity);
        dest.writeFloat(applicationScale);
        dest.writeFloat(applicationInvertedScale);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
    }

    
    public class Translator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.602 -0400", hash_original_field = "1B0B3DCFB15C2ED0E188C58DDA8DD7CD", hash_generated_field = "14E3397589B948719667F1E3AF571289")

        public float applicationScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.602 -0400", hash_original_field = "0C690E3EEBE7CF4097CF724C322C61E7", hash_generated_field = "FB16C6B90478FF3C6286ADC11FCB2FCF")

        public float applicationInvertedScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.602 -0400", hash_original_field = "EDE06AC5C744684AABDC17E4C58048FB", hash_generated_field = "C20DA98F4A08CF10BAA7142D933BD66B")

        private Rect mContentInsetsBuffer = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.602 -0400", hash_original_field = "BC4262CACB99DE79E24A559425160C3D", hash_generated_field = "1C9F92E30D2ADEA2CAAF0B834CACAAC8")

        private Rect mVisibleInsetsBuffer = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.602 -0400", hash_original_field = "5DA8752760AFEE3A011AA2DEFA9D2F09", hash_generated_field = "971A29021FD305F495522776D9E154AB")

        private Region mTouchableAreaBuffer = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.603 -0400", hash_original_method = "8F3615DA11565DF9F003F5DF13D87652", hash_generated_method = "0C0DC721E724DDCFF11BBA0EA3D0F318")
          Translator(float applicationScale, float applicationInvertedScale) {
            this.applicationScale = applicationScale;
            this.applicationInvertedScale = applicationInvertedScale;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.604 -0400", hash_original_method = "AAEFB3B2AA6A68EC0C613C02DA13C765", hash_generated_method = "B80EA47BCFE059FE1DCE31F0C84B8FFA")
          Translator() {
            this(CompatibilityInfo.this.applicationScale,
                    CompatibilityInfo.this.applicationInvertedScale);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.605 -0400", hash_original_method = "36CC389463C4EECA1FFAD848C8F58415", hash_generated_method = "6A95F75DF2FA2A3157C2E7AFCD6A3196")
        public void translateRectInScreenToAppWinFrame(Rect rect) {
            rect.scale(applicationInvertedScale);
            addTaint(rect.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.606 -0400", hash_original_method = "0A49DDBACE394A9C82B87775AA7B8808", hash_generated_method = "6A7314117C8269CDEA9C55F128F0FA9A")
        public void translateRegionInWindowToScreen(Region transparentRegion) {
            transparentRegion.scale(applicationScale);
            addTaint(transparentRegion.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.607 -0400", hash_original_method = "F6C04E9988D3236CD1A288419E980857", hash_generated_method = "3101E2ED252AFB581831A237877648E7")
        public void translateCanvas(Canvas canvas) {
            {
                final float tinyOffset = 2.0f / (3 * 255);
                canvas.translate(tinyOffset, tinyOffset);
            } 
            canvas.scale(applicationScale, applicationScale);
            addTaint(canvas.getTaint());
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.608 -0400", hash_original_method = "4D5FCD5F9907EB8D629A45C5A11C2836", hash_generated_method = "6CC0903C2B98DAE3F8446802376C4BA3")
        public void translateEventInScreenToAppWindow(MotionEvent event) {
            event.scale(applicationInvertedScale);
            addTaint(event.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.608 -0400", hash_original_method = "DE018C3EFE6320C8CBFF22F7586A6AFE", hash_generated_method = "356F781F7177FCAAA0744976DB7DE008")
        public void translateWindowLayout(WindowManager.LayoutParams params) {
            params.scale(applicationScale);
            addTaint(params.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.609 -0400", hash_original_method = "657A8C506709C2AB2507FE170E8B78C8", hash_generated_method = "36FA054FF09E8D512AD131218F319098")
        public void translateRectInAppWindowToScreen(Rect rect) {
            rect.scale(applicationScale);
            addTaint(rect.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.609 -0400", hash_original_method = "5BBB001295BC7F6BF111AF6DC66C9205", hash_generated_method = "91B5CF534CFE3D622E1E0379580CB483")
        public void translateRectInScreenToAppWindow(Rect rect) {
            rect.scale(applicationInvertedScale);
            addTaint(rect.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.610 -0400", hash_original_method = "9DE177160064B2A1F8C9D8228C599CDD", hash_generated_method = "86A292F07A183A4B8325053620DD8134")
        public void translatePointInScreenToAppWindow(PointF point) {
            final float scale = applicationInvertedScale;
            {
                point.x *= scale;
                point.y *= scale;
            } 
            addTaint(point.getTaint());
            
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.610 -0400", hash_original_method = "122ACDBA22A4D3B6B9E93FB00E1FAEC7", hash_generated_method = "D9FA42D278E92F5C1AD5CE1913C17798")
        public void translateLayoutParamsInAppWindowToScreen(LayoutParams params) {
            params.scale(applicationScale);
            addTaint(params.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.611 -0400", hash_original_method = "43D8C9F45845A6C6CC10427CCFCFAF3D", hash_generated_method = "9FDD1CAEED339ACD61088CF451E4786B")
        public Rect getTranslatedContentInsets(Rect contentInsets) {
            Rect varB4EAC82CA7396A68D541C85D26508E83_648497983 = null; 
            mContentInsetsBuffer = new Rect();
            mContentInsetsBuffer.set(contentInsets);
            translateRectInAppWindowToScreen(mContentInsetsBuffer);
            varB4EAC82CA7396A68D541C85D26508E83_648497983 = mContentInsetsBuffer;
            addTaint(contentInsets.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_648497983.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_648497983;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.612 -0400", hash_original_method = "DB46A5AF3015676AE668EB7338A074FC", hash_generated_method = "AD6F77A606835D6469E64A3B875A562B")
        public Rect getTranslatedVisibleInsets(Rect visibleInsets) {
            Rect varB4EAC82CA7396A68D541C85D26508E83_1994812217 = null; 
            mVisibleInsetsBuffer = new Rect();
            mVisibleInsetsBuffer.set(visibleInsets);
            translateRectInAppWindowToScreen(mVisibleInsetsBuffer);
            varB4EAC82CA7396A68D541C85D26508E83_1994812217 = mVisibleInsetsBuffer;
            addTaint(visibleInsets.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1994812217.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1994812217;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.614 -0400", hash_original_method = "25CFF327B78CA768A3AFCA299ED2CC8E", hash_generated_method = "EC5D2DFDF7138B2365E661DDDB4CFB85")
        public Region getTranslatedTouchableArea(Region touchableArea) {
            Region varB4EAC82CA7396A68D541C85D26508E83_1455694077 = null; 
            mTouchableAreaBuffer = new Region();
            mTouchableAreaBuffer.set(touchableArea);
            mTouchableAreaBuffer.scale(applicationScale);
            varB4EAC82CA7396A68D541C85D26508E83_1455694077 = mTouchableAreaBuffer;
            addTaint(touchableArea.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1455694077.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1455694077;
            
            
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.614 -0400", hash_original_field = "4D62768B5BBBA187A77A708A4E42824A", hash_generated_field = "08F5AA372944765B46BC517FBE4DAD3A")

    public static final CompatibilityInfo DEFAULT_COMPATIBILITY_INFO = new CompatibilityInfo() {
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.614 -0400", hash_original_field = "451C361316AB4D2AB8C1A0D4C769C245", hash_generated_field = "55912B57605F0907923E81814B30C0CE")

    public static final int DEFAULT_NORMAL_SHORT_DIMENSION = 320;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.614 -0400", hash_original_field = "E26C22452B88ED3FAEB17AF976663C39", hash_generated_field = "8D1764CCB355F9E44B73ECAF9C0E1A67")

    public static final float MAXIMUM_ASPECT_RATIO = (854f/480f);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.614 -0400", hash_original_field = "C28A801344B818D09042B9E76A19DD97", hash_generated_field = "FE8F3097DE77D4A5968EA9E99511671D")

    private static final int SCALING_REQUIRED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.614 -0400", hash_original_field = "E39F8903903FD6713DF47E8D72A99A0F", hash_generated_field = "783C1B480AFA79751F1953AF0C3E699E")

    private static final int ALWAYS_NEEDS_COMPAT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.615 -0400", hash_original_field = "A1252321239230719F04378EA51B60DD", hash_generated_field = "E0E953FF12F7A9AC5E30F9487F011934")

    private static final int NEVER_NEEDS_COMPAT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.615 -0400", hash_original_field = "12E72E73A3200A46C182FE5A62237016", hash_generated_field = "BAA6E0AAF402CD0959A7E08540FA5CC3")

    private static final int NEEDS_SCREEN_COMPAT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.615 -0400", hash_original_field = "22851AF58516589EBC6294DD83CB7F2D", hash_generated_field = "DDAA02554421F72326F350E7F40CEA00")

    public static final Parcelable.Creator<CompatibilityInfo> CREATOR
            = new Parcelable.Creator<CompatibilityInfo>() {
        public CompatibilityInfo createFromParcel(Parcel source) {
            return new CompatibilityInfo(source);
        }

        public CompatibilityInfo[] newArray(int size) {
            return new CompatibilityInfo[size];
        }
    };
    
    public CompatibilityInfo createFromParcel(Parcel source) {
            return new CompatibilityInfo(source);
        }
    
    
    public CompatibilityInfo[] newArray(int size) {
            return new CompatibilityInfo[size];
        }
    
}

