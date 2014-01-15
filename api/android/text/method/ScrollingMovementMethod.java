package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.text.Layout;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class ScrollingMovementMethod extends BaseMovementMethod implements MovementMethod {

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.839 -0500", hash_original_method = "B3F3A19A7208089C7C1F22732FD8EEF0", hash_generated_method = "4FDB8BE771FAEF096FBF571BB07474FD")
    
public static MovementMethod getInstance() {
        if (sInstance == null)
            sInstance = new ScrollingMovementMethod();

        return sInstance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.843 -0500", hash_original_field = "4FDA3548CD411AA1A414666645C3D509", hash_generated_field = "E3F2C749F87B458DFC8C00803F37AFF0")

    private static ScrollingMovementMethod sInstance;
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.716 -0400", hash_original_method = "997C1BE7C30077BC0332DB617608ABA5", hash_generated_method = "997C1BE7C30077BC0332DB617608ABA5")
    public ScrollingMovementMethod ()
    {
        //Synthesized constructor
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.792 -0500", hash_original_method = "4575BF452832A0D7CE335FE2D333B9A8", hash_generated_method = "33F2C02DB63512AAB4013BAA4F6DAA02")
    
@Override
    protected boolean left(TextView widget, Spannable buffer) {
        return scrollLeft(widget, buffer, 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.796 -0500", hash_original_method = "E8486D1C2D56FFC371988279D1AD8571", hash_generated_method = "38F570EB2D4E7551D404B719278D92C3")
    
@Override
    protected boolean right(TextView widget, Spannable buffer) {
        return scrollRight(widget, buffer, 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.799 -0500", hash_original_method = "1155FFC79CCA2014F7E16D97983A80B8", hash_generated_method = "7872DCAE3D3C9C2045761A3C736B5899")
    
@Override
    protected boolean up(TextView widget, Spannable buffer) {
        return scrollUp(widget, buffer, 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.802 -0500", hash_original_method = "FCF9DD7A394B565166B77EC48277B9BE", hash_generated_method = "F68BDF2D322967BC53AF30B11D47756A")
    
@Override
    protected boolean down(TextView widget, Spannable buffer) {
        return scrollDown(widget, buffer, 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.805 -0500", hash_original_method = "6AC637482165D29C2C4109F9D569279C", hash_generated_method = "F839608DF24A84976AC5B8B477131E43")
    
@Override
    protected boolean pageUp(TextView widget, Spannable buffer) {
        return scrollPageUp(widget, buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.808 -0500", hash_original_method = "290A98973A36AD8EEE0D3D32B5DA2AC3", hash_generated_method = "2CA6F908C4D39432D0C05F54F8A45986")
    
@Override
    protected boolean pageDown(TextView widget, Spannable buffer) {
        return scrollPageDown(widget, buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.811 -0500", hash_original_method = "96FE67A8B27885C4870A2D965DD698B2", hash_generated_method = "3CDA59EBCC33AB302B20FF29E8FA187E")
    
@Override
    protected boolean top(TextView widget, Spannable buffer) {
        return scrollTop(widget, buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.815 -0500", hash_original_method = "6D879379D7CBA6045850AECFB8A1C165", hash_generated_method = "09E07D6A9DD0750FF690BB259D5C071F")
    
@Override
    protected boolean bottom(TextView widget, Spannable buffer) {
        return scrollBottom(widget, buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.819 -0500", hash_original_method = "28541DE829E7071F01F9CFB8222A0CA3", hash_generated_method = "677EB2A6D09CA15BB8A03B26915D55C4")
    
@Override
    protected boolean lineStart(TextView widget, Spannable buffer) {
        return scrollLineStart(widget, buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.822 -0500", hash_original_method = "633692CF531080A659FB64ED1AA4A5F4", hash_generated_method = "113F9A3281F281657FF248D7FF18C0D1")
    
@Override
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        return scrollLineEnd(widget, buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.825 -0500", hash_original_method = "C15EA31EA0FD3AAF4D2911A25A30C355", hash_generated_method = "085358784601361A60D440701B5F5687")
    
@Override
    protected boolean home(TextView widget, Spannable buffer) {
        return top(widget, buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.828 -0500", hash_original_method = "8A16106DF26D61EEC58C1723A12C8B5F", hash_generated_method = "C9A83DFA814929FEAC1374A379E55C00")
    
@Override
    protected boolean end(TextView widget, Spannable buffer) {
        return bottom(widget, buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.831 -0500", hash_original_method = "A7480C6BC5D883E26DF36990823FBEAF", hash_generated_method = "AB89F43484A7EE83F997A5257F522122")
    
@Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        return Touch.onTouchEvent(widget, buffer, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.835 -0500", hash_original_method = "171EBC702B28CBB8F3E97F4458472A3A", hash_generated_method = "5DCECA0897065B42021C2E345B7ECCC7")
    
@Override
    public void onTakeFocus(TextView widget, Spannable text, int dir) {
        Layout layout = widget.getLayout();

        if (layout != null && (dir & View.FOCUS_FORWARD) != 0) {
            widget.scrollTo(widget.getScrollX(),
                            layout.getLineTop(0));
        }
        if (layout != null && (dir & View.FOCUS_BACKWARD) != 0) {
            int padding = widget.getTotalPaddingTop() +
                          widget.getTotalPaddingBottom();
            int line = layout.getLineCount() - 1;

            widget.scrollTo(widget.getScrollX(),
                            layout.getLineTop(line+1) -
                            (widget.getHeight() - padding));
        }
    }
}

