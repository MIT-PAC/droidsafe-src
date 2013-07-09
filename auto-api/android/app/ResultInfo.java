package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Bundle;
import java.util.Map;

public class ResultInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.991 -0400", hash_original_field = "344245CF6F3FB0EF7E71D82B314565C8", hash_generated_field = "9751D4E955A56AA5356026C082D57D65")

    public String mResultWho;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.991 -0400", hash_original_field = "86891437037662D667B835C6AB354174", hash_generated_field = "85DF646F4249AC1D2BDB38637924C61D")

    public int mRequestCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.991 -0400", hash_original_field = "E5CED19E692744D577EC9F38B767773F", hash_generated_field = "C5F755BFBAC5FACAF96067E93F13F919")

    public int mResultCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.991 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "44EE18239FF473343B1B4A3246CBC87D")

    public Intent mData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.992 -0400", hash_original_method = "5613E3DAA5C00F0B9643F3F13EB312FC", hash_generated_method = "7996DAB0AC864885B2CBAC135A1A1795")
    public  ResultInfo(String resultWho, int requestCode, int resultCode,
            Intent data) {
        mResultWho = resultWho;
        mRequestCode = requestCode;
        mResultCode = resultCode;
        mData = data;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.992 -0400", hash_original_method = "96F78670445F12E6C74BEEDC3D49BD9C", hash_generated_method = "FCFF0F9F6710DB8DE82CC6469372A8D1")
    public  ResultInfo(Parcel in) {
        mResultWho = in.readString();
        mRequestCode = in.readInt();
        mResultCode = in.readInt();
        {
            boolean var25D67F28E4887DDC152DCB9726EAB4D3_1088975851 = (in.readInt() != 0);
            {
                mData = Intent.CREATOR.createFromParcel(in);
            } 
            {
                mData = null;
            } 
        } 
        
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.993 -0400", hash_original_method = "45459039AB19A0482EB7D8EB8705A318", hash_generated_method = "630E4398BC7BFC938B3F72E871DD0E75")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1386252514 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1386252514 = "ResultInfo{who=" + mResultWho + ", request=" + mRequestCode
            + ", result=" + mResultCode + ", data=" + mData + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1386252514.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1386252514;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.994 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "16E122B4E4C858F89988828243DFB52B")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_540248404 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_540248404;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.995 -0400", hash_original_method = "C00CE2610591477E96DECA81C0021A12", hash_generated_method = "B1BFE7759F145E81AF523935B785959B")
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mResultWho);
        out.writeInt(mRequestCode);
        out.writeInt(mResultCode);
        {
            out.writeInt(1);
            mData.writeToParcel(out, 0);
        } 
        {
            out.writeInt(0);
        } 
        addTaint(out.getTaint());
        addTaint(flags);
        
        
        
        
        
            
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.995 -0400", hash_original_field = "0AD537D7B4AC3F7C300248CFF3FC2AEF", hash_generated_field = "D13876AA40E0BEAA5F9CE88B0DEDE86A")

    public static final Parcelable.Creator<ResultInfo> CREATOR
            = new Parcelable.Creator<ResultInfo>() {
        public ResultInfo createFromParcel(Parcel in) {
            return new ResultInfo(in);
        }

        public ResultInfo[] newArray(int size) {
            return new ResultInfo[size];
        }
    };
    
    public ResultInfo createFromParcel(Parcel in) {
            return new ResultInfo(in);
        }
    
    
    public ResultInfo[] newArray(int size) {
            return new ResultInfo[size];
        }
    
}

