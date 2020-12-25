package irita.signer.base;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = true)
public class StdTx {
    private String type;
    private StdTxValue value;

    public StdTx() {
    }

    public StdTx(String type, StdTxValue value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setValue(StdTxValue value) {
        this.value = value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public StdTxValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("type", type)
            .append("value", value)
            .toString();
    }

    public static StdTx fromJson(String json) {
        return JSON.parseObject(json, StdTx.class);
    }
}
