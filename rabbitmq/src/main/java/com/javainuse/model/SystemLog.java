package com.javainuse.model;


import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class SystemLog {

    LogType logType;
    String controller;
    String content;


}
