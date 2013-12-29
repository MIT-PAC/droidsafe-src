package android.preference;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;

import com.android.internal.util.XmlUtils;




class PreferenceInflater extends GenericInflater<Preference, PreferenceGroup> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:15.675 -0500", hash_original_field = "BA3A8A544724D0E4E42D6BF4A9E4DAC8", hash_generated_field = "51862D8DBF3975C527844ECFFE8161D7")

    private static final String TAG = "PreferenceInflater";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:15.676 -0500", hash_original_field = "E16FFAA03325E339CEF0621828DB82CA", hash_generated_field = "92DCFA625A163150FAF710C1B8511031")

    private static final String INTENT_TAG_NAME = "intent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:15.677 -0500", hash_original_field = "8785E51C6EFC793663CF47AE60566B4A", hash_generated_field = "7482A4F6F924E88A63D3F01DD26DE8B7")

    private static final String EXTRA_TAG_NAME = "extra";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:15.677 -0500", hash_original_field = "F44A9B2F698C7B96C36DE45B8F61794D", hash_generated_field = "13262EB3751B753EEB3302EF75D8B1E5")


    private PreferenceManager mPreferenceManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:15.678 -0500", hash_original_method = "50527EB8D19F2F0D64584B04C3D41EF2", hash_generated_method = "EEC468F90D8E00AB757571523C2C60CD")
    public PreferenceInflater(Context context, PreferenceManager preferenceManager) {
        super(context);
        init(preferenceManager);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:15.679 -0500", hash_original_method = "CBCBABB7FE70B103F3E123A80F4BFEB8", hash_generated_method = "CBCBABB7FE70B103F3E123A80F4BFEB8")
    PreferenceInflater(GenericInflater<Preference, PreferenceGroup> original, PreferenceManager preferenceManager, Context newContext) {
        super(original, newContext);
        init(preferenceManager);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:15.680 -0500", hash_original_method = "FF1F94752C869BA06052B7A67A109910", hash_generated_method = "D002D8CD4BC3305737889E4528569FB5")
    @Override
public GenericInflater<Preference, PreferenceGroup> cloneInContext(Context newContext) {
        return new PreferenceInflater(this, mPreferenceManager, newContext);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:15.681 -0500", hash_original_method = "7B227AC4C6BF5338AF52F597A9EDC5E2", hash_generated_method = "1BAC0EABFF78094E41E7999CDDD424C2")
    private void init(PreferenceManager preferenceManager) {
        mPreferenceManager = preferenceManager;
        setDefaultPackage("android.preference.");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:15.682 -0500", hash_original_method = "295C055EC64DF7189FE6DF67209CBBC4", hash_generated_method = "A49F78E383E0DC0415039AFD49AC2F3E")
    @Override
protected boolean onCreateCustomFromTag(XmlPullParser parser, Preference parentPreference,
            AttributeSet attrs) throws XmlPullParserException {
        final String tag = parser.getName();
        
        if (tag.equals(INTENT_TAG_NAME)) {
            Intent intent = null;
            
            try {
                intent = Intent.parseIntent(getContext().getResources(), parser, attrs);
            } catch (IOException e) {
                XmlPullParserException ex = new XmlPullParserException(
                        "Error parsing preference");
                ex.initCause(e);
                throw ex;
            }
            
            if (intent != null) {
                parentPreference.setIntent(intent);
            }
            
            return true;
        } else if (tag.equals(EXTRA_TAG_NAME)) {
            getContext().getResources().parseBundleExtra(EXTRA_TAG_NAME, attrs,
                    parentPreference.getExtras());
            try {
                XmlUtils.skipCurrentTag(parser);
            } catch (IOException e) {
                XmlPullParserException ex = new XmlPullParserException(
                        "Error parsing preference");
                ex.initCause(e);
                throw ex;
            }
            return true;
        }
        
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:15.683 -0500", hash_original_method = "677330D7578A225E3A8F3B018B853A0C", hash_generated_method = "C1EBE6F09A6778CC669F985F96F689A8")
    @Override
protected PreferenceGroup onMergeRoots(PreferenceGroup givenRoot, boolean attachToGivenRoot,
            PreferenceGroup xmlRoot) {
        // If we were given a Preferences, use it as the root (ignoring the root
        // Preferences from the XML file).
        if (givenRoot == null) {
            xmlRoot.onAttachedToHierarchy(mPreferenceManager);
            return xmlRoot;
        } else {
            return givenRoot;
        }
    }
}

