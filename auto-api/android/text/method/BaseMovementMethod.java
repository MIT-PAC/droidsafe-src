package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.Layout;
import android.text.Spannable;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class BaseMovementMethod implements MovementMethod {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.204 -0400", hash_original_method = "7E66E2C5944F121EE22C8D08D5BB1CA1", hash_generated_method = "7E66E2C5944F121EE22C8D08D5BB1CA1")
        public BaseMovementMethod ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.205 -0400", hash_original_method = "3C8541B244B3E418A0704604E985C4F6", hash_generated_method = "25ABB32EA7C767AF793AB7B2363F29EB")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean canSelectArbitrarily() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.205 -0400", hash_original_method = "D13D908BA0DAF76C398D062F3F380F09", hash_generated_method = "CC45E36200620A5B33FC964C55C53FC8")
    @DSModeled(DSC.SAFE)
    @Override
    public void initialize(TextView widget, Spannable text) {
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.205 -0400", hash_original_method = "51F4180929D179462C8A792E383BE4DE", hash_generated_method = "75FCC90324C4D562A2C974E12C9D6B5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyDown(TextView widget, Spannable text, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        int movementMetaState;
        movementMetaState = getMovementMetaState(text, event);
        boolean handled;
        handled = handleMovementKey(widget, text, keyCode, movementMetaState, event);
        {
            MetaKeyKeyListener.adjustMetaAfterKeypress(text);
            MetaKeyKeyListener.resetLockedMeta(text);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int movementMetaState = getMovementMetaState(text, event);
        //boolean handled = handleMovementKey(widget, text, keyCode, movementMetaState, event);
        //if (handled) {
            //MetaKeyKeyListener.adjustMetaAfterKeypress(text);
            //MetaKeyKeyListener.resetLockedMeta(text);
        //}
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.206 -0400", hash_original_method = "8FECF2F4DB21657DC257EBEAC5D3F348", hash_generated_method = "C297246478BEB637EF7E79D4E97A19F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyOther(TextView widget, Spannable text, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        int movementMetaState;
        movementMetaState = getMovementMetaState(text, event);
        int keyCode;
        keyCode = event.getKeyCode();
        {
            boolean varC5978A4FB4364F803569EDCCE2DC1BA1_1540664168 = (keyCode != KeyEvent.KEYCODE_UNKNOWN
                && event.getAction() == KeyEvent.ACTION_MULTIPLE);
            {
                int repeat;
                repeat = event.getRepeatCount();
                boolean handled;
                handled = false;
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean varB934909A57248142D896FFD0AC144DC8_567566624 = (!handleMovementKey(widget, text, keyCode, movementMetaState, event));
                        } //End collapsed parenthetic
                        handled = true;
                    } //End block
                } //End collapsed parenthetic
                {
                    MetaKeyKeyListener.adjustMetaAfterKeypress(text);
                    MetaKeyKeyListener.resetLockedMeta(text);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int movementMetaState = getMovementMetaState(text, event);
        //final int keyCode = event.getKeyCode();
        //if (keyCode != KeyEvent.KEYCODE_UNKNOWN
                //&& event.getAction() == KeyEvent.ACTION_MULTIPLE) {
            //final int repeat = event.getRepeatCount();
            //boolean handled = false;
            //for (int i = 0; i < repeat; i++) {
                //if (!handleMovementKey(widget, text, keyCode, movementMetaState, event)) {
                    //break;
                //}
                //handled = true;
            //}
            //if (handled) {
                //MetaKeyKeyListener.adjustMetaAfterKeypress(text);
                //MetaKeyKeyListener.resetLockedMeta(text);
            //}
            //return handled;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.206 -0400", hash_original_method = "03F6AD3B58EDAE8DF6A1CC395F5B54B3", hash_generated_method = "6286303062BF633748A53CF879205A4E")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean onKeyUp(TextView widget, Spannable text, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.206 -0400", hash_original_method = "AC3F1CB1818DDCB7BD27F03C760797A7", hash_generated_method = "E66C62B479081C98DA13456CD5CADF8E")
    @DSModeled(DSC.SAFE)
    @Override
    public void onTakeFocus(TextView widget, Spannable text, int direction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(widget.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.206 -0400", hash_original_method = "136932FCA27B55C4FFFE4C0F482F5C95", hash_generated_method = "C561312F2E3072C9A460246E0064DE71")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean onTouchEvent(TextView widget, Spannable text, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.207 -0400", hash_original_method = "B091339813AE51B8A0FCC53026E81FDE", hash_generated_method = "21E4D22C892BB821334C99D4DD058367")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean onTrackballEvent(TextView widget, Spannable text, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.207 -0400", hash_original_method = "F7B7D807C9903B237C0BDFCF28378E9E", hash_generated_method = "C5DB9A78BA606367EEA28DCA4BAC1893")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onGenericMotionEvent(TextView widget, Spannable text, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_769531338 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_344191744 = (event.getAction());
                    //Begin case MotionEvent.ACTION_SCROLL 
                    {
                        float vscroll;
                        float hscroll;
                        {
                            boolean varB4D6A432BD6856FDF71FC12482F4DB92_595610815 = ((event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0);
                            {
                                vscroll = 0;
                                hscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                            } //End block
                            {
                                vscroll = -event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                                hscroll = event.getAxisValue(MotionEvent.AXIS_HSCROLL);
                            } //End block
                        } //End collapsed parenthetic
                        boolean handled;
                        handled = false;
                        {
                            handled |= scrollLeft(widget, text, (int)Math.ceil(-hscroll));
                        } //End block
                        {
                            handled |= scrollRight(widget, text, (int)Math.ceil(hscroll));
                        } //End block
                        {
                            handled |= scrollUp(widget, text, (int)Math.ceil(-vscroll));
                        } //End block
                        {
                            handled |= scrollDown(widget, text, (int)Math.ceil(vscroll));
                        } //End block
                    } //End block
                    //End case MotionEvent.ACTION_SCROLL 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.207 -0400", hash_original_method = "DBF5E10955F96650BAEE8C94618C2948", hash_generated_method = "8B93537E1EFBA822EAF2733AA006E246")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getMovementMetaState(Spannable buffer, KeyEvent event) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        int metaState;
        metaState = (event.getMetaState() | MetaKeyKeyListener.getMetaState(buffer))
                & ~(MetaKeyKeyListener.META_ALT_LOCKED | MetaKeyKeyListener.META_SYM_LOCKED);
        int var222F3A165AD44F34AEC0D203BF2F0E46_632191322 = (KeyEvent.normalizeMetaState(metaState) & ~KeyEvent.META_SHIFT_MASK);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int metaState = (event.getMetaState() | MetaKeyKeyListener.getMetaState(buffer))
                //& ~(MetaKeyKeyListener.META_ALT_LOCKED | MetaKeyKeyListener.META_SYM_LOCKED);
        //return KeyEvent.normalizeMetaState(metaState) & ~KeyEvent.META_SHIFT_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.208 -0400", hash_original_method = "53B656A1E8393E8F576933E71ADE5872", hash_generated_method = "4B307CCA9B2394A54172B01EC91A1191")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean handleMovementKey(TextView widget, Spannable buffer,
            int keyCode, int movementMetaState, KeyEvent event) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        dsTaint.addTaint(movementMetaState);
        //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1468226382 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean var68D671775614B8A3392859D5A7BFB272_350517473 = (left(widget, buffer));
            } //End block
            {
                boolean varF7CBF05BAA26D1F0FE66CD64B99CDBDC_1734928650 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON));
                {
                    boolean var8B70984B6D204986E86DC5E9D21EE379_1576552336 = (leftWord(widget, buffer));
                } //End block
                {
                    boolean var0C59350E9823D9FDC411AFB3B4E4D995_1298289005 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                    {
                        boolean varF91F8ED470DB3CB92941B7FB32F16F98_2013603620 = (lineStart(widget, buffer));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_LEFT 
        //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_397773684 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean var611677DDD7BCF208C2108267C92093F0_1777352186 = (right(widget, buffer));
            } //End block
            {
                boolean varF7CBF05BAA26D1F0FE66CD64B99CDBDC_1271853750 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON));
                {
                    boolean var5AAE0481ED9ADA837863356FCD6CBF51_511297500 = (rightWord(widget, buffer));
                } //End block
                {
                    boolean var0C59350E9823D9FDC411AFB3B4E4D995_1888258114 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                    {
                        boolean varB65D932CCFD36B7EACB4EE7EE3C54F1E_2109766285 = (lineEnd(widget, buffer));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_RIGHT 
        //Begin case KeyEvent.KEYCODE_DPAD_UP 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1946071514 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean var7FA4D50FEE7D0B231F734E91D2642307_824662310 = (up(widget, buffer));
            } //End block
            {
                boolean var5E32B625D4444A09AA68BCFD992ECE2D_95934184 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                {
                    boolean var7EA610619321657A9AD12517CB6DB46F_1779361455 = (top(widget, buffer));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_UP 
        //Begin case KeyEvent.KEYCODE_DPAD_DOWN 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1246021287 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean var8755A1382E2B8967B38EC82AC8AD7026_401012422 = (down(widget, buffer));
            } //End block
            {
                boolean var5E32B625D4444A09AA68BCFD992ECE2D_744304200 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                {
                    boolean var147A9E526C33B1617033994832B32BCD_609492332 = (bottom(widget, buffer));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_DOWN 
        //Begin case KeyEvent.KEYCODE_PAGE_UP 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1974927767 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean var7A20B6A7ADD620ED36BF97D295E03752_1371707596 = (pageUp(widget, buffer));
            } //End block
            {
                boolean var5E32B625D4444A09AA68BCFD992ECE2D_63870531 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                {
                    boolean var7EA610619321657A9AD12517CB6DB46F_1881381085 = (top(widget, buffer));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_PAGE_UP 
        //Begin case KeyEvent.KEYCODE_PAGE_DOWN 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_2036790225 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean varEAE8B54B2ED18C0A322E5C2C2227ABFE_316517216 = (pageDown(widget, buffer));
            } //End block
            {
                boolean var5E32B625D4444A09AA68BCFD992ECE2D_1761234886 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                {
                    boolean var147A9E526C33B1617033994832B32BCD_1775059952 = (bottom(widget, buffer));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_PAGE_DOWN 
        //Begin case KeyEvent.KEYCODE_MOVE_HOME 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1618678215 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean varB99A5007A511DDDDEC7F28357AA472F1_350026809 = (home(widget, buffer));
            } //End block
            {
                boolean varF7CBF05BAA26D1F0FE66CD64B99CDBDC_1702483793 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON));
                {
                    boolean var7EA610619321657A9AD12517CB6DB46F_41005277 = (top(widget, buffer));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_MOVE_HOME 
        //Begin case KeyEvent.KEYCODE_MOVE_END 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1711257462 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean varFD118AD11A361DEDA24BCD2A88D3C277_1495003460 = (end(widget, buffer));
            } //End block
            {
                boolean varF7CBF05BAA26D1F0FE66CD64B99CDBDC_725410005 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON));
                {
                    boolean var147A9E526C33B1617033994832B32BCD_814093255 = (bottom(widget, buffer));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_MOVE_END 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.209 -0400", hash_original_method = "176341E451B55C50C4D903315018153A", hash_generated_method = "5E34538DED12549D32EBAE5156A1905D")
    @DSModeled(DSC.SAFE)
    protected boolean left(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.209 -0400", hash_original_method = "68CC4A5755726297BC90EB8071236539", hash_generated_method = "E21C9A7DFB39217C7B45E3E0E0D5BB2A")
    @DSModeled(DSC.SAFE)
    protected boolean right(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.209 -0400", hash_original_method = "4C3F0CF20A3CBF82271A73533254C678", hash_generated_method = "369B835A0CCD13346BC49DC5FE54BF32")
    @DSModeled(DSC.SAFE)
    protected boolean up(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.209 -0400", hash_original_method = "FDACBEC8690232193991EC2D654F498C", hash_generated_method = "B8A7CC2241202A6CB4CFBB7164134BDB")
    @DSModeled(DSC.SAFE)
    protected boolean down(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.210 -0400", hash_original_method = "C9503F691DAF48A1F140F42890F719F7", hash_generated_method = "6B6DB331ECC403B2862EA42BA38BFF6B")
    @DSModeled(DSC.SAFE)
    protected boolean pageUp(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.210 -0400", hash_original_method = "EA27CD9461C85470B182D05F37CF9E99", hash_generated_method = "DA38402C3FB11B24AA00C6E2D6493B55")
    @DSModeled(DSC.SAFE)
    protected boolean pageDown(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.210 -0400", hash_original_method = "3F6686FAC1641E4D3DFFC3F0DB33E5B2", hash_generated_method = "783DFC45847F3ECE68C4DD2D77B8A9CA")
    @DSModeled(DSC.SAFE)
    protected boolean top(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.210 -0400", hash_original_method = "721AC2C980F4969C548FB1DE5C82C277", hash_generated_method = "FA748DBCBB9CAB0A052700BF34159197")
    @DSModeled(DSC.SAFE)
    protected boolean bottom(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.210 -0400", hash_original_method = "A4B1F2E867C9A510C601A243C52C492E", hash_generated_method = "E528E3C6175ACB355F645F0A33258B7C")
    @DSModeled(DSC.SAFE)
    protected boolean lineStart(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.211 -0400", hash_original_method = "A632F71919730AFFFF566F700D39B7D0", hash_generated_method = "254E6F94C1AE5FAD978291B412A66C3B")
    @DSModeled(DSC.SAFE)
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.211 -0400", hash_original_method = "1043D0C7BC940A703E52A54D62DB9381", hash_generated_method = "C39A806AE6FBD7699B6C136BDC8D7F08")
    @DSModeled(DSC.SAFE)
    protected boolean leftWord(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.211 -0400", hash_original_method = "8D9EF29844655A160F605C571CBB67AE", hash_generated_method = "95D22CBB729F3234E35EB65CC5B3D5AE")
    @DSModeled(DSC.SAFE)
    protected boolean rightWord(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.211 -0400", hash_original_method = "8E23D2BEC9459FE2CC91B2DD463DCF3F", hash_generated_method = "820D6899C9D8CF4D6645DC13C1F4CBA3")
    @DSModeled(DSC.SAFE)
    protected boolean home(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.211 -0400", hash_original_method = "6807F0AF3535B8AAE125BEB8D24FA4BA", hash_generated_method = "7B154464C35E71B44302B89E9657FC40")
    @DSModeled(DSC.SAFE)
    protected boolean end(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.211 -0400", hash_original_method = "772DAE7A7DE9A4DC4AD657418C90F32E", hash_generated_method = "9E1BE13EAD8C72CF1F87C303B7AEE82F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getTopLine(TextView widget) {
        dsTaint.addTaint(widget.dsTaint);
        int var805F4348DA22D9BE2CA9DD1502114BBC_34450668 = (widget.getLayout().getLineForVertical(widget.getScrollY()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return widget.getLayout().getLineForVertical(widget.getScrollY());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.212 -0400", hash_original_method = "653A8A6EB137C95052F7EAEBCC41BD55", hash_generated_method = "40D7C637B984FAB8A9E1122E0D65584F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getBottomLine(TextView widget) {
        dsTaint.addTaint(widget.dsTaint);
        int var802B9CFC7F9FC9F6D5306002E1A24D67_19821349 = (widget.getLayout().getLineForVertical(widget.getScrollY() + getInnerHeight(widget)));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return widget.getLayout().getLineForVertical(widget.getScrollY() + getInnerHeight(widget));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.212 -0400", hash_original_method = "C7082848D94AD1EC4FC0EC3514A56C71", hash_generated_method = "F1D826FE7A643EE390A3EBB3FFED1EC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getInnerWidth(TextView widget) {
        dsTaint.addTaint(widget.dsTaint);
        int var5E051DC25D40FEA956D6187DC3B3424F_2053592991 = (widget.getWidth() - widget.getTotalPaddingLeft() - widget.getTotalPaddingRight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return widget.getWidth() - widget.getTotalPaddingLeft() - widget.getTotalPaddingRight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.212 -0400", hash_original_method = "232D6784857554322EB1F91BB9F6CC48", hash_generated_method = "69EBBBD46D1AFDFC98F2AEB245B7098D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getInnerHeight(TextView widget) {
        dsTaint.addTaint(widget.dsTaint);
        int var99A6A405D49CFB17B685FBA2C3B645E4_429950447 = (widget.getHeight() - widget.getTotalPaddingTop() - widget.getTotalPaddingBottom());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return widget.getHeight() - widget.getTotalPaddingTop() - widget.getTotalPaddingBottom();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.212 -0400", hash_original_method = "BCC9C4F3EEFF08511FB2E9A20E83B404", hash_generated_method = "D772CCEEE4D54ED491484DF932361431")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getCharacterWidth(TextView widget) {
        dsTaint.addTaint(widget.dsTaint);
        int varD2D617A927571E013F1AB0889DF28F56_926281482 = ((int) Math.ceil(widget.getPaint().getFontSpacing()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) Math.ceil(widget.getPaint().getFontSpacing());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.213 -0400", hash_original_method = "32AF158BA043ADAC837409A280E9071B", hash_generated_method = "C83644021F34928D06F4B1F40E81ABA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getScrollBoundsLeft(TextView widget) {
        dsTaint.addTaint(widget.dsTaint);
        Layout layout;
        layout = widget.getLayout();
        int topLine;
        topLine = getTopLine(widget);
        int bottomLine;
        bottomLine = getBottomLine(widget);
        int left;
        left = Integer.MAX_VALUE;
        {
            int line;
            line = topLine;
            {
                int lineLeft;
                lineLeft = (int) Math.floor(layout.getLineLeft(line));
                {
                    left = lineLeft;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //final int topLine = getTopLine(widget);
        //final int bottomLine = getBottomLine(widget);
        //if (topLine > bottomLine) {
            //return 0;
        //}
        //int left = Integer.MAX_VALUE;
        //for (int line = topLine; line <= bottomLine; line++) {
            //final int lineLeft = (int) Math.floor(layout.getLineLeft(line));
            //if (lineLeft < left) {
                //left = lineLeft;
            //}
        //}
        //return left;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.213 -0400", hash_original_method = "F8CD0B2B66ECC22BDFE1C77AF25A13D6", hash_generated_method = "4B7F75F9D0CE6D06F265A0546DBA8DAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getScrollBoundsRight(TextView widget) {
        dsTaint.addTaint(widget.dsTaint);
        Layout layout;
        layout = widget.getLayout();
        int topLine;
        topLine = getTopLine(widget);
        int bottomLine;
        bottomLine = getBottomLine(widget);
        int right;
        right = Integer.MIN_VALUE;
        {
            int line;
            line = topLine;
            {
                int lineRight;
                lineRight = (int) Math.ceil(layout.getLineRight(line));
                {
                    right = lineRight;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //final int topLine = getTopLine(widget);
        //final int bottomLine = getBottomLine(widget);
        //if (topLine > bottomLine) {
            //return 0;
        //}
        //int right = Integer.MIN_VALUE;
        //for (int line = topLine; line <= bottomLine; line++) {
            //final int lineRight = (int) Math.ceil(layout.getLineRight(line));
            //if (lineRight > right) {
                //right = lineRight;
            //}
        //}
        //return right;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.213 -0400", hash_original_method = "99A2FC579527B2CEA9AC5A41AD01795F", hash_generated_method = "125BDBA5854C945409AC8B27FC697F87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean scrollLeft(TextView widget, Spannable buffer, int amount) {
        dsTaint.addTaint(amount);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        int minScrollX;
        minScrollX = getScrollBoundsLeft(widget);
        int scrollX;
        scrollX = widget.getScrollX();
        {
            scrollX = Math.max(scrollX - getCharacterWidth(widget) * amount, minScrollX);
            widget.scrollTo(scrollX, widget.getScrollY());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int minScrollX = getScrollBoundsLeft(widget);
        //int scrollX = widget.getScrollX();
        //if (scrollX > minScrollX) {
            //scrollX = Math.max(scrollX - getCharacterWidth(widget) * amount, minScrollX);
            //widget.scrollTo(scrollX, widget.getScrollY());
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.214 -0400", hash_original_method = "34082555FFD2A1D5F6DB38655C7C2C48", hash_generated_method = "50DA0EF400BEA4420F915059B3442726")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean scrollRight(TextView widget, Spannable buffer, int amount) {
        dsTaint.addTaint(amount);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        int maxScrollX;
        maxScrollX = getScrollBoundsRight(widget) - getInnerWidth(widget);
        int scrollX;
        scrollX = widget.getScrollX();
        {
            scrollX = Math.min(scrollX + getCharacterWidth(widget) * amount, maxScrollX);
            widget.scrollTo(scrollX, widget.getScrollY());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int maxScrollX = getScrollBoundsRight(widget) - getInnerWidth(widget);
        //int scrollX = widget.getScrollX();
        //if (scrollX < maxScrollX) {
            //scrollX = Math.min(scrollX + getCharacterWidth(widget) * amount, maxScrollX);
            //widget.scrollTo(scrollX, widget.getScrollY());
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.214 -0400", hash_original_method = "A3AFC4271D337C51C9B090DAD80C0547", hash_generated_method = "724B602E3908DA569E9EA61C490924ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean scrollUp(TextView widget, Spannable buffer, int amount) {
        dsTaint.addTaint(amount);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        Layout layout;
        layout = widget.getLayout();
        int top;
        top = widget.getScrollY();
        int topLine;
        topLine = layout.getLineForVertical(top);
        {
            boolean varEEE5BBB9733FB099657B9686D5BC78E7_486867254 = (layout.getLineTop(topLine) == top);
            {
                topLine -= 1;
            } //End block
        } //End collapsed parenthetic
        {
            topLine = Math.max(topLine - amount + 1, 0);
            Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(topLine));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //final int top = widget.getScrollY();
        //int topLine = layout.getLineForVertical(top);
        //if (layout.getLineTop(topLine) == top) {
            //topLine -= 1;
        //}
        //if (topLine >= 0) {
            //topLine = Math.max(topLine - amount + 1, 0);
            //Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(topLine));
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.214 -0400", hash_original_method = "0BF828F72F7601E47AA52D725EC1C4EF", hash_generated_method = "E4BCD101EF2C422131B6A3D9A4B970B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean scrollDown(TextView widget, Spannable buffer, int amount) {
        dsTaint.addTaint(amount);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        Layout layout;
        layout = widget.getLayout();
        int innerHeight;
        innerHeight = getInnerHeight(widget);
        int bottom;
        bottom = widget.getScrollY() + innerHeight;
        int bottomLine;
        bottomLine = layout.getLineForVertical(bottom);
        {
            boolean var030919D13F1284BB3F9B91F681DCB1BC_1993920147 = (layout.getLineTop(bottomLine + 1) < bottom + 1);
            {
                bottomLine += 1;
            } //End block
        } //End collapsed parenthetic
        int limit;
        limit = layout.getLineCount() - 1;
        {
            bottomLine = Math.min(bottomLine + amount - 1, limit);
            Touch.scrollTo(widget, layout, widget.getScrollX(),
                    layout.getLineTop(bottomLine + 1) - innerHeight);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //final int innerHeight = getInnerHeight(widget);
        //final int bottom = widget.getScrollY() + innerHeight;
        //int bottomLine = layout.getLineForVertical(bottom);
        //if (layout.getLineTop(bottomLine + 1) < bottom + 1) {
            //bottomLine += 1;
        //}
        //final int limit = layout.getLineCount() - 1;
        //if (bottomLine <= limit) {
            //bottomLine = Math.min(bottomLine + amount - 1, limit);
            //Touch.scrollTo(widget, layout, widget.getScrollX(),
                    //layout.getLineTop(bottomLine + 1) - innerHeight);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.215 -0400", hash_original_method = "961665135E04FC2BFD71FE9A7899CD8F", hash_generated_method = "F72A06D1C4DFF323281D4570AC8BA913")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean scrollPageUp(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        Layout layout;
        layout = widget.getLayout();
        int top;
        top = widget.getScrollY() - getInnerHeight(widget);
        int topLine;
        topLine = layout.getLineForVertical(top);
        {
            Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(topLine));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //final int top = widget.getScrollY() - getInnerHeight(widget);
        //int topLine = layout.getLineForVertical(top);
        //if (topLine >= 0) {
            //Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(topLine));
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.215 -0400", hash_original_method = "FC4FA64E8CF6D16D369F4D51265A00D0", hash_generated_method = "77C8A20EBE65B45238826A6FAAEB6593")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean scrollPageDown(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        Layout layout;
        layout = widget.getLayout();
        int innerHeight;
        innerHeight = getInnerHeight(widget);
        int bottom;
        bottom = widget.getScrollY() + innerHeight + innerHeight;
        int bottomLine;
        bottomLine = layout.getLineForVertical(bottom);
        {
            boolean var70F0029FEFBA551A703CC1A7793615A5_1666749964 = (bottomLine <= layout.getLineCount() - 1);
            {
                Touch.scrollTo(widget, layout, widget.getScrollX(),
                    layout.getLineTop(bottomLine + 1) - innerHeight);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //final int innerHeight = getInnerHeight(widget);
        //final int bottom = widget.getScrollY() + innerHeight + innerHeight;
        //int bottomLine = layout.getLineForVertical(bottom);
        //if (bottomLine <= layout.getLineCount() - 1) {
            //Touch.scrollTo(widget, layout, widget.getScrollX(),
                    //layout.getLineTop(bottomLine + 1) - innerHeight);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.215 -0400", hash_original_method = "7CF9A5A04E9D7FD8D1056DC0F832B9EF", hash_generated_method = "99B39CF54F745EF376F1D6CF7FC706DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean scrollTop(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        Layout layout;
        layout = widget.getLayout();
        {
            boolean varA4FA92505E883020183A6E88585B9BF8_1406845067 = (getTopLine(widget) >= 0);
            {
                Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(0));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (getTopLine(widget) >= 0) {
            //Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(0));
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.216 -0400", hash_original_method = "FCBCF26A13DC616293A73F9223FE45DF", hash_generated_method = "5A45F9C35169A8D738BE9E58CD2A61F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean scrollBottom(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        Layout layout;
        layout = widget.getLayout();
        int lineCount;
        lineCount = layout.getLineCount();
        {
            boolean varB6ABA3DF3EBF85AF261C26BD0C4F402E_1114867489 = (getBottomLine(widget) <= lineCount - 1);
            {
                Touch.scrollTo(widget, layout, widget.getScrollX(),
                    layout.getLineTop(lineCount) - getInnerHeight(widget));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //final int lineCount = layout.getLineCount();
        //if (getBottomLine(widget) <= lineCount - 1) {
            //Touch.scrollTo(widget, layout, widget.getScrollX(),
                    //layout.getLineTop(lineCount) - getInnerHeight(widget));
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.216 -0400", hash_original_method = "FDDC66476559B51E1C65BE36B03CFE74", hash_generated_method = "89554DADBC5BB597AB5A964D00565CA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean scrollLineStart(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        int minScrollX;
        minScrollX = getScrollBoundsLeft(widget);
        int scrollX;
        scrollX = widget.getScrollX();
        {
            widget.scrollTo(minScrollX, widget.getScrollY());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int minScrollX = getScrollBoundsLeft(widget);
        //int scrollX = widget.getScrollX();
        //if (scrollX > minScrollX) {
            //widget.scrollTo(minScrollX, widget.getScrollY());
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.216 -0400", hash_original_method = "83871D5A105C781298F6AD1F6CCA2A68", hash_generated_method = "352543CC53F1327608D10A37F2DC176E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean scrollLineEnd(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        int maxScrollX;
        maxScrollX = getScrollBoundsRight(widget) - getInnerWidth(widget);
        int scrollX;
        scrollX = widget.getScrollX();
        {
            widget.scrollTo(maxScrollX, widget.getScrollY());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int maxScrollX = getScrollBoundsRight(widget) - getInnerWidth(widget);
        //int scrollX = widget.getScrollX();
        //if (scrollX < maxScrollX) {
            //widget.scrollTo(maxScrollX, widget.getScrollY());
            //return true;
        //}
        //return false;
    }

    
}

