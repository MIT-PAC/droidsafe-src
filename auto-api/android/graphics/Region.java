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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.161 -0400", hash_original_field = "39A8A1AE8A42CDC584C4F2F420719809", hash_generated_field = "BE18D4475688FDC46F0A31DE4104CC38")

    public int mNativeRegion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.177 -0400", hash_original_method = "0D8BB79D644235D834A5B870E7DE5E55", hash_generated_method = "E39C818312FCB6AA783B7BFB03E94023")
    public  Region() {
        this(nativeConstructor());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.177 -0400", hash_original_method = "ADA47703EEBAAF081A921E3B439FC136", hash_generated_method = "A09777D2102260181E3E2BD364A2770A")
    public  Region(Region region) {
        this(nativeConstructor());
        nativeSetRegion(mNativeRegion, region.mNativeRegion);
        addTaint(region.getTaint());
        // ---------- Original Method ----------
        //nativeSetRegion(mNativeRegion, region.mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.178 -0400", hash_original_method = "A1BEE89A791B5892C0419D31229063CC", hash_generated_method = "DD7F9984E03DE8897E830C80A8E503AC")
    public  Region(Rect r) {
        mNativeRegion = nativeConstructor();
        nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        //mNativeRegion = nativeConstructor();
        //nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.179 -0400", hash_original_method = "3B1EBFADD13882DEC7CB8A7DB9BB782B", hash_generated_method = "864E2AA468A5C0CDD79590BC9201CFEA")
    public  Region(int left, int top, int right, int bottom) {
        mNativeRegion = nativeConstructor();
        nativeSetRect(mNativeRegion, left, top, right, bottom);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        // ---------- Original Method ----------
        //mNativeRegion = nativeConstructor();
        //nativeSetRect(mNativeRegion, left, top, right, bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.180 -0400", hash_original_method = "AE1199122B801919FCCD86EFAEB8981E", hash_generated_method = "D76989F906C7903EBFB8F0E5C3DD4905")
      Region(int ni) {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException();
        } //End block
        mNativeRegion = ni;
        // ---------- Original Method ----------
        //if (ni == 0) {
            //throw new RuntimeException();
        //}
        //mNativeRegion = ni;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.194 -0400", hash_original_method = "5B5253F8036AE411F7DD245C7F6E35C3", hash_generated_method = "016A964C73357547BF51727F07F054D8")
    private  Region(int ni, int dummy) {
        this(ni);
        addTaint(ni);
        addTaint(dummy);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.194 -0400", hash_original_method = "200ADD9307CCB536C203EAC015A5A024", hash_generated_method = "A1D8D2D68CAD63FF400E3E9B34FAD970")
    public void setEmpty() {
        nativeSetRect(mNativeRegion, 0, 0, 0, 0);
        // ---------- Original Method ----------
        //nativeSetRect(mNativeRegion, 0, 0, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.195 -0400", hash_original_method = "4FCDB3DC16FC27229A4383057FFC976C", hash_generated_method = "9A5D869837AF884095CED49DA810F791")
    public boolean set(Region region) {
        boolean varFD6438F9B0E81607A15A2B33F843B9FB_988686744 = (nativeSetRegion(mNativeRegion, region.mNativeRegion));
        addTaint(region.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_275918165 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_275918165;
        // ---------- Original Method ----------
        //return nativeSetRegion(mNativeRegion, region.mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.196 -0400", hash_original_method = "C2513170875A2D5A2EB27E891206577A", hash_generated_method = "CA3FA6C9A17F12F6053C4E9986C9371D")
    public boolean set(Rect r) {
        boolean var25DF7F0C1A123F4C32CF83DCE205F87D_2068609693 = (nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_485698057 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_485698057;
        // ---------- Original Method ----------
        //return nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.196 -0400", hash_original_method = "D06421CD512172DCB28D2F3E0620053E", hash_generated_method = "E24562E4D061AAABBA4066C0BBBE85F0")
    public boolean set(int left, int top, int right, int bottom) {
        boolean varAA92C668356049C143CCD434BB32A02D_229018005 = (nativeSetRect(mNativeRegion, left, top, right, bottom));
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1654926747 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1654926747;
        // ---------- Original Method ----------
        //return nativeSetRect(mNativeRegion, left, top, right, bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.217 -0400", hash_original_method = "E058C8FF714DCD6DC5C3B199CE291ABB", hash_generated_method = "284307B3EEEC195F2C85EA3D2C33A0FB")
    public boolean setPath(Path path, Region clip) {
        boolean var031F6EBD4CDCFA81D22115484A3E2F03_2042294183 = (nativeSetPath(mNativeRegion, path.ni(), clip.mNativeRegion));
        addTaint(path.getTaint());
        addTaint(clip.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1792993968 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1792993968;
        // ---------- Original Method ----------
        //return nativeSetPath(mNativeRegion, path.ni(), clip.mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.218 -0400", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "ACF56FE7F348B8C7C97D38F4A9A31877")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_715225925 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_715225925;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.218 -0400", hash_original_method = "2BE881D6CE1CF3506EFB49B5287B67D4", hash_generated_method = "B6363D0C862AFFDCC6FCAC74166590EA")
    public boolean isRect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_249117355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_249117355;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.218 -0400", hash_original_method = "96E541304104A48A190119203B0E80D4", hash_generated_method = "13ACF6BD98DBE632FEFB689EEA326713")
    public boolean isComplex() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_875289743 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_875289743;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.219 -0400", hash_original_method = "EBA477C7AF945181ADA3A9B8177742BE", hash_generated_method = "F1298FF5D8FFC11707B1F5AC9C853812")
    public Rect getBounds() {
        Rect varB4EAC82CA7396A68D541C85D26508E83_1968904533 = null; //Variable for return #1
        Rect r;
        r = new Rect();
        nativeGetBounds(mNativeRegion, r);
        varB4EAC82CA7396A68D541C85D26508E83_1968904533 = r;
        varB4EAC82CA7396A68D541C85D26508E83_1968904533.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1968904533;
        // ---------- Original Method ----------
        //Rect r = new Rect();
        //nativeGetBounds(mNativeRegion, r);
        //return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.222 -0400", hash_original_method = "A46555E1E49458678846473DF9E9883B", hash_generated_method = "76A27E07DA8C97C3D9F86A5FFD9E2186")
    public boolean getBounds(Rect r) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        boolean var612724CC1222E7287B756B46F505C1EB_1330105912 = (nativeGetBounds(mNativeRegion, r));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_190119623 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_190119623;
        // ---------- Original Method ----------
        //if (r == null) {
            //throw new NullPointerException();
        //}
        //return nativeGetBounds(mNativeRegion, r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.223 -0400", hash_original_method = "378316FE7952FD732F90591AB3699DE2", hash_generated_method = "C11D504E25D48143A01EB7951801B611")
    public Path getBoundaryPath() {
        Path varB4EAC82CA7396A68D541C85D26508E83_106663069 = null; //Variable for return #1
        Path path;
        path = new Path();
        nativeGetBoundaryPath(mNativeRegion, path.ni());
        varB4EAC82CA7396A68D541C85D26508E83_106663069 = path;
        varB4EAC82CA7396A68D541C85D26508E83_106663069.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_106663069;
        // ---------- Original Method ----------
        //Path path = new Path();
        //nativeGetBoundaryPath(mNativeRegion, path.ni());
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.224 -0400", hash_original_method = "4EAA9FC9D13D7E90DDD0EEB1CB6196B1", hash_generated_method = "C8DEED96A924384C5159C20553214603")
    public boolean getBoundaryPath(Path path) {
        boolean var7A07334C6D667AC5F4DCF43B96AAF16A_122701122 = (nativeGetBoundaryPath(mNativeRegion, path.ni()));
        addTaint(path.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_953752255 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_953752255;
        // ---------- Original Method ----------
        //return nativeGetBoundaryPath(mNativeRegion, path.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.227 -0400", hash_original_method = "5B0A75408C2B4CF9238ADD529FC37D02", hash_generated_method = "9BDB5E15A254AA3A47260A13AF3E15B3")
    public boolean contains(int x, int y) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1794712206 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1794712206;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.228 -0400", hash_original_method = "963E643D37666FF20B3A3B029F181389", hash_generated_method = "4FBF355BE1B07850B2BAC1781EABAF28")
    public boolean quickContains(Rect r) {
        boolean var017062C31AD44FF41B703185E7097A3E_59812626 = (quickContains(r.left, r.top, r.right, r.bottom));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1538344152 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1538344152;
        // ---------- Original Method ----------
        //return quickContains(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.231 -0400", hash_original_method = "F4780612A05468EA5B4971365E65F2E9", hash_generated_method = "DB4F0EC64CB9FDB74935C835DA4A0AC6")
    public boolean quickContains(int left, int top, int right,
                                        int bottom) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_426435909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_426435909;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.235 -0400", hash_original_method = "99713AAB8FDC91BA4FFF953154B93F70", hash_generated_method = "9C63DA914EF7372D1B561501256B94D9")
    public boolean quickReject(Rect r) {
        boolean varB72F58AD7D20DCFFA79D3669C170785C_1091493323 = (quickReject(r.left, r.top, r.right, r.bottom));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1629470778 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1629470778;
        // ---------- Original Method ----------
        //return quickReject(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.235 -0400", hash_original_method = "C7FE089D5B9638DFC662C69BB1CCA253", hash_generated_method = "F21033982C6B477BA1E47AA50B591C83")
    public boolean quickReject(int left, int top, int right, int bottom) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_984044031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_984044031;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.236 -0400", hash_original_method = "248FAC130B583135AFED72EC96EB473C", hash_generated_method = "8FE6424F8C0458BF3E623798A7A57DE7")
    public boolean quickReject(Region rgn) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_659719602 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_659719602;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.236 -0400", hash_original_method = "1E0220698FB1311F0D8B9F18E7495908", hash_generated_method = "E24B5EF6D47ED52A756A2EA13DEC0030")
    public void translate(int dx, int dy) {
        translate(dx, dy, null);
        addTaint(dx);
        addTaint(dy);
        // ---------- Original Method ----------
        //translate(dx, dy, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.236 -0400", hash_original_method = "F2F101D23D8556E25BBA4D0A405F0CD3", hash_generated_method = "2A31251C6E83A876D8030DE3CA7F91C4")
    public void translate(int dx, int dy, Region dst) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.267 -0400", hash_original_method = "39111F1C858A6D228BD34A5A0563D24D", hash_generated_method = "A4ED0A074CB69C62A947FAC105ECCFB4")
    public void scale(float scale) {
        scale(scale, null);
        addTaint(scale);
        // ---------- Original Method ----------
        //scale(scale, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.268 -0400", hash_original_method = "704645B9B50E78F1B3F526FB095B5A0C", hash_generated_method = "93622E1801E30E8106831D2D97D909FA")
    public void scale(float scale, Region dst) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.268 -0400", hash_original_method = "50F2C1285B4A35F7EE8C85CE7082EAF5", hash_generated_method = "087981963FEA3FAC81BE6828CDABE8DA")
    public final boolean union(Rect r) {
        boolean varF191283E3A07FEE13EB2FB081B34FC0D_460267433 = (op(r, Op.UNION));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_215054147 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_215054147;
        // ---------- Original Method ----------
        //return op(r, Op.UNION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.269 -0400", hash_original_method = "0254EC2D8CB0B709656A3942F767CF9E", hash_generated_method = "2744DBDAE4991187720EF0C931126D77")
    public boolean op(Rect r, Op op) {
        boolean var90EAA618B3BAC1E5B315E4AB50A3912D_1766853719 = (nativeOp(mNativeRegion, r.left, r.top, r.right, r.bottom,
                        op.nativeInt));
        addTaint(r.getTaint());
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_771069325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_771069325;
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, r.left, r.top, r.right, r.bottom,
                        //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.270 -0400", hash_original_method = "F7B19A9596841ACD8A98EA48656877B1", hash_generated_method = "922D0402647D8211C0A62B270FA84A00")
    public boolean op(int left, int top, int right, int bottom, Op op) {
        boolean varABC9D9B2705AE309B237F72644A5AB34_1499040114 = (nativeOp(mNativeRegion, left, top, right, bottom,
                        op.nativeInt));
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1190214516 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1190214516;
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, left, top, right, bottom,
                        //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.271 -0400", hash_original_method = "7B6B61AB972DEFAAC29D5DA42EF8C210", hash_generated_method = "CEF63BE5095AD790A54BE688C9E1B4CF")
    public boolean op(Region region, Op op) {
        boolean var0AD004458B8F75085CC4F6F5BFEA2284_571500603 = (op(this, region, op));
        addTaint(region.getTaint());
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2115254133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2115254133;
        // ---------- Original Method ----------
        //return op(this, region, op);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.284 -0400", hash_original_method = "029ED340525EAD4C240C408219CCC448", hash_generated_method = "D445CB26031D2CF4383F3BC8178BB5C2")
    public boolean op(Rect rect, Region region, Op op) {
        boolean varB0742BC4953C9AFE0E99DE4F785439D4_133540235 = (nativeOp(mNativeRegion, rect, region.mNativeRegion,
                        op.nativeInt));
        addTaint(rect.getTaint());
        addTaint(region.getTaint());
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1776367411 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1776367411;
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, rect, region.mNativeRegion,
                        //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.285 -0400", hash_original_method = "7FDA52C90EA81767BFA435745FBF29BC", hash_generated_method = "9CC60E8BB6A29BE5E548EDC6060D18A3")
    public boolean op(Region region1, Region region2, Op op) {
        boolean var0855EC438B898D69658174303EBCB740_1362492534 = (nativeOp(mNativeRegion, region1.mNativeRegion,
                        region2.mNativeRegion, op.nativeInt));
        addTaint(region1.getTaint());
        addTaint(region2.getTaint());
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_565917696 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_565917696;
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, region1.mNativeRegion,
                        //region2.mNativeRegion, op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.286 -0400", hash_original_method = "9B6C5B9AE4B0C715D06D485A7F8D4046", hash_generated_method = "C927D002CCE9A303051CBAFFD42F732B")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_696163758 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_696163758 = nativeToString(mNativeRegion);
        varB4EAC82CA7396A68D541C85D26508E83_696163758.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_696163758;
        // ---------- Original Method ----------
        //return nativeToString(mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.286 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "5D8B3E6D808298A5870B9A9EC808BEC5")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_946497839 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_946497839;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.287 -0400", hash_original_method = "D2434A1CAFA87CC30850BFCF09357749", hash_generated_method = "7E13DABC8EFBCF2A85846259DF670905")
    public void writeToParcel(Parcel p, int flags) {
        {
            boolean varD704EA22356746E9A56ADBBB4C97F8A4_580918620 = (!nativeWriteToParcel(mNativeRegion, p));
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException();
            } //End block
        } //End collapsed parenthetic
        addTaint(p.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //if (!nativeWriteToParcel(mNativeRegion, p)) {
            //throw new RuntimeException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.287 -0400", hash_original_method = "1060AF13EAB0782D5AA6FD12A9EA9F72", hash_generated_method = "71A5066C6BA09F6FA107F3EF26D504B8")
    @Override
    public boolean equals(Object obj) {
        Region peer;
        peer = (Region) obj;
        boolean var3AD8F6933DA7C0D2F9603EC218BF03E8_1182111321 = (nativeEquals(mNativeRegion, peer.mNativeRegion));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_566148337 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_566148337;
        // ---------- Original Method ----------
        //if (obj == null || !(obj instanceof Region)) {
            //return false;
        //}
        //Region peer = (Region) obj;
        //return nativeEquals(mNativeRegion, peer.mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.297 -0400", hash_original_method = "7B9D4EAB814BE6F839A0AFACF43162A1", hash_generated_method = "88533E051B74F60620695CD5B6D42F0C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.312 -0400", hash_original_method = "7C7B16974B0225DA07D6CF6E35F70776", hash_generated_method = "0D0259A260C7E5A85153DE4AB379BCC3")
    final int ni() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1171179298 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1171179298;
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
        //DSFIXME:  CODE0012: Native static method requires manual modeling
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.331 -0400", hash_original_field = "50CCBBF498983066FB87505BC8EF122F", hash_generated_field = "200FB204FCAF60B88F8DADAA8213325E")

    public static final Parcelable.Creator<Region> CREATOR
        = new Parcelable.Creator<Region>() {
            
            public Region createFromParcel(Parcel p) {
                int ni = nativeCreateFromParcel(p);
                if (ni == 0) {
                    throw new RuntimeException();
                }
                return new Region(ni);
            }
            public Region[] newArray(int size) {
                return new Region[size];
            }
    };
}

