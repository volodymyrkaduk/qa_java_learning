package ru.stqa.pft.addressbook;

public class PersonData {
    private final String firstname;
    private final String lastname;
    private final String nickname;
    private final String email;

    public PersonData(String firstname, String lastname, String nickname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }
}
