package ru.ak.app.resourses;

public final class Resourse {

    private Resourse(){}

    //=====================================================URL's=======================================================================
    public static final String HOME_PAGE_URL = "https://www.wrike.com/";

    public static final String RESEND_PAGE_URL = "https://www.wrike.com/resend/";

    public static final String TWITTER_URL = "https://twitter.com/wrike";

    public static final String TWITTER_ICON_URL = "/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v1#twitter";


    //=====================================================SELECTORS===================================================================
    /**Xpath*/
    public static final String BTN_GET_STARTED_FOR_FREE = "/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button";

    /**Xpath*/
    public static final String FIELD_EMAIL = "//*[@id=\"modal-pro\"]/form/label[1]/input";

    /**Xpath*/
    public static final String BTN_CREATE_ACCOUNT = "//*[@id=\"modal-pro\"]/form/label[2]/button";

    /**Xpath*/
    public static final String GOOGLE_DIALOG = "/html/body/div[6]";

    /**Xpath*/
    public static final String BTN_NO_IN_GOOGLE_FRAME = "/html/body/c-wiz/div/div/div[2]/div[4]/span[1]/div";

    /**Xpath*/
    public static final String BTN_YES_IN_GOOGLE_FRAME = "/html/body/c-wiz/div/div/div[2]/div[4]/span[2]/div";

    /**className*/
    public static final String SWITCH_BUTTON = "switch__button";

    /**Xpath*/
    public static final String FIELD_OTHER = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[3]/button/span/input";

    /**Xpath*/
    public static final String BTN_SUBMIT_ANSWERS = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button";

    /**Xpath*/
    public static final String SURVEY_SUCCESS = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/div";

    /**Xpath*/
    public static final String BTN_RESEND_EMAIL = "/html/body/div[1]/main/div/div/div[2]/div/div[1]/p[3]/button";

    /**className*/
    public static final String WG_FOOTER_SOCIAL_LIST = "wg-footer__social-list";

    /**Xpath*/
    public static final String BTN_TWITTER_PATH = ".//*[@href=\"https://twitter.com/wrike\"]";

    /**tagName*/
    public static final String TAG_USE = "use";

    /**attributeName*/
    public static final String ATTRIBUTE_HREF = "href";

    /**attributeName*/
    public static final String ATTRIBUTE_XLINK_HREF = "xlink:href";

    //======================================================Email_mask=================================================================
    public static final String EMAIL_MASK = "+wpt@wriketask.qaa";



    //======================================================Random_Text(Java SE insrumentation)========================================
    private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String randomText(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }


    //=====================================================JavaScript==================================================================
    public static final String  SCRIPT_SCROLL = "scroll(0,800)";


}
