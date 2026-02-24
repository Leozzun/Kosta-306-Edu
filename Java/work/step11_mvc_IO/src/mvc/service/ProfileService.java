package mvc.service;

import java.io.*;
import mvc.dto.Profile;

public class ProfileService {

    public void saveProfile(Profile profile) throws Exception {

    	File file = new File("resources/" + profile.getName() + ".txt");

        file.createNewFile();

        BufferedWriter bw =
                new BufferedWriter(new FileWriter(file));

        bw.write(profile.getWeight() + ":" + profile.getPassword());
        bw.close();
    }

    public Profile loadProfile(String name) throws Exception {

        File file = new File("resources/" + name + ".txt");

        if(!file.exists()) {
            throw new FileNotFoundException("해당 프로필이 존재하지 않습니다.");
        }

        BufferedReader br =
                new BufferedReader(new FileReader(file));

        String data = br.readLine();
        br.close();

        String[] arr = data.split(":");

        return new Profile(name, arr[0], arr[1]);
    }
}
