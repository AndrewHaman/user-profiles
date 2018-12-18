package com.dece.userprofile.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsonHelper {

    public static <C> C readValueFromJsonFile(String fileName, TypeReference<C> typeReference) throws IOException {
        ClassLoader classLoader = JsonHelper.class.getClassLoader();
        URL url = classLoader.getResource(fileName);
        File file = new File(url.getFile());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        C retVal = (C) objectMapper.readValue(file, typeReference);

        return retVal;
    }
}
