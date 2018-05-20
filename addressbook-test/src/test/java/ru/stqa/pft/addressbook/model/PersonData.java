package ru.stqa.pft.addressbook.model;

public class PersonData {
    private int id = 0;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String phone;
    private String group;

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public PersonData setId(int id) {
        this.id = id;
        return this;
    }

    public PersonData setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public PersonData setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public PersonData setAddress(String address) {
        this.address = address;
        return this;
    }

    public PersonData setEmail(String email) {
        this.email = email;
        return this;
    }

    public PersonData setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public PersonData setGroup(String group) {
        this.group = group;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonData that = (PersonData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        return group != null ? group.equals(that.group) : that.group == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

}
