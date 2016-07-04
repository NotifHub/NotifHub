package synapsehub.cd.notifhub.model;

import java.io.Serializable;

/**
 * Created by michelo on 7/2/16.
 */

public class SousRubrique implements Serializable {

    public String getNamerubrique() {
        return namerubrique;
    }

    public void setNamerubrique(String namerubrique) {
        this.namerubrique = namerubrique;
    }

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

    private String namerubrique;
    private String name;
    private String desc;

    private SousRubrique(){}

    private SousRubrique(String namerubrique,String name, String desc){
        this.namerubrique=namerubrique;
        this.name=name;
        this.desc=desc;
    }


}
