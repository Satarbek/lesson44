package model;

import java.util.ArrayList;
import java.util.List;

public class UsersModel {
    private SampleUser user= new SampleUser("Name", "currentBook", "oldBook");
    private List<SampleUser> users = new ArrayList<>();

    public UsersModel() {
        users.add(new SampleUser("Pier Withoutear", "Silent Don", "Mathematics"));
        users.add(new SampleUser("Aksiniia", "Pinocchio", "Java"));
        users.add(new SampleUser("Artemon Pudel", "Java", "War & Peace"));
    }

    public SampleUser getUser() {
        return user;
    }

    public List<SampleUser> getUsers() {
        return users;
    }
}
