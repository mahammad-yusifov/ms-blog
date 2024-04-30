package com.mahammad.msblog.constant;

public enum UserType {
    ADMIN(1),
    MODERATOR(2);

    private final int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static UserType fromValue(int value) {
        for (UserType userType : UserType.values()) {
            if (userType.value == value) {
                return userType;
            }
        }
        throw new IllegalArgumentException("Invalid UserType value: " + value);
    }
}
