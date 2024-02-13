package com.example.newapp.pages;
import org.apache.tapestry5.annotations.*;

import java.util.ArrayList;
import java.util.List;
import com.example.newapp.business.Person;
import com.example.newapp.pages.Grid;
import org.apache.tapestry5.http.Link;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;


@Import(stylesheet = "context:css/plain.css")
public class ViewUser {

    @PageActivationContext
    @Property
    private int id;
    @Property
    private String name;
    @Property
    private Person per;
    @InjectPage
    private Grid grid;
    public Person getDetails(){
        per=grid.getSelectedper( id);
        return per;
    }




}
