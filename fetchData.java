package com.example.doctor;

public class fetchData {
    String id;
    String firstname;
    String lastname;
    String gender;
    String date;

    public fetchData(String id, String firstname,String lastname, String gender, String date){
       this.id = id;
       this.firstname= firstname;
       this.lastname= lastname;
       this.gender= gender;
       this.date= date;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getFirstname(){
        return firstname;
    }
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }
}
