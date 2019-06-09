package com.example.advancedandroid.networking;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nullable;

import timber.log.Timber;

/**
 * @author Mugiwara_Munyi
 * @date 09/06/2019
 */
class MockResourceLoader {

    private MockResourceLoader(){

    }

    @Nullable
    static String getResponseString(Context context, String method, String[] endpointParts){
        try{
            String currentPath = "mock";
            Set<String> mockList = new HashSet<>(Arrays.asList(context.getAssets().list(currentPath)));
            for(String endpointPart: endpointParts){
                if(mockList.contains(endpointPart)){
                    currentPath = currentPath + "/"+endpointPart;
                    mockList = new HashSet<>(Arrays.asList(context.getAssets().list(currentPath)));
                }
            }

            //At this stage, our mock list will be the list of files in the matching directory for the
            // endpoint parts.
            String finalPath = null;
            for(String path: mockList){
                if(path.contains(method.toLowerCase())) {
                    finalPath = currentPath + "/" + path;
                    break;
                }
            }

            if(finalPath!=null){
                return responseFromPath(context, finalPath);
            }

        } catch (IOException e){
            Timber.e(e, "Error loading mock response from assets");
        }

        return null;
    }

    private static String responseFromPath(Context context, String path){
        StringBuilder sb =new StringBuilder();
        try(InputStream assetstream = context.getAssets().open(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(assetstream))){
            String line;
            while((line = reader.readLine())!=null){
                sb.append(line);
            }

        } catch (IOException e){
            Timber.e(e,"Error reading mock responses from path.");

        }

        return sb.toString();
    }
}
