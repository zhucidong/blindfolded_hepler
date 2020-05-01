package zd.cornermemory.utils;

import java.util.HashMap;
import java.util.Map;

import zd.cornermemory.R;

/**
 * Created by zhud on 2019/4/29.
 * 存储魔方公式，及联想词
 */

public class Dictionary {
   public  static Map<String, String> dic = new HashMap<>();
    public static Map<String, Integer> pic = new HashMap<>();
    public static Map<String, String> formula_corner = new HashMap<>();
    public static Map<String, String> formula_edge = new HashMap<>();

    public static void initFormulaCorner(){
        formula_corner.put("AD","R' D' R U' R' D R U' R' D' R U2 R' D R");
        formula_corner.put("AE","U' R2 D R' U2 R D' R' U2 R' U");
        formula_corner.put("AF","U' R' U' R' D' R U R' D R2 U");
        formula_corner.put("AG","x' R2 D2 R' U' R D2 R' U R' x");
        formula_corner.put("AH","U' R2 D R' U R D' R' U' R' U");
        formula_corner.put("AI","U' R' U2 R' D' R U2 R' D R2 U");
        formula_corner.put("AW","D R2 D' R2 D R2 U' R2 D' R2 D R2 U D'");
        formula_corner.put("AM","R' D R U' R' D' R U");
        formula_corner.put("AN","D R' D' R U' R' D R U D'");
        formula_corner.put("AO","R' D' R2 U' R' D R U R' D' R' D R");
        formula_corner.put("AP","R' D2 R U' R' D2 R U");
        formula_corner.put("AQ","U' R D' R' U' R D R' U2");
        formula_corner.put("AR","R D' R2 D R U' R' D' R U R D R'");
        formula_corner.put("AS","U' R D R' U' R D' R' U2");
        formula_corner.put("AT","D' R' D' R U' R' D R U D");
        formula_corner.put("AX","R' F' R2 F R U' R' F' R2 F R U");
        formula_corner.put("AY","D' R' D R U' R' D' R U D");
        formula_corner.put("AZ","R' D' R U' R' D R U");



        formula_corner.put("BD","l' R' D2 R U2 R' D2 R U2 l");
        formula_corner.put("BE","U2 R' U2 R' D' R U2 R' D R2 U2");
        formula_corner.put("BF","R2 U' R U R' D' R U2 R' D R U R' U R2");
        formula_corner.put("BG","R2 D R' U2 R D' R' U2 R'");
        formula_corner.put("BH","R U D' R' D' R U2 R' D R D U R'");
        formula_corner.put("BI","R' U' R2 D' R2 D R2 U R2 D' R2 D R'");
        formula_corner.put("BW","R2 D2 R' U2 R D2 R' U2 R'");
        formula_corner.put("BM","R' D F2 D' R D R' F2 R D'");
        formula_corner.put("BN","R U R' D R U2 R' D' R U R'");
        formula_corner.put("BO","R2 D' R' U2 R D R' U2 R'");
        formula_corner.put("BP","U2 R' U2 R' D2 R U2 R' D2 R2 U2");
        formula_corner.put("BQ","R U R' D2 R U2 R' D2 R U R'");
        formula_corner.put("BR","D R2 D' R' U2 R D R' U2 R' D'");
        formula_corner.put("BS","R U D' R' D R U2 R' D' R D U R'");
        formula_corner.put("BT","R U R' D' R U2 R' D R U R'");
        formula_corner.put("BX","D' R2 D2 R' U2 R D2 R' U2 R' D");
        formula_corner.put("BY","R2 U' D' R' D' R U2 R' D R D U' R2");
        formula_corner.put("BZ","D' R U R' D R U2 R' D' R U R' D");


        formula_corner.put("CD","F R' D' R U2 R' D R U2 F'");
        formula_corner.put("CE","U' R' U L U' R U L'");
        formula_corner.put("CF","x' R U' R' D R U R' D' x");
        formula_corner.put("CG","x' R U R' D R U' R' D' x'");
        formula_corner.put("CH","R' U L U' R U L' U'");
        formula_corner.put("CI","F' U R' D R U2 R' D' R U F");
        formula_corner.put("CW","U' R' U R U' R' D R U R' D' U' R U");
        formula_corner.put("CM","F' D R U' R' D' R U R' F");
        formula_corner.put("CN","D R' U' D' R U R' D R U' R' U R D'");
        formula_corner.put("CO","R2 D2 R U' R' D R U R' D R2");
        formula_corner.put("CP","x' R U2 R' D R U2 R' D' x");
        formula_corner.put("CQ","U' R' U L2 U' R U L2");
        formula_corner.put("CR","R2 U L U' R2 U L' U'");
        formula_corner.put("CS","R' U' R' D' R U2 R' D R U' R");
        formula_corner.put("CT","F D' R U R' D R U' R' F'");
        formula_corner.put("CX","D' R2 D R U' R' D2 R U R' D R2 D");
        formula_corner.put("CY","R U L U' R' U L' U'");
        formula_corner.put("CZ","R' U' D' R U R' D R U' R' U R");
        
        
        

        formula_corner.put("DA","R' D' R U2 R' D R U R' D' R U R' D R");
        formula_corner.put("DB","l' U2 R' D2 R U2 R' D2 R l");
        formula_corner.put("DC","F U2 R' D' R U2 R' U R F'");
        formula_corner.put("DG","l' U R' D2 R U' R' D2 R l");
        formula_corner.put("DH","R' U2 D' R' D R U2 R' D' R D R");
        formula_corner.put("DI","U R U D' R' D' R U2 R' D R D U R' U'");
        formula_corner.put("DW","D R2 U R2 D R2 D' R2 U' R2 D R2 D2");
        formula_corner.put("DM","R' D R U2 R' D' R U2");
        formula_corner.put("DN","D R' D' R U2 R' D R U2 D'");
        formula_corner.put("DO","R' U' D' R2 U' R' D R U R' D' R' U D R");
        formula_corner.put("DP","R' D2 R U2 R' D2 R U2");
        formula_corner.put("DQ","U' R D' R' U2 R D R' U'");
        formula_corner.put("DR","R D' R2 D R U2 R' D' R U2 R D R'");
        formula_corner.put("DS","U' R D R' U2 R D' R' U'");
        formula_corner.put("DT","D' R' D' R U2 R' D R U2 D");
        formula_corner.put("DX","R2 U R2 D R2 D' R2 U' R2 D R2 D'");
        formula_corner.put("DY","D' R' D R U2 R' D' R U2 D");
        formula_corner.put("DZ","R' D' R U2 R' D R U2");



        formula_corner.put("EA","U' R U2 R D R' U2 R D' R2 U");
        formula_corner.put("EB","U2 R2 D' R U2 R' D R U2 R U2");
        formula_corner.put("EC","L U' R' U L' U' R U");
        formula_corner.put("EG","R2 D R' U R D' R' U' R'");
        formula_corner.put("EH","z' U2 R' D2 R U R' D2 R U z");
        formula_corner.put("EI","R' D R2 D' R2 U R2 D R2 D' R2 U' R' ");
        formula_corner.put("EW","R2 D2 R' U R D2 R' U' R'");
        formula_corner.put("EM","U R' U' R' D R U R' D' R2 U'");
        formula_corner.put("EN","R U R' D R U R' D' R U2 R'");
        formula_corner.put("EO","R2 D' R' U R D R' U' R'");
        formula_corner.put("EP","D U R' U' R' D R U R' D' R2 U' D'");
        formula_corner.put("EQ","R U R' D2 R U R' D2 R U2 R'");
        formula_corner.put("ER","D R2 D' R' U R D R' U' R' D'");
        formula_corner.put("ES","R D R D R' U R D' R' D' U' R'");
        formula_corner.put("ET","R U R' D' R U R' D R U2 R'");
        formula_corner.put("EX","D' R2 D2 R' U R D2 R' U' R' D");
        formula_corner.put("EY","z' R' D2 R U' R' D2 R U z");
        formula_corner.put("EZ","x' R' U2 R D R' U2 R D' x");




        formula_corner.put("FA","U' R2 D' R U' R' D R U R U");
        formula_corner.put("FB","R2 U' R U' R' D' R U2 R' D R U' R' U R2");
        formula_corner.put("FC","x' D R U' R' D' R U R' x");
        formula_corner.put("FG","R' U2 R' D' R U2 R' D R2");
        formula_corner.put("FH","U' L' U R U' L U R'");
        formula_corner.put("FI","U R2 D R' U2 R D' R' U2 R' U'");
        formula_corner.put("FW","x' D2 R U' R' D2 R U R' x");
        formula_corner.put("FM","R' D2 R' U R D' R' U' R D' R");
        formula_corner.put("FN","D R2 U R D R' U' R D' R D'");
        formula_corner.put("FO","L' D' R2 D L D' R2 D");
        formula_corner.put("FP","R' D' R' U R D2 R' U' R D' R");
        formula_corner.put("FQ","U2 R U R D' R' U' R D R2 U2");
        formula_corner.put("FR","R' U' L' U R2 U' L U R'");
        formula_corner.put("FS","R' U2 R' D' R U' R' D R U' R");
        formula_corner.put("FT","R2 U R D R' U2 R D' R' U R2");
        formula_corner.put("FX","DU R D' R U' R' D R U R2 U'D'");
        formula_corner.put("FY","R2 U' L' U R' U' L U R'");
        formula_corner.put("FZ","x' D' R U' R' D R U R' x");


        formula_corner.put("GA","x' R U' R D2 R' U R D2 R2 x");
        formula_corner.put("GB","R U2 R D R' U2 R D' R2");
        formula_corner.put("GC","x' D R U R' D' R U' R' x");
        formula_corner.put("GD","x R2 D2 R U R' D2 R U' R x'");
        formula_corner.put("GE","R U R D R' U' R D' R2");
        formula_corner.put("GF","R2 D' R U2 R' D R U2 R");
        formula_corner.put("GW","x' D2 R U R' D2 R U' R' x");
        formula_corner.put("GM","R' D R U R' D' R U'");
        formula_corner.put("GN","U' R D2 R' U R D2 R'");
        formula_corner.put("GO","x R' U' R D2 R' U R D2 x'");
        formula_corner.put("GP","R' D2 R U R' D2 R U'");
        formula_corner.put("GQ","U' R D' R' U R D R'");
        formula_corner.put("GR","U' R2 D R2 D' R2 U R2 D R2 D' R2");
        formula_corner.put("GS","U' R D R' U R D' R'");
        formula_corner.put("GT","D' R' D' R U R' D R U' D");
        formula_corner.put("GX","R2 D' R2 D R2 U R2 D' R2 D R2 U'");
        formula_corner.put("GY","D' R' D R U R' D' R U' D");
        formula_corner.put("GZ","R' D' R U R' D R U'");



        formula_corner.put("HA","U' R U R D R' U' R D' R2 U");
        formula_corner.put("HB","R U' D' R' D' R U2 R' D R D U' R'");
        formula_corner.put("HC","U L U' R' U L' U' R");
        formula_corner.put("HD","R' D' R' D R U2 R' D' R D U2 R");
        formula_corner.put("HE","z' U' R' D2 R U' R' D2 R U2 z");
        formula_corner.put("HF","R U' L' U R' U' L U");
        formula_corner.put("HW","D' R U' R' U R D' R' U' R D U R' D");
        formula_corner.put("HM","R U' L2 U R' U' L2 U");
        formula_corner.put("HN","U L' U' R' U L U' R");
        formula_corner.put("HO","U L2 U' R' U L2 U' R");
        formula_corner.put("HP","R' D2 U R U' R' D2 R U R' U' R");
        formula_corner.put("HQ","R U' L U R' U' L' U");
        formula_corner.put("HR","D R U' R' U R D' R' U' R D U R' D'");
        formula_corner.put("HS","U' R U D R' U' R D' R' U R U' R' U");
        formula_corner.put("HT","R' D' R' D R U R' D' R U' D R");
        formula_corner.put("HX","U R' U' R U R' D' R U' R' D U R U' ");
        formula_corner.put("HY","D' R' U D R U' R' D' R U R' U' R D");
        formula_corner.put("HZ","R' U D' R U' R' D R U R' U' R");


        formula_corner.put("IA","U' R2 D' R U2 R' D R U2 R U");
        formula_corner.put("IB","R D' R2 D R2 U' R2 D' R2 D R2 U R");
        formula_corner.put("IC","F' U' R' D R U2 R' D' R U' F");
        formula_corner.put("ID","U R U' D' R' D' R U2 R' D R D U' R' U'");
        formula_corner.put("IE","R U R2 D R2 D' R2 U' R2 D R2 D' R ");
        formula_corner.put("IF","U R U2 R D R' U2 R D' R2 U'");
        formula_corner.put("IW","U' R2 D R U2 R' D' R U2 R U");
        formula_corner.put("IM","U R U' R' D R U2 R' D' R U' R' U'");
        formula_corner.put("IN","F' U' R' D' R U2 R' D R U' F");
        formula_corner.put("IO","U' R2 D2 R U2 R' D2 R U2 R U");
        formula_corner.put("IP","U' R' U' R D' R' U2 R D R' U' R U");
        formula_corner.put("IQ","U R U2 R D' R' U2 R D R2 U'");
        formula_corner.put("IR","F' U2 R D R' U2 R D' R' F");
        formula_corner.put("IS","U R U' R' D' R U2 R' D R U' R' U'");
        formula_corner.put("IT","U D R U2 R D' R' U2 R D R2 D' U'");
        formula_corner.put("IX","D' U' R2 D R U2 R' D' R U2 R U D");
        formula_corner.put("IY","U' R' U' R D R' U2 R D' R' U' R U");
        formula_corner.put("IZ","D' U R U2 R D2 R' U2 R D2 R2 U' D");


        formula_corner.put("WA","D U' R2 D' R2 D R2 U R2 D' R2 D R2 D'");
        formula_corner.put("WB","R U2 R D2 R' U2 R D2 R2");
        formula_corner.put("WC","R2 D' R U' R' D2 R U R' D' R2");
        formula_corner.put("WD","D2 R2 D' R2 U R2 D R2 D' R2 U' R2 D'");
        formula_corner.put("WE","R U R D2 R' U' R D2 R2");
        formula_corner.put("WF","x' R U' R' D2 R U R' D2 x");
        formula_corner.put("WG","x' R U R' D2 R U' R' D2 x");
        formula_corner.put("WH","D' R U' D' R' U R D R' U' R U R' D");
        formula_corner.put("WI","U' R' U2 R' D R U2 R' D' R2 U");
        formula_corner.put("WO","D R2 U R2 U' R2 D R2 U R2 U' R2 D2");
        formula_corner.put("WP","x' R U2 R' D2 R U2 R' D2 x");
        formula_corner.put("WQ","l' R' D F2 D' R D R' F2 R D' l");
        formula_corner.put("WR","D R2 U R2 U' R2 D2 R2 U R2 U' R2 D");
        formula_corner.put("WS","U' R' U R' D R U' R' D' R2 U");
        formula_corner.put("WT","D' R U' R D' R' U R D R2 D");
        formula_corner.put("WX","D R2 U R2 U' R2 D' R2 U R2 U' R2");
        formula_corner.put("WY","R U' R2 D R2 U R' U' R2 D' R2 U");
        formula_corner.put("WZ","R U' R D2 R' U R D2 R2");


        formula_corner.put("MA","U' R' D R U R' D' R");
        formula_corner.put("MB","D R' F2 R D' R' D F2 D' R");
        formula_corner.put("MC","L' U' R' U L U' R U");
        formula_corner.put("MD","U2 R' D R U2 R' D' R");
        formula_corner.put("ME","L' U' R' U L2 U' R U L'");
        formula_corner.put("MF","R' D R' U R D R' U' R D2 R");
        formula_corner.put("MG","U R' D R U' R' D' R");
        formula_corner.put("MH","U' L2 U R U' L2 U R'");
        formula_corner.put("MI","U R U R' D R U2 R' D' R U R' U'");
        formula_corner.put("MO","F' R U' R' D2 R U R' D2 F");
        formula_corner.put("MP","D U R U' R' D R U R' U' D2");
        formula_corner.put("MQ","L' U' R' U L' U' R U L2");
        formula_corner.put("MR","R' U' L2 U R2 U' L2 U R'");
        formula_corner.put("MS","D U R U' R' D2 R U R' U' D");
        formula_corner.put("MT","R' D R' U' R D R' U R D2 R");
        formula_corner.put("MX","D2 R2 D2 R U R' D R U' R' D R2 D2");
        formula_corner.put("MY","D U R U' R' D' R U R' U'");
        formula_corner.put("MZ","l D2 R U R' D2 R U' l' R'");


        formula_corner.put("NA","D U' R' D' R U R' D R D'");
        formula_corner.put("NB","R U' R' D R U2 R' D' R U' R'");
        formula_corner.put("NC","D R' U' R U R' D' R U' R' D U R D'");
        formula_corner.put("ND","D U2 R' D' R U2 R' D R D'");
        formula_corner.put("NE","R U2 R' D R U' R' D' R U' R'");
        formula_corner.put("NF","D R' D R' U R D' R' U' R2 D'");
        formula_corner.put("NG","R D2 R' U' R D2 R' U");
        formula_corner.put("NH","R' U L' U' R U L U'");
        formula_corner.put("NI","F' U R' D' R U2 R' D R U F");
        formula_corner.put("NO","z' D R' U2 R D' R' U2 R z");
        formula_corner.put("NP","D' R D' R' U' R D2 R' U R D' R' D");
        formula_corner.put("NQ","D R U R' D R U' R' D2");
        formula_corner.put("NR","R2 U L' U' R2 U L U'");
        formula_corner.put("NS","R D2 R' U' R D' R' U R D' R'");
        formula_corner.put("NT","D R U R' D2 R U' R' D");
        formula_corner.put("NX","R U' R2 D R U2 R' D' R U2 R U R'");
        formula_corner.put("NY","R U L' U' R' U L U'");
        formula_corner.put("NZ","D R U R' D' R U' R'");


        formula_corner.put("OA","R' D' R D R U' R' D' R U R2 D R");
        formula_corner.put("OB","R U2 R D' R' U2 R D R2");
        formula_corner.put("OC","R2 D' R U' R' D' R U R' D2 R2");
        formula_corner.put("OD","R' U' D' R D R U' R' D' R U R2 D U R");
        formula_corner.put("OE","R U R D' R' U' R D R2");
        formula_corner.put("OF","D' R2 D L' D' R2 D L");
        formula_corner.put("OG","x D2 R' U' R D2 R' U R x'");
        formula_corner.put("OH","R U' D' R' U R D R' U' R U R'");
        formula_corner.put("OI","U' R' U2 R' D2 R U2 R' D2 R2 U");
        formula_corner.put("OW","D2 R2 U R2 U' R2 D' R2 U R2 U' R2 D'");
        formula_corner.put("OM","F' D2 R U' R' D2 R U R' F");
        formula_corner.put("ON","R U' R D' R' U R D R' U R' D R U' R' D'");
        formula_corner.put("OR","D2 R2 U R2 U' R2 D R2 U R2 U' R2 D");
        formula_corner.put("OS","R2 D' R U R' D' R U' R' D2 R2");
        formula_corner.put("OT","L2 U L D2 L' U' L D2 L");
        formula_corner.put("OX","D2 R2 U R2 U' R2 D2 R2 U R2 U' R2");
        formula_corner.put("OY","R U L2 U' R' U L2 U'");
        formula_corner.put("OZ","R U' R D' R' U R D R2");


        formula_corner.put("PA","U' R' D2 R U R' D2 R");
        formula_corner.put("PB","U2 R2 D2 R U2 R' D2 R U2 R U2");
        formula_corner.put("PC","x' D R U2 R' D' R U2 R' x");
        formula_corner.put("PD","U2 R' D2 R U2 R' D2 R");
        formula_corner.put("PE","DU R2 D R U' R' D' R U R U'D'");
        formula_corner.put("PF","R' D R' U R D2 R' U' R D R");
        formula_corner.put("PG","U R' D2 R U' R' D2 R");
        formula_corner.put("PH","R' U R U' R' D2 R U R' U' D2 R");
        formula_corner.put("PI","U' R' U R D' R' U2 R D R' U R U");
        formula_corner.put("PW","x' D2 R U2 R' D2 R U2 R' x");
        formula_corner.put("PM","D2 U R U' R' D' R U R' U' D'");
        formula_corner.put("PN","D' R D R' U' R D2 R' U R D R' D");
        formula_corner.put("PR","U R D2 R U' R' D2 R U R2 U'");
        formula_corner.put("PS","D2 U R U' R' D R U R' U' D");
        formula_corner.put("PT","R' D R' U' R D2 R' U R D R");
        formula_corner.put("PX","D' U' R2 D R U R' D' R U' R U D");
        formula_corner.put("PY","D2 U R U' R' D2 R U R' U'");
        formula_corner.put("PZ","x' D' R U2 R' D R U2 R' x");



        formula_corner.put("QA","U2 R D' R' U R D R' U");
        formula_corner.put("QB","R U' R' D2 R U2 R' D2 R U' R'");
        formula_corner.put("QC","L2 U' R' U L2 U' R U");
        formula_corner.put("QD","U R D' R' U2 R D R' U");
        formula_corner.put("QE","R U2 R' D2 R U' R' D2 R U' R'");
        formula_corner.put("QF","U2 R2 D' R' U R D R' U' R' U2");
        formula_corner.put("QG","R D' R' U' R D R' U");
        formula_corner.put("QH","U' L U R U' L' U R'");
        formula_corner.put("QI","U R2 D' R' U2 R D R' U2 R' U'");
        formula_corner.put("QW","l' D R' F2 R D' R' D F2 D' R l");
        formula_corner.put("QM","L2 U' R' U L U' R U L");
        formula_corner.put("QN","D2 R U R' D' R U' R' D'");
        formula_corner.put("QR","R' U' L U R2 U' L' U R'");
        formula_corner.put("QS","R D' R' U' R D2 R' U R D' R'");
        formula_corner.put("QT","D2 R U R' D R U' R' D");
        formula_corner.put("QX","D2 R2 D' R' U' R D R' U R' D2");
        formula_corner.put("QY","R2 U' L U R' U' L' U R'");
        formula_corner.put("QZ","D2 R U R' D2 R U' R'");



        formula_corner.put("RA","z' U2 R D2 R' U2 R D2 R' z");
        formula_corner.put("RB","D R U2 R D' R' U2 R D R2 D'");
        formula_corner.put("RC","U L U' R2 U L' U' R2");
        formula_corner.put("RD","R D' R' U2 R' D R U2 R' D' R2 D R'");
        formula_corner.put("RE","z' U' R' D2 R U2 R' D2 R U' z");
        formula_corner.put("RF","R U' L' U R2 U' L U R");
        formula_corner.put("RG","R2 D R2 D' R2 U' R2 D R2 D' R2 U");
        formula_corner.put("RH","D R U' D' R' U R D R' U' R U R' D'");
        formula_corner.put("RI","F' R D R' U2 R D' R' U2 F");
        formula_corner.put("RW","D' R2 U R2 U' R2 D2 R2 U R2 U' R2 D'");
        formula_corner.put("RM","R U' L2 U R2 U' L2 U R");
        formula_corner.put("RN","U L' U' R2 U L U' R2");
        formula_corner.put("RO","D' R2 U R2 U' R2 D' R2 U R2 U' R2 D2");
        formula_corner.put("RP","U R2 U' R' D2 R U R' D2 R' U'");
        formula_corner.put("RQ","R U' L U R2 U' L' U R");
        formula_corner.put("RX","D' R2 U R2 U' R2 D R2 U R2 U' R2");
        formula_corner.put("RY","U R D' R' D R U' R' D' R D U R' U'");
        formula_corner.put("RZ","D R U' D' R' U R D2 R' U' R D' U R' D'");



        formula_corner.put("SA","U2 R D R' U R D' R' U");
        formula_corner.put("SB","R U' D' R' D R U2 R' D' R D U' R'");
        formula_corner.put("SC","R' U R' D' R U2 R' D R U R");
        formula_corner.put("SD","U R D R' U2 R D' R' U");
        formula_corner.put("SE","x' U R' D' R U2 R' D R U x");
        formula_corner.put("SF","R' U R' D' R U R' D R U2 R");
        formula_corner.put("SG","R D R' U' R D' R' U");
        formula_corner.put("SH","U' R U R' U' R D R' U R D' U' R' U");
        formula_corner.put("SI","U R U R' D' R U2 R' D R U R' U'");
        formula_corner.put("SW","U' R2 D R U R' D' R U' R U");
        formula_corner.put("SM","D' U R U' R' D2 R U R' U' D'");
        formula_corner.put("SN","R D R' U' R D R' U R D2 R'");
        formula_corner.put("SO","R2 D2 R U R' D R U' R' D R2");
        formula_corner.put("SP","D' U R U' R' D' R U R' U' D2");
        formula_corner.put("SQ","R D R' U' R D2 R' U R D R'");
        formula_corner.put("SX","U D R D2 R U' R' D2 R U R2 D' U'");
        formula_corner.put("SY","D' U R U' R' D R U R' U'");
        formula_corner.put("SZ","R D' R' D R U R' D' R D U' R'");


        formula_corner.put("TA","D' U' R' D' R U R' D R D");
        formula_corner.put("TB","R U' R' D' R U2 R' D R U' R'");
        formula_corner.put("TC","F R U R' D' R U' R' D F'");
        formula_corner.put("TD","D' U2 R' D' R U2 R' D R D");
        formula_corner.put("TE","R U2 R' D' R U' R' D R U' R'");
        formula_corner.put("TF","R2 U' R D R' U2 R D' R' U' R2");
        formula_corner.put("TG","D' U R' D' R U' R' D R D");
        formula_corner.put("TH","R' U D' R' D R U' R' D' R D R");
        formula_corner.put("TI","U D R2 D' R' U2 R D R' U2 R' D' U'");
        formula_corner.put("TW","D' R2 D' R' U' R D R' U R' D");
        formula_corner.put("TM","R' D2 R' U' R D' R' U R D' R");
        formula_corner.put("TN","D' R U R' D2 R U' R' D'");
        formula_corner.put("TO","L' D2 L' U L D2 L' U' L2");
        formula_corner.put("TP","R' D' R' U' R D2 R' U R D' R");
        formula_corner.put("TQ","D' R U R' D' R U' R' D2");
        formula_corner.put("TX","D' R2 D2 R' U' R D2 R' U R' D");
        formula_corner.put("TY","D R D' R' U' R D2 R' U R D' R' D'");
        formula_corner.put("TZ","D' R U R' D R U' R'");


        formula_corner.put("XA","U' R2 D' R2 D R2 U R2 D' R2 D R2");
        formula_corner.put("XB","D' R U2 R D2 R' U2 R D2 R2 D");
        formula_corner.put("XC","D' R2 D' R U' R' D2 R U R' D' R2 D");
        formula_corner.put("XD","D R2 D' R2 U R2 D R2 D' R2 U' R2");
        formula_corner.put("XE","D' R U R D2 R' U' R D2 R2 D");
        formula_corner.put("XF","DU R2 U' R' D' RUR' D R' U'D");
        formula_corner.put("XG","U R'F'R2FR U' R'F'R2FR");
        formula_corner.put("XH","UR'U' D' RUR' D RU'R' URU'");
        formula_corner.put("XI","D' U' R' U2 R' D R U2 R' D' R2 U D");
        formula_corner.put("XW","R2 U R2 U' R2 D R2 U R2 U' R2 D'");
        formula_corner.put("XM","D2 R2 D' R U R' D' R U' R' D2 R2 D2");
        formula_corner.put("XN","R U' R' U2 R' D R U2 R' D' R2 U R'");
        formula_corner.put("XO","R2 U R2 U' R2 D2 R2 U R2 U' R2 D2");
        formula_corner.put("XP","UD R2 U'R' D RUR' D' R'U'D'");
        formula_corner.put("XQ","D2 R U' R D' R' U R D' R2 D2");
        formula_corner.put("XR","R2 U R2 U' R2 D' R2 U R2 U' R2 D");
        formula_corner.put("XS","U D R2 U' R' D2 R U R' D2 R' D' U'");
        formula_corner.put("XT","D' R U' R D2 R' U R D2 R2 D");



        formula_corner.put("YA","D' U' R' D R U R' D' R D");
        formula_corner.put("YB","R2 U D' R' D' R U2 R' D R D U R2");
        formula_corner.put("YC","z' U' R' D R U R' D' R z");
        formula_corner.put("YD","D' U2 R' D R U2 R' D' R D");
        formula_corner.put("YE","z' U' R' D2 R U R' D2 R z");
        formula_corner.put("YF","R U' L' U R U' L U R2");
        formula_corner.put("YG","D' U R' D R U' R' D' R D");
        formula_corner.put("YH","D' R' U R U' R' D R U R' D' U' R D");
        formula_corner.put("YI","U' R' U R D R' U2 R D' R' U R U");
        formula_corner.put("YW","U' R2 D R2 U R U' R2 D' R2 U R'");
        formula_corner.put("YM","U R U' R' D R U R' U' D'");
        formula_corner.put("YN","U L' U' R U L U' R'");
        formula_corner.put("YO","U L2 U' R U L2 U' R'");
        formula_corner.put("YP","U R U' R' D2 R U R' U' D2");
        formula_corner.put("YQ","R U' L U R U' L' U R2");
        formula_corner.put("YR","U R D'U' R' D R U R' D' R D R' U'");
        formula_corner.put("YS","U R U' R' D' R U R' U' D");
        formula_corner.put("YT","D R D R' U' R D2 R' U R D R' D'");


        formula_corner.put("ZA","U' R' D' R U R' D R");
        formula_corner.put("ZB","D' R U' R' D R U2 R' D' R U' R' D");
        formula_corner.put("ZC","R' U' R U R' D' R U' R' D U R");
        formula_corner.put("ZD","U2 R' D' R U2 R' D R");
        formula_corner.put("ZE","x' D R' U2 R D' R' U2 R x");
        formula_corner.put("ZF","x' R U' R' D' R U R' D x");
        formula_corner.put("ZG","U R' D' R U' R' D R");
        formula_corner.put("ZH","R' U R U' R' D' R U R' DU' R");
        formula_corner.put("ZI","D' U R2 D2 R' U2 R D2 R' U2 R' U' D");
        formula_corner.put("ZW","R2 D2 R' U' R D2 R' U R'");
        formula_corner.put("ZM","l R U R' D2 R U' R' D2 l'");
        formula_corner.put("ZN","R U R' D R U' R' D'");
        formula_corner.put("ZO","R2 D' R' U' R D R' U R'");
        formula_corner.put("ZP","x' R U2 R' D' R U2 R' D x");
        formula_corner.put("ZQ","R U R' D2 R U' R' D2");
        formula_corner.put("ZR","B' R U R' D2 R U' R' D2 B");
        formula_corner.put("ZS","R D'U R' D R U' R' D' R D R'");
        formula_corner.put("ZT","R U R' D' R U' R' D");






    }


