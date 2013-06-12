package android.net.rtp;

// Droidsafe Imports
import java.net.InetAddress;
import java.net.SocketException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class AudioStream extends RtpStream {
    private AudioCodec mCodec;
    private int mDtmfType = -1;
    private AudioGroup mGroup;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.286 -0400", hash_original_method = "409408EC0859D4060DA7CEF5328B7220", hash_generated_method = "A5A9C0EE3810C0D5559C88D0F19677B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AudioStream(InetAddress address) throws SocketException {
        super(address);
        dsTaint.addTaint(address.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.286 -0400", hash_original_method = "254DAECE553220B60B3DDCDB0D3A9A7B", hash_generated_method = "04A86122AF7E73F7644272DB201337E5")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isBusy() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mGroup != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.286 -0400", hash_original_method = "477F536A3076B0B10A19072AA2686CEC", hash_generated_method = "49BB42521F7D28E28F5ED334DDA016EC")
    @DSModeled(DSC.SAFE)
    public AudioGroup getGroup() {
        return (AudioGroup)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mGroup;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.286 -0400", hash_original_method = "119D45B9BF5FF64C97C7293B3DF5F7E3", hash_generated_method = "BC3B5878E4BC2CF560EBB2EA65BB51DD")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.287 -0400", hash_original_method = "477233579E49B9ACBFE0DA40A2D8DF9C", hash_generated_method = "BC62456BE16A45EBDEC72FC48027E12F")
    @DSModeled(DSC.SAFE)
    public AudioCodec getCodec() {
        return (AudioCodec)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCodec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.287 -0400", hash_original_method = "E0A36AFBD97A7B298B1941948E16CA1A", hash_generated_method = "D5B8EBFC9E2E0515C11BD5FE0370266F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCodec(AudioCodec codec) {
        dsTaint.addTaint(codec.dsTaint);
        {
            boolean var6331CCDC5360782724F2E909851BBC53_506944475 = (isBusy());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Busy");
            } //End block
        } //End collapsed parenthetic
        {
            throw new IllegalArgumentException("The type is used by DTMF");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.287 -0400", hash_original_method = "67DA2B7B029AD6BDA2A522BA945FCCC7", hash_generated_method = "DD5E4D58AD9A37F16E8AC7D8780999EE")
    @DSModeled(DSC.SAFE)
    public int getDtmfType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDtmfType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.287 -0400", hash_original_method = "08CFB9D3491C3CF797064DF404EB556C", hash_generated_method = "6F77C4C6DD17BC646DD7978D7E7E7664")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDtmfType(int type) {
        dsTaint.addTaint(type);
        {
            boolean var6331CCDC5360782724F2E909851BBC53_980498546 = (isBusy());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Busy");
            } //End block
        } //End collapsed parenthetic
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid type");
            } //End block
            {
                throw new IllegalArgumentException("The type is used by codec");
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


