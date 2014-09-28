package com.google.android.gms.drive;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import android.os.Parcelable.Creator;

public class Contents implements com.google.android.gms.common.internal.safeparcel.SafeParcelable
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.920 -0400", hash_original_field = "1895632691E3D0ACD93635E7B4E629BC", hash_generated_field = "1895632691E3D0ACD93635E7B4E629BC")

     int xM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.924 -0400", hash_original_field = "7D44FC9D8C14CFDE6CF88F30981A993D", hash_generated_field = "7D44FC9D8C14CFDE6CF88F30981A993D")

     ParcelFileDescriptor Fj;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.928 -0400", hash_original_field = "D36DF6FE11CA0AA3C4753B985A4181B5", hash_generated_field = "D36DF6FE11CA0AA3C4753B985A4181B5")

     int ra;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.932 -0400", hash_original_field = "2891B6038FB4C3E766373CF38DFBB5F7", hash_generated_field = "2891B6038FB4C3E766373CF38DFBB5F7")

     int Hy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.936 -0400", hash_original_field = "910B21623053D60ED36D74617E9A01AA", hash_generated_field = "910B21623053D60ED36D74617E9A01AA")

     DriveId Hz;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.940 -0400", hash_original_field = "8DA8B8B8407103457E4BEFA910ED2904", hash_generated_field = "8DA8B8B8407103457E4BEFA910ED2904")

    String HA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.944 -0400", hash_original_field = "3661ED47578856C0975A5AC05548F72B", hash_generated_field = "3661ED47578856C0975A5AC05548F72B")

    boolean HB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.948 -0400", hash_original_field = "56ECBEBCC8BAA6BB3E13A5DE04356F54", hash_generated_field = "BD690B26D5468868AFAF08CAFB003D2A")

    private boolean mClosed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.952 -0400", hash_original_field = "45E56E0A36F9317E7FF451DA4C0D6659", hash_generated_field = "020FEBD5EE122DB5CC40C2FE12FB577A")

    private boolean HC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.956 -0400", hash_original_field = "83831A6DD8FAC2A842BE6C6EB73F117E", hash_generated_field = "7B7E4369D5ECB6E5791A2ACA90D3F3BC")

    private boolean HD;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.960 -0400", hash_original_field = "F0EA6F81DA2D33981D1C38F834A89171", hash_generated_field = "428E950F931FCEEE7629E7B6E1A5459C")

    private boolean HE;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.974 -0400", hash_original_method = "480B3E3B0F11B3D949E994083DDBDD83", hash_generated_method = "480B3E3B0F11B3D949E994083DDBDD83")
    
Contents(int  i0, ParcelFileDescriptor  r1, int  i1, int  i2, DriveId  r2, String  r3, boolean  z0)
    {

        mClosed = false;
        HC = false;
        HD = false;
        HE = false;
        xM = i0;
        Fj = r1;
        ra = i1;
        Hy = i2;
        Hz = r2;
        HA = r3;
        HB = z0;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.963 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents()
    {

        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.967 -0400", hash_original_method = "A5A23D2AA3685D8D76199C8059690279", hash_generated_method = "BC917CE6A443E0AE76AEDDE8E0D683E2")
    
public void writeToParcel(Parcel  r1, int  i0)
    {
    	r1.writeInt(i0);
    	r1.writeInt(ra);
    	r1.writeInt(xM);
    	r1.writeString(HA); 
    	r1.writeInt(toTaintInt(HB));
    	r1.writeInt(toTaintInt(HC));
    	r1.writeInt(toTaintInt(HD));
    	r1.writeInt(toTaintInt(mClosed));
    	r1.writeInt(Hy);
    	r1.writeInt(Hz.getTaintInt());

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.978 -0400", hash_original_method = "8DE7F84DECAFF425BF82654097A23DD9", hash_generated_method = "3796AA904121B66F83AA77AB72A729C9")
    
public ParcelFileDescriptor getParcelFileDescriptor()
    {
        if ( ! (mClosed))
        {
            return Fj;
        }

        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.983 -0400", hash_original_method = "316D0BA3D089155B54F3410EB3C37C3B", hash_generated_method = "221392C771368EF2EB490E3FA9E063BB")
    
public DriveId getDriveId()
    {

        return Hz;
    }

    @DSSource({DSSourceKind. GOOGLE_SERVICES})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.989 -0400", hash_original_method = "D8B6F24D6CE84AA5B472A5A054CBF9C5", hash_generated_method = "AF2BDE2213F5B0AC04144304F8ED91D9")
    
public InputStream getInputStream()
    {

        if ( ! (mClosed))
        {
            if (Hy == 268435456)
            {
                if ( ! (HC))
                {
                    HC = true;
                    return new FileInputStream(Fj.getFileDescriptor());
                }

                throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
            }
            else
            {
                throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
            }
        }
        else
        {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.995 -0400", hash_original_method = "EEAF894971DD204B63F1B170A7894732", hash_generated_method = "B552507038AAEA6B7B7E74F58D426C6F")
    
public OutputStream getOutputStream()
    {

        if ( ! (mClosed))
        {
            if (Hy == 536870912)
            {
                if ( ! (HD))
                {
                    HD = true;
                    return new FileOutputStream(Fj.getFileDescriptor());
                }

                throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
            }
            else
            {
                throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
            }
        }
        else
        {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.999 -0400", hash_original_method = "CA31EE8F82010738A60158DC0DFF9B4E", hash_generated_method = "DE3587680D5C17E9D6B865B81EC4B070")
    
public int getMode()
    {

        return Hy;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.004 -0400", hash_original_method = "BCF0C017E502FCDE1FDDFABD050D3F83", hash_generated_method = "F5B3C5CF741B1DADC7E236990FA6144B")
    
public int getRequestId()
    {

        return ra;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.007 -0400", hash_original_method = "6BEF5FA7BF5F9CDB77788A0486DCB486", hash_generated_method = "AD34821351246F35D4C40153EDEF54E2")
    
public void close()
    {

        mClosed = true;
    }
    
    public static final Creator<Contents> CREATOR = new Creator<Contents>() {

		@Override
		@DSVerified
		@DSSafe(DSCat.SAFE_LIST)
		public Contents createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			source.readString();
			DriveId id = new DriveId(source.readString(), source.readLong(), 0);
			return new Contents(source.readInt(), 
								source.readFileDescriptor(),
								source.readInt(),
								source.readInt(),
								id, 
								source.readString(),
								false);
		}

		@Override
		@DSVerified
		@DSSpec(DSCat.ABSTRACT_METHOD)
		public Contents[] newArray(int size) {
			// TODO Auto-generated method stub
			Contents[] contents = new Contents[1];
			contents[0] = new Contents(DSUtils.FAKE_INT,
								(ParcelFileDescriptor)null,
								DSUtils.FAKE_INT,
								DSUtils.FAKE_INT,
								null,
								DSUtils.FAKE_STRING,
								DSUtils.UNKNOWN_BOOLEAN);
			return contents;
		}
    	
    };
    
}
