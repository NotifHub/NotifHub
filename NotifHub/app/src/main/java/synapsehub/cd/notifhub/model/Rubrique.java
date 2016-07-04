package synapsehub.cd.notifhub.model;

import java.io.Serializable;

/**
 * Created by michelo on 7/2/16.
 */

public class Rubrique implements Serializable {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String name;
    private String desc;

    public Rubrique(){}

    public Rubrique(String name, String desc){
        this.name=name;
        this.desc=desc;
    }



}
