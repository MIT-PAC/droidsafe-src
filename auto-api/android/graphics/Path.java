package android.graphics;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.view.HardwareRenderer;

public class Path {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.956 -0400", hash_original_field = "29624343DB5BC876FA1D9DF3677A6ED3", hash_generated_field = "A385DF57FCDF6BC40C36AC929278C06B")

    public int mNativePath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.956 -0400", hash_original_field = "BBB9244AC68A5AE8F6E83F820B224A84", hash_generated_field = "250A69E67387663075BAE4FF6CF576D2")

    public boolean isSimplePath = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.956 -0400", hash_original_field = "9E366C78B27FBDD9C0248431A83481D2", hash_generated_field = "407FA9D3A82E310B399E446D54E9EE3E")

    public Region rects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.956 -0400", hash_original_field = "3DEE1FD91D4FA98ABE970571DAF12576", hash_generated_field = "06EEE85B84C90F2AA9425935FBA31565")

    private boolean mDetectSimplePaths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.956 -0400", hash_original_field = "539749EABE9BA627327F84BD9DB0990A", hash_generated_field = "DC756050863566DEECE2CF58DA95FC7C")

    private Direction mLastDirection = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.957 -0400", hash_original_method = "E55892E9E32EE58ABA689C884DCC620A", hash_generated_method = "2516288491884B0595FC4CFC8A04A2E0")
    public  Path() {
        mNativePath = init1();
        mDetectSimplePaths = HardwareRenderer.isAvailable();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.957 -0400", hash_original_method = "75D205ED700EB535C654F75061722DB2", hash_generated_method = "3563BA57F46C64CF93DAB573885CCBB1")
    public  Path(Path src) {
        int valNative = 0;
        {
            valNative = src.mNativePath;
        } 
        mNativePath = init2(valNative);
        mDetectSimplePaths = HardwareRenderer.isAvailable();
        addTaint(src.getTaint());
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.958 -0400", hash_original_method = "2D6F810980DCFBBC547D7B9A11965950", hash_generated_method = "0D44BA305E11BD4751D9F5AD2F2C8B26")
    public void reset() {
        isSimplePath = true;
        {
            mLastDirection = null;
            rects.setEmpty();
        } 
        native_reset(mNativePath);
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.958 -0400", hash_original_method = "3CA9EEECBF523F762771968CCD0E129D", hash_generated_method = "566028D65C7E94ED7A9BA3A11E5BB664")
    public void rewind() {
        isSimplePath = true;
        {
            mLastDirection = null;
            rects.setEmpty();
        } 
        native_rewind(mNativePath);
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.959 -0400", hash_original_method = "B685542335E97A84BA9D0A3AD0CEB866", hash_generated_method = "53DF6508310DAC819B41B2AA70624EDA")
    public void set(Path src) {
        {
            isSimplePath = src.isSimplePath;
            native_set(mNativePath, src.mNativePath);
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.961 -0400", hash_original_method = "756CBBEFC8F729432A1EDFB10FC9B142", hash_generated_method = "A0F44DAFEF7A75F5DC60551146FE9366")
    public FillType getFillType() {
        FillType varB4EAC82CA7396A68D541C85D26508E83_705983293 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_705983293 = sFillTypeArray[native_getFillType(mNativePath)];
        varB4EAC82CA7396A68D541C85D26508E83_705983293.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_705983293;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.961 -0400", hash_original_method = "5E380303FA17349F493701662250C5C9", hash_generated_method = "E22750EED58F8812C09157707C8755F7")
    public void setFillType(FillType ft) {
        native_setFillType(mNativePath, ft.nativeInt);
        addTaint(ft.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.962 -0400", hash_original_method = "659A2CB8B4863836C5C292B196F32903", hash_generated_method = "4894B4C29EE834EB99BC9F93C06A1655")
    public boolean isInverseFillType() {
        final int ft = native_getFillType(mNativePath);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1619698253 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1619698253;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.963 -0400", hash_original_method = "B0C8497AF8D8E800E41ED12D1C4B68D2", hash_generated_method = "59720BE86F09EC269AE8F1A659A8BB00")
    public void toggleInverseFillType() {
        int ft = native_getFillType(mNativePath);
        ft ^= 2;
        native_setFillType(mNativePath, ft);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.963 -0400", hash_original_method = "7418BC5D1CF727D38A2258A36F4B5C15", hash_generated_method = "8A98D2505B7E66EEB69A7FD4A5D3D826")
    public boolean isEmpty() {
        boolean var522B462A5C17E5E49A401CABA795A0BC_1187686368 = (native_isEmpty(mNativePath));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_519463769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_519463769;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.964 -0400", hash_original_method = "B84E7088610242E6493E719E7ABEF1E6", hash_generated_method = "BA5FD6AC375F2FCDBAEA9C860FAFB12D")
    public boolean isRect(RectF rect) {
        boolean varAA53C40F0A5EA7379B3BEE35A1C7F0DA_1683086614 = (native_isRect(mNativePath, rect));
        addTaint(rect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_228262932 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_228262932;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.965 -0400", hash_original_method = "72B50A956CBF7B7731470BDB2A5220D2", hash_generated_method = "3ECFF8D0A69CDC7564563B418861CCF5")
    @SuppressWarnings({"UnusedDeclaration"})
    public void computeBounds(RectF bounds, boolean exact) {
        native_computeBounds(mNativePath, bounds);
        addTaint(bounds.getTaint());
        addTaint(exact);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.965 -0400", hash_original_method = "29BD172EB2F3A7AF9AFA9275279C4F54", hash_generated_method = "2135FAB4B8848E291A9864D67A562D40")
    public void incReserve(int extraPtCount) {
        native_incReserve(mNativePath, extraPtCount);
        addTaint(extraPtCount);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.966 -0400", hash_original_method = "732AD0D6CB11A9ADE203372D23E48872", hash_generated_method = "0864D1D9D5BD5DCCBF58627BA9C2C2BB")
    public void moveTo(float x, float y) {
        native_moveTo(mNativePath, x, y);
        addTaint(x);
        addTaint(y);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.967 -0400", hash_original_method = "0933141A2BB19D63525BF81BE900CD97", hash_generated_method = "7B022FEA22F39A51D387608A94759943")
    public void rMoveTo(float dx, float dy) {
        native_rMoveTo(mNativePath, dx, dy);
        addTaint(dx);
        addTaint(dy);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.967 -0400", hash_original_method = "58E5C3E4C7F046934AC91F8FDFBACD2C", hash_generated_method = "34FCD860560E9FB0B7726B37B5F21D7F")
    public void lineTo(float x, float y) {
        isSimplePath = false;
        native_lineTo(mNativePath, x, y);
        addTaint(x);
        addTaint(y);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.968 -0400", hash_original_method = "745591040780C0D8C5D54F59927D5E79", hash_generated_method = "8F0B13764DF75B3DA2EABFE89336178E")
    public void rLineTo(float dx, float dy) {
        isSimplePath = false;
        native_rLineTo(mNativePath, dx, dy);
        addTaint(dx);
        addTaint(dy);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.968 -0400", hash_original_method = "CDE92CD41872F87599E772CCBEB9168F", hash_generated_method = "6B08AFEE501FD583B7F4B7A95E6F2880")
    public void quadTo(float x1, float y1, float x2, float y2) {
        isSimplePath = false;
        native_quadTo(mNativePath, x1, y1, x2, y2);
        addTaint(x1);
        addTaint(y1);
        addTaint(x2);
        addTaint(y2);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.969 -0400", hash_original_method = "F0FFAC3AAFD6A3822EB31C31A758C054", hash_generated_method = "C493033452CA9D40EE81B642119B00EF")
    public void rQuadTo(float dx1, float dy1, float dx2, float dy2) {
        isSimplePath = false;
        native_rQuadTo(mNativePath, dx1, dy1, dx2, dy2);
        addTaint(dx1);
        addTaint(dy1);
        addTaint(dx2);
        addTaint(dy2);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.970 -0400", hash_original_method = "680DEAF903653AA5E9334EFF44E1FB26", hash_generated_method = "5D1ED9C0AF2A7AB704389E8B7802F69A")
    public void cubicTo(float x1, float y1, float x2, float y2,
                        float x3, float y3) {
        isSimplePath = false;
        native_cubicTo(mNativePath, x1, y1, x2, y2, x3, y3);
        addTaint(x1);
        addTaint(y1);
        addTaint(x2);
        addTaint(y2);
        addTaint(x3);
        addTaint(y3);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.971 -0400", hash_original_method = "7CE3D84B1219A8E32E8697E9D54626ED", hash_generated_method = "B5C08E8D051F87EDB1A1C0398B3B8010")
    public void rCubicTo(float x1, float y1, float x2, float y2,
                         float x3, float y3) {
        isSimplePath = false;
        native_rCubicTo(mNativePath, x1, y1, x2, y2, x3, y3);
        addTaint(x1);
        addTaint(y1);
        addTaint(x2);
        addTaint(y2);
        addTaint(x3);
        addTaint(y3);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.973 -0400", hash_original_method = "FF1AA715D5A76F97289F9771795F5B75", hash_generated_method = "25D73E9751759DCB5AB02B02E2505563")
    public void arcTo(RectF oval, float startAngle, float sweepAngle,
                      boolean forceMoveTo) {
        isSimplePath = false;
        native_arcTo(mNativePath, oval, startAngle, sweepAngle, forceMoveTo);
        addTaint(oval.getTaint());
        addTaint(startAngle);
        addTaint(sweepAngle);
        addTaint(forceMoveTo);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.974 -0400", hash_original_method = "48B980B599EE39F47888B8590B0311CC", hash_generated_method = "95C7F009AF33197732B33FAF6D631AE8")
    public void arcTo(RectF oval, float startAngle, float sweepAngle) {
        isSimplePath = false;
        native_arcTo(mNativePath, oval, startAngle, sweepAngle, false);
        addTaint(oval.getTaint());
        addTaint(startAngle);
        addTaint(sweepAngle);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.975 -0400", hash_original_method = "E16C5D29E703AEBAB6CAF17A68A08F6B", hash_generated_method = "34D9621BE529F6E4B1748728F71F3FA6")
    public void close() {
        isSimplePath = false;
        native_close(mNativePath);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.975 -0400", hash_original_method = "4C4C77916FAC7E47D84337BC4A27AFDA", hash_generated_method = "DF388069D1F12E0A457371259D9D5E4D")
    private void detectSimplePath(float left, float top, float right, float bottom, Direction dir) {
        {
            {
                mLastDirection = dir;
            } 
            {
                isSimplePath = false;
            } 
            {
                rects = new Region();
                rects.op((int) left, (int) top, (int) right, (int) bottom, Region.Op.UNION);
            } 
        } 
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
            
                
            
            
                
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.976 -0400", hash_original_method = "4612527F52EC9CC57646B58789A81A83", hash_generated_method = "1AC4F0718F6869BDA350582BCCCCCBBD")
    public void addRect(RectF rect, Direction dir) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("need rect parameter");
        } 
        detectSimplePath(rect.left, rect.top, rect.right, rect.bottom, dir);
        native_addRect(mNativePath, rect, dir.nativeInt);
        addTaint(rect.getTaint());
        addTaint(dir.getTaint());
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.977 -0400", hash_original_method = "B728DA55BB20CAF41F04A8721ACC9EB9", hash_generated_method = "2D2B755AE4769979BD60C995F5CE949A")
    public void addRect(float left, float top, float right, float bottom, Direction dir) {
        detectSimplePath(left, top, right, bottom, dir);
        native_addRect(mNativePath, left, top, right, bottom, dir.nativeInt);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        addTaint(dir.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.977 -0400", hash_original_method = "A39723146C675E0E04F715D6E89297CC", hash_generated_method = "506392569CBD052F92734BE913ACA6BC")
    public void addOval(RectF oval, Direction dir) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("need oval parameter");
        } 
        isSimplePath = false;
        native_addOval(mNativePath, oval, dir.nativeInt);
        addTaint(oval.getTaint());
        addTaint(dir.getTaint());
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.978 -0400", hash_original_method = "7256751168A905EF802B1EFF88D64306", hash_generated_method = "93FA7BB7CCE9E64DABF028372FF5F65F")
    public void addCircle(float x, float y, float radius, Direction dir) {
        isSimplePath = false;
        native_addCircle(mNativePath, x, y, radius, dir.nativeInt);
        addTaint(x);
        addTaint(y);
        addTaint(radius);
        addTaint(dir.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.979 -0400", hash_original_method = "BDC1F894C327354FF6BC9BE2A0106898", hash_generated_method = "885476D3108B155EE9015434EEE5B4AB")
    public void addArc(RectF oval, float startAngle, float sweepAngle) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("need oval parameter");
        } 
        isSimplePath = false;
        native_addArc(mNativePath, oval, startAngle, sweepAngle);
        addTaint(oval.getTaint());
        addTaint(startAngle);
        addTaint(sweepAngle);
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.979 -0400", hash_original_method = "3ECD815B6409768DB15813B06CD42DD5", hash_generated_method = "9A88BBF4C0DE90D39EBEE02D3A2359E9")
    public void addRoundRect(RectF rect, float rx, float ry, Direction dir) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("need rect parameter");
        } 
        isSimplePath = false;
        native_addRoundRect(mNativePath, rect, rx, ry, dir.nativeInt);
        addTaint(rect.getTaint());
        addTaint(rx);
        addTaint(ry);
        addTaint(dir.getTaint());
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.980 -0400", hash_original_method = "543113738AC73676270E7FCF210EDB1F", hash_generated_method = "817D4FE469CA51BBF73DE28F9F3888F6")
    public void addRoundRect(RectF rect, float[] radii, Direction dir) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("need rect parameter");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
        } 
        isSimplePath = false;
        native_addRoundRect(mNativePath, rect, radii, dir.nativeInt);
        addTaint(rect.getTaint());
        addTaint(radii[0]);
        addTaint(dir.getTaint());
        
        
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.982 -0400", hash_original_method = "E4CA114D3203375891711738ECF0A722", hash_generated_method = "6FD53F00EBF0350D891B476ED3098C4E")
    public void addPath(Path src, float dx, float dy) {
        isSimplePath = false;
        native_addPath(mNativePath, src.mNativePath, dx, dy);
        addTaint(src.getTaint());
        addTaint(dx);
        addTaint(dy);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.983 -0400", hash_original_method = "543B497D09485FEEC00989CA21E8A572", hash_generated_method = "BF38A0F2E59FA76A4D493AD32709C0DC")
    public void addPath(Path src) {
        isSimplePath = false;
        native_addPath(mNativePath, src.mNativePath);
        addTaint(src.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.984 -0400", hash_original_method = "D7DB7FC66FA71E8C80EBAD3AE821E2C4", hash_generated_method = "587857142D418BE3B3D9530937061F17")
    public void addPath(Path src, Matrix matrix) {
        isSimplePath = false;
        native_addPath(mNativePath, src.mNativePath, matrix.native_instance);
        addTaint(src.getTaint());
        addTaint(matrix.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.984 -0400", hash_original_method = "300271373C98AD70F0D1DFEC9CC1821E", hash_generated_method = "E7F9E096F82462809862AC916DCC4027")
    public void offset(float dx, float dy, Path dst) {
        int dstNative = 0;
        {
            dstNative = dst.mNativePath;
        } 
        native_offset(mNativePath, dx, dy, dstNative);
        addTaint(dx);
        addTaint(dy);
        addTaint(dst.getTaint());
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.985 -0400", hash_original_method = "84AAB7006BE97BBDBF66CEB78BE6403B", hash_generated_method = "C11EE2F349061614502CA3E634C54202")
    public void offset(float dx, float dy) {
        native_offset(mNativePath, dx, dy);
        addTaint(dx);
        addTaint(dy);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.986 -0400", hash_original_method = "DE0F6A19984A9351DC908B14944CEA04", hash_generated_method = "1497F02327938BB4588A5E3E5A0048CD")
    public void setLastPoint(float dx, float dy) {
        isSimplePath = false;
        native_setLastPoint(mNativePath, dx, dy);
        addTaint(dx);
        addTaint(dy);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.987 -0400", hash_original_method = "C6EADCEB56E45A061E81B3D824529855", hash_generated_method = "FD075B4B0436A977C9A7289B248EB1B3")
    public void transform(Matrix matrix, Path dst) {
        int dstNative = 0;
        {
            dstNative = dst.mNativePath;
        } 
        native_transform(mNativePath, matrix.native_instance, dstNative);
        addTaint(matrix.getTaint());
        addTaint(dst.getTaint());
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.987 -0400", hash_original_method = "E2E9E79308A321DB0305128A17F8E66B", hash_generated_method = "5966CACD4204A7C25AEE390FD5BFB416")
    public void transform(Matrix matrix) {
        native_transform(mNativePath, matrix.native_instance);
        addTaint(matrix.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.988 -0400", hash_original_method = "F7200B02D28E5C321C9E159FC014E915", hash_generated_method = "B63DF27303A34F6912C29DAE9DF797C8")
    protected void finalize() throws Throwable {
        try 
        {
            finalizer(mNativePath);
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.988 -0400", hash_original_method = "A7A62D46D1AC389C59E8D1EF0EC6AB35", hash_generated_method = "D4A1C7AEFE1CB615ED81D0CF3EC8B683")
    final int ni() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1311112728 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1311112728;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int init1() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int init2(int nPath) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_reset(int nPath) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_rewind(int nPath) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_set(int native_dst, int native_src) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_getFillType(int nPath) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setFillType(int nPath, int ft) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_isEmpty(int nPath) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_isRect(int nPath, RectF rect) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_computeBounds(int nPath, RectF bounds) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_incReserve(int nPath, int extraPtCount) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_moveTo(int nPath, float x, float y) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_rMoveTo(int nPath, float dx, float dy) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_lineTo(int nPath, float x, float y) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_rLineTo(int nPath, float dx, float dy) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_quadTo(int nPath, float x1, float y1,
                                             float x2, float y2) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_rQuadTo(int nPath, float dx1, float dy1,
                                              float dx2, float dy2) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_cubicTo(int nPath, float x1, float y1,
                                        float x2, float y2, float x3, float y3) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_rCubicTo(int nPath, float x1, float y1,
                                        float x2, float y2, float x3, float y3) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_arcTo(int nPath, RectF oval,
                    float startAngle, float sweepAngle, boolean forceMoveTo) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_close(int nPath) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_addRect(int nPath, RectF rect, int dir) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_addRect(int nPath, float left, float top,
                                            float right, float bottom, int dir) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_addOval(int nPath, RectF oval, int dir) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_addCircle(int nPath, float x, float y,
                                                float radius, int dir) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_addArc(int nPath, RectF oval,
                                            float startAngle, float sweepAngle) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_addRoundRect(int nPath, RectF rect,
                                                   float rx, float ry, int dir) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_addRoundRect(int nPath, RectF r,
                                                   float[] radii, int dir) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_addPath(int nPath, int src, float dx,
                                              float dy) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_addPath(int nPath, int src) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_addPath(int nPath, int src, int matrix) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_offset(int nPath, float dx, float dy,
                                             int dst_path) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_offset(int nPath, float dx, float dy) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setLastPoint(int nPath, float dx, float dy) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_transform(int nPath, int matrix,
                                                int dst_path) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_transform(int nPath, int matrix) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void finalizer(int nPath) {
    }

    
    public enum FillType {
        WINDING         (0),
        EVEN_ODD        (1),
        INVERSE_WINDING (2),
        INVERSE_EVEN_ODD(3);
        FillType(int ni) {
            nativeInt = ni;
        }
        final int nativeInt;
    }

    
    public enum Direction {
        CW  (0),    
        CCW (1);    
        Direction(int ni) {
            nativeInt = ni;
        }
        final int nativeInt;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.003 -0400", hash_original_field = "B19F48D0AF5FF74743B0986B97B54BD5", hash_generated_field = "66C300B8D77E06A5BCE8FE4DD0DAFB70")

    static final FillType[] sFillTypeArray = {
        FillType.WINDING,
        FillType.EVEN_ODD,
        FillType.INVERSE_WINDING,
        FillType.INVERSE_EVEN_ODD
    };
}