    public static void initFormulaEdge(){
        formula_edge.put("CE", "L2 U' S' L2 S L2 U L2 ");
        formula_edge.put("CF", "l U L' U' M' U L U' L' ");
        formula_edge.put("CG", "M2 U' M U2 M' U' M2 ");
        formula_edge.put("CH", "S R' F R S' R' F' R ");
        formula_edge.put("CI", "M U2 M U' M' U2 M' U ");
        formula_edge.put("CJ", "l' U L U' M U L' U' L ");
        formula_edge.put("CK", "L U' L S' L2 S L U L' ");
        formula_edge.put("CL", "U L' E' L U' L' E L ");
        formula_edge.put("CM", "M2 L U L' U' M2 U L U' L' ");
        formula_edge.put("CN", "U' M U' M' U' M U' M' ");
        formula_edge.put("CO", "(URUR'U'R'U'R'U)R");
        formula_edge.put("CP", "U' R E R' U' R E' R' U2 ");
        formula_edge.put("CQ", "R'(URUR'U'R'U'R'U)R2");
        formula_edge.put("CR", "U L E' L' U' L E L' ");
        formula_edge.put("CS", "F2 R U M' U2 M U R' F2 ");
        formula_edge.put("CT", "U' R' E R U' R' E' R U2 ");
        formula_edge.put("CW", "u L' E L U' L' E' L E");
        formula_edge.put("CX", "U' R E' R' U' R E R' U2");
        formula_edge.put("CY", "R(URUR'U'R'U'R'U)");
        formula_edge.put("CZ", "U L' E L U' L' E' L ");


        formula_edge.put("DE", "U' M U M' U2 M U M' U ");
        formula_edge.put("DF", "L' U' L U M' U' L' U l ");
        formula_edge.put("DG", "L F' L' S' L F L' S ");
        formula_edge.put("DH", "M U M' U2 M U M' ");
        formula_edge.put("DI", "L' F' L2 E' L2 E F L ");
        formula_edge.put("DJ", "L F L' U L E' L' U' L E F' L' ");
        formula_edge.put("DK", "L F' L' S L F L' S' ");
        formula_edge.put("DL", "S' U' R2' S' R2 S U S ");
        formula_edge.put("DM", "M L' U' L U M2 U' L' U l");
        formula_edge.put("DN", "M' U M' U M U M' U M2");
        formula_edge.put("DO", "r U' L E' L' U L E L' r' ");
        formula_edge.put("DP", "R' F R S R2 S' R F' R");
        formula_edge.put("DQ", "M' U' l E' l' U l E L'");
        formula_edge.put("DR", "R M U M' U2 M U M' R'");
        formula_edge.put("DS", "r U R' E R U R' E' R U2 r'");
        formula_edge.put("DT", "S U' R' E R U R' E' R S'");
        formula_edge.put("DW", "U' l U M' U2 M U l' U");
        formula_edge.put("DX", "S U' R E' R' U R E R' S'");
        formula_edge.put("DY", "M' U' L' E L U L' E' l");
        formula_edge.put("DZ", "r' U M' U2 M U r");


        formula_edge.put("EC", "L2 U S' L2 S L2 U' L2 ");
        formula_edge.put("ED", "U' M U' M' U2 M U' M' U ");
        formula_edge.put("EG", "R2 U' S R2 S' R2 U R2 ");
        formula_edge.put("EH", "U M U M' U2 M U M' U' ");
        formula_edge.put("EI", "U2 M' U2 M ");
        formula_edge.put("EJ", "R' F' R U R' E R U' R' E' F R");
        formula_edge.put("EK", "U S' L2 S L2 U' ");
        formula_edge.put("EL", "U L' E' L U2 L' E L U ");
        formula_edge.put("EM", "M U2 M' U2 ");
        formula_edge.put("EN", "U M' U M' U2 M U M U' ");
        formula_edge.put("EO", "U' S R2 S' R2 U ");
        formula_edge.put("EP", "U' R E R' U2 R E' R' U' ");
        formula_edge.put("EQ", "R' U' S R2 S' R2 U R ");
        formula_edge.put("ER", "U L E' L' U2 L E L' U ");
        formula_edge.put("ES", "L U S' L2 S L2 U' L' ");
        formula_edge.put("ET", "U' R' E R U2 R' E' R U' ");
        formula_edge.put("EW", "L' U S' L2 S L2 U' L ");
        formula_edge.put("EX", "U' R E' R' U2 R E R' U' ");
        formula_edge.put("EY", "R U' S R2 S' R2 U R' ");
        formula_edge.put("EZ", "U L' E L U2 L' E' L U ");


        formula_edge.put("FC", "L U L' U' M U L U' l' ");
        formula_edge.put("FD", "l' U' L U M U' L' U L ");
        formula_edge.put("FG", "R' U' R U M U' R' U r ");
        formula_edge.put("FH", "r U R' U' M U R U' R' ");
        formula_edge.put("FI", "U S R' F' R S' R' F R U' ");
        formula_edge.put("FJ", "U' R' F' R S R' F R S' U");
        formula_edge.put("FK", "U L2 U' M U L2 U' M'");
        formula_edge.put("FL", "M' U' L2 U M U' L2 U");
        formula_edge.put("FM", "U S R B R' S' R B' R' U'");
        formula_edge.put("FN", "U' R B R' S R B' R' S' U");
        formula_edge.put("FO", "U' R2 U M U' R2 U M'");
        formula_edge.put("FP", "M' U R2 U' M U R2 U'");
        formula_edge.put("FQ", "U' R U M U' R' U M'");
        formula_edge.put("FR", "M' U R U' M U R' U'");
        formula_edge.put("FS", "U L' U' M U L U' M'");
        formula_edge.put("FT", "M' U' L' U M U' L U");
        formula_edge.put("FW", "U L U' M U L' U' M'");
        formula_edge.put("FX", "M' U' L U M U' L' U");
        formula_edge.put("FY", "U' R' U M U' R U M'");
        formula_edge.put("FZ", "M' U R' U' M U R U'");


        formula_edge.put("GC", "M2 U M U2 M' U M2");
        formula_edge.put("GD", "S' L F' L' S L F L'");
        formula_edge.put("GE", "R2 U S R2 S' R2 U' R2 ");
        formula_edge.put("GF", "r' U' R U M' U' R' U R ");
        formula_edge.put("GI", "M U2 M U M' U2 M' U' ");
        formula_edge.put("GJ", "r U' R' U M U' R U R' ");
        formula_edge.put("GK", "U'L'U'LU LU LU'L'");
        formula_edge.put("GL", "U L' E' L U L' E L U2 ");
        formula_edge.put("GM", "M2 R' U' R U M2 U' R' U R ");
        formula_edge.put("GN", "U M U M' U M U M' ");
        formula_edge.put("GO", "R' U R' S R2 S' R' U' R ");
        formula_edge.put("GP", "U' R E R' U R E' R' ");
        formula_edge.put("GQ", "F2 L' U' M' U2 M U' L F2 ");
        formula_edge.put("GR", "U L E' L' U L E L' U2 ");
        formula_edge.put("GS", "LU'L'U'LULU LU'L2");
        formula_edge.put("GT", "U' R' E R U R' E' R ");
        formula_edge.put("GW", "L'U'L'U'LULULU'");
        formula_edge.put("GX", "U' R E' R' U R E R' ");
        formula_edge.put("GY", "M U M' U' R' U M U' r");
        formula_edge.put("GZ", "U L' E L U L' E' L U2");


        formula_edge.put("HC", "R' F R S R' F' R S'");
        formula_edge.put("HD", "M U' M' U2 M U' M' ");
        formula_edge.put("HE", "U M U' M' U2 M U' M' U'");
        formula_edge.put("HF", "R U R' U' M' U R U' r'");
        formula_edge.put("HI", "R F R2 E R2 E' F' R' ");
        formula_edge.put("HJ", "R' F' R U' R' E R U R' E' F R ");
        formula_edge.put("HK", "R' F R' S' R F' R' S R2 ");
        formula_edge.put("HL", "L F' L' S' L2 S L' F L'");
        formula_edge.put("HM", "M R U R' U' M2 U R U' r'");
        formula_edge.put("HN", "M' U' M' U' M U' M' U' M2");
        formula_edge.put("HO", "R' F R S' R' F' R S");
        formula_edge.put("HP", "S U L2 S L2 S' U' S'");
        formula_edge.put("HQ", "l' U' L E' L' U' L E L' U2 l");
        formula_edge.put("HR", "S' U L E' L' U' L E L' S");
        formula_edge.put("HS", "M' U r' E r U' r' E' R");
        formula_edge.put("HT", "L' M U' M' U2 M U' M' L");
        formula_edge.put("HW", "M' U R E' R' U' R E r'");
        formula_edge.put("HX", "l U' M' U2 M U' l'");
        formula_edge.put("HY", "U r' U' M' U2 M U' r U'");
        formula_edge.put("HZ", "S' U L' E L U' L' E' L S");


        formula_edge.put("IC", "U' M U2 M U M' U2 M'");
        formula_edge.put("ID", "L' F' E' L2 E L2 F L ");
        formula_edge.put("IE", "M' U2 M U2 ");
        formula_edge.put("IF", "U R' F' R S R' F R S' U' ");
        formula_edge.put("IG", "U M U2 M U' M' U2 M' ");
        formula_edge.put("IH", "R F E R2 E' R2 F' R' ");
        formula_edge.put("IK", "U' L2 U M' U2 M U L2 U ");
        formula_edge.put("IL", "L F' E' L2 E L2 F L'");
        formula_edge.put("IM", "M2 U2 M U2 M");
        formula_edge.put("IN", "D' S' R F R' S R F' R' D ");
        formula_edge.put("IO", "U R2 U' M' U2 M U' R2 U' ");
        formula_edge.put("IP", "R' F E R2 E' R2 F' R ");
        formula_edge.put("IQ", "U R U' M' U2 M U' R' U' ");
        formula_edge.put("IR", "R2 F E R2 E' R2 F' R2 ");
        formula_edge.put("IS", "U' L' U M' U2 M U L U ");
        formula_edge.put("IT", "L2 F' E' L2 E L2 F L2");
        formula_edge.put("IW", "U' L U M' U2 M U L' U ");
        formula_edge.put("IX", "F' E' L2 E L2 F ");
        formula_edge.put("IY", "U R' U' M' U2 M U' R U' ");
        formula_edge.put("IZ", "F E R2 E' R2 F' ");


        formula_edge.put("JC", "L' U L U' M' U L' U' l ");
        formula_edge.put("JD", "L F E' L' U L E L' U' L F' L' ");
        formula_edge.put("JE", "R' F' E R U R' E' R U' R' F R");
        formula_edge.put("JF", "U' S R' F' R S' R' F R U");
        formula_edge.put("JG", "R U' R' U M' U' R U r'");
        formula_edge.put("JH", "R' F' E R U' R' E' R U R' F R ");
        formula_edge.put("JK", "U L2 U' M' U L2 U' M");
        formula_edge.put("JL", "U S L F L' S' L F' L' U' ");
        formula_edge.put("JM", "D R F R' S' R F' R' S D'");
        formula_edge.put("JN", "U M' U' M U2 M U M' U ");
        formula_edge.put("JO", "U' R2 U M' U' R2 U M");
        formula_edge.put("JP", "U' S' R' F' R S R' F R U ");
        formula_edge.put("JQ", "U' R U M' U' R' U M ");
        formula_edge.put("JR", "M' U R U' M' U R' U' M2 ");
        formula_edge.put("JS", "U L' U' M' U L U' M ");
        formula_edge.put("JT", "M' U' L' U M' U' L U M2 ");
        formula_edge.put("JW", "U L U' M' U L' U' M ");
        formula_edge.put("JX", "L2' F E' L' U L E L' U' L F' L2 ");
        formula_edge.put("JY", "U' R' U M' U' R U M ");
        formula_edge.put("JZ", "R2' F' E R U' R' E' R U R' F R2");


        formula_edge.put("KC", "L' U' L S' L2 S L U L ");
        formula_edge.put("KD", "S L F' L' S' L F L' ");
        formula_edge.put("KE", "U' S' L2 S L2 U ");
        formula_edge.put("KF", "M U L2 U' M' U L2 U' ");
        formula_edge.put("KG", "LUL'U'L'U'L'ULU");
        formula_edge.put("KH", "l' R' E R U R' E' R U' l ");
        formula_edge.put("KI", "U' L2 U' M' U2 M U' L2 U ");
        formula_edge.put("KJ", "l' U L' U' M U L U' L ");
        formula_edge.put("KM", "M2 U L2 U' M2 U L2 U' ");
        formula_edge.put("KN", "L' U' l' U' M' U2 M U' l U L ");
        formula_edge.put("KO", "U' R2 S' R2 S U");
        formula_edge.put("KP", "S' R F R' S R F' R' ");
        formula_edge.put("KQ", "U L' E' L2 E L' U' ");
        formula_edge.put("KR", "L2 U L E' L' U' L E L ");
        formula_edge.put("KS", "U' D L' U M' U2 M U L D' U ");
        formula_edge.put("KT", "U E L' E' L2 E L' E' U' ");
        formula_edge.put("KW", "U' D L U M' U2 M U L' D' U ");
        formula_edge.put("KX", "u L E L2 E' L u' ");
        formula_edge.put("KY", "U L E L2 E' L U' ");
        formula_edge.put("KZ", "u L' E' L2 E L' u' ");


        formula_edge.put("LC", "L' E' L U L' E L U' ");
        formula_edge.put("LD", "l' U L S' L2 S L U' l ");
        formula_edge.put("LE", "U' L' E' L U2 L' E L U' ");
        formula_edge.put("LF", "U' L2 U M' U' L2 U M ");
        formula_edge.put("LG", "U2 L' E' L U' L' E L U' ");
        formula_edge.put("LH", "l L U M' U2 M U L' l' ");
        formula_edge.put("LI", "L F E' L2 E L2 F' L'");
        formula_edge.put("LJ", "U L F L' S L F' L' S' U' ");
        formula_edge.put("LM", "L' M U' L' U M2 U' L U l ");
        formula_edge.put("LN", "M D M' D M D M' D ");
        formula_edge.put("LO", "L' F' L S L' F L S' ");
        formula_edge.put("LP", "l' U R' E R2 E' R' U' l ");
        formula_edge.put("LQ", "D U' R U M' U' R' U M D' ");
        formula_edge.put("LR", "M' U' L' E' L2 E L' U M ");
        formula_edge.put("LS", "D U L' U' M' U L U' M D' ");
        formula_edge.put("LT", "z L E' L' U L E L' U' z' ");
        formula_edge.put("LW", "D U L U' M' U L' U' M D' ");
        formula_edge.put("LX", "z L E' L' U' L E L' U z' ");
        formula_edge.put("LY", "D U' R' U M' U' R U M D' ");
        formula_edge.put("LZ", "x' L U M' U2 M U L' x ");

        formula_edge.put("MC", "L U L' U' M2 U L U' L' M2 ");
        formula_edge.put("MD", "l' U' L U M2 U' L' U L M'");
        formula_edge.put("ME", "U2 M U2 M'");
        formula_edge.put("MF", "U R B R' S R B' R' S' U'");
        formula_edge.put("MG", "R U' R' U M2 U' R U R' M2");
        formula_edge.put("MH", "r U R' U' M2 U R U' R' M'");
        formula_edge.put("MI", "M' U2 M' U2 M2");
        formula_edge.put("MJ", "D S' R F R' S R F' R' D'");
        formula_edge.put("MK", "U'DRDR'D' R'D'R'DR U");
        formula_edge.put("ML", "M' U' L2 U M2 U' L2 U M'");
        formula_edge.put("MO", "U' R2 U M2 U' R2 U M2");
        formula_edge.put("MP", "M' U R2 U' M2 U R2 U' M'");
        formula_edge.put("MQ", "U' R U M2 U' R' U M2");
        formula_edge.put("MR", "M' U R U' M2 U R' U' M'");
        formula_edge.put("MS", "U L' U' M2 U L U' M2");
        formula_edge.put("MT", "M' U' L' U M2 U' L U M'");
        formula_edge.put("MW", "U L U' M2 U L' U' M2");
        formula_edge.put("MX", "M' U' L U M2 U' L' U M'");
        formula_edge.put("MY", "U' R' U M2 U' R U M2");
        formula_edge.put("MZ", "M' U R' U' M2 U R U' M'");


        formula_edge.put("NC", "M U M' U M U M' U");
        formula_edge.put("ND", "M2 U' M U' M' U' M U' M");
        formula_edge.put("NE", "U M' U' M' U2 M U' M U'");
        formula_edge.put("NF", "U' S R B R' S' R B' R' U");
        formula_edge.put("NG", "M U' M' U' M U' M' U'");
        formula_edge.put("NH", "M2 U M U M' U M U M");
        formula_edge.put("NI", "D' R F R' S' R F' R' S D");
        formula_edge.put("NJ", "U' M U' M' U2 M' U M U'");
        formula_edge.put("NK", "U L2 U M U' L2 U M' U2");
        formula_edge.put("NL", "D' M D' M' D' M D' M'");
        formula_edge.put("NO", "U' R2 U' M U R2 U' M' U2");
        formula_edge.put("NP", "D M D M' D M D M'");
        formula_edge.put("NQ", "U' R U' M U R' U' M' U2");
        formula_edge.put("NR", "r M' U M U M' U M U r'");
        formula_edge.put("NS", "U L' U M U' L U M' U2");
        formula_edge.put("NT", "l' M' U' M U' M' U' M U' l");
        formula_edge.put("NW", "U L U M U' L' U M' U2");
        formula_edge.put("NX", "u' l' U M' U2 M U l u");
        formula_edge.put("NY", "U' R' U' M U R U' M' U2");
        formula_edge.put("NZ", "u r U' M' U2 M U' r' u'");


        formula_edge.put("OC", "R'(U'RURURU'R'U')");
        formula_edge.put("OD", "r L E' L' U' L E L' U r' ");
        formula_edge.put("OE", "U S R2 S' R2 U' ");
        formula_edge.put("OF", "M U' R2 U M' U' R2 U ");
        formula_edge.put("OG", "R U R' S R2 S' R' U' R' ");
        formula_edge.put("OH", "S' R' F R S R' F' R ");
        formula_edge.put("OI", "U R2 U M' U2 M U R2 U' ");
        formula_edge.put("OJ", "r U' R U M U' R' U R' ");
        formula_edge.put("OK", "U L2 S L2 S' U'");
        formula_edge.put("OL", "S L' F' L S' L' F L ");
        formula_edge.put("OM", "M2 U' R2 U M2 U' R2 U ");
        formula_edge.put("ON", "U2 M U R2 U' M' U R2 U");
        formula_edge.put("OQ", "U D' R U' M' U2 M U' R' D U' ");
        formula_edge.put("OR", "U' E' R E R2 E' R E U ");
        formula_edge.put("OS", "U' R E R2 E' R U ");
        formula_edge.put("OT", "R2 U' R' E R U R' E' R' ");
        formula_edge.put("OW", "U' R' E' R2 E R' U ");
        formula_edge.put("OX", "u' R E R2 E' R u ");
        formula_edge.put("OY", "U D' R' U' M' U2 M U' R D U' ");
        formula_edge.put("OZ", "u' R' E' R2 E R' u ");


        formula_edge.put("PC", "U2 R E R' U R E' R' U ");
        formula_edge.put("PD", "r' R' U' M' U2 M U' R r ");
        formula_edge.put("PE", "U R E R' U2 R E' R' U ");
        formula_edge.put("PF", "U R2 U' M' U R2 U' M ");
        formula_edge.put("PG", "R E R' U' R E' R' U ");
        formula_edge.put("PH", "r U' R' S R2 S' R' U r' ");
        formula_edge.put("PI", "R' F' E R2 E' R2 F R ");
        formula_edge.put("PJ", "U' R' F' R S' R' F R S U ");
        formula_edge.put("PK", "R F R' S' R F' R' S ");
        formula_edge.put("PL", "l' U R E R2 E' R U' l ");
        formula_edge.put("PM", "R M U R U' M2 U R' U' r' ");
        formula_edge.put("PN", "M D' M' D' M D' M' D' ");
        formula_edge.put("PQ", "D' U' R U M' U' R' U M D ");
        formula_edge.put("PR", "z' R' E R U' R' E' R U z ");
        formula_edge.put("PS", "D' U L' U' M' U L U' M D ");
        formula_edge.put("PT", "M' U R E R2 E' R U' M ");
        formula_edge.put("PW", "D' U L U' M' U L' U' M D ");
        formula_edge.put("PX", "x' R' U' M' U2 M U' R x ");
        formula_edge.put("PY", "D' U' R' U M' U' R U M D ");
        formula_edge.put("PZ", "z' R' E R U R' E' R U' z ");


        formula_edge.put("QC", "R2(U'RURURU'R'U')R");
        formula_edge.put("QD", "L E' l' U' l E l' U M");
        formula_edge.put("QE", "R' U S R2 S' R2 U' R");
        formula_edge.put("QF", "M U' R U M' U' R' U");
        formula_edge.put("QG", "F2 L' U M' U2 M U L F2 ");
        formula_edge.put("QH", "l' U2 L E' L' U L E L' U l");
        formula_edge.put("QI", "U R U M' U2 M U R' U' ");
        formula_edge.put("QJ", "M' U' R U M U' R' U ");
        formula_edge.put("QK", "U L E' L2 E L U' ");
        formula_edge.put("QL", "D M' U' R U M U' R' U D' ");
        formula_edge.put("QM", "M2 U' R U M2 U' R' U ");
        formula_edge.put("QN", "U2 M U R U' M' U R' U");
        formula_edge.put("QO", "U D' R U M' U2 M U R' D U' ");
        formula_edge.put("QP", "D' M' U' R U M U' R' U D ");
        formula_edge.put("QS", "R' U' R E R2 E' R U R ");
        formula_edge.put("QT", "R U' R' E R U R' E' ");
        formula_edge.put("QW", "R' U' R' E' R2 E R' U R ");
        formula_edge.put("QX", "R U' R E' R' U R E R2 ");
        formula_edge.put("QY", "U R' S R2 S' R' U' ");
        formula_edge.put("QZ", "R U' R' E' R U R' E ");


        formula_edge.put("RC", "L E' L' U L E L' U' ");
        formula_edge.put("RD", "M R U' M' U2 M U' R' M' ");
        formula_edge.put("RE", "U' L E' L' U2 L E L' U' ");
        formula_edge.put("RF", "U R U' M' U R' U' M ");
        formula_edge.put("RG", "U2 L E' L' U' L E L' U' ");
        formula_edge.put("RH", "S' L E' L' U L E L' U' S ");
        formula_edge.put("RI", "R2 F' E R2 E' R2 F R2 ");
        formula_edge.put("RJ", "M2 U R U' M U R' U' M ");
        formula_edge.put("RK", "L' E' L' U L E L' U' L2 ");
        formula_edge.put("RL", "M' U' L E' L2 E L U M ");
        formula_edge.put("RM", "M U R U' M2 U R' U' M ");
        formula_edge.put("RN", "r U' M' U' M U' M' U' M r' ");
        formula_edge.put("RO", "U' E' R' E R2 E' R' E U ");
        formula_edge.put("RP", "z' U' R' E R U R' E' R z ");
        formula_edge.put("RS", "E' L' U L E L' U' L ");
        formula_edge.put("RT", "U' E' L S' L2 S L E U ");
        formula_edge.put("RW", "L2 E' L' U L E L' U' L' ");
        formula_edge.put("RX", "l' U' L E' L2 E L U l ");
        formula_edge.put("RY", "E R' U' R E' R' U R");
        formula_edge.put("RZ", "l' U' R' S R2 S' R' U l ");


        formula_edge.put("SC", "F2 R U' M' U2 M U' R' F2 ");
        formula_edge.put("SD", "r U2 R' E R U' R' E' R U' r'");
        formula_edge.put("SE", "L U' S' L2 S L2 U L'");
        formula_edge.put("SF", "M U L' U' M' U L U'");
        formula_edge.put("SG", "R E2 R' U' R E2 R' U");
        formula_edge.put("SH", "R' E r U r' E' r U' M");
        formula_edge.put("SI", "U' L' U' M' U2 M U' L U ");
        formula_edge.put("SJ", "M' U L' U' M U L U' ");
        formula_edge.put("SK", "U' D L' U' M' U2 M U' L D' U");
        formula_edge.put("SL", "D M' U L' U' M U L U' D' ");
        formula_edge.put("SM", "M2 U L' U' M2 U L U' ");
        formula_edge.put("SN", "U' l' U' M' U2 M U' l U ");
        formula_edge.put("SO", "U' R' E R2 E' R' U ");
        formula_edge.put("SP", "D' M' U L' U' M U L U' D ");
        formula_edge.put("SQ", "R' U' R' E R2 E' R' U R ");
        formula_edge.put("SR", "L' U L E' L' U' L E ");
        formula_edge.put("SW", "U' L S' L2 S L U ");
        formula_edge.put("SX", "L' U L E L' U' L E' ");
        formula_edge.put("SY", "R U' R' E R2 E' R' U R' ");
        formula_edge.put("SZ", "L' U L' E L U' L' E' L2 ");

        formula_edge.put("TC", "U2 R' E R U R' E' R U ");
        formula_edge.put("TD", "S R' E R U' R' E' R U S' ");
        formula_edge.put("TE", "U R' E R U2 R' E' R U ");
        formula_edge.put("TF", "U' L' U M' U' L U M ");
        formula_edge.put("TG", "R' E R U' R' E' R U ");
        formula_edge.put("TH", "M L' U M' U2 M U L M' ");
        formula_edge.put("TI", "L2 F E' L2 E L2 F' L2");
        formula_edge.put("TJ", "M2 U' L' U M U' L U M ");
        formula_edge.put("TK", "U E L E' L2 E L E' U' ");
        formula_edge.put("TL", "z U L E' L' U' L E L' z' ");
        formula_edge.put("TM", "M U' L' U M2 U' L U M ");
        formula_edge.put("TN", "l' U M' U M U M' U M l ");
        formula_edge.put("TO", "R E R U' R' E' R U R2 ");
        formula_edge.put("TP", "M' U R' E R2 E' R' U' M ");
        formula_edge.put("TQ", "E R U' R' E' R U R' ");
        formula_edge.put("TR", "U E R' S R2 S' R' E' U' ");
        formula_edge.put("TW", "E' L U L' E L U' L' ");
        formula_edge.put("TX", "r U L S' L2 S L U' r' ");
        formula_edge.put("TY", "R2 E R U' R' E' R U R ");
        formula_edge.put("TZ", "r U R' E R2 E' R' U' r'");


        formula_edge.put("WC", "E' L' E L U L' E' L u'");
        formula_edge.put("WD", "U' l U' M' U2 M U' l' U ");
        formula_edge.put("WE", "L' U' S' L2 S L2 U L ");
        formula_edge.put("WF", "M U L U' M' U L' U' ");
        formula_edge.put("WG", "UL'U'L'U'L'ULUL");
        formula_edge.put("WH", "r E' R' U R E R' U' M");
        formula_edge.put("WI", "U' L U' M' U2 M U' L' U ");
        formula_edge.put("WJ", "M' U L U' M U L' U' ");
        formula_edge.put("WK", "U' D L U' M' U2 M U' L' D' U ");
        formula_edge.put("WL", "D M' U L U' M U L' U' D' ");
        formula_edge.put("WM", "M2 U L U' M2 U L' U' ");
        formula_edge.put("WN", "L U' M U' M' U' M U' l' ");
        formula_edge.put("WO", "U' R E' R2 E R U ");
        formula_edge.put("WP", "D' M' U L U' M U L' U' D ");
        formula_edge.put("WQ", "R' U' R E' R2 E R U R ");
        formula_edge.put("WR", "L U L E' L' U' L E L2 ");
        formula_edge.put("WS", "U' L' S' L2 S L' U ");
        formula_edge.put("WT", "L U L' E' L U' L' E ");
        formula_edge.put("WY", "R U' R E' R2 E R U R' ");
        formula_edge.put("WZ", "L U L' E L U' L' E' ");

        formula_edge.put("XC", "U2 R E' R' U R E R' U ");
        formula_edge.put("XD", "S R E' R' U' R E R' U S' ");
        formula_edge.put("XE", "U R E' R' U2 R E R' U ");
        formula_edge.put("XF", "U' L U M' U' L' U M ");
        formula_edge.put("XG", "R E' R' U' R E R' U ");
        formula_edge.put("XH", "l U M' U2 M U l' ");
        formula_edge.put("XI", "F E' L2 E L2 F' ");
        formula_edge.put("XJ", "M2 U' L U M U' L' U M ");
        formula_edge.put("XK", "u L' E L2 E' L' u' ");
        formula_edge.put("XL", "z U' L E' L' U L E L' z' ");
        formula_edge.put("XM", "M U' L U M2 U' L' U M ");
        formula_edge.put("XN", "u' l' U' M' U2 M U' l u ");
        formula_edge.put("XO", "u' R' E R2 E' R' u ");
        formula_edge.put("XP", "x' R' U M' U2 M U R x ");
        formula_edge.put("XQ", "R2 E' R' U' R E R' U R' ");
        formula_edge.put("XR", "l' U' L' E' L2 E L' U l");
        formula_edge.put("XS", "E L' U L E' L' U' L ");
        formula_edge.put("XT", "r U L' S' L2 S L' U' r' ");
        formula_edge.put("XY", "E' R' U' R E R' U R ");
        formula_edge.put("XZ", "x' U M' U2 M U x ");

        formula_edge.put("YC", "(U'RURURU'R'U')R'");
        formula_edge.put("YD", "R' U' R U R' U' M' U R U' r' U R");
        formula_edge.put("YE", "R U S R2 S' R2 U' R' ");
        formula_edge.put("YF", "M U' R' U M' U' R U ");
        formula_edge.put("YG", "r' U M' U' R U M U' M' ");
        formula_edge.put("YH", "U r' U M' U2 M U r U' ");
        formula_edge.put("YI", "U R' U M' U2 M U R U' ");
        formula_edge.put("YJ", "M' U' R' U M U' R U ");
        formula_edge.put("YK", "U L' E L2 E' L' U' ");
        formula_edge.put("YL", "D M' U' R' U M U' R U D' ");
        formula_edge.put("YM", "M2 U' R' U M2 U' R U ");
        formula_edge.put("YN", "R' U M U M' U M U r ");
        formula_edge.put("YO", "U D' R' U M' U2 M U R D U' ");
        formula_edge.put("YP", "D' M' U' R' U M U' R U D ");
        formula_edge.put("YQ", "U R S R2 S' R U' ");
        formula_edge.put("YR", "R' U' R E R' U R E' ");
        formula_edge.put("YS", "R U' R E R2 E' R U R' ");
        formula_edge.put("YT", "R' U' R' E R U R' E' R2 ");
        formula_edge.put("YW", "R U' R' E' R2 E R' U R' ");
        formula_edge.put("YX", "R' U' R E' R' U R E ");


        formula_edge.put("ZC", "L' E L U L' E' L U' ");
        formula_edge.put("ZD", "r' U' M' U2 M U' r ");
        formula_edge.put("ZE", "U' L' E L U2 L' E' L U' ");
        formula_edge.put("ZF", "U R' U' M' U R U' M ");
        formula_edge.put("ZG", "U2 L' E L U' L' E' L U' ");
        formula_edge.put("ZH", "S' L' E L U L' E' L U' S ");
        formula_edge.put("ZI", "F' E R2 E' R2 F ");
        formula_edge.put("ZJ", "M2 U R' U' M U R U' M ");
        formula_edge.put("ZK", "u L E' L2 E L u' ");
        formula_edge.put("ZL", "x' L U' M' U2 M U' L' x ");
        formula_edge.put("ZM", "M U R' U' M2 U R U' M ");
        formula_edge.put("ZN", "u r U M' U2 M U r' u' ");
        formula_edge.put("ZO", "u' R E' R2 E R u ");
        formula_edge.put("ZP", "z' U R' E R U' R' E' R z ");
        formula_edge.put("ZQ", "E' R U' R' E R U R' ");
        formula_edge.put("ZR", "l' U' R S R2 S' R U l ");
        formula_edge.put("ZS", "L2 E L U L' E' L U' L ");
        formula_edge.put("ZT", "r U R E R2 E' R U' r'");
        formula_edge.put("ZW", "E L U L' E' L U' L' ");
        formula_edge.put("ZX", "x' U' M' U2 M U' x ");
    }

