package dev.cosmingherghe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File input = new File("src/dev/cosmingherghe/data/jsonData.json");

        //Start to process a file
        try(FileReader fileReader = new FileReader(input)) {

            //Get a JsonObject from JsonElement
            JsonElement fileElement = JsonParser.parseReader(fileReader);
            JsonObject fileObject = fileElement.getAsJsonObject();

            //Extracting basic fields looking at JSON file format
            //Basic fields = no arrays or objects
            String name = fileObject.get("name").getAsString();
            Integer age = fileObject.get("age").getAsInt();  // (Skipping primitives gives you the option to be null if value not found)
            System.out.println("Name: " + name + "\nAge: " + age);

            //Compute Array Pets that contains Objects
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
