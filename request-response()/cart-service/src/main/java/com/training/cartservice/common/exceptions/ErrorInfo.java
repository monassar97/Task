package com.training.cartservice.common.exceptions;

import com.training.cartservice.common.Lang;
import lombok.Data;

import java.util.Map;

@Data
public class ErrorInfo {

    private int code;
    private Map<Lang,String> message;
    private int restErrorCode= 400;

}
