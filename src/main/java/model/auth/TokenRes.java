package model.auth;

import lombok.Data;
import model.UserData;
import model.UserSupport;

@Data
public class TokenRes {

  public String idToken;
  public Integer expiresIn;
}
