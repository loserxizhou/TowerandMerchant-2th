package Model;

public class Buildings {
    private String buildings_type;
    private String buildings_uuid;
    private String buildings_name;
    private int buildings_level;
    private int fieldID;
    private String resourcesType;
    private int resources;

    public Buildings(String buildingsType, String buildingsUuid, String buildingsName, int buildingsLevel, int fieldID, String resourcesType, int resources) {
        this.buildings_type = buildingsType;
        this.buildings_uuid = buildingsUuid;
        this.buildings_name = buildingsName;
        this.buildings_level = buildingsLevel;
        this.fieldID = fieldID;
        this.resourcesType = resourcesType;
        this.resources = resources;
    }

    public String getBuildingsName() {
            return buildings_name;
        }

    public void setBuildingsName(String buildings_namename) {
            this.buildings_name = buildings_name;
        }

    public String getBuildingsId() {
            return buildings_uuid;
        }

    public void setBuildingsId(String buildings_uuid) {
            this.buildings_uuid = buildings_uuid;
        }

    public int getBuildingsLevel() {
            return buildings_level;
        }

    public void setBuildingsLevel(int buildings_level) {
            this.buildings_level = buildings_level;
        }

    public int getFieldID() {
            return fieldID;
        }

    public void setFieldID(int fieldID) {
            this.fieldID = fieldID;
        }

    public String getResourcesType() {
            return resourcesType;
        }

    public void setResourcesType(String resourcesType) {
            this.resourcesType = resourcesType;
        }

    public int getResources(){return resources;}

    public void setResources(int resources){this.resources = resources;}
}
