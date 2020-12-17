package irita.signer.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = true)
public class SignDoc {
    @JSONField(name="account_number")
    @SerializedName("account_number")
    private String accountNumber;

    private String sequence;

    @JSONField(name="chain_id")
    @SerializedName("chain_id")
    private String chainID;

    private Fee fee;
    private String memo;
    private Message[] msgs;

    public SignDoc() {
    }

    public SignDoc(String accountNumber, String sequence, String chainID, Fee fee, String memo, Message[] msgs) {
        this.accountNumber = accountNumber;
        this.sequence = sequence;
        this.chainID = chainID;
        this.fee = fee;
        this.memo = memo;
        this.msgs = msgs;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getChainID() {
        return chainID;
    }

    public void setChainID(String chainID) {
        this.chainID = chainID;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Message[] getMsgs() {
        return msgs;
    }

    public void setMsgs(Message[] msgs) {
        this.msgs = msgs;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("account_number", accountNumber)
            .append("chain_id", chainID)
            .append("fee", fee)
            .append("memo", memo)
            .append("msgs", msgs)
            .append("sequence", sequence)
            .toString();
    }

    public String toJson() {
        return JSON.toJSONString(this, SerializerFeature.SortField.MapSortField);
    }
}
