package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.R;
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
import java.text.NumberFormat;

public class ProgressDialog extends AlertDialog {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.929 -0400", hash_original_field = "8E57A1AD458E8C11842F6CF5D7E06883", hash_generated_field = "77244E1CDBA901DF4A72F7384A95707A")

    private ProgressBar mProgress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.929 -0400", hash_original_field = "768B4DEF5F289C647A0FFACAF09B88CB", hash_generated_field = "461DDCE97AF551A1C6803EBC4533C15B")

    private TextView mMessageView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.929 -0400", hash_original_field = "3C01B54FB013B44502A679D52B9E8E4C", hash_generated_field = "D606E8AD4CB2138AB3E23AD40FAEF122")

    private int mProgressStyle = STYLE_SPINNER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.930 -0400", hash_original_field = "5842F5908165248A36D44C06DAD9E095", hash_generated_field = "B144E5A12AFBB6F4D43B9925DE81C337")

    private TextView mProgressNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.930 -0400", hash_original_field = "1C59558CC38D008257A363BDA65D0031", hash_generated_field = "919E83DFD466D019ADD12AA5B4AB137B")

    private String mProgressNumberFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.930 -0400", hash_original_field = "62AC1BC2B985215A9D310F464AE5C44B", hash_generated_field = "E1E15B58291253ABA7CD4CA5C053A29F")

    private TextView mProgressPercent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.930 -0400", hash_original_field = "A9B6F572387FDD285748C1B733801A39", hash_generated_field = "801BEF4B64C99340B750EC7CE4102A7A")

    private NumberFormat mProgressPercentFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.930 -0400", hash_original_field = "C886C6FF92A43B3F6833B7BAFD354FBA", hash_generated_field = "A1BFCC57A6BC96010A1D330EF07F3F34")

    private int mMax;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.930 -0400", hash_original_field = "5E8741E831828F60C397C0B58D4C2DD4", hash_generated_field = "24EC69CEF56B680AD8D4A6ABB0E5F818")

    private int mProgressVal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.930 -0400", hash_original_field = "F552E03C67F4E999DAB0DF5EE4448EA3", hash_generated_field = "4217821FA8C458E3FEC38C24E41044A4")

    private int mSecondaryProgressVal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.930 -0400", hash_original_field = "0DDA7933DD412EB58E35762015F6B91B", hash_generated_field = "02383EBC67D3065E0E23A2693D4D47D3")

    private int mIncrementBy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.930 -0400", hash_original_field = "0AA7CBA308EF87D2E43750AFA51CD8BF", hash_generated_field = "0BEE4F38AD86E1B9CC7469AF6E5775BA")

    private int mIncrementSecondaryBy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.930 -0400", hash_original_field = "35ACEA7B06E4E9292BB05774C2312E1C", hash_generated_field = "C7829E00A6912D78CF4DAAA1F03878F2")

    private Drawable mProgressDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.930 -0400", hash_original_field = "081CE0D8134A29404CF8CC8A86F7E0F6", hash_generated_field = "C689AC3D1D2B848F3E53B0D791A6559F")

