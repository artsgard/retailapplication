package com.artsgard.retailapplication.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TestCommonConstants {

    //public static final int RAND = Integer.MAX_VALUE;
    public static final int RAND = 1000;

    //COMPANY
    public final static String COMP_NAME_1 = "test-comp-name-1";
    public final static String COMP_NAME_2 = "test-comp-name-2";
    public final static String COMP_NAME_3 = "test-comp-name-3";
    public final static String COMP_REF_1 = "test-comp-ref-111";
    public final static String COMP_REF_2 = "test-comp-ref-222";
    public final static String COMP_REF_3 = "test-comp-ref-333";
    public final static String COMP_DESCR_1 = "test-comp-descr1";
    public final static String COMP_DESCR_2 = "test-comp-descr2";
    public final static String COMP_DESCR_3 = "test-comp-descr3";

    public final static List<String> COMPANY_LIST = new ArrayList() {{
        add("test-comp-ref-111");
        add("test-comp-ref-222");
        add("test-comp-ref-333");
    }};

    //USER
    public final static String PURCHASE_REF_1 = "test-purchase-ref-" + new Random().nextInt(RAND);
    public final static String PURCHASE_REF_2 = "test-purchase-ref-" + new Random().nextInt(RAND);
    public final static String PURCHASE_REF_3 = "test-purchase-ref-" + new Random().nextInt(RAND);
    public final static String COMPANY_LITERAL_UPDATE = "test-literalCompany-update" + new Random().nextInt(RAND);

    public final static String USERNAME_1 = "test-username1";
    public final static String USERNAME_2 = "test-username2";
    public final static String USERNAME_3 = "test-username3";
    public final static String USERNAME_UPDATE = "test-username-update";

    public final static String PASSWORD_1 = "test-password1";
    public final static String PASSWORD_2 = "test-password1";
    public final static String PASSWORD_3 = "test-password1";
    public final static String PASSWORD_UPDATE = "test-password-update";

    public final static String FIRST_NAME_1 = "test-firstName1";
    public final static String FIRST_NAME_2 = "test-firstName2";
    public final static String FIRST_NAME_3 = "test-firstName3";
    public final static String FIRST_NAME_UPDATE = "test-firstName-update";

    public final static String LAST_NAME_1 = "test-lastName1";
    public final static String LAST_NAME_2 = "test-lastName2";
    public final static String LAST_NAME_3 = "test-lastName3";
    public final static String LAST_NAME_UPDATE = "test-lastName-update";

    public final static Boolean ACTIVE_1 = true;
    public final static Boolean ACTIVE_2 = true;
    public final static Boolean ACTIVE_3 = true;
    public final static Boolean ACTIVE_UPDATE = true;

    public final static String EMAIL_1= "test@email1.com";
    public final static String EMAIL_2 = "test@email2.com";
    public final static String EMAIL_3 = "test@email3.com";
    public final static String EMAIL_UPDATE = "test@emailupdate.com";

    //PRODUCT
    public final static String NAME_1 = "test-name1";
    public final static String NAME_2 = "test-name2";
    public final static String NAME_3 = "test-name3";
    public final static String NAME_UPDATE = "test-name-update";

    public final static String PRODUCT_REF_1 = "test-product-ref-111";
    public final static String PRODUCT_REF_2 = "test-product-ref-222";
    public final static String PRODUCT_REF_3 = "test-product-ref-333";
    public final static String PRODUCT_REF_UPDATE = "test-product-ref-777";

    public final static String BEER_TYPE_1 = "PILS";
    public final static String BEER_TYPE_2 = "HELLES";
    public final static String BEER_TYPE_3 = "STARKBIER";
    public final static String BEER_TYPE_UPDATE = "ALTBIER";

    public final static String DESCRIPTION_1 = "test-description1";
    public final static String DESCRIPTION_2 = "test-description2";
    public final static String DESCRIPTION_3 = "test-description3";
    public final static String DESCRIPTION_UPDATE = "test-description-update";

    public final static boolean PROMOTION_1 = true;
    public final static boolean PROMOTION_2 = true;
    public final static boolean PROMOTION_3 = true;
    public final static boolean PROMOTION_UPDATE = false;

    public final static BigDecimal PRICE_1 =  new BigDecimal("11.00");
    public final static BigDecimal PRICE_2 =  new BigDecimal("11.00");
    public final static BigDecimal PRICE_3 =  new BigDecimal("11.00");
    public final static BigDecimal PRICE_UPDATE =  new BigDecimal("77.00");

    public final static String GRADUATION_1 = "test-graduation1";
    public final static String GRADUATION_2 = "test-graduation2";
    public final static String GRADUATION_3 = "test-graduation3";
    public final static String GRADUATION_UPDATE = "test-graduation-update";

    public final static String NATIONALITY_1 = "test-nationality1";
    public final static String NATIONALITY_2 = "test-nationality1";
    public final static String NATIONALITY_3 = "test-nationality1";
    public final static String NATIONALITY_UPDATE = "test-nationality-update";

    public final static List<String> PRODUCT_LIST = new ArrayList() {{
        add("test-product-ref-111");
        add("test-product-ref-222");
        add("test-product-ref-333");
    }};

}
