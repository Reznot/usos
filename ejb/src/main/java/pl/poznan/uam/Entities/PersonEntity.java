package pl.poznan.uam.Entities;

import java.io.Serializable;

public class PersonEntity implements Serializable {

    private Long id;
    private int index;
    private String  pesel;
    private int status;
    private String name;
    private String surname;
    private String titles;
    private String mail;

    public PersonEntity(){

    }

    public PersonEntity(Long id, int index, String pesel, int status, String name, String surname, String titles, String mail){
        this.id = id;
        this.index = index;
        this.pesel = pesel;
        this.status = status;
        this.name = name;
        this.surname = surname;
        this.titles = titles;
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntity personDto = (PersonEntity) o;

        return  id != null ? id.equals(personDto.id) : personDto.id == null;
    }

    @Override
    public int hashCode(){
        return id != null ? id.hashCode() : 0;
    }

    public void update(PersonEntity aPerson){
        index = aPerson.getIndex();
        pesel = aPerson.getPesel();
        status = aPerson.getStatus();
        name = aPerson.getName();
        surname = aPerson.getSurname();
        titles = aPerson.getTitles();
        mail = aPerson.getMail();
    }
}
