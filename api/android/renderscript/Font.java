package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import android.content.res.AssetManager;
import java.util.Map;
import android.util.Log;
import android.util.TypedValue;
import java.io.File;
import android.os.Environment;
import java.util.HashMap;
import java.io.IOException;
import android.content.res.Resources;
public class Font extends BaseObj {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:43.874 -0400", hash_original_method = "CEBF3BB0FBFA1185414632BE38CC53FE", hash_generated_method = "B0A91AB37DDDDB03FFE5C45B734C8AA5")
      Font(int id, RenderScript rs) {
        super(id, rs);
        addTaint(rs.getTaint());
        addTaint(id);
        // ---------- Original Method ----------
    }

    
        private static void addFamilyToMap(FontFamily family) {
        for(int i = 0; i < family.mNames.length; i ++) {
            sFontFamilyMap.put(family.mNames[i], family);
        }
    }

    
        private static void initFontFamilyMap() {
        sFontFamilyMap = new HashMap<String, FontFamily>();
        FontFamily sansFamily = new FontFamily();
        sansFamily.mNames = sSansNames;
        sansFamily.mNormalFileName = "Roboto-Regular.ttf";
        sansFamily.mBoldFileName = "Roboto-Bold.ttf";
        sansFamily.mItalicFileName = "Roboto-Italic.ttf";
        sansFamily.mBoldItalicFileName = "Roboto-BoldItalic.ttf";
        addFamilyToMap(sansFamily);
        FontFamily serifFamily = new FontFamily();
        serifFamily.mNames = sSerifNames;
        serifFamily.mNormalFileName = "DroidSerif-Regular.ttf";
        serifFamily.mBoldFileName = "DroidSerif-Bold.ttf";
        serifFamily.mItalicFileName = "DroidSerif-Italic.ttf";
        serifFamily.mBoldItalicFileName = "DroidSerif-BoldItalic.ttf";
        addFamilyToMap(serifFamily);
        FontFamily monoFamily = new FontFamily();
        monoFamily.mNames = sMonoNames;
        monoFamily.mNormalFileName = "DroidSansMono.ttf";
        monoFamily.mBoldFileName = "DroidSansMono.ttf";
        monoFamily.mItalicFileName = "DroidSansMono.ttf";
        monoFamily.mBoldItalicFileName = "DroidSansMono.ttf";
        addFamilyToMap(monoFamily);
    }

    
        static String getFontFileName(String familyName, Style style) {
        FontFamily family = sFontFamilyMap.get(familyName);
        if(family != null) {
            switch(style) {
                case NORMAL:
                    return family.mNormalFileName;
                case BOLD:
                    return family.mBoldFileName;
                case ITALIC:
                    return family.mItalicFileName;
                case BOLD_ITALIC:
                    return family.mBoldItalicFileName;
            }
        }
        return "DroidSans.ttf";
    }

    
        static public Font createFromFile(RenderScript rs, Resources res, String path, float pointSize) {
        rs.validate();
        int dpi = res.getDisplayMetrics().densityDpi;
        int fontId = rs.nFontCreateFromFile(path, pointSize, dpi);
        if(fontId == 0) {
            throw new RSRuntimeException("Unable to create font from file " + path);
        }
        Font rsFont = new Font(fontId, rs);
        return rsFont;
    }

    
        static public Font createFromFile(RenderScript rs, Resources res, File path, float pointSize) {
        return createFromFile(rs, res, path.getAbsolutePath(), pointSize);
    }

    
        static public Font createFromAsset(RenderScript rs, Resources res, String path, float pointSize) {
        rs.validate();
        AssetManager mgr = res.getAssets();
        int dpi = res.getDisplayMetrics().densityDpi;
        int fontId = rs.nFontCreateFromAsset(mgr, path, pointSize, dpi);
        if(fontId == 0) {
            throw new RSRuntimeException("Unable to create font from asset " + path);
        }
        Font rsFont = new Font(fontId, rs);
        return rsFont;
    }

    
        static public Font createFromResource(RenderScript rs, Resources res, int id, float pointSize) {
        String name = "R." + Integer.toString(id);
        rs.validate();
        InputStream is = null;
        try {
            is = res.openRawResource(id);
        } catch (Exception e) {
            throw new RSRuntimeException("Unable to open resource " + id);
        }
        int dpi = res.getDisplayMetrics().densityDpi;
        int fontId = 0;
        if (is instanceof AssetManager.AssetInputStream) {
            int asset = ((AssetManager.AssetInputStream) is).getAssetInt();
            fontId = rs.nFontCreateFromAssetStream(name, pointSize, dpi, asset);
        } else {
            throw new RSRuntimeException("Unsupported asset stream created");
        }
        if(fontId == 0) {
            throw new RSRuntimeException("Unable to create font from resource " + id);
        }
        Font rsFont = new Font(fontId, rs);
        return rsFont;
    }

    
        static public Font create(RenderScript rs, Resources res, String familyName, Style fontStyle, float pointSize) {
        String fileName = getFontFileName(familyName, fontStyle);
        String fontPath = Environment.getRootDirectory().getAbsolutePath();
        fontPath += "/fonts/" + fileName;
        return createFromFile(rs, res, fontPath, pointSize);
    }

    
    private static class FontFamily {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:43.935 -0400", hash_original_field = "EBC18CA3F76B59E4A33A3D6FB8F12F1C", hash_generated_field = "C468A34F5DD151632BC543C242FE3020")

