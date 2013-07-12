package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Slog;

public final class InputChannel implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.800 -0400", hash_original_field = "34F930F150EAEEFF27D6C0C8E4629911", hash_generated_field = "F6CBBCA427D08C52E84BEBFADDF6C4B3")

    @SuppressWarnings("unused") private int mPtr;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.800 -0400", hash_original_method = "0BA27F691F89E713693B84FE27F01014", hash_generated_method = "ED243824FEFC4B413411561FA4FF02D0")
    public  InputChannel() {
        
    }

    
    @DSModeled(DSC.SAFE)
    private static InputChannel[] nativeOpenInputChannelPair(String name) {
    	InputChannel i = new InputChannel();
    	i.addTaint(name.getTaint());
    	InputChannel[] iarr = {i};
    	return iarr;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.800 -0400", hash_original_method = "94154519B1A6EA4BB0BB640C85BD9A02", hash_generated_method = "6C7C0E61BCDFCC694DC91C268DE99361")
    private void nativeDispose(boolean finalized) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.800 -0400", hash_original_method = "799DA83596ED16E96D78A1B89899E0CA", hash_generated_method = "43DD19AFEED002ACDDA5EE5C126D0199")
    private void nativeTransferTo(InputChannel other) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.800 -0400", hash_original_method = "CB18D1AF1302EC392F144D01425C9ED8", hash_generated_method = "2C38BCBB39AFEAF9135E868F8C4B1983")
    private void nativeReadFromParcel(Parcel parcel) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.800 -0400", hash_original_method = "0C3EF2E831F019E30F5E266ABBEB1FCD", hash_generated_method = "29CBDFA8F1245A477428080B155FEC70")
    private void nativeWriteToParcel(Parcel parcel) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.950 -0400", hash_original_method = "CA39384861C04125EB204839D7970E78", hash_generated_method = "55C683646032EAF5E4A7B598D440C2F0")
    private String nativeGetName() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.801 -0400", hash_original_method = "AAF6A8EEDB66DCFEB1E035B63F14BAD7", hash_generated_method = "7B07B9CB0BB6168167263DFA5C36C7E7")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            nativeDispose(true);
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
        
            
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.801 -0400", hash_original_method = "DD120B8650E4DAC77C83EEDB526B0BAD", hash_generated_method = "5A4F738B0BF9B818D70ADD14C03C0E40")
    public String getName() {
        String name = nativeGetName();
String var5F98A75DFF64F33CE8AE40C1B031DA81_1646692075 =         name != null ? name : "uninitialized";
        var5F98A75DFF64F33CE8AE40C1B031DA81_1646692075.addTaint(taint);
        return var5F98A75DFF64F33CE8AE40C1B031DA81_1646692075;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.801 -0400", hash_original_method = "55D32946D61D585CF9CB8D4DE0F8875C", hash_generated_method = "DBF3738A56ED3C108DB00E89DD16E55E")
    public void dispose() {
        nativeDispose(false);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.801 -0400", hash_original_method = "56717C4466E220164D65DBB18C5ECF92", hash_generated_method = "DE56365A787DDD9B0BA083E1F2C4508B")
    public void transferTo(InputChannel outParameter) {
        addTaint(outParameter.getTaint());
    if(outParameter == null)        
        {
            IllegalArgumentException varD9250E46A2F98FC88D0000C296D41C41_623738988 = new IllegalArgumentException("outParameter must not be null");
            varD9250E46A2F98FC88D0000C296D41C41_623738988.addTaint(taint);
            throw varD9250E46A2F98FC88D0000C296D41C41_623738988;
        } 
        nativeTransferTo(outParameter);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.801 -0400", hash_original_method = "5C5A30224996A2D414D9176559E683A9", hash_generated_method = "EBBC4FA159D7EBD1CF1491A78BD2F1D5")
    public int describeContents() {
        int var7D45AD2A24206A9DE492E2B68DB53120_35964028 = (Parcelable.CONTENTS_FILE_DESCRIPTOR);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_220045122 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_220045122;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.801 -0400", hash_original_method = "60688696539354D4CAC238797E17CD4A", hash_generated_method = "C9428C75646B7D7482ED860CA1DBB3C6")
    public void readFromParcel(Parcel in) {
        addTaint(in.getTaint());
    if(in == null)        
        {
            IllegalArgumentException var9F2CAB2C9FA1AB78A1F18FEDA7916E37_1111477181 = new IllegalArgumentException("in must not be null");
            var9F2CAB2C9FA1AB78A1F18FEDA7916E37_1111477181.addTaint(taint);
            throw var9F2CAB2C9FA1AB78A1F18FEDA7916E37_1111477181;
        } 
        nativeReadFromParcel(in);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.801 -0400", hash_original_method = "A30FA9E3CB51C121BDB664DAA1EA96F9", hash_generated_method = "41078E272C7E5238717D086F85C485E8")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
    if(out == null)        
        {
            IllegalArgumentException var2DC484913D6FF5E7A0EB68FD588375DC_1098115438 = new IllegalArgumentException("out must not be null");
            var2DC484913D6FF5E7A0EB68FD588375DC_1098115438.addTaint(taint);
            throw var2DC484913D6FF5E7A0EB68FD588375DC_1098115438;
        } 
        nativeWriteToParcel(out);
    if((flags & PARCELABLE_WRITE_RETURN_VALUE) != 0)        
        {
            dispose();
        } 
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.802 -0400", hash_original_method = "EF513D06BF396F11B9CE8E1C6BA16499", hash_generated_method = "E8874982ED45207C0F8E52F67633D7B0")
    @Override
    public String toString() {
String var674CAC8E34E5C6C4D042792BFADA198C_1497751061 =         getName();
        var674CAC8E34E5C6C4D042792BFADA198C_1497751061.addTaint(taint);
        return var674CAC8E34E5C6C4D042792BFADA198C_1497751061;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.802 -0400", hash_original_field = "B698A68630D878F4CEBCB79306407DDB", hash_generated_field = "377094B8A738A384EF73C0C18F5AD722")

    private static final String TAG = "InputChannel";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.802 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.802 -0400", hash_original_field = "7C7ADF72FF6C232CC276E7538511A5AA", hash_generated_field = "1E8E5BA243BA0BDF86F284A9E05D652B")

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
    
    public InputChannel createFromParcel(Parcel source) {
            InputChannel result = new InputChannel();
            result.readFromParcel(source);
            return result;
        }
    
    
    public InputChannel[] newArray(int size) {
            return new InputChannel[size];
        }
    
}

