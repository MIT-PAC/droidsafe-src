package android.text.method;

// Droidsafe Imports
import android.text.Layout;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ScrollingMovementMethod extends BaseMovementMethod implements MovementMethod {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.716 -0400", hash_original_method = "997C1BE7C30077BC0332DB617608ABA5", hash_generated_method = "997C1BE7C30077BC0332DB617608ABA5")
    public ScrollingMovementMethod ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.716 -0400", hash_original_method = "4575BF452832A0D7CE335FE2D333B9A8", hash_generated_method = "5989048C6B91DAA4C6E1BC4CAB73A242")
    @Override
    protected boolean left(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var9A8F6C3DAFB76B0507053213DC846BAD_1707603077 = (scrollLeft(widget, buffer, 1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_928960089 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_928960089;
        // ---------- Original Method ----------
        //return scrollLeft(widget, buffer, 1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.717 -0400", hash_original_method = "E8486D1C2D56FFC371988279D1AD8571", hash_generated_method = "47531C4A679DC9E4FBE566E92422A159")
    @Override
    protected boolean right(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean varF2C830BA8F221D47B627A74DBDB92A5A_1947277170 = (scrollRight(widget, buffer, 1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_903401562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_903401562;
        // ---------- Original Method ----------
        //return scrollRight(widget, buffer, 1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.717 -0400", hash_original_method = "1155FFC79CCA2014F7E16D97983A80B8", hash_generated_method = "8994E54E5FCE1C5109539E40CEB2EA56")
    @Override
    protected boolean up(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var12D2A31960AFB2BBC8F9B23731F513A4_973061879 = (scrollUp(widget, buffer, 1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_756950776 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_756950776;
        // ---------- Original Method ----------
        //return scrollUp(widget, buffer, 1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.718 -0400", hash_original_method = "FCF9DD7A394B565166B77EC48277B9BE", hash_generated_method = "03980861189DCB1907F1875DA63A3B0A")
    @Override
    protected boolean down(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var6817B0F42CEE5008712A5E7FC6702E3A_1842212023 = (scrollDown(widget, buffer, 1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1904184755 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1904184755;
        // ---------- Original Method ----------
        //return scrollDown(widget, buffer, 1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.718 -0400", hash_original_method = "6AC637482165D29C2C4109F9D569279C", hash_generated_method = "7F02A391FB47289E90EBABE4A51C7329")
    @Override
    protected boolean pageUp(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var5AF185FF86C85EC7E1E7EECEB6E3DEB5_521696478 = (scrollPageUp(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_635666965 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_635666965;
        // ---------- Original Method ----------
        //return scrollPageUp(widget, buffer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.719 -0400", hash_original_method = "290A98973A36AD8EEE0D3D32B5DA2AC3", hash_generated_method = "1638407EEA60212809C6A078734531BE")
    @Override
    protected boolean pageDown(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var1E14859E3C53B33E207F55D853D92831_738957511 = (scrollPageDown(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_792389246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_792389246;
        // ---------- Original Method ----------
        //return scrollPageDown(widget, buffer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.720 -0400", hash_original_method = "96FE67A8B27885C4870A2D965DD698B2", hash_generated_method = "C9A5A96A83E4E39EE2EFB1C3E1857F9C")
    @Override
    protected boolean top(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean varB314B6E7CE2B4D28F744350851993E74_1735700463 = (scrollTop(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1561009821 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1561009821;
        // ---------- Original Method ----------
        //return scrollTop(widget, buffer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.720 -0400", hash_original_method = "6D879379D7CBA6045850AECFB8A1C165", hash_generated_method = "4B02C2B3F16B3C510CDD3596467860DD")
    @Override
    protected boolean bottom(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var90E352F21C2388D01D5BE717B6B18BE8_1635048766 = (scrollBottom(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_324892450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_324892450;
        // ---------- Original Method ----------
        //return scrollBottom(widget, buffer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.721 -0400", hash_original_method = "28541DE829E7071F01F9CFB8222A0CA3", hash_generated_method = "ACCF198F3999D281C56D2E1185957FAE")
    @Override
    protected boolean lineStart(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var730D6DFBEB20847A8ECFADDA7313102F_720288832 = (scrollLineStart(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_816488378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_816488378;
        // ---------- Original Method ----------
        //return scrollLineStart(widget, buffer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.721 -0400", hash_original_method = "633692CF531080A659FB64ED1AA4A5F4", hash_generated_method = "2C9A3FE2B856FD2A55B6D213192485F2")
    @Override
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var5B51638B3022F4CFABB18BD4A87D0F6A_708450569 = (scrollLineEnd(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1443148564 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1443148564;
        // ---------- Original Method ----------
        //return scrollLineEnd(widget, buffer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.721 -0400", hash_original_method = "C15EA31EA0FD3AAF4D2911A25A30C355", hash_generated_method = "5EFD8A50F3102660270C9E142EFBB66E")
    @Override
    protected boolean home(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var424EFC0BF224F3CC0BCA6C388F135791_32805500 = (top(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_392961106 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_392961106;
        // ---------- Original Method ----------
        //return top(widget, buffer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.722 -0400", hash_original_method = "8A16106DF26D61EEC58C1723A12C8B5F", hash_generated_method = "597B4A85559E69460A0AE18CE62F79ED")
    @Override
    protected boolean end(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean varC0FE786DF7B84990831CD6E0AC6030F4_679281070 = (bottom(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_935540620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_935540620;
        // ---------- Original Method ----------
        //return bottom(widget, buffer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.722 -0400", hash_original_method = "A7480C6BC5D883E26DF36990823FBEAF", hash_generated_method = "D8C81F1ED2CC53FD9E299ECED4AF67C8")
    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var2DDCF6F59EC11F3CA6774211C85E2239_239519669 = (Touch.onTouchEvent(widget, buffer, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_896200671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_896200671;
        // ---------- Original Method ----------
        //return Touch.onTouchEvent(widget, buffer, event);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.723 -0400", hash_original_method = "171EBC702B28CBB8F3E97F4458472A3A", hash_generated_method = "6231E95CF651359DEF093E01716F8985")
    @Override
    public void onTakeFocus(TextView widget, Spannable text, int dir) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(dir);
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
        Layout layout = widget.getLayout();
        if(layout != null && (dir & View.FOCUS_FORWARD) != 0)        
        {
            widget.scrollTo(widget.getScrollX(),
                            layout.getLineTop(0));
        } //End block
        if(layout != null && (dir & View.FOCUS_BACKWARD) != 0)        
        {
            int padding = widget.getTotalPaddingTop() +
                          widget.getTotalPaddingBottom();
            int line = layout.getLineCount() - 1;
            widget.scrollTo(widget.getScrollX(),
                            layout.getLineTop(line+1) -
                            (widget.getHeight() - padding));
        } //End block
        // ---------- Original Method ----------
        //Layout layout = widget.getLayout();
        //if (layout != null && (dir & View.FOCUS_FORWARD) != 0) {
            //widget.scrollTo(widget.getScrollX(),
                            //layout.getLineTop(0));
        //}
        //if (layout != null && (dir & View.FOCUS_BACKWARD) != 0) {
            //int padding = widget.getTotalPaddingTop() +
                          //widget.getTotalPaddingBottom();
            //int line = layout.getLineCount() - 1;
            //widget.scrollTo(widget.getScrollX(),
                            //layout.getLineTop(line+1) -
                            //(widget.getHeight() - padding));
        //}
    }

    
    @DSModeled(DSC.SAFE)
    public static MovementMethod getInstance() {
        if (sInstance == null)
            sInstance = new ScrollingMovementMethod();
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.724 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "E3F2C749F87B458DFC8C00803F37AFF0")

    private static ScrollingMovementMethod sInstance;
}

