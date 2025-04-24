package helpers;

import Models.User;
//import org.codehaus.jackson.map.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helpers {
    public static String generateAccountNumber(){
        int LENGTH = 11;
        StringBuilder initAccountNUmber = new StringBuilder();

        for(int i = 0; i < 11; i++){

            initAccountNUmber.append(ThreadLocalRandom.current().nextInt(10));
        }
        return initAccountNUmber.toString();
    }

    public static String formatString(String string){
        return string.trim().toLowerCase();
    }

    public static Set<User> loadUserData() throws Exception {
        Set<User> users = new HashSet<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File("user.json");

            if (file.exists() && file.length() > 0) {
                users = mapper.readValue(
                        file,
                        mapper.getTypeFactory().constructCollectionType(Set.class, User.class)
                );
                System.out.println(users);
            } else {
                mapper.writeValue(file, users); // Create an empty file
            }

        } catch (IOException e) {
            System.out.println("Error reading user data/home/sammy/IdeaProjects/bankApp: " + e.getMessage());
            throw new Exception("Failed to load user data", e);
        }
        return users;
    }

    public static void saveUserData(Set<User> user){
        Set<User> users = new HashSet<>(user);
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("user.json"), users);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Pattern VALIDATE_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static boolean validateEmail(String email){
        Matcher matcher = VALIDATE_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.matches();
    }
}
