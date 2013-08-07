package android.app;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.NumberFormat;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.internal.R;






public class ProgressDialog extends AlertDialog {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.462 -0400", hash_original_field = "8E57A1AD458E8C11842F6CF5D7E06883", hash_generated_field = "77244E1CDBA901DF4A72F7384A95707A")

    private ProgressBar mProgress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.462 -0400", hash_original_field = "768B4DEF5F289C647A0FFACAF09B88CB", hash_generated_field = "461DDCE97AF551A1C6803EBC4533C15B")

    private TextView mMessageView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.462 -0400", hash_original_field = "3C01B54FB013B44502A679D52B9E8E4C", hash_generated_field = "D606E8AD4CB2138AB3E23AD40FAEF122")

    private int mProgressStyle = STYLE_SPINNER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.462 -0400", hash_original_field = "5842F5908165248A36D44C06DAD9E095", hash_generated_field = "B144E5A12AFBB6F4D43B9925DE81C337")

    private TextView mProgressNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.462 -0400", hash_original_field = "1C59558CC38D008257A363BDA65D0031", hash_generated_field = "919E83DFD466D019ADD12AA5B4AB137B")

    private String mProgressNumberFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.463 -0400", hash_original_field = "62AC1BC2B985215A9D310F464AE5C44B", hash_generated_field = "E1E15B58291253ABA7CD4CA5C053A29F")

    private TextView mProgressPercent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.463 -0400", hash_original_field = "A9B6F572387FDD285748C1B733801A39", hash_generated_field = "801BEF4B64C99340B750EC7CE4102A7A")

    private NumberFormat mProgressPercentFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.463 -0400", hash_original_field = "C886C6FF92A43B3F6833B7BAFD354FBA", hash_generated_field = "A1BFCC57A6BC96010A1D330EF07F3F34")

    private int mMax;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.463 -0400", hash_original_field = "5E8741E831828F60C397C0B58D4C2DD4", hash_generated_field = "24EC69CEF56B680AD8D4A6ABB0E5F818")

    private int mProgressVal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.463 -0400", hash_original_field = "F552E03C67F4E999DAB0DF5EE4448EA3", hash_generated_field = "4217821FA8C458E3FEC38C24E41044A4")

    private int mSecondaryProgressVal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.463 -0400", hash_original_field = "0DDA7933DD412EB58E35762015F6B91B", hash_generated_field = "02383EBC67D3065E0E23A2693D4D47D3")

    private int mIncrementBy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.463 -0400", hash_original_field = "0AA7CBA308EF87D2E43750AFA51CD8BF", hash_generated_field = "0BEE4F38AD86E1B9CC7469AF6E5775BA")

    private int mIncrementSecondaryBy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.463 -0400", hash_original_field = "35ACEA7B06E4E9292BB05774C2312E1C", hash_generated_field = "C7829E00A6912D78CF4DAAA1F03878F2")

    private Drawable mProgressDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.463 -0400", hash_original_field = "081CE0D8134A29404CF8CC8A86F7E0F6", hash_generated_field = "C689AC3D1D2B848F3E53B0D791A6559F")

