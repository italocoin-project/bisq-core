package bisq.core.crypto;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.CertificateException;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.After;
import org.junit.Before;



import io.bisq.common.crypto.CryptoException;
import io.bisq.common.crypto.KeyRing;
import io.bisq.common.crypto.KeyStorage;
import io.bisq.common.storage.FileUtil;

public class EncryptionTest {
    private static final Logger log = LoggerFactory.getLogger(EncryptionTest.class);
    private KeyRing keyRing;
    private File dir;

    @Before
    public void setup() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, CryptoException {
        Security.addProvider(new BouncyCastleProvider());
        dir = File.createTempFile("temp_tests", "");
        //noinspection ResultOfMethodCallIgnored
        dir.delete();
        //noinspection ResultOfMethodCallIgnored
        dir.mkdir();
        KeyStorage keyStorage = new KeyStorage(dir);
        keyRing = new KeyRing(keyStorage);
    }

    @After
    public void tearDown() throws IOException {
        FileUtil.deleteDirectory(dir);
    }


}

