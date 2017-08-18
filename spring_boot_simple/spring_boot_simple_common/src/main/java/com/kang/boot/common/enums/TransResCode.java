package com.kang.boot.common.enums;

import com.google.common.base.Objects;
import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * User: healthy
 * Date: 14-5-5
 * Time: 上午4:24
 * 响应码枚举类
 */
public enum TransResCode {
    BGW_SUCCESS("BGW07000000","交易成功","SIM02000000","交易成功"),
    PGW_SUCCESS("PGW04000000", "成功","SIM02000000", "成功"),
    SUCCESS_CODE_PFS11000000("PFS11000000", "签约路由服务成功","SIM02000000","交易成功"),
    SUCCESS_CODE_CUM00000000("CUM09000000", "交易成功","SIM02000000","交易成功"),
    SUCCESS_CODE_PE00000000("PEC05000000","交易成功","PE00000000","交易成功"),
    SUCCESS_CODE_EBK00000000("EBK06000000","交易成功","SIM02000000","交易成功"),
    SUCCESS_CODE_CIF00000000("CIF30000000", "成功","SIM02000000", "成功"),
    SUCCESS_CODE_RSK00000000("RSK10000000", "成功","SIM02000000", "成功"),

    PFS_TIMEOUT_PFS11990002("PFS11990002", "服务超时","PFS11990002", "服务超时"),
    BGW_TIMEOUT_BGW078800002("BGW078800002", "支付网关返回参数为空，交易状态未明","BGW078800002", "支付网关返回参数为空，交易状态未明"),
    BGW_TIMEOUT_BGW079900003("BGW079900003", "系统异常,交易状态未明","BGW079900003", "系统异常,交易状态未明"),
    PGW_TIMEOUT_PGW04880001("PGW04880001", "交易处理中","PGW04880001", "交易处理中"),
    PEC_TIMEOUT_PEC05778999("PEC05778999", "交易处理中，请稍后查询！","PEC05778999", "交易处理中，请稍后查询！"),
    PEC_CALLBACK_PEC05668996("PEC05668996", "支付请求已受理,等待银行返回结果!","PEC05668996", "支付请求已受理,等待银行返回结果!"),
    PEC_AUDITREJECT_PEC05888019("PEC05888019", "交易审核拒绝!","PEC05888019", "交易审核拒绝!"),
    PEC_BIZRISKREJECT_PEC05888020("PEC05888020", "业务风控直接拒绝交易!","PEC05888020", "业务风控直接拒绝交易!"),
    PEC_AUDITAPPLY_CODE_PEC05888995("PEC05668995", "支付请求已受理,等待审核结果!","SIM02668995","支付请求已受理,等待审核结果!"),


    SUCCESS_CODE_SIM02000000("SIM02000000","交易成功","SIM02000000","交易成功"),

    RES_CODE_SIM02990001("SIM02990001", "系统繁忙","SIM02990001","系统繁忙"),
    RES_CODE_SIM02990002("SIM02990002", "交易失败[%s]","SIM02990002","交易失败[%s]"),
    RES_CODE_SIM02990003("SIM02990003", "交易超时","SIM02990003","交易超时"),
    RES_CODE_SIM02888019("SIM02888019", "交易审核拒绝!","SIM02888019", "交易审核拒绝!"),
    RES_CODE_SIM02880004("SIM02880004", "交易处理中","SIM02880004", "交易处理中"),
    RES_CODE_SIM02880001("SIM02880001", "请求参数校验失败[%s]","SIM02880001", "请求参数校验失败[%s]"),
    RES_CODE_SIM02880002("SIM02880002", "该签约信息已存在","SIM02880002", "该签约信息已存在"),
    RES_CODE_SIM02880003("SIM02880003", "该签约信息不存在","SIM02880003", "该签约信息不存在"),
    RES_CODE_SIM02880005("SIM02880005","数据库操作失败[%s]","SIM02880005","数据库操作失败[%s]"),
    RES_CODE_SIM02880006("SIM02880006","请核实请求信息[%s]","SIM02880006","请核实请求信息[%s]"),
    RES_CODE_SIM02880007("SIM02880007","签约银行卡信息不一致","SIM02880007","签约银行卡信息不一致"),

    RES_CODE_SIM02880008("SIM02880008","tokenId异常","SIM02880008","tokenId异常");


    private TransResCode(String channelResCode, String channelResDes, String resCode, String resDes){

        this.channelResCode = channelResCode;
        this.channelResDes = channelResDes;
        this.resCode = resCode;
        this.resDes = resDes;

    }

    /**
     * resCode  pe返回响应码
     */
    @Getter
    private String resCode;

    /**
     * resDes pe返回响应描述
     */
    @Getter
    private String resDes;

    /**
     * channelResCode 渠道响应码
     */
    @Getter
    private String channelResCode;

    /**
     * channelResDes 渠道响应描术
     */
    @Getter
    private String channelResDes;

    /**
     * 获取描述信息
     * @param resCode
     * @return
     */
    public static String explain(String resCode) {
        for (TransResCode transResCode : TransResCode.values()) {
            if (Objects.equal(resCode, transResCode.resCode)) {
                return transResCode.resDes;
            }
        }
        return resCode;
    }

    /**
     * 获取描述信息
     * @param channelResCode
     * @return
     */
    public static TransResCode explainBychannel(String channelResCode) {
        for (TransResCode transResCode : TransResCode.values()) {
            if (Objects.equal(channelResCode, transResCode.channelResCode)) {
                return transResCode;
            }
        }
        return null;
    }

    /**
     * 是否相等
     * @param channelResCode
     * @return 是否相等
     */
    public boolean isCodeEqual(String channelResCode) {
        return this.getChannelResCode().equals(channelResCode);
    }

}
