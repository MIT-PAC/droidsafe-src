package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Slog;

public final class InputChannel implements Parcelable {
    @SuppressWarnings("unused") private int mPtr;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.860 -0400", hash_original_method = "0BA27F691F89E713693B84FE27F01014", hash_generated_method = "ED243824FEFC4B413411561FA4FF02D0")
    @DSModeled(DSC.SAFE)
    public InputChannel() {
        // ---------- Original Method ----------
    }

    
        private static InputChannel[] nativeOpenInputChannelPair(String name) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.860 -0400", hash_original_method = "94154519B1A6EA4BB0BB640C85BD9A02", hash_generated_method = "CFD52324E464B8722904AF4E20A8363D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeDispose(boolean finalized) {
        dsTaint.addTaint(finalized);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.860 -0400", hash_original_method = "799DA83596ED16E96D78A1B89899E0CA", hash_generated_method = "47A4D5460903EFEDF78C827025236AC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeTransferTo(InputChannel other) {
        dsTaint.addTaint(other.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.861 -0400", hash_original_method = "CB18D1AF1302EC392F144D01425C9ED8", hash_generated_method = "EAC06E7436CC466B8F985BE0EDEB6BF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeReadFromParcel(Parcel parcel) {
        dsTaint.addTaint(parcel.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.861 -0400", hash_original_method = "0C3EF2E831F019E30F5E266ABBEB1FCD", hash_generated_method = "8BFF9687323E423D18BE2BBB2A7D8599")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeWriteToParcel(Parcel parcel) {
        dsTaint.addTaint(parcel.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.861 -0400", hash_original_method = "CA39384861C04125EB204839D7970E78", hash_generated_method = "DDF4F0657A5DB192CC526E9FFF6BE46B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeGetName() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.861 -0400", hash_original_method = "AAF6A8EEDB66DCFEB1E035B63F14BAD7", hash_generated_method = "7B07B9CB0BB6168167263DFA5C36C7E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
        public static InputChannel[] openInputChannelPair(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        if (DEBUG) {
            Slog.d(TAG, "Opening input channel pair '" + name + "'");
        }
        return nativeOpenInputChannelPair(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.861 -0400", hash_original_method = "DD120B8650E4DAC77C83EEDB526B0BAD", hash_generated_method = "A9CCD3BE6E8A36FF7E9CDE8CCE15F52D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getName() {
        String name;
        name = nativeGetName();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String name = nativeGetName();
        //return name != null ? name : "uninitialized";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.862 -0400", hash_original_method = "55D32946D61D585CF9CB8D4DE0F8875C", hash_generated_method = "DBF3738A56ED3C108DB00E89DD16E55E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispose() {
        nativeDispose(false);
        // ---------- Original Method ----------
        //nativeDispose(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.862 -0400", hash_original_method = "56717C4466E220164D65DBB18C5ECF92", hash_generated_method = "9835316AF35893C8149C3BE902541978")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void transferTo(InputChannel outParameter) {
        dsTaint.addTaint(outParameter.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("outParameter must not be null");
        } //End block
        nativeTransferTo(outParameter);
        // ---------- Original Method ----------
        //if (outParameter == null) {
            //throw new IllegalArgumentException("outParameter must not be null");
        //}
        //nativeTransferTo(outParameter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.862 -0400", hash_original_method = "5C5A30224996A2D414D9176559E683A9", hash_generated_method = "FC3B912957A2E65031C97112DB7F5A46")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Parcelable.CONTENTS_FILE_DESCRIPTOR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.862 -0400", hash_original_method = "60688696539354D4CAC238797E17CD4A", hash_generated_method = "9FAA0170BBF69813B4C09BB705E7E0C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("in must not be null");
        } //End block
        nativeReadFromParcel(in);
        // ---------- Original Method ----------
        //if (in == null) {
            //throw new IllegalArgumentException("in must not be null");
        //}
        //nativeReadFromParcel(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.863 -0400", hash_original_method = "A30FA9E3CB51C121BDB664DAA1EA96F9", hash_generated_method = "949B7E7C502E21B0B12EEF1806E6EAC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("out must not be null");
        } //End block
        nativeWriteToParcel(out);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.863 -0400", hash_original_method = "EF513D06BF396F11B9CE8E1C6BA16499", hash_generated_method = "F496CD1FD2510A6CB286D3120A82F1C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var5032DEC29B552A5D605BC7E38765B26B_44963877 = (getName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getName();
    }

    
    private static final String TAG = "InputChannel";
    private static final boolean DEBUG = false;
    public static final Parcelable.Creator<InputChannel> CREATOR = new Parcelable.Creator<InputChannel>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.863 -0400", hash_original_method = "3BB57A0678E2E259E4D4569B18871435", hash_generated_method = "17F62C43FD3F7FE8A1BF387037A37C33")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InputChannel createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            InputChannel result;
            result = new InputChannel();
            result.readFromParcel(source);
            return (InputChannel)dsTaint.getTaint();
            // ---------- Original Method ----------
            //InputChannel result = new InputChannel();
            //result.readFromParcel(source);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.863 -0400", hash_original_method = "C2AA7A2AF034D29E3F507E8F25F9D2CD", hash_generated_method = "937ABECCBDBE7C5ED04BBE95DE1773AC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InputChannel[] newArray(int size) {
            dsTaint.addTaint(size);
            InputChannel[] varD3D9ED592B2F4EA60D3DF1039656F9A2_850659461 = (new InputChannel[size]);
            return (InputChannel[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InputChannel[size];
        }

        
}; //Transformed anonymous class
}

