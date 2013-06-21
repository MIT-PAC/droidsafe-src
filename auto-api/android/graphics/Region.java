package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class Region implements Parcelable {
    public int mNativeRegion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.792 -0400", hash_original_method = "0D8BB79D644235D834A5B870E7DE5E55", hash_generated_method = "E39C818312FCB6AA783B7BFB03E94023")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Region() {
        this(nativeConstructor());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.792 -0400", hash_original_method = "ADA47703EEBAAF081A921E3B439FC136", hash_generated_method = "6726E5B83C2C3C2B97E8E6382102A4AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Region(Region region) {
        this(nativeConstructor());
        dsTaint.addTaint(region.dsTaint);
        nativeSetRegion(mNativeRegion, region.mNativeRegion);
        // ---------- Original Method ----------
        //nativeSetRegion(mNativeRegion, region.mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.792 -0400", hash_original_method = "A1BEE89A791B5892C0419D31229063CC", hash_generated_method = "D86D4FFFC1D71CD063F8CC108AD2A6C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Region(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        mNativeRegion = nativeConstructor();
        nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
        // ---------- Original Method ----------
        //mNativeRegion = nativeConstructor();
        //nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.793 -0400", hash_original_method = "3B1EBFADD13882DEC7CB8A7DB9BB782B", hash_generated_method = "82920683F823A47A68D7EB9A42CB9B75")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.793 -0400", hash_original_method = "AE1199122B801919FCCD86EFAEB8981E", hash_generated_method = "9C97A6023D00438F79B3320670A6C98E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Region(int ni) {
        dsTaint.addTaint(ni);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException();
        } //End block
        // ---------- Original Method ----------
        //if (ni == 0) {
            //throw new RuntimeException();
        //}
        //mNativeRegion = ni;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.793 -0400", hash_original_method = "5B5253F8036AE411F7DD245C7F6E35C3", hash_generated_method = "14B93E2FD42BC2DB7983288D2AD210F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Region(int ni, int dummy) {
        this(ni);
        dsTaint.addTaint(dummy);
        dsTaint.addTaint(ni);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.793 -0400", hash_original_method = "200ADD9307CCB536C203EAC015A5A024", hash_generated_method = "A1D8D2D68CAD63FF400E3E9B34FAD970")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEmpty() {
        nativeSetRect(mNativeRegion, 0, 0, 0, 0);
        // ---------- Original Method ----------
        //nativeSetRect(mNativeRegion, 0, 0, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.793 -0400", hash_original_method = "4FCDB3DC16FC27229A4383057FFC976C", hash_generated_method = "07E9C0F6BA00E4B6E3FE0943C5D76E99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean set(Region region) {
        dsTaint.addTaint(region.dsTaint);
        boolean varFD6438F9B0E81607A15A2B33F843B9FB_1733122964 = (nativeSetRegion(mNativeRegion, region.mNativeRegion));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeSetRegion(mNativeRegion, region.mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.794 -0400", hash_original_method = "C2513170875A2D5A2EB27E891206577A", hash_generated_method = "41B8290ADD6EB61928B1AE8076DA1706")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean set(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        boolean var25DF7F0C1A123F4C32CF83DCE205F87D_859037014 = (nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.794 -0400", hash_original_method = "D06421CD512172DCB28D2F3E0620053E", hash_generated_method = "0B9EB74056F3C32F6DBC380E74513F1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean set(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean varAA92C668356049C143CCD434BB32A02D_1542683757 = (nativeSetRect(mNativeRegion, left, top, right, bottom));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeSetRect(mNativeRegion, left, top, right, bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.794 -0400", hash_original_method = "E058C8FF714DCD6DC5C3B199CE291ABB", hash_generated_method = "B4ED845EC68F8A72C51471D77942039B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setPath(Path path, Region clip) {
        dsTaint.addTaint(clip.dsTaint);
        dsTaint.addTaint(path.dsTaint);
        boolean var031F6EBD4CDCFA81D22115484A3E2F03_632974923 = (nativeSetPath(mNativeRegion, path.ni(), clip.mNativeRegion));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeSetPath(mNativeRegion, path.ni(), clip.mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.794 -0400", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "980C3CA394064A1D9FE11B9568A552C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.795 -0400", hash_original_method = "2BE881D6CE1CF3506EFB49B5287B67D4", hash_generated_method = "A865AD5932BD3AA02828C3360E01FF77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isRect() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.795 -0400", hash_original_method = "96E541304104A48A190119203B0E80D4", hash_generated_method = "E6BB26D83FE1841A4437BD28CC098626")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isComplex() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.795 -0400", hash_original_method = "EBA477C7AF945181ADA3A9B8177742BE", hash_generated_method = "E580D31D45768A10B77591A43EED96B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.795 -0400", hash_original_method = "A46555E1E49458678846473DF9E9883B", hash_generated_method = "51314DB78E1B62F081E35E00DF12E713")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBounds(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        boolean var612724CC1222E7287B756B46F505C1EB_1265075649 = (nativeGetBounds(mNativeRegion, r));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (r == null) {
            //throw new NullPointerException();
        //}
        //return nativeGetBounds(mNativeRegion, r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.796 -0400", hash_original_method = "378316FE7952FD732F90591AB3699DE2", hash_generated_method = "9AC37811588A4600C9064CABED516E62")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.796 -0400", hash_original_method = "4EAA9FC9D13D7E90DDD0EEB1CB6196B1", hash_generated_method = "7F777DB3E8ED03B1E468C5B819B53102")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBoundaryPath(Path path) {
        dsTaint.addTaint(path.dsTaint);
        boolean var7A07334C6D667AC5F4DCF43B96AAF16A_1576226329 = (nativeGetBoundaryPath(mNativeRegion, path.ni()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeGetBoundaryPath(mNativeRegion, path.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.796 -0400", hash_original_method = "5B0A75408C2B4CF9238ADD529FC37D02", hash_generated_method = "703BC5C3336F4DC502F394FE56B93277")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.796 -0400", hash_original_method = "963E643D37666FF20B3A3B029F181389", hash_generated_method = "47EDBFD50B476CC8D6151A5D2A98B0C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quickContains(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        boolean var017062C31AD44FF41B703185E7097A3E_1602786722 = (quickContains(r.left, r.top, r.right, r.bottom));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return quickContains(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.796 -0400", hash_original_method = "F4780612A05468EA5B4971365E65F2E9", hash_generated_method = "FD8B13E913984FE437D91770E69F8704")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quickContains(int left, int top, int right,
                                        int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.797 -0400", hash_original_method = "99713AAB8FDC91BA4FFF953154B93F70", hash_generated_method = "CDAD18F5AAD0B34964FC01CEABBD7237")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quickReject(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        boolean varB72F58AD7D20DCFFA79D3669C170785C_72211162 = (quickReject(r.left, r.top, r.right, r.bottom));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return quickReject(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.797 -0400", hash_original_method = "C7FE089D5B9638DFC662C69BB1CCA253", hash_generated_method = "507956BEA1FA21886838584595A3B466")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quickReject(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.797 -0400", hash_original_method = "248FAC130B583135AFED72EC96EB473C", hash_generated_method = "F57C0791972DF66AE2485907AAAD2735")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quickReject(Region rgn) {
        dsTaint.addTaint(rgn.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.797 -0400", hash_original_method = "1E0220698FB1311F0D8B9F18E7495908", hash_generated_method = "A4AE59F6BFF2BD6582212EA890CCDB02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void translate(int dx, int dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        translate(dx, dy, null);
        // ---------- Original Method ----------
        //translate(dx, dy, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.798 -0400", hash_original_method = "F2F101D23D8556E25BBA4D0A405F0CD3", hash_generated_method = "84643C0B3CE859AF3927E02C666F6CD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void translate(int dx, int dy, Region dst) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        dsTaint.addTaint(dst.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.798 -0400", hash_original_method = "39111F1C858A6D228BD34A5A0563D24D", hash_generated_method = "F79812200A3C59A5449C57E62E618793")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scale(float scale) {
        dsTaint.addTaint(scale);
        scale(scale, null);
        // ---------- Original Method ----------
        //scale(scale, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.798 -0400", hash_original_method = "704645B9B50E78F1B3F526FB095B5A0C", hash_generated_method = "5EAFF6E12EE2FF36C4D81639B732D686")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scale(float scale, Region dst) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(dst.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.798 -0400", hash_original_method = "50F2C1285B4A35F7EE8C85CE7082EAF5", hash_generated_method = "CAC4F41B40F31B1DAB38A13B2D51BA6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean union(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        boolean varF191283E3A07FEE13EB2FB081B34FC0D_402092038 = (op(r, Op.UNION));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return op(r, Op.UNION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.798 -0400", hash_original_method = "0254EC2D8CB0B709656A3942F767CF9E", hash_generated_method = "DEDE785670027733E094B439AB964B82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean op(Rect r, Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        boolean var90EAA618B3BAC1E5B315E4AB50A3912D_745257455 = (nativeOp(mNativeRegion, r.left, r.top, r.right, r.bottom,
                        op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, r.left, r.top, r.right, r.bottom,
                        //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.799 -0400", hash_original_method = "F7B19A9596841ACD8A98EA48656877B1", hash_generated_method = "82276D388D4145E6D8B3C7C37651B72F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean op(int left, int top, int right, int bottom, Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean varABC9D9B2705AE309B237F72644A5AB34_956545594 = (nativeOp(mNativeRegion, left, top, right, bottom,
                        op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, left, top, right, bottom,
                        //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.799 -0400", hash_original_method = "7B6B61AB972DEFAAC29D5DA42EF8C210", hash_generated_method = "0B5A8D7990FC3A440ADF9AB8C2AE2877")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean op(Region region, Op op) {
        dsTaint.addTaint(region.dsTaint);
        dsTaint.addTaint(op.dsTaint);
        boolean var0AD004458B8F75085CC4F6F5BFEA2284_475218840 = (op(this, region, op));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return op(this, region, op);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.799 -0400", hash_original_method = "029ED340525EAD4C240C408219CCC448", hash_generated_method = "9DF314DDD708143D647C11C5BCED3648")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean op(Rect rect, Region region, Op op) {
        dsTaint.addTaint(region.dsTaint);
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        boolean varB0742BC4953C9AFE0E99DE4F785439D4_1322422665 = (nativeOp(mNativeRegion, rect, region.mNativeRegion,
                        op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, rect, region.mNativeRegion,
                        //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.799 -0400", hash_original_method = "7FDA52C90EA81767BFA435745FBF29BC", hash_generated_method = "1FC2A222F6D214647C9ACBAC428AC1CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean op(Region region1, Region region2, Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(region2.dsTaint);
        dsTaint.addTaint(region1.dsTaint);
        boolean var0855EC438B898D69658174303EBCB740_1677606080 = (nativeOp(mNativeRegion, region1.mNativeRegion,
                        region2.mNativeRegion, op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, region1.mNativeRegion,
                        //region2.mNativeRegion, op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.800 -0400", hash_original_method = "9B6C5B9AE4B0C715D06D485A7F8D4046", hash_generated_method = "5734F54CE9B7BCFA35AEF0F2C7A7FFB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varDC2402CB4F37B486A874A8FCF1F196ED_471840173 = (nativeToString(mNativeRegion));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return nativeToString(mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.800 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.800 -0400", hash_original_method = "D2434A1CAFA87CC30850BFCF09357749", hash_generated_method = "E7E00322D077090FE906D065D64CDB2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel p, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(p.dsTaint);
        {
            boolean varD704EA22356746E9A56ADBBB4C97F8A4_1724353544 = (!nativeWriteToParcel(mNativeRegion, p));
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!nativeWriteToParcel(mNativeRegion, p)) {
            //throw new RuntimeException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.800 -0400", hash_original_method = "1060AF13EAB0782D5AA6FD12A9EA9F72", hash_generated_method = "368F2AE96A626E087A9D8252D48D716A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        Region peer;
        peer = (Region) obj;
        boolean var3AD8F6933DA7C0D2F9603EC218BF03E8_1984372742 = (nativeEquals(mNativeRegion, peer.mNativeRegion));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (obj == null || !(obj instanceof Region)) {
            //return false;
        //}
        //Region peer = (Region) obj;
        //return nativeEquals(mNativeRegion, peer.mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.801 -0400", hash_original_method = "7B9D4EAB814BE6F839A0AFACF43162A1", hash_generated_method = "88533E051B74F60620695CD5B6D42F0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.801 -0400", hash_original_method = "7C7B16974B0225DA07D6CF6E35F70776", hash_generated_method = "01BEA6054D532E74DEE8CE398CA99716")
    @DSModeled(DSC.SAFE)
    final int ni() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNativeRegion;
    }

    
        private static boolean nativeEquals(int native_r1, int native_r2) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static int nativeConstructor() {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void nativeDestructor(int native_region) {
    }

    
        private static boolean nativeSetRegion(int native_dst,
                                                  int native_src) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean nativeSetRect(int native_dst, int left,
                                                int top, int right, int bottom) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean nativeSetPath(int native_dst, int native_path,
                                                int native_clip) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean nativeGetBounds(int native_region, Rect rect) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean nativeGetBoundaryPath(int native_region,
                                                        int native_path) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean nativeOp(int native_dst, int left, int top,
                                           int right, int bottom, int op) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean nativeOp(int native_dst, Rect rect,
                                           int native_region, int op) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean nativeOp(int native_dst, int native_region1,
                                           int native_region2, int op) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static int nativeCreateFromParcel(Parcel p) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static boolean nativeWriteToParcel(int native_region,
                                                      Parcel p) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static String nativeToString(int native_region) {
        return DSUtils.UNKNOWN_STRING;
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

    
    public static final Parcelable.Creator<Region> CREATOR = new Parcelable.Creator<Region>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.803 -0400", hash_original_method = "57FADA8DB6AE415E8D7938E17AD42A96", hash_generated_method = "E3BB924FE1EEE2F4A712F94808E0386B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Region createFromParcel(Parcel p) {
            dsTaint.addTaint(p.dsTaint);
            int ni;
            ni = nativeCreateFromParcel(p);
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException();
            } //End block
            Region varF800144DF59CD796FC7AA3E373E91903_119677059 = (new Region(ni));
            return (Region)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int ni = nativeCreateFromParcel(p);
            //if (ni == 0) {
                    //throw new RuntimeException();
                //}
            //return new Region(ni);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.803 -0400", hash_original_method = "CEFFB067794D43B67239BC68D4FB216A", hash_generated_method = "CF0097436C8AF6EE33513ADFCC060C72")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Region[] newArray(int size) {
            dsTaint.addTaint(size);
            Region[] var1D1F88C3837C7C1E168EC44CDABBF03E_1508097794 = (new Region[size]);
            return (Region[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Region[size];
        }

        
}; //Transformed anonymous class
}

