package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
public class ProgramStore extends BaseObj {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.255 -0400", hash_original_field = "4382140BCA1D636874DA96F2CB741946", hash_generated_field = "8FAB28482622024207604FC8F68FBA68")

    DepthFunc mDepthFunc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.258 -0400", hash_original_field = "EF5ADB93D9C2E2FD3222AED39318B510", hash_generated_field = "FC6FA044D5DC3801C8E4182A42864AF5")

    boolean mDepthMask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.259 -0400", hash_original_field = "6AE2BD0E8D1E8F52233ED950ECBF1A46", hash_generated_field = "960D09803A4683C4A2879BE8D1C9DE36")

    boolean mColorMaskR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.261 -0400", hash_original_field = "1650D5163E2ABCA652BCEE80BBAC713B", hash_generated_field = "D753E63388AFCEB1C1E8ED1C2E5A5CDD")

    boolean mColorMaskG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.262 -0400", hash_original_field = "6D76CAFA24DBFE2336BB003111671A39", hash_generated_field = "4F2C8807D2265836A23A4C5CE2D26F83")

    boolean mColorMaskB;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.268 -0400", hash_original_field = "2E33ED01C925634252F73809AD0F3FDB", hash_generated_field = "5CAA513127E3F20913DEBEEE391AC5C2")

    boolean mColorMaskA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.270 -0400", hash_original_field = "9CBC5DE30EA9C740ABAE481AF449EE5A", hash_generated_field = "B1BBF7FAB925501900F9837599439C47")

    BlendSrcFunc mBlendSrc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.271 -0400", hash_original_field = "43F051D12E29844B745A6A0C9561CD6B", hash_generated_field = "72512BE02D1B3C4D84AB5B81AC84E45D")

    BlendDstFunc mBlendDst;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.272 -0400", hash_original_field = "39F3EFC8FE0445AB43D96028DA65CB34", hash_generated_field = "28ABDDC6F40109F392846C3ED0C6A12A")

