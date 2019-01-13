package com.dchealth.healthcard.vo;

import java.io.Serializable;

public class BussinessCode implements Serializable {

    /**
     * 健康卡注册
     */
    public static String CARD_REGIST="RHC_E0001";

    /**
     * 二维码申请
     */
    public static String QCODE_APPLY="RHC_E0002";

    /**
     * 二维码验证
     */
    public static String QCODE_CHECK = "RHC_E0003";


    /**
     * 二维码注销
     */
    public static String CARD_UNREGIST="RHC_E0004";

    /**
     * 二维码查询
     */
    public static String QCODE_SEARCH="RHC_E0005";

    /**
     * 二维码注册，现场认证
     */
    public static String CARD_REGIST_CONFIRM= "RHC_E0006";

    /**
     * 健康卡绑定 （家庭成员）
     */
    public static String CARD_BINDING_FOR_FAMILLY="RHC_E0007";

    /**
     * 解除 （家庭成员）
     */
    public static String CARD_UNBINDING_FOR_FAMILLY="RHC_E0008";
    /**
     * 用卡记录
     */
    public static String CARD_USE_RECORD="RHC_E0009";

    /**
     * 健康卡成员查询
     */
    public static String CARD_FAMILLY_SEARCH="RHC_E0010";
    /***
     * 健康卡修改
     */
    public static String CARD_MODIFY="RHC_E0011";
    /**
     * 临时健康卡申请
     */
    public static String TEMP_CARD_APPLY="RHC_E0012";
    /**
     * 临时健康卡验证
     */
    public static String TEMP_CARD_CHECK="RHC_E0013";
    public static String TEMP_CARD_BINDING="RHC_E0014";
    /**
     * 获取新生儿
     */
    public static String GET_NEWBORN="RHC_E0015";

    /***
     * 新生儿健康注册
     */
    public static String CARD_REGIST_FOR_NEWBORN="RHC_E0016";

    /**
     * 机构健康注册
     */
    public static String ORG_CARD_NUM_SEARCH="RHC_E0017";



}