    public static void initDic(){
        dic.put("AA","夹子 【形】");
        dic.put("AB","安倍晋三（首相）");
        dic.put("AC","AC米兰（球队）");
        dic.put("AD","AD钙奶（哇哈哈）");
        dic.put("AE","AE86 （汽车）");
        dic.put("AF","Africa（非洲长颈鹿）");
        dic.put("AG","爱国者（充电宝）");
        dic.put("AH","阿虎 （有翅膀的白虎）");
        dic.put("AI","AI (人工智能机器人)");
        dic.put("AJ","按键（游戏台杆及按键）");
        dic.put("AK","AK47");
        dic.put("AL","阿狸");
        dic.put("AW","AW338 (狙击枪)");
        dic.put("AM","爱玛（电瓶车）");
        dic.put("AN","拉链【形】");
        dic.put("AO","奥特曼【音】");
        dic.put("AP","Apple（被咬了一口的苹果）");
        dic.put("AQ","暗器（手里剑）");
        dic.put("AR","矮人火枪手（DOTA人物）");
        dic.put("AS","傲速（四阶魔方）");
        dic.put("AT","ATM (自动提款机)");
        dic.put("AX","爱心【音】");
        dic.put("AY","奥运（火炬）");
        dic.put("AZ","艾滋（红丝带）");

        dic.put("BA","靶【音】");
        dic.put("BB","眼镜【形】");
        dic.put("BC","菠菜（大力水手）");
        dic.put("BD","板凳【音】");
        dic.put("BE","bee（蜜蜂）");
        dic.put("BF","蝙蝠【音】");
        dic.put("BG","饼干【音】");
        dic.put("BH","壁虎【音】");
        dic.put("BI","笔【音】");
        dic.put("BJ","北京（天安门）");
        dic.put("BK","贝壳【音】");
        dic.put("BL","菠萝【音】");
        dic.put("BW","保卫（萝卜）");
        dic.put("BM","白马【音】");
        dic.put("BN","白牛（DOTA人物）");
        dic.put("BO","博士帽【音】");
        dic.put("BP","鞭炮【音】");
        dic.put("BQ","棒球【音】");
        dic.put("BR","bra(胸罩)");
        dic.put("BS","宝石【音】");
        dic.put("BT","鼻涕【音】");
        dic.put("BX","宝箱【音】");
        dic.put("BY","白云【音】");
        dic.put("BZ","鼻子【音】");


        dic.put("CA","擦(黑板擦)");
        dic.put("CB","茶杯");
        dic.put("CC","头箍[形]");
        dic.put("CD","菜刀");
        dic.put("CE","biCyclE （自行车）");
        dic.put("CF","穿越火线(拿着铲子)");
        dic.put("CG","唇膏");
        dic.put("CH","Chuan船");
        dic.put("CI","刺");
        dic.put("CJ","茶几");
        dic.put("CK","仓库(集装箱)");
        dic.put("CL","车轮(轮胎)");
        dic.put("CW","刺猬");
        dic.put("CM","草莓");
        dic.put("CN","菜鸟(愤怒的小鸟)");
        dic.put("CO","手铐[形]");
        dic.put("CP","钞票");
        dic.put("CQ","彩旗");
        dic.put("CR","超人");
        dic.put("CS","反恐精英(拿着手枪)");
        dic.put("CT","CT机(医用设备)");
        dic.put("CX","潮汐猎人(DOTA人物)");
        dic.put("CY","苍蝇");
        dic.put("CZ","锤子");



        dic.put("DA","打针（注射器）");
        dic.put("DB","大便");
        dic.put("DC","电池");
        dic.put("DD","扶手拉环【形】");
        dic.put("DE","戴尔（笔记本电脑）");
        dic.put("DF","敌法（DOTA人物）");
        dic.put("DG","蛋糕");
        dic.put("DH","电话");
        dic.put("DI","笛子");
        dic.put("DJ","Disc Jockey（打碟工作者）");
        dic.put("DK","短裤");
        dic.put("DL","地雷");
        dic.put("DW","端午（粽子）");
        dic.put("DM","大米（米饭）");
        dic.put("DN","deng灯【音】");
        dic.put("DO","哆啦A梦（机器猫）");
        dic.put("DP","刀片");
        dic.put("DQ","地球（地球仪）");
        dic.put("DR","电人（拳皇人物 二阶堂红丸）");
        dic.put("DS","电视");
        dic.put("DT","电筒");
        dic.put("DX","大象");
        dic.put("DY","钓鱼（钓竿）");
        dic.put("DZ","电钻");




        dic.put("EA","EAsports FIFA (足球)");
        dic.put("EB","erB(2B铅笔)");
        dic.put("EC","耳垂（释迦摩尼）");
        dic.put("ED","二档（变速器）");
        dic.put("EE","视力表【形】");
        dic.put("EF","窗户【形】");
        dic.put("EG","二锅（红星二锅头）");
        dic.put("EH","耳环");
        dic.put("EI","钉耙【形】");
        dic.put("EJ","耳机");
        dic.put("EK","E扣（衣扣）");
        dic.put("EL","饿狼（灰太狼）");
        dic.put("EW","二万（麻将）");
        dic.put("EM","鹅毛");
        dic.put("EN","cheng秤【音】");
        dic.put("EO","鹅蛋【音】");
        dic.put("EP","磁带（小专辑）【捆绑】");
        dic.put("EQ","恶犬");
        dic.put("ER","二人（二人转）");
        dic.put("ES","耳勺");
        dic.put("ET","ET(外星人)");
        dic.put("EX","Exit(安全出口标志)");
        dic.put("EY","鳄鱼");
        dic.put("EZ","鹅掌");


        dic.put("FA","发（头发）");
        dic.put("FB","粉笔");
        dic.put("FC","风车");
        dic.put("FD","飞碟");
        dic.put("FE","飞蛾");
        dic.put("FF","大显支架【形】");
        dic.put("FG","发箍（悟空的紧箍）");
        dic.put("FH","凤凰");
        dic.put("FI","Fire(灭火器)");
        dic.put("FJ","飞机");
        dic.put("FK","F-U-C-K（双节棍）【捆绑】");
        dic.put("FL","风铃");
        dic.put("FW","房屋");
        dic.put("FM","阀门");
        dic.put("FN","蜂鸟");
        dic.put("FO","佛（功德佛：唐僧）");
        dic.put("FP","飞盘");
        dic.put("FQ","风琴");
        dic.put("FR","芙蓉（梦幻西游 芙蓉仙子）");
        dic.put("FS","风扇");
        dic.put("FT","斧头");
        dic.put("FX","方向（方向盘）");
        dic.put("FY","防御（防爆盾）");
        dic.put("FZ","风筝");


        dic.put("GA","gai盖（锅盖）");
        dic.put("GB","钢镚（硬币）");
        dic.put("GC","锅铲");
        dic.put("GD","轨道（铁轨）");
        dic.put("GE","ge割（锯子“割”东西）");
        dic.put("GF","功夫（会功夫的人）");
        dic.put("GG","挡车石【形】");
        dic.put("GH","骨灰（骨灰盒）");
        dic.put("GI","光I（光剑，激光剑）【音+形】");
        dic.put("GJ","公交（公交车）");
        dic.put("GK","钢盔（头盔）");
        dic.put("GL","锅炉（太上老君炼丹炉）");
        dic.put("GW","狗屋（猫和老鼠里的狗屋）");
        dic.put("GM","古墓（墓碑）");
        dic.put("GN","弓弩(弓箭)");
        dic.put("GO","gou钩（钩子）【音】");
        dic.put("GP","光盘");
        dic.put("GQ","钢琴");
        dic.put("GR","缸R（缸人，浴缸）【音+形+意】");
        dic.put("GS","怪兽");
        dic.put("GT","骨头");
        dic.put("GX","狗熊");
        dic.put("GY","观音");
        dic.put("GZ","甘蔗");


        dic.put("HA","蛤（蛤蟆文太）");
        dic.put("HB","寒冰【拳皇 冰女】");
        dic.put("HC","火车");
        dic.put("HD","蝴蝶");
        dic.put("HE","鹤【音】");
        dic.put("HF","横幅");
        dic.put("HG","黄瓜");
        dic.put("HH","跨栏【形】");
        dic.put("HI","海【音】");
        dic.put("HJ","红椒");
        dic.put("HK","Hongkong（迪士尼米老鼠）【捆绑】");
        dic.put("HL","葫芦");
        dic.put("HW","护腕");
        dic.put("HM","悍马");
        dic.put("HN","红牛(饮料)");
        dic.put("HO","海O（海马）【音+形】");
        dic.put("HP","花瓶");
        dic.put("HQ","红旗");
        dic.put("HR","火人（拳皇 草稚京）");
        dic.put("HS","护士");
        dic.put("HT","核桃");
        dic.put("HX","河蟹");
        dic.put("HY","火影（初代火影）");
        dic.put("HZ","猴子");


        dic.put("IA","埃菲尔铁塔【形】");
        dic.put("IB","订书机【形】");
        dic.put("IC","电话亭（IC电话卡）【捆绑】");
        dic.put("ID","ID卡（身份证）");
        dic.put("IE","拖把【形】");
        dic.put("IF","锄头【形】");
        dic.put("IG","iG（战队）");
        dic.put("IH","扁担【形】");
        dic.put("II","筷子【形】");
        dic.put("IJ","伞【形】");
        dic.put("IK","色架带（啥东西？）【形】");
        dic.put("IL","编钟（长得像么？）【捆绑】");
        dic.put("IW","iWatch(手表)");
        dic.put("IM","yIng魔（影魔）【音】");
        dic.put("IN","Ink（墨水）");
        dic.put("IO","高尔夫【形】");
        dic.put("IP","IP地址（路由器）【捆绑】");
        dic.put("IQ","吸管【形】");
        dic.put("IR"," I人（\"竖\"人，DOTA大树）【捆绑】");
        dic.put("IS","拐杖（I是拐杖，S是驼背老人）【形】");
        dic.put("IT","钉子【形】");
        dic.put("IX","折叠小板凳【形】");
        dic.put("IY","弹弓【形】");
        dic.put("IZ","超级玛丽（I是人，Z是弹簧）【捆绑】");


        dic.put("JA","jia（枷锁）【捆绑】");
        dic.put("JB","金币（一大袋金币）");
        dic.put("JC","鸡翅");
        dic.put("JD"," 剪刀");
        dic.put("JE","面具【捆绑】");
        dic.put("JF","飓风（龙卷风）");
        dic.put("JG","胶管（胶头滴管）");
        dic.put("JH","菊花");
        dic.put("JI","吉（如意、中国结）【捆绑】");
        dic.put("JJ","伞把【形】");
        dic.put("JK","监控（摄像头）");
        dic.put("JL","金龙");
        dic.put("JW","九尾（火影忍者 九尾）");
        dic.put("JM","鸡毛（鸡毛掸子）");
        dic.put("JN","胶囊");
        dic.put("JO","jio（脚、DOTA假腿）【捆绑】");
        dic.put("JP","键盘");
        dic.put("JQ","金枪（枪矛）");
        dic.put("JR","巨人（DOTA山岭巨人）");
        dic.put("JS","剑圣（DOTA剑圣）");
        dic.put("JT","吉他");
        dic.put("JX","剑侠（梦幻西游 剑侠客）");
        dic.put("JY","加油（加油站油箱）");
        dic.put("JZ","饺子");

        dic.put("KA","卡、掐（僵尸掐脖子）【捆绑】");
        dic.put("KB","科比");
        dic.put("KC","卡车");
        dic.put("KD","砍刀");
        dic.put("KE","卡尔（DOTA人物）");
        dic.put("KF","KFC（全家桶）【捆绑】");
        dic.put("KG","开关（拉杆）");
        dic.put("KH","葵花");
        dic.put("KI","猕猴桃（英语单词么？）【捆绑】");
        dic.put("KJ","铠甲（铠甲勇士）");
        dic.put("KK","K（拳皇人物）");
        dic.put("KL","开路（压路机）");
        dic.put("KW","皮鞋（康王？有这牌子么？）【捆绑】");
        dic.put("KM","孔明（孔明灯）");
        dic.put("KN","放大镜（看你？）【捆绑】");
        dic.put("KO","拳击手套【捆绑】");
        dic.put("KP","开瓶（开瓶器）");
        dic.put("KQ","空气（空气呼吸机）");
        dic.put("KR","快人（博尔特）");
        dic.put("KS","开锁（锁）");
        dic.put("KT","KT板");
        dic.put("KX","烤箱（微波炉）");
        dic.put("KY","烤鸭");
        dic.put("KZ","口罩");


        dic.put("LA","喇叭【音】");
        dic.put("LB","蜡笔（蜡笔小新）");
        dic.put("LC","拉车（板车）");
        dic.put("LD","漏斗");
        dic.put("LE","LED屏");
        dic.put("LF","凉粉");
        dic.put("LG","龙宫（梦幻西游 龙太子）");
        dic.put("LH","轮滑（轮滑鞋）");
        dic.put("LI","锂（锂电池）");
        dic.put("LJ","垃圾（垃圾桶）");
        dic.put("LK","篮筐");
        dic.put("LL","L (死亡笔记主角)");
        dic.put("LW","老瓦（庄海燕）");
        dic.put("LM","流氓（流氓兔）");
        dic.put("LN","老牛（DOTA 撼地神牛）");
        dic.put("LO","锣");
        dic.put("LP","礼炮");
        dic.put("LQ","刘谦（魔术师）");
        dic.put("LR","鹿茸");
        dic.put("LS","螺丝（螺丝刀）");
        dic.put("LT","龙头（水龙头）");
        dic.put("LX","凉席");
        dic.put("LY","轮椅");
        dic.put("LZ","蜡烛");







        dic.put("WA","娃（娃娃、婴儿）【音】");
        dic.put("WB","卫兵");
        dic.put("WC","water closet(大便池)【捆绑】");
        dic.put("WD","豌豆（豌豆射手）【捆绑】");
        dic.put("WE","维维（豆奶）【捆绑】");
        dic.put("WF","汪峰");
        dic.put("WG","乌龟（龟丞相）");
        dic.put("WH","武汉（黄鹤楼）【捆绑】");
        dic.put("WI","windows(win95界面)【捆绑】");
        dic.put("WJ","围巾");
        dic.put("WK","悟空");
        dic.put("WL","涡轮");
        dic.put("WW","折叠帐篷【形】");
        dic.put("WM","五魔");
        dic.put("WN","蜗牛");
        dic.put("WO","窝窝头【音】");
        dic.put("WP","瓦片");
        dic.put("WQ","武器（倚天剑）【捆绑】");
        dic.put("WR","五仁（切糕？沙琪玛）【捆绑】");
        dic.put("WS","卫生（卫生纸）【捆绑】");
        dic.put("WT","挖土（挖掘机）【捆绑】");
        dic.put("WX","蚊香");
        dic.put("WY","乌鸦");
        dic.put("WZ","五庄（五庄观人参果）【捆绑】");


        dic.put("MA","妈（妈妈再打我一次）");
        dic.put("MB","面包");
        dic.put("MC","Mic（麦克风）");
        dic.put("MD","牡丹");
        dic.put("ME","木耳");
        dic.put("MF","米粉");
        dic.put("MG","蘑菇");
        dic.put("MH","棉花（棉花糖）");
        dic.put("MI","MI小米（手机）");
        dic.put("MJ","Michael Jackson");
        dic.put("MK","梅肯（DOTA物品）");
        dic.put("ML","麻辣（麻辣烫、火锅）");
        dic.put("MW","魔王（梦幻西游 巨魔王）");
        dic.put("MM","麦当劳（小丑）");
        dic.put("MN","蒙牛（奶牛）");
        dic.put("MO","墨（砚台、烟灰缸）【捆绑】");
        dic.put("MP","MP3(U盘) 【捆绑】");
        dic.put("MQ","煤气（液化气罐）");
        dic.put("MR","鸣人（火影忍者 漩涡鸣人）");
        dic.put("MS","蟒蛇（火影忍者 大蛇丸）");
        dic.put("MT","馒头");
        dic.put("MX","毛线（毛线团）");
        dic.put("MY","蚂蚁");
        dic.put("MZ","帽子（鸭舌帽）");


        dic.put("NA","NANA（动漫人物）");
        dic.put("NB","尿布（尿不湿）");
        dic.put("NC","奶茶");
        dic.put("ND","牛顿（定滑轮）【捆绑】");
        dic.put("NE","near？(和领带有关系么？)【捆绑】");
        dic.put("NF","农夫（农夫山泉）");
        dic.put("NG","南瓜（万圣节）");
        dic.put("NH","暖壶（热水壶）");
        dic.put("NI","Nie（镊子）【音】");
        dic.put("NJ","牛角");
        dic.put("NK","Nike(nike Logo)");
        dic.put("NL","年轮（树桩）");
        dic.put("NW","女巫（骑扫把的女巫）");
        dic.put("NM","喇嘛（LM是流氓兔，NM就用喇嘛）【捆绑】");
        dic.put("NN","(N形字母饼干)【形】");
        dic.put("NO","no(不，不倒翁)【捆绑】");
        dic.put("NP","NPC（梦幻西游NPC：罗道人）【捆绑】");
        dic.put("NQ","泥鳅（沙泥鳅、沙和尚）【捆绑】");
        dic.put("NR","泥人");
        dic.put("NS","磁铁（N极\\S极）【意】");
        dic.put("NT","牛头（梦幻西游 牛头）");
        dic.put("NX","高跟鞋（N是高跟，X是鞋）【形+音】");
        dic.put("NY","鲶鱼");
        dic.put("NZ","闹钟");


        dic.put("OA","定时炸弹（O是表，A是炸弹）【形】");
        dic.put("OB","实况无线电广播（扩音器）【捆绑】");
        dic.put("OC","耳罩（O是人头，C是耳罩）【形】");
        dic.put("OD","容量瓶【形】");
        dic.put("OE","梳子（O是人头，E是数字）【形】");
        dic.put("OF","单反（O读作\"dan\"）【音】");
        dic.put("OG","欧哥（欧弟的哥哥、大胡子）【捆绑】");
        dic.put("OH","藕荷（荷叶）");
        dic.put("OI","气球（O是气球，I是线）【形】");
        dic.put("OJ","蛋卷（冰淇淋）【音】");
        dic.put("OK","OK绷（创可贴）");
        dic.put("OL","奥利奥【音】");
        dic.put("OW","owl(猫头鹰)");
        dic.put("OM","奥巴马【音】");
        dic.put("ON","onion(洋葱)");
        dic.put("OO","救生圈【形】");
        dic.put("OP","藕片");
        dic.put("OQ","望远镜【形】");
        dic.put("OR","orange(橙子)");
        dic.put("OS","S形挂钩(O是圆管横截面)【形】");
        dic.put("OT","蛋挞【音】");
        dic.put("OX","弹匣");
        dic.put("OY","陷阱（O是井，Y是人伸出两只手）【形】");
        dic.put("OZ","弹珠【音】");


        dic.put("PA","幻影刺客（DOTA人物）");
        dic.put("PB","皮鞭");
        dic.put("PC","泡菜（泡菜坛）");
        dic.put("PD","皮带(腰带)");
        dic.put("PE","泡儿（吹泡泡）【音】");
        dic.put("PF","屏风");
        dic.put("PG","屁股（嘿嘿）");
        dic.put("PH","PH试纸");
        dic.put("PI","Pig（猪）");
        dic.put("PJ","普京（他会开飞机）");
        dic.put("PK","扑克");
        dic.put("PL","漂流（皮划艇）");
        dic.put("PW","破碗");
        dic.put("PM","泡面（口味自选）");
        dic.put("PN","ping乒（乒乓球拍）【音】");
        dic.put("PO","婆（老婆婆）");
        dic.put("PP","哨子【形】");
        dic.put("PQ","喷泉");
        dic.put("PR","飘柔（duang!）");
        dic.put("PS","盘丝（蜘蛛网）");
        dic.put("PT","葡萄");
        dic.put("PX","皮箱（拉杆行李箱）");
        dic.put("PY","蒲英（蒲公英）");
        dic.put("PZ","盆子");


        dic.put("QA","qia洽（洽洽香瓜子）");
        dic.put("QB","乔巴（海贼王人物）");
        dic.put("QC","芹菜");
        dic.put("QD","青岛（青岛啤酒）");
        dic.put("QE","企鹅【音】");
        dic.put("QF","Qiao(拼音编码)【捆绑】");
        dic.put("QG","曲棍（四驱车）【捆绑】");
        dic.put("QH","清华（清华园）");
        dic.put("QI","Qiaoqiaoban(跷跷板)【音】");
        dic.put("QJ","青椒（肥大的青椒）");
        dic.put("QK","昆卡（DOTA船长）【音】");
        dic.put("QL","千里（葫芦娃千里眼）");
        dic.put("QW","青蛙(不是蛤蟆)");
        dic.put("QM","球门");
        dic.put("QN","气囊（洗耳球）【捆绑】");
        dic.put("QO","热气球（Q是上面大气球，O是下面小篮子）【形】");
        dic.put("QP","青苹（青苹果，绿色的没被咬过的）");
        dic.put("QQ","旺仔QQ糖【音】");
        dic.put("QR","青R（青铜鼎，R是鼎）【音+形】");
        dic.put("QS","翘舌（舌头）");
        dic.put("QT","气筒");
        dic.put("QX","球鞋（不是皮鞋和拖鞋）");
        dic.put("QY","蚯蚓");
        dic.put("QZ","裙子");


        dic.put("RA","宣纸（可能因为RB是毛笔）【捆绑】");
        dic.put("RB","绒笔（毛绒绒的笔，毛笔）【捆绑】");
        dic.put("RC","肉串");
        dic.put("RD","肉盾（DOTA刚背兽）");
        dic.put("RE","热（热水器喷头）【音】");
        dic.put("RF","燃放（燃放烟花）");
        dic.put("RG","热狗");
        dic.put("RH","润滑（小丸油）");
        dic.put("RI","日（太阳）【音】");
        dic.put("RJ","肉机（绞肉机）");
        dic.put("RK","热快（热得快）");
        dic.put("RL","肉瘤（太恶心还是换石榴把）【捆绑】");
        dic.put("RW","肉丸(撒尿牛丸)");
        dic.put("RM","燃煤（蜂窝煤）");
        dic.put("RN","RaiN(雨)【音】");
        dic.put("RO","rou肉（腊肉）【音】");
        dic.put("RP","人品（遇到神打乱，人品爆发，拍计时器）【捆绑】");
        dic.put("RQ","日期（日历）");
        dic.put("RR","Rocket(火箭)【音】");
        dic.put("RS","瑞兽（梦幻西游 古代瑞兽）");
        dic.put("RT","人头");
        dic.put("RX","热血（热血物语格斗游戏）");
        dic.put("RY","任意?（橡皮筋可以任意形变？）【捆绑】");
        dic.put("RZ","忍者【火影忍者 卡卡西】");

        dic.put("SA","隐形刺客（DOTA人物）");
        dic.put("SB","鼠标");
        dic.put("SC","四川（大熊猫）【捆绑】");
        dic.put("SD","SD卡（储存卡）");
        dic.put("SE","涩（手撕鱿鱼+芥末）【捆绑】");
        dic.put("SF","沙发");
        dic.put("SG","试管");
        dic.put("SH","死后（棺材）【捆绑】");
        dic.put("SI","SIO2二氧化硅（玻璃主要成分）【捆绑】");
        dic.put("SJ","时间（钟表）【捆绑】");
        dic.put("SK","沙王（DOTA人物）");
        dic.put("SL","森林（很多树木）");
        dic.put("SW","丝袜");
        dic.put("SM","烧卖");
        dic.put("SN","索尼（游戏人物：索尼克）");
        dic.put("SO","soap（肥皂，捡肥皂？）");
        dic.put("SP","算盘");
        dic.put("SQ","山丘（山）");
        dic.put("SR","SpideR (蜘蛛侠)");
        dic.put("SS","超人的内裤【形】");
        dic.put("ST","水桶（饮水机上的）");
        dic.put("SX","水下（潜水艇）【捆绑】");
        dic.put("SY","山羊（喜羊羊）【捆绑】");
        dic.put("SZ","扇子");


        dic.put("TA","塔（金字塔）");
        dic.put("TB","铁饼（掷铁饼者）");
        dic.put("TC","拖车（小拖车，不是板车）");
        dic.put("TD","台灯");
        dic.put("TE","大显Tel");
        dic.put("TF","屠夫（DOTA人物）");
        dic.put("TG","铜管");
        dic.put("TH","弹簧");
        dic.put("TI","梯（梯子）");
        dic.put("TJ","太监");
        dic.put("TK","坦克");
        dic.put("TL","螳螂");
        dic.put("TW","铁网");
        dic.put("TM","Tom(猫和老鼠Tom)");
        dic.put("TN","鸵鸟");
        dic.put("TO","TOTO\\toilet（TOTO小便池，不是WC）【捆绑】");
        dic.put("TP","天蓬（猪八戒）");
        dic.put("TQ","台球");
        dic.put("TR","土壤");
        dic.put("TS","铁丝");
        dic.put("TT","十字架【形】");
        dic.put("TX","拖鞋");
        dic.put("TY","涂鸦（涂鸦工具）");
        dic.put("TZ","听诊（听诊器）");

        dic.put("XA","袜夹盘（X是盘，A是夹子）【形】");
        dic.put("XB","线板（插线板，插排）");
        dic.put("XC","铁钳【形】");
        dic.put("XD","鞋垫");
        dic.put("XE","星儿（派大星）【捆绑】");
        dic.put("XF","修复（用扳手修复）【捆绑】");
        dic.put("XG","西瓜");
        dic.put("XH","鲜花");
        dic.put("XI","竹蜻蜓【形】");
        dic.put("XJ","香蕉");
        dic.put("XK","胸口（胸骨）");
        dic.put("XL","项链");
        dic.put("XW","显微（显微镜）");
        dic.put("XM","虾米（梦幻西游 虾兵）");
        dic.put("XN","犀牛");
        dic.put("XO","白兰地");
        dic.put("XP","橡皮");
        dic.put("XQ","象棋");
        dic.put("XR","仙人（仙人掌）");
        dic.put("XS","小鼠");
        dic.put("XT","袖套");
        dic.put("XX","禁停标志牌【形】");
        dic.put("XY","香烟");
        dic.put("XZ","先知（DOTA人物）");

        dic.put("YA","牙【音】");
        dic.put("YB","元宝");
        dic.put("YC","烟囱（不是牙齿）");
        dic.put("YD","烟斗");
        dic.put("YE","叶【音】");
        dic.put("YF","衣服（T恤）【捆绑】");
        dic.put("YG","牙膏（不是圆规）");
        dic.put("YH","圆滑（圆规）【捆绑】");
        dic.put("YI","衣架（Y是杆子，I是线，Y撑起衣架，挂在I上）【捆绑】");
        dic.put("YJ","泳镜");
        dic.put("YK","遥控（手柄）【捆绑】");
        dic.put("YL","哑铃");
        dic.put("YW","渔网(如图所示的网)");
        dic.put("YM","羽毛（羽毛球）【捆绑】");
        dic.put("YN","印泥（印章）【捆绑】");
        dic.put("YO","悠悠球【音或形】");
        dic.put("YP","邮票（信封）【捆绑】");
        dic.put("YQ","牙签");
        dic.put("YR","鱼人（DOTA大鱼人）");
        dic.put("YS","钥匙");
        dic.put("YT","油条");
        dic.put("YX","音响");
        dic.put("YY","树杈【形】");
        dic.put("YZ","眼罩");

        dic.put("ZA","杂（杂志）【捆绑】");
        dic.put("ZB","嘴巴");
        dic.put("ZC","直尺");
        dic.put("ZD","字典");
        dic.put("ZE","啫（啫喱水）【捆绑】");
        dic.put("ZF","中锋（姚明）【捆绑】");
        dic.put("ZG","诸葛");
        dic.put("ZH","纸盒（抽纸）");
        dic.put("ZI","Zippo（打火机）");
        dic.put("ZJ","子姜");
        dic.put("ZK","钟馗（捉鬼的）");
        dic.put("ZL","知了");
        dic.put("ZW","猪尾");
        dic.put("ZM","芝麻(芝麻糊)【捆绑】");
        dic.put("ZN","指南（指南针，勺子）【捆绑】");
        dic.put("ZO","座（座椅）【捆绑】");
        dic.put("ZP","帐篷");
        dic.put("ZQ","中秋（月亮）【捆绑】");
        dic.put("ZR","钟乳（钟乳石）");
        dic.put("ZS","宙斯（DOTA人物）");
        dic.put("ZT","枕头");
        dic.put("ZX","纸箱");
        dic.put("ZY","章鱼");
        dic.put("ZZ","Zorro(佐罗)【音】");



    }

