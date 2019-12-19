package seleniumWebTesting.web.dataObjects;

import com.github.javafaker.Faker;

public interface UserData {

    Faker faker = new Faker();

    String
            username = "995557345566",
            password = "daneliadavid",
            songName = "markul серпантин",
            foundByName = "Серпантин",
            nameOfPerson = "David Danelia",
            massage = "Idumali str.5" + faker.number().digits(10);

}
