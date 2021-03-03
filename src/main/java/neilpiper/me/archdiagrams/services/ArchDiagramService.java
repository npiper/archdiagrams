package neilpiper.me.archdiagrams.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neilpiper.me.archdiagrams.components.ArchViewsComponent;
import net.sourceforge.plantuml.SourceStringReader;

/**
 * REST Entry point for Architecture diagrams
 * 
 * PlantUML Ref at http://plantuml.com/api
 * 
 * @author neilpiper
 *
 */
@RestController
public class ArchDiagramService {

  @Autowired
  ArchViewsComponent views;


  @RequestMapping("/archdiagrams")
  public List<String> getDiagramList() {
    List<String> names = new ArrayList<String>();
    names.add("FakeName");

    views.views.getComponentViews().stream().filter(Objects::nonNull)
        .forEach(d -> names.add("COMPONENT:" + d.getName()));
    views.views.getDeploymentViews().stream().filter(Objects::nonNull)
        .forEach(d -> names.add("DEPLOYMENT:" + d.getName()));
    views.views.getContainerViews().stream().filter(Objects::nonNull)
        .forEach(d -> names.add("CONTAINERS:" + d.getName()));


    return names;
  }

  @RequestMapping(value = "/archdiagrams/{ID}", method = RequestMethod.GET, produces = "image/png")
  public void getImageAsByteArray(HttpServletResponse response, String ID) throws IOException {

    response.setContentType(MediaType.IMAGE_PNG.getType());


    String source = views.getDiagramByID("1");



    SourceStringReader reader = new SourceStringReader(source);

    reader.generateImage(response.getOutputStream());

  }


  @RequestMapping(value = "/archdiagrams/{ID}/plantUML", method = RequestMethod.GET,
      produces = "application/text")
  public void getPlantUMLRepresentation(HttpServletResponse response, String ID)
      throws IOException {

    response.setContentType(MediaType.TEXT_PLAIN_VALUE);


    //
    // String source = "@startuml\n";
    // source += "Bob -> Alice : hello\n";
    // source += "@enduml\n";
    String source = views.getDiagramByID("1");



    // SourceStringReader reader = new SourceStringReader(source);
    // reader.generateDiagramDescription(response.getOutputStream());


    response.getOutputStream().print(source);


  }

}
