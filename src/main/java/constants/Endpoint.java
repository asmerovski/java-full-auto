package constants;

public class Endpoint {

  public static final String USERS = "/api/users";

  public static String USER_BY_ID(int id) {
    return USERS + "/" + id;
  }
}
