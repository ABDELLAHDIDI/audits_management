/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idao;

/**
 *
 * @author maejj
 */
import java.util.Date;

public class Audit {
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public CheckList getCheckList() {
        return checkList;
    }

    public void setCheckList(CheckList checkList) {
        this.checkList = checkList;
    }
        int id;
    private String auditeur;
    private CheckList checkList;
    private String date_creation;
    private String date_realisation;
    private  String date_limite;
    private float score;
    private String niveau;

    // Constructeur par défaut
    public Audit() {}
    public Audit(int id ) {
    this.id = id; }

    // Constructeur avec paramètres
    public Audit(String auditeur,CheckList checkList, String date_creation, String date_realisation,String   date_limite, int score, String niveau) {
        this.auditeur = auditeur;
              this.checkList = checkList;
        this.date_creation = date_creation;
        this.date_realisation = date_realisation;
        this.date_limite = date_limite;
        this.score = score;
        this.niveau = niveau;
    }
    public Audit(String auditeur,CheckList checkList, String  date_creation, String  date_limite) {
        this.auditeur = auditeur;
        this.checkList = checkList;
        this.date_creation = date_creation;
        this.date_limite = date_limite;
    }
    public Audit(String auditeur,CheckList checkList, String  date_creation, String  date_limite,int id ) {
        this.auditeur = auditeur;
        this.checkList = checkList;
        this.date_creation = date_creation;
        this.date_limite = date_limite;
        this.id = id;
    }
    public Audit(int id , String auditeur,CheckList checkList, String  date_creation,String date_realisation ,  String  date_limite , 
            float score , String niveau ) {
        
        this.auditeur = auditeur;
        this.checkList = checkList;
        this.date_creation = date_creation;
        this.date_limite = date_limite;
        this.id = id;
        this.date_realisation=date_realisation;
        this.score=score;
        this.niveau=niveau;
    }
 

    // Getters et Setters
    public String getAuditeur() {
        return auditeur;
    }

    public void setAuditeur(String auditeur) {
        this.auditeur = auditeur;
    }

    public String  getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public String  getDate_realisation() {
        return date_realisation;
    }

    public void setDate_realisation(String  date_realisation) {
        this.date_realisation = date_realisation;
    }

    public String  getDate_limite() {
        return date_limite;
    }

    public void setDate_limite( String date_limite) {
        this.date_limite = date_limite;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}

