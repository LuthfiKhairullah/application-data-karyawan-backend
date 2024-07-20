package com.data_karyawan.data_karyawan.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBodyUtil {
    private String type;
    private String message;
    private Object content;

    public ResponseBodyUtil(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public ResponseBodyUtil(String type, String message, Object content) {
        this.type = type;
        this.message = message;
        this.content = content;
    }
}
