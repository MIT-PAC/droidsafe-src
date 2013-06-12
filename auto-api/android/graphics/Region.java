package android.graphics;

// Droidsafe Imports
import android.os.Parcel;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class Region implements Parcelable {
    public final int mNativeRegion;
    public static final Parcelable.Creator<Region> CREATOR = new Parcelable.Creator<Region>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.458 -0400", hash_original_method = "57FADA8DB6AE415E8D7938E17AD42A96", hash_generated_method = "4EC31260FBFA12AB9BBEF151B28F393F")
        @DSModeled(DSC.SAFE)
        public Region createFromParcel(Parcel p) {
            dsTaint.addTaint(p.dsTaint);
            int ni;
            ni = nativeCreateFromParcel(p);
            if (DroidSafeAndroidRuntime.control)
            {
                throw new RuntimeException();
            } //End block
            return (Region)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int ni = nativeCreateFromParcel(p);
            //if (ni == 0) {
                    //throw new RuntimeException();
                //}
            //return new Region(ni);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.458 -0400", hash_original_method = "CEFFB067794D43B67239BC68D4FB216A", hash_generated_method = "17ADA8D4F34D96CFDFF9CE2E26E1C2A7")
        @DSModeled(DSC.SAFE)
        public Region[] newArray(int size) {
            dsTaint.addTaint(size);
            return (Region[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Region[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.459 -0400", hash_original_method = "0D8BB79D644235D834A5B870E7DE5E55", hash_generated_method = "1F9CB34F6B6E4503BA0726046B434DC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Region() {
        this(nativeConstructor());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.459 -0400", hash_original_method = "ADA47703EEBAAF081A921E3B439FC136", hash_generated_method = "05770E06E9DB813DDF5DE06A8293A46D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Region(Region region) {
        this(nativeConstructor());
        dsTaint.addTaint(region.dsTaint);
        nativeSetRegion(mNativeRegion, region.mNativeRegion);
        // ---------- Original Method ----------
        //nativeSetRegion(mNativeRegion, region.mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.459 -0400", hash_original_method = "A1BEE89A791B5892C0419D31229063CC", hash_generated_method = "1142EEF0F932A9142967FF9B449BD4C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Region(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        mNativeRegion = nativeConstructor();
        nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
        // ---------- Original Method ----------
        //mNativeRegion = nativeConstructor();
        //nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.459 -0400", hash_original_method = "3B1EBFADD13882DEC7CB8A7DB9BB782B", hash_generated_method = "106BAAE08346FE39A1FB129D5243B67E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Region(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        mNativeRegion = nativeConstructor();
        nativeSetRect(mNativeRegion, left, top, right, bottom);
        // ---------- Original Method ----------
        //mNativeRegion = nativeConstructor();
        //nativeSetRect(mNativeRegion, left, top, right, bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.459 -0400", hash_original_method = "AE1199122B801919FCCD86EFAEB8981E", hash_generated_method = "F9AAF4E931B790F2E45BAF3563B344A5")
    @DSModeled(DSC.SAFE)
     Region(int ni) {
        dsTaint.addTaint(ni);
        {
            throw new RuntimeException();
        } //End block
        // ---------- Original Method ----------
        //if (ni == 0) {
            //throw new RuntimeException();
        //}
        //mNativeRegion = ni;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.459 -0400", hash_original_method = "5B5253F8036AE411F7DD245C7F6E35C3", hash_generated_method = "5946DD3BA21A504824D6D7A65D9994C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Region(int ni, int dummy) {
        this(ni);
        dsTaint.addTaint(dummy);
        dsTaint.addTaint(ni);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.459 -0400", hash_original_method = "200ADD9307CCB536C203EAC015A5A024", hash_generated_method = "8FBB1D0E58ACABF2F39853546855B938")
    @DSModeled(DSC.SAFE)
    public void setEmpty() {
        nativeSetRect(mNativeRegion, 0, 0, 0, 0);
        // ---------- Original Method ----------
        //nativeSetRect(mNativeRegion, 0, 0, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.459 -0400", hash_original_method = "4FCDB3DC16FC27229A4383057FFC976C", hash_generated_method = "C432A31EEB2FF864B44B90E1D4CA7A27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean set(Region region) {
        dsTaint.addTaint(region.dsTaint);
        boolean varFD6438F9B0E81607A15A2B33F843B9FB_237424459 = (nativeSetRegion(mNativeRegion, region.mNativeRegion));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeSetRegion(mNativeRegion, region.mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.459 -0400", hash_original_method = "C2513170875A2D5A2EB27E891206577A", hash_generated_method = "1DDB629DBA795687638ABB87CC579155")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean set(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        boolean var25DF7F0C1A123F4C32CF83DCE205F87D_1932710544 = (nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.460 -0400", hash_original_method = "D06421CD512172DCB28D2F3E0620053E", hash_generated_method = "10B55FC6469C7F8EFCD69D484D2B1B75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean set(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean varAA92C668356049C143CCD434BB32A02D_199417413 = (nativeSetRect(mNativeRegion, left, top, right, bottom));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeSetRect(mNativeRegion, left, top, right, bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.460 -0400", hash_original_method = "E058C8FF714DCD6DC5C3B199CE291ABB", hash_generated_method = "FDFBBD2E1442BE670A9EA6E2AE969354")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setPath(Path path, Region clip) {
        dsTaint.addTaint(clip.dsTaint);
        dsTaint.addTaint(path.dsTaint);
        boolean var031F6EBD4CDCFA81D22115484A3E2F03_1118809580 = (nativeSetPath(mNativeRegion, path.ni(), clip.mNativeRegion));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeSetPath(mNativeRegion, path.ni(), clip.mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.460 -0400", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "4E74ADDF216264F808BE80126788B2B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
    	return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.460 -0400", hash_original_method = "2BE881D6CE1CF3506EFB49B5287B67D4", hash_generated_method = "458686144F44D24670486B77A1965F85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isRect() {
    	return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.460 -0400", hash_original_method = "96E541304104A48A190119203B0E80D4", hash_generated_method = "AB0A3EB53CB36CEC342FB6718B50FA95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isComplex() {
    	return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.460 -0400", hash_original_method = "EBA477C7AF945181ADA3A9B8177742BE", hash_generated_method = "0208863B9EDBE14946D1E10AB9E5DEB3")
    @DSModeled(DSC.SAFE)
    public Rect getBounds() {
        Rect r;
        r = new Rect();
        nativeGetBounds(mNativeRegion, r);
        return (Rect)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Rect r = new Rect();
        //nativeGetBounds(mNativeRegion, r);
        //return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.460 -0400", hash_original_method = "A46555E1E49458678846473DF9E9883B", hash_generated_method = "46FBAB4F0B80BD2B6922CEC496084D82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBounds(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new NullPointerException();
        } //End block
        boolean var612724CC1222E7287B756B46F505C1EB_289326387 = (nativeGetBounds(mNativeRegion, r));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (r == null) {
            //throw new NullPointerException();
        //}
        //return nativeGetBounds(mNativeRegion, r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.460 -0400", hash_original_method = "378316FE7952FD732F90591AB3699DE2", hash_generated_method = "12073DECA550B349F13DEB630485EDBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Path getBoundaryPath() {
        Path path;
        path = new Path();
        nativeGetBoundaryPath(mNativeRegion, path.ni());
        return (Path)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Path path = new Path();
        //nativeGetBoundaryPath(mNativeRegion, path.ni());
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.460 -0400", hash_original_method = "4EAA9FC9D13D7E90DDD0EEB1CB6196B1", hash_generated_method = "BFF7F12A1AF36F9061F2394FE037D7D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBoundaryPath(Path path) {
        dsTaint.addTaint(path.dsTaint);
        boolean var7A07334C6D667AC5F4DCF43B96AAF16A_325354180 = (nativeGetBoundaryPath(mNativeRegion, path.ni()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeGetBoundaryPath(mNativeRegion, path.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.461 -0400", hash_original_method = "5B0A75408C2B4CF9238ADD529FC37D02", hash_generated_method = "19677A0BC460C3CFDAE1A27B3D83E68A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.461 -0400", hash_original_method = "963E643D37666FF20B3A3B029F181389", hash_generated_method = "2B5EBF0B5C333929F79FEE84C5894DFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quickContains(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        boolean var017062C31AD44FF41B703185E7097A3E_1104426223 = (quickContains(r.left, r.top, r.right, r.bottom));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return quickContains(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.461 -0400", hash_original_method = "F4780612A05468EA5B4971365E65F2E9", hash_generated_method = "665B54D0CF7FC0FFD7A19F4C47BEE536")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quickContains(int left, int top, int right,
                                        int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.461 -0400", hash_original_method = "99713AAB8FDC91BA4FFF953154B93F70", hash_generated_method = "2A8E4292E44FC7D4689AEA1AAE6D22EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quickReject(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        boolean varB72F58AD7D20DCFFA79D3669C170785C_1575631776 = (quickReject(r.left, r.top, r.right, r.bottom));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return quickReject(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.461 -0400", hash_original_method = "C7FE089D5B9638DFC662C69BB1CCA253", hash_generated_method = "54B935766DFD70AC72CFC4EB41725C91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quickReject(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.461 -0400", hash_original_method = "248FAC130B583135AFED72EC96EB473C", hash_generated_method = "A242E4CF303ED2FD53D7B2244467C022")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quickReject(Region rgn) {
        dsTaint.addTaint(rgn.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.461 -0400", hash_original_method = "1E0220698FB1311F0D8B9F18E7495908", hash_generated_method = "FCD4C9855BB86B07C79CA9D849B92758")
    @DSModeled(DSC.SAFE)
    public void translate(int dx, int dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        translate(dx, dy, null);
        // ---------- Original Method ----------
        //translate(dx, dy, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.461 -0400", hash_original_method = "F2F101D23D8556E25BBA4D0A405F0CD3", hash_generated_method = "0A0401B6BC967740A6EFF30791C3CE59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void translate(int dx, int dy, Region dst) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        dsTaint.addTaint(dst.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.461 -0400", hash_original_method = "39111F1C858A6D228BD34A5A0563D24D", hash_generated_method = "C7DB4D50AC5C2212CC7202C073E46C8F")
    @DSModeled(DSC.SAFE)
    public void scale(float scale) {
        dsTaint.addTaint(scale);
        scale(scale, null);
        // ---------- Original Method ----------
        //scale(scale, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.461 -0400", hash_original_method = "704645B9B50E78F1B3F526FB095B5A0C", hash_generated_method = "C195AEDBD728540BE51462D905565EA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scale(float scale, Region dst) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(dst.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.462 -0400", hash_original_method = "50F2C1285B4A35F7EE8C85CE7082EAF5", hash_generated_method = "B6E1810C1F273FB22B9A4822A1D38DA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean union(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        boolean varF191283E3A07FEE13EB2FB081B34FC0D_1324094416 = (op(r, Op.UNION));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return op(r, Op.UNION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.462 -0400", hash_original_method = "0254EC2D8CB0B709656A3942F767CF9E", hash_generated_method = "8DBDE859362B95099526E3D46A7244D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean op(Rect r, Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        boolean var90EAA618B3BAC1E5B315E4AB50A3912D_278590618 = (nativeOp(mNativeRegion, r.left, r.top, r.right, r.bottom,
                        op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, r.left, r.top, r.right, r.bottom,
                        //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.462 -0400", hash_original_method = "F7B19A9596841ACD8A98EA48656877B1", hash_generated_method = "CE8D874AD92CA6F28A29099E0134F80A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean op(int left, int top, int right, int bottom, Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean varABC9D9B2705AE309B237F72644A5AB34_1070812394 = (nativeOp(mNativeRegion, left, top, right, bottom,
                        op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, left, top, right, bottom,
                        //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.462 -0400", hash_original_method = "7B6B61AB972DEFAAC29D5DA42EF8C210", hash_generated_method = "7FE7F1D0EDED7866BD4D98A02C07DA9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean op(Region region, Op op) {
        dsTaint.addTaint(region.dsTaint);
        dsTaint.addTaint(op.dsTaint);
        boolean var0AD004458B8F75085CC4F6F5BFEA2284_1163023990 = (op(this, region, op));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return op(this, region, op);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.462 -0400", hash_original_method = "029ED340525EAD4C240C408219CCC448", hash_generated_method = "97896466433B34C9D41E559475DFEA04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean op(Rect rect, Region region, Op op) {
        dsTaint.addTaint(region.dsTaint);
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        boolean varB0742BC4953C9AFE0E99DE4F785439D4_632826923 = (nativeOp(mNativeRegion, rect, region.mNativeRegion,
                        op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, rect, region.mNativeRegion,
                        //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.462 -0400", hash_original_method = "7FDA52C90EA81767BFA435745FBF29BC", hash_generated_method = "FB547254995F815AAA4D0ECE5F334B36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean op(Region region1, Region region2, Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(region2.dsTaint);
        dsTaint.addTaint(region1.dsTaint);
        boolean var0855EC438B898D69658174303EBCB740_1612223827 = (nativeOp(mNativeRegion, region1.mNativeRegion,
                        region2.mNativeRegion, op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, region1.mNativeRegion,
                        //region2.mNativeRegion, op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.462 -0400", hash_original_method = "9B6C5B9AE4B0C715D06D485A7F8D4046", hash_generated_method = "58ADCFEEC2522E0175BB608DE4394B49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varDC2402CB4F37B486A874A8FCF1F196ED_653798035 = (nativeToString(mNativeRegion));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return nativeToString(mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.462 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.462 -0400", hash_original_method = "D2434A1CAFA87CC30850BFCF09357749", hash_generated_method = "EB93FF7542373D402E22D565B7AF526C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel p, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(p.dsTaint);
        {
            boolean varD704EA22356746E9A56ADBBB4C97F8A4_489758070 = (!nativeWriteToParcel(mNativeRegion, p));
            {
                throw new RuntimeException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!nativeWriteToParcel(mNativeRegion, p)) {
            //throw new RuntimeException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.463 -0400", hash_original_method = "1060AF13EAB0782D5AA6FD12A9EA9F72", hash_generated_method = "30D06E143738C877BAE6B551846BE71F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        Region peer;
        peer = (Region) obj;
        boolean var3AD8F6933DA7C0D2F9603EC218BF03E8_1654351227 = (nativeEquals(mNativeRegion, peer.mNativeRegion));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (obj == null || !(obj instanceof Region)) {
            //return false;
        //}
        //Region peer = (Region) obj;
        //return nativeEquals(mNativeRegion, peer.mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.463 -0400", hash_original_method = "7B9D4EAB814BE6F839A0AFACF43162A1", hash_generated_method = "7FB38D86B005DB6C79E89973B5F213F5")
    @DSModeled(DSC.SAFE)
    protected void finalize() throws Throwable {
        try 
        {
            nativeDestructor(mNativeRegion);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //nativeDestructor(mNativeRegion);
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.463 -0400", hash_original_method = "7C7B16974B0225DA07D6CF6E35F70776", hash_generated_method = "9F8501F0A01AB60EA6D41E7058824E12")
    @DSModeled(DSC.SAFE)
    final int ni() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNativeRegion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.463 -0400", hash_original_method = "598B1991EF10295B3051016A841305EB", hash_generated_method = "9DB592E037E80C5CE657CC5174F39E70")
    private static boolean nativeEquals(int native_r1, int native_r2) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.463 -0400", hash_original_method = "3E924FA274207677C1685DA252728964", hash_generated_method = "783BD50B4B71271940FA9D99D43D18FE")
    private static int nativeConstructor() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.463 -0400", hash_original_method = "A8BD981701C67480B873C71171CBACF6", hash_generated_method = "3E943F367F424468A4EBB7840470C118")
    private static void nativeDestructor(int native_region) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.463 -0400", hash_original_method = "9E4242078355D7B184F8BCDFE25D96A8", hash_generated_method = "9335F4BB309EB5015342FF1FDA24F170")
    private static boolean nativeSetRegion(int native_dst,
                                                  int native_src) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.463 -0400", hash_original_method = "253A4F1125E3DC2F0204ECC739AFF0FA", hash_generated_method = "C642F55203C30E07089736F03690D268")
    private static boolean nativeSetRect(int native_dst, int left,
                                                int top, int right, int bottom) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.463 -0400", hash_original_method = "548ADFBE3399F0238FEF07CB349B272E", hash_generated_method = "D3572AAAC0B51728378289A8D1F9F436")
    private static boolean nativeSetPath(int native_dst, int native_path,
                                                int native_clip) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.463 -0400", hash_original_method = "1271021B06E5F4556F941DCBA2750C73", hash_generated_method = "A165287157DE09D6D76C6843F784ACAB")
    private static boolean nativeGetBounds(int native_region, Rect rect) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.463 -0400", hash_original_method = "46A30DC6204C7043F695CF4068A135E3", hash_generated_method = "D7AC122A236D582E78C418BC29A4E00D")
    private static boolean nativeGetBoundaryPath(int native_region,
                                                        int native_path) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.464 -0400", hash_original_method = "09186B760BB24F32CE73B2F755B3D1D7", hash_generated_method = "F343B36FBFB30229C20959AE6E4F1437")
    private static boolean nativeOp(int native_dst, int left, int top,
                                           int right, int bottom, int op) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.464 -0400", hash_original_method = "78BAB0A233963D1BC9B112A8344E682F", hash_generated_method = "0EDC98E7FBB075D29AC2D3BF7A7F9785")
    private static boolean nativeOp(int native_dst, Rect rect,
                                           int native_region, int op) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.464 -0400", hash_original_method = "092054E6D28B4F07C6EC84BBAA5E3501", hash_generated_method = "295B5B440359C37B992C7963ABB8ADB1")
    private static boolean nativeOp(int native_dst, int native_region1,
                                           int native_region2, int op) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.464 -0400", hash_original_method = "D561B5355DF3E88C82B4FF8EBC54B7CE", hash_generated_method = "5914FD74CA8BC723AFE9188D54BC4A1D")
    private static int nativeCreateFromParcel(Parcel p) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.464 -0400", hash_original_method = "48BF38789B9A65289141052C650618AD", hash_generated_method = "C3D5D372068833AA095282DED6949CC5")
    private static boolean nativeWriteToParcel(int native_region,
                                                      Parcel p) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.464 -0400", hash_original_method = "CE9470C796B46050D08AF02A078E3479", hash_generated_method = "443251BD69E63DECB0B9F19DB643318C")
    private static String nativeToString(int native_region) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return new String();
    }

    
    public enum Op {
        DIFFERENCE(0),
        INTERSECT(1),
        UNION(2),
        XOR(3),
        REVERSE_DIFFERENCE(4),
        REPLACE(5);
        Op(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        public final int nativeInt;
    }

    
}


