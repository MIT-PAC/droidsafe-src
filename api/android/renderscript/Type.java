package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import java.lang.reflect.Field;
public class Type extends BaseObj {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.288 -0400", hash_original_field = "74F2C7E1CEE060256706B117F5FA730E", hash_generated_field = "166EAD939F5B09E30CBCA868F3EBACAE")

    int mDimX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.291 -0400", hash_original_field = "EB7B56BF2E26D72976C8BE5C6E4CAFB5", hash_generated_field = "52E465806612DCEB5EFA0AB2B3ADAE76")

    int mDimY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.292 -0400", hash_original_field = "30713945613FB4C6A730B4A32950F103", hash_generated_field = "CECA88AF13F74CDB4E12BE33048A317C")

    int mDimZ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.294 -0400", hash_original_field = "DDAEBBC104D36F2D3D3CDAF5E4EC77DB", hash_generated_field = "25321B8A368E9568ECB8D39F78480AB5")

    boolean mDimMipmaps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.296 -0400", hash_original_field = "3E1AACDB9C31033BF848156C0A3F9A83", hash_generated_field = "DFD2959534422FCC872B818F7E0B6875")

    boolean mDimFaces;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.302 -0400", hash_original_field = "6BADBC84ED4C8D9AA913FEA8E9084017", hash_generated_field = "E724C728128A53C10A09F06C64DDD490")

    int mElementCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.304 -0400", hash_original_field = "08E316DDB61D78B6AA0D6372095F762A", hash_generated_field = "EC8CEE28EE8EC6C488BEE33A3E23406D")

