package com.ads2018II.banking.application.enum_common;

public enum RequestBodyType {
	VALID {
        public String toString() {
            return "VALID";
        }
    },
	INVALID {
        public String toString() {
            return "INVALID";
        }
    },
}
