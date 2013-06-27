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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.960 -0400", hash_original_field = "54FC99FFF06FAFF26E47359497AA764D", hash_generated_field = "1610EB574C9A048E3BE2EA98FBE15AF1")

    protected List<HDR> hlist;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.960 -0400", hash_original_field = "D0509468108F68C610DFF430648FE029", hash_generated_field = "7DDB65A0A435AAFCBC63AD9D687C490F")

    private Class<HDR> myClass;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.960 -0400", hash_original_method = "D7E30AE5F54C678856B1E2B4E08FADF6", hash_generated_method = "DD0314912C40308B77D7E83CB7E4756A")
    private  SIPHeaderList() {
        hlist = new LinkedList<HDR>();
        // ---------- Original Method ----------
        //hlist = new LinkedList<HDR>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.964 -0400", hash_original_method = "C956079DDC347F2EE85C1D1E44860715", hash_generated_method = "71A8CB9F8A10DE5179F85ADE3330F4CD")
    protected  SIPHeaderList(Class<HDR> objclass, String hname) {
        this();
        this.headerName = hname;
        this.myClass =  objclass;
        addTaint(hname.getTaint());
        // ---------- Original Method ----------
        //this.headerName = hname;
        //this.myClass =  objclass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.967 -0400", hash_original_method = "5A8D65821D08B5534EF9F59F256EB0ED", hash_generated_method = "E87AD745482EDDDAC31FBED8AD039517")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_139283218 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_139283218 = this.headerName;
        varB4EAC82CA7396A68D541C85D26508E83_139283218.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_139283218;
        // ---------- Original Method ----------
        //return this.headerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.969 -0400", hash_original_method = "45FF804DBFA2BB4F4071CDF27CE28633", hash_generated_method = "6DA9E41E2A00240B16160621E37A8177")
    public boolean add(HDR objectToAdd) {
        hlist.add((HDR)objectToAdd);
        addTaint(objectToAdd.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_670982691 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_670982691;
        // ---------- Original Method ----------
        //hlist.add((HDR)objectToAdd);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.970 -0400", hash_original_method = "87B618AF10705C22EFB36E4A71158D56", hash_generated_method = "DE9B6D6649ABF9C8DB0585491FFC6042")
    public void addFirst(HDR obj) {
        hlist.add(0,(HDR) obj);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //hlist.add(0,(HDR) obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.972 -0400", hash_original_method = "3D14CCA72C816FE4801BBC05991E4343", hash_generated_method = "DEFF22172743287D432AD5098BC3CE0A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.973 -0400", hash_original_method = "2C5EDAC0235777863EFD087B4072277C", hash_generated_method = "404BFC6CB25B05B66A65C3518964A329")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.974 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "EEA10A0DED4FA2334870B3504F7AB814")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_30695638 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_30695638 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_30695638.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_30695638;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.986 -0400", hash_original_method = "4452028BB43CC449CBD4FD5523C455CD", hash_generated_method = "90B31F2AF30034534EBB034907609456")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_559139766 = null; //Variable for return #1
        {
            boolean varADCB242902E2A36C5E7E88B9C037FBC8_1102436 = (hlist.isEmpty());
            {
                buffer.append(headerName).append(':').append(Separators.NEWLINE);
            } //End block
            {
                {
                    boolean varAA9EB60710CB021FA924A856488476AF_58014339 = (this.headerName.equals(SIPHeaderNames.WWW_AUTHENTICATE)
                    || this.headerName.equals(SIPHeaderNames.PROXY_AUTHENTICATE)
                    || this.headerName.equals(SIPHeaderNames.AUTHORIZATION)
                    || this.headerName.equals(SIPHeaderNames.PROXY_AUTHORIZATION)
                    || (prettyEncode &&
                            (this.headerName.equals(SIPHeaderNames.VIA) || this.headerName.equals(SIPHeaderNames.ROUTE) || this.headerName.equals(SIPHeaderNames.RECORD_ROUTE))) 
                    || this.getClass().equals( ExtensionHeaderList.class));
                    {
                        ListIterator<HDR> li;
                        li = hlist.listIterator();
                        {
                            boolean varD36012C5F0076A971BB5DCB92CB4D117_445155219 = (li.hasNext());
                            {
                                HDR sipheader;
                                sipheader = (HDR) li.next();
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
        varB4EAC82CA7396A68D541C85D26508E83_559139766 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_559139766.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_559139766;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.986 -0400", hash_original_method = "3A5F29F99CF35D16AD0C376ECAFA4E44", hash_generated_method = "450C77896DA3E03787C2ED8092AF24CF")
    public List<String> getHeadersAsEncodedStrings() {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1883132742 = null; //Variable for return #1
        List<String> retval;
        retval = new LinkedList<String>();
        ListIterator<HDR> li;
        li = hlist.listIterator();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_963518547 = (li.hasNext());
            {
                Header sipheader;
                sipheader = li.next();
                retval.add(sipheader.toString());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1883132742 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1883132742.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1883132742;
        // ---------- Original Method ----------
        //List<String> retval = new LinkedList<String>();
        //ListIterator<HDR> li = hlist.listIterator();
        //while (li.hasNext()) {
            //Header sipheader = li.next();
            //retval.add(sipheader.toString());
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.987 -0400", hash_original_method = "6C7059400A289BDBD2DC174FD9546E0E", hash_generated_method = "275B6C24C114A5AD1FCC5FEFD28C4672")
    public Header getFirst() {
        Header varB4EAC82CA7396A68D541C85D26508E83_2028182054 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_1841003412 = null; //Variable for return #2
        {
            boolean varBC3C1D335DC6F5058F706F5D73C7DB2D_8709533 = (hlist == null || hlist.isEmpty());
            varB4EAC82CA7396A68D541C85D26508E83_2028182054 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1841003412 = hlist.get(0);
        } //End collapsed parenthetic
        Header varA7E53CE21691AB073D9660D615818899_409798948; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_409798948 = varB4EAC82CA7396A68D541C85D26508E83_2028182054;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_409798948 = varB4EAC82CA7396A68D541C85D26508E83_1841003412;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_409798948.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_409798948;
        // ---------- Original Method ----------
        //if (hlist == null || hlist.isEmpty())
            //return null;
        //else
            //return  hlist.get(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.987 -0400", hash_original_method = "564DA566938B5DEC3F30C613889BA2FD", hash_generated_method = "48BD4C0A133309F79E9B2AEF2CAEEABA")
    public Header getLast() {
        Header varB4EAC82CA7396A68D541C85D26508E83_169864070 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_981969848 = null; //Variable for return #2
        {
            boolean varBC3C1D335DC6F5058F706F5D73C7DB2D_809162505 = (hlist == null || hlist.isEmpty());
            varB4EAC82CA7396A68D541C85D26508E83_169864070 = null;
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_981969848 = hlist.get(hlist.size() - 1);
        Header varA7E53CE21691AB073D9660D615818899_1291839098; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1291839098 = varB4EAC82CA7396A68D541C85D26508E83_169864070;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1291839098 = varB4EAC82CA7396A68D541C85D26508E83_981969848;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1291839098.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1291839098;
        // ---------- Original Method ----------
        //if (hlist == null || hlist.isEmpty())
            //return null;
        //return  hlist.get(hlist.size() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.988 -0400", hash_original_method = "52DB400388897C60F1E5D7C5CF768C2C", hash_generated_method = "E8FB839C6F26DEDA61973EF2DA0DC9D7")
    public Class<HDR> getMyClass() {
        Class<HDR> varB4EAC82CA7396A68D541C85D26508E83_195287813 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_195287813 = this.myClass;
        varB4EAC82CA7396A68D541C85D26508E83_195287813.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_195287813;
        // ---------- Original Method ----------
        //return  this.myClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.988 -0400", hash_original_method = "FF43F4EB263E123805961D1A87217B48", hash_generated_method = "E64C7D2C0427D69D6EF4B1BF82411A67")
    public boolean isEmpty() {
        boolean varE0F068754A4434D383386203B916E809_232390180 = (hlist.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1285776339 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1285776339;
        // ---------- Original Method ----------
        //return hlist.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.988 -0400", hash_original_method = "36E257E69C92FC5D45CD0DCB007DB07A", hash_generated_method = "DF541EE00456A18A808B7A45CBA90F09")
    public ListIterator<HDR> listIterator() {
        ListIterator<HDR> varB4EAC82CA7396A68D541C85D26508E83_1002093135 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1002093135 = hlist.listIterator(0);
        varB4EAC82CA7396A68D541C85D26508E83_1002093135.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1002093135;
        // ---------- Original Method ----------
        //return hlist.listIterator(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.989 -0400", hash_original_method = "9E6C15618943805727A8B08583C0FF39", hash_generated_method = "2AA126432DD6DAAF24FDB762ED829DD3")
    public List<HDR> getHeaderList() {
        List<HDR> varB4EAC82CA7396A68D541C85D26508E83_1751067294 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1751067294 = this.hlist;
        varB4EAC82CA7396A68D541C85D26508E83_1751067294.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1751067294;
        // ---------- Original Method ----------
        //return this.hlist;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.989 -0400", hash_original_method = "EDE82742DF271310D47CFC69F814BF44", hash_generated_method = "926819AA0AC9B41E6AF7A991851E737D")
    public ListIterator<HDR> listIterator(int position) {
        ListIterator<HDR> varB4EAC82CA7396A68D541C85D26508E83_986802246 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_986802246 = hlist.listIterator(position);
        addTaint(position);
        varB4EAC82CA7396A68D541C85D26508E83_986802246.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_986802246;
        // ---------- Original Method ----------
        //return hlist.listIterator(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.989 -0400", hash_original_method = "66F538C19C1B45B9F4975D517A08EBE7", hash_generated_method = "6FCD4E295ADB4B5CA9CBFF161564CADB")
    public void removeFirst() {
        {
            boolean varEF2906AB9D37F5F9FE2592D0F985ED0F_737971003 = (hlist.size() != 0);
            hlist.remove(0);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (hlist.size() != 0)
            //hlist.remove(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.002 -0400", hash_original_method = "56685A1560151077841543B2BC810F93", hash_generated_method = "C73AA986093CC0EA78638A1AF70056CD")
    public void removeLast() {
        {
            boolean varEF2906AB9D37F5F9FE2592D0F985ED0F_617104331 = (hlist.size() != 0);
            hlist.remove(hlist.size() - 1);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (hlist.size() != 0)
            //hlist.remove(hlist.size() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.002 -0400", hash_original_method = "6090D81CA85470AC09234766F76789C0", hash_generated_method = "DDF6FBF52805C99FD1EAFC7A8DC7F6A0")
    public boolean remove(HDR obj) {
        {
            boolean varE27C8BEA585DAC7A51DC79C569D41E9A_2101041718 = (hlist.size() == 0);
            boolean varD8FBF7C33228C788AD0720ECF32B962A_1766833374 = (hlist.remove(obj));
        } //End collapsed parenthetic
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1512792404 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1512792404;
        // ---------- Original Method ----------
        //if (hlist.size() == 0)
            //return false;
        //else
            //return hlist.remove(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.003 -0400", hash_original_method = "23B9304014C757503CC0D5B9D6DB550F", hash_generated_method = "B52967299638535006F513B062474563")
    protected void setMyClass(Class<HDR> cl) {
        this.myClass = cl;
        // ---------- Original Method ----------
        //this.myClass = cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.004 -0400", hash_original_method = "CC42CBF49D5975143777F4A2B14A482C", hash_generated_method = "2619743F6BB5DA2184D757765846349B")
    public String debugDump(int indentation) {
        String varB4EAC82CA7396A68D541C85D26508E83_901490000 = null; //Variable for return #1
        stringRepresentation = "";
        String indent;
        indent = new Indentation(indentation).getIndentation();
        String className;
        className = this.getClass().getName();
        sprint(indent + className);
        sprint(indent + "{");
        {
            Iterator<HDR> it;
            it = hlist.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_638049076 = (it.hasNext());
            {
                HDR sipHeader;
                sipHeader = (HDR) it.next();
                sprint(indent + sipHeader.debugDump());
            } //End block
        } //End collapsed parenthetic
        sprint(indent + "}");
        varB4EAC82CA7396A68D541C85D26508E83_901490000 = stringRepresentation;
        addTaint(indentation);
        varB4EAC82CA7396A68D541C85D26508E83_901490000.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_901490000;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.008 -0400", hash_original_method = "ABFB21316126C2849AB41073C957D80E", hash_generated_method = "F7CE673BFF65FC46EC85BEE325205B9E")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_265786836 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_265786836 = debugDump(0);
        varB4EAC82CA7396A68D541C85D26508E83_265786836.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_265786836;
        // ---------- Original Method ----------
        //return debugDump(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.012 -0400", hash_original_method = "7EBA89BCEE46EEC5D25867CF89F8E8B9", hash_generated_method = "2CB84E5CE650649F241D6383BDFF6DFF")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1780802586 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1780802586 = hlist.toArray();
        varB4EAC82CA7396A68D541C85D26508E83_1780802586.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1780802586;
        // ---------- Original Method ----------
        //return hlist.toArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.012 -0400", hash_original_method = "795B857E8950EF3C66EEA5946EF97E00", hash_generated_method = "51EAAA762C77C0EAF480C0663018744C")
    public int indexOf(GenericObject gobj) {
        int varFE7F2AD0158B0E9DB2F579EDDA049625_1392355593 = (hlist.indexOf(gobj));
        addTaint(gobj.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371366235 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371366235;
        // ---------- Original Method ----------
        //return hlist.indexOf(gobj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.017 -0400", hash_original_method = "D4A0602F4424EB672EFBEE9811EC3EF2", hash_generated_method = "179768562AFF79E4A8B63E31DC8FFE58")
    public void add(int index, HDR  sipHeader) throws IndexOutOfBoundsException {
        hlist.add(index, sipHeader);
        addTaint(index);
        addTaint(sipHeader.getTaint());
        // ---------- Original Method ----------
        //hlist.add(index, sipHeader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.017 -0400", hash_original_method = "7AF224A0221DFF0013A72A01287D2D95", hash_generated_method = "279771DBB1AEDCA39630D3BFFFDB00F0")
    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        {
            boolean var140A8815FDEEC27C4D8944D501CA10BC_1065511412 = (other == this);
        } //End collapsed parenthetic
        {
            SIPHeaderList<SIPHeader> that;
            that = (SIPHeaderList<SIPHeader>) other;
            boolean varB0759ED93504D2871EADB7BC17D112AC_1016599707 = (that.hlist == null || that.hlist.size() == 0);
            boolean var5490630F41DAE65E89132ADE4761F7BB_1317228420 = (this.hlist.equals(that.hlist));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_262790330 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_262790330;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.019 -0400", hash_original_method = "6ED02991F9AD79524F79D6703964DFB6", hash_generated_method = "3DB1A7B464BF0E189E558A6652929392")
    public boolean match(SIPHeaderList<?> template) {
        {
            boolean var42D525C71BB0E2BEC53AF10700E42587_943422464 = (!this.getClass().equals(template.getClass()));
        } //End collapsed parenthetic
        SIPHeaderList<SIPHeader> that;
        that = (SIPHeaderList<SIPHeader>) template;
        {
            {
                Iterator<SIPHeader> it;
                it = that.hlist.iterator();
                boolean varB2FF4435B274CC4BE01D264DEA08F957_625197236 = (it.hasNext());
                {
                    SIPHeader sipHeader;
                    sipHeader = (SIPHeader) it.next();
                    boolean found;
                    found = false;
                    {
                        Iterator<HDR> it1;
                        it1 = this.hlist.iterator();
                        boolean varD776FD1A955609D835179BFFD00F64DE_1602046432 = (it1.hasNext()
                        && !found);
                        {
                            SIPHeader sipHeader1;
                            sipHeader1 = (SIPHeader) it1.next();
                            found = sipHeader1.match(sipHeader);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(template.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2067411722 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2067411722;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.021 -0400", hash_original_method = "359991759D26E2A3F33ACAEA17758D18", hash_generated_method = "892BB56794399B367DF2A8419F25A2DA")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1597869223 = null; //Variable for return #1
        try 
        {
            Class<?> clazz;
            clazz = this.getClass();
            Constructor<?> cons;
            cons = clazz.getConstructor((Class[])null);
            SIPHeaderList<HDR> retval;
            retval = (SIPHeaderList<HDR>) cons.newInstance((Object[])null);
            retval.headerName = this.headerName;
            retval.myClass  = this.myClass;
            varB4EAC82CA7396A68D541C85D26508E83_1597869223 = retval.clonehlist(this.hlist);
        } //End block
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Could not clone!", ex);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1597869223.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1597869223;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.029 -0400", hash_original_method = "CA032BB58CFE2AE5C2CC307C2E78224F", hash_generated_method = "F53D2F9876DCECAC70D869C0BDB6CF26")
    protected final SIPHeaderList<HDR> clonehlist(List<HDR> hlistToClone) {
        SIPHeaderList<HDR> varB4EAC82CA7396A68D541C85D26508E83_2027753530 = null; //Variable for return #1
        {
            {
                Iterator<HDR> it;
                it = (Iterator<HDR>) hlistToClone.iterator();
                boolean varB2FF4435B274CC4BE01D264DEA08F957_476961494 = (it.hasNext());
                {
                    Header h;
                    h = it.next();
                    this.hlist.add((HDR)h.clone());
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2027753530 = this;
        addTaint(hlistToClone.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2027753530.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2027753530;
        // ---------- Original Method ----------
        //if (hlistToClone != null) {
            //for (Iterator<HDR> it = (Iterator<HDR>) hlistToClone.iterator(); it.hasNext();) {
                //Header h = it.next();
                //this.hlist.add((HDR)h.clone());
            //}
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.029 -0400", hash_original_method = "FCBD3ECE23AA666BDE06756DAACE9219", hash_generated_method = "446D5A65BEB7962AF37D8942EA6EA278")
    public int size() {
        int varAD7F07CB7D5D3937AFE4543892270C80_786149930 = (hlist.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_174503255 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_174503255;
        // ---------- Original Method ----------
        //return hlist.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.030 -0400", hash_original_method = "32932F147EA25CC7B7BC47F740C6BF91", hash_generated_method = "007DBB0541C4A99BB290DF1B106B4682")
    public boolean isHeaderList() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1101925268 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1101925268;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.030 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "48BF77B949229715A9EA33C6177E300D")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_994307877 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_994307877 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_994307877.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_994307877;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.034 -0400", hash_original_method = "8EFAAECA9CE0AC45762D4D910A6D9585", hash_generated_method = "9FD1FC221DC006EECFBCBF331285DB37")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1452722753 = null; //Variable for return #1
        ListIterator<HDR> iterator;
        iterator = this.listIterator();
        {
            SIPHeader sipHeader;
            sipHeader = (SIPHeader) iterator.next();
            {
                boolean var81FA26130A77648ABA9F7EE49157FB67_2072423428 = (sipHeader == this);
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Unexpected circularity in SipHeaderList");
            } //End collapsed parenthetic
            sipHeader.encodeBody(buffer);
            {
                boolean var863C7B066016334243F11BA2A858D956_98081351 = (iterator.hasNext());
                {
                    {
                        boolean varEC2BFBCD9D89F853D1F8004544E80422_953887367 = (!this.headerName.equals(PrivacyHeader.NAME));
                        buffer.append(Separators.COMMA);
                        buffer.append(Separators.SEMICOLON);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1452722753 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1452722753.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1452722753;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.034 -0400", hash_original_method = "D5DDE9BDBABBA5EC4E7B0879A10A7D8D", hash_generated_method = "A90CA2634439482A895100ED9B17EF0F")
    public boolean addAll(Collection<? extends HDR> collection) {
        boolean var9940151E0E552CDF60A32A4F5430F34D_1266888584 = (this.hlist.addAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1573390514 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1573390514;
        // ---------- Original Method ----------
        //return this.hlist.addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.041 -0400", hash_original_method = "5E3DA6DCBC302D72E9103E3CB1D3527B", hash_generated_method = "D8110BF5DFB6F521B9B8CDAEBF02A9A4")
    public boolean addAll(int index, Collection<? extends HDR> collection) {
        boolean varEFE51ECFC9507D8AC4C14D317E8D6CB0_1348920571 = (this.hlist.addAll(index, collection));
        addTaint(index);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1016156909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1016156909;
        // ---------- Original Method ----------
        //return this.hlist.addAll(index, collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.042 -0400", hash_original_method = "F1DA48A9A827D74FF9F3AEB298E80E0A", hash_generated_method = "5DE0CFBE244FC76FDD157FA89DD82023")
    public boolean containsAll(Collection<?> collection) {
        boolean varD2618BE52D31E66DA0B87AF95177D40B_1033629828 = (this.hlist.containsAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2040867242 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2040867242;
        // ---------- Original Method ----------
        //return this.hlist.containsAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.042 -0400", hash_original_method = "D791B8D331C82850017A4DF87B2D73FE", hash_generated_method = "7B3736200B6CC37F2F0C36EB7F8C7C36")
    public void clear() {
        this.hlist.clear();
        // ---------- Original Method ----------
        //this.hlist.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.042 -0400", hash_original_method = "B039DF80CC42319FF93C93DFC4F09CCF", hash_generated_method = "663E290E72290F8BD6EF8FAF4947C13C")
    public boolean contains(Object header) {
        boolean varFF9B9114D30EEBE8FF7C2118E12A9B47_338352889 = (this.hlist.contains(header));
        addTaint(header.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1224017911 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1224017911;
        // ---------- Original Method ----------
        //return this.hlist.contains(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.043 -0400", hash_original_method = "B0FF15B145547E100ED44D45A7137CDE", hash_generated_method = "4F5450D1405488C74B77E4F50928C884")
    public HDR get(int index) {
        HDR varB4EAC82CA7396A68D541C85D26508E83_1710200473 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1710200473 = this.hlist.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1710200473.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1710200473;
        // ---------- Original Method ----------
        //return  this.hlist.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.043 -0400", hash_original_method = "9C1A1055EA03DFB32FF882EA4FC9149D", hash_generated_method = "D36BAB09EB1EC573E30BD89496931AA8")
    public int indexOf(Object obj) {
        int varBEC02A7A8B6C276C18FAB86ECDD19E4E_1963640024 = (this.hlist.indexOf(obj));
        addTaint(obj.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_864760835 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_864760835;
        // ---------- Original Method ----------
        //return this.hlist.indexOf(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.043 -0400", hash_original_method = "84FF645EE0B76DB0D5B552F9A7A0DC94", hash_generated_method = "D280066CD8639EA1E0BB105A6899DE46")
    public java.util.Iterator<HDR> iterator() {
        java.util.Iterator<HDR> varB4EAC82CA7396A68D541C85D26508E83_989634480 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_989634480 = this.hlist.listIterator();
        varB4EAC82CA7396A68D541C85D26508E83_989634480.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_989634480;
        // ---------- Original Method ----------
        //return this.hlist.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.043 -0400", hash_original_method = "05A7D65C6D911E0B1F3261A66888CB52", hash_generated_method = "F7C59309597058BA29298D83FCF4B8BF")
    public int lastIndexOf(Object obj) {
        int varD48BB8B2C188D796AB5E25DB24A359A2_374851155 = (this.hlist.lastIndexOf(obj));
        addTaint(obj.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625135928 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625135928;
        // ---------- Original Method ----------
        //return this.hlist.lastIndexOf(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.044 -0400", hash_original_method = "FB49499CFAFE2E72F27390E6807CB034", hash_generated_method = "AD7C308BE7D56371DA252F1B1D36B308")
    public boolean remove(Object obj) {
        boolean varA126E10370F872777A607D5086A88085_909258008 = (this.hlist.remove(obj));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_426506824 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_426506824;
        // ---------- Original Method ----------
        //return this.hlist.remove(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.049 -0400", hash_original_method = "2B7049D180B166140C32B8D54A96E238", hash_generated_method = "17EA8FDCB0E4794A8786C9D3B114057D")
    public HDR remove(int index) {
        HDR varB4EAC82CA7396A68D541C85D26508E83_606918393 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_606918393 = this.hlist.remove(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_606918393.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_606918393;
        // ---------- Original Method ----------
        //return this.hlist.remove(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.050 -0400", hash_original_method = "5A03B3005777615BF04A1D43320D1AA1", hash_generated_method = "D42E3D4890FE76F97579EED4882AE615")
    public boolean removeAll(java.util.Collection<?> collection) {
        boolean var1B94C4550E9AC61EE706C14BF778F96F_1352792093 = (this.hlist.removeAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_813937727 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_813937727;
        // ---------- Original Method ----------
        //return this.hlist.removeAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.050 -0400", hash_original_method = "4FD342E6A050272CE06CEE9969944C1B", hash_generated_method = "1FBFF937CF83B8124CDDD5C4235668EF")
    public boolean retainAll(java.util.Collection<?> collection) {
        boolean varD3CD1D943CC0A6AFD9C7DA463C27ADE5_193054623 = (this.hlist.retainAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_373558867 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_373558867;
        // ---------- Original Method ----------
        //return this.hlist.retainAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.051 -0400", hash_original_method = "894CB5A5FAD7AFC5CD5A3389B3F77AB4", hash_generated_method = "03A06855F0A6BCA3FE039EE8230AE510")
    public java.util.List<HDR> subList(int index1, int index2) {
        java.util.List<HDR> varB4EAC82CA7396A68D541C85D26508E83_2119344712 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2119344712 = this.hlist.subList(index1, index2);
        addTaint(index1);
        addTaint(index2);
        varB4EAC82CA7396A68D541C85D26508E83_2119344712.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2119344712;
        // ---------- Original Method ----------
        //return this.hlist.subList(index1, index2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.056 -0400", hash_original_method = "78242797F449E5EBFB278CC5A6BC56D0", hash_generated_method = "8F712E20DBB94DEA0B57D146C7855D04")
    public int hashCode() {
        int var4B8D37533CC12365BECFAB730FC9EDC2_257431955 = (this.headerName.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1285159093 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1285159093;
        // ---------- Original Method ----------
        //return this.headerName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.070 -0400", hash_original_method = "A9FD382DBA3FE66AACB46D6203100A0D", hash_generated_method = "87DA5938EF40636AC879CD1B018CA524")
    public HDR set(int position, HDR sipHeader) {
        HDR varB4EAC82CA7396A68D541C85D26508E83_541749959 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_541749959 = hlist.set(position, sipHeader);
        addTaint(position);
        addTaint(sipHeader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_541749959.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_541749959;
        // ---------- Original Method ----------
        //return hlist.set(position, sipHeader);
    }

    
        public static void setPrettyEncode(boolean flag) {
        prettyEncode = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.071 -0400", hash_original_method = "B04CD19C0316B320C5B66A678FB2994B", hash_generated_method = "6BB069E00965133596DDCC457B53EF7E")
    public <T> T[] toArray(T[] array) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_61433752 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_61433752 = this.hlist.toArray(array);
        addTaint(array[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_61433752.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_61433752;
        // ---------- Original Method ----------
        //return this.hlist.toArray(array);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.071 -0400", hash_original_field = "BB31D88D930D91866C4879183DCACA7E", hash_generated_field = "F24392C13A6D95700264E5A997197264")

    private static boolean prettyEncode = false;
}

