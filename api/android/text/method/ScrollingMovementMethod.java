package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.MotionEvent;
import android.text.*;
import android.widget.TextView;
import android.view.View;

public class ScrollingMovementMethod extends BaseMovementMethod implements MovementMethod {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.921 -0400", hash_original_method = "997C1BE7C30077BC0332DB617608ABA5", hash_generated_method = "997C1BE7C30077BC0332DB617608ABA5")
    public ScrollingMovementMethod ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.922 -0400", hash_original_method = "4575BF452832A0D7CE335FE2D333B9A8", hash_generated_method = "97AC481C13F2827C3EAD52206A73C776")
    @Override
    protected boolean left(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var9A8F6C3DAFB76B0507053213DC846BAD_1054753030 = (scrollLeft(widget, buffer, 1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_568071207 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_568071207;
        // ---------- Original Method ----------
        //return scrollLeft(widget, buffer, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.922 -0400", hash_original_method = "E8486D1C2D56FFC371988279D1AD8571", hash_generated_method = "ECC2E80A7C665EC9E968CDB1D1C71B01")
    @Override
    protected boolean right(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean varF2C830BA8F221D47B627A74DBDB92A5A_1226878606 = (scrollRight(widget, buffer, 1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_795222998 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_795222998;
        // ---------- Original Method ----------
        //return scrollRight(widget, buffer, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.923 -0400", hash_original_method = "1155FFC79CCA2014F7E16D97983A80B8", hash_generated_method = "D6591C007683AB9F7A05AD956C7F3B40")
    @Override
    protected boolean up(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var12D2A31960AFB2BBC8F9B23731F513A4_1817628460 = (scrollUp(widget, buffer, 1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1873361715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1873361715;
        // ---------- Original Method ----------
        //return scrollUp(widget, buffer, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.924 -0400", hash_original_method = "FCF9DD7A394B565166B77EC48277B9BE", hash_generated_method = "3B1714D19CC47DBF96FFE9FACDF445C5")
    @Override
    protected boolean down(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var6817B0F42CEE5008712A5E7FC6702E3A_66270375 = (scrollDown(widget, buffer, 1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_980479313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_980479313;
        // ---------- Original Method ----------
        //return scrollDown(widget, buffer, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.924 -0400", hash_original_method = "6AC637482165D29C2C4109F9D569279C", hash_generated_method = "E8E010B29E51E52DB6AAEECA7A7BB13C")
    @Override
    protected boolean pageUp(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var5AF185FF86C85EC7E1E7EECEB6E3DEB5_1334357152 = (scrollPageUp(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_477620366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_477620366;
        // ---------- Original Method ----------
        //return scrollPageUp(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.925 -0400", hash_original_method = "290A98973A36AD8EEE0D3D32B5DA2AC3", hash_generated_method = "B448D891AC4EE6EA7BC0A03F9F2A6A19")
    @Override
    protected boolean pageDown(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var1E14859E3C53B33E207F55D853D92831_1440465772 = (scrollPageDown(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2128936865 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2128936865;
        // ---------- Original Method ----------
        //return scrollPageDown(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.925 -0400", hash_original_method = "96FE67A8B27885C4870A2D965DD698B2", hash_generated_method = "F5FDB09DFD7312D61E26A162379D68B5")
    @Override
    protected boolean top(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean varB314B6E7CE2B4D28F744350851993E74_2137054909 = (scrollTop(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_42907059 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_42907059;
        // ---------- Original Method ----------
        //return scrollTop(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.926 -0400", hash_original_method = "6D879379D7CBA6045850AECFB8A1C165", hash_generated_method = "E9C9615540E3C8B96A05C929F8DABE5A")
    @Override
    protected boolean bottom(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var90E352F21C2388D01D5BE717B6B18BE8_703914992 = (scrollBottom(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2128306962 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2128306962;
        // ---------- Original Method ----------
        //return scrollBottom(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.926 -0400", hash_original_method = "28541DE829E7071F01F9CFB8222A0CA3", hash_generated_method = "555C8F8BCCE0811B06594783358862FB")
    @Override
    protected boolean lineStart(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var730D6DFBEB20847A8ECFADDA7313102F_1877103385 = (scrollLineStart(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1565660369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1565660369;
        // ---------- Original Method ----------
        //return scrollLineStart(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.927 -0400", hash_original_method = "633692CF531080A659FB64ED1AA4A5F4", hash_generated_method = "0975B6E65E8E6E7134A2A9748AA3910C")
    @Override
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var5B51638B3022F4CFABB18BD4A87D0F6A_2122310507 = (scrollLineEnd(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_379737870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_379737870;
        // ---------- Original Method ----------
        //return scrollLineEnd(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.927 -0400", hash_original_method = "C15EA31EA0FD3AAF4D2911A25A30C355", hash_generated_method = "3EC341E63E63AB57C709AC31F1ED1A35")
    @Override
    protected boolean home(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var424EFC0BF224F3CC0BCA6C388F135791_1019758077 = (top(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1743954433 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1743954433;
        // ---------- Original Method ----------
        //return top(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.928 -0400", hash_original_method = "8A16106DF26D61EEC58C1723A12C8B5F", hash_generated_method = "C777F4C5685BF44B6683F4FE75BA6BAC")
    @Override
    protected boolean end(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean varC0FE786DF7B84990831CD6E0AC6030F4_2145155845 = (bottom(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_752259828 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_752259828;
        // ---------- Original Method ----------
        //return bottom(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.928 -0400", hash_original_method = "A7480C6BC5D883E26DF36990823FBEAF", hash_generated_method = "5CB4579958F2FD71C1F6B8D2AF5D8CC9")
    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var2DDCF6F59EC11F3CA6774211C85E2239_1698212805 = (Touch.onTouchEvent(widget, buffer, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1821275826 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1821275826;
        // ---------- Original Method ----------
        //return Touch.onTouchEvent(widget, buffer, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.928 -0400", hash_original_method = "171EBC702B28CBB8F3E97F4458472A3A", hash_generated_method = "6231E95CF651359DEF093E01716F8985")
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

    
        public static MovementMethod getInstance() {
        if (sInstance == null)
            sInstance = new ScrollingMovementMethod();
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.929 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "E3F2C749F87B458DFC8C00803F37AFF0")

    private static ScrollingMovementMethod sInstance;
}

