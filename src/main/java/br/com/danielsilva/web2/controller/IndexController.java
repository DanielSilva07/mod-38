package br.com.danielsilva.web2.controller;

import java.io.Serializable;

public class IndexController implements Serializable {

    private static final long serialVersionUID = -3176307559028924604L;

    public String goToClientPage() {
        return "/cliente/list.xhtml";
    }
}
