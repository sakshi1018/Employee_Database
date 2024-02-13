package com.example.newapp.pages;

import com.example.newapp.business.Person;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;


@Import(stylesheet="context:css/Index.css")
public class AddEmployee {

    @Property
    @Persist
    private int id;
    @InjectComponent("id")
    private TextField idField;
    @Property
    @Persist
    private int age;
    @InjectComponent("age")
    private TextField ageField;

    @InjectComponent
    private Form form;
    @Property
    @Persist
    private String name;

    @Property
    @Persist
    private String address;
    @Property
    @Persist

    private String username;
    @Property
    @Persist
    private String password;
    @Property
    private Person perdetail;
    @InjectPage
    private Grid grid;


    void onValidateFromForm() {
        if (id<=0)
            form.recordError(idField, "Id cannot be less than equal to 0");
        if(grid.getIdAvailable(id)){
            String errorMessage = String.format("Id %d is already present in employee table", id);
            form.recordError(idField, errorMessage);
        }

        if (age<=0)
            form.recordError(ageField, "age can't be negative");


    }



    @OnEvent(value = "success", component = "form")
    Object  onSuccess() {
        return Grid.class;

}
    public Person getAddDetails(){
        System.out.println(id+" "+username+" "+name+" "+age+" "+address+" "+password);
        if(id==0){
            return null;
        }
        perdetail=new Person(id,username,name,age,address,password);
        id=0;
        return perdetail;

    }







}
