package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.nio.Buffer;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL10Ext;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11Ext;
import javax.microedition.khronos.opengles.GL11ExtensionPack;

import android.app.AppGlobals;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.os.Build;
import android.util.Log;





public class GLImpl implements GL10, GL10Ext, GL11, GL11Ext, GL11ExtensionPack {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.611 -0400", hash_original_field = "8C8F45597D72D547EC6C57788A116CDD", hash_generated_field = "15CBD0DB05354E49FA41EDA6F6894843")

    Buffer _colorPointer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.611 -0400", hash_original_field = "3721A1BFE6ABEF6A1250AC2593809B00", hash_generated_field = "1D9638494227294B6707A326980392B7")

    Buffer _normalPointer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.611 -0400", hash_original_field = "CD477BB3231F306BD1A9FD97D0E8EDBE", hash_generated_field = "A097629D9CDA30DDF5BE5A14512EB23F")

    Buffer _texCoordPointer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.611 -0400", hash_original_field = "8BB253B98B23CC71962BEA847C362D23", hash_generated_field = "00B0011F84BCEE8409C349D31613FF06")

    Buffer _vertexPointer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.611 -0400", hash_original_field = "9CAC7B627E9C7BA2CBE98BADFFFE8A6D", hash_generated_field = "4CBE9C8ACE3C168F1CD97C057E7266C4")

    Buffer _pointSizePointerOES = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.611 -0400", hash_original_field = "898F8F939C779AA6C61771715401DAC6", hash_generated_field = "DD8607AFD26FDEAB9A9B73DCDCB63BB2")

    Buffer _matrixIndexPointerOES = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.611 -0400", hash_original_field = "7BC85316E0263D252F1D391B4A821CD1", hash_generated_field = "41E3253F5FB30C5383FBE43DCA9E249D")

    Buffer _weightPointerOES = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.611 -0400", hash_original_field = "2B78A905D625683198EA829B556B3E54", hash_generated_field = "AF11D4A762D9150D29527EF81F1566DE")

    private boolean haveCheckedExtensions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.611 -0400", hash_original_field = "53388D0A9376C42AE49BBE501C259267", hash_generated_field = "84E67FD7C266DDF7D2E0C04DAF1F0E62")

    private boolean have_OES_blend_equation_separate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.611 -0400", hash_original_field = "1D20B9DE17A5AFB26CD0E3245D4CDE15", hash_generated_field = "B6A044407641930A7CE41C04E383ED0F")

    private boolean have_OES_blend_subtract;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.611 -0400", hash_original_field = "E7CE1DBB708C18F86A1FF41DF7B6E610", hash_generated_field = "FA9978BE7CE9264B5E6B531CE7E2C25D")

    private boolean have_OES_framebuffer_object;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.611 -0400", hash_original_field = "CC7D220BC2E77085DC17FFCBE84A1994", hash_generated_field = "C64C57713C6D3FD3A3964CCE4EB4099C")

