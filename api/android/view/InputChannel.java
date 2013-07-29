package android.view;

// Droidsafe Imports
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Slog;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class InputChannel implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.972 -0400", hash_original_field = "34F930F150EAEEFF27D6C0C8E4629911", hash_generated_field = "F6CBBCA427D08C52E84BEBFADDF6C4B3")

    @SuppressWarnings("unused") private int mPtr;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.972 -0400", hash_original_method = "0BA27F691F89E713693B84FE27F01014", hash_generated_method = "ED243824FEFC4B413411561FA4FF02D0")
    public  InputChannel() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    private static InputChannel[] nativeOpenInputChannelPair(String name) {
    	InputChannel i = new InputChannel();
    	i.addTaint(name.getTaint());
    	InputChannel[] iarr = {i};
    	return iarr;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.972 -0400", hash_original_method = "94154519B1A6EA4BB0BB640C85BD9A02", hash_generated_method = "6C7C0E61BCDFCC694DC91C268DE99361")
    private void nativeDispose(boolean finalized) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.972 -0400", hash_original_method = "799DA83596ED16E96D78A1B89899E0CA", hash_generated_method = "43DD19AFEED002ACDDA5EE5C126D0199")
    private void nativeTransferTo(InputChannel other) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.972 -0400", hash_original_method = "CB18D1AF1302EC392F144D01425C9ED8", hash_generated_method = "2C38BCBB39AFEAF9135E868F8C4B1983")
    private void nativeReadFromParcel(Parcel parcel) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.972 -0400", hash_original_method = "0C3EF2E831F019E30F5E266ABBEB1FCD", hash_generated_method = "29CBDFA8F1245A477428080B155FEC70")
    private void nativeWriteToParcel(Parcel parcel) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.950 -0400", hash_original_method = "CA39384861C04125EB204839D7970E78", hash_generated_method = "55C683646032EAF5E4A7B598D440C2F0")
    private String nativeGetName() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.973 -0400", hash_original_method = "AAF6A8EEDB66DCFEB1E035B63F14BAD7", hash_generated_method = "7B07B9CB0BB6168167263DFA5C36C7E7")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            nativeDispose(true);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //nativeDispose(true);
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    public static InputChannel[] openInputChannelPair(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        if (DEBUG) {
            Slog.d(TAG, "Opening input channel pair '" + name + "'");
        }
        return nativeOpenInputChannelPair(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.973 -0400", hash_original_method = "DD120B8650E4DAC77C83EEDB526B0BAD", hash_generated_method = "92966C322F1477BE4CC5BD2E0BF0B480")
    public String getName() {
        String name = nativeGetName();
String var5F98A75DFF64F33CE8AE40C1B031DA81_613098005 =         name != null ? name : "uninitialized";
        var5F98A75DFF64F33CE8AE40C1B031DA81_613098005.addTaint(taint);
        return var5F98A75DFF64F33CE8AE40C1B031DA81_613098005;
        // ---------- Original Method ----------
        //String name = nativeGetName();
        //return name != null ? name : "uninitialized";
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.973 -0400", hash_original_method = "55D32946D61D585CF9CB8D4DE0F8875C", hash_generated_method = "DBF3738A56ED3C108DB00E89DD16E55E")
    public void dispose() {
        nativeDispose(false);
        // ---------- Original Method ----------
        //nativeDispose(false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.973 -0400", hash_original_method = "56717C4466E220164D65DBB18C5ECF92", hash_generated_method = "1CF7A7EA753F3285A5155A3552DE34D8")
    public void transferTo(InputChannel outParameter) {
        addTaint(outParameter.getTaint());
        if(outParameter == null)        
        {
            IllegalArgumentException varD9250E46A2F98FC88D0000C296D41C41_36474517 = new IllegalArgumentException("outParameter must not be null");
            varD9250E46A2F98FC88D0000C296D41C41_36474517.addTaint(taint);
            throw varD9250E46A2F98FC88D0000C296D41C41_36474517;
        } //End block
        nativeTransferTo(outParameter);
        // ---------- Original Method ----------
        //if (outParameter == null) {
            //throw new IllegalArgumentException("outParameter must not be null");
        //}
        //nativeTransferTo(outParameter);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.973 -0400", hash_original_method = "5C5A30224996A2D414D9176559E683A9", hash_generated_method = "779F29758B72D97385402AC4E59D4C79")
    public int describeContents() {
        int var7D45AD2A24206A9DE492E2B68DB53120_1970148315 = (Parcelable.CONTENTS_FILE_DESCRIPTOR);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_262590718 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_262590718;
        // ---------- Original Method ----------
        //return Parcelable.CONTENTS_FILE_DESCRIPTOR;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.973 -0400", hash_original_method = "60688696539354D4CAC238797E17CD4A", hash_generated_method = "1ED7DD0906F7C8007B43B1CC54098A70")
    public void readFromParcel(Parcel in) {
        addTaint(in.getTaint());
        if(in == null)        
        {
            IllegalArgumentException var9F2CAB2C9FA1AB78A1F18FEDA7916E37_559645080 = new IllegalArgumentException("in must not be null");
            var9F2CAB2C9FA1AB78A1F18FEDA7916E37_559645080.addTaint(taint);
            throw var9F2CAB2C9FA1AB78A1F18FEDA7916E37_559645080;
        } //End block
        nativeReadFromParcel(in);
        // ---------- Original Method ----------
        //if (in == null) {
            //throw new IllegalArgumentException("in must not be null");
        //}
        //nativeReadFromParcel(in);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.973 -0400", hash_original_method = "A30FA9E3CB51C121BDB664DAA1EA96F9", hash_generated_method = "647004986783C6EB9F1A4A1ED40C9E6F")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        if(out == null)        
        {
            IllegalArgumentException var2DC484913D6FF5E7A0EB68FD588375DC_771610523 = new IllegalArgumentException("out must not be null");
            var2DC484913D6FF5E7A0EB68FD588375DC_771610523.addTaint(taint);
            throw var2DC484913D6FF5E7A0EB68FD588375DC_771610523;
        } //End block
        nativeWriteToParcel(out);
        if((flags & PARCELABLE_WRITE_RETURN_VALUE) != 0)        
        {
            dispose();
        } //End block
        // ---------- Original Method ----------
        //if (out == null) {
            //throw new IllegalArgumentException("out must not be null");
        //}
        //nativeWriteToParcel(out);
        //if ((flags & PARCELABLE_WRITE_RETURN_VALUE) != 0) {
            //dispose();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.973 -0400", hash_original_method = "EF513D06BF396F11B9CE8E1C6BA16499", hash_generated_method = "77EC63FB9BA5FAE1A3AB9CFCBDEE9CC1")
    @Override
    public String toString() {
String var674CAC8E34E5C6C4D042792BFADA198C_522387628 =         getName();
        var674CAC8E34E5C6C4D042792BFADA198C_522387628.addTaint(taint);
        return var674CAC8E34E5C6C4D042792BFADA198C_522387628;
        // ---------- Original Method ----------
        //return getName();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.973 -0400", hash_original_field = "B698A68630D878F4CEBCB79306407DDB", hash_generated_field = "377094B8A738A384EF73C0C18F5AD722")

    private static final String TAG = "InputChannel";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.974 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.974 -0400", hash_original_field = "7C7ADF72FF6C232CC276E7538511A5AA", hash_generated_field = "1E8E5BA243BA0BDF86F284A9E05D652B")

    public static final Parcelable.Creator<InputChannel> CREATOR
            = new Parcelable.Creator<InputChannel>() {
        public InputChannel createFromParcel(Parcel source) {
            InputChannel result = new InputChannel();
            result.readFromParcel(source);
            return result;
        }
        
        public InputChannel[] newArray(int size) {
            return new InputChannel[size];
        }
    };
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

