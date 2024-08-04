/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.log.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author talle
 */
public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate>{
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, DATE_FORMATTER);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.format(DATE_FORMATTER);
    }
}
