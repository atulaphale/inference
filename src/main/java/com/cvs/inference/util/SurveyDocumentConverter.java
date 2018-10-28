package com.cvs.inference.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cvs.inference.representation.Survey;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Converter
public class SurveyDocumentConverter implements
        AttributeConverter<List<Survey>, String> {

    // ObjectMapper is thread safe
    private final static ObjectMapper objectMapper = new ObjectMapper();

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public String convertToDatabaseColumn(List<Survey> meta) {
        String jsonString = "";
        try {
            log.debug("Start convertToDatabaseColumn");

            // convert list of POJO to json
            jsonString = objectMapper.writeValueAsString(meta);
            log.debug("convertToDatabaseColumn" + jsonString);

        } catch (JsonProcessingException ex) {
            log.error(ex.getMessage());
        }
        return jsonString;
    }

    @Override
    public List<Survey> convertToEntityAttribute(String dbData) {
        List<Survey> list = new ArrayList<Survey>();
        try {
            log.debug("Start convertToEntityAttribute");

            // convert json to list of POJO
            list = Arrays.asList(objectMapper.readValue(dbData,
                    Survey[].class));
            log.debug("SurveyDocumentConverter.convertToDatabaseColumn" + list);

        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
        return list;
    }
}