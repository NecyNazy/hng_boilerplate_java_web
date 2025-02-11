package hng_java_boilerplate.twofactor.service;

import dev.samstevens.totp.code.HashingAlgorithm;
import dev.samstevens.totp.exceptions.QrGenerationException;
import dev.samstevens.totp.qr.QrData;
import dev.samstevens.totp.qr.QrGenerator;
import dev.samstevens.totp.secret.SecretGenerator;
import dev.samstevens.totp.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TotpService {

    private final SecretGenerator secretGenerator;
    private final QrGenerator qrGenerator;

    public String generateSecretKey() {
        return secretGenerator.generate();
    }

    public String getQRCode(String secret) throws QrGenerationException {
        QrData qrData = new QrData.Builder().label("2FA")
                .issuer("2FA boilerplate")
                .secret(secret)
                .digits(6)
                .period(30)
                .algorithm(HashingAlgorithm.SHA512)
                .build();
        return Utils.getDataUriForImage(qrGenerator.generate(qrData), qrGenerator.getImageMimeType());
    }
}
