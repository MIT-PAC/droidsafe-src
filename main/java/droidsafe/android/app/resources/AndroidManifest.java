package droidsafe.android.app.resources;

import java.util.*;
import java.io.*;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;

import droidsafe.android.system.AndroidComponents;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;


/**
 * These classes represent the information stored in an AndroidManifest.
 * Common values are represented as fields in the classes.  Less common
 * values can be retrieved from the attribute map (if the field is present).
 * 
 * Values that are not present are null.  All primitive values are stored
 * as wrapped primitives so that attributes that are not present can be
 * distinguished.  In some cases, where the spec makes it very clear what the
 * default value is for a missing attribute that value is set if the attribute
 * is missing.  To make those cases clear, those fields are NOT wrapped.
 */
public class AndroidManifest {
    private final static Logger logger = LoggerFactory.getLogger(AndroidManifest.class);

    public Manifest manifest = null;
    public Application application = null;
    public List<Activity> activities = new ArrayList<Activity>();
    public List<Service> services = new ArrayList<Service>();
    public List<Receiver> receivers = new ArrayList<Receiver>();
    public List<Provider> providers = new ArrayList<Provider>();
    /** All component classes registered in the manifest */
    Set<SootClass> components = new LinkedHashSet<SootClass>();
    Map<SootClass, ComponentBaseElement> scToBaseElement = new HashMap<SootClass, ComponentBaseElement>();

    public UsesSDK uses_sdk = null;
    public List<UsesPermission> uses_permissions 
    = new ArrayList<UsesPermission>();
    public List<Permission> permissions = new ArrayList<Permission>();
    public List<UsesFeature> features = new ArrayList<UsesFeature>();

    public AndroidManifest (File manifest) throws Exception {

        DocumentBuilderFactory docBuilderFactory 
        = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse (manifest);    
        doc.normalize();
        Element e = doc.getDocumentElement();

        if (false)
            BaseElement.dump_node (e, 0);

        // The only element should be the manifest
        if ((e.getNodeType() != Node.ELEMENT_NODE) 
                || !e.getNodeName().equalsIgnoreCase ("manifest")) {
            String msg = String.format ("unknown node type %d, name %s in Manifest",
                e.getNodeType(), e.getNodeName());
            throw new InvalidPropertiesFormatException (msg);
        }

        this.manifest = new Manifest (null, e);
    }  

    public Set<SootClass> allComponents() {
        return components;
    }

    public List<? extends ComponentBaseElement> getComponentsByType(AndroidComponents type) {
        switch (type) {
            case ACTIVITY: return activities;
            case SERVICE: return services;
            case BROADCAST_RECEIVER: return receivers; 
            case CONTENT_PROVIDER: return providers;
            default: return null;
        }

    }

    public boolean isDefinedInManifest(SootClass clz) {
        return scToBaseElement.containsKey(clz);
    }

    public boolean isExported(SootClass clz) {
        if (!isDefinedInManifest(clz))
            return true;

        if (scToBaseElement.get(clz).hasIntentFilter())
            return true;

        return scToBaseElement.get(clz).isExported();
    }
    
    public boolean isEnabled(SootClass clz) {
        if (!isDefinedInManifest(clz))
            return true;
       
        return scToBaseElement.get(clz).enabled;
    }

    /**
     * Return the set of all components as sootclasses.
     */
    public Set<SootClass> getComponents() {
        return components;
    }

    /** 
     * Process a node in an AndroidManifest and any of its childen.  Upon
     * completion all of the fields in this class should be filled in
     */
    void process_node (BaseElement parent, Node n) 
            throws InvalidPropertiesFormatException {

        if (n.getNodeType() == Node.ELEMENT_NODE) {
            String name = n.getNodeName();
            if (name.equalsIgnoreCase ("application") ||
               (name.equalsIgnoreCase ("android.app.application")))
                application = new Application (parent, n);
            else if (name.equalsIgnoreCase ("activity"))
                activities.add (new Activity (parent, n));
            else if (name.equalsIgnoreCase ("service"))
                services.add (new Service (parent, n));
            else if (name.equalsIgnoreCase ("receiver"))
                receivers.add (new Receiver (parent, n));
            else if (name.equalsIgnoreCase ("provider"))
                providers.add (new Provider (parent, n));
            else if (name.equalsIgnoreCase ("uses-sdk"))
                uses_sdk = new UsesSDK (parent, n);
            else if (name.equalsIgnoreCase ("uses-permission"))
                uses_permissions.add (new UsesPermission (parent, n));
            else if (name.equalsIgnoreCase ("permission"))
                permissions.add (new Permission (parent, n));
            else if (name.equalsIgnoreCase ("uses-feature"))
                features.add (new UsesFeature(parent, n));
            else { 
                parent.xml_error ("Unexpected node %s in manifest ignored", 
                    n.getNodeName());
            }
        }
    }

