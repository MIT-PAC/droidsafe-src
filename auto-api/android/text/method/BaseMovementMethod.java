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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.809 -0400", hash_original_method = "1DE84F8ABE7124ECFD52F353C5E545C4", hash_generated_method = "1DE84F8ABE7124ECFD52F353C5E545C4")
    public BaseMovementMethod ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.814 -0400", hash_original_method = "3C8541B244B3E418A0704604E985C4F6", hash_generated_method = "7FCF0CEEF30F3BC7E5A5A4A495C6BD72")
    @Override
    public boolean canSelectArbitrarily() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_714617946 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_714617946;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.815 -0400", hash_original_method = "D13D908BA0DAF76C398D062F3F380F09", hash_generated_method = "C57EDA36F09CC6129F642DA1BD1E4D7D")
    @Override
    public void initialize(TextView widget, Spannable text) {
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.816 -0400", hash_original_method = "51F4180929D179462C8A792E383BE4DE", hash_generated_method = "7E67E7DAE47680D16885689D5D1E9FC5")
    @Override
    public boolean onKeyDown(TextView widget, Spannable text, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int movementMetaState;
        movementMetaState = getMovementMetaState(text, event);
        boolean handled;
        handled = handleMovementKey(widget, text, keyCode, movementMetaState, event);
        {
            MetaKeyKeyListener.adjustMetaAfterKeypress(text);
            MetaKeyKeyListener.resetLockedMeta(text);
        } //End block
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_307966240 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_307966240;
        // ---------- Original Method ----------
        //final int movementMetaState = getMovementMetaState(text, event);
        //boolean handled = handleMovementKey(widget, text, keyCode, movementMetaState, event);
        //if (handled) {
            //MetaKeyKeyListener.adjustMetaAfterKeypress(text);
            //MetaKeyKeyListener.resetLockedMeta(text);
        //}
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.822 -0400", hash_original_method = "8FECF2F4DB21657DC257EBEAC5D3F348", hash_generated_method = "D2C3A2F96C08C7365AA0754489998F7A")
    @Override
    public boolean onKeyOther(TextView widget, Spannable text, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int movementMetaState;
        movementMetaState = getMovementMetaState(text, event);
        int keyCode;
        keyCode = event.getKeyCode();
        {
            boolean varC5978A4FB4364F803569EDCCE2DC1BA1_69076667 = (keyCode != KeyEvent.KEYCODE_UNKNOWN
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
                            boolean varB934909A57248142D896FFD0AC144DC8_2143446617 = (!handleMovementKey(widget, text, keyCode, movementMetaState, event));
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
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_253951582 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_253951582;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.823 -0400", hash_original_method = "03F6AD3B58EDAE8DF6A1CC395F5B54B3", hash_generated_method = "C28722883AD373C58112E086EC7F4F16")
    @Override
    public boolean onKeyUp(TextView widget, Spannable text, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147984429 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147984429;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.823 -0400", hash_original_method = "AC3F1CB1818DDCB7BD27F03C760797A7", hash_generated_method = "D617C850B9E6AEDCA4942B3A21B86765")
    @Override
    public void onTakeFocus(TextView widget, Spannable text, int direction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        addTaint(direction);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.831 -0400", hash_original_method = "136932FCA27B55C4FFFE4C0F482F5C95", hash_generated_method = "D628124A6B83F0CA8E48FA980E44EA4F")
    @Override
    public boolean onTouchEvent(TextView widget, Spannable text, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1193562004 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1193562004;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.832 -0400", hash_original_method = "B091339813AE51B8A0FCC53026E81FDE", hash_generated_method = "FF28E2DA5A91F413FF5602993AA6B350")
    @Override
    public boolean onTrackballEvent(TextView widget, Spannable text, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_479124791 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_479124791;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.843 -0400", hash_original_method = "F7B7D807C9903B237C0BDFCF28378E9E", hash_generated_method = "4E305D1D70C588894CE4745A42398E05")
    @Override
    public boolean onGenericMotionEvent(TextView widget, Spannable text, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_743011026 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_624110408 = (event.getAction());
                    //Begin case MotionEvent.ACTION_SCROLL 
                    {
                        float vscroll;
                        float hscroll;
                        {
                            boolean varB4D6A432BD6856FDF71FC12482F4DB92_439014661 = ((event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0);
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
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_930786827 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_930786827;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.844 -0400", hash_original_method = "DBF5E10955F96650BAEE8C94618C2948", hash_generated_method = "219985ADA9A0CB1B1A9344B2EC5C0715")
    protected int getMovementMetaState(Spannable buffer, KeyEvent event) {
        int metaState;
        metaState = (event.getMetaState() | MetaKeyKeyListener.getMetaState(buffer))
                & ~(MetaKeyKeyListener.META_ALT_LOCKED | MetaKeyKeyListener.META_SYM_LOCKED);
        int var222F3A165AD44F34AEC0D203BF2F0E46_937899549 = (KeyEvent.normalizeMetaState(metaState) & ~KeyEvent.META_SHIFT_MASK);
        addTaint(buffer.getTaint());
        addTaint(event.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1066964547 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1066964547;
        // ---------- Original Method ----------
        //int metaState = (event.getMetaState() | MetaKeyKeyListener.getMetaState(buffer))
                //& ~(MetaKeyKeyListener.META_ALT_LOCKED | MetaKeyKeyListener.META_SYM_LOCKED);
        //return KeyEvent.normalizeMetaState(metaState) & ~KeyEvent.META_SHIFT_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.857 -0400", hash_original_method = "53B656A1E8393E8F576933E71ADE5872", hash_generated_method = "39AD860B839F4CEA488B71AD5D208585")
    protected boolean handleMovementKey(TextView widget, Spannable buffer,
            int keyCode, int movementMetaState, KeyEvent event) {
        //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1199811917 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean var68D671775614B8A3392859D5A7BFB272_473606335 = (left(widget, buffer));
            } //End block
            {
                boolean varF7CBF05BAA26D1F0FE66CD64B99CDBDC_692679215 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON));
                {
                    boolean var8B70984B6D204986E86DC5E9D21EE379_529863188 = (leftWord(widget, buffer));
                } //End block
                {
                    boolean var0C59350E9823D9FDC411AFB3B4E4D995_827001226 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                    {
                        boolean varF91F8ED470DB3CB92941B7FB32F16F98_271043999 = (lineStart(widget, buffer));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_LEFT 
        //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1515769486 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean var611677DDD7BCF208C2108267C92093F0_554359456 = (right(widget, buffer));
            } //End block
            {
                boolean varF7CBF05BAA26D1F0FE66CD64B99CDBDC_986368742 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON));
                {
                    boolean var5AAE0481ED9ADA837863356FCD6CBF51_1683438244 = (rightWord(widget, buffer));
                } //End block
                {
                    boolean var0C59350E9823D9FDC411AFB3B4E4D995_1085829916 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                    {
                        boolean varB65D932CCFD36B7EACB4EE7EE3C54F1E_1420071499 = (lineEnd(widget, buffer));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_RIGHT 
        //Begin case KeyEvent.KEYCODE_DPAD_UP 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1169402870 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean var7FA4D50FEE7D0B231F734E91D2642307_1487920770 = (up(widget, buffer));
            } //End block
            {
                boolean var5E32B625D4444A09AA68BCFD992ECE2D_1135199395 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                {
                    boolean var7EA610619321657A9AD12517CB6DB46F_448763754 = (top(widget, buffer));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_UP 
        //Begin case KeyEvent.KEYCODE_DPAD_DOWN 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1587053160 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean var8755A1382E2B8967B38EC82AC8AD7026_1451201124 = (down(widget, buffer));
            } //End block
            {
                boolean var5E32B625D4444A09AA68BCFD992ECE2D_1538068309 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                {
                    boolean var147A9E526C33B1617033994832B32BCD_1959684154 = (bottom(widget, buffer));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_DOWN 
        //Begin case KeyEvent.KEYCODE_PAGE_UP 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1205905750 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean var7A20B6A7ADD620ED36BF97D295E03752_1312466843 = (pageUp(widget, buffer));
            } //End block
            {
                boolean var5E32B625D4444A09AA68BCFD992ECE2D_250940158 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                {
                    boolean var7EA610619321657A9AD12517CB6DB46F_1551599822 = (top(widget, buffer));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_PAGE_UP 
        //Begin case KeyEvent.KEYCODE_PAGE_DOWN 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_2125412300 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean varEAE8B54B2ED18C0A322E5C2C2227ABFE_1742971449 = (pageDown(widget, buffer));
            } //End block
            {
                boolean var5E32B625D4444A09AA68BCFD992ECE2D_1479396730 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                {
                    boolean var147A9E526C33B1617033994832B32BCD_1892988320 = (bottom(widget, buffer));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_PAGE_DOWN 
        //Begin case KeyEvent.KEYCODE_MOVE_HOME 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1278819469 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean varB99A5007A511DDDDEC7F28357AA472F1_1939154164 = (home(widget, buffer));
            } //End block
            {
                boolean varF7CBF05BAA26D1F0FE66CD64B99CDBDC_1843187546 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON));
                {
                    boolean var7EA610619321657A9AD12517CB6DB46F_1502953593 = (top(widget, buffer));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_MOVE_HOME 
        //Begin case KeyEvent.KEYCODE_MOVE_END 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1392319661 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean varFD118AD11A361DEDA24BCD2A88D3C277_1336478109 = (end(widget, buffer));
            } //End block
            {
                boolean varF7CBF05BAA26D1F0FE66CD64B99CDBDC_398031259 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON));
                {
                    boolean var147A9E526C33B1617033994832B32BCD_155081544 = (bottom(widget, buffer));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_MOVE_END 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(keyCode);
        addTaint(movementMetaState);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_959604333 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_959604333;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.863 -0400", hash_original_method = "176341E451B55C50C4D903315018153A", hash_generated_method = "1F72CAC11E1E720EF5204FB1B0D885C8")
    protected boolean left(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1588165398 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1588165398;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.864 -0400", hash_original_method = "68CC4A5755726297BC90EB8071236539", hash_generated_method = "0E5945BD5CC26741AB35D8F1513D20FF")
    protected boolean right(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1949878233 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1949878233;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.865 -0400", hash_original_method = "4C3F0CF20A3CBF82271A73533254C678", hash_generated_method = "ABDEA52AAB9B45E0EA988A1922471352")
    protected boolean up(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_254613720 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_254613720;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.878 -0400", hash_original_method = "FDACBEC8690232193991EC2D654F498C", hash_generated_method = "D8CECC221243F7CF382B643B4D6C84F8")
    protected boolean down(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1764724215 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1764724215;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.879 -0400", hash_original_method = "C9503F691DAF48A1F140F42890F719F7", hash_generated_method = "8EFCD391CDB79A5C6B111CC6A80B15E1")
    protected boolean pageUp(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1935576858 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1935576858;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.879 -0400", hash_original_method = "EA27CD9461C85470B182D05F37CF9E99", hash_generated_method = "56B55CC6505C54F1B8B71461699BEB1E")
    protected boolean pageDown(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_80404556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_80404556;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.879 -0400", hash_original_method = "3F6686FAC1641E4D3DFFC3F0DB33E5B2", hash_generated_method = "D22F69319D9FC25FE26F927CC53DF667")
    protected boolean top(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1077201683 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1077201683;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.880 -0400", hash_original_method = "721AC2C980F4969C548FB1DE5C82C277", hash_generated_method = "F91335B45185593BA5885DB7FA6B0D33")
    protected boolean bottom(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_782006669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_782006669;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.880 -0400", hash_original_method = "A4B1F2E867C9A510C601A243C52C492E", hash_generated_method = "F9D393B72BDE62BAC4BDFA82E99D8D22")
    protected boolean lineStart(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1289235864 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1289235864;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.881 -0400", hash_original_method = "A632F71919730AFFFF566F700D39B7D0", hash_generated_method = "486E993E10F2E0A47C8632268245D615")
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_722834234 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_722834234;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.904 -0400", hash_original_method = "1043D0C7BC940A703E52A54D62DB9381", hash_generated_method = "DF4CA1CAFFD6FF80BB3E4BF98ED9E2B7")
    protected boolean leftWord(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_591089173 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_591089173;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.905 -0400", hash_original_method = "8D9EF29844655A160F605C571CBB67AE", hash_generated_method = "A4510B9EE99E15A78D05CD92D014EDE8")
    protected boolean rightWord(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1809748853 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1809748853;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.906 -0400", hash_original_method = "8E23D2BEC9459FE2CC91B2DD463DCF3F", hash_generated_method = "00EE521F62B4157EEDE33BB309E4BDCB")
    protected boolean home(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_518680167 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_518680167;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.906 -0400", hash_original_method = "6807F0AF3535B8AAE125BEB8D24FA4BA", hash_generated_method = "6F4E579BA3A3BBEB8694E0488240B2D8")
    protected boolean end(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1322770880 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1322770880;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.907 -0400", hash_original_method = "772DAE7A7DE9A4DC4AD657418C90F32E", hash_generated_method = "EB3F004A2F5B0A5632463D424CD67647")
    private int getTopLine(TextView widget) {
        int var805F4348DA22D9BE2CA9DD1502114BBC_386047891 = (widget.getLayout().getLineForVertical(widget.getScrollY()));
        addTaint(widget.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_520267625 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_520267625;
        // ---------- Original Method ----------
        //return widget.getLayout().getLineForVertical(widget.getScrollY());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.908 -0400", hash_original_method = "653A8A6EB137C95052F7EAEBCC41BD55", hash_generated_method = "C35635BA22388FE29C4AF7744D11471F")
    private int getBottomLine(TextView widget) {
        int var802B9CFC7F9FC9F6D5306002E1A24D67_583931804 = (widget.getLayout().getLineForVertical(widget.getScrollY() + getInnerHeight(widget)));
        addTaint(widget.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1402611666 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1402611666;
        // ---------- Original Method ----------
        //return widget.getLayout().getLineForVertical(widget.getScrollY() + getInnerHeight(widget));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.912 -0400", hash_original_method = "C7082848D94AD1EC4FC0EC3514A56C71", hash_generated_method = "0FC4739744D63F3A73536034B2E536A4")
    private int getInnerWidth(TextView widget) {
        int var5E051DC25D40FEA956D6187DC3B3424F_1995982718 = (widget.getWidth() - widget.getTotalPaddingLeft() - widget.getTotalPaddingRight());
        addTaint(widget.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546501351 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546501351;
        // ---------- Original Method ----------
        //return widget.getWidth() - widget.getTotalPaddingLeft() - widget.getTotalPaddingRight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.921 -0400", hash_original_method = "232D6784857554322EB1F91BB9F6CC48", hash_generated_method = "81EECD1BB7315BAA962BBD222DB8AB46")
    private int getInnerHeight(TextView widget) {
        int var99A6A405D49CFB17B685FBA2C3B645E4_1979896871 = (widget.getHeight() - widget.getTotalPaddingTop() - widget.getTotalPaddingBottom());
        addTaint(widget.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_114384816 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_114384816;
        // ---------- Original Method ----------
        //return widget.getHeight() - widget.getTotalPaddingTop() - widget.getTotalPaddingBottom();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.925 -0400", hash_original_method = "BCC9C4F3EEFF08511FB2E9A20E83B404", hash_generated_method = "2520CE13179761AB880A93E270C50BB6")
    private int getCharacterWidth(TextView widget) {
        int varD2D617A927571E013F1AB0889DF28F56_1788901070 = ((int) Math.ceil(widget.getPaint().getFontSpacing()));
        addTaint(widget.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1646660524 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1646660524;
        // ---------- Original Method ----------
        //return (int) Math.ceil(widget.getPaint().getFontSpacing());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.942 -0400", hash_original_method = "32AF158BA043ADAC837409A280E9071B", hash_generated_method = "40B3D6632064EAA8D4BFA37403B486F4")
    private int getScrollBoundsLeft(TextView widget) {
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
        addTaint(widget.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537954131 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537954131;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.943 -0400", hash_original_method = "F8CD0B2B66ECC22BDFE1C77AF25A13D6", hash_generated_method = "82D4470EC9BBED2709EA3D0768F6C338")
    private int getScrollBoundsRight(TextView widget) {
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
        addTaint(widget.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828101266 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828101266;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.944 -0400", hash_original_method = "99A2FC579527B2CEA9AC5A41AD01795F", hash_generated_method = "EB10C52E2DC0866D513BA11E937E9761")
    protected boolean scrollLeft(TextView widget, Spannable buffer, int amount) {
        int minScrollX;
        minScrollX = getScrollBoundsLeft(widget);
        int scrollX;
        scrollX = widget.getScrollX();
        {
            scrollX = Math.max(scrollX - getCharacterWidth(widget) * amount, minScrollX);
            widget.scrollTo(scrollX, widget.getScrollY());
        } //End block
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(amount);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1150806943 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1150806943;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.957 -0400", hash_original_method = "34082555FFD2A1D5F6DB38655C7C2C48", hash_generated_method = "3A2CAF1BD2B7579DFFF1EE3276BA9CD3")
    protected boolean scrollRight(TextView widget, Spannable buffer, int amount) {
        int maxScrollX;
        maxScrollX = getScrollBoundsRight(widget) - getInnerWidth(widget);
        int scrollX;
        scrollX = widget.getScrollX();
        {
            scrollX = Math.min(scrollX + getCharacterWidth(widget) * amount, maxScrollX);
            widget.scrollTo(scrollX, widget.getScrollY());
        } //End block
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(amount);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2104163828 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2104163828;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.962 -0400", hash_original_method = "A3AFC4271D337C51C9B090DAD80C0547", hash_generated_method = "7FBF93788EA1A0AF3097B8DA27433698")
    protected boolean scrollUp(TextView widget, Spannable buffer, int amount) {
        Layout layout;
        layout = widget.getLayout();
        int top;
        top = widget.getScrollY();
        int topLine;
        topLine = layout.getLineForVertical(top);
        {
            boolean varEEE5BBB9733FB099657B9686D5BC78E7_772469344 = (layout.getLineTop(topLine) == top);
            {
                topLine -= 1;
            } //End block
        } //End collapsed parenthetic
        {
            topLine = Math.max(topLine - amount + 1, 0);
            Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(topLine));
        } //End block
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(amount);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1759227931 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1759227931;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.963 -0400", hash_original_method = "0BF828F72F7601E47AA52D725EC1C4EF", hash_generated_method = "B3DFE33FEE67BD32D31244951F296ABF")
    protected boolean scrollDown(TextView widget, Spannable buffer, int amount) {
        Layout layout;
        layout = widget.getLayout();
        int innerHeight;
        innerHeight = getInnerHeight(widget);
        int bottom;
        bottom = widget.getScrollY() + innerHeight;
        int bottomLine;
        bottomLine = layout.getLineForVertical(bottom);
        {
            boolean var030919D13F1284BB3F9B91F681DCB1BC_1445640761 = (layout.getLineTop(bottomLine + 1) < bottom + 1);
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
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(amount);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_902970433 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_902970433;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.967 -0400", hash_original_method = "961665135E04FC2BFD71FE9A7899CD8F", hash_generated_method = "ACB704C64852C4ADEBE608B468366195")
    protected boolean scrollPageUp(TextView widget, Spannable buffer) {
        Layout layout;
        layout = widget.getLayout();
        int top;
        top = widget.getScrollY() - getInnerHeight(widget);
        int topLine;
        topLine = layout.getLineForVertical(top);
        {
            Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(topLine));
        } //End block
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1324268168 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1324268168;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.993 -0400", hash_original_method = "FC4FA64E8CF6D16D369F4D51265A00D0", hash_generated_method = "4FA9B909F99094B5B65EE6C230D0BCB0")
    protected boolean scrollPageDown(TextView widget, Spannable buffer) {
        Layout layout;
        layout = widget.getLayout();
        int innerHeight;
        innerHeight = getInnerHeight(widget);
        int bottom;
        bottom = widget.getScrollY() + innerHeight + innerHeight;
        int bottomLine;
        bottomLine = layout.getLineForVertical(bottom);
        {
            boolean var70F0029FEFBA551A703CC1A7793615A5_1331986684 = (bottomLine <= layout.getLineCount() - 1);
            {
                Touch.scrollTo(widget, layout, widget.getScrollX(),
                    layout.getLineTop(bottomLine + 1) - innerHeight);
            } //End block
        } //End collapsed parenthetic
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928331258 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928331258;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.993 -0400", hash_original_method = "7CF9A5A04E9D7FD8D1056DC0F832B9EF", hash_generated_method = "1D751100E15C80C1F09668D66685FAE5")
    protected boolean scrollTop(TextView widget, Spannable buffer) {
        Layout layout;
        layout = widget.getLayout();
        {
            boolean varA4FA92505E883020183A6E88585B9BF8_1679683070 = (getTopLine(widget) >= 0);
            {
                Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(0));
            } //End block
        } //End collapsed parenthetic
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2061150721 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2061150721;
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (getTopLine(widget) >= 0) {
            //Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(0));
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.994 -0400", hash_original_method = "FCBCF26A13DC616293A73F9223FE45DF", hash_generated_method = "593810BEC5C9FE6B9F43983A4155D6A8")
    protected boolean scrollBottom(TextView widget, Spannable buffer) {
        Layout layout;
        layout = widget.getLayout();
        int lineCount;
        lineCount = layout.getLineCount();
        {
            boolean varB6ABA3DF3EBF85AF261C26BD0C4F402E_261864058 = (getBottomLine(widget) <= lineCount - 1);
            {
                Touch.scrollTo(widget, layout, widget.getScrollX(),
                    layout.getLineTop(lineCount) - getInnerHeight(widget));
            } //End block
        } //End collapsed parenthetic
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_766822089 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_766822089;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.994 -0400", hash_original_method = "FDDC66476559B51E1C65BE36B03CFE74", hash_generated_method = "31B5B4F69099440ACE79517194A940F3")
    protected boolean scrollLineStart(TextView widget, Spannable buffer) {
        int minScrollX;
        minScrollX = getScrollBoundsLeft(widget);
        int scrollX;
        scrollX = widget.getScrollX();
        {
            widget.scrollTo(minScrollX, widget.getScrollY());
        } //End block
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_868844951 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_868844951;
        // ---------- Original Method ----------
        //final int minScrollX = getScrollBoundsLeft(widget);
        //int scrollX = widget.getScrollX();
        //if (scrollX > minScrollX) {
            //widget.scrollTo(minScrollX, widget.getScrollY());
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.995 -0400", hash_original_method = "83871D5A105C781298F6AD1F6CCA2A68", hash_generated_method = "0B5B11D7C5535256AA569EB7A5FF5FD2")
    protected boolean scrollLineEnd(TextView widget, Spannable buffer) {
        int maxScrollX;
        maxScrollX = getScrollBoundsRight(widget) - getInnerWidth(widget);
        int scrollX;
        scrollX = widget.getScrollX();
        {
            widget.scrollTo(maxScrollX, widget.getScrollY());
        } //End block
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_533591762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_533591762;
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

