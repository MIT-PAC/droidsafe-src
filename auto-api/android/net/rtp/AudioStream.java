package android.net.rtp;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.InetAddress;
import java.net.SocketException;

public class AudioStream extends RtpStream {
    private AudioCodec mCodec;
    private int mDtmfType = -1;
    private AudioGroup mGroup;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.139 -0400", hash_original_method = "409408EC0859D4060DA7CEF5328B7220", hash_generated_method = "FD963E3D97E4DB8311DB8079554BA47B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AudioStream(InetAddress address) throws SocketException {
        super(address);
        dsTaint.addTaint(address.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.139 -0400", hash_original_method = "254DAECE553220B60B3DDCDB0D3A9A7B", hash_generated_method = "D86B945AE603F7E0143CA9BF99716A7C")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isBusy() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mGroup != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.139 -0400", hash_original_method = "477F536A3076B0B10A19072AA2686CEC", hash_generated_method = "4A046F841951266BBDF495B1FD8B0195")
    @DSModeled(DSC.SAFE)
    public AudioGroup getGroup() {
        return (AudioGroup)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mGroup;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.139 -0400", hash_original_method = "119D45B9BF5FF64C97C7293B3DF5F7E3", hash_generated_method = "D42B41A0F5E73B25204ADF1D2DDDB1D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void join(AudioGroup group) {
        dsTaint.addTaint(group.dsTaint);
        {
            {
                mGroup.remove(this);
                mGroup = null;
            } //End block
            {
                group.add(this, mCodec, mDtmfType);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mGroup == group) {
                //return;
            //}
            //if (mGroup != null) {
                //mGroup.remove(this);
                //mGroup = null;
            //}
            //if (group != null) {
                //group.add(this, mCodec, mDtmfType);
                //mGroup = group;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.139 -0400", hash_original_method = "477233579E49B9ACBFE0DA40A2D8DF9C", hash_generated_method = "8F395BAB723BEC0E0A187CCFD643FCC1")
    @DSModeled(DSC.SAFE)
    public AudioCodec getCodec() {
        return (AudioCodec)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCodec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.140 -0400", hash_original_method = "E0A36AFBD97A7B298B1941948E16CA1A", hash_generated_method = "6F4497609F32694538B64594DA68CE69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCodec(AudioCodec codec) {
        dsTaint.addTaint(codec.dsTaint);
        {
            boolean var6331CCDC5360782724F2E909851BBC53_1645384483 = (isBusy());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Busy");
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The type is used by DTMF");
        } //End block
        // ---------- Original Method ----------
        //if (isBusy()) {
            //throw new IllegalStateException("Busy");
        //}
        //if (codec.type == mDtmfType) {
            //throw new IllegalArgumentException("The type is used by DTMF");
        //}
        //mCodec = codec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.140 -0400", hash_original_method = "67DA2B7B029AD6BDA2A522BA945FCCC7", hash_generated_method = "FA98267BEFC9D69C6B49E9FEEF6EA95D")
    @DSModeled(DSC.SAFE)
    public int getDtmfType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDtmfType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.140 -0400", hash_original_method = "08CFB9D3491C3CF797064DF404EB556C", hash_generated_method = "A57853C2989B9B325F8AB7BBC896A23B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDtmfType(int type) {
        dsTaint.addTaint(type);
        {
            boolean var6331CCDC5360782724F2E909851BBC53_1889385636 = (isBusy());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Busy");
            } //End block
        } //End collapsed parenthetic
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid type");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The type is used by codec");
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (isBusy()) {
            //throw new IllegalStateException("Busy");
        //}
        //if (type != -1) {
            //if (type < 96 || type > 127) {
                //throw new IllegalArgumentException("Invalid type");
            //}
            //if (type == mCodec.type) {
                //throw new IllegalArgumentException("The type is used by codec");
            //}
        //}
        //mDtmfType = type;
    }

    
}

