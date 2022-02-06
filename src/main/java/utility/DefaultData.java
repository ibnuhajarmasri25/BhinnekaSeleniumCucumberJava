package utility;

public class DefaultData {
    public static TestData testData = new TestData();

    public static void setTestData () throws Exception {
        //Setting getting url for conf.roperties
        testData.setUrl(ClassHelp.getEnv("url"));
        testData.setUsername(ClassHelp.getEnv("username"));
        testData.setPassword(ClassHelp.getEnv("password"));

    }
}