    void process_children (BaseElement parent, Node n) 
            throws InvalidPropertiesFormatException {
        NodeList children = n.getChildNodes();
        if (children != null) {
            for (int ii = 0; ii < children.getLength(); ii++) {
                Node child = children.item(ii);
                process_node (parent, child);
            }
        }
    }


    /** Manifest is the top level of the Android Manifest **/
    class Manifest extends BaseElement {

        public String package_name = null;

        public Manifest (BaseElement parent, Node n) 
                throws InvalidPropertiesFormatException {

            super(n, parent);

            // Don't fail on missing/misformed elements, just complain about them
            errors_are_exceptions = false;
            log = System.out;

            package_name = get_attr ("package");
            process_children (this, n);
        }

        public String toString() {
            return String.format ("%s (version %s)", package_name, 
                get_attr("versionName"));
        }
    }


    /**
     * Application class to hold information about  Application.  
     * @author Nguyen Nguyen
     *
     */
    public class Application extends BaseElement {

        public String name = null;

        public Application (BaseElement parent, Node n) 
                throws InvalidPropertiesFormatException {

            super(n, parent);
            name = get_attr ("name");
            process_children (this, n);

            if (name == null || name.length() == 0)
                name = "android.app.Application";
        }

        public String toString() {
            return name;
        }

        private SootClass sootClass;

        public void setSootClass(String name) {
            String className;

            if (name.startsWith(".")) {
            	logger.info("name started with . " + name);
                className = Resources.v().package_name + name;
            }
            else if (!name.contains("."))  {
            	logger.info("name does not contain DOT " + name);
                className = Resources.v().package_name + "." + name;
            }
            else
                className = name;
            try {
                if (!Scene.v().containsClass(className))
                    throw new Exception();

                sootClass = Scene.v().getSootClass(className);

                if (sootClass.isPhantom() || !sootClass.isInScene())
                    throw new Exception();
            } catch (Exception e) {
                logger.error("Unable to resolve underlying class for component in Manifest (Manifest Error): {}, class {}", 
                		name, className);
                droidsafe.main.Main.exit(1);
            }

        }

        public SootClass getSootClass() {
            return sootClass;
        }
    }

    /**
     * Comoponent Base class where Service, Provider, Receiver and Provider will derive from
     * @author nnguyen
     *
     */
    public abstract class ComponentBaseElement extends BaseElement {
        public List<IntentFilter> intent_filters = new ArrayList<IntentFilter>();
        public boolean enabled = true;
        public ComponentBaseElement (Node n, BaseElement parent) throws 
        InvalidPropertiesFormatException {
            super(n, parent);
            String enabledString = get_attr("enabled");
            if (enabledString != null && enabledString.equals("false"))
                enabled = false;
        }
        private SootClass sootClass;

        public boolean setSootClass(String name) {
            String className;

            if (name.startsWith(".")) {
                //.Component
                className = Resources.v().package_name + name;
            }
            else if (!name.contains(".")) {
                //Component
                className = Resources.v().package_name + "." + name;
            }
            else {
                //com.google.ABC
                className = name;
            }

            try {
                if (!Scene.v().containsClass(className))
                    throw new Exception();

                sootClass = Scene.v().getSootClass(className);

                scToBaseElement.put(sootClass, this);

                if (sootClass.isPhantom() || !sootClass.isInScene())
                    throw new Exception();
            } catch (Exception e) {
                logger.error("Unable to resolve underlying class for component in Manifest (Manifest Error): {}, from {}, {} ", 
                    className, name, e);
                logger.error("Package name from AndroidManifest.xml: {} ", Resources.v().package_name);
                //droidsafe.main.Main.exit(1);
                return false;
            }
            return true;
        }

        public SootClass getSootClass() {
            return sootClass;
        } 

        public boolean isExported() {
            String exported = get_attr("exported");
            if (exported == null)
                return true;

            return "true".equals(exported);
        }