    Element mElement;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.309 -0400", hash_original_method = "16C6269A6A80062F3C7B05511AF2EA14", hash_generated_method = "282F3AE7F99D41BEA69CEFB7D86A5488")
      Type(int id, RenderScript rs) {
        super(id, rs);
        addTaint(rs.getTaint());
        addTaint(id);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.314 -0400", hash_original_method = "4A983E462672C2EA1E6C39A6A01B91CB", hash_generated_method = "F8065654CDEA0C547A9BE53140ECA542")
    public Element getElement() {
Element varA85FFCDAA3B45409BDD4C198FC37D351_665221814 =         mElement;
        varA85FFCDAA3B45409BDD4C198FC37D351_665221814.addTaint(taint);
        return varA85FFCDAA3B45409BDD4C198FC37D351_665221814;
        // ---------- Original Method ----------
        //return mElement;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.319 -0400", hash_original_method = "B8C0887F5E9E541E727ECCD0086F5E5B", hash_generated_method = "FFE0CD7F234A36DC2E6B5935FF29688B")
    public int getX() {
        int var74F2C7E1CEE060256706B117F5FA730E_482445178 = (mDimX);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2077490746 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2077490746;
        // ---------- Original Method ----------
        //return mDimX;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.324 -0400", hash_original_method = "5E9C3BBA0D7932B9CBA182F8B32036BC", hash_generated_method = "FAE6A2C799BAC65CF38B55FD7DD732B6")
    public int getY() {
        int varEB7B56BF2E26D72976C8BE5C6E4CAFB5_1550429101 = (mDimY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1042223702 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1042223702;
        // ---------- Original Method ----------
        //return mDimY;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.330 -0400", hash_original_method = "E315B95FC6DF6C1A4510539F8CFF9FC2", hash_generated_method = "84B6E83216D9BAF2CB8E90C7B3C2B3CA")
    public int getZ() {
        int var30713945613FB4C6A730B4A32950F103_1442774074 = (mDimZ);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822994791 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822994791;
        // ---------- Original Method ----------
        //return mDimZ;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.335 -0400", hash_original_method = "4B051F35B9C270411E541578F7D74139", hash_generated_method = "5A73CA4245BDF94A4A3704BD28D5FBFE")
    public boolean hasMipmaps() {
        boolean varDDAEBBC104D36F2D3D3CDAF5E4EC77DB_808556547 = (mDimMipmaps);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_280743789 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_280743789;
        // ---------- Original Method ----------
        //return mDimMipmaps;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.341 -0400", hash_original_method = "A298ED811BA5BE2EDFB864807B88B98E", hash_generated_method = "B2ECE4EB67403FB69FB05ABC00EDEE5C")
    public boolean hasFaces() {
        boolean var3E1AACDB9C31033BF848156C0A3F9A83_1324462790 = (mDimFaces);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1039302540 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1039302540;
        // ---------- Original Method ----------
        //return mDimFaces;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.345 -0400", hash_original_method = "48334469C8B133AB7598FD3FC5B4F37B", hash_generated_method = "878540EA78CCD96B69AEBDEF96AE99E2")
    public int getCount() {
        int var6BADBC84ED4C8D9AA913FEA8E9084017_1731871881 = (mElementCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_652924165 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_652924165;
        // ---------- Original Method ----------
        //return mElementCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.374 -0400", hash_original_method = "2C27E4A52BBF3CC9203234C207690BDD", hash_generated_method = "1C9B9889EC0221690A567A55318C7062")
     void calcElementCount() {
        boolean hasLod = hasMipmaps();
        int x = getX();
        int y = getY();
        int z = getZ();
        int faces = 1;
        if(hasFaces())        
        {
            faces = 6;
        } //End block
        if(x == 0)        
        {
            x = 1;
        } //End block
        if(y == 0)        
        {
            y = 1;
        } //End block
        if(z == 0)        
        {
            z = 1;
        } //End block
        int count = x * y * z * faces;
        while
(hasLod && ((x > 1) || (y > 1) || (z > 1)))        
        {
            if(x > 1)            
            {
                x >>= 1;
            } //End block
            if(y > 1)            
            {
                y >>= 1;
            } //End block
            if(z > 1)            
            {
                z >>= 1;
            } //End block
            count += x * y * z * faces;
        } //End block
        mElementCount = count;
        // ---------- Original Method ----------
        //boolean hasLod = hasMipmaps();
        //int x = getX();
        //int y = getY();
        //int z = getZ();
        //int faces = 1;
        //if (hasFaces()) {
            //faces = 6;
        //}
        //if (x == 0) {
            //x = 1;
        //}
        //if (y == 0) {
            //y = 1;
        //}
        //if (z == 0) {
            //z = 1;
        //}
        //int count = x * y * z * faces;
        //while (hasLod && ((x > 1) || (y > 1) || (z > 1))) {
            //if(x > 1) {
                //x >>= 1;
            //}
            //if(y > 1) {
                //y >>= 1;
            //}
            //if(z > 1) {
                //z >>= 1;
            //}
            //count += x * y * z * faces;
        //}
        //mElementCount = count;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.396 -0400", hash_original_method = "D9C91D8B790AFADAD6800FA858F1EFFA", hash_generated_method = "245668955FC688CA4C3655E0C3BA7F3A")
    @Override
     void updateFromNative() {
        int[] dataBuffer = new int[6];
        mRS.nTypeGetNativeData(getID(), dataBuffer);
        mDimX = dataBuffer[0];
        mDimY = dataBuffer[1];
        mDimZ = dataBuffer[2];
        mDimMipmaps = dataBuffer[3] == 1 ? true : false;
        mDimFaces = dataBuffer[4] == 1 ? true : false;
        int elementID = dataBuffer[5];
        if(elementID != 0)        
        {
            mElement = new Element(elementID, mRS);
            mElement.updateFromNative();
        } //End block
        calcElementCount();
        // ---------- Original Method ----------
        //int[] dataBuffer = new int[6];
        //mRS.nTypeGetNativeData(getID(), dataBuffer);
        //mDimX = dataBuffer[0];
        //mDimY = dataBuffer[1];
        //mDimZ = dataBuffer[2];
        //mDimMipmaps = dataBuffer[3] == 1 ? true : false;
        //mDimFaces = dataBuffer[4] == 1 ? true : false;
        //int elementID = dataBuffer[5];
        //if(elementID != 0) {
            //mElement = new Element(elementID, mRS);
            //mElement.updateFromNative();
        //}
        //calcElementCount();
    }

    
    public enum CubemapFace {
        POSITIVE_X (0),
        NEGATIVE_X (1),
        POSITIVE_Y (2),
        NEGATIVE_Y (3),
        POSITIVE_Z (4),
        NEGATIVE_Z (5),
        @Deprecated
        POSITVE_X (0),
        @Deprecated
        POSITVE_Y (2),
        @Deprecated
        POSITVE_Z (4);
        int mID;
        CubemapFace(int id) {
            mID = id;
        }
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.401 -0400", hash_original_field = "15EADDEB24354180E81F0ADC804C4CED", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.403 -0400", hash_original_field = "B837DC4E124712F48273216A28900AC0", hash_generated_field = "19CD781E8EBBB291E01238A36BA4EFE0")

        int mDimX = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.405 -0400", hash_original_field = "EB7B56BF2E26D72976C8BE5C6E4CAFB5", hash_generated_field = "52E465806612DCEB5EFA0AB2B3ADAE76")

        int mDimY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.409 -0400", hash_original_field = "30713945613FB4C6A730B4A32950F103", hash_generated_field = "CECA88AF13F74CDB4E12BE33048A317C")

        int mDimZ;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.410 -0400", hash_original_field = "DDAEBBC104D36F2D3D3CDAF5E4EC77DB", hash_generated_field = "25321B8A368E9568ECB8D39F78480AB5")

        boolean mDimMipmaps;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.412 -0400", hash_original_field = "3E1AACDB9C31033BF848156C0A3F9A83", hash_generated_field = "DFD2959534422FCC872B818F7E0B6875")

        boolean mDimFaces;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.413 -0400", hash_original_field = "08E316DDB61D78B6AA0D6372095F762A", hash_generated_field = "EC8CEE28EE8EC6C488BEE33A3E23406D")

        Element mElement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.419 -0400", hash_original_method = "7F91DC25C3C3CDE10A09CD9C14BFD4B5", hash_generated_method = "7485E16896131D978767558B345EEB2A")
        public  Builder(RenderScript rs, Element e) {
            e.checkValid();
            mRS = rs;
            mElement = e;
            // ---------- Original Method ----------
            //e.checkValid();
            //mRS = rs;
            //mElement = e;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.429 -0400", hash_original_method = "49C74CAE6836798531411A61C63C5943", hash_generated_method = "824B27B1198C5E7D78F8B5D1E28F7C7D")
        public Builder setX(int value) {
            if(value < 1)            
            {
                RSIllegalArgumentException var7DBE63B2CADDC0CECB01E687D159ECC7_498774420 = new RSIllegalArgumentException("Values of less than 1 for Dimension X are not valid.");
                var7DBE63B2CADDC0CECB01E687D159ECC7_498774420.addTaint(taint);
                throw var7DBE63B2CADDC0CECB01E687D159ECC7_498774420;
            } //End block
            mDimX = value;
Builder var72A74007B2BE62B849F475C7BDA4658B_1194048284 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1194048284.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1194048284;
            // ---------- Original Method ----------
            //if(value < 1) {
                //throw new RSIllegalArgumentException("Values of less than 1 for Dimension X are not valid.");
            //}
            //mDimX = value;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.437 -0400", hash_original_method = "DFB03FCEFD1326FB2171A041DB523085", hash_generated_method = "A4105DA6B2544342FEF9615C4B0FD3F4")
        public Builder setY(int value) {
            if(value < 1)            
            {
                RSIllegalArgumentException var2CFDAA71FD07A74164ED25EA958A3AD4_343564817 = new RSIllegalArgumentException("Values of less than 1 for Dimension Y are not valid.");
                var2CFDAA71FD07A74164ED25EA958A3AD4_343564817.addTaint(taint);
                throw var2CFDAA71FD07A74164ED25EA958A3AD4_343564817;
            } //End block
            mDimY = value;
Builder var72A74007B2BE62B849F475C7BDA4658B_1223422091 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1223422091.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1223422091;
            // ---------- Original Method ----------
            //if(value < 1) {
                //throw new RSIllegalArgumentException("Values of less than 1 for Dimension Y are not valid.");
            //}
            //mDimY = value;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.443 -0400", hash_original_method = "6FF2F97061E56A03E659E1B7B4FEDFAC", hash_generated_method = "AE8341CC56D90BE2246DD8C3A23DDDEF")
        public Builder setMipmaps(boolean value) {
            mDimMipmaps = value;
Builder var72A74007B2BE62B849F475C7BDA4658B_1741595708 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1741595708.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1741595708;
            // ---------- Original Method ----------
            //mDimMipmaps = value;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.453 -0400", hash_original_method = "A3F9FA926CF212B551274C553F57A403", hash_generated_method = "C49FC9F8E575764C2EEE5D5A5EA2419B")
        public Builder setFaces(boolean value) {
            mDimFaces = value;
Builder var72A74007B2BE62B849F475C7BDA4658B_1222195317 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1222195317.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1222195317;
            // ---------- Original Method ----------
            //mDimFaces = value;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:08:25.474 -0400", hash_original_method = "FE3D5B55E53BDF1600935D20E2D4BB17", hash_generated_method = "DE2CF13A483BC7939911E0E6E44F7BC2")
        public Type create() {
            if(mDimZ > 0)            
            {
                if((mDimX < 1) || (mDimY < 1))                
                {
                    RSInvalidStateException varBF7EFA3FB00B1F013C843C56DB64B461_704828225 = new RSInvalidStateException("Both X and Y dimension required when Z is present.");
                    varBF7EFA3FB00B1F013C843C56DB64B461_704828225.addTaint(taint);
                    throw varBF7EFA3FB00B1F013C843C56DB64B461_704828225;
                } //End block
                if(mDimFaces)                
                {
                    RSInvalidStateException var3DA2A67E886A7F4840143E799A977C4C_426072810 = new RSInvalidStateException("Cube maps not supported with 3D types.");
                    var3DA2A67E886A7F4840143E799A977C4C_426072810.addTaint(taint);
                    throw var3DA2A67E886A7F4840143E799A977C4C_426072810;
                } //End block
            } //End block
            if(mDimY > 0)            
            {
                if(mDimX < 1)                
                {
                    RSInvalidStateException var82AE11D5EA543E0FC474D22B3D41950E_1538691273 = new RSInvalidStateException("X dimension required when Y is present.");
                    var82AE11D5EA543E0FC474D22B3D41950E_1538691273.addTaint(taint);
                    throw var82AE11D5EA543E0FC474D22B3D41950E_1538691273;
                } //End block
            } //End block
            if(mDimFaces)            
            {
                if(mDimY < 1)                
                {
                    RSInvalidStateException var4B0DD9C3AA46F21C109A1F3DFE84400A_812653116 = new RSInvalidStateException("Cube maps require 2D Types.");
                    var4B0DD9C3AA46F21C109A1F3DFE84400A_812653116.addTaint(taint);
                    throw var4B0DD9C3AA46F21C109A1F3DFE84400A_812653116;
                } //End block
            } //End block
            int id = mRS.nTypeCreate(mElement.getID(), mDimX, mDimY, mDimZ, mDimMipmaps, mDimFaces);
            Type t = new Type(id, mRS);
            t.mElement = mElement;
            t.mDimX = mDimX;
            t.mDimY = mDimY;
            t.mDimZ = mDimZ;
            t.mDimMipmaps = mDimMipmaps;
            t.mDimFaces = mDimFaces;
            t.calcElementCount();
Type varE0D714D758F1540A8DF364A965AF9150_1422603211 =             t;
            varE0D714D758F1540A8DF364A965AF9150_1422603211.addTaint(taint);
            return varE0D714D758F1540A8DF364A965AF9150_1422603211;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
}

