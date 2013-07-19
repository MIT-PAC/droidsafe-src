package android.text.method;

// Droidsafe Imports
import android.text.Layout;
import android.text.Spannable;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class BaseMovementMethod implements MovementMethod {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.048 -0400", hash_original_method = "1DE84F8ABE7124ECFD52F353C5E545C4", hash_generated_method = "1DE84F8ABE7124ECFD52F353C5E545C4")
    public BaseMovementMethod ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.048 -0400", hash_original_method = "3C8541B244B3E418A0704604E985C4F6", hash_generated_method = "E1176C17631A9F45B230063CA3E538DB")
    @Override
    public boolean canSelectArbitrarily() {
        boolean var68934A3E9455FA72420237EB05902327_778111560 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1444683423 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1444683423;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.049 -0400", hash_original_method = "D13D908BA0DAF76C398D062F3F380F09", hash_generated_method = "15192064FC213288763008F6F54D3FA7")
    @Override
    public void initialize(TextView widget, Spannable text) {
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.049 -0400", hash_original_method = "51F4180929D179462C8A792E383BE4DE", hash_generated_method = "3AACE2179E15F9CCB788F2DDD3C2C08D")
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
        boolean var98F0599AF776A1FE4101C199A40EEB8F_200160704 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1298760381 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1298760381;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.049 -0400", hash_original_method = "8FECF2F4DB21657DC257EBEAC5D3F348", hash_generated_method = "E06F070FD9ED7080053C862F7983334C")
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
            boolean var98F0599AF776A1FE4101C199A40EEB8F_1951079738 = (handled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1715676819 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1715676819;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1967607199 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1158738771 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1158738771;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.049 -0400", hash_original_method = "03F6AD3B58EDAE8DF6A1CC395F5B54B3", hash_generated_method = "F8532EF69EF07CE88FBC25AA768F7676")
    @Override
    public boolean onKeyUp(TextView widget, Spannable text, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1488365826 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_421969675 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_421969675;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.049 -0400", hash_original_method = "AC3F1CB1818DDCB7BD27F03C760797A7", hash_generated_method = "45BEFD53752A40F7B900748932B941AA")
    @Override
    public void onTakeFocus(TextView widget, Spannable text, int direction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(direction);
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.050 -0400", hash_original_method = "136932FCA27B55C4FFFE4C0F482F5C95", hash_generated_method = "BA6C8E55E8446659F88AF32DC7FF0DA9")
    @Override
    public boolean onTouchEvent(TextView widget, Spannable text, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1045510975 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1353113711 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1353113711;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.050 -0400", hash_original_method = "B091339813AE51B8A0FCC53026E81FDE", hash_generated_method = "7D2BDB370C3609DDB59882900033F9D8")
    @Override
    public boolean onTrackballEvent(TextView widget, Spannable text, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_437026134 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_168093113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_168093113;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.050 -0400", hash_original_method = "F7B7D807C9903B237C0BDFCF28378E9E", hash_generated_method = "7E208A2E58DD91E004430CD0A4B1CA51")
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
                boolean var98F0599AF776A1FE4101C199A40EEB8F_1433112872 = (handled);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1601562337 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1601562337;
            } //End block
}
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1753491954 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1564630986 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1564630986;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.050 -0400", hash_original_method = "DBF5E10955F96650BAEE8C94618C2948", hash_generated_method = "4B43F8A140B11BA680D8DD5D2E497AD3")
    protected int getMovementMetaState(Spannable buffer, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(buffer.getTaint());
        int metaState = (event.getMetaState() | MetaKeyKeyListener.getMetaState(buffer))
                & ~(MetaKeyKeyListener.META_ALT_LOCKED | MetaKeyKeyListener.META_SYM_LOCKED);
        int var0618D9F169768B4A9154F0A9CE2BF1E3_1876915510 = (KeyEvent.normalizeMetaState(metaState) & ~KeyEvent.META_SHIFT_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844994120 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844994120;
        // ---------- Original Method ----------
        //int metaState = (event.getMetaState() | MetaKeyKeyListener.getMetaState(buffer))
                //& ~(MetaKeyKeyListener.META_ALT_LOCKED | MetaKeyKeyListener.META_SYM_LOCKED);
        //return KeyEvent.normalizeMetaState(metaState) & ~KeyEvent.META_SHIFT_MASK;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.064 -0400", hash_original_method = "53B656A1E8393E8F576933E71ADE5872", hash_generated_method = "A39D06FDAFAC7513560439745FB009FC")
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
            boolean varCF12E2CA38233705D4E21575A471F84F_746713376 = (left(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488832542 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488832542;
        } //End block
        else
        if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON))        
        {
            boolean varF2C063E36D8E381396852955CFB93108_2013173606 = (leftWord(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_144159121 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_144159121;
        } //End block
        else
        if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON))        
        {
            boolean var8A4EC837595EF2ADA26279838B03A6B4_533222150 = (lineStart(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_42345858 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_42345858;
        } //End block
        break;
        case KeyEvent.KEYCODE_DPAD_RIGHT:
        if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
            boolean varD48A2CEAAD3A206165D552168637CA85_212992759 = (right(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222029638 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_222029638;
        } //End block
        else
        if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON))        
        {
            boolean varF8EE3E1955B6189144933E629C582F24_1470760275 = (rightWord(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_147799327 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_147799327;
        } //End block
        else
        if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON))        
        {
            boolean varA7A846A276FEA3FA92892DE21D931845_729101966 = (lineEnd(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_406859395 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_406859395;
        } //End block
        break;
        case KeyEvent.KEYCODE_DPAD_UP:
        if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
            boolean varFE38488D025552D10C0658FA83A7624D_1681506559 = (up(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_658219057 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_658219057;
        } //End block
        else
        if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON))        
        {
            boolean var424EFC0BF224F3CC0BCA6C388F135791_387370241 = (top(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_886346856 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_886346856;
        } //End block
        break;
        case KeyEvent.KEYCODE_DPAD_DOWN:
        if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
            boolean varA73FB96498E02B33A28E038E6C9B0E97_1043446574 = (down(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104382430 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_104382430;
        } //End block
        else
        if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON))        
        {
            boolean varC0FE786DF7B84990831CD6E0AC6030F4_937922496 = (bottom(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1528641167 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1528641167;
        } //End block
        break;
        case KeyEvent.KEYCODE_PAGE_UP:
        if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
            boolean var8CC6249604ECEEC2097F62B55FC85F4B_214089833 = (pageUp(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_870671058 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_870671058;
        } //End block
        else
        if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON))        
        {
            boolean var424EFC0BF224F3CC0BCA6C388F135791_425151298 = (top(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_899798401 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_899798401;
        } //End block
        break;
        case KeyEvent.KEYCODE_PAGE_DOWN:
        if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
            boolean varD81B389CB65339161474B381E2B808B1_1831039275 = (pageDown(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1230418406 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1230418406;
        } //End block
        else
        if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON))        
        {
            boolean varC0FE786DF7B84990831CD6E0AC6030F4_1023219793 = (bottom(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1357182939 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1357182939;
        } //End block
        break;
        case KeyEvent.KEYCODE_MOVE_HOME:
        if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
            boolean varA59A30EF1E7E76FAF9A62F0ECFE24418_1431256487 = (home(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_513210985 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_513210985;
        } //End block
        else
        if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON))        
        {
            boolean var424EFC0BF224F3CC0BCA6C388F135791_986145344 = (top(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1152481449 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1152481449;
        } //End block
        break;
        case KeyEvent.KEYCODE_MOVE_END:
        if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
            boolean var8220B4DC73291CE01773DBBCF9C442EC_1553151960 = (end(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1924101369 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1924101369;
        } //End block
        else
        if(KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON))        
        {
            boolean varC0FE786DF7B84990831CD6E0AC6030F4_1385984956 = (bottom(widget, buffer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2035554875 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2035554875;
        } //End block
        break;
}        boolean var68934A3E9455FA72420237EB05902327_2022014889 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1403461653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1403461653;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.065 -0400", hash_original_method = "176341E451B55C50C4D903315018153A", hash_generated_method = "83E77F5E30F2F0CD5C8E30352E846142")
    protected boolean left(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1636716896 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008655348 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008655348;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.065 -0400", hash_original_method = "68CC4A5755726297BC90EB8071236539", hash_generated_method = "4655AD0C7626567D7A0261870D20A2EB")
    protected boolean right(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_791852613 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1927354229 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1927354229;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.065 -0400", hash_original_method = "4C3F0CF20A3CBF82271A73533254C678", hash_generated_method = "42FFBFB0CDE6AA9C7A096FDC45EED8E6")
    protected boolean up(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_172009470 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1191902076 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1191902076;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.065 -0400", hash_original_method = "FDACBEC8690232193991EC2D654F498C", hash_generated_method = "95A878A68A4B60B9A7AA376E93A92093")
    protected boolean down(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1335758436 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1671860204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1671860204;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.065 -0400", hash_original_method = "C9503F691DAF48A1F140F42890F719F7", hash_generated_method = "49898C01743A3363CC5073A01BC82270")
    protected boolean pageUp(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1223546029 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_631473785 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_631473785;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.065 -0400", hash_original_method = "EA27CD9461C85470B182D05F37CF9E99", hash_generated_method = "E0AB9A477116B342A76F74E16F1681B0")
    protected boolean pageDown(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_519559941 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241606662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241606662;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.065 -0400", hash_original_method = "3F6686FAC1641E4D3DFFC3F0DB33E5B2", hash_generated_method = "1A9D708AB83141371EA163DC2AA347BC")
    protected boolean top(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1920745257 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_943377037 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_943377037;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.066 -0400", hash_original_method = "721AC2C980F4969C548FB1DE5C82C277", hash_generated_method = "3A95B6167C1FBEDD61C4777185BADFB5")
    protected boolean bottom(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_593408174 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518756626 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518756626;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.066 -0400", hash_original_method = "A4B1F2E867C9A510C601A243C52C492E", hash_generated_method = "B66BD04071189A88922E79B8EA73B4F3")
    protected boolean lineStart(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_637626835 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1573173524 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1573173524;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.066 -0400", hash_original_method = "A632F71919730AFFFF566F700D39B7D0", hash_generated_method = "CE1568A7BF9D4EF7C2F82D3ADD310005")
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_332662397 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606557510 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606557510;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.066 -0400", hash_original_method = "1043D0C7BC940A703E52A54D62DB9381", hash_generated_method = "A27D7FC723716830909EFC256A26CB7A")
    protected boolean leftWord(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1099457166 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1495686558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1495686558;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.066 -0400", hash_original_method = "8D9EF29844655A160F605C571CBB67AE", hash_generated_method = "48083BEF06B037994547101A360B40B5")
    protected boolean rightWord(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_2131505647 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1112009206 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1112009206;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.066 -0400", hash_original_method = "8E23D2BEC9459FE2CC91B2DD463DCF3F", hash_generated_method = "7DB1E63B5B7DD82AC37CB2AF62838F93")
    protected boolean home(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_179407783 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_383668692 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_383668692;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.067 -0400", hash_original_method = "6807F0AF3535B8AAE125BEB8D24FA4BA", hash_generated_method = "76EAA1D638FED014840DBE126DC6240C")
    protected boolean end(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1506123139 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1593315611 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1593315611;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.067 -0400", hash_original_method = "772DAE7A7DE9A4DC4AD657418C90F32E", hash_generated_method = "317A256AA53B0A101A3BAE715A7504FB")
    private int getTopLine(TextView widget) {
        addTaint(widget.getTaint());
        int var7A2F7EBAD23CE795EA7F93727DD7199B_169304471 = (widget.getLayout().getLineForVertical(widget.getScrollY()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1321107847 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1321107847;
        // ---------- Original Method ----------
        //return widget.getLayout().getLineForVertical(widget.getScrollY());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.067 -0400", hash_original_method = "653A8A6EB137C95052F7EAEBCC41BD55", hash_generated_method = "1A7482D2A8F57E5FA502ECCEB402AEC0")
    private int getBottomLine(TextView widget) {
        addTaint(widget.getTaint());
        int var34C29A643051F91B4A68CD4B172EAAAC_1924000829 = (widget.getLayout().getLineForVertical(widget.getScrollY() + getInnerHeight(widget)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050277951 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050277951;
        // ---------- Original Method ----------
        //return widget.getLayout().getLineForVertical(widget.getScrollY() + getInnerHeight(widget));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.067 -0400", hash_original_method = "C7082848D94AD1EC4FC0EC3514A56C71", hash_generated_method = "E28262D348DEC0B6BAA411FE9AFE368F")
    private int getInnerWidth(TextView widget) {
        addTaint(widget.getTaint());
        int varF7CC8B7E3BFDE8EFDC291157AF9CD870_1576834083 = (widget.getWidth() - widget.getTotalPaddingLeft() - widget.getTotalPaddingRight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_813014021 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_813014021;
        // ---------- Original Method ----------
        //return widget.getWidth() - widget.getTotalPaddingLeft() - widget.getTotalPaddingRight();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.067 -0400", hash_original_method = "232D6784857554322EB1F91BB9F6CC48", hash_generated_method = "A0D3167482A7FA7B9068583962CFD54F")
    private int getInnerHeight(TextView widget) {
        addTaint(widget.getTaint());
        int var45EAE2B9789DA4F3B5BF7A71EAD2146F_900960750 = (widget.getHeight() - widget.getTotalPaddingTop() - widget.getTotalPaddingBottom());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1826875957 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1826875957;
        // ---------- Original Method ----------
        //return widget.getHeight() - widget.getTotalPaddingTop() - widget.getTotalPaddingBottom();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.067 -0400", hash_original_method = "BCC9C4F3EEFF08511FB2E9A20E83B404", hash_generated_method = "A94755FD656D05BEDC84C3573166EE3C")
    private int getCharacterWidth(TextView widget) {
        addTaint(widget.getTaint());
        int varD7401C759798984FE0DAC36221045B3D_282011315 = ((int) Math.ceil(widget.getPaint().getFontSpacing()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1613612719 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1613612719;
        // ---------- Original Method ----------
        //return (int) Math.ceil(widget.getPaint().getFontSpacing());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.068 -0400", hash_original_method = "32AF158BA043ADAC837409A280E9071B", hash_generated_method = "71B3ABCE893391566FB6B93656B48C73")
    private int getScrollBoundsLeft(TextView widget) {
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        final int topLine = getTopLine(widget);
        final int bottomLine = getBottomLine(widget);
        if(topLine > bottomLine)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1596930239 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254081465 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254081465;
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
        int var811882FECD5C7618D7099EBBD39EA254_2125803727 = (left);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516646088 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516646088;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.068 -0400", hash_original_method = "F8CD0B2B66ECC22BDFE1C77AF25A13D6", hash_generated_method = "A48A64175BB035A096E7F86E6DEC7A1D")
    private int getScrollBoundsRight(TextView widget) {
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        final int topLine = getTopLine(widget);
        final int bottomLine = getBottomLine(widget);
        if(topLine > bottomLine)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_574679301 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1528925069 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1528925069;
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
        int var7C4F29407893C334A6CB7A87BF045C0D_979678252 = (right);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_649070735 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_649070735;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.068 -0400", hash_original_method = "99A2FC579527B2CEA9AC5A41AD01795F", hash_generated_method = "627DA97D369D16EDBBD9C065EA95AA9A")
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
            boolean varB326B5062B2F0E69046810717534CB09_67110012 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1239108731 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1239108731;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_704800253 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1737679246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1737679246;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.069 -0400", hash_original_method = "34082555FFD2A1D5F6DB38655C7C2C48", hash_generated_method = "8F26A9956CC2D043E2AF2BDAAE8EA775")
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
            boolean varB326B5062B2F0E69046810717534CB09_325889883 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_444865778 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_444865778;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1561405420 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_750699468 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_750699468;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.069 -0400", hash_original_method = "A3AFC4271D337C51C9B090DAD80C0547", hash_generated_method = "FEFB188D7F45011F62291A07341A6F4F")
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
            boolean varB326B5062B2F0E69046810717534CB09_1761829486 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1675677574 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1675677574;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_816448377 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_523167393 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_523167393;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.070 -0400", hash_original_method = "0BF828F72F7601E47AA52D725EC1C4EF", hash_generated_method = "C37FA42FA9CA0277213619E0B19BF527")
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
            boolean varB326B5062B2F0E69046810717534CB09_909870293 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1650129392 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1650129392;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1967079536 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_350719681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_350719681;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.070 -0400", hash_original_method = "961665135E04FC2BFD71FE9A7899CD8F", hash_generated_method = "5D654627A62B09DF872DBBF036283685")
    protected boolean scrollPageUp(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        final int top = widget.getScrollY() - getInnerHeight(widget);
        int topLine = layout.getLineForVertical(top);
        if(topLine >= 0)        
        {
            Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(topLine));
            boolean varB326B5062B2F0E69046810717534CB09_1739823742 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1501316003 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1501316003;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2131483573 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928293788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928293788;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.070 -0400", hash_original_method = "FC4FA64E8CF6D16D369F4D51265A00D0", hash_generated_method = "042DE12E09C3E60063B68F8225EC431C")
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
            boolean varB326B5062B2F0E69046810717534CB09_891736176 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1909963450 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1909963450;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_608875480 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179462677 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179462677;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.070 -0400", hash_original_method = "7CF9A5A04E9D7FD8D1056DC0F832B9EF", hash_generated_method = "650A09B835A25E0AC48818874BEE31FB")
    protected boolean scrollTop(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        if(getTopLine(widget) >= 0)        
        {
            Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(0));
            boolean varB326B5062B2F0E69046810717534CB09_793166940 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_698014399 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_698014399;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1688469872 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1576440851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1576440851;
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (getTopLine(widget) >= 0) {
            //Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(0));
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.070 -0400", hash_original_method = "FCBCF26A13DC616293A73F9223FE45DF", hash_generated_method = "9B94C134A2C85482DED29CD96A9F7614")
    protected boolean scrollBottom(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        final int lineCount = layout.getLineCount();
        if(getBottomLine(widget) <= lineCount - 1)        
        {
            Touch.scrollTo(widget, layout, widget.getScrollX(),
                    layout.getLineTop(lineCount) - getInnerHeight(widget));
            boolean varB326B5062B2F0E69046810717534CB09_1652049892 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_309408742 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_309408742;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_777798584 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1916058501 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1916058501;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.071 -0400", hash_original_method = "FDDC66476559B51E1C65BE36B03CFE74", hash_generated_method = "ED0BC97C2300F0ABC0F93E75F3C2D7B3")
    protected boolean scrollLineStart(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final int minScrollX = getScrollBoundsLeft(widget);
        int scrollX = widget.getScrollX();
        if(scrollX > minScrollX)        
        {
            widget.scrollTo(minScrollX, widget.getScrollY());
            boolean varB326B5062B2F0E69046810717534CB09_1350233798 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1800282304 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1800282304;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1224133946 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2075985574 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2075985574;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.071 -0400", hash_original_method = "83871D5A105C781298F6AD1F6CCA2A68", hash_generated_method = "2710E5C56D7B9078F333F9D0C062E0EE")
    protected boolean scrollLineEnd(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final int maxScrollX = getScrollBoundsRight(widget) - getInnerWidth(widget);
        int scrollX = widget.getScrollX();
        if(scrollX < maxScrollX)        
        {
            widget.scrollTo(maxScrollX, widget.getScrollY());
            boolean varB326B5062B2F0E69046810717534CB09_946244391 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_865595880 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_865595880;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_9495487 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1294568656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1294568656;
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

