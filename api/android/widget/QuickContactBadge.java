package android.widget;

// Droidsafe Imports
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Intents;
import android.provider.ContactsContract.PhoneLookup;
import android.provider.ContactsContract.QuickContact;
import android.provider.ContactsContract.RawContacts;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;

import com.android.internal.R;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class QuickContactBadge extends ImageView implements OnClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.148 -0400", hash_original_field = "BA420FA571B7EC31BB499073241D6F9F", hash_generated_field = "DE36A63479C290388AC419A19DF1934A")

    private Uri mContactUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.149 -0400", hash_original_field = "7AD4B1FA832C7375DFC64083F30E4B16", hash_generated_field = "242C604AD7306A64F8A8950721E9293B")

    private String mContactEmail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.149 -0400", hash_original_field = "37442DC6EFCEF29EAD74198B1B834E60", hash_generated_field = "1405D0B985B3E1064DA28B8E3CDCF13E")

    private String mContactPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.149 -0400", hash_original_field = "B4937A20F874B8F93CDFB5157F168D45", hash_generated_field = "E4FFEB6F6E75DFDD57A869634014173C")

    private Drawable mOverlay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.149 -0400", hash_original_field = "1553EFF3BE5353B37340AFEC993BD26E", hash_generated_field = "1C0F9064DA07DC52699B398D8B3CE544")

    private QueryHandler mQueryHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.149 -0400", hash_original_field = "37316F55BBFD9B180047A7D4B58CB675", hash_generated_field = "A5D89ED472D11D04A15AD79450D39F44")

    private Drawable mDefaultAvatar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.149 -0400", hash_original_field = "B28D02617C67C5174CB34FCF1D81AC09", hash_generated_field = "30C77D2B5C142799143EDF40257BBF81")

    protected String[] mExcludeMimes = null;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.149 -0400", hash_original_method = "F698EB0A9BF86C10F29F79F4D1EFD1DC", hash_generated_method = "206406F26BFA9B8F8E50C9AB2E189CB1")
    public  QuickContactBadge(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.150 -0400", hash_original_method = "ADED2BA446D2A9BF4C8E4781CE5F3F84", hash_generated_method = "9686B4C1F8636BF227E01308CA537305")
    public  QuickContactBadge(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.150 -0400", hash_original_method = "0171DAF66D107836BC0033CB50F41701", hash_generated_method = "E9D2D7B5C2998C2B265BF207CD176C5D")
    public  QuickContactBadge(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray styledAttributes = mContext.obtainStyledAttributes(R.styleable.Theme);
        mOverlay = styledAttributes.getDrawable(
                com.android.internal.R.styleable.Theme_quickContactBadgeOverlay);
        styledAttributes.recycle();
        mQueryHandler = new QueryHandler(mContext.getContentResolver());
        setOnClickListener(this);
        // ---------- Original Method ----------
        //TypedArray styledAttributes = mContext.obtainStyledAttributes(R.styleable.Theme);
        //mOverlay = styledAttributes.getDrawable(
                //com.android.internal.R.styleable.Theme_quickContactBadgeOverlay);
        //styledAttributes.recycle();
        //mQueryHandler = new QueryHandler(mContext.getContentResolver());
        //setOnClickListener(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.150 -0400", hash_original_method = "5693D4EF6FAC7E7AFE930BDF5EC8E103", hash_generated_method = "3A49175F7D70A1781AD14F7C9FD0E3B4")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if(mOverlay != null && mOverlay.isStateful())        
        {
            mOverlay.setState(getDrawableState());
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //if (mOverlay != null && mOverlay.isStateful()) {
            //mOverlay.setState(getDrawableState());
            //invalidate();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.151 -0400", hash_original_method = "02B3BF267746F04A443A6F33FDD49C50", hash_generated_method = "D4021E48063A8881864778297492D18C")
    @SuppressWarnings("unused")
    public void setMode(int size) {
        addTaint(size);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.152 -0400", hash_original_method = "23D2E4F314D26FFBC9D75F31C49B7153", hash_generated_method = "4C29E491FBADA83BF3F370F2B8FBECB6")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        super.onDraw(canvas);
        if(!isEnabled())        
        {
            return;
        } //End block
        if(mOverlay == null || mOverlay.getIntrinsicWidth() == 0 ||
                mOverlay.getIntrinsicHeight() == 0)        
        {
            return;
        } //End block
        mOverlay.setBounds(0, 0, getWidth(), getHeight());
        if(mPaddingTop == 0 && mPaddingLeft == 0)        
        {
            mOverlay.draw(canvas);
        } //End block
        else
        {
            int saveCount = canvas.getSaveCount();
            canvas.save();
            canvas.translate(mPaddingLeft, mPaddingTop);
            mOverlay.draw(canvas);
            canvas.restoreToCount(saveCount);
        } //End block
        // ---------- Original Method ----------
        //super.onDraw(canvas);
        //if (!isEnabled()) {
            //return;
        //}
        //if (mOverlay == null || mOverlay.getIntrinsicWidth() == 0 ||
                //mOverlay.getIntrinsicHeight() == 0) {
            //return;
        //}
        //mOverlay.setBounds(0, 0, getWidth(), getHeight());
        //if (mPaddingTop == 0 && mPaddingLeft == 0) {
            //mOverlay.draw(canvas);
        //} else {
            //int saveCount = canvas.getSaveCount();
            //canvas.save();
            //canvas.translate(mPaddingLeft, mPaddingTop);
            //mOverlay.draw(canvas);
            //canvas.restoreToCount(saveCount);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.152 -0400", hash_original_method = "FCE3B5086AEC0F336253CCDCDE531810", hash_generated_method = "437F388ACEC73B9782E0E94B061D44B1")
    private boolean isAssigned() {
        boolean var5B311DB59956F2A2D93DB75AFB520017_133401385 = (mContactUri != null || mContactEmail != null || mContactPhone != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_178538599 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_178538599;
        // ---------- Original Method ----------
        //return mContactUri != null || mContactEmail != null || mContactPhone != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.153 -0400", hash_original_method = "E4AF1B9673F011A8417C08012510E27B", hash_generated_method = "6810026ABE20C92676789320376FD9E7")
    public void setImageToDefault() {
        if(mDefaultAvatar == null)        
        {
            mDefaultAvatar = getResources().getDrawable(R.drawable.ic_contact_picture);
        } //End block
        setImageDrawable(mDefaultAvatar);
        // ---------- Original Method ----------
        //if (mDefaultAvatar == null) {
            //mDefaultAvatar = getResources().getDrawable(R.drawable.ic_contact_picture);
        //}
        //setImageDrawable(mDefaultAvatar);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.153 -0400", hash_original_method = "F07B10D1C60A4CC654BA1655A0E456BD", hash_generated_method = "1C1D96C40DD0DE46B710181BFE8FC45E")
    public void assignContactUri(Uri contactUri) {
        mContactUri = contactUri;
        mContactEmail = null;
        mContactPhone = null;
        onContactUriChanged();
        // ---------- Original Method ----------
        //mContactUri = contactUri;
        //mContactEmail = null;
        //mContactPhone = null;
        //onContactUriChanged();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.154 -0400", hash_original_method = "7E46CBF823F769C000B50BD24A037D73", hash_generated_method = "8A2D93579F7F511CF665A27BDE67F8E4")
    public void assignContactFromEmail(String emailAddress, boolean lazyLookup) {
        addTaint(lazyLookup);
        mContactEmail = emailAddress;
        if(!lazyLookup)        
        {
            mQueryHandler.startQuery(TOKEN_EMAIL_LOOKUP, null,
                    Uri.withAppendedPath(Email.CONTENT_LOOKUP_URI, Uri.encode(mContactEmail)),
                    EMAIL_LOOKUP_PROJECTION, null, null, null);
        } //End block
        else
        {
            mContactUri = null;
            onContactUriChanged();
        } //End block
        // ---------- Original Method ----------
        //mContactEmail = emailAddress;
        //if (!lazyLookup) {
            //mQueryHandler.startQuery(TOKEN_EMAIL_LOOKUP, null,
                    //Uri.withAppendedPath(Email.CONTENT_LOOKUP_URI, Uri.encode(mContactEmail)),
                    //EMAIL_LOOKUP_PROJECTION, null, null, null);
        //} else {
            //mContactUri = null;
            //onContactUriChanged();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.155 -0400", hash_original_method = "615886346605DCC8A37347200BE80EDB", hash_generated_method = "DBB7A6FE59CC0A00910C99B4D28F6A8B")
    public void assignContactFromPhone(String phoneNumber, boolean lazyLookup) {
        addTaint(lazyLookup);
        mContactPhone = phoneNumber;
        if(!lazyLookup)        
        {
            mQueryHandler.startQuery(TOKEN_PHONE_LOOKUP, null,
                    Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, mContactPhone),
                    PHONE_LOOKUP_PROJECTION, null, null, null);
        } //End block
        else
        {
            mContactUri = null;
            onContactUriChanged();
        } //End block
        // ---------- Original Method ----------
        //mContactPhone = phoneNumber;
        //if (!lazyLookup) {
            //mQueryHandler.startQuery(TOKEN_PHONE_LOOKUP, null,
                    //Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, mContactPhone),
                    //PHONE_LOOKUP_PROJECTION, null, null, null);
        //} else {
            //mContactUri = null;
            //onContactUriChanged();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.156 -0400", hash_original_method = "8712FDD692B08E6979A43AB02ED73539", hash_generated_method = "9332C53BC9532EB272CB981FE68B7B39")
    private void onContactUriChanged() {
        setEnabled(isAssigned());
        // ---------- Original Method ----------
        //setEnabled(isAssigned());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.156 -0400", hash_original_method = "58382461F76E5F0CD49350469EC07976", hash_generated_method = "AE3D74460F56B9E573BF63B69A7BAB14")
    @Override
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
        if(mContactUri != null)        
        {
            QuickContact.showQuickContact(getContext(), QuickContactBadge.this, mContactUri,
                    QuickContact.MODE_LARGE, mExcludeMimes);
        } //End block
        else
        if(mContactEmail != null)        
        {
            mQueryHandler.startQuery(TOKEN_EMAIL_LOOKUP_AND_TRIGGER, mContactEmail,
                    Uri.withAppendedPath(Email.CONTENT_LOOKUP_URI, Uri.encode(mContactEmail)),
                    EMAIL_LOOKUP_PROJECTION, null, null, null);
        } //End block
        else
        if(mContactPhone != null)        
        {
            mQueryHandler.startQuery(TOKEN_PHONE_LOOKUP_AND_TRIGGER, mContactPhone,
                    Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, mContactPhone),
                    PHONE_LOOKUP_PROJECTION, null, null, null);
        } //End block
        else
        {
            return;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.157 -0400", hash_original_method = "6EE6B4CDAB8A2B121BC24B2101C4B640", hash_generated_method = "C5F83460E261F170BDD1386C11FBEC35")
    public void setExcludeMimes(String[] excludeMimes) {
        mExcludeMimes = excludeMimes;
        // ---------- Original Method ----------
        //mExcludeMimes = excludeMimes;
    }

    
    private class QueryHandler extends AsyncQueryHandler {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.157 -0400", hash_original_method = "9B79E3E63BDEF0F27411ADE3BE0052BB", hash_generated_method = "690E9E0B29B635C88AEDB29459E9EEF3")
        public  QueryHandler(ContentResolver cr) {
            super(cr);
            addTaint(cr.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.159 -0400", hash_original_method = "8665D4A0C21AED185AE6812E2DF2128E", hash_generated_method = "C00305FB1E3219C61BD323674488A045")
        @Override
        protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(cursor.getTaint());
            addTaint(cookie.getTaint());
            addTaint(token);
            Uri lookupUri = null;
            Uri createUri = null;
            boolean trigger = false;
            try 
            {
switch(token){
                case TOKEN_PHONE_LOOKUP_AND_TRIGGER:
                trigger = true;
                createUri = Uri.fromParts("tel", (String)cookie, null);
                case TOKEN_PHONE_LOOKUP:
                {
                    if(cursor != null && cursor.moveToFirst())                    
                    {
                        long contactId = cursor.getLong(PHONE_ID_COLUMN_INDEX);
                        String lookupKey = cursor.getString(PHONE_LOOKUP_STRING_COLUMN_INDEX);
                        lookupUri = Contacts.getLookupUri(contactId, lookupKey);
                    } //End block
                    break;
                } //End block
                case TOKEN_EMAIL_LOOKUP_AND_TRIGGER:
                trigger = true;
                createUri = Uri.fromParts("mailto", (String)cookie, null);
                case TOKEN_EMAIL_LOOKUP:
                {
                    if(cursor != null && cursor.moveToFirst())                    
                    {
                        long contactId = cursor.getLong(EMAIL_ID_COLUMN_INDEX);
                        String lookupKey = cursor.getString(EMAIL_LOOKUP_STRING_COLUMN_INDEX);
                        lookupUri = Contacts.getLookupUri(contactId, lookupKey);
                    } //End block
                    break;
                } //End block
}
            } //End block
            finally 
            {
                if(cursor != null)                
                {
                    cursor.close();
                } //End block
            } //End block
            mContactUri = lookupUri;
            onContactUriChanged();
            if(trigger && lookupUri != null)            
            {
                QuickContact.showQuickContact(getContext(), QuickContactBadge.this, lookupUri,
                        QuickContact.MODE_LARGE, mExcludeMimes);
            } //End block
            else
            if(createUri != null)            
            {
                final Intent intent = new Intent(Intents.SHOW_OR_CREATE_CONTACT, createUri);
                getContext().startActivity(intent);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.159 -0400", hash_original_field = "664E7DD9996E89C7733805455D8EECD5", hash_generated_field = "533A8CEF6E142EBAC7E1B5A17091F7F2")

    static final private int TOKEN_EMAIL_LOOKUP = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.159 -0400", hash_original_field = "4A0AD3226265EC5CFC95A30B4665854F", hash_generated_field = "45AD8A525F8FF7B24545C8B3C30D66FD")

    static final private int TOKEN_PHONE_LOOKUP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.159 -0400", hash_original_field = "9C88A14B6A4A9FDCEAE2A3E7F0323E03", hash_generated_field = "E4C3AEADC27EE8D2221F82021E35F393")

    static final private int TOKEN_EMAIL_LOOKUP_AND_TRIGGER = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.159 -0400", hash_original_field = "4494EE813B2D41C5CFC028EB8B988E35", hash_generated_field = "E274D049D8939102252754AA3F3CE25D")

    static final private int TOKEN_PHONE_LOOKUP_AND_TRIGGER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.160 -0400", hash_original_field = "53FA6C2DFA49B10C709E4F5ECB4DC02B", hash_generated_field = "5BC314B31DAFB4D3E62E31C0091F16E8")

    static final String[] EMAIL_LOOKUP_PROJECTION = new String[] {
        RawContacts.CONTACT_ID,
        Contacts.LOOKUP_KEY,
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.160 -0400", hash_original_field = "79DA496BAF25818AE0ACB2DA9F3D8AAB", hash_generated_field = "606A1A5105C7E1D12513D4D30A5AF232")

    static final int EMAIL_ID_COLUMN_INDEX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.160 -0400", hash_original_field = "8CA5350EE8E76471D444C91E688B33B8", hash_generated_field = "309C75105083A41E6CA832580959EC79")

    static final int EMAIL_LOOKUP_STRING_COLUMN_INDEX = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.160 -0400", hash_original_field = "E2AF639F8507379FD3AED72CDE819522", hash_generated_field = "2D7D54E80205345029A67BDDBE6A6EED")

    static final String[] PHONE_LOOKUP_PROJECTION = new String[] {
        PhoneLookup._ID,
        PhoneLookup.LOOKUP_KEY,
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.160 -0400", hash_original_field = "3258601EB58CCA2272C909F1D8991ACF", hash_generated_field = "2BB94FFF4C455E1FEFBD94CE13BC7BE5")

    static final int PHONE_ID_COLUMN_INDEX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.160 -0400", hash_original_field = "21B09BF7FACD7702D32F2C7F5F6B0315", hash_generated_field = "1A6A9191C414CD353E13C5DB375978FF")

    static final int PHONE_LOOKUP_STRING_COLUMN_INDEX = 1;
}

