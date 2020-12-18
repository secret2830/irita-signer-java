package irita.signer.crypto;

import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.signers.DSAEncoding;
import org.bouncycastle.crypto.signers.StandardDSAEncoding;
import org.zz.gmhelper.BCECUtil;
import org.zz.gmhelper.SM2Util;

import java.io.IOException;
import java.math.BigInteger;

public class SM2 {
    public static byte[] getPubkeyFromPrivkey(BigInteger privkey) {
        ECPrivateKeyParameters privkeyParameters = BCECUtil.createECPrivateKeyParameters(privkey, SM2Util.DOMAIN_PARAMS);
        ECPublicKeyParameters pubkey = BCECUtil.buildECPublicKeyByPrivateKey(privkeyParameters);
        
        return pubkey.getQ().getEncoded(true);
    }

    public static byte[] sign(BigInteger privKey, byte[] signDoc) throws CryptoException {
        ECPrivateKeyParameters privKeyParameters = BCECUtil.createECPrivateKeyParameters(privKey, SM2Util.DOMAIN_PARAMS);
        return SM2Util.sign(privKeyParameters, "1234567812345678".getBytes(), signDoc);
    }

    public static BigInteger[] getRSFromSignature(byte[] signature) throws IOException {
        DSAEncoding encoding = new StandardDSAEncoding();
        return encoding.decode(SM2Util.DOMAIN_PARAMS.getN(), signature);
    }
}
