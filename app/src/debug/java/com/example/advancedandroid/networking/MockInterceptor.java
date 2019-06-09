package com.example.advancedandroid.networking;

import com.example.advancedandroid.settings.DebugPreferences;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @author Mugiwara_Munyi
 * @date 09/06/2019
 */
public class MockInterceptor implements Interceptor {

    private final MockResponsesFactory mockResponsesFactory;
    private final DebugPreferences debugPreferences;

    @Inject MockInterceptor(MockResponsesFactory mockResponsesFactory, DebugPreferences debugPreferences){
        this.mockResponsesFactory = mockResponsesFactory;
        this.debugPreferences = debugPreferences;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if(debugPreferences.useMockResponsesEnabled()){
            String mockResponse = mockResponsesFactory.getMockResponse(chain.request());
            if(mockResponse!=null){
                return new Response.Builder()
                        .message("")
                        .protocol(Protocol.HTTP_1_1)
                        .request(chain.request())
                        .code(200)
                        .body(ResponseBody.create(MediaType.parse("text/json"), mockResponse))
                        .build();
            }
        }
        return chain.proceed(chain.request());
    }
}
