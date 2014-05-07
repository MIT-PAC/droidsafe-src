package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

import droidsafe.helpers.DSUtils;

public class Region implements Parcelable {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeEquals(int native_r1, int native_r2) {
        return toTaintBoolean((native_r1 + native_r2));
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeConstructor() {
        return DSUtils.UNKNOWN_INT;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeDestructor(int native_region) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeSetRegion(int native_dst,
                                                  int native_src) {
        return toTaintBoolean((native_dst + native_src));
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeSetRect(int native_dst, int left,
                                                int top, int right, int bottom) {
        return toTaintBoolean((native_dst + left + top + right + bottom));
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeSetPath(int native_dst, int native_path,
                                                int native_clip) {
        return toTaintBoolean((native_dst + native_path + native_clip));
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeGetBounds(int native_region, Rect rect) {
        return toTaintBoolean((native_region + rect.getTaintInt()));
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeGetBoundaryPath(int native_region,
                                                        int native_path) {
        return toTaintBoolean((native_region + native_path));
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeOp(int native_dst, int left, int top,
                                           int right, int bottom, int op) {
        return toTaintBoolean((native_dst + left + top + right + bottom + op));
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeOp(int native_dst, Rect rect,
                                           int native_region, int op) {
        return toTaintBoolean((native_dst + rect.getTaintInt() + native_region + op));
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeOp(int native_dst, int native_region1,
                                           int native_region2, int op) {
        return toTaintBoolean((native_dst + native_region1 + native_region2 + op));
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeCreateFromParcel(Parcel p) {
        return p.getTaintInt();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeWriteToParcel(int native_region,
                                                      Parcel p) {
        p.addTaint(native_region);
        return p.getTaintBoolean();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String nativeToString(int native_region) {
        	return ""; 
        }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.106 -0400", hash_original_field = "50CCBBF498983066FB87505BC8EF122F", hash_generated_field = "200FB204FCAF60B88F8DADAA8213325E")

    public static final Parcelable.Creator<Region> CREATOR
        = new Parcelable.Creator<Region>() {
            /**
            * Rebuild a Region previously stored with writeToParcel().
             * @param p    Parcel object to read the region from
             * @return a new region created from the data in the parcel
             */
            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.281 -0500", hash_original_method = "57FADA8DB6AE415E8D7938E17AD42A96", hash_generated_method = "23AC31C1150E253AA6670C5491C86B02")
        
public Region createFromParcel(Parcel p) {
                int ni = nativeCreateFromParcel(p);
                if (ni == 0) {
                    throw new RuntimeException();
                }
                return new Region(ni);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.284 -0500", hash_original_method = "CEFFB067794D43B67239BC68D4FB216A", hash_generated_method = "E85D661CD017FA828B9DA564DAC5F8B5")
        
public Region[] newArray(int size) {
                return new Region[size];
            }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.184 -0500", hash_original_field = "482A3AC7F719782C43F3E5E0FCAEDE91", hash_generated_field = "BE18D4475688FDC46F0A31DE4104CC38")

    public  int mNativeRegion;

    /** Create an empty region
    */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.193 -0500", hash_original_method = "0D8BB79D644235D834A5B870E7DE5E55", hash_generated_method = "26CF2A3DDBA2B25D750180E7A5D924AA")
    
public Region() {
        //this(nativeConstructor());
    }

    /** Return a copy of the specified region
    */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.196 -0500", hash_original_method = "ADA47703EEBAAF081A921E3B439FC136", hash_generated_method = "A5B59A910014976676BF2030660D4E57")
    
public Region(Region region) {
        //this(nativeConstructor());
        //nativeSetRegion(mNativeRegion, region.mNativeRegion);
    }

    /** Return a region set to the specified rectangle
    */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.198 -0500", hash_original_method = "A1BEE89A791B5892C0419D31229063CC", hash_generated_method = "EB9B16E8EFD92A7622854E0DAA174898")
    
public Region(Rect r) {
        //mNativeRegion = nativeConstructor();
        //nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
        addTaintLocal(r.getTaintInt());
    }

    /** Return a region set to the specified rectangle
    */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.201 -0500", hash_original_method = "3B1EBFADD13882DEC7CB8A7DB9BB782B", hash_generated_method = "83AE03E01797E3C3432BDFB8207BCAEF")
    
public Region(int left, int top, int right, int bottom) {
        //mNativeRegion = nativeConstructor();
        //nativeSetRect(mNativeRegion, left, top, right, bottom);
        addTaintLocal(left + right + bottom + top);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.299 -0500", hash_original_method = "AE1199122B801919FCCD86EFAEB8981E", hash_generated_method = "AE1199122B801919FCCD86EFAEB8981E")
    
Region(int ni) {
        
        /*
        if (ni == 0) {
            throw new RuntimeException();
        }
        */
        //mNativeRegion = ni;
        addTaintLocal(ni);
    }

    /* add dummy parameter so constructor can be called from jni without
       triggering 'not cloneable' exception */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.302 -0500", hash_original_method = "5B5253F8036AE411F7DD245C7F6E35C3", hash_generated_method = "437B56B8F299655728FD6424D860FFDE")
    
private Region(int ni, int dummy) {
        addTaintLocal(ni + dummy);
        //this(ni);
    }

    /** Set the region to the empty region
    */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.204 -0500", hash_original_method = "200ADD9307CCB536C203EAC015A5A024", hash_generated_method = "F60AD194CCD318D4A492AD3CEA5E1A55")
    
public void setEmpty() {
        //nativeSetRect(mNativeRegion, 0, 0, 0, 0);
    }

    /** Set the region to the specified region.
    */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.206 -0500", hash_original_method = "4FCDB3DC16FC27229A4383057FFC976C", hash_generated_method = "DF74DC22025304EEB4E1BBC240C829FA")
    
public boolean set(Region region) {
        //return nativeSetRegion(mNativeRegion, region.mNativeRegion);
        addTaintLocal(region.getTaintInt());
        return getTaintBoolean();
    }

    /** Set the region to the specified rectangle
    */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.208 -0500", hash_original_method = "C2513170875A2D5A2EB27E891206577A", hash_generated_method = "1EE701CCE5E602E8F86BFFEA5C6A52FA")
    
public boolean set(Rect r) {
        //return nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
        addTaintLocal(r.getTaintInt());
        return getTaintBoolean();
    }
    
    /** Set the region to the specified rectangle
    */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.210 -0500", hash_original_method = "D06421CD512172DCB28D2F3E0620053E", hash_generated_method = "A6370D0256D51227732DADCCC0838A83")
    
public boolean set(int left, int top, int right, int bottom) {
        addTaintLocal(left + right + top + bottom);
        return getTaintBoolean();
    }

    /**
     * Set the region to the area described by the path and clip.
     * Return true if the resulting region is non-empty. This produces a region
     * that is identical to the pixels that would be drawn by the path
     * (with no antialiasing).
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.212 -0500", hash_original_method = "E058C8FF714DCD6DC5C3B199CE291ABB", hash_generated_method = "0E8BAC49241220EF5972DCAD88426D86")
    
public boolean setPath(Path path, Region clip) {
        //return nativeSetPath(mNativeRegion, path.ni(), clip.mNativeRegion);
        addTaintLocal(path.getTaintInt() + clip.getTaintInt());
        return getTaintBoolean();
    }

    /**
     * Return true if this region is empty
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.216 -0500", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "9EFBA24431943EE0CA752566A6372B65")
    
    public boolean isEmpty(){
    	//Formerly a native method
    	return getTaintBoolean();
    }
    
    /**
     * Return true if the region contains a single rectangle
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.220 -0500", hash_original_method = "2BE881D6CE1CF3506EFB49B5287B67D4", hash_generated_method = "C33BBD7A1E4F2540D9F79FE41B5DB121")
    
    public boolean isRect(){
    	//Formerly a native method
    	return getTaintBoolean();
    }
    
    /**
     * Return true if the region contains more than one rectangle
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.223 -0500", hash_original_method = "96E541304104A48A190119203B0E80D4", hash_generated_method = "6C553C9F8EC00B5D20E97AAC6D8FB38C")
    
    public boolean isComplex(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    /**
     * Return a new Rect set to the bounds of the region. If the region is
     * empty, the Rect will be set to [0, 0, 0, 0]
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.226 -0500", hash_original_method = "EBA477C7AF945181ADA3A9B8177742BE", hash_generated_method = "91F82C3A1BDD393CBC9AC4F6E285E45C")
    
public Rect getBounds() {
        Rect r = new Rect();
        //nativeGetBounds(mNativeRegion, r);
        r.addTaint(getTaintInt());
        r.describeContents();
        return r;
    }
    
    /**
     * Set the Rect to the bounds of the region. If the region is empty, the
     * Rect will be set to [0, 0, 0, 0]
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.229 -0500", hash_original_method = "A46555E1E49458678846473DF9E9883B", hash_generated_method = "072D6A525D010879C3ED1409F7063754")
    
public boolean getBounds(Rect r) {
        if (r == null) {
            throw new NullPointerException();
        }
        //return nativeGetBounds(mNativeRegion, r);
        r.scale(getTaintFloat());
        return r.getTaintBoolean();
    }

    /**
     * Return the boundary of the region as a new Path. If the region is empty,
     * the path will also be empty.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.231 -0500", hash_original_method = "378316FE7952FD732F90591AB3699DE2", hash_generated_method = "D31D11F12DD46AB8DDBF7582ACF4373A")
    
public Path getBoundaryPath() {
        Path path = new Path();
        //nativeGetBoundaryPath(mNativeRegion, path.ni());
        path.addTaint(getTaint());
        return path;
    }

    /**
     * Set the path to the boundary of the region. If the region is empty, the
     * path will also be empty.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.233 -0500", hash_original_method = "4EAA9FC9D13D7E90DDD0EEB1CB6196B1", hash_generated_method = "8C0B92710855EFE0DA0BBF78C532F7A0")
    
public boolean getBoundaryPath(Path path) {
        path.addTaint(getTaint());
        return path.getTaintBoolean();
    }
        
    /**
     * Return true if the region contains the specified point
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.236 -0500", hash_original_method = "5B0A75408C2B4CF9238ADD529FC37D02", hash_generated_method = "A7115730B47BC9123607938D0003EDE3")
    
    public boolean contains(int x, int y){
    	//Formerly a native method
    	return toTaintBoolean(getTaintInt() + x + y);
    }

    /**
     * Return true if the region is a single rectangle (not complex) and it
     * contains the specified rectangle. Returning false is not a guarantee
     * that the rectangle is not contained by this region, but return true is a
     * guarantee that the rectangle is contained by this region.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.238 -0500", hash_original_method = "963E643D37666FF20B3A3B029F181389", hash_generated_method = "E5D3FDE45AA5BD19E1FD088D74ECF497")
    
public boolean quickContains(Rect r) {
        return toTaintBoolean(r.getTaintInt() + getTaintInt()) ;
    }

    /**
     * Return true if the region is a single rectangle (not complex) and it
     * contains the specified rectangle. Returning false is not a guarantee
     * that the rectangle is not contained by this region, but return true is a
     * guarantee that the rectangle is contained by this region.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.242 -0500", hash_original_method = "F4780612A05468EA5B4971365E65F2E9", hash_generated_method = "3CA9ECB8B6579E2ED02777D3C810F04C")
    
    public boolean quickContains(int left, int top, int right,
                                            int bottom){
    	//Formerly a native method
    	return toTaintBoolean(left + right + top + bottom + getTaintInt());
    }

    /**
     * Return true if the region is empty, or if the specified rectangle does
     * not intersect the region. Returning false is not a guarantee that they
     * intersect, but returning true is a guarantee that they do not.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.244 -0500", hash_original_method = "99713AAB8FDC91BA4FFF953154B93F70", hash_generated_method = "41CB867DCDD72D9ED89078F64DB12175")
    
public boolean quickReject(Rect r) {
        return toTaintBoolean(r.getTaintInt() + getTaintInt());
    }

    /**
     * Return true if the region is empty, or if the specified rectangle does
     * not intersect the region. Returning false is not a guarantee that they
     * intersect, but returning true is a guarantee that they do not.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.248 -0500", hash_original_method = "C7FE089D5B9638DFC662C69BB1CCA253", hash_generated_method = "F7F12532769C64CBD97E063872D24096")
    
    public boolean quickReject(int left, int top, int right, int bottom){
    	//Formerly a native method
        return toTaintBoolean(getTaintInt() + left + right + top + bottom);
    }

    /**
     * Return true if the region is empty, or if the specified region does not
     * intersect the region. Returning false is not a guarantee that they
     * intersect, but returning true is a guarantee that they do not.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.252 -0500", hash_original_method = "248FAC130B583135AFED72EC96EB473C", hash_generated_method = "3572170AA4F7EEAA69DBE4A77B77CFFC")
    
    public boolean quickReject(Region rgn){
    	//Formerly a native method
        return toTaintBoolean(rgn.getTaintInt() + getTaintInt());
    }

    /**
     * Translate the region by [dx, dy]. If the region is empty, do nothing.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.254 -0500", hash_original_method = "1E0220698FB1311F0D8B9F18E7495908", hash_generated_method = "45063F3EB3C0799C5F99D2526314B9C3")
    
public void translate(int dx, int dy) {
        translate(dx, dy, null);
    }

    /**
     * Set the dst region to the result of translating this region by [dx, dy].
     * If this region is empty, then dst will be set to empty.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.258 -0500", hash_original_method = "F2F101D23D8556E25BBA4D0A405F0CD3", hash_generated_method = "EE9270B7DA4BE02B4DA14C8FE019870C")
    
    public void translate(int dx, int dy, Region dst){
    	//Formerly a native method
    	addTaintLocal(dx);
    	addTaintLocal(dy);
    	if (dst != null)
    	    addTaintLocal(dst.getTaintInt());
    }

    /**
     * Scale the region by the given scale amount. This re-constructs new region by
     * scaling the rects that this region consists of. New rectis are computed by scaling 
     * coordinates by float, then rounded by roundf() function to integers. This may results
     * in less internal rects if 0 < scale < 1. Zero and Negative scale result in
     * an empty region. If this region is empty, do nothing.
     *
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.260 -0500", hash_original_method = "39111F1C858A6D228BD34A5A0563D24D", hash_generated_method = "BFEEB739496400E432F0DC548F518493")
    
public void scale(float scale) {
        scale(scale, null);
    }

    /**
     * Set the dst region to the result of scaling this region by the given scale amount.
     * If this region is empty, then dst will be set to empty.
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.263 -0500", hash_original_method = "704645B9B50E78F1B3F526FB095B5A0C", hash_generated_method = "D6E6AD9CBBC79DF1403EF93AA313E6B0")
    
    public void scale(float scale, Region dst){
    	//Formerly a native method
    	addTaintLocal(scale);
    	if (dst != null)
    	    addTaintLocal(dst.getTaintInt());
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.266 -0500", hash_original_method = "50F2C1285B4A35F7EE8C85CE7082EAF5", hash_generated_method = "CF4A9E8BED30B016B573CDE6F9A1F331")
    
public final boolean union(Rect r) {
        return op(r, Op.UNION);
    }

    /**
     * Perform the specified Op on this region and the specified rect. Return
     * true if the result of the op is not empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.268 -0500", hash_original_method = "0254EC2D8CB0B709656A3942F767CF9E", hash_generated_method = "0CB3F7FD91AEAB7C2CA4E8CE82749124")
    
public boolean op(Rect r, Op op) {
        addTaintLocal(r.getTaintInt() + op.nativeInt);
        return getTaintBoolean();
    }

    /**
     * Perform the specified Op on this region and the specified rect. Return
     * true if the result of the op is not empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.270 -0500", hash_original_method = "F7B19A9596841ACD8A98EA48656877B1", hash_generated_method = "79A6092D9718A068C6448484EC593839")
    
public boolean op(int left, int top, int right, int bottom, Op op) {
        addTaintLocal(left + right + top + bottom + op.nativeInt);
        return getTaintBoolean();
    }

    /**
     * Perform the specified Op on this region and the specified region. Return
     * true if the result of the op is not empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.272 -0500", hash_original_method = "7B6B61AB972DEFAAC29D5DA42EF8C210", hash_generated_method = "98EF1EEBE7B091E23404DE1FD813A782")
    
public boolean op(Region region, Op op) {
        return op(this, region, op);
    }

    /**
     * Set this region to the result of performing the Op on the specified rect
     * and region. Return true if the result is not empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.274 -0500", hash_original_method = "029ED340525EAD4C240C408219CCC448", hash_generated_method = "232E6767C9A21A7EAC5FD15D9DEB8F1E")
    
public boolean op(Rect rect, Region region, Op op) {
        addTaintLocal(rect.getTaintInt() + region.getTaintInt() + op.getTaintInt());
        return getTaintBoolean();
    }

    /**
     * Set this region to the result of performing the Op on the specified
     * regions. Return true if the result is not empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.277 -0500", hash_original_method = "7FDA52C90EA81767BFA435745FBF29BC", hash_generated_method = "089E0854D84F67F7C34E741D9604673A")
    
public boolean op(Region region1, Region region2, Op op) {
        addTaintLocal(region1.getTaintInt() + region2.getTaintInt() + op.getTaintInt());
        return getTaintBoolean();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.279 -0500", hash_original_method = "9B6C5B9AE4B0C715D06D485A7F8D4046", hash_generated_method = "A0A5F489A038871AC177308E2C07676C")
    
public String toString() {
        String str = new String();
        str.addTaint(getTaint());
        return str;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.289 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return getTaintInt();
    }

    /**
     * Write the region and its pixels to the parcel. The region can be
     * rebuilt from the parcel by calling CREATOR.createFromParcel().
     * @param p    Parcel object to write the region data into
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.292 -0500", hash_original_method = "D2434A1CAFA87CC30850BFCF09357749", hash_generated_method = "E11215F902D1914FB169602BEAD50BE4")
    
public void writeToParcel(Parcel p, int flags) {
        p.addTaint(getTaint());
        p.addTaint(flags);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.294 -0500", hash_original_method = "1060AF13EAB0782D5AA6FD12A9EA9F72", hash_generated_method = "05933B9020F20BBC28ACC69917027936")
    
@Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Region)) {
            return false;
        }
        return toTaintBoolean(obj.getTaintInt() + getTaintInt());
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.297 -0500", hash_original_method = "7B9D4EAB814BE6F839A0AFACF43162A1", hash_generated_method = "5A211E66A6B26EFD24F86C7123F3EC90")
    
protected void finalize() throws Throwable {
        try {
            nativeDestructor(mNativeRegion);
        } finally {
            super.finalize();
        }
    }

    private void droidsafeUpdateMembers() {
    }
  
    public void addTaintLocal(double t) {
        super.addTaint(t);
        droidsafeUpdateMembers();
    }
    
    public enum Op {
        DIFFERENCE(0),
        INTERSECT(1),
        UNION(2),
        XOR(3),
        REVERSE_DIFFERENCE(4),
        REPLACE(5);

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.188 -0500", hash_original_method = "4CD4C6B6E07DACAE04E4E7273010B355", hash_generated_method = "4CD4C6B6E07DACAE04E4E7273010B355")
            
Op(int nativeInt) {
            this.nativeInt = nativeInt;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.190 -0500", hash_original_field = "6B116C6445FBD920A2653C64D32C9FB3", hash_generated_field = "98EAA4A55387890AE1074B767C7F1464")

        public  int nativeInt;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.304 -0500", hash_original_method = "7C7B16974B0225DA07D6CF6E35F70776", hash_generated_method = "3E7EB36F7C9D3CBF11EF862D6CCE34C9")
    
final int ni() {
        //return mNativeRegion;
        return getTaintInt();
    }
}

