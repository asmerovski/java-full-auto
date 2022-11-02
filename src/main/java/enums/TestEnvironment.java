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
          case DEVELOP:
            return "https://dev.corehomeapi.com/";
          case UAT:
            return "https://uat.corehomeapi.com";
          case STAGING:
            return "https://staging.corehomeapi.com";
          default:
            return "https://qa.corehomeapi.com";
        }
      } else {
        return "https://qa.corehomeapi.com";
      }
    }

    public static final String DEVELOP = "dev";
    public static final String QA = "qa";
    public static final String UAT = "uat";
    public static final String STAGING = "staging";
  };


  public String getUrl() {
    return "";
  }
}
