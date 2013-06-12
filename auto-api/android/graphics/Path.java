package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.view.HardwareRenderer;

public class Path {
    public final int mNativePath;
    public boolean isSimplePath = true;
    public Region rects;
    private boolean mDetectSimplePaths;
    private Direction mLastDirection = null;
    static final FillType[] sFillTypeArray = {
        FillType.WINDING,
        FillType.EVEN_ODD,
        FillType.INVERSE_WINDING,
        FillType.INVERSE_EVEN_ODD
    };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.285 -0400", hash_original_method = "E55892E9E32EE58ABA689C884DCC620A", hash_generated_method = "EB0FAC8272BA90A82C2E3E6DC142D493")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Path() {
        mNativePath = init1();
        mDetectSimplePaths = HardwareRenderer.isAvailable();
        // ---------- Original Method ----------
        //mNativePath = init1();
        //mDetectSimplePaths = HardwareRenderer.isAvailable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.285 -0400", hash_original_method = "75D205ED700EB535C654F75061722DB2", hash_generated_method = "1535843774B4DF3561AE7C989C6BF8D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Path(Path src) {
        dsTaint.addTaint(src.dsTaint);
        int valNative;
        valNative = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.285 -0400", hash_original_method = "2D6F810980DCFBBC547D7B9A11965950", hash_generated_method = "7C4B8BFFA10DE1206C35EAE1173C3A46")
    @DSModeled(DSC.SAFE)
    public void reset() {
        isSimplePath = true;
        {
            mLastDirection = null;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.286 -0400", hash_original_method = "3CA9EEECBF523F762771968CCD0E129D", hash_generated_method = "F0660BE2B08DA2F1B7ED5A982CBFFD22")
    @DSModeled(DSC.SAFE)
    public void rewind() {
        isSimplePath = true;
        {
            mLastDirection = null;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.286 -0400", hash_original_method = "B685542335E97A84BA9D0A3AD0CEB866", hash_generated_method = "FBE77F5C8DB46FD2F22AC9D5472196AD")
    @DSModeled(DSC.SAFE)
    public void set(Path src) {
        dsTaint.addTaint(src.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.286 -0400", hash_original_method = "756CBBEFC8F729432A1EDFB10FC9B142", hash_generated_method = "EC41985D3C78A3BAD5BA96A1FB844BD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FillType getFillType() {
        FillType var46169E7DE3649425DA22AE0366B45799_1663881398 = (sFillTypeArray[native_getFillType(mNativePath)]);
        return (FillType)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sFillTypeArray[native_getFillType(mNativePath)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.286 -0400", hash_original_method = "5E380303FA17349F493701662250C5C9", hash_generated_method = "41E688250183B9552E6B54424974A3CE")
    @DSModeled(DSC.SAFE)
    public void setFillType(FillType ft) {
        dsTaint.addTaint(ft.dsTaint);
        native_setFillType(mNativePath, ft.nativeInt);
        // ---------- Original Method ----------
        //native_setFillType(mNativePath, ft.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.286 -0400", hash_original_method = "659A2CB8B4863836C5C292B196F32903", hash_generated_method = "519CCEC58A30A8C00B371DB4601E765E")
    @DSModeled(DSC.SAFE)
    public boolean isInverseFillType() {
        final int ft;
        ft = native_getFillType(mNativePath);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int ft = native_getFillType(mNativePath);
        //return (ft & 2) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.286 -0400", hash_original_method = "B0C8497AF8D8E800E41ED12D1C4B68D2", hash_generated_method = "E2107E9D8464463B4935361B62E3EC1D")
    @DSModeled(DSC.SAFE)
    public void toggleInverseFillType() {
        int ft;
        ft = native_getFillType(mNativePath);
        ft ^= 2;
        native_setFillType(mNativePath, ft);
        // ---------- Original Method ----------
        //int ft = native_getFillType(mNativePath);
        //ft ^= 2;
        //native_setFillType(mNativePath, ft);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.286 -0400", hash_original_method = "7418BC5D1CF727D38A2258A36F4B5C15", hash_generated_method = "29590703AE0D7917BDE7244813D419CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var522B462A5C17E5E49A401CABA795A0BC_1195175449 = (native_isEmpty(mNativePath));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_isEmpty(mNativePath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.286 -0400", hash_original_method = "B84E7088610242E6493E719E7ABEF1E6", hash_generated_method = "0B592866DCEEB1FF7F542A2081B9C7B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isRect(RectF rect) {
        dsTaint.addTaint(rect.dsTaint);
        boolean varAA53C40F0A5EA7379B3BEE35A1C7F0DA_963197813 = (native_isRect(mNativePath, rect));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_isRect(mNativePath, rect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.286 -0400", hash_original_method = "72B50A956CBF7B7731470BDB2A5220D2", hash_generated_method = "071462F60CB3519A9CB65D492495D983")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings({"UnusedDeclaration"})
    public void computeBounds(RectF bounds, boolean exact) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(exact);
        native_computeBounds(mNativePath, bounds);
        // ---------- Original Method ----------
        //native_computeBounds(mNativePath, bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.287 -0400", hash_original_method = "29BD172EB2F3A7AF9AFA9275279C4F54", hash_generated_method = "1E57F6EC3D6CBAD13EC7ED503E41F686")
    @DSModeled(DSC.SAFE)
    public void incReserve(int extraPtCount) {
        dsTaint.addTaint(extraPtCount);
        native_incReserve(mNativePath, extraPtCount);
        // ---------- Original Method ----------
        //native_incReserve(mNativePath, extraPtCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.287 -0400", hash_original_method = "732AD0D6CB11A9ADE203372D23E48872", hash_generated_method = "9CFA13FF8CCC0BEA234CBD336B374CD3")
    @DSModeled(DSC.SAFE)
    public void moveTo(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        native_moveTo(mNativePath, x, y);
        // ---------- Original Method ----------
        //native_moveTo(mNativePath, x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.287 -0400", hash_original_method = "0933141A2BB19D63525BF81BE900CD97", hash_generated_method = "B0F65031C3387854F2CC1E72A207969C")
    @DSModeled(DSC.SAFE)
    public void rMoveTo(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        native_rMoveTo(mNativePath, dx, dy);
        // ---------- Original Method ----------
        //native_rMoveTo(mNativePath, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.287 -0400", hash_original_method = "58E5C3E4C7F046934AC91F8FDFBACD2C", hash_generated_method = "BE71C6CD1B52521CDA4558D037904CFA")
    @DSModeled(DSC.SAFE)
    public void lineTo(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        isSimplePath = false;
        native_lineTo(mNativePath, x, y);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_lineTo(mNativePath, x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.287 -0400", hash_original_method = "745591040780C0D8C5D54F59927D5E79", hash_generated_method = "966FD124068677D7F9BA06959F0A2218")
    @DSModeled(DSC.SAFE)
    public void rLineTo(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        isSimplePath = false;
        native_rLineTo(mNativePath, dx, dy);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_rLineTo(mNativePath, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.287 -0400", hash_original_method = "CDE92CD41872F87599E772CCBEB9168F", hash_generated_method = "D84EF907289F6942F191B9C0F5D7B893")
    @DSModeled(DSC.SAFE)
    public void quadTo(float x1, float y1, float x2, float y2) {
        dsTaint.addTaint(y1);
        dsTaint.addTaint(y2);
        dsTaint.addTaint(x2);
        dsTaint.addTaint(x1);
        isSimplePath = false;
        native_quadTo(mNativePath, x1, y1, x2, y2);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_quadTo(mNativePath, x1, y1, x2, y2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.287 -0400", hash_original_method = "F0FFAC3AAFD6A3822EB31C31A758C054", hash_generated_method = "5F0523D2D59501E5C4F65F3B1636F44C")
    @DSModeled(DSC.SAFE)
    public void rQuadTo(float dx1, float dy1, float dx2, float dy2) {
        dsTaint.addTaint(dx1);
        dsTaint.addTaint(dy1);
        dsTaint.addTaint(dx2);
        dsTaint.addTaint(dy2);
        isSimplePath = false;
        native_rQuadTo(mNativePath, dx1, dy1, dx2, dy2);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_rQuadTo(mNativePath, dx1, dy1, dx2, dy2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.287 -0400", hash_original_method = "680DEAF903653AA5E9334EFF44E1FB26", hash_generated_method = "D0512382DF3F6FF77EF187A8C23149EA")
    @DSModeled(DSC.SAFE)
    public void cubicTo(float x1, float y1, float x2, float y2,
                        float x3, float y3) {
        dsTaint.addTaint(y1);
        dsTaint.addTaint(y2);
        dsTaint.addTaint(y3);
        dsTaint.addTaint(x2);
        dsTaint.addTaint(x3);
        dsTaint.addTaint(x1);
        isSimplePath = false;
        native_cubicTo(mNativePath, x1, y1, x2, y2, x3, y3);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_cubicTo(mNativePath, x1, y1, x2, y2, x3, y3);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.287 -0400", hash_original_method = "7CE3D84B1219A8E32E8697E9D54626ED", hash_generated_method = "E207CD1504E494C8A7A02C1930372B62")
    @DSModeled(DSC.SAFE)
    public void rCubicTo(float x1, float y1, float x2, float y2,
                         float x3, float y3) {
        dsTaint.addTaint(y1);
        dsTaint.addTaint(y2);
        dsTaint.addTaint(y3);
        dsTaint.addTaint(x2);
        dsTaint.addTaint(x3);
        dsTaint.addTaint(x1);
        isSimplePath = false;
        native_rCubicTo(mNativePath, x1, y1, x2, y2, x3, y3);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_rCubicTo(mNativePath, x1, y1, x2, y2, x3, y3);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.288 -0400", hash_original_method = "FF1AA715D5A76F97289F9771795F5B75", hash_generated_method = "4D72523FE4B81C18EE1A01D5A6443670")
    @DSModeled(DSC.SAFE)
    public void arcTo(RectF oval, float startAngle, float sweepAngle,
                      boolean forceMoveTo) {
        dsTaint.addTaint(startAngle);
        dsTaint.addTaint(forceMoveTo);
        dsTaint.addTaint(sweepAngle);
        dsTaint.addTaint(oval.dsTaint);
        isSimplePath = false;
        native_arcTo(mNativePath, oval, startAngle, sweepAngle, forceMoveTo);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_arcTo(mNativePath, oval, startAngle, sweepAngle, forceMoveTo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.288 -0400", hash_original_method = "48B980B599EE39F47888B8590B0311CC", hash_generated_method = "B78390CEE4062C814A6DE9DA28F91B90")
    @DSModeled(DSC.SAFE)
    public void arcTo(RectF oval, float startAngle, float sweepAngle) {
        dsTaint.addTaint(startAngle);
        dsTaint.addTaint(sweepAngle);
        dsTaint.addTaint(oval.dsTaint);
        isSimplePath = false;
        native_arcTo(mNativePath, oval, startAngle, sweepAngle, false);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_arcTo(mNativePath, oval, startAngle, sweepAngle, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.288 -0400", hash_original_method = "E16C5D29E703AEBAB6CAF17A68A08F6B", hash_generated_method = "35857876CBF663AA0500A9F96DF0E0C2")
    @DSModeled(DSC.SAFE)
    public void close() {
        isSimplePath = false;
        native_close(mNativePath);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_close(mNativePath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.288 -0400", hash_original_method = "4C4C77916FAC7E47D84337BC4A27AFDA", hash_generated_method = "0FEF6BCB3C822E53DB56CDB877965394")
    @DSModeled(DSC.SAFE)
    private void detectSimplePath(float left, float top, float right, float bottom, Direction dir) {
        dsTaint.addTaint(dir.dsTaint);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        {
            {
                isSimplePath = false;
            } //End block
            {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.288 -0400", hash_original_method = "4612527F52EC9CC57646B58789A81A83", hash_generated_method = "6660100033FA766BDC4F2395F9AC112E")
    @DSModeled(DSC.SAFE)
    public void addRect(RectF rect, Direction dir) {
        dsTaint.addTaint(dir.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        {
            throw new NullPointerException("need rect parameter");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.288 -0400", hash_original_method = "B728DA55BB20CAF41F04A8721ACC9EB9", hash_generated_method = "FA201A3CBE32A435DF80C0B9EE6522B6")
    @DSModeled(DSC.SAFE)
    public void addRect(float left, float top, float right, float bottom, Direction dir) {
        dsTaint.addTaint(dir.dsTaint);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        detectSimplePath(left, top, right, bottom, dir);
        native_addRect(mNativePath, left, top, right, bottom, dir.nativeInt);
        // ---------- Original Method ----------
        //detectSimplePath(left, top, right, bottom, dir);
        //native_addRect(mNativePath, left, top, right, bottom, dir.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.289 -0400", hash_original_method = "A39723146C675E0E04F715D6E89297CC", hash_generated_method = "6D8EB56AF53ED742390483C3F8F92A97")
    @DSModeled(DSC.SAFE)
    public void addOval(RectF oval, Direction dir) {
        dsTaint.addTaint(dir.dsTaint);
        dsTaint.addTaint(oval.dsTaint);
        {
            throw new NullPointerException("need oval parameter");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.289 -0400", hash_original_method = "7256751168A905EF802B1EFF88D64306", hash_generated_method = "B5C7C0AA2FED92A8453760ECBE81DBF0")
    @DSModeled(DSC.SAFE)
    public void addCircle(float x, float y, float radius, Direction dir) {
        dsTaint.addTaint(dir.dsTaint);
        dsTaint.addTaint(radius);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        isSimplePath = false;
        native_addCircle(mNativePath, x, y, radius, dir.nativeInt);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_addCircle(mNativePath, x, y, radius, dir.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.289 -0400", hash_original_method = "BDC1F894C327354FF6BC9BE2A0106898", hash_generated_method = "1E9E5BF84F60721F8CDD3A48444877A6")
    @DSModeled(DSC.SAFE)
    public void addArc(RectF oval, float startAngle, float sweepAngle) {
        dsTaint.addTaint(startAngle);
        dsTaint.addTaint(sweepAngle);
        dsTaint.addTaint(oval.dsTaint);
        {
            throw new NullPointerException("need oval parameter");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.289 -0400", hash_original_method = "3ECD815B6409768DB15813B06CD42DD5", hash_generated_method = "F2A46D452BF7C4698075BBEEC469D63D")
    @DSModeled(DSC.SAFE)
    public void addRoundRect(RectF rect, float rx, float ry, Direction dir) {
        dsTaint.addTaint(dir.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        dsTaint.addTaint(rx);
        dsTaint.addTaint(ry);
        {
            throw new NullPointerException("need rect parameter");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.289 -0400", hash_original_method = "543113738AC73676270E7FCF210EDB1F", hash_generated_method = "E6CDC21BA08F8BD362EBE2F11173F31E")
    @DSModeled(DSC.SAFE)
    public void addRoundRect(RectF rect, float[] radii, Direction dir) {
        dsTaint.addTaint(dir.dsTaint);
        dsTaint.addTaint(radii);
        dsTaint.addTaint(rect.dsTaint);
        {
            throw new NullPointerException("need rect parameter");
        } //End block
        {
            throw new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.289 -0400", hash_original_method = "E4CA114D3203375891711738ECF0A722", hash_generated_method = "8875E5E543E9645E3BCD29B559644BCE")
    @DSModeled(DSC.SAFE)
    public void addPath(Path src, float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        dsTaint.addTaint(src.dsTaint);
        isSimplePath = false;
        native_addPath(mNativePath, src.mNativePath, dx, dy);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_addPath(mNativePath, src.mNativePath, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.289 -0400", hash_original_method = "543B497D09485FEEC00989CA21E8A572", hash_generated_method = "1B24B7F2A2AAD3BB638BECA878B420BE")
    @DSModeled(DSC.SAFE)
    public void addPath(Path src) {
        dsTaint.addTaint(src.dsTaint);
        isSimplePath = false;
        native_addPath(mNativePath, src.mNativePath);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_addPath(mNativePath, src.mNativePath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.289 -0400", hash_original_method = "D7DB7FC66FA71E8C80EBAD3AE821E2C4", hash_generated_method = "3224F9FDE3C3F1E3D0EBB5F6CF8082C1")
    @DSModeled(DSC.SAFE)
    public void addPath(Path src, Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        isSimplePath = false;
        native_addPath(mNativePath, src.mNativePath, matrix.native_instance);
        // ---------- Original Method ----------
        //if (!src.isSimplePath) isSimplePath = false;
        //native_addPath(mNativePath, src.mNativePath, matrix.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.290 -0400", hash_original_method = "300271373C98AD70F0D1DFEC9CC1821E", hash_generated_method = "BAF1B068ABC8B2920620089A37563EEF")
    @DSModeled(DSC.SAFE)
    public void offset(float dx, float dy, Path dst) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        dsTaint.addTaint(dst.dsTaint);
        int dstNative;
        dstNative = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.290 -0400", hash_original_method = "84AAB7006BE97BBDBF66CEB78BE6403B", hash_generated_method = "542F76B85EFD9F810B5B6A5C254C2CBF")
    @DSModeled(DSC.SAFE)
    public void offset(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        native_offset(mNativePath, dx, dy);
        // ---------- Original Method ----------
        //native_offset(mNativePath, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.290 -0400", hash_original_method = "DE0F6A19984A9351DC908B14944CEA04", hash_generated_method = "43322493DBAB43705EA16F0C61E82AAA")
    @DSModeled(DSC.SAFE)
    public void setLastPoint(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        isSimplePath = false;
        native_setLastPoint(mNativePath, dx, dy);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_setLastPoint(mNativePath, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.290 -0400", hash_original_method = "C6EADCEB56E45A061E81B3D824529855", hash_generated_method = "95C882AB816F9ED56D94603B6DE92D52")
    @DSModeled(DSC.SAFE)
    public void transform(Matrix matrix, Path dst) {
        dsTaint.addTaint(matrix.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        int dstNative;
        dstNative = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.290 -0400", hash_original_method = "E2E9E79308A321DB0305128A17F8E66B", hash_generated_method = "CB81BFF145AF786DF1A6A1857EF67CE2")
    @DSModeled(DSC.SAFE)
    public void transform(Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        native_transform(mNativePath, matrix.native_instance);
        // ---------- Original Method ----------
        //native_transform(mNativePath, matrix.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.290 -0400", hash_original_method = "F7200B02D28E5C321C9E159FC014E915", hash_generated_method = "27C8C110519540A565653D29616E5013")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.290 -0400", hash_original_method = "A7A62D46D1AC389C59E8D1EF0EC6AB35", hash_generated_method = "36891FA95DEB51579078009F8B492730")
    @DSModeled(DSC.SAFE)
    final int ni() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNativePath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.290 -0400", hash_original_method = "232F114BC5F74E323FCD79BC10CA3A70", hash_generated_method = "28A807FDD4AA4FCAFEF1759B69FA2261")
    private static int init1() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.290 -0400", hash_original_method = "CA05AF3D5A4F491DA5E63E08B85C0E02", hash_generated_method = "03219D8F47F1490AA8120A375997CBBD")
    private static int init2(int nPath) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.290 -0400", hash_original_method = "EB48567ECB1D3C5C52F1E799B2470BE6", hash_generated_method = "FFAB43D862CCD67B66F2F5CDD2A9343C")
    private static void native_reset(int nPath) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.290 -0400", hash_original_method = "0DC6107D54CC72091789930650CFC24B", hash_generated_method = "0FC7A5831069D162AE09DEDCB6005D06")
    private static void native_rewind(int nPath) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.291 -0400", hash_original_method = "03FE39B4725C25687863AC255E842897", hash_generated_method = "BF523FC9DD9199FCC7A3E8789C7273B1")
    private static void native_set(int native_dst, int native_src) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.291 -0400", hash_original_method = "625F84282E71964B255F4DA618060BEA", hash_generated_method = "B148D02A1C0A42010250DA7113D4022C")
    private static int native_getFillType(int nPath) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.291 -0400", hash_original_method = "FC02BAF2795EA08DC72E26A5BF4E877D", hash_generated_method = "43FF21C27F141C3461026470DC23D23B")
    private static void native_setFillType(int nPath, int ft) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.291 -0400", hash_original_method = "9D341A6CA16069AE434C8E7F0D9728DA", hash_generated_method = "7A626C77C1AA456177B5D6AA44B8A0B5")
    private static boolean native_isEmpty(int nPath) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.291 -0400", hash_original_method = "34DF884C683B3D939B872BC2EC431580", hash_generated_method = "AD10CE655CF22AD0DAF3AA374447A91C")
    private static boolean native_isRect(int nPath, RectF rect) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.291 -0400", hash_original_method = "853C60D9870DFD4CC1876AA4F2D0424B", hash_generated_method = "4B5844AD2E3E612818BCF81ED7FA23AE")
    private static void native_computeBounds(int nPath, RectF bounds) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.291 -0400", hash_original_method = "04A0F885A6F8983699AAB032DAB0681B", hash_generated_method = "18A145FAC055A6FC4C047A055FF8A0C2")
    private static void native_incReserve(int nPath, int extraPtCount) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.291 -0400", hash_original_method = "13568C121A793F16607C82DB0AEE7075", hash_generated_method = "FDAF4C494342B0184B492790F0BAD48E")
    private static void native_moveTo(int nPath, float x, float y) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.291 -0400", hash_original_method = "45F520675473559B8DA14E9577364DDD", hash_generated_method = "AB2986B419DEAA86B782EB18E3E3D34C")
    private static void native_rMoveTo(int nPath, float dx, float dy) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.291 -0400", hash_original_method = "FBC84642887C7A0F2C6DD3599BBD8DC2", hash_generated_method = "35F83D4948F9D54FF62CDBC600B28DC3")
    private static void native_lineTo(int nPath, float x, float y) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.291 -0400", hash_original_method = "EE9C8035D3F3A2986F3034401C316D15", hash_generated_method = "DA4B1DB107875753F4386D1DF15760B1")
    private static void native_rLineTo(int nPath, float dx, float dy) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.291 -0400", hash_original_method = "60C61B9C0737F8C8631CD3CEE3D15FC1", hash_generated_method = "0D93939685524CEF257101327B83A636")
    private static void native_quadTo(int nPath, float x1, float y1,
                                             float x2, float y2) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.291 -0400", hash_original_method = "381D78869927EADE1F7C70064F84A076", hash_generated_method = "3AF92183762A544DBF171C95C6A65A43")
    private static void native_rQuadTo(int nPath, float dx1, float dy1,
                                              float dx2, float dy2) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.291 -0400", hash_original_method = "AD01BFDEDC371E5A0467CBBED14F5954", hash_generated_method = "9C22F740C10CE919CFE0034D4AB4BB8D")
    private static void native_cubicTo(int nPath, float x1, float y1,
                                        float x2, float y2, float x3, float y3) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.292 -0400", hash_original_method = "6DF918AE35A16FDAE50A7090DB96A555", hash_generated_method = "54DD33BA4D496F0BE63AA59B4115EA34")
    private static void native_rCubicTo(int nPath, float x1, float y1,
                                        float x2, float y2, float x3, float y3) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.292 -0400", hash_original_method = "EDCB0E27033BF8F21DABF5BF0C0D55C4", hash_generated_method = "068922BC13D84E18E52582F8463D50CB")
    private static void native_arcTo(int nPath, RectF oval,
                    float startAngle, float sweepAngle, boolean forceMoveTo) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.292 -0400", hash_original_method = "AC6D9FE6786B1855307C432C661B4353", hash_generated_method = "F4D4A861EA6708F41891926B71C21722")
    private static void native_close(int nPath) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.292 -0400", hash_original_method = "E018103BDCB992C5F3B9A90FA53F3E4D", hash_generated_method = "108B0F41930BE2021A14DA32BB753EED")
    private static void native_addRect(int nPath, RectF rect, int dir) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.292 -0400", hash_original_method = "ADAA9E342CBECC8DE742FD95D17D2735", hash_generated_method = "91A0DB3A8F0BFF89CE5D9A3A667FFEE1")
    private static void native_addRect(int nPath, float left, float top,
                                            float right, float bottom, int dir) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.292 -0400", hash_original_method = "CF44773229282EC9D90E0F87740784D5", hash_generated_method = "80A9F690516033E0846FA6E5CA6BC969")
    private static void native_addOval(int nPath, RectF oval, int dir) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.292 -0400", hash_original_method = "798EF76A799EC6FDCAD03A0719C1CAA7", hash_generated_method = "6F0A6B6B4DC8D91CF0733EC73F95D3E4")
    private static void native_addCircle(int nPath, float x, float y,
                                                float radius, int dir) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.292 -0400", hash_original_method = "9378D20419FBA3D8D89A207FA53ECBC8", hash_generated_method = "9719319D7FADC43F31598C90BBA5D666")
    private static void native_addArc(int nPath, RectF oval,
                                            float startAngle, float sweepAngle) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.292 -0400", hash_original_method = "132847F5E9D9434F006CEAE8EC44F410", hash_generated_method = "F9D752B0FFA371D92EC2B5C7BDFD28DC")
    private static void native_addRoundRect(int nPath, RectF rect,
                                                   float rx, float ry, int dir) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.292 -0400", hash_original_method = "356056DE0E1873E50A8458E1F72A4C21", hash_generated_method = "A86071B5C9C251CBAD340F1E17EC8E96")
    private static void native_addRoundRect(int nPath, RectF r,
                                                   float[] radii, int dir) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.292 -0400", hash_original_method = "500189098AFA3363D9C29A83C9D9AC3F", hash_generated_method = "AEF82EF0E4167A6511686E4A6A22D0AB")
    private static void native_addPath(int nPath, int src, float dx,
                                              float dy) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.292 -0400", hash_original_method = "436CCCCD39651D6A2BB1E0E3AC5B284C", hash_generated_method = "72F9934C4F55B307E0ED4BEAA755CDD1")
    private static void native_addPath(int nPath, int src) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.292 -0400", hash_original_method = "123EC003B5C2E945F5D1FFC808E5DB1D", hash_generated_method = "363EAB27D4185AC8C4C6E32BBB73DA42")
    private static void native_addPath(int nPath, int src, int matrix) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.293 -0400", hash_original_method = "947CB59775BFA76649CCA2484E8F6C1A", hash_generated_method = "115DB953F77E9B7702268E631E6D7F06")
    private static void native_offset(int nPath, float dx, float dy,
                                             int dst_path) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.293 -0400", hash_original_method = "E7D9EB756152860817C22AF8D5C63289", hash_generated_method = "608A2C43758831D53733F92ED0C7CEA2")
    private static void native_offset(int nPath, float dx, float dy) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.293 -0400", hash_original_method = "9598ABB5EFE8C7E38D442882F0F93C6C", hash_generated_method = "0BC5072352A295A2BFD55C5924B6F8BA")
    private static void native_setLastPoint(int nPath, float dx, float dy) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.293 -0400", hash_original_method = "BDA8ABA90F01D5DEDF473822199298D0", hash_generated_method = "7F69463E12843429757A743C71F7E99D")
    private static void native_transform(int nPath, int matrix,
                                                int dst_path) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.293 -0400", hash_original_method = "BE05CC6725DE82A9F415575149058805", hash_generated_method = "E2CDD900EF1909B4417C451762DB0F48")
    private static void native_transform(int nPath, int matrix) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.293 -0400", hash_original_method = "45ED4FF1D1D1335AAFC23BB777B809DA", hash_generated_method = "92D42606442ACFE97F0B492596267C6D")
    private static void finalizer(int nPath) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
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

    
}