        public boolean hasIntentFilter() {
            for (Node child : gather_children()) {
                String name = child.getNodeName();
                if (name.equalsIgnoreCase ("intent-filter"))
                    return true;
            }

            return false;
        }
    }

    public class Activity extends ComponentBaseElement {

        /** The resource number of the view associated with this activity **/
        Set<Integer> content_views = new LinkedHashSet<Integer>();

        public String label;
        public String name;

        public List<MetaData> metaDataList = new LinkedList<MetaData>();

        public Activity (BaseElement parent, Node n) 
                throws InvalidPropertiesFormatException {

            super (n, parent);
            label = get_attr ("label");
            name = get_attr ("name");

            for (Node child : gather_children()) {
                String name = child.getNodeName();
                if (name.equalsIgnoreCase ("intent-filter"))
                    intent_filters.add (new IntentFilter(parent, child));
                else if (name.equalsIgnoreCase("meta-data")) {
                    metaDataList.add(new MetaData(parent, child));
                }
                else {
                    xml_error ("Unexpected node %s in activity %s ignored", 
                        n.getNodeName(), name);
                }
            }
        }

        /** Returns the fully qualified classname of the activities main class **/
        public String main_class() {
            return manifest.package_name + "." + name;
        }

        public String toString() {
            if (intent_filters.size() > 0) 
                return String.format ("%s: intent-filters: %s", name, intent_filters);
            return name;
        }

    }

    public class Service extends ComponentBaseElement {

        public boolean enabled;
        public boolean exported;
        public Boolean isolatedProcess;
        public String label;
        public String name;
        public String permission;
        public String process;

        public Service (BaseElement parent, Node n) 
                throws InvalidPropertiesFormatException {

            super (n, parent);
            enabled = boolean_attribute ("enabled", true);
            isolatedProcess = boolean_attribute ("isolatedProcess");
            label = get_attr ("label");
            name = get_attr ("name");
            permission = get_attr ("permission");
            process = get_attr ("process");

            for (Node child : gather_children()) {
                String name = child.getNodeName();
                if (name.equalsIgnoreCase ("intent-filter"))
                    intent_filters.add (new IntentFilter(parent, child));
                else {
                    xml_error ("Unexpected node %s in service %s ignored", 
                        n.getNodeName(), name);
                }
            }

            // Services are exported by default if there is at least one intent filter
            exported = boolean_attribute ("exported", (intent_filters.size() > 0));

        }

        /** Returns the fully qualified classname of the activities main class **/
        public String main_class() {
            return manifest.package_name + "." + name;
        }

        public String toString() {
            if (intent_filters.size() > 0) 
                return String.format ("%s: intent-filters: %s", name, intent_filters);
            return name;
        }

    }

    public class Receiver extends ComponentBaseElement {

        @Attribute public boolean enabled = true;
        @Attribute public boolean exported = true;
        @Attribute public String label;
        @Attribute public String name;
        @Attribute public String permission;
        @Attribute public String process;

        public List<MetaData> metadata = new ArrayList<MetaData>();

        public Receiver (BaseElement parent, Node n) 
                throws InvalidPropertiesFormatException {

            super (n, parent);
            get_attributes (this);

            for (Node child : gather_children()) {
                String name = child.getNodeName();
                if (name.equalsIgnoreCase ("intent-filter"))
                    intent_filters.add (new IntentFilter(parent, child));
                else if (name.equalsIgnoreCase ("meta-data"))
                    metadata.add (new MetaData (parent, child));
                else {
                    xml_error ("Unexpected node '%s' in receiver named '%s' ignored", 
                        name, this.name);
                }
            }

        }
    }

    /**
     * http://developer.android.com/guide/topics/manifest/provider-element.html
     *
     * Declares a content provider component. A content provider is a
     * subclass of ContentProvider that supplies structured access to
     * data managed by the application. All content providers in your
     * application must be defined in a 'provider' element in the
     * manifest file; otherwise, the system is unaware of them and
     * doesn't run them.
     *
     * You only declare content providers that are part of your
     * application. Content providers in other applications that you use
     * in your application should not be declared.
     *
     * The Android system stores references to content providers
     * according to an authority string, part of the provider's content
     * URI. For example, suppose you want to access a content provider
     * that stores information about health care professionals. To do
     * this, you call the method ContentResolver.query(), which among
     * other arguments takes a URI that identifies the provider:
     *
     *   content://com.example.project.healthcareprovider/nurses/rn
     *
     * The content: scheme identifies the URI as a content URI pointing
     * to an Android content provider. The authority
     * com.example.project.healthcareprovider identifies the provider
     * itself; the Android system looks up the authority in its list of
     * known providers and their authorities. The substring nurses/rn is
     * a path, which the content provider can use to identify subsets of
     * the provider data.
     *
     * Notice that when you define your provider in the 'provider'
     * element, you don't include the scheme or the path in the
     * android:name argument, only the authority.  For information on
     * using and developing content providers, see the API Guide,
     * Content Providers.
     */
    public class Provider extends ComponentBaseElement {

