package javax.microedition.khronos.opengles;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface GL11ExtensionPack extends GL {
    int GL_BLEND_DST_ALPHA                                  = 0x80CA;
    int GL_BLEND_DST_RGB                                    = 0x80C8;
    int GL_BLEND_EQUATION                                   = 0x8009;
    int GL_BLEND_EQUATION_ALPHA                             = 0x883D;
    int GL_BLEND_EQUATION_RGB                               = 0x8009;
    int GL_BLEND_SRC_ALPHA                                  = 0x80CB;
    int GL_BLEND_SRC_RGB                                    = 0x80C9;
    int GL_COLOR_ATTACHMENT0_OES                            = 0x8CE0;
    int GL_COLOR_ATTACHMENT1_OES                            = 0x8CE1;
    int GL_COLOR_ATTACHMENT2_OES                            = 0x8CE2;
    int GL_COLOR_ATTACHMENT3_OES                            = 0x8CE3;
    int GL_COLOR_ATTACHMENT4_OES                            = 0x8CE4;
    int GL_COLOR_ATTACHMENT5_OES                            = 0x8CE5;
    int GL_COLOR_ATTACHMENT6_OES                            = 0x8CE6;
    int GL_COLOR_ATTACHMENT7_OES                            = 0x8CE7;
    int GL_COLOR_ATTACHMENT8_OES                            = 0x8CE8;
    int GL_COLOR_ATTACHMENT9_OES                            = 0x8CE9;
    int GL_COLOR_ATTACHMENT10_OES                           = 0x8CEA;
    int GL_COLOR_ATTACHMENT11_OES                           = 0x8CEB;
    int GL_COLOR_ATTACHMENT12_OES                           = 0x8CEC;
    int GL_COLOR_ATTACHMENT13_OES                           = 0x8CED;
    int GL_COLOR_ATTACHMENT14_OES                           = 0x8CEE;
    int GL_COLOR_ATTACHMENT15_OES                           = 0x8CEF;
    int GL_DECR_WRAP                                        = 0x8508;
    int GL_DEPTH_ATTACHMENT_OES                             = 0x8D00;
    int GL_DEPTH_COMPONENT                                  = 0x1902;
    int GL_DEPTH_COMPONENT16                                = 0x81A5;
    int GL_DEPTH_COMPONENT24                                = 0x81A6;
    int GL_DEPTH_COMPONENT32                                = 0x81A7;
    int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME_OES           = 0x8CD1;
    int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE_OES           = 0x8CD0;
    int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE_OES = 0x8CD3;
    int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL_OES         = 0x8CD2;
    int GL_FRAMEBUFFER_BINDING_OES                          = 0x8CA6;
    int GL_FRAMEBUFFER_COMPLETE_OES                         = 0x8CD5;
    int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_OES            = 0x8CD6;
    int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_OES            = 0x8CD9;
    int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_OES           = 0x8CDB;
    int GL_FRAMEBUFFER_INCOMPLETE_FORMATS_OES               = 0x8CDA;
    int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_OES    = 0x8CD7;
    int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER_OES           = 0x8CDC;
    int GL_FRAMEBUFFER_OES                                  = 0x8D40;
    int GL_FRAMEBUFFER_UNSUPPORTED_OES                      = 0x8CDD;
    int GL_FUNC_ADD                                         = 0x8006;
    int GL_FUNC_REVERSE_SUBTRACT                            = 0x800B;
    int GL_FUNC_SUBTRACT                                    = 0x800A;
    int GL_INCR_WRAP                                        = 0x8507;
    int GL_INVALID_FRAMEBUFFER_OPERATION_OES                = 0x0506;
    int GL_MAX_COLOR_ATTACHMENTS_OES                        = 0x8CDF;
    int GL_MAX_CUBE_MAP_TEXTURE_SIZE                        = 0x851C;
    int GL_MAX_RENDERBUFFER_SIZE_OES                        = 0x84E8;
    int GL_MIRRORED_REPEAT                                  = 0x8370;
    int GL_NORMAL_MAP                                       = 0x8511;
    int GL_REFLECTION_MAP                                   = 0x8512;
    int GL_RENDERBUFFER_ALPHA_SIZE_OES                      = 0x8D53;
    int GL_RENDERBUFFER_BINDING_OES                         = 0x8CA7;
    int GL_RENDERBUFFER_BLUE_SIZE_OES                       = 0x8D52;
    int GL_RENDERBUFFER_DEPTH_SIZE_OES                      = 0x8D54;
    int GL_RENDERBUFFER_GREEN_SIZE_OES                      = 0x8D51;
    int GL_RENDERBUFFER_HEIGHT_OES                          = 0x8D43;
    int GL_RENDERBUFFER_INTERNAL_FORMAT_OES                 = 0x8D44;
    int GL_RENDERBUFFER_OES                                 = 0x8D41;
    int GL_RENDERBUFFER_RED_SIZE_OES                        = 0x8D50;
    int GL_RENDERBUFFER_STENCIL_SIZE_OES                    = 0x8D55;
    int GL_RENDERBUFFER_WIDTH_OES                           = 0x8D42;
    int GL_RGB5_A1                                          = 0x8057;
    int GL_RGB565_OES                                       = 0x8D62;
    int GL_RGB8                                             = 0x8051;
    int GL_RGBA4                                            = 0x8056;
    int GL_RGBA8                                            = 0x8058;
    int GL_STENCIL_ATTACHMENT_OES                           = 0x8D20;
    int GL_STENCIL_INDEX                                    = 0x1901;
    int GL_STENCIL_INDEX1_OES                               = 0x8D46;
    int GL_STENCIL_INDEX4_OES                               = 0x8D47;
    int GL_STENCIL_INDEX8_OES                               = 0x8D48;
    int GL_STR                                              = -1;
    int GL_TEXTURE_BINDING_CUBE_MAP                         = 0x8514;
    int GL_TEXTURE_CUBE_MAP                                 = 0x8513;
    int GL_TEXTURE_CUBE_MAP_NEGATIVE_X                      = 0x8516;
    int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y                      = 0x8518;
    int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z                      = 0x851A;
    int GL_TEXTURE_CUBE_MAP_POSITIVE_X                      = 0x8515;
    int GL_TEXTURE_CUBE_MAP_POSITIVE_Y                      = 0x8517;
    int GL_TEXTURE_CUBE_MAP_POSITIVE_Z                      = 0x8519;
    int GL_TEXTURE_GEN_MODE                                 = 0x2500;
    int GL_TEXTURE_GEN_STR                                  = 0x8D60;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glBindFramebufferOES(
        int target,
        int framebuffer
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glBindRenderbufferOES(
        int target,
        int renderbuffer
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glBindTexture(
        int target,
        int texture
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glBlendEquation(
        int mode
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glBlendEquationSeparate(
        int modeRGB,
        int modeAlpha
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glBlendFuncSeparate(
        int srcRGB,
        int dstRGB,
        int srcAlpha,
        int dstAlpha
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int glCheckFramebufferStatusOES(
        int target
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glCompressedTexImage2D(
        int target,
        int level,
        int internalformat,
        int width,
        int height,
        int border,
        int imageSize,
        java.nio.Buffer data
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glCopyTexImage2D(
        int target,
        int level,
        int internalformat,
        int x,
        int y,
        int width,
        int height,
        int border
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glDeleteFramebuffersOES(
        int n,
        int[] framebuffers,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glDeleteFramebuffersOES(
        int n,
        java.nio.IntBuffer framebuffers
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glDeleteRenderbuffersOES(
        int n,
        int[] renderbuffers,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glDeleteRenderbuffersOES(
        int n,
        java.nio.IntBuffer renderbuffers
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glEnable(
        int cap
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glFramebufferRenderbufferOES(
        int target,
        int attachment,
        int renderbuffertarget,
        int renderbuffer
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glFramebufferTexture2DOES(
        int target,
        int attachment,
        int textarget,
        int texture,
        int level
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGenerateMipmapOES(
        int target
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGenFramebuffersOES(
        int n,
        int[] framebuffers,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGenFramebuffersOES(
        int n,
        java.nio.IntBuffer framebuffers
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGenRenderbuffersOES(
        int n,
        int[] renderbuffers,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGenRenderbuffersOES(
        int n,
        java.nio.IntBuffer renderbuffers
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGetFramebufferAttachmentParameterivOES(
        int target,
        int attachment,
        int pname,
        int[] params,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGetFramebufferAttachmentParameterivOES(
        int target,
        int attachment,
        int pname,
        java.nio.IntBuffer params
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGetIntegerv(
        int pname,
        int[] params,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGetIntegerv(
        int pname,
        java.nio.IntBuffer params
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGetRenderbufferParameterivOES(
        int target,
        int pname,
        int[] params,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGetRenderbufferParameterivOES(
        int target,
        int pname,
        java.nio.IntBuffer params
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGetTexGenfv(
        int coord,
        int pname,
        float[] params,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGetTexGenfv(
        int coord,
        int pname,
        java.nio.FloatBuffer params
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGetTexGeniv(
        int coord,
        int pname,
        int[] params,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGetTexGeniv(
        int coord,
        int pname,
        java.nio.IntBuffer params
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGetTexGenxv(
        int coord,
        int pname,
        int[] params,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glGetTexGenxv(
        int coord,
        int pname,
        java.nio.IntBuffer params
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean glIsFramebufferOES(
        int framebuffer
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean glIsRenderbufferOES(
        int renderbuffer
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glRenderbufferStorageOES(
        int target,
        int internalformat,
        int width,
        int height
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glStencilOp(
        int fail,
        int zfail,
        int zpass
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexEnvf(
        int target,
        int pname,
        float param
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexEnvfv(
        int target,
        int pname,
        float[] params,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexEnvfv(
        int target,
        int pname,
        java.nio.FloatBuffer params
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexEnvx(
        int target,
        int pname,
        int param
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexEnvxv(
        int target,
        int pname,
        int[] params,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexEnvxv(
        int target,
        int pname,
        java.nio.IntBuffer params
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexGenf(
        int coord,
        int pname,
        float param
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexGenfv(
        int coord,
        int pname,
        float[] params,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexGenfv(
        int coord,
        int pname,
        java.nio.FloatBuffer params
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexGeni(
        int coord,
        int pname,
        int param
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexGeniv(
        int coord,
        int pname,
        int[] params,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexGeniv(
        int coord,
        int pname,
        java.nio.IntBuffer params
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexGenx(
        int coord,
        int pname,
        int param
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexGenxv(
        int coord,
        int pname,
        int[] params,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexGenxv(
        int coord,
        int pname,
        java.nio.IntBuffer params
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexParameterf(
        int target,
        int pname,
        float param
    );

}
