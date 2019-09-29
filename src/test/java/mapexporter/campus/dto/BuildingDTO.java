
package mapexporter.campus.dto;

import java.util.List;
public class BuildingDTO {

    private List<FloorDTO> floorDTOS;
    private String id;
    private String name;

    public List<FloorDTO> getFloorDTOS() {
        return floorDTOS;
    }

    public void setFloorDTOS(List<FloorDTO> floorDTOS) {
        this.floorDTOS = floorDTOS;
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

}
