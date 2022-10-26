package enums;

/**
 * With multiple environments this may come in handy. Specify base url for every environment. Environment is specified
 * in the command run, i.e. -Deut=dev
 */
public enum TestEnvironment {
  BASE_URL {
    @Override
    public String getUrl() {
      if (System.getProperty("eut") != null) {
        switch (System.getProperty("eut")) {
          case LOCAL:
            return "https://reqres.in";
          case DEVELOP:
            return "https://reqres.in";
          default:
            return "https://reqres.in";
        }
      } else {
        return "https://reqres.in";
      }
    }
  };

  public static final String LOCAL = "local";
  public static final String DEVELOP = "dev";

  public String getUrl() {
    return "";
  }
}
