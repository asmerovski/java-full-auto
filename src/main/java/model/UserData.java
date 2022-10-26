package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserData {

  public Integer id;
  public String email;
  @JsonProperty("first_name")
  public String firstName;
  @JsonProperty("last_name")
  public String lastName;
  public String avatar;
}
