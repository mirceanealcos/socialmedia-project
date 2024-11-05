package com.mirceanealcos.socialmedia.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private String title;
    private String message;
    private String path;

}
