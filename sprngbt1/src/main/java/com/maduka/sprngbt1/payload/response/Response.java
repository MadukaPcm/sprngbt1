package com.maduka.sprngbt1.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private boolean error;
    private int code;
    private String message;
    private T data;
    private List<T> dataList;

    public Response(boolean error, int code, String message){
        this.error = error;
        this.code = code;
        this.message = message;
    }

    public Response(boolean error, int code, T data){
        this.error = error;
        this.code = code;
        this.data = data;
    }

    public Response(boolean error, int code, String message, List<T> dataList){
        this.error = error;
        this.code = code;
        this.message = message;
        this.dataList = dataList;
    }

    public Response(boolean error, int code, T data, String message){
        this.error = error;
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
