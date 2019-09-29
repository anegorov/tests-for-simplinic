package mapexporter.campus;

import com.google.gson.Gson;
import mapexporter.campus.dto.BuildingDTO;
import mapexporter.campus.dto.CampusDTO;
import mapexporter.campus.dto.CampusExportDTO;
import mapexporter.campus.dto.CampusImportDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static mapexporter.campus.util.HttpUtil.post;
import static org.junit.Assert.assertEquals;

public class campusExportTest {

    private String id = "id#1";
    private String organizationCode = "";
    private String name = "name#1";
    private String code = "code#1";
    private List<BuildingDTO> building = Arrays.asList(new BuildingDTO());
    private CampusDTO campus;

    @Before()
    public void prepareData(){
        campus = new CampusDTO();
        campus.setId(id);
        campus.setOrganizationCode(organizationCode);
        campus.setName(name);
        campus.setCode(code);
        campus.setBuildings(building);

        Gson gson = new Gson();

        post("https://url-import",gson.toJson(campus)).as(CampusImportDTO.class);
    }

    @Test
    public void exportTest(){
        CampusExportDTO campusExport = post("https://url-export",id).as(CampusExportDTO.class);

        assertEquals("Wrong campus in response", campus, campusExport.getCampus());

    }
}
