package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.HardwareRenderer;

public class Path {
    public int mNativePath;
    public boolean isSimplePath = true;
    public Region rects;
    private boolean mDetectSimplePaths;
    private Direction mLastDirection = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.465 -0400", hash_original_method = "E55892E9E32EE58ABA689C884DCC620A", hash_generated_method = "2516288491884B0595FC4CFC8A04A2E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Path() {
        mNativePath = init1();
        mDetectSimplePaths = HardwareRenderer.isAvailable();
        // ---------- Original Method ----------
        //mNativePath = init1();
        //mDetectSimplePaths = HardwareRenderer.isAvailable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.466 -0400", hash_original_method = "75D205ED700EB535C654F75061722DB2", hash_generated_method = "BC4F34E80FA014D09C402CCA6D2A06D7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.467 -0400", hash_original_method = "2D6F810980DCFBBC547D7B9A11965950", hash_generated_method = "0D44BA305E11BD4751D9F5AD2F2C8B26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.468 -0400", hash_original_method = "3CA9EEECBF523F762771968CCD0E129D", hash_generated_method = "566028D65C7E94ED7A9BA3A11E5BB664")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.469 -0400", hash_original_method = "B685542335E97A84BA9D0A3AD0CEB866", hash_generated_method = "D3203B2401F3FAA9D448F06FF12886E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.469 -0400", hash_original_method = "756CBBEFC8F729432A1EDFB10FC9B142", hash_generated_method = "6ABA028F6F113B6E66FBA34CD58641D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FillType getFillType() {
        FillType var46169E7DE3649425DA22AE0366B45799_812846006 = (sFillTypeArray[native_getFillType(mNativePath)]);
        return (FillType)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sFillTypeArray[native_getFillType(mNativePath)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.469 -0400", hash_original_method = "5E380303FA17349F493701662250C5C9", hash_generated_method = "C2971D92D4126A2C7732C4AA5704879D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFillType(FillType ft) {
        dsTaint.addTaint(ft.dsTaint);
        native_setFillType(mNativePath, ft.nativeInt);
        // ---------- Original Method ----------
        //native_setFillType(mNativePath, ft.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.470 -0400", hash_original_method = "659A2CB8B4863836C5C292B196F32903", hash_generated_method = "6925010E7DB0F25B08EAB072A03F63D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInverseFillType() {
        int ft;
        ft = native_getFillType(mNativePath);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int ft = native_getFillType(mNativePath);
        //return (ft & 2) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.470 -0400", hash_original_method = "B0C8497AF8D8E800E41ED12D1C4B68D2", hash_generated_method = "7C0447712C2235237223BE945F9B8BFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.470 -0400", hash_original_method = "7418BC5D1CF727D38A2258A36F4B5C15", hash_generated_method = "C99EB6FF332DA20E19A9B60155C65DD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var522B462A5C17E5E49A401CABA795A0BC_100279431 = (native_isEmpty(mNativePath));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_isEmpty(mNativePath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.471 -0400", hash_original_method = "B84E7088610242E6493E719E7ABEF1E6", hash_generated_method = "70391D59F7106BBC1371098002D68558")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isRect(RectF rect) {
        dsTaint.addTaint(rect.dsTaint);
        boolean varAA53C40F0A5EA7379B3BEE35A1C7F0DA_1169845642 = (native_isRect(mNativePath, rect));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_isRect(mNativePath, rect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.471 -0400", hash_original_method = "72B50A956CBF7B7731470BDB2A5220D2", hash_generated_method = "943087A140F9D9B198684C0F134B5656")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"UnusedDeclaration"})
    public void computeBounds(RectF bounds, boolean exact) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(exact);
        native_computeBounds(mNativePath, bounds);
        // ---------- Original Method ----------
        //native_computeBounds(mNativePath, bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.471 -0400", hash_original_method = "29BD172EB2F3A7AF9AFA9275279C4F54", hash_generated_method = "CBAA4A20C6B1A53636CCB21E4750F884")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void incReserve(int extraPtCount) {
        dsTaint.addTaint(extraPtCount);
        native_incReserve(mNativePath, extraPtCount);
        // ---------- Original Method ----------
        //native_incReserve(mNativePath, extraPtCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.471 -0400", hash_original_method = "732AD0D6CB11A9ADE203372D23E48872", hash_generated_method = "8B8EF8A60FCA5D327E831F1DA9BBFE0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void moveTo(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        native_moveTo(mNativePath, x, y);
        // ---------- Original Method ----------
        //native_moveTo(mNativePath, x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.472 -0400", hash_original_method = "0933141A2BB19D63525BF81BE900CD97", hash_generated_method = "B7DB9167C3C999FDA798BD77DF96BBB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rMoveTo(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        native_rMoveTo(mNativePath, dx, dy);
        // ---------- Original Method ----------
        //native_rMoveTo(mNativePath, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.472 -0400", hash_original_method = "58E5C3E4C7F046934AC91F8FDFBACD2C", hash_generated_method = "A673678FA81032B4A478033C6DA62D1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void lineTo(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        isSimplePath = false;
        native_lineTo(mNativePath, x, y);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_lineTo(mNativePath, x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.472 -0400", hash_original_method = "745591040780C0D8C5D54F59927D5E79", hash_generated_method = "006D27B345F6DA7E80DC36880E24B50C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rLineTo(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        isSimplePath = false;
        native_rLineTo(mNativePath, dx, dy);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_rLineTo(mNativePath, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.472 -0400", hash_original_method = "CDE92CD41872F87599E772CCBEB9168F", hash_generated_method = "FF433C7F721895449C59D2175D87F67A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.473 -0400", hash_original_method = "F0FFAC3AAFD6A3822EB31C31A758C054", hash_generated_method = "2BC2F5E475BE0BC5B3E5D49AA0A72749")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rQuadTo(float dx1, float dy1, float dx2, float dy2) {
        dsTaint.addTaint(dx1);
        dsTaint.addTaint(dx2);
        dsTaint.addTaint(dy1);
        dsTaint.addTaint(dy2);
        isSimplePath = false;
        native_rQuadTo(mNativePath, dx1, dy1, dx2, dy2);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_rQuadTo(mNativePath, dx1, dy1, dx2, dy2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.473 -0400", hash_original_method = "680DEAF903653AA5E9334EFF44E1FB26", hash_generated_method = "4B6ED7DC1CDADF3594562D3EA6D79103")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.473 -0400", hash_original_method = "7CE3D84B1219A8E32E8697E9D54626ED", hash_generated_method = "5A2D58B99E6E86BE8C9AFF411FCAFDDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.474 -0400", hash_original_method = "FF1AA715D5A76F97289F9771795F5B75", hash_generated_method = "F61A3FF637628261E93D304D29DA4DB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.474 -0400", hash_original_method = "48B980B599EE39F47888B8590B0311CC", hash_generated_method = "550AF6ADE425F51A7A7CA8CA858D647A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.474 -0400", hash_original_method = "E16C5D29E703AEBAB6CAF17A68A08F6B", hash_generated_method = "34D9621BE529F6E4B1748728F71F3FA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        isSimplePath = false;
        native_close(mNativePath);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_close(mNativePath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.475 -0400", hash_original_method = "4C4C77916FAC7E47D84337BC4A27AFDA", hash_generated_method = "A4693EDCCD8287848FDF91C143B224E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.475 -0400", hash_original_method = "4612527F52EC9CC57646B58789A81A83", hash_generated_method = "F8E833F1B1D853097E5E6CA34CF591C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addRect(RectF rect, Direction dir) {
        dsTaint.addTaint(dir.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("need rect parameter");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.475 -0400", hash_original_method = "B728DA55BB20CAF41F04A8721ACC9EB9", hash_generated_method = "6693A61159A7F780C7F905959AE2AF0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.475 -0400", hash_original_method = "A39723146C675E0E04F715D6E89297CC", hash_generated_method = "346B750DB549A7713F7C35A53C9D0DF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addOval(RectF oval, Direction dir) {
        dsTaint.addTaint(dir.dsTaint);
        dsTaint.addTaint(oval.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("need oval parameter");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.476 -0400", hash_original_method = "7256751168A905EF802B1EFF88D64306", hash_generated_method = "AEDA14893440F5EF948B12F4D7FA395F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.476 -0400", hash_original_method = "BDC1F894C327354FF6BC9BE2A0106898", hash_generated_method = "109AABFD94D0C4F3BD2D9854101A6E34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addArc(RectF oval, float startAngle, float sweepAngle) {
        dsTaint.addTaint(startAngle);
        dsTaint.addTaint(sweepAngle);
        dsTaint.addTaint(oval.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("need oval parameter");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.477 -0400", hash_original_method = "3ECD815B6409768DB15813B06CD42DD5", hash_generated_method = "2E0E9E2A9085ABDCAA57186D6040C9FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addRoundRect(RectF rect, float rx, float ry, Direction dir) {
        dsTaint.addTaint(dir.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        dsTaint.addTaint(rx);
        dsTaint.addTaint(ry);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("need rect parameter");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.477 -0400", hash_original_method = "543113738AC73676270E7FCF210EDB1F", hash_generated_method = "85F762CF9C91FF2AAE455EC9262C75D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addRoundRect(RectF rect, float[] radii, Direction dir) {
        dsTaint.addTaint(dir.dsTaint);
        dsTaint.addTaint(radii[0]);
        dsTaint.addTaint(rect.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("need rect parameter");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.477 -0400", hash_original_method = "E4CA114D3203375891711738ECF0A722", hash_generated_method = "2A76E207BADC557E6D3045B2E7090BAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.478 -0400", hash_original_method = "543B497D09485FEEC00989CA21E8A572", hash_generated_method = "A91EC53CC8DEF0D8A815D892268612BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addPath(Path src) {
        dsTaint.addTaint(src.dsTaint);
        isSimplePath = false;
        native_addPath(mNativePath, src.mNativePath);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_addPath(mNativePath, src.mNativePath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.478 -0400", hash_original_method = "D7DB7FC66FA71E8C80EBAD3AE821E2C4", hash_generated_method = "53A1E3EA9BB6B6DC175B349ACBD06301")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addPath(Path src, Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        isSimplePath = false;
        native_addPath(mNativePath, src.mNativePath, matrix.native_instance);
        // ---------- Original Method ----------
        //if (!src.isSimplePath) isSimplePath = false;
        //native_addPath(mNativePath, src.mNativePath, matrix.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.478 -0400", hash_original_method = "300271373C98AD70F0D1DFEC9CC1821E", hash_generated_method = "CF1D8C158F6E0EE4C229A23CD6AF02F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.479 -0400", hash_original_method = "84AAB7006BE97BBDBF66CEB78BE6403B", hash_generated_method = "944882BCF57F565065C3AA96DDF40602")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void offset(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        native_offset(mNativePath, dx, dy);
        // ---------- Original Method ----------
        //native_offset(mNativePath, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.479 -0400", hash_original_method = "DE0F6A19984A9351DC908B14944CEA04", hash_generated_method = "A06EFD2F8ADAE7DD14650983B464F48C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLastPoint(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        isSimplePath = false;
        native_setLastPoint(mNativePath, dx, dy);
        // ---------- Original Method ----------
        //isSimplePath = false;
        //native_setLastPoint(mNativePath, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.479 -0400", hash_original_method = "C6EADCEB56E45A061E81B3D824529855", hash_generated_method = "D0DE28439E677054BB1DE59680CFC97B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.480 -0400", hash_original_method = "E2E9E79308A321DB0305128A17F8E66B", hash_generated_method = "B175438167AE6280B34C20046F63299C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void transform(Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        native_transform(mNativePath, matrix.native_instance);
        // ---------- Original Method ----------
        //native_transform(mNativePath, matrix.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.480 -0400", hash_original_method = "F7200B02D28E5C321C9E159FC014E915", hash_generated_method = "B63DF27303A34F6912C29DAE9DF797C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.480 -0400", hash_original_method = "A7A62D46D1AC389C59E8D1EF0EC6AB35", hash_generated_method = "2EACA381393CC55056239B734BDB6276")
    @DSModeled(DSC.SAFE)
    final int ni() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNativePath;
    }

    
        private static int init1() {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int init2(int nPath) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void native_reset(int nPath) {
    }

    
        private static void native_rewind(int nPath) {
    }

    
        private static void native_set(int native_dst, int native_src) {
    }

    
        private static int native_getFillType(int nPath) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void native_setFillType(int nPath, int ft) {
    }

    
        private static boolean native_isEmpty(int nPath) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_isRect(int nPath, RectF rect) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void native_computeBounds(int nPath, RectF bounds) {
    }

    
        private static void native_incReserve(int nPath, int extraPtCount) {
    }

    
        private static void native_moveTo(int nPath, float x, float y) {
    }

    
        private static void native_rMoveTo(int nPath, float dx, float dy) {
    }

    
        private static void native_lineTo(int nPath, float x, float y) {
    }

    
        private static void native_rLineTo(int nPath, float dx, float dy) {
    }

    
        private static void native_quadTo(int nPath, float x1, float y1,
                                             float x2, float y2) {
    }

    
        private static void native_rQuadTo(int nPath, float dx1, float dy1,
                                              float dx2, float dy2) {
    }

    
        private static void native_cubicTo(int nPath, float x1, float y1,
                                        float x2, float y2, float x3, float y3) {
    }

    
        private static void native_rCubicTo(int nPath, float x1, float y1,
                                        float x2, float y2, float x3, float y3) {
    }

    
        private static void native_arcTo(int nPath, RectF oval,
                    float startAngle, float sweepAngle, boolean forceMoveTo) {
    }

    
        private static void native_close(int nPath) {
    }

    
        private static void native_addRect(int nPath, RectF rect, int dir) {
    }

    
        private static void native_addRect(int nPath, float left, float top,
                                            float right, float bottom, int dir) {
    }

    
        private static void native_addOval(int nPath, RectF oval, int dir) {
    }

    
        private static void native_addCircle(int nPath, float x, float y,
                                                float radius, int dir) {
    }

    
        private static void native_addArc(int nPath, RectF oval,
                                            float startAngle, float sweepAngle) {
    }

    
        private static void native_addRoundRect(int nPath, RectF rect,
                                                   float rx, float ry, int dir) {
    }

    
        private static void native_addRoundRect(int nPath, RectF r,
                                                   float[] radii, int dir) {
    }

    
        private static void native_addPath(int nPath, int src, float dx,
                                              float dy) {
    }

    
        private static void native_addPath(int nPath, int src) {
    }

    
        private static void native_addPath(int nPath, int src, int matrix) {
    }

    
        private static void native_offset(int nPath, float dx, float dy,
                                             int dst_path) {
    }

    
        private static void native_offset(int nPath, float dx, float dy) {
    }

    
        private static void native_setLastPoint(int nPath, float dx, float dy) {
    }

    
        private static void native_transform(int nPath, int matrix,
                                                int dst_path) {
    }

    
        private static void native_transform(int nPath, int matrix) {
    }

    
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

    
    static final FillType[] sFillTypeArray = {
        FillType.WINDING,
        FillType.EVEN_ODD,
        FillType.INVERSE_WINDING,
        FillType.INVERSE_EVEN_ODD
    };
}

