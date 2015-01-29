package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.857 -0500", hash_original_method = "735A07E8EA3FECB061EA4EDEB18A0EB9", hash_generated_method = "F5477D72941826039516E31C68F358E3")
    
public static ProgressDialog show(Context context, CharSequence title,
            CharSequence message) {
        return show(context, title, message, false);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.859 -0500", hash_original_method = "82C9FB373B0183F4E1F162584F9FBDE1", hash_generated_method = "2ED142F3AE45F2F88589B5AB5E2AE110")
    
public static ProgressDialog show(Context context, CharSequence title,
            CharSequence message, boolean indeterminate) {
        return show(context, title, message, indeterminate, false, null);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.861 -0500", hash_original_method = "D9B389952ED9A81378FC79549F38BFBD", hash_generated_method = "20653E99A704CEEC6391592E99401A0E")
    
public static ProgressDialog show(Context context, CharSequence title,
            CharSequence message, boolean indeterminate, boolean cancelable) {
        return show(context, title, message, indeterminate, cancelable, null);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.864 -0500", hash_original_method = "03DAB0D982360E51140E9719BAAFE26F", hash_generated_method = "E3DCC1D2DE2531289BDB206E026F7182")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.807 -0500", hash_original_field = "FA800DFFB2EDC4C68D3B6120120CE011", hash_generated_field = "8E4B753198D7E1478BD4980982C5E4B0")

    public static final int STYLE_SPINNER = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.809 -0500", hash_original_field = "15EE2B1D4EC09099342E743EBE64C388", hash_generated_field = "71151F676EF3890F6697F6CEF895DD7A")

    public static final int STYLE_HORIZONTAL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.812 -0500", hash_original_field = "789276011B0B73E01A12C7020EDE82A8", hash_generated_field = "77244E1CDBA901DF4A72F7384A95707A")
    
    private ProgressBar mProgress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.814 -0500", hash_original_field = "3C68F58819B50F04C23C7889C2B27482", hash_generated_field = "461DDCE97AF551A1C6803EBC4533C15B")

    private TextView mMessageView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.816 -0500", hash_original_field = "17435A0667B0477AB6458FA502C7EEB2", hash_generated_field = "D606E8AD4CB2138AB3E23AD40FAEF122")
    
    private int mProgressStyle = STYLE_SPINNER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.817 -0500", hash_original_field = "22CE0B9FB494D1B757AFDD8529E500F4", hash_generated_field = "B144E5A12AFBB6F4D43B9925DE81C337")

    private TextView mProgressNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.819 -0500", hash_original_field = "315CF74D8CB2AD45A6C4A44740846241", hash_generated_field = "919E83DFD466D019ADD12AA5B4AB137B")

    private String mProgressNumberFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.821 -0500", hash_original_field = "FC59310AB9DED09AB24DC3CF35F9CE7D", hash_generated_field = "E1E15B58291253ABA7CD4CA5C053A29F")

    private TextView mProgressPercent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.823 -0500", hash_original_field = "5425DC3B2A47FF60B1B148315175781C", hash_generated_field = "801BEF4B64C99340B750EC7CE4102A7A")

    private NumberFormat mProgressPercentFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.826 -0500", hash_original_field = "643806E929E292CCE314B6AD18027C00", hash_generated_field = "A1BFCC57A6BC96010A1D330EF07F3F34")
    
    private int mMax;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.828 -0500", hash_original_field = "FD853BE2FA795215E14D487AB843805D", hash_generated_field = "24EC69CEF56B680AD8D4A6ABB0E5F818")

    private int mProgressVal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.830 -0500", hash_original_field = "FDA999A1ED9A776C8D5C1C0490506C99", hash_generated_field = "4217821FA8C458E3FEC38C24E41044A4")

    private int mSecondaryProgressVal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.832 -0500", hash_original_field = "1B56282B97D51A42F974718DF5CE81ED", hash_generated_field = "02383EBC67D3065E0E23A2693D4D47D3")

    private int mIncrementBy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.835 -0500", hash_original_field = "D0010533E2B982EFF3197CE9A3A3C19A", hash_generated_field = "0BEE4F38AD86E1B9CC7469AF6E5775BA")

    private int mIncrementSecondaryBy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.837 -0500", hash_original_field = "5D7F822ED6B0FEE4C7B4B596E0F35534", hash_generated_field = "C7829E00A6912D78CF4DAAA1F03878F2")

    private Drawable mProgressDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.839 -0500", hash_original_field = "ACF08658A02B579A46D5805654850485", hash_generated_field = "C689AC3D1D2B848F3E53B0D791A6559F")

    private Drawable mIndeterminateDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.841 -0500", hash_original_field = "63AD8EC50650F4FC1A994F2CF8879BF9", hash_generated_field = "B242999524A78B5E31650BFBB7850632")

    private CharSequence mMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.843 -0500", hash_original_field = "0D148F2C69F7B5D4956EFF238B82CCCF", hash_generated_field = "92F2421E00AF2915B64A009A8AEF51CA")

    private boolean mIndeterminate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.846 -0500", hash_original_field = "3B1E9196D0E5D604CF53F2AD1EEEAD8A", hash_generated_field = "62FBA97BE9733493DCEE6CDD41719180")
    
    private boolean mHasStarted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.848 -0500", hash_original_field = "DE0E53A68D9E53536021C1D2CAC9B7DB", hash_generated_field = "9C96B0DBEEFCF0BF24069370A43F6E2A")

    private Handler mViewUpdateHandler;
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.850 -0500", hash_original_method = "92C5111B01C2F7487094F131EFA7D9CD", hash_generated_method = "AB3F338B4B6D93EA8D10AB9E027B4C64")
    
public ProgressDialog(Context context) {
        super(context);
        initFormats();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.852 -0500", hash_original_method = "2063B34B32B727D3ADD346C69E61541B", hash_generated_method = "6ADB1347E04F2738810E2BEB1859F74D")
    
public ProgressDialog(Context context, int theme) {
        super(context, theme);
        initFormats();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.855 -0500", hash_original_method = "FE2AC98467F95F1FDF5E365DE947BD3D", hash_generated_method = "206CBC2BA8E19D7D280646B044BF8A4B")
    
private void initFormats() {
        mProgressNumberFormat = "%1d/%2d";
        mProgressPercentFormat = NumberFormat.getPercentInstance();
        mProgressPercentFormat.setMaximumFractionDigits(0);
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.871 -0500", hash_original_method = "3C62C073499C0C1AB7CB80CDA6A00701", hash_generated_method = "A98AAFA7F757CF183D33413B3E7E8B2B")
    
@Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        TypedArray a = mContext.obtainStyledAttributes(null,
                com.android.internal.R.styleable.AlertDialog,
                com.android.internal.R.attr.alertDialogStyle, 0);
        if (mProgressStyle == STYLE_HORIZONTAL) {
            
            /* Use a separate handler to update the text views as they
             * must be updated on the same thread that created them.
             */
            mViewUpdateHandler = new Handler() {
                @DSSafe(DSCat.SAFE_LIST)
        @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    
                    /* Update the number and percent */
                    int progress = mProgress.getProgress();
                    int max = mProgress.getMax();
                    if (mProgressNumberFormat != null) {
                        String format = mProgressNumberFormat;
                        mProgressNumber.setText(String.format(format, progress, max));
                    } else {
                        mProgressNumber.setText("");
                    }
                    if (mProgressPercentFormat != null) {
                        double percent = (double) progress / (double) max;
                        SpannableString tmp = new SpannableString(mProgressPercentFormat.format(percent));
                        tmp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD),
                                0, tmp.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        mProgressPercent.setText(tmp);
                    } else {
                        mProgressPercent.setText("");
                    }
                }
            };
            View view = inflater.inflate(a.getResourceId(
                    com.android.internal.R.styleable.AlertDialog_horizontalProgressLayout,
                    R.layout.alert_dialog_progress), null);
            mProgress = (ProgressBar) view.findViewById(R.id.progress);
            mProgressNumber = (TextView) view.findViewById(R.id.progress_number);
            mProgressPercent = (TextView) view.findViewById(R.id.progress_percent);
            setView(view);
        } else {
            View view = inflater.inflate(a.getResourceId(
                    com.android.internal.R.styleable.AlertDialog_progressLayout,
                    R.layout.progress_dialog), null);
            mProgress = (ProgressBar) view.findViewById(R.id.progress);
            mMessageView = (TextView) view.findViewById(R.id.message);
            setView(view);
        }
        a.recycle();
        if (mMax > 0) {
            setMax(mMax);
        }
        if (mProgressVal > 0) {
            setProgress(mProgressVal);
        }
        if (mSecondaryProgressVal > 0) {
            setSecondaryProgress(mSecondaryProgressVal);
        }
        if (mIncrementBy > 0) {
            incrementProgressBy(mIncrementBy);
        }
        if (mIncrementSecondaryBy > 0) {
            incrementSecondaryProgressBy(mIncrementSecondaryBy);
        }
        if (mProgressDrawable != null) {
            setProgressDrawable(mProgressDrawable);
        }
        if (mIndeterminateDrawable != null) {
            setIndeterminateDrawable(mIndeterminateDrawable);
        }
        if (mMessage != null) {
            setMessage(mMessage);
        }
        setIndeterminate(mIndeterminate);
        onProgressChanged();
        super.onCreate(savedInstanceState);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.874 -0500", hash_original_method = "E4C380672C091716BA880A9F39495F13", hash_generated_method = "3E9BA6794495067018918A3137CF8875")
    
@Override
    public void onStart() {
        super.onStart();
        mHasStarted = true;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.876 -0500", hash_original_method = "167333ED7F36A78C04285C2EEC5DCE22", hash_generated_method = "188082093DD6037521F259233199C972")
    
@Override
    protected void onStop() {
        super.onStop();
        mHasStarted = false;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.878 -0500", hash_original_method = "23FC1AAA73A8AF68F967E7C4900FBF4D", hash_generated_method = "05F98110A99D6346FA890CEA32E6E9A3")
    
public void setProgress(int value) {
        if (mHasStarted) {
            mProgress.setProgress(value);
            onProgressChanged();
        } else {
            mProgressVal = value;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.880 -0500", hash_original_method = "6E4750DDBC0AC16C300E83EC6E6DBC1D", hash_generated_method = "049B63ECC3766F000E69B653D3E08B63")
    
public void setSecondaryProgress(int secondaryProgress) {
        if (mProgress != null) {
            mProgress.setSecondaryProgress(secondaryProgress);
            onProgressChanged();
        } else {
            mSecondaryProgressVal = secondaryProgress;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.882 -0500", hash_original_method = "4D0AEB75C79AE0306A009E89E85077BB", hash_generated_method = "D749C979527826D47398AAA8CF2F0759")
    
public int getProgress() {
        if (mProgress != null) {
            return mProgress.getProgress();
        }
        return mProgressVal;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.884 -0500", hash_original_method = "58FB68124F7103A7657A430EF8D5C27D", hash_generated_method = "99B5F21139D4F0C1E13667229A1A1C30")
    
public int getSecondaryProgress() {
        if (mProgress != null) {
            return mProgress.getSecondaryProgress();
        }
        return mSecondaryProgressVal;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.887 -0500", hash_original_method = "B2C91689E392BFA0100BFE7CD7CBCF9A", hash_generated_method = "0BA0955C8639A19AC37233F767D112C4")
    
public int getMax() {
        if (mProgress != null) {
            return mProgress.getMax();
        }
        return mMax;
    }

    @DSComment("GUI, progress dialog")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.889 -0500", hash_original_method = "823B39538AFD9A862BBB0CFD9EF1E653", hash_generated_method = "BDCC61E9C0CE4E6A02EC03E9E27B9042")
    
public void setMax(int max) {
        if (mProgress != null) {
            mProgress.setMax(max);
            onProgressChanged();
        } else {
            mMax = max;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.891 -0500", hash_original_method = "445D81214DF2B063E62A55D5F8A17F23", hash_generated_method = "8BA970F65D82D91B778C582644F5BF01")
    
public void incrementProgressBy(int diff) {
        if (mProgress != null) {
            mProgress.incrementProgressBy(diff);
            onProgressChanged();
        } else {
            mIncrementBy += diff;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.893 -0500", hash_original_method = "ACDD0F5A55036B735620D3E49831AA1C", hash_generated_method = "D99757F9676751470B4EFD06877AF05B")
    
public void incrementSecondaryProgressBy(int diff) {
        if (mProgress != null) {
            mProgress.incrementSecondaryProgressBy(diff);
            onProgressChanged();
        } else {
            mIncrementSecondaryBy += diff;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.895 -0500", hash_original_method = "BF189ED691A8CB1AA1828F7DFAB16E61", hash_generated_method = "78AA9509CD2D2535AC53E33C53AB6253")
    
public void setProgressDrawable(Drawable d) {
        if (mProgress != null) {
            mProgress.setProgressDrawable(d);
        } else {
            mProgressDrawable = d;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.897 -0500", hash_original_method = "55A3C3032B86D6D77860B6605EF0B7F9", hash_generated_method = "821E1ED76F840C141E0593F120497980")
    
public void setIndeterminateDrawable(Drawable d) {
        if (mProgress != null) {
            mProgress.setIndeterminateDrawable(d);
        } else {
            mIndeterminateDrawable = d;
        }
    }

    @DSComment("GUI, progress dialog")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.899 -0500", hash_original_method = "87844978D06A223987B222FFA166DFBA", hash_generated_method = "50465A8C6BC7AD3AA2D89E2C54ABAEF0")
    
public void setIndeterminate(boolean indeterminate) {
        if (mProgress != null) {
            mProgress.setIndeterminate(indeterminate);
        } else {
            mIndeterminate = indeterminate;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.902 -0500", hash_original_method = "91BE21C4F81E2907389C6C7DE0F7DEB9", hash_generated_method = "DDFECEBB7C651D0222868A31378FDA24")
    
public boolean isIndeterminate() {
        if (mProgress != null) {
            return mProgress.isIndeterminate();
        }
        return mIndeterminate;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.905 -0500", hash_original_method = "AFD34C008702B9F6492C001F2A71B115", hash_generated_method = "653FAFF7F47E464FDECDD114561CC10B")
    
@Override
    public void setMessage(CharSequence message) {
        if (mProgress != null) {
            if (mProgressStyle == STYLE_HORIZONTAL) {
                super.setMessage(message);
            } else {
                mMessageView.setText(message);
            }
        } else {
            mMessage = message;
        }
    }
    
    @DSComment("GUI, progress dialog")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.907 -0500", hash_original_method = "85F4612555E33B447C725C49965B14D6", hash_generated_method = "4A0A32BC4C602AA73094B9828B823181")
    
public void setProgressStyle(int style) {
        mProgressStyle = style;
    }

    /**
     * Change the format of the small text showing current and maximum units
     * of progress.  The default is "%1d/%2d".
     * Should not be called during the number is progressing.
     * @param format A string passed to {@link String#format String.format()};
     * use "%1d" for the current number and "%2d" for the maximum.  If null,
     * nothing will be shown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.909 -0500", hash_original_method = "B0BFAE800A15CED2E9D1DC398253EB1C", hash_generated_method = "B3F58D0BCF31F3534B82F83360488A76")
    
public void setProgressNumberFormat(String format) {
        mProgressNumberFormat = format;
        onProgressChanged();
    }

    /**
     * Change the format of the small text showing the percentage of progress.
     * The default is
     * {@link NumberFormat#getPercentInstance() NumberFormat.getPercentageInstnace().}
     * Should not be called during the number is progressing.
     * @param format An instance of a {@link NumberFormat} to generate the
     * percentage text.  If null, nothing will be shown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.911 -0500", hash_original_method = "4324E732D77BC0648AC0ECF3DB6A3F8F", hash_generated_method = "37F47C1FC0F57E3169A5228A3BD9B5C2")
    
public void setProgressPercentFormat(NumberFormat format) {
        mProgressPercentFormat = format;
        onProgressChanged();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.913 -0500", hash_original_method = "28A5BA5A84A47E224F80ADB1F1423669", hash_generated_method = "A86D6E5EF6EAA26BB844A1F4E394AB71")
    
private void onProgressChanged() {
        if (mProgressStyle == STYLE_HORIZONTAL) {
            if (mViewUpdateHandler != null && !mViewUpdateHandler.hasMessages(0)) {
                mViewUpdateHandler.sendEmptyMessage(0);
            }
        }
    }
}

