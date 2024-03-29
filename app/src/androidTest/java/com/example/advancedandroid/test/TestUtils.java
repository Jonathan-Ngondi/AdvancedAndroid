package com.example.advancedandroid.test;

import com.squareup.moshi.Moshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import javax.inject.Inject;

/**
 * @author Mugiwara_Munyi
 * @date 03/06/2019
 */
public class TestUtils {

    private final Moshi moshi;

    @Inject TestUtils(Moshi moshi){
        this.moshi = moshi;
    }

    private  <T> T loadJson(String path, Type type)
    {
        try{
            String json = getFileString(path);
            //noinspection unchecked
            return (T) moshi.adapter(type).fromJson(json);
        } catch (IOException e){
            throw new IllegalArgumentException("Could not deserialize: "+path+" into type "+type);
        }

    }

    public <T> T loadJson(String path, Class clazz){
        try{
            String json = getFileString(path);
            //noinspection unchecked
            return (T) moshi.adapter(clazz).fromJson(json);
        } catch (IOException e){
            throw new IllegalArgumentException("Could not deserialize: "+path+" into type "+clazz);
        }
    }

    private  String getFileString(String path) {
        try{
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    getClass().getClassLoader().getResourceAsStream(path)));
            String line;
            while((line = reader.readLine())!=null){
                sb.append(line);

            }
            return sb.toString();
        } catch(IOException e){
            throw new IllegalArgumentException("Could not read from resource at: " + path);
        }
    }


}
