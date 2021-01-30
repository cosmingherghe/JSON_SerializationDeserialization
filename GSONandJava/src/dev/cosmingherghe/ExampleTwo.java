package dev.cosmingherghe;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import dev.cosmingherghe.entity.User;

import java.io.FileReader;
import java.io.Reader;

public class ExampleTwo {
    public static void main(String[] args) {

        // pretty print
        Gson gson = new Gson();

        try (Reader reader = new FileReader("src/dev/cosmingherghe/data/jsonData.json")) {

            // Convert JSON to JsonElement, and later to String
            JsonElement json = gson.fromJson(reader, JsonElement.class);
            String jsonInString = gson.toJson(json);

            //Get an Gson Object
            User user = gson.fromJson(jsonInString, User.class);
            System.out.println(user.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