        @Attribute public String authorities;
        @Attribute public boolean enabled = true;
        @Attribute public Boolean exported;
        @Attribute public Boolean grantUriPermissions;
        @Attribute public Integer initOrder;
        @Attribute public String label;
        @Attribute public String name;
        @Attribute public String permission;
        @Attribute public String process;
        @Attribute public String readPermission;
        @Attribute public Boolean syncable;
        @Attribute public String writePermission;

        public Provider (BaseElement parent, Node n) 
                throws InvalidPropertiesFormatException {

            super (n, parent);
            get_attributes (this);

            for (Node child : gather_children()) {
                String name = child.getNodeName();
                // Needs to handle grant-uri-permission, path-permission
                xml_error ("Unexpected node %s in service %s ignored", 
                    n.getNodeName(), name);
            }
        }

        public String toString() {
            return name;
        }
        
        /**
         * Return true if the provided authority is defined in the authorities attribute.
         */
        public boolean definesAuthority(String authority) {
            String[] splitAuthorities = authorities.split(";");
            
            for (String defined : splitAuthorities) {
                defined = defined.trim();
                if (authority.equals(defined))
                    return true;
            }
            
            return false;
        }
    }

    /**
     * A name-value pair for an item of additional, arbitrary data that
     * can be supplied to the parent component. A component element can
     * contain any number of 'meta-data' subelements. The values from
     * all of them are collected in a single Bundle object and made
     * available to the component as the PackageItemInfo.metaData field.
     */
    public class MetaData extends BaseElement {

        @Attribute public String name;
        @Attribute public String resource;
        @Attribute public String value;

        public MetaData (BaseElement parent, Node n) 
                throws InvalidPropertiesFormatException {

            super (n, parent);
            get_attributes (this);

            for (Node child : gather_children()) {
                String name = child.getNodeName();
                xml_error ("Unexpected node '%s' in meta-data named '%s' ignored", 
                    name, this.name);
            }
        }

        public String toString() {
            return name;
        }
    }

    public class UsesFeature extends BaseElement {

        @Attribute public String name;
        @Attribute public Boolean required; 

        public UsesFeature (BaseElement parent, Node n) 
                throws InvalidPropertiesFormatException {

            super (n, parent);
            get_attributes (this);

            for (Node child : gather_children()) {
                String name = child.getNodeName();
                xml_error ("Unexpected node '%s' in uses-sdk ignored", name);
            }
        }

        public String toString() {
            return String.format ("UsesFeature: name %s, Required = %s",
                name, required);
        }
    }

    /**
     * Specifies the API level (not the version number of the SDK) that an
     * application is compatible with
     */
    public class UsesSDK extends BaseElement {

        @Attribute public Integer minSdkVersion;
        @Attribute public Integer targetSdkVersion;
        @Attribute public Integer maxSdkVersion;

        public UsesSDK (BaseElement parent, Node n) 
                throws InvalidPropertiesFormatException {

            super (n, parent);
            get_attributes (this);

            for (Node child : gather_children()) {
                String name = child.getNodeName();
                xml_error ("Unexpected node '%s' in uses-sdk ignored", name);
            }
        }

        public String toString() {
            return String.format ("UsesSDK: min: %s, target: %s, max: %s", 
                minSdkVersion, targetSdkVersion, maxSdkVersion);
        }
    }

    /**
     * Requests a permission that the application must be granted in
     * order for it to operate correctly. Permissions are granted by the
     * user when the application is installed, not while it's running.
     */
    public class UsesPermission extends BaseElement {

        @Attribute public String name;

        public UsesPermission (BaseElement parent, Node n) 
                throws InvalidPropertiesFormatException {

            super (n, parent);
            get_attributes (this);

            for (Node child : gather_children()) {
                String name = child.getNodeName();
                xml_error ("Unexpected node '%s' in uses-permission named '%s' ignored", 
                    name, this.name);
            }
        }

