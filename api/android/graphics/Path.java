package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.HardwareRenderer;

public class Path {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.655 -0400", hash_original_field = "29624343DB5BC876FA1D9DF3677A6ED3", hash_generated_field = "A385DF57FCDF6BC40C36AC929278C06B")

    public int mNativePath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.655 -0400", hash_original_field = "BBB9244AC68A5AE8F6E83F820B224A84", hash_generated_field = "250A69E67387663075BAE4FF6CF576D2")

    public boolean isSimplePath = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.655 -0400", hash_original_field = "9E366C78B27FBDD9C0248431A83481D2", hash_generated_field = "407FA9D3A82E310B399E446D54E9EE3E")

    public Region rects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.655 -0400", hash_original_field = "3DEE1FD91D4FA98ABE970571DAF12576", hash_generated_field = "06EEE85B84C90F2AA9425935FBA31565")

    private boolean mDetectSimplePaths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.656 -0400", hash_original_field = "539749EABE9BA627327F84BD9DB0990A", hash_generated_field = "DC756050863566DEECE2CF58DA95FC7C")

    private Direction mLastDirection = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.656 -0400", hash_original_method = "E55892E9E32EE58ABA689C884DCC620A", hash_generated_method = "2516288491884B0595FC4CFC8A04A2E0")
    public  Path() {
        mNativePath = init1();
        mDetectSimplePaths = HardwareRenderer.isAvailable();
        // ---------- Original Method ----------
        //mNativePath = init1();
        //mDetectSimplePaths = HardwareRenderer.isAvailable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.657 -0400", hash_original_method = "75D205ED700EB535C654F75061722DB2", hash_generated_method = "6C76EF4E23B4B68E5688BD1FBBB31DA6")
    public  Path(Path src) {
        addTaint(src.getTaint());
        int valNative = 0;
    if(src != null)        
        {
            valNative = src.mNativePath;
        } //End block
        mNativePath = init2(valNative);
        mDetectSimplePaths = HardwareRenderer.isAvailable();
        // ---------- Original Method ----------
        //int valNative = 0;
        //if (src != null) {
            //valNative = src.mNativePath;
        //}
        //mNativePath = init2(valNative);
        //mDetectSimplePaths = HardwareRenderer.isAvailable();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.657 -0400", hash_original_method = "2D6F810980DCFBBC547D7B9A11965950", hash_generated_method = "978526E65BEC3CC7CE5B0A38DBAA74FF")
    public void reset() {
        isSimplePath = true;
    if(mDetectSimplePaths)        
        {
            mLastDirection = null;
    if(rects != null)            
            rects.setEmpty();
        } //End block
        native_reset(mNativePath);
        // ---------- Original Method ----------
        //isSimplePath = true;
        //if (mDetectSimplePaths) {
            //mLastDirection = null;
            //if (rects != null) rects.setEmpty();
        //}
        //native_reset(mNativePath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.658 -0400", hash_original_method = "3CA9EEECBF523F762771968CCD0E129D", hash_generated_method = "0277DBDA0757BDADBEC65F71BF44B0EE")
    public void rewind() {
        isSimplePath = true;
    if(mDetectSimplePaths)        
        {
            mLastDirection = null;
    if(rects != null)            
            rects.setEmpty();
        } //End block
        native_rewind(mNativePath);
        // ---------- Original Method ----------
        //isSimplePath = true;
        //if (mDetectSimplePaths) {
            //mLastDirection = null;
            //if (rects != null) rects.setEmpty();
        //}
        //native_rewind(mNativePath);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.659 -0400", hash_original_method = "B685542335E97A84BA9D0A3AD0CEB866", hash_generated_method = "7D497A89981C4569C6C9414D14D3AA84")
    public void set(Path src) {
    if(this != src)        
        {
            isSimplePath = src.isSimplePath;
            native_set(mNativePath, src.mNativePath);
        } //End block
        // ---------- Original Method ----------
        //if (this != src) {
            //isSimplePath = src.isSimplePath;
            //native_set(mNativePath, src.mNativePath);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.659 -0400", hash_original_method = "756CBBEFC8F729432A1EDFB10FC9B142", hash_generated_method = "4B1EAE235E1DD82E0E7EB0AE9A9A4D04")
    public FillType getFillType() {
FillType varA25260A40654CCF047769B01502CF7FA_32068267 =         sFillTypeArray[native_getFillType(mNativePath)];
        varA25260A40654CCF047769B01502CF7FA_32068267.addTaint(taint);
        return varA25260A40654CCF047769B01502CF7FA_32068267;
        // ---------- Original Method ----------
        //return sFillTypeArray[native_getFillType(mNativePath)];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.659 -0400", hash_original_method = "5E380303FA17349F493701662250C5C9", hash_generated_method = "5153C0C8E0DB8CFB15CFE349440F5514")
    public void setFillType(FillType ft) {
        addTaint(ft.getTaint());
        native_setFillType(mNativePath, ft.nativeInt);
        // ---------- Original Method ----------
        //native_setFillType(mNativePath, ft.nativeInt);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.660 -0400", hash_original_method = "659A2CB8B4863836C5C292B196F32903", hash_generated_method = "CBA9EAB1A6B950E0E62FC081CD7764FB")
    public boolean isInverseFillType() {
        final int ft = native_getFillType(mNativePath);
        boolean var07924B37F89A123629529DC775F22843_1005211457 = ((ft & 2) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_922053610 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_922053610;
        // ---------- Original Method ----------
        //final int ft = native_getFillType(mNativePath);
        //return (ft & 2) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.660 -0400", hash_original_method = "B0C8497AF8D8E800E41ED12D1C4B68D2", hash_generated_method = "59720BE86F09EC269AE8F1A659A8BB00")
    public void toggleInverseFillType() {
        int ft = native_getFillType(mNativePath);
        ft ^= 2;
        native_setFillType(mNativePath, ft);
        // ---------- Original Method ----------
        //int ft = native_getFillType(mNativePath);
        //ft ^= 2;
        //native_setFillType(mNativePath, ft);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.660 -0400", hash_original_method = "7418BC5D1CF727D38A2258A36F4B5C15", hash_generated_method = "F65BC618D28F21C81EFF0522AEB55686")
    public boolean isEmpty() {
        boolean var12D9D9A45EE7F1929912B2DE78D89304_136159568 = (native_isEmpty(mNativePath));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1190620132 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1190620132;
        // ---------- Original Method ----------
        //return native_isEmpty(mNativePath);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.661 -0400", hash_original_method = "B84E7088610242E6493E719E7ABEF1E6", hash_generated_method = "A5D8F68200CF01586B7380883B77E403")
    public boolean isRect(RectF rect) {
        addTaint(rect.getTaint());
        boolean var4BB4DB54F9B146EF8C10C80204B2AADA_420219654 = (native_isRect(mNativePath, rect));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18451540 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_18451540;
        // ---------- Original Method ----------
        //return native_isRect(mNativePath, rect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.661 -0400", hash_original_method = "72B50A956CBF7B7731470BDB2A5220D2", hash_generated_method = "3A47A381E111EE8853F72FC4FEF2277C")
    @SuppressWarnings({"UnusedDeclaration"})
    public void computeBounds(RectF bounds, boolean exact) {
        addTaint(exact);
        addTaint(bounds.getTaint());
        native_computeBounds(mNativePath, bounds);
        // ---------- Original Method ----------
        //native_computeBounds(mNativePath, bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.661 -0400", hash_original_method = "29BD172EB2F3A7AF9AFA9275279C4F54", hash_generated_method = "AA17543C8EF974775773B602CD5836B8")
    public void incReserve(int extraPtCount) {
        addTaint(extraPtCount);
        native_incReserve(mNativePath, extraPtCount);
        // ---------- Original Method ----------
        //native_incReserve(mNativePath, extraPtCount);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.661 -0400", hash_original_method = "732AD0D6CB11A9ADE203372D23E48872", hash_generated_method = "5E3FE0E9A6DCAADA37294E42EC34265B")
    public void moveTo(float x, float y) {
        addTaint(y);
        addTaint(x);
        native_moveTo(mNativePath, x, y);
        // ---------- Original Method ----------
        //native_moveTo(mNativePath, x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.662 -0400", hash_original_method = "0933141A2BB19D63525BF81BE900CD97", hash_generated_method = "86D4849953C10E46C3B3EFB1AAC9FF31")
    public void rMoveTo(float dx, float dy) {
        addTaint(dy);
        addTaint(dx);
        native_rMoveTo(mNativePath, dx, dy);
        // ---------- Original Method ----------
        //native_rMoveTo(mNativePath, dx, dy);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.662 -0400", hash_original_method = "58E5C3E4C7F046934AC91F8FDFBACD2C", hash_generated_method = "E711381256F709BB1DC395E02C6F55C6")
    public void lineTo(float x, float y) {
        addTaint(y);
        addTaint(x);
        isSimplePath = false;
        native_lineTo(mNativePath, x, y);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_lineTo(mNativePath, x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.663 -0400", hash_original_method = "745591040780C0D8C5D54F59927D5E79", hash_generated_method = "B0F4A45C13B21CE5A918C7C04E97BB69")
    public void rLineTo(float dx, float dy) {
        addTaint(dy);
        addTaint(dx);
        isSimplePath = false;
        native_rLineTo(mNativePath, dx, dy);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_rLineTo(mNativePath, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.664 -0400", hash_original_method = "CDE92CD41872F87599E772CCBEB9168F", hash_generated_method = "5684D0CAE9508B5567C7115CA90AF290")
    public void quadTo(float x1, float y1, float x2, float y2) {
        addTaint(y2);
        addTaint(x2);
        addTaint(y1);
        addTaint(x1);
        isSimplePath = false;
        native_quadTo(mNativePath, x1, y1, x2, y2);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_quadTo(mNativePath, x1, y1, x2, y2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.664 -0400", hash_original_method = "F0FFAC3AAFD6A3822EB31C31A758C054", hash_generated_method = "68752B3575320259FFB9BF622D3CB16C")
    public void rQuadTo(float dx1, float dy1, float dx2, float dy2) {
        addTaint(dy2);
        addTaint(dx2);
        addTaint(dy1);
        addTaint(dx1);
        isSimplePath = false;
        native_rQuadTo(mNativePath, dx1, dy1, dx2, dy2);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_rQuadTo(mNativePath, dx1, dy1, dx2, dy2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.665 -0400", hash_original_method = "680DEAF903653AA5E9334EFF44E1FB26", hash_generated_method = "BC02C6ABB852E92794BAD5E72B816066")
    public void cubicTo(float x1, float y1, float x2, float y2,
                        float x3, float y3) {
        addTaint(y3);
        addTaint(x3);
        addTaint(y2);
        addTaint(x2);
        addTaint(y1);
        addTaint(x1);
        isSimplePath = false;
        native_cubicTo(mNativePath, x1, y1, x2, y2, x3, y3);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_cubicTo(mNativePath, x1, y1, x2, y2, x3, y3);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.666 -0400", hash_original_method = "7CE3D84B1219A8E32E8697E9D54626ED", hash_generated_method = "323668AE55824701820BF3E0DAB7D449")
    public void rCubicTo(float x1, float y1, float x2, float y2,
                         float x3, float y3) {
        addTaint(y3);
        addTaint(x3);
        addTaint(y2);
        addTaint(x2);
        addTaint(y1);
        addTaint(x1);
        isSimplePath = false;
        native_rCubicTo(mNativePath, x1, y1, x2, y2, x3, y3);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_rCubicTo(mNativePath, x1, y1, x2, y2, x3, y3);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.667 -0400", hash_original_method = "FF1AA715D5A76F97289F9771795F5B75", hash_generated_method = "54AF0D4C20924879CBA94E26472DBD41")
    public void arcTo(RectF oval, float startAngle, float sweepAngle,
                      boolean forceMoveTo) {
        addTaint(forceMoveTo);
        addTaint(sweepAngle);
        addTaint(startAngle);
        addTaint(oval.getTaint());
        isSimplePath = false;
        native_arcTo(mNativePath, oval, startAngle, sweepAngle, forceMoveTo);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_arcTo(mNativePath, oval, startAngle, sweepAngle, forceMoveTo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.668 -0400", hash_original_method = "48B980B599EE39F47888B8590B0311CC", hash_generated_method = "D9D4CB937CAF952B6C029256C3876AFB")
    public void arcTo(RectF oval, float startAngle, float sweepAngle) {
        addTaint(sweepAngle);
        addTaint(startAngle);
        addTaint(oval.getTaint());
        isSimplePath = false;
        native_arcTo(mNativePath, oval, startAngle, sweepAngle, false);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_arcTo(mNativePath, oval, startAngle, sweepAngle, false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.669 -0400", hash_original_method = "E16C5D29E703AEBAB6CAF17A68A08F6B", hash_generated_method = "34D9621BE529F6E4B1748728F71F3FA6")
    public void close() {
        isSimplePath = false;
        native_close(mNativePath);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_close(mNativePath);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.670 -0400", hash_original_method = "4C4C77916FAC7E47D84337BC4A27AFDA", hash_generated_method = "03C3F9106318D79761CADDE43B31F645")
    private void detectSimplePath(float left, float top, float right, float bottom, Direction dir) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
    if(mDetectSimplePaths)        
        {
    if(mLastDirection == null)            
            {
                mLastDirection = dir;
            } //End block
    if(mLastDirection != dir)            
            {
                isSimplePath = false;
            } //End block
            else
            {
    if(rects == null)                
                rects = new Region();
                rects.op((int) left, (int) top, (int) right, (int) bottom, Region.Op.UNION);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mDetectSimplePaths) {
            //if (mLastDirection == null) {
                //mLastDirection = dir;
            //}
            //if (mLastDirection != dir) {
                //isSimplePath = false;
            //} else {
                //if (rects == null) rects = new Region();
                //rects.op((int) left, (int) top, (int) right, (int) bottom, Region.Op.UNION);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.671 -0400", hash_original_method = "4612527F52EC9CC57646B58789A81A83", hash_generated_method = "FA6CCC43EB74EEF96087E62D60750C9F")
    public void addRect(RectF rect, Direction dir) {
        addTaint(dir.getTaint());
        addTaint(rect.getTaint());
    if(rect == null)        
        {
            NullPointerException var20101AB4A823166AB07098470945D92B_1156761511 = new NullPointerException("need rect parameter");
            var20101AB4A823166AB07098470945D92B_1156761511.addTaint(taint);
            throw var20101AB4A823166AB07098470945D92B_1156761511;
        } //End block
        detectSimplePath(rect.left, rect.top, rect.right, rect.bottom, dir);
        native_addRect(mNativePath, rect, dir.nativeInt);
        // ---------- Original Method ----------
        //if (rect == null) {
            //throw new NullPointerException("need rect parameter");
        //}
        //detectSimplePath(rect.left, rect.top, rect.right, rect.bottom, dir);
        //native_addRect(mNativePath, rect, dir.nativeInt);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.672 -0400", hash_original_method = "B728DA55BB20CAF41F04A8721ACC9EB9", hash_generated_method = "559F11D2D375098B2B96A43B90DAF8A4")
    public void addRect(float left, float top, float right, float bottom, Direction dir) {
        addTaint(dir.getTaint());
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        detectSimplePath(left, top, right, bottom, dir);
        native_addRect(mNativePath, left, top, right, bottom, dir.nativeInt);
        // ---------- Original Method ----------
        //detectSimplePath(left, top, right, bottom, dir);
        //native_addRect(mNativePath, left, top, right, bottom, dir.nativeInt);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.672 -0400", hash_original_method = "A39723146C675E0E04F715D6E89297CC", hash_generated_method = "81331B3F8F7774739AA13744AF57F380")
    public void addOval(RectF oval, Direction dir) {
        addTaint(dir.getTaint());
        addTaint(oval.getTaint());
    if(oval == null)        
        {
            NullPointerException varE99607B1E8C84849DE34B3C387B9CCD7_1708625475 = new NullPointerException("need oval parameter");
            varE99607B1E8C84849DE34B3C387B9CCD7_1708625475.addTaint(taint);
            throw varE99607B1E8C84849DE34B3C387B9CCD7_1708625475;
        } //End block
        isSimplePath = false;
        native_addOval(mNativePath, oval, dir.nativeInt);
        // ---------- Original Method ----------
        //if (oval == null) {
            //throw new NullPointerException("need oval parameter");
        //}
        //isSimplePath = false;
        //native_addOval(mNativePath, oval, dir.nativeInt);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.673 -0400", hash_original_method = "7256751168A905EF802B1EFF88D64306", hash_generated_method = "F2A09A2C2F64536729469E3C4A005381")
    public void addCircle(float x, float y, float radius, Direction dir) {
        addTaint(dir.getTaint());
        addTaint(radius);
        addTaint(y);
        addTaint(x);
        isSimplePath = false;
        native_addCircle(mNativePath, x, y, radius, dir.nativeInt);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_addCircle(mNativePath, x, y, radius, dir.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.674 -0400", hash_original_method = "BDC1F894C327354FF6BC9BE2A0106898", hash_generated_method = "5E4E0F332003C54C055DC41373CF91E0")
    public void addArc(RectF oval, float startAngle, float sweepAngle) {
        addTaint(sweepAngle);
        addTaint(startAngle);
        addTaint(oval.getTaint());
    if(oval == null)        
        {
            NullPointerException varE99607B1E8C84849DE34B3C387B9CCD7_1348242510 = new NullPointerException("need oval parameter");
            varE99607B1E8C84849DE34B3C387B9CCD7_1348242510.addTaint(taint);
            throw varE99607B1E8C84849DE34B3C387B9CCD7_1348242510;
        } //End block
        isSimplePath = false;
        native_addArc(mNativePath, oval, startAngle, sweepAngle);
        // ---------- Original Method ----------
        //if (oval == null) {
            //throw new NullPointerException("need oval parameter");
        //}
        //isSimplePath = false;
        //native_addArc(mNativePath, oval, startAngle, sweepAngle);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.675 -0400", hash_original_method = "3ECD815B6409768DB15813B06CD42DD5", hash_generated_method = "5E15C7CEB52DFB503BC7B769C1869C9F")
    public void addRoundRect(RectF rect, float rx, float ry, Direction dir) {
        addTaint(dir.getTaint());
        addTaint(ry);
        addTaint(rx);
        addTaint(rect.getTaint());
    if(rect == null)        
        {
            NullPointerException var20101AB4A823166AB07098470945D92B_2103052673 = new NullPointerException("need rect parameter");
            var20101AB4A823166AB07098470945D92B_2103052673.addTaint(taint);
            throw var20101AB4A823166AB07098470945D92B_2103052673;
        } //End block
        isSimplePath = false;
        native_addRoundRect(mNativePath, rect, rx, ry, dir.nativeInt);
        // ---------- Original Method ----------
        //if (rect == null) {
            //throw new NullPointerException("need rect parameter");
        //}
        //isSimplePath = false;
        //native_addRoundRect(mNativePath, rect, rx, ry, dir.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.677 -0400", hash_original_method = "543113738AC73676270E7FCF210EDB1F", hash_generated_method = "8D51203269D2E66B3C6974238299786B")
    public void addRoundRect(RectF rect, float[] radii, Direction dir) {
        addTaint(dir.getTaint());
        addTaint(radii[0]);
        addTaint(rect.getTaint());
    if(rect == null)        
        {
            NullPointerException var20101AB4A823166AB07098470945D92B_1696087912 = new NullPointerException("need rect parameter");
            var20101AB4A823166AB07098470945D92B_1696087912.addTaint(taint);
            throw var20101AB4A823166AB07098470945D92B_1696087912;
        } //End block
    if(radii.length < 8)        
        {
            ArrayIndexOutOfBoundsException var418E46122F39025F32A1446196BF386E_1685978337 = new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
            var418E46122F39025F32A1446196BF386E_1685978337.addTaint(taint);
            throw var418E46122F39025F32A1446196BF386E_1685978337;
        } //End block
        isSimplePath = false;
        native_addRoundRect(mNativePath, rect, radii, dir.nativeInt);
        // ---------- Original Method ----------
        //if (rect == null) {
            //throw new NullPointerException("need rect parameter");
        //}
        //if (radii.length < 8) {
            //throw new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
        //}
        //isSimplePath = false;
        //native_addRoundRect(mNativePath, rect, radii, dir.nativeInt);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.679 -0400", hash_original_method = "E4CA114D3203375891711738ECF0A722", hash_generated_method = "069850A6C6E425EFBC502F4F9F0088BA")
    public void addPath(Path src, float dx, float dy) {
        addTaint(dy);
        addTaint(dx);
        addTaint(src.getTaint());
        isSimplePath = false;
        native_addPath(mNativePath, src.mNativePath, dx, dy);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_addPath(mNativePath, src.mNativePath, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.680 -0400", hash_original_method = "543B497D09485FEEC00989CA21E8A572", hash_generated_method = "32E1AC3D8B750CF29A4A5DB44E3F3CCC")
    public void addPath(Path src) {
        addTaint(src.getTaint());
        isSimplePath = false;
        native_addPath(mNativePath, src.mNativePath);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_addPath(mNativePath, src.mNativePath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.681 -0400", hash_original_method = "D7DB7FC66FA71E8C80EBAD3AE821E2C4", hash_generated_method = "0E67C22A086AF65F7F98160704149241")
    public void addPath(Path src, Matrix matrix) {
        addTaint(matrix.getTaint());
        addTaint(src.getTaint());
    if(!src.isSimplePath)        
        isSimplePath = false;
        native_addPath(mNativePath, src.mNativePath, matrix.native_instance);
        // ---------- Original Method ----------
        //if (!src.isSimplePath) isSimplePath = false;
        //native_addPath(mNativePath, src.mNativePath, matrix.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.682 -0400", hash_original_method = "300271373C98AD70F0D1DFEC9CC1821E", hash_generated_method = "EC2162628929B3CA8A98F48DFDE954E6")
    public void offset(float dx, float dy, Path dst) {
        addTaint(dst.getTaint());
        addTaint(dy);
        addTaint(dx);
        int dstNative = 0;
    if(dst != null)        
        {
            dstNative = dst.mNativePath;
        } //End block
        native_offset(mNativePath, dx, dy, dstNative);
        // ---------- Original Method ----------
        //int dstNative = 0;
        //if (dst != null) {
            //dstNative = dst.mNativePath;
        //}
        //native_offset(mNativePath, dx, dy, dstNative);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.682 -0400", hash_original_method = "84AAB7006BE97BBDBF66CEB78BE6403B", hash_generated_method = "C7EF102895276FAC7172DEBA45A68C3D")
    public void offset(float dx, float dy) {
        addTaint(dy);
        addTaint(dx);
        native_offset(mNativePath, dx, dy);
        // ---------- Original Method ----------
        //native_offset(mNativePath, dx, dy);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.683 -0400", hash_original_method = "DE0F6A19984A9351DC908B14944CEA04", hash_generated_method = "C747E9F1D81C86765EAF8DF7406059B5")
    public void setLastPoint(float dx, float dy) {
        addTaint(dy);
        addTaint(dx);
        isSimplePath = false;
        native_setLastPoint(mNativePath, dx, dy);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_setLastPoint(mNativePath, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.684 -0400", hash_original_method = "C6EADCEB56E45A061E81B3D824529855", hash_generated_method = "3C623C0C76397DD9E82AFB048C23EF95")
    public void transform(Matrix matrix, Path dst) {
        addTaint(dst.getTaint());
        addTaint(matrix.getTaint());
        int dstNative = 0;
    if(dst != null)        
        {
            dstNative = dst.mNativePath;
        } //End block
        native_transform(mNativePath, matrix.native_instance, dstNative);
        // ---------- Original Method ----------
        //int dstNative = 0;
        //if (dst != null) {
            //dstNative = dst.mNativePath;
        //}
        //native_transform(mNativePath, matrix.native_instance, dstNative);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.684 -0400", hash_original_method = "E2E9E79308A321DB0305128A17F8E66B", hash_generated_method = "1817257E491253CE81C196BBE55DD424")
    public void transform(Matrix matrix) {
        addTaint(matrix.getTaint());
        native_transform(mNativePath, matrix.native_instance);
        // ---------- Original Method ----------
        //native_transform(mNativePath, matrix.native_instance);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.685 -0400", hash_original_method = "F7200B02D28E5C321C9E159FC014E915", hash_generated_method = "B63DF27303A34F6912C29DAE9DF797C8")
    protected void finalize() throws Throwable {
        try 
        {
            finalizer(mNativePath);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //finalizer(mNativePath);
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.685 -0400", hash_original_method = "A7A62D46D1AC389C59E8D1EF0EC6AB35", hash_generated_method = "FF6AC127F21A0D691A31E3950A6A3C70")
    final int ni() {
        int var29624343DB5BC876FA1D9DF3677A6ED3_1019024410 = (mNativePath);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1719878540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1719878540;
        // ---------- Original Method ----------
        //return mNativePath;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.699 -0400", hash_original_field = "B19F48D0AF5FF74743B0986B97B54BD5", hash_generated_field = "66C300B8D77E06A5BCE8FE4DD0DAFB70")

    static final FillType[] sFillTypeArray = {
        FillType.WINDING,
        FillType.EVEN_ODD,
        FillType.INVERSE_WINDING,
        FillType.INVERSE_EVEN_ODD
    };
}