    public static void initPic(){
        pic.put("AA", R.drawable.a);
        pic.put("AB",R.drawable.ab);
        pic.put("AC",R.drawable.ac);
        pic.put("AD",R.drawable.ad);
        pic.put("AE",R.drawable.ae);
        pic.put("AF",R.drawable.af);
        pic.put("AG",R.drawable.ag);
        pic.put("AH",R.drawable.ah);
        pic.put("AI",R.drawable.ai);
        pic.put("AW",R.drawable.aw);
        pic.put("AM",R.drawable.am);
        pic.put("AN",R.drawable.an);
        pic.put("AO",R.drawable.ao);
        pic.put("AP",R.drawable.ap);
        pic.put("AQ",R.drawable.aq);
        pic.put("AR",R.drawable.ar);
        pic.put("AS",R.drawable.as);
        pic.put("AT",R.drawable.at);
        pic.put("AX",R.drawable.ax);
        pic.put("AY",R.drawable.ay);
        pic.put("AZ",R.drawable.az);
        pic.put("AJ",R.drawable.aj);
        pic.put("AK",R.drawable.ak);
        pic.put("AL",R.drawable.al);




        pic.put("BA",R.drawable.ba);
        pic.put("BB",R.drawable.b);
        pic.put("BC",R.drawable.bc);
        pic.put("BD",R.drawable.bd);
        pic.put("BE",R.drawable.be);
        pic.put("BF",R.drawable.bf);
        pic.put("BG",R.drawable.bg);
        pic.put("BH",R.drawable.bh);
        pic.put("BI",R.drawable.bi);
        pic.put("BW",R.drawable.bw);
        pic.put("BM",R.drawable.bm);
        pic.put("BN",R.drawable.bn);
        pic.put("BO",R.drawable.bo);
        pic.put("BP",R.drawable.bp);
        pic.put("BQ",R.drawable.bq);
        pic.put("BR",R.drawable.br);
        pic.put("BS",R.drawable.bs);
        pic.put("BT",R.drawable.bt);
        pic.put("BX",R.drawable.bx);
        pic.put("BY",R.drawable.by);
        pic.put("BZ",R.drawable.bz);
        pic.put("BJ",R.drawable.bj);
        pic.put("BK",R.drawable.bk);
        pic.put("BL",R.drawable.bl);


        pic.put("CA",R.drawable.ca);
        pic.put("CB",R.drawable.cb);
        pic.put("CC",R.drawable.c);
        pic.put("CD",R.drawable.cd);
        pic.put("CE",R.drawable.ce);
        pic.put("CF",R.drawable.cf);
        pic.put("CG",R.drawable.cg);
        pic.put("CH",R.drawable.ch);
        pic.put("CI",R.drawable.ci);
        pic.put("CW",R.drawable.cw);
        pic.put("CM",R.drawable.cm);
        pic.put("CN",R.drawable.cn);
        pic.put("CO",R.drawable.co);
        pic.put("CP",R.drawable.cp);
        pic.put("CQ",R.drawable.cq);
        pic.put("CR",R.drawable.cr);
        pic.put("CS",R.drawable.cs);
        pic.put("CT",R.drawable.ct);
        pic.put("CX",R.drawable.cx);
        pic.put("CY",R.drawable.cy);
        pic.put("CZ",R.drawable.cz);
        pic.put("CJ",R.drawable.cj);
        pic.put("CK",R.drawable.ck);
        pic.put("CL",R.drawable.cl);


        pic.put("DA",R.drawable.da);
        pic.put("DB",R.drawable.db);
        pic.put("DC",R.drawable.dc);
        pic.put("DD",R.drawable.d);
        pic.put("DE",R.drawable.de);
        pic.put("DF",R.drawable.df);
        pic.put("DG",R.drawable.dg);
        pic.put("DH",R.drawable.dh);
        pic.put("DI",R.drawable.di);
        pic.put("DW",R.drawable.dw);
        pic.put("DM",R.drawable.dm);
        pic.put("DN",R.drawable.dn);
        pic.put("DO",R.drawable.do1);
        pic.put("DP",R.drawable.dp);
        pic.put("DQ",R.drawable.dq);
        pic.put("DR",R.drawable.dr);
        pic.put("DS",R.drawable.ds);
        pic.put("DT",R.drawable.dt);
        pic.put("DX",R.drawable.dx);
        pic.put("DY",R.drawable.dy);
        pic.put("DZ",R.drawable.dz);
        pic.put("DJ",R.drawable.dj);
        pic.put("DK",R.drawable.dk);
        pic.put("DL",R.drawable.dl);



        pic.put("EA",R.drawable.ea);
        pic.put("EB",R.drawable.eb);
        pic.put("EC",R.drawable.ec);
        pic.put("ED",R.drawable.ed);
        pic.put("EE",R.drawable.e);
        pic.put("EF",R.drawable.ef);
        pic.put("EG",R.drawable.eg);
        pic.put("EH",R.drawable.eh);
        pic.put("EI",R.drawable.ei);
        pic.put("EW",R.drawable.ew);
        pic.put("EM",R.drawable.em);
        pic.put("EN",R.drawable.en);
        pic.put("EO",R.drawable.eo);
        pic.put("EP",R.drawable.ep);
        pic.put("EQ",R.drawable.eq);
        pic.put("ER",R.drawable.er);
        pic.put("ES",R.drawable.es);
        pic.put("ET",R.drawable.et);
        pic.put("EX",R.drawable.ex);
        pic.put("EY",R.drawable.ey);
        pic.put("EZ",R.drawable.ez);
        pic.put("EJ",R.drawable.ej);
        pic.put("EK",R.drawable.ek);
        pic.put("EL",R.drawable.el);


        pic.put("FA",R.drawable.fa);
        pic.put("FB",R.drawable.fb);
        pic.put("FC",R.drawable.fc);
        pic.put("FD",R.drawable.fd);
        pic.put("FE",R.drawable.fe);
        pic.put("FF",R.drawable.f);
        pic.put("FG",R.drawable.fg);
        pic.put("FH",R.drawable.fh);
        pic.put("FI",R.drawable.fi);
        pic.put("FW",R.drawable.fw);
        pic.put("FM",R.drawable.fm);
        pic.put("FN",R.drawable.fn);
        pic.put("FO",R.drawable.fo);
        pic.put("FP",R.drawable.fp);
        pic.put("FQ",R.drawable.fq);
        pic.put("FR",R.drawable.fr);
        pic.put("FS",R.drawable.fs);
        pic.put("FT",R.drawable.ft);
        pic.put("FX",R.drawable.fx);
        pic.put("FY",R.drawable.fy);
        pic.put("FZ",R.drawable.fz);
        pic.put("FJ",R.drawable.fj);
        pic.put("FK",R.drawable.fk);
        pic.put("FL",R.drawable.fl);





        pic.put("GA",R.drawable.ga);
        pic.put("GB",R.drawable.gb);
        pic.put("GC",R.drawable.gc);
        pic.put("GD",R.drawable.gd);
        pic.put("GE",R.drawable.ge);
        pic.put("GF",R.drawable.gf);
        pic.put("GG",R.drawable.g);
        pic.put("GH",R.drawable.gh);
        pic.put("GI",R.drawable.gi);
        pic.put("GW",R.drawable.gw);
        pic.put("GM",R.drawable.gm);
        pic.put("GN",R.drawable.gn);
        pic.put("GO",R.drawable.go);
        pic.put("GP",R.drawable.gp);
        pic.put("GQ",R.drawable.gq);
        pic.put("GR",R.drawable.gr);
        pic.put("GS",R.drawable.gs);
        pic.put("GT",R.drawable.gt);
        pic.put("GX",R.drawable.gx);
        pic.put("GY",R.drawable.gy);
        pic.put("GZ",R.drawable.gz);
        pic.put("GJ",R.drawable.gj);
        pic.put("GK",R.drawable.gk);
        pic.put("GL",R.drawable.gl);




        pic.put("HA",R.drawable.ha);
        pic.put("HB",R.drawable.hb);
        pic.put("HC",R.drawable.hc);
        pic.put("HD",R.drawable.hd);
        pic.put("HE",R.drawable.he);
        pic.put("HF",R.drawable.hf);
        pic.put("HG",R.drawable.hg);
        pic.put("HH",R.drawable.h);
        pic.put("HI",R.drawable.hi);
        pic.put("HW",R.drawable.hw);
        pic.put("HM",R.drawable.hm);
        pic.put("HN",R.drawable.hn);
        pic.put("HO",R.drawable.ho);
        pic.put("HP",R.drawable.hp);
        pic.put("HQ",R.drawable.hq);
        pic.put("HR",R.drawable.hr);
        pic.put("HS",R.drawable.hs);
        pic.put("HT",R.drawable.ht);
        pic.put("HX",R.drawable.hx);
        pic.put("HY",R.drawable.hy);
        pic.put("HZ",R.drawable.hz);
        pic.put("HJ",R.drawable.hj);
        pic.put("HK",R.drawable.hk);
        pic.put("HL",R.drawable.hl);




        pic.put("IA",R.drawable.ia);
        pic.put("IB",R.drawable.ib);
        pic.put("IC",R.drawable.ic);
        pic.put("ID",R.drawable.id);
        pic.put("IE",R.drawable.ie);
        pic.put("IF",R.drawable.if1);
        pic.put("IG",R.drawable.ig);
        pic.put("IH",R.drawable.ih);
        pic.put("II",R.drawable.i);
        pic.put("IW",R.drawable.iw);
        pic.put("IM",R.drawable.im);
        pic.put("IN",R.drawable.in);
        pic.put("IO",R.drawable.io);
        pic.put("IP",R.drawable.ip);
        pic.put("IQ",R.drawable.iq);
        pic.put("IR",R.drawable.ir);
        pic.put("IS",R.drawable.is);
        pic.put("IT",R.drawable.it);
        pic.put("IX",R.drawable.ix);
        pic.put("IY",R.drawable.iy);
        pic.put("IZ",R.drawable.iz);
        pic.put("IJ",R.drawable.ij);
        pic.put("IK",R.drawable.ik);
        pic.put("IL",R.drawable.il);




        pic.put("JA",R.drawable.ja);
        pic.put("JB",R.drawable.jb);
        pic.put("JC",R.drawable.jc);
        pic.put("JD",R.drawable.jd);
        pic.put("JE",R.drawable.je);
        pic.put("JF",R.drawable.jf);
        pic.put("JG",R.drawable.jg);
        pic.put("JH",R.drawable.jh);
        pic.put("JI",R.drawable.ji);
        pic.put("JW",R.drawable.jw);
        pic.put("JM",R.drawable.jm);
        pic.put("JN",R.drawable.jn);
        pic.put("JO",R.drawable.jo);
        pic.put("JP",R.drawable.jp);
        pic.put("JQ",R.drawable.jq);
        pic.put("JR",R.drawable.jr);
        pic.put("JS",R.drawable.js);
        pic.put("JT",R.drawable.jt);
        pic.put("JX",R.drawable.jx);
        pic.put("JY",R.drawable.jy);
        pic.put("JZ",R.drawable.jz);
        pic.put("JJ",R.drawable.j);
        pic.put("JK",R.drawable.jk);
        pic.put("JL",R.drawable.jl);



        pic.put("KA",R.drawable.ka);
        pic.put("KB",R.drawable.kb);
        pic.put("KC",R.drawable.kc);
        pic.put("KD",R.drawable.kd);
        pic.put("KE",R.drawable.ke);
        pic.put("KF",R.drawable.kf);
        pic.put("KG",R.drawable.kg);
        pic.put("KH",R.drawable.kh);
        pic.put("KI",R.drawable.ki);
        pic.put("KW",R.drawable.kw);
        pic.put("KM",R.drawable.km);
        pic.put("KN",R.drawable.kn);
        pic.put("KO",R.drawable.ko);
        pic.put("KP",R.drawable.kp);
        pic.put("KQ",R.drawable.kq);
        pic.put("KR",R.drawable.kr);
        pic.put("KS",R.drawable.ks);
        pic.put("KT",R.drawable.kt);
        pic.put("KX",R.drawable.kx);
        pic.put("KY",R.drawable.ky);
        pic.put("KZ",R.drawable.kz);
        pic.put("KJ",R.drawable.kj);
        pic.put("KK",R.drawable.k);
        pic.put("KL",R.drawable.kl);


        pic.put("LA",R.drawable.la);
        pic.put("LB",R.drawable.lb);
        pic.put("LC",R.drawable.lc);
        pic.put("LD",R.drawable.ld);
        pic.put("LE",R.drawable.le);
        pic.put("LF",R.drawable.lf);
        pic.put("LG",R.drawable.lg);
        pic.put("LH",R.drawable.lh);
        pic.put("LI",R.drawable.li);
        pic.put("LW",R.drawable.lw);
        pic.put("LM",R.drawable.lm);
        pic.put("LN",R.drawable.ln);
        pic.put("LO",R.drawable.lo);
        pic.put("LP",R.drawable.lp);
        pic.put("LQ",R.drawable.lq);
        pic.put("LR",R.drawable.lr);
        pic.put("LS",R.drawable.ls);
        pic.put("LT",R.drawable.lt);
        pic.put("LX",R.drawable.lx);
        pic.put("LY",R.drawable.ly);
        pic.put("LZ",R.drawable.lz);
        pic.put("LJ",R.drawable.lj);
        pic.put("LK",R.drawable.lk);
        pic.put("LL",R.drawable.l);






        pic.put("WA",R.drawable.wa);
        pic.put("WB",R.drawable.wb);
        pic.put("WC",R.drawable.wc);
        pic.put("WD",R.drawable.wd);
        pic.put("WE",R.drawable.we);
        pic.put("WF",R.drawable.wf);
        pic.put("WG",R.drawable.wg);
        pic.put("WH",R.drawable.wh);
        pic.put("WI",R.drawable.wi);
        pic.put("WW",R.drawable.w);
        pic.put("WM",R.drawable.wm);
        pic.put("WN",R.drawable.wn);
        pic.put("WO",R.drawable.wo);
        pic.put("WP",R.drawable.wp);
        pic.put("WQ",R.drawable.wq);
        pic.put("WR",R.drawable.wr);
        pic.put("WS",R.drawable.ws);
        pic.put("WT",R.drawable.wt);
        pic.put("WX",R.drawable.wx);
        pic.put("WY",R.drawable.wy);
        pic.put("WZ",R.drawable.wz);
        pic.put("WJ",R.drawable.wj);
        pic.put("WK",R.drawable.wk);
        pic.put("WL",R.drawable.wl);


        pic.put("MA",R.drawable.ma);
        pic.put("MB",R.drawable.mb);
        pic.put("MC",R.drawable.mc);
        pic.put("MD",R.drawable.md);
        pic.put("ME",R.drawable.me);
        pic.put("MF",R.drawable.mf);
        pic.put("MG",R.drawable.mg);
        pic.put("MH",R.drawable.mh);
        pic.put("MI",R.drawable.mi);
        pic.put("MW",R.drawable.mw);
        pic.put("MM",R.drawable.m);
        pic.put("MN",R.drawable.mn);
        pic.put("MO",R.drawable.mo);
        pic.put("MP",R.drawable.mp);
        pic.put("MQ",R.drawable.mq);
        pic.put("MR",R.drawable.mr);
        pic.put("MS",R.drawable.ms);
        pic.put("MT",R.drawable.mt);
        pic.put("MX",R.drawable.mx);
        pic.put("MY",R.drawable.my);
        pic.put("MZ",R.drawable.mz);
        pic.put("MJ",R.drawable.mj);
        pic.put("MK",R.drawable.mk);
        pic.put("ML",R.drawable.ml);


        pic.put("NA",R.drawable.na);
        pic.put("NB",R.drawable.nb);
        pic.put("NC",R.drawable.nc);
        pic.put("ND",R.drawable.nd);
        pic.put("NE",R.drawable.ne);
        pic.put("NF",R.drawable.nf);
        pic.put("NG",R.drawable.ng);
        pic.put("NH",R.drawable.nh);
        pic.put("NI",R.drawable.ni);
        pic.put("NW",R.drawable.nw);
        pic.put("NM",R.drawable.nm);
        pic.put("NN",R.drawable.n);
        pic.put("NO",R.drawable.no);
        pic.put("NP",R.drawable.np);
        pic.put("NQ",R.drawable.nq);
        pic.put("NR",R.drawable.nr);
        pic.put("NS",R.drawable.ns);
        pic.put("NT",R.drawable.nt);
        pic.put("NX",R.drawable.nx);
        pic.put("NY",R.drawable.ny);
        pic.put("NZ",R.drawable.nz);
        pic.put("NJ",R.drawable.nj);
        pic.put("NK",R.drawable.nk);
        pic.put("NL",R.drawable.nl);





        pic.put("OA",R.drawable.oa);
        pic.put("OB",R.drawable.ob);
        pic.put("OC",R.drawable.oc);
        pic.put("OD",R.drawable.od);
        pic.put("OE",R.drawable.oe);
        pic.put("OF",R.drawable.of);
        pic.put("OG",R.drawable.og);
        pic.put("OH",R.drawable.oh);
        pic.put("OI",R.drawable.oi);
        pic.put("OW",R.drawable.ow);
        pic.put("OM",R.drawable.om);
        pic.put("ON",R.drawable.on);
        pic.put("OO",R.drawable.o);
        pic.put("OP",R.drawable.op);
        pic.put("OQ",R.drawable.oq);
        pic.put("OR",R.drawable.or);
        pic.put("OS",R.drawable.os);
        pic.put("OT",R.drawable.ot);
        pic.put("OX",R.drawable.ox);
        pic.put("OY",R.drawable.oy);
        pic.put("OZ",R.drawable.oz);
        pic.put("OJ",R.drawable.oj);
        pic.put("OK",R.drawable.ok);
        pic.put("OL",R.drawable.ol);





        pic.put("PA",R.drawable.pa);
        pic.put("PB",R.drawable.pb);
        pic.put("PC",R.drawable.pc);
        pic.put("PD",R.drawable.pd);
        pic.put("PE",R.drawable.pe);
        pic.put("PF",R.drawable.pf);
        pic.put("PG",R.drawable.pg);
        pic.put("PH",R.drawable.ph);
        pic.put("PI",R.drawable.pi);
        pic.put("PW",R.drawable.pw);
        pic.put("PM",R.drawable.pm);
        pic.put("PN",R.drawable.pn);
        pic.put("PO",R.drawable.po);
        pic.put("PP",R.drawable.p);
        pic.put("PQ",R.drawable.pq);
        pic.put("PR",R.drawable.pr);
        pic.put("PS",R.drawable.ps);
        pic.put("PT",R.drawable.pt);
        pic.put("PX",R.drawable.px);
        pic.put("PY",R.drawable.py);
        pic.put("PZ",R.drawable.pz);
        pic.put("PJ",R.drawable.pj);
        pic.put("PK",R.drawable.pk);
        pic.put("PL",R.drawable.pl);




        pic.put("QA",R.drawable.qa);
        pic.put("QB",R.drawable.qb);
        pic.put("QC",R.drawable.qc);
        pic.put("QD",R.drawable.qd);
        pic.put("QE",R.drawable.qe);
        pic.put("QF",R.drawable.qf);
        pic.put("QG",R.drawable.qg);
        pic.put("QH",R.drawable.qh);
        pic.put("QI",R.drawable.qi);
        pic.put("QW",R.drawable.qw);
        pic.put("QM",R.drawable.qm);
        pic.put("QN",R.drawable.qn);
        pic.put("QO",R.drawable.qo);
        pic.put("QP",R.drawable.qp);
        pic.put("QQ",R.drawable.q);
        pic.put("QR",R.drawable.qr);
        pic.put("QS",R.drawable.qs);
        pic.put("QT",R.drawable.qt);
        pic.put("QX",R.drawable.qx);
        pic.put("QY",R.drawable.qy);
        pic.put("QZ",R.drawable.qz);
        pic.put("QJ",R.drawable.qj);
        pic.put("QK",R.drawable.qk);
        pic.put("QL",R.drawable.ql);




        pic.put("RA",R.drawable.ra);
        pic.put("RB",R.drawable.rb);
        pic.put("RC",R.drawable.rc);
        pic.put("RD",R.drawable.rd);
        pic.put("RE",R.drawable.re);
        pic.put("RF",R.drawable.rf);
        pic.put("RG",R.drawable.rg);
        pic.put("RH",R.drawable.rh);
        pic.put("RI",R.drawable.ri);
        pic.put("RW",R.drawable.rw);
        pic.put("RM",R.drawable.rm);
        pic.put("RN",R.drawable.rn);
        pic.put("RO",R.drawable.ro);
        pic.put("RP",R.drawable.rp);
        pic.put("RQ",R.drawable.rq);
        pic.put("RR",R.drawable.r);
        pic.put("RS",R.drawable.rs);
        pic.put("RT",R.drawable.rt);
        pic.put("RX",R.drawable.rx);
        pic.put("RY",R.drawable.ry);
        pic.put("RZ",R.drawable.rz);
        pic.put("RJ",R.drawable.rj);
        pic.put("RK",R.drawable.rk);
        pic.put("RL",R.drawable.rl);




        pic.put("SA",R.drawable.sa);
        pic.put("SB",R.drawable.sb);
        pic.put("SC",R.drawable.sc);
        pic.put("SD",R.drawable.sd);
        pic.put("SE",R.drawable.se);
        pic.put("SF",R.drawable.sf);
        pic.put("SG",R.drawable.sg);
        pic.put("SH",R.drawable.sh);
        pic.put("SI",R.drawable.si);
        pic.put("SW",R.drawable.sw);
        pic.put("SM",R.drawable.sm);
        pic.put("SN",R.drawable.sn);
        pic.put("SO",R.drawable.so);
        pic.put("SP",R.drawable.sp);
        pic.put("SQ",R.drawable.sq);
        pic.put("SR",R.drawable.sr);
        pic.put("SS",R.drawable.s);
        pic.put("ST",R.drawable.st);
        pic.put("SX",R.drawable.sx);
        pic.put("SY",R.drawable.sy);
        pic.put("SZ",R.drawable.sz);
        pic.put("SJ",R.drawable.sj);
        pic.put("SK",R.drawable.sk);
        pic.put("SL",R.drawable.sl);


        pic.put("TA",R.drawable.ta);
        pic.put("TB",R.drawable.tb);
        pic.put("TC",R.drawable.tc);
        pic.put("TD",R.drawable.td);
        pic.put("TE",R.drawable.te);
        pic.put("TF",R.drawable.tf);
        pic.put("TG",R.drawable.tg);
        pic.put("TH",R.drawable.th);
        pic.put("TI",R.drawable.ti);
        pic.put("TW",R.drawable.tw);
        pic.put("TM",R.drawable.tm);
        pic.put("TN",R.drawable.tn);
        pic.put("TO",R.drawable.to);
        pic.put("TP",R.drawable.tp);
        pic.put("TQ",R.drawable.tq);
        pic.put("TR",R.drawable.tr);
        pic.put("TS",R.drawable.ts);
        pic.put("TT",R.drawable.t);
        pic.put("TX",R.drawable.tx);
        pic.put("TY",R.drawable.ty);
        pic.put("TZ",R.drawable.tz);
        pic.put("TJ",R.drawable.tj);
        pic.put("TK",R.drawable.tk);
        pic.put("TL",R.drawable.tl);




        pic.put("XA",R.drawable.xa);
        pic.put("XB",R.drawable.xb);
        pic.put("XC",R.drawable.xc);
        pic.put("XD",R.drawable.xd);
        pic.put("XE",R.drawable.xe);
        pic.put("XF",R.drawable.xf);
        pic.put("XG",R.drawable.xg);
        pic.put("XH",R.drawable.xh);
        pic.put("XI",R.drawable.xi);
        pic.put("XW",R.drawable.xw);
        pic.put("XM",R.drawable.xm);
        pic.put("XN",R.drawable.xn);
        pic.put("XO",R.drawable.xo);
        pic.put("XP",R.drawable.xp);
        pic.put("XQ",R.drawable.xq);
        pic.put("XR",R.drawable.xr);
        pic.put("XS",R.drawable.xs);
        pic.put("XT",R.drawable.xt);
        pic.put("XX",R.drawable.x);
        pic.put("XY",R.drawable.xy);
        pic.put("XZ",R.drawable.xz);
        pic.put("XJ",R.drawable.xj);
        pic.put("XK",R.drawable.xk);
        pic.put("XL",R.drawable.xl);

        pic.put("YA",R.drawable.ya);
        pic.put("YB",R.drawable.yb);
        pic.put("YC",R.drawable.yc);
        pic.put("YD",R.drawable.yd);
        pic.put("YE",R.drawable.ye);
        pic.put("YF",R.drawable.yf);
        pic.put("YG",R.drawable.yg);
        pic.put("YH",R.drawable.yh);
        pic.put("YI",R.drawable.yi);
        pic.put("YW",R.drawable.yw);
        pic.put("YM",R.drawable.ym);
        pic.put("YN",R.drawable.yn);
        pic.put("YO",R.drawable.yo);
        pic.put("YP",R.drawable.yp);
        pic.put("YQ",R.drawable.yq);
        pic.put("YR",R.drawable.yr);
        pic.put("YS",R.drawable.ys);
        pic.put("YT",R.drawable.yt);
        pic.put("YX",R.drawable.yx);
        pic.put("YY",R.drawable.y);
        pic.put("YZ",R.drawable.yz);
        pic.put("YJ",R.drawable.yj);
        pic.put("YK",R.drawable.yk);
        pic.put("YL",R.drawable.yl);

        pic.put("ZA",R.drawable.za);
        pic.put("ZB",R.drawable.zb);
        pic.put("ZC",R.drawable.zc);
        pic.put("ZD",R.drawable.zd);
        pic.put("ZE",R.drawable.ze);
        pic.put("ZF",R.drawable.zf);
        pic.put("ZG",R.drawable.zg);
        pic.put("ZH",R.drawable.zh);
        pic.put("ZI",R.drawable.zi);
        pic.put("ZW",R.drawable.zw);
        pic.put("ZM",R.drawable.zm);
        pic.put("ZN",R.drawable.zn);
        pic.put("ZO",R.drawable.zo);
        pic.put("ZP",R.drawable.zp);
        pic.put("ZQ",R.drawable.zq);
        pic.put("ZR",R.drawable.zr);
        pic.put("ZS",R.drawable.zs);
        pic.put("ZT",R.drawable.zt);
        pic.put("ZX",R.drawable.zx);
        pic.put("ZY",R.drawable.zy);
        pic.put("ZZ",R.drawable.z);

        pic.put("ZJ",R.drawable.zj);
        pic.put("ZK",R.drawable.zk);
        pic.put("ZL",R.drawable.zl);



    }
}
