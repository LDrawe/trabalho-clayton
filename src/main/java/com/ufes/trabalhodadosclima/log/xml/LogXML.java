/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.log.xml;

import com.ufes.trabalhodadosclima.log.ILog;
import com.ufes.trabalhodadosclima.log.LogEntry;
import com.ufes.trabalhodadosclima.model.DadoClima;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.StringWriter;
/**
 *
 * @author talle
 */
public class LogXML implements ILog{
    
    @Override
    public String getLogMensagem(DadoClima dado, Boolean removido) {
        try {
            JAXBContext context = JAXBContext.newInstance(LogEntry.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            StringWriter sw = new StringWriter();
            marshaller.marshal(new LogEntry(dado, removido ? "Removido" : "Adicionado"), sw);
            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
