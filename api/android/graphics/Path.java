package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




import droidsafe.helpers.DSUtils;

public class Path {

    
    @DSModeled(DSC.SAFE)
    private static int init1() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1576785566 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1576785566;
    }

    
    @DSModeled(DSC.SAFE)
    private static int init2(int nPath) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_107083419 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_107083419;
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
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1765210493 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1765210493;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setFillType(int nPath, int ft) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_isEmpty(int nPath) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1520183094 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1520183094;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_isRect(int nPath, RectF rect) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682948170 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_682948170;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.121 -0500", hash_original_field = "A65348C57F03ABAAC20448834387B31A", hash_generated_field = "66C300B8D77E06A5BCE8FE4DD0DAFB70")

    static final FillType[] sFillTypeArray = {
        FillType.WINDING,
        FillType.EVEN_ODD,
        FillType.INVERSE_WINDING,
        FillType.INVERSE_EVEN_ODD
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.110 -0500", hash_original_field = "1B6F9540A95D5C897A37F528CD0904C2", hash_generated_field = "A385DF57FCDF6BC40C36AC929278C06B")

    public  int mNativePath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.111 -0500", hash_original_field = "EEAC0D6319FA7D718A2ADB14BA9AF6C1", hash_generated_field = "250A69E67387663075BAE4FF6CF576D2")

    public boolean isSimplePath = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.112 -0500", hash_original_field = "8F7F7383DBE21363614E5BF9BE57AF8C", hash_generated_field = "407FA9D3A82E310B399E446D54E9EE3E")

    public Region rects;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.113 -0500", hash_original_field = "EA07C8DE704216A3D92C4D7BF18F06E9", hash_generated_field = "06EEE85B84C90F2AA9425935FBA31565")

    private boolean mDetectSimplePaths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.113 -0500", hash_original_field = "F85FC01A2563127428192B9A55D83A45", hash_generated_field = "DC756050863566DEECE2CF58DA95FC7C")

    private Direction mLastDirection = null;
    
    @DSModeled(DSC.SAFE)
    public Path() {}

    
    @DSModeled(DSC.SAFE)
    public Path(Path src) {
        // src.mNativePath is passed through init2() and the result is stored
        // within this object's mNativePath.  init2 is a native call,
        // so I conseratively assume this object's mNativePath is tainted 
        // with src.mNativePath 
        addTaint(src.getTaint());
    }
    
    /**
     * Clear any lines and curves from the path, making it empty.
     * This does NOT change the fill-type setting.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.116 -0500", hash_original_method = "2D6F810980DCFBBC547D7B9A11965950", hash_generated_method = "832A9429C16C86298C91242E8C17B8AB")
    public void reset() {
        isSimplePath = true;
        if (mDetectSimplePaths) {
            mLastDirection = null;
            if (rects != null) rects.setEmpty();
        }
        native_reset(mNativePath);
    }

    /**
     * Rewinds the path: clears any lines and curves from the path but
     * keeps the internal data structure for faster reuse.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.117 -0500", hash_original_method = "3CA9EEECBF523F762771968CCD0E129D", hash_generated_method = "6A89F7BD8D9E3E6306E3DC771FBF4556")
    public void rewind() {
        isSimplePath = true;
        if (mDetectSimplePaths) {
            mLastDirection = null;
            if (rects != null) rects.setEmpty();
        }
        native_rewind(mNativePath);
    }

    /** Replace the contents of this with the contents of src.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.118 -0500", hash_original_method = "B685542335E97A84BA9D0A3AD0CEB866", hash_generated_method = "90F1B9EE81732DFF84414BAF401516D8")
    public void set(Path src) {
        if (this != src) {
            isSimplePath = src.isSimplePath;
            native_set(mNativePath, src.mNativePath);
        }
    }

    /**
     * Return the path's fill type. This defines how "inside" is
     * computed. The default value is WINDING.
     *
     * @return the path's fill type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.121 -0500", hash_original_method = "756CBBEFC8F729432A1EDFB10FC9B142", hash_generated_method = "3E1091E64E04D95BCD9FC7CCA880B267")
    public FillType getFillType() {
        return sFillTypeArray[native_getFillType(mNativePath)];
    }

    /**
     * Set the path's fill type. This defines how "inside" is computed.
     *
     * @param ft The new fill type for this path
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.122 -0500", hash_original_method = "5E380303FA17349F493701662250C5C9", hash_generated_method = "A82B4D2E18FDC69EB3998B22CCB8CB7D")
    public void setFillType(FillType ft) {
        native_setFillType(mNativePath, ft.nativeInt);
    }
    
    /**
     * Returns true if the filltype is one of the INVERSE variants
     *
     * @return true if the filltype is one of the INVERSE variants
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.123 -0500", hash_original_method = "659A2CB8B4863836C5C292B196F32903", hash_generated_method = "60472A76FE7A5B817C24F7714958844A")
    public boolean isInverseFillType() {
        final int ft = native_getFillType(mNativePath);
        return (ft & 2) != 0;
    }
    
    /**
     * Toggles the INVERSE state of the filltype
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.124 -0500", hash_original_method = "B0C8497AF8D8E800E41ED12D1C4B68D2", hash_generated_method = "01779E7563CC9D1C10FBB738A02AEB08")
    public void toggleInverseFillType() {
        int ft = native_getFillType(mNativePath);
        ft ^= 2;
        native_setFillType(mNativePath, ft);
    }
    
    /**
     * Returns true if the path is empty (contains no lines or curves)
     *
     * @return true if the path is empty (contains no lines or curves)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.124 -0500", hash_original_method = "7418BC5D1CF727D38A2258A36F4B5C15", hash_generated_method = "5E68F97A65859B3BEDCFD1D0A3F53164")
    public boolean isEmpty() {
        return native_isEmpty(mNativePath);
    }

    /**
     * Returns true if the path specifies a rectangle. If so, and if rect is
     * not null, set rect to the bounds of the path. If the path does not
     * specify a rectangle, return false and ignore rect.
     *
     * @param rect If not null, returns the bounds of the path if it specifies
     *             a rectangle
     * @return     true if the path specifies a rectangle
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.125 -0500", hash_original_method = "B84E7088610242E6493E719E7ABEF1E6", hash_generated_method = "A006FE7A8FF3CC1C6DAB8DB5F9C7CA0D")
    public boolean isRect(RectF rect) {
        return native_isRect(mNativePath, rect);
    }

    /**
     * Compute the bounds of the control points of the path, and write the
     * answer into bounds. If the path contains 0 or 1 points, the bounds is
     * set to (0,0,0,0)
     *
     * @param bounds Returns the computed bounds of the path's control points.
     * @param exact This parameter is no longer used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.126 -0500", hash_original_method = "72B50A956CBF7B7731470BDB2A5220D2", hash_generated_method = "4F97F0FA0FA474D4CCAFFDEF31355305")
    @SuppressWarnings({"UnusedDeclaration"})
public void computeBounds(RectF bounds, boolean exact) {
        native_computeBounds(mNativePath, bounds);
    }

    /**
     * Hint to the path to prepare for adding more points. This can allow the
     * path to more efficiently allocate its storage.
     *
     * @param extraPtCount The number of extra points that may be added to this
     *                     path
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.127 -0500", hash_original_method = "29BD172EB2F3A7AF9AFA9275279C4F54", hash_generated_method = "5043BC79422F095F0E841B1527CD7B1D")
    public void incReserve(int extraPtCount) {
        native_incReserve(mNativePath, extraPtCount);
    }

    /**
     * Set the beginning of the next contour to the point (x,y).
     *
     * @param x The x-coordinate of the start of a new contour
     * @param y The y-coordinate of the start of a new contour
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.128 -0500", hash_original_method = "732AD0D6CB11A9ADE203372D23E48872", hash_generated_method = "D02CEE4CBF36DAA6F8F680D2D5C12B04")
    public void moveTo(float x, float y) {
        native_moveTo(mNativePath, x, y);
    }

    /**
     * Set the beginning of the next contour relative to the last point on the
     * previous contour. If there is no previous contour, this is treated the
     * same as moveTo().
     *
     * @param dx The amount to add to the x-coordinate of the end of the
     *           previous contour, to specify the start of a new contour
     * @param dy The amount to add to the y-coordinate of the end of the
     *           previous contour, to specify the start of a new contour
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.128 -0500", hash_original_method = "0933141A2BB19D63525BF81BE900CD97", hash_generated_method = "7DAF1A7203D408BDFAB1D871ECB1CE25")
    public void rMoveTo(float dx, float dy) {
        native_rMoveTo(mNativePath, dx, dy);
    }

    /**
     * Add a line from the last point to the specified point (x,y).
     * If no moveTo() call has been made for this contour, the first point is
     * automatically set to (0,0).
     *
     * @param x The x-coordinate of the end of a line
     * @param y The y-coordinate of the end of a line
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.129 -0500", hash_original_method = "58E5C3E4C7F046934AC91F8FDFBACD2C", hash_generated_method = "E0070DBC57868727B629F1FD39E2DF76")
    public void lineTo(float x, float y) {
        isSimplePath = false;
        native_lineTo(mNativePath, x, y);
    }

    /**
     * Same as lineTo, but the coordinates are considered relative to the last
     * point on this contour. If there is no previous point, then a moveTo(0,0)
     * is inserted automatically.
     *
     * @param dx The amount to add to the x-coordinate of the previous point on
     *           this contour, to specify a line
     * @param dy The amount to add to the y-coordinate of the previous point on
     *           this contour, to specify a line
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.130 -0500", hash_original_method = "745591040780C0D8C5D54F59927D5E79", hash_generated_method = "8923EB396029333E94EFB164EAB0AD22")
    public void rLineTo(float dx, float dy) {
        isSimplePath = false;
        native_rLineTo(mNativePath, dx, dy);
    }

    /**
     * Add a quadratic bezier from the last point, approaching control point
     * (x1,y1), and ending at (x2,y2). If no moveTo() call has been made for
     * this contour, the first point is automatically set to (0,0).
     *
     * @param x1 The x-coordinate of the control point on a quadratic curve
     * @param y1 The y-coordinate of the control point on a quadratic curve
     * @param x2 The x-coordinate of the end point on a quadratic curve
     * @param y2 The y-coordinate of the end point on a quadratic curve
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.131 -0500", hash_original_method = "CDE92CD41872F87599E772CCBEB9168F", hash_generated_method = "09F656BFFACAFEDB59C6BC615878B4BD")
    public void quadTo(float x1, float y1, float x2, float y2) {
        isSimplePath = false;
        native_quadTo(mNativePath, x1, y1, x2, y2);
    }

    /**
     * Same as quadTo, but the coordinates are considered relative to the last
     * point on this contour. If there is no previous point, then a moveTo(0,0)
     * is inserted automatically.
     *
     * @param dx1 The amount to add to the x-coordinate of the last point on
     *            this contour, for the control point of a quadratic curve
     * @param dy1 The amount to add to the y-coordinate of the last point on
     *            this contour, for the control point of a quadratic curve
     * @param dx2 The amount to add to the x-coordinate of the last point on
     *            this contour, for the end point of a quadratic curve
     * @param dy2 The amount to add to the y-coordinate of the last point on
     *            this contour, for the end point of a quadratic curve
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.132 -0500", hash_original_method = "F0FFAC3AAFD6A3822EB31C31A758C054", hash_generated_method = "03C4A0708CB33033E5F38754F3D2D335")
    public void rQuadTo(float dx1, float dy1, float dx2, float dy2) {
        isSimplePath = false;
        native_rQuadTo(mNativePath, dx1, dy1, dx2, dy2);
    }

    /**
     * Add a cubic bezier from the last point, approaching control points
     * (x1,y1) and (x2,y2), and ending at (x3,y3). If no moveTo() call has been
     * made for this contour, the first point is automatically set to (0,0).
     *
     * @param x1 The x-coordinate of the 1st control point on a cubic curve
     * @param y1 The y-coordinate of the 1st control point on a cubic curve
     * @param x2 The x-coordinate of the 2nd control point on a cubic curve
     * @param y2 The y-coordinate of the 2nd control point on a cubic curve
     * @param x3 The x-coordinate of the end point on a cubic curve
     * @param y3 The y-coordinate of the end point on a cubic curve
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.132 -0500", hash_original_method = "680DEAF903653AA5E9334EFF44E1FB26", hash_generated_method = "4616CEC4A7D9ECDAB77031EC98E7681D")
    public void cubicTo(float x1, float y1, float x2, float y2,
                        float x3, float y3) {
        isSimplePath = false;
        native_cubicTo(mNativePath, x1, y1, x2, y2, x3, y3);
    }

    /**
     * Same as cubicTo, but the coordinates are considered relative to the
     * current point on this contour. If there is no previous point, then a
     * moveTo(0,0) is inserted automatically.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.133 -0500", hash_original_method = "7CE3D84B1219A8E32E8697E9D54626ED", hash_generated_method = "4C8EAB745486F94E97F40986CEE70D96")
    public void rCubicTo(float x1, float y1, float x2, float y2,
                         float x3, float y3) {
        isSimplePath = false;
        native_rCubicTo(mNativePath, x1, y1, x2, y2, x3, y3);
    }

    /**
     * Append the specified arc to the path as a new contour. If the start of
     * the path is different from the path's current last point, then an
     * automatic lineTo() is added to connect the current contour to the
     * start of the arc. However, if the path is empty, then we call moveTo()
     * with the first point of the arc. The sweep angle is tread mod 360.
     *
     * @param oval        The bounds of oval defining shape and size of the arc
     * @param startAngle  Starting angle (in degrees) where the arc begins
     * @param sweepAngle  Sweep angle (in degrees) measured clockwise, treated
     *                    mod 360.
     * @param forceMoveTo If true, always begin a new contour with the arc
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.134 -0500", hash_original_method = "FF1AA715D5A76F97289F9771795F5B75", hash_generated_method = "D13EA8B4571C88CE1520B97A33E45D38")
    public void arcTo(RectF oval, float startAngle, float sweepAngle,
                      boolean forceMoveTo) {
        isSimplePath = false;
        native_arcTo(mNativePath, oval, startAngle, sweepAngle, forceMoveTo);
    }

    
    @DSModeled(DSC.SAFE) 
    public void arcTo(RectF oval, float startAngle, float sweepAngle) {
        addTaint(oval.getTaint());
        addTaint(startAngle);
        addTaint(sweepAngle);
    }
    
    /**
     * Close the current contour. If the current point is not equal to the
     * first point of the contour, a line segment is automatically added.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.136 -0500", hash_original_method = "E16C5D29E703AEBAB6CAF17A68A08F6B", hash_generated_method = "9EB7EFD517B4F19AFC5BCF612FA2F8F9")
    public void close() {
        isSimplePath = false;
        native_close(mNativePath);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.139 -0500", hash_original_method = "4C4C77916FAC7E47D84337BC4A27AFDA", hash_generated_method = "0EF07D3D916DD25CFCB49A56E294B8A6")
    private void detectSimplePath(float left, float top, float right, float bottom, Direction dir) {
        if (mDetectSimplePaths) {
            if (mLastDirection == null) {
                mLastDirection = dir;
            }
            if (mLastDirection != dir) {
                isSimplePath = false;
            } else {
                if (rects == null) rects = new Region();
                rects.op((int) left, (int) top, (int) right, (int) bottom, Region.Op.UNION);
            }
        }
    }

    /**
     * Add a closed rectangle contour to the path
     *
     * @param rect The rectangle to add as a closed contour to the path
     * @param dir  The direction to wind the rectangle's contour
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.140 -0500", hash_original_method = "4612527F52EC9CC57646B58789A81A83", hash_generated_method = "F3FCE6F0895DC0626F1A47B38DBC60AC")
    public void addRect(RectF rect, Direction dir) {
        if (rect == null) {
            throw new NullPointerException("need rect parameter");
        }
        detectSimplePath(rect.left, rect.top, rect.right, rect.bottom, dir);
        native_addRect(mNativePath, rect, dir.nativeInt);
    }

    /**
     * Add a closed rectangle contour to the path
     *
     * @param left   The left side of a rectangle to add to the path
     * @param top    The top of a rectangle to add to the path
     * @param right  The right side of a rectangle to add to the path
     * @param bottom The bottom of a rectangle to add to the path
     * @param dir    The direction to wind the rectangle's contour
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.141 -0500", hash_original_method = "B728DA55BB20CAF41F04A8721ACC9EB9", hash_generated_method = "0BA08D94C9C70E0F15187FE74361DB91")
    public void addRect(float left, float top, float right, float bottom, Direction dir) {
        detectSimplePath(left, top, right, bottom, dir);
        native_addRect(mNativePath, left, top, right, bottom, dir.nativeInt);
    }

    /**
     * Add a closed oval contour to the path
     *
     * @param oval The bounds of the oval to add as a closed contour to the path
     * @param dir  The direction to wind the oval's contour
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.142 -0500", hash_original_method = "A39723146C675E0E04F715D6E89297CC", hash_generated_method = "89EE2DA80B5178A23B90617E1CD2B725")
    public void addOval(RectF oval, Direction dir) {
        if (oval == null) {
            throw new NullPointerException("need oval parameter");
        }
        isSimplePath = false;
        native_addOval(mNativePath, oval, dir.nativeInt);
    }

    /**
     * Add a closed circle contour to the path
     *
     * @param x   The x-coordinate of the center of a circle to add to the path
     * @param y   The y-coordinate of the center of a circle to add to the path
     * @param radius The radius of a circle to add to the path
     * @param dir    The direction to wind the circle's contour
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.142 -0500", hash_original_method = "7256751168A905EF802B1EFF88D64306", hash_generated_method = "6684F3DAAD8CDC40AFAE4177FC4EA7E1")
    public void addCircle(float x, float y, float radius, Direction dir) {
        isSimplePath = false;
        native_addCircle(mNativePath, x, y, radius, dir.nativeInt);
    }

    /**
     * Add the specified arc to the path as a new contour.
     *
     * @param oval The bounds of oval defining the shape and size of the arc
     * @param startAngle Starting angle (in degrees) where the arc begins
     * @param sweepAngle Sweep angle (in degrees) measured clockwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.143 -0500", hash_original_method = "BDC1F894C327354FF6BC9BE2A0106898", hash_generated_method = "444ACD2D65C852D3BADAF2A2AC45FF05")
    public void addArc(RectF oval, float startAngle, float sweepAngle) {
        if (oval == null) {
            throw new NullPointerException("need oval parameter");
        }
        isSimplePath = false;
        native_addArc(mNativePath, oval, startAngle, sweepAngle);
    }

    /**
        * Add a closed round-rectangle contour to the path
     *
     * @param rect The bounds of a round-rectangle to add to the path
     * @param rx   The x-radius of the rounded corners on the round-rectangle
     * @param ry   The y-radius of the rounded corners on the round-rectangle
     * @param dir  The direction to wind the round-rectangle's contour
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.144 -0500", hash_original_method = "3ECD815B6409768DB15813B06CD42DD5", hash_generated_method = "CAD5522B69D979DEA8767B5667599229")
    public void addRoundRect(RectF rect, float rx, float ry, Direction dir) {
        if (rect == null) {
            throw new NullPointerException("need rect parameter");
        }
        isSimplePath = false;
        native_addRoundRect(mNativePath, rect, rx, ry, dir.nativeInt);
    }
    
    /**
     * Add a closed round-rectangle contour to the path. Each corner receives
     * two radius values [X, Y]. The corners are ordered top-left, top-right,
     * bottom-right, bottom-left
     *
     * @param rect The bounds of a round-rectangle to add to the path
     * @param radii Array of 8 values, 4 pairs of [X,Y] radii
     * @param dir  The direction to wind the round-rectangle's contour
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.145 -0500", hash_original_method = "543113738AC73676270E7FCF210EDB1F", hash_generated_method = "A7851546E4E62DD9E4A187AF2279F6AD")
    public void addRoundRect(RectF rect, float[] radii, Direction dir) {
        if (rect == null) {
            throw new NullPointerException("need rect parameter");
        }
        if (radii.length < 8) {
            throw new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
        }
        isSimplePath = false;
        native_addRoundRect(mNativePath, rect, radii, dir.nativeInt);
    }
    
    /**
     * Add a copy of src to the path, offset by (dx,dy)
     *
     * @param src The path to add as a new contour
     * @param dx  The amount to translate the path in X as it is added
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.146 -0500", hash_original_method = "E4CA114D3203375891711738ECF0A722", hash_generated_method = "F8EFAE91A5ADEB3557D34652D034011A")
    public void addPath(Path src, float dx, float dy) {
        isSimplePath = false;
        native_addPath(mNativePath, src.mNativePath, dx, dy);
    }

    /**
     * Add a copy of src to the path
     *
     * @param src The path that is appended to the current path
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.146 -0500", hash_original_method = "543B497D09485FEEC00989CA21E8A572", hash_generated_method = "B72D4F9A3995594F75166AE308C9AC75")
    public void addPath(Path src) {
        isSimplePath = false;
        native_addPath(mNativePath, src.mNativePath);
    }

    /**
     * Add a copy of src to the path, transformed by matrix
     *
     * @param src The path to add as a new contour
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.147 -0500", hash_original_method = "D7DB7FC66FA71E8C80EBAD3AE821E2C4", hash_generated_method = "08D1602981A2361A8F6F6CAB7B54DF83")
    public void addPath(Path src, Matrix matrix) {
        if (!src.isSimplePath) isSimplePath = false;
        native_addPath(mNativePath, src.mNativePath, matrix.native_instance);
    }

    /**
     * Offset the path by (dx,dy), returning true on success
     *
     * @param dx  The amount in the X direction to offset the entire path
     * @param dy  The amount in the Y direction to offset the entire path
     * @param dst The translated path is written here. If this is null, then
     *            the original path is modified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.148 -0500", hash_original_method = "300271373C98AD70F0D1DFEC9CC1821E", hash_generated_method = "59165EC4A27D0BFC06FEA206895769A9")
    public void offset(float dx, float dy, Path dst) {
        int dstNative = 0;
        if (dst != null) {
            dstNative = dst.mNativePath;
        }
        native_offset(mNativePath, dx, dy, dstNative);
    }

    /**
     * Offset the path by (dx,dy), returning true on success
     *
     * @param dx The amount in the X direction to offset the entire path
     * @param dy The amount in the Y direction to offset the entire path
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.149 -0500", hash_original_method = "84AAB7006BE97BBDBF66CEB78BE6403B", hash_generated_method = "3C20BC051E9D2FCD151EE798638265AC")
    public void offset(float dx, float dy) {
        native_offset(mNativePath, dx, dy);
    }

    /**
     * Sets the last point of the path.
     *
     * @param dx The new X coordinate for the last point
     * @param dy The new Y coordinate for the last point
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.149 -0500", hash_original_method = "DE0F6A19984A9351DC908B14944CEA04", hash_generated_method = "24EFCFC7818241CE2618509261F697F1")
    public void setLastPoint(float dx, float dy) {
        isSimplePath = false;
        native_setLastPoint(mNativePath, dx, dy);
    }

    /**
     * Transform the points in this path by matrix, and write the answer
     * into dst. If dst is null, then the the original path is modified.
     *
     * @param matrix The matrix to apply to the path
     * @param dst    The transformed path is written here. If dst is null,
     *               then the the original path is modified
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.150 -0500", hash_original_method = "C6EADCEB56E45A061E81B3D824529855", hash_generated_method = "155AEFF2297093F3595BC74B1CF28D38")
    public void transform(Matrix matrix, Path dst) {
        int dstNative = 0;
        if (dst != null) {
            dstNative = dst.mNativePath;
        }
        native_transform(mNativePath, matrix.native_instance, dstNative);
    }

    /**
     * Transform the points in this path by matrix.
     *
     * @param matrix The matrix to apply to the path
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.152 -0500", hash_original_method = "E2E9E79308A321DB0305128A17F8E66B", hash_generated_method = "AA19067AA7A96EBCD61A9CD10B053F4E")
    public void transform(Matrix matrix) {
        native_transform(mNativePath, matrix.native_instance);
    }

    
    @DSModeled(DSC.SAFE)
    protected void finalize() {}

    
    public enum FillType {
        WINDING         (0),
        EVEN_ODD        (1),
        INVERSE_WINDING (2),
        INVERSE_EVEN_ODD(3);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.119 -0500", hash_original_method = "48CD3FC81E60C7E4434D9510482F9260", hash_generated_method = "48CD3FC81E60C7E4434D9510482F9260")
            FillType(int ni) {
            nativeInt = ni;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.119 -0500", hash_original_field = "6B116C6445FBD920A2653C64D32C9FB3", hash_generated_field = "6B116C6445FBD920A2653C64D32C9FB3")

         int nativeInt;
    }

    
    public enum Direction {
        CW  (0),    
        CCW (1);    // must match enum in SkPath.h
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.137 -0500", hash_original_method = "F6E651FD95F84CA8616E346E7FF3747C", hash_generated_method = "F6E651FD95F84CA8616E346E7FF3747C")
            Direction(int ni) {
            nativeInt = ni;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:50.137 -0500", hash_original_field = "6B116C6445FBD920A2653C64D32C9FB3", hash_generated_field = "6B116C6445FBD920A2653C64D32C9FB3")

         int nativeInt;
    }

    
    @DSModeled(DSC.SAFE)
    final int ni() {
        return getTaintInt(); 
    }
}