    boolean mDither;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.278 -0400", hash_original_method = "10AC3BE9B8E79A8C066B5A14E3CCD64D", hash_generated_method = "C36EAEBEFF5B17E6B939EB646E785876")
      ProgramStore(int id, RenderScript rs) {
        super(id, rs);
        addTaint(rs.getTaint());
        addTaint(id);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.283 -0400", hash_original_method = "E178526BAD510BEC5A50D318A1F97DC1", hash_generated_method = "63A0C7DA01E6F1C28EA78D824FC3D005")
    public DepthFunc getDepthFunc() {
DepthFunc var69F8AE82356B914D7D19BB87C2E35D80_1885429142 =         mDepthFunc;
        var69F8AE82356B914D7D19BB87C2E35D80_1885429142.addTaint(taint);
        return var69F8AE82356B914D7D19BB87C2E35D80_1885429142;
        // ---------- Original Method ----------
        //return mDepthFunc;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.291 -0400", hash_original_method = "1F891625D44773A65FB94F9D60624E8A", hash_generated_method = "06090192FC5DA03D1FC09AC7A902D049")
    public boolean getDepthMaskEnabled() {
        boolean varEF5ADB93D9C2E2FD3222AED39318B510_255980358 = (mDepthMask);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1187665806 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1187665806;
        // ---------- Original Method ----------
        //return mDepthMask;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.295 -0400", hash_original_method = "D81DE2799023369A5B0CF1E2BC6BC18C", hash_generated_method = "A3D0E76C227F3CF0B8955D9697D197DA")
    public boolean getColorMaskREnabled() {
        boolean var6AE2BD0E8D1E8F52233ED950ECBF1A46_751684805 = (mColorMaskR);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_534763600 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_534763600;
        // ---------- Original Method ----------
        //return mColorMaskR;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.301 -0400", hash_original_method = "593F65FDE62B7209CAD6D4F19808F91A", hash_generated_method = "E2F01B274F135C6DC0EE8883C844B448")
    public boolean getColorMaskGEnabled() {
        boolean var1650D5163E2ABCA652BCEE80BBAC713B_145979337 = (mColorMaskG);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1405387329 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1405387329;
        // ---------- Original Method ----------
        //return mColorMaskG;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.307 -0400", hash_original_method = "03C0B53F0CD817F381C212AA9DF64896", hash_generated_method = "82E27DBB36534453FEF42B470E05F805")
    public boolean getColorMaskBEnabled() {
        boolean var6D76CAFA24DBFE2336BB003111671A39_1543212432 = (mColorMaskB);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1720319716 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1720319716;
        // ---------- Original Method ----------
        //return mColorMaskB;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.312 -0400", hash_original_method = "9A2193599E83E8BA9884E0A2E8A26218", hash_generated_method = "1EE5ACF879F018ACAD02262FACB43462")
    public boolean getColorMaskAEnabled() {
        boolean var2E33ED01C925634252F73809AD0F3FDB_1422584771 = (mColorMaskA);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1102058016 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1102058016;
        // ---------- Original Method ----------
        //return mColorMaskA;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.317 -0400", hash_original_method = "357FBEAFF960E5DE9B63C0DF2F2569E1", hash_generated_method = "1291CA8E0401BA82DC685C1D488DAEA3")
    public BlendSrcFunc getBlendSrcFunc() {
BlendSrcFunc varCE49FF3DFFBCFFA1668C497A73B2FCD9_1652639707 =         mBlendSrc;
        varCE49FF3DFFBCFFA1668C497A73B2FCD9_1652639707.addTaint(taint);
        return varCE49FF3DFFBCFFA1668C497A73B2FCD9_1652639707;
        // ---------- Original Method ----------
        //return mBlendSrc;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.321 -0400", hash_original_method = "0FD248B13178F7E7D7FDD24B8B83E163", hash_generated_method = "38C7E3D4A16EDF91C6B523D8E5B54AA7")
    public BlendDstFunc getBlendDstFunc() {
BlendDstFunc varBA9FBDF309FE837973BF7CABB9122658_189020843 =         mBlendDst;
        varBA9FBDF309FE837973BF7CABB9122658_189020843.addTaint(taint);
        return varBA9FBDF309FE837973BF7CABB9122658_189020843;
        // ---------- Original Method ----------
        //return mBlendDst;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.326 -0400", hash_original_method = "B3B90DE9FCB53C4AF17446CF7F19CDA0", hash_generated_method = "3427C794FBC6E30440C807169FFDE881")
    public boolean getDitherEnabled() {
        boolean var39F3EFC8FE0445AB43D96028DA65CB34_1574820933 = (mDither);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1779338201 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1779338201;
        // ---------- Original Method ----------
        //return mDither;
    }

    
        @DSModeled(DSC.SAFE)
    public static ProgramStore BLEND_NONE_DEPTH_TEST(RenderScript rs) {
        if(rs.mProgramStore_BLEND_NONE_DEPTH_TEST == null) {
            ProgramStore.Builder builder = new ProgramStore.Builder(rs);
            builder.setDepthFunc(ProgramStore.DepthFunc.LESS);
            builder.setBlendFunc(BlendSrcFunc.ONE, BlendDstFunc.ZERO);
            builder.setDitherEnabled(false);
            builder.setDepthMaskEnabled(true);
            rs.mProgramStore_BLEND_NONE_DEPTH_TEST = builder.create();
        }
        return rs.mProgramStore_BLEND_NONE_DEPTH_TEST;
    }

    
        @DSModeled(DSC.SAFE)
    public static ProgramStore BLEND_NONE_DEPTH_NONE(RenderScript rs) {
        if(rs.mProgramStore_BLEND_NONE_DEPTH_NO_DEPTH == null) {
            ProgramStore.Builder builder = new ProgramStore.Builder(rs);
            builder.setDepthFunc(ProgramStore.DepthFunc.ALWAYS);
            builder.setBlendFunc(BlendSrcFunc.ONE, BlendDstFunc.ZERO);
            builder.setDitherEnabled(false);
            builder.setDepthMaskEnabled(false);
            rs.mProgramStore_BLEND_NONE_DEPTH_NO_DEPTH = builder.create();
        }
        return rs.mProgramStore_BLEND_NONE_DEPTH_NO_DEPTH;
    }

    
        @DSModeled(DSC.SAFE)
    public static ProgramStore BLEND_ALPHA_DEPTH_TEST(RenderScript rs) {
        if(rs.mProgramStore_BLEND_ALPHA_DEPTH_TEST == null) {
            ProgramStore.Builder builder = new ProgramStore.Builder(rs);
            builder.setDepthFunc(ProgramStore.DepthFunc.LESS);
            builder.setBlendFunc(BlendSrcFunc.SRC_ALPHA, BlendDstFunc.ONE_MINUS_SRC_ALPHA);
            builder.setDitherEnabled(false);
            builder.setDepthMaskEnabled(true);
            rs.mProgramStore_BLEND_ALPHA_DEPTH_TEST = builder.create();
        }
        return rs.mProgramStore_BLEND_ALPHA_DEPTH_TEST;
    }

    
        public static ProgramStore BLEND_ALPHA_DEPTH_NONE(RenderScript rs) {
        if(rs.mProgramStore_BLEND_ALPHA_DEPTH_NO_DEPTH == null) {
            ProgramStore.Builder builder = new ProgramStore.Builder(rs);
            builder.setDepthFunc(ProgramStore.DepthFunc.ALWAYS);
            builder.setBlendFunc(BlendSrcFunc.SRC_ALPHA, BlendDstFunc.ONE_MINUS_SRC_ALPHA);
            builder.setDitherEnabled(false);
            builder.setDepthMaskEnabled(false);
            rs.mProgramStore_BLEND_ALPHA_DEPTH_NO_DEPTH = builder.create();
        }
        return rs.mProgramStore_BLEND_ALPHA_DEPTH_NO_DEPTH;
    }

    
    public enum DepthFunc {
        ALWAYS (0),
        LESS (1),
        LESS_OR_EQUAL (2),
        GREATER (3),
        GREATER_OR_EQUAL (4),
        EQUAL (5),
        NOT_EQUAL (6);
        int mID;
        @DSModeled(DSC.BAN)
        DepthFunc(int id) {
            mID = id;
        }
    }

    
    public enum BlendSrcFunc {
        ZERO (0),
        ONE (1),
        DST_COLOR (2),
        ONE_MINUS_DST_COLOR (3),
        SRC_ALPHA (4),
        ONE_MINUS_SRC_ALPHA (5),
        DST_ALPHA (6),
        ONE_MINUS_DST_ALPHA (7),
        SRC_ALPHA_SATURATE (8);
        int mID;
        @DSModeled(DSC.BAN)
        BlendSrcFunc(int id) {
            mID = id;
        }
    }

    
    public enum BlendDstFunc {
        ZERO (0),
        ONE (1),
        SRC_COLOR (2),
        ONE_MINUS_SRC_COLOR (3),
        SRC_ALPHA (4),
        ONE_MINUS_SRC_ALPHA (5),
        DST_ALPHA (6),
        ONE_MINUS_DST_ALPHA (7);
        int mID;
        @DSModeled(DSC.BAN)
        BlendDstFunc(int id) {
            mID = id;
        }
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.346 -0400", hash_original_field = "15EADDEB24354180E81F0ADC804C4CED", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.349 -0400", hash_original_field = "4382140BCA1D636874DA96F2CB741946", hash_generated_field = "8FAB28482622024207604FC8F68FBA68")

        DepthFunc mDepthFunc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.350 -0400", hash_original_field = "EF5ADB93D9C2E2FD3222AED39318B510", hash_generated_field = "FC6FA044D5DC3801C8E4182A42864AF5")

        boolean mDepthMask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.352 -0400", hash_original_field = "6AE2BD0E8D1E8F52233ED950ECBF1A46", hash_generated_field = "960D09803A4683C4A2879BE8D1C9DE36")

        boolean mColorMaskR;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.353 -0400", hash_original_field = "1650D5163E2ABCA652BCEE80BBAC713B", hash_generated_field = "D753E63388AFCEB1C1E8ED1C2E5A5CDD")

        boolean mColorMaskG;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.356 -0400", hash_original_field = "6D76CAFA24DBFE2336BB003111671A39", hash_generated_field = "4F2C8807D2265836A23A4C5CE2D26F83")

        boolean mColorMaskB;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.358 -0400", hash_original_field = "2E33ED01C925634252F73809AD0F3FDB", hash_generated_field = "5CAA513127E3F20913DEBEEE391AC5C2")

        boolean mColorMaskA;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.360 -0400", hash_original_field = "9CBC5DE30EA9C740ABAE481AF449EE5A", hash_generated_field = "B1BBF7FAB925501900F9837599439C47")

        BlendSrcFunc mBlendSrc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.362 -0400", hash_original_field = "43F051D12E29844B745A6A0C9561CD6B", hash_generated_field = "72512BE02D1B3C4D84AB5B81AC84E45D")

        BlendDstFunc mBlendDst;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.364 -0400", hash_original_field = "39F3EFC8FE0445AB43D96028DA65CB34", hash_generated_field = "28ABDDC6F40109F392846C3ED0C6A12A")

        boolean mDither;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.380 -0400", hash_original_method = "265149AB55D37D488388E31C3D90875C", hash_generated_method = "2EDF9856A1AB4572EC4A936A649D73AE")
        public  Builder(RenderScript rs) {
            mRS = rs;
            mDepthFunc = DepthFunc.ALWAYS;
            mDepthMask = false;
            mColorMaskR = true;
            mColorMaskG = true;
            mColorMaskB = true;
            mColorMaskA = true;
            mBlendSrc = BlendSrcFunc.ONE;
            mBlendDst = BlendDstFunc.ZERO;
            // ---------- Original Method ----------
            //mRS = rs;
            //mDepthFunc = DepthFunc.ALWAYS;
            //mDepthMask = false;
            //mColorMaskR = true;
            //mColorMaskG = true;
            //mColorMaskB = true;
            //mColorMaskA = true;
            //mBlendSrc = BlendSrcFunc.ONE;
            //mBlendDst = BlendDstFunc.ZERO;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.385 -0400", hash_original_method = "077DECC8ABDB24AB85F09F77AF3C34E9", hash_generated_method = "AAAB88D706C767B68C25653BC09AF547")
        public Builder setDepthFunc(DepthFunc func) {
            mDepthFunc = func;
Builder var72A74007B2BE62B849F475C7BDA4658B_1382784537 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1382784537.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1382784537;
            // ---------- Original Method ----------
            //mDepthFunc = func;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.392 -0400", hash_original_method = "73973CBC15407B8A1D4D695A797EF98B", hash_generated_method = "34E58A5FF4EBB3FA81208B64C0B6456C")
        public Builder setDepthMaskEnabled(boolean enable) {
            mDepthMask = enable;
Builder var72A74007B2BE62B849F475C7BDA4658B_273534571 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_273534571.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_273534571;
            // ---------- Original Method ----------
            //mDepthMask = enable;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.403 -0400", hash_original_method = "A842B9DBA01F76FC3765EB18537F0DD4", hash_generated_method = "74922CE295AE746B4A7897541C6F9392")
        public Builder setColorMaskEnabled(boolean r, boolean g, boolean b, boolean a) {
            mColorMaskR = r;
            mColorMaskG = g;
            mColorMaskB = b;
            mColorMaskA = a;
Builder var72A74007B2BE62B849F475C7BDA4658B_931895083 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_931895083.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_931895083;
            // ---------- Original Method ----------
            //mColorMaskR = r;
            //mColorMaskG = g;
            //mColorMaskB = b;
            //mColorMaskA = a;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.410 -0400", hash_original_method = "BF6FFFCAA7ABBFD68FA703F185B02D94", hash_generated_method = "1A536671E15415E4E57BFA786B595CEE")
        public Builder setBlendFunc(BlendSrcFunc src, BlendDstFunc dst) {
            mBlendSrc = src;
            mBlendDst = dst;
Builder var72A74007B2BE62B849F475C7BDA4658B_793639002 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_793639002.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_793639002;
            // ---------- Original Method ----------
            //mBlendSrc = src;
            //mBlendDst = dst;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.415 -0400", hash_original_method = "F7A644C4DD22B87998E888BDC808A0FA", hash_generated_method = "74DE629D2639F45BC158A670B58ABDDB")
        public Builder setDitherEnabled(boolean enable) {
            mDither = enable;
Builder var72A74007B2BE62B849F475C7BDA4658B_716813064 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_716813064.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_716813064;
            // ---------- Original Method ----------
            //mDither = enable;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:06:11.434 -0400", hash_original_method = "7B8B743B7FBFF92D2151AB95EB2CD90A", hash_generated_method = "BE31FAEEA8F0C275FDE3153D1D53E090")
        public ProgramStore create() {
            mRS.validate();
            int id = mRS.nProgramStoreCreate(mColorMaskR, mColorMaskG, mColorMaskB, mColorMaskA,
                                             mDepthMask, mDither,
                                             mBlendSrc.mID, mBlendDst.mID, mDepthFunc.mID);
            ProgramStore programStore = new ProgramStore(id, mRS);
            programStore.mDepthFunc = mDepthFunc;
            programStore.mDepthMask = mDepthMask;
            programStore.mColorMaskR = mColorMaskR;
            programStore.mColorMaskG = mColorMaskG;
            programStore.mColorMaskB = mColorMaskB;
            programStore.mColorMaskA = mColorMaskA;
            programStore.mBlendSrc = mBlendSrc;
            programStore.mBlendDst = mBlendDst;
            programStore.mDither = mDither;
ProgramStore varFD05B409AF5A919495D9392DEB498A8E_623473183 =             programStore;
            varFD05B409AF5A919495D9392DEB498A8E_623473183.addTaint(taint);
            return varFD05B409AF5A919495D9392DEB498A8E_623473183;
            // ---------- Original Method ----------
            //mRS.validate();
            //int id = mRS.nProgramStoreCreate(mColorMaskR, mColorMaskG, mColorMaskB, mColorMaskA,
                                             //mDepthMask, mDither,
                                             //mBlendSrc.mID, mBlendDst.mID, mDepthFunc.mID);
            //ProgramStore programStore = new ProgramStore(id, mRS);
            //programStore.mDepthFunc = mDepthFunc;
            //programStore.mDepthMask = mDepthMask;
            //programStore.mColorMaskR = mColorMaskR;
            //programStore.mColorMaskG = mColorMaskG;
            //programStore.mColorMaskB = mColorMaskB;
            //programStore.mColorMaskA = mColorMaskA;
            //programStore.mBlendSrc = mBlendSrc;
            //programStore.mBlendDst = mBlendDst;
            //programStore.mDither = mDither;
            //return programStore;
        }

        
    }


    
}

