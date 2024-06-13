package com.renan.literature.model;

public interface IConvertData {
   <T> T getData(String json, Class<T> clazz);
    
}