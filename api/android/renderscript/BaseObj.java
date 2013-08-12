package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
public class BaseObj {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-12 10:24:38.821 -0400", hash_original_field = "F967916F035DAD625F94606212B89077", hash_generated_field = "B318151FF40ADE16FE6B3D1CFBCF936A")

    private int mID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-12 10:24:38.823 -0400", hash_original_field = "C724374D1A8B3D38592BCBAA64034D32", hash_generated_field = "1C64CB399BFF718CD14799195853AA6E")

    private boolean mDestroyed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-12 10:24:38.825 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-12 10:24:38.827 -0400", hash_original_field = "15EADDEB24354180E81F0ADC804C4CED", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

    RenderScript mRS;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-12 10:24:38.846 -0400", hash_original_method = "C8BB1F812AF2F94B259A1E5D31EF6D41", hash_generated_method = "9BA993700E946D74BD21802FA955DFDC")
      BaseObj(int id, RenderScript rs) {
        rs.validate();
        mRS = rs;
        mID = id;
        mDestroyed = false;
        // ---------- Original Method ----------
        //rs.validate();
        //mRS = rs;
        //mID = id;
        //mDestroyed = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-12 10:24:38.885 -0400", hash_original_method = "092163F994B2BA343A828C1CA6CB67EF", hash_generated_method = "6AB76F45D90B5C4C568C32E7A1A93D7B")
     void setID(int id) {
        if(mID != 0)        
        {
            RSRuntimeException varAECDCC356466FA0E08C3F6BD0A6601F4_1942724321 = new RSRuntimeException("Internal Error, reset of object ID.");
            varAECDCC356466FA0E08C3F6BD0A6601F4_1942724321.addTaint(taint);
            throw varAECDCC356466FA0E08C3F6BD0A6601F4_1942724321;
        } //End block
        mID = id;
        // ---------- Original Method ----------
        //if (mID != 0) {
            //throw new RSRuntimeException("Internal Error, reset of object ID.");
        //}
        //mID = id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-12 10:24:38.902 -0400", hash_original_method = "070330937CB15D09BB5E296631EB884D", hash_generated_method = "787BC2A5C62355AD70DAB5AD9F6E5B9F")
     int getID() {
        if(mDestroyed)        
        {
            RSInvalidStateException varB895F990960DDBEFCCE03FC7C266BCAC_1683985551 = new RSInvalidStateException("using a destroyed object.");
            varB895F990960DDBEFCCE03FC7C266BCAC_1683985551.addTaint(taint);
            throw varB895F990960DDBEFCCE03FC7C266BCAC_1683985551;
        } //End block
        if(mID == 0)        
        {
            RSRuntimeException varC5C419CF83B62126EF3D347BC8CB76E4_577202160 = new RSRuntimeException("Internal error: Object id 0.");
            varC5C419CF83B62126EF3D347BC8CB76E4_577202160.addTaint(taint);
            throw varC5C419CF83B62126EF3D347BC8CB76E4_577202160;
        } //End block
        int varF967916F035DAD625F94606212B89077_1153197812 = (mID);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080762398 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080762398;
        // ---------- Original Method ----------
        //if (mDestroyed) {
            //throw new RSInvalidStateException("using a destroyed object.");
        //}
        //if (mID == 0) {
            //throw new RSRuntimeException("Internal error: Object id 0.");
        //}
        //return mID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-12 10:24:38.919 -0400", hash_original_method = "B7F1DAC6FB0A90239CE3626781D0AB2E", hash_generated_method = "C2187B3977F54248C6E3E53F798C73A1")
     void checkValid() {
        if(mID == 0)        
        {
            RSIllegalArgumentException var09F4F7B2975CA0E3378CAE0D6F618607_388383060 = new RSIllegalArgumentException("Invalid object.");
            var09F4F7B2975CA0E3378CAE0D6F618607_388383060.addTaint(taint);
            throw var09F4F7B2975CA0E3378CAE0D6F618607_388383060;
        } //End block
        // ---------- Original Method ----------
        //if (mID == 0) {
            //throw new RSIllegalArgumentException("Invalid object.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-12 10:24:38.945 -0400", hash_original_method = "1123E46F9FC56B053C2DA43752023478", hash_generated_method = "916C39BC253A284CE57606C12EB79D12")
    public void setName(String name) {
        if(name == null)        
        {
            RSIllegalArgumentException var6E4861738507B0FA7F3BE881F7C014CF_1859547089 = new RSIllegalArgumentException(
                "setName requires a string of non-zero length.");
            var6E4861738507B0FA7F3BE881F7C014CF_1859547089.addTaint(taint);
            throw var6E4861738507B0FA7F3BE881F7C014CF_1859547089;
        } //End block
        if(name.length() < 1)        
        {
            RSIllegalArgumentException var9F8A7447AB8B4708ECF2415070DBDC3B_1954377893 = new RSIllegalArgumentException(
                "setName does not accept a zero length string.");
            var9F8A7447AB8B4708ECF2415070DBDC3B_1954377893.addTaint(taint);
            throw var9F8A7447AB8B4708ECF2415070DBDC3B_1954377893;
        } //End block
        if(mName != null)        
        {
            RSIllegalArgumentException varA75290665B52F99DEF12EE246888A4E1_1209699789 = new RSIllegalArgumentException(
                "setName object already has a name.");
            varA75290665B52F99DEF12EE246888A4E1_1209699789.addTaint(taint);
            throw varA75290665B52F99DEF12EE246888A4E1_1209699789;
        } //End block
        try 
        {
            byte[] bytes = name.getBytes("UTF-8");
            mRS.nAssignName(mID, bytes);
            mName = name;
        } //End block
        catch (java.io.UnsupportedEncodingException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_869881414 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_869881414.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_869881414;
        } //End block
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new RSIllegalArgumentException(
                //"setName requires a string of non-zero length.");
        //}
        //if(name.length() < 1) {
            //throw new RSIllegalArgumentException(
                //"setName does not accept a zero length string.");
        //}
        //if(mName != null) {
            //throw new RSIllegalArgumentException(
                //"setName object already has a name.");
        //}
        //try {
            //byte[] bytes = name.getBytes("UTF-8");
            //mRS.nAssignName(mID, bytes);
            //mName = name;
        //} catch (java.io.UnsupportedEncodingException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-12 10:24:38.962 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "76576415083956B2A9D7F69455B0166B")
    public String getName() {
String varDBF15A5FB8102A5C28D5046A0E92E443_222070636 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_222070636.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_222070636;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-12 10:24:38.981 -0400", hash_original_method = "FF2533C9D3CAE2C033B0095CDF311C3A", hash_generated_method = "7C93334D7FFDAA5256FF31AA8A0BDB04")
    protected void finalize() throws Throwable {
        if(!mDestroyed)        
        {
            if(mID != 0 && mRS.isAlive())            
            {
                mRS.nObjDestroy(mID);
            } //End block
            mRS = null;
            mID = 0;
            mDestroyed = true;
        } //End block
        super.finalize();
        // ---------- Original Method ----------
        //if (!mDestroyed) {
            //if(mID != 0 && mRS.isAlive()) {
                //mRS.nObjDestroy(mID);
            //}
            //mRS = null;
            //mID = 0;
            //mDestroyed = true;
        //}
        //super.finalize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-12 10:24:38.995 -0400", hash_original_method = "48EC2BD0914D5724BE75C18442D4A6A2", hash_generated_method = "E6A644BDD17613785413B0EED42CF0A6")
    synchronized public void destroy() {
        if(mDestroyed)        
        {
            RSInvalidStateException var18AB0BF0CE1E1755C9E29A01802A0DEE_2114557133 = new RSInvalidStateException("Object already destroyed.");
            var18AB0BF0CE1E1755C9E29A01802A0DEE_2114557133.addTaint(taint);
            throw var18AB0BF0CE1E1755C9E29A01802A0DEE_2114557133;
        } //End block
        mDestroyed = true;
        mRS.nObjDestroy(mID);
        // ---------- Original Method ----------
        //if(mDestroyed) {
            //throw new RSInvalidStateException("Object already destroyed.");
        //}
        //mDestroyed = true;
        //mRS.nObjDestroy(mID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-12 10:24:39.006 -0400", hash_original_method = "AB3B4827E233BF1789642230E2C32EC4", hash_generated_method = "7D88B51DC6EFD24018D2A83530573BE6")
     void updateFromNative() {
        mRS.validate();
        mName = mRS.nGetName(getID());
        // ---------- Original Method ----------
        //mRS.validate();
        //mName = mRS.nGetName(getID());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-12 10:24:39.012 -0400", hash_original_method = "399A2DDCEE4C827B87F141BE75C58C17", hash_generated_method = "783E387FC850A620061B6D7EFD462E3C")
    @Override
    public int hashCode() {
        int varF967916F035DAD625F94606212B89077_671928927 = (mID);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_101936535 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_101936535;
        // ---------- Original Method ----------
        //return mID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-12 10:24:39.024 -0400", hash_original_method = "60FC0B8BE57466D21B9D49483A61B23F", hash_generated_method = "0BE831F494D505876FDC41DC28F9D2F6")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(this == obj)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1823101024 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2002500282 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2002500282;
        }
        if(getClass() != obj.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1516764908 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_695654597 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_695654597;
        } //End block
        BaseObj b = (BaseObj) obj;
        boolean var14A90621BD4E9D0EBF7B8AE315FB0064_208063530 = (mID == b.mID);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1454751548 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1454751548;
        // ---------- Original Method ----------
        //if (this == obj)
            //return true;
        //if (getClass() != obj.getClass()) {
            //return false;
        //}
        //BaseObj b = (BaseObj) obj;
        //return mID == b.mID;
    }

    
}

