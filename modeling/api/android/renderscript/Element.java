package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import java.lang.reflect.Field;
public class Element extends BaseObj {

    /**
     * Utility function for returning an Element containing a single Boolean.
     *
     * @param rs Context to which the element will belong.
     *
     * @return Element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.286 -0500", hash_original_method = "0B50D7519F00D454A2A6502FA20A4415", hash_generated_method = "4200AE66B63982882ADDF97168C7B996")
    
public static Element BOOLEAN(RenderScript rs) {
        if(rs.mElement_BOOLEAN == null) {
            rs.mElement_BOOLEAN = createUser(rs, DataType.BOOLEAN);
        }
        return rs.mElement_BOOLEAN;
    }

    /**
     * Utility function for returning an Element containing a single UNSIGNED_8.
     *
     * @param rs Context to which the element will belong.
     *
     * @return Element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.289 -0500", hash_original_method = "C166F3E0EFB403FB56F87B006221B9E6", hash_generated_method = "334D55D4A583D5A671874A1A55AC2492")
    
public static Element U8(RenderScript rs) {
        if(rs.mElement_U8 == null) {
            rs.mElement_U8 = createUser(rs, DataType.UNSIGNED_8);
        }
        return rs.mElement_U8;
    }

    /**
     * Utility function for returning an Element containing a single SIGNED_8.
     *
     * @param rs Context to which the element will belong.
     *
     * @return Element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.291 -0500", hash_original_method = "9CC8ED822661580CCE03E5BEBA190339", hash_generated_method = "AC382532967A92F5AE0A6334C055E43B")
    
public static Element I8(RenderScript rs) {
        if(rs.mElement_I8 == null) {
            rs.mElement_I8 = createUser(rs, DataType.SIGNED_8);
        }
        return rs.mElement_I8;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.293 -0500", hash_original_method = "959918A4EC36193110EB9C2116D8E702", hash_generated_method = "FD2BE102080703F0E0FD67214466CDD8")
    
public static Element U16(RenderScript rs) {
        if(rs.mElement_U16 == null) {
            rs.mElement_U16 = createUser(rs, DataType.UNSIGNED_16);
        }
        return rs.mElement_U16;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.296 -0500", hash_original_method = "5ED22C1EB2491E56707310B51363975A", hash_generated_method = "2A4580F969F95EDEBD01D55EB1718A4F")
    
public static Element I16(RenderScript rs) {
        if(rs.mElement_I16 == null) {
            rs.mElement_I16 = createUser(rs, DataType.SIGNED_16);
        }
        return rs.mElement_I16;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.298 -0500", hash_original_method = "5A2D43CCF847386638F75E4AC61E835D", hash_generated_method = "49834697652ABBFA34DDEC1C5E75FE8B")
    
public static Element U32(RenderScript rs) {
        if(rs.mElement_U32 == null) {
            rs.mElement_U32 = createUser(rs, DataType.UNSIGNED_32);
        }
        return rs.mElement_U32;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.300 -0500", hash_original_method = "805B6C0794556085C49F0CD62F6E3A3C", hash_generated_method = "67D68F042E83871C28E1C5B00F5814B9")
    
public static Element I32(RenderScript rs) {
        if(rs.mElement_I32 == null) {
            rs.mElement_I32 = createUser(rs, DataType.SIGNED_32);
        }
        return rs.mElement_I32;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.303 -0500", hash_original_method = "B259FB2D95B196949F7941AFED7ADB64", hash_generated_method = "E770DD45BDAA48805CBEE77EAA835A03")
    
public static Element U64(RenderScript rs) {
        if(rs.mElement_U64 == null) {
            rs.mElement_U64 = createUser(rs, DataType.UNSIGNED_64);
        }
        return rs.mElement_U64;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.305 -0500", hash_original_method = "E041087781786ED1AF7EADF6F33C4AA0", hash_generated_method = "E70B194B26B23C804D11B3AE7BFF6A5A")
    
public static Element I64(RenderScript rs) {
        if(rs.mElement_I64 == null) {
            rs.mElement_I64 = createUser(rs, DataType.SIGNED_64);
        }
        return rs.mElement_I64;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.307 -0500", hash_original_method = "ADA173557C6134753536D56139B10FEC", hash_generated_method = "417F1C7402230D2DD9A643F12A1274FE")
    
public static Element F32(RenderScript rs) {
        if(rs.mElement_F32 == null) {
            rs.mElement_F32 = createUser(rs, DataType.FLOAT_32);
        }
        return rs.mElement_F32;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.309 -0500", hash_original_method = "32341244E002B5416A6058993B523D2E", hash_generated_method = "0C3DD42ED77776DB1071718166CE2438")
    
public static Element F64(RenderScript rs) {
        if(rs.mElement_F64 == null) {
            rs.mElement_F64 = createUser(rs, DataType.FLOAT_64);
        }
        return rs.mElement_F64;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.312 -0500", hash_original_method = "229CB30C1C38C1A1161AA6F8DAB01261", hash_generated_method = "78012A0C808668CB62CB8E9DDC04261E")
    
public static Element ELEMENT(RenderScript rs) {
        if(rs.mElement_ELEMENT == null) {
            rs.mElement_ELEMENT = createUser(rs, DataType.RS_ELEMENT);
        }
        return rs.mElement_ELEMENT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.314 -0500", hash_original_method = "EB6FB3C89DC508CAC58E1D3C12FB5C28", hash_generated_method = "79D9BBD5F569D7249F4CA48F7A6EBD06")
    
public static Element TYPE(RenderScript rs) {
        if(rs.mElement_TYPE == null) {
            rs.mElement_TYPE = createUser(rs, DataType.RS_TYPE);
        }
        return rs.mElement_TYPE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.316 -0500", hash_original_method = "54EC1EFB11D419BFDC66EB03DB8604F9", hash_generated_method = "D2FAF94C280F1927EEC2A57899D1AEAC")
    
public static Element ALLOCATION(RenderScript rs) {
        if(rs.mElement_ALLOCATION == null) {
            rs.mElement_ALLOCATION = createUser(rs, DataType.RS_ALLOCATION);
        }
        return rs.mElement_ALLOCATION;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.319 -0500", hash_original_method = "A920499AA5985DF1D1F27BF1CC0DF786", hash_generated_method = "2F9BE0669072BF7C4D8E70FBDE061E3C")
    
public static Element SAMPLER(RenderScript rs) {
        if(rs.mElement_SAMPLER == null) {
            rs.mElement_SAMPLER = createUser(rs, DataType.RS_SAMPLER);
        }
        return rs.mElement_SAMPLER;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.321 -0500", hash_original_method = "E52AFC9D26844EADF700642562CDAD70", hash_generated_method = "93E886ED73CF537A8163AB2796929819")
    
public static Element SCRIPT(RenderScript rs) {
        if(rs.mElement_SCRIPT == null) {
            rs.mElement_SCRIPT = createUser(rs, DataType.RS_SCRIPT);
        }
        return rs.mElement_SCRIPT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.324 -0500", hash_original_method = "790AD277F9DCE37ACF0161D5E229C455", hash_generated_method = "C4DAD9F458F8A0E27AE45F5BEE391D67")
    
public static Element MESH(RenderScript rs) {
        if(rs.mElement_MESH == null) {
            rs.mElement_MESH = createUser(rs, DataType.RS_MESH);
        }
        return rs.mElement_MESH;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.326 -0500", hash_original_method = "503C7BBD8742ECE66F8B0A3BCBFA0CEC", hash_generated_method = "3A4F21CFC8A4CF21DF196DC653DA6C03")
    
public static Element PROGRAM_FRAGMENT(RenderScript rs) {
        if(rs.mElement_PROGRAM_FRAGMENT == null) {
            rs.mElement_PROGRAM_FRAGMENT = createUser(rs, DataType.RS_PROGRAM_FRAGMENT);
        }
        return rs.mElement_PROGRAM_FRAGMENT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.328 -0500", hash_original_method = "06DDE13E7E08717FF47CAB81A5DCA5E9", hash_generated_method = "BDA2E8E817553F6939779C46629AF0B4")
    
public static Element PROGRAM_VERTEX(RenderScript rs) {
        if(rs.mElement_PROGRAM_VERTEX == null) {
            rs.mElement_PROGRAM_VERTEX = createUser(rs, DataType.RS_PROGRAM_VERTEX);
        }
        return rs.mElement_PROGRAM_VERTEX;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.331 -0500", hash_original_method = "537D69958F74168156ABCA17656F089D", hash_generated_method = "C55E0FCB742DC55C9D27CE1E7797CED4")
    
public static Element PROGRAM_RASTER(RenderScript rs) {
        if(rs.mElement_PROGRAM_RASTER == null) {
            rs.mElement_PROGRAM_RASTER = createUser(rs, DataType.RS_PROGRAM_RASTER);
        }
        return rs.mElement_PROGRAM_RASTER;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.333 -0500", hash_original_method = "AF5A53E77F16289A869654E8D9CD6C21", hash_generated_method = "C194861A77861FB7D777C12AEE250042")
    
public static Element PROGRAM_STORE(RenderScript rs) {
        if(rs.mElement_PROGRAM_STORE == null) {
            rs.mElement_PROGRAM_STORE = createUser(rs, DataType.RS_PROGRAM_STORE);
        }
        return rs.mElement_PROGRAM_STORE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.335 -0500", hash_original_method = "915CEB99F13762FDDB02D8453BFFDF26", hash_generated_method = "F6B48BCF68F8DE76276FEEFFCC829AC2")
    
public static Element A_8(RenderScript rs) {
        if(rs.mElement_A_8 == null) {
            rs.mElement_A_8 = createPixel(rs, DataType.UNSIGNED_8, DataKind.PIXEL_A);
        }
        return rs.mElement_A_8;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.338 -0500", hash_original_method = "FFD8BA80B19F0E4ACB5DCC0D42EC43F6", hash_generated_method = "FF70CDB09012572D880F7222A74609DD")
    
public static Element RGB_565(RenderScript rs) {
        if(rs.mElement_RGB_565 == null) {
            rs.mElement_RGB_565 = createPixel(rs, DataType.UNSIGNED_5_6_5, DataKind.PIXEL_RGB);
        }
        return rs.mElement_RGB_565;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.340 -0500", hash_original_method = "197D001524CD912A07375CFBAF33B23C", hash_generated_method = "2C5CAD53298E8CECD813734F8B21A5CA")
    
public static Element RGB_888(RenderScript rs) {
        if(rs.mElement_RGB_888 == null) {
            rs.mElement_RGB_888 = createPixel(rs, DataType.UNSIGNED_8, DataKind.PIXEL_RGB);
        }
        return rs.mElement_RGB_888;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.342 -0500", hash_original_method = "C3D0C5985E2C0575C94F726CD78AC4F2", hash_generated_method = "4C601414E602534071101F3F5A0656A3")
    
public static Element RGBA_5551(RenderScript rs) {
        if(rs.mElement_RGBA_5551 == null) {
            rs.mElement_RGBA_5551 = createPixel(rs, DataType.UNSIGNED_5_5_5_1, DataKind.PIXEL_RGBA);
        }
        return rs.mElement_RGBA_5551;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.344 -0500", hash_original_method = "B7D7711B1223EE3EE8F0ADF1C0F10172", hash_generated_method = "6265F7AFFFC1E4F3073B44789C46A1E9")
    
public static Element RGBA_4444(RenderScript rs) {
        if(rs.mElement_RGBA_4444 == null) {
            rs.mElement_RGBA_4444 = createPixel(rs, DataType.UNSIGNED_4_4_4_4, DataKind.PIXEL_RGBA);
        }
        return rs.mElement_RGBA_4444;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.347 -0500", hash_original_method = "8F3AB3EBAF6E563E6AA33505F3024AFC", hash_generated_method = "BF43939E9ED0D83CA755EEAD1253F4B6")
    
public static Element RGBA_8888(RenderScript rs) {
        if(rs.mElement_RGBA_8888 == null) {
            rs.mElement_RGBA_8888 = createPixel(rs, DataType.UNSIGNED_8, DataKind.PIXEL_RGBA);
        }
        return rs.mElement_RGBA_8888;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.349 -0500", hash_original_method = "DAE9E591A17194E562757A6C2877DBFD", hash_generated_method = "5308C551E8C2004BD1024CEF82CB0FCA")
    
public static Element F32_2(RenderScript rs) {
        if(rs.mElement_FLOAT_2 == null) {
            rs.mElement_FLOAT_2 = createVector(rs, DataType.FLOAT_32, 2);
        }
        return rs.mElement_FLOAT_2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.351 -0500", hash_original_method = "5F562C0CF81721142221EC0D00CDE2DD", hash_generated_method = "BAFADAF6058A56C9C7B83AA0C3631151")
    
public static Element F32_3(RenderScript rs) {
        if(rs.mElement_FLOAT_3 == null) {
            rs.mElement_FLOAT_3 = createVector(rs, DataType.FLOAT_32, 3);
        }
        return rs.mElement_FLOAT_3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.353 -0500", hash_original_method = "9A20D2C21174BD1C5D8042C7B3619EB0", hash_generated_method = "9E02B67F4C3A3971260217988E914B8B")
    
public static Element F32_4(RenderScript rs) {
        if(rs.mElement_FLOAT_4 == null) {
            rs.mElement_FLOAT_4 = createVector(rs, DataType.FLOAT_32, 4);
        }
        return rs.mElement_FLOAT_4;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.356 -0500", hash_original_method = "E83B45167C2DCAA1FB1331374D631F13", hash_generated_method = "06711883B281E6D42A4B0D3FBB4849D6")
    
public static Element F64_2(RenderScript rs) {
        if(rs.mElement_DOUBLE_2 == null) {
            rs.mElement_DOUBLE_2 = createVector(rs, DataType.FLOAT_64, 2);
        }
        return rs.mElement_DOUBLE_2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.359 -0500", hash_original_method = "A7DF97411E9CEFCDC01AF5764E25D91D", hash_generated_method = "9385ADEF259F190E136E11BE7A383A13")
    
public static Element F64_3(RenderScript rs) {
        if(rs.mElement_DOUBLE_3 == null) {
            rs.mElement_DOUBLE_3 = createVector(rs, DataType.FLOAT_64, 3);
        }
        return rs.mElement_DOUBLE_3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.361 -0500", hash_original_method = "B6423C3540A083E90909F75A46316AC1", hash_generated_method = "C05E3B70F3016E4211A4EC912FC96AFD")
    
public static Element F64_4(RenderScript rs) {
        if(rs.mElement_DOUBLE_4 == null) {
            rs.mElement_DOUBLE_4 = createVector(rs, DataType.FLOAT_64, 4);
        }
        return rs.mElement_DOUBLE_4;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.364 -0500", hash_original_method = "62876F91C58EAF77EF8D067E2661CBF8", hash_generated_method = "21CF9B77947BCA34523BE69FA73186F6")
    
public static Element U8_2(RenderScript rs) {
        if(rs.mElement_UCHAR_2 == null) {
            rs.mElement_UCHAR_2 = createVector(rs, DataType.UNSIGNED_8, 2);
        }
        return rs.mElement_UCHAR_2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.366 -0500", hash_original_method = "6739A3A574FC3185A5CD0803D81A51EE", hash_generated_method = "70BF1D93FD74E6EC308BF8A1BB346FA0")
    
public static Element U8_3(RenderScript rs) {
        if(rs.mElement_UCHAR_3 == null) {
            rs.mElement_UCHAR_3 = createVector(rs, DataType.UNSIGNED_8, 3);
        }
        return rs.mElement_UCHAR_3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.368 -0500", hash_original_method = "DAB979582FABDDCC63A195912425C558", hash_generated_method = "00B2271687BCBDB6DA4C2100ECCCE250")
    
public static Element U8_4(RenderScript rs) {
        if(rs.mElement_UCHAR_4 == null) {
            rs.mElement_UCHAR_4 = createVector(rs, DataType.UNSIGNED_8, 4);
        }
        return rs.mElement_UCHAR_4;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.370 -0500", hash_original_method = "414E6B87B3CE7829F7A9849A371C90CE", hash_generated_method = "3B98804473BD908508AEE0B04B41CBFF")
    
public static Element I8_2(RenderScript rs) {
        if(rs.mElement_CHAR_2 == null) {
            rs.mElement_CHAR_2 = createVector(rs, DataType.SIGNED_8, 2);
        }
        return rs.mElement_CHAR_2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.373 -0500", hash_original_method = "30BF71187566A4C34527F107CA0D1A23", hash_generated_method = "5AD6487B1B3A38849868ADC0C3E8B28B")
    
public static Element I8_3(RenderScript rs) {
        if(rs.mElement_CHAR_3 == null) {
            rs.mElement_CHAR_3 = createVector(rs, DataType.SIGNED_8, 3);
        }
        return rs.mElement_CHAR_3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.375 -0500", hash_original_method = "1DA2ED8F3A7E4597A0646047CA870A37", hash_generated_method = "67A28ECC6D4CFE7025A18B1E475BD064")
    
public static Element I8_4(RenderScript rs) {
        if(rs.mElement_CHAR_4 == null) {
            rs.mElement_CHAR_4 = createVector(rs, DataType.SIGNED_8, 4);
        }
        return rs.mElement_CHAR_4;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.377 -0500", hash_original_method = "8773B5541A58AED8073A4DC6228ECB49", hash_generated_method = "8FEFC2E81F5A5F69E92D35E324D88E33")
    
public static Element U16_2(RenderScript rs) {
        if(rs.mElement_USHORT_2 == null) {
            rs.mElement_USHORT_2 = createVector(rs, DataType.UNSIGNED_16, 2);
        }
        return rs.mElement_USHORT_2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.379 -0500", hash_original_method = "D3C1CBF9F9255A40965FFB1C01B771B9", hash_generated_method = "577417AA2B8D4AC1741903622EE99AE6")
    
public static Element U16_3(RenderScript rs) {
        if(rs.mElement_USHORT_3 == null) {
            rs.mElement_USHORT_3 = createVector(rs, DataType.UNSIGNED_16, 3);
        }
        return rs.mElement_USHORT_3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.382 -0500", hash_original_method = "DB79DEF377FB8D669D6F22D63D6146FA", hash_generated_method = "F499AD089B39B4BD222A3EC6AC5DDFDB")
    
public static Element U16_4(RenderScript rs) {
        if(rs.mElement_USHORT_4 == null) {
            rs.mElement_USHORT_4 = createVector(rs, DataType.UNSIGNED_16, 4);
        }
        return rs.mElement_USHORT_4;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.384 -0500", hash_original_method = "9F9A03E74BC01F31B22330C0CA65EDBF", hash_generated_method = "233BB9A25E4046F822212C39A82C10D5")
    
public static Element I16_2(RenderScript rs) {
        if(rs.mElement_SHORT_2 == null) {
            rs.mElement_SHORT_2 = createVector(rs, DataType.SIGNED_16, 2);
        }
        return rs.mElement_SHORT_2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.387 -0500", hash_original_method = "51521429ADE7049015E53ED095AB980B", hash_generated_method = "538099810E971344294F5554C55DC8EE")
    
public static Element I16_3(RenderScript rs) {
        if(rs.mElement_SHORT_3 == null) {
            rs.mElement_SHORT_3 = createVector(rs, DataType.SIGNED_16, 3);
        }
        return rs.mElement_SHORT_3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.389 -0500", hash_original_method = "DA1DC9091B71C0A448F07F1276BB1856", hash_generated_method = "38CCE42EA82CFFC62A745EDA55F2C760")
    
public static Element I16_4(RenderScript rs) {
        if(rs.mElement_SHORT_4 == null) {
            rs.mElement_SHORT_4 = createVector(rs, DataType.SIGNED_16, 4);
        }
        return rs.mElement_SHORT_4;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.391 -0500", hash_original_method = "DA06DBC7CE2FE18D45E6AFA3E2F503B2", hash_generated_method = "0142C6ACCA45037A147441E138C67097")
    
public static Element U32_2(RenderScript rs) {
        if(rs.mElement_UINT_2 == null) {
            rs.mElement_UINT_2 = createVector(rs, DataType.UNSIGNED_32, 2);
        }
        return rs.mElement_UINT_2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.393 -0500", hash_original_method = "3EEBBA98B95FF0157C5F8AC30B353A89", hash_generated_method = "0F155865CB3AAEDE1DCAC05A5B54707B")
    
public static Element U32_3(RenderScript rs) {
        if(rs.mElement_UINT_3 == null) {
            rs.mElement_UINT_3 = createVector(rs, DataType.UNSIGNED_32, 3);
        }
        return rs.mElement_UINT_3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.395 -0500", hash_original_method = "B20628A0BCC411CD2B2BF644DC1440BE", hash_generated_method = "E622AB96ED42DD6D72C31DEDD9FB639C")
    
public static Element U32_4(RenderScript rs) {
        if(rs.mElement_UINT_4 == null) {
            rs.mElement_UINT_4 = createVector(rs, DataType.UNSIGNED_32, 4);
        }
        return rs.mElement_UINT_4;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.397 -0500", hash_original_method = "A1B576AAF1ECBB0A14A714C3093FB100", hash_generated_method = "2DB9D7160771FE64F3E997640F13E3E9")
    
public static Element I32_2(RenderScript rs) {
        if(rs.mElement_INT_2 == null) {
            rs.mElement_INT_2 = createVector(rs, DataType.SIGNED_32, 2);
        }
        return rs.mElement_INT_2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.401 -0500", hash_original_method = "80E15F4F69EADEA74F941DDB0B9DFFE7", hash_generated_method = "0A09E304618C84C89318F324158B118D")
    
public static Element I32_3(RenderScript rs) {
        if(rs.mElement_INT_3 == null) {
            rs.mElement_INT_3 = createVector(rs, DataType.SIGNED_32, 3);
        }
        return rs.mElement_INT_3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.403 -0500", hash_original_method = "F9F0C7F79792DD753872AECE9D216FA8", hash_generated_method = "2FC965662456E3F036C7E6642C54975D")
    
public static Element I32_4(RenderScript rs) {
        if(rs.mElement_INT_4 == null) {
            rs.mElement_INT_4 = createVector(rs, DataType.SIGNED_32, 4);
        }
        return rs.mElement_INT_4;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.406 -0500", hash_original_method = "704BA9CAF47C03A7D2CD5FE01AA7BFAC", hash_generated_method = "67A2F8C080CB8AD1A34405E5590B34E2")
    
public static Element U64_2(RenderScript rs) {
        if(rs.mElement_ULONG_2 == null) {
            rs.mElement_ULONG_2 = createVector(rs, DataType.UNSIGNED_64, 2);
        }
        return rs.mElement_ULONG_2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.408 -0500", hash_original_method = "BDAA0A607BBADC74008B0E9690384AA1", hash_generated_method = "98AF518455A64D686CEF9064937BC9B2")
    
public static Element U64_3(RenderScript rs) {
        if(rs.mElement_ULONG_3 == null) {
            rs.mElement_ULONG_3 = createVector(rs, DataType.UNSIGNED_64, 3);
        }
        return rs.mElement_ULONG_3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.410 -0500", hash_original_method = "8D441EE778E5B141C211F20B136ECE15", hash_generated_method = "5E9B9BA3462D667EBDE7C57F91E0C152")
    
public static Element U64_4(RenderScript rs) {
        if(rs.mElement_ULONG_4 == null) {
            rs.mElement_ULONG_4 = createVector(rs, DataType.UNSIGNED_64, 4);
        }
        return rs.mElement_ULONG_4;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.413 -0500", hash_original_method = "8102E4CB22354F112D04E3915787DF17", hash_generated_method = "DBCAB4DC6D0E9FB61EDEE0E9308E4414")
    
public static Element I64_2(RenderScript rs) {
        if(rs.mElement_LONG_2 == null) {
            rs.mElement_LONG_2 = createVector(rs, DataType.SIGNED_64, 2);
        }
        return rs.mElement_LONG_2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.415 -0500", hash_original_method = "78ED8FD0C878E9DC780F76732F0A528B", hash_generated_method = "53C864D896A91F6A0D249B38A2C7D9A2")
    
public static Element I64_3(RenderScript rs) {
        if(rs.mElement_LONG_3 == null) {
            rs.mElement_LONG_3 = createVector(rs, DataType.SIGNED_64, 3);
        }
        return rs.mElement_LONG_3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.417 -0500", hash_original_method = "BC586F8F6DD80AB6F9DD0F6EFE3370C7", hash_generated_method = "57A46E431EC581DFB00BF2C07A0C1A6B")
    
public static Element I64_4(RenderScript rs) {
        if(rs.mElement_LONG_4 == null) {
            rs.mElement_LONG_4 = createVector(rs, DataType.SIGNED_64, 4);
        }
        return rs.mElement_LONG_4;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.419 -0500", hash_original_method = "86C84CCF35B68421F88A805FE0C217E6", hash_generated_method = "03C8D05FA4BADE8C6B1195DB05EEC6E2")
    
public static Element MATRIX_4X4(RenderScript rs) {
        if(rs.mElement_MATRIX_4X4 == null) {
            rs.mElement_MATRIX_4X4 = createUser(rs, DataType.MATRIX_4X4);
        }
        return rs.mElement_MATRIX_4X4;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.422 -0500", hash_original_method = "5332AADE0A9495685283FF53B800616C", hash_generated_method = "5DF0E6B24900B7EFFDDB1D1A6AF560A4")
    
public static Element MATRIX4X4(RenderScript rs) {
        return MATRIX_4X4(rs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.424 -0500", hash_original_method = "324B13DDD6333ECD993A1A7E1E54F002", hash_generated_method = "842760E6D8075472A629B55BABD63398")
    
public static Element MATRIX_3X3(RenderScript rs) {
        if(rs.mElement_MATRIX_3X3 == null) {
            rs.mElement_MATRIX_3X3 = createUser(rs, DataType.MATRIX_3X3);
        }
        return rs.mElement_MATRIX_3X3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.426 -0500", hash_original_method = "CFF7B0183685C16646A986E156F5B4A5", hash_generated_method = "CB39544C9FAACC19A110B98A56040E10")
    
public static Element MATRIX_2X2(RenderScript rs) {
        if(rs.mElement_MATRIX_2X2 == null) {
            rs.mElement_MATRIX_2X2 = createUser(rs, DataType.MATRIX_2X2);
        }
        return rs.mElement_MATRIX_2X2;
    }

    /**
     * Create a custom Element of the specified DataType.  The DataKind will be
     * set to USER and the vector size to 1 indicating non-vector.
     *
     * @param rs The context associated with the new Element.
     * @param dt The DataType for the new element.
     * @return Element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.439 -0500", hash_original_method = "B37B8587D770D7826EF61767CDFB0D6A", hash_generated_method = "DA2EEFE68EA779BBB3625E96F4F5DF0E")
    
static Element createUser(RenderScript rs, DataType dt) {
        DataKind dk = DataKind.USER;
        boolean norm = false;
        int vecSize = 1;
        int id = rs.nElementCreate(dt.mID, dk.mID, norm, vecSize);
        return new Element(id, rs, dt, dk, norm, vecSize);
    }

    /**
     * Create a custom vector element of the specified DataType and vector size.
     *  DataKind will be set to USER.
     *
     * @param rs The context associated with the new Element.
     * @param dt The DataType for the new element.
     * @param size Vector size for the new Element.  Range 2-4 inclusive
     *             supported.
     *
     * @return Element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.442 -0500", hash_original_method = "B1B4E779BD078982D9B492986F6F7537", hash_generated_method = "F26C98211CB7444F933B107F0C3E8429")
    
public static Element createVector(RenderScript rs, DataType dt, int size) {
        if (size < 2 || size > 4) {
            throw new RSIllegalArgumentException("Vector size out of range 2-4.");
        }
        DataKind dk = DataKind.USER;
        boolean norm = false;
        int id = rs.nElementCreate(dt.mID, dk.mID, norm, size);
        return new Element(id, rs, dt, dk, norm, size);
    }

    /**
     * Create a new pixel Element type.  A matching DataType and DataKind must
     * be provided.  The DataType and DataKind must contain the same number of
     * components.  Vector size will be set to 1.
     *
     * @param rs The context associated with the new Element.
     * @param dt The DataType for the new element.
     * @param dk The DataKind to specify the mapping of each component in the
     *           DataType.
     *
     * @return Element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.445 -0500", hash_original_method = "4EFDA8834EFC5233A7016DA7BAF37B87", hash_generated_method = "733524971F5C6064AEA14C8767E0FE6D")
    
public static Element createPixel(RenderScript rs, DataType dt, DataKind dk) {
        if (!(dk == DataKind.PIXEL_L ||
              dk == DataKind.PIXEL_A ||
              dk == DataKind.PIXEL_LA ||
              dk == DataKind.PIXEL_RGB ||
              dk == DataKind.PIXEL_RGBA ||
              dk == DataKind.PIXEL_DEPTH)) {
            throw new RSIllegalArgumentException("Unsupported DataKind");
        }
        if (!(dt == DataType.UNSIGNED_8 ||
              dt == DataType.UNSIGNED_16 ||
              dt == DataType.UNSIGNED_5_6_5 ||
              dt == DataType.UNSIGNED_4_4_4_4 ||
              dt == DataType.UNSIGNED_5_5_5_1)) {
            throw new RSIllegalArgumentException("Unsupported DataType");
        }
        if (dt == DataType.UNSIGNED_5_6_5 && dk != DataKind.PIXEL_RGB) {
            throw new RSIllegalArgumentException("Bad kind and type combo");
        }
        if (dt == DataType.UNSIGNED_5_5_5_1 && dk != DataKind.PIXEL_RGBA) {
            throw new RSIllegalArgumentException("Bad kind and type combo");
        }
        if (dt == DataType.UNSIGNED_4_4_4_4 && dk != DataKind.PIXEL_RGBA) {
            throw new RSIllegalArgumentException("Bad kind and type combo");
        }
        if (dt == DataType.UNSIGNED_16 &&
            dk != DataKind.PIXEL_DEPTH) {
            throw new RSIllegalArgumentException("Bad kind and type combo");
        }

        int size = 1;
        switch (dk) {
        case PIXEL_LA:
            size = 2;
            break;
        case PIXEL_RGB:
            size = 3;
            break;
        case PIXEL_RGBA:
            size = 4;
            break;
        case PIXEL_DEPTH:
            size = 2;
            break;
        }

        boolean norm = true;
        int id = rs.nElementCreate(dt.mID, dk.mID, norm, size);
        return new Element(id, rs, dt, dk, norm, size);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.236 -0500", hash_original_field = "205262C28D2B190751535A4911B3B259", hash_generated_field = "205262C28D2B190751535A4911B3B259")

    int mSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.238 -0500", hash_original_field = "B4AACD1A33198C98C0C0D6BB21148E0E", hash_generated_field = "B4AACD1A33198C98C0C0D6BB21148E0E")

    Element[] mElements;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.240 -0500", hash_original_field = "D62B64EBC8BFD8DAE5E1EC6F5A939D2E", hash_generated_field = "D62B64EBC8BFD8DAE5E1EC6F5A939D2E")

    String[] mElementNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.242 -0500", hash_original_field = "CCF5C576DC1912807FD250325C1CD519", hash_generated_field = "CCF5C576DC1912807FD250325C1CD519")

    int[] mArraySizes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.244 -0500", hash_original_field = "2E5F2887D0D6DD04ADD3744A455172F1", hash_generated_field = "2E5F2887D0D6DD04ADD3744A455172F1")

    int[] mOffsetInBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.246 -0500", hash_original_field = "C0DAE69C302036895B5D54FD7E7F24F6", hash_generated_field = "C0DAE69C302036895B5D54FD7E7F24F6")

    DataType mType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.248 -0500", hash_original_field = "8565922A5748730DA211092C23993311", hash_generated_field = "8565922A5748730DA211092C23993311")

    DataKind mKind;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.250 -0500", hash_original_field = "F95038D32AB5A54E42A838D357D13473", hash_generated_field = "F95038D32AB5A54E42A838D357D13473")

    boolean mNormalized;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.252 -0500", hash_original_field = "9770236E3CE44E9B0E69591DDC704970", hash_generated_field = "9770236E3CE44E9B0E69591DDC704970")

    int mVectorSize;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.429 -0500", hash_original_method = "ED819749D70FA098614C1909362577A7", hash_generated_method = "ED819749D70FA098614C1909362577A7")
    
Element(int id, RenderScript rs, Element[] e, String[] n, int[] as) {
        super(id, rs);
        mSize = 0;
        mElements = e;
        mElementNames = n;
        mArraySizes = as;
        mOffsetInBytes = new int[mElements.length];
        for (int ct = 0; ct < mElements.length; ct++ ) {
            mOffsetInBytes[ct] = mSize;
            mSize += mElements[ct].mSize * mArraySizes[ct];
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.432 -0500", hash_original_method = "803DBF0EEF773E6E2205B989242FDDA6", hash_generated_method = "803DBF0EEF773E6E2205B989242FDDA6")
    
Element(int id, RenderScript rs, DataType dt, DataKind dk, boolean norm, int size) {
        super(id, rs);
        if ((dt != DataType.UNSIGNED_5_6_5) &&
            (dt != DataType.UNSIGNED_4_4_4_4) &&
            (dt != DataType.UNSIGNED_5_5_5_1)) {
            mSize = dt.mSize * size;
        } else {
            mSize = dt.mSize;
        }
        mType = dt;
        mKind = dk;
        mNormalized = norm;
        mVectorSize = size;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.435 -0500", hash_original_method = "C4EFD6253604440679EF13CF69D2FF93", hash_generated_method = "C4EFD6253604440679EF13CF69D2FF93")
    
Element(int id, RenderScript rs) {
        super(id, rs);
    }

    /**
    * @hide
    * @return element size in bytes
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.254 -0500", hash_original_method = "0A9009DB77E5CAA409A88E1F9233C5BB", hash_generated_method = "438F4D24BF2AC91687A2ADF57290172F")
    
public int getSizeBytes() {return mSize;}

    /**
     * Return if a element is too complex for use as a data source for a Mesh or
     * a Program.
     *
     * @return boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.273 -0500", hash_original_method = "62F3D976050C390A4D28EE7C5F1BA715", hash_generated_method = "8D23A41AC14097A194B8A0B66A4D6D61")
    
public boolean isComplex() {
        if (mElements == null) {
            return false;
        }
        for (int ct=0; ct < mElements.length; ct++) {
            if (mElements[ct].mElements != null) {
                return true;
            }
        }
        return false;
    }

    /**
    * @hide
    * @return number of sub-elements in this element
    */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.275 -0500", hash_original_method = "D2C3182AD613A846205329B1E6C8F2DD", hash_generated_method = "DB56486F5355452E37DD4594905ABD8B")
    
public int getSubElementCount() {
        if (mElements == null) {
            return 0;
        }
        return mElements.length;
    }