    private Drawable mIndeterminateDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.930 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "B242999524A78B5E31650BFBB7850632")

    private CharSequence mMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.930 -0400", hash_original_field = "066BD2341E290903C1ACFDCFA38A9B44", hash_generated_field = "92F2421E00AF2915B64A009A8AEF51CA")

    private boolean mIndeterminate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.930 -0400", hash_original_field = "DB7AB0513255FC6EDE7219D5798C2D77", hash_generated_field = "62FBA97BE9733493DCEE6CDD41719180")

    private boolean mHasStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.930 -0400", hash_original_field = "BFA4F1C185EE5682C76991543B556A86", hash_generated_field = "9C96B0DBEEFCF0BF24069370A43F6E2A")

    private Handler mViewUpdateHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.931 -0400", hash_original_method = "92C5111B01C2F7487094F131EFA7D9CD", hash_generated_method = "84132C6A5BBB1AC760ECE98263A38AD5")
    public  ProgressDialog(Context context) {
        super(context);
        initFormats();
        addTaint(context.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.931 -0400", hash_original_method = "2063B34B32B727D3ADD346C69E61541B", hash_generated_method = "6CB930AF7C22AB7848C6E0F91C720DD4")
    public  ProgressDialog(Context context, int theme) {
        super(context, theme);
        initFormats();
        addTaint(context.getTaint());
        addTaint(theme);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.932 -0400", hash_original_method = "FE2AC98467F95F1FDF5E365DE947BD3D", hash_generated_method = "EB60C8DF224A339DC28B96F8E67BA73A")
    private void initFormats() {
        mProgressNumberFormat = "%1d/%2d";
        mProgressPercentFormat = NumberFormat.getPercentInstance();
        mProgressPercentFormat.setMaximumFractionDigits(0);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static ProgressDialog show(Context context, CharSequence title,
            CharSequence message) {
        return show(context, title, message, false);
    }

    
    @DSModeled(DSC.SAFE)
    public static ProgressDialog show(Context context, CharSequence title,
            CharSequence message, boolean indeterminate) {
        return show(context, title, message, indeterminate, false, null);
    }

    
    @DSModeled(DSC.SAFE)
    public static ProgressDialog show(Context context, CharSequence title,
            CharSequence message, boolean indeterminate, boolean cancelable) {
        return show(context, title, message, indeterminate, cancelable, null);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.935 -0400", hash_original_method = "3C62C073499C0C1AB7CB80CDA6A00701", hash_generated_method = "3D307DCA01B98C41E5FE08FB80C9684C")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        LayoutInflater inflater = LayoutInflater.from(mContext);
        TypedArray a = mContext.obtainStyledAttributes(null,
                com.android.internal.R.styleable.AlertDialog,
                com.android.internal.R.attr.alertDialogStyle, 0);
        {
            mViewUpdateHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.935 -0400", hash_original_method = "7104A26B01D6B673482D82C714B7E2C7", hash_generated_method = "C9E53F7AAB56EDC7EC034511D70F7BD3")
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    int progress = mProgress.getProgress();
                    int max = mProgress.getMax();
                    {
                        String format = mProgressNumberFormat;
                        mProgressNumber.setText(String.format(format, progress, max));
                    } 
                    {
                        mProgressNumber.setText("");
                    } 
                    {
                        double percent = (double) progress / (double) max;
                        SpannableString tmp = new SpannableString(mProgressPercentFormat.format(percent));
                        tmp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD),
                                0, tmp.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        mProgressPercent.setText(tmp);
                    } 
                    {
                        mProgressPercent.setText("");
                    } 
                    addTaint(msg.getTaint());
                    
                    
                }
};
            View view = inflater.inflate(a.getResourceId(
                    com.android.internal.R.styleable.AlertDialog_horizontalProgressLayout,
                    R.layout.alert_dialog_progress), null);
            mProgress = (ProgressBar) view.findViewById(R.id.progress);
            mProgressNumber = (TextView) view.findViewById(R.id.progress_number);
            mProgressPercent = (TextView) view.findViewById(R.id.progress_percent);
            setView(view);
        } 
        {
            View view = inflater.inflate(a.getResourceId(
                    com.android.internal.R.styleable.AlertDialog_progressLayout,
                    R.layout.progress_dialog), null);
            mProgress = (ProgressBar) view.findViewById(R.id.progress);
            mMessageView = (TextView) view.findViewById(R.id.message);
            setView(view);
        } 
        a.recycle();
        {
            setMax(mMax);
        } 
        {
            setProgress(mProgressVal);
        } 
        {
            setSecondaryProgress(mSecondaryProgressVal);
        } 
        {
            incrementProgressBy(mIncrementBy);
        } 
        {
            incrementSecondaryProgressBy(mIncrementSecondaryBy);
        } 
        {
            setProgressDrawable(mProgressDrawable);
        } 
        {
            setIndeterminateDrawable(mIndeterminateDrawable);
        } 
        {
            setMessage(mMessage);
        } 
        setIndeterminate(mIndeterminate);
        onProgressChanged();
        super.onCreate(savedInstanceState);
        addTaint(savedInstanceState.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.936 -0400", hash_original_method = "E4C380672C091716BA880A9F39495F13", hash_generated_method = "D96DD738669DD0F97C550EA7D446DAAF")
    @Override
    public void onStart() {
        
        super.onStart();
        mHasStarted = true;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.936 -0400", hash_original_method = "167333ED7F36A78C04285C2EEC5DCE22", hash_generated_method = "CA0145CDF0F773E726BCE8702522BE73")
    @Override
    protected void onStop() {
        
        super.onStop();
        mHasStarted = false;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.937 -0400", hash_original_method = "23FC1AAA73A8AF68F967E7C4900FBF4D", hash_generated_method = "BB42C57544548132E30EC1734345E853")
    public void setProgress(int value) {
        {
            mProgress.setProgress(value);
            onProgressChanged();
        } 
        {
            mProgressVal = value;
        } 
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.937 -0400", hash_original_method = "6E4750DDBC0AC16C300E83EC6E6DBC1D", hash_generated_method = "0EE242042DDB35C7EABBF558918F9225")
    public void setSecondaryProgress(int secondaryProgress) {
        {
            mProgress.setSecondaryProgress(secondaryProgress);
            onProgressChanged();
        } 
        {
            mSecondaryProgressVal = secondaryProgress;
        } 
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.938 -0400", hash_original_method = "4D0AEB75C79AE0306A009E89E85077BB", hash_generated_method = "0F5761C1CED21D08E06B5F737C8E1E7D")
    public int getProgress() {
        {
            int varC3FCEABAA482DDE04BD57D3E33B890B4_878827539 = (mProgress.getProgress());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_799706768 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_799706768;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.939 -0400", hash_original_method = "58FB68124F7103A7657A430EF8D5C27D", hash_generated_method = "730D1C8271E640A5A780E06D1D24F073")
    public int getSecondaryProgress() {
        {
            int var44A0564C0ED141CA0E9A06C34FFA054C_1836915648 = (mProgress.getSecondaryProgress());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270576940 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270576940;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.939 -0400", hash_original_method = "B2C91689E392BFA0100BFE7CD7CBCF9A", hash_generated_method = "4F90A4CEFECCAA37A5C6E99383DD2A8B")
    public int getMax() {
        {
            int var4949B217EA884167BD50B357099ED859_538704282 = (mProgress.getMax());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479450171 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479450171;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.940 -0400", hash_original_method = "823B39538AFD9A862BBB0CFD9EF1E653", hash_generated_method = "F638B4D3E9F6838BB8C0BF979EA9329F")
    public void setMax(int max) {
        {
            mProgress.setMax(max);
            onProgressChanged();
        } 
        {
            mMax = max;
        } 
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.940 -0400", hash_original_method = "445D81214DF2B063E62A55D5F8A17F23", hash_generated_method = "57379F8B73C5869FB43E31275DE8EA50")
    public void incrementProgressBy(int diff) {
        {
            mProgress.incrementProgressBy(diff);
            onProgressChanged();
        } 
        {
            mIncrementBy += diff;
        } 
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.941 -0400", hash_original_method = "ACDD0F5A55036B735620D3E49831AA1C", hash_generated_method = "90B9B31A7CA6C58F812AAE7F8CFE280C")
    public void incrementSecondaryProgressBy(int diff) {
        {
            mProgress.incrementSecondaryProgressBy(diff);
            onProgressChanged();
        } 
        {
            mIncrementSecondaryBy += diff;
        } 
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.941 -0400", hash_original_method = "BF189ED691A8CB1AA1828F7DFAB16E61", hash_generated_method = "7F2317240E17C54B8808B22072CF61FD")
    public void setProgressDrawable(Drawable d) {
        {
            mProgress.setProgressDrawable(d);
        } 
        {
            mProgressDrawable = d;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.942 -0400", hash_original_method = "55A3C3032B86D6D77860B6605EF0B7F9", hash_generated_method = "E380E3CEA365635C07622D1AC65D074F")
    public void setIndeterminateDrawable(Drawable d) {
        {
            mProgress.setIndeterminateDrawable(d);
        } 
        {
            mIndeterminateDrawable = d;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.942 -0400", hash_original_method = "87844978D06A223987B222FFA166DFBA", hash_generated_method = "EEA54B82C34006BCD4248E462DEB99B2")
    public void setIndeterminate(boolean indeterminate) {
        {
            mProgress.setIndeterminate(indeterminate);
        } 
        {
            mIndeterminate = indeterminate;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.943 -0400", hash_original_method = "91BE21C4F81E2907389C6C7DE0F7DEB9", hash_generated_method = "C6D4D43B40C01B344BFA7AB63E9F2134")
    public boolean isIndeterminate() {
        {
            boolean var909255BB0BE06BA49690588123C2581F_510134473 = (mProgress.isIndeterminate());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1887703950 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1887703950;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.944 -0400", hash_original_method = "AFD34C008702B9F6492C001F2A71B115", hash_generated_method = "8615547F9FCEDB23F0C423FE70B5B6C5")
    @Override
    public void setMessage(CharSequence message) {
        {
            {
                super.setMessage(message);
            } 
            {
                mMessageView.setText(message);
            } 
        } 
        {
            mMessage = message;
        } 
        
        
            
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.944 -0400", hash_original_method = "85F4612555E33B447C725C49965B14D6", hash_generated_method = "4273143CCA6E95A2C8596BE20934D03B")
    public void setProgressStyle(int style) {
        mProgressStyle = style;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.946 -0400", hash_original_method = "B0BFAE800A15CED2E9D1DC398253EB1C", hash_generated_method = "F482EA4B05B7D51B24E03A24216110BC")
    public void setProgressNumberFormat(String format) {
        mProgressNumberFormat = format;
        onProgressChanged();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.947 -0400", hash_original_method = "4324E732D77BC0648AC0ECF3DB6A3F8F", hash_generated_method = "9C8F46C8F794E97CBBAB7656535BB4DC")
    public void setProgressPercentFormat(NumberFormat format) {
        mProgressPercentFormat = format;
        onProgressChanged();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.947 -0400", hash_original_method = "28A5BA5A84A47E224F80ADB1F1423669", hash_generated_method = "1C5E585E4F2FA169AEF4E64184178FD8")
    private void onProgressChanged() {
        {
            {
                boolean var0882FC0F145234A3AFDA3C6B71E116E7_974229711 = (mViewUpdateHandler != null && !mViewUpdateHandler.hasMessages(0));
                {
                    mViewUpdateHandler.sendEmptyMessage(0);
                } 
            } 
        } 
        
        
            
                
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.947 -0400", hash_original_field = "B704989AC93CDD7359531BC1271B6699", hash_generated_field = "8E4B753198D7E1478BD4980982C5E4B0")

    public static final int STYLE_SPINNER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.947 -0400", hash_original_field = "34AD4F285C90BC4056FBA291E780C3FB", hash_generated_field = "71151F676EF3890F6697F6CEF895DD7A")

    public static final int STYLE_HORIZONTAL = 1;
}

