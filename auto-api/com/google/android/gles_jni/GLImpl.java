package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.AppGlobals;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.os.Build;
import android.util.Log;
import java.nio.Buffer;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL10Ext;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11Ext;
import javax.microedition.khronos.opengles.GL11ExtensionPack;

public class GLImpl implements GL10, GL10Ext, GL11, GL11Ext, GL11ExtensionPack {
    Buffer _colorPointer = null;
    Buffer _normalPointer = null;
    Buffer _texCoordPointer = null;
    Buffer _vertexPointer = null;
    Buffer _pointSizePointerOES = null;
    Buffer _matrixIndexPointerOES = null;
    Buffer _weightPointerOES = null;
    private boolean haveCheckedExtensions;
    private boolean have_OES_blend_equation_separate;
    private boolean have_OES_blend_subtract;
    private boolean have_OES_framebuffer_object;
    private boolean have_OES_texture_cube_map;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.162 -0400", hash_original_method = "B8D773F1A7CFA96D2497C742B1D0AB9A", hash_generated_method = "11F556B43317BDD2203C73CA96CCDB1C")
    @DSModeled(DSC.SAFE)
    public GLImpl() {
        // ---------- Original Method ----------
    }

    
        private static void _nativeClassInit() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.162 -0400", hash_original_method = "16A1ADA10B85F20D9DE0E81A43C2050C", hash_generated_method = "5402862D58543B69A0050019E5249C19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetPointerv(int pname, java.nio.Buffer[] params) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0].dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("glGetPointerv");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("glGetPointerv");
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.162 -0400", hash_original_method = "97DEC0321FF9B09E49E45C9980AD2CAB", hash_generated_method = "D62ED5AE2E50D75134964485D30D872E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glActiveTexture(
        int texture
    ) {
        dsTaint.addTaint(texture);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.163 -0400", hash_original_method = "E7B4134F951CACA5D3E260E6C8389AD6", hash_generated_method = "9635D0BF2131CDC972F852BA669F4719")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glAlphaFunc(
        int func,
        float ref
    ) {
        dsTaint.addTaint(ref);
        dsTaint.addTaint(func);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.163 -0400", hash_original_method = "0865B3896933828D18B5F3FD6A177BE6", hash_generated_method = "7B2ECEA9187344E806846A431ACA9C76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glAlphaFuncx(
        int func,
        int ref
    ) {
        dsTaint.addTaint(ref);
        dsTaint.addTaint(func);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.163 -0400", hash_original_method = "F26D066144D77B7F711F4AD20988DF70", hash_generated_method = "DF661381577E4BFE8A390784BE2BC7E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glBindTexture(
        int target,
        int texture
    ) {
        dsTaint.addTaint(texture);
        dsTaint.addTaint(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.163 -0400", hash_original_method = "A2FFC2EC79748E7F073DCEF2CA88E7F7", hash_generated_method = "046D59E450CF4B28168EC636C950E6D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glBlendFunc(
        int sfactor,
        int dfactor
    ) {
        dsTaint.addTaint(sfactor);
        dsTaint.addTaint(dfactor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.163 -0400", hash_original_method = "CEF5782DE326F4639690136522E382D5", hash_generated_method = "10F57893FF763874B6D7FD0FAE48AFB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glClear(
        int mask
    ) {
        dsTaint.addTaint(mask);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.163 -0400", hash_original_method = "7CE69D057BBB96A8C17F9D52DC80AA96", hash_generated_method = "6257EF2ABBCC25BA370A3C4203123741")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glClearColor(
        float red,
        float green,
        float blue,
        float alpha
    ) {
        dsTaint.addTaint(red);
        dsTaint.addTaint(blue);
        dsTaint.addTaint(green);
        dsTaint.addTaint(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.163 -0400", hash_original_method = "275A5B33E1A225983A518F82979B2F68", hash_generated_method = "C56358AED6601A7BB5DFD26E8AEE326E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glClearColorx(
        int red,
        int green,
        int blue,
        int alpha
    ) {
        dsTaint.addTaint(red);
        dsTaint.addTaint(blue);
        dsTaint.addTaint(green);
        dsTaint.addTaint(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.164 -0400", hash_original_method = "1EB7D9BA90DAFE23078810226BAE8C0C", hash_generated_method = "5A69EF4BB0309635EA8D4E2FF8A63849")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glClearDepthf(
        float depth
    ) {
        dsTaint.addTaint(depth);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.164 -0400", hash_original_method = "3F34D4A59EEDC6C0D2CA3EEB8AC8090C", hash_generated_method = "B6ECA2F780669D946FAE24FBFDEEE90F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glClearDepthx(
        int depth
    ) {
        dsTaint.addTaint(depth);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.164 -0400", hash_original_method = "0B981F79246B08586C7CE02E0CA71119", hash_generated_method = "F1686983113B5C10C9BADF2CCC51215D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glClearStencil(
        int s
    ) {
        dsTaint.addTaint(s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.164 -0400", hash_original_method = "0F933753B69BA360F13E4FB9F8E0065B", hash_generated_method = "B0396ABF15F312BDB2C0DC692BAAEEE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glClientActiveTexture(
        int texture
    ) {
        dsTaint.addTaint(texture);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.164 -0400", hash_original_method = "0533CB48F440C5DC30BCFA6724D2A255", hash_generated_method = "B3A841A45B8889E00C3984D0F5170C6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glColor4f(
        float red,
        float green,
        float blue,
        float alpha
    ) {
        dsTaint.addTaint(red);
        dsTaint.addTaint(blue);
        dsTaint.addTaint(green);
        dsTaint.addTaint(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.164 -0400", hash_original_method = "74951C5E7B28BB879C844C1CB4A28E26", hash_generated_method = "D374FA47C311CCD78693924420FA32A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glColor4x(
        int red,
        int green,
        int blue,
        int alpha
    ) {
        dsTaint.addTaint(red);
        dsTaint.addTaint(blue);
        dsTaint.addTaint(green);
        dsTaint.addTaint(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.165 -0400", hash_original_method = "35F5236562E70DF9BC2799C8D2FADA8F", hash_generated_method = "1853BDACB358F87867A19E1F1922DED0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glColorMask(
        boolean red,
        boolean green,
        boolean blue,
        boolean alpha
    ) {
        dsTaint.addTaint(red);
        dsTaint.addTaint(blue);
        dsTaint.addTaint(green);
        dsTaint.addTaint(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.165 -0400", hash_original_method = "D299BA021168438B5E6E34E52FC6C3F5", hash_generated_method = "E4E4208F0CBA2B927916A7B75D0318C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void glColorPointerBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
        dsTaint.addTaint(remaining);
        dsTaint.addTaint(pointer.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.165 -0400", hash_original_method = "BE0504B13DA269CA089182E44C7F834B", hash_generated_method = "1727C93C1EF6006686816BB472FA0A4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glColorPointer(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        dsTaint.addTaint(pointer.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(size);
        glColorPointerBounds(
            size,
            type,
            stride,
            pointer,
            pointer.remaining()
        );
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.165 -0400", hash_original_method = "1DF16BDBC659AD9A84053C254D5C876E", hash_generated_method = "7E3D2B5168875F3D0B18C62C5AC6BC93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        dsTaint.addTaint(height);
        dsTaint.addTaint(level);
        dsTaint.addTaint(width);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(target);
        dsTaint.addTaint(imageSize);
        dsTaint.addTaint(border);
        dsTaint.addTaint(internalformat);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.165 -0400", hash_original_method = "5F3B11428832BB3EDC7989E25F3372FC", hash_generated_method = "2B3A637868B370EA3B98134744C33E01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        dsTaint.addTaint(height);
        dsTaint.addTaint(level);
        dsTaint.addTaint(xoffset);
        dsTaint.addTaint(yoffset);
        dsTaint.addTaint(width);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(target);
        dsTaint.addTaint(imageSize);
        dsTaint.addTaint(format);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.165 -0400", hash_original_method = "842526CAA5B5EF81DE180C77C64E9061", hash_generated_method = "8368481126A99957CA0E9B71DC8E2412")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        dsTaint.addTaint(height);
        dsTaint.addTaint(level);
        dsTaint.addTaint(width);
        dsTaint.addTaint(target);
        dsTaint.addTaint(border);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        dsTaint.addTaint(internalformat);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.166 -0400", hash_original_method = "F04240E045617269474207BFBECC16FF", hash_generated_method = "912645F958AE6EBB704995556E3674F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        dsTaint.addTaint(height);
        dsTaint.addTaint(level);
        dsTaint.addTaint(xoffset);
        dsTaint.addTaint(yoffset);
        dsTaint.addTaint(width);
        dsTaint.addTaint(target);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.166 -0400", hash_original_method = "BF058CF8285375279C20F1E97C513D8F", hash_generated_method = "A0CAB7760A3E1E06FFA0D5FA78B24877")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glCullFace(
        int mode
    ) {
        dsTaint.addTaint(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.166 -0400", hash_original_method = "101445A2DF4F3A2138F3CE9187FCE63C", hash_generated_method = "164B6AAE3269151E5CA5776629721BB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDeleteTextures(
        int n,
        int[] textures,
        int offset
    ) {
        dsTaint.addTaint(textures[0]);
        dsTaint.addTaint(n);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.166 -0400", hash_original_method = "D095348CAE17C3691EC094768112CBAF", hash_generated_method = "2177A237526E7591C55E9AE522E38315")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDeleteTextures(
        int n,
        java.nio.IntBuffer textures
    ) {
        dsTaint.addTaint(textures.dsTaint);
        dsTaint.addTaint(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.166 -0400", hash_original_method = "8C02F7FAED1907F361FD59A628ECBD22", hash_generated_method = "B7E53F48D4215E7951E88319ED197562")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDepthFunc(
        int func
    ) {
        dsTaint.addTaint(func);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.166 -0400", hash_original_method = "C2DFC52E0130222A386062E7C36C540C", hash_generated_method = "663F010F0D0747B201CB118B04256EC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDepthMask(
        boolean flag
    ) {
        dsTaint.addTaint(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.166 -0400", hash_original_method = "E7355D3212849EB0BD47CDEAB4ED34D8", hash_generated_method = "82BAA1CD0DF0C18DD7E0F0B52DD3B694")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDepthRangef(
        float zNear,
        float zFar
    ) {
        dsTaint.addTaint(zFar);
        dsTaint.addTaint(zNear);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.167 -0400", hash_original_method = "E32ECE36BCFE7480D9AC74D264F5EFCB", hash_generated_method = "F675BF73A2D444AFF9C5FF7385521724")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDepthRangex(
        int zNear,
        int zFar
    ) {
        dsTaint.addTaint(zFar);
        dsTaint.addTaint(zNear);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.167 -0400", hash_original_method = "256D91725811492CC49701A657A0BEE5", hash_generated_method = "0EB19623BA29AA63257D44E5021E8BB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDisable(
        int cap
    ) {
        dsTaint.addTaint(cap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.167 -0400", hash_original_method = "45A7662FE3309DCB52E9D50B8B88E585", hash_generated_method = "532E7927F0709640F8C648393AFF1024")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDisableClientState(
        int array
    ) {
        dsTaint.addTaint(array);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.167 -0400", hash_original_method = "D8CC37788E3378C496F8ED8C8C656160", hash_generated_method = "EAF8B5154EC154973B78765B40DCE0C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDrawArrays(
        int mode,
        int first,
        int count
    ) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(first);
        dsTaint.addTaint(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.167 -0400", hash_original_method = "AA331AE5D7C80D1BAA992FA5E2ACE318", hash_generated_method = "88F6524E025620B5723161F59307FB01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDrawElements(
        int mode,
        int count,
        int type,
        java.nio.Buffer indices
    ) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(indices.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.167 -0400", hash_original_method = "DA63A528B7CE4387E843DC02AB39FA4E", hash_generated_method = "71053DD67EE5E8B87E4C7F37D038A190")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glEnable(
        int cap
    ) {
        dsTaint.addTaint(cap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.167 -0400", hash_original_method = "65AED86EB3A5CAC39903F830C4DC3A62", hash_generated_method = "1853827A8BBE7E62449E775F54145EB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glEnableClientState(
        int array
    ) {
        dsTaint.addTaint(array);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.168 -0400", hash_original_method = "B245C18D1679C9F54DA6F9DB4AB7671B", hash_generated_method = "42B3C8E68A9B47CE73D394313B40F773")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glFinish(
    ) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.168 -0400", hash_original_method = "0DC82BEA9D8586E19F2791A82FAA6841", hash_generated_method = "6501AEDD1510D399BC012100D3EAE705")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glFlush(
    ) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.168 -0400", hash_original_method = "B9E8FFE3840C500F758630055A918A38", hash_generated_method = "4A18026FC8B4A20A9D5FBC88AF84A39E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glFogf(
        int pname,
        float param
    ) {
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.168 -0400", hash_original_method = "BE00E22E98F513D77F19185FDB52DF2B", hash_generated_method = "5573D6C07A79F34DB8CADAFE3CDAF585")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glFogfv(
        int pname,
        float[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.168 -0400", hash_original_method = "AD37BF249EE97473580D297C4497D098", hash_generated_method = "02A3EAE96458B3CBFEF1CFF6AAC5768D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glFogfv(
        int pname,
        java.nio.FloatBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.168 -0400", hash_original_method = "D2A635C8556AD8704E3B26380CA4E66B", hash_generated_method = "C73BD43FE684F58A35B0A0E7BB9D24F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glFogx(
        int pname,
        int param
    ) {
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.168 -0400", hash_original_method = "56931392328BA8F65D6B9AE45F613231", hash_generated_method = "565074AD7B10CA09E2FE2F76620D8C39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glFogxv(
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.168 -0400", hash_original_method = "D9ACE5927E1ADC9EC43FDBC1C3AFD392", hash_generated_method = "1A7F30EE69D90D486D802C4353AD31FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glFogxv(
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.169 -0400", hash_original_method = "58E66F9B437E228FC7F553B01D901911", hash_generated_method = "09FFCE3FDE301C7A705E76C70C37A1EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glFrontFace(
        int mode
    ) {
        dsTaint.addTaint(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.169 -0400", hash_original_method = "258ACC44157D8C73AE0DD0608758234D", hash_generated_method = "17927C8AADA77BE0055AADEA58E81CEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glFrustumf(
        float left,
        float right,
        float bottom,
        float top,
        float zNear,
        float zFar
    ) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(zFar);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(zNear);
        dsTaint.addTaint(top);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.169 -0400", hash_original_method = "B647E46DB6CC0EF9C5D63CE945C7426B", hash_generated_method = "BF0A564D44F98A51F378F556CF99B291")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glFrustumx(
        int left,
        int right,
        int bottom,
        int top,
        int zNear,
        int zFar
    ) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(zFar);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(zNear);
        dsTaint.addTaint(top);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.169 -0400", hash_original_method = "F376BD874C5726C877C78955E3906803", hash_generated_method = "6C8832FF8F63FECF07EC4E6114C15491")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGenTextures(
        int n,
        int[] textures,
        int offset
    ) {
        dsTaint.addTaint(textures[0]);
        dsTaint.addTaint(n);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.169 -0400", hash_original_method = "5433EB0BD32825204D952206851671B4", hash_generated_method = "AB7DCFD14938A4767CA4CCE9ED3E2A7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGenTextures(
        int n,
        java.nio.IntBuffer textures
    ) {
        dsTaint.addTaint(textures.dsTaint);
        dsTaint.addTaint(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.169 -0400", hash_original_method = "3AEB3B830A2084F227EAFBC906BD9186", hash_generated_method = "18F9A1445BEE527DDF6CD45FDDA0A26A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int glGetError(
    ) {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.169 -0400", hash_original_method = "BE83917E35D95BF70433F1B2EFD4AA45", hash_generated_method = "D5533CB9A1DF299A705BD76D5896F557")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetIntegerv(
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.170 -0400", hash_original_method = "773ECB86C0D6C008ED75815E0C485FED", hash_generated_method = "32DEC6606CA530478ECCB28A1E8A394B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetIntegerv(
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.170 -0400", hash_original_method = "C8F5D66A4A0C233120B2D99EA024C798", hash_generated_method = "1860A7B96A7CF6A39270404031336E21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String _glGetString(
        int name
    ) {
        dsTaint.addTaint(name);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.170 -0400", hash_original_method = "A9D2CB8422A028FB150957649B6BF2BA", hash_generated_method = "611E2CEA19B72C4C524EAE5104D7809F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String glGetString(
        int name
    ) {
        dsTaint.addTaint(name);
        String returnValue;
        returnValue = _glGetString(
            name
        );
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String returnValue;
        //returnValue = _glGetString(
            //name
        //);
        //return returnValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.170 -0400", hash_original_method = "E301695B30A10DCD62C26798611AB78D", hash_generated_method = "78A008F90A1AFE4EE229DB6F1CB5F66A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glHint(
        int target,
        int mode
    ) {
        dsTaint.addTaint(target);
        dsTaint.addTaint(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.170 -0400", hash_original_method = "5B55D240600D2347D0B596E98C1FD03E", hash_generated_method = "D849E5B50CD4D7D7C0221CE5B88F3FC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLightModelf(
        int pname,
        float param
    ) {
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.170 -0400", hash_original_method = "469DC3934BDE6F64F646577239C71F2F", hash_generated_method = "BDC917B0982C5E3280D42BD700050A85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLightModelfv(
        int pname,
        float[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.171 -0400", hash_original_method = "F43364E33E247B9D84BA159B372B4002", hash_generated_method = "8BB73E34E873EDD190B36A10215C7D51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLightModelfv(
        int pname,
        java.nio.FloatBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.171 -0400", hash_original_method = "9B3A746FED707CC1F39424E3DA8ABB06", hash_generated_method = "47CA6CDBC25ACF286153A8C9D9AF1AF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLightModelx(
        int pname,
        int param
    ) {
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.171 -0400", hash_original_method = "63BEC7A58A6C485233CE34909855CC91", hash_generated_method = "0F586133784B5BCE583FA5715FB717D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLightModelxv(
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.171 -0400", hash_original_method = "4983CEF3084132F982716E77E65DA0DC", hash_generated_method = "56F150E67B1C42D028847603AEC97A8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLightModelxv(
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.171 -0400", hash_original_method = "BC4F16E0EA5A26CEBC4A97ACCF933FD8", hash_generated_method = "87D3286F5FCED297067744277488DA63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLightf(
        int light,
        int pname,
        float param
    ) {
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(light);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.171 -0400", hash_original_method = "EB971A23213F76661BF6D474DB7C2C2B", hash_generated_method = "74070D8CBADBB80452BD38AB05493077")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLightfv(
        int light,
        int pname,
        float[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(light);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.172 -0400", hash_original_method = "BBD1B83CF877B43B7D98E2E20B1FA8F5", hash_generated_method = "FEEC7482DE6785E3D3A7A6952A5845A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLightfv(
        int light,
        int pname,
        java.nio.FloatBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(light);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.172 -0400", hash_original_method = "1636FACE953A8B90B672FD6B8B82E049", hash_generated_method = "3A741F28A331AEB643849971393B8E11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLightx(
        int light,
        int pname,
        int param
    ) {
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(light);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.173 -0400", hash_original_method = "5EEC4CF6BA8F18D7C0133A72068C6997", hash_generated_method = "95D3307B089DBC4CFBFEC01E73C70BD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLightxv(
        int light,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(light);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.173 -0400", hash_original_method = "A87D0BD27836CABD7E83A0BE50712B19", hash_generated_method = "809F57132EECCD5737569752958E1DDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLightxv(
        int light,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(light);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.173 -0400", hash_original_method = "418A5E015C9F0EF8168906698F676B52", hash_generated_method = "9050D8A73E770C4510D6809859AB0412")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLineWidth(
        float width
    ) {
        dsTaint.addTaint(width);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.173 -0400", hash_original_method = "46A2A26397F6D04C8D01B2E1097F9B31", hash_generated_method = "9B39E5688CD1AF1B1A6DB38F2775C5A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLineWidthx(
        int width
    ) {
        dsTaint.addTaint(width);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.173 -0400", hash_original_method = "D042F9F6A97E88B9C214C3163B975280", hash_generated_method = "6459B682ADFDC7A99B84D5DA90D419D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLoadIdentity(
    ) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.173 -0400", hash_original_method = "BF5B7D451473F76AF4260EBB3D9B9ECD", hash_generated_method = "505D28B337A8339B6D69ECFB28A41C39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLoadMatrixf(
        float[] m,
        int offset
    ) {
        dsTaint.addTaint(m[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.173 -0400", hash_original_method = "837F28F7EEECF84ECA621818DC3C637A", hash_generated_method = "9BA23BA533B8B710361DF7C01FFDE30E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLoadMatrixf(
        java.nio.FloatBuffer m
    ) {
        dsTaint.addTaint(m.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.174 -0400", hash_original_method = "8EEBBA5929A3A830E73BB9FC9F171FB5", hash_generated_method = "DD1976A93DD1C6265F92D744BC7E862A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLoadMatrixx(
        int[] m,
        int offset
    ) {
        dsTaint.addTaint(m[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.174 -0400", hash_original_method = "3F7B33E669417D7583090F577D211E45", hash_generated_method = "1DC63BF0F39F7F60328F716076722495")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLoadMatrixx(
        java.nio.IntBuffer m
    ) {
        dsTaint.addTaint(m.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.174 -0400", hash_original_method = "EFB3D7E34F512A452A0388AA3929F12A", hash_generated_method = "5B7326C86CB1F3A6A31DC381A70C8008")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLogicOp(
        int opcode
    ) {
        dsTaint.addTaint(opcode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.174 -0400", hash_original_method = "2486F3344BB028D6ECF51AD6932BC71D", hash_generated_method = "D39C49B749E7191FC6052B906290D9C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glMaterialf(
        int face,
        int pname,
        float param
    ) {
        dsTaint.addTaint(face);
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.174 -0400", hash_original_method = "FBDA35E6E17FD54BBA85AC8AD5CB2D2D", hash_generated_method = "A2FA57F5D94E09C9230D4D4292A466C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glMaterialfv(
        int face,
        int pname,
        float[] params,
        int offset
    ) {
        dsTaint.addTaint(face);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.174 -0400", hash_original_method = "0C556B2BE454B86C9858160252C402E3", hash_generated_method = "98E931A401040B0AF0A5FFCD6DCB674F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glMaterialfv(
        int face,
        int pname,
        java.nio.FloatBuffer params
    ) {
        dsTaint.addTaint(face);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.174 -0400", hash_original_method = "061C8AE3D5B422D4FA509AC9BB661EA2", hash_generated_method = "09EACB4FE0B29C41DF08928144DC2121")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glMaterialx(
        int face,
        int pname,
        int param
    ) {
        dsTaint.addTaint(face);
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.174 -0400", hash_original_method = "472B643031F0D036A87E30E2765D5474", hash_generated_method = "817D08D953F041A3AB8A637B62C66C4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glMaterialxv(
        int face,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(face);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.175 -0400", hash_original_method = "C8896486401C23A34B9A8815791ACA5F", hash_generated_method = "AA8DAD15FEA0511D95D1DD1805218086")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glMaterialxv(
        int face,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(face);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.175 -0400", hash_original_method = "071A0DE8AF455560D084B2FEE6249056", hash_generated_method = "E18E2303F70EB6CC32286ACA09686B18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glMatrixMode(
        int mode
    ) {
        dsTaint.addTaint(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.175 -0400", hash_original_method = "F3AFD06B34A43E8403C806B69E46B6B8", hash_generated_method = "428C79CC946E3BD81DE16E31387FE8C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glMultMatrixf(
        float[] m,
        int offset
    ) {
        dsTaint.addTaint(m[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.175 -0400", hash_original_method = "9713DC69CB7C2DDBF435393A004F3DD4", hash_generated_method = "2A4B6DAF1FA52E1DF7EBC95A1E4DEDAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glMultMatrixf(
        java.nio.FloatBuffer m
    ) {
        dsTaint.addTaint(m.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.175 -0400", hash_original_method = "4465F8842A1FA52D69E1334040E6F51E", hash_generated_method = "DBE03BF4DF1891DCEE9EA0198FFE23F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glMultMatrixx(
        int[] m,
        int offset
    ) {
        dsTaint.addTaint(m[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.175 -0400", hash_original_method = "DF5EC04F6F5FD65FC1A3F65FA14E17AE", hash_generated_method = "FA0B758CA0CE9E8E7EF71F5B3CAF193D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glMultMatrixx(
        java.nio.IntBuffer m
    ) {
        dsTaint.addTaint(m.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.175 -0400", hash_original_method = "11C7AE2F7FBF34FAA4EB3D3D62BF913A", hash_generated_method = "D8EE52607721A15C974E6E092405DB19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glMultiTexCoord4f(
        int target,
        float s,
        float t,
        float r,
        float q
    ) {
        dsTaint.addTaint(t);
        dsTaint.addTaint(s);
        dsTaint.addTaint(r);
        dsTaint.addTaint(q);
        dsTaint.addTaint(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.176 -0400", hash_original_method = "23E284E29F32FC21C7A0FCFA0D22DEB6", hash_generated_method = "27EB07A572C9FEF667D5210ABBE31788")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glMultiTexCoord4x(
        int target,
        int s,
        int t,
        int r,
        int q
    ) {
        dsTaint.addTaint(t);
        dsTaint.addTaint(s);
        dsTaint.addTaint(r);
        dsTaint.addTaint(q);
        dsTaint.addTaint(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.176 -0400", hash_original_method = "9DE586E6F695FF88688A307035F39CA5", hash_generated_method = "1859699353B2E4A3F106B86378B3B041")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glNormal3f(
        float nx,
        float ny,
        float nz
    ) {
        dsTaint.addTaint(nz);
        dsTaint.addTaint(ny);
        dsTaint.addTaint(nx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.176 -0400", hash_original_method = "20119369DE227042EDEFDBE3270C3DE9", hash_generated_method = "E2DF41C4565AFAE1EA79E58677D5C84D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glNormal3x(
        int nx,
        int ny,
        int nz
    ) {
        dsTaint.addTaint(nz);
        dsTaint.addTaint(ny);
        dsTaint.addTaint(nx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.176 -0400", hash_original_method = "1F3C9CA6DB76EF1CEC4FE9381E242024", hash_generated_method = "8120B3C08A189FA7CE1C80AC2400DE1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void glNormalPointerBounds(
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
        dsTaint.addTaint(remaining);
        dsTaint.addTaint(pointer.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.176 -0400", hash_original_method = "B0279F28E501DAEA74F3B8688C94AB46", hash_generated_method = "AEC782040D5B4D1135BA8EE4D88AEF4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glNormalPointer(
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        dsTaint.addTaint(pointer.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        glNormalPointerBounds(
            type,
            stride,
            pointer,
            pointer.remaining()
        );
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.177 -0400", hash_original_method = "FA472E5A7F4340721FB63D20C6C9872C", hash_generated_method = "10B70DED76E9AC78CA0AA8EE02810207")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glOrthof(
        float left,
        float right,
        float bottom,
        float top,
        float zNear,
        float zFar
    ) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(zFar);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(zNear);
        dsTaint.addTaint(top);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.177 -0400", hash_original_method = "779BA3AE3934F2C0E0D6CD9B22925617", hash_generated_method = "3694A35465ED825C2AA54FEE3CA50DB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glOrthox(
        int left,
        int right,
        int bottom,
        int top,
        int zNear,
        int zFar
    ) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(zFar);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(zNear);
        dsTaint.addTaint(top);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.177 -0400", hash_original_method = "9F46DCF7880A291F21EA87295ECFB64D", hash_generated_method = "A6D891671C7C3FA9AC62CCFFE6D53462")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glPixelStorei(
        int pname,
        int param
    ) {
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.177 -0400", hash_original_method = "70E088306D05927B07E2ED10F48C457E", hash_generated_method = "C1C18A2049DE2A759B2CBB02B6129FE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glPointSize(
        float size
    ) {
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.177 -0400", hash_original_method = "8990BB5170BD865165F8304AE65CA7D9", hash_generated_method = "68FADB0B966D191FE0A799284D410E08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glPointSizex(
        int size
    ) {
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.177 -0400", hash_original_method = "E1FC86F4B601EF0C69805BFC127ED812", hash_generated_method = "677152B9E89349FAF5D9367920A5AA75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glPolygonOffset(
        float factor,
        float units
    ) {
        dsTaint.addTaint(factor);
        dsTaint.addTaint(units);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.177 -0400", hash_original_method = "627C0C70B067DF76C0A65620B55C9D89", hash_generated_method = "2E16A2567595FD69972766E5BC297462")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glPolygonOffsetx(
        int factor,
        int units
    ) {
        dsTaint.addTaint(factor);
        dsTaint.addTaint(units);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.177 -0400", hash_original_method = "7B9DD6E697258B776092627B483BEC50", hash_generated_method = "369BFD187A09E72ED283C5E143F24E1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glPopMatrix(
    ) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.178 -0400", hash_original_method = "5E9492F1A35F4DB85CB36C12255394B9", hash_generated_method = "A836F02FFAF1F7FF17B740ED3F586CE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glPushMatrix(
    ) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.178 -0400", hash_original_method = "06F089EB522BB6494D3BBAD3A839D917", hash_generated_method = "41D3351C6D76A47CA98BC8987A409A48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glReadPixels(
        int x,
        int y,
        int width,
        int height,
        int format,
        int type,
        java.nio.Buffer pixels
    ) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(format);
        dsTaint.addTaint(pixels.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.178 -0400", hash_original_method = "1C954364937B2BCE355EFA4F5D15232D", hash_generated_method = "92DDCB258EE75FBBE924CE0B7DBD031F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glRotatef(
        float angle,
        float x,
        float y,
        float z
    ) {
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(angle);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.178 -0400", hash_original_method = "B1A5B8433BC4E0D5D8E9AD5FE1254788", hash_generated_method = "470822453A4E62462C49A0F358623CE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glRotatex(
        int angle,
        int x,
        int y,
        int z
    ) {
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(angle);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.178 -0400", hash_original_method = "AA4B2DFEFBE4905278A3F5AA24D3A995", hash_generated_method = "4F7F620EEBAC24BDE5643E0E849BCA84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glSampleCoverage(
        float value,
        boolean invert
    ) {
        dsTaint.addTaint(invert);
        dsTaint.addTaint(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.178 -0400", hash_original_method = "44B6D2540DFD3AA85A51F37AE0763C78", hash_generated_method = "D8DA0136704FF65B6F9A28182602DE8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glSampleCoveragex(
        int value,
        boolean invert
    ) {
        dsTaint.addTaint(invert);
        dsTaint.addTaint(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.178 -0400", hash_original_method = "EF219AA0948830AA415C1204BCBC2736", hash_generated_method = "1FEE026ED9ABBC55A0E7E63827A06B49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glScalef(
        float x,
        float y,
        float z
    ) {
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.179 -0400", hash_original_method = "84D2C12CD2738F500F416AFA5567D4F0", hash_generated_method = "B7FA9B276C73B16DDCEA682E262EC29C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glScalex(
        int x,
        int y,
        int z
    ) {
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.179 -0400", hash_original_method = "2706B1054613592AF5D1DF72ABC0CD83", hash_generated_method = "AAB4D2683AB87A5CFD5DBA07B364FDCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glScissor(
        int x,
        int y,
        int width,
        int height
    ) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.179 -0400", hash_original_method = "06D4AD727137B397BA1C790AE88392D9", hash_generated_method = "981BCAA37B810814B6A3AE79CB678F17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glShadeModel(
        int mode
    ) {
        dsTaint.addTaint(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.179 -0400", hash_original_method = "E1207A48D38BC4812B68A4C96B0D52F1", hash_generated_method = "866AFDF12F35CF81A424A621CD1AD3DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glStencilFunc(
        int func,
        int ref,
        int mask
    ) {
        dsTaint.addTaint(ref);
        dsTaint.addTaint(mask);
        dsTaint.addTaint(func);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.179 -0400", hash_original_method = "7094BBA3123BF4E1DB187F35149B8AFA", hash_generated_method = "970913DDC385204BF1B6FC64AD075CC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glStencilMask(
        int mask
    ) {
        dsTaint.addTaint(mask);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.179 -0400", hash_original_method = "B10D55F18627610DD2579793D42F3254", hash_generated_method = "6BB8ACA2B8E9D87A3723806921B74922")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glStencilOp(
        int fail,
        int zfail,
        int zpass
    ) {
        dsTaint.addTaint(fail);
        dsTaint.addTaint(zfail);
        dsTaint.addTaint(zpass);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.179 -0400", hash_original_method = "9D620040AA720FDD33F346FBC8BD5A6E", hash_generated_method = "A71E562ED329CC1FD375BB5C8E5C6530")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void glTexCoordPointerBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
        dsTaint.addTaint(remaining);
        dsTaint.addTaint(pointer.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.180 -0400", hash_original_method = "76ED75F6FDC0A5E37C32F775B196CB2D", hash_generated_method = "D2C8821EDBC083B46426BC26B75C6B6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexCoordPointer(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        dsTaint.addTaint(pointer.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(size);
        glTexCoordPointerBounds(
            size,
            type,
            stride,
            pointer,
            pointer.remaining()
        );
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.180 -0400", hash_original_method = "C92F17394C34CCF009999C2B03267478", hash_generated_method = "C0105E8CC086361743B9FAF3FF327DE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexEnvf(
        int target,
        int pname,
        float param
    ) {
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.180 -0400", hash_original_method = "17EB1D9A37B75139BEBB3A24236CA174", hash_generated_method = "86843AC5BCE54EB9188424C7579E1903")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexEnvfv(
        int target,
        int pname,
        float[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.180 -0400", hash_original_method = "7DAA860F4B0103CB3FBE5370186D423C", hash_generated_method = "33ADCCBC43F2DB56E8B03E94E7C36D76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexEnvfv(
        int target,
        int pname,
        java.nio.FloatBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.180 -0400", hash_original_method = "0B4A8E67F48DF299AEE127C1D6D6E842", hash_generated_method = "7A6F385AF58A05FF75EF17CF259B0160")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexEnvx(
        int target,
        int pname,
        int param
    ) {
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.180 -0400", hash_original_method = "3454AE1EA38B6015D5079DEC25C07356", hash_generated_method = "220E5CEE54F44C6AD69AF8327AE35452")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexEnvxv(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.180 -0400", hash_original_method = "A182AF661C6E3504BF48BA26E70CC975", hash_generated_method = "E47911937426521324DE9430D7F94D98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexEnvxv(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.180 -0400", hash_original_method = "1318832C2059A909174341F9487D764F", hash_generated_method = "E44422BD9DB18757202893DAFE04A779")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        dsTaint.addTaint(height);
        dsTaint.addTaint(level);
        dsTaint.addTaint(width);
        dsTaint.addTaint(target);
        dsTaint.addTaint(format);
        dsTaint.addTaint(pixels.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(border);
        dsTaint.addTaint(internalformat);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.181 -0400", hash_original_method = "F2C35EB1905189AC842F73F625C9049E", hash_generated_method = "64452AF35F0AF62F043657FFD15C648D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexParameterf(
        int target,
        int pname,
        float param
    ) {
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.181 -0400", hash_original_method = "679BAE0DF1765F687A0745B0BA3EC234", hash_generated_method = "2CEF6213C55032D4C8C87C105A9DDFE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexParameterx(
        int target,
        int pname,
        int param
    ) {
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.181 -0400", hash_original_method = "6621BB389C4964067C97C1E29DF058F0", hash_generated_method = "567652C14419F974639C79F920E648AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        dsTaint.addTaint(height);
        dsTaint.addTaint(level);
        dsTaint.addTaint(xoffset);
        dsTaint.addTaint(yoffset);
        dsTaint.addTaint(width);
        dsTaint.addTaint(target);
        dsTaint.addTaint(format);
        dsTaint.addTaint(pixels.dsTaint);
        dsTaint.addTaint(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.181 -0400", hash_original_method = "8D88726507AA19B9B9ECE00EF0AA6770", hash_generated_method = "7E5EA523684203743A378EAA722F9E76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTranslatef(
        float x,
        float y,
        float z
    ) {
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.181 -0400", hash_original_method = "156D8083E2F48E9E423D17537DC8B72A", hash_generated_method = "BD1CE78DBBC7FCD19C6C7A058B1F4B66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTranslatex(
        int x,
        int y,
        int z
    ) {
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.181 -0400", hash_original_method = "93D9D08DB02A2FA19D56A49842CFD50E", hash_generated_method = "9BA1CCB7E9747B1ED1191613738097D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void glVertexPointerBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
        dsTaint.addTaint(remaining);
        dsTaint.addTaint(pointer.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.182 -0400", hash_original_method = "EB50FBD03587D2E27B120FC4C1DFD2C5", hash_generated_method = "0C65D35AF699CF49A4FC73C97F77FD01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glVertexPointer(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        dsTaint.addTaint(pointer.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(size);
        glVertexPointerBounds(
            size,
            type,
            stride,
            pointer,
            pointer.remaining()
        );
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.182 -0400", hash_original_method = "4BB437B5524083B48EDAA779B8096AF4", hash_generated_method = "3A57AE2BA3301A3087337DE841EDDB2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glViewport(
        int x,
        int y,
        int width,
        int height
    ) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.182 -0400", hash_original_method = "9B92240362A0C24B54C7BFD4F1CE5714", hash_generated_method = "CAB07530EAE649191A860E0667735215")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int glQueryMatrixxOES(
        int[] mantissa,
        int mantissaOffset,
        int[] exponent,
        int exponentOffset
    ) {
        dsTaint.addTaint(exponent[0]);
        dsTaint.addTaint(mantissa[0]);
        dsTaint.addTaint(exponentOffset);
        dsTaint.addTaint(mantissaOffset);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.182 -0400", hash_original_method = "101C06E84233F4A43BD578F661A40864", hash_generated_method = "3213D846DB917B3BA2F137A4AA8562BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int glQueryMatrixxOES(
        java.nio.IntBuffer mantissa,
        java.nio.IntBuffer exponent
    ) {
        dsTaint.addTaint(exponent.dsTaint);
        dsTaint.addTaint(mantissa.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.182 -0400", hash_original_method = "8D2FB6E82772953815CBFED3E425025F", hash_generated_method = "7342CEC2D163F80DDF3F1FE8DCBC3CD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glBindBuffer(
        int target,
        int buffer
    ) {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.182 -0400", hash_original_method = "60652602159136F858DBF56A81FAD463", hash_generated_method = "53020A0E51B3F92C654BB2A1EC2E0E69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glBufferData(
        int target,
        int size,
        java.nio.Buffer data,
        int usage
    ) {
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(target);
        dsTaint.addTaint(usage);
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.182 -0400", hash_original_method = "8950BE5BF752428FF824E4C8DAF2F401", hash_generated_method = "4EB3C1EE95DDEC97E010949DAA435C2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glBufferSubData(
        int target,
        int offset,
        int size,
        java.nio.Buffer data
    ) {
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(target);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.183 -0400", hash_original_method = "155F1B281020C8D1BB6048C36DD6FADD", hash_generated_method = "EC2D276DA1C56B14EC2360920FD8B30B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glClipPlanef(
        int plane,
        float[] equation,
        int offset
    ) {
        dsTaint.addTaint(plane);
        dsTaint.addTaint(equation[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.183 -0400", hash_original_method = "BFAF1ADDEE7B010F7D84F768A9758F4D", hash_generated_method = "AB342DB404DF3E052A68878A24580E0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glClipPlanef(
        int plane,
        java.nio.FloatBuffer equation
    ) {
        dsTaint.addTaint(plane);
        dsTaint.addTaint(equation.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.183 -0400", hash_original_method = "0657B828FBDFCB33E6AEAE065879195B", hash_generated_method = "7B632E547150392FBD6BE7E837785431")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glClipPlanex(
        int plane,
        int[] equation,
        int offset
    ) {
        dsTaint.addTaint(plane);
        dsTaint.addTaint(equation[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.183 -0400", hash_original_method = "0DA6B6D2978A64F63583FC89A46DD2C9", hash_generated_method = "F5328FE696F91B1BBA4EC35539686BE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glClipPlanex(
        int plane,
        java.nio.IntBuffer equation
    ) {
        dsTaint.addTaint(plane);
        dsTaint.addTaint(equation.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.183 -0400", hash_original_method = "27D12F7262E17AFA65E5B69E9E658934", hash_generated_method = "514415383563FF1AE5854C4DA74A350C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glColor4ub(
        byte red,
        byte green,
        byte blue,
        byte alpha
    ) {
        dsTaint.addTaint(red);
        dsTaint.addTaint(blue);
        dsTaint.addTaint(green);
        dsTaint.addTaint(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.183 -0400", hash_original_method = "BFA7C744F4E209AD9E46A7063445C612", hash_generated_method = "D4D1C45F13C447E902D564BA483F6E39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glColorPointer(
        int size,
        int type,
        int stride,
        int offset
    ) {
        dsTaint.addTaint(offset);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.183 -0400", hash_original_method = "E5E400D8B0DD28099195D126630AE3F3", hash_generated_method = "E99AD45A9E10F6717654529E340A1C9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDeleteBuffers(
        int n,
        int[] buffers,
        int offset
    ) {
        dsTaint.addTaint(buffers[0]);
        dsTaint.addTaint(n);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.184 -0400", hash_original_method = "70C001894D0487E1FC16B5A8E3289001", hash_generated_method = "72A78F58FA023DAECA6004B56CE11D80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDeleteBuffers(
        int n,
        java.nio.IntBuffer buffers
    ) {
        dsTaint.addTaint(buffers.dsTaint);
        dsTaint.addTaint(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.184 -0400", hash_original_method = "435560D0BA5A8695B9DFA99E435C09EF", hash_generated_method = "D300BABEF974EBA5313765C41A3C1E13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDrawElements(
        int mode,
        int count,
        int type,
        int offset
    ) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(type);
        dsTaint.addTaint(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.184 -0400", hash_original_method = "FA01B6EEE9A8B6C56F123033DDBB027C", hash_generated_method = "FEF430BE9F8CDBF3CCD57CC16D093A06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGenBuffers(
        int n,
        int[] buffers,
        int offset
    ) {
        dsTaint.addTaint(buffers[0]);
        dsTaint.addTaint(n);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.184 -0400", hash_original_method = "A06F6445182A854FF9614FEACAA08BDA", hash_generated_method = "95F7F66D6773EA5FD088D3462974124B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGenBuffers(
        int n,
        java.nio.IntBuffer buffers
    ) {
        dsTaint.addTaint(buffers.dsTaint);
        dsTaint.addTaint(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.184 -0400", hash_original_method = "7095CBF55ACD4B9F2AA86E657F4CB2B3", hash_generated_method = "EB09BF865E03CF1DCFC6F79C311C316B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetBooleanv(
        int pname,
        boolean[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.184 -0400", hash_original_method = "6AE434FF80C80956E80241A5F3448A43", hash_generated_method = "3BEA573FC319D19F6BBB71CB835821CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetBooleanv(
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.184 -0400", hash_original_method = "FE5274567105EB2D10CBB5CF28493B10", hash_generated_method = "CBA11F893507A27CF7B5361241039EB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetBufferParameteriv(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.185 -0400", hash_original_method = "72ED25126A92670FCEBB1B4962677465", hash_generated_method = "D0483EECA3396FDCCAACD47D16D978B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetBufferParameteriv(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.185 -0400", hash_original_method = "B414E64778E376C130F5038CB527E31F", hash_generated_method = "AB7DC9520BC7E8DD893695E72F5F1FE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetClipPlanef(
        int pname,
        float[] eqn,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(eqn[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.185 -0400", hash_original_method = "1C111E4CC3829517C17B35EA499D5BFD", hash_generated_method = "F8B229F7251EEA1186219E7D1C32ECF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetClipPlanef(
        int pname,
        java.nio.FloatBuffer eqn
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(eqn.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.185 -0400", hash_original_method = "9782A147ABD9AFBBF1DDDCF344CA05F5", hash_generated_method = "C321F6C4DD68C4AB0E1634F10D921755")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetClipPlanex(
        int pname,
        int[] eqn,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(eqn[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.185 -0400", hash_original_method = "4DB3F0354D2E2FDC4D6C7551700566FD", hash_generated_method = "11D35430A89E35DA8F52DB9FE8F9B89B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetClipPlanex(
        int pname,
        java.nio.IntBuffer eqn
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(eqn.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.185 -0400", hash_original_method = "72D05611B5260CD5F4BD9FBDD7EF3356", hash_generated_method = "2930688BD754926F91A9C9B5265FBED8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetFixedv(
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.185 -0400", hash_original_method = "D5438CEA44EE048204E6C055FB0ADA7A", hash_generated_method = "A5D4B30644B531F023178312EC1B7996")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetFixedv(
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.186 -0400", hash_original_method = "D28AD4CA9FE8670565C188B18F0632DC", hash_generated_method = "E292237F2023A329CD2B2965174ACB41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetFloatv(
        int pname,
        float[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.186 -0400", hash_original_method = "3B5B54F3207F36DC8458C2C22ECF19A7", hash_generated_method = "17AB994372B8CCE31C113C1E1B1566E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetFloatv(
        int pname,
        java.nio.FloatBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.186 -0400", hash_original_method = "6E5CC7433F2D11EE58A323BDB9B2C031", hash_generated_method = "9769A9C932670DD21CC02F0968C58E73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetLightfv(
        int light,
        int pname,
        float[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(light);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.186 -0400", hash_original_method = "6D38AF1876F30D3A6786EFE90DF09285", hash_generated_method = "4150DED06A0DE3C8FAD879B3CF6071B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetLightfv(
        int light,
        int pname,
        java.nio.FloatBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(light);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.186 -0400", hash_original_method = "6258F81E6CD446483B153322692371F6", hash_generated_method = "706DD922767D4AC22745E9E05D1869D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetLightxv(
        int light,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(light);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.186 -0400", hash_original_method = "858C4450F94D83CD8A405C5DA4478E6B", hash_generated_method = "82C0566B78986B64AA8991E0473EDB57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetLightxv(
        int light,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(light);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.186 -0400", hash_original_method = "4AD4AE19FF3DE20072E7B36663EF7FF1", hash_generated_method = "B82607FE4835AD8FFF4FC8DAEEA00C84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetMaterialfv(
        int face,
        int pname,
        float[] params,
        int offset
    ) {
        dsTaint.addTaint(face);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.186 -0400", hash_original_method = "AAEA106163ADE72C9EC108D40BEC96F3", hash_generated_method = "86556CD44B8086994A70189F6D46E754")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetMaterialfv(
        int face,
        int pname,
        java.nio.FloatBuffer params
    ) {
        dsTaint.addTaint(face);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.187 -0400", hash_original_method = "DA45382300D64D4633231B25DC790ED5", hash_generated_method = "087C178E6F55A3EF684D4BB0AFDE48C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetMaterialxv(
        int face,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(face);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.187 -0400", hash_original_method = "77D07CA7E363A44E04443485884C5B13", hash_generated_method = "63DF3373B92346E1946E1EB8280BF1D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetMaterialxv(
        int face,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(face);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.187 -0400", hash_original_method = "BC56AF50A79D05EDBF323A443949E95D", hash_generated_method = "8C536BFF10C0EB92430026BC47E33ABD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetTexEnviv(
        int env,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(env);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.187 -0400", hash_original_method = "E065D6D8A539FB0D184E951B3A77BFAF", hash_generated_method = "1081F27F16D5B87968FF25B82CEFD39F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetTexEnviv(
        int env,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(env);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.187 -0400", hash_original_method = "EE2ECB11441E634C6CF011A0FBC9E456", hash_generated_method = "9FEE6887ECD254C816060E54763C2CB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetTexEnvxv(
        int env,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(env);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.187 -0400", hash_original_method = "4763956A6FE09C8FE7B17EE79BBD7E20", hash_generated_method = "7194B70BF937679D47031B700A91DFE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetTexEnvxv(
        int env,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(env);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.187 -0400", hash_original_method = "A8EA7C4CAD5F8207BAFF4D19B2B8A061", hash_generated_method = "5C1BA831B84ACEFD94185DDB51457249")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetTexParameterfv(
        int target,
        int pname,
        float[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.188 -0400", hash_original_method = "4367C68441A9AA98F01515FDC90FDB44", hash_generated_method = "D3A42A8C74C868D877AAE6D16765631C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetTexParameterfv(
        int target,
        int pname,
        java.nio.FloatBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.188 -0400", hash_original_method = "8602EDD51435EC27A0B8958E793FF372", hash_generated_method = "47460768C6BFAA33D1FDB921556FD24A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetTexParameteriv(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.188 -0400", hash_original_method = "71368889A06C9E1744E4E25318DA6058", hash_generated_method = "F59A9EBB01BB6EE202B4F4925900C1CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetTexParameteriv(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.188 -0400", hash_original_method = "1BA765DD7E0FB5AA6AD2EBB11DF8B607", hash_generated_method = "7076D44F9F5B18FF1DFBB0363016CDBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetTexParameterxv(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.188 -0400", hash_original_method = "374E464895B48D2BEAC554053928B2AF", hash_generated_method = "D3DEB1C728D4A4FC9C4131A640946E1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetTexParameterxv(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.188 -0400", hash_original_method = "5CBCE22A13679DB40202021E228060B4", hash_generated_method = "B1A740251D3CDACEDD3650411AE4FEC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean glIsBuffer(
        int buffer
    ) {
        dsTaint.addTaint(buffer);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.188 -0400", hash_original_method = "2B37B396792E11A373DC696386D55E16", hash_generated_method = "0954C292C7DA1EBF145A51C4945591BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean glIsEnabled(
        int cap
    ) {
        dsTaint.addTaint(cap);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.188 -0400", hash_original_method = "B0774EFDFDF7E34E3A748242DEA5FF75", hash_generated_method = "C942ACCE09D9A9327B3A0119B507DE00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean glIsTexture(
        int texture
    ) {
        dsTaint.addTaint(texture);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.189 -0400", hash_original_method = "59EE792672F5ACA51D14291B099DC2AE", hash_generated_method = "9F174A5840E5B4BA92E407CC6B1DE3D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glNormalPointer(
        int type,
        int stride,
        int offset
    ) {
        dsTaint.addTaint(offset);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.189 -0400", hash_original_method = "E63CD7975861B2CCB6AD8F16DA976646", hash_generated_method = "0851AED6C9287ED05408A12628C86C00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glPointParameterf(
        int pname,
        float param
    ) {
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.189 -0400", hash_original_method = "A11196C9C3232519E010B3D895E7B10B", hash_generated_method = "40F1259DACCA2DDBED26D93CD0E1C74E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glPointParameterfv(
        int pname,
        float[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.189 -0400", hash_original_method = "6E76F6C08D9C74E626F785B0CF4DDD86", hash_generated_method = "44B20866CDED1FF3EC6A89AD7C381FE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glPointParameterfv(
        int pname,
        java.nio.FloatBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.189 -0400", hash_original_method = "2BB54735F90AB9973C6E35C2068C71E7", hash_generated_method = "E2564AA19456528A738459FAD63749FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glPointParameterx(
        int pname,
        int param
    ) {
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.189 -0400", hash_original_method = "5934D4E26BE75521F9F4579D9C8DCFE4", hash_generated_method = "E3852F33B96EF1CE10374956F57F6AD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glPointParameterxv(
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.189 -0400", hash_original_method = "C6C705CE06675FCC62C044DF88D7C5DF", hash_generated_method = "5186FA76AF8A4ACE0840BF1C300CD7DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glPointParameterxv(
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.189 -0400", hash_original_method = "8C106C3CEF3BB7BF47C54FD961C1CA10", hash_generated_method = "076C72AC03D85514BC009F7F640847D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void glPointSizePointerOESBounds(
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
        dsTaint.addTaint(remaining);
        dsTaint.addTaint(pointer.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.190 -0400", hash_original_method = "EC0D07F3AF47DBC4190CF008FCA93E16", hash_generated_method = "8E5C41C49D34098932BCB9A6E3A820B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glPointSizePointerOES(
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        dsTaint.addTaint(pointer.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        glPointSizePointerOESBounds(
            type,
            stride,
            pointer,
            pointer.remaining()
        );
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.190 -0400", hash_original_method = "12CDED926CDCF7EA42742009896284D9", hash_generated_method = "5813E672BB4BC65A7D6A408967F4491F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexCoordPointer(
        int size,
        int type,
        int stride,
        int offset
    ) {
        dsTaint.addTaint(offset);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.190 -0400", hash_original_method = "D87BE224D969AEA6EA7B6B5DC106EE96", hash_generated_method = "C40394A759A77F3B0D6656AAA21B35F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexEnvi(
        int target,
        int pname,
        int param
    ) {
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.190 -0400", hash_original_method = "5D2B9210D6DE6236279DA021F5E63F79", hash_generated_method = "74405091FA707055D439158198FEAF49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexEnviv(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.190 -0400", hash_original_method = "5C6F79AEDC5DC4EAF22C5D32A1DF3A50", hash_generated_method = "EE6F884DE2BB61AA843D5714EAB0AD81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexEnviv(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.190 -0400", hash_original_method = "A0FA0DFE2CA71C45A154ED0DC216DF9E", hash_generated_method = "07AF85130DC57259A4A388C0EB904169")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexParameterfv(
        int target,
        int pname,
        float[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.190 -0400", hash_original_method = "6A0800686C986953231F118EFA89B68E", hash_generated_method = "784786AF94630226B4475EB0D0273005")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexParameterfv(
        int target,
        int pname,
        java.nio.FloatBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.191 -0400", hash_original_method = "1ACB3111112291A939213D1C616FDF01", hash_generated_method = "16F20E24060AF555CF0C5A25EF9EDAFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexParameteri(
        int target,
        int pname,
        int param
    ) {
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.191 -0400", hash_original_method = "B9123A3C5F31C764ACDC251B4B063084", hash_generated_method = "F8D7A6D2FEBEBD43515B7CB23C6A28B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexParameteriv(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.191 -0400", hash_original_method = "14BFADF901BE034B97F27EFDB7249EC5", hash_generated_method = "05D1881F06FAB5535A22FC5BE484508F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexParameteriv(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.191 -0400", hash_original_method = "3F6F8E0BA39C35229A89553DB35B9114", hash_generated_method = "C5262BC0A2E8A729F836BEB4BC5C210F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexParameterxv(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.191 -0400", hash_original_method = "04A367584151D9D9FD975F225EE885B4", hash_generated_method = "7CE581A04F53539FAD9C3BFD8E409166")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexParameterxv(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.191 -0400", hash_original_method = "7C26F1A50D75B77F9272FCB63EA624C6", hash_generated_method = "524C50750EE6F04D82B2008FAE237F15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glVertexPointer(
        int size,
        int type,
        int stride,
        int offset
    ) {
        dsTaint.addTaint(offset);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.191 -0400", hash_original_method = "95BA1F07B3AEB4D134CCBDFFE0DB7EE4", hash_generated_method = "DB7238A450342AF847EEF8BD372AFC80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glCurrentPaletteMatrixOES(
        int matrixpaletteindex
    ) {
        dsTaint.addTaint(matrixpaletteindex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.192 -0400", hash_original_method = "D2BE11A64665DB8B06B4DC96FEC208B6", hash_generated_method = "BC56D08B143403EFD5BEDEF257E55000")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDrawTexfOES(
        float x,
        float y,
        float z,
        float width,
        float height
    ) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.192 -0400", hash_original_method = "1910442FB838D19DD4C27DB699DB4D46", hash_generated_method = "D02D256E1DE3287CED78C4AD80366FD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDrawTexfvOES(
        float[] coords,
        int offset
    ) {
        dsTaint.addTaint(coords[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.192 -0400", hash_original_method = "831C162EE3D2DC1DF6F1AE6669ECD44A", hash_generated_method = "C977D1A1EE9728CFE3148D20600CE8E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDrawTexfvOES(
        java.nio.FloatBuffer coords
    ) {
        dsTaint.addTaint(coords.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.192 -0400", hash_original_method = "A28C833EC2B9C4EB45296643BE372A85", hash_generated_method = "92CBA5D2DE548FCC9E54E9C1BDCE0975")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDrawTexiOES(
        int x,
        int y,
        int z,
        int width,
        int height
    ) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.192 -0400", hash_original_method = "38C985EB15B5E699CFA5800CE9313B6C", hash_generated_method = "2D611F9B629FD5797566842053D17B3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDrawTexivOES(
        int[] coords,
        int offset
    ) {
        dsTaint.addTaint(coords[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.192 -0400", hash_original_method = "2E2E2E76797892659616F6D96EE421EA", hash_generated_method = "BD4FBBA3A7FD9CDDEC028138E192F370")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDrawTexivOES(
        java.nio.IntBuffer coords
    ) {
        dsTaint.addTaint(coords.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.192 -0400", hash_original_method = "8566A29D8D8B09C3A6BC518418932CDB", hash_generated_method = "9247CBA02A01A73E39A6567C9100FB78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDrawTexsOES(
        short x,
        short y,
        short z,
        short width,
        short height
    ) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.193 -0400", hash_original_method = "91E6CBADB398633A4383C31A0AD86296", hash_generated_method = "F5D6A31420387023150BEA3C51502327")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDrawTexsvOES(
        short[] coords,
        int offset
    ) {
        dsTaint.addTaint(coords[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.193 -0400", hash_original_method = "0954B7C7035D691303E55E25D6EFB672", hash_generated_method = "DE6ECA0F7882A542CCDD09BFD950F513")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDrawTexsvOES(
        java.nio.ShortBuffer coords
    ) {
        dsTaint.addTaint(coords.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.193 -0400", hash_original_method = "74CF88596F8DBCCE4A394CCE81E9FC91", hash_generated_method = "8373C7DDE261C2085B3C2324A88A4235")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDrawTexxOES(
        int x,
        int y,
        int z,
        int width,
        int height
    ) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.193 -0400", hash_original_method = "2F7A3F5025DF5EF064319814B3209A3C", hash_generated_method = "C6A74F315006ECF7A844A267D2658AAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDrawTexxvOES(
        int[] coords,
        int offset
    ) {
        dsTaint.addTaint(coords[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.193 -0400", hash_original_method = "51D917B4A8B9530FF8924BF2E6AF392B", hash_generated_method = "E3809A20305C037A67823B40B801A555")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDrawTexxvOES(
        java.nio.IntBuffer coords
    ) {
        dsTaint.addTaint(coords.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.193 -0400", hash_original_method = "0DEF4FDA31B693FD58B4F5466D1F6B2D", hash_generated_method = "9AE3D51ED1F5C97D2F81EBC963677EAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glLoadPaletteFromModelViewMatrixOES(
    ) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.193 -0400", hash_original_method = "6A7CA123A9CB88F0A99C0D9B4D2D33AF", hash_generated_method = "A07B1408810C6D6896F7937CD29B464E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void glMatrixIndexPointerOESBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
        dsTaint.addTaint(remaining);
        dsTaint.addTaint(pointer.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.194 -0400", hash_original_method = "A2DEF3847665EA2F7AE241D0B05BBB08", hash_generated_method = "269F981E0ACD33BEE7BFFF01457A3325")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glMatrixIndexPointerOES(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        dsTaint.addTaint(pointer.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(size);
        glMatrixIndexPointerOESBounds(
            size,
            type,
            stride,
            pointer,
            pointer.remaining()
        );
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.194 -0400", hash_original_method = "C6EEDA2F0CB848D1825DAA27E05C1F25", hash_generated_method = "0DBF92450B0A2D955E8DA23CC7A8057B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glMatrixIndexPointerOES(
        int size,
        int type,
        int stride,
        int offset
    ) {
        dsTaint.addTaint(offset);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.194 -0400", hash_original_method = "733A86C2F1705E763179D2C64FE1F559", hash_generated_method = "ACDF5612EF1F7F78B86409742D53B181")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void glWeightPointerOESBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
        dsTaint.addTaint(remaining);
        dsTaint.addTaint(pointer.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.194 -0400", hash_original_method = "DA1591FF7EA6F5F9EAE67C123814B637", hash_generated_method = "342F7A83732507738ED6952178B94ABA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glWeightPointerOES(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        dsTaint.addTaint(pointer.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(size);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.194 -0400", hash_original_method = "80F6563B1D95178FF3AFD1CF5B96CA9E", hash_generated_method = "69189442FEB0B3FC5A4EE6AA86CE6907")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glWeightPointerOES(
        int size,
        int type,
        int stride,
        int offset
    ) {
        dsTaint.addTaint(offset);
        dsTaint.addTaint(type);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.195 -0400", hash_original_method = "7012E0C28CAA85B7F547C387DC5490BF", hash_generated_method = "1B9E19E0A430BF9077DA112A45AFAB4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glBindFramebufferOES(
        int target,
        int framebuffer
    ) {
        dsTaint.addTaint(target);
        dsTaint.addTaint(framebuffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.195 -0400", hash_original_method = "E996F619A69BBB02AE5800FE72064177", hash_generated_method = "E4EC25FBA604144C3FEAA6D04EC39C4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glBindRenderbufferOES(
        int target,
        int renderbuffer
    ) {
        dsTaint.addTaint(renderbuffer);
        dsTaint.addTaint(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.195 -0400", hash_original_method = "96629AB18523F1B8BD5CC1F0B06C9A3A", hash_generated_method = "D17213918FC0921F71EE95D92278D2D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glBlendEquation(
        int mode
    ) {
        dsTaint.addTaint(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.195 -0400", hash_original_method = "D2522F56984AE422BAA6705290A5800D", hash_generated_method = "3595044AB36CB266D3946C239ECD0D4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glBlendEquationSeparate(
        int modeRGB,
        int modeAlpha
    ) {
        dsTaint.addTaint(modeAlpha);
        dsTaint.addTaint(modeRGB);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.195 -0400", hash_original_method = "BEC8094313FE35DDC834FD9794924A8C", hash_generated_method = "F7DA9AC55B9CF570B073DDC74250EC1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glBlendFuncSeparate(
        int srcRGB,
        int dstRGB,
        int srcAlpha,
        int dstAlpha
    ) {
        dsTaint.addTaint(dstRGB);
        dsTaint.addTaint(dstAlpha);
        dsTaint.addTaint(srcAlpha);
        dsTaint.addTaint(srcRGB);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.195 -0400", hash_original_method = "B1A4A768D52CA135614FAA74BF2A89E7", hash_generated_method = "88201DD6C170AFA38924D4B2848BBDBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int glCheckFramebufferStatusOES(
        int target
    ) {
        dsTaint.addTaint(target);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.195 -0400", hash_original_method = "224046A7647ABE7AB757051B3805C7F0", hash_generated_method = "9C0C99F56A1429CD826B07B039D20E01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDeleteFramebuffersOES(
        int n,
        int[] framebuffers,
        int offset
    ) {
        dsTaint.addTaint(framebuffers[0]);
        dsTaint.addTaint(n);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.195 -0400", hash_original_method = "0DFDB8F7E46ED0CE9E0FCF78465DA298", hash_generated_method = "797D9CD76A331D0B74681C250B57E3FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDeleteFramebuffersOES(
        int n,
        java.nio.IntBuffer framebuffers
    ) {
        dsTaint.addTaint(framebuffers.dsTaint);
        dsTaint.addTaint(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.196 -0400", hash_original_method = "1FFECA3ED850152A6CC369D1F14D97EB", hash_generated_method = "5864152B1C5B219900B973622E4CFF98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDeleteRenderbuffersOES(
        int n,
        int[] renderbuffers,
        int offset
    ) {
        dsTaint.addTaint(renderbuffers[0]);
        dsTaint.addTaint(n);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.196 -0400", hash_original_method = "46CFE024939DBAEA7FE408A9C7C03F41", hash_generated_method = "EC24A734D713FC95D3BC76E6C61A4746")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glDeleteRenderbuffersOES(
        int n,
        java.nio.IntBuffer renderbuffers
    ) {
        dsTaint.addTaint(renderbuffers.dsTaint);
        dsTaint.addTaint(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.196 -0400", hash_original_method = "DF7EC8EDF18B86227477D66A9E612D5C", hash_generated_method = "7F29433BCC2CE245468B75977FEBC841")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glFramebufferRenderbufferOES(
        int target,
        int attachment,
        int renderbuffertarget,
        int renderbuffer
    ) {
        dsTaint.addTaint(renderbuffertarget);
        dsTaint.addTaint(renderbuffer);
        dsTaint.addTaint(target);
        dsTaint.addTaint(attachment);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.196 -0400", hash_original_method = "E6578E5E33958E12104B156D133D18C1", hash_generated_method = "4F7BD7980192B947272C42DA1F70C1A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glFramebufferTexture2DOES(
        int target,
        int attachment,
        int textarget,
        int texture,
        int level
    ) {
        dsTaint.addTaint(level);
        dsTaint.addTaint(texture);
        dsTaint.addTaint(target);
        dsTaint.addTaint(textarget);
        dsTaint.addTaint(attachment);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.196 -0400", hash_original_method = "CF3BBC0690535D9ACEDA510E7C25FE93", hash_generated_method = "3A4E9ABD1BCCBE887A64D64A128D53B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGenerateMipmapOES(
        int target
    ) {
        dsTaint.addTaint(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.196 -0400", hash_original_method = "5CF430CF82275396EA94D85409CBB33E", hash_generated_method = "D95D65183CCB3E47D625F407153A1AE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGenFramebuffersOES(
        int n,
        int[] framebuffers,
        int offset
    ) {
        dsTaint.addTaint(framebuffers[0]);
        dsTaint.addTaint(n);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.196 -0400", hash_original_method = "4BB7994AB48E0E49BC5DEE99DDBE64C7", hash_generated_method = "C98CEA58010111C69B5B503E16DC5CCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGenFramebuffersOES(
        int n,
        java.nio.IntBuffer framebuffers
    ) {
        dsTaint.addTaint(framebuffers.dsTaint);
        dsTaint.addTaint(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.197 -0400", hash_original_method = "C06623E355A0F7E782F31327854908F9", hash_generated_method = "463AAF374916CFDA298E6554FA6D3D37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGenRenderbuffersOES(
        int n,
        int[] renderbuffers,
        int offset
    ) {
        dsTaint.addTaint(renderbuffers[0]);
        dsTaint.addTaint(n);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.197 -0400", hash_original_method = "7033C2CDCB61F1BA8BB94D8B8850FD60", hash_generated_method = "E6BB0A9B880A7B5786888F6BB2D4EFAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGenRenderbuffersOES(
        int n,
        java.nio.IntBuffer renderbuffers
    ) {
        dsTaint.addTaint(renderbuffers.dsTaint);
        dsTaint.addTaint(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.197 -0400", hash_original_method = "F29F63990C9EBFB77B2A5E7A020E447B", hash_generated_method = "AD7506EC5383D64DFFFE9780E8318FBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetFramebufferAttachmentParameterivOES(
        int target,
        int attachment,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(attachment);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.197 -0400", hash_original_method = "80E3B7662123EAE7B5048632F9E3C14B", hash_generated_method = "DFB1D4DE239B92A5FD3E66606CE80C66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetFramebufferAttachmentParameterivOES(
        int target,
        int attachment,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(attachment);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.197 -0400", hash_original_method = "6361A7359BD6B257B9C730DAA1639DC0", hash_generated_method = "C84ADB6323458EFC8A97048E8FE1F353")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetRenderbufferParameterivOES(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.197 -0400", hash_original_method = "D4443F3E98C9A915B5F88EF6379DF720", hash_generated_method = "33500B35F7E3662E8D96F9355DEB078B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetRenderbufferParameterivOES(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(pname);
        dsTaint.addTaint(target);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.197 -0400", hash_original_method = "CCB2C58BFB01275BCB44948E86C23A6F", hash_generated_method = "075FA35DE8433E9F694C2D2664D3D4B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetTexGenfv(
        int coord,
        int pname,
        float[] params,
        int offset
    ) {
        dsTaint.addTaint(coord);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.198 -0400", hash_original_method = "BA57774F60DC2980B7FF38B0A2E8016F", hash_generated_method = "7456A095EBA6728BCCD6A2C52DB13350")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetTexGenfv(
        int coord,
        int pname,
        java.nio.FloatBuffer params
    ) {
        dsTaint.addTaint(coord);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.198 -0400", hash_original_method = "D83AC0B94E45154E9C39405960588DD9", hash_generated_method = "072817CFAC8C0B5443A7EC2B68F322EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetTexGeniv(
        int coord,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(coord);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.198 -0400", hash_original_method = "EF430454571D4D94946D5978BDE708A5", hash_generated_method = "5E8A91D2C8F3ADDFF0355D6C367D4806")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetTexGeniv(
        int coord,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(coord);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.198 -0400", hash_original_method = "1448662FEB07A59CFBC07726254162A7", hash_generated_method = "5F36E953414C640BA1DEDBE7D81016AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetTexGenxv(
        int coord,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(coord);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.198 -0400", hash_original_method = "AA312740D7D8B86852FA57EC0F935C49", hash_generated_method = "3C8E195BBB27CEF1CE369645B569ABF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glGetTexGenxv(
        int coord,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(coord);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.198 -0400", hash_original_method = "0A5D6A2632DB9C567FFD91F0ACA40965", hash_generated_method = "9C2AA9CB2E1D44568F8909A829150119")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean glIsFramebufferOES(
        int framebuffer
    ) {
        dsTaint.addTaint(framebuffer);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.198 -0400", hash_original_method = "B2AFE473D5090C2AFBF0DD5218613E24", hash_generated_method = "B41D631BEB5B11D576A636467D3D3E92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean glIsRenderbufferOES(
        int renderbuffer
    ) {
        dsTaint.addTaint(renderbuffer);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.198 -0400", hash_original_method = "4BF2A91D21E16F3AE981CF68C4DFDE38", hash_generated_method = "9C640CC1A344509010CA2F7C94DD3DB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glRenderbufferStorageOES(
        int target,
        int internalformat,
        int width,
        int height
    ) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(target);
        dsTaint.addTaint(internalformat);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.199 -0400", hash_original_method = "DF1DDF095262CB65042B8B6E4ACB5D83", hash_generated_method = "660D90C1CF8375C7DB5329D75372A5E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexGenf(
        int coord,
        int pname,
        float param
    ) {
        dsTaint.addTaint(coord);
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.199 -0400", hash_original_method = "021935B8D9D6C7B463624EBDA4B11EB4", hash_generated_method = "B40635FBC116659C651095F9AC914C30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexGenfv(
        int coord,
        int pname,
        float[] params,
        int offset
    ) {
        dsTaint.addTaint(coord);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.199 -0400", hash_original_method = "D8B15F6B92AF3D4541AFD7FC1F3284DA", hash_generated_method = "744A27CE2C7E1CAB65C1B625FEEB39A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexGenfv(
        int coord,
        int pname,
        java.nio.FloatBuffer params
    ) {
        dsTaint.addTaint(coord);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.199 -0400", hash_original_method = "53C8322668092422760AEEABF3A0A50D", hash_generated_method = "9682202C53DFC78D59B57B94E553338A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexGeni(
        int coord,
        int pname,
        int param
    ) {
        dsTaint.addTaint(coord);
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.199 -0400", hash_original_method = "B98ED31CB4FEB2295803ED2F666679A9", hash_generated_method = "24BC2829D22589E4F897FC49DB80F62D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexGeniv(
        int coord,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(coord);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.199 -0400", hash_original_method = "E7AA7F75A0A7E8AB84868E171B6AFAE8", hash_generated_method = "8826192B373AF2AE69982F26B6F7DBA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexGeniv(
        int coord,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(coord);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.199 -0400", hash_original_method = "231B06A212F7462B4A9045C185C5C0A0", hash_generated_method = "D0B8B19945CFFBB2218A9733D560B3D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexGenx(
        int coord,
        int pname,
        int param
    ) {
        dsTaint.addTaint(coord);
        dsTaint.addTaint(param);
        dsTaint.addTaint(pname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.200 -0400", hash_original_method = "1AD9E3A06A99E29BF5DD361F01CD823D", hash_generated_method = "0FF0ACB5330E4998B31C8F7D3F9198AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexGenxv(
        int coord,
        int pname,
        int[] params,
        int offset
    ) {
        dsTaint.addTaint(coord);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.200 -0400", hash_original_method = "33A72688981BB5774C2892D6B098DC19", hash_generated_method = "3CDA09CC4A9CBF35E3EEBE0713F92BA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void glTexGenxv(
        int coord,
        int pname,
        java.nio.IntBuffer params
    ) {
        dsTaint.addTaint(coord);
        dsTaint.addTaint(pname);
        dsTaint.addTaint(params.dsTaint);
    }

    
    static {
	_nativeClassInit();
    }
    
}

