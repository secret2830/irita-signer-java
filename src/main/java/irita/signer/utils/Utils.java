package irita.signer.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utils {
    public static final Gson serializer = new GsonBuilder()
            .serializeNulls()
            .create();
}
