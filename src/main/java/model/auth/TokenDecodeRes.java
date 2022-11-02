package model.auth;

import lombok.Data;

@Data
public class TokenDecodeRes {

  public Integer accountId;
  public Integer userId;
  public Integer contactId;
}
