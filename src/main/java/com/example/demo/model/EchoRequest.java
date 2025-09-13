package com.example.demo.model;


import jakarta.validation.constraints.NotBlank;


public class EchoRequest {


@NotBlank(message = "message must not be blank")
private String message;


public EchoRequest() {}


public EchoRequest(String message) {
this.message = message;
}


public String getMessage() {
return message;
}


public void setMessage(String message) {
this.message = message;
}


@Override
public String toString() {
return "EchoRequest{message='" + message + "'}";
}
}
