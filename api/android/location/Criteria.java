package android.location;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public class Criteria implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.008 -0400", hash_original_field = "13196B050486260F665DAFD2DCB1423F", hash_generated_field = "1A506D6FCBAE89E5ED8986984C204EDF")

    private int mHorizontalAccuracy = NO_REQUIREMENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.008 -0400", hash_original_field = "0E3223CDB10E8518132E5C3C8949A857", hash_generated_field = "9C948891D51E1ECED7D5B42EA88A1980")

    private int mVerticalAccuracy = NO_REQUIREMENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.008 -0400", hash_original_field = "13BEB683610F4CA34C01AD5B72FB840D", hash_generated_field = "4206F17114FC87E89D5E2D934FD265D1")

    private int mSpeedAccuracy = NO_REQUIREMENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.008 -0400", hash_original_field = "C8601B5B1BC4F79D3CFF6EFC67E5AFBF", hash_generated_field = "AFE00C78DEAD58C36FFBF596A3087BA3")

    private int mBearingAccuracy = NO_REQUIREMENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.008 -0400", hash_original_field = "02F1E7376BDB45AD1CE174FBAE2021E0", hash_generated_field = "F89FA2DF8DA48BD5497DB50DA1CA47F5")

    private int mPowerRequirement = NO_REQUIREMENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.008 -0400", hash_original_field = "575F35BF19BB272643940F388D2E2DB4", hash_generated_field = "1ABEB241EAFF3EEBFF568528AFCBA219")

    private boolean mAltitudeRequired = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.008 -0400", hash_original_field = "9A6402C26B24D09EFCAC163486A70A18", hash_generated_field = "0299E987BE1DC1D0B0A7571822B9D8AA")

    private boolean mBearingRequired = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.008 -0400", hash_original_field = "11B7FA9A4B9DEE5D16188AFC702520C8", hash_generated_field = "9B3C565095BC4FCEC789B430DD2467DF")

    private boolean mSpeedRequired = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.008 -0400", hash_original_field = "767BA11EBC9E4746FB44A19596372104", hash_generated_field = "4FF764166F8A934C7C88D2C8472DFB24")

    private boolean mCostAllowed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.009 -0400", hash_original_method = "56D25A23ADD1F3C93CB7F827DA5DFB02", hash_generated_method = "3EFEE149D939DD3A0C00E9F5B56EE461")
    public  Criteria() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.012 -0400", hash_original_method = "4027197A668FB712D0A5A09027B96247", hash_generated_method = "AF9F22AB717402C29CAE5B27F1850449")
    public  Criteria(Criteria criteria) {
        mHorizontalAccuracy = criteria.mHorizontalAccuracy;
        mVerticalAccuracy = criteria.mVerticalAccuracy;
        mSpeedAccuracy = criteria.mSpeedAccuracy;
        mBearingAccuracy = criteria.mBearingAccuracy;
        mPowerRequirement = criteria.mPowerRequirement;
        mAltitudeRequired = criteria.mAltitudeRequired;
        mBearingRequired = criteria.mBearingRequired;
        mSpeedRequired = criteria.mSpeedRequired;
        mCostAllowed = criteria.mCostAllowed;
        // ---------- Original Method ----------
        //mHorizontalAccuracy = criteria.mHorizontalAccuracy;
        //mVerticalAccuracy = criteria.mVerticalAccuracy;
        //mSpeedAccuracy = criteria.mSpeedAccuracy;
        //mBearingAccuracy = criteria.mBearingAccuracy;
        //mPowerRequirement = criteria.mPowerRequirement;
        //mAltitudeRequired = criteria.mAltitudeRequired;
        //mBearingRequired = criteria.mBearingRequired;
        //mSpeedRequired = criteria.mSpeedRequired;
        //mCostAllowed = criteria.mCostAllowed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.012 -0400", hash_original_method = "F7CDA1AEB030C3E960B93BFBD444E4B1", hash_generated_method = "52B8FA720840D972634AEC73BB657779")
    public void setHorizontalAccuracy(int accuracy) {
        if(accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH)        
        {
            IllegalArgumentException varF790EF5E2E4FE72E5D1C0EA8A5531656_1583309643 = new IllegalArgumentException("accuracy=" + accuracy);
            varF790EF5E2E4FE72E5D1C0EA8A5531656_1583309643.addTaint(taint);
            throw varF790EF5E2E4FE72E5D1C0EA8A5531656_1583309643;
        } //End block
        mHorizontalAccuracy = accuracy;
        // ---------- Original Method ----------
        //if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH) {
            //throw new IllegalArgumentException("accuracy=" + accuracy);
        //}
        //mHorizontalAccuracy = accuracy;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.013 -0400", hash_original_method = "2F566A20A5A9A3E4947DCE83AA9DF67E", hash_generated_method = "8F34A5D548E1139FEA9C958AE28836B5")
    public int getHorizontalAccuracy() {
        int var657284437DEB9E5B0F822222073D019D_1890004690 = (mHorizontalAccuracy);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_801260840 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_801260840;
        // ---------- Original Method ----------
        //return mHorizontalAccuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.014 -0400", hash_original_method = "A234CD6EE2124B9B176BE728225522DE", hash_generated_method = "B649BA1793B0FFEF75641906B89EC917")
    public void setVerticalAccuracy(int accuracy) {
        if(accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH)        
        {
            IllegalArgumentException varF790EF5E2E4FE72E5D1C0EA8A5531656_1985360705 = new IllegalArgumentException("accuracy=" + accuracy);
            varF790EF5E2E4FE72E5D1C0EA8A5531656_1985360705.addTaint(taint);
            throw varF790EF5E2E4FE72E5D1C0EA8A5531656_1985360705;
        } //End block
        mVerticalAccuracy = accuracy;
        // ---------- Original Method ----------
        //if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH) {
            //throw new IllegalArgumentException("accuracy=" + accuracy);
        //}
        //mVerticalAccuracy = accuracy;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.014 -0400", hash_original_method = "E46E133CF34270F0210C8D2BD309B3F5", hash_generated_method = "28EEE7A3A06DAFEDD5DE971F4286D98D")
    public int getVerticalAccuracy() {
        int var9DC0DEEA417C8E8EBF9F521967A757AB_1537681205 = (mVerticalAccuracy);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080477112 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080477112;
        // ---------- Original Method ----------
        //return mVerticalAccuracy;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.016 -0400", hash_original_method = "7DA41913012CB9940E77425DCF2D2731", hash_generated_method = "543C39EA56B675DB78101AD30EAD84E4")
    public void setSpeedAccuracy(int accuracy) {
        if(accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH)        
        {
            IllegalArgumentException varF790EF5E2E4FE72E5D1C0EA8A5531656_1595237212 = new IllegalArgumentException("accuracy=" + accuracy);
            varF790EF5E2E4FE72E5D1C0EA8A5531656_1595237212.addTaint(taint);
            throw varF790EF5E2E4FE72E5D1C0EA8A5531656_1595237212;
        } //End block
        mSpeedAccuracy = accuracy;
        // ---------- Original Method ----------
        //if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH) {
            //throw new IllegalArgumentException("accuracy=" + accuracy);
        //}
        //mSpeedAccuracy = accuracy;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.017 -0400", hash_original_method = "87339E07174611DFFFF3AC3EA0F5BF3F", hash_generated_method = "236448CD211CB12C6E95E63872926D05")
    public int getSpeedAccuracy() {
        int varDD6DE31C3EA53337E8393DB1A3DDB208_1027003314 = (mSpeedAccuracy);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2079617042 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2079617042;
        // ---------- Original Method ----------
        //return mSpeedAccuracy;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.019 -0400", hash_original_method = "7D38552738106C949C369F73EBC07BAD", hash_generated_method = "B924D8393A9B1A9C8F627FCA6EC62C41")
    public void setBearingAccuracy(int accuracy) {
        if(accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH)        
        {
            IllegalArgumentException varF790EF5E2E4FE72E5D1C0EA8A5531656_567482522 = new IllegalArgumentException("accuracy=" + accuracy);
            varF790EF5E2E4FE72E5D1C0EA8A5531656_567482522.addTaint(taint);
            throw varF790EF5E2E4FE72E5D1C0EA8A5531656_567482522;
        } //End block
        mBearingAccuracy = accuracy;
        // ---------- Original Method ----------
        //if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH) {
            //throw new IllegalArgumentException("accuracy=" + accuracy);
        //}
        //mBearingAccuracy = accuracy;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.020 -0400", hash_original_method = "0A4814C8F779184929A4F3680AE62C8F", hash_generated_method = "68F8DFC029A0362C183936B8C1676EA1")
    public int getBearingAccuracy() {
        int var0E53E998E66FEE913D5E92D4E04CA177_483590645 = (mBearingAccuracy);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22551789 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22551789;
        // ---------- Original Method ----------
        //return mBearingAccuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.021 -0400", hash_original_method = "F2B3644622DFC41E9C3EF3B6293185D6", hash_generated_method = "F34B00F4C086DF3B61A940215161B0C5")
    public void setAccuracy(int accuracy) {
        addTaint(accuracy);
        if(accuracy < NO_REQUIREMENT || accuracy > ACCURACY_COARSE)        
        {
            IllegalArgumentException varF790EF5E2E4FE72E5D1C0EA8A5531656_1321633890 = new IllegalArgumentException("accuracy=" + accuracy);
            varF790EF5E2E4FE72E5D1C0EA8A5531656_1321633890.addTaint(taint);
            throw varF790EF5E2E4FE72E5D1C0EA8A5531656_1321633890;
        } //End block
        if(accuracy == ACCURACY_FINE)        
        {
            mHorizontalAccuracy = ACCURACY_HIGH;
        } //End block
        else
        {
            mHorizontalAccuracy = ACCURACY_LOW;
        } //End block
        // ---------- Original Method ----------
        //if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_COARSE) {
            //throw new IllegalArgumentException("accuracy=" + accuracy);
        //}
        //if (accuracy == ACCURACY_FINE) {
            //mHorizontalAccuracy = ACCURACY_HIGH;
        //} else {
            //mHorizontalAccuracy = ACCURACY_LOW;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.023 -0400", hash_original_method = "738CC4C555122D617CAE26F950A7954B", hash_generated_method = "E5AE6E03F9DDD4FCFD29A1895DA19D3A")
    public int getAccuracy() {
        if(mHorizontalAccuracy >= ACCURACY_HIGH)        
        {
            int var245CB7E1095C6AE263632D8AC9A78D9D_715929988 = (ACCURACY_FINE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_603873631 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_603873631;
        } //End block
        else
        {
            int var071AA21F3F4833EA1DFC453B75CCC2E7_2067897220 = (ACCURACY_COARSE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273990202 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273990202;
        } //End block
        // ---------- Original Method ----------
        //if (mHorizontalAccuracy >= ACCURACY_HIGH) {
            //return ACCURACY_FINE;
        //} else {
            //return ACCURACY_COARSE;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.024 -0400", hash_original_method = "91C2D38607A4F9F70C65E1811565AAD2", hash_generated_method = "FCB227990432D28CAF1CCEFB3A6A10E8")
    public void setPowerRequirement(int level) {
        if(level < NO_REQUIREMENT || level > POWER_HIGH)        
        {
            IllegalArgumentException var7FCAD3A78732A0E9BE9F94A31FA7836A_169602880 = new IllegalArgumentException("level=" + level);
            var7FCAD3A78732A0E9BE9F94A31FA7836A_169602880.addTaint(taint);
            throw var7FCAD3A78732A0E9BE9F94A31FA7836A_169602880;
        } //End block
        mPowerRequirement = level;
        // ---------- Original Method ----------
        //if (level < NO_REQUIREMENT || level > POWER_HIGH) {
            //throw new IllegalArgumentException("level=" + level);
        //}
        //mPowerRequirement = level;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.025 -0400", hash_original_method = "50AB5D6061392E8FAC8A81CA41B14FB2", hash_generated_method = "63B5824F3F687F45DCA75441088657D4")
    public int getPowerRequirement() {
        int var8CE6AA00EE3C11F8598CD0D337F6CAE9_1031222149 = (mPowerRequirement);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1181842481 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1181842481;
        // ---------- Original Method ----------
        //return mPowerRequirement;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.026 -0400", hash_original_method = "F89CAE570739AB3028DA707B2893B5C5", hash_generated_method = "443B9DB636371A2B7B02DF32D76227F5")
    public void setCostAllowed(boolean costAllowed) {
        mCostAllowed = costAllowed;
        // ---------- Original Method ----------
        //mCostAllowed = costAllowed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.027 -0400", hash_original_method = "A41D9C3F2D62A3EB42A9C94631C7A3C6", hash_generated_method = "F758BA5B226D64690214DBE407B90CCB")
    public boolean isCostAllowed() {
        boolean var693DBFD3D8595E83FEC37E42A7E10FC5_1634969469 = (mCostAllowed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_470068075 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_470068075;
        // ---------- Original Method ----------
        //return mCostAllowed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.027 -0400", hash_original_method = "22D4EC779FEBEFBD7A04B35673FD6242", hash_generated_method = "524AA438AB1E72E536604C84A2FEE4DD")
    public void setAltitudeRequired(boolean altitudeRequired) {
        mAltitudeRequired = altitudeRequired;
        // ---------- Original Method ----------
        //mAltitudeRequired = altitudeRequired;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.028 -0400", hash_original_method = "B960582E2C1A3651AC20223DA8436091", hash_generated_method = "B70D02F64EE67F9AFFF4216E3348F3DF")
    public boolean isAltitudeRequired() {
        boolean var68A3FE577355C936A23E450FE3D7DBC9_381399279 = (mAltitudeRequired);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1546617947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1546617947;
        // ---------- Original Method ----------
        //return mAltitudeRequired;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.028 -0400", hash_original_method = "6A27513D0E2583F73F00042D0FDBD9E3", hash_generated_method = "8525723E1D70E6CFA504642A945EA5E3")
    public void setSpeedRequired(boolean speedRequired) {
        mSpeedRequired = speedRequired;
        // ---------- Original Method ----------
        //mSpeedRequired = speedRequired;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.029 -0400", hash_original_method = "F6BA7163C74D6BF39003C6333C2CFD6D", hash_generated_method = "7BD82D411AC8D36DB9902064AC83D3F2")
    public boolean isSpeedRequired() {
        boolean varCCB4571254AD4731D960379818749D41_1964309910 = (mSpeedRequired);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_401593104 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_401593104;
        // ---------- Original Method ----------
        //return mSpeedRequired;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.029 -0400", hash_original_method = "B68158C6EC7F405A349EABCD21ABA300", hash_generated_method = "9B323C768409D641E011EE1EA543FD58")
    public void setBearingRequired(boolean bearingRequired) {
        mBearingRequired = bearingRequired;
        // ---------- Original Method ----------
        //mBearingRequired = bearingRequired;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.029 -0400", hash_original_method = "17013BC273E96D7EA584C9522A6EEB48", hash_generated_method = "F35E31E2B868FA382067E20DF4A118B3")
    public boolean isBearingRequired() {
        boolean var2AF7CBE0467BF9F76706A2F707AE0899_1033941569 = (mBearingRequired);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_183079813 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_183079813;
        // ---------- Original Method ----------
        //return mBearingRequired;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.030 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "5F1EF615AE224FDDBFF0BAD43A3F2B0C")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1738181772 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_763133121 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_763133121;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.030 -0400", hash_original_method = "F656AD17D4B37BFDE841686B6FE00CD9", hash_generated_method = "FC69A3A3CCA44B5D59BAF7FA25866C5E")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
        parcel.writeInt(mHorizontalAccuracy);
        parcel.writeInt(mVerticalAccuracy);
        parcel.writeInt(mSpeedAccuracy);
        parcel.writeInt(mBearingAccuracy);
        parcel.writeInt(mPowerRequirement);
        parcel.writeInt(mAltitudeRequired ? 1 : 0);
        parcel.writeInt(mBearingRequired ? 1 : 0);
        parcel.writeInt(mSpeedRequired ? 1 : 0);
        parcel.writeInt(mCostAllowed ? 1 : 0);
        // ---------- Original Method ----------
        //parcel.writeInt(mHorizontalAccuracy);
        //parcel.writeInt(mVerticalAccuracy);
        //parcel.writeInt(mSpeedAccuracy);
        //parcel.writeInt(mBearingAccuracy);
        //parcel.writeInt(mPowerRequirement);
        //parcel.writeInt(mAltitudeRequired ? 1 : 0);
        //parcel.writeInt(mBearingRequired ? 1 : 0);
        //parcel.writeInt(mSpeedRequired ? 1 : 0);
        //parcel.writeInt(mCostAllowed ? 1 : 0);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.030 -0400", hash_original_field = "B7D400F2964C178B086E2679800E2D89", hash_generated_field = "26610DC2B1083D7D7A6C941CAD5368F1")

    public static final int NO_REQUIREMENT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.031 -0400", hash_original_field = "AE41CE7BE0BEFEA4A6A38E49E0B398ED", hash_generated_field = "2A8F870C36199E6F65F6D3EB71E31BF0")

    public static final int POWER_LOW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.031 -0400", hash_original_field = "890CC80159603097DD27C3C84AD4AF57", hash_generated_field = "DFA9FE4C32E292E3C452D97E2C3C6CDA")

    public static final int POWER_MEDIUM = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.031 -0400", hash_original_field = "182F660573A26FA2AD27A11CD10B27F6", hash_generated_field = "38275E31E5C855126379B323DE5DD9C7")

    public static final int POWER_HIGH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.031 -0400", hash_original_field = "124724F4BB45C3449013006EF5FEA6CE", hash_generated_field = "A366216338BB755942AC27704C9B79D8")

    public static final int ACCURACY_FINE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.031 -0400", hash_original_field = "EBA62E10E6E74191D33F5BCBA6CC9B50", hash_generated_field = "DD89026FA5904F8FEA9BF61E65028781")

    public static final int ACCURACY_COARSE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.031 -0400", hash_original_field = "5E61442237B10B60E07735DE8E99BF3F", hash_generated_field = "FEEA110B2F23E156C40D0225E9C1F5E7")

    public static final int ACCURACY_LOW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.031 -0400", hash_original_field = "6A771DF807E4482FD6D3523C2295A4D1", hash_generated_field = "B88A3F805E6768C02C982D1B682E62DD")

    public static final int ACCURACY_MEDIUM = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.031 -0400", hash_original_field = "1B20A5794EC66BE757CB2A24617C63E2", hash_generated_field = "DD965F02FCC4D35F6D665F7E61154460")

    public static final int ACCURACY_HIGH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.031 -0400", hash_original_field = "40988B39F05D9D61C63D1AD45A024C82", hash_generated_field = "3FE2F16195852B6CF068FB9D971A81E2")

    public static final Parcelable.Creator<Criteria> CREATOR =
        new Parcelable.Creator<Criteria>() {
        public Criteria createFromParcel(Parcel in) {
            Criteria c = new Criteria();
            c.mHorizontalAccuracy = in.readInt();
            c.mVerticalAccuracy = in.readInt();
            c.mSpeedAccuracy = in.readInt();
            c.mBearingAccuracy = in.readInt();
            c.mPowerRequirement = in.readInt();
            c.mAltitudeRequired = in.readInt() != 0;
            c.mBearingRequired = in.readInt() != 0;
            c.mSpeedRequired = in.readInt() != 0;
            c.mCostAllowed = in.readInt() != 0;
            return c;
        }

        @DSModeled(DSC.SAFE)
        public Criteria[] newArray(int size) {
            return new Criteria[size];
        }
    };
    // orphaned legacy method
    public Criteria createFromParcel(Parcel in) {
            Criteria c = new Criteria();
            c.mHorizontalAccuracy = in.readInt();
            c.mVerticalAccuracy = in.readInt();
            c.mSpeedAccuracy = in.readInt();
            c.mBearingAccuracy = in.readInt();
            c.mPowerRequirement = in.readInt();
            c.mAltitudeRequired = in.readInt() != 0;
            c.mBearingRequired = in.readInt() != 0;
            c.mSpeedRequired = in.readInt() != 0;
            c.mCostAllowed = in.readInt() != 0;
            return c;
        }
    
    // orphaned legacy method
    public Criteria[] newArray(int size) {
            return new Criteria[size];
        }
    
}

