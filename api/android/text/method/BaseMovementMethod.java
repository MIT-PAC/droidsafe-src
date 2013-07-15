package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.text.Layout;
import android.text.Spannable;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class BaseMovementMethod implements MovementMethod {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.406 -0400", hash_original_method = "1DE84F8ABE7124ECFD52F353C5E545C4", hash_generated_method = "1DE84F8ABE7124ECFD52F353C5E545C4")
    public BaseMovementMethod ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.406 -0400", hash_original_method = "3C8541B244B3E418A0704604E985C4F6", hash_generated_method = "A725A1F82EE3C10624D955524BD10000")
    @Override
    public boolean canSelectArbitrarily() {
        boolean var68934A3E9455FA72420237EB05902327_1349322066 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_886945790 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_886945790;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.407 -0400", hash_original_method = "D13D908BA0DAF76C398D062F3F380F09", hash_generated_method = "15192064FC213288763008F6F54D3FA7")
    @Override
    public void initialize(TextView widget, Spannable text) {
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.407 -0400", hash_original_method = "51F4180929D179462C8A792E383BE4DE", hash_generated_method = "4E63B590D18B91000B3565B389010DAC")
    @Override
    public boolean onKeyDown(TextView widget, Spannable text, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
        final int movementMetaState = getMovementMetaState(text, event);
        boolean handled = handleMovementKey(widget, text, keyCode, movementMetaState, event);
    if(handled)        
        {
            MetaKeyKeyListener.adjustMetaAfterKeypress(text);
            MetaKeyKeyListener.resetLockedMeta(text);
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_525284375 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1504372993 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1504372993;
        // ---------- Original Method ----------
        //final int movementMetaState = getMovementMetaState(text, event);
        //boolean handled = handleMovementKey(widget, text, keyCode, movementMetaState, event);
        //if (handled) {
            //MetaKeyKeyListener.adjustMetaAfterKeypress(text);
            //MetaKeyKeyListener.resetLockedMeta(text);
        //}
        //return handled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.408 -0400", hash_original_method = "8FECF2F4DB21657DC257EBEAC5D3F348", hash_generated_method = "79AEE0FD46F2C31CEF6A96737EBD6134")
    @Override
    public boolean onKeyOther(TextView widget, Spannable text, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
        final int movementMetaState = getMovementMetaState(text, event);
        final int keyCode = event.getKeyCode();
    if(keyCode != KeyEvent.KEYCODE_UNKNOWN
                && event.getAction() == KeyEvent.ACTION_MULTIPLE)        
        {
            final int repeat = event.getRepeatCount();
            boolean handled = false;
for(int i = 0;i < repeat;i++)
            {
    if(!handleMovementKey(widget, text, keyCode, movementMetaState, event))                
                {
                    break;
                } //End block
                handled = true;
            } //End block
    if(handled)            
            {
                MetaKeyKeyListener.adjustMetaAfterKeypress(text);
                MetaKeyKeyListener.resetLockedMeta(text);
            } //End block
            boolean var98F0599AF776A1FE4101C199A40EEB8F_1475129096 = (handled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_437088189 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_437088189;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_118596394 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_250794627 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_250794627;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.409 -0400", hash_original_method = "03F6AD3B58EDAE8DF6A1CC395F5B54B3", hash_generated_method = "3A5C00FB80C89CCBEE8EDB1ABAAFEAB4")
    @Override
    public boolean onKeyUp(TextView widget, Spannable text, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1647127841 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2027700593 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2027700593;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.409 -0400", hash_original_method = "AC3F1CB1818DDCB7BD27F03C760797A7", hash_generated_method = "45BEFD53752A40F7B900748932B941AA")
    @Override
    public void onTakeFocus(TextView widget, Spannable text, int direction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(direction);
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.410 -0400", hash_original_method = "136932FCA27B55C4FFFE4C0F482F5C95", hash_generated_method = "6C84AEDD76E1C4EAEBD4194D927CA072")
    @Override
    public boolean onTouchEvent(TextView widget, Spannable text, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_509190730 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1866965889 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1866965889;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.410 -0400", hash_original_method = "B091339813AE51B8A0FCC53026E81FDE", hash_generated_method = "B16D7BB6DF45CAD1A719102E5C5954D2")
    @Override
    public boolean onTrackballEvent(TextView widget, Spannable text, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_805316445 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_677290924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_677290924;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.413 -0400", hash_original_method = "F7B7D807C9903B237C0BDFCF28378E9E", hash_generated_method = "207924E5DF55CF2E3845183ADE74A4C3")
    @Override
    public boolean onGenericMotionEvent(TextView widget, Spannable text, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
    if((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0)        
        {
switch(event.getAction()){
            case MotionEvent.ACTION_SCROLL:
            {
                float vscroll;
                float hscroll;
    if((event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0)                
                {
                    vscroll = 0;
                    hscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                } //End block
                else
                {
                    vscroll = -event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                    hscroll = event.getAxisValue(MotionEvent.AXIS_HSCROLL);
                } //End block
                boolean handled = false;
    if(hscroll < 0)                
                {
                    handled |= scrollLeft(widget, text, (int)Math.ceil(-hscroll));
                } //End block
                else
    if(hscroll > 0)                
                {
                    handled |= scrollRight(widget, text, (int)Math.ceil(hscroll));
                } //End block
    if(vscroll < 0)                
                {
                    handled |= scrollUp(widget, text, (int)Math.ceil(-vscroll));
                } //End block
                else
    if(vscroll > 0)                
                {
                    handled |= scrollDown(widget, text, (int)Math.ceil(vscroll));
                } //End block
                boolean var98F0599AF776A1FE4101C199A40EEB8F_378300017 = (handled);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1721643604 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1721643604;
            } //End block
}
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_615604246 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1753616898 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1753616898;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.414 -0400", hash_original_method = "DBF5E10955F96650BAEE8C94618C2948", hash_generated_method = "038608E8DD9212F2FBACC310CAC447DE")
    protected int getMovementMetaState(Spannable buffer, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(buffer.getTaint());
        int metaState = (event.getMetaState() | MetaKeyKeyListener.getMetaState(buffer))
                & ~(MetaKeyKeyListener.META_ALT_LOCKED | MetaKeyKeyListener.META_SYM_LOCKED);
        int var0618D9F169768B4A9154F0A9CE2BF1E3_812228054 = (KeyEvent.normalizeMetaState(metaState) & ~KeyEvent.META_SHIFT_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_924270134 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_924270134;
        // ---------- Original Method ----------
        //int metaState = (event.getMetaState() | MetaKeyKeyListener.getMetaState(buffer))
                //& ~(MetaKeyKeyListener.META_ALT_LOCKED | MetaKeyKeyListener.META_SYM_LOCKED);
        //return KeyEvent.normalizeMetaState(metaState) & ~KeyEvent.META_SHIFT_MASK;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.415 -0400", hash_original_method = "53B656A1E8393E8F576933E71ADE5872", hash_generated_method = "8E5053279200D3C444851E5C17FF92BD")
    protected boolean handleMovementKey(TextView widget, Spannable buffer,
            int keyCode, int movementMetaState, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(movementMetaState);
        addTaint(keyCode);
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
switch(keyCode){
        case KeyEvent.KEYCODE_DPAD_LEFT:
    if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
            boolean varCF12E2CA38233705D4E21575A471F84F_2131775313 = (left(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1072029189 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1072029189;
        } //End block
        else
    if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON))        
        {
            boolean varF2C063E36D8E381396852955CFB93108_413844462 = (leftWord(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1457342143 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1457342143;
        } //End block
        else
    if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON))        
        {
            boolean var8A4EC837595EF2ADA26279838B03A6B4_983099669 = (lineStart(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50062159 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_50062159;
        } //End block
        break;
        case KeyEvent.KEYCODE_DPAD_RIGHT:
    if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
            boolean varD48A2CEAAD3A206165D552168637CA85_457892131 = (right(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_993044689 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_993044689;
        } //End block
        else
    if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON))        
        {
            boolean varF8EE3E1955B6189144933E629C582F24_284284326 = (rightWord(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1916964688 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1916964688;
        } //End block
        else
    if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON))        
        {
            boolean varA7A846A276FEA3FA92892DE21D931845_1155348937 = (lineEnd(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_381657840 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_381657840;
        } //End block
        break;
        case KeyEvent.KEYCODE_DPAD_UP:
    if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
            boolean varFE38488D025552D10C0658FA83A7624D_1510914807 = (up(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1758512217 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1758512217;
        } //End block
        else
    if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON))        
        {
            boolean var424EFC0BF224F3CC0BCA6C388F135791_1715880083 = (top(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_323994832 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_323994832;
        } //End block
        break;
        case KeyEvent.KEYCODE_DPAD_DOWN:
    if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
            boolean varA73FB96498E02B33A28E038E6C9B0E97_328261003 = (down(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1617132478 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1617132478;
        } //End block
        else
    if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON))        
        {
            boolean varC0FE786DF7B84990831CD6E0AC6030F4_1629343930 = (bottom(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_256617114 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_256617114;
        } //End block
        break;
        case KeyEvent.KEYCODE_PAGE_UP:
    if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
            boolean var8CC6249604ECEEC2097F62B55FC85F4B_282601644 = (pageUp(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1821745011 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1821745011;
        } //End block
        else
    if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON))        
        {
            boolean var424EFC0BF224F3CC0BCA6C388F135791_688607984 = (top(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_870437114 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_870437114;
        } //End block
        break;
        case KeyEvent.KEYCODE_PAGE_DOWN:
    if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
            boolean varD81B389CB65339161474B381E2B808B1_276667799 = (pageDown(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1246390305 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1246390305;
        } //End block
        else
    if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON))        
        {
            boolean varC0FE786DF7B84990831CD6E0AC6030F4_111707068 = (bottom(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_393876556 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_393876556;
        } //End block
        break;
        case KeyEvent.KEYCODE_MOVE_HOME:
    if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
            boolean varA59A30EF1E7E76FAF9A62F0ECFE24418_461076547 = (home(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2108524854 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2108524854;
        } //End block
        else
    if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON))        
        {
            boolean var424EFC0BF224F3CC0BCA6C388F135791_2009710607 = (top(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2060889883 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2060889883;
        } //End block
        break;
        case KeyEvent.KEYCODE_MOVE_END:
    if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
            boolean var8220B4DC73291CE01773DBBCF9C442EC_506698964 = (end(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1892825639 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1892825639;
        } //End block
        else
    if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON))        
        {
            boolean varC0FE786DF7B84990831CD6E0AC6030F4_1020960576 = (bottom(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1459196073 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1459196073;
        } //End block
        break;
}        boolean var68934A3E9455FA72420237EB05902327_505749182 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1500520177 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1500520177;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.417 -0400", hash_original_method = "176341E451B55C50C4D903315018153A", hash_generated_method = "988FD100217F72159F985559A7EAEEE9")
    protected boolean left(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_983810192 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1437089290 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1437089290;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.418 -0400", hash_original_method = "68CC4A5755726297BC90EB8071236539", hash_generated_method = "8BF8B177DC6CF66EF7F29B9D62146B7A")
    protected boolean right(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_2101016552 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_718036622 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_718036622;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.418 -0400", hash_original_method = "4C3F0CF20A3CBF82271A73533254C678", hash_generated_method = "31AD5A8C8A5A2BF15F1F8074741B8309")
    protected boolean up(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_931195985 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2012055749 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2012055749;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.418 -0400", hash_original_method = "FDACBEC8690232193991EC2D654F498C", hash_generated_method = "BF28A4D2D6F3EDE6386797F8346BF6D3")
    protected boolean down(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_453101586 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_716285386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_716285386;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.418 -0400", hash_original_method = "C9503F691DAF48A1F140F42890F719F7", hash_generated_method = "D1A4FE981F7F6019475D08B9B6CD44D7")
    protected boolean pageUp(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1728525986 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_905749340 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_905749340;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.419 -0400", hash_original_method = "EA27CD9461C85470B182D05F37CF9E99", hash_generated_method = "49974A5745388173D1053E76FA34F2B0")
    protected boolean pageDown(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1942983039 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1982658174 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1982658174;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.419 -0400", hash_original_method = "3F6686FAC1641E4D3DFFC3F0DB33E5B2", hash_generated_method = "A92D09CA23E604311BB36B22CD9713EA")
    protected boolean top(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_2113677909 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_95098572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_95098572;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.419 -0400", hash_original_method = "721AC2C980F4969C548FB1DE5C82C277", hash_generated_method = "DF1404D80DEF9681987D2F735FDD018D")
    protected boolean bottom(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_837713337 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1762504708 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1762504708;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.420 -0400", hash_original_method = "A4B1F2E867C9A510C601A243C52C492E", hash_generated_method = "A7380B32A57ADE9A7725840DA044BABA")
    protected boolean lineStart(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_21202842 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1707850252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1707850252;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.420 -0400", hash_original_method = "A632F71919730AFFFF566F700D39B7D0", hash_generated_method = "343DCF8A804F5421E2B8C544954D970B")
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1894885971 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_604650451 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_604650451;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.420 -0400", hash_original_method = "1043D0C7BC940A703E52A54D62DB9381", hash_generated_method = "FDDD509A1A9F1EF355CBCF7ACCB70A8D")
    protected boolean leftWord(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_635977185 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1942918265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1942918265;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.421 -0400", hash_original_method = "8D9EF29844655A160F605C571CBB67AE", hash_generated_method = "0D414618D275341BA6A65F6FD45273E4")
    protected boolean rightWord(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1621971759 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1840904553 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1840904553;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.421 -0400", hash_original_method = "8E23D2BEC9459FE2CC91B2DD463DCF3F", hash_generated_method = "6DEC505B7C9DF6C78D213C2F97478FDA")
    protected boolean home(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1589096250 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1302866490 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1302866490;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.421 -0400", hash_original_method = "6807F0AF3535B8AAE125BEB8D24FA4BA", hash_generated_method = "718722D348E9575531EB403057F07DEA")
    protected boolean end(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_209128004 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1517603677 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1517603677;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.421 -0400", hash_original_method = "772DAE7A7DE9A4DC4AD657418C90F32E", hash_generated_method = "D81D6955C00419099A0CD7395D6182FB")
    private int getTopLine(TextView widget) {
        addTaint(widget.getTaint());
        int var7A2F7EBAD23CE795EA7F93727DD7199B_2102199017 = (widget.getLayout().getLineForVertical(widget.getScrollY()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080081505 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080081505;
        // ---------- Original Method ----------
        //return widget.getLayout().getLineForVertical(widget.getScrollY());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.422 -0400", hash_original_method = "653A8A6EB137C95052F7EAEBCC41BD55", hash_generated_method = "DE2C7C84081D2A3529F2EE86D4F765A9")
    private int getBottomLine(TextView widget) {
        addTaint(widget.getTaint());
        int var34C29A643051F91B4A68CD4B172EAAAC_1867719286 = (widget.getLayout().getLineForVertical(widget.getScrollY() + getInnerHeight(widget)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651383880 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651383880;
        // ---------- Original Method ----------
        //return widget.getLayout().getLineForVertical(widget.getScrollY() + getInnerHeight(widget));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.422 -0400", hash_original_method = "C7082848D94AD1EC4FC0EC3514A56C71", hash_generated_method = "DB6FE13DF0B14FFF3F009657FABFF7DB")
    private int getInnerWidth(TextView widget) {
        addTaint(widget.getTaint());
        int varF7CC8B7E3BFDE8EFDC291157AF9CD870_619176849 = (widget.getWidth() - widget.getTotalPaddingLeft() - widget.getTotalPaddingRight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1206578296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1206578296;
        // ---------- Original Method ----------
        //return widget.getWidth() - widget.getTotalPaddingLeft() - widget.getTotalPaddingRight();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.422 -0400", hash_original_method = "232D6784857554322EB1F91BB9F6CC48", hash_generated_method = "3068CEE2CA83EA5200D21AD973645F6B")
    private int getInnerHeight(TextView widget) {
        addTaint(widget.getTaint());
        int var45EAE2B9789DA4F3B5BF7A71EAD2146F_2018555312 = (widget.getHeight() - widget.getTotalPaddingTop() - widget.getTotalPaddingBottom());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1870819487 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1870819487;
        // ---------- Original Method ----------
        //return widget.getHeight() - widget.getTotalPaddingTop() - widget.getTotalPaddingBottom();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.422 -0400", hash_original_method = "BCC9C4F3EEFF08511FB2E9A20E83B404", hash_generated_method = "EC917EC62F355E97543E26729F78BE83")
    private int getCharacterWidth(TextView widget) {
        addTaint(widget.getTaint());
        int varD7401C759798984FE0DAC36221045B3D_47931492 = ((int) Math.ceil(widget.getPaint().getFontSpacing()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811627868 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811627868;
        // ---------- Original Method ----------
        //return (int) Math.ceil(widget.getPaint().getFontSpacing());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.423 -0400", hash_original_method = "32AF158BA043ADAC837409A280E9071B", hash_generated_method = "AB30BC093C196B9FE1F6329A33D7AB3A")
    private int getScrollBoundsLeft(TextView widget) {
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        final int topLine = getTopLine(widget);
        final int bottomLine = getBottomLine(widget);
    if(topLine > bottomLine)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1358977171 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_310701270 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_310701270;
        } //End block
        int left = Integer.MAX_VALUE;
for(int line = topLine;line <= bottomLine;line++)
        {
            final int lineLeft = (int) Math.floor(layout.getLineLeft(line));
    if(lineLeft < left)            
            {
                left = lineLeft;
            } //End block
        } //End block
        int var811882FECD5C7618D7099EBBD39EA254_901251131 = (left);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_416039399 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_416039399;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.423 -0400", hash_original_method = "F8CD0B2B66ECC22BDFE1C77AF25A13D6", hash_generated_method = "0D5E990D4CF4DF3BAE88D3B15CD1BA01")
    private int getScrollBoundsRight(TextView widget) {
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        final int topLine = getTopLine(widget);
        final int bottomLine = getBottomLine(widget);
    if(topLine > bottomLine)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1415147930 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471759385 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471759385;
        } //End block
        int right = Integer.MIN_VALUE;
for(int line = topLine;line <= bottomLine;line++)
        {
            final int lineRight = (int) Math.ceil(layout.getLineRight(line));
    if(lineRight > right)            
            {
                right = lineRight;
            } //End block
        } //End block
        int var7C4F29407893C334A6CB7A87BF045C0D_1754388526 = (right);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_55990017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_55990017;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.424 -0400", hash_original_method = "99A2FC579527B2CEA9AC5A41AD01795F", hash_generated_method = "9C5C34C7D6CE8C99B537159C318D7DFE")
    protected boolean scrollLeft(TextView widget, Spannable buffer, int amount) {
        addTaint(amount);
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final int minScrollX = getScrollBoundsLeft(widget);
        int scrollX = widget.getScrollX();
    if(scrollX > minScrollX)        
        {
            scrollX = Math.max(scrollX - getCharacterWidth(widget) * amount, minScrollX);
            widget.scrollTo(scrollX, widget.getScrollY());
            boolean varB326B5062B2F0E69046810717534CB09_1899418127 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1683641831 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1683641831;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1750805677 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_166810619 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_166810619;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.425 -0400", hash_original_method = "34082555FFD2A1D5F6DB38655C7C2C48", hash_generated_method = "7372D9595A60888CB2F8F2409832A0A5")
    protected boolean scrollRight(TextView widget, Spannable buffer, int amount) {
        addTaint(amount);
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final int maxScrollX = getScrollBoundsRight(widget) - getInnerWidth(widget);
        int scrollX = widget.getScrollX();
    if(scrollX < maxScrollX)        
        {
            scrollX = Math.min(scrollX + getCharacterWidth(widget) * amount, maxScrollX);
            widget.scrollTo(scrollX, widget.getScrollY());
            boolean varB326B5062B2F0E69046810717534CB09_411924520 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2106593327 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2106593327;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_798457735 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_214042563 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_214042563;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.425 -0400", hash_original_method = "A3AFC4271D337C51C9B090DAD80C0547", hash_generated_method = "2063BA01C175532707D723CEB1EBE9EC")
    protected boolean scrollUp(TextView widget, Spannable buffer, int amount) {
        addTaint(amount);
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        final int top = widget.getScrollY();
        int topLine = layout.getLineForVertical(top);
    if(layout.getLineTop(topLine) == top)        
        {
            topLine -= 1;
        } //End block
    if(topLine >= 0)        
        {
            topLine = Math.max(topLine - amount + 1, 0);
            Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(topLine));
            boolean varB326B5062B2F0E69046810717534CB09_1583269750 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_934626754 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_934626754;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2002719583 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_59151621 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_59151621;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.426 -0400", hash_original_method = "0BF828F72F7601E47AA52D725EC1C4EF", hash_generated_method = "4B4E3B5A1ECBB0F427901C67C5477CB1")
    protected boolean scrollDown(TextView widget, Spannable buffer, int amount) {
        addTaint(amount);
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        final int innerHeight = getInnerHeight(widget);
        final int bottom = widget.getScrollY() + innerHeight;
        int bottomLine = layout.getLineForVertical(bottom);
    if(layout.getLineTop(bottomLine + 1) < bottom + 1)        
        {
            bottomLine += 1;
        } //End block
        final int limit = layout.getLineCount() - 1;
    if(bottomLine <= limit)        
        {
            bottomLine = Math.min(bottomLine + amount - 1, limit);
            Touch.scrollTo(widget, layout, widget.getScrollX(),
                    layout.getLineTop(bottomLine + 1) - innerHeight);
            boolean varB326B5062B2F0E69046810717534CB09_4308409 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1160395962 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1160395962;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_709724052 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_309886477 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_309886477;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.426 -0400", hash_original_method = "961665135E04FC2BFD71FE9A7899CD8F", hash_generated_method = "E43D1D47140CCA0B538B43501AF89557")
    protected boolean scrollPageUp(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        final int top = widget.getScrollY() - getInnerHeight(widget);
        int topLine = layout.getLineForVertical(top);
    if(topLine >= 0)        
        {
            Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(topLine));
            boolean varB326B5062B2F0E69046810717534CB09_38586843 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1274438512 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1274438512;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_272427821 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1376482434 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1376482434;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.427 -0400", hash_original_method = "FC4FA64E8CF6D16D369F4D51265A00D0", hash_generated_method = "9C394047CC0F9A4C68EDB45717A66CCB")
    protected boolean scrollPageDown(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        final int innerHeight = getInnerHeight(widget);
        final int bottom = widget.getScrollY() + innerHeight + innerHeight;
        int bottomLine = layout.getLineForVertical(bottom);
    if(bottomLine <= layout.getLineCount() - 1)        
        {
            Touch.scrollTo(widget, layout, widget.getScrollX(),
                    layout.getLineTop(bottomLine + 1) - innerHeight);
            boolean varB326B5062B2F0E69046810717534CB09_1571931466 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_309650319 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_309650319;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1591301597 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1864646252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1864646252;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.427 -0400", hash_original_method = "7CF9A5A04E9D7FD8D1056DC0F832B9EF", hash_generated_method = "861C29F4870804CAE2A5DD712835FDFA")
    protected boolean scrollTop(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
    if(getTopLine(widget) >= 0)        
        {
            Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(0));
            boolean varB326B5062B2F0E69046810717534CB09_567988050 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_305918128 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_305918128;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_978510679 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1318967809 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1318967809;
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (getTopLine(widget) >= 0) {
            //Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(0));
            //return true;
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.428 -0400", hash_original_method = "FCBCF26A13DC616293A73F9223FE45DF", hash_generated_method = "8CD8A7C97B356F29220EE33B550B5CAE")
    protected boolean scrollBottom(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        final int lineCount = layout.getLineCount();
    if(getBottomLine(widget) <= lineCount - 1)        
        {
            Touch.scrollTo(widget, layout, widget.getScrollX(),
                    layout.getLineTop(lineCount) - getInnerHeight(widget));
            boolean varB326B5062B2F0E69046810717534CB09_1097801578 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1673808198 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1673808198;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_178859213 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1593360161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1593360161;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.428 -0400", hash_original_method = "FDDC66476559B51E1C65BE36B03CFE74", hash_generated_method = "A122DF9741305D91D2E1271371DD1F6D")
    protected boolean scrollLineStart(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final int minScrollX = getScrollBoundsLeft(widget);
        int scrollX = widget.getScrollX();
    if(scrollX > minScrollX)        
        {
            widget.scrollTo(minScrollX, widget.getScrollY());
            boolean varB326B5062B2F0E69046810717534CB09_753291125 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_802231178 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_802231178;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1541558048 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1374857018 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1374857018;
        // ---------- Original Method ----------
        //final int minScrollX = getScrollBoundsLeft(widget);
        //int scrollX = widget.getScrollX();
        //if (scrollX > minScrollX) {
            //widget.scrollTo(minScrollX, widget.getScrollY());
            //return true;
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.428 -0400", hash_original_method = "83871D5A105C781298F6AD1F6CCA2A68", hash_generated_method = "6C948407D152C8AAAC72371742127BA1")
    protected boolean scrollLineEnd(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final int maxScrollX = getScrollBoundsRight(widget) - getInnerWidth(widget);
        int scrollX = widget.getScrollX();
    if(scrollX < maxScrollX)        
        {
            widget.scrollTo(maxScrollX, widget.getScrollY());
            boolean varB326B5062B2F0E69046810717534CB09_1771490192 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1747973731 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1747973731;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1437951030 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1341171949 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1341171949;
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

