package com.qaschool.validators;

public class PostValidator {

    public String getPostStatus(String postBody) {
        if (postBody == null || postBody.isEmpty()) {
            return "ERROR_EMPTY";
        }
        if (postBody.length() > 250) {
            return "ERROR_TOO_LONG";
        }
        if (postBody.contains("politică")) {
            return "ERROR_FORBIDDEN";
        }
        return "POST_VALID";
    }
}
