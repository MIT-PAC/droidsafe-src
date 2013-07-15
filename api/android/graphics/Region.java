package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public class Region implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.289 -0400", hash_original_field = "39A8A1AE8A42CDC584C4F2F420719809", hash_generated_field = "BE18D4475688FDC46F0A31DE4104CC38")

    public int mNativeRegion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.290 -0400", hash_original_method = "0D8BB79D644235D834A5B870E7DE5E55", hash_generated_method = "E39C818312FCB6AA783B7BFB03E94023")
    public  Region() {
        this(nativeConstructor());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.290 -0400", hash_original_method = "ADA47703EEBAAF081A921E3B439FC136", hash_generated_method = "582253F2DAC4B25A9646718BCF02E18A")
    public  Region(Region region) {
        this(nativeConstructor());
        addTaint(region.getTaint());
        nativeSetRegion(mNativeRegion, region.mNativeRegion);
        // ---------- Original Method ----------
        //nativeSetRegion(mNativeRegion, region.mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.290 -0400", hash_original_method = "A1BEE89A791B5892C0419D31229063CC", hash_generated_method = "14114442245D1B4BD280000ECC27ED02")
    public  Region(Rect r) {
        addTaint(r.getTaint());
        mNativeRegion = nativeConstructor();
        nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
        // ---------- Original Method ----------
        //mNativeRegion = nativeConstructor();
        //nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.291 -0400", hash_original_method = "3B1EBFADD13882DEC7CB8A7DB9BB782B", hash_generated_method = "E86BD36C25460E44FE220E2247882CFB")
    public  Region(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        mNativeRegion = nativeConstructor();
        nativeSetRect(mNativeRegion, left, top, right, bottom);
        // ---------- Original Method ----------
        //mNativeRegion = nativeConstructor();
        //nativeSetRect(mNativeRegion, left, top, right, bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.291 -0400", hash_original_method = "AE1199122B801919FCCD86EFAEB8981E", hash_generated_method = "7472ACE5C029CE9D1729441DFE480C65")
      Region(int ni) {
    if(ni == 0)        
        {
            RuntimeException varF1484B21EF4EE84F790184975238945B_1910786447 = new RuntimeException();
            varF1484B21EF4EE84F790184975238945B_1910786447.addTaint(taint);
            throw varF1484B21EF4EE84F790184975238945B_1910786447;
        } //End block
        mNativeRegion = ni;
        // ---------- Original Method ----------
        //if (ni == 0) {
            //throw new RuntimeException();
        //}
        //mNativeRegion = ni;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.292 -0400", hash_original_method = "5B5253F8036AE411F7DD245C7F6E35C3", hash_generated_method = "01C6E0BEBF91446973826C5A49A77230")
    private  Region(int ni, int dummy) {
        this(ni);
        addTaint(dummy);
        addTaint(ni);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.292 -0400", hash_original_method = "200ADD9307CCB536C203EAC015A5A024", hash_generated_method = "A1D8D2D68CAD63FF400E3E9B34FAD970")
    public void setEmpty() {
        nativeSetRect(mNativeRegion, 0, 0, 0, 0);
        // ---------- Original Method ----------
        //nativeSetRect(mNativeRegion, 0, 0, 0, 0);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.292 -0400", hash_original_method = "4FCDB3DC16FC27229A4383057FFC976C", hash_generated_method = "163A545CCC51FE5A28E37CB1708DD693")
    public boolean set(Region region) {
        addTaint(region.getTaint());
        boolean var4742FCE111FE94CEC1DF70182FA0F994_212901265 = (nativeSetRegion(mNativeRegion, region.mNativeRegion));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_909638984 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_909638984;
        // ---------- Original Method ----------
        //return nativeSetRegion(mNativeRegion, region.mNativeRegion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.293 -0400", hash_original_method = "C2513170875A2D5A2EB27E891206577A", hash_generated_method = "60E4E93B8F9910E94455AA2E3D7D325B")
    public boolean set(Rect r) {
        addTaint(r.getTaint());
        boolean var670334B4B8CBA37910CFC6A6068E65EF_1350552752 = (nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_493797359 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_493797359;
        // ---------- Original Method ----------
        //return nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.293 -0400", hash_original_method = "D06421CD512172DCB28D2F3E0620053E", hash_generated_method = "CD23584289B8B47B8FB1898A223543C4")
    public boolean set(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean var0F998888D9C85E260DD70D2C5BB13C80_661199062 = (nativeSetRect(mNativeRegion, left, top, right, bottom));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_62400539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_62400539;
        // ---------- Original Method ----------
        //return nativeSetRect(mNativeRegion, left, top, right, bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.294 -0400", hash_original_method = "E058C8FF714DCD6DC5C3B199CE291ABB", hash_generated_method = "B96EBA650784A58686F6D639BDAFE567")
    public boolean setPath(Path path, Region clip) {
        addTaint(clip.getTaint());
        addTaint(path.getTaint());
        boolean varD91396C7F1E58A93899ACB6C012572DE_1451220173 = (nativeSetPath(mNativeRegion, path.ni(), clip.mNativeRegion));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1930297318 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1930297318;
        // ---------- Original Method ----------
        //return nativeSetPath(mNativeRegion, path.ni(), clip.mNativeRegion);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.294 -0400", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "3CDEB18F64CBA5D432AA74BB65342C52")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394009208 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394009208;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.295 -0400", hash_original_method = "2BE881D6CE1CF3506EFB49B5287B67D4", hash_generated_method = "D1A90B70236BFF6E0DDABDA18301483C")
    public boolean isRect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1669255879 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1669255879;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.295 -0400", hash_original_method = "96E541304104A48A190119203B0E80D4", hash_generated_method = "E93A7F820AD0DDC86AFAA160466E505A")
    public boolean isComplex() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1796267356 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1796267356;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.295 -0400", hash_original_method = "EBA477C7AF945181ADA3A9B8177742BE", hash_generated_method = "80E4757C862908705E40498EFE139CC8")
    public Rect getBounds() {
        Rect r = new Rect();
        nativeGetBounds(mNativeRegion, r);
Rect var4C1F3C86A0E56B6E375080F5F710547E_993470561 =         r;
        var4C1F3C86A0E56B6E375080F5F710547E_993470561.addTaint(taint);
        return var4C1F3C86A0E56B6E375080F5F710547E_993470561;
        // ---------- Original Method ----------
        //Rect r = new Rect();
        //nativeGetBounds(mNativeRegion, r);
        //return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.296 -0400", hash_original_method = "A46555E1E49458678846473DF9E9883B", hash_generated_method = "A9B12273C4E0EBB3ABC09B5979BA8B98")
    public boolean getBounds(Rect r) {
        addTaint(r.getTaint());
    if(r == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1468164021 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1468164021.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1468164021;
        } //End block
        boolean var58166477F2E5A8B1618EDB1B05A8CD95_782154801 = (nativeGetBounds(mNativeRegion, r));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_661893533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_661893533;
        // ---------- Original Method ----------
        //if (r == null) {
            //throw new NullPointerException();
        //}
        //return nativeGetBounds(mNativeRegion, r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.296 -0400", hash_original_method = "378316FE7952FD732F90591AB3699DE2", hash_generated_method = "F94332256A892FE2710C1DBDAFF06841")
    public Path getBoundaryPath() {
        Path path = new Path();
        nativeGetBoundaryPath(mNativeRegion, path.ni());
Path var535F4D9720F3B0C96D8143873CE0638C_1372078618 =         path;
        var535F4D9720F3B0C96D8143873CE0638C_1372078618.addTaint(taint);
        return var535F4D9720F3B0C96D8143873CE0638C_1372078618;
        // ---------- Original Method ----------
        //Path path = new Path();
        //nativeGetBoundaryPath(mNativeRegion, path.ni());
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.296 -0400", hash_original_method = "4EAA9FC9D13D7E90DDD0EEB1CB6196B1", hash_generated_method = "950F1C3CE1EF924DE9430F5A8CED01D5")
    public boolean getBoundaryPath(Path path) {
        addTaint(path.getTaint());
        boolean var44F7C68BB6E54F8B1274432605BED09D_1923171032 = (nativeGetBoundaryPath(mNativeRegion, path.ni()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_447430276 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_447430276;
        // ---------- Original Method ----------
        //return nativeGetBoundaryPath(mNativeRegion, path.ni());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.297 -0400", hash_original_method = "5B0A75408C2B4CF9238ADD529FC37D02", hash_generated_method = "834FA7F298C2462B532A950EA6D7FF18")
    public boolean contains(int x, int y) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1253365900 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1253365900;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.297 -0400", hash_original_method = "963E643D37666FF20B3A3B029F181389", hash_generated_method = "3DF12CDF9EC9A5160306CD1251926242")
    public boolean quickContains(Rect r) {
        addTaint(r.getTaint());
        boolean var4761C687211BFF5E720AAEF108F51958_1273692624 = (quickContains(r.left, r.top, r.right, r.bottom));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1231103935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1231103935;
        // ---------- Original Method ----------
        //return quickContains(r.left, r.top, r.right, r.bottom);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.298 -0400", hash_original_method = "F4780612A05468EA5B4971365E65F2E9", hash_generated_method = "FC00FFD3A459ECB3A36D502E7E4D2387")
    public boolean quickContains(int left, int top, int right,
                                        int bottom) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_968700752 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_968700752;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.298 -0400", hash_original_method = "99713AAB8FDC91BA4FFF953154B93F70", hash_generated_method = "F870C3A8BBB7E8B21FF5D87BE52F00DC")
    public boolean quickReject(Rect r) {
        addTaint(r.getTaint());
        boolean varFB599CEA3600EA81BEA95891D33ED082_1680626188 = (quickReject(r.left, r.top, r.right, r.bottom));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_321387182 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_321387182;
        // ---------- Original Method ----------
        //return quickReject(r.left, r.top, r.right, r.bottom);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.298 -0400", hash_original_method = "C7FE089D5B9638DFC662C69BB1CCA253", hash_generated_method = "6EFF8182CF37F2C294D9F3B100D91F2F")
    public boolean quickReject(int left, int top, int right, int bottom) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_868474879 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_868474879;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.299 -0400", hash_original_method = "248FAC130B583135AFED72EC96EB473C", hash_generated_method = "DB3B9CA07DAE7676E5640D3F1556B733")
    public boolean quickReject(Region rgn) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1815278621 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1815278621;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.299 -0400", hash_original_method = "1E0220698FB1311F0D8B9F18E7495908", hash_generated_method = "F41CB55792DFB6AF73AE3365E76E7164")
    public void translate(int dx, int dy) {
        addTaint(dy);
        addTaint(dx);
        translate(dx, dy, null);
        // ---------- Original Method ----------
        //translate(dx, dy, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.300 -0400", hash_original_method = "F2F101D23D8556E25BBA4D0A405F0CD3", hash_generated_method = "2A31251C6E83A876D8030DE3CA7F91C4")
    public void translate(int dx, int dy, Region dst) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.300 -0400", hash_original_method = "39111F1C858A6D228BD34A5A0563D24D", hash_generated_method = "D91EAAD3D7EC8A230C5EB71204DB1B93")
    public void scale(float scale) {
        addTaint(scale);
        scale(scale, null);
        // ---------- Original Method ----------
        //scale(scale, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.301 -0400", hash_original_method = "704645B9B50E78F1B3F526FB095B5A0C", hash_generated_method = "93622E1801E30E8106831D2D97D909FA")
    public void scale(float scale, Region dst) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.301 -0400", hash_original_method = "50F2C1285B4A35F7EE8C85CE7082EAF5", hash_generated_method = "CA46692579FD5AEBFE0DA03A2C10F5C3")
    public final boolean union(Rect r) {
        addTaint(r.getTaint());
        boolean var045068AD26987A1F92CE9CEBD3F1BE8A_1962236861 = (op(r, Op.UNION));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1405505329 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1405505329;
        // ---------- Original Method ----------
        //return op(r, Op.UNION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.302 -0400", hash_original_method = "0254EC2D8CB0B709656A3942F767CF9E", hash_generated_method = "2F6EE79288F441EC5A7624CC883294BC")
    public boolean op(Rect r, Op op) {
        addTaint(op.getTaint());
        addTaint(r.getTaint());
        boolean varAE455A039BD49CAC65B462237D1BBF58_477597237 = (nativeOp(mNativeRegion, r.left, r.top, r.right, r.bottom,
                        op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1454999747 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1454999747;
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, r.left, r.top, r.right, r.bottom,
                        //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.303 -0400", hash_original_method = "F7B19A9596841ACD8A98EA48656877B1", hash_generated_method = "907A811B7BD96A3720751D04C3F39E58")
    public boolean op(int left, int top, int right, int bottom, Op op) {
        addTaint(op.getTaint());
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean var55806BEBBCF11C7AD487B8C5B4858A2F_384130044 = (nativeOp(mNativeRegion, left, top, right, bottom,
                        op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1235210244 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1235210244;
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, left, top, right, bottom,
                        //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.303 -0400", hash_original_method = "7B6B61AB972DEFAAC29D5DA42EF8C210", hash_generated_method = "A20D5F2E58A1469415052F01F9BBB2C5")
    public boolean op(Region region, Op op) {
        addTaint(op.getTaint());
        addTaint(region.getTaint());
        boolean varEBA559D10BE2859E15E22C87BDD24E3A_1682590735 = (op(this, region, op));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_877292526 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_877292526;
        // ---------- Original Method ----------
        //return op(this, region, op);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.304 -0400", hash_original_method = "029ED340525EAD4C240C408219CCC448", hash_generated_method = "F2ED5C6471AA7DC4DE0F5329065DADBD")
    public boolean op(Rect rect, Region region, Op op) {
        addTaint(op.getTaint());
        addTaint(region.getTaint());
        addTaint(rect.getTaint());
        boolean var7D4D54B1E37211C95931ED416A003041_755304725 = (nativeOp(mNativeRegion, rect, region.mNativeRegion,
                        op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1368880428 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1368880428;
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, rect, region.mNativeRegion,
                        //op.nativeInt);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.305 -0400", hash_original_method = "7FDA52C90EA81767BFA435745FBF29BC", hash_generated_method = "0F64815A039DF8BDB5F9D1C12EF29BBF")
    public boolean op(Region region1, Region region2, Op op) {
        addTaint(op.getTaint());
        addTaint(region2.getTaint());
        addTaint(region1.getTaint());
        boolean var008F5F73B040131B8A98200BC7089D69_483113140 = (nativeOp(mNativeRegion, region1.mNativeRegion,
                        region2.mNativeRegion, op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1310958558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1310958558;
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, region1.mNativeRegion,
                        //region2.mNativeRegion, op.nativeInt);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.306 -0400", hash_original_method = "9B6C5B9AE4B0C715D06D485A7F8D4046", hash_generated_method = "05C51D767125E00CC47509D5974F0E43")
    public String toString() {
String varDDC806D031E96ADAFEE4C9E5395D6E1C_1499967690 =         nativeToString(mNativeRegion);
        varDDC806D031E96ADAFEE4C9E5395D6E1C_1499967690.addTaint(taint);
        return varDDC806D031E96ADAFEE4C9E5395D6E1C_1499967690;
        // ---------- Original Method ----------
        //return nativeToString(mNativeRegion);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.306 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0F9BC93AE3D5CCBAFFBB68AF3856FF67")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1467849276 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901935640 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901935640;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.307 -0400", hash_original_method = "D2434A1CAFA87CC30850BFCF09357749", hash_generated_method = "CACDCDDBDA0DDB8F3591182ABC23E3E5")
    public void writeToParcel(Parcel p, int flags) {
        addTaint(flags);
        addTaint(p.getTaint());
    if(!nativeWriteToParcel(mNativeRegion, p))        
        {
            RuntimeException varF1484B21EF4EE84F790184975238945B_459754689 = new RuntimeException();
            varF1484B21EF4EE84F790184975238945B_459754689.addTaint(taint);
            throw varF1484B21EF4EE84F790184975238945B_459754689;
        } //End block
        // ---------- Original Method ----------
        //if (!nativeWriteToParcel(mNativeRegion, p)) {
            //throw new RuntimeException();
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.309 -0400", hash_original_method = "1060AF13EAB0782D5AA6FD12A9EA9F72", hash_generated_method = "C3C73F30D94E68ED6D9BD81925029104")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(obj == null || !(obj instanceof Region))        
        {
            boolean var68934A3E9455FA72420237EB05902327_109375661 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_373879511 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_373879511;
        } //End block
        Region peer = (Region) obj;
        boolean varB5D17C638607BD87EFEB2B9211C51074_1327882737 = (nativeEquals(mNativeRegion, peer.mNativeRegion));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1498427699 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1498427699;
        // ---------- Original Method ----------
        //if (obj == null || !(obj instanceof Region)) {
            //return false;
        //}
        //Region peer = (Region) obj;
        //return nativeEquals(mNativeRegion, peer.mNativeRegion);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.310 -0400", hash_original_method = "7B9D4EAB814BE6F839A0AFACF43162A1", hash_generated_method = "88533E051B74F60620695CD5B6D42F0C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.311 -0400", hash_original_method = "7C7B16974B0225DA07D6CF6E35F70776", hash_generated_method = "F753A186DE17ED9BFA2FD2794F8A2998")
    final int ni() {
        int var39A8A1AE8A42CDC584C4F2F420719809_259546367 = (mNativeRegion);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_354632023 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_354632023;
        // ---------- Original Method ----------
        //return mNativeRegion;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.317 -0400", hash_original_field = "50CCBBF498983066FB87505BC8EF122F", hash_generated_field = "200FB204FCAF60B88F8DADAA8213325E")

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

