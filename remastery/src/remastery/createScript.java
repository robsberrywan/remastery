/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remastery;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author RobinaAnne
 */
public class createScript {
    FileWriter fw;
    File file;
    public createScript(){
        
    }
    public void script(String sPath, String dPath, String name){
            try{
                file = new File(dPath + "\\saveFrames.m");
                fw = new FileWriter(file);
                
                fw.write(String.format("obj = VideoReader('" + sPath + "');"));
                fw.write(System.lineSeparator());
                fw.write(String.format("for img = 1:obj.NumberOfFrames;"));
                fw.write(String.format("filename = strcat('" + dPath + "\\', num2str(img), '.jpg');"));
                fw.write(String.format("b = read(obj,img);"));
                fw.write(String.format("imwrite(b, filename);"));
                fw.write(String.format("end"));
                fw.close();
                
                saveFrames sf = new saveFrames();
                sf.frByFr(file.getPath());
            }
            catch(Exception ex){
                System.out.println("error");
            }
    }
    public void conv(String dPath, String src, String des){
        try{
            file = new File(dPath + "\\gray2rgb.m");
            System.out.println("f");
            fw = new FileWriter(file);
            System.out.println(file.getPath());
            fw.write(String.format("img1='" + src + "';"));
            fw.write(System.lineSeparator());
            fw.write(String.format("img2='" + des + "';"));
            fw.write(System.lineSeparator());
            fw.write(String.format("function R=gray2rgb(img1,img2)"));
            System.out.println("s");
            fw.write(System.lineSeparator());
            fw.write(String.format("clc;"));
            fw.write(System.lineSeparator());
            fw.write(String.format("warning off;"));
            fw.write(String.format("imt = imread(img1);"));
            fw.write(System.lineSeparator());
            fw.write(String.format("ims = imread(img2);"));
            fw.write(System.lineSeparator());
            fw.write(String.format("[sx sy sz] = size(imt);"));
            fw.write(System.lineSeparator());
            fw.write(String.format("[tx ty tz]=size(ims);"));
            fw.write(System.lineSeparator());
            fw.write(String.format("if sz~=1 "));
            fw.write(System.lineSeparator());
            fw.write(String.format("imt=rgb2gray(imt); "));
            fw.write(System.lineSeparator());
            fw.write(String.format("end "));
            fw.write(System.lineSeparator());
            fw.write(String.format("if tz~=3 "));
            fw.write(System.lineSeparator());
            fw.write(String.format("disp('img2 must be a color image'); "));
            fw.write(System.lineSeparator());
            fw.write(String.format("else "));
            fw.write(System.lineSeparator());
            fw.write(String.format("imt(:,:,2)=imt(:,:,1);"));
            fw.write(System.lineSeparator());
            fw.write(String.format("nspace1=rgb2ycbcr(ims);"));
            fw.write(System.lineSeparator());
            fw.write(String.format("nspace2=rgb2ycbcr(imt);"));
            fw.write(System.lineSeparator());
            fw.write(String.format("ms=double(nspace1(:,:,1));"));
            fw.write(System.lineSeparator());
            fw.write(String.format("m1=max(max(ms));"));
            fw.write(System.lineSeparator());
            fw.write(String.format("m2=min(min(ms));"));
            fw.write(System.lineSeparator());
            fw.write(String.format("m3=max(max(mt));"));
            fw.write(System.lineSeparator());
            fw.write(String.format("m4=min(min(mt));"));
            fw.write(System.lineSeparator());
            fw.write(String.format("d1=m1-m2;"));
            fw.write(System.lineSeparator());
            fw.write(String.format("d2=m3-m4;"));
            fw.write(System.lineSeparator());
            
            fw.write(String.format("dx1=ms;"));
            fw.write(System.lineSeparator());
            fw.write(String.format("dx2=mt;"));
            fw.write(System.lineSeparator());
            fw.write(String.format("dx1=(dx1*255)/(255-d1);"));
            fw.write(System.lineSeparator());
            fw.write(String.format("dx2=(dx2*255)/(255-d2);"));
            fw.write(System.lineSeparator());
            fw.write(String.format("[mx,my,mz]=size(dx2);"));
            fw.write(System.lineSeparator());
            
            fw.write(String.format("disp('Please wait..');"));
            fw.write(System.lineSeparator());
            fw.write(String.format("for i=1:mx "));
            fw.write(System.lineSeparator());
            fw.write(String.format("for j=1:my "));
            fw.write(System.lineSeparator());
            fw.write(String.format("iy=dx2(i,j);"));
            fw.write(System.lineSeparator());
            fw.write(String.format("tmp=abs(dx1-iy);"));
            fw.write(System.lineSeparator());
            fw.write(String.format("ck=min(min(tmp));"));
            fw.write(System.lineSeparator());
            fw.write(String.format("[r,c] = find(tmp==ck);"));
            fw.write(System.lineSeparator());
            fw.write(String.format("ck=isempty(r);"));
            fw.write(System.lineSeparator());
            fw.write(String.format("if(ck~=1) "));
            fw.write(System.lineSeparator());
            fw.write(String.format("nimage(i,j,2)=nspace1(r(1),c(1),2);"));
            fw.write(System.lineSeparator());
            fw.write(String.format("nimage(i,j,3)=nspace1(r(1),c(1),3);"));
            fw.write(System.lineSeparator());
            fw.write(String.format("nimage(i,j,1)=nspace2(i,j,1);"));
            fw.write(System.lineSeparator());
            fw.write(String.format("end "));
            fw.write(System.lineSeparator());
            fw.write(String.format("end "));
            fw.write(System.lineSeparator());
            fw.write(String.format("end "));
            
            fw.write(System.lineSeparator());
            fw.write(String.format("rslt=ycbcr2rgb(nimage);"));
            fw.write(System.lineSeparator());
            //fw.write(String.format("figure,imshow(uint8(imt));"));
            //fw.write(String.format("figure,imshow(uint8(rslt));"));
            fw.write(String.format("uint8(rslt); "));
            fw.write(System.lineSeparator());
            fw.write(String.format("imwrite(uint8(rslt), img1); "));
            fw.write(System.lineSeparator());
            fw.write(String.format("end "));
            fw.close();
            saveFrames sf = new saveFrames();
            sf.frByFr(file.getPath());            
        }
        catch(Exception ex){
            System.out.println("error");    
        }
    }
}
