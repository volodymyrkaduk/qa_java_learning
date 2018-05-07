package ru.stqa.pft.addressbook.model;

public class PersonData {
    private final String firstname;
    private final String lastname;
    private final String nickname;
    private final String email;
    private String group;

    public PersonData(String firstname, String lastname, String nickname, String email, String group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.email = email;
        this.group = group;
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

    public String getGroup() {
        return group;
    }
}
