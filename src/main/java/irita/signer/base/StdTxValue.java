package irita.signer.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StdTxValue {
    private String memo;

    @JSONField(name="msg")
    @SerializedName("msg")
    private Message[] msgs;

    private Fee fee;

    private List<Signature> signatures;

    public Message[] getMsgs() {
        return msgs;
    }

    public void setMsgs(Message[] msgs) {
        this.msgs = msgs;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public Fee getFee() {
        return fee;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<Signature> signatures) {
        this.signatures = signatures;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public static StdTxValue fromJson(String json) {
        return JSON.parseObject(json, StdTxValue.class);
    }
}
