package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.app.AliasActivity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;

class PreferenceInflater extends GenericInflater<Preference, PreferenceGroup> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.502 -0400", hash_original_field = "D1487CA8252F4AA0A95324AB4DDD5316", hash_generated_field = "13262EB3751B753EEB3302EF75D8B1E5")

    private PreferenceManager mPreferenceManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.503 -0400", hash_original_method = "50527EB8D19F2F0D64584B04C3D41EF2", hash_generated_method = "D6D28B12B333061A7C201785812F6799")
    public  PreferenceInflater(Context context, PreferenceManager preferenceManager) {
        super(context);
        init(preferenceManager);
        addTaint(context.getTaint());
        addTaint(preferenceManager.getTaint());
        // ---------- Original Method ----------
        //init(preferenceManager);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.503 -0400", hash_original_method = "CBCBABB7FE70B103F3E123A80F4BFEB8", hash_generated_method = "809E76E315FCFAE6A68DEDAD22D7D4BC")
      PreferenceInflater(GenericInflater<Preference, PreferenceGroup> original, PreferenceManager preferenceManager, Context newContext) {
        super(original, newContext);
        init(preferenceManager);
        addTaint(original.getTaint());
        addTaint(preferenceManager.getTaint());
        addTaint(newContext.getTaint());
        // ---------- Original Method ----------
        //init(preferenceManager);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.504 -0400", hash_original_method = "FF1F94752C869BA06052B7A67A109910", hash_generated_method = "682C07709D93C69BF492C1EBB0CB6917")
    @Override
    public GenericInflater<Preference, PreferenceGroup> cloneInContext(Context newContext) {
        GenericInflater<Preference, PreferenceGroup> varB4EAC82CA7396A68D541C85D26508E83_985059816 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_985059816 = new PreferenceInflater(this, mPreferenceManager, newContext);
        addTaint(newContext.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_985059816.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_985059816;
        // ---------- Original Method ----------
        //return new PreferenceInflater(this, mPreferenceManager, newContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.504 -0400", hash_original_method = "7B227AC4C6BF5338AF52F597A9EDC5E2", hash_generated_method = "97D721084DFEECEA5417B367F5EF73D1")
    private void init(PreferenceManager preferenceManager) {
        mPreferenceManager = preferenceManager;
        setDefaultPackage("android.preference.");
        // ---------- Original Method ----------
        //mPreferenceManager = preferenceManager;
        //setDefaultPackage("android.preference.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.505 -0400", hash_original_method = "295C055EC64DF7189FE6DF67209CBBC4", hash_generated_method = "E68CCD076DB0E20554E7575F6984F7E9")
    @Override
    protected boolean onCreateCustomFromTag(XmlPullParser parser, Preference parentPreference,
            AttributeSet attrs) throws XmlPullParserException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final String tag = parser.getName();
        {
            boolean var5BE944252877569CC94E888792E6D758_662897185 = (tag.equals(INTENT_TAG_NAME));
            {
                Intent intent = null;
                try 
                {
                    intent = Intent.parseIntent(getContext().getResources(), parser, attrs);
                } //End block
                catch (IOException e)
                {
                    XmlPullParserException ex = new XmlPullParserException(
                        "Error parsing preference");
                    ex.initCause(e);
                    if (DroidSafeAndroidRuntime.control) throw ex;
                } //End block
                {
                    parentPreference.setIntent(intent);
                } //End block
            } //End block
            {
                boolean varFA18FB7EC231D2706E0747E224A5CB67_1142170943 = (tag.equals(EXTRA_TAG_NAME));
                {
                    getContext().getResources().parseBundleExtra(EXTRA_TAG_NAME, attrs,
                    parentPreference.getExtras());
                    try 
                    {
                        XmlUtils.skipCurrentTag(parser);
                    } //End block
                    catch (IOException e)
                    {
                        XmlPullParserException ex = new XmlPullParserException(
                        "Error parsing preference");
                        ex.initCause(e);
                        if (DroidSafeAndroidRuntime.control) throw ex;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(parser.getTaint());
        addTaint(parentPreference.getTaint());
        addTaint(attrs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_329503763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_329503763;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.505 -0400", hash_original_method = "677330D7578A225E3A8F3B018B853A0C", hash_generated_method = "EE1B179466990B5E6DEFFD4741E9C279")
    @Override
    protected PreferenceGroup onMergeRoots(PreferenceGroup givenRoot, boolean attachToGivenRoot,
            PreferenceGroup xmlRoot) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        PreferenceGroup varB4EAC82CA7396A68D541C85D26508E83_1816274796 = null; //Variable for return #1
        PreferenceGroup varB4EAC82CA7396A68D541C85D26508E83_484937459 = null; //Variable for return #2
        {
            xmlRoot.onAttachedToHierarchy(mPreferenceManager);
            varB4EAC82CA7396A68D541C85D26508E83_1816274796 = xmlRoot;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_484937459 = givenRoot;
        } //End block
        addTaint(givenRoot.getTaint());
        addTaint(attachToGivenRoot);
        addTaint(xmlRoot.getTaint());
        PreferenceGroup varA7E53CE21691AB073D9660D615818899_713865605; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_713865605 = varB4EAC82CA7396A68D541C85D26508E83_1816274796;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_713865605 = varB4EAC82CA7396A68D541C85D26508E83_484937459;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_713865605.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_713865605;
        // ---------- Original Method ----------
        //if (givenRoot == null) {
            //xmlRoot.onAttachedToHierarchy(mPreferenceManager);
            //return xmlRoot;
        //} else {
            //return givenRoot;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.506 -0400", hash_original_field = "CC8ACA106F6290F3A7C71CC6BC7F2325", hash_generated_field = "51862D8DBF3975C527844ECFFE8161D7")

    private static final String TAG = "PreferenceInflater";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.506 -0400", hash_original_field = "1D953FC9E39CE8F449C111E1CEABB7F3", hash_generated_field = "92DCFA625A163150FAF710C1B8511031")

    private static final String INTENT_TAG_NAME = "intent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.506 -0400", hash_original_field = "82F944EA1D0CD5852D3BD9F756FE9CEE", hash_generated_field = "7482A4F6F924E88A63D3F01DD26DE8B7")

    private static final String EXTRA_TAG_NAME = "extra";
}

