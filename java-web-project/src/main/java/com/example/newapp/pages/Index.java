package com.example.newapp.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.HttpError;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.services.PageRenderLinkSource;


import java.time.ZonedDateTime;

/**
 * Start page of application newapp.
 */

@Import(stylesheet="context:css/Index.css")
public class Index {


    @Inject
    private AlertManager alertManager;

    @InjectComponent
    private Form login;

    @InjectComponent("email")
    private TextField emailField;

    @InjectComponent("password")
    private PasswordField passwordField;

    @Property
    private String email;

    @Property
    private String password;

    @InjectPage
    private WelcomePage welcomePage;



    void onValidateFromLogin() {
        if (!email.equals("users@dummy.com"))
            login.recordError(emailField, "Try with user: users@dummy.com");

        if (!password.equals("dummy"))
            login.recordError(passwordField, "Try with password: dummy");

    }

    @OnEvent(value = "success", component = "login")
    Object  onSuccessFromLogin() {
            return welcomePage;

    }



}