    /**
    * @hide
    * @param index index of the sub-element to return
    * @return sub-element in this element at given index
    */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.277 -0500", hash_original_method = "14503E907986F4FAF260BC78C8B9B60E", hash_generated_method = "5C96CD4D5EFD541E26ACF64F4D130D5A")
    
public Element getSubElement(int index) {
        if (mElements == null) {
            throw new RSIllegalArgumentException("Element contains no sub-elements");
        }
        if (index < 0 || index >= mElements.length) {
            throw new RSIllegalArgumentException("Illegal sub-element index");
        }
        return mElements[index];
    }

    /**
    * @hide
    * @param index index of the sub-element
    * @return sub-element in this element at given index
    */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.280 -0500", hash_original_method = "E8F6A160EAF7D73719B978688CDD0426", hash_generated_method = "3E2F11EA663F68039EBA0AF10218249B")
    
public String getSubElementName(int index) {
        if (mElements == null) {
            throw new RSIllegalArgumentException("Element contains no sub-elements");
        }
        if (index < 0 || index >= mElements.length) {
            throw new RSIllegalArgumentException("Illegal sub-element index");
        }
        return mElementNames[index];
    }

    /**
    * @hide
    * @param index index of the sub-element
    * @return array size of sub-element in this element at given index
    */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.282 -0500", hash_original_method = "19B70985107F13C23CD2C2D21B16BDB6", hash_generated_method = "58CEC8B8A0021BB58A119C0A6539BA41")
    
public int getSubElementArraySize(int index) {
        if (mElements == null) {
            throw new RSIllegalArgumentException("Element contains no sub-elements");
        }
        if (index < 0 || index >= mElements.length) {
            throw new RSIllegalArgumentException("Illegal sub-element index");
        }
        return mArraySizes[index];
    }

