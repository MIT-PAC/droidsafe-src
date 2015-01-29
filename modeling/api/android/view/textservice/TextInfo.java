package android.view.textservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class TextInfo implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.025 -0400", hash_original_field = "6EEA547074FA6FFA43F36F5BBA63B9C1", hash_generated_field = "E3059B89E044EFFFEE81FFCBFDB37D6F")

    public static final Parcelable.Creator<TextInfo> CREATOR
            = new Parcelable.Creator<TextInfo>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.984 -0500", hash_original_method = "C95CDA85767E41F4E63E830DD2608E4F", hash_generated_method = "D7FF489E347355ACCB77123DCC8FEFA6")
        
@Override
        public TextInfo createFromParcel(Parcel source) {
            return new TextInfo(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.987 -0500", hash_original_method = "6BCA98C20410A9F228A60FB161EDF202", hash_generated_method = "B84C3E56B72C0DD5E6698098EE431F54")
        
@Override
        public TextInfo[] newArray(int size) {
            return new TextInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.958 -0500", hash_original_field = "5C1E1D7AA24FFCA320ADE83B66FB0AC4", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")

    private  String mText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.960 -0500", hash_original_field = "17C86C09C6C4D7B6E875B4525EC536C5", hash_generated_field = "02A3A9994454C1152633199C0FF9DCC4")

    private  int mCookie;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.963 -0500", hash_original_field = "C28E864EAE17A45901F02FA70D5B732C", hash_generated_field = "8F50649AA652CE4330E55AC6A68FCB0E")

    private  int mSequence;

    /**
     * Constructor.
     * @param text the text which will be input to TextService
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.965 -0500", hash_original_method = "A935C713B1C118E04C925F76EDA27293", hash_generated_method = "B46CBEBBC71988345535851815A1A2B8")
    
public TextInfo(String text) {
        this(text, 0, 0);
    }

    /**
     * Constructor.
     * @param text the text which will be input to TextService
     * @param cookie the cookie for this TextInfo
     * @param sequence the sequence number for this TextInfo
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.968 -0500", hash_original_method = "B3A9BFDD6561354A8432CF39635FFD52", hash_generated_method = "07897BAF061DC026422243415D88151C")
    
public TextInfo(String text, int cookie, int sequence) {
        if (TextUtils.isEmpty(text)) {
            throw new IllegalArgumentException(text);
        }
        mText = text;
        mCookie = cookie;
        mSequence = sequence;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.971 -0500", hash_original_method = "54ACC9BA5B2FD7C303374DCEBBF4E743", hash_generated_method = "B0E084E0AC7A1730EBF51F5A76111C82")
    
public TextInfo(Parcel source) {
        mText = source.readString();
        mCookie = source.readInt();
        mSequence = source.readInt();
    }

    /**
     * Used to package this object into a {@link Parcel}.
     *
     * @param dest The {@link Parcel} to be written.
     * @param flags The flags used for parceling.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.974 -0500", hash_original_method = "573D2D5BE8E27F6CA8F77B871E9B67A7", hash_generated_method = "7C2B1222BC5B65C9B69B66830A07FBC5")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mText);
        dest.writeInt(mCookie);
        dest.writeInt(mSequence);
    }

    /**
     * @return the text which is an input of a text service
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.976 -0500", hash_original_method = "2FFFCC59A442EF1196B854805331F3A7", hash_generated_method = "7675B56A832FA6E1A4872CB2A7C75222")
    
public String getText() {
        return mText;
    }

    /**
     * @return the cookie of TextInfo
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.978 -0500", hash_original_method = "AC1EDA43FC7023F4D4E1DFBFEFAF3924", hash_generated_method = "409946859A12F6C3A6BC121010CF938D")
    
public int getCookie() {
        return mCookie;
    }

    /**
     * @return the sequence of TextInfo
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.981 -0500", hash_original_method = "FE2AB8ECE26FD7A4F1B7769F13B3F465", hash_generated_method = "9FB850F0F91CCC9108C608E4BE6ED809")
    
public int getSequence() {
        return mSequence;
    }

    /**
     * Used to make this class parcelable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.991 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }
}

