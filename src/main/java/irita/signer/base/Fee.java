package irita.signer.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = true)
public class Fee {
    private List<Coin> amount;
    private String gas;

    public List<Coin> getAmount() {
        return amount;
    }

    public String getGas() {
        return gas;
    }

    public void setAmount(List<Coin> amount) {
        this.amount = amount;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("amount", amount)
            .append("gas", gas)
            .toString();
    }
}
