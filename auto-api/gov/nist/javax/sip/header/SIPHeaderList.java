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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.964 -0400", hash_original_field = "54FC99FFF06FAFF26E47359497AA764D", hash_generated_field = "1610EB574C9A048E3BE2EA98FBE15AF1")

    protected List<HDR> hlist;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.965 -0400", hash_original_field = "D0509468108F68C610DFF430648FE029", hash_generated_field = "7DDB65A0A435AAFCBC63AD9D687C490F")

    private Class<HDR> myClass;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.965 -0400", hash_original_method = "D7E30AE5F54C678856B1E2B4E08FADF6", hash_generated_method = "DD0314912C40308B77D7E83CB7E4756A")
    private  SIPHeaderList() {
        hlist = new LinkedList<HDR>();
        // ---------- Original Method ----------
        //hlist = new LinkedList<HDR>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.965 -0400", hash_original_method = "C956079DDC347F2EE85C1D1E44860715", hash_generated_method = "71A8CB9F8A10DE5179F85ADE3330F4CD")
    protected  SIPHeaderList(Class<HDR> objclass, String hname) {
        this();
        this.headerName = hname;
        this.myClass =  objclass;
        addTaint(hname.getTaint());
        // ---------- Original Method ----------
        //this.headerName = hname;
        //this.myClass =  objclass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.973 -0400", hash_original_method = "5A8D65821D08B5534EF9F59F256EB0ED", hash_generated_method = "11CFBF351521F3FE1638659920FE7F48")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_212506614 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_212506614 = this.headerName;
        varB4EAC82CA7396A68D541C85D26508E83_212506614.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_212506614;
        // ---------- Original Method ----------
        //return this.headerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.974 -0400", hash_original_method = "45FF804DBFA2BB4F4071CDF27CE28633", hash_generated_method = "0BBE89EE914B003ED2096D7BDBF99F6F")
    public boolean add(HDR objectToAdd) {
        hlist.add((HDR)objectToAdd);
        addTaint(objectToAdd.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1658546391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1658546391;
        // ---------- Original Method ----------
        //hlist.add((HDR)objectToAdd);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.974 -0400", hash_original_method = "87B618AF10705C22EFB36E4A71158D56", hash_generated_method = "DE9B6D6649ABF9C8DB0585491FFC6042")
    public void addFirst(HDR obj) {
        hlist.add(0,(HDR) obj);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //hlist.add(0,(HDR) obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.979 -0400", hash_original_method = "3D14CCA72C816FE4801BBC05991E4343", hash_generated_method = "DEFF22172743287D432AD5098BC3CE0A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.981 -0400", hash_original_method = "2C5EDAC0235777863EFD087B4072277C", hash_generated_method = "404BFC6CB25B05B66A65C3518964A329")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.990 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "EEA99BECF4988B4728657BB3727780F7")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_2072496904 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2072496904 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_2072496904.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2072496904;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.992 -0400", hash_original_method = "4452028BB43CC449CBD4FD5523C455CD", hash_generated_method = "1D15E8D60E1CF79BC90EE80770E3116B")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_765340878 = null; //Variable for return #1
        {
            boolean varADCB242902E2A36C5E7E88B9C037FBC8_908770653 = (hlist.isEmpty());
            {
                buffer.append(headerName).append(':').append(Separators.NEWLINE);
            } //End block
            {
                {
                    boolean varAA9EB60710CB021FA924A856488476AF_200921512 = (this.headerName.equals(SIPHeaderNames.WWW_AUTHENTICATE)
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
                            boolean varD36012C5F0076A971BB5DCB92CB4D117_946208140 = (li.hasNext());
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
        varB4EAC82CA7396A68D541C85D26508E83_765340878 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_765340878.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_765340878;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.996 -0400", hash_original_method = "3A5F29F99CF35D16AD0C376ECAFA4E44", hash_generated_method = "F874D4979DB21EC0511D312194D1C3E9")
    public List<String> getHeadersAsEncodedStrings() {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1615666171 = null; //Variable for return #1
        List<String> retval;
        retval = new LinkedList<String>();
        ListIterator<HDR> li;
        li = hlist.listIterator();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_1856380333 = (li.hasNext());
            {
                Header sipheader;
                sipheader = li.next();
                retval.add(sipheader.toString());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1615666171 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1615666171.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1615666171;
        // ---------- Original Method ----------
        //List<String> retval = new LinkedList<String>();
        //ListIterator<HDR> li = hlist.listIterator();
        //while (li.hasNext()) {
            //Header sipheader = li.next();
            //retval.add(sipheader.toString());
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.008 -0400", hash_original_method = "6C7059400A289BDBD2DC174FD9546E0E", hash_generated_method = "1CF703A8E804D68EA6295E93D25E8CFB")
    public Header getFirst() {
        Header varB4EAC82CA7396A68D541C85D26508E83_78043915 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_1952635290 = null; //Variable for return #2
        {
            boolean varBC3C1D335DC6F5058F706F5D73C7DB2D_357345539 = (hlist == null || hlist.isEmpty());
            varB4EAC82CA7396A68D541C85D26508E83_78043915 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1952635290 = hlist.get(0);
        } //End collapsed parenthetic
        Header varA7E53CE21691AB073D9660D615818899_1713132653; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1713132653 = varB4EAC82CA7396A68D541C85D26508E83_78043915;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1713132653 = varB4EAC82CA7396A68D541C85D26508E83_1952635290;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1713132653.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1713132653;
        // ---------- Original Method ----------
        //if (hlist == null || hlist.isEmpty())
            //return null;
        //else
            //return  hlist.get(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.008 -0400", hash_original_method = "564DA566938B5DEC3F30C613889BA2FD", hash_generated_method = "E923301FEBA75327820514228D2C1E64")
    public Header getLast() {
        Header varB4EAC82CA7396A68D541C85D26508E83_1966837193 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_521057393 = null; //Variable for return #2
        {
            boolean varBC3C1D335DC6F5058F706F5D73C7DB2D_863459168 = (hlist == null || hlist.isEmpty());
            varB4EAC82CA7396A68D541C85D26508E83_1966837193 = null;
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_521057393 = hlist.get(hlist.size() - 1);
        Header varA7E53CE21691AB073D9660D615818899_711694953; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_711694953 = varB4EAC82CA7396A68D541C85D26508E83_1966837193;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_711694953 = varB4EAC82CA7396A68D541C85D26508E83_521057393;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_711694953.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_711694953;
        // ---------- Original Method ----------
        //if (hlist == null || hlist.isEmpty())
            //return null;
        //return  hlist.get(hlist.size() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.009 -0400", hash_original_method = "52DB400388897C60F1E5D7C5CF768C2C", hash_generated_method = "647EC0A2B5C5D22DD04D83B8D6952D1E")
    public Class<HDR> getMyClass() {
        Class<HDR> varB4EAC82CA7396A68D541C85D26508E83_1514283611 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1514283611 = this.myClass;
        varB4EAC82CA7396A68D541C85D26508E83_1514283611.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1514283611;
        // ---------- Original Method ----------
        //return  this.myClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.009 -0400", hash_original_method = "FF43F4EB263E123805961D1A87217B48", hash_generated_method = "EE06826E2497B0DA98C751DBAE946C64")
    public boolean isEmpty() {
        boolean varE0F068754A4434D383386203B916E809_619177817 = (hlist.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1714328129 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1714328129;
        // ---------- Original Method ----------
        //return hlist.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.009 -0400", hash_original_method = "36E257E69C92FC5D45CD0DCB007DB07A", hash_generated_method = "E5BDE3704ADE21E112A0A013D7F03E93")
    public ListIterator<HDR> listIterator() {
        ListIterator<HDR> varB4EAC82CA7396A68D541C85D26508E83_1683156804 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1683156804 = hlist.listIterator(0);
        varB4EAC82CA7396A68D541C85D26508E83_1683156804.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1683156804;
        // ---------- Original Method ----------
        //return hlist.listIterator(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.023 -0400", hash_original_method = "9E6C15618943805727A8B08583C0FF39", hash_generated_method = "F32A07C08178951FDFBF06EE59D3DA27")
    public List<HDR> getHeaderList() {
        List<HDR> varB4EAC82CA7396A68D541C85D26508E83_1448799101 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1448799101 = this.hlist;
        varB4EAC82CA7396A68D541C85D26508E83_1448799101.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1448799101;
        // ---------- Original Method ----------
        //return this.hlist;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.024 -0400", hash_original_method = "EDE82742DF271310D47CFC69F814BF44", hash_generated_method = "992DF1590517F700F64516AB9233FE11")
    public ListIterator<HDR> listIterator(int position) {
        ListIterator<HDR> varB4EAC82CA7396A68D541C85D26508E83_1003692602 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1003692602 = hlist.listIterator(position);
        addTaint(position);
        varB4EAC82CA7396A68D541C85D26508E83_1003692602.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1003692602;
        // ---------- Original Method ----------
        //return hlist.listIterator(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.051 -0400", hash_original_method = "66F538C19C1B45B9F4975D517A08EBE7", hash_generated_method = "BC0F118DE1BFC189F3B011B879E14712")
    public void removeFirst() {
        {
            boolean varEF2906AB9D37F5F9FE2592D0F985ED0F_2030353558 = (hlist.size() != 0);
            hlist.remove(0);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (hlist.size() != 0)
            //hlist.remove(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.051 -0400", hash_original_method = "56685A1560151077841543B2BC810F93", hash_generated_method = "B4E74E8821F38EE323CD4AA77549D2DB")
    public void removeLast() {
        {
            boolean varEF2906AB9D37F5F9FE2592D0F985ED0F_283910390 = (hlist.size() != 0);
            hlist.remove(hlist.size() - 1);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (hlist.size() != 0)
            //hlist.remove(hlist.size() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.053 -0400", hash_original_method = "6090D81CA85470AC09234766F76789C0", hash_generated_method = "A840D27F6A2744F52423BF8E54CED880")
    public boolean remove(HDR obj) {
        {
            boolean varE27C8BEA585DAC7A51DC79C569D41E9A_535696954 = (hlist.size() == 0);
            boolean varD8FBF7C33228C788AD0720ECF32B962A_565373560 = (hlist.remove(obj));
        } //End collapsed parenthetic
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_705320922 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_705320922;
        // ---------- Original Method ----------
        //if (hlist.size() == 0)
            //return false;
        //else
            //return hlist.remove(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.054 -0400", hash_original_method = "23B9304014C757503CC0D5B9D6DB550F", hash_generated_method = "B52967299638535006F513B062474563")
    protected void setMyClass(Class<HDR> cl) {
        this.myClass = cl;
        // ---------- Original Method ----------
        //this.myClass = cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.056 -0400", hash_original_method = "CC42CBF49D5975143777F4A2B14A482C", hash_generated_method = "CBDFAAACEDAB20ACE7EFAFB7B8E06E38")
    public String debugDump(int indentation) {
        String varB4EAC82CA7396A68D541C85D26508E83_333497487 = null; //Variable for return #1
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
            boolean var03729FD53960D8DCA3A41A13A0229637_1755456135 = (it.hasNext());
            {
                HDR sipHeader;
                sipHeader = (HDR) it.next();
                sprint(indent + sipHeader.debugDump());
            } //End block
        } //End collapsed parenthetic
        sprint(indent + "}");
        varB4EAC82CA7396A68D541C85D26508E83_333497487 = stringRepresentation;
        addTaint(indentation);
        varB4EAC82CA7396A68D541C85D26508E83_333497487.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_333497487;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.056 -0400", hash_original_method = "ABFB21316126C2849AB41073C957D80E", hash_generated_method = "DDC0C8BE620A083B922ED953ED9A0F03")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_901216727 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_901216727 = debugDump(0);
        varB4EAC82CA7396A68D541C85D26508E83_901216727.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_901216727;
        // ---------- Original Method ----------
        //return debugDump(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.057 -0400", hash_original_method = "7EBA89BCEE46EEC5D25867CF89F8E8B9", hash_generated_method = "E8DA623E4F94E0351ED6C9C5C8400418")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_275287797 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_275287797 = hlist.toArray();
        varB4EAC82CA7396A68D541C85D26508E83_275287797.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_275287797;
        // ---------- Original Method ----------
        //return hlist.toArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.057 -0400", hash_original_method = "795B857E8950EF3C66EEA5946EF97E00", hash_generated_method = "529A7EA2AA5AC9BAB9E701E4E915FA5B")
    public int indexOf(GenericObject gobj) {
        int varFE7F2AD0158B0E9DB2F579EDDA049625_574585639 = (hlist.indexOf(gobj));
        addTaint(gobj.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1983025211 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1983025211;
        // ---------- Original Method ----------
        //return hlist.indexOf(gobj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.057 -0400", hash_original_method = "D4A0602F4424EB672EFBEE9811EC3EF2", hash_generated_method = "179768562AFF79E4A8B63E31DC8FFE58")
    public void add(int index, HDR  sipHeader) throws IndexOutOfBoundsException {
        hlist.add(index, sipHeader);
        addTaint(index);
        addTaint(sipHeader.getTaint());
        // ---------- Original Method ----------
        //hlist.add(index, sipHeader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.059 -0400", hash_original_method = "7AF224A0221DFF0013A72A01287D2D95", hash_generated_method = "F1DB991C1F6A9ADF250627234EB09461")
    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        {
            boolean var140A8815FDEEC27C4D8944D501CA10BC_1152330679 = (other == this);
        } //End collapsed parenthetic
        {
            SIPHeaderList<SIPHeader> that;
            that = (SIPHeaderList<SIPHeader>) other;
            boolean varB0759ED93504D2871EADB7BC17D112AC_209327292 = (that.hlist == null || that.hlist.size() == 0);
            boolean var5490630F41DAE65E89132ADE4761F7BB_49559023 = (this.hlist.equals(that.hlist));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_142443772 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_142443772;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.059 -0400", hash_original_method = "6ED02991F9AD79524F79D6703964DFB6", hash_generated_method = "63CDBE5BAFA6EBEB74D544BA2046C208")
    public boolean match(SIPHeaderList<?> template) {
        {
            boolean var42D525C71BB0E2BEC53AF10700E42587_774744789 = (!this.getClass().equals(template.getClass()));
        } //End collapsed parenthetic
        SIPHeaderList<SIPHeader> that;
        that = (SIPHeaderList<SIPHeader>) template;
        {
            {
                Iterator<SIPHeader> it;
                it = that.hlist.iterator();
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1532888883 = (it.hasNext());
                {
                    SIPHeader sipHeader;
                    sipHeader = (SIPHeader) it.next();
                    boolean found;
                    found = false;
                    {
                        Iterator<HDR> it1;
                        it1 = this.hlist.iterator();
                        boolean varD776FD1A955609D835179BFFD00F64DE_592968737 = (it1.hasNext()
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2108330707 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2108330707;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.060 -0400", hash_original_method = "359991759D26E2A3F33ACAEA17758D18", hash_generated_method = "474C371CDF9CB8231AA1B1B38465B4A8")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1683013609 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1683013609 = retval.clonehlist(this.hlist);
        } //End block
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Could not clone!", ex);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1683013609.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1683013609;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.080 -0400", hash_original_method = "CA032BB58CFE2AE5C2CC307C2E78224F", hash_generated_method = "9AD4AC2DAF25BE069865CE503F3038ED")
    protected final SIPHeaderList<HDR> clonehlist(List<HDR> hlistToClone) {
        SIPHeaderList<HDR> varB4EAC82CA7396A68D541C85D26508E83_109268795 = null; //Variable for return #1
        {
            {
                Iterator<HDR> it;
                it = (Iterator<HDR>) hlistToClone.iterator();
                boolean varB2FF4435B274CC4BE01D264DEA08F957_276863896 = (it.hasNext());
                {
                    Header h;
                    h = it.next();
                    this.hlist.add((HDR)h.clone());
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_109268795 = this;
        addTaint(hlistToClone.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_109268795.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_109268795;
        // ---------- Original Method ----------
        //if (hlistToClone != null) {
            //for (Iterator<HDR> it = (Iterator<HDR>) hlistToClone.iterator(); it.hasNext();) {
                //Header h = it.next();
                //this.hlist.add((HDR)h.clone());
            //}
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.080 -0400", hash_original_method = "FCBD3ECE23AA666BDE06756DAACE9219", hash_generated_method = "D1FF7299731269D7E53E001BD22C0A78")
    public int size() {
        int varAD7F07CB7D5D3937AFE4543892270C80_1024526309 = (hlist.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732304949 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732304949;
        // ---------- Original Method ----------
        //return hlist.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.081 -0400", hash_original_method = "32932F147EA25CC7B7BC47F740C6BF91", hash_generated_method = "181A6B7C24556F07DEB1CBAB45DCDE0C")
    public boolean isHeaderList() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1363359376 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1363359376;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.081 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "195B68F716765E2EA4D51B4C514F70A1")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1699468003 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1699468003 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1699468003.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1699468003;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.105 -0400", hash_original_method = "8EFAAECA9CE0AC45762D4D910A6D9585", hash_generated_method = "02C36DB3CC2DC9BBCFC41DB4AF242419")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_407836187 = null; //Variable for return #1
        ListIterator<HDR> iterator;
        iterator = this.listIterator();
        {
            SIPHeader sipHeader;
            sipHeader = (SIPHeader) iterator.next();
            {
                boolean var81FA26130A77648ABA9F7EE49157FB67_1097707555 = (sipHeader == this);
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Unexpected circularity in SipHeaderList");
            } //End collapsed parenthetic
            sipHeader.encodeBody(buffer);
            {
                boolean var863C7B066016334243F11BA2A858D956_1331663872 = (iterator.hasNext());
                {
                    {
                        boolean varEC2BFBCD9D89F853D1F8004544E80422_2028124663 = (!this.headerName.equals(PrivacyHeader.NAME));
                        buffer.append(Separators.COMMA);
                        buffer.append(Separators.SEMICOLON);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_407836187 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_407836187.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_407836187;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.105 -0400", hash_original_method = "D5DDE9BDBABBA5EC4E7B0879A10A7D8D", hash_generated_method = "250B9F257523CE60CB04E362CA872404")
    public boolean addAll(Collection<? extends HDR> collection) {
        boolean var9940151E0E552CDF60A32A4F5430F34D_837049131 = (this.hlist.addAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_302229452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_302229452;
        // ---------- Original Method ----------
        //return this.hlist.addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.106 -0400", hash_original_method = "5E3DA6DCBC302D72E9103E3CB1D3527B", hash_generated_method = "DB5ABF0DAE42BB8B99D493CEA00E1CF6")
    public boolean addAll(int index, Collection<? extends HDR> collection) {
        boolean varEFE51ECFC9507D8AC4C14D317E8D6CB0_1234248897 = (this.hlist.addAll(index, collection));
        addTaint(index);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1039186533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1039186533;
        // ---------- Original Method ----------
        //return this.hlist.addAll(index, collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.106 -0400", hash_original_method = "F1DA48A9A827D74FF9F3AEB298E80E0A", hash_generated_method = "BF129FC976D02AA872EDC2D9DE2AE41F")
    public boolean containsAll(Collection<?> collection) {
        boolean varD2618BE52D31E66DA0B87AF95177D40B_547103296 = (this.hlist.containsAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2100646976 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2100646976;
        // ---------- Original Method ----------
        //return this.hlist.containsAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.106 -0400", hash_original_method = "D791B8D331C82850017A4DF87B2D73FE", hash_generated_method = "7B3736200B6CC37F2F0C36EB7F8C7C36")
    public void clear() {
        this.hlist.clear();
        // ---------- Original Method ----------
        //this.hlist.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.107 -0400", hash_original_method = "B039DF80CC42319FF93C93DFC4F09CCF", hash_generated_method = "1D61E575719DB72EC464EE8F1A01AB38")
    public boolean contains(Object header) {
        boolean varFF9B9114D30EEBE8FF7C2118E12A9B47_963087766 = (this.hlist.contains(header));
        addTaint(header.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1257963279 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1257963279;
        // ---------- Original Method ----------
        //return this.hlist.contains(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.108 -0400", hash_original_method = "B0FF15B145547E100ED44D45A7137CDE", hash_generated_method = "0709E5D1D3F195DBA9721A71A76ECE0F")
    public HDR get(int index) {
        HDR varB4EAC82CA7396A68D541C85D26508E83_1064277205 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1064277205 = this.hlist.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1064277205.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1064277205;
        // ---------- Original Method ----------
        //return  this.hlist.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.108 -0400", hash_original_method = "9C1A1055EA03DFB32FF882EA4FC9149D", hash_generated_method = "D2CC9F7543998EFB058D008CC2052E1F")
    public int indexOf(Object obj) {
        int varBEC02A7A8B6C276C18FAB86ECDD19E4E_1348101334 = (this.hlist.indexOf(obj));
        addTaint(obj.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540018862 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540018862;
        // ---------- Original Method ----------
        //return this.hlist.indexOf(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.109 -0400", hash_original_method = "84FF645EE0B76DB0D5B552F9A7A0DC94", hash_generated_method = "E1FEB93753C4433A03E517ADBFDF8A1D")
    public java.util.Iterator<HDR> iterator() {
        java.util.Iterator<HDR> varB4EAC82CA7396A68D541C85D26508E83_66458335 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_66458335 = this.hlist.listIterator();
        varB4EAC82CA7396A68D541C85D26508E83_66458335.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_66458335;
        // ---------- Original Method ----------
        //return this.hlist.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.109 -0400", hash_original_method = "05A7D65C6D911E0B1F3261A66888CB52", hash_generated_method = "B0049CB6D970AA6854B83BDEE2B4CF05")
    public int lastIndexOf(Object obj) {
        int varD48BB8B2C188D796AB5E25DB24A359A2_1711755546 = (this.hlist.lastIndexOf(obj));
        addTaint(obj.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_637206254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_637206254;
        // ---------- Original Method ----------
        //return this.hlist.lastIndexOf(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.109 -0400", hash_original_method = "FB49499CFAFE2E72F27390E6807CB034", hash_generated_method = "0131B1DDDF95FE8C7FB73853FFA1ECDE")
    public boolean remove(Object obj) {
        boolean varA126E10370F872777A607D5086A88085_1307159879 = (this.hlist.remove(obj));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1507245153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1507245153;
        // ---------- Original Method ----------
        //return this.hlist.remove(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.110 -0400", hash_original_method = "2B7049D180B166140C32B8D54A96E238", hash_generated_method = "38C6FEBFEF2AF442623C25A12E5AB457")
    public HDR remove(int index) {
        HDR varB4EAC82CA7396A68D541C85D26508E83_630825672 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_630825672 = this.hlist.remove(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_630825672.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_630825672;
        // ---------- Original Method ----------
        //return this.hlist.remove(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.110 -0400", hash_original_method = "5A03B3005777615BF04A1D43320D1AA1", hash_generated_method = "E3A5F8294AE14DACC44F494891276DC2")
    public boolean removeAll(java.util.Collection<?> collection) {
        boolean var1B94C4550E9AC61EE706C14BF778F96F_1435203784 = (this.hlist.removeAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_450372089 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_450372089;
        // ---------- Original Method ----------
        //return this.hlist.removeAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.111 -0400", hash_original_method = "4FD342E6A050272CE06CEE9969944C1B", hash_generated_method = "C1F2E0E8A9A9AD425D4D7B408658DE22")
    public boolean retainAll(java.util.Collection<?> collection) {
        boolean varD3CD1D943CC0A6AFD9C7DA463C27ADE5_1097613194 = (this.hlist.retainAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_444893652 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_444893652;
        // ---------- Original Method ----------
        //return this.hlist.retainAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.111 -0400", hash_original_method = "894CB5A5FAD7AFC5CD5A3389B3F77AB4", hash_generated_method = "98D5F83457A2088BA8DA5DE79C0513A2")
    public java.util.List<HDR> subList(int index1, int index2) {
        java.util.List<HDR> varB4EAC82CA7396A68D541C85D26508E83_49780250 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_49780250 = this.hlist.subList(index1, index2);
        addTaint(index1);
        addTaint(index2);
        varB4EAC82CA7396A68D541C85D26508E83_49780250.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_49780250;
        // ---------- Original Method ----------
        //return this.hlist.subList(index1, index2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.113 -0400", hash_original_method = "78242797F449E5EBFB278CC5A6BC56D0", hash_generated_method = "772CC83B9075792E4035B7C6C756A684")
    public int hashCode() {
        int var4B8D37533CC12365BECFAB730FC9EDC2_420032580 = (this.headerName.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1271921393 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1271921393;
        // ---------- Original Method ----------
        //return this.headerName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.133 -0400", hash_original_method = "A9FD382DBA3FE66AACB46D6203100A0D", hash_generated_method = "A46733512DB51C8CC7DA2442B037DCED")
    public HDR set(int position, HDR sipHeader) {
        HDR varB4EAC82CA7396A68D541C85D26508E83_1732882876 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1732882876 = hlist.set(position, sipHeader);
        addTaint(position);
        addTaint(sipHeader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1732882876.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1732882876;
        // ---------- Original Method ----------
        //return hlist.set(position, sipHeader);
    }

    
        public static void setPrettyEncode(boolean flag) {
        prettyEncode = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.134 -0400", hash_original_method = "B04CD19C0316B320C5B66A678FB2994B", hash_generated_method = "1D50F02FD8673C83397A47F7B513038D")
    public <T> T[] toArray(T[] array) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_357977011 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_357977011 = this.hlist.toArray(array);
        addTaint(array[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_357977011.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_357977011;
        // ---------- Original Method ----------
        //return this.hlist.toArray(array);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.134 -0400", hash_original_field = "BB31D88D930D91866C4879183DCACA7E", hash_generated_field = "F24392C13A6D95700264E5A997197264")

    private static boolean prettyEncode = false;
}