        String[] mNames;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:43.939 -0400", hash_original_field = "3FAEF7E15E575D81F243F6AB6FFAB33D", hash_generated_field = "8405B33ACB81E7FCD7174A69A1A9F1C5")

        String mNormalFileName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:43.955 -0400", hash_original_field = "C187AB4E881BA9C77BA14F646DD37ED9", hash_generated_field = "E437C40DB3D9DC288DE7AA73AF1A11BF")

        String mBoldFileName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:43.957 -0400", hash_original_field = "4CFDECDEC04DBA0BE85B1A55AB82FF33", hash_generated_field = "1656ED9CD212F40AB8536F22B2C84A3E")

        String mItalicFileName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:43.959 -0400", hash_original_field = "10ABEF4C22A0459431FF2073B54CE119", hash_generated_field = "2D7185F9EF5F494D5A3DF2089C6F43AA")

        String mBoldItalicFileName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:43.961 -0400", hash_original_method = "4B1D119D7774A95910A46246D7100E2A", hash_generated_method = "4B1D119D7774A95910A46246D7100E2A")
        public FontFamily ()
        {
            //Synthesized constructor
        }


    }


    
    public enum Style {
        NORMAL,
        BOLD,
        ITALIC,
        BOLD_ITALIC;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:43.964 -0400", hash_original_field = "663719D388FE6222DCFB3247F55A9215", hash_generated_field = "8BC2D87CD2A1F44E6D97553AF264AE04")

    private static final String[] sSansNames = {
        "sans-serif", "arial", "helvetica", "tahoma", "verdana"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:43.966 -0400", hash_original_field = "BC9730F37AF5822F2284642EE2CB0442", hash_generated_field = "956EE2129D0161C6B10DC2012BE919B2")

    private static final String[] sSerifNames = {
        "serif", "times", "times new roman", "palatino", "georgia", "baskerville",
        "goudy", "fantasy", "cursive", "ITC Stone Serif"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:43.968 -0400", hash_original_field = "6569F52E74250E381B7EEE220482BC23", hash_generated_field = "61C4C302027A48126C97C1452FCD5ED2")

    private static final String[] sMonoNames = {
        "monospace", "courier", "courier new", "monaco"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:43.970 -0400", hash_original_field = "E3A7D140B22E30E1A66930F8CD11AE9D", hash_generated_field = "6636438EA6751E60F063FC76FE98D8F6")

    private static Map<String, FontFamily> sFontFamilyMap;
    static {
        initFontFamilyMap();
    }
    
}

