package dev.cosmingherghe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.cosmingherghe.entity.Pet;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            List<Pet> petList = new ArrayList<>();

            JsonArray jsonArrayOfPets = fileObject.get("pets").getAsJsonArray();
            for (JsonElement petElement : jsonArrayOfPets) {
                //get Json Pet Object
                JsonObject petJsonObject = petElement.getAsJsonObject();

                //Extract Data
                String petName = petJsonObject.get("name").getAsString();
                String petColor = petJsonObject.get("color").getAsString();

                //Create Pet
                Pet pet = new Pet(petName, petColor);
                petList.add(pet);
            }

            System.out.println("All pets: " + petList);

        } catch (IOException e) {
            System.err.println("Error: File not found!");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error: processing input file!");
            e.printStackTrace();
        }
    }
}
