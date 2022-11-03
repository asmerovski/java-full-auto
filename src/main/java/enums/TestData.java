package enums;

import constants.ProjectConstants;

public enum TestData {

    REST_BASE_URL("https://dev.corehomeapi.com/", "https://qa.corehomeapi.com", "https://uat.corehomeapi.com", "https://staging.corehomeapi.com"),
    ENCRYPTED_KEY("ZKSvo5tiY2edq6qfXmRqm6g", "ZKSvo5tiY2edq6qfXmRqm6g", "ZKSvo5tiY2edq6qfXmRqm6g", "ZKSvo5tiY2edq6qfXmRqm6g"),
    EMAIL("ire.holp.qa+dev@gmail.com", "ire.holp.qa+qa@gmail.com", "ire.holp.qa+uat@gmail.com", "ire.holp.qa+stg@gmail.com");

    private final String dev;
    private final String qa;
    private final String uat;
    private final String staging;

    TestData(String dev, String qa, String uat, String staging) {
        this.dev = dev;
        this.qa = qa;
        this.uat = uat;
        this.staging = staging;
    }

    public String get() {
        if (System.getProperty("eut") != null) {
            switch (System.getProperty("eut")) {
                case ProjectConstants.DEVELOP:
                    return this.dev;
                case ProjectConstants.UAT:
                    return this.uat;
                case ProjectConstants.STAGING:
                    return this.staging;
                default:
                    return this.qa;
            }
        } else {
            return this.qa;
        }
    }
}
