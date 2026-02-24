package mvc.controller;

import mvc.dto.Profile;
import mvc.service.ProfileService;

public class ProfileController {

    private ProfileService service = new ProfileService();

    public void save(String name, String weight, String password) {

        try {
            Profile profile = new Profile(name, weight, password);
            service.saveProfile(profile);
            System.out.println("저장 완료!");

        } catch(Exception e) {
            System.out.println("저장 실패: " + e.getMessage());
        }
    }

    public void load(String name) {

        try {
            Profile profile = service.loadProfile(name);

            System.out.println(profile);

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
