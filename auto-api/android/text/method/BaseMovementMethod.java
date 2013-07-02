package android.text.method;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.text.Layout;
import android.text.Spannable;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class BaseMovementMethod implements MovementMethod {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.045 -0400", hash_original_method = "1DE84F8ABE7124ECFD52F353C5E545C4", hash_generated_method = "1DE84F8ABE7124ECFD52F353C5E545C4")
    public BaseMovementMethod ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.045 -0400", hash_original_method = "3C8541B244B3E418A0704604E985C4F6", hash_generated_method = "61F16E3DED075F6BEFF73AD274B8DB03")
    @Override
    public boolean canSelectArbitrarily() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1277254798 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1277254798;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.046 -0400", hash_original_method = "D13D908BA0DAF76C398D062F3F380F09", hash_generated_method = "C57EDA36F09CC6129F642DA1BD1E4D7D")
    @Override
    public void initialize(TextView widget, Spannable text) {
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.046 -0400", hash_original_method = "51F4180929D179462C8A792E383BE4DE", hash_generated_method = "DEFDB21D0AA99F70D9D40621047146E8")
    @Override
    public boolean onKeyDown(TextView widget, Spannable text, int keyCode, KeyEvent event) {
        
        final int movementMetaState = getMovementMetaState(text, event);
        boolean handled = handleMovementKey(widget, text, keyCode, movementMetaState, event);
        {
            MetaKeyKeyListener.adjustMetaAfterKeypress(text);
            MetaKeyKeyListener.resetLockedMeta(text);
        } 
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2147050263 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2147050263;
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.047 -0400", hash_original_method = "8FECF2F4DB21657DC257EBEAC5D3F348", hash_generated_method = "78A1E1F6C86A610C2FDE80066FB4962E")
    @Override
    public boolean onKeyOther(TextView widget, Spannable text, KeyEvent event) {
        
        final int movementMetaState = getMovementMetaState(text, event);
        final int keyCode = event.getKeyCode();
        {
            boolean varC5978A4FB4364F803569EDCCE2DC1BA1_310508053 = (keyCode != KeyEvent.KEYCODE_UNKNOWN
                && event.getAction() == KeyEvent.ACTION_MULTIPLE);
            {
                final int repeat = event.getRepeatCount();
                boolean handled = false;
                {
                    int i = 0;
                    {
                        {
                            boolean varB934909A57248142D896FFD0AC144DC8_1889941757 = (!handleMovementKey(widget, text, keyCode, movementMetaState, event));
                        } 
                        handled = true;
                    } 
                } 
                {
                    MetaKeyKeyListener.adjustMetaAfterKeypress(text);
                    MetaKeyKeyListener.resetLockedMeta(text);
                } 
            } 
        } 
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_432862411 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_432862411;
        
        
        
        
                
            
            
            
                
                    
                
                
            
            
                
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.047 -0400", hash_original_method = "03F6AD3B58EDAE8DF6A1CC395F5B54B3", hash_generated_method = "BA9B0A4D4F54B26655BC782661C77C2F")
    @Override
    public boolean onKeyUp(TextView widget, Spannable text, int keyCode, KeyEvent event) {
        
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_203597386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_203597386;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.047 -0400", hash_original_method = "AC3F1CB1818DDCB7BD27F03C760797A7", hash_generated_method = "D617C850B9E6AEDCA4942B3A21B86765")
    @Override
    public void onTakeFocus(TextView widget, Spannable text, int direction) {
        
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        addTaint(direction);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.048 -0400", hash_original_method = "136932FCA27B55C4FFFE4C0F482F5C95", hash_generated_method = "88747A82B3E2946578C1102029398581")
    @Override
    public boolean onTouchEvent(TextView widget, Spannable text, MotionEvent event) {
        
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1472362310 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1472362310;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.049 -0400", hash_original_method = "B091339813AE51B8A0FCC53026E81FDE", hash_generated_method = "7D9F07303968FEE1E1F9AB0F521C88CC")
    @Override
    public boolean onTrackballEvent(TextView widget, Spannable text, MotionEvent event) {
        
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1022935929 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1022935929;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.049 -0400", hash_original_method = "F7B7D807C9903B237C0BDFCF28378E9E", hash_generated_method = "46F8F81930C5FF631108914268310548")
    @Override
    public boolean onGenericMotionEvent(TextView widget, Spannable text, MotionEvent event) {
        
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_1583682839 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_224980144 = (event.getAction());
                    
                    {
                        float vscroll;
                        float hscroll;
                        {
                            boolean varB4D6A432BD6856FDF71FC12482F4DB92_289866095 = ((event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0);
                            {
                                vscroll = 0;
                                hscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                            } 
                            {
                                vscroll = -event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                                hscroll = event.getAxisValue(MotionEvent.AXIS_HSCROLL);
                            } 
                        } 
                        boolean handled = false;
                        {
                            handled |= scrollLeft(widget, text, (int)Math.ceil(-hscroll));
                        } 
                        {
                            handled |= scrollRight(widget, text, (int)Math.ceil(hscroll));
                        } 
                        {
                            handled |= scrollUp(widget, text, (int)Math.ceil(-vscroll));
                        } 
                        {
                            handled |= scrollDown(widget, text, (int)Math.ceil(vscroll));
                        } 
                    } 
                    
                } 
            } 
        } 
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_301083949 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_301083949;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.050 -0400", hash_original_method = "DBF5E10955F96650BAEE8C94618C2948", hash_generated_method = "01B2545132BBD05A525E68B719241E1B")
    protected int getMovementMetaState(Spannable buffer, KeyEvent event) {
        int metaState = (event.getMetaState() | MetaKeyKeyListener.getMetaState(buffer))
                & ~(MetaKeyKeyListener.META_ALT_LOCKED | MetaKeyKeyListener.META_SYM_LOCKED);
        int var222F3A165AD44F34AEC0D203BF2F0E46_1064647003 = (KeyEvent.normalizeMetaState(metaState) & ~KeyEvent.META_SHIFT_MASK);
        addTaint(buffer.getTaint());
        addTaint(event.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925610154 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925610154;
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.051 -0400", hash_original_method = "53B656A1E8393E8F576933E71ADE5872", hash_generated_method = "01AA1D74B761A19DFA75DF35C9DF6B7E")
    protected boolean handleMovementKey(TextView widget, Spannable buffer,
            int keyCode, int movementMetaState, KeyEvent event) {
        
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1190067943 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean var68D671775614B8A3392859D5A7BFB272_232552339 = (left(widget, buffer));
            } 
            {
                boolean varF7CBF05BAA26D1F0FE66CD64B99CDBDC_2133209024 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON));
                {
                    boolean var8B70984B6D204986E86DC5E9D21EE379_1371808540 = (leftWord(widget, buffer));
                } 
                {
                    boolean var0C59350E9823D9FDC411AFB3B4E4D995_1705039892 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                    {
                        boolean varF91F8ED470DB3CB92941B7FB32F16F98_1279259855 = (lineStart(widget, buffer));
                    } 
                } 
            } 
        } 
        
        
        {
            boolean varD311727E65FDD806D61A6271FF483A84_2128363223 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean var611677DDD7BCF208C2108267C92093F0_1163355260 = (right(widget, buffer));
            } 
            {
                boolean varF7CBF05BAA26D1F0FE66CD64B99CDBDC_560839233 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON));
                {
                    boolean var5AAE0481ED9ADA837863356FCD6CBF51_1434949598 = (rightWord(widget, buffer));
                } 
                {
                    boolean var0C59350E9823D9FDC411AFB3B4E4D995_278040447 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                    {
                        boolean varB65D932CCFD36B7EACB4EE7EE3C54F1E_1643813836 = (lineEnd(widget, buffer));
                    } 
                } 
            } 
        } 
        
        
        {
            boolean varD311727E65FDD806D61A6271FF483A84_605795450 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean var7FA4D50FEE7D0B231F734E91D2642307_1561760415 = (up(widget, buffer));
            } 
            {
                boolean var5E32B625D4444A09AA68BCFD992ECE2D_1527121962 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                {
                    boolean var7EA610619321657A9AD12517CB6DB46F_1154272395 = (top(widget, buffer));
                } 
            } 
        } 
        
        
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1975757397 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean var8755A1382E2B8967B38EC82AC8AD7026_1369091490 = (down(widget, buffer));
            } 
            {
                boolean var5E32B625D4444A09AA68BCFD992ECE2D_1525117646 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                {
                    boolean var147A9E526C33B1617033994832B32BCD_1307280199 = (bottom(widget, buffer));
                } 
            } 
        } 
        
        
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1563208777 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean var7A20B6A7ADD620ED36BF97D295E03752_1541958155 = (pageUp(widget, buffer));
            } 
            {
                boolean var5E32B625D4444A09AA68BCFD992ECE2D_616372027 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                {
                    boolean var7EA610619321657A9AD12517CB6DB46F_1729114761 = (top(widget, buffer));
                } 
            } 
        } 
        
        
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1921151126 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean varEAE8B54B2ED18C0A322E5C2C2227ABFE_1657564889 = (pageDown(widget, buffer));
            } 
            {
                boolean var5E32B625D4444A09AA68BCFD992ECE2D_1527980808 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON));
                {
                    boolean var147A9E526C33B1617033994832B32BCD_27417223 = (bottom(widget, buffer));
                } 
            } 
        } 
        
        
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1059039848 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean varB99A5007A511DDDDEC7F28357AA472F1_1855136181 = (home(widget, buffer));
            } 
            {
                boolean varF7CBF05BAA26D1F0FE66CD64B99CDBDC_137277016 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON));
                {
                    boolean var7EA610619321657A9AD12517CB6DB46F_1202199091 = (top(widget, buffer));
                } 
            } 
        } 
        
        
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1557517830 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                boolean varFD118AD11A361DEDA24BCD2A88D3C277_1466980417 = (end(widget, buffer));
            } 
            {
                boolean varF7CBF05BAA26D1F0FE66CD64B99CDBDC_2106453229 = (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON));
                {
                    boolean var147A9E526C33B1617033994832B32BCD_1104548841 = (bottom(widget, buffer));
                } 
            } 
        } 
        
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(keyCode);
        addTaint(movementMetaState);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1868545553 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1868545553;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.051 -0400", hash_original_method = "176341E451B55C50C4D903315018153A", hash_generated_method = "8BCBE6C7A5D724228A46D3F3BD5D2736")
    protected boolean left(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_940135925 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_940135925;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.052 -0400", hash_original_method = "68CC4A5755726297BC90EB8071236539", hash_generated_method = "A0341F1D54E34B2D38C6749A2EDFD47C")
    protected boolean right(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_128754125 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_128754125;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.052 -0400", hash_original_method = "4C3F0CF20A3CBF82271A73533254C678", hash_generated_method = "885BDAEBA6513132FE771CBE9497DADC")
    protected boolean up(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_697250951 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_697250951;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.052 -0400", hash_original_method = "FDACBEC8690232193991EC2D654F498C", hash_generated_method = "7333F3B7E9E87B778F676DDC044A1945")
    protected boolean down(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_552639894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_552639894;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.053 -0400", hash_original_method = "C9503F691DAF48A1F140F42890F719F7", hash_generated_method = "4050009FCE0FAC29A53B97AE167F1324")
    protected boolean pageUp(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1561527345 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1561527345;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.053 -0400", hash_original_method = "EA27CD9461C85470B182D05F37CF9E99", hash_generated_method = "EE2932D1CB2BF8C61D555463C719E81F")
    protected boolean pageDown(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_517363422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_517363422;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.053 -0400", hash_original_method = "3F6686FAC1641E4D3DFFC3F0DB33E5B2", hash_generated_method = "F18FD5550F7B013D56B9BFEF9B8BF0BA")
    protected boolean top(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_695440740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_695440740;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.053 -0400", hash_original_method = "721AC2C980F4969C548FB1DE5C82C277", hash_generated_method = "F06D31DC1F76E21D7B167EF5B35D790F")
    protected boolean bottom(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_868042898 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_868042898;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.054 -0400", hash_original_method = "A4B1F2E867C9A510C601A243C52C492E", hash_generated_method = "693E6E54D1D45F517D3BA695B8CE6FA6")
    protected boolean lineStart(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_829416619 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_829416619;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.054 -0400", hash_original_method = "A632F71919730AFFFF566F700D39B7D0", hash_generated_method = "B26B57A705B07BB25989AD7F9DDD2D0D")
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_174015391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_174015391;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.054 -0400", hash_original_method = "1043D0C7BC940A703E52A54D62DB9381", hash_generated_method = "27B99478F2443AC6D81FB08825DE6BBB")
    protected boolean leftWord(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1078195086 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1078195086;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.054 -0400", hash_original_method = "8D9EF29844655A160F605C571CBB67AE", hash_generated_method = "84014AAA8965AB321DEEEA71BC036F11")
    protected boolean rightWord(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1276005395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1276005395;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.055 -0400", hash_original_method = "8E23D2BEC9459FE2CC91B2DD463DCF3F", hash_generated_method = "9A8145EC1088A39BFD5B83EF579CBF78")
    protected boolean home(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1975505604 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1975505604;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.055 -0400", hash_original_method = "6807F0AF3535B8AAE125BEB8D24FA4BA", hash_generated_method = "A4F7B2E447FC8F619DFEA506CEB5763C")
    protected boolean end(TextView widget, Spannable buffer) {
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_337237167 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_337237167;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.055 -0400", hash_original_method = "772DAE7A7DE9A4DC4AD657418C90F32E", hash_generated_method = "624BAB20B0312886541A56589BF32408")
    private int getTopLine(TextView widget) {
        int var805F4348DA22D9BE2CA9DD1502114BBC_138993481 = (widget.getLayout().getLineForVertical(widget.getScrollY()));
        addTaint(widget.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_510417795 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_510417795;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.055 -0400", hash_original_method = "653A8A6EB137C95052F7EAEBCC41BD55", hash_generated_method = "8A281B5CA0D6A4095A4AA15BAE935527")
    private int getBottomLine(TextView widget) {
        int var802B9CFC7F9FC9F6D5306002E1A24D67_171594003 = (widget.getLayout().getLineForVertical(widget.getScrollY() + getInnerHeight(widget)));
        addTaint(widget.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52547455 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52547455;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.056 -0400", hash_original_method = "C7082848D94AD1EC4FC0EC3514A56C71", hash_generated_method = "44FAFBC7EBAC3068531FCF834BE44408")
    private int getInnerWidth(TextView widget) {
        int var5E051DC25D40FEA956D6187DC3B3424F_1472701895 = (widget.getWidth() - widget.getTotalPaddingLeft() - widget.getTotalPaddingRight());
        addTaint(widget.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1996261690 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1996261690;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.056 -0400", hash_original_method = "232D6784857554322EB1F91BB9F6CC48", hash_generated_method = "48C5FF5F11F4C3B4C1CF90A33F1A1D62")
    private int getInnerHeight(TextView widget) {
        int var99A6A405D49CFB17B685FBA2C3B645E4_1479367680 = (widget.getHeight() - widget.getTotalPaddingTop() - widget.getTotalPaddingBottom());
        addTaint(widget.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2085209729 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2085209729;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.056 -0400", hash_original_method = "BCC9C4F3EEFF08511FB2E9A20E83B404", hash_generated_method = "01D3DB9F9E880A474B8C7FAFCAC5B62A")
    private int getCharacterWidth(TextView widget) {
        int varD2D617A927571E013F1AB0889DF28F56_1251469417 = ((int) Math.ceil(widget.getPaint().getFontSpacing()));
        addTaint(widget.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_695987150 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_695987150;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.057 -0400", hash_original_method = "32AF158BA043ADAC837409A280E9071B", hash_generated_method = "912E24CB36CC6CD49782C23C488E73BC")
    private int getScrollBoundsLeft(TextView widget) {
        final Layout layout = widget.getLayout();
        final int topLine = getTopLine(widget);
        final int bottomLine = getBottomLine(widget);
        int left = Integer.MAX_VALUE;
        {
            int line = topLine;
            {
                final int lineLeft = (int) Math.floor(layout.getLineLeft(line));
                {
                    left = lineLeft;
                } 
            } 
        } 
        addTaint(widget.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1484012638 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1484012638;
        
        
        
        
        
            
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.057 -0400", hash_original_method = "F8CD0B2B66ECC22BDFE1C77AF25A13D6", hash_generated_method = "D1563316988B74AF816AC23D9047302D")
    private int getScrollBoundsRight(TextView widget) {
        final Layout layout = widget.getLayout();
        final int topLine = getTopLine(widget);
        final int bottomLine = getBottomLine(widget);
        int right = Integer.MIN_VALUE;
        {
            int line = topLine;
            {
                final int lineRight = (int) Math.ceil(layout.getLineRight(line));
                {
                    right = lineRight;
                } 
            } 
        } 
        addTaint(widget.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_563584076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_563584076;
        
        
        
        
        
            
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.058 -0400", hash_original_method = "99A2FC579527B2CEA9AC5A41AD01795F", hash_generated_method = "18E2680551A51197B673334987CD3B89")
    protected boolean scrollLeft(TextView widget, Spannable buffer, int amount) {
        final int minScrollX = getScrollBoundsLeft(widget);
        int scrollX = widget.getScrollX();
        {
            scrollX = Math.max(scrollX - getCharacterWidth(widget) * amount, minScrollX);
            widget.scrollTo(scrollX, widget.getScrollY());
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(amount);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_485735883 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_485735883;
        
        
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.059 -0400", hash_original_method = "34082555FFD2A1D5F6DB38655C7C2C48", hash_generated_method = "19960DFCE957FD39E24AE128734D54EB")
    protected boolean scrollRight(TextView widget, Spannable buffer, int amount) {
        final int maxScrollX = getScrollBoundsRight(widget) - getInnerWidth(widget);
        int scrollX = widget.getScrollX();
        {
            scrollX = Math.min(scrollX + getCharacterWidth(widget) * amount, maxScrollX);
            widget.scrollTo(scrollX, widget.getScrollY());
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(amount);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1853322669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1853322669;
        
        
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.060 -0400", hash_original_method = "A3AFC4271D337C51C9B090DAD80C0547", hash_generated_method = "D9B4053255A295D236873734930CAD06")
    protected boolean scrollUp(TextView widget, Spannable buffer, int amount) {
        final Layout layout = widget.getLayout();
        final int top = widget.getScrollY();
        int topLine = layout.getLineForVertical(top);
        {
            boolean varEEE5BBB9733FB099657B9686D5BC78E7_1392634654 = (layout.getLineTop(topLine) == top);
            {
                topLine -= 1;
            } 
        } 
        {
            topLine = Math.max(topLine - amount + 1, 0);
            Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(topLine));
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(amount);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1514527005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1514527005;
        
        
        
        
        
            
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.061 -0400", hash_original_method = "0BF828F72F7601E47AA52D725EC1C4EF", hash_generated_method = "4F7CFB09C8AC333C027C4FB67AD14F5A")
    protected boolean scrollDown(TextView widget, Spannable buffer, int amount) {
        final Layout layout = widget.getLayout();
        final int innerHeight = getInnerHeight(widget);
        final int bottom = widget.getScrollY() + innerHeight;
        int bottomLine = layout.getLineForVertical(bottom);
        {
            boolean var030919D13F1284BB3F9B91F681DCB1BC_1092208601 = (layout.getLineTop(bottomLine + 1) < bottom + 1);
            {
                bottomLine += 1;
            } 
        } 
        final int limit = layout.getLineCount() - 1;
        {
            bottomLine = Math.min(bottomLine + amount - 1, limit);
            Touch.scrollTo(widget, layout, widget.getScrollX(),
                    layout.getLineTop(bottomLine + 1) - innerHeight);
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(amount);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1519169452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1519169452;
        
        
        
        
        
        
            
        
        
        
            
            
                    
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.061 -0400", hash_original_method = "961665135E04FC2BFD71FE9A7899CD8F", hash_generated_method = "0E0BC21E8CBF0CE19553248B7CFDCE8D")
    protected boolean scrollPageUp(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        final int top = widget.getScrollY() - getInnerHeight(widget);
        int topLine = layout.getLineForVertical(top);
        {
            Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(topLine));
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1922162903 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1922162903;
        
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.062 -0400", hash_original_method = "FC4FA64E8CF6D16D369F4D51265A00D0", hash_generated_method = "897A425A6846126E16A5E5ABAFC367C2")
    protected boolean scrollPageDown(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        final int innerHeight = getInnerHeight(widget);
        final int bottom = widget.getScrollY() + innerHeight + innerHeight;
        int bottomLine = layout.getLineForVertical(bottom);
        {
            boolean var70F0029FEFBA551A703CC1A7793615A5_469301555 = (bottomLine <= layout.getLineCount() - 1);
            {
                Touch.scrollTo(widget, layout, widget.getScrollX(),
                    layout.getLineTop(bottomLine + 1) - innerHeight);
            } 
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_738409564 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_738409564;
        
        
        
        
        
        
            
                    
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.062 -0400", hash_original_method = "7CF9A5A04E9D7FD8D1056DC0F832B9EF", hash_generated_method = "2C2853BAB74DEAEA5EF3DA04C5F7C429")
    protected boolean scrollTop(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        {
            boolean varA4FA92505E883020183A6E88585B9BF8_856409487 = (getTopLine(widget) >= 0);
            {
                Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(0));
            } 
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_55809702 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_55809702;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.063 -0400", hash_original_method = "FCBCF26A13DC616293A73F9223FE45DF", hash_generated_method = "3F09ADDC921219FF1E443AE9D0C9C58B")
    protected boolean scrollBottom(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        final int lineCount = layout.getLineCount();
        {
            boolean varB6ABA3DF3EBF85AF261C26BD0C4F402E_939670031 = (getBottomLine(widget) <= lineCount - 1);
            {
                Touch.scrollTo(widget, layout, widget.getScrollX(),
                    layout.getLineTop(lineCount) - getInnerHeight(widget));
            } 
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1211645558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1211645558;
        
        
        
        
            
                    
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.063 -0400", hash_original_method = "FDDC66476559B51E1C65BE36B03CFE74", hash_generated_method = "02129BC99FBBFF783B41522680A5C1B5")
    protected boolean scrollLineStart(TextView widget, Spannable buffer) {
        final int minScrollX = getScrollBoundsLeft(widget);
        int scrollX = widget.getScrollX();
        {
            widget.scrollTo(minScrollX, widget.getScrollY());
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2057700724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2057700724;
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.064 -0400", hash_original_method = "83871D5A105C781298F6AD1F6CCA2A68", hash_generated_method = "0BC788D81380A3C7D487683075627F69")
    protected boolean scrollLineEnd(TextView widget, Spannable buffer) {
        final int maxScrollX = getScrollBoundsRight(widget) - getInnerWidth(widget);
        int scrollX = widget.getScrollX();
        {
            widget.scrollTo(maxScrollX, widget.getScrollY());
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2132692478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2132692478;
        
        
        
        
            
            
        
        
    }

    
}

