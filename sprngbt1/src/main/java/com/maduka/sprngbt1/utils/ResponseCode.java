package com.maduka.sprngbt1.utils;

public class ResponseCode {
    public static final int RECORD_EXIST = 4009;
    public static final int SUCCESS = 4000;
    public static final int DOES_NOT_EXIST = 4001;
    public static final int EMAIL_ALREADY_EXIST = 5002;
    public static final int PHONE_ALREADY_EXIST = 4003;
    public static final int NULL_ARGUMENT = 4004;
    public static final int FAIL = 4005;
    public static final int UNAUTHORIZED = 4006;
    public static final int OPERATION_NOT_ALLOWED = 4007;
    public static final int PASSWORD_DO_NOT_MATCH = 5008;
    public static final int WEAK_PASSWORD = 5010;
    public static final String MSG_DOES_NOT_EXIST = "Record Not Found";
    public static final String MSG_INVALID_UNIQUE_ID = "Invalid unique Id";
    public static final String MSG_DOES_EXIST = "Record Found";
    public static final String MSG_OPERATION_SUCCESSFUL = "Operation Successful";
    public static final String MSG_OPERATION_UNSUCCESSFUL = "Operation Failed";
    public static final String MSG_INTERNAL_SERVER_ERROR = "Internal Server Error";
    public static final String MSG_UNAUTHORIZED = "Unauthorized";
    public static final String tokenType = "Bearer";
}