        public String toString() {
            return "UsesPermission: " + name;
        }
    }

    /**
     * Declares a security permission that can be used to limit access
     * to specific components or features of this or other applications
     */
    public class Permission extends BaseElement {

        @Attribute public String name;
        @Attribute public String description;
        @Attribute public String label;
        @Attribute public String resource;
        @Attribute public String permissionGroup;
        @Attribute public String protectionLevel;

        public Permission (BaseElement parent, Node n) 
                throws InvalidPropertiesFormatException {

            super (n, parent);
            get_attributes (this);

            for (Node child : gather_children()) {
                String name = child.getNodeName();
                xml_error ("Unexpected node '%s' in permission named '%s' ignored", 
                    name, this.name);
            }
        }

        public String toString() {
            return "Permission: " + name;
        }
    }

    /** 
     * Class for IntentFilter information.  
     */
    public class IntentFilter extends BaseElement {

        // list of actions accepted by filter
        public List<String> actions = new ArrayList<String>();

        // List of categories accepted by filter
        public List<String>  categories = new ArrayList<String>();

        public List<String>  dataHost = new ArrayList<String>();
        public List<String>  dataMime = new ArrayList<String>();
        public List<String>  dataPort = new ArrayList<String>();
        public List<String>  dataScheme =  new ArrayList<String>();
        public List<String>  dataPath = new ArrayList<String>();
        public List<String>  dataPathPattern = new ArrayList<String>();
        public List<String>  dataPathPrefix = new ArrayList<String>();
        public List<String> dataList = new ArrayList<String>();

        /** list of built uri RE strings, built from the attributes of the intent-filter */
        public List<String> dataUri = new ArrayList<String>();

        public IntentFilter (BaseElement parent, Node n) 
                throws InvalidPropertiesFormatException {

            super(n, parent);

            for (Node child : gather_children()) {
                String name = child.getNodeName();
                logger.info("processing node %s in IntentFilter", name);
                if (name.equalsIgnoreCase ("action"))
                    actions.add (get_attr (child, "name"));
                else if (name.equalsIgnoreCase ("category"))
                    categories.add (get_attr (child, "name"));
                else if (name.equalsIgnoreCase ("data")) {
                    StringBuffer uriBuilder = new StringBuffer();
                    boolean host = false;
                    boolean hasMimeType = false;

                    if (get_attr(child, "mimeType") != null) {
                        dataMime.add(get_attr(child, "mimeType"));
                        hasMimeType = true;
                    }
                    
                    
                    if (get_attr(child, "scheme") != null) {
                        String value = get_attr(child, "scheme");
                        dataScheme.add(value);
                        uriBuilder.append(String.format("%s://", value));
                    } else if (hasMimeType) {
                        uriBuilder.append("(file|content)://");
                    } else {
                        //according to documentation:
                        //If a scheme is not specified (and no mimetype) for the intent filter, all the other URI attributes are ignored.                        
                        continue;
                    }

                    if (get_attr(child, "host") != null) {
                        host = true;
                        String value = get_attr(child, "host");
                        dataHost.add(value);
                        uriBuilder.append(String.format("%s", value));

                        if (get_attr(child, "port") != null) {
                            String port = get_attr(child, "port"); 
                            dataPort.add(port);
                            uriBuilder.append(String.format(":%s", port));
                        }
                    }

                    boolean hasPath = false;
                    if (host) {               
                        if (get_attr(child, "path") != null) {
                            String value = get_attr(child, "path"); 
                            dataPath.add(value);                    
                            hasPath = true;
                            dataUri.add(uriBuilder.toString() + String.format("/%s", value));
                        }

                        if (get_attr(child, "pathPattern") != null) {
                            hasPath = true;             
                            String value = get_attr(child, "pathPattern");
                            dataPathPattern.add(value);
                            dataUri.add(uriBuilder.toString() + String.format("/%s", value));
                        }

                        if (get_attr(child, "pathPrefix") != null) {
                            hasPath = true;          
                            String value = get_attr(child, "pathPrefix");
                            dataPathPrefix.add(value);
                            dataUri.add(uriBuilder.toString() + String.format("/%s", value));
                        }
                    }

                    //no path, so just add the uri string built
                    if (!hasPath) {
                        dataUri.add(uriBuilder.toString() + "/*"); 
                    }


                }
                else { // unexpected node
                    xml_error ("Unexpected node %s in intent-filter ignored", 
                        name);
                }
            }

        }
    }   
}
