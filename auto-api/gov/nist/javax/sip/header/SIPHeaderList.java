package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.GenericObject;
import gov.nist.core.Separators;
import gov.nist.javax.sip.header.ims.PrivacyHeader;
import javax.sip.header.Header;
import java.lang.reflect.Constructor;
import java.util.*;

public abstract class SIPHeaderList<HDR extends SIPHeader> extends SIPHeader implements java.util.List<HDR>, Header {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.461 -0400", hash_original_field = "54FC99FFF06FAFF26E47359497AA764D", hash_generated_field = "1610EB574C9A048E3BE2EA98FBE15AF1")

    protected List<HDR> hlist;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.461 -0400", hash_original_field = "D0509468108F68C610DFF430648FE029", hash_generated_field = "7DDB65A0A435AAFCBC63AD9D687C490F")

    private Class<HDR> myClass;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.462 -0400", hash_original_method = "D7E30AE5F54C678856B1E2B4E08FADF6", hash_generated_method = "DD0314912C40308B77D7E83CB7E4756A")
    private  SIPHeaderList() {
        hlist = new LinkedList<HDR>();
        // ---------- Original Method ----------
        //hlist = new LinkedList<HDR>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.462 -0400", hash_original_method = "C956079DDC347F2EE85C1D1E44860715", hash_generated_method = "71A8CB9F8A10DE5179F85ADE3330F4CD")
    protected  SIPHeaderList(Class<HDR> objclass, String hname) {
        this();
        this.headerName = hname;
        this.myClass =  objclass;
        addTaint(hname.getTaint());
        // ---------- Original Method ----------
        //this.headerName = hname;
        //this.myClass =  objclass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.462 -0400", hash_original_method = "5A8D65821D08B5534EF9F59F256EB0ED", hash_generated_method = "C94CF503B90709F4D4703CBF71A21A3B")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1890077639 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1890077639 = this.headerName;
        varB4EAC82CA7396A68D541C85D26508E83_1890077639.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1890077639;
        // ---------- Original Method ----------
        //return this.headerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.463 -0400", hash_original_method = "45FF804DBFA2BB4F4071CDF27CE28633", hash_generated_method = "9385DF776C8F99CB5ACCDEA5F27C2F78")
    public boolean add(HDR objectToAdd) {
        hlist.add((HDR)objectToAdd);
        addTaint(objectToAdd.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_734433503 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_734433503;
        // ---------- Original Method ----------
        //hlist.add((HDR)objectToAdd);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.463 -0400", hash_original_method = "87B618AF10705C22EFB36E4A71158D56", hash_generated_method = "DE9B6D6649ABF9C8DB0585491FFC6042")
    public void addFirst(HDR obj) {
        hlist.add(0,(HDR) obj);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //hlist.add(0,(HDR) obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.463 -0400", hash_original_method = "3D14CCA72C816FE4801BBC05991E4343", hash_generated_method = "DEFF22172743287D432AD5098BC3CE0A")
    public void add(HDR sipheader, boolean top) {
        this.addFirst(sipheader);
        this.add(sipheader);
        addTaint(sipheader.getTaint());
        addTaint(top);
        // ---------- Original Method ----------
        //if (top)
            //this.addFirst(sipheader);
        //else
            //this.add(sipheader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.463 -0400", hash_original_method = "2C5EDAC0235777863EFD087B4072277C", hash_generated_method = "404BFC6CB25B05B66A65C3518964A329")
    public void concatenate(SIPHeaderList<HDR> other, boolean topFlag) throws IllegalArgumentException {
        {
            this.addAll(other);
        } //End block
        {
            this.addAll(0, other);
        } //End block
        addTaint(other.getTaint());
        addTaint(topFlag);
        // ---------- Original Method ----------
        //if (!topFlag) {
            //this.addAll(other);
        //} else {
            //this.addAll(0, other);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.464 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "AEF9E08E3E0D382F09686E44B4F252F6")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1959560323 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1959560323 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1959560323.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1959560323;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.466 -0400", hash_original_method = "4452028BB43CC449CBD4FD5523C455CD", hash_generated_method = "68EE06C75EA6BB125DBC04ED24273AE9")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1844398957 = null; //Variable for return #1
        {
            boolean varADCB242902E2A36C5E7E88B9C037FBC8_1099350463 = (hlist.isEmpty());
            {
                buffer.append(headerName).append(':').append(Separators.NEWLINE);
            } //End block
            {
                {
                    boolean varAA9EB60710CB021FA924A856488476AF_1169873123 = (this.headerName.equals(SIPHeaderNames.WWW_AUTHENTICATE)
                    || this.headerName.equals(SIPHeaderNames.PROXY_AUTHENTICATE)
                    || this.headerName.equals(SIPHeaderNames.AUTHORIZATION)
                    || this.headerName.equals(SIPHeaderNames.PROXY_AUTHORIZATION)
                    || (prettyEncode &&
                            (this.headerName.equals(SIPHeaderNames.VIA) || this.headerName.equals(SIPHeaderNames.ROUTE) || this.headerName.equals(SIPHeaderNames.RECORD_ROUTE))) 
                    || this.getClass().equals( ExtensionHeaderList.class));
                    {
                        ListIterator<HDR> li = hlist.listIterator();
                        {
                            boolean varD36012C5F0076A971BB5DCB92CB4D117_504141696 = (li.hasNext());
                            {
                                HDR sipheader = (HDR) li.next();
                                sipheader.encode(buffer);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        buffer.append(headerName).append(Separators.COLON).append(Separators.SP);
                        this.encodeBody(buffer);
                        buffer.append(Separators.NEWLINE);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1844398957 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1844398957.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1844398957;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.467 -0400", hash_original_method = "3A5F29F99CF35D16AD0C376ECAFA4E44", hash_generated_method = "385EBBDF8E107C78F6F46FB0C56E389E")
    public List<String> getHeadersAsEncodedStrings() {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_941078704 = null; //Variable for return #1
        List<String> retval = new LinkedList<String>();
        ListIterator<HDR> li = hlist.listIterator();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_2043900085 = (li.hasNext());
            {
                Header sipheader = li.next();
                retval.add(sipheader.toString());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_941078704 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_941078704.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_941078704;
        // ---------- Original Method ----------
        //List<String> retval = new LinkedList<String>();
        //ListIterator<HDR> li = hlist.listIterator();
        //while (li.hasNext()) {
            //Header sipheader = li.next();
            //retval.add(sipheader.toString());
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.468 -0400", hash_original_method = "6C7059400A289BDBD2DC174FD9546E0E", hash_generated_method = "8108EB184C7B440769BDA3A275C60D34")
    public Header getFirst() {
        Header varB4EAC82CA7396A68D541C85D26508E83_1979414903 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_1512717424 = null; //Variable for return #2
        {
            boolean varBC3C1D335DC6F5058F706F5D73C7DB2D_1694234310 = (hlist == null || hlist.isEmpty());
            varB4EAC82CA7396A68D541C85D26508E83_1979414903 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1512717424 = hlist.get(0);
        } //End collapsed parenthetic
        Header varA7E53CE21691AB073D9660D615818899_421502201; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_421502201 = varB4EAC82CA7396A68D541C85D26508E83_1979414903;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_421502201 = varB4EAC82CA7396A68D541C85D26508E83_1512717424;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_421502201.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_421502201;
        // ---------- Original Method ----------
        //if (hlist == null || hlist.isEmpty())
            //return null;
        //else
            //return  hlist.get(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.468 -0400", hash_original_method = "564DA566938B5DEC3F30C613889BA2FD", hash_generated_method = "04B162375626EB0CE63B9685F16701D9")
    public Header getLast() {
        Header varB4EAC82CA7396A68D541C85D26508E83_273091437 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_1087877770 = null; //Variable for return #2
        {
            boolean varBC3C1D335DC6F5058F706F5D73C7DB2D_1321389961 = (hlist == null || hlist.isEmpty());
            varB4EAC82CA7396A68D541C85D26508E83_273091437 = null;
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1087877770 = hlist.get(hlist.size() - 1);
        Header varA7E53CE21691AB073D9660D615818899_22134140; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_22134140 = varB4EAC82CA7396A68D541C85D26508E83_273091437;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_22134140 = varB4EAC82CA7396A68D541C85D26508E83_1087877770;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_22134140.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_22134140;
        // ---------- Original Method ----------
        //if (hlist == null || hlist.isEmpty())
            //return null;
        //return  hlist.get(hlist.size() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.469 -0400", hash_original_method = "52DB400388897C60F1E5D7C5CF768C2C", hash_generated_method = "7345113348BD01D2D7132362B2FA6BCB")
    public Class<HDR> getMyClass() {
        Class<HDR> varB4EAC82CA7396A68D541C85D26508E83_1354170704 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1354170704 = this.myClass;
        varB4EAC82CA7396A68D541C85D26508E83_1354170704.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1354170704;
        // ---------- Original Method ----------
        //return  this.myClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.469 -0400", hash_original_method = "FF43F4EB263E123805961D1A87217B48", hash_generated_method = "D77AA8B9C02C62352955C61918DA3C8F")
    public boolean isEmpty() {
        boolean varE0F068754A4434D383386203B916E809_1733399143 = (hlist.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997336482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997336482;
        // ---------- Original Method ----------
        //return hlist.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.469 -0400", hash_original_method = "36E257E69C92FC5D45CD0DCB007DB07A", hash_generated_method = "ACC3504AA077C9B5F7D20AFD327E78D0")
    public ListIterator<HDR> listIterator() {
        ListIterator<HDR> varB4EAC82CA7396A68D541C85D26508E83_1609812799 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1609812799 = hlist.listIterator(0);
        varB4EAC82CA7396A68D541C85D26508E83_1609812799.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1609812799;
        // ---------- Original Method ----------
        //return hlist.listIterator(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.470 -0400", hash_original_method = "9E6C15618943805727A8B08583C0FF39", hash_generated_method = "1119E8CEC416A65CB67F70E69E9DD711")
    public List<HDR> getHeaderList() {
        List<HDR> varB4EAC82CA7396A68D541C85D26508E83_1748783200 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1748783200 = this.hlist;
        varB4EAC82CA7396A68D541C85D26508E83_1748783200.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1748783200;
        // ---------- Original Method ----------
        //return this.hlist;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.470 -0400", hash_original_method = "EDE82742DF271310D47CFC69F814BF44", hash_generated_method = "64936F67CC6AF634017CD919F3698638")
    public ListIterator<HDR> listIterator(int position) {
        ListIterator<HDR> varB4EAC82CA7396A68D541C85D26508E83_1877847988 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1877847988 = hlist.listIterator(position);
        addTaint(position);
        varB4EAC82CA7396A68D541C85D26508E83_1877847988.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1877847988;
        // ---------- Original Method ----------
        //return hlist.listIterator(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.470 -0400", hash_original_method = "66F538C19C1B45B9F4975D517A08EBE7", hash_generated_method = "F3FA50F85DC97B3015E8BC48A45CAD35")
    public void removeFirst() {
        {
            boolean varEF2906AB9D37F5F9FE2592D0F985ED0F_1019555866 = (hlist.size() != 0);
            hlist.remove(0);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (hlist.size() != 0)
            //hlist.remove(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.471 -0400", hash_original_method = "56685A1560151077841543B2BC810F93", hash_generated_method = "0FDB31334271BD0240626E073CE18AB9")
    public void removeLast() {
        {
            boolean varEF2906AB9D37F5F9FE2592D0F985ED0F_1832986941 = (hlist.size() != 0);
            hlist.remove(hlist.size() - 1);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (hlist.size() != 0)
            //hlist.remove(hlist.size() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.471 -0400", hash_original_method = "6090D81CA85470AC09234766F76789C0", hash_generated_method = "56A405BFDAA92E947880A2F17F556F0D")
    public boolean remove(HDR obj) {
        {
            boolean varE27C8BEA585DAC7A51DC79C569D41E9A_391881706 = (hlist.size() == 0);
            boolean varD8FBF7C33228C788AD0720ECF32B962A_804902037 = (hlist.remove(obj));
        } //End collapsed parenthetic
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_681802550 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_681802550;
        // ---------- Original Method ----------
        //if (hlist.size() == 0)
            //return false;
        //else
            //return hlist.remove(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.471 -0400", hash_original_method = "23B9304014C757503CC0D5B9D6DB550F", hash_generated_method = "B52967299638535006F513B062474563")
    protected void setMyClass(Class<HDR> cl) {
        this.myClass = cl;
        // ---------- Original Method ----------
        //this.myClass = cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.472 -0400", hash_original_method = "CC42CBF49D5975143777F4A2B14A482C", hash_generated_method = "E8B8D054B81031D25DE14DDB24050705")
    public String debugDump(int indentation) {
        String varB4EAC82CA7396A68D541C85D26508E83_814127675 = null; //Variable for return #1
        stringRepresentation = "";
        String indent = new Indentation(indentation).getIndentation();
        String className = this.getClass().getName();
        sprint(indent + className);
        sprint(indent + "{");
        {
            Iterator<HDR> it = hlist.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_896559939 = (it.hasNext());
            {
                HDR sipHeader = (HDR) it.next();
                sprint(indent + sipHeader.debugDump());
            } //End block
        } //End collapsed parenthetic
        sprint(indent + "}");
        varB4EAC82CA7396A68D541C85D26508E83_814127675 = stringRepresentation;
        addTaint(indentation);
        varB4EAC82CA7396A68D541C85D26508E83_814127675.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_814127675;
        // ---------- Original Method ----------
        //stringRepresentation = "";
        //String indent = new Indentation(indentation).getIndentation();
        //String className = this.getClass().getName();
        //sprint(indent + className);
        //sprint(indent + "{");
        //for (Iterator<HDR> it = hlist.iterator(); it.hasNext();) {
            //HDR sipHeader = (HDR) it.next();
            //sprint(indent + sipHeader.debugDump());
        //}
        //sprint(indent + "}");
        //return stringRepresentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.472 -0400", hash_original_method = "ABFB21316126C2849AB41073C957D80E", hash_generated_method = "0737787CA09077F6A24F7162E6213D07")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_1372583965 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1372583965 = debugDump(0);
        varB4EAC82CA7396A68D541C85D26508E83_1372583965.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1372583965;
        // ---------- Original Method ----------
        //return debugDump(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.474 -0400", hash_original_method = "7EBA89BCEE46EEC5D25867CF89F8E8B9", hash_generated_method = "3FE1A1975B37156D7BB26BB81CB6AB84")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1307930346 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1307930346 = hlist.toArray();
        varB4EAC82CA7396A68D541C85D26508E83_1307930346.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1307930346;
        // ---------- Original Method ----------
        //return hlist.toArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.474 -0400", hash_original_method = "795B857E8950EF3C66EEA5946EF97E00", hash_generated_method = "693BE2FE844A9B39945B89D379B679BE")
    public int indexOf(GenericObject gobj) {
        int varFE7F2AD0158B0E9DB2F579EDDA049625_1968567578 = (hlist.indexOf(gobj));
        addTaint(gobj.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696262982 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696262982;
        // ---------- Original Method ----------
        //return hlist.indexOf(gobj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.475 -0400", hash_original_method = "D4A0602F4424EB672EFBEE9811EC3EF2", hash_generated_method = "179768562AFF79E4A8B63E31DC8FFE58")
    public void add(int index, HDR  sipHeader) throws IndexOutOfBoundsException {
        hlist.add(index, sipHeader);
        addTaint(index);
        addTaint(sipHeader.getTaint());
        // ---------- Original Method ----------
        //hlist.add(index, sipHeader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.476 -0400", hash_original_method = "7AF224A0221DFF0013A72A01287D2D95", hash_generated_method = "AD8EEB1E1AB9B63C435D72168F085685")
    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        {
            boolean var140A8815FDEEC27C4D8944D501CA10BC_1007790623 = (other == this);
        } //End collapsed parenthetic
        {
            SIPHeaderList<SIPHeader> that = (SIPHeaderList<SIPHeader>) other;
            boolean varB0759ED93504D2871EADB7BC17D112AC_1592569817 = (that.hlist == null || that.hlist.size() == 0);
            boolean var5490630F41DAE65E89132ADE4761F7BB_884071376 = (this.hlist.equals(that.hlist));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_915156573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_915156573;
        // ---------- Original Method ----------
        //if (other == this)
            //return true;
        //if (other instanceof SIPHeaderList) {
            //SIPHeaderList<SIPHeader> that = (SIPHeaderList<SIPHeader>) other;
            //if (this.hlist == that.hlist)
                //return true;
            //else if (this.hlist == null)
                //return that.hlist == null || that.hlist.size() == 0;
            //return this.hlist.equals(that.hlist);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.477 -0400", hash_original_method = "6ED02991F9AD79524F79D6703964DFB6", hash_generated_method = "5C95A83EC91647DF154E5C9D39F77FFC")
    public boolean match(SIPHeaderList<?> template) {
        {
            boolean var42D525C71BB0E2BEC53AF10700E42587_1530089088 = (!this.getClass().equals(template.getClass()));
        } //End collapsed parenthetic
        SIPHeaderList<SIPHeader> that = (SIPHeaderList<SIPHeader>) template;
        {
            {
                Iterator<SIPHeader> it = that.hlist.iterator();
                boolean varB2FF4435B274CC4BE01D264DEA08F957_124860004 = (it.hasNext());
                {
                    SIPHeader sipHeader = (SIPHeader) it.next();
                    boolean found = false;
                    {
                        Iterator<HDR> it1 = this.hlist.iterator();
                        boolean varD776FD1A955609D835179BFFD00F64DE_1250637688 = (it1.hasNext()
                        && !found);
                        {
                            SIPHeader sipHeader1 = (SIPHeader) it1.next();
                            found = sipHeader1.match(sipHeader);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(template.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2042537143 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2042537143;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.478 -0400", hash_original_method = "359991759D26E2A3F33ACAEA17758D18", hash_generated_method = "64719AB2D7C2BC77EBB9C90CD19BCB05")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_330025330 = null; //Variable for return #1
        try 
        {
            Class<?> clazz = this.getClass();
            Constructor<?> cons = clazz.getConstructor((Class[])null);
            SIPHeaderList<HDR> retval = (SIPHeaderList<HDR>) cons.newInstance((Object[])null);
            retval.headerName = this.headerName;
            retval.myClass  = this.myClass;
            varB4EAC82CA7396A68D541C85D26508E83_330025330 = retval.clonehlist(this.hlist);
        } //End block
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Could not clone!", ex);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_330025330.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_330025330;
        // ---------- Original Method ----------
        //try {
            //Class<?> clazz = this.getClass();
            //Constructor<?> cons = clazz.getConstructor((Class[])null);
            //SIPHeaderList<HDR> retval = (SIPHeaderList<HDR>) cons.newInstance((Object[])null);
            //retval.headerName = this.headerName;
            //retval.myClass  = this.myClass;
            //return retval.clonehlist(this.hlist);
        //} catch (Exception ex) {
            //throw new RuntimeException("Could not clone!", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.479 -0400", hash_original_method = "CA032BB58CFE2AE5C2CC307C2E78224F", hash_generated_method = "FF41B741209E64028C0706D0EC27BDEB")
    protected final SIPHeaderList<HDR> clonehlist(List<HDR> hlistToClone) {
        SIPHeaderList<HDR> varB4EAC82CA7396A68D541C85D26508E83_527665370 = null; //Variable for return #1
        {
            {
                Iterator<HDR> it = (Iterator<HDR>) hlistToClone.iterator();
                boolean varB2FF4435B274CC4BE01D264DEA08F957_842836993 = (it.hasNext());
                {
                    Header h = it.next();
                    this.hlist.add((HDR)h.clone());
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_527665370 = this;
        addTaint(hlistToClone.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_527665370.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_527665370;
        // ---------- Original Method ----------
        //if (hlistToClone != null) {
            //for (Iterator<HDR> it = (Iterator<HDR>) hlistToClone.iterator(); it.hasNext();) {
                //Header h = it.next();
                //this.hlist.add((HDR)h.clone());
            //}
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.481 -0400", hash_original_method = "FCBD3ECE23AA666BDE06756DAACE9219", hash_generated_method = "7950B8D3D852B598008BB7038FDB0222")
    public int size() {
        int varAD7F07CB7D5D3937AFE4543892270C80_233932627 = (hlist.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447137544 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447137544;
        // ---------- Original Method ----------
        //return hlist.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.483 -0400", hash_original_method = "32932F147EA25CC7B7BC47F740C6BF91", hash_generated_method = "46CEE002A49B3E9AC380441DD8BC969A")
    public boolean isHeaderList() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_928465327 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_928465327;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.485 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "E92D2B50BB331D04E9DE3B8220EB9E0E")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1995062437 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1995062437 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1995062437.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1995062437;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.487 -0400", hash_original_method = "8EFAAECA9CE0AC45762D4D910A6D9585", hash_generated_method = "A8A5F121C5D6F4E873B4665148F7D420")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_475449614 = null; //Variable for return #1
        ListIterator<HDR> iterator = this.listIterator();
        {
            SIPHeader sipHeader = (SIPHeader) iterator.next();
            {
                boolean var81FA26130A77648ABA9F7EE49157FB67_1576898087 = (sipHeader == this);
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Unexpected circularity in SipHeaderList");
            } //End collapsed parenthetic
            sipHeader.encodeBody(buffer);
            {
                boolean var863C7B066016334243F11BA2A858D956_879943474 = (iterator.hasNext());
                {
                    {
                        boolean varEC2BFBCD9D89F853D1F8004544E80422_1663509340 = (!this.headerName.equals(PrivacyHeader.NAME));
                        buffer.append(Separators.COMMA);
                        buffer.append(Separators.SEMICOLON);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_475449614 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_475449614.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_475449614;
        // ---------- Original Method ----------
        //ListIterator<HDR> iterator = this.listIterator();
        //while (true) {
            //SIPHeader sipHeader = (SIPHeader) iterator.next();
            //if ( sipHeader == this ) throw new RuntimeException ("Unexpected circularity in SipHeaderList");
            //sipHeader.encodeBody(buffer);
            //if (iterator.hasNext()) {
                //if (!this.headerName.equals(PrivacyHeader.NAME))
                    //buffer.append(Separators.COMMA);
                //else
                    //buffer.append(Separators.SEMICOLON);
                //continue;
            //} else
                //break;
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.487 -0400", hash_original_method = "D5DDE9BDBABBA5EC4E7B0879A10A7D8D", hash_generated_method = "F3AA9D692314446889B8E815A2D75E9B")
    public boolean addAll(Collection<? extends HDR> collection) {
        boolean var9940151E0E552CDF60A32A4F5430F34D_679441200 = (this.hlist.addAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2136222012 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2136222012;
        // ---------- Original Method ----------
        //return this.hlist.addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.488 -0400", hash_original_method = "5E3DA6DCBC302D72E9103E3CB1D3527B", hash_generated_method = "498EE732F15DAF7198C8104617B3352F")
    public boolean addAll(int index, Collection<? extends HDR> collection) {
        boolean varEFE51ECFC9507D8AC4C14D317E8D6CB0_1267455416 = (this.hlist.addAll(index, collection));
        addTaint(index);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_201212441 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_201212441;
        // ---------- Original Method ----------
        //return this.hlist.addAll(index, collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.489 -0400", hash_original_method = "F1DA48A9A827D74FF9F3AEB298E80E0A", hash_generated_method = "365B1227EF707ADA010A0499E24B7458")
    public boolean containsAll(Collection<?> collection) {
        boolean varD2618BE52D31E66DA0B87AF95177D40B_827648584 = (this.hlist.containsAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1823009310 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1823009310;
        // ---------- Original Method ----------
        //return this.hlist.containsAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.490 -0400", hash_original_method = "D791B8D331C82850017A4DF87B2D73FE", hash_generated_method = "7B3736200B6CC37F2F0C36EB7F8C7C36")
    public void clear() {
        this.hlist.clear();
        // ---------- Original Method ----------
        //this.hlist.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.490 -0400", hash_original_method = "B039DF80CC42319FF93C93DFC4F09CCF", hash_generated_method = "A014AD07BBCA85D1AB9229AF6766183F")
    public boolean contains(Object header) {
        boolean varFF9B9114D30EEBE8FF7C2118E12A9B47_811478058 = (this.hlist.contains(header));
        addTaint(header.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1200201909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1200201909;
        // ---------- Original Method ----------
        //return this.hlist.contains(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.491 -0400", hash_original_method = "B0FF15B145547E100ED44D45A7137CDE", hash_generated_method = "17ECF84DD273A12FB7DB849168C02CC3")
    public HDR get(int index) {
        HDR varB4EAC82CA7396A68D541C85D26508E83_422948859 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_422948859 = this.hlist.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_422948859.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_422948859;
        // ---------- Original Method ----------
        //return  this.hlist.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.492 -0400", hash_original_method = "9C1A1055EA03DFB32FF882EA4FC9149D", hash_generated_method = "9D82A4EFA5E7A024701281A6900C23B5")
    public int indexOf(Object obj) {
        int varBEC02A7A8B6C276C18FAB86ECDD19E4E_666869314 = (this.hlist.indexOf(obj));
        addTaint(obj.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1912649514 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1912649514;
        // ---------- Original Method ----------
        //return this.hlist.indexOf(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.492 -0400", hash_original_method = "84FF645EE0B76DB0D5B552F9A7A0DC94", hash_generated_method = "EAEECAA45D8F7B65BFD9E645D2A90F16")
    public java.util.Iterator<HDR> iterator() {
        java.util.Iterator<HDR> varB4EAC82CA7396A68D541C85D26508E83_1196769000 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1196769000 = this.hlist.listIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1196769000.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1196769000;
        // ---------- Original Method ----------
        //return this.hlist.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.493 -0400", hash_original_method = "05A7D65C6D911E0B1F3261A66888CB52", hash_generated_method = "1760690311A0D748EFC7F75F2F0A45CE")
    public int lastIndexOf(Object obj) {
        int varD48BB8B2C188D796AB5E25DB24A359A2_382091828 = (this.hlist.lastIndexOf(obj));
        addTaint(obj.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638306768 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638306768;
        // ---------- Original Method ----------
        //return this.hlist.lastIndexOf(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.493 -0400", hash_original_method = "FB49499CFAFE2E72F27390E6807CB034", hash_generated_method = "0B862A3CA7D8891A5E6EF3A80034C204")
    public boolean remove(Object obj) {
        boolean varA126E10370F872777A607D5086A88085_267484502 = (this.hlist.remove(obj));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1560507927 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1560507927;
        // ---------- Original Method ----------
        //return this.hlist.remove(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.493 -0400", hash_original_method = "2B7049D180B166140C32B8D54A96E238", hash_generated_method = "A12D93DB72C2E8363487C251543FAFA3")
    public HDR remove(int index) {
        HDR varB4EAC82CA7396A68D541C85D26508E83_1049989688 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1049989688 = this.hlist.remove(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1049989688.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1049989688;
        // ---------- Original Method ----------
        //return this.hlist.remove(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.494 -0400", hash_original_method = "5A03B3005777615BF04A1D43320D1AA1", hash_generated_method = "76DF819CE58CB490CC69C4F18CED882D")
    public boolean removeAll(java.util.Collection<?> collection) {
        boolean var1B94C4550E9AC61EE706C14BF778F96F_1812599678 = (this.hlist.removeAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1847990435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1847990435;
        // ---------- Original Method ----------
        //return this.hlist.removeAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.494 -0400", hash_original_method = "4FD342E6A050272CE06CEE9969944C1B", hash_generated_method = "0893FC984F9737BEDC9B03D0F24AFCAB")
    public boolean retainAll(java.util.Collection<?> collection) {
        boolean varD3CD1D943CC0A6AFD9C7DA463C27ADE5_2101968565 = (this.hlist.retainAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1923700982 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1923700982;
        // ---------- Original Method ----------
        //return this.hlist.retainAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.495 -0400", hash_original_method = "894CB5A5FAD7AFC5CD5A3389B3F77AB4", hash_generated_method = "59F664B9E41C4637A41EB9C54A76C494")
    public java.util.List<HDR> subList(int index1, int index2) {
        java.util.List<HDR> varB4EAC82CA7396A68D541C85D26508E83_996673167 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_996673167 = this.hlist.subList(index1, index2);
        addTaint(index1);
        addTaint(index2);
        varB4EAC82CA7396A68D541C85D26508E83_996673167.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_996673167;
        // ---------- Original Method ----------
        //return this.hlist.subList(index1, index2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.495 -0400", hash_original_method = "78242797F449E5EBFB278CC5A6BC56D0", hash_generated_method = "CCC426AE87ADFB69D0906839714CA954")
    public int hashCode() {
        int var4B8D37533CC12365BECFAB730FC9EDC2_1965404369 = (this.headerName.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746860403 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746860403;
        // ---------- Original Method ----------
        //return this.headerName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.495 -0400", hash_original_method = "A9FD382DBA3FE66AACB46D6203100A0D", hash_generated_method = "A7F31CF8183BD5A426BD25FA74611028")
    public HDR set(int position, HDR sipHeader) {
        HDR varB4EAC82CA7396A68D541C85D26508E83_393552733 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_393552733 = hlist.set(position, sipHeader);
        addTaint(position);
        addTaint(sipHeader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_393552733.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_393552733;
        // ---------- Original Method ----------
        //return hlist.set(position, sipHeader);
    }

    
    public static void setPrettyEncode(boolean flag) {
        prettyEncode = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.496 -0400", hash_original_method = "B04CD19C0316B320C5B66A678FB2994B", hash_generated_method = "AFF9E2A02EEA4F5AB7E2B8F0BFEA0918")
    public <T> T[] toArray(T[] array) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1277240199 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1277240199 = this.hlist.toArray(array);
        addTaint(array[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1277240199.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1277240199;
        // ---------- Original Method ----------
        //return this.hlist.toArray(array);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.496 -0400", hash_original_field = "BB31D88D930D91866C4879183DCACA7E", hash_generated_field = "F24392C13A6D95700264E5A997197264")

    private static boolean prettyEncode = false;
}

