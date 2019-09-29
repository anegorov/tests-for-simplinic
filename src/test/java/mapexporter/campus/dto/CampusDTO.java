
package mapexporter.campus.dto;

import mapexporter.campus.dto.BuildingDTO;

import java.util.List;

public class CampusDTO {

    private String code;
    private String id;
    private String name;
    private String organizationCode;
    private List<BuildingDTO> buildings;

    public List<BuildingDTO> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingDTO> buildings) {
        this.buildings = buildings;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CampusDTO oo = (CampusDTO) o;
        return id.equals(oo.id) &&
                code.equals(oo.code) &&
                name.equals(oo.name) &&
                organizationCode.equals(oo.organizationCode) &&
                buildings.equals(oo.buildings);
    }
}
