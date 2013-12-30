package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Slog;





public final class InputChannel implements Parcelable {

    
    @DSModeled(DSC.SAFE)
    private static InputChannel[] nativeOpenInputChannelPair(String name) {
    	InputChannel i = new InputChannel();
    	i.addTaint(name.getTaint());
    	InputChannel[] iarr = {i};
    	return iarr;
    }
    
    /**
     * Creates a new input channel pair.  One channel should be provided to the input
     * dispatcher and the other to the application's input queue.
     * @param name The descriptive (non-unique) name of the channel pair.
     * @return A pair of input channels.  They are symmetric and indistinguishable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.385 -0500", hash_original_method = "B48C7485F97A9F9AC68CAB76CC49654C", hash_generated_method = "991C5E2D6EAFE2CBC1AEF7EF2C9E2905")
    
public static InputChannel[] openInputChannelPair(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }

        if (DEBUG) {
            Slog.d(TAG, "Opening input channel pair '" + name + "'");
        }
        return nativeOpenInputChannelPair(name);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.340 -0500", hash_original_field = "A3AFBC8DBD98C10824C3C75C8F23123A", hash_generated_field = "377094B8A738A384EF73C0C18F5AD722")

    private static final String TAG = "InputChannel";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.343 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    
    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.974 -0400", hash_original_field = "7C7ADF72FF6C232CC276E7538511A5AA", hash_generated_field = "1E8E5BA243BA0BDF86F284A9E05D652B")

    public static final Parcelable.Creator<InputChannel> CREATOR
            = new Parcelable.Creator<InputChannel>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.346 -0500", hash_original_method = "3BB57A0678E2E259E4D4569B18871435", hash_generated_method = "3C33716C68BC83EBB699B9D2A0C469DA")
        
public InputChannel createFromParcel(Parcel source) {
            InputChannel result = new InputChannel();
            result.readFromParcel(source);
            return result;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.348 -0500", hash_original_method = "C2AA7A2AF034D29E3F507E8F25F9D2CD", hash_generated_method = "1B2D18F4580205242E3CE861F5EC1EF9")
        
public InputChannel[] newArray(int size) {
            return new InputChannel[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.353 -0500", hash_original_field = "42C21A18FB5976D4C67962413781C35D", hash_generated_field = "F6CBBCA427D08C52E84BEBFADDF6C4B3")

    
    @SuppressWarnings("unused")
    private int mPtr;

    /**
     * Creates an uninitialized input channel.
     * It can be initialized by reading from a Parcel or by transferring the state of
     * another input channel into this one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.379 -0500", hash_original_method = "0BA27F691F89E713693B84FE27F01014", hash_generated_method = "D35B2854DF5C3BF5BD0B678DF456EC8A")
    
public InputChannel() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.361 -0500", hash_original_method = "94154519B1A6EA4BB0BB640C85BD9A02", hash_generated_method = "5D30F67E0226CDCF475AEF93B871CE0A")
    
    private void nativeDispose(boolean finalized){
    	//Formerly a native method
    	addTaint(finalized);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.365 -0500", hash_original_method = "799DA83596ED16E96D78A1B89899E0CA", hash_generated_method = "BD592B7066D3493771F751F7863D1F53")
    
    private void nativeTransferTo(InputChannel other){
    	//Formerly a native method
    	addTaint(other.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.369 -0500", hash_original_method = "CB18D1AF1302EC392F144D01425C9ED8", hash_generated_method = "AA6DFDCC8316FCF6C68C857459A11555")
    
    private void nativeReadFromParcel(Parcel parcel){
    	//Formerly a native method
    	addTaint(parcel.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.373 -0500", hash_original_method = "0C3EF2E831F019E30F5E266ABBEB1FCD", hash_generated_method = "1E7F17F566678CAC2AC2E8FB5AD98A9C")
    
    private void nativeWriteToParcel(Parcel parcel){
    	//Formerly a native method
    	addTaint(parcel.getTaint());
    }


    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.950 -0400", hash_original_method = "CA39384861C04125EB204839D7970E78", hash_generated_method = "55C683646032EAF5E4A7B598D440C2F0")
    private String nativeGetName() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.383 -0500", hash_original_method = "AAF6A8EEDB66DCFEB1E035B63F14BAD7", hash_generated_method = "8BB93E376E86DC2554CEB4CC1E5FB6B8")
    
@Override
    protected void finalize() throws Throwable {
        try {
            nativeDispose(true);
        } finally {
            super.finalize();
        }
    }
    
    /**
     * Gets the name of the input channel.
     * @return The input channel name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.388 -0500", hash_original_method = "DD120B8650E4DAC77C83EEDB526B0BAD", hash_generated_method = "2E7B6BF32866DEF297339CCFE34F1FFA")
    
public String getName() {
        String name = nativeGetName();
        return name != null ? name : "uninitialized";
    }

    /**
     * Disposes the input channel.
     * Explicitly releases the reference this object is holding on the input channel.
     * When all references are released, the input channel will be closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.390 -0500", hash_original_method = "55D32946D61D585CF9CB8D4DE0F8875C", hash_generated_method = "F651B33C5F1F4A3D6588D50A91443375")
    
public void dispose() {
        nativeDispose(false);
    }
    
    /**
     * Transfers ownership of the internal state of the input channel to another
     * instance and invalidates this instance.  This is used to pass an input channel
     * as an out parameter in a binder call.
     * @param other The other input channel instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.392 -0500", hash_original_method = "56717C4466E220164D65DBB18C5ECF92", hash_generated_method = "2E212131A24D5A272E84C349FE7D0F17")
    
public void transferTo(InputChannel outParameter) {
        if (outParameter == null) {
            throw new IllegalArgumentException("outParameter must not be null");
        }
        
        nativeTransferTo(outParameter);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.395 -0500", hash_original_method = "5C5A30224996A2D414D9176559E683A9", hash_generated_method = "21B90FA3BEA6E09C036B9A91E6B4B68C")
    
public int describeContents() {
        return Parcelable.CONTENTS_FILE_DESCRIPTOR;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.397 -0500", hash_original_method = "60688696539354D4CAC238797E17CD4A", hash_generated_method = "C60FEDAEE2027385AB7F95C9679C6EFB")
    
public void readFromParcel(Parcel in) {
        if (in == null) {
            throw new IllegalArgumentException("in must not be null");
        }
        
        nativeReadFromParcel(in);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.399 -0500", hash_original_method = "A30FA9E3CB51C121BDB664DAA1EA96F9", hash_generated_method = "EE8C3B3A12323EEE806BACAE9BC7227C")
    
public void writeToParcel(Parcel out, int flags) {
        if (out == null) {
            throw new IllegalArgumentException("out must not be null");
        }
        
        nativeWriteToParcel(out);
        
        if ((flags & PARCELABLE_WRITE_RETURN_VALUE) != 0) {
            dispose();
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.402 -0500", hash_original_method = "EF513D06BF396F11B9CE8E1C6BA16499", hash_generated_method = "3EA8038E69A7E959224FDB2C00D29148")
    
@Override
    public String toString() {
        return getName();
    }
    // orphaned legacy method
    public InputChannel createFromParcel(Parcel source) {
            InputChannel result = new InputChannel();
            result.readFromParcel(source);
            return result;
        }
    
    // orphaned legacy method
    public InputChannel[] newArray(int size) {
            return new InputChannel[size];
        }
    
}

