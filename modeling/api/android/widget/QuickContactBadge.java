/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

public class QuickContactBadge extends ImageView implements OnClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.347 -0500", hash_original_field = "27BCF70A1D5953A27BE74D341A1C5C80", hash_generated_field = "533A8CEF6E142EBAC7E1B5A17091F7F2")

    static final private int TOKEN_EMAIL_LOOKUP = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.350 -0500", hash_original_field = "5A3D584F9C103021F883B59FDF59126A", hash_generated_field = "45AD8A525F8FF7B24545C8B3C30D66FD")

    static final private int TOKEN_PHONE_LOOKUP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.352 -0500", hash_original_field = "7CAC8C4A91271527709857C0775A6A6C", hash_generated_field = "E4C3AEADC27EE8D2221F82021E35F393")

    static final private int TOKEN_EMAIL_LOOKUP_AND_TRIGGER = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.354 -0500", hash_original_field = "A8689F494788C8D8B5E0D33C87904403", hash_generated_field = "E274D049D8939102252754AA3F3CE25D")

    static final private int TOKEN_PHONE_LOOKUP_AND_TRIGGER = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.356 -0500", hash_original_field = "0A3E5422D2A4B80E8F0E74830879F83A", hash_generated_field = "5BC314B31DAFB4D3E62E31C0091F16E8")

    static final String[] EMAIL_LOOKUP_PROJECTION = new String[] {
        RawContacts.CONTACT_ID,
        Contacts.LOOKUP_KEY,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.358 -0500", hash_original_field = "95416DF1FB2457B4445FF5A49EA54CD2", hash_generated_field = "606A1A5105C7E1D12513D4D30A5AF232")

    static final int EMAIL_ID_COLUMN_INDEX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.361 -0500", hash_original_field = "F73FB15CB4DE624AA0B86C2A1303046B", hash_generated_field = "309C75105083A41E6CA832580959EC79")

    static final int EMAIL_LOOKUP_STRING_COLUMN_INDEX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.363 -0500", hash_original_field = "18F5B7D24E8A4EB535164650222ADAB6", hash_generated_field = "2D7D54E80205345029A67BDDBE6A6EED")

    static final String[] PHONE_LOOKUP_PROJECTION = new String[] {
        PhoneLookup._ID,
        PhoneLookup.LOOKUP_KEY,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.366 -0500", hash_original_field = "8296534A50AC03FA216DB7BD123EBC19", hash_generated_field = "2BB94FFF4C455E1FEFBD94CE13BC7BE5")

    static final int PHONE_ID_COLUMN_INDEX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.368 -0500", hash_original_field = "64957DB69534095311A3A28401B63B79", hash_generated_field = "1A6A9191C414CD353E13C5DB375978FF")

    static final int PHONE_LOOKUP_STRING_COLUMN_INDEX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.332 -0500", hash_original_field = "8979776F3517191547FD91DF21C0E608", hash_generated_field = "DE36A63479C290388AC419A19DF1934A")

    private Uri mContactUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.334 -0500", hash_original_field = "38E33E1DE39A087E4F6EA71151A10B01", hash_generated_field = "242C604AD7306A64F8A8950721E9293B")

    private String mContactEmail;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.336 -0500", hash_original_field = "5DEB665387944F3786DC774447F0D857", hash_generated_field = "1405D0B985B3E1064DA28B8E3CDCF13E")

    private String mContactPhone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.338 -0500", hash_original_field = "83B4FD39972E07B3369ECF1E556D1437", hash_generated_field = "E4FFEB6F6E75DFDD57A869634014173C")

    private Drawable mOverlay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.341 -0500", hash_original_field = "9CF62AA3F5E130437CD767D3827C80B7", hash_generated_field = "1C0F9064DA07DC52699B398D8B3CE544")

    private QueryHandler mQueryHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.343 -0500", hash_original_field = "779204423F79A959A85D50363A58B93F", hash_generated_field = "A5D89ED472D11D04A15AD79450D39F44")

    private Drawable mDefaultAvatar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.345 -0500", hash_original_field = "FCCFBB00D8C29CFECD897F798EB835CA", hash_generated_field = "30C77D2B5C142799143EDF40257BBF81")

    protected String[] mExcludeMimes = null;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.370 -0500", hash_original_method = "F698EB0A9BF86C10F29F79F4D1EFD1DC", hash_generated_method = "E606BDD76AA44C2129C3ADDD227FC669")
    
public QuickContactBadge(Context context) {
        this(context, null);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.373 -0500", hash_original_method = "ADED2BA446D2A9BF4C8E4781CE5F3F84", hash_generated_method = "3F05716E9814AD5BB783CFF0A6097297")
    
public QuickContactBadge(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.375 -0500", hash_original_method = "0171DAF66D107836BC0033CB50F41701", hash_generated_method = "BB3E0EBFAF3B9ED2C102EB011DEB0044")
    
public QuickContactBadge(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray styledAttributes = mContext.obtainStyledAttributes(R.styleable.Theme);
        mOverlay = styledAttributes.getDrawable(
                com.android.internal.R.styleable.Theme_quickContactBadgeOverlay);
        styledAttributes.recycle();

        mQueryHandler = new QueryHandler(mContext.getContentResolver());
        setOnClickListener(this);
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.378 -0500", hash_original_method = "5693D4EF6FAC7E7AFE930BDF5EC8E103", hash_generated_method = "D9F4A3982F3C07E260D6359D1B37C215")
    
@Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (mOverlay != null && mOverlay.isStateful()) {
            mOverlay.setState(getDrawableState());
            invalidate();
        }
    }
    
    private class QueryHandler extends AsyncQueryHandler {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.404 -0500", hash_original_method = "9B79E3E63BDEF0F27411ADE3BE0052BB", hash_generated_method = "09B5D9ACB037B399D23809322FF8FC00")
        
public QueryHandler(ContentResolver cr) {
            super(cr);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.408 -0500", hash_original_method = "8665D4A0C21AED185AE6812E2DF2128E", hash_generated_method = "EB9E7FC14E98BFF1788A7BD25DD2D084")
        
@Override
        protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
            Uri lookupUri = null;
            Uri createUri = null;
            boolean trigger = false;

            try {
                switch(token) {
                    case TOKEN_PHONE_LOOKUP_AND_TRIGGER:
                        trigger = true;
                        createUri = Uri.fromParts("tel", (String)cookie, null);

                        //$FALL-THROUGH$
                    case TOKEN_PHONE_LOOKUP: {
                        if (cursor != null && cursor.moveToFirst()) {
                            long contactId = cursor.getLong(PHONE_ID_COLUMN_INDEX);
                            String lookupKey = cursor.getString(PHONE_LOOKUP_STRING_COLUMN_INDEX);
                            lookupUri = Contacts.getLookupUri(contactId, lookupKey);
                        }

                        break;
                    }
                    case TOKEN_EMAIL_LOOKUP_AND_TRIGGER:
                        trigger = true;
                        createUri = Uri.fromParts("mailto", (String)cookie, null);

                        //$FALL-THROUGH$
                    case TOKEN_EMAIL_LOOKUP: {
                        if (cursor != null && cursor.moveToFirst()) {
                            long contactId = cursor.getLong(EMAIL_ID_COLUMN_INDEX);
                            String lookupKey = cursor.getString(EMAIL_LOOKUP_STRING_COLUMN_INDEX);
                            lookupUri = Contacts.getLookupUri(contactId, lookupKey);
                        }
                        break;
                    }
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }

            mContactUri = lookupUri;
            onContactUriChanged();

            if (trigger && lookupUri != null) {
                // Found contact, so trigger QuickContact
                QuickContact.showQuickContact(getContext(), QuickContactBadge.this, lookupUri,
                        QuickContact.MODE_LARGE, mExcludeMimes);
            } else if (createUri != null) {
                // Prompt user to add this person to contacts
                final Intent intent = new Intent(Intents.SHOW_OR_CREATE_CONTACT, createUri);
                getContext().startActivity(intent);
            }
        }
        
    }

    /** This call has no effect anymore, as there is only one QuickContact mode */
    @DSSink({DSSinkKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.381 -0500", hash_original_method = "02B3BF267746F04A443A6F33FDD49C50", hash_generated_method = "8DE5AB9FAD140791B6E1A06A3AED821B")
    
@SuppressWarnings("unused")
    public void setMode(int size) {
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.383 -0500", hash_original_method = "23D2E4F314D26FFBC9D75F31C49B7153", hash_generated_method = "1D455346E497046E21B5D8556C4DFFFF")
    
@Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (!isEnabled()) {
            // not clickable? don't show triangle
            return;
        }

        if (mOverlay == null || mOverlay.getIntrinsicWidth() == 0 ||
                mOverlay.getIntrinsicHeight() == 0) {
            // nothing to draw
            return;
        }

        mOverlay.setBounds(0, 0, getWidth(), getHeight());

        if (mPaddingTop == 0 && mPaddingLeft == 0) {
            mOverlay.draw(canvas);
        } else {
            int saveCount = canvas.getSaveCount();
            canvas.save();
            canvas.translate(mPaddingLeft, mPaddingTop);
            mOverlay.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    /** True if a contact, an email address or a phone number has been assigned */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.385 -0500", hash_original_method = "FCE3B5086AEC0F336253CCDCDE531810", hash_generated_method = "39F8BD95C60DAF4B4F02B7D2464E2E6C")
    
private boolean isAssigned() {
        return mContactUri != null || mContactEmail != null || mContactPhone != null;
    }

    /**
     * Resets the contact photo to the default state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.388 -0500", hash_original_method = "E4AF1B9673F011A8417C08012510E27B", hash_generated_method = "5EABEB3AE86D756D6D30D83A4ABC5FEF")
    
public void setImageToDefault() {
        if (mDefaultAvatar == null) {
            mDefaultAvatar = getResources().getDrawable(R.drawable.ic_contact_picture);
        }
        setImageDrawable(mDefaultAvatar);
    }

    /**
     * Assign the contact uri that this QuickContactBadge should be associated
     * with. Note that this is only used for displaying the QuickContact window and
     * won't bind the contact's photo for you. Call {@link #setImageDrawable(Drawable)} to set the
     * photo.
     *
     * @param contactUri Either a {@link Contacts#CONTENT_URI} or
     *            {@link Contacts#CONTENT_LOOKUP_URI} style URI.
     */
    @DSComment("Contact manipulation UI")
    @DSSpec(DSCat.CONTACT)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.390 -0500", hash_original_method = "F07B10D1C60A4CC654BA1655A0E456BD", hash_generated_method = "E2C6A43B359882336153206DBEED5B85")
    
public void assignContactUri(Uri contactUri) {
        mContactUri = contactUri;
        mContactEmail = null;
        mContactPhone = null;
        onContactUriChanged();
    }

    /**
     * Assign a contact based on an email address. This should only be used when
     * the contact's URI is not available, as an extra query will have to be
     * performed to lookup the URI based on the email.
     *
     * @param emailAddress The email address of the contact.
     * @param lazyLookup If this is true, the lookup query will not be performed
     * until this view is clicked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.393 -0500", hash_original_method = "7E46CBF823F769C000B50BD24A037D73", hash_generated_method = "734D35A9074C3333BADCEA23C260DABC")
    
public void assignContactFromEmail(String emailAddress, boolean lazyLookup) {
        mContactEmail = emailAddress;
        if (!lazyLookup) {
            mQueryHandler.startQuery(TOKEN_EMAIL_LOOKUP, null,
                    Uri.withAppendedPath(Email.CONTENT_LOOKUP_URI, Uri.encode(mContactEmail)),
                    EMAIL_LOOKUP_PROJECTION, null, null, null);
        } else {
            mContactUri = null;
            onContactUriChanged();
        }
    }

    /**
     * Assign a contact based on a phone number. This should only be used when
     * the contact's URI is not available, as an extra query will have to be
     * performed to lookup the URI based on the phone number.
     *
     * @param phoneNumber The phone number of the contact.
     * @param lazyLookup If this is true, the lookup query will not be performed
     * until this view is clicked.
     */
    @DSComment("Contact manipulation UI")
    @DSSpec(DSCat.CONTACT)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.395 -0500", hash_original_method = "615886346605DCC8A37347200BE80EDB", hash_generated_method = "1929BA143A9C517068A4599A02DEEDF6")
    
public void assignContactFromPhone(String phoneNumber, boolean lazyLookup) {
        mContactPhone = phoneNumber;
        if (!lazyLookup) {
            mQueryHandler.startQuery(TOKEN_PHONE_LOOKUP, null,
                    Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, mContactPhone),
                    PHONE_LOOKUP_PROJECTION, null, null, null);
        } else {
            mContactUri = null;
            onContactUriChanged();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.397 -0500", hash_original_method = "8712FDD692B08E6979A43AB02ED73539", hash_generated_method = "6C3F92EB8F185EEC93FF0FAB48C6EBE3")
    
private void onContactUriChanged() {
        setEnabled(isAssigned());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.399 -0500", hash_original_method = "58382461F76E5F0CD49350469EC07976", hash_generated_method = "A5ABAA9F0A344073317EB255684B5814")
    
@Override
    public void onClick(View v) {
        if (mContactUri != null) {
            QuickContact.showQuickContact(getContext(), QuickContactBadge.this, mContactUri,
                    QuickContact.MODE_LARGE, mExcludeMimes);
        } else if (mContactEmail != null) {
            mQueryHandler.startQuery(TOKEN_EMAIL_LOOKUP_AND_TRIGGER, mContactEmail,
                    Uri.withAppendedPath(Email.CONTENT_LOOKUP_URI, Uri.encode(mContactEmail)),
                    EMAIL_LOOKUP_PROJECTION, null, null, null);
        } else if (mContactPhone != null) {
            mQueryHandler.startQuery(TOKEN_PHONE_LOOKUP_AND_TRIGGER, mContactPhone,
                    Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, mContactPhone),
                    PHONE_LOOKUP_PROJECTION, null, null, null);
        } else {
            // If a contact hasn't been assigned, don't react to click.
            return;
        }
    }

    /**
     * Set a list of specific MIME-types to exclude and not display. For
     * example, this can be used to hide the {@link Contacts#CONTENT_ITEM_TYPE}
     * profile icon.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.401 -0500", hash_original_method = "6EE6B4CDAB8A2B121BC24B2101C4B640", hash_generated_method = "D0DB403E43BE795AB35FDD45CBB16A28")
    
public void setExcludeMimes(String[] excludeMimes) {
        mExcludeMimes = excludeMimes;
    }
}

