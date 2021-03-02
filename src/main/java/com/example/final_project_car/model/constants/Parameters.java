package com.example.final_project_car.model.constants;

public class Parameters {

    /**
     * Parameters for DAO from database
     */


    /**
     * Accident parameters
     */
    public static final String ACCIDENT_ID = "accident_id";
    public static final String ACCIDENT_CATEGORY_ID = "accident_category_id";
    public static final String ACCIDENT_TIME = "accident_time";
    public static final String DESCRIPTION = "description";
    public static final String COST_PER_DAMAGE = "cost_per_damage";
    public static final String ACCIDENT_CATEGORY_NAME = "accident_category_name";

    /**
     * Car parameters
     */
    public static final String CAR_ID = "car_id";
    public static final String CAR_CATEGORY_ID = "car_category_id";
    public static final String BRAND_NAME = "brand_name";
    public static final String MODEL_NAME = "model_name";
    public static final String COLOR = "color";
    public static final String PRICE = "price";
    public static final String CAR_CATEGORY_NAME = "car_category_name";

    /**
     * Order parameters
     */
    public static final String ORDER_ID = "order_id";
    public static final String ORDER_STATUS_ID = "order_status_id";
    public static final String CREATE_DATE = "creation_date";
    public static final String WITH_DRIVER = "with_driver";
    public static final String RENT_DURATION = "rent_duration";
    public static final String TOTAL_PRICE = "total_price";
    public static final String ORDER_STATUS_NAME = "order_status_name";
    public static final String RENT_HOURS = "rent_hours";

    /**
     * User Parameters
     */
    public static final String USER_ID = "user_id";
    public static final String USER_ROLE_ID = "user_role_id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final String PASSPORT = "passport";
    public static final String IS_BLOCKED = "is_blocked";
    public static final String ROLE_NAME = "role_name";


    /**
     * DB properties from file
     */

    public static final String DB_DRIVER = "db.driver";
    public static final String DB_URL = "db.url";
    public static final String DB_USER = "db.user";
    public static final String DB_PASSWORD = "db.password";
    public static final String POOL_SIZE = "db.poolsize";
    public static final int DEFAULT_POOL_SIZE = 7;
}
