package com.mozip.dto;

import lombok.Data;

@Data
public class CMRespDto<T> {
    private final Integer code;
    private final String msg;
    private final T Data;
}
