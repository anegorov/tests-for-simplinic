package mapexporter.campus;

import com.google.gson.Gson;
import mapexporter.campus.dto.BuildingDTO;
import mapexporter.campus.dto.CampusDTO;
import mapexporter.campus.dto.CampusImportDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static mapexporter.campus.util.HttpUtil.post;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class campusImportTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "id#1", "org#1", "anyName", "anyCode", Arrays.asList(new BuildingDTO(),new BuildingDTO()) , "Object created in DB"},
                { "id#2", null, null, null, null , "Object created in DB"},
                { "", "org#1", "anyName", "anyCode", Arrays.asList(new BuildingDTO()) , "Object created in DB"},
                { "maxValue", "maxValue", "maxValue", "maxValue", Arrays.asList(new BuildingDTO()) , "Object created in DB"},
                { "id#1", "org#2", "secondName", "secondCode", Arrays.asList(new BuildingDTO(),new BuildingDTO(),new BuildingDTO()) , "Object updated in DB"},
                { "id#1", "", "", "", Arrays.asList(new BuildingDTO()) , "Object updated in DB"},
                { "id#3", "org#31", "anyName", "anyCode3", Arrays.asList(new BuildingDTO()) , "Object deleted from DB"},
        });
    }

    private String id;
    private String organizationCode;
    private String name;
    private String code;
    private List<BuildingDTO> building;
    private String expectedReport;

    public campusImportTest(String id, String organizationCode, String name, String code, List<BuildingDTO> building, String expectedReport){
        this.id = id;
        this.organizationCode = organizationCode;
        this.name = name;
        this.code = code;
        this.building = building;
        this.expectedReport = expectedReport;
    }

    @Test
    public void campusInput() {
        System.out.println("TEST:" + id + "," + organizationCode+ "," +name+ "," +code+","+building);

        CampusDTO campus = new CampusDTO();
        campus.setId(id);
        campus.setOrganizationCode(organizationCode);
        campus.setName(name);
        campus.setCode(code);
        campus.setBuildings(building);

        Gson gson = new Gson();

        CampusImportDTO campusImport = post("https://url-import",gson.toJson(campus)).as(CampusImportDTO.class);

        assertThat(campusImport.getRequestId(), notNullValue());
        assertEquals("Wrong report in the request", expectedReport, campusImport.getReport());

        //Here it's necessary to include method isCampuseSavedInDB(campus).
        //The method should return true or false depending if campus is saved successfully or not.
        //OR
        //Here we can execute request to another service (that I believe exist) to get the campus by id.
        //It would be better approach.

    }

}
