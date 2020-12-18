package irita.signer;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;
import org.bitcoinj.crypto.ChildNumber;
import org.bitcoinj.crypto.DeterministicKey;
import org.bitcoinj.crypto.HDUtils;
import org.bitcoinj.wallet.DeterministicKeyChain;
import org.bitcoinj.wallet.DeterministicSeed;
import org.junit.Test;

import java.util.List;

public class SignerTest 
{
    @Test
    public void testSigner()
    {
        try {
            String unsignedTx = IOUtils.toString(this.getClass().getResourceAsStream("/TestUnsignedTx.json"), "utf-8");
            
            String chainID = "irita";
            String accountNumber = "6";
            String sequence = "0";

            String mnemonic = "gauge inquiry cage lecture box ceiling chimney permit radar innocent wood wrong input chronic gift almost note evidence stool parrot bridge uniform hockey orbit";
            
            DeterministicKey dk = generateDeterministicKey(mnemonic);
            String privKey = Hex.encodeHexString(dk.getPrivKeyBytes());

            String signedTx = Signer.signTx(unsignedTx, chainID, accountNumber, sequence, privKey);

            System.out.println(signedTx);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public DeterministicKey generateDeterministicKey(String mnemonic) throws Exception {
        String HD_PATH = "M/44H/118H/0H/0/0";
        DeterministicSeed seed = new DeterministicSeed(mnemonic, null, "", 0);

        DeterministicKeyChain chain = DeterministicKeyChain.builder().seed(seed).build();
        List<ChildNumber> keyPath = HDUtils.parsePath(HD_PATH);
        
        return chain.getKeyByPath(keyPath, true);
    }
}
