package droidsafe.android.app.resources;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import droidsafe.main.Config;

/**
 * This class deal-with android Built-in Strings
 * @author Nguyen Nguyen
 *
 */
public class BuiltinStrings {
    private final static Logger logger = LoggerFactory.getLogger(Resources.class);
    static BuiltinStrings builtin = null;
        
    /**
     * singleton access method
     * @return
     */
    public static BuiltinStrings v() { 
        if (builtin == null)
            builtin = new BuiltinStrings();
        return builtin; 
    }
    
    private Map<Integer, String> idToName = new HashMap<Integer, String>();
    private Map<String, Set<RString>> nameToValueSet = new HashMap<String, Set<RString>>();
    
    /**
     * load built-in strings
     */
    public void loadBuiltinStrings() {
        loadBuiltinStrings("us");
    }
    
    public Map<String, Set<RString>> getNameToValueSet() { 
        return nameToValueSet; 
    }
    
    /**
     * load builtin strings for a given locale
     * @param localeSuffix
     */
    private void loadBuiltinStrings(String localeSuffix) {
        
        logger.info("Loading builtin strings for locale {} ", localeSuffix);

        String path = Config.v().ANDROID_LIB_DIR.getPath() + File.separator + "res/values";
        if (localeSuffix != null && !localeSuffix.isEmpty() && !localeSuffix.equalsIgnoreCase("US"))
            path = path + "-" + localeSuffix;
        
        path = path + File.separator + "strings.xml";
        XmlFile xmlFile = new XmlFile(path);
        processStrings(xmlFile);
    }
    
    /**
     * private constructor to initialize default strings
     */
    private BuiltinStrings() {
        /* setup default string ID, to name */
        idToName.put(new Integer(0x01040010), "android.R.string.VideoView_error_button");
        idToName.put(new Integer(0x01040015), "android.R.string.VideoView_error_text_invalid_progressive_playback");
        idToName.put(new Integer(0x01040011), "android.R.string.VideoView_error_text_unknown");
        idToName.put(new Integer(0x01040012), "android.R.string.VideoView_error_title");
        idToName.put(new Integer(0x01040000), "android.R.string.cancel");
        idToName.put(new Integer(0x01040001), "android.R.string.copy");
        idToName.put(new Integer(0x01040002), "android.R.string.copyUrl");
        idToName.put(new Integer(0x01040003), "android.R.string.cut");
        idToName.put(new Integer(0x01040005), "android.R.string.defaultMsisdnAlphaTag");
        idToName.put(new Integer(0x01040004), "android.R.string.defaultVoiceMailAlphaTag");
        idToName.put(new Integer(0x01040014), "android.R.string.dialog_alert_title");
        idToName.put(new Integer(0x01040006), "android.R.string.emptyPhoneNumber");
        idToName.put(new Integer(0x01040007), "android.R.string.httpErrorBadUrl");
        idToName.put(new Integer(0x01040008), "android.R.string.httpErrorUnsupportedScheme");
        idToName.put(new Integer(0x01040009), "android.R.string.no");
        idToName.put(new Integer(0x0104000a), "android.R.string.ok");
        idToName.put(new Integer(0x0104000b), "android.R.string.paste");
        idToName.put(new Integer(0x0104000c), "android.R.string.search_go");
        idToName.put(new Integer(0x0104000d), "android.R.string.selectAll");
        idToName.put(new Integer(0x01040016), "android.R.string.selectTextMode");
        idToName.put(new Integer(0x01040017), "android.R.string.status_bar_notification_info_overflow");
        idToName.put(new Integer(0x0104000e), "android.R.string.unknownName");
        idToName.put(new Integer(0x0104000f), "android.R.string.untitled");
        idToName.put(new Integer(0x01040013), "android.R.string.yes");
    } 
    
    void processStrings(XmlFile xmlFile) {
        logger.info("Processing values from {}", xmlFile);

        BaseElement baseElement = new BaseElement(xmlFile.getDocumentElement(), null);
        List<Node> children = baseElement.gather_children();

        // process strings
        // IMPORTANT: this must execute fully before we process string-arrays because some string values in a string array
        // can be string names. We want to substitute the values in instead but don't have them all until this finishes
        for(int i = 0; i < children.size(); ++i){
            Element element = (Element)children.get(i);
            String tagName = element.getTagName();

            if (tagName.equals("string")){
                Node firstChild = element.getFirstChild();
                if (firstChild != null) {
                    logger.debug("firstChild {} ", firstChild);
                    String stringValue = firstChild.getNodeValue();
                    // create an instance of our internal representation of the android string - RString
                    RString rString = null;
                    try{
                        rString = new RString(element, xmlFile, stringValue);
                    } catch (InvalidPropertiesFormatException e) {
                        logger.error("String {} is not formatted correctly in {} : {}", element, xmlFile, e);
                        continue;
                    }
                    // the name automatically gets assigned during xml parsing
                    String stringName = "android.R.string." + rString.name;
                    
                    logger.debug("Adding a string name to string value mapping: ({}:{})", 
                            stringName, stringValue);

                    Set<RString> valueSet = nameToValueSet.get(stringName);

                    if (valueSet == null) {
                        valueSet = new HashSet<RString>();
                        nameToValueSet.put(stringName, valueSet);
                    }
                    valueSet.add(rString);
                }
            }
        }
    }
}
