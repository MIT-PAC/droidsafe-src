package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.telephony.IccCard;
import android.content.Context;
public class LockPatternKeyguardViewProperties implements KeyguardViewProperties {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.758 -0400", hash_original_field = "EAA1758ACB8C3815224ED7417E5328B5", hash_generated_field = "FB69BB5EA99FF1AC6B151A37F4FEA26C")

    private LockPatternUtils mLockPatternUtils;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.758 -0400", hash_original_field = "E8A7E633D99E3BACB8ADFBBABB173D14", hash_generated_field = "22DCE3AFB482F86E6B2E96F873097CE0")

    private KeyguardUpdateMonitor mUpdateMonitor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.759 -0400", hash_original_method = "2B8D83733C3D83E7D15CF43F7D755597", hash_generated_method = "924C41818D2DEBAB0B7A6677695A0C45")
    public  LockPatternKeyguardViewProperties(LockPatternUtils lockPatternUtils,
            KeyguardUpdateMonitor updateMonitor) {
        addTaint(updateMonitor.getTaint());
        addTaint(lockPatternUtils.getTaint());
mLockPatternUtils=lockPatternUtilsmUpdateMonitor=updateMonitor
        // ---------- Original Method ----------
        //mLockPatternUtils = lockPatternUtils;
        //mUpdateMonitor = updateMonitor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.761 -0400", hash_original_method = "EC67F8D4D44611C7850F39557A2C6C3E", hash_generated_method = "B8B33A8A65F1D20FEC3C13EDBF6E4D29")
    public KeyguardViewBase createKeyguardView(Context context,
            KeyguardUpdateMonitor updateMonitor,
            KeyguardWindowController controller) {
        addTaint(controller.getTaint());
        addTaint(updateMonitor.getTaint());
        addTaint(context.getTaint());
KeyguardViewBase varD25C3F17DB8B5DB921C9AD6B4A9EBB37_174569945 = new LockPatternKeyguardView(context, updateMonitor, mLockPatternUtils, controller)        varD25C3F17DB8B5DB921C9AD6B4A9EBB37_174569945.addTaint(taint);
        return varD25C3F17DB8B5DB921C9AD6B4A9EBB37_174569945;
        // ---------- Original Method ----------
        //return new LockPatternKeyguardView(context, updateMonitor,
                //mLockPatternUtils, controller);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.762 -0400", hash_original_method = "FF0BFA1CE251C9C6182F87EE8709091B", hash_generated_method = "765A6F6B2BD6BBF0F7034C87DB9AF1D4")
    public boolean isSecure() {
        boolean var1A059EB769D6DD75FCCDDA63A896E3C4_386269920 = (mLockPatternUtils.isSecure()||isSimPinSecure());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_833934442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_833934442;
        // ---------- Original Method ----------
        //return mLockPatternUtils.isSecure() || isSimPinSecure();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.763 -0400", hash_original_method = "DB67DA5848BFC047D5C22649A53FE304", hash_generated_method = "0AA3977410A8BBDEAEE28BD79D03065F")
    private boolean isSimPinSecure() {
        final IccCard.State simState = mUpdateMonitor.getSimState();
        boolean var52E94442F8C735EB3CBDDB001C3765A9_1608319862 = ((simState==IccCard.State.PIN_REQUIRED||simState==IccCard.State.PUK_REQUIRED||simState==IccCard.State.ABSENT||simState==IccCard.State.PERM_DISABLED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_336408323 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_336408323;
        // ---------- Original Method ----------
        //final IccCard.State simState = mUpdateMonitor.getSimState();
        //return (simState == IccCard.State.PIN_REQUIRED
                //|| simState == IccCard.State.PUK_REQUIRED
                //|| simState == IccCard.State.ABSENT
                //|| simState == IccCard.State.PERM_DISABLED);
    }

    
}

