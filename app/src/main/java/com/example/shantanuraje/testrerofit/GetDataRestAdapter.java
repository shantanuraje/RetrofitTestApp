package com.example.shantanuraje.testrerofit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

/**
 * Created by Shantanuraje on 10-08-2015.
 */
public class GetDataRestAdapter {
    protected RestAdapter dataRestAdapter;
    protected IGetData getData;
    static final String SERVER_URL="http://192.168.1.8:8080";

    public GetDataRestAdapter(){
        dataRestAdapter=new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(SERVER_URL)
                .setConverter(new StringConverter())
                .build();

        getData=dataRestAdapter.create(IGetData.class);


    }
    public void testServerConnection(Callback<String> callback){
        getData.testConnection(callback);
    }
/*http://stackoverflow.com/questions/10239969/using-gson-giving-error-expected-begin-array-but-was-string
http://stackoverflow.com/questions/28645822/retrofit-android-can-i-download-json-object-to-string-without-parsing
http://stackoverflow.com/questions/21881943/how-can-i-return-string-or-jsonobject-from-asynchronous-callback-using-retrofit/22820153#22820153
http://stackoverflow.com/questions/22325641/retrofit-callback-get-response-body
http://stackoverflow.com/questions/16615038/what-is-the-shortcut-to-auto-import-all-in-android-studio
http://stackoverflow.com/questions/21881943/how-can-i-return-string-or-jsonobject-from-asynchronous-callback-using-retrofit
http://square.github.io/retrofit/javadoc/retrofit/converter/Converter.html*/
    static class StringConverter implements Converter {

        @Override
        public Object fromBody(TypedInput typedInput, Type type) throws ConversionException {
            String text = null;
            try {
                text = fromStream(typedInput.in());
            } catch (IOException ignored) {/*NOP*/ }

            return text;
        }

        @Override
        public TypedOutput toBody(Object o) {
            return null;
        }

        public static String fromStream(InputStream in) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder out = new StringBuilder();
            String newLine = System.getProperty("line.separator");
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
                out.append(newLine);
            }
            return out.toString();
        }
    }
}
