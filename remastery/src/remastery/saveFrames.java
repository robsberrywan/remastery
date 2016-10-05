/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remastery;

import java.io.BufferedReader;
import java.io.FileReader;
import matlabcontrol.*;
/**
 *
 * @author RobinaAnne
 */
public class saveFrames {
    public saveFrames(){
        
    }
    public void frByFr(String sPath){
        try{
            MatlabProxyFactoryOptions options = new MatlabProxyFactoryOptions.Builder().setUsePreviouslyControlledSession(true).build();
            MatlabProxyFactory factory = new MatlabProxyFactory(options);
            MatlabProxy proxy = factory.getProxy();
            
            proxy.eval("addpath('" + sPath + "')");
            
            try(BufferedReader read = new BufferedReader(new FileReader(sPath))) {
                String line;         
                while((line = read.readLine())!= null){
                    System.out.println(line);
                    proxy.eval(line);
                }
                read.close();
            }
            catch(Exception ef){
                System.out.println("File reader error");
                ef.printStackTrace();
            }
            
            proxy.eval("rmpath('" + sPath + "')");
            proxy.disconnect();
            
        }
        catch(Exception ex){
            System.out.println("Save frame script error");
        }
    }
}
