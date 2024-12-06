package files;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String[] links = {
                "https://fake-json-api.mock.beeceptor.com/users",
                "https://fake-json-api.mock.beeceptor.com/companies" };

        for (int i = 0; i < 2;i++){
            try {
                String response = Methods.get(links[0]);
                System.out.println(i+1 + " ссылка:");
                Methods.print(response);
            } catch (IOException e) {
                System.out.println("Возникла ошибка");
            }
            System.out.print("\n");
        }
    }
}

