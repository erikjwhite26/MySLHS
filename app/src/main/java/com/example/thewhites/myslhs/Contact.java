package com.example.thewhites.myslhs;

public class Contact {

    private String _name, _phone, _email, _address, _image;
    private int _id;



    public Contact (int id, String name, String phone, String email, String address, String image) {
        _id = id;
        _name = name;
        _phone = phone;
        _email = email;
        _address = address;
        _image = image;
    }

    public int getId() { return _id; }

    public String getName() {
        return _name;
    }

    public String getPhone() {
        return _phone;
    }

    public String getEmail() {
        return _email;
    }

    public String getAddress() {
        return _address;
    }

    public String getImage() {
        return _image;
    }

    public void setName(String newName) {
        _name = newName;
    }

    public void setPhone(String newPhone) {
        _phone = newPhone;
    }

    public void setEmail(String newEmail) {
        _email = newEmail;
    }

    public void setAddress(String newAddress) {
        _address = newAddress;
    }

    public void setImage(String newImage) {
        _image = newImage;
    }

}