    private Drawable mIndeterminateDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.464 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "B242999524A78B5E31650BFBB7850632")

    private CharSequence mMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.464 -0400", hash_original_field = "066BD2341E290903C1ACFDCFA38A9B44", hash_generated_field = "92F2421E00AF2915B64A009A8AEF51CA")

    private boolean mIndeterminate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.464 -0400", hash_original_field = "DB7AB0513255FC6EDE7219D5798C2D77", hash_generated_field = "62FBA97BE9733493DCEE6CDD41719180")

    private boolean mHasStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.464 -0400", hash_original_field = "BFA4F1C185EE5682C76991543B556A86", hash_generated_field = "9C96B0DBEEFCF0BF24069370A43F6E2A")

    private Handler mViewUpdateHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.464 -0400", hash_original_method = "92C5111B01C2F7487094F131EFA7D9CD", hash_generated_method = "C8F2A7C4E7F63DC79EE9B903878487F7")
    public  ProgressDialog(Context context) {
        super(context);
        addTaint(context.getTaint());
        initFormats();
        // ---------- Original Method ----------
        //initFormats();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.465 -0400", hash_original_method = "2063B34B32B727D3ADD346C69E61541B", hash_generated_method = "499F66C8C85ADCCE88CFC354BD6E2985")
    public  ProgressDialog(Context context, int theme) {
        super(context, theme);
        addTaint(theme);
        addTaint(context.getTaint());
        initFormats();
        // ---------- Original Method ----------
        //initFormats();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.465 -0400", hash_original_method = "FE2AC98467F95F1FDF5E365DE947BD3D", hash_generated_method = "EB60C8DF224A339DC28B96F8E67BA73A")
    private void initFormats() {
        mProgressNumberFormat = "%1d/%2d";
        mProgressPercentFormat = NumberFormat.getPercentInstance();
        mProgressPercentFormat.setMaximumFractionDigits(0);
        // ---------- Original Method ----------
        //mProgressNumberFormat = "%1d/%2d";
        //mProgressPercentFormat = NumberFormat.getPercentInstance();
        //mProgressPercentFormat.setMaximumFractionDigits(0);
    }

    
    @DSModeled(DSC.SPEC)
    public static ProgressDialog show(Context context, CharSequence title,
            CharSequence message) {
        return show(context, title, message, false);
    }

    
    @DSModeled(DSC.SPEC)
    public static ProgressDialog show(Context context, CharSequence title,
            CharSequence message, boolean indeterminate) {
        return show(context, title, message, indeterminate, false, null);
    }

    
    @DSModeled(DSC.SPEC)
    public static ProgressDialog show(Context context, CharSequence title,
            CharSequence message, boolean indeterminate, boolean cancelable) {
        return show(context, title, message, indeterminate, cancelable, null);
    }

    
    public static ProgressDialog show(Context context, CharSequence title,
            CharSequence message, boolean indeterminate,
            boolean cancelable, OnCancelListener cancelListener) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setIndeterminate(indeterminate);
        dialog.setCancelable(cancelable);
        dialog.setOnCancelListener(cancelListener);
        dialog.show();
        return dialog;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.475 -0400", hash_original_method = "3C62C073499C0C1AB7CB80CDA6A00701", hash_generated_method = "F3B1B33B448A8B5A64A88D838A9F4694")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        LayoutInflater inflater = LayoutInflater.from(mContext);
        TypedArray a = mContext.obtainStyledAttributes(null,
                com.android.internal.R.styleable.AlertDialog,
                com.android.internal.R.attr.alertDialogStyle, 0);
        if(mProgressStyle == STYLE_HORIZONTAL)        
        {
            mViewUpdateHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.472 -0400", hash_original_method = "7104A26B01D6B673482D82C714B7E2C7", hash_generated_method = "0A6E57203DC523B22C7FA7DD0019D1A3")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            super.handleMessage(msg);
            int progress = mProgress.getProgress();
            int max = mProgress.getMax();
            if(mProgressNumberFormat != null)            
            {
                String format = mProgressNumberFormat;
                mProgressNumber.setText(String.format(format, progress, max));
            } //End block
            else
            {
                mProgressNumber.setText("");
            } //End block
            if(mProgressPercentFormat != null)            
            {
                double percent = (double) progress / (double) max;
                SpannableString tmp = new SpannableString(mProgressPercentFormat.format(percent));
                tmp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD),
                                0, tmp.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                mProgressPercent.setText(tmp);
            } //End block
            else
            {
                mProgressPercent.setText("");
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
};
            View view = inflater.inflate(a.getResourceId(
                    com.android.internal.R.styleable.AlertDialog_horizontalProgressLayout,
                    R.layout.alert_dialog_progress), null);
            mProgress = (ProgressBar) view.findViewById(R.id.progress);
            mProgressNumber = (TextView) view.findViewById(R.id.progress_number);
            mProgressPercent = (TextView) view.findViewById(R.id.progress_percent);
            setView(view);
        } //End block
        else
        {
            View view = inflater.inflate(a.getResourceId(
                    com.android.internal.R.styleable.AlertDialog_progressLayout,
                    R.layout.progress_dialog), null);
            mProgress = (ProgressBar) view.findViewById(R.id.progress);
            mMessageView = (TextView) view.findViewById(R.id.message);
            setView(view);
        } //End block
        a.recycle();
        if(mMax > 0)        
        {
            setMax(mMax);
        } //End block
        if(mProgressVal > 0)        
        {
            setProgress(mProgressVal);
        } //End block
        if(mSecondaryProgressVal > 0)        
        {
            setSecondaryProgress(mSecondaryProgressVal);
        } //End block
        if(mIncrementBy > 0)        
        {
            incrementProgressBy(mIncrementBy);
        } //End block
        if(mIncrementSecondaryBy > 0)        
        {
            incrementSecondaryProgressBy(mIncrementSecondaryBy);
        } //End block
        if(mProgressDrawable != null)        
        {
            setProgressDrawable(mProgressDrawable);
        } //End block
        if(mIndeterminateDrawable != null)        
        {
            setIndeterminateDrawable(mIndeterminateDrawable);
        } //End block
        if(mMessage != null)        
        {
            setMessage(mMessage);
        } //End block
        setIndeterminate(mIndeterminate);
        onProgressChanged();
        super.onCreate(savedInstanceState);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.477 -0400", hash_original_method = "E4C380672C091716BA880A9F39495F13", hash_generated_method = "D96DD738669DD0F97C550EA7D446DAAF")
    @Override
    public void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStart();
        mHasStarted = true;
        // ---------- Original Method ----------
        //super.onStart();
        //mHasStarted = true;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.478 -0400", hash_original_method = "167333ED7F36A78C04285C2EEC5DCE22", hash_generated_method = "CA0145CDF0F773E726BCE8702522BE73")
    @Override
    protected void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStop();
        mHasStarted = false;
        // ---------- Original Method ----------
        //super.onStop();
        //mHasStarted = false;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.479 -0400", hash_original_method = "23FC1AAA73A8AF68F967E7C4900FBF4D", hash_generated_method = "18D7ED23AA1B10B9E6A56B9078FB67D0")
    public void setProgress(int value) {
        if(mHasStarted)        
        {
            mProgress.setProgress(value);
            onProgressChanged();
        } //End block
        else
        {
            mProgressVal = value;
        } //End block
        // ---------- Original Method ----------
        //if (mHasStarted) {
            //mProgress.setProgress(value);
            //onProgressChanged();
        //} else {
            //mProgressVal = value;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.481 -0400", hash_original_method = "6E4750DDBC0AC16C300E83EC6E6DBC1D", hash_generated_method = "97BC4668F32198E8F25070B2DC67928E")
    public void setSecondaryProgress(int secondaryProgress) {
        if(mProgress != null)        
        {
            mProgress.setSecondaryProgress(secondaryProgress);
            onProgressChanged();
        } //End block
        else
        {
            mSecondaryProgressVal = secondaryProgress;
        } //End block
        // ---------- Original Method ----------
        //if (mProgress != null) {
            //mProgress.setSecondaryProgress(secondaryProgress);
            //onProgressChanged();
        //} else {
            //mSecondaryProgressVal = secondaryProgress;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.481 -0400", hash_original_method = "4D0AEB75C79AE0306A009E89E85077BB", hash_generated_method = "39FFA63B0345AC14627FD245982AD050")
    public int getProgress() {
        if(mProgress != null)        
        {
            int var292796CFCEE66A472904F5FA591BCC36_1447992927 = (mProgress.getProgress());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_53926771 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_53926771;
        } //End block
        int var5E8741E831828F60C397C0B58D4C2DD4_1152106774 = (mProgressVal);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557393960 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557393960;
        // ---------- Original Method ----------
        //if (mProgress != null) {
            //return mProgress.getProgress();
        //}
        //return mProgressVal;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.482 -0400", hash_original_method = "58FB68124F7103A7657A430EF8D5C27D", hash_generated_method = "584609706BBA1942EE130F355FF0F8B0")
    public int getSecondaryProgress() {
        if(mProgress != null)        
        {
            int var90A0D87DC3797D82B2B98D2C5446EBC4_1197778366 = (mProgress.getSecondaryProgress());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622069975 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622069975;
        } //End block
        int varF552E03C67F4E999DAB0DF5EE4448EA3_1277981835 = (mSecondaryProgressVal);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183712368 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183712368;
        // ---------- Original Method ----------
        //if (mProgress != null) {
            //return mProgress.getSecondaryProgress();
        //}
        //return mSecondaryProgressVal;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.483 -0400", hash_original_method = "B2C91689E392BFA0100BFE7CD7CBCF9A", hash_generated_method = "5B03911899A4D1D38B8BF4D5F1005C45")
    public int getMax() {
        if(mProgress != null)        
        {
            int var8928C3CF458B77783751A22F222C0F96_107874564 = (mProgress.getMax());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1602470748 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1602470748;
        } //End block
        int varC886C6FF92A43B3F6833B7BAFD354FBA_1333313557 = (mMax);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1559686263 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1559686263;
        // ---------- Original Method ----------
        //if (mProgress != null) {
            //return mProgress.getMax();
        //}
        //return mMax;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.484 -0400", hash_original_method = "823B39538AFD9A862BBB0CFD9EF1E653", hash_generated_method = "DCCD9F44809BE846A2E4D4386280730D")
    public void setMax(int max) {
        if(mProgress != null)        
        {
            mProgress.setMax(max);
            onProgressChanged();
        } //End block
        else
        {
            mMax = max;
        } //End block
        // ---------- Original Method ----------
        //if (mProgress != null) {
            //mProgress.setMax(max);
            //onProgressChanged();
        //} else {
            //mMax = max;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.486 -0400", hash_original_method = "445D81214DF2B063E62A55D5F8A17F23", hash_generated_method = "174E8B55067E0CF8A7D5C5419831531E")
    public void incrementProgressBy(int diff) {
        if(mProgress != null)        
        {
            mProgress.incrementProgressBy(diff);
            onProgressChanged();
        } //End block
        else
        {
            mIncrementBy += diff;
        } //End block
        // ---------- Original Method ----------
        //if (mProgress != null) {
            //mProgress.incrementProgressBy(diff);
            //onProgressChanged();
        //} else {
            //mIncrementBy += diff;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.487 -0400", hash_original_method = "ACDD0F5A55036B735620D3E49831AA1C", hash_generated_method = "841371A88B83560F209D63A0B796D0E9")
    public void incrementSecondaryProgressBy(int diff) {
        if(mProgress != null)        
        {
            mProgress.incrementSecondaryProgressBy(diff);
            onProgressChanged();
        } //End block
        else
        {
            mIncrementSecondaryBy += diff;
        } //End block
        // ---------- Original Method ----------
        //if (mProgress != null) {
            //mProgress.incrementSecondaryProgressBy(diff);
            //onProgressChanged();
        //} else {
            //mIncrementSecondaryBy += diff;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.487 -0400", hash_original_method = "BF189ED691A8CB1AA1828F7DFAB16E61", hash_generated_method = "67F658A537AD2BBFB6D2FE0B2202855F")
    public void setProgressDrawable(Drawable d) {
        if(mProgress != null)        
        {
            mProgress.setProgressDrawable(d);
        } //End block
        else
        {
            mProgressDrawable = d;
        } //End block
        // ---------- Original Method ----------
        //if (mProgress != null) {
            //mProgress.setProgressDrawable(d);
        //} else {
            //mProgressDrawable = d;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.489 -0400", hash_original_method = "55A3C3032B86D6D77860B6605EF0B7F9", hash_generated_method = "F9021E2B403438273A020FD71BE5010C")
    public void setIndeterminateDrawable(Drawable d) {
        if(mProgress != null)        
        {
            mProgress.setIndeterminateDrawable(d);
        } //End block
        else
        {
            mIndeterminateDrawable = d;
        } //End block
        // ---------- Original Method ----------
        //if (mProgress != null) {
            //mProgress.setIndeterminateDrawable(d);
        //} else {
            //mIndeterminateDrawable = d;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.490 -0400", hash_original_method = "87844978D06A223987B222FFA166DFBA", hash_generated_method = "C9A3F9E10B5F181198E6EE74040148FB")
    public void setIndeterminate(boolean indeterminate) {
        if(mProgress != null)        
        {
            mProgress.setIndeterminate(indeterminate);
        } //End block
        else
        {
            mIndeterminate = indeterminate;
        } //End block
        // ---------- Original Method ----------
        //if (mProgress != null) {
            //mProgress.setIndeterminate(indeterminate);
        //} else {
            //mIndeterminate = indeterminate;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.491 -0400", hash_original_method = "91BE21C4F81E2907389C6C7DE0F7DEB9", hash_generated_method = "C64FF1177E426224D626E320EA8792AA")
    public boolean isIndeterminate() {
        if(mProgress != null)        
        {
            boolean var679E7A5E5DF9C5A0941CDD91F263DD31_1089678846 = (mProgress.isIndeterminate());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482172282 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482172282;
        } //End block
        boolean var066BD2341E290903C1ACFDCFA38A9B44_24730211 = (mIndeterminate);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382533957 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_382533957;
        // ---------- Original Method ----------
        //if (mProgress != null) {
            //return mProgress.isIndeterminate();
        //}
        //return mIndeterminate;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.492 -0400", hash_original_method = "AFD34C008702B9F6492C001F2A71B115", hash_generated_method = "BE89C27492FBBDAA43AF53BEA18E23FF")
    @Override
    public void setMessage(CharSequence message) {
        if(mProgress != null)        
        {
            if(mProgressStyle == STYLE_HORIZONTAL)            
            {
                super.setMessage(message);
            } //End block
            else
            {
                mMessageView.setText(message);
            } //End block
        } //End block
        else
        {
            mMessage = message;
        } //End block
        // ---------- Original Method ----------
        //if (mProgress != null) {
            //if (mProgressStyle == STYLE_HORIZONTAL) {
                //super.setMessage(message);
            //} else {
                //mMessageView.setText(message);
            //}
        //} else {
            //mMessage = message;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.494 -0400", hash_original_method = "85F4612555E33B447C725C49965B14D6", hash_generated_method = "4273143CCA6E95A2C8596BE20934D03B")
    public void setProgressStyle(int style) {
        mProgressStyle = style;
        // ---------- Original Method ----------
        //mProgressStyle = style;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.495 -0400", hash_original_method = "B0BFAE800A15CED2E9D1DC398253EB1C", hash_generated_method = "F482EA4B05B7D51B24E03A24216110BC")
    public void setProgressNumberFormat(String format) {
        mProgressNumberFormat = format;
        onProgressChanged();
        // ---------- Original Method ----------
        //mProgressNumberFormat = format;
        //onProgressChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.496 -0400", hash_original_method = "4324E732D77BC0648AC0ECF3DB6A3F8F", hash_generated_method = "9C8F46C8F794E97CBBAB7656535BB4DC")
    public void setProgressPercentFormat(NumberFormat format) {
        mProgressPercentFormat = format;
        onProgressChanged();
        // ---------- Original Method ----------
        //mProgressPercentFormat = format;
        //onProgressChanged();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.497 -0400", hash_original_method = "28A5BA5A84A47E224F80ADB1F1423669", hash_generated_method = "3381CDF2225D84E26B49476232567754")
    private void onProgressChanged() {
        if(mProgressStyle == STYLE_HORIZONTAL)        
        {
            if(mViewUpdateHandler != null && !mViewUpdateHandler.hasMessages(0))            
            {
                mViewUpdateHandler.sendEmptyMessage(0);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mProgressStyle == STYLE_HORIZONTAL) {
            //if (mViewUpdateHandler != null && !mViewUpdateHandler.hasMessages(0)) {
                //mViewUpdateHandler.sendEmptyMessage(0);
            //}
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.497 -0400", hash_original_field = "B704989AC93CDD7359531BC1271B6699", hash_generated_field = "8E4B753198D7E1478BD4980982C5E4B0")

    public static final int STYLE_SPINNER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.498 -0400", hash_original_field = "34AD4F285C90BC4056FBA291E780C3FB", hash_generated_field = "71151F676EF3890F6697F6CEF895DD7A")

    public static final int STYLE_HORIZONTAL = 1;
}

