/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.log;

import com.ufes.trabalhodadosclima.log.json.LogJSON;
import com.ufes.trabalhodadosclima.model.DadoClima;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author tallesh
 */
public class Log {
    private static File file;
    private String type;
    
    private LogJSON logJson;
    
        public Log(){
            logJson = new LogJSON();
        }
    
    public void setLogType(String type){
        this.type = type;
    }
    
    public void makeLog(DadoClima dadoClima, boolean added){
        String content = null;
        if(type.equals("xml")){
            //content = logXml.getLogMessage(dadoClima, added);
        }else{
            content = logJson.getLogMessage(dadoClima, added);
        }
            
        try{
            appendToFile(content);
        }catch (IOException e){
            System.out.println(e);
        }
    }
    
    private void appendToFile(String text) throws IOException{
        file = new File("./assets" + type);
        BufferedWriter bw;
        if(!file.exists()){
            file.createNewFile();
        }
        bw = new BufferedWriter(new FileWriter(file, true));

        bw.write(text);
        bw.newLine();

        bw.close();
    }
    
}
