package se.sprinto.hakan.adventuregame.appinfo;

import se.sprinto.hakan.adventuregame.view.ScannerUI;
import se.sprinto.hakan.adventuregame.view.UI;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AppInfo {
        private static AppInfo instance;
        private String author;
        private double version;

        private AppInfo() {

        }

        private AppInfo(String author, double version) {
            this.author = author;
            this.version = version;
        }

        public static AppInfo getInstance( ) {
            if (instance == null) {
                instance = new AppInfo();
            }
            return instance;
        }


        public String getAuthor() {
            return author;
        }

        public double getVersion() {
            return version;
        }

        public void setAuthor( String author) {
            this.author = author;
        }


        public void setVersion(double version) {
            this.version = version;
        }

        @Override
        public String toString() {
            return "AppInfo{" +
                    "version=" + version +
                    ", author='" + author + '\'' +
                    '}';
        }

        public AppInfo readProperty() {
            Map<String, String> properties = new HashMap<>();

            try (BufferedReader reader = new BufferedReader (new FileReader("property.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    String key = parts[0];
                    String value = parts[1];
                    properties.put(key, value);
                }

                instance.setVersion(Double.parseDouble(properties.get("app.version")));
                instance.setAuthor(properties.get("app.author"));

            } catch (IOException e) {
                System.out.println("Error when reading the file.");
            }
            return instance;
        }

        public void writeProperty(String author, double version) {
            UI ui = new ScannerUI();
            author = ui.getInput("Please enter the author's NAME:");
            version = Double.parseDouble(ui.getInput("Please enter the game's VERSION:"));


            try (BufferedWriter writer = new BufferedWriter(new FileWriter("property.txt"))) {
                writer.write("app.author ; " + author);
                writer.newLine();
                writer.write("app.version ; " + Double.toString(version) );
                System.out.println("Successfully wrote to the file.");

            } catch (IOException e) {
                System.out.println("Error when writing the file.");
            }
        }

}

