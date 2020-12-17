package irita.signer;

import irita.signer.base.TxBroadcast;
import irita.signer.base.PubKey;
import irita.signer.base.StdTx;
import irita.signer.base.Signature;
import irita.signer.base.SignDoc;
import irita.signer.crypto.SM2;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Base64;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Signer {
    private static final String PUBKEY_TYPE_SM2 = "cosmos/PubKeySm2";

    public static String signTx(String unsignedTx, String chainID, String accNumber, String sequence, String privateKey) throws CryptoException {
        StdTx tx = StdTx.fromJson(unsignedTx);
        SignDoc signDoc = new SignDoc(accNumber, sequence, chainID, tx.getValue().getFee(), tx.getValue().getMemo(), tx.getValue().getMsgs());
        
        System.out.println(signDoc.toJson());

        BigInteger privKey = new BigInteger(privateKey, 16);
        Signature signature = sign(privKey, signDoc.toJson().getBytes());
        
        List<Signature> signatures = new ArrayList<>();
            signatures.add(signature);
        tx.getValue().setSignatures(signatures);

        TxBroadcast broadcastTx = new TxBroadcast();
        broadcastTx.setMode("block");
        broadcastTx.setTx(tx);

        return broadcastTx.toJson();
    }

    private static Signature sign(BigInteger privKey, byte[] signBytes) throws CryptoException {
        byte[] signature = SM2.sign(privKey, signBytes);
        PubKey pk = new PubKey(PUBKEY_TYPE_SM2, Strings.fromByteArray(Base64.encode(SM2.getPubkeyFromPrivkey(privKey))));
        
        return new Signature(pk, Strings.fromByteArray(Base64.encode(signature)));
    }
}
