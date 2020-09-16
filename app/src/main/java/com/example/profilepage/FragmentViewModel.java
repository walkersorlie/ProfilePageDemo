package com.example.profilepage;

import android.media.Image;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FragmentViewModel extends ViewModel {

    private MutableLiveData<Image> avatar = new MutableLiveData<>();
    private MutableLiveData<String> name = new MutableLiveData<>();
    private MutableLiveData<String> email = new MutableLiveData<>();
    private MutableLiveData<String> phone = new MutableLiveData<>();
    private MutableLiveData<String> description = new MutableLiveData<>();

    public void setImage(Image avatar) {
        this.avatar.setValue(avatar);
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public void setEmail(String email) {
        this.email.setValue(email);
    }

    public void setPhone(String phone) {
        this.phone.setValue(phone);
    }

    public void setDescription(String description) {
        this.description.setValue(description);
    }

    public MutableLiveData<Image> getImage() {
        return avatar;
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<String> getEmail() {
        return email;
    }

    public MutableLiveData<String> getPhone() {
        return phone;
    }

    public MutableLiveData<String> getDescription() {
        return description;
    }
}
