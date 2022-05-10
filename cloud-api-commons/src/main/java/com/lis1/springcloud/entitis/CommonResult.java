package com.lis1.springcloud.entitis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lis1
 * @date 2022/5/9
 * @time 10:43
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
