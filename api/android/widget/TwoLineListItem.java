package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;





public class TwoLineListItem extends RelativeLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:02.409 -0500", hash_original_field = "1A08D4AF3119810748DCC283DD7E10BC", hash_generated_field = "F5573217E3FB17E4C2E05B5A614A374B")


    private TextView mText1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:02.411 -0500", hash_original_field = "F98229843AEA245C72D2087EAA96F6DB", hash_generated_field = "9C503E03972B02D8593F75DB4A48C018")

    private TextView mText2;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:02.411 -0500", hash_original_method = "BC9E06923C52B4408C5799E621927130", hash_generated_method = "7080F0278EBB45E1853CFF79326BCB88")
    public TwoLineListItem(Context context) {
        this(context, null, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:02.412 -0500", hash_original_method = "87B3C0D43C58ABA2C023B5293BE676E4", hash_generated_method = "4871FB1F6D37841CB52B54C6E36AE2F1")
    public TwoLineListItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0); 
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:02.413 -0500", hash_original_method = "BAEB06BAE3C9E4F2F16A54E72A4BB3E7", hash_generated_method = "2A3FDBF318FB465BF391C0DDC999F490")
    public TwoLineListItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.TwoLineListItem, defStyle, 0);

        a.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:02.414 -0500", hash_original_method = "8089C6FCEBF2C15DBA19075B8780AF97", hash_generated_method = "920476040349633DFD9E643FA3AE3873")
    @Override
protected void onFinishInflate() {
        super.onFinishInflate();
        
        mText1 = (TextView) findViewById(com.android.internal.R.id.text1);
        mText2 = (TextView) findViewById(com.android.internal.R.id.text2);
    }
    
    /**
     * Returns a handle to the item with ID text1.
     * @return A handle to the item with ID text1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:02.415 -0500", hash_original_method = "6D31016C3EFADAD00849C6FB753C3139", hash_generated_method = "94B57183344FE551C5A82AD82F7E846A")
    public TextView getText1() {
        return mText1;
    }
    
    /**
     * Returns a handle to the item with ID text2.
     * @return A handle to the item with ID text2.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:02.416 -0500", hash_original_method = "3E15133DBF34E1DA0E6FF67809AEAC81", hash_generated_method = "68589246CEB40B35E20815867173DA1D")
    public TextView getText2() {
        return mText2;
    }

    
}

