package com.example.newapp.pages;

import java.util.ArrayList;
import java.util.List;
import com.example.newapp.business.Person;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;

@Import(stylesheet = "context:css/plain.css")

public class Grid {
    @Property
    private Person persons;
    @Property
    private Person selectedPerson;

    @Property
    private Person addpersons;
    @Property

    private List<Person> ls=new ArrayList<>();
    @InjectPage
    private AddEmployee ae;



    public List<Person> getCreateSampleData(){
        if(ls.isEmpty()) {
            ls.add(new Person(1, "sak@", "sakshi", 24, "India", "123"));
            ls.add(new Person(2, "xyz@", "xyz", 20, "India", "869"));
        }
        addpersons=ae.getAddDetails();

        if(addpersons!=null){
            ls.add(addpersons);
            addpersons=null;

        }
        return ls;
    }

    Object onSuccess() {
        return ViewUser.class;

    }
    public Person getSelectedper(int personId) {
        selectedPerson = ls.stream().filter(person -> person.getId() == personId).findFirst().orElse(null);
        return selectedPerson;
    }
    public boolean getIdAvailable(int id){
        selectedPerson = ls.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
        if(selectedPerson!=null){
            return true;
        }
        return false;
    }
}

