package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public class Region implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.082 -0400", hash_original_field = "39A8A1AE8A42CDC584C4F2F420719809", hash_generated_field = "BE18D4475688FDC46F0A31DE4104CC38")

    public int mNativeRegion;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.083 -0400", hash_original_method = "0D8BB79D644235D834A5B870E7DE5E55", hash_generated_method = "E39C818312FCB6AA783B7BFB03E94023")
    public  Region() {
        this(nativeConstructor());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.084 -0400", hash_original_method = "ADA47703EEBAAF081A921E3B439FC136", hash_generated_method = "582253F2DAC4B25A9646718BCF02E18A")
    public  Region(Region region) {
        this(nativeConstructor());
        addTaint(region.getTaint());
        nativeSetRegion(mNativeRegion, region.mNativeRegion);
        // ---------- Original Method ----------
        //nativeSetRegion(mNativeRegion, region.mNativeRegion);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.084 -0400", hash_original_method = "A1BEE89A791B5892C0419D31229063CC", hash_generated_method = "14114442245D1B4BD280000ECC27ED02")
    public  Region(Rect r) {
        addTaint(r.getTaint());
        mNativeRegion = nativeConstructor();
        nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
        // ---------- Original Method ----------
        //mNativeRegion = nativeConstructor();
        //nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.085 -0400", hash_original_method = "3B1EBFADD13882DEC7CB8A7DB9BB782B", hash_generated_method = "E86BD36C25460E44FE220E2247882CFB")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.085 -0400", hash_original_method = "AE1199122B801919FCCD86EFAEB8981E", hash_generated_method = "90EFC0132FCB4FC85D2BF17BB5D915AC")
      Region(int ni) {
        if(ni == 0)        
        {
            RuntimeException varF1484B21EF4EE84F790184975238945B_338901481 = new RuntimeException();
            varF1484B21EF4EE84F790184975238945B_338901481.addTaint(taint);
            throw varF1484B21EF4EE84F790184975238945B_338901481;
        } //End block
        mNativeRegion = ni;
        // ---------- Original Method ----------
        //if (ni == 0) {
            //throw new RuntimeException();
        //}
        //mNativeRegion = ni;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.086 -0400", hash_original_method = "5B5253F8036AE411F7DD245C7F6E35C3", hash_generated_method = "01C6E0BEBF91446973826C5A49A77230")
    private  Region(int ni, int dummy) {
        this(ni);
        addTaint(dummy);
        addTaint(ni);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.086 -0400", hash_original_method = "200ADD9307CCB536C203EAC015A5A024", hash_generated_method = "A1D8D2D68CAD63FF400E3E9B34FAD970")
    public void setEmpty() {
        nativeSetRect(mNativeRegion, 0, 0, 0, 0);
        // ---------- Original Method ----------
        //nativeSetRect(mNativeRegion, 0, 0, 0, 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.086 -0400", hash_original_method = "4FCDB3DC16FC27229A4383057FFC976C", hash_generated_method = "59BC7FFE7881B50496F68C30D1DDF35B")
    public boolean set(Region region) {
        addTaint(region.getTaint());
        boolean var4742FCE111FE94CEC1DF70182FA0F994_222903328 = (nativeSetRegion(mNativeRegion, region.mNativeRegion));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_215019183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_215019183;
        // ---------- Original Method ----------
        //return nativeSetRegion(mNativeRegion, region.mNativeRegion);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.087 -0400", hash_original_method = "C2513170875A2D5A2EB27E891206577A", hash_generated_method = "75BA5FFE8CC9BD0C6D2CD47FB63CD985")
    public boolean set(Rect r) {
        addTaint(r.getTaint());
        boolean var670334B4B8CBA37910CFC6A6068E65EF_507248317 = (nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_176599207 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_176599207;
        // ---------- Original Method ----------
        //return nativeSetRect(mNativeRegion, r.left, r.top, r.right, r.bottom);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.087 -0400", hash_original_method = "D06421CD512172DCB28D2F3E0620053E", hash_generated_method = "2636E3337B87DB0E37CF43F9E2BF9C98")
    public boolean set(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean var0F998888D9C85E260DD70D2C5BB13C80_244265941 = (nativeSetRect(mNativeRegion, left, top, right, bottom));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1469697714 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1469697714;
        // ---------- Original Method ----------
        //return nativeSetRect(mNativeRegion, left, top, right, bottom);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.088 -0400", hash_original_method = "E058C8FF714DCD6DC5C3B199CE291ABB", hash_generated_method = "D36FBE475B73C67B4B5B757FEC044601")
    public boolean setPath(Path path, Region clip) {
        addTaint(clip.getTaint());
        addTaint(path.getTaint());
        boolean varD91396C7F1E58A93899ACB6C012572DE_550569802 = (nativeSetPath(mNativeRegion, path.ni(), clip.mNativeRegion));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_416235293 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_416235293;
        // ---------- Original Method ----------
        //return nativeSetPath(mNativeRegion, path.ni(), clip.mNativeRegion);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.088 -0400", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "4A620D8FFF0E47FE19494CF8E004F970")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_251750964 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_251750964;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.088 -0400", hash_original_method = "2BE881D6CE1CF3506EFB49B5287B67D4", hash_generated_method = "D7890BE07A28E818032F4ADD3E586B12")
    public boolean isRect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_834223071 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_834223071;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.088 -0400", hash_original_method = "96E541304104A48A190119203B0E80D4", hash_generated_method = "F68CA19DEA1ACA872206A0832DB0FA9A")
    public boolean isComplex() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_249827442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_249827442;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.089 -0400", hash_original_method = "EBA477C7AF945181ADA3A9B8177742BE", hash_generated_method = "9F44386FCC5F18E03E989A669F3A24B8")
    public Rect getBounds() {
        Rect r = new Rect();
        nativeGetBounds(mNativeRegion, r);
Rect var4C1F3C86A0E56B6E375080F5F710547E_42161986 =         r;
        var4C1F3C86A0E56B6E375080F5F710547E_42161986.addTaint(taint);
        return var4C1F3C86A0E56B6E375080F5F710547E_42161986;
        // ---------- Original Method ----------
        //Rect r = new Rect();
        //nativeGetBounds(mNativeRegion, r);
        //return r;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.089 -0400", hash_original_method = "A46555E1E49458678846473DF9E9883B", hash_generated_method = "2C7E2D61291DAF14112F226105F6933B")
    public boolean getBounds(Rect r) {
        addTaint(r.getTaint());
        if(r == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1295136282 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1295136282.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1295136282;
        } //End block
        boolean var58166477F2E5A8B1618EDB1B05A8CD95_358679555 = (nativeGetBounds(mNativeRegion, r));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1353772543 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1353772543;
        // ---------- Original Method ----------
        //if (r == null) {
            //throw new NullPointerException();
        //}
        //return nativeGetBounds(mNativeRegion, r);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.090 -0400", hash_original_method = "378316FE7952FD732F90591AB3699DE2", hash_generated_method = "2308FE5CD091FFD22DA39611D1B52ECF")
    public Path getBoundaryPath() {
        Path path = new Path();
        nativeGetBoundaryPath(mNativeRegion, path.ni());
Path var535F4D9720F3B0C96D8143873CE0638C_229971889 =         path;
        var535F4D9720F3B0C96D8143873CE0638C_229971889.addTaint(taint);
        return var535F4D9720F3B0C96D8143873CE0638C_229971889;
        // ---------- Original Method ----------
        //Path path = new Path();
        //nativeGetBoundaryPath(mNativeRegion, path.ni());
        //return path;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.090 -0400", hash_original_method = "4EAA9FC9D13D7E90DDD0EEB1CB6196B1", hash_generated_method = "82CA0E3201E179A182F1C5B58EE323E3")
    public boolean getBoundaryPath(Path path) {
        addTaint(path.getTaint());
        boolean var44F7C68BB6E54F8B1274432605BED09D_1455506767 = (nativeGetBoundaryPath(mNativeRegion, path.ni()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1120695993 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1120695993;
        // ---------- Original Method ----------
        //return nativeGetBoundaryPath(mNativeRegion, path.ni());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.090 -0400", hash_original_method = "5B0A75408C2B4CF9238ADD529FC37D02", hash_generated_method = "E7A2E4D5687265DAF2816C17FEF3EA09")
    public boolean contains(int x, int y) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1224292229 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1224292229;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.091 -0400", hash_original_method = "963E643D37666FF20B3A3B029F181389", hash_generated_method = "76A0D8B69DBD7B57287B9FE87B712A63")
    public boolean quickContains(Rect r) {
        addTaint(r.getTaint());
        boolean var4761C687211BFF5E720AAEF108F51958_1928191020 = (quickContains(r.left, r.top, r.right, r.bottom));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_732769216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_732769216;
        // ---------- Original Method ----------
        //return quickContains(r.left, r.top, r.right, r.bottom);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.091 -0400", hash_original_method = "F4780612A05468EA5B4971365E65F2E9", hash_generated_method = "77CFBDE5E894A1B8FB9530CB2CC35410")
    public boolean quickContains(int left, int top, int right,
                                        int bottom) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1837045759 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1837045759;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.092 -0400", hash_original_method = "99713AAB8FDC91BA4FFF953154B93F70", hash_generated_method = "4CFF413F138F98A02D25461B70000C21")
    public boolean quickReject(Rect r) {
        addTaint(r.getTaint());
        boolean varFB599CEA3600EA81BEA95891D33ED082_617182370 = (quickReject(r.left, r.top, r.right, r.bottom));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1163351546 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1163351546;
        // ---------- Original Method ----------
        //return quickReject(r.left, r.top, r.right, r.bottom);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.092 -0400", hash_original_method = "C7FE089D5B9638DFC662C69BB1CCA253", hash_generated_method = "5D2BE9EF19B00D5509EEDF64A86DE2F0")
    public boolean quickReject(int left, int top, int right, int bottom) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_295054577 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_295054577;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.092 -0400", hash_original_method = "248FAC130B583135AFED72EC96EB473C", hash_generated_method = "70052E209823747C5EF6406C101B4B37")
    public boolean quickReject(Region rgn) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_668817601 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_668817601;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.093 -0400", hash_original_method = "1E0220698FB1311F0D8B9F18E7495908", hash_generated_method = "F41CB55792DFB6AF73AE3365E76E7164")
    public void translate(int dx, int dy) {
        addTaint(dy);
        addTaint(dx);
        translate(dx, dy, null);
        // ---------- Original Method ----------
        //translate(dx, dy, null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.093 -0400", hash_original_method = "F2F101D23D8556E25BBA4D0A405F0CD3", hash_generated_method = "2A31251C6E83A876D8030DE3CA7F91C4")
    public void translate(int dx, int dy, Region dst) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.094 -0400", hash_original_method = "39111F1C858A6D228BD34A5A0563D24D", hash_generated_method = "D91EAAD3D7EC8A230C5EB71204DB1B93")
    public void scale(float scale) {
        addTaint(scale);
        scale(scale, null);
        // ---------- Original Method ----------
        //scale(scale, null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.094 -0400", hash_original_method = "704645B9B50E78F1B3F526FB095B5A0C", hash_generated_method = "93622E1801E30E8106831D2D97D909FA")
    public void scale(float scale, Region dst) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.095 -0400", hash_original_method = "50F2C1285B4A35F7EE8C85CE7082EAF5", hash_generated_method = "E28FF6FDB78742B2692835CC7A8606DC")
    public final boolean union(Rect r) {
        addTaint(r.getTaint());
        boolean var045068AD26987A1F92CE9CEBD3F1BE8A_789141378 = (op(r, Op.UNION));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2113904038 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2113904038;
        // ---------- Original Method ----------
        //return op(r, Op.UNION);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.096 -0400", hash_original_method = "0254EC2D8CB0B709656A3942F767CF9E", hash_generated_method = "9C5826A199EE0327FCC28E1D6379C340")
    public boolean op(Rect r, Op op) {
        addTaint(op.getTaint());
        addTaint(r.getTaint());
        boolean varAE455A039BD49CAC65B462237D1BBF58_1396661967 = (nativeOp(mNativeRegion, r.left, r.top, r.right, r.bottom,
                        op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1697756908 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1697756908;
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, r.left, r.top, r.right, r.bottom,
                        //op.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.097 -0400", hash_original_method = "F7B19A9596841ACD8A98EA48656877B1", hash_generated_method = "09D9156AC3B383C2EE14864205A1F12F")
    public boolean op(int left, int top, int right, int bottom, Op op) {
        addTaint(op.getTaint());
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean var55806BEBBCF11C7AD487B8C5B4858A2F_617937181 = (nativeOp(mNativeRegion, left, top, right, bottom,
                        op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_52507577 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_52507577;
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, left, top, right, bottom,
                        //op.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.097 -0400", hash_original_method = "7B6B61AB972DEFAAC29D5DA42EF8C210", hash_generated_method = "B021FDE73DE2A81741E9CE9BE5D7333F")
    public boolean op(Region region, Op op) {
        addTaint(op.getTaint());
        addTaint(region.getTaint());
        boolean varEBA559D10BE2859E15E22C87BDD24E3A_226587662 = (op(this, region, op));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2075690015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2075690015;
        // ---------- Original Method ----------
        //return op(this, region, op);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.098 -0400", hash_original_method = "029ED340525EAD4C240C408219CCC448", hash_generated_method = "D204B4555E428293987268AE62960192")
    public boolean op(Rect rect, Region region, Op op) {
        addTaint(op.getTaint());
        addTaint(region.getTaint());
        addTaint(rect.getTaint());
        boolean var7D4D54B1E37211C95931ED416A003041_1323366388 = (nativeOp(mNativeRegion, rect, region.mNativeRegion,
                        op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1583912390 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1583912390;
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, rect, region.mNativeRegion,
                        //op.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.098 -0400", hash_original_method = "7FDA52C90EA81767BFA435745FBF29BC", hash_generated_method = "8072C9A84D60B28EAA5742AFC3A9513F")
    public boolean op(Region region1, Region region2, Op op) {
        addTaint(op.getTaint());
        addTaint(region2.getTaint());
        addTaint(region1.getTaint());
        boolean var008F5F73B040131B8A98200BC7089D69_624531829 = (nativeOp(mNativeRegion, region1.mNativeRegion,
                        region2.mNativeRegion, op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_527125776 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_527125776;
        // ---------- Original Method ----------
        //return nativeOp(mNativeRegion, region1.mNativeRegion,
                        //region2.mNativeRegion, op.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.099 -0400", hash_original_method = "9B6C5B9AE4B0C715D06D485A7F8D4046", hash_generated_method = "53FB4B7C776AE8E09F8F98C00ED4A64D")
    public String toString() {
String varDDC806D031E96ADAFEE4C9E5395D6E1C_593256382 =         nativeToString(mNativeRegion);
        varDDC806D031E96ADAFEE4C9E5395D6E1C_593256382.addTaint(taint);
        return varDDC806D031E96ADAFEE4C9E5395D6E1C_593256382;
        // ---------- Original Method ----------
        //return nativeToString(mNativeRegion);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.099 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2D2E2AE77B1B97F7FB79AFF3C74D7464")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1618053853 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745888368 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745888368;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.100 -0400", hash_original_method = "D2434A1CAFA87CC30850BFCF09357749", hash_generated_method = "0D581A61BC0C584A86F9E1F1E81B2099")
    public void writeToParcel(Parcel p, int flags) {
        addTaint(flags);
        addTaint(p.getTaint());
        if(!nativeWriteToParcel(mNativeRegion, p))        
        {
            RuntimeException varF1484B21EF4EE84F790184975238945B_1243774237 = new RuntimeException();
            varF1484B21EF4EE84F790184975238945B_1243774237.addTaint(taint);
            throw varF1484B21EF4EE84F790184975238945B_1243774237;
        } //End block
        // ---------- Original Method ----------
        //if (!nativeWriteToParcel(mNativeRegion, p)) {
            //throw new RuntimeException();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.101 -0400", hash_original_method = "1060AF13EAB0782D5AA6FD12A9EA9F72", hash_generated_method = "FBE29BE8A48094FC28D26E32A40CA07F")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj == null || !(obj instanceof Region))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1416078449 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1796701456 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1796701456;
        } //End block
        Region peer = (Region) obj;
        boolean varB5D17C638607BD87EFEB2B9211C51074_143574817 = (nativeEquals(mNativeRegion, peer.mNativeRegion));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1686747610 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1686747610;
        // ---------- Original Method ----------
        //if (obj == null || !(obj instanceof Region)) {
            //return false;
        //}
        //Region peer = (Region) obj;
        //return nativeEquals(mNativeRegion, peer.mNativeRegion);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.101 -0400", hash_original_method = "7B9D4EAB814BE6F839A0AFACF43162A1", hash_generated_method = "88533E051B74F60620695CD5B6D42F0C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.102 -0400", hash_original_method = "7C7B16974B0225DA07D6CF6E35F70776", hash_generated_method = "46EA745647F8D32722051D7068ED8828")
    final int ni() {
        int var39A8A1AE8A42CDC584C4F2F420719809_1112233175 = (mNativeRegion);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1094202152 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1094202152;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.106 -0400", hash_original_field = "50CCBBF498983066FB87505BC8EF122F", hash_generated_field = "200FB204FCAF60B88F8DADAA8213325E")

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

