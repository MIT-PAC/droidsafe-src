package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.R;
import android.annotation.Widget;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class TwoLineListItem extends RelativeLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:13.903 -0400", hash_original_field = "205BE263C74C715DC52CF9A7EA2D73ED", hash_generated_field = "F5573217E3FB17E4C2E05B5A614A374B")

    private TextView mText1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:13.903 -0400", hash_original_field = "1772A2F42FB317DE654726988EC76A3E", hash_generated_field = "9C503E03972B02D8593F75DB4A48C018")

    private TextView mText2;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:13.903 -0400", hash_original_method = "BC9E06923C52B4408C5799E621927130", hash_generated_method = "B726CCA79692212BE8C33AC86B2C78B5")
    public  TwoLineListItem(Context context) {
        this(context, null, 0);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:13.903 -0400", hash_original_method = "87B3C0D43C58ABA2C023B5293BE676E4", hash_generated_method = "834DF629CEC3FEE1495E5F9DCA14459F")
    public  TwoLineListItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:13.903 -0400", hash_original_method = "BAEB06BAE3C9E4F2F16A54E72A4BB3E7", hash_generated_method = "6C1882FFF437C814D18EB5F3EAEF362D")
    public  TwoLineListItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.TwoLineListItem, defStyle, 0);
        a.recycle();
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:13.904 -0400", hash_original_method = "8089C6FCEBF2C15DBA19075B8780AF97", hash_generated_method = "C9BF355422712BB517B06701C14C698B")
    @Override
    protected void onFinishInflate() {
        
        super.onFinishInflate();
        mText1 = (TextView) findViewById(com.android.internal.R.id.text1);
        mText2 = (TextView) findViewById(com.android.internal.R.id.text2);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:13.904 -0400", hash_original_method = "6D31016C3EFADAD00849C6FB753C3139", hash_generated_method = "38651C22AAC4E366A3E5C3514E81BCB3")
    public TextView getText1() {
TextView var43BEA2B78E19BF93FAB5B45950C069F2_1693616459 =         mText1;
        var43BEA2B78E19BF93FAB5B45950C069F2_1693616459.addTaint(taint);
        return var43BEA2B78E19BF93FAB5B45950C069F2_1693616459;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:13.904 -0400", hash_original_method = "3E15133DBF34E1DA0E6FF67809AEAC81", hash_generated_method = "DA84E924A49102EEB5B23E411CE54DDA")
    public TextView getText2() {
TextView var882466576CD0969F2DE58CB488A1C8BC_1054782041 =         mText2;
        var882466576CD0969F2DE58CB488A1C8BC_1054782041.addTaint(taint);
        return var882466576CD0969F2DE58CB488A1C8BC_1054782041;
        
        
    }

    
}

