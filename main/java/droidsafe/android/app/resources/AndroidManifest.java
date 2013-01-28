package droidsafe.android.app.resources;

import java.util.*;
import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;

import droidsafe.analyses.CallGraphFromEntryPoints;

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
  public UsesSDK uses_sdk = null;
  public List<UsesPermission> uses_permissions 
    = new ArrayList<UsesPermission>();
  public List<Permission> permissions = new ArrayList<Permission>();

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

  /** 
   * Process a node in an AndroidManifest and any of its childen.  Upon
   * completion all of the fields in this class should be filled in
   */
  void process_node (BaseElement parent, Node n) 
    throws InvalidPropertiesFormatException {

    if (n.getNodeType() == Node.ELEMENT_NODE) {
      String name = n.getNodeName();
      if (name.equalsIgnoreCase ("application"))
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

  class Application extends BaseElement {

    public String name = null;

    public Application (BaseElement parent, Node n) 
      throws InvalidPropertiesFormatException {

      super(n, parent);
      name = get_attr ("name");
      process_children (this, n);
    }

    public String toString() {
      return name;
    }
  }

  class Activity extends BaseElement {

    /** The resource number of the view associated with this activity **/
    int content_view = 0;

    public String label;
    public String name;
    public List<IntentFilter> intent_filters = new ArrayList<IntentFilter>();

    public Activity (BaseElement parent, Node n) 
      throws InvalidPropertiesFormatException {

      super (n, parent);
      label = get_attr ("label");
      name = get_attr ("name");

      for (Node child : gather_children()) {
        String name = child.getNodeName();
        if (name.equalsIgnoreCase ("intent-filter"))
          intent_filters.add (new IntentFilter(parent, child));
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

  public class Service extends BaseElement {

    public boolean enabled;
    public boolean exported;
    public Boolean isolatedProcess;
    public String label;
    public String name;
    public String permission;
    public String process;

    public List<IntentFilter> intent_filters = new ArrayList<IntentFilter>();

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

  public class Receiver extends BaseElement {

    @Attribute public boolean enabled = true;
    @Attribute public boolean exported = true;
    @Attribute public String label;
    @Attribute public String name;
    @Attribute public String permission;
    @Attribute public String process;

    public List<IntentFilter> intent_filters = new ArrayList<IntentFilter>();
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
  public class Provider extends BaseElement {

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

    public List<IntentFilter> intent_filters = new ArrayList<IntentFilter>();

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
  class IntentFilter extends BaseElement {

    // list of actions accepted by filter
    List<String> actions = new ArrayList<String>();

    // List of categories accepted by filter
    List<String>  categories = new ArrayList<String>();

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
        else { // unexpected node
          xml_error ("Unexpected node %s in intent-filter ignored", 
                     name);
        }
      }
    }

    public String toString() {
      return String.format ("actions: %s, categories: %s", actions, categories);
    }
  }      
      
}
