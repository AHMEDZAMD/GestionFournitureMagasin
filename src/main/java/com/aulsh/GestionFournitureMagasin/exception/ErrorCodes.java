package com.aulsh.GestionFournitureMagasin.exception;

public enum ErrorCodes {

    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001),
    CATEGORY_NOT_FOUND(2000),
    AGENT_NOT_FOUND(3000),
    COMMANDE_AGENT_NOT_FOUND(4000),
    COMMANDE_AGENT_NOT_VALID(4001),
    COMMANDE_CHEF_SERVICE_EQUIPMENTS_NOT_FOUND(5000),
    CHEF_SERVICE_EQUIPMENTS_NOT_FOUND(6000),
    CHEF_SERVICE_EQUIPMENTS_NOT_VALID(6001),
    LIGNE_COMMANDE_AGENT_NOT_FOUND(7000),
    LIGNE_COMMANDE_CHEF_SERVICE_EQUIPMENTS_NOT_FOUND(8000),
    MVTK_STK_NOT_FOUND(9000),
    UTILISATEUR_NOT_FOUND(10000),
    AGENT_NOT_VALID(11000),
    CATEGORY_NOT_VALID(12000),
    UTILISATEUR_NOT_VAILD(13000),
    MVT_STK_NOT_VALID(14009),
    VENTE_NOT_VALID(15009),
    VENTE_ALREADY_IN_USE(15399),
    VENTE_NOT_FOUND(16000),
    ;

  private int  code;
    ErrorCodes(int  code){

        this.code = code;
    }

  public int  getCode(){
        return code;

  }

}
