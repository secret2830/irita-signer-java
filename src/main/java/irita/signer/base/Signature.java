package irita.signer.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = true)
public class Signature {
    @JSONField(name="pub_key")
    @SerializedName("pub_key")
    private PubKey pubKey;

    private String signature;

    public Signature(PubKey pubKey, String signature) {
        this.pubKey = pubKey;
        this.signature = signature;
    }

    public PubKey getPubKey() {
        return pubKey;
    }

    public String getSignature() {
        return signature;
    }

    public void setPubKey(PubKey pubKey) {
        this.pubKey = pubKey;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("pub_key", pubKey)
            .append("signature", signature)
            .toString();
    }
}
