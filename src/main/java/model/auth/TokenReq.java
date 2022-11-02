package model.auth;

import enums.TestData;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenReq {

    public String key;

    public static TokenReq tokenPayload() {
        return TokenReq.builder()
                .key(TestData.ENCRYPTED_KEY.get())
                .build();
    }
}
