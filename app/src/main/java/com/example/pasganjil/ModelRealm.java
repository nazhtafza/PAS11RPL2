package com.example.pasganjil;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ModelRealm extends RealmObject {
    @PrimaryKey
    String strTeam;
    String strLeague;
    String strTeamBadge;
    String strDescriptionEN;
Integer idTeam;


    public Integer getidTeam() {
        return idTeam;
    }

    public void setidTeam(Integer id) {
        this.idTeam = id;
    }

    public String getstrTeam() {
        return strTeam;
    }

    public void setstrTeam(String strTeam) {
        this.strTeam =strTeam;
    }

    public String getstrLeague() {
        return strLeague;
    }

    public void setstrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getstrTeamBadge() {
        return strTeamBadge;
    }

    public void setstrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }


    public String getstrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setstrDescriptionEN(String  strDescriptionEN) {
        this.strDescriptionEN =  strDescriptionEN;
    }
}