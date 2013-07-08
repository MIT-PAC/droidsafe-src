package android.graphics;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class Region implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.389 -0400", hash_original_field = "39A8A1AE8A42CDC584C4F2F420719809", hash_generated_field = "BE18D4475688FDC46F0A31DE4104CC38")

    public int mNativeRegion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.389 -0400", hash_original_method = "0D8BB79D644235D834A5B870E7DE5E55", hash_generated_method = "E39C818312FCB6AA783B7BFB03E94023")
    public  Region() {
        this(nativeConstructor());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.390 -0400", hash_original_method = "ADA47703EEBAAF081A921E3B439FC136", hash_generated_method = "A09777D2102260181E3E2BD364A2770A")
    public  Region(Region region) {
        this(nativeConstructor());
        nativeSetRegion(mNativeRegion, region.mNativeRegion);
        addTaint(region.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.390 -0400", hash_original_method = "A1BEE89A791B5892C0419D31229063CC", hash_generated_method = "DD7F9984E03DE8897E830C80A8E503AC")
    public  Region(Rect r) {
        mNativeRegion = nativeConstructor();
        nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
        addTaint(r.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.391 -0400", hash_original_method = "3B1EBFADD13882DEC7CB8A7DB9BB782B", hash_generated_method = "864E2AA468A5C0CDD79590BC9201CFEA")
    public  Region(int left, int top, int right, int bottom) {
        mNativeRegion = nativeConstructor();
        nativeSetRect(mNativeRegion, left, top, right, bottom);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.391 -0400", hash_original_method = "AE1199122B801919FCCD86EFAEB8981E", hash_generated_method = "D76989F906C7903EBFB8F0E5C3DD4905")
      Region(int ni) {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException();
        } 
        mNativeRegion = ni;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.391 -0400", hash_original_method = "5B5253F8036AE411F7DD245C7F6E35C3", hash_generated_method = "016A964C73357547BF51727F07F054D8")
    private  Region(int ni, int dummy) {
        this(ni);
        addTaint(ni);
        addTaint(dummy);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.392 -0400", hash_original_method = "200ADD9307CCB536C203EAC015A5A024", hash_generated_method = "A1D8D2D68CAD63FF400E3E9B34FAD970")
    public void setEmpty() {
        nativeSetRect(mNativeRegion, 0, 0, 0, 0);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.393 -0400", hash_original_method = "4FCDB3DC16FC27229A4383057FFC976C", hash_generated_method = "E754B5A2EAFFC9C197F1AC9974CD0654")
    public boolean set(Region region) {
        boolean varFD6438F9B0E81607A15A2B33F843B9FB_860933043 = (nativeSetRegion(mNativeRegion, region.mNativeRegion));
        addTaint(region.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_109048113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_109048113;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.393 -0400", hash_original_method = "C2513170875A2D5A2EB27E891206577A", hash_generated_method = "CF3996EBBCBD43E2C1F68E2FA35DE471")
    public boolean set(Rect r) {
        boolean var25DF7F0C1A123F4C32CF83DCE205F87D_119988085 = (nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1790267845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1790267845;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.394 -0400", hash_original_method = "D06421CD512172DCB28D2F3E0620053E", hash_generated_method = "CA2F4D41BDDC1CAC828EBCB14BCA2D69")
    public boolean set(int left, int top, int right, int bottom) {
        boolean varAA92C668356049C143CCD434BB32A02D_2093118291 = (nativeSetRect(mNativeRegion, left, top, right, bottom));
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1697642857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1697642857;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.394 -0400", hash_original_method = "E058C8FF714DCD6DC5C3B199CE291ABB", hash_generated_method = "18CCD2FF2A3DEBA3703CA5C4B7C53A6C")
    public boolean setPath(Path path, Region clip) {
        boolean var031F6EBD4CDCFA81D22115484A3E2F03_468315750 = (nativeSetPath(mNativeRegion, path.ni(), clip.mNativeRegion));
        addTaint(path.getTaint());
        addTaint(clip.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1442315663 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1442315663;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.394 -0400", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "373F32B5C5D9D821C78FC87256AD696D")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_578762212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_578762212;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.395 -0400", hash_original_method = "2BE881D6CE1CF3506EFB49B5287B67D4", hash_generated_method = "188A3C2840198A9E3A100F2DF56554F7")
    public boolean isRect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1926706982 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1926706982;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.395 -0400", hash_original_method = "96E541304104A48A190119203B0E80D4", hash_generated_method = "D52979BD919B9DA829AAE8D4E0B130E4")
    public boolean isComplex() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_652653039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_652653039;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.396 -0400", hash_original_method = "EBA477C7AF945181ADA3A9B8177742BE", hash_generated_method = "D31BF811D58BE32FACADA755296C2CA2")
    public Rect getBounds() {
        Rect varB4EAC82CA7396A68D541C85D26508E83_861795964 = null; 
        Rect r = new Rect();
        nativeGetBounds(mNativeRegion, r);
        varB4EAC82CA7396A68D541C85D26508E83_861795964 = r;
        varB4EAC82CA7396A68D541C85D26508E83_861795964.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_861795964;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.396 -0400", hash_original_method = "A46555E1E49458678846473DF9E9883B", hash_generated_method = "4C401D2140682252E5ACC0B5E2CBCD25")
    public boolean getBounds(Rect r) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        boolean var612724CC1222E7287B756B46F505C1EB_325126881 = (nativeGetBounds(mNativeRegion, r));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_199502102 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_199502102;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.397 -0400", hash_original_method = "378316FE7952FD732F90591AB3699DE2", hash_generated_method = "C4D35FF6C702AB7B68CF39E4B822C543")
    public Path getBoundaryPath() {
        Path varB4EAC82CA7396A68D541C85D26508E83_1466174278 = null; 
        Path path = new Path();
        nativeGetBoundaryPath(mNativeRegion, path.ni());
        varB4EAC82CA7396A68D541C85D26508E83_1466174278 = path;
        varB4EAC82CA7396A68D541C85D26508E83_1466174278.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1466174278;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.397 -0400", hash_original_method = "4EAA9FC9D13D7E90DDD0EEB1CB6196B1", hash_generated_method = "FAA59FCA9AB75C97383A8AF5D8071E20")
    public boolean getBoundaryPath(Path path) {
        boolean var7A07334C6D667AC5F4DCF43B96AAF16A_2065108428 = (nativeGetBoundaryPath(mNativeRegion, path.ni()));
        addTaint(path.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_737049622 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_737049622;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.398 -0400", hash_original_method = "5B0A75408C2B4CF9238ADD529FC37D02", hash_generated_method = "5C600B7804C83F1F5F6229F0DDD45561")
    public boolean contains(int x, int y) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1135233485 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1135233485;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.398 -0400", hash_original_method = "963E643D37666FF20B3A3B029F181389", hash_generated_method = "E19D2527CC218CA739AF6F435B8490BF")
    public boolean quickContains(Rect r) {
        boolean var017062C31AD44FF41B703185E7097A3E_1148136164 = (quickContains(r.left, r.top, r.right, r.bottom));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1732679252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1732679252;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.398 -0400", hash_original_method = "F4780612A05468EA5B4971365E65F2E9", hash_generated_method = "80B3788EBA88FA4829D168BE023F346D")
    public boolean quickContains(int left, int top, int right,
                                        int bottom) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_519536572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_519536572;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.399 -0400", hash_original_method = "99713AAB8FDC91BA4FFF953154B93F70", hash_generated_method = "09AFCE326680885BDE70128544EBE08E")
    public boolean quickReject(Rect r) {
        boolean varB72F58AD7D20DCFFA79D3669C170785C_691314076 = (quickReject(r.left, r.top, r.right, r.bottom));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387937259 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_387937259;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.399 -0400", hash_original_method = "C7FE089D5B9638DFC662C69BB1CCA253", hash_generated_method = "15602AF1010EA4BC8541EE6E339C9781")
    public boolean quickReject(int left, int top, int right, int bottom) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1544138247 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1544138247;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.399 -0400", hash_original_method = "248FAC130B583135AFED72EC96EB473C", hash_generated_method = "5EE2BB218D26BE1B9F52E31FDFA64D06")
    public boolean quickReject(Region rgn) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1584539484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1584539484;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.400 -0400", hash_original_method = "1E0220698FB1311F0D8B9F18E7495908", hash_generated_method = "E24B5EF6D47ED52A756A2EA13DEC0030")
    public void translate(int dx, int dy) {
        translate(dx, dy, null);
        addTaint(dx);
        addTaint(dy);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.400 -0400", hash_original_method = "F2F101D23D8556E25BBA4D0A405F0CD3", hash_generated_method = "2A31251C6E83A876D8030DE3CA7F91C4")
    public void translate(int dx, int dy, Region dst) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.400 -0400", hash_original_method = "39111F1C858A6D228BD34A5A0563D24D", hash_generated_method = "A4ED0A074CB69C62A947FAC105ECCFB4")
    public void scale(float scale) {
        scale(scale, null);
        addTaint(scale);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.401 -0400", hash_original_method = "704645B9B50E78F1B3F526FB095B5A0C", hash_generated_method = "93622E1801E30E8106831D2D97D909FA")
    public void scale(float scale, Region dst) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.401 -0400", hash_original_method = "50F2C1285B4A35F7EE8C85CE7082EAF5", hash_generated_method = "2CF52B1D46136132FC42F7E397C80399")
    public final boolean union(Rect r) {
        boolean varF191283E3A07FEE13EB2FB081B34FC0D_153780403 = (op(r, Op.UNION));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1742849328 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1742849328;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.402 -0400", hash_original_method = "0254EC2D8CB0B709656A3942F767CF9E", hash_generated_method = "59B92AB16C117D353F6D04F50E7B193D")
    public boolean op(Rect r, Op op) {
        boolean var90EAA618B3BAC1E5B315E4AB50A3912D_1716962582 = (nativeOp(mNativeRegion, r.left, r.top, r.right, r.bottom,
                        op.nativeInt));
        addTaint(r.getTaint());
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1966513614 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1966513614;
        
        
                        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.402 -0400", hash_original_method = "F7B19A9596841ACD8A98EA48656877B1", hash_generated_method = "E2A811242398A4FF0C0325858AFE9E26")
    public boolean op(int left, int top, int right, int bottom, Op op) {
        boolean varABC9D9B2705AE309B237F72644A5AB34_1812177000 = (nativeOp(mNativeRegion, left, top, right, bottom,
                        op.nativeInt));
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_600968459 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_600968459;
        
        
                        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.403 -0400", hash_original_method = "7B6B61AB972DEFAAC29D5DA42EF8C210", hash_generated_method = "3B27538E707B9DBC1E743764F486C638")
    public boolean op(Region region, Op op) {
        boolean var0AD004458B8F75085CC4F6F5BFEA2284_1410868384 = (op(this, region, op));
        addTaint(region.getTaint());
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_472517145 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_472517145;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.404 -0400", hash_original_method = "029ED340525EAD4C240C408219CCC448", hash_generated_method = "62BEEE20D595AB3A6FBA5A6523C6746A")
    public boolean op(Rect rect, Region region, Op op) {
        boolean varB0742BC4953C9AFE0E99DE4F785439D4_85318054 = (nativeOp(mNativeRegion, rect, region.mNativeRegion,
                        op.nativeInt));
        addTaint(rect.getTaint());
        addTaint(region.getTaint());
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1219152386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1219152386;
        
        
                        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.404 -0400", hash_original_method = "7FDA52C90EA81767BFA435745FBF29BC", hash_generated_method = "55567FFAFC4B50FB0445B4D5311FCCD0")
    public boolean op(Region region1, Region region2, Op op) {
        boolean var0855EC438B898D69658174303EBCB740_1547308905 = (nativeOp(mNativeRegion, region1.mNativeRegion,
                        region2.mNativeRegion, op.nativeInt));
        addTaint(region1.getTaint());
        addTaint(region2.getTaint());
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2001409837 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2001409837;
        
        
                        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.286 -0400", hash_original_method = "9B6C5B9AE4B0C715D06D485A7F8D4046", hash_generated_method = "C927D002CCE9A303051CBAFFD42F732B")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_696163758 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_696163758 = new String();
        varB4EAC82CA7396A68D541C85D26508E83_696163758.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_696163758;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.405 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "5D2A239F40013AC2471F59331AA58CA1")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284711407 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284711407;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.406 -0400", hash_original_method = "D2434A1CAFA87CC30850BFCF09357749", hash_generated_method = "311B69B371B46F7494E5EC8A0FAC8890")
    public void writeToParcel(Parcel p, int flags) {
        {
            boolean varD704EA22356746E9A56ADBBB4C97F8A4_1663372985 = (!nativeWriteToParcel(mNativeRegion, p));
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException();
            } 
        } 
        addTaint(p.getTaint());
        addTaint(flags);
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.406 -0400", hash_original_method = "1060AF13EAB0782D5AA6FD12A9EA9F72", hash_generated_method = "471947E1793CDE89BF4A089F7C8CF0E6")
    @Override
    public boolean equals(Object obj) {
        Region peer = (Region) obj;
        boolean var3AD8F6933DA7C0D2F9603EC218BF03E8_860302647 = (nativeEquals(mNativeRegion, peer.mNativeRegion));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1316119175 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1316119175;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.407 -0400", hash_original_method = "7B9D4EAB814BE6F839A0AFACF43162A1", hash_generated_method = "88533E051B74F60620695CD5B6D42F0C")
    protected void finalize() throws Throwable {
        try 
        {
            nativeDestructor(mNativeRegion);
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.407 -0400", hash_original_method = "7C7B16974B0225DA07D6CF6E35F70776", hash_generated_method = "D0E6207647C7F6A9150854BCE49DCCB5")
    final int ni() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717994427 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717994427;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeEquals(int native_r1, int native_r2) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeConstructor() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDestructor(int native_region) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeSetRegion(int native_dst,
                                                  int native_src) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeSetRect(int native_dst, int left,
                                                int top, int right, int bottom) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeSetPath(int native_dst, int native_path,
                                                int native_clip) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeGetBounds(int native_region, Rect rect) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeGetBoundaryPath(int native_region,
                                                        int native_path) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeOp(int native_dst, int left, int top,
                                           int right, int bottom, int op) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeOp(int native_dst, Rect rect,
                                           int native_region, int op) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeOp(int native_dst, int native_region1,
                                           int native_region2, int op) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeCreateFromParcel(Parcel p) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeWriteToParcel(int native_region,
                                                      Parcel p) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static String nativeToString(int native_region) {
        	return ""; 
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.410 -0400", hash_original_field = "50CCBBF498983066FB87505BC8EF122F", hash_generated_field = "200FB204FCAF60B88F8DADAA8213325E")

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

