package irita.signer;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;

public class SignerTest 
{
    @Test
    public void testSigner()
    {
        try {
            String unsignedTx = IOUtils.toString(this.getClass().getResourceAsStream("/TestUnsignedTx.json"), "utf-8");
            
            String chainID = "irita";
            String accountNumber = "10";
            String sequence = "5";

            String privKey = "12345678abcdef12345678abcdef12345678abcdef12345678abcdef12345678";
            String signedTx = Signer.signTx(unsignedTx, chainID, accountNumber, sequence, privKey);
        
            System.out.println(signedTx);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
