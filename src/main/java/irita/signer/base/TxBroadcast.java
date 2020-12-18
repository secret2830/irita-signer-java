package irita.signer.base;

import com.alibaba.fastjson.JSON;

public class TxBroadcast {
    private StdTxValue tx;
    private String mode;

    public TxBroadcast() {
    }

    public StdTxValue getTx() {
        return tx;
    }

    public void setTx(StdTxValue tx) {
        this.tx = tx;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }

    public static TxBroadcast fromJson(String json) {
        return JSON.parseObject(json, TxBroadcast.class);
    }
}