    private boolean have_OES_texture_cube_map;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.611 -0400", hash_original_method = "B8D773F1A7CFA96D2497C742B1D0AB9A", hash_generated_method = "11F556B43317BDD2203C73CA96CCDB1C")
    public  GLImpl() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    private static void _nativeClassInit() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.612 -0400", hash_original_method = "16A1ADA10B85F20D9DE0E81A43C2050C", hash_generated_method = "622B982839B25094F2588C502E2E3424")
    public void glGetPointerv(int pname, java.nio.Buffer[] params) {
        addTaint(params[0].getTaint());
        addTaint(pname);
        UnsupportedOperationException varAFCDDB03205F9E536629913C48D298A4_418793820 = new UnsupportedOperationException("glGetPointerv");
        varAFCDDB03205F9E536629913C48D298A4_418793820.addTaint(taint);
        throw varAFCDDB03205F9E536629913C48D298A4_418793820;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("glGetPointerv");
    }

    
    @DSModeled(DSC.BAN)
    private static boolean allowIndirectBuffers(String appName) {
        boolean result = false;
        int version = 0;
        IPackageManager pm = AppGlobals.getPackageManager();
        try {
            ApplicationInfo applicationInfo = pm.getApplicationInfo(appName, 0);
            if (applicationInfo != null) {
                version = applicationInfo.targetSdkVersion;
            }
        } catch (android.os.RemoteException e) {
        }
        Log.e("OpenGLES", String.format(
            "Application %s (SDK target %d) called a GL11 Pointer method with an indirect Buffer.",
            appName, version));
        if (version <= Build.VERSION_CODES.CUPCAKE) {
            result = true;
        }
        return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.612 -0400", hash_original_method = "97DEC0321FF9B09E49E45C9980AD2CAB", hash_generated_method = "59D0F5979F8F3224070EBB2DC792C648")
    public void glActiveTexture(
        int texture
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.613 -0400", hash_original_method = "E7B4134F951CACA5D3E260E6C8389AD6", hash_generated_method = "0EF977CED5E7B428D31FEFDC65D7F84F")
    public void glAlphaFunc(
        int func,
        float ref
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.613 -0400", hash_original_method = "0865B3896933828D18B5F3FD6A177BE6", hash_generated_method = "199E6F27800F72237C0183A7D3ACE5B2")
    public void glAlphaFuncx(
        int func,
        int ref
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.613 -0400", hash_original_method = "F26D066144D77B7F711F4AD20988DF70", hash_generated_method = "A092C42306CC4C3727EDB757FBAC85EF")
    public void glBindTexture(
        int target,
        int texture
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.613 -0400", hash_original_method = "A2FFC2EC79748E7F073DCEF2CA88E7F7", hash_generated_method = "2F65D73A471608BA5916421C8B031808")
    public void glBlendFunc(
        int sfactor,
        int dfactor
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.614 -0400", hash_original_method = "CEF5782DE326F4639690136522E382D5", hash_generated_method = "7D17C38475DE8ADBB23E64F843A63E69")
    public void glClear(
        int mask
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.614 -0400", hash_original_method = "7CE69D057BBB96A8C17F9D52DC80AA96", hash_generated_method = "85EA696ADFAC662ECE7BAC5DB6B923C2")
    public void glClearColor(
        float red,
        float green,
        float blue,
        float alpha
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.614 -0400", hash_original_method = "275A5B33E1A225983A518F82979B2F68", hash_generated_method = "9544AE461411D392168C81CEA1C7E199")
    public void glClearColorx(
        int red,
        int green,
        int blue,
        int alpha
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.614 -0400", hash_original_method = "1EB7D9BA90DAFE23078810226BAE8C0C", hash_generated_method = "345F1C9AAC0B2F306CDEBE5503B87C25")
    public void glClearDepthf(
        float depth
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.614 -0400", hash_original_method = "3F34D4A59EEDC6C0D2CA3EEB8AC8090C", hash_generated_method = "A3F3F7E2B7BB089B5B033188557A8333")
    public void glClearDepthx(
        int depth
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.615 -0400", hash_original_method = "0B981F79246B08586C7CE02E0CA71119", hash_generated_method = "5075791F2D6DC5D34EF8E53D236F5EF0")
    public void glClearStencil(
        int s
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.615 -0400", hash_original_method = "0F933753B69BA360F13E4FB9F8E0065B", hash_generated_method = "504FC1D01BDA986DB287D8AEA42C844E")
    public void glClientActiveTexture(
        int texture
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.615 -0400", hash_original_method = "0533CB48F440C5DC30BCFA6724D2A255", hash_generated_method = "33013E03BFCDE88E8582401824484250")
    public void glColor4f(
        float red,
        float green,
        float blue,
        float alpha
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.615 -0400", hash_original_method = "74951C5E7B28BB879C844C1CB4A28E26", hash_generated_method = "DD14324109808D3465E9FC9348918120")
    public void glColor4x(
        int red,
        int green,
        int blue,
        int alpha
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.615 -0400", hash_original_method = "35F5236562E70DF9BC2799C8D2FADA8F", hash_generated_method = "28419C52A2F9154E0335D688BE0F0D81")
    public void glColorMask(
        boolean red,
        boolean green,
        boolean blue,
        boolean alpha
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.615 -0400", hash_original_method = "D299BA021168438B5E6E34E52FC6C3F5", hash_generated_method = "5E026E27B3B7D0A9BCD53656655E323F")
    private void glColorPointerBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.616 -0400", hash_original_method = "BE0504B13DA269CA089182E44C7F834B", hash_generated_method = "DFEB890C2DD945BBAFD101E3D282231F")
    public void glColorPointer(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        glColorPointerBounds(
            size,
            type,
            stride,
            pointer,
            pointer.remaining()
        );
        if((size == 4) &&
            ((type == GL_FLOAT) ||
             (type == GL_UNSIGNED_BYTE) ||
             (type == GL_FIXED)) &&
            (stride >= 0))        
        {
            _colorPointer = pointer;
        } //End block
        // ---------- Original Method ----------
        //glColorPointerBounds(
            //size,
            //type,
            //stride,
            //pointer,
            //pointer.remaining()
        //);
        //if ((size == 4) &&
            //((type == GL_FLOAT) ||
             //(type == GL_UNSIGNED_BYTE) ||
             //(type == GL_FIXED)) &&
            //(stride >= 0)) {
            //_colorPointer = pointer;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.616 -0400", hash_original_method = "1DF16BDBC659AD9A84053C254D5C876E", hash_generated_method = "C93E3081DAC41A20E89A76976B8E5138")
    public void glCompressedTexImage2D(
        int target,
        int level,
        int internalformat,
        int width,
        int height,
        int border,
        int imageSize,
        java.nio.Buffer data
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.617 -0400", hash_original_method = "5F3B11428832BB3EDC7989E25F3372FC", hash_generated_method = "BB3A060BAB01A4C5ED93358D5C47F08F")
    public void glCompressedTexSubImage2D(
        int target,
        int level,
        int xoffset,
        int yoffset,
        int width,
        int height,
        int format,
        int imageSize,
        java.nio.Buffer data
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.617 -0400", hash_original_method = "842526CAA5B5EF81DE180C77C64E9061", hash_generated_method = "92DBAAD2866E78452B2F9FD7DD56BE0F")
    public void glCopyTexImage2D(
        int target,
        int level,
        int internalformat,
        int x,
        int y,
        int width,
        int height,
        int border
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.618 -0400", hash_original_method = "F04240E045617269474207BFBECC16FF", hash_generated_method = "DB8ACA8E82B1CE4F9218DB6201937D6A")
    public void glCopyTexSubImage2D(
        int target,
        int level,
        int xoffset,
        int yoffset,
        int x,
        int y,
        int width,
        int height
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.618 -0400", hash_original_method = "BF058CF8285375279C20F1E97C513D8F", hash_generated_method = "640C96F615088A10628AE055FCCB3763")
    public void glCullFace(
        int mode
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.619 -0400", hash_original_method = "101445A2DF4F3A2138F3CE9187FCE63C", hash_generated_method = "EA30526C1B8820F046561ECD91C936E0")
    public void glDeleteTextures(
        int n,
        int[] textures,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.619 -0400", hash_original_method = "D095348CAE17C3691EC094768112CBAF", hash_generated_method = "45F8AF8102B3F7872D99217FEFBD1A9C")
    public void glDeleteTextures(
        int n,
        java.nio.IntBuffer textures
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.619 -0400", hash_original_method = "8C02F7FAED1907F361FD59A628ECBD22", hash_generated_method = "CC05836F618332D3D289D3C642E80D45")
    public void glDepthFunc(
        int func
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.619 -0400", hash_original_method = "C2DFC52E0130222A386062E7C36C540C", hash_generated_method = "4625A4487EA9D9B9D579EA01BC1CE08E")
    public void glDepthMask(
        boolean flag
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.619 -0400", hash_original_method = "E7355D3212849EB0BD47CDEAB4ED34D8", hash_generated_method = "3CBF3E043B3F3BEB3E6F127D4C95D1B2")
    public void glDepthRangef(
        float zNear,
        float zFar
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.620 -0400", hash_original_method = "E32ECE36BCFE7480D9AC74D264F5EFCB", hash_generated_method = "CB233497654C7CCD00127A7610BD4BF2")
    public void glDepthRangex(
        int zNear,
        int zFar
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.620 -0400", hash_original_method = "256D91725811492CC49701A657A0BEE5", hash_generated_method = "C321FFE4B96ECC3890F4FAF7E16E366D")
    public void glDisable(
        int cap
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.620 -0400", hash_original_method = "45A7662FE3309DCB52E9D50B8B88E585", hash_generated_method = "BF4927B4BFB0C2F29DC22DB16D82F162")
    public void glDisableClientState(
        int array
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.620 -0400", hash_original_method = "D8CC37788E3378C496F8ED8C8C656160", hash_generated_method = "2B8826ACEB73D6A13DA26CD13483879C")
    public void glDrawArrays(
        int mode,
        int first,
        int count
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.620 -0400", hash_original_method = "AA331AE5D7C80D1BAA992FA5E2ACE318", hash_generated_method = "4401A571220CC59A497AA8FAEDEFDA62")
    public void glDrawElements(
        int mode,
        int count,
        int type,
        java.nio.Buffer indices
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.620 -0400", hash_original_method = "DA63A528B7CE4387E843DC02AB39FA4E", hash_generated_method = "AB51CE5FE10D37520FEC28DC42B12B36")
    public void glEnable(
        int cap
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.620 -0400", hash_original_method = "65AED86EB3A5CAC39903F830C4DC3A62", hash_generated_method = "82A72443DD6E65A3E23D525DFB511D08")
    public void glEnableClientState(
        int array
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.620 -0400", hash_original_method = "B245C18D1679C9F54DA6F9DB4AB7671B", hash_generated_method = "42B3C8E68A9B47CE73D394313B40F773")
    public void glFinish(
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.620 -0400", hash_original_method = "0DC82BEA9D8586E19F2791A82FAA6841", hash_generated_method = "6501AEDD1510D399BC012100D3EAE705")
    public void glFlush(
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.620 -0400", hash_original_method = "B9E8FFE3840C500F758630055A918A38", hash_generated_method = "2286F1799EF11288CC83A51F22102A39")
    public void glFogf(
        int pname,
        float param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.620 -0400", hash_original_method = "BE00E22E98F513D77F19185FDB52DF2B", hash_generated_method = "3090DE15F04453B25B9D97B037A18C77")
    public void glFogfv(
        int pname,
        float[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.620 -0400", hash_original_method = "AD37BF249EE97473580D297C4497D098", hash_generated_method = "303344BBE92CEA732CF4F36BEF0412A5")
    public void glFogfv(
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.620 -0400", hash_original_method = "D2A635C8556AD8704E3B26380CA4E66B", hash_generated_method = "44678824A0AACAF6BE36C5928E61ECBD")
    public void glFogx(
        int pname,
        int param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.621 -0400", hash_original_method = "56931392328BA8F65D6B9AE45F613231", hash_generated_method = "C4E9A94AB253C5697CA67DD75DA34160")
    public void glFogxv(
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.621 -0400", hash_original_method = "D9ACE5927E1ADC9EC43FDBC1C3AFD392", hash_generated_method = "558B4EC8D56C12C493B741E6034078A4")
    public void glFogxv(
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.621 -0400", hash_original_method = "58E66F9B437E228FC7F553B01D901911", hash_generated_method = "E36C14D3A7629DFBC5137F1AC19E1B87")
    public void glFrontFace(
        int mode
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.621 -0400", hash_original_method = "258ACC44157D8C73AE0DD0608758234D", hash_generated_method = "74FB22AB97CA28CB3E54DBC4D8A7E2A6")
    public void glFrustumf(
        float left,
        float right,
        float bottom,
        float top,
        float zNear,
        float zFar
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.621 -0400", hash_original_method = "B647E46DB6CC0EF9C5D63CE945C7426B", hash_generated_method = "6661B71A3E17C808056EA8E86CA23D87")
    public void glFrustumx(
        int left,
        int right,
        int bottom,
        int top,
        int zNear,
        int zFar
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.621 -0400", hash_original_method = "F376BD874C5726C877C78955E3906803", hash_generated_method = "0774DEDF29145271ED5BBF4BB7ECACCF")
    public void glGenTextures(
        int n,
        int[] textures,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.621 -0400", hash_original_method = "5433EB0BD32825204D952206851671B4", hash_generated_method = "B1DFC95E9DB4CC1B34440AD0560B0084")
    public void glGenTextures(
        int n,
        java.nio.IntBuffer textures
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.621 -0400", hash_original_method = "3AEB3B830A2084F227EAFBC906BD9186", hash_generated_method = "B3674C988EC127089C2D83F2C39E3F80")
    public int glGetError(
    ) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_816227723 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_816227723;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.621 -0400", hash_original_method = "BE83917E35D95BF70433F1B2EFD4AA45", hash_generated_method = "E23E442E42AA6DAE0B790FCEE53E117E")
    public void glGetIntegerv(
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.621 -0400", hash_original_method = "773ECB86C0D6C008ED75815E0C485FED", hash_generated_method = "6ACBEF801DF29AA5D1C970580D3676AE")
    public void glGetIntegerv(
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.464 -0400", hash_original_method = "C8F5D66A4A0C233120B2D99EA024C798", hash_generated_method = "C8637FC1886E81608EB74A6761675B8E")
    public String _glGetString(
        int name
    ) {
    	addTaint(name);
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.622 -0400", hash_original_method = "A9D2CB8422A028FB150957649B6BF2BA", hash_generated_method = "ABD334F1ED3EE45E2A3347F6D074AA5E")
    public String glGetString(
        int name
    ) {
        addTaint(name);
        String returnValue;
        returnValue = _glGetString(
            name
        );
String varC04F7EF67EFA4B802A6C88CA1EC6368A_1687678124 =         returnValue;
        varC04F7EF67EFA4B802A6C88CA1EC6368A_1687678124.addTaint(taint);
        return varC04F7EF67EFA4B802A6C88CA1EC6368A_1687678124;
        // ---------- Original Method ----------
        //String returnValue;
        //returnValue = _glGetString(
            //name
        //);
        //return returnValue;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.622 -0400", hash_original_method = "E301695B30A10DCD62C26798611AB78D", hash_generated_method = "D918E12BC45E0E57E9379C0C1D36A613")
    public void glHint(
        int target,
        int mode
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.622 -0400", hash_original_method = "5B55D240600D2347D0B596E98C1FD03E", hash_generated_method = "9A38A394AA80DCA04AE988215C1DC168")
    public void glLightModelf(
        int pname,
        float param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.622 -0400", hash_original_method = "469DC3934BDE6F64F646577239C71F2F", hash_generated_method = "63598535AB13E30FD2C83871BBE38387")
    public void glLightModelfv(
        int pname,
        float[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.622 -0400", hash_original_method = "F43364E33E247B9D84BA159B372B4002", hash_generated_method = "A41876AB7E3C520C7BD3521DED47D310")
    public void glLightModelfv(
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.622 -0400", hash_original_method = "9B3A746FED707CC1F39424E3DA8ABB06", hash_generated_method = "567DDF8CBD6DD0CE9A47294DDB21C0C2")
    public void glLightModelx(
        int pname,
        int param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.622 -0400", hash_original_method = "63BEC7A58A6C485233CE34909855CC91", hash_generated_method = "E7AF1B32F1BB0D60E40B55E175820A44")
    public void glLightModelxv(
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.622 -0400", hash_original_method = "4983CEF3084132F982716E77E65DA0DC", hash_generated_method = "97B674DB6D8FC95E007EDACAF761AF51")
    public void glLightModelxv(
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.622 -0400", hash_original_method = "BC4F16E0EA5A26CEBC4A97ACCF933FD8", hash_generated_method = "05FA04CC38144619245B3A264432CDC5")
    public void glLightf(
        int light,
        int pname,
        float param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.623 -0400", hash_original_method = "EB971A23213F76661BF6D474DB7C2C2B", hash_generated_method = "44DF9083DB416632583C153E599853B8")
    public void glLightfv(
        int light,
        int pname,
        float[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.623 -0400", hash_original_method = "BBD1B83CF877B43B7D98E2E20B1FA8F5", hash_generated_method = "A845A122D1EA1EF96B88B9B17194B951")
    public void glLightfv(
        int light,
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.623 -0400", hash_original_method = "1636FACE953A8B90B672FD6B8B82E049", hash_generated_method = "E55F518ED664E8F7E3719DF9D8EC8347")
    public void glLightx(
        int light,
        int pname,
        int param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.623 -0400", hash_original_method = "5EEC4CF6BA8F18D7C0133A72068C6997", hash_generated_method = "CB3971C8AEEE7736F744B11B79BBA10F")
    public void glLightxv(
        int light,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.623 -0400", hash_original_method = "A87D0BD27836CABD7E83A0BE50712B19", hash_generated_method = "7B0F004F970E18E04CE7927DD3CDA98B")
    public void glLightxv(
        int light,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.623 -0400", hash_original_method = "418A5E015C9F0EF8168906698F676B52", hash_generated_method = "5D1DC66BAC75C0888ABB60C86725BEAC")
    public void glLineWidth(
        float width
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.623 -0400", hash_original_method = "46A2A26397F6D04C8D01B2E1097F9B31", hash_generated_method = "81CD2C1160B670D165BE06507B1C0084")
    public void glLineWidthx(
        int width
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.623 -0400", hash_original_method = "D042F9F6A97E88B9C214C3163B975280", hash_generated_method = "6459B682ADFDC7A99B84D5DA90D419D4")
    public void glLoadIdentity(
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.623 -0400", hash_original_method = "BF5B7D451473F76AF4260EBB3D9B9ECD", hash_generated_method = "4B101C7D342BF385B89D10BD44674349")
    public void glLoadMatrixf(
        float[] m,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.623 -0400", hash_original_method = "837F28F7EEECF84ECA621818DC3C637A", hash_generated_method = "36EF64C2169C6884DDC57C49EC2FF6D2")
    public void glLoadMatrixf(
        java.nio.FloatBuffer m
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.623 -0400", hash_original_method = "8EEBBA5929A3A830E73BB9FC9F171FB5", hash_generated_method = "99E5F987514E39969100AA6E32DB57E3")
    public void glLoadMatrixx(
        int[] m,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.623 -0400", hash_original_method = "3F7B33E669417D7583090F577D211E45", hash_generated_method = "25CCE50982AD1C383AC8B06D05E42B09")
    public void glLoadMatrixx(
        java.nio.IntBuffer m
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.624 -0400", hash_original_method = "EFB3D7E34F512A452A0388AA3929F12A", hash_generated_method = "8B6C3A6AAE9A76A3EF451C3FE27F3C48")
    public void glLogicOp(
        int opcode
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.624 -0400", hash_original_method = "2486F3344BB028D6ECF51AD6932BC71D", hash_generated_method = "7F16702D13F37D4380F86C547C38EE8A")
    public void glMaterialf(
        int face,
        int pname,
        float param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.624 -0400", hash_original_method = "FBDA35E6E17FD54BBA85AC8AD5CB2D2D", hash_generated_method = "574098D3A83F5F4989FE247EBF05351F")
    public void glMaterialfv(
        int face,
        int pname,
        float[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.624 -0400", hash_original_method = "0C556B2BE454B86C9858160252C402E3", hash_generated_method = "6D198F4FDE4AD5003D0CF9A56C2BFB8B")
    public void glMaterialfv(
        int face,
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.624 -0400", hash_original_method = "061C8AE3D5B422D4FA509AC9BB661EA2", hash_generated_method = "7FF8048BB53CD5ABC8AE9C7CEC22F7D2")
    public void glMaterialx(
        int face,
        int pname,
        int param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.624 -0400", hash_original_method = "472B643031F0D036A87E30E2765D5474", hash_generated_method = "E259777DB3704C365174EFA494244316")
    public void glMaterialxv(
        int face,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.624 -0400", hash_original_method = "C8896486401C23A34B9A8815791ACA5F", hash_generated_method = "836777088FFE9D4F9D88C36DB8360142")
    public void glMaterialxv(
        int face,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.624 -0400", hash_original_method = "071A0DE8AF455560D084B2FEE6249056", hash_generated_method = "BCF023EB6E7C261EED4E8E4EBAC54906")
    public void glMatrixMode(
        int mode
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.624 -0400", hash_original_method = "F3AFD06B34A43E8403C806B69E46B6B8", hash_generated_method = "1AE9D87D2492C95C94A3EF762AE351F2")
    public void glMultMatrixf(
        float[] m,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.624 -0400", hash_original_method = "9713DC69CB7C2DDBF435393A004F3DD4", hash_generated_method = "39923C35509FB0422AF2AD0DDD03683F")
    public void glMultMatrixf(
        java.nio.FloatBuffer m
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.624 -0400", hash_original_method = "4465F8842A1FA52D69E1334040E6F51E", hash_generated_method = "4099FDCB098E09B9DF808854418A838A")
    public void glMultMatrixx(
        int[] m,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.624 -0400", hash_original_method = "DF5EC04F6F5FD65FC1A3F65FA14E17AE", hash_generated_method = "CFA7175C46E9B142B4440EE9C2E83EF7")
    public void glMultMatrixx(
        java.nio.IntBuffer m
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.624 -0400", hash_original_method = "11C7AE2F7FBF34FAA4EB3D3D62BF913A", hash_generated_method = "1DA2E100F4372B7D1294A16AB405D144")
    public void glMultiTexCoord4f(
        int target,
        float s,
        float t,
        float r,
        float q
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.624 -0400", hash_original_method = "23E284E29F32FC21C7A0FCFA0D22DEB6", hash_generated_method = "59DFDAF169EA723C77F0B0C5DCE17771")
    public void glMultiTexCoord4x(
        int target,
        int s,
        int t,
        int r,
        int q
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.625 -0400", hash_original_method = "9DE586E6F695FF88688A307035F39CA5", hash_generated_method = "E93ECF8F7FEBE741CE91C4877902EA51")
    public void glNormal3f(
        float nx,
        float ny,
        float nz
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.625 -0400", hash_original_method = "20119369DE227042EDEFDBE3270C3DE9", hash_generated_method = "F916CC2BC7C102A2BD583D53DBCABBCC")
    public void glNormal3x(
        int nx,
        int ny,
        int nz
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.625 -0400", hash_original_method = "1F3C9CA6DB76EF1CEC4FE9381E242024", hash_generated_method = "42FC877363763EA15A6FB84308729F49")
    private void glNormalPointerBounds(
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.625 -0400", hash_original_method = "B0279F28E501DAEA74F3B8688C94AB46", hash_generated_method = "EDB0ED95402094B9EFFE5C377098F64D")
    public void glNormalPointer(
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        addTaint(stride);
        addTaint(type);
        glNormalPointerBounds(
            type,
            stride,
            pointer,
            pointer.remaining()
        );
        if(((type == GL_FLOAT) ||
             (type == GL_BYTE) ||
             (type == GL_SHORT) ||
             (type == GL_FIXED)) &&
            (stride >= 0))        
        {
            _normalPointer = pointer;
        } //End block
        // ---------- Original Method ----------
        //glNormalPointerBounds(
            //type,
            //stride,
            //pointer,
            //pointer.remaining()
        //);
        //if (((type == GL_FLOAT) ||
             //(type == GL_BYTE) ||
             //(type == GL_SHORT) ||
             //(type == GL_FIXED)) &&
            //(stride >= 0)) {
            //_normalPointer = pointer;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.625 -0400", hash_original_method = "FA472E5A7F4340721FB63D20C6C9872C", hash_generated_method = "CA8CFEB208258609311AA1C394CEAC05")
    public void glOrthof(
        float left,
        float right,
        float bottom,
        float top,
        float zNear,
        float zFar
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.625 -0400", hash_original_method = "779BA3AE3934F2C0E0D6CD9B22925617", hash_generated_method = "6F1A6C47CCEF2FB124753AFF6D136A4E")
    public void glOrthox(
        int left,
        int right,
        int bottom,
        int top,
        int zNear,
        int zFar
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.625 -0400", hash_original_method = "9F46DCF7880A291F21EA87295ECFB64D", hash_generated_method = "10CAD97A92CB26F852739736E3890C10")
    public void glPixelStorei(
        int pname,
        int param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.626 -0400", hash_original_method = "70E088306D05927B07E2ED10F48C457E", hash_generated_method = "D90040A45986CB2A03D831424AA52813")
    public void glPointSize(
        float size
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.626 -0400", hash_original_method = "8990BB5170BD865165F8304AE65CA7D9", hash_generated_method = "0E9F6C03F563D22FE097C9E8B36E55FF")
    public void glPointSizex(
        int size
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.626 -0400", hash_original_method = "E1FC86F4B601EF0C69805BFC127ED812", hash_generated_method = "28C107895FF74C246776FD70655F7E32")
    public void glPolygonOffset(
        float factor,
        float units
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.626 -0400", hash_original_method = "627C0C70B067DF76C0A65620B55C9D89", hash_generated_method = "B5C491F27E8AD830F4A0FE9F79C27F39")
    public void glPolygonOffsetx(
        int factor,
        int units
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.626 -0400", hash_original_method = "7B9DD6E697258B776092627B483BEC50", hash_generated_method = "369BFD187A09E72ED283C5E143F24E1B")
    public void glPopMatrix(
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.626 -0400", hash_original_method = "5E9492F1A35F4DB85CB36C12255394B9", hash_generated_method = "A836F02FFAF1F7FF17B740ED3F586CE0")
    public void glPushMatrix(
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.626 -0400", hash_original_method = "06F089EB522BB6494D3BBAD3A839D917", hash_generated_method = "18BFE8B9F3F153E84628274072359A88")
    public void glReadPixels(
        int x,
        int y,
        int width,
        int height,
        int format,
        int type,
        java.nio.Buffer pixels
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.626 -0400", hash_original_method = "1C954364937B2BCE355EFA4F5D15232D", hash_generated_method = "E56D312FAB25209B64DBE1886BFD7EEE")
    public void glRotatef(
        float angle,
        float x,
        float y,
        float z
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.626 -0400", hash_original_method = "B1A5B8433BC4E0D5D8E9AD5FE1254788", hash_generated_method = "DF60DD015BF0420AD0D5C4B0854C6804")
    public void glRotatex(
        int angle,
        int x,
        int y,
        int z
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.626 -0400", hash_original_method = "AA4B2DFEFBE4905278A3F5AA24D3A995", hash_generated_method = "804376289991CACB0E2367E8ACD26189")
    public void glSampleCoverage(
        float value,
        boolean invert
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.627 -0400", hash_original_method = "44B6D2540DFD3AA85A51F37AE0763C78", hash_generated_method = "BE5D7F8DC48DB3B53AEEC7A4FF5270BB")
    public void glSampleCoveragex(
        int value,
        boolean invert
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.627 -0400", hash_original_method = "EF219AA0948830AA415C1204BCBC2736", hash_generated_method = "E767D3B194E8E2B6950C4F7C9C3ACDDB")
    public void glScalef(
        float x,
        float y,
        float z
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.627 -0400", hash_original_method = "84D2C12CD2738F500F416AFA5567D4F0", hash_generated_method = "65EE7F0413053F2C5498FE757FB45F29")
    public void glScalex(
        int x,
        int y,
        int z
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.627 -0400", hash_original_method = "2706B1054613592AF5D1DF72ABC0CD83", hash_generated_method = "C4F248E3D4761D35236A3F68D7FB3043")
    public void glScissor(
        int x,
        int y,
        int width,
        int height
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.627 -0400", hash_original_method = "06D4AD727137B397BA1C790AE88392D9", hash_generated_method = "BF1E9CE115F577A344C4791A556EC3E5")
    public void glShadeModel(
        int mode
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.627 -0400", hash_original_method = "E1207A48D38BC4812B68A4C96B0D52F1", hash_generated_method = "B589B19BDC54E71C75A7E530FF178BCD")
    public void glStencilFunc(
        int func,
        int ref,
        int mask
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.627 -0400", hash_original_method = "7094BBA3123BF4E1DB187F35149B8AFA", hash_generated_method = "5C9E74A761938F3633268CEBFDB75652")
    public void glStencilMask(
        int mask
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.628 -0400", hash_original_method = "B10D55F18627610DD2579793D42F3254", hash_generated_method = "2EB1F0F9F685D1E2BD030E0C75AFBD3B")
    public void glStencilOp(
        int fail,
        int zfail,
        int zpass
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.628 -0400", hash_original_method = "9D620040AA720FDD33F346FBC8BD5A6E", hash_generated_method = "BCB2927FA1F7961F0E799A940608A6FE")
    private void glTexCoordPointerBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.628 -0400", hash_original_method = "76ED75F6FDC0A5E37C32F775B196CB2D", hash_generated_method = "041BDEE7B262239F00F4DB92C0A9180F")
    public void glTexCoordPointer(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        glTexCoordPointerBounds(
            size,
            type,
            stride,
            pointer,
            pointer.remaining()
        );
        if(((size == 2) ||
             (size == 3) ||
             (size == 4)) &&
            ((type == GL_FLOAT) ||
             (type == GL_BYTE) ||
             (type == GL_SHORT) ||
             (type == GL_FIXED)) &&
            (stride >= 0))        
        {
            _texCoordPointer = pointer;
        } //End block
        // ---------- Original Method ----------
        //glTexCoordPointerBounds(
            //size,
            //type,
            //stride,
            //pointer,
            //pointer.remaining()
        //);
        //if (((size == 2) ||
             //(size == 3) ||
             //(size == 4)) &&
            //((type == GL_FLOAT) ||
             //(type == GL_BYTE) ||
             //(type == GL_SHORT) ||
             //(type == GL_FIXED)) &&
            //(stride >= 0)) {
            //_texCoordPointer = pointer;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.628 -0400", hash_original_method = "C92F17394C34CCF009999C2B03267478", hash_generated_method = "EDD0C70E3202650EF276218F1BBA897B")
    public void glTexEnvf(
        int target,
        int pname,
        float param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.628 -0400", hash_original_method = "17EB1D9A37B75139BEBB3A24236CA174", hash_generated_method = "8AA3BABF900DE9786339A948405AFEE0")
    public void glTexEnvfv(
        int target,
        int pname,
        float[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.628 -0400", hash_original_method = "7DAA860F4B0103CB3FBE5370186D423C", hash_generated_method = "A0826FC7C0EDB01B1D7C0243F822BB60")
    public void glTexEnvfv(
        int target,
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.628 -0400", hash_original_method = "0B4A8E67F48DF299AEE127C1D6D6E842", hash_generated_method = "817449342CAF7A9AC685940E0A8DE665")
    public void glTexEnvx(
        int target,
        int pname,
        int param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.629 -0400", hash_original_method = "3454AE1EA38B6015D5079DEC25C07356", hash_generated_method = "934D053702F5AC8A95AA86122526374F")
    public void glTexEnvxv(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.629 -0400", hash_original_method = "A182AF661C6E3504BF48BA26E70CC975", hash_generated_method = "FD06D747E165DB21F7033773869A12BB")
    public void glTexEnvxv(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.629 -0400", hash_original_method = "1318832C2059A909174341F9487D764F", hash_generated_method = "51B36FE8C06ACAC1D3AB67423B2454BB")
    public void glTexImage2D(
        int target,
        int level,
        int internalformat,
        int width,
        int height,
        int border,
        int format,
        int type,
        java.nio.Buffer pixels
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.629 -0400", hash_original_method = "F2C35EB1905189AC842F73F625C9049E", hash_generated_method = "03DDB1ECCE46F85907D443C35529B344")
    public void glTexParameterf(
        int target,
        int pname,
        float param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.629 -0400", hash_original_method = "679BAE0DF1765F687A0745B0BA3EC234", hash_generated_method = "6C2AB88557B144BC93C67DE2FCF2E24B")
    public void glTexParameterx(
        int target,
        int pname,
        int param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.629 -0400", hash_original_method = "6621BB389C4964067C97C1E29DF058F0", hash_generated_method = "C5418836E7950CD13B34F2D690C63627")
    public void glTexSubImage2D(
        int target,
        int level,
        int xoffset,
        int yoffset,
        int width,
        int height,
        int format,
        int type,
        java.nio.Buffer pixels
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.630 -0400", hash_original_method = "8D88726507AA19B9B9ECE00EF0AA6770", hash_generated_method = "AFFF4B189BF6C42179B1BF93140D39F8")
    public void glTranslatef(
        float x,
        float y,
        float z
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.630 -0400", hash_original_method = "156D8083E2F48E9E423D17537DC8B72A", hash_generated_method = "2036461D9775A01A30AE5D30A1609F3C")
    public void glTranslatex(
        int x,
        int y,
        int z
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.630 -0400", hash_original_method = "93D9D08DB02A2FA19D56A49842CFD50E", hash_generated_method = "570DAA9620BD3E02CC95EA189FE06F4B")
    private void glVertexPointerBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.630 -0400", hash_original_method = "EB50FBD03587D2E27B120FC4C1DFD2C5", hash_generated_method = "63F79E5606DDE77685C98D550EEB41CA")
    public void glVertexPointer(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        glVertexPointerBounds(
            size,
            type,
            stride,
            pointer,
            pointer.remaining()
        );
        if(((size == 2) ||
             (size == 3) ||
             (size == 4)) &&
            ((type == GL_FLOAT) ||
             (type == GL_BYTE) ||
             (type == GL_SHORT) ||
             (type == GL_FIXED)) &&
            (stride >= 0))        
        {
            _vertexPointer = pointer;
        } //End block
        // ---------- Original Method ----------
        //glVertexPointerBounds(
            //size,
            //type,
            //stride,
            //pointer,
            //pointer.remaining()
        //);
        //if (((size == 2) ||
             //(size == 3) ||
             //(size == 4)) &&
            //((type == GL_FLOAT) ||
             //(type == GL_BYTE) ||
             //(type == GL_SHORT) ||
             //(type == GL_FIXED)) &&
            //(stride >= 0)) {
            //_vertexPointer = pointer;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.630 -0400", hash_original_method = "4BB437B5524083B48EDAA779B8096AF4", hash_generated_method = "D2EBD0F2D0E5E48D4E2BAA361D912464")
    public void glViewport(
        int x,
        int y,
        int width,
        int height
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.630 -0400", hash_original_method = "9B92240362A0C24B54C7BFD4F1CE5714", hash_generated_method = "092AB6BAB3208B778FBC277EFC4A0381")
    public int glQueryMatrixxOES(
        int[] mantissa,
        int mantissaOffset,
        int[] exponent,
        int exponentOffset
    ) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337033503 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337033503;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.631 -0400", hash_original_method = "101C06E84233F4A43BD578F661A40864", hash_generated_method = "72CFD98A84B57EFB5C21E40040944396")
    public int glQueryMatrixxOES(
        java.nio.IntBuffer mantissa,
        java.nio.IntBuffer exponent
    ) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_708139740 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_708139740;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.631 -0400", hash_original_method = "8D2FB6E82772953815CBFED3E425025F", hash_generated_method = "162584B7321FEE50F162500339373AF6")
    public void glBindBuffer(
        int target,
        int buffer
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.631 -0400", hash_original_method = "60652602159136F858DBF56A81FAD463", hash_generated_method = "A9A1F62E7C1345B823F40E3B36F0BF44")
    public void glBufferData(
        int target,
        int size,
        java.nio.Buffer data,
        int usage
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.631 -0400", hash_original_method = "8950BE5BF752428FF824E4C8DAF2F401", hash_generated_method = "1E168D790BD422605662E71529D04BE3")
    public void glBufferSubData(
        int target,
        int offset,
        int size,
        java.nio.Buffer data
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.631 -0400", hash_original_method = "155F1B281020C8D1BB6048C36DD6FADD", hash_generated_method = "3985FD3174DC374B0F3D3C545471CA48")
    public void glClipPlanef(
        int plane,
        float[] equation,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.631 -0400", hash_original_method = "BFAF1ADDEE7B010F7D84F768A9758F4D", hash_generated_method = "A9BF533DB7B2D340A43DBD5CB58B833F")
    public void glClipPlanef(
        int plane,
        java.nio.FloatBuffer equation
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.631 -0400", hash_original_method = "0657B828FBDFCB33E6AEAE065879195B", hash_generated_method = "E51C6BC18244B98F32B7BF10239AA185")
    public void glClipPlanex(
        int plane,
        int[] equation,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.632 -0400", hash_original_method = "0DA6B6D2978A64F63583FC89A46DD2C9", hash_generated_method = "A925A90D3111AB2CE04CFAD93F80722B")
    public void glClipPlanex(
        int plane,
        java.nio.IntBuffer equation
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.632 -0400", hash_original_method = "27D12F7262E17AFA65E5B69E9E658934", hash_generated_method = "E3D1948DDA0DA4586DBE18C5129730C3")
    public void glColor4ub(
        byte red,
        byte green,
        byte blue,
        byte alpha
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.632 -0400", hash_original_method = "BFA7C744F4E209AD9E46A7063445C612", hash_generated_method = "30B47BBB17D174B7E3F90288DA90C845")
    public void glColorPointer(
        int size,
        int type,
        int stride,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.632 -0400", hash_original_method = "E5E400D8B0DD28099195D126630AE3F3", hash_generated_method = "F018BA5EDA88633F98AEC43ECE05F97F")
    public void glDeleteBuffers(
        int n,
        int[] buffers,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.632 -0400", hash_original_method = "70C001894D0487E1FC16B5A8E3289001", hash_generated_method = "0F41DB46B3E837B8097AC3DC173B6F19")
    public void glDeleteBuffers(
        int n,
        java.nio.IntBuffer buffers
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.632 -0400", hash_original_method = "435560D0BA5A8695B9DFA99E435C09EF", hash_generated_method = "2CD1E9563B836D1163C1E24730A07E61")
    public void glDrawElements(
        int mode,
        int count,
        int type,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.634 -0400", hash_original_method = "FA01B6EEE9A8B6C56F123033DDBB027C", hash_generated_method = "7AAC36D9CB2E719131C551E8D649215C")
    public void glGenBuffers(
        int n,
        int[] buffers,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.635 -0400", hash_original_method = "A06F6445182A854FF9614FEACAA08BDA", hash_generated_method = "86E0842F795AA190823CD080A02C3D20")
    public void glGenBuffers(
        int n,
        java.nio.IntBuffer buffers
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.635 -0400", hash_original_method = "7095CBF55ACD4B9F2AA86E657F4CB2B3", hash_generated_method = "A9F9D7C4D753F2B753C02CB8278389DB")
    public void glGetBooleanv(
        int pname,
        boolean[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.635 -0400", hash_original_method = "6AE434FF80C80956E80241A5F3448A43", hash_generated_method = "CC805629881BB3AB2BBDA59E71C1F478")
    public void glGetBooleanv(
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.635 -0400", hash_original_method = "FE5274567105EB2D10CBB5CF28493B10", hash_generated_method = "C27EFA6BBA1B0D75570DD4FE2A52CDBB")
    public void glGetBufferParameteriv(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.635 -0400", hash_original_method = "72ED25126A92670FCEBB1B4962677465", hash_generated_method = "47FDCAD4CA941CA125E1A484F3CF9992")
    public void glGetBufferParameteriv(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.635 -0400", hash_original_method = "B414E64778E376C130F5038CB527E31F", hash_generated_method = "877AE798F1552C3C30B75541511A90DA")
    public void glGetClipPlanef(
        int pname,
        float[] eqn,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.635 -0400", hash_original_method = "1C111E4CC3829517C17B35EA499D5BFD", hash_generated_method = "4264A3FEF68337363900015A34C1515E")
    public void glGetClipPlanef(
        int pname,
        java.nio.FloatBuffer eqn
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.637 -0400", hash_original_method = "9782A147ABD9AFBBF1DDDCF344CA05F5", hash_generated_method = "5AA9494D45CFE2D309C5676AE151A6C8")
    public void glGetClipPlanex(
        int pname,
        int[] eqn,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.637 -0400", hash_original_method = "4DB3F0354D2E2FDC4D6C7551700566FD", hash_generated_method = "078026867F47E5E50CF7EAC7438AFF39")
    public void glGetClipPlanex(
        int pname,
        java.nio.IntBuffer eqn
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.637 -0400", hash_original_method = "72D05611B5260CD5F4BD9FBDD7EF3356", hash_generated_method = "B338CABC577E45BD1BFDB8ECE211C85F")
    public void glGetFixedv(
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.637 -0400", hash_original_method = "D5438CEA44EE048204E6C055FB0ADA7A", hash_generated_method = "97C0EC5FF946B124BCD2241C55BCED84")
    public void glGetFixedv(
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.637 -0400", hash_original_method = "D28AD4CA9FE8670565C188B18F0632DC", hash_generated_method = "82E4A0F06F422D4C0C9C66EABAD8EB25")
    public void glGetFloatv(
        int pname,
        float[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.637 -0400", hash_original_method = "3B5B54F3207F36DC8458C2C22ECF19A7", hash_generated_method = "ADD03DF5F0123FE07AAFD7872D488656")
    public void glGetFloatv(
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.637 -0400", hash_original_method = "6E5CC7433F2D11EE58A323BDB9B2C031", hash_generated_method = "B3B17EB593AF5643E6D2D6027639115D")
    public void glGetLightfv(
        int light,
        int pname,
        float[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.637 -0400", hash_original_method = "6D38AF1876F30D3A6786EFE90DF09285", hash_generated_method = "4141E9E2DE5283CDEA0A5BEE4E5092C3")
    public void glGetLightfv(
        int light,
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.637 -0400", hash_original_method = "6258F81E6CD446483B153322692371F6", hash_generated_method = "89292D5BB503212C23325A62AEB586FA")
    public void glGetLightxv(
        int light,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.640 -0400", hash_original_method = "858C4450F94D83CD8A405C5DA4478E6B", hash_generated_method = "403E5D0FE2D897FD8ADF41C2683E55F0")
    public void glGetLightxv(
        int light,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.640 -0400", hash_original_method = "4AD4AE19FF3DE20072E7B36663EF7FF1", hash_generated_method = "14A8011243D8429F1E105B8AEA2B7B6A")
    public void glGetMaterialfv(
        int face,
        int pname,
        float[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.640 -0400", hash_original_method = "AAEA106163ADE72C9EC108D40BEC96F3", hash_generated_method = "DA8CFFD913240F98456A22CCBB9E3E7A")
    public void glGetMaterialfv(
        int face,
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.641 -0400", hash_original_method = "DA45382300D64D4633231B25DC790ED5", hash_generated_method = "2BAFE5EF9294E74B84C1C3334FFD6F3D")
    public void glGetMaterialxv(
        int face,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.641 -0400", hash_original_method = "77D07CA7E363A44E04443485884C5B13", hash_generated_method = "55E71A61A3F9DA0CC2A48975DEBEB272")
    public void glGetMaterialxv(
        int face,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.641 -0400", hash_original_method = "BC56AF50A79D05EDBF323A443949E95D", hash_generated_method = "34E49F7BE853593F51EC4D2CDABB7933")
    public void glGetTexEnviv(
        int env,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.641 -0400", hash_original_method = "E065D6D8A539FB0D184E951B3A77BFAF", hash_generated_method = "0198A10AD3BDC4DEAA120146BC24E2EC")
    public void glGetTexEnviv(
        int env,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.641 -0400", hash_original_method = "EE2ECB11441E634C6CF011A0FBC9E456", hash_generated_method = "6D326FA269B82C66A6025CDF33630771")
    public void glGetTexEnvxv(
        int env,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.642 -0400", hash_original_method = "4763956A6FE09C8FE7B17EE79BBD7E20", hash_generated_method = "332FB2AC556F65222ED602CF156EFB71")
    public void glGetTexEnvxv(
        int env,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.642 -0400", hash_original_method = "A8EA7C4CAD5F8207BAFF4D19B2B8A061", hash_generated_method = "C61FE3F8643DB0814625D03CF3A4292F")
    public void glGetTexParameterfv(
        int target,
        int pname,
        float[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.642 -0400", hash_original_method = "4367C68441A9AA98F01515FDC90FDB44", hash_generated_method = "33C5CA9B88B87821DEE59B270ADCA5B8")
    public void glGetTexParameterfv(
        int target,
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.642 -0400", hash_original_method = "8602EDD51435EC27A0B8958E793FF372", hash_generated_method = "DCD6C15E6C61310CCB02674AE9FC7F04")
    public void glGetTexParameteriv(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.643 -0400", hash_original_method = "71368889A06C9E1744E4E25318DA6058", hash_generated_method = "4DEDD975EABD73009CBA66D860E54363")
    public void glGetTexParameteriv(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.643 -0400", hash_original_method = "1BA765DD7E0FB5AA6AD2EBB11DF8B607", hash_generated_method = "CBDEE98B03A690E1755D4C47276ED058")
    public void glGetTexParameterxv(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.643 -0400", hash_original_method = "374E464895B48D2BEAC554053928B2AF", hash_generated_method = "58ACF7D231D179C4B5D3617EA16203F5")
    public void glGetTexParameterxv(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.643 -0400", hash_original_method = "5CBCE22A13679DB40202021E228060B4", hash_generated_method = "C4C0F3C1D91B09653FAC4233BB6433C4")
    public boolean glIsBuffer(
        int buffer
    ) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_24550186 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_24550186;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.645 -0400", hash_original_method = "2B37B396792E11A373DC696386D55E16", hash_generated_method = "9D47F1B83A6F35ED0B7A55D16E8CA3D6")
    public boolean glIsEnabled(
        int cap
    ) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1560484781 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1560484781;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.645 -0400", hash_original_method = "B0774EFDFDF7E34E3A748242DEA5FF75", hash_generated_method = "952F1990EF12F1E669456AD8987FC480")
    public boolean glIsTexture(
        int texture
    ) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_409621762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_409621762;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.645 -0400", hash_original_method = "59EE792672F5ACA51D14291B099DC2AE", hash_generated_method = "7DE7E9570A5F12CC26089882858EE14E")
    public void glNormalPointer(
        int type,
        int stride,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.645 -0400", hash_original_method = "E63CD7975861B2CCB6AD8F16DA976646", hash_generated_method = "674884E74C9CF9EF0B221FACAB62BC15")
    public void glPointParameterf(
        int pname,
        float param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.645 -0400", hash_original_method = "A11196C9C3232519E010B3D895E7B10B", hash_generated_method = "0EF6BC4A85D27ED7775D4A494642AFFD")
    public void glPointParameterfv(
        int pname,
        float[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.645 -0400", hash_original_method = "6E76F6C08D9C74E626F785B0CF4DDD86", hash_generated_method = "34B7D9DF97CDA8B8EC58D38F54FA35DE")
    public void glPointParameterfv(
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.645 -0400", hash_original_method = "2BB54735F90AB9973C6E35C2068C71E7", hash_generated_method = "7FCD0AD642D1AB9E719ACECEE0069991")
    public void glPointParameterx(
        int pname,
        int param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.645 -0400", hash_original_method = "5934D4E26BE75521F9F4579D9C8DCFE4", hash_generated_method = "F153BAC91EB15FD48AA26141F3FF664B")
    public void glPointParameterxv(
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.645 -0400", hash_original_method = "C6C705CE06675FCC62C044DF88D7C5DF", hash_generated_method = "BBB9029E91F2D78688E2DF44FBDEFDA0")
    public void glPointParameterxv(
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.647 -0400", hash_original_method = "8C106C3CEF3BB7BF47C54FD961C1CA10", hash_generated_method = "192FD033B20D68F6ED4757DB5E20E943")
    private void glPointSizePointerOESBounds(
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.647 -0400", hash_original_method = "EC0D07F3AF47DBC4190CF008FCA93E16", hash_generated_method = "83CAA6310E8D729BFDB28784B91C6228")
    public void glPointSizePointerOES(
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        addTaint(stride);
        addTaint(type);
        glPointSizePointerOESBounds(
            type,
            stride,
            pointer,
            pointer.remaining()
        );
        if(((type == GL_FLOAT) ||
             (type == GL_FIXED)) &&
            (stride >= 0))        
        {
            _pointSizePointerOES = pointer;
        } //End block
        // ---------- Original Method ----------
        //glPointSizePointerOESBounds(
            //type,
            //stride,
            //pointer,
            //pointer.remaining()
        //);
        //if (((type == GL_FLOAT) ||
             //(type == GL_FIXED)) &&
            //(stride >= 0)) {
            //_pointSizePointerOES = pointer;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.647 -0400", hash_original_method = "12CDED926CDCF7EA42742009896284D9", hash_generated_method = "BEEB7F90DAAFDABB40F885C0E60BC7D2")
    public void glTexCoordPointer(
        int size,
        int type,
        int stride,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.647 -0400", hash_original_method = "D87BE224D969AEA6EA7B6B5DC106EE96", hash_generated_method = "CCE842E2B41412B300E5EA3B5F15F27F")
    public void glTexEnvi(
        int target,
        int pname,
        int param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.647 -0400", hash_original_method = "5D2B9210D6DE6236279DA021F5E63F79", hash_generated_method = "1EE73776A790986944D9BB3DB813E27C")
    public void glTexEnviv(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.647 -0400", hash_original_method = "5C6F79AEDC5DC4EAF22C5D32A1DF3A50", hash_generated_method = "812B29ED8282FE39B52E00715EA45BD9")
    public void glTexEnviv(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.648 -0400", hash_original_method = "A0FA0DFE2CA71C45A154ED0DC216DF9E", hash_generated_method = "F3C5DEFE659E72340B2F0BB04BFB1DE7")
    public void glTexParameterfv(
        int target,
        int pname,
        float[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.650 -0400", hash_original_method = "6A0800686C986953231F118EFA89B68E", hash_generated_method = "84F85B7687AF9D4B1C9F5454CA865AC9")
    public void glTexParameterfv(
        int target,
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.650 -0400", hash_original_method = "1ACB3111112291A939213D1C616FDF01", hash_generated_method = "9337018E4FBD3A51D5CEC05D62EC0981")
    public void glTexParameteri(
        int target,
        int pname,
        int param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.650 -0400", hash_original_method = "B9123A3C5F31C764ACDC251B4B063084", hash_generated_method = "63461BF2FB25497748EB5ED7A6A84E10")
    public void glTexParameteriv(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.650 -0400", hash_original_method = "14BFADF901BE034B97F27EFDB7249EC5", hash_generated_method = "706AD1647AB76023B717FA05180B904D")
    public void glTexParameteriv(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.650 -0400", hash_original_method = "3F6F8E0BA39C35229A89553DB35B9114", hash_generated_method = "AA8CDD740CE9F77FF0FBD8BD3A28FDE6")
    public void glTexParameterxv(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.651 -0400", hash_original_method = "04A367584151D9D9FD975F225EE885B4", hash_generated_method = "FB31B1CB7A49F6D78DE7CA49C332D78D")
    public void glTexParameterxv(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.651 -0400", hash_original_method = "7C26F1A50D75B77F9272FCB63EA624C6", hash_generated_method = "55FB5A034A8CE81FFA56AB7385E3BE7F")
    public void glVertexPointer(
        int size,
        int type,
        int stride,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.651 -0400", hash_original_method = "95BA1F07B3AEB4D134CCBDFFE0DB7EE4", hash_generated_method = "088FAEDEA4854D7EB7775F74A596E347")
    public void glCurrentPaletteMatrixOES(
        int matrixpaletteindex
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.654 -0400", hash_original_method = "D2BE11A64665DB8B06B4DC96FEC208B6", hash_generated_method = "8BA48329B99D7A974211CB8BCB41DD1B")
    public void glDrawTexfOES(
        float x,
        float y,
        float z,
        float width,
        float height
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.654 -0400", hash_original_method = "1910442FB838D19DD4C27DB699DB4D46", hash_generated_method = "20C1C3E93A70AEECDC66745DD696B083")
    public void glDrawTexfvOES(
        float[] coords,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.654 -0400", hash_original_method = "831C162EE3D2DC1DF6F1AE6669ECD44A", hash_generated_method = "66E20AEB2DCABC4B9D526413FCA44344")
    public void glDrawTexfvOES(
        java.nio.FloatBuffer coords
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.654 -0400", hash_original_method = "A28C833EC2B9C4EB45296643BE372A85", hash_generated_method = "BA074C8B04363EFC5884DF7657316BBE")
    public void glDrawTexiOES(
        int x,
        int y,
        int z,
        int width,
        int height
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.654 -0400", hash_original_method = "38C985EB15B5E699CFA5800CE9313B6C", hash_generated_method = "E9D424E2E3BD2F0B6684CB7FA6A0F9C4")
    public void glDrawTexivOES(
        int[] coords,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.654 -0400", hash_original_method = "2E2E2E76797892659616F6D96EE421EA", hash_generated_method = "6FEB75AD658B1EF49D8021D1DB894DB4")
    public void glDrawTexivOES(
        java.nio.IntBuffer coords
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.655 -0400", hash_original_method = "8566A29D8D8B09C3A6BC518418932CDB", hash_generated_method = "5BC5E4717FD6921F10384044CF47FE6C")
    public void glDrawTexsOES(
        short x,
        short y,
        short z,
        short width,
        short height
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.655 -0400", hash_original_method = "91E6CBADB398633A4383C31A0AD86296", hash_generated_method = "66D43E8347876BABCE456963DA42E4FF")
    public void glDrawTexsvOES(
        short[] coords,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.656 -0400", hash_original_method = "0954B7C7035D691303E55E25D6EFB672", hash_generated_method = "953734A7A074FBAF289DC86325E59B46")
    public void glDrawTexsvOES(
        java.nio.ShortBuffer coords
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.657 -0400", hash_original_method = "74CF88596F8DBCCE4A394CCE81E9FC91", hash_generated_method = "C93369A10F4FE4290D4C28AE1BB97E65")
    public void glDrawTexxOES(
        int x,
        int y,
        int z,
        int width,
        int height
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.657 -0400", hash_original_method = "2F7A3F5025DF5EF064319814B3209A3C", hash_generated_method = "E9799EA25704C419BAC17A7D6A96BA02")
    public void glDrawTexxvOES(
        int[] coords,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.657 -0400", hash_original_method = "51D917B4A8B9530FF8924BF2E6AF392B", hash_generated_method = "DBD5276AC63C2CD93ABD31E4BF0EBE85")
    public void glDrawTexxvOES(
        java.nio.IntBuffer coords
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.657 -0400", hash_original_method = "0DEF4FDA31B693FD58B4F5466D1F6B2D", hash_generated_method = "9AE3D51ED1F5C97D2F81EBC963677EAD")
    public void glLoadPaletteFromModelViewMatrixOES(
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.657 -0400", hash_original_method = "6A7CA123A9CB88F0A99C0D9B4D2D33AF", hash_generated_method = "6BFF8A7BF2A6F82B68D60E240DA4F053")
    private void glMatrixIndexPointerOESBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.657 -0400", hash_original_method = "A2DEF3847665EA2F7AE241D0B05BBB08", hash_generated_method = "3C1B365E1C7CB14D82D37D2568A607CA")
    public void glMatrixIndexPointerOES(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        glMatrixIndexPointerOESBounds(
            size,
            type,
            stride,
            pointer,
            pointer.remaining()
        );
        if(((size == 2) ||
             (size == 3) ||
             (size == 4)) &&
            ((type == GL_FLOAT) ||
             (type == GL_BYTE) ||
             (type == GL_SHORT) ||
             (type == GL_FIXED)) &&
            (stride >= 0))        
        {
            _matrixIndexPointerOES = pointer;
        } //End block
        // ---------- Original Method ----------
        //glMatrixIndexPointerOESBounds(
            //size,
            //type,
            //stride,
            //pointer,
            //pointer.remaining()
        //);
        //if (((size == 2) ||
             //(size == 3) ||
             //(size == 4)) &&
            //((type == GL_FLOAT) ||
             //(type == GL_BYTE) ||
             //(type == GL_SHORT) ||
             //(type == GL_FIXED)) &&
            //(stride >= 0)) {
            //_matrixIndexPointerOES = pointer;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.660 -0400", hash_original_method = "C6EEDA2F0CB848D1825DAA27E05C1F25", hash_generated_method = "6AE091AC465616795CF2349E770B5E15")
    public void glMatrixIndexPointerOES(
        int size,
        int type,
        int stride,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.660 -0400", hash_original_method = "733A86C2F1705E763179D2C64FE1F559", hash_generated_method = "F934C71687EE1574AD10A5B91E529246")
    private void glWeightPointerOESBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.660 -0400", hash_original_method = "DA1591FF7EA6F5F9EAE67C123814B637", hash_generated_method = "6A12EB1EF326E9D46E15E8936408A400")
    public void glWeightPointerOES(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        addTaint(pointer.getTaint());
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        glWeightPointerOESBounds(
            size,
            type,
            stride,
            pointer,
            pointer.remaining()
        );
        // ---------- Original Method ----------
        //glWeightPointerOESBounds(
            //size,
            //type,
            //stride,
            //pointer,
            //pointer.remaining()
        //);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.660 -0400", hash_original_method = "80F6563B1D95178FF3AFD1CF5B96CA9E", hash_generated_method = "87AC33DC16A807C0D79E7987B7661C29")
    public void glWeightPointerOES(
        int size,
        int type,
        int stride,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.661 -0400", hash_original_method = "7012E0C28CAA85B7F547C387DC5490BF", hash_generated_method = "D7ABCF29F341A6A51E4546A4DAD526ED")
    public void glBindFramebufferOES(
        int target,
        int framebuffer
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.661 -0400", hash_original_method = "E996F619A69BBB02AE5800FE72064177", hash_generated_method = "6D9D9DEF37C0D52937F215CED2048C3E")
    public void glBindRenderbufferOES(
        int target,
        int renderbuffer
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.661 -0400", hash_original_method = "96629AB18523F1B8BD5CC1F0B06C9A3A", hash_generated_method = "1B725DDA1D626B3E0541EC6BBBD8BBB3")
    public void glBlendEquation(
        int mode
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.661 -0400", hash_original_method = "D2522F56984AE422BAA6705290A5800D", hash_generated_method = "9CC386155D1395333CC1C2A2F487413C")
    public void glBlendEquationSeparate(
        int modeRGB,
        int modeAlpha
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.661 -0400", hash_original_method = "BEC8094313FE35DDC834FD9794924A8C", hash_generated_method = "09AD10A1045FFE8F9EA784557728A320")
    public void glBlendFuncSeparate(
        int srcRGB,
        int dstRGB,
        int srcAlpha,
        int dstAlpha
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.662 -0400", hash_original_method = "B1A4A768D52CA135614FAA74BF2A89E7", hash_generated_method = "E5FB03530B5F5EC41A8A6A68DBAB5E09")
    public int glCheckFramebufferStatusOES(
        int target
    ) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37005314 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37005314;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.663 -0400", hash_original_method = "224046A7647ABE7AB757051B3805C7F0", hash_generated_method = "7DB01978BA6A89F93E8D5648FEFB13ED")
    public void glDeleteFramebuffersOES(
        int n,
        int[] framebuffers,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.663 -0400", hash_original_method = "0DFDB8F7E46ED0CE9E0FCF78465DA298", hash_generated_method = "50D65AC9A13569100E3D914B8AFAAAF7")
    public void glDeleteFramebuffersOES(
        int n,
        java.nio.IntBuffer framebuffers
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.663 -0400", hash_original_method = "1FFECA3ED850152A6CC369D1F14D97EB", hash_generated_method = "09D47B642298231F6E3D04CC4387F310")
    public void glDeleteRenderbuffersOES(
        int n,
        int[] renderbuffers,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.663 -0400", hash_original_method = "46CFE024939DBAEA7FE408A9C7C03F41", hash_generated_method = "689894580BE2A65416F8B357F9459003")
    public void glDeleteRenderbuffersOES(
        int n,
        java.nio.IntBuffer renderbuffers
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.663 -0400", hash_original_method = "DF7EC8EDF18B86227477D66A9E612D5C", hash_generated_method = "6FF7BAB2A5DD4D8AB44004A087436294")
    public void glFramebufferRenderbufferOES(
        int target,
        int attachment,
        int renderbuffertarget,
        int renderbuffer
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.663 -0400", hash_original_method = "E6578E5E33958E12104B156D133D18C1", hash_generated_method = "23583F5ADDB470B4DA074F39323A8FCE")
    public void glFramebufferTexture2DOES(
        int target,
        int attachment,
        int textarget,
        int texture,
        int level
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.663 -0400", hash_original_method = "CF3BBC0690535D9ACEDA510E7C25FE93", hash_generated_method = "2345F549F4E18DFDFF6D6F4DA626148A")
    public void glGenerateMipmapOES(
        int target
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.665 -0400", hash_original_method = "5CF430CF82275396EA94D85409CBB33E", hash_generated_method = "F740DD93029F20A598DB143D34AB1D56")
    public void glGenFramebuffersOES(
        int n,
        int[] framebuffers,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.665 -0400", hash_original_method = "4BB7994AB48E0E49BC5DEE99DDBE64C7", hash_generated_method = "2D41EB078E63FC75B02750775E68C0F1")
    public void glGenFramebuffersOES(
        int n,
        java.nio.IntBuffer framebuffers
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.665 -0400", hash_original_method = "C06623E355A0F7E782F31327854908F9", hash_generated_method = "AA1E1B141813B17A8EDDDBDE63485FE7")
    public void glGenRenderbuffersOES(
        int n,
        int[] renderbuffers,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.666 -0400", hash_original_method = "7033C2CDCB61F1BA8BB94D8B8850FD60", hash_generated_method = "D27D72423F8A6D7E2A11709CE0A4C38E")
    public void glGenRenderbuffersOES(
        int n,
        java.nio.IntBuffer renderbuffers
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.666 -0400", hash_original_method = "F29F63990C9EBFB77B2A5E7A020E447B", hash_generated_method = "AC73186ABB1F8D89878B092FF1161E13")
    public void glGetFramebufferAttachmentParameterivOES(
        int target,
        int attachment,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.666 -0400", hash_original_method = "80E3B7662123EAE7B5048632F9E3C14B", hash_generated_method = "F1883D40ABAC45CBA1EF0A3FE7DD4A3A")
    public void glGetFramebufferAttachmentParameterivOES(
        int target,
        int attachment,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.666 -0400", hash_original_method = "6361A7359BD6B257B9C730DAA1639DC0", hash_generated_method = "736B4A752167341D19AAC2AFADD2E008")
    public void glGetRenderbufferParameterivOES(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.666 -0400", hash_original_method = "D4443F3E98C9A915B5F88EF6379DF720", hash_generated_method = "CBF9D502273A3EFEBD0748D112269FE9")
    public void glGetRenderbufferParameterivOES(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.668 -0400", hash_original_method = "CCB2C58BFB01275BCB44948E86C23A6F", hash_generated_method = "4EA9F8BDA0807B552139D70B80A8D5D2")
    public void glGetTexGenfv(
        int coord,
        int pname,
        float[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.668 -0400", hash_original_method = "BA57774F60DC2980B7FF38B0A2E8016F", hash_generated_method = "D8C305F22C97C2D5CDA043864F79EC05")
    public void glGetTexGenfv(
        int coord,
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.668 -0400", hash_original_method = "D83AC0B94E45154E9C39405960588DD9", hash_generated_method = "3B465CF2F22E15B1CB9A0D2F07A68BE6")
    public void glGetTexGeniv(
        int coord,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.668 -0400", hash_original_method = "EF430454571D4D94946D5978BDE708A5", hash_generated_method = "7E3934B0CCA8BF9B46F6944711227F54")
    public void glGetTexGeniv(
        int coord,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.668 -0400", hash_original_method = "1448662FEB07A59CFBC07726254162A7", hash_generated_method = "E60F9E2890CD693A777F5A7117F1421B")
    public void glGetTexGenxv(
        int coord,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.668 -0400", hash_original_method = "AA312740D7D8B86852FA57EC0F935C49", hash_generated_method = "FBE302FE969B6BAFA7F2CDAE4494DE7F")
    public void glGetTexGenxv(
        int coord,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.668 -0400", hash_original_method = "0A5D6A2632DB9C567FFD91F0ACA40965", hash_generated_method = "EA1E2F5CB9C2933EA62DE896C0E78C23")
    public boolean glIsFramebufferOES(
        int framebuffer
    ) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_552055998 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_552055998;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.668 -0400", hash_original_method = "B2AFE473D5090C2AFBF0DD5218613E24", hash_generated_method = "069809AEB7C0EE25AA20827FB5D05BBC")
    public boolean glIsRenderbufferOES(
        int renderbuffer
    ) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_77407139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_77407139;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.670 -0400", hash_original_method = "4BF2A91D21E16F3AE981CF68C4DFDE38", hash_generated_method = "8241BBDD3D88A1F88CBDBBFDF2DD0516")
    public void glRenderbufferStorageOES(
        int target,
        int internalformat,
        int width,
        int height
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.670 -0400", hash_original_method = "DF1DDF095262CB65042B8B6E4ACB5D83", hash_generated_method = "50052B95EBE6EAF693C9705AC0EE570B")
    public void glTexGenf(
        int coord,
        int pname,
        float param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.670 -0400", hash_original_method = "021935B8D9D6C7B463624EBDA4B11EB4", hash_generated_method = "28ABC6E8CBC6BBDB453E4EFC5DA68666")
    public void glTexGenfv(
        int coord,
        int pname,
        float[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.670 -0400", hash_original_method = "D8B15F6B92AF3D4541AFD7FC1F3284DA", hash_generated_method = "3E9B8927CC774F323E17FEA9BF9E20D8")
    public void glTexGenfv(
        int coord,
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.670 -0400", hash_original_method = "53C8322668092422760AEEABF3A0A50D", hash_generated_method = "E7BCC2AFF3EF6A5E1D3C3E25BFF5AEA8")
    public void glTexGeni(
        int coord,
        int pname,
        int param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.670 -0400", hash_original_method = "B98ED31CB4FEB2295803ED2F666679A9", hash_generated_method = "F12DFF4C8DFFEDC5058AF77BDA045563")
    public void glTexGeniv(
        int coord,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.670 -0400", hash_original_method = "E7AA7F75A0A7E8AB84868E171B6AFAE8", hash_generated_method = "2FA34D679591A253774114A71A6EB7A2")
    public void glTexGeniv(
        int coord,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.670 -0400", hash_original_method = "231B06A212F7462B4A9045C185C5C0A0", hash_generated_method = "E05BA4CE502124162AA075CDA9B4AFCE")
    public void glTexGenx(
        int coord,
        int pname,
        int param
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.672 -0400", hash_original_method = "1AD9E3A06A99E29BF5DD361F01CD823D", hash_generated_method = "42B401DCD2C56F63216881D4870F97DB")
    public void glTexGenxv(
        int coord,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.672 -0400", hash_original_method = "33A72688981BB5774C2892D6B098DC19", hash_generated_method = "AB9EC2E057FA8F886E8073F11EC49C74")
    public void glTexGenxv(
        int coord,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
    static {
	_nativeClassInit();
    }
    
}