    /**
    * @hide
    * @param index index of the sub-element
    * @return offset in bytes of sub-element in this element at given index
    */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.284 -0500", hash_original_method = "1AC48AE3A04EA0A2E41E968266E6585D", hash_generated_method = "1ABE7A909EA2AA9B6F771AB090296849")
    
public int getSubElementOffsetBytes(int index) {
        if (mElements == null) {
            throw new RSIllegalArgumentException("Element contains no sub-elements");
        }
        if (index < 0 || index >= mElements.length) {
            throw new RSIllegalArgumentException("Illegal sub-element index");
        }
        return mOffsetInBytes[index];
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.437 -0500", hash_original_method = "8ECBC2337848BD749AC42873FE5AD6F5", hash_generated_method = "8AAD6E6DB4461C82734101F8C496EA16")
    
@Override
    void updateFromNative() {
        super.updateFromNative();

        // we will pack mType; mKind; mNormalized; mVectorSize; NumSubElements
        int[] dataBuffer = new int[5];
        mRS.nElementGetNativeData(getID(), dataBuffer);

        mNormalized = dataBuffer[2] == 1 ? true : false;
        mVectorSize = dataBuffer[3];
        mSize = 0;
        for (DataType dt: DataType.values()) {
            if(dt.mID == dataBuffer[0]){
                mType = dt;
                mSize = mType.mSize * mVectorSize;
            }
        }
        for (DataKind dk: DataKind.values()) {
            if(dk.mID == dataBuffer[1]){
                mKind = dk;
            }
        }

        int numSubElements = dataBuffer[4];
        if(numSubElements > 0) {
            mElements = new Element[numSubElements];
            mElementNames = new String[numSubElements];
            mArraySizes = new int[numSubElements];
            mOffsetInBytes = new int[numSubElements];

            int[] subElementIds = new int[numSubElements];
            mRS.nElementGetSubElements(getID(), subElementIds, mElementNames, mArraySizes);
            for(int i = 0; i < numSubElements; i ++) {
                mElements[i] = new Element(subElementIds[i], mRS);
                mElements[i].updateFromNative();
                mOffsetInBytes[i] = mSize;
                mSize += mElements[i].mSize * mArraySizes[i];
            }
        }

    }

    /**
     * Check if the current Element is compatible with another Element.
     * Primitive Elements are compatible if they share the same underlying
     * size and type (i.e. U8 is compatible with A_8). User-defined Elements
     * must be equal in order to be compatible. This requires strict name
     * equivalence for all sub-Elements (in addition to structural equivalence).
     *
     * @param e The Element to check compatibility with.
     *
     * @return boolean true if the Elements are compatible, otherwise false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.448 -0500", hash_original_method = "10DB51484387728F55F8C48219903602", hash_generated_method = "6FF5BF60DA800166DD3109E45A5B18EF")
    
public boolean isCompatible(Element e) {
        // Try strict BaseObj equality to start with.
        if (this.equals(e)) {
            return true;
        }

        // Ignore mKind because it is allowed to be different (user vs. pixel).
        // We also ignore mNormalized because it can be different. The mType
        // field must be non-null since we require name equivalence for
        // user-created Elements.
        return ((mSize == e.mSize) &&
                (mType != null) &&
                (mType == e.mType) &&
                (mVectorSize == e.mVectorSize));
    }
    
    public enum DataType {
        FLOAT_32 (2, 4),
        FLOAT_64 (3, 8),
        SIGNED_8 (4, 1),
        SIGNED_16 (5, 2),
        SIGNED_32 (6, 4),
        SIGNED_64 (7, 8),
        UNSIGNED_8 (8, 1),
        UNSIGNED_16 (9, 2),
        UNSIGNED_32 (10, 4),
        UNSIGNED_64 (11, 8),
        BOOLEAN(12, 1),
        UNSIGNED_5_6_5 (13, 2),
        UNSIGNED_5_5_5_1 (14, 2),
        UNSIGNED_4_4_4_4 (15, 2),
        MATRIX_4X4 (16, 64),
        MATRIX_3X3 (17, 36),
        MATRIX_2X2 (18, 16),
        RS_ELEMENT (1000, 4),
        RS_TYPE (1001, 4),
        RS_ALLOCATION (1002, 4),
        RS_SAMPLER (1003, 4),
        RS_SCRIPT (1004, 4),
        RS_MESH (1005, 4),
        RS_PROGRAM_FRAGMENT (1006, 4),
        RS_PROGRAM_VERTEX (1007, 4),
        RS_PROGRAM_RASTER (1008, 4),
        RS_PROGRAM_STORE (1009, 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.257 -0500", hash_original_field = "0B53E374282B34FB268F3024A1E73BA5", hash_generated_field = "0B53E374282B34FB268F3024A1E73BA5")

        int mID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.259 -0500", hash_original_field = "205262C28D2B190751535A4911B3B259", hash_generated_field = "205262C28D2B190751535A4911B3B259")

        int mSize;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.261 -0500", hash_original_method = "4AD92AF32882933A121403DF8D371600", hash_generated_method = "4AD92AF32882933A121403DF8D371600")
            
DataType(int id, int size) {
            mID = id;
            mSize = size;
        }
    }
    
    public enum DataKind {
        USER (0),
        PIXEL_L (7),
        PIXEL_A (8),
        PIXEL_LA (9),
        PIXEL_RGB (10),
        PIXEL_RGBA (11),
        PIXEL_DEPTH (12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.267 -0500", hash_original_field = "0B53E374282B34FB268F3024A1E73BA5", hash_generated_field = "0B53E374282B34FB268F3024A1E73BA5")

        int mID;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.269 -0500", hash_original_method = "5FF850D3ACAE392788630857D736F073", hash_generated_method = "5FF850D3ACAE392788630857D736F073")
            
DataKind(int id) {
            mID = id;
        }
    }
    
    public static class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.451 -0500", hash_original_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.453 -0500", hash_original_field = "B4AACD1A33198C98C0C0D6BB21148E0E", hash_generated_field = "B4AACD1A33198C98C0C0D6BB21148E0E")

        Element[] mElements;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.455 -0500", hash_original_field = "D62B64EBC8BFD8DAE5E1EC6F5A939D2E", hash_generated_field = "D62B64EBC8BFD8DAE5E1EC6F5A939D2E")

        String[] mElementNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.457 -0500", hash_original_field = "CCF5C576DC1912807FD250325C1CD519", hash_generated_field = "CCF5C576DC1912807FD250325C1CD519")

        int[] mArraySizes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.459 -0500", hash_original_field = "228E80965D19F3262507FB2E30484C98", hash_generated_field = "228E80965D19F3262507FB2E30484C98")

        int mCount;

        /**
         * Create a builder object.
         *
         * @param rs
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.462 -0500", hash_original_method = "728E8165442E638E6B663EFB1CAFAD98", hash_generated_method = "C2147FA41BB5E19B403DAA3AAD03D883")
        
public Builder(RenderScript rs) {
            mRS = rs;
            mCount = 0;
            mElements = new Element[8];
            mElementNames = new String[8];
            mArraySizes = new int[8];
        }

        /**
         * Add an array of elements to this element.
         *
         * @param element
         * @param name
         * @param arraySize
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.465 -0500", hash_original_method = "06213E432958F959DC8D842BD0BC1A12", hash_generated_method = "A12F4F08B7A2E0F4F9C66F47F3D4C47B")
        
public Builder add(Element element, String name, int arraySize) {
            if (arraySize < 1) {
                throw new RSIllegalArgumentException("Array size cannot be less than 1.");
            }
            if(mCount == mElements.length) {
                Element[] e = new Element[mCount + 8];
                String[] s = new String[mCount + 8];
                int[] as = new int[mCount + 8];
                System.arraycopy(mElements, 0, e, 0, mCount);
                System.arraycopy(mElementNames, 0, s, 0, mCount);
                System.arraycopy(mArraySizes, 0, as, 0, mCount);
                mElements = e;
                mElementNames = s;
                mArraySizes = as;
            }
            mElements[mCount] = element;
            mElementNames[mCount] = name;
            mArraySizes[mCount] = arraySize;
            mCount++;
            return this;
        }

        /**
         * Add a single element to this Element.
         *
         * @param element
         * @param name
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.467 -0500", hash_original_method = "166A4AF2B4A563746350FD29F5208B27", hash_generated_method = "C922C1384CF85260CDE8879B6D8D288B")
        
public Builder add(Element element, String name) {
            return add(element, name, 1);
        }

        /**
         * Create the element from this builder.
         *
         *
         * @return Element
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:10.470 -0500", hash_original_method = "75B70D9FB26EF7CE7043E09D494022A0", hash_generated_method = "68FAF3CB941E8F3EE47F333D991B23E1")
        
public Element create() {
            mRS.validate();
            Element[] ein = new Element[mCount];
            String[] sin = new String[mCount];
            int[] asin = new int[mCount];
            java.lang.System.arraycopy(mElements, 0, ein, 0, mCount);
            java.lang.System.arraycopy(mElementNames, 0, sin, 0, mCount);
            java.lang.System.arraycopy(mArraySizes, 0, asin, 0, mCount);

            int[] ids = new int[ein.length];
            for (int ct = 0; ct < ein.length; ct++ ) {
                ids[ct] = ein[ct].getID();
            }
            int id = mRS.nElementCreate2(ids, sin, asin);
            return new Element(id, mRS, ein, sin, asin);
        }
        
    }
    
